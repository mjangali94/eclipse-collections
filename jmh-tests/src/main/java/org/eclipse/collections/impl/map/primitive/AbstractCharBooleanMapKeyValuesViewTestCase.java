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
import org.eclipse.collections.api.map.primitive.CharBooleanMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.CharBooleanPair;
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
 * Abstract JUnit test for {@link CharBooleanMap#keyValuesView()}.
 * This file was automatically generated from template file abstractPrimitiveBooleanMapKeyValuesViewTest.stg.
 */
public abstract class AbstractCharBooleanMapKeyValuesViewTestCase {

    public abstract CharBooleanMap newWithKeysValues(char key1, boolean value1, char key2, boolean value2, char key3, boolean value3);

    public abstract CharBooleanMap newWithKeysValues(char key1, boolean value1, char key2, boolean value2);

    public abstract CharBooleanMap newWithKeysValues(char key1, boolean value1);

    public abstract CharBooleanMap newEmpty();

    public RichIterable<CharBooleanPair> newWith() {
        return this.newEmpty().keyValuesView();
    }

    public RichIterable<CharBooleanPair> newWith(char key1, boolean value1) {
        return this.newWithKeysValues(key1, value1).keyValuesView();
    }

    public RichIterable<CharBooleanPair> newWith(char key1, boolean value1, char key2, boolean value2) {
        return this.newWithKeysValues(key1, value1, key2, value2).keyValuesView();
    }

    public RichIterable<CharBooleanPair> newWith(char key1, boolean value1, char key2, boolean value2, char key3, boolean value3) {
        return this.newWithKeysValues(key1, value1, key2, value2, key3, value3).keyValuesView();
    }

    @Test
    public void containsAllIterable() {
        RichIterable<CharBooleanPair> collection = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        Assert.assertTrue(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair((char) 1, false), PrimitiveTuples.pair((char) 2, true))));
        Assert.assertFalse(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair((char) 1, false), PrimitiveTuples.pair((char) 1, true))));
    }

    @Test
    public void containsAllArray() {
        RichIterable<CharBooleanPair> collection = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        Assert.assertTrue(collection.containsAllArguments(PrimitiveTuples.pair((char) 1, false), PrimitiveTuples.pair((char) 2, true)));
        Assert.assertFalse(collection.containsAllArguments(PrimitiveTuples.pair((char) 1, false), PrimitiveTuples.pair(1, 5L)));
    }

    @Test
    public void forEach() {
        MutableList<CharBooleanPair> result = Lists.mutable.of();
        RichIterable<CharBooleanPair> collection = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        collection.forEach(Procedures.cast(result::add));
        Verify.assertSize(3, result);
        Verify.assertContainsAll(result, PrimitiveTuples.pair((char) 1, false), PrimitiveTuples.pair((char) 2, true), PrimitiveTuples.pair((char) 3, false));
        MutableList<CharBooleanPair> result2 = Lists.mutable.of();
        RichIterable<CharBooleanPair> collection2 = this.newWith((char) 0, false, (char) 2, true, (char) 3, false);
        collection2.forEach(Procedures.cast(result2::add));
        Verify.assertSize(3, result2);
        Verify.assertContainsAll(result2, PrimitiveTuples.pair((char) 0, false), PrimitiveTuples.pair((char) 2, true), PrimitiveTuples.pair((char) 3, false));
    }

    @Test
    public void forEachWith() {
        MutableBag<CharBooleanPair> result = Bags.mutable.of();
        MutableBag<Integer> result2 = Bags.mutable.of();
        RichIterable<CharBooleanPair> collection = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        collection.forEachWith((CharBooleanPair argument1, Integer argument2) -> {
            result.add(argument1);
            result2.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((char) 1, false), PrimitiveTuples.pair((char) 2, true), PrimitiveTuples.pair((char) 3, false)), result);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result2);
    }

    @Test
    public void forEachWithIndex() {
        MutableBag<CharBooleanPair> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<CharBooleanPair> collection = this.newWith((char) 1, false, (char) 0, true, (char) 3, false);
        collection.forEachWithIndex((CharBooleanPair object, int index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair((char) 1, false), PrimitiveTuples.pair((char) 0, true), PrimitiveTuples.pair((char) 3, false)), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes);
    }

    @Test
    public void select() {
        MutableList<CharBooleanPair> result = this.newWith((char) 1, false, (char) 2, true, (char) 3, false).select(PrimitiveTuples.pair((char) 2, true)::equals).toList();
        Verify.assertContains(PrimitiveTuples.pair((char) 2, true), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 1, false), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 3, false), result);
    }

    @Test
    public void selectWith() {
        MutableList<CharBooleanPair> result = this.newWith((char) 1, false, (char) 2, true, (char) 3, false).selectWith(Object::equals, PrimitiveTuples.pair((char) 2, true)).toList();
        Verify.assertContains(PrimitiveTuples.pair((char) 2, true), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 1, false), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 3, false), result);
    }

    @Test
    public void selectWith_target() {
        HashBag<CharBooleanPair> result = this.newWith((char) 1, false, (char) 2, true, (char) 3, false).selectWith(Predicates2.notEqual(), PrimitiveTuples.pair((char) 2, true), HashBag.<CharBooleanPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((char) 1, false), PrimitiveTuples.pair((char) 3, false)), result);
    }

    @Test
    public void reject() {
        MutableList<CharBooleanPair> result = this.newWith((char) 1, false, (char) 2, true, (char) 3, false).reject(Predicates.notEqual(PrimitiveTuples.pair((char) 2, true))).toList();
        Verify.assertContains(PrimitiveTuples.pair((char) 2, true), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 1, false), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 3, false), result);
    }

    @Test
    public void rejectWith() {
        MutableList<CharBooleanPair> result = this.newWith((char) 1, false, (char) 2, true, (char) 3, false).rejectWith(Predicates2.notEqual(), PrimitiveTuples.pair((char) 2, true)).toList();
        Verify.assertContains(PrimitiveTuples.pair((char) 2, true), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 1, false), result);
        Verify.assertNotContains(PrimitiveTuples.pair((char) 3, false), result);
    }

    @Test
    public void rejectWith_target() {
        HashBag<CharBooleanPair> result = this.newWith((char) 1, false, (char) 2, true, (char) 3, false).rejectWith(Object::equals, PrimitiveTuples.pair((char) 2, true), HashBag.<CharBooleanPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((char) 1, false), PrimitiveTuples.pair((char) 3, false)), result);
    }

    @Test
    public void selectInstancesOf() {
        RichIterable<CharBooleanPair> pairs = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        Verify.assertIterableEmpty(pairs.selectInstancesOf(Integer.class));
        Verify.assertContainsAll(pairs.selectInstancesOf(CharBooleanPair.class), PrimitiveTuples.pair((char) 1, false), PrimitiveTuples.pair((char) 3, false), PrimitiveTuples.pair((char) 2, true));
    }

    @Test
    public void collect() {
        RichIterable<Integer> result1 = this.newWith((char) 1, false, (char) 2, true, (char) 3, false).collect((CharBooleanPair object) -> (int) object.getOne());
        Assert.assertEquals(Bags.immutable.of(1, 2, 3), result1.toBag());
        RichIterable<Boolean> result2 = this.newWith((char) 1, false, (char) 2, true, (char) 3, false).collect(CharBooleanPair::getTwo);
        Assert.assertEquals(Bags.immutable.of(false, true, false), result2.toBag());
    }

    @Test
    public void collectBoolean() {
        BooleanIterable result = this.newWith((char) 1, false, (char) 2, true, (char) 3, false).collectBoolean((CharBooleanPair each) -> (each.getOne() % 2) == 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), result.toBag());
    }

    @Test
    public void collectByte() {
        ByteIterable result = this.newWith((char) 1, false, (char) 2, true, (char) 3, false).collectByte((CharBooleanPair anObject) -> (byte) anObject.getOne());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), result.toBag());
    }

    @Test
    public void collectChar() {
        CharIterable result = this.newWith((char) 1, false, (char) 2, true, (char) 3, false).collectChar((CharBooleanPair anObject) -> (char) anObject.getOne());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), result.toBag());
    }

    @Test
    public void collectDouble() {
        DoubleIterable result = this.newWith((char) 1, false, (char) 2, true, (char) 3, false).collectDouble((CharBooleanPair anObject) -> (double) anObject.getOne());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), result.toBag());
    }

    @Test
    public void collectFloat() {
        FloatIterable result = this.newWith((char) 1, false, (char) 2, true, (char) 3, false).collectFloat((CharBooleanPair anObject) -> (float) anObject.getOne());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), result.toBag());
    }

    @Test
    public void collectInt() {
        IntIterable result = this.newWith((char) 1, false, (char) 2, true, (char) 3, false).collectInt((CharBooleanPair anObject) -> (int) anObject.getOne());
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), result.toBag());
    }

    @Test
    public void collectLong() {
        LongIterable result = this.newWith((char) 1, false, (char) 2, true, (char) 3, false).collectLong((CharBooleanPair anObject) -> (long) anObject.getOne());
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort() {
        ShortIterable result = this.newWith((char) 1, false, (char) 2, true, (char) 3, false).collectShort((CharBooleanPair anObject) -> (short) anObject.getOne());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), result.toBag());
    }

    @Test
    public void flatCollect() {
        RichIterable<CharBooleanPair> collection = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        Function<CharBooleanPair, MutableList<String>> function = (CharBooleanPair object) -> FastList.newListWith(String.valueOf(object));
        Verify.assertListsEqual(FastList.newListWith("\u0001:false", "\u0002:true", "\u0003:false"), collection.flatCollect(function).toSortedList());
        Verify.assertSetsEqual(UnifiedSet.newSetWith("\u0001:false", "\u0002:true", "\u0003:false"), collection.flatCollect(function, UnifiedSet.<String>newSet()));
    }

    @Test
    public void detect() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 2, true), this.newWith((char) 1, false, (char) 2, true, (char) 3, false).detect(PrimitiveTuples.pair((char) 2, true)::equals));
        Assert.assertNull(this.newWith((char) 1, false, (char) 2, true, (char) 3, false).detect(PrimitiveTuples.pair(2, 4L)::equals));
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
        Assert.assertEquals(PrimitiveTuples.pair((char) 1, false), this.newWith((char) 1, false, (char) 2, true, (char) 3, false).min(Comparators.naturalOrder()));
    }

    @Test
    public void max() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 3, false), this.newWith((char) 1, false, (char) 2, true, (char) 3, false).max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 1, false), this.newWith((char) 1, false, (char) 2, true, (char) 3, false).min(Comparators.naturalOrder()));
    }

    @Test
    public void max_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 3, false), this.newWith((char) 1, false, (char) 2, true, (char) 3, false).max(Comparators.naturalOrder()));
    }

    @Test
    public void minBy() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 2, true), this.newWith((char) 1, false, (char) 2, true, (char) 3, false).minBy((CharBooleanPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void maxBy() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 1, false), this.newWith((char) 1, false, (char) 2, true, (char) 4, false).maxBy((CharBooleanPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void detectWith() {
        Assert.assertEquals(PrimitiveTuples.pair((char) 2, true), this.newWith((char) 1, false, (char) 2, true, (char) 3, false).detectWith(Object::equals, PrimitiveTuples.pair((char) 2, true)));
        Assert.assertNull(this.newWith((char) 1, false, (char) 2, true, (char) 3, false).detectWith(Object::equals, PrimitiveTuples.pair((char) 2, false)));
    }

    @Test
    public void detectIfNone() {
        Function0<CharBooleanPair> function = Functions0.value(PrimitiveTuples.pair((char) 5, true));
        Assert.assertEquals(PrimitiveTuples.pair((char) 2, true), this.newWith((char) 1, false, (char) 2, true, (char) 3, false).detectIfNone(PrimitiveTuples.pair((char) 2, true)::equals, function));
        Assert.assertEquals(PrimitiveTuples.pair((char) 5, true), this.newWith((char) 1, false, (char) 2, true, (char) 3, false).detectIfNone(PrimitiveTuples.pair((char) 2, false)::equals, function));
    }

    @Test
    public void detectWithIfNoneBlock() {
        Function0<CharBooleanPair> function = Functions0.value(PrimitiveTuples.pair((char) 5, true));
        Assert.assertEquals(PrimitiveTuples.pair((char) 2, true), this.newWith((char) 1, false, (char) 2, true, (char) 3, false).detectWithIfNone(Object::equals, PrimitiveTuples.pair((char) 2, true), function));
        Assert.assertEquals(PrimitiveTuples.pair((char) 5, true), this.newWith((char) 1, false, (char) 2, true, (char) 3, false).detectWithIfNone(Object::equals, PrimitiveTuples.pair((char) 2, false), function));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.newWith((char) 1, false, (char) 2, true, (char) 3, false).allSatisfy(CharBooleanPair.class::isInstance));
        Assert.assertFalse(this.newWith((char) 1, false, (char) 2, true, (char) 3, false).allSatisfy(PrimitiveTuples.pair((char) 2, true)::equals));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertTrue(this.newWith((char) 1, false, (char) 2, true, (char) 3, false).allSatisfyWith(Predicates2.instanceOf(), CharBooleanPair.class));
        Assert.assertFalse(this.newWith((char) 1, false, (char) 2, true, (char) 3, false).allSatisfyWith(Object::equals, PrimitiveTuples.pair((char) 2, true)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.newWith((char) 1, false, (char) 2, true, (char) 3, false).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith((char) 1, false, (char) 2, true, (char) 3, false).noneSatisfy(PrimitiveTuples.pair((char) 2, true)::equals));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertTrue(this.newWith((char) 1, false, (char) 2, true, (char) 3, false).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith((char) 1, false, (char) 2, true, (char) 3, false).noneSatisfyWith(Object::equals, PrimitiveTuples.pair((char) 2, true)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newWith((char) 1, false, (char) 2, true, (char) 3, false).anySatisfy(PrimitiveTuples.pair((char) 2, true)::equals));
        Assert.assertFalse(this.newWith((char) 1, false, (char) 2, true, (char) 3, false).anySatisfy(PrimitiveTuples.pair(2, 5L)::equals));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertTrue(this.newWith((char) 1, false, (char) 2, true, (char) 3, false).anySatisfyWith(Object::equals, PrimitiveTuples.pair((char) 2, true)));
        Assert.assertFalse(this.newWith((char) 1, false, (char) 2, true, (char) 3, false).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2, 5L)));
    }

    @Test
    public void count() {
        Assert.assertEquals(0, this.newWith((char) 1, false, (char) 2, true, (char) 3, false).count(Boolean.class::isInstance));
        Assert.assertEquals(3, this.newWith((char) 1, false, (char) 2, true, (char) 3, false).count(CharBooleanPair.class::isInstance));
        Assert.assertEquals(1, this.newWith((char) 1, false, (char) 2, true, (char) 3, false).count(PrimitiveTuples.pair((char) 2, true)::equals));
    }

    @Test
    public void countWith() {
        Assert.assertEquals(0, this.newWith((char) 1, false, (char) 2, true, (char) 3, false).countWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertEquals(3, this.newWith((char) 1, false, (char) 2, true, (char) 3, false).countWith(Predicates2.instanceOf(), CharBooleanPair.class));
        Assert.assertEquals(1, this.newWith((char) 1, false, (char) 2, true, (char) 3, false).countWith(Object::equals, PrimitiveTuples.pair((char) 2, true)));
    }

    @Test
    public void collectIf() {
        Verify.assertContainsAll(this.newWith((char) 1, false, (char) 2, true, (char) 3, false).collectIf(CharBooleanPair.class::isInstance, String::valueOf), "\u0001:false", "\u0002:true", "\u0003:false");
        Verify.assertContainsAll(this.newWith((char) 1, false, (char) 2, true, (char) 3, false).collectIf(CharBooleanPair.class::isInstance, String::valueOf, UnifiedSet.<String>newSet()), "\u0001:false", "\u0002:true", "\u0003:false");
    }

    @Test
    public void collectWith() {
        Assert.assertEquals(Bags.mutable.of("\u0003:false-", "\u0002:true-", "\u0001:false-"), this.newWith((char) 1, false, (char) 2, true, (char) 3, false).collectWith((CharBooleanPair argument1, String argument2) -> argument1 + argument2, "-").toBag());
    }

    @Test
    public void collectWith_target() {
        Assert.assertEquals(Bags.mutable.of("\u0001:false-", "\u0002:true-", "\u0003:false-"), this.newWith((char) 1, false, (char) 2, true, (char) 3, false).collectWith((CharBooleanPair argument1, String argument2) -> argument1 + argument2, "-", HashBag.<String>newBag()));
    }

    @Test
    public void getFirst() {
        CharBooleanPair first = this.newWith((char) 1, false, (char) 2, true, (char) 3, false).getFirst();
        Assert.assertTrue(PrimitiveTuples.pair((char) 1, false).equals(first) || PrimitiveTuples.pair((char) 2, true).equals(first) || PrimitiveTuples.pair((char) 3, false).equals(first));
        Assert.assertEquals(PrimitiveTuples.pair((char) 1, false), this.newWith((char) 1, false).getFirst());
    }

    @Test
    public void getLast() {
        CharBooleanPair last = this.newWith((char) 1, false, (char) 2, true, (char) 3, false).getLast();
        Assert.assertTrue(PrimitiveTuples.pair((char) 1, false).equals(last) || PrimitiveTuples.pair((char) 2, true).equals(last) || PrimitiveTuples.pair((char) 3, false).equals(last));
        Assert.assertEquals(PrimitiveTuples.pair((char) 1, false), this.newWith((char) 1, false).getLast());
    }

    @Test
    public void isEmpty() {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith((char) 1, false));
        Assert.assertTrue(this.newWith((char) 1, false).notEmpty());
    }

    @Test
    public void iterator() {
        RichIterable<CharBooleanPair> objects = this.newWith((char) 1, false, (char) 0, true, (char) 3, false);
        MutableBag<CharBooleanPair> actual = Bags.mutable.of();
        Iterator<CharBooleanPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_next_throws() {
        RichIterable<CharBooleanPair> objects = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        Iterator<CharBooleanPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            iterator.next();
        }
        Assert.assertFalse(iterator.hasNext());
        iterator.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iterator_remove_throws() {
        RichIterable<CharBooleanPair> objects = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        Iterator<CharBooleanPair> iterator = objects.iterator();
        iterator.remove();
    }

    @Test
    public void injectInto() {
        RichIterable<CharBooleanPair> objects = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        Long result = objects.injectInto(1L, (Long argument1, CharBooleanPair argument2) -> (long) (argument1 + argument2.getOne() + (argument2.getTwo() ? 0 : 1)));
        Assert.assertEquals(Long.valueOf(9), result);
    }

    @Test
    public void injectIntoInt() {
        RichIterable<CharBooleanPair> objects = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        int result = objects.injectInto(1, (int intParameter, CharBooleanPair argument2) -> (int) (intParameter + argument2.getOne() + (argument2.getTwo() ? 0 : 1)));
        Assert.assertEquals(9, result);
    }

    @Test
    public void injectIntoLong() {
        RichIterable<CharBooleanPair> objects = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        long result = objects.injectInto(1L, (long parameter, CharBooleanPair argument2) -> (long) (parameter + argument2.getOne() + (argument2.getTwo() ? 0 : 1)));
        Assert.assertEquals(9, result);
    }

    @Test
    public void injectIntoDouble() {
        RichIterable<CharBooleanPair> objects = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        double result = objects.injectInto(1.0, (double parameter, CharBooleanPair argument2) -> (double) (parameter + argument2.getOne() + (argument2.getTwo() ? 0 : 1)));
        Assert.assertEquals(9.0, result, 0.0);
    }

    @Test
    public void injectIntoFloat() {
        RichIterable<CharBooleanPair> objects = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        float result = objects.injectInto(1.0f, (float parameter, CharBooleanPair argument2) -> (float) (parameter + argument2.getOne() + (argument2.getTwo() ? 0 : 1)));
        Assert.assertEquals(9.0, result, 0.0);
    }

    @Test
    public void sumFloat() {
        RichIterable<CharBooleanPair> objects = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        double actual = objects.sumOfFloat((CharBooleanPair each) -> (float) (each.getOne() + (each.getTwo() ? 0 : 1)));
        Assert.assertEquals(8.0, actual, 0.0);
    }

    @Test
    public void sumDouble() {
        RichIterable<CharBooleanPair> objects = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        double actual = objects.sumOfDouble((CharBooleanPair each) -> (double) (each.getOne() + (each.getTwo() ? 0 : 1)));
        Assert.assertEquals(8.0, actual, 0.0);
    }

    @Test
    public void sumInteger() {
        RichIterable<CharBooleanPair> objects = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        long actual = objects.sumOfInt((CharBooleanPair each) -> (int) (each.getOne() + (each.getTwo() ? 0 : 1)));
        Assert.assertEquals(8, actual);
    }

    @Test
    public void sumLong() {
        RichIterable<CharBooleanPair> objects = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        long actual = objects.sumOfLong((CharBooleanPair each) -> (long) (each.getOne() + (each.getTwo() ? 0 : 1)));
        Assert.assertEquals(8, actual);
    }

    @Test
    public void toArray() {
        RichIterable<CharBooleanPair> objects = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        CharBooleanPair[] array2 = objects.toArray(new CharBooleanPair[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition() {
        PartitionIterable<CharBooleanPair> result = this.newWith((char) 1, false, (char) 2, true, (char) 3, false).partition(PrimitiveTuples.pair((char) 2, true)::equals);
        Verify.assertContains(PrimitiveTuples.pair((char) 2, true), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair((char) 1, false), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair((char) 3, false), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void partitionWith() {
        PartitionIterable<CharBooleanPair> result = this.newWith((char) 1, false, (char) 2, true, (char) 3, false).partitionWith(Object::equals, PrimitiveTuples.pair((char) 2, true));
        Verify.assertContains(PrimitiveTuples.pair((char) 2, true), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair((char) 1, false), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair((char) 3, false), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void toList() {
        MutableList<CharBooleanPair> list = this.newWith((char) 1, false, (char) 2, true, (char) 3, false).toList();
        Verify.assertContainsAll(list, PrimitiveTuples.pair((char) 1, false), PrimitiveTuples.pair((char) 2, true), PrimitiveTuples.pair((char) 3, false));
    }

    @Test
    public void toBag() {
        MutableBag<CharBooleanPair> bag = this.newWith((char) 1, false, (char) 2, true, (char) 3, false).toBag();
        Verify.assertContainsAll(bag, PrimitiveTuples.pair((char) 1, false), PrimitiveTuples.pair((char) 2, true), PrimitiveTuples.pair((char) 3, false));
    }

    @Test
    public void toSortedList_natural_ordering() {
        RichIterable<CharBooleanPair> pairs = this.newWith((char) 2, true, (char) 1, false, (char) 3, false);
        MutableList<CharBooleanPair> list = pairs.toSortedList();
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((char) 1, false), PrimitiveTuples.pair((char) 2, true), PrimitiveTuples.pair((char) 3, false)), list);
    }

    @Test
    public void toSortedList_with_comparator() {
        RichIterable<CharBooleanPair> pairs = this.newWith((char) 2, true, (char) 1, false, (char) 3, false);
        MutableList<CharBooleanPair> list = pairs.toSortedList(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((char) 3, false), PrimitiveTuples.pair((char) 2, true), PrimitiveTuples.pair((char) 1, false)), list);
    }

    @Test
    public void toSortedListBy() {
        RichIterable<CharBooleanPair> pairs = this.newWith((char) 2, true, (char) 1, false, (char) 3, false);
        MutableList<CharBooleanPair> list = pairs.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((char) 1, false), PrimitiveTuples.pair((char) 2, true), PrimitiveTuples.pair((char) 3, false)), list);
    }

    @Test
    public void toSortedBag_natural_ordering() {
        RichIterable<CharBooleanPair> pairs = this.newWith((char) 2, true, (char) 1, false, (char) 3, false);
        MutableSortedBag<CharBooleanPair> bag = pairs.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair((char) 1, false), PrimitiveTuples.pair((char) 2, true), PrimitiveTuples.pair((char) 3, false)), bag);
    }

    @Test
    public void toSortedBag_with_comparator() {
        RichIterable<CharBooleanPair> pairs = this.newWith((char) 2, true, (char) 1, false, (char) 3, false);
        MutableSortedBag<CharBooleanPair> bag = pairs.toSortedBag(Comparators.reverseNaturalOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair((char) 3, false), PrimitiveTuples.pair((char) 2, true), PrimitiveTuples.pair((char) 1, false)), bag);
    }

    @Test
    public void toSortedBagBy() {
        RichIterable<CharBooleanPair> pairs = this.newWith((char) 2, true, (char) 1, false, (char) 3, false);
        MutableSortedBag<CharBooleanPair> bag = pairs.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair((char) 1, false), PrimitiveTuples.pair((char) 2, true), PrimitiveTuples.pair((char) 3, false)), bag);
    }

    @Test
    public void toSortedSet_natural_ordering() {
        RichIterable<CharBooleanPair> pairs = this.newWith((char) 2, true, (char) 1, false, (char) 3, false);
        MutableSortedSet<CharBooleanPair> set = pairs.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair((char) 1, false), PrimitiveTuples.pair((char) 2, true), PrimitiveTuples.pair((char) 3, false)), set);
    }

    @Test
    public void toSortedSet_with_comparator() {
        RichIterable<CharBooleanPair> pairs = this.newWith((char) 2, true, (char) 1, false, (char) 3, false);
        MutableSortedSet<CharBooleanPair> set = pairs.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair((char) 3, false), PrimitiveTuples.pair((char) 2, true), PrimitiveTuples.pair((char) 1, false)), set);
    }

    @Test
    public void toSortedSetBy() {
        RichIterable<CharBooleanPair> pairs = this.newWith((char) 2, true, (char) 1, false, (char) 3, false);
        MutableSortedSet<CharBooleanPair> set = pairs.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair((char) 1, false), PrimitiveTuples.pair((char) 2, true), PrimitiveTuples.pair((char) 3, false)), set);
    }

    @Test
    public void toSet() {
        RichIterable<CharBooleanPair> pairs = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        MutableSet<CharBooleanPair> set = pairs.toSet();
        Verify.assertContainsAll(set, PrimitiveTuples.pair((char) 1, false), PrimitiveTuples.pair((char) 2, true), PrimitiveTuples.pair((char) 3, false));
    }

    @Test
    public void toMap() {
        RichIterable<CharBooleanPair> pairs = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        MutableMap<String, String> map = pairs.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("\u0001:false", "\u0001:false", "\u0002:true", "\u0002:true", "\u0003:false", "\u0003:false"), map);
    }

    @Test
    public void toSortedMap() {
        RichIterable<CharBooleanPair> pairs = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        MutableSortedMap<String, String> map = pairs.toSortedMap(String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith("\u0001:false", "\u0001:false", "\u0002:true", "\u0002:true", "\u0003:false", "\u0003:false"), map);
    }

    @Test
    public void toSortedMap_with_comparator() {
        RichIterable<CharBooleanPair> pairs = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        MutableSortedMap<String, String> map = pairs.toSortedMap(Comparators.reverseNaturalOrder(), String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), "\u0001:false", "\u0001:false", "\u0002:true", "\u0002:true", "\u0003:false", "\u0003:false"), map);
    }

    @Test
    public void toSortedMapBy() {
        RichIterable<CharBooleanPair> pairs = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        MutableSortedMap<String, String> map = pairs.toSortedMapBy(String::valueOf, String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.naturalOrder(), "\u0001:false", "\u0001:false", "\u0002:true", "\u0002:true", "\u0003:false", "\u0003:false"), map);
    }

    @Test
    public void toBiMap() {
        RichIterable<CharBooleanPair> pairs = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        MutableBiMap<String, String> biMap = pairs.toBiMap(String::valueOf, String::valueOf);
        Assert.assertEquals(HashBiMap.newWithKeysValues("\u0001:false", "\u0001:false", "\u0002:true", "\u0002:true", "\u0003:false", "\u0003:false"), biMap);
    }

    @Test
    public void testToString() {
        RichIterable<CharBooleanPair> collection = this.newWith((char) 1, false, (char) 2, true);
        Assert.assertTrue("[\u0001:false, \u0002:true]".equals(collection.toString()) || "[\u0002:true, \u0001:false]".equals(collection.toString()));
    }

    @Test
    public void makeString() {
        RichIterable<CharBooleanPair> collection = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator() {
        RichIterable<CharBooleanPair> collection = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd() {
        RichIterable<CharBooleanPair> collection = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString() {
        RichIterable<CharBooleanPair> collection = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator() {
        RichIterable<CharBooleanPair> collection = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd() {
        RichIterable<CharBooleanPair> collection = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void groupBy() {
        RichIterable<CharBooleanPair> collection = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        Function<CharBooleanPair, Boolean> function = (CharBooleanPair object) -> PrimitiveTuples.pair((char) 1, false).equals(object);
        Multimap<Boolean, CharBooleanPair> multimap = collection.groupBy(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair((char) 1, false)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((char) 2, true)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((char) 3, false)));
    }

    @Test
    public void groupByEach() {
        RichIterable<CharBooleanPair> collection = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        Function<CharBooleanPair, MutableList<Boolean>> function = (CharBooleanPair object) -> Lists.mutable.of(PrimitiveTuples.pair((char) 1, false).equals(object));
        Multimap<Boolean, CharBooleanPair> multimap = collection.groupByEach(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair((char) 1, false)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((char) 2, true)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((char) 3, false)));
    }

    @Test
    public void zip() {
        RichIterable<CharBooleanPair> collection = this.newWith((char) 1, false, (char) 2, true);
        RichIterable<Pair<CharBooleanPair, Integer>> result = collection.zip(Interval.oneTo(5));
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((char) 1, false), 1), Tuples.pair(PrimitiveTuples.pair((char) 2, true), 2)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((char) 2, true), 1), Tuples.pair(PrimitiveTuples.pair((char) 1, false), 2)).equals(result.toBag()));
    }

    @Test
    public void zipWithIndex() {
        RichIterable<CharBooleanPair> collection = this.newWith((char) 1, false, (char) 2, true);
        RichIterable<Pair<CharBooleanPair, Integer>> result = collection.zipWithIndex();
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((char) 1, false), 0), Tuples.pair(PrimitiveTuples.pair((char) 2, true), 1)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((char) 2, true), 0), Tuples.pair(PrimitiveTuples.pair((char) 1, false), 1)).equals(result.toBag()));
    }

    @Test
    public void chunk() {
        RichIterable<CharBooleanPair> collection = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        Assert.assertEquals(Bags.immutable.of(FastList.newListWith(PrimitiveTuples.pair((char) 1, false)), FastList.newListWith(PrimitiveTuples.pair((char) 2, true)), FastList.newListWith(PrimitiveTuples.pair((char) 3, false))), collection.chunk(1).toBag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        RichIterable<CharBooleanPair> collection = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size() {
        RichIterable<CharBooleanPair> collection = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
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
        RichIterable<CharBooleanPair> notEmpty = this.newWith((char) 1, false);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating() {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, CharBooleanPair> sumAggregator = (AtomicInteger aggregate, CharBooleanPair value) -> aggregate.addAndGet((int) value.getOne());
        RichIterable<CharBooleanPair> collection = this.newWith((char) 1, false, (char) 2, true, (char) 3, false);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("\u0003:false").intValue());
        Assert.assertEquals(2, aggregation.get("\u0002:true").intValue());
        Assert.assertEquals(1, aggregation.get("\u0001:false").intValue());
    }

    @Test
    public void aggregateByNonMutating() {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, CharBooleanPair, Integer> sumAggregator = (Integer aggregate, CharBooleanPair value) -> (int) (aggregate + value.getOne());
        RichIterable<CharBooleanPair> collection = this.newWith((char) 1, false, (char) 1, false, (char) 2, true);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(2, aggregation.get("\u0002:true").intValue());
        Assert.assertEquals(1, aggregation.get("\u0001:false").intValue());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractCharBooleanMapKeyValuesViewTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractCharBooleanMapKeyValuesViewTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> iterator_next_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> iterator_remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapKeyValuesViewTestCase> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = AbstractCharBooleanMapKeyValuesViewTestCase::containsAllIterable;
            this.payloads.containsAllArray = AbstractCharBooleanMapKeyValuesViewTestCase::containsAllArray;
            this.payloads.forEach = AbstractCharBooleanMapKeyValuesViewTestCase::forEach;
            this.payloads.forEachWith = AbstractCharBooleanMapKeyValuesViewTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractCharBooleanMapKeyValuesViewTestCase::forEachWithIndex;
            this.payloads.select = AbstractCharBooleanMapKeyValuesViewTestCase::select;
            this.payloads.selectWith = AbstractCharBooleanMapKeyValuesViewTestCase::selectWith;
            this.payloads.selectWith_target = AbstractCharBooleanMapKeyValuesViewTestCase::selectWith_target;
            this.payloads.reject = AbstractCharBooleanMapKeyValuesViewTestCase::reject;
            this.payloads.rejectWith = AbstractCharBooleanMapKeyValuesViewTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractCharBooleanMapKeyValuesViewTestCase::rejectWith_target;
            this.payloads.selectInstancesOf = AbstractCharBooleanMapKeyValuesViewTestCase::selectInstancesOf;
            this.payloads.collect = AbstractCharBooleanMapKeyValuesViewTestCase::collect;
            this.payloads.collectBoolean = AbstractCharBooleanMapKeyValuesViewTestCase::collectBoolean;
            this.payloads.collectByte = AbstractCharBooleanMapKeyValuesViewTestCase::collectByte;
            this.payloads.collectChar = AbstractCharBooleanMapKeyValuesViewTestCase::collectChar;
            this.payloads.collectDouble = AbstractCharBooleanMapKeyValuesViewTestCase::collectDouble;
            this.payloads.collectFloat = AbstractCharBooleanMapKeyValuesViewTestCase::collectFloat;
            this.payloads.collectInt = AbstractCharBooleanMapKeyValuesViewTestCase::collectInt;
            this.payloads.collectLong = AbstractCharBooleanMapKeyValuesViewTestCase::collectLong;
            this.payloads.collectShort = AbstractCharBooleanMapKeyValuesViewTestCase::collectShort;
            this.payloads.flatCollect = AbstractCharBooleanMapKeyValuesViewTestCase::flatCollect;
            this.payloads.detect = AbstractCharBooleanMapKeyValuesViewTestCase::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharBooleanMapKeyValuesViewTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharBooleanMapKeyValuesViewTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractCharBooleanMapKeyValuesViewTestCase::min;
            this.payloads.max = AbstractCharBooleanMapKeyValuesViewTestCase::max;
            this.payloads.min_without_comparator = AbstractCharBooleanMapKeyValuesViewTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractCharBooleanMapKeyValuesViewTestCase::max_without_comparator;
            this.payloads.minBy = AbstractCharBooleanMapKeyValuesViewTestCase::minBy;
            this.payloads.maxBy = AbstractCharBooleanMapKeyValuesViewTestCase::maxBy;
            this.payloads.detectWith = AbstractCharBooleanMapKeyValuesViewTestCase::detectWith;
            this.payloads.detectIfNone = AbstractCharBooleanMapKeyValuesViewTestCase::detectIfNone;
            this.payloads.detectWithIfNoneBlock = AbstractCharBooleanMapKeyValuesViewTestCase::detectWithIfNoneBlock;
            this.payloads.allSatisfy = AbstractCharBooleanMapKeyValuesViewTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractCharBooleanMapKeyValuesViewTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractCharBooleanMapKeyValuesViewTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractCharBooleanMapKeyValuesViewTestCase::noneSatisfyWith;
            this.payloads.anySatisfy = AbstractCharBooleanMapKeyValuesViewTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractCharBooleanMapKeyValuesViewTestCase::anySatisfyWith;
            this.payloads.count = AbstractCharBooleanMapKeyValuesViewTestCase::count;
            this.payloads.countWith = AbstractCharBooleanMapKeyValuesViewTestCase::countWith;
            this.payloads.collectIf = AbstractCharBooleanMapKeyValuesViewTestCase::collectIf;
            this.payloads.collectWith = AbstractCharBooleanMapKeyValuesViewTestCase::collectWith;
            this.payloads.collectWith_target = AbstractCharBooleanMapKeyValuesViewTestCase::collectWith_target;
            this.payloads.getFirst = AbstractCharBooleanMapKeyValuesViewTestCase::getFirst;
            this.payloads.getLast = AbstractCharBooleanMapKeyValuesViewTestCase::getLast;
            this.payloads.isEmpty = AbstractCharBooleanMapKeyValuesViewTestCase::isEmpty;
            this.payloads.iterator = AbstractCharBooleanMapKeyValuesViewTestCase::iterator;
            this.payloads.iterator_next_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharBooleanMapKeyValuesViewTestCase::iterator_next_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharBooleanMapKeyValuesViewTestCase::iterator_remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.injectInto = AbstractCharBooleanMapKeyValuesViewTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractCharBooleanMapKeyValuesViewTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractCharBooleanMapKeyValuesViewTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractCharBooleanMapKeyValuesViewTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractCharBooleanMapKeyValuesViewTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractCharBooleanMapKeyValuesViewTestCase::sumFloat;
            this.payloads.sumDouble = AbstractCharBooleanMapKeyValuesViewTestCase::sumDouble;
            this.payloads.sumInteger = AbstractCharBooleanMapKeyValuesViewTestCase::sumInteger;
            this.payloads.sumLong = AbstractCharBooleanMapKeyValuesViewTestCase::sumLong;
            this.payloads.toArray = AbstractCharBooleanMapKeyValuesViewTestCase::toArray;
            this.payloads.partition = AbstractCharBooleanMapKeyValuesViewTestCase::partition;
            this.payloads.partitionWith = AbstractCharBooleanMapKeyValuesViewTestCase::partitionWith;
            this.payloads.toList = AbstractCharBooleanMapKeyValuesViewTestCase::toList;
            this.payloads.toBag = AbstractCharBooleanMapKeyValuesViewTestCase::toBag;
            this.payloads.toSortedList_natural_ordering = AbstractCharBooleanMapKeyValuesViewTestCase::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = AbstractCharBooleanMapKeyValuesViewTestCase::toSortedList_with_comparator;
            this.payloads.toSortedListBy = AbstractCharBooleanMapKeyValuesViewTestCase::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = AbstractCharBooleanMapKeyValuesViewTestCase::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = AbstractCharBooleanMapKeyValuesViewTestCase::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = AbstractCharBooleanMapKeyValuesViewTestCase::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = AbstractCharBooleanMapKeyValuesViewTestCase::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = AbstractCharBooleanMapKeyValuesViewTestCase::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractCharBooleanMapKeyValuesViewTestCase::toSortedSetBy;
            this.payloads.toSet = AbstractCharBooleanMapKeyValuesViewTestCase::toSet;
            this.payloads.toMap = AbstractCharBooleanMapKeyValuesViewTestCase::toMap;
            this.payloads.toSortedMap = AbstractCharBooleanMapKeyValuesViewTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractCharBooleanMapKeyValuesViewTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractCharBooleanMapKeyValuesViewTestCase::toSortedMapBy;
            this.payloads.toBiMap = AbstractCharBooleanMapKeyValuesViewTestCase::toBiMap;
            this.payloads.testToString = AbstractCharBooleanMapKeyValuesViewTestCase::testToString;
            this.payloads.makeString = AbstractCharBooleanMapKeyValuesViewTestCase::makeString;
            this.payloads.makeStringWithSeparator = AbstractCharBooleanMapKeyValuesViewTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = AbstractCharBooleanMapKeyValuesViewTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = AbstractCharBooleanMapKeyValuesViewTestCase::appendString;
            this.payloads.appendStringWithSeparator = AbstractCharBooleanMapKeyValuesViewTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = AbstractCharBooleanMapKeyValuesViewTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = AbstractCharBooleanMapKeyValuesViewTestCase::groupBy;
            this.payloads.groupByEach = AbstractCharBooleanMapKeyValuesViewTestCase::groupByEach;
            this.payloads.zip = AbstractCharBooleanMapKeyValuesViewTestCase::zip;
            this.payloads.zipWithIndex = AbstractCharBooleanMapKeyValuesViewTestCase::zipWithIndex;
            this.payloads.chunk = AbstractCharBooleanMapKeyValuesViewTestCase::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharBooleanMapKeyValuesViewTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractCharBooleanMapKeyValuesViewTestCase::chunk_large_size;
            this.payloads.empty = AbstractCharBooleanMapKeyValuesViewTestCase::empty;
            this.payloads.notEmpty = AbstractCharBooleanMapKeyValuesViewTestCase::notEmpty;
            this.payloads.aggregateByMutating = AbstractCharBooleanMapKeyValuesViewTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractCharBooleanMapKeyValuesViewTestCase::aggregateByNonMutating;
        }
    }
}
