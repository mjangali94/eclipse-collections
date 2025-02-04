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
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.procedure.Procedure2;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MapIterable;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.map.primitive.ObjectCharMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.ObjectCharPair;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.BooleanHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.ByteHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.bag.sorted.mutable.TreeBag;
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
 * Abstract JUnit test for {@link ObjectCharMap#keyValuesView()}.
 * This file was automatically generated from template file abstractObjectPrimitiveMapKeyValuesViewTestCase.stg.
 */
public abstract class AbstractObjectCharMapKeyValuesViewTestCase {

    public abstract <T> ObjectCharMap<T> newWithKeysValues(T key1, char value1, T key2, char value2, T key3, char value3);

    public abstract <T> ObjectCharMap<T> newWithKeysValues(T key1, char value1, T key2, char value2);

    public abstract <T> ObjectCharMap<T> newWithKeysValues(T key1, char value1);

    public abstract <T> ObjectCharMap<T> newEmpty();

    public RichIterable<ObjectCharPair<Object>> newWith() {
        return this.newEmpty().keyValuesView();
    }

    public <T> RichIterable<ObjectCharPair<T>> newWith(T key1, char value1) {
        return this.newWithKeysValues(key1, value1).keyValuesView();
    }

    public <T> RichIterable<ObjectCharPair<T>> newWith(T key1, char value1, T key2, char value2) {
        return this.newWithKeysValues(key1, value1, key2, value2).keyValuesView();
    }

    public <T> RichIterable<ObjectCharPair<T>> newWith(T key1, char value1, T key2, char value2, T key3, char value3) {
        return this.newWithKeysValues(key1, value1, key2, value2, key3, value3).keyValuesView();
    }

    @Test
    public void containsAllIterable() {
        RichIterable<ObjectCharPair<Integer>> collection = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        Assert.assertTrue(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), PrimitiveTuples.pair(Integer.valueOf(2), (char) 3))));
        Assert.assertFalse(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), PrimitiveTuples.pair((char) 1, Integer.valueOf(5)))));
    }

    @Test
    public void containsAllArray() {
        RichIterable<ObjectCharPair<Integer>> collection = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        Assert.assertTrue(collection.containsAllArguments(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), PrimitiveTuples.pair(Integer.valueOf(2), (char) 3)));
        Assert.assertFalse(collection.containsAllArguments(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), PrimitiveTuples.pair((char) 1, Integer.valueOf(5))));
    }

    @Test
    public void forEach() {
        MutableList<ObjectCharPair<Integer>> result = Lists.mutable.of();
        RichIterable<ObjectCharPair<Integer>> collection = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        collection.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(3, result);
        Verify.assertContainsAll(result, PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), PrimitiveTuples.pair(Integer.valueOf(2), (char) 3), PrimitiveTuples.pair(Integer.valueOf(3), (char) 4));
    }

    @Test
    public void forEachWith() {
        MutableBag<ObjectCharPair<Integer>> result = Bags.mutable.of();
        MutableBag<Integer> result2 = Bags.mutable.of();
        RichIterable<ObjectCharPair<Integer>> collection = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        collection.forEachWith((ObjectCharPair<Integer> argument1, Integer argument2) -> {
            result.add(argument1);
            result2.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), PrimitiveTuples.pair(Integer.valueOf(2), (char) 3), PrimitiveTuples.pair(Integer.valueOf(3), (char) 4)), result);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result2);
    }

    @Test
    public void forEachWithIndex() {
        MutableBag<ObjectCharPair<Integer>> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<ObjectCharPair<Integer>> collection = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        collection.forEachWithIndex((ObjectCharPair<Integer> object, int index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), PrimitiveTuples.pair(Integer.valueOf(2), (char) 3), PrimitiveTuples.pair(Integer.valueOf(3), (char) 4)), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes);
    }

    @Test
    public void select() {
        MutableList<ObjectCharPair<Integer>> result = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).select(Predicates.equal(PrimitiveTuples.pair(Integer.valueOf(2), (char) 3))).toList();
        Verify.assertContains(PrimitiveTuples.pair(Integer.valueOf(2), (char) 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair(Integer.valueOf(3), (char) 4), result);
    }

    @Test
    public void selectWith() {
        MutableList<ObjectCharPair<Integer>> result = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).selectWith(Object::equals, PrimitiveTuples.pair(Integer.valueOf(2), (char) 3)).toList();
        Verify.assertContains(PrimitiveTuples.pair(Integer.valueOf(2), (char) 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair(Integer.valueOf(3), (char) 4), result);
    }

    @Test
    public void selectWith_target() {
        HashBag<ObjectCharPair<Integer>> result = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).selectWith(Predicates2.notEqual(), PrimitiveTuples.pair(Integer.valueOf(2), (char) 3), HashBag.<ObjectCharPair<Integer>>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), PrimitiveTuples.pair(Integer.valueOf(3), (char) 4)), result);
    }

    @Test
    public void reject() {
        MutableList<ObjectCharPair<Integer>> result = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).reject(Predicates.notEqual(PrimitiveTuples.pair(Integer.valueOf(2), (char) 3))).toList();
        Verify.assertContains(PrimitiveTuples.pair(Integer.valueOf(2), (char) 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair(Integer.valueOf(3), (char) 4), result);
    }

    @Test
    public void rejectWith() {
        MutableList<ObjectCharPair<Integer>> result = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).rejectWith(Predicates2.notEqual(), PrimitiveTuples.pair(Integer.valueOf(2), (char) 3)).toList();
        Verify.assertContains(PrimitiveTuples.pair(Integer.valueOf(2), (char) 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair(Integer.valueOf(3), (char) 4), result);
    }

    @Test
    public void rejectWith_target() {
        HashBag<ObjectCharPair<Integer>> result = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).rejectWith(Object::equals, PrimitiveTuples.pair(Integer.valueOf(2), (char) 3), HashBag.<ObjectCharPair<Integer>>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), PrimitiveTuples.pair(Integer.valueOf(3), (char) 4)), result);
    }

    @Test
    public void selectInstancesOf() {
        RichIterable<ObjectCharPair<Integer>> pairs = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        Verify.assertIterableEmpty(pairs.selectInstancesOf(Integer.class));
        Verify.assertContainsAll(pairs.selectInstancesOf(ObjectCharPair.class), PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), PrimitiveTuples.pair(Integer.valueOf(3), (char) 4), PrimitiveTuples.pair(Integer.valueOf(2), (char) 3));
    }

    @Test
    public void collect() {
        RichIterable<Integer> result1 = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).collect((ObjectCharPair<Integer> object) -> (int) object.getTwo());
        Assert.assertEquals(FastList.newListWith(2, 3, 4), result1.toList());
    }

    @Test
    public void collectBoolean() {
        BooleanIterable result = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).collectBoolean(pair -> (pair.getTwo() % 2) == 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(false, true, true), result.toBag());
    }

    @Test
    public void collectByte() {
        ByteIterable result = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).collectByte(pair -> (byte) pair.getTwo());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 2, (byte) 3, (byte) 4), result.toBag());
    }

    @Test
    public void collectChar() {
        CharIterable result = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).collectChar(pair -> (char) pair.getTwo());
        Assert.assertEquals(CharHashBag.newBagWith((char) 2, (char) 4, (char) 3), result.toBag());
    }

    @Test
    public void collectDouble() {
        DoubleIterable result = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).collectDouble(pair -> (double) pair.getTwo());
        Assert.assertEquals(DoubleHashBag.newBagWith(4.0, 3.0, 2.0), result.toBag());
    }

    @Test
    public void collectFloat() {
        FloatIterable result = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).collectFloat(pair -> (float) pair.getTwo());
        Assert.assertEquals(FloatHashBag.newBagWith(3.0f, 4.0f, 2.0f), result.toBag());
    }

    @Test
    public void collectInt() {
        IntIterable result = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).collectInt(pair -> (int) pair.getTwo());
        Assert.assertEquals(IntHashBag.newBagWith(2, 4, 3), result.toBag());
    }

    @Test
    public void collectLong() {
        LongIterable result = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).collectLong(pair -> (long) pair.getTwo());
        Assert.assertEquals(LongHashBag.newBagWith(4L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort() {
        ShortIterable result = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).collectShort(pair -> (short) pair.getTwo());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 2, (short) 4, (short) 3), result.toBag());
    }

    @Test
    public void flatCollect() {
        RichIterable<ObjectCharPair<Integer>> collection = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        Function<ObjectCharPair<Integer>, MutableList<String>> function = pair -> FastList.newListWith(String.valueOf(pair));
        Verify.assertListsEqual(FastList.newListWith("1:\u0002", "2:\u0003", "3:\u0004"), collection.flatCollect(function).toSortedList());
        Verify.assertSetsEqual(UnifiedSet.newSetWith("1:\u0002", "2:\u0003", "3:\u0004"), collection.flatCollect(function, UnifiedSet.<String>newSet()));
    }

    @Test
    public void detect() {
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(2), (char) 3), this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).detect(Predicates.equal(PrimitiveTuples.pair(Integer.valueOf(2), (char) 3))));
        Assert.assertNull(this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).detect(Predicates.equal(PrimitiveTuples.pair((char) 2, Integer.valueOf(4)))));
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
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).min(Comparators.naturalOrder()));
    }

    @Test
    public void max() {
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(3), (char) 4), this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).min(Comparators.naturalOrder()));
    }

    @Test
    public void max_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(3), (char) 4), this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).max(Comparators.naturalOrder()));
    }

    @Test
    public void minBy() {
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).minBy(pair -> (int) pair.getTwo() & 1));
    }

    @Test
    public void maxBy() {
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(2), (char) 3), this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).maxBy(pair -> (int) pair.getTwo() & 1));
    }

    @Test
    public void detectWith() {
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(2), (char) 3), this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).detectWith(Object::equals, PrimitiveTuples.pair(Integer.valueOf(2), (char) 3)));
        Assert.assertNull(this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).detectWith(Object::equals, PrimitiveTuples.pair((char) 2, Integer.valueOf(4))));
    }

    @Test
    public void detectIfNone() {
        Function0<ObjectCharPair<Integer>> function = Functions0.value(PrimitiveTuples.pair(Integer.valueOf(5), (char) 6));
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(2), (char) 3), this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).detectIfNone(Predicates.equal(PrimitiveTuples.pair(Integer.valueOf(2), (char) 3)), function));
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(5), (char) 6), this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).detectIfNone(Predicates.equal(PrimitiveTuples.pair((char) 2, Integer.valueOf(4))), function));
    }

    @Test
    public void detectWithIfNoneBlock() {
        Function0<ObjectCharPair<Integer>> function = Functions0.value(PrimitiveTuples.pair(Integer.valueOf(5), (char) 6));
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(2), (char) 3), this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).detectWithIfNone(Object::equals, PrimitiveTuples.pair(Integer.valueOf(2), (char) 3), function));
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(5), (char) 6), this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).detectWithIfNone(Object::equals, PrimitiveTuples.pair((char) 2, Integer.valueOf(4)), function));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).allSatisfy(ObjectCharPair.class::isInstance));
        Assert.assertFalse(this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).allSatisfy(Predicates.equal(PrimitiveTuples.pair(Integer.valueOf(2), (char) 3))));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertTrue(this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).allSatisfyWith(Predicates2.instanceOf(), ObjectCharPair.class));
        Assert.assertFalse(this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).allSatisfyWith(Object::equals, PrimitiveTuples.pair(Integer.valueOf(2), (char) 3)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).noneSatisfy(Predicates.equal(PrimitiveTuples.pair(Integer.valueOf(2), (char) 3))));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertTrue(this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).noneSatisfyWith(Object::equals, PrimitiveTuples.pair(Integer.valueOf(2), (char) 3)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).anySatisfy(Predicates.equal(PrimitiveTuples.pair(Integer.valueOf(2), (char) 3))));
        Assert.assertFalse(this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).anySatisfy(Predicates.equal(PrimitiveTuples.pair((char) 2, Integer.valueOf(5)))));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertTrue(this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).anySatisfyWith(Object::equals, PrimitiveTuples.pair(Integer.valueOf(2), (char) 3)));
        Assert.assertFalse(this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).anySatisfyWith(Object::equals, PrimitiveTuples.pair((char) 2, Integer.valueOf(5))));
    }

    @Test
    public void count() {
        Assert.assertEquals(0, this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).count(Boolean.class::isInstance));
        Assert.assertEquals(3, this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).count(ObjectCharPair.class::isInstance));
        Assert.assertEquals(1, this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).count(Predicates.equal(PrimitiveTuples.pair(Integer.valueOf(2), (char) 3))));
    }

    @Test
    public void countWith() {
        Assert.assertEquals(0, this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).countWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertEquals(3, this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).countWith(Predicates2.instanceOf(), ObjectCharPair.class));
        Assert.assertEquals(1, this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).countWith(Object::equals, PrimitiveTuples.pair(Integer.valueOf(2), (char) 3)));
    }

    @Test
    public void collectIf() {
        Verify.assertContainsAll(this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).collectIf(ObjectCharPair.class::isInstance, String::valueOf), "1:\u0002", "2:\u0003", "3:\u0004");
        Verify.assertContainsAll(this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).collectIf(ObjectCharPair.class::isInstance, String::valueOf, UnifiedSet.<String>newSet()), "1:\u0002", "2:\u0003", "3:\u0004");
    }

    @Test
    public void collectWith() {
        Assert.assertEquals(Bags.mutable.of(5L, 7L, 9L), this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).collectWith((ObjectCharPair<Integer> argument1, Long argument2) -> (long) (argument1.getTwo() + argument1.getTwo() + argument2), 1L).toBag());
    }

    @Test
    public void collectWith_target() {
        Assert.assertEquals(Bags.mutable.of(5L, 7L, 9L), this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).collectWith((ObjectCharPair<Integer> argument1, Long argument2) -> (long) (argument1.getTwo() + argument1.getTwo() + argument2), 1L, HashBag.<Long>newBag()));
    }

    @Test
    public void getFirst() {
        ObjectCharPair<Integer> first = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).getFirst();
        Assert.assertTrue(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2).equals(first) || PrimitiveTuples.pair(Integer.valueOf(2), (char) 3).equals(first) || PrimitiveTuples.pair(Integer.valueOf(3), (char) 4).equals(first));
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), this.newWith(1, (char) 2).getFirst());
    }

    @Test
    public void getLast() {
        ObjectCharPair<Integer> last = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).getLast();
        Assert.assertTrue(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2).equals(last) || PrimitiveTuples.pair(Integer.valueOf(2), (char) 3).equals(last) || PrimitiveTuples.pair(Integer.valueOf(3), (char) 4).equals(last));
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), this.newWith(1, (char) 2).getLast());
    }

    @Test
    public void isEmpty() {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith(1, (char) 2));
        Assert.assertTrue(this.newWith(1, (char) 2).notEmpty());
    }

    @Test
    public void iterator() {
        RichIterable<ObjectCharPair<Integer>> objects = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        MutableBag<ObjectCharPair<Integer>> actual = Bags.mutable.of();
        Iterator<ObjectCharPair<Integer>> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_throws() {
        RichIterable<ObjectCharPair<Integer>> objects = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        Iterator<ObjectCharPair<Integer>> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            iterator.next();
        }
        Assert.assertFalse(iterator.hasNext());
        iterator.next();
    }

    @Test
    public void injectInto() {
        RichIterable<ObjectCharPair<Integer>> objects = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        Long result = objects.injectInto(Long.valueOf(1L), (Long argument1, ObjectCharPair<Integer> argument2) -> (long) (argument1 + argument2.getTwo() + argument2.getTwo()));
        Assert.assertEquals(Long.valueOf(19), result);
    }

    @Test
    public void injectIntoInt() {
        RichIterable<ObjectCharPair<Integer>> objects = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        int result = objects.injectInto(1, (int intParameter, ObjectCharPair<Integer> argument2) -> (int) (intParameter + argument2.getTwo() + argument2.getTwo()));
        Assert.assertEquals(19, result);
    }

    @Test
    public void injectIntoLong() {
        RichIterable<ObjectCharPair<Integer>> objects = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        long result = objects.injectInto(1L, (long parameter, ObjectCharPair<Integer> argument2) -> (long) (parameter + argument2.getTwo() + argument2.getTwo()));
        Assert.assertEquals(19, result);
    }

    @Test
    public void injectIntoDouble() {
        RichIterable<ObjectCharPair<Integer>> objects = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        double result = objects.injectInto(1.0, (double parameter, ObjectCharPair<Integer> argument2) -> (double) (parameter + argument2.getTwo() + argument2.getTwo()));
        Assert.assertEquals(19.0, result, 0.0);
    }

    @Test
    public void injectIntoFloat() {
        RichIterable<ObjectCharPair<Integer>> objects = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        float result = objects.injectInto(1.0f, (float parameter, ObjectCharPair<Integer> argument2) -> (float) (parameter + argument2.getTwo() + argument2.getTwo()));
        Assert.assertEquals(19.0, result, 0.0);
    }

    @Test
    public void sumFloat() {
        RichIterable<ObjectCharPair<Integer>> objects = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        double actual = objects.sumOfFloat(pair -> (float) (pair.getTwo() + pair.getTwo()));
        Assert.assertEquals(18.0, actual, 0.0);
    }

    @Test
    public void sumDouble() {
        RichIterable<ObjectCharPair<Integer>> objects = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        double actual = objects.sumOfDouble(pair -> (double) (pair.getTwo() + pair.getTwo()));
        Assert.assertEquals(18.0, actual, 0.0);
    }

    @Test
    public void sumInteger() {
        RichIterable<ObjectCharPair<Integer>> objects = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        long actual = objects.sumOfInt(pair -> (int) (pair.getTwo() + pair.getTwo()));
        Assert.assertEquals(18, actual);
    }

    @Test
    public void sumLong() {
        RichIterable<ObjectCharPair<Integer>> objects = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        long actual = objects.sumOfLong(pair -> (long) (pair.getTwo() + pair.getTwo()));
        Assert.assertEquals(18, actual);
    }

    @Test
    public void toArray() {
        RichIterable<ObjectCharPair<Integer>> objects = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        ObjectCharPair<Integer>[] array2 = objects.toArray(new ObjectCharPair[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition() {
        PartitionIterable<ObjectCharPair<Integer>> result = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).partition(Predicates.equal(PrimitiveTuples.pair(Integer.valueOf(2), (char) 3)));
        Verify.assertContains(PrimitiveTuples.pair(Integer.valueOf(2), (char) 3), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair(Integer.valueOf(3), (char) 4), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void toList() {
        MutableList<ObjectCharPair<Integer>> list = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).toList();
        Verify.assertContainsAll(list, PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), PrimitiveTuples.pair(Integer.valueOf(2), (char) 3), PrimitiveTuples.pair(Integer.valueOf(3), (char) 4));
    }

    @Test
    public void toBag() {
        MutableBag<ObjectCharPair<Integer>> bag = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4).toBag();
        Verify.assertContainsAll(bag, PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), PrimitiveTuples.pair(Integer.valueOf(2), (char) 3), PrimitiveTuples.pair(Integer.valueOf(3), (char) 4));
    }

    @Test
    public void toSortedList_natural_ordering() {
        RichIterable<ObjectCharPair<Integer>> pairs = this.newWith(5, (char) 3, 1, (char) 2, 2, (char) 4);
        MutableList<ObjectCharPair<Integer>> list = pairs.toSortedList();
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), PrimitiveTuples.pair(Integer.valueOf(2), (char) 4), PrimitiveTuples.pair(Integer.valueOf(5), (char) 3)), list);
    }

    @Test
    public void toSortedList_with_comparator() {
        RichIterable<ObjectCharPair<Integer>> pairs = this.newWith(5, (char) 3, 1, (char) 2, 2, (char) 4);
        MutableList<ObjectCharPair<Integer>> list = pairs.toSortedList(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(Integer.valueOf(5), (char) 3), PrimitiveTuples.pair(Integer.valueOf(2), (char) 4), PrimitiveTuples.pair(Integer.valueOf(1), (char) 2)), list);
    }

    @Test
    public void toSortedListBy() {
        RichIterable<ObjectCharPair<Integer>> pairs = this.newWith(5, (char) 3, 1, (char) 2, 2, (char) 4);
        MutableList<ObjectCharPair<Integer>> list = pairs.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), PrimitiveTuples.pair(Integer.valueOf(2), (char) 4), PrimitiveTuples.pair(Integer.valueOf(5), (char) 3)), list);
    }

    @Test
    public void toSortedBag_natural_ordering() {
        RichIterable<ObjectCharPair<Integer>> pairs = this.newWith(5, (char) 3, 1, (char) 2, 2, (char) 4);
        MutableSortedBag<ObjectCharPair<Integer>> bag = pairs.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), PrimitiveTuples.pair(Integer.valueOf(2), (char) 4), PrimitiveTuples.pair(Integer.valueOf(5), (char) 3)), bag);
    }

    @Test
    public void toSortedBag_with_comparator() {
        RichIterable<ObjectCharPair<Integer>> pairs = this.newWith(5, (char) 3, 1, (char) 2, 2, (char) 4);
        MutableSortedBag<ObjectCharPair<Integer>> bag = pairs.toSortedBag(Comparators.reverseNaturalOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair(Integer.valueOf(5), (char) 3), PrimitiveTuples.pair(Integer.valueOf(2), (char) 4), PrimitiveTuples.pair(Integer.valueOf(1), (char) 2)), bag);
    }

    @Test
    public void toSortedBagBy() {
        RichIterable<ObjectCharPair<Integer>> pairs = this.newWith(5, (char) 3, 1, (char) 2, 2, (char) 4);
        MutableSortedBag<ObjectCharPair<Integer>> bag = pairs.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), PrimitiveTuples.pair(Integer.valueOf(2), (char) 4), PrimitiveTuples.pair(Integer.valueOf(5), (char) 3)), bag);
    }

    @Test
    public void toSortedSet_natural_ordering() {
        RichIterable<ObjectCharPair<Integer>> pairs = this.newWith(5, (char) 3, 1, (char) 2, 2, (char) 4);
        MutableSortedSet<ObjectCharPair<Integer>> set = pairs.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), PrimitiveTuples.pair(Integer.valueOf(2), (char) 4), PrimitiveTuples.pair(Integer.valueOf(5), (char) 3)), set);
    }

    @Test
    public void toSortedSet_with_comparator() {
        RichIterable<ObjectCharPair<Integer>> pairs = this.newWith(5, (char) 3, 1, (char) 2, 2, (char) 4);
        MutableSortedSet<ObjectCharPair<Integer>> set = pairs.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair(Integer.valueOf(5), (char) 3), PrimitiveTuples.pair(Integer.valueOf(2), (char) 4), PrimitiveTuples.pair(Integer.valueOf(1), (char) 2)), set);
    }

    @Test
    public void toSortedSetBy() {
        RichIterable<ObjectCharPair<Integer>> pairs = this.newWith(5, (char) 3, 1, (char) 2, 2, (char) 4);
        MutableSortedSet<ObjectCharPair<Integer>> set = pairs.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), PrimitiveTuples.pair(Integer.valueOf(2), (char) 4), PrimitiveTuples.pair(Integer.valueOf(5), (char) 3)), set);
    }

    @Test
    public void toSet() {
        RichIterable<ObjectCharPair<Integer>> pairs = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        MutableSet<ObjectCharPair<Integer>> set = pairs.toSet();
        Verify.assertContainsAll(set, PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), PrimitiveTuples.pair(Integer.valueOf(2), (char) 3), PrimitiveTuples.pair(Integer.valueOf(3), (char) 4));
    }

    @Test
    public void toMap() {
        RichIterable<ObjectCharPair<Integer>> pairs = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        MutableMap<String, String> map = pairs.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1:\u0002", "1:\u0002", "2:\u0003", "2:\u0003", "3:\u0004", "3:\u0004"), map);
    }

    @Test
    public void toSortedMap() {
        RichIterable<ObjectCharPair<Integer>> pairs = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        MutableSortedMap<String, String> map = pairs.toSortedMap(String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith("1:\u0002", "1:\u0002", "2:\u0003", "2:\u0003", "3:\u0004", "3:\u0004"), map);
    }

    @Test
    public void toSortedMap_with_comparator() {
        RichIterable<ObjectCharPair<Integer>> pairs = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        MutableSortedMap<String, String> map = pairs.toSortedMap(Comparators.reverseNaturalOrder(), String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), "1:\u0002", "1:\u0002", "2:\u0003", "2:\u0003", "3:\u0004", "3:\u0004"), map);
    }

    @Test
    public void toSortedMapBy() {
        RichIterable<ObjectCharPair<Integer>> pairs = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        MutableSortedMap<String, String> map = pairs.toSortedMapBy(String::valueOf, String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.naturalOrder(), "1:\u0002", "1:\u0002", "2:\u0003", "2:\u0003", "3:\u0004", "3:\u0004"), map);
    }

    @Test
    public void testToString() {
        RichIterable<ObjectCharPair<Integer>> collection = this.newWith(1, (char) 2, 2, (char) 3);
        Assert.assertTrue("[1:\u0002, 2:\u0003]".equals(collection.toString()) || "[2:\u0003, 1:\u0002]".equals(collection.toString()));
    }

    @Test
    public void makeString() {
        RichIterable<ObjectCharPair<Integer>> collection = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator() {
        RichIterable<ObjectCharPair<Integer>> collection = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd() {
        RichIterable<ObjectCharPair<Integer>> collection = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString() {
        RichIterable<ObjectCharPair<Integer>> collection = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator() {
        RichIterable<ObjectCharPair<Integer>> collection = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd() {
        RichIterable<ObjectCharPair<Integer>> collection = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void groupBy() {
        RichIterable<ObjectCharPair<Integer>> collection = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        Function<ObjectCharPair<Integer>, Boolean> function = pair -> PrimitiveTuples.pair(Integer.valueOf(1), (char) 2).equals(pair);
        Multimap<Boolean, ObjectCharPair<Integer>> multimap = collection.groupBy(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(Integer.valueOf(1), (char) 2)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(Integer.valueOf(2), (char) 3)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(Integer.valueOf(3), (char) 4)));
    }

    @Test
    public void groupByEach() {
        RichIterable<ObjectCharPair<Integer>> collection = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        Function<ObjectCharPair<Integer>, MutableList<Boolean>> function = pair -> Lists.mutable.of(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2).equals(pair));
        Multimap<Boolean, ObjectCharPair<Integer>> multimap = collection.groupByEach(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(Integer.valueOf(1), (char) 2)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(Integer.valueOf(2), (char) 3)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(Integer.valueOf(3), (char) 4)));
    }

    @Test
    public void zip() {
        RichIterable<ObjectCharPair<Integer>> collection = this.newWith(1, (char) 2, 2, (char) 3);
        RichIterable<Pair<ObjectCharPair<Integer>, Integer>> result = collection.zip(Interval.oneTo(5));
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), 1), Tuples.pair(PrimitiveTuples.pair(Integer.valueOf(2), (char) 3), 2)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(Integer.valueOf(2), (char) 3), 1), Tuples.pair(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), 2)).equals(result.toBag()));
    }

    @Test
    public void zipWithIndex() {
        RichIterable<ObjectCharPair<Integer>> collection = this.newWith(1, (char) 2, 2, (char) 3);
        RichIterable<Pair<ObjectCharPair<Integer>, Integer>> result = collection.zipWithIndex();
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), 0), Tuples.pair(PrimitiveTuples.pair(Integer.valueOf(2), (char) 3), 1)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(Integer.valueOf(2), (char) 3), 0), Tuples.pair(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2), 1)).equals(result.toBag()));
    }

    @Test
    public void chunk() {
        RichIterable<ObjectCharPair<Integer>> collection = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        Assert.assertEquals(Bags.immutable.of(FastList.newListWith(PrimitiveTuples.pair(Integer.valueOf(1), (char) 2)), FastList.newListWith(PrimitiveTuples.pair(Integer.valueOf(2), (char) 3)), FastList.newListWith(PrimitiveTuples.pair(Integer.valueOf(3), (char) 4))), collection.chunk(1).toBag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        RichIterable<ObjectCharPair<Integer>> collection = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size() {
        RichIterable<ObjectCharPair<Integer>> collection = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
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
        RichIterable<ObjectCharPair<Integer>> notEmpty = this.newWith(1, (char) 2);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating() {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, ObjectCharPair<Integer>> sumAggregator = (aggregate, pair) -> {
            aggregate.addAndGet((int) pair.getTwo());
        };
        RichIterable<ObjectCharPair<Integer>> collection = this.newWith(1, (char) 2, 2, (char) 3, 3, (char) 4);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(4, aggregation.get("3:\u0004").intValue());
        Assert.assertEquals(3, aggregation.get("2:\u0003").intValue());
        Assert.assertEquals(2, aggregation.get("1:\u0002").intValue());
    }

    @Test
    public void aggregateByNonMutating() {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, ObjectCharPair<Integer>, Integer> sumAggregator = (aggregate, pair) -> (int) (aggregate + pair.getTwo());
        RichIterable<ObjectCharPair<Integer>> collection = this.newWith(1, (char) 1, 1, (char) 2, 2, (char) 3);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("2:\u0003").intValue());
        Assert.assertEquals(2, aggregation.get("1:\u0002").intValue());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractObjectCharMapKeyValuesViewTestCase instance;

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
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractObjectCharMapKeyValuesViewTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapKeyValuesViewTestCase> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = AbstractObjectCharMapKeyValuesViewTestCase::containsAllIterable;
            this.payloads.containsAllArray = AbstractObjectCharMapKeyValuesViewTestCase::containsAllArray;
            this.payloads.forEach = AbstractObjectCharMapKeyValuesViewTestCase::forEach;
            this.payloads.forEachWith = AbstractObjectCharMapKeyValuesViewTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractObjectCharMapKeyValuesViewTestCase::forEachWithIndex;
            this.payloads.select = AbstractObjectCharMapKeyValuesViewTestCase::select;
            this.payloads.selectWith = AbstractObjectCharMapKeyValuesViewTestCase::selectWith;
            this.payloads.selectWith_target = AbstractObjectCharMapKeyValuesViewTestCase::selectWith_target;
            this.payloads.reject = AbstractObjectCharMapKeyValuesViewTestCase::reject;
            this.payloads.rejectWith = AbstractObjectCharMapKeyValuesViewTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractObjectCharMapKeyValuesViewTestCase::rejectWith_target;
            this.payloads.selectInstancesOf = AbstractObjectCharMapKeyValuesViewTestCase::selectInstancesOf;
            this.payloads.collect = AbstractObjectCharMapKeyValuesViewTestCase::collect;
            this.payloads.collectBoolean = AbstractObjectCharMapKeyValuesViewTestCase::collectBoolean;
            this.payloads.collectByte = AbstractObjectCharMapKeyValuesViewTestCase::collectByte;
            this.payloads.collectChar = AbstractObjectCharMapKeyValuesViewTestCase::collectChar;
            this.payloads.collectDouble = AbstractObjectCharMapKeyValuesViewTestCase::collectDouble;
            this.payloads.collectFloat = AbstractObjectCharMapKeyValuesViewTestCase::collectFloat;
            this.payloads.collectInt = AbstractObjectCharMapKeyValuesViewTestCase::collectInt;
            this.payloads.collectLong = AbstractObjectCharMapKeyValuesViewTestCase::collectLong;
            this.payloads.collectShort = AbstractObjectCharMapKeyValuesViewTestCase::collectShort;
            this.payloads.flatCollect = AbstractObjectCharMapKeyValuesViewTestCase::flatCollect;
            this.payloads.detect = AbstractObjectCharMapKeyValuesViewTestCase::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectCharMapKeyValuesViewTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectCharMapKeyValuesViewTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractObjectCharMapKeyValuesViewTestCase::min;
            this.payloads.max = AbstractObjectCharMapKeyValuesViewTestCase::max;
            this.payloads.min_without_comparator = AbstractObjectCharMapKeyValuesViewTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractObjectCharMapKeyValuesViewTestCase::max_without_comparator;
            this.payloads.minBy = AbstractObjectCharMapKeyValuesViewTestCase::minBy;
            this.payloads.maxBy = AbstractObjectCharMapKeyValuesViewTestCase::maxBy;
            this.payloads.detectWith = AbstractObjectCharMapKeyValuesViewTestCase::detectWith;
            this.payloads.detectIfNone = AbstractObjectCharMapKeyValuesViewTestCase::detectIfNone;
            this.payloads.detectWithIfNoneBlock = AbstractObjectCharMapKeyValuesViewTestCase::detectWithIfNoneBlock;
            this.payloads.allSatisfy = AbstractObjectCharMapKeyValuesViewTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractObjectCharMapKeyValuesViewTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractObjectCharMapKeyValuesViewTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractObjectCharMapKeyValuesViewTestCase::noneSatisfyWith;
            this.payloads.anySatisfy = AbstractObjectCharMapKeyValuesViewTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractObjectCharMapKeyValuesViewTestCase::anySatisfyWith;
            this.payloads.count = AbstractObjectCharMapKeyValuesViewTestCase::count;
            this.payloads.countWith = AbstractObjectCharMapKeyValuesViewTestCase::countWith;
            this.payloads.collectIf = AbstractObjectCharMapKeyValuesViewTestCase::collectIf;
            this.payloads.collectWith = AbstractObjectCharMapKeyValuesViewTestCase::collectWith;
            this.payloads.collectWith_target = AbstractObjectCharMapKeyValuesViewTestCase::collectWith_target;
            this.payloads.getFirst = AbstractObjectCharMapKeyValuesViewTestCase::getFirst;
            this.payloads.getLast = AbstractObjectCharMapKeyValuesViewTestCase::getLast;
            this.payloads.isEmpty = AbstractObjectCharMapKeyValuesViewTestCase::isEmpty;
            this.payloads.iterator = AbstractObjectCharMapKeyValuesViewTestCase::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectCharMapKeyValuesViewTestCase::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = AbstractObjectCharMapKeyValuesViewTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractObjectCharMapKeyValuesViewTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractObjectCharMapKeyValuesViewTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractObjectCharMapKeyValuesViewTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractObjectCharMapKeyValuesViewTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractObjectCharMapKeyValuesViewTestCase::sumFloat;
            this.payloads.sumDouble = AbstractObjectCharMapKeyValuesViewTestCase::sumDouble;
            this.payloads.sumInteger = AbstractObjectCharMapKeyValuesViewTestCase::sumInteger;
            this.payloads.sumLong = AbstractObjectCharMapKeyValuesViewTestCase::sumLong;
            this.payloads.toArray = AbstractObjectCharMapKeyValuesViewTestCase::toArray;
            this.payloads.partition = AbstractObjectCharMapKeyValuesViewTestCase::partition;
            this.payloads.toList = AbstractObjectCharMapKeyValuesViewTestCase::toList;
            this.payloads.toBag = AbstractObjectCharMapKeyValuesViewTestCase::toBag;
            this.payloads.toSortedList_natural_ordering = AbstractObjectCharMapKeyValuesViewTestCase::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = AbstractObjectCharMapKeyValuesViewTestCase::toSortedList_with_comparator;
            this.payloads.toSortedListBy = AbstractObjectCharMapKeyValuesViewTestCase::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = AbstractObjectCharMapKeyValuesViewTestCase::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = AbstractObjectCharMapKeyValuesViewTestCase::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = AbstractObjectCharMapKeyValuesViewTestCase::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = AbstractObjectCharMapKeyValuesViewTestCase::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = AbstractObjectCharMapKeyValuesViewTestCase::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractObjectCharMapKeyValuesViewTestCase::toSortedSetBy;
            this.payloads.toSet = AbstractObjectCharMapKeyValuesViewTestCase::toSet;
            this.payloads.toMap = AbstractObjectCharMapKeyValuesViewTestCase::toMap;
            this.payloads.toSortedMap = AbstractObjectCharMapKeyValuesViewTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractObjectCharMapKeyValuesViewTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractObjectCharMapKeyValuesViewTestCase::toSortedMapBy;
            this.payloads.testToString = AbstractObjectCharMapKeyValuesViewTestCase::testToString;
            this.payloads.makeString = AbstractObjectCharMapKeyValuesViewTestCase::makeString;
            this.payloads.makeStringWithSeparator = AbstractObjectCharMapKeyValuesViewTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = AbstractObjectCharMapKeyValuesViewTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = AbstractObjectCharMapKeyValuesViewTestCase::appendString;
            this.payloads.appendStringWithSeparator = AbstractObjectCharMapKeyValuesViewTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = AbstractObjectCharMapKeyValuesViewTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = AbstractObjectCharMapKeyValuesViewTestCase::groupBy;
            this.payloads.groupByEach = AbstractObjectCharMapKeyValuesViewTestCase::groupByEach;
            this.payloads.zip = AbstractObjectCharMapKeyValuesViewTestCase::zip;
            this.payloads.zipWithIndex = AbstractObjectCharMapKeyValuesViewTestCase::zipWithIndex;
            this.payloads.chunk = AbstractObjectCharMapKeyValuesViewTestCase::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectCharMapKeyValuesViewTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractObjectCharMapKeyValuesViewTestCase::chunk_large_size;
            this.payloads.empty = AbstractObjectCharMapKeyValuesViewTestCase::empty;
            this.payloads.notEmpty = AbstractObjectCharMapKeyValuesViewTestCase::notEmpty;
            this.payloads.aggregateByMutating = AbstractObjectCharMapKeyValuesViewTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractObjectCharMapKeyValuesViewTestCase::aggregateByNonMutating;
        }
    }
}
