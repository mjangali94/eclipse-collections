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
import org.eclipse.collections.api.map.primitive.DoubleBooleanMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.DoubleBooleanPair;
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
 * Abstract JUnit test for {@link DoubleBooleanMap#keyValuesView()}.
 * This file was automatically generated from template file abstractPrimitiveBooleanMapKeyValuesViewTest.stg.
 */
public abstract class AbstractDoubleBooleanMapKeyValuesViewTestCase {

    public abstract DoubleBooleanMap newWithKeysValues(double key1, boolean value1, double key2, boolean value2, double key3, boolean value3);

    public abstract DoubleBooleanMap newWithKeysValues(double key1, boolean value1, double key2, boolean value2);

    public abstract DoubleBooleanMap newWithKeysValues(double key1, boolean value1);

    public abstract DoubleBooleanMap newEmpty();

    public RichIterable<DoubleBooleanPair> newWith() {
        return this.newEmpty().keyValuesView();
    }

    public RichIterable<DoubleBooleanPair> newWith(double key1, boolean value1) {
        return this.newWithKeysValues(key1, value1).keyValuesView();
    }

    public RichIterable<DoubleBooleanPair> newWith(double key1, boolean value1, double key2, boolean value2) {
        return this.newWithKeysValues(key1, value1, key2, value2).keyValuesView();
    }

    public RichIterable<DoubleBooleanPair> newWith(double key1, boolean value1, double key2, boolean value2, double key3, boolean value3) {
        return this.newWithKeysValues(key1, value1, key2, value2, key3, value3).keyValuesView();
    }

    @Test
    public void containsAllIterable() {
        RichIterable<DoubleBooleanPair> collection = this.newWith(1.0, false, 2.0, true, 3.0, false);
        Assert.assertTrue(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(1.0, false), PrimitiveTuples.pair(2.0, true))));
        Assert.assertFalse(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(1.0, false), PrimitiveTuples.pair(1.0, true))));
    }

    @Test
    public void containsAllArray() {
        RichIterable<DoubleBooleanPair> collection = this.newWith(1.0, false, 2.0, true, 3.0, false);
        Assert.assertTrue(collection.containsAllArguments(PrimitiveTuples.pair(1.0, false), PrimitiveTuples.pair(2.0, true)));
        Assert.assertFalse(collection.containsAllArguments(PrimitiveTuples.pair(1.0, false), PrimitiveTuples.pair(1, 5L)));
    }

    @Test
    public void forEach() {
        MutableList<DoubleBooleanPair> result = Lists.mutable.of();
        RichIterable<DoubleBooleanPair> collection = this.newWith(1.0, false, 2.0, true, 3.0, false);
        collection.forEach(Procedures.cast(result::add));
        Verify.assertSize(3, result);
        Verify.assertContainsAll(result, PrimitiveTuples.pair(1.0, false), PrimitiveTuples.pair(2.0, true), PrimitiveTuples.pair(3.0, false));
        MutableList<DoubleBooleanPair> result2 = Lists.mutable.of();
        RichIterable<DoubleBooleanPair> collection2 = this.newWith(0.0, false, 2.0, true, 3.0, false);
        collection2.forEach(Procedures.cast(result2::add));
        Verify.assertSize(3, result2);
        Verify.assertContainsAll(result2, PrimitiveTuples.pair(0.0, false), PrimitiveTuples.pair(2.0, true), PrimitiveTuples.pair(3.0, false));
    }

    @Test
    public void forEachWith() {
        MutableBag<DoubleBooleanPair> result = Bags.mutable.of();
        MutableBag<Integer> result2 = Bags.mutable.of();
        RichIterable<DoubleBooleanPair> collection = this.newWith(1.0, false, 2.0, true, 3.0, false);
        collection.forEachWith((DoubleBooleanPair argument1, Integer argument2) -> {
            result.add(argument1);
            result2.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1.0, false), PrimitiveTuples.pair(2.0, true), PrimitiveTuples.pair(3.0, false)), result);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result2);
    }

    @Test
    public void forEachWithIndex() {
        MutableBag<DoubleBooleanPair> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<DoubleBooleanPair> collection = this.newWith(1.0, false, 0.0, true, 3.0, false);
        collection.forEachWithIndex((DoubleBooleanPair object, int index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair(1.0, false), PrimitiveTuples.pair(0.0, true), PrimitiveTuples.pair(3.0, false)), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes);
    }

    @Test
    public void select() {
        MutableList<DoubleBooleanPair> result = this.newWith(1.0, false, 2.0, true, 3.0, false).select(PrimitiveTuples.pair(2.0, true)::equals).toList();
        Verify.assertContains(PrimitiveTuples.pair(2.0, true), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1.0, false), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3.0, false), result);
    }

    @Test
    public void selectWith() {
        MutableList<DoubleBooleanPair> result = this.newWith(1.0, false, 2.0, true, 3.0, false).selectWith(Object::equals, PrimitiveTuples.pair(2.0, true)).toList();
        Verify.assertContains(PrimitiveTuples.pair(2.0, true), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1.0, false), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3.0, false), result);
    }

    @Test
    public void selectWith_target() {
        HashBag<DoubleBooleanPair> result = this.newWith(1.0, false, 2.0, true, 3.0, false).selectWith(Predicates2.notEqual(), PrimitiveTuples.pair(2.0, true), HashBag.<DoubleBooleanPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1.0, false), PrimitiveTuples.pair(3.0, false)), result);
    }

    @Test
    public void reject() {
        MutableList<DoubleBooleanPair> result = this.newWith(1.0, false, 2.0, true, 3.0, false).reject(Predicates.notEqual(PrimitiveTuples.pair(2.0, true))).toList();
        Verify.assertContains(PrimitiveTuples.pair(2.0, true), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1.0, false), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3.0, false), result);
    }

    @Test
    public void rejectWith() {
        MutableList<DoubleBooleanPair> result = this.newWith(1.0, false, 2.0, true, 3.0, false).rejectWith(Predicates2.notEqual(), PrimitiveTuples.pair(2.0, true)).toList();
        Verify.assertContains(PrimitiveTuples.pair(2.0, true), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1.0, false), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3.0, false), result);
    }

    @Test
    public void rejectWith_target() {
        HashBag<DoubleBooleanPair> result = this.newWith(1.0, false, 2.0, true, 3.0, false).rejectWith(Object::equals, PrimitiveTuples.pair(2.0, true), HashBag.<DoubleBooleanPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1.0, false), PrimitiveTuples.pair(3.0, false)), result);
    }

    @Test
    public void selectInstancesOf() {
        RichIterable<DoubleBooleanPair> pairs = this.newWith(1.0, false, 2.0, true, 3.0, false);
        Verify.assertIterableEmpty(pairs.selectInstancesOf(Integer.class));
        Verify.assertContainsAll(pairs.selectInstancesOf(DoubleBooleanPair.class), PrimitiveTuples.pair(1.0, false), PrimitiveTuples.pair(3.0, false), PrimitiveTuples.pair(2.0, true));
    }

    @Test
    public void collect() {
        RichIterable<Integer> result1 = this.newWith(1.0, false, 2.0, true, 3.0, false).collect((DoubleBooleanPair object) -> (int) object.getOne());
        Assert.assertEquals(Bags.immutable.of(1, 2, 3), result1.toBag());
        RichIterable<Boolean> result2 = this.newWith(1.0, false, 2.0, true, 3.0, false).collect(DoubleBooleanPair::getTwo);
        Assert.assertEquals(Bags.immutable.of(false, true, false), result2.toBag());
    }

    @Test
    public void collectBoolean() {
        BooleanIterable result = this.newWith(1.0, false, 2.0, true, 3.0, false).collectBoolean((DoubleBooleanPair each) -> (each.getOne() % 2) == 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), result.toBag());
    }

    @Test
    public void collectByte() {
        ByteIterable result = this.newWith(1.0, false, 2.0, true, 3.0, false).collectByte((DoubleBooleanPair anObject) -> (byte) anObject.getOne());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), result.toBag());
    }

    @Test
    public void collectChar() {
        CharIterable result = this.newWith(1.0, false, 2.0, true, 3.0, false).collectChar((DoubleBooleanPair anObject) -> (char) anObject.getOne());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), result.toBag());
    }

    @Test
    public void collectDouble() {
        DoubleIterable result = this.newWith(1.0, false, 2.0, true, 3.0, false).collectDouble((DoubleBooleanPair anObject) -> (double) anObject.getOne());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), result.toBag());
    }

    @Test
    public void collectFloat() {
        FloatIterable result = this.newWith(1.0, false, 2.0, true, 3.0, false).collectFloat((DoubleBooleanPair anObject) -> (float) anObject.getOne());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), result.toBag());
    }

    @Test
    public void collectInt() {
        IntIterable result = this.newWith(1.0, false, 2.0, true, 3.0, false).collectInt((DoubleBooleanPair anObject) -> (int) anObject.getOne());
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), result.toBag());
    }

    @Test
    public void collectLong() {
        LongIterable result = this.newWith(1.0, false, 2.0, true, 3.0, false).collectLong((DoubleBooleanPair anObject) -> (long) anObject.getOne());
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort() {
        ShortIterable result = this.newWith(1.0, false, 2.0, true, 3.0, false).collectShort((DoubleBooleanPair anObject) -> (short) anObject.getOne());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), result.toBag());
    }

    @Test
    public void flatCollect() {
        RichIterable<DoubleBooleanPair> collection = this.newWith(1.0, false, 2.0, true, 3.0, false);
        Function<DoubleBooleanPair, MutableList<String>> function = (DoubleBooleanPair object) -> FastList.newListWith(String.valueOf(object));
        Verify.assertListsEqual(FastList.newListWith("1.0:false", "2.0:true", "3.0:false"), collection.flatCollect(function).toSortedList());
        Verify.assertSetsEqual(UnifiedSet.newSetWith("1.0:false", "2.0:true", "3.0:false"), collection.flatCollect(function, UnifiedSet.<String>newSet()));
    }

    @Test
    public void detect() {
        Assert.assertEquals(PrimitiveTuples.pair(2.0, true), this.newWith(1.0, false, 2.0, true, 3.0, false).detect(PrimitiveTuples.pair(2.0, true)::equals));
        Assert.assertNull(this.newWith(1.0, false, 2.0, true, 3.0, false).detect(PrimitiveTuples.pair(2, 4L)::equals));
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
        Assert.assertEquals(PrimitiveTuples.pair(1.0, false), this.newWith(1.0, false, 2.0, true, 3.0, false).min(Comparators.naturalOrder()));
    }

    @Test
    public void max() {
        Assert.assertEquals(PrimitiveTuples.pair(3.0, false), this.newWith(1.0, false, 2.0, true, 3.0, false).max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair(1.0, false), this.newWith(1.0, false, 2.0, true, 3.0, false).min(Comparators.naturalOrder()));
    }

    @Test
    public void max_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair(3.0, false), this.newWith(1.0, false, 2.0, true, 3.0, false).max(Comparators.naturalOrder()));
    }

    @Test
    public void minBy() {
        Assert.assertEquals(PrimitiveTuples.pair(2.0, true), this.newWith(1.0, false, 2.0, true, 3.0, false).minBy((DoubleBooleanPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void maxBy() {
        Assert.assertEquals(PrimitiveTuples.pair(1.0, false), this.newWith(1.0, false, 2.0, true, 4.0, false).maxBy((DoubleBooleanPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void detectWith() {
        Assert.assertEquals(PrimitiveTuples.pair(2.0, true), this.newWith(1.0, false, 2.0, true, 3.0, false).detectWith(Object::equals, PrimitiveTuples.pair(2.0, true)));
        Assert.assertNull(this.newWith(1.0, false, 2.0, true, 3.0, false).detectWith(Object::equals, PrimitiveTuples.pair(2.0, false)));
    }

    @Test
    public void detectIfNone() {
        Function0<DoubleBooleanPair> function = Functions0.value(PrimitiveTuples.pair(5.0, true));
        Assert.assertEquals(PrimitiveTuples.pair(2.0, true), this.newWith(1.0, false, 2.0, true, 3.0, false).detectIfNone(PrimitiveTuples.pair(2.0, true)::equals, function));
        Assert.assertEquals(PrimitiveTuples.pair(5.0, true), this.newWith(1.0, false, 2.0, true, 3.0, false).detectIfNone(PrimitiveTuples.pair(2.0, false)::equals, function));
    }

    @Test
    public void detectWithIfNoneBlock() {
        Function0<DoubleBooleanPair> function = Functions0.value(PrimitiveTuples.pair(5.0, true));
        Assert.assertEquals(PrimitiveTuples.pair(2.0, true), this.newWith(1.0, false, 2.0, true, 3.0, false).detectWithIfNone(Object::equals, PrimitiveTuples.pair(2.0, true), function));
        Assert.assertEquals(PrimitiveTuples.pair(5.0, true), this.newWith(1.0, false, 2.0, true, 3.0, false).detectWithIfNone(Object::equals, PrimitiveTuples.pair(2.0, false), function));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.newWith(1.0, false, 2.0, true, 3.0, false).allSatisfy(DoubleBooleanPair.class::isInstance));
        Assert.assertFalse(this.newWith(1.0, false, 2.0, true, 3.0, false).allSatisfy(PrimitiveTuples.pair(2.0, true)::equals));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertTrue(this.newWith(1.0, false, 2.0, true, 3.0, false).allSatisfyWith(Predicates2.instanceOf(), DoubleBooleanPair.class));
        Assert.assertFalse(this.newWith(1.0, false, 2.0, true, 3.0, false).allSatisfyWith(Object::equals, PrimitiveTuples.pair(2.0, true)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.newWith(1.0, false, 2.0, true, 3.0, false).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith(1.0, false, 2.0, true, 3.0, false).noneSatisfy(PrimitiveTuples.pair(2.0, true)::equals));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertTrue(this.newWith(1.0, false, 2.0, true, 3.0, false).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith(1.0, false, 2.0, true, 3.0, false).noneSatisfyWith(Object::equals, PrimitiveTuples.pair(2.0, true)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newWith(1.0, false, 2.0, true, 3.0, false).anySatisfy(PrimitiveTuples.pair(2.0, true)::equals));
        Assert.assertFalse(this.newWith(1.0, false, 2.0, true, 3.0, false).anySatisfy(PrimitiveTuples.pair(2, 5L)::equals));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertTrue(this.newWith(1.0, false, 2.0, true, 3.0, false).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2.0, true)));
        Assert.assertFalse(this.newWith(1.0, false, 2.0, true, 3.0, false).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2, 5L)));
    }

    @Test
    public void count() {
        Assert.assertEquals(0, this.newWith(1.0, false, 2.0, true, 3.0, false).count(Boolean.class::isInstance));
        Assert.assertEquals(3, this.newWith(1.0, false, 2.0, true, 3.0, false).count(DoubleBooleanPair.class::isInstance));
        Assert.assertEquals(1, this.newWith(1.0, false, 2.0, true, 3.0, false).count(PrimitiveTuples.pair(2.0, true)::equals));
    }

    @Test
    public void countWith() {
        Assert.assertEquals(0, this.newWith(1.0, false, 2.0, true, 3.0, false).countWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertEquals(3, this.newWith(1.0, false, 2.0, true, 3.0, false).countWith(Predicates2.instanceOf(), DoubleBooleanPair.class));
        Assert.assertEquals(1, this.newWith(1.0, false, 2.0, true, 3.0, false).countWith(Object::equals, PrimitiveTuples.pair(2.0, true)));
    }

    @Test
    public void collectIf() {
        Verify.assertContainsAll(this.newWith(1.0, false, 2.0, true, 3.0, false).collectIf(DoubleBooleanPair.class::isInstance, String::valueOf), "1.0:false", "2.0:true", "3.0:false");
        Verify.assertContainsAll(this.newWith(1.0, false, 2.0, true, 3.0, false).collectIf(DoubleBooleanPair.class::isInstance, String::valueOf, UnifiedSet.<String>newSet()), "1.0:false", "2.0:true", "3.0:false");
    }

    @Test
    public void collectWith() {
        Assert.assertEquals(Bags.mutable.of("3.0:false-", "2.0:true-", "1.0:false-"), this.newWith(1.0, false, 2.0, true, 3.0, false).collectWith((DoubleBooleanPair argument1, String argument2) -> argument1 + argument2, "-").toBag());
    }

    @Test
    public void collectWith_target() {
        Assert.assertEquals(Bags.mutable.of("1.0:false-", "2.0:true-", "3.0:false-"), this.newWith(1.0, false, 2.0, true, 3.0, false).collectWith((DoubleBooleanPair argument1, String argument2) -> argument1 + argument2, "-", HashBag.<String>newBag()));
    }

    @Test
    public void getFirst() {
        DoubleBooleanPair first = this.newWith(1.0, false, 2.0, true, 3.0, false).getFirst();
        Assert.assertTrue(PrimitiveTuples.pair(1.0, false).equals(first) || PrimitiveTuples.pair(2.0, true).equals(first) || PrimitiveTuples.pair(3.0, false).equals(first));
        Assert.assertEquals(PrimitiveTuples.pair(1.0, false), this.newWith(1.0, false).getFirst());
    }

    @Test
    public void getLast() {
        DoubleBooleanPair last = this.newWith(1.0, false, 2.0, true, 3.0, false).getLast();
        Assert.assertTrue(PrimitiveTuples.pair(1.0, false).equals(last) || PrimitiveTuples.pair(2.0, true).equals(last) || PrimitiveTuples.pair(3.0, false).equals(last));
        Assert.assertEquals(PrimitiveTuples.pair(1.0, false), this.newWith(1.0, false).getLast());
    }

    @Test
    public void isEmpty() {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith(1.0, false));
        Assert.assertTrue(this.newWith(1.0, false).notEmpty());
    }

    @Test
    public void iterator() {
        RichIterable<DoubleBooleanPair> objects = this.newWith(1.0, false, 0.0, true, 3.0, false);
        MutableBag<DoubleBooleanPair> actual = Bags.mutable.of();
        Iterator<DoubleBooleanPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_next_throws() {
        RichIterable<DoubleBooleanPair> objects = this.newWith(1.0, false, 2.0, true, 3.0, false);
        Iterator<DoubleBooleanPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            iterator.next();
        }
        Assert.assertFalse(iterator.hasNext());
        iterator.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iterator_remove_throws() {
        RichIterable<DoubleBooleanPair> objects = this.newWith(1.0, false, 2.0, true, 3.0, false);
        Iterator<DoubleBooleanPair> iterator = objects.iterator();
        iterator.remove();
    }

    @Test
    public void injectInto() {
        RichIterable<DoubleBooleanPair> objects = this.newWith(1.0, false, 2.0, true, 3.0, false);
        Long result = objects.injectInto(1L, (Long argument1, DoubleBooleanPair argument2) -> (long) (argument1 + argument2.getOne() + (argument2.getTwo() ? 0 : 1)));
        Assert.assertEquals(Long.valueOf(9), result);
    }

    @Test
    public void injectIntoInt() {
        RichIterable<DoubleBooleanPair> objects = this.newWith(1.0, false, 2.0, true, 3.0, false);
        int result = objects.injectInto(1, (int intParameter, DoubleBooleanPair argument2) -> (int) (intParameter + argument2.getOne() + (argument2.getTwo() ? 0 : 1)));
        Assert.assertEquals(9, result);
    }

    @Test
    public void injectIntoLong() {
        RichIterable<DoubleBooleanPair> objects = this.newWith(1.0, false, 2.0, true, 3.0, false);
        long result = objects.injectInto(1L, (long parameter, DoubleBooleanPair argument2) -> (long) (parameter + argument2.getOne() + (argument2.getTwo() ? 0 : 1)));
        Assert.assertEquals(9, result);
    }

    @Test
    public void injectIntoDouble() {
        RichIterable<DoubleBooleanPair> objects = this.newWith(1.0, false, 2.0, true, 3.0, false);
        double result = objects.injectInto(1.0, (double parameter, DoubleBooleanPair argument2) -> (double) (parameter + argument2.getOne() + (argument2.getTwo() ? 0 : 1)));
        Assert.assertEquals(9.0, result, 0.0);
    }

    @Test
    public void injectIntoFloat() {
        RichIterable<DoubleBooleanPair> objects = this.newWith(1.0, false, 2.0, true, 3.0, false);
        float result = objects.injectInto(1.0f, (float parameter, DoubleBooleanPair argument2) -> (float) (parameter + argument2.getOne() + (argument2.getTwo() ? 0 : 1)));
        Assert.assertEquals(9.0, result, 0.0);
    }

    @Test
    public void sumFloat() {
        RichIterable<DoubleBooleanPair> objects = this.newWith(1.0, false, 2.0, true, 3.0, false);
        double actual = objects.sumOfFloat((DoubleBooleanPair each) -> (float) (each.getOne() + (each.getTwo() ? 0 : 1)));
        Assert.assertEquals(8.0, actual, 0.0);
    }

    @Test
    public void sumDouble() {
        RichIterable<DoubleBooleanPair> objects = this.newWith(1.0, false, 2.0, true, 3.0, false);
        double actual = objects.sumOfDouble((DoubleBooleanPair each) -> (double) (each.getOne() + (each.getTwo() ? 0 : 1)));
        Assert.assertEquals(8.0, actual, 0.0);
    }

    @Test
    public void sumInteger() {
        RichIterable<DoubleBooleanPair> objects = this.newWith(1.0, false, 2.0, true, 3.0, false);
        long actual = objects.sumOfInt((DoubleBooleanPair each) -> (int) (each.getOne() + (each.getTwo() ? 0 : 1)));
        Assert.assertEquals(8, actual);
    }

    @Test
    public void sumLong() {
        RichIterable<DoubleBooleanPair> objects = this.newWith(1.0, false, 2.0, true, 3.0, false);
        long actual = objects.sumOfLong((DoubleBooleanPair each) -> (long) (each.getOne() + (each.getTwo() ? 0 : 1)));
        Assert.assertEquals(8, actual);
    }

    @Test
    public void toArray() {
        RichIterable<DoubleBooleanPair> objects = this.newWith(1.0, false, 2.0, true, 3.0, false);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        DoubleBooleanPair[] array2 = objects.toArray(new DoubleBooleanPair[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition() {
        PartitionIterable<DoubleBooleanPair> result = this.newWith(1.0, false, 2.0, true, 3.0, false).partition(PrimitiveTuples.pair(2.0, true)::equals);
        Verify.assertContains(PrimitiveTuples.pair(2.0, true), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair(1.0, false), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair(3.0, false), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void partitionWith() {
        PartitionIterable<DoubleBooleanPair> result = this.newWith(1.0, false, 2.0, true, 3.0, false).partitionWith(Object::equals, PrimitiveTuples.pair(2.0, true));
        Verify.assertContains(PrimitiveTuples.pair(2.0, true), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair(1.0, false), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair(3.0, false), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void toList() {
        MutableList<DoubleBooleanPair> list = this.newWith(1.0, false, 2.0, true, 3.0, false).toList();
        Verify.assertContainsAll(list, PrimitiveTuples.pair(1.0, false), PrimitiveTuples.pair(2.0, true), PrimitiveTuples.pair(3.0, false));
    }

    @Test
    public void toBag() {
        MutableBag<DoubleBooleanPair> bag = this.newWith(1.0, false, 2.0, true, 3.0, false).toBag();
        Verify.assertContainsAll(bag, PrimitiveTuples.pair(1.0, false), PrimitiveTuples.pair(2.0, true), PrimitiveTuples.pair(3.0, false));
    }

    @Test
    public void toSortedList_natural_ordering() {
        RichIterable<DoubleBooleanPair> pairs = this.newWith(2.0, true, 1.0, false, 3.0, false);
        MutableList<DoubleBooleanPair> list = pairs.toSortedList();
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(1.0, false), PrimitiveTuples.pair(2.0, true), PrimitiveTuples.pair(3.0, false)), list);
    }

    @Test
    public void toSortedList_with_comparator() {
        RichIterable<DoubleBooleanPair> pairs = this.newWith(2.0, true, 1.0, false, 3.0, false);
        MutableList<DoubleBooleanPair> list = pairs.toSortedList(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(3.0, false), PrimitiveTuples.pair(2.0, true), PrimitiveTuples.pair(1.0, false)), list);
    }

    @Test
    public void toSortedListBy() {
        RichIterable<DoubleBooleanPair> pairs = this.newWith(2.0, true, 1.0, false, 3.0, false);
        MutableList<DoubleBooleanPair> list = pairs.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(1.0, false), PrimitiveTuples.pair(2.0, true), PrimitiveTuples.pair(3.0, false)), list);
    }

    @Test
    public void toSortedBag_natural_ordering() {
        RichIterable<DoubleBooleanPair> pairs = this.newWith(2.0, true, 1.0, false, 3.0, false);
        MutableSortedBag<DoubleBooleanPair> bag = pairs.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(1.0, false), PrimitiveTuples.pair(2.0, true), PrimitiveTuples.pair(3.0, false)), bag);
    }

    @Test
    public void toSortedBag_with_comparator() {
        RichIterable<DoubleBooleanPair> pairs = this.newWith(2.0, true, 1.0, false, 3.0, false);
        MutableSortedBag<DoubleBooleanPair> bag = pairs.toSortedBag(Comparators.reverseNaturalOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair(3.0, false), PrimitiveTuples.pair(2.0, true), PrimitiveTuples.pair(1.0, false)), bag);
    }

    @Test
    public void toSortedBagBy() {
        RichIterable<DoubleBooleanPair> pairs = this.newWith(2.0, true, 1.0, false, 3.0, false);
        MutableSortedBag<DoubleBooleanPair> bag = pairs.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(1.0, false), PrimitiveTuples.pair(2.0, true), PrimitiveTuples.pair(3.0, false)), bag);
    }

    @Test
    public void toSortedSet_natural_ordering() {
        RichIterable<DoubleBooleanPair> pairs = this.newWith(2.0, true, 1.0, false, 3.0, false);
        MutableSortedSet<DoubleBooleanPair> set = pairs.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(1.0, false), PrimitiveTuples.pair(2.0, true), PrimitiveTuples.pair(3.0, false)), set);
    }

    @Test
    public void toSortedSet_with_comparator() {
        RichIterable<DoubleBooleanPair> pairs = this.newWith(2.0, true, 1.0, false, 3.0, false);
        MutableSortedSet<DoubleBooleanPair> set = pairs.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair(3.0, false), PrimitiveTuples.pair(2.0, true), PrimitiveTuples.pair(1.0, false)), set);
    }

    @Test
    public void toSortedSetBy() {
        RichIterable<DoubleBooleanPair> pairs = this.newWith(2.0, true, 1.0, false, 3.0, false);
        MutableSortedSet<DoubleBooleanPair> set = pairs.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(1.0, false), PrimitiveTuples.pair(2.0, true), PrimitiveTuples.pair(3.0, false)), set);
    }

    @Test
    public void toSet() {
        RichIterable<DoubleBooleanPair> pairs = this.newWith(1.0, false, 2.0, true, 3.0, false);
        MutableSet<DoubleBooleanPair> set = pairs.toSet();
        Verify.assertContainsAll(set, PrimitiveTuples.pair(1.0, false), PrimitiveTuples.pair(2.0, true), PrimitiveTuples.pair(3.0, false));
    }

    @Test
    public void toMap() {
        RichIterable<DoubleBooleanPair> pairs = this.newWith(1.0, false, 2.0, true, 3.0, false);
        MutableMap<String, String> map = pairs.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1.0:false", "1.0:false", "2.0:true", "2.0:true", "3.0:false", "3.0:false"), map);
    }

    @Test
    public void toSortedMap() {
        RichIterable<DoubleBooleanPair> pairs = this.newWith(1.0, false, 2.0, true, 3.0, false);
        MutableSortedMap<String, String> map = pairs.toSortedMap(String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith("1.0:false", "1.0:false", "2.0:true", "2.0:true", "3.0:false", "3.0:false"), map);
    }

    @Test
    public void toSortedMap_with_comparator() {
        RichIterable<DoubleBooleanPair> pairs = this.newWith(1.0, false, 2.0, true, 3.0, false);
        MutableSortedMap<String, String> map = pairs.toSortedMap(Comparators.reverseNaturalOrder(), String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), "1.0:false", "1.0:false", "2.0:true", "2.0:true", "3.0:false", "3.0:false"), map);
    }

    @Test
    public void toSortedMapBy() {
        RichIterable<DoubleBooleanPair> pairs = this.newWith(1.0, false, 2.0, true, 3.0, false);
        MutableSortedMap<String, String> map = pairs.toSortedMapBy(String::valueOf, String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.naturalOrder(), "1.0:false", "1.0:false", "2.0:true", "2.0:true", "3.0:false", "3.0:false"), map);
    }

    @Test
    public void toBiMap() {
        RichIterable<DoubleBooleanPair> pairs = this.newWith(1.0, false, 2.0, true, 3.0, false);
        MutableBiMap<String, String> biMap = pairs.toBiMap(String::valueOf, String::valueOf);
        Assert.assertEquals(HashBiMap.newWithKeysValues("1.0:false", "1.0:false", "2.0:true", "2.0:true", "3.0:false", "3.0:false"), biMap);
    }

    @Test
    public void testToString() {
        RichIterable<DoubleBooleanPair> collection = this.newWith(1.0, false, 2.0, true);
        Assert.assertTrue("[1.0:false, 2.0:true]".equals(collection.toString()) || "[2.0:true, 1.0:false]".equals(collection.toString()));
    }

    @Test
    public void makeString() {
        RichIterable<DoubleBooleanPair> collection = this.newWith(1.0, false, 2.0, true, 3.0, false);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator() {
        RichIterable<DoubleBooleanPair> collection = this.newWith(1.0, false, 2.0, true, 3.0, false);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd() {
        RichIterable<DoubleBooleanPair> collection = this.newWith(1.0, false, 2.0, true, 3.0, false);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString() {
        RichIterable<DoubleBooleanPair> collection = this.newWith(1.0, false, 2.0, true, 3.0, false);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator() {
        RichIterable<DoubleBooleanPair> collection = this.newWith(1.0, false, 2.0, true, 3.0, false);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd() {
        RichIterable<DoubleBooleanPair> collection = this.newWith(1.0, false, 2.0, true, 3.0, false);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void groupBy() {
        RichIterable<DoubleBooleanPair> collection = this.newWith(1.0, false, 2.0, true, 3.0, false);
        Function<DoubleBooleanPair, Boolean> function = (DoubleBooleanPair object) -> PrimitiveTuples.pair(1.0, false).equals(object);
        Multimap<Boolean, DoubleBooleanPair> multimap = collection.groupBy(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(1.0, false)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(2.0, true)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(3.0, false)));
    }

    @Test
    public void groupByEach() {
        RichIterable<DoubleBooleanPair> collection = this.newWith(1.0, false, 2.0, true, 3.0, false);
        Function<DoubleBooleanPair, MutableList<Boolean>> function = (DoubleBooleanPair object) -> Lists.mutable.of(PrimitiveTuples.pair(1.0, false).equals(object));
        Multimap<Boolean, DoubleBooleanPair> multimap = collection.groupByEach(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(1.0, false)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(2.0, true)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(3.0, false)));
    }

    @Test
    public void zip() {
        RichIterable<DoubleBooleanPair> collection = this.newWith(1.0, false, 2.0, true);
        RichIterable<Pair<DoubleBooleanPair, Integer>> result = collection.zip(Interval.oneTo(5));
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(1.0, false), 1), Tuples.pair(PrimitiveTuples.pair(2.0, true), 2)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(2.0, true), 1), Tuples.pair(PrimitiveTuples.pair(1.0, false), 2)).equals(result.toBag()));
    }

    @Test
    public void zipWithIndex() {
        RichIterable<DoubleBooleanPair> collection = this.newWith(1.0, false, 2.0, true);
        RichIterable<Pair<DoubleBooleanPair, Integer>> result = collection.zipWithIndex();
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(1.0, false), 0), Tuples.pair(PrimitiveTuples.pair(2.0, true), 1)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(2.0, true), 0), Tuples.pair(PrimitiveTuples.pair(1.0, false), 1)).equals(result.toBag()));
    }

    @Test
    public void chunk() {
        RichIterable<DoubleBooleanPair> collection = this.newWith(1.0, false, 2.0, true, 3.0, false);
        Assert.assertEquals(Bags.immutable.of(FastList.newListWith(PrimitiveTuples.pair(1.0, false)), FastList.newListWith(PrimitiveTuples.pair(2.0, true)), FastList.newListWith(PrimitiveTuples.pair(3.0, false))), collection.chunk(1).toBag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        RichIterable<DoubleBooleanPair> collection = this.newWith(1.0, false, 2.0, true, 3.0, false);
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size() {
        RichIterable<DoubleBooleanPair> collection = this.newWith(1.0, false, 2.0, true, 3.0, false);
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
        RichIterable<DoubleBooleanPair> notEmpty = this.newWith(1.0, false);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating() {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, DoubleBooleanPair> sumAggregator = (AtomicInteger aggregate, DoubleBooleanPair value) -> aggregate.addAndGet((int) value.getOne());
        RichIterable<DoubleBooleanPair> collection = this.newWith(1.0, false, 2.0, true, 3.0, false);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("3.0:false").intValue());
        Assert.assertEquals(2, aggregation.get("2.0:true").intValue());
        Assert.assertEquals(1, aggregation.get("1.0:false").intValue());
    }

    @Test
    public void aggregateByNonMutating() {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, DoubleBooleanPair, Integer> sumAggregator = (Integer aggregate, DoubleBooleanPair value) -> (int) (aggregate + value.getOne());
        RichIterable<DoubleBooleanPair> collection = this.newWith(1.0, false, 1.0, false, 2.0, true);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(2, aggregation.get("2.0:true").intValue());
        Assert.assertEquals(1, aggregation.get("1.0:false").intValue());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractDoubleBooleanMapKeyValuesViewTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractDoubleBooleanMapKeyValuesViewTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> iterator_next_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> iterator_remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleBooleanMapKeyValuesViewTestCase> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = AbstractDoubleBooleanMapKeyValuesViewTestCase::containsAllIterable;
            this.payloads.containsAllArray = AbstractDoubleBooleanMapKeyValuesViewTestCase::containsAllArray;
            this.payloads.forEach = AbstractDoubleBooleanMapKeyValuesViewTestCase::forEach;
            this.payloads.forEachWith = AbstractDoubleBooleanMapKeyValuesViewTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractDoubleBooleanMapKeyValuesViewTestCase::forEachWithIndex;
            this.payloads.select = AbstractDoubleBooleanMapKeyValuesViewTestCase::select;
            this.payloads.selectWith = AbstractDoubleBooleanMapKeyValuesViewTestCase::selectWith;
            this.payloads.selectWith_target = AbstractDoubleBooleanMapKeyValuesViewTestCase::selectWith_target;
            this.payloads.reject = AbstractDoubleBooleanMapKeyValuesViewTestCase::reject;
            this.payloads.rejectWith = AbstractDoubleBooleanMapKeyValuesViewTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractDoubleBooleanMapKeyValuesViewTestCase::rejectWith_target;
            this.payloads.selectInstancesOf = AbstractDoubleBooleanMapKeyValuesViewTestCase::selectInstancesOf;
            this.payloads.collect = AbstractDoubleBooleanMapKeyValuesViewTestCase::collect;
            this.payloads.collectBoolean = AbstractDoubleBooleanMapKeyValuesViewTestCase::collectBoolean;
            this.payloads.collectByte = AbstractDoubleBooleanMapKeyValuesViewTestCase::collectByte;
            this.payloads.collectChar = AbstractDoubleBooleanMapKeyValuesViewTestCase::collectChar;
            this.payloads.collectDouble = AbstractDoubleBooleanMapKeyValuesViewTestCase::collectDouble;
            this.payloads.collectFloat = AbstractDoubleBooleanMapKeyValuesViewTestCase::collectFloat;
            this.payloads.collectInt = AbstractDoubleBooleanMapKeyValuesViewTestCase::collectInt;
            this.payloads.collectLong = AbstractDoubleBooleanMapKeyValuesViewTestCase::collectLong;
            this.payloads.collectShort = AbstractDoubleBooleanMapKeyValuesViewTestCase::collectShort;
            this.payloads.flatCollect = AbstractDoubleBooleanMapKeyValuesViewTestCase::flatCollect;
            this.payloads.detect = AbstractDoubleBooleanMapKeyValuesViewTestCase::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleBooleanMapKeyValuesViewTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleBooleanMapKeyValuesViewTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractDoubleBooleanMapKeyValuesViewTestCase::min;
            this.payloads.max = AbstractDoubleBooleanMapKeyValuesViewTestCase::max;
            this.payloads.min_without_comparator = AbstractDoubleBooleanMapKeyValuesViewTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractDoubleBooleanMapKeyValuesViewTestCase::max_without_comparator;
            this.payloads.minBy = AbstractDoubleBooleanMapKeyValuesViewTestCase::minBy;
            this.payloads.maxBy = AbstractDoubleBooleanMapKeyValuesViewTestCase::maxBy;
            this.payloads.detectWith = AbstractDoubleBooleanMapKeyValuesViewTestCase::detectWith;
            this.payloads.detectIfNone = AbstractDoubleBooleanMapKeyValuesViewTestCase::detectIfNone;
            this.payloads.detectWithIfNoneBlock = AbstractDoubleBooleanMapKeyValuesViewTestCase::detectWithIfNoneBlock;
            this.payloads.allSatisfy = AbstractDoubleBooleanMapKeyValuesViewTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractDoubleBooleanMapKeyValuesViewTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractDoubleBooleanMapKeyValuesViewTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractDoubleBooleanMapKeyValuesViewTestCase::noneSatisfyWith;
            this.payloads.anySatisfy = AbstractDoubleBooleanMapKeyValuesViewTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractDoubleBooleanMapKeyValuesViewTestCase::anySatisfyWith;
            this.payloads.count = AbstractDoubleBooleanMapKeyValuesViewTestCase::count;
            this.payloads.countWith = AbstractDoubleBooleanMapKeyValuesViewTestCase::countWith;
            this.payloads.collectIf = AbstractDoubleBooleanMapKeyValuesViewTestCase::collectIf;
            this.payloads.collectWith = AbstractDoubleBooleanMapKeyValuesViewTestCase::collectWith;
            this.payloads.collectWith_target = AbstractDoubleBooleanMapKeyValuesViewTestCase::collectWith_target;
            this.payloads.getFirst = AbstractDoubleBooleanMapKeyValuesViewTestCase::getFirst;
            this.payloads.getLast = AbstractDoubleBooleanMapKeyValuesViewTestCase::getLast;
            this.payloads.isEmpty = AbstractDoubleBooleanMapKeyValuesViewTestCase::isEmpty;
            this.payloads.iterator = AbstractDoubleBooleanMapKeyValuesViewTestCase::iterator;
            this.payloads.iterator_next_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleBooleanMapKeyValuesViewTestCase::iterator_next_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleBooleanMapKeyValuesViewTestCase::iterator_remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.injectInto = AbstractDoubleBooleanMapKeyValuesViewTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractDoubleBooleanMapKeyValuesViewTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractDoubleBooleanMapKeyValuesViewTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractDoubleBooleanMapKeyValuesViewTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractDoubleBooleanMapKeyValuesViewTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractDoubleBooleanMapKeyValuesViewTestCase::sumFloat;
            this.payloads.sumDouble = AbstractDoubleBooleanMapKeyValuesViewTestCase::sumDouble;
            this.payloads.sumInteger = AbstractDoubleBooleanMapKeyValuesViewTestCase::sumInteger;
            this.payloads.sumLong = AbstractDoubleBooleanMapKeyValuesViewTestCase::sumLong;
            this.payloads.toArray = AbstractDoubleBooleanMapKeyValuesViewTestCase::toArray;
            this.payloads.partition = AbstractDoubleBooleanMapKeyValuesViewTestCase::partition;
            this.payloads.partitionWith = AbstractDoubleBooleanMapKeyValuesViewTestCase::partitionWith;
            this.payloads.toList = AbstractDoubleBooleanMapKeyValuesViewTestCase::toList;
            this.payloads.toBag = AbstractDoubleBooleanMapKeyValuesViewTestCase::toBag;
            this.payloads.toSortedList_natural_ordering = AbstractDoubleBooleanMapKeyValuesViewTestCase::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = AbstractDoubleBooleanMapKeyValuesViewTestCase::toSortedList_with_comparator;
            this.payloads.toSortedListBy = AbstractDoubleBooleanMapKeyValuesViewTestCase::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = AbstractDoubleBooleanMapKeyValuesViewTestCase::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = AbstractDoubleBooleanMapKeyValuesViewTestCase::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = AbstractDoubleBooleanMapKeyValuesViewTestCase::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = AbstractDoubleBooleanMapKeyValuesViewTestCase::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = AbstractDoubleBooleanMapKeyValuesViewTestCase::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractDoubleBooleanMapKeyValuesViewTestCase::toSortedSetBy;
            this.payloads.toSet = AbstractDoubleBooleanMapKeyValuesViewTestCase::toSet;
            this.payloads.toMap = AbstractDoubleBooleanMapKeyValuesViewTestCase::toMap;
            this.payloads.toSortedMap = AbstractDoubleBooleanMapKeyValuesViewTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractDoubleBooleanMapKeyValuesViewTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractDoubleBooleanMapKeyValuesViewTestCase::toSortedMapBy;
            this.payloads.toBiMap = AbstractDoubleBooleanMapKeyValuesViewTestCase::toBiMap;
            this.payloads.testToString = AbstractDoubleBooleanMapKeyValuesViewTestCase::testToString;
            this.payloads.makeString = AbstractDoubleBooleanMapKeyValuesViewTestCase::makeString;
            this.payloads.makeStringWithSeparator = AbstractDoubleBooleanMapKeyValuesViewTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = AbstractDoubleBooleanMapKeyValuesViewTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = AbstractDoubleBooleanMapKeyValuesViewTestCase::appendString;
            this.payloads.appendStringWithSeparator = AbstractDoubleBooleanMapKeyValuesViewTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = AbstractDoubleBooleanMapKeyValuesViewTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = AbstractDoubleBooleanMapKeyValuesViewTestCase::groupBy;
            this.payloads.groupByEach = AbstractDoubleBooleanMapKeyValuesViewTestCase::groupByEach;
            this.payloads.zip = AbstractDoubleBooleanMapKeyValuesViewTestCase::zip;
            this.payloads.zipWithIndex = AbstractDoubleBooleanMapKeyValuesViewTestCase::zipWithIndex;
            this.payloads.chunk = AbstractDoubleBooleanMapKeyValuesViewTestCase::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleBooleanMapKeyValuesViewTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractDoubleBooleanMapKeyValuesViewTestCase::chunk_large_size;
            this.payloads.empty = AbstractDoubleBooleanMapKeyValuesViewTestCase::empty;
            this.payloads.notEmpty = AbstractDoubleBooleanMapKeyValuesViewTestCase::notEmpty;
            this.payloads.aggregateByMutating = AbstractDoubleBooleanMapKeyValuesViewTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractDoubleBooleanMapKeyValuesViewTestCase::aggregateByNonMutating;
        }
    }
*/
}
