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
import org.eclipse.collections.api.map.primitive.ObjectIntMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;
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
 * Abstract JUnit test for {@link ObjectIntMap#keyValuesView()}.
 * This file was automatically generated from template file abstractObjectPrimitiveMapKeyValuesViewTestCase.stg.
 */
public abstract class AbstractObjectIntMapKeyValuesViewTestCase {

    public abstract <T> ObjectIntMap<T> newWithKeysValues(T key1, int value1, T key2, int value2, T key3, int value3);

    public abstract <T> ObjectIntMap<T> newWithKeysValues(T key1, int value1, T key2, int value2);

    public abstract <T> ObjectIntMap<T> newWithKeysValues(T key1, int value1);

    public abstract <T> ObjectIntMap<T> newEmpty();

    public RichIterable<ObjectIntPair<Object>> newWith() {
        return this.newEmpty().keyValuesView();
    }

    public <T> RichIterable<ObjectIntPair<T>> newWith(T key1, int value1) {
        return this.newWithKeysValues(key1, value1).keyValuesView();
    }

    public <T> RichIterable<ObjectIntPair<T>> newWith(T key1, int value1, T key2, int value2) {
        return this.newWithKeysValues(key1, value1, key2, value2).keyValuesView();
    }

    public <T> RichIterable<ObjectIntPair<T>> newWith(T key1, int value1, T key2, int value2, T key3, int value3) {
        return this.newWithKeysValues(key1, value1, key2, value2, key3, value3).keyValuesView();
    }

    @Test
    public void containsAllIterable() {
        RichIterable<ObjectIntPair<Integer>> collection = this.newWith(1, 2, 2, 3, 3, 4);
        Assert.assertTrue(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(Integer.valueOf(1), 2), PrimitiveTuples.pair(Integer.valueOf(2), 3))));
        Assert.assertFalse(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(Integer.valueOf(1), 2), PrimitiveTuples.pair(1, Integer.valueOf(5)))));
    }

    @Test
    public void containsAllArray() {
        RichIterable<ObjectIntPair<Integer>> collection = this.newWith(1, 2, 2, 3, 3, 4);
        Assert.assertTrue(collection.containsAllArguments(PrimitiveTuples.pair(Integer.valueOf(1), 2), PrimitiveTuples.pair(Integer.valueOf(2), 3)));
        Assert.assertFalse(collection.containsAllArguments(PrimitiveTuples.pair(Integer.valueOf(1), 2), PrimitiveTuples.pair(1, Integer.valueOf(5))));
    }

    @Test
    public void forEach() {
        MutableList<ObjectIntPair<Integer>> result = Lists.mutable.of();
        RichIterable<ObjectIntPair<Integer>> collection = this.newWith(1, 2, 2, 3, 3, 4);
        collection.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(3, result);
        Verify.assertContainsAll(result, PrimitiveTuples.pair(Integer.valueOf(1), 2), PrimitiveTuples.pair(Integer.valueOf(2), 3), PrimitiveTuples.pair(Integer.valueOf(3), 4));
    }

    @Test
    public void forEachWith() {
        MutableBag<ObjectIntPair<Integer>> result = Bags.mutable.of();
        MutableBag<Integer> result2 = Bags.mutable.of();
        RichIterable<ObjectIntPair<Integer>> collection = this.newWith(1, 2, 2, 3, 3, 4);
        collection.forEachWith((ObjectIntPair<Integer> argument1, Integer argument2) -> {
            result.add(argument1);
            result2.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(Integer.valueOf(1), 2), PrimitiveTuples.pair(Integer.valueOf(2), 3), PrimitiveTuples.pair(Integer.valueOf(3), 4)), result);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result2);
    }

    @Test
    public void forEachWithIndex() {
        MutableBag<ObjectIntPair<Integer>> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<ObjectIntPair<Integer>> collection = this.newWith(1, 2, 2, 3, 3, 4);
        collection.forEachWithIndex((ObjectIntPair<Integer> object, int index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair(Integer.valueOf(1), 2), PrimitiveTuples.pair(Integer.valueOf(2), 3), PrimitiveTuples.pair(Integer.valueOf(3), 4)), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes);
    }

    @Test
    public void select() {
        MutableList<ObjectIntPair<Integer>> result = this.newWith(1, 2, 2, 3, 3, 4).select(Predicates.equal(PrimitiveTuples.pair(Integer.valueOf(2), 3))).toList();
        Verify.assertContains(PrimitiveTuples.pair(Integer.valueOf(2), 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair(Integer.valueOf(1), 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair(Integer.valueOf(3), 4), result);
    }

    @Test
    public void selectWith() {
        MutableList<ObjectIntPair<Integer>> result = this.newWith(1, 2, 2, 3, 3, 4).selectWith(Object::equals, PrimitiveTuples.pair(Integer.valueOf(2), 3)).toList();
        Verify.assertContains(PrimitiveTuples.pair(Integer.valueOf(2), 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair(Integer.valueOf(1), 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair(Integer.valueOf(3), 4), result);
    }

    @Test
    public void selectWith_target() {
        HashBag<ObjectIntPair<Integer>> result = this.newWith(1, 2, 2, 3, 3, 4).selectWith(Predicates2.notEqual(), PrimitiveTuples.pair(Integer.valueOf(2), 3), HashBag.<ObjectIntPair<Integer>>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(Integer.valueOf(1), 2), PrimitiveTuples.pair(Integer.valueOf(3), 4)), result);
    }

    @Test
    public void reject() {
        MutableList<ObjectIntPair<Integer>> result = this.newWith(1, 2, 2, 3, 3, 4).reject(Predicates.notEqual(PrimitiveTuples.pair(Integer.valueOf(2), 3))).toList();
        Verify.assertContains(PrimitiveTuples.pair(Integer.valueOf(2), 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair(Integer.valueOf(1), 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair(Integer.valueOf(3), 4), result);
    }

    @Test
    public void rejectWith() {
        MutableList<ObjectIntPair<Integer>> result = this.newWith(1, 2, 2, 3, 3, 4).rejectWith(Predicates2.notEqual(), PrimitiveTuples.pair(Integer.valueOf(2), 3)).toList();
        Verify.assertContains(PrimitiveTuples.pair(Integer.valueOf(2), 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair(Integer.valueOf(1), 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair(Integer.valueOf(3), 4), result);
    }

    @Test
    public void rejectWith_target() {
        HashBag<ObjectIntPair<Integer>> result = this.newWith(1, 2, 2, 3, 3, 4).rejectWith(Object::equals, PrimitiveTuples.pair(Integer.valueOf(2), 3), HashBag.<ObjectIntPair<Integer>>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(Integer.valueOf(1), 2), PrimitiveTuples.pair(Integer.valueOf(3), 4)), result);
    }

    @Test
    public void selectInstancesOf() {
        RichIterable<ObjectIntPair<Integer>> pairs = this.newWith(1, 2, 2, 3, 3, 4);
        Verify.assertIterableEmpty(pairs.selectInstancesOf(Integer.class));
        Verify.assertContainsAll(pairs.selectInstancesOf(ObjectIntPair.class), PrimitiveTuples.pair(Integer.valueOf(1), 2), PrimitiveTuples.pair(Integer.valueOf(3), 4), PrimitiveTuples.pair(Integer.valueOf(2), 3));
    }

    @Test
    public void collect() {
        RichIterable<Integer> result1 = this.newWith(1, 2, 2, 3, 3, 4).collect((ObjectIntPair<Integer> object) -> (int) object.getTwo());
        Assert.assertEquals(FastList.newListWith(2, 3, 4), result1.toList());
    }

    @Test
    public void collectBoolean() {
        BooleanIterable result = this.newWith(1, 2, 2, 3, 3, 4).collectBoolean(pair -> (pair.getTwo() % 2) == 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(false, true, true), result.toBag());
    }

    @Test
    public void collectByte() {
        ByteIterable result = this.newWith(1, 2, 2, 3, 3, 4).collectByte(pair -> (byte) pair.getTwo());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 2, (byte) 3, (byte) 4), result.toBag());
    }

    @Test
    public void collectChar() {
        CharIterable result = this.newWith(1, 2, 2, 3, 3, 4).collectChar(pair -> (char) pair.getTwo());
        Assert.assertEquals(CharHashBag.newBagWith((char) 2, (char) 4, (char) 3), result.toBag());
    }

    @Test
    public void collectDouble() {
        DoubleIterable result = this.newWith(1, 2, 2, 3, 3, 4).collectDouble(pair -> (double) pair.getTwo());
        Assert.assertEquals(DoubleHashBag.newBagWith(4.0, 3.0, 2.0), result.toBag());
    }

    @Test
    public void collectFloat() {
        FloatIterable result = this.newWith(1, 2, 2, 3, 3, 4).collectFloat(pair -> (float) pair.getTwo());
        Assert.assertEquals(FloatHashBag.newBagWith(3.0f, 4.0f, 2.0f), result.toBag());
    }

    @Test
    public void collectInt() {
        IntIterable result = this.newWith(1, 2, 2, 3, 3, 4).collectInt(pair -> (int) pair.getTwo());
        Assert.assertEquals(IntHashBag.newBagWith(2, 4, 3), result.toBag());
    }

    @Test
    public void collectLong() {
        LongIterable result = this.newWith(1, 2, 2, 3, 3, 4).collectLong(pair -> (long) pair.getTwo());
        Assert.assertEquals(LongHashBag.newBagWith(4L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort() {
        ShortIterable result = this.newWith(1, 2, 2, 3, 3, 4).collectShort(pair -> (short) pair.getTwo());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 2, (short) 4, (short) 3), result.toBag());
    }

    @Test
    public void flatCollect() {
        RichIterable<ObjectIntPair<Integer>> collection = this.newWith(1, 2, 2, 3, 3, 4);
        Function<ObjectIntPair<Integer>, MutableList<String>> function = pair -> FastList.newListWith(String.valueOf(pair));
        Verify.assertListsEqual(FastList.newListWith("1:2", "2:3", "3:4"), collection.flatCollect(function).toSortedList());
        Verify.assertSetsEqual(UnifiedSet.newSetWith("1:2", "2:3", "3:4"), collection.flatCollect(function, UnifiedSet.<String>newSet()));
    }

    @Test
    public void detect() {
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(2), 3), this.newWith(1, 2, 2, 3, 3, 4).detect(Predicates.equal(PrimitiveTuples.pair(Integer.valueOf(2), 3))));
        Assert.assertNull(this.newWith(1, 2, 2, 3, 3, 4).detect(Predicates.equal(PrimitiveTuples.pair(2, Integer.valueOf(4)))));
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
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(1), 2), this.newWith(1, 2, 2, 3, 3, 4).min(Comparators.naturalOrder()));
    }

    @Test
    public void max() {
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(3), 4), this.newWith(1, 2, 2, 3, 3, 4).max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(1), 2), this.newWith(1, 2, 2, 3, 3, 4).min(Comparators.naturalOrder()));
    }

    @Test
    public void max_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(3), 4), this.newWith(1, 2, 2, 3, 3, 4).max(Comparators.naturalOrder()));
    }

    @Test
    public void minBy() {
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(1), 2), this.newWith(1, 2, 2, 3, 3, 4).minBy(pair -> (int) pair.getTwo() & 1));
    }

    @Test
    public void maxBy() {
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(2), 3), this.newWith(1, 2, 2, 3, 3, 4).maxBy(pair -> (int) pair.getTwo() & 1));
    }

    @Test
    public void detectWith() {
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(2), 3), this.newWith(1, 2, 2, 3, 3, 4).detectWith(Object::equals, PrimitiveTuples.pair(Integer.valueOf(2), 3)));
        Assert.assertNull(this.newWith(1, 2, 2, 3, 3, 4).detectWith(Object::equals, PrimitiveTuples.pair(2, Integer.valueOf(4))));
    }

    @Test
    public void detectIfNone() {
        Function0<ObjectIntPair<Integer>> function = Functions0.value(PrimitiveTuples.pair(Integer.valueOf(5), 6));
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(2), 3), this.newWith(1, 2, 2, 3, 3, 4).detectIfNone(Predicates.equal(PrimitiveTuples.pair(Integer.valueOf(2), 3)), function));
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(5), 6), this.newWith(1, 2, 2, 3, 3, 4).detectIfNone(Predicates.equal(PrimitiveTuples.pair(2, Integer.valueOf(4))), function));
    }

    @Test
    public void detectWithIfNoneBlock() {
        Function0<ObjectIntPair<Integer>> function = Functions0.value(PrimitiveTuples.pair(Integer.valueOf(5), 6));
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(2), 3), this.newWith(1, 2, 2, 3, 3, 4).detectWithIfNone(Object::equals, PrimitiveTuples.pair(Integer.valueOf(2), 3), function));
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(5), 6), this.newWith(1, 2, 2, 3, 3, 4).detectWithIfNone(Object::equals, PrimitiveTuples.pair(2, Integer.valueOf(4)), function));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.newWith(1, 2, 2, 3, 3, 4).allSatisfy(ObjectIntPair.class::isInstance));
        Assert.assertFalse(this.newWith(1, 2, 2, 3, 3, 4).allSatisfy(Predicates.equal(PrimitiveTuples.pair(Integer.valueOf(2), 3))));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertTrue(this.newWith(1, 2, 2, 3, 3, 4).allSatisfyWith(Predicates2.instanceOf(), ObjectIntPair.class));
        Assert.assertFalse(this.newWith(1, 2, 2, 3, 3, 4).allSatisfyWith(Object::equals, PrimitiveTuples.pair(Integer.valueOf(2), 3)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.newWith(1, 2, 2, 3, 3, 4).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith(1, 2, 2, 3, 3, 4).noneSatisfy(Predicates.equal(PrimitiveTuples.pair(Integer.valueOf(2), 3))));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertTrue(this.newWith(1, 2, 2, 3, 3, 4).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith(1, 2, 2, 3, 3, 4).noneSatisfyWith(Object::equals, PrimitiveTuples.pair(Integer.valueOf(2), 3)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newWith(1, 2, 2, 3, 3, 4).anySatisfy(Predicates.equal(PrimitiveTuples.pair(Integer.valueOf(2), 3))));
        Assert.assertFalse(this.newWith(1, 2, 2, 3, 3, 4).anySatisfy(Predicates.equal(PrimitiveTuples.pair(2, Integer.valueOf(5)))));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertTrue(this.newWith(1, 2, 2, 3, 3, 4).anySatisfyWith(Object::equals, PrimitiveTuples.pair(Integer.valueOf(2), 3)));
        Assert.assertFalse(this.newWith(1, 2, 2, 3, 3, 4).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2, Integer.valueOf(5))));
    }

    @Test
    public void count() {
        Assert.assertEquals(0, this.newWith(1, 2, 2, 3, 3, 4).count(Boolean.class::isInstance));
        Assert.assertEquals(3, this.newWith(1, 2, 2, 3, 3, 4).count(ObjectIntPair.class::isInstance));
        Assert.assertEquals(1, this.newWith(1, 2, 2, 3, 3, 4).count(Predicates.equal(PrimitiveTuples.pair(Integer.valueOf(2), 3))));
    }

    @Test
    public void countWith() {
        Assert.assertEquals(0, this.newWith(1, 2, 2, 3, 3, 4).countWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertEquals(3, this.newWith(1, 2, 2, 3, 3, 4).countWith(Predicates2.instanceOf(), ObjectIntPair.class));
        Assert.assertEquals(1, this.newWith(1, 2, 2, 3, 3, 4).countWith(Object::equals, PrimitiveTuples.pair(Integer.valueOf(2), 3)));
    }

    @Test
    public void collectIf() {
        Verify.assertContainsAll(this.newWith(1, 2, 2, 3, 3, 4).collectIf(ObjectIntPair.class::isInstance, String::valueOf), "1:2", "2:3", "3:4");
        Verify.assertContainsAll(this.newWith(1, 2, 2, 3, 3, 4).collectIf(ObjectIntPair.class::isInstance, String::valueOf, UnifiedSet.<String>newSet()), "1:2", "2:3", "3:4");
    }

    @Test
    public void collectWith() {
        Assert.assertEquals(Bags.mutable.of(5L, 7L, 9L), this.newWith(1, 2, 2, 3, 3, 4).collectWith((ObjectIntPair<Integer> argument1, Long argument2) -> (long) (argument1.getTwo() + argument1.getTwo() + argument2), 1L).toBag());
    }

    @Test
    public void collectWith_target() {
        Assert.assertEquals(Bags.mutable.of(5L, 7L, 9L), this.newWith(1, 2, 2, 3, 3, 4).collectWith((ObjectIntPair<Integer> argument1, Long argument2) -> (long) (argument1.getTwo() + argument1.getTwo() + argument2), 1L, HashBag.<Long>newBag()));
    }

    @Test
    public void getFirst() {
        ObjectIntPair<Integer> first = this.newWith(1, 2, 2, 3, 3, 4).getFirst();
        Assert.assertTrue(PrimitiveTuples.pair(Integer.valueOf(1), 2).equals(first) || PrimitiveTuples.pair(Integer.valueOf(2), 3).equals(first) || PrimitiveTuples.pair(Integer.valueOf(3), 4).equals(first));
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(1), 2), this.newWith(1, 2).getFirst());
    }

    @Test
    public void getLast() {
        ObjectIntPair<Integer> last = this.newWith(1, 2, 2, 3, 3, 4).getLast();
        Assert.assertTrue(PrimitiveTuples.pair(Integer.valueOf(1), 2).equals(last) || PrimitiveTuples.pair(Integer.valueOf(2), 3).equals(last) || PrimitiveTuples.pair(Integer.valueOf(3), 4).equals(last));
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(1), 2), this.newWith(1, 2).getLast());
    }

    @Test
    public void isEmpty() {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith(1, 2));
        Assert.assertTrue(this.newWith(1, 2).notEmpty());
    }

    @Test
    public void iterator() {
        RichIterable<ObjectIntPair<Integer>> objects = this.newWith(1, 2, 2, 3, 3, 4);
        MutableBag<ObjectIntPair<Integer>> actual = Bags.mutable.of();
        Iterator<ObjectIntPair<Integer>> iterator = objects.iterator();
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
        RichIterable<ObjectIntPair<Integer>> objects = this.newWith(1, 2, 2, 3, 3, 4);
        Iterator<ObjectIntPair<Integer>> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            iterator.next();
        }
        Assert.assertFalse(iterator.hasNext());
        iterator.next();
    }

    @Test
    public void injectInto() {
        RichIterable<ObjectIntPair<Integer>> objects = this.newWith(1, 2, 2, 3, 3, 4);
        Long result = objects.injectInto(Long.valueOf(1L), (Long argument1, ObjectIntPair<Integer> argument2) -> (long) (argument1 + argument2.getTwo() + argument2.getTwo()));
        Assert.assertEquals(Long.valueOf(19), result);
    }

    @Test
    public void injectIntoInt() {
        RichIterable<ObjectIntPair<Integer>> objects = this.newWith(1, 2, 2, 3, 3, 4);
        int result = objects.injectInto(1, (int intParameter, ObjectIntPair<Integer> argument2) -> (int) (intParameter + argument2.getTwo() + argument2.getTwo()));
        Assert.assertEquals(19, result);
    }

    @Test
    public void injectIntoLong() {
        RichIterable<ObjectIntPair<Integer>> objects = this.newWith(1, 2, 2, 3, 3, 4);
        long result = objects.injectInto(1L, (long parameter, ObjectIntPair<Integer> argument2) -> (long) (parameter + argument2.getTwo() + argument2.getTwo()));
        Assert.assertEquals(19, result);
    }

    @Test
    public void injectIntoDouble() {
        RichIterable<ObjectIntPair<Integer>> objects = this.newWith(1, 2, 2, 3, 3, 4);
        double result = objects.injectInto(1.0, (double parameter, ObjectIntPair<Integer> argument2) -> (double) (parameter + argument2.getTwo() + argument2.getTwo()));
        Assert.assertEquals(19.0, result, 0.0);
    }

    @Test
    public void injectIntoFloat() {
        RichIterable<ObjectIntPair<Integer>> objects = this.newWith(1, 2, 2, 3, 3, 4);
        float result = objects.injectInto(1.0f, (float parameter, ObjectIntPair<Integer> argument2) -> (float) (parameter + argument2.getTwo() + argument2.getTwo()));
        Assert.assertEquals(19.0, result, 0.0);
    }

    @Test
    public void sumFloat() {
        RichIterable<ObjectIntPair<Integer>> objects = this.newWith(1, 2, 2, 3, 3, 4);
        double actual = objects.sumOfFloat(pair -> (float) (pair.getTwo() + pair.getTwo()));
        Assert.assertEquals(18.0, actual, 0.0);
    }

    @Test
    public void sumDouble() {
        RichIterable<ObjectIntPair<Integer>> objects = this.newWith(1, 2, 2, 3, 3, 4);
        double actual = objects.sumOfDouble(pair -> (double) (pair.getTwo() + pair.getTwo()));
        Assert.assertEquals(18.0, actual, 0.0);
    }

    @Test
    public void sumInteger() {
        RichIterable<ObjectIntPair<Integer>> objects = this.newWith(1, 2, 2, 3, 3, 4);
        long actual = objects.sumOfInt(pair -> (int) (pair.getTwo() + pair.getTwo()));
        Assert.assertEquals(18, actual);
    }

    @Test
    public void sumLong() {
        RichIterable<ObjectIntPair<Integer>> objects = this.newWith(1, 2, 2, 3, 3, 4);
        long actual = objects.sumOfLong(pair -> (long) (pair.getTwo() + pair.getTwo()));
        Assert.assertEquals(18, actual);
    }

    @Test
    public void toArray() {
        RichIterable<ObjectIntPair<Integer>> objects = this.newWith(1, 2, 2, 3, 3, 4);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        ObjectIntPair<Integer>[] array2 = objects.toArray(new ObjectIntPair[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition() {
        PartitionIterable<ObjectIntPair<Integer>> result = this.newWith(1, 2, 2, 3, 3, 4).partition(Predicates.equal(PrimitiveTuples.pair(Integer.valueOf(2), 3)));
        Verify.assertContains(PrimitiveTuples.pair(Integer.valueOf(2), 3), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair(Integer.valueOf(1), 2), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair(Integer.valueOf(3), 4), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void toList() {
        MutableList<ObjectIntPair<Integer>> list = this.newWith(1, 2, 2, 3, 3, 4).toList();
        Verify.assertContainsAll(list, PrimitiveTuples.pair(Integer.valueOf(1), 2), PrimitiveTuples.pair(Integer.valueOf(2), 3), PrimitiveTuples.pair(Integer.valueOf(3), 4));
    }

    @Test
    public void toBag() {
        MutableBag<ObjectIntPair<Integer>> bag = this.newWith(1, 2, 2, 3, 3, 4).toBag();
        Verify.assertContainsAll(bag, PrimitiveTuples.pair(Integer.valueOf(1), 2), PrimitiveTuples.pair(Integer.valueOf(2), 3), PrimitiveTuples.pair(Integer.valueOf(3), 4));
    }

    @Test
    public void toSortedList_natural_ordering() {
        RichIterable<ObjectIntPair<Integer>> pairs = this.newWith(5, 3, 1, 2, 2, 4);
        MutableList<ObjectIntPair<Integer>> list = pairs.toSortedList();
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(Integer.valueOf(1), 2), PrimitiveTuples.pair(Integer.valueOf(2), 4), PrimitiveTuples.pair(Integer.valueOf(5), 3)), list);
    }

    @Test
    public void toSortedList_with_comparator() {
        RichIterable<ObjectIntPair<Integer>> pairs = this.newWith(5, 3, 1, 2, 2, 4);
        MutableList<ObjectIntPair<Integer>> list = pairs.toSortedList(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(Integer.valueOf(5), 3), PrimitiveTuples.pair(Integer.valueOf(2), 4), PrimitiveTuples.pair(Integer.valueOf(1), 2)), list);
    }

    @Test
    public void toSortedListBy() {
        RichIterable<ObjectIntPair<Integer>> pairs = this.newWith(5, 3, 1, 2, 2, 4);
        MutableList<ObjectIntPair<Integer>> list = pairs.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(Integer.valueOf(1), 2), PrimitiveTuples.pair(Integer.valueOf(2), 4), PrimitiveTuples.pair(Integer.valueOf(5), 3)), list);
    }

    @Test
    public void toSortedBag_natural_ordering() {
        RichIterable<ObjectIntPair<Integer>> pairs = this.newWith(5, 3, 1, 2, 2, 4);
        MutableSortedBag<ObjectIntPair<Integer>> bag = pairs.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(Integer.valueOf(1), 2), PrimitiveTuples.pair(Integer.valueOf(2), 4), PrimitiveTuples.pair(Integer.valueOf(5), 3)), bag);
    }

    @Test
    public void toSortedBag_with_comparator() {
        RichIterable<ObjectIntPair<Integer>> pairs = this.newWith(5, 3, 1, 2, 2, 4);
        MutableSortedBag<ObjectIntPair<Integer>> bag = pairs.toSortedBag(Comparators.reverseNaturalOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair(Integer.valueOf(5), 3), PrimitiveTuples.pair(Integer.valueOf(2), 4), PrimitiveTuples.pair(Integer.valueOf(1), 2)), bag);
    }

    @Test
    public void toSortedBagBy() {
        RichIterable<ObjectIntPair<Integer>> pairs = this.newWith(5, 3, 1, 2, 2, 4);
        MutableSortedBag<ObjectIntPair<Integer>> bag = pairs.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(Integer.valueOf(1), 2), PrimitiveTuples.pair(Integer.valueOf(2), 4), PrimitiveTuples.pair(Integer.valueOf(5), 3)), bag);
    }

    @Test
    public void toSortedSet_natural_ordering() {
        RichIterable<ObjectIntPair<Integer>> pairs = this.newWith(5, 3, 1, 2, 2, 4);
        MutableSortedSet<ObjectIntPair<Integer>> set = pairs.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(Integer.valueOf(1), 2), PrimitiveTuples.pair(Integer.valueOf(2), 4), PrimitiveTuples.pair(Integer.valueOf(5), 3)), set);
    }

    @Test
    public void toSortedSet_with_comparator() {
        RichIterable<ObjectIntPair<Integer>> pairs = this.newWith(5, 3, 1, 2, 2, 4);
        MutableSortedSet<ObjectIntPair<Integer>> set = pairs.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair(Integer.valueOf(5), 3), PrimitiveTuples.pair(Integer.valueOf(2), 4), PrimitiveTuples.pair(Integer.valueOf(1), 2)), set);
    }

    @Test
    public void toSortedSetBy() {
        RichIterable<ObjectIntPair<Integer>> pairs = this.newWith(5, 3, 1, 2, 2, 4);
        MutableSortedSet<ObjectIntPair<Integer>> set = pairs.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(Integer.valueOf(1), 2), PrimitiveTuples.pair(Integer.valueOf(2), 4), PrimitiveTuples.pair(Integer.valueOf(5), 3)), set);
    }

    @Test
    public void toSet() {
        RichIterable<ObjectIntPair<Integer>> pairs = this.newWith(1, 2, 2, 3, 3, 4);
        MutableSet<ObjectIntPair<Integer>> set = pairs.toSet();
        Verify.assertContainsAll(set, PrimitiveTuples.pair(Integer.valueOf(1), 2), PrimitiveTuples.pair(Integer.valueOf(2), 3), PrimitiveTuples.pair(Integer.valueOf(3), 4));
    }

    @Test
    public void toMap() {
        RichIterable<ObjectIntPair<Integer>> pairs = this.newWith(1, 2, 2, 3, 3, 4);
        MutableMap<String, String> map = pairs.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMap() {
        RichIterable<ObjectIntPair<Integer>> pairs = this.newWith(1, 2, 2, 3, 3, 4);
        MutableSortedMap<String, String> map = pairs.toSortedMap(String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith("1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMap_with_comparator() {
        RichIterable<ObjectIntPair<Integer>> pairs = this.newWith(1, 2, 2, 3, 3, 4);
        MutableSortedMap<String, String> map = pairs.toSortedMap(Comparators.reverseNaturalOrder(), String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), "1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMapBy() {
        RichIterable<ObjectIntPair<Integer>> pairs = this.newWith(1, 2, 2, 3, 3, 4);
        MutableSortedMap<String, String> map = pairs.toSortedMapBy(String::valueOf, String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.naturalOrder(), "1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void testToString() {
        RichIterable<ObjectIntPair<Integer>> collection = this.newWith(1, 2, 2, 3);
        Assert.assertTrue("[1:2, 2:3]".equals(collection.toString()) || "[2:3, 1:2]".equals(collection.toString()));
    }

    @Test
    public void makeString() {
        RichIterable<ObjectIntPair<Integer>> collection = this.newWith(1, 2, 2, 3, 3, 4);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator() {
        RichIterable<ObjectIntPair<Integer>> collection = this.newWith(1, 2, 2, 3, 3, 4);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd() {
        RichIterable<ObjectIntPair<Integer>> collection = this.newWith(1, 2, 2, 3, 3, 4);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString() {
        RichIterable<ObjectIntPair<Integer>> collection = this.newWith(1, 2, 2, 3, 3, 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator() {
        RichIterable<ObjectIntPair<Integer>> collection = this.newWith(1, 2, 2, 3, 3, 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd() {
        RichIterable<ObjectIntPair<Integer>> collection = this.newWith(1, 2, 2, 3, 3, 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void groupBy() {
        RichIterable<ObjectIntPair<Integer>> collection = this.newWith(1, 2, 2, 3, 3, 4);
        Function<ObjectIntPair<Integer>, Boolean> function = pair -> PrimitiveTuples.pair(Integer.valueOf(1), 2).equals(pair);
        Multimap<Boolean, ObjectIntPair<Integer>> multimap = collection.groupBy(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(Integer.valueOf(1), 2)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(Integer.valueOf(2), 3)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(Integer.valueOf(3), 4)));
    }

    @Test
    public void groupByEach() {
        RichIterable<ObjectIntPair<Integer>> collection = this.newWith(1, 2, 2, 3, 3, 4);
        Function<ObjectIntPair<Integer>, MutableList<Boolean>> function = pair -> Lists.mutable.of(PrimitiveTuples.pair(Integer.valueOf(1), 2).equals(pair));
        Multimap<Boolean, ObjectIntPair<Integer>> multimap = collection.groupByEach(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(Integer.valueOf(1), 2)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(Integer.valueOf(2), 3)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(Integer.valueOf(3), 4)));
    }

    @Test
    public void zip() {
        RichIterable<ObjectIntPair<Integer>> collection = this.newWith(1, 2, 2, 3);
        RichIterable<Pair<ObjectIntPair<Integer>, Integer>> result = collection.zip(Interval.oneTo(5));
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(Integer.valueOf(1), 2), 1), Tuples.pair(PrimitiveTuples.pair(Integer.valueOf(2), 3), 2)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(Integer.valueOf(2), 3), 1), Tuples.pair(PrimitiveTuples.pair(Integer.valueOf(1), 2), 2)).equals(result.toBag()));
    }

    @Test
    public void zipWithIndex() {
        RichIterable<ObjectIntPair<Integer>> collection = this.newWith(1, 2, 2, 3);
        RichIterable<Pair<ObjectIntPair<Integer>, Integer>> result = collection.zipWithIndex();
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(Integer.valueOf(1), 2), 0), Tuples.pair(PrimitiveTuples.pair(Integer.valueOf(2), 3), 1)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(Integer.valueOf(2), 3), 0), Tuples.pair(PrimitiveTuples.pair(Integer.valueOf(1), 2), 1)).equals(result.toBag()));
    }

    @Test
    public void chunk() {
        RichIterable<ObjectIntPair<Integer>> collection = this.newWith(1, 2, 2, 3, 3, 4);
        Assert.assertEquals(Bags.immutable.of(FastList.newListWith(PrimitiveTuples.pair(Integer.valueOf(1), 2)), FastList.newListWith(PrimitiveTuples.pair(Integer.valueOf(2), 3)), FastList.newListWith(PrimitiveTuples.pair(Integer.valueOf(3), 4))), collection.chunk(1).toBag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        RichIterable<ObjectIntPair<Integer>> collection = this.newWith(1, 2, 2, 3, 3, 4);
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size() {
        RichIterable<ObjectIntPair<Integer>> collection = this.newWith(1, 2, 2, 3, 3, 4);
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
        RichIterable<ObjectIntPair<Integer>> notEmpty = this.newWith(1, 2);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating() {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, ObjectIntPair<Integer>> sumAggregator = (aggregate, pair) -> {
            aggregate.addAndGet((int) pair.getTwo());
        };
        RichIterable<ObjectIntPair<Integer>> collection = this.newWith(1, 2, 2, 3, 3, 4);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(4, aggregation.get("3:4").intValue());
        Assert.assertEquals(3, aggregation.get("2:3").intValue());
        Assert.assertEquals(2, aggregation.get("1:2").intValue());
    }

    @Test
    public void aggregateByNonMutating() {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, ObjectIntPair<Integer>, Integer> sumAggregator = (aggregate, pair) -> (int) (aggregate + pair.getTwo());
        RichIterable<ObjectIntPair<Integer>> collection = this.newWith(1, 1, 1, 2, 2, 3);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("2:3").intValue());
        Assert.assertEquals(2, aggregation.get("1:2").intValue());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractObjectIntMapKeyValuesViewTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractObjectIntMapKeyValuesViewTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectIntMapKeyValuesViewTestCase> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = AbstractObjectIntMapKeyValuesViewTestCase::containsAllIterable;
            this.payloads.containsAllArray = AbstractObjectIntMapKeyValuesViewTestCase::containsAllArray;
            this.payloads.forEach = AbstractObjectIntMapKeyValuesViewTestCase::forEach;
            this.payloads.forEachWith = AbstractObjectIntMapKeyValuesViewTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractObjectIntMapKeyValuesViewTestCase::forEachWithIndex;
            this.payloads.select = AbstractObjectIntMapKeyValuesViewTestCase::select;
            this.payloads.selectWith = AbstractObjectIntMapKeyValuesViewTestCase::selectWith;
            this.payloads.selectWith_target = AbstractObjectIntMapKeyValuesViewTestCase::selectWith_target;
            this.payloads.reject = AbstractObjectIntMapKeyValuesViewTestCase::reject;
            this.payloads.rejectWith = AbstractObjectIntMapKeyValuesViewTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractObjectIntMapKeyValuesViewTestCase::rejectWith_target;
            this.payloads.selectInstancesOf = AbstractObjectIntMapKeyValuesViewTestCase::selectInstancesOf;
            this.payloads.collect = AbstractObjectIntMapKeyValuesViewTestCase::collect;
            this.payloads.collectBoolean = AbstractObjectIntMapKeyValuesViewTestCase::collectBoolean;
            this.payloads.collectByte = AbstractObjectIntMapKeyValuesViewTestCase::collectByte;
            this.payloads.collectChar = AbstractObjectIntMapKeyValuesViewTestCase::collectChar;
            this.payloads.collectDouble = AbstractObjectIntMapKeyValuesViewTestCase::collectDouble;
            this.payloads.collectFloat = AbstractObjectIntMapKeyValuesViewTestCase::collectFloat;
            this.payloads.collectInt = AbstractObjectIntMapKeyValuesViewTestCase::collectInt;
            this.payloads.collectLong = AbstractObjectIntMapKeyValuesViewTestCase::collectLong;
            this.payloads.collectShort = AbstractObjectIntMapKeyValuesViewTestCase::collectShort;
            this.payloads.flatCollect = AbstractObjectIntMapKeyValuesViewTestCase::flatCollect;
            this.payloads.detect = AbstractObjectIntMapKeyValuesViewTestCase::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectIntMapKeyValuesViewTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectIntMapKeyValuesViewTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractObjectIntMapKeyValuesViewTestCase::min;
            this.payloads.max = AbstractObjectIntMapKeyValuesViewTestCase::max;
            this.payloads.min_without_comparator = AbstractObjectIntMapKeyValuesViewTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractObjectIntMapKeyValuesViewTestCase::max_without_comparator;
            this.payloads.minBy = AbstractObjectIntMapKeyValuesViewTestCase::minBy;
            this.payloads.maxBy = AbstractObjectIntMapKeyValuesViewTestCase::maxBy;
            this.payloads.detectWith = AbstractObjectIntMapKeyValuesViewTestCase::detectWith;
            this.payloads.detectIfNone = AbstractObjectIntMapKeyValuesViewTestCase::detectIfNone;
            this.payloads.detectWithIfNoneBlock = AbstractObjectIntMapKeyValuesViewTestCase::detectWithIfNoneBlock;
            this.payloads.allSatisfy = AbstractObjectIntMapKeyValuesViewTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractObjectIntMapKeyValuesViewTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractObjectIntMapKeyValuesViewTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractObjectIntMapKeyValuesViewTestCase::noneSatisfyWith;
            this.payloads.anySatisfy = AbstractObjectIntMapKeyValuesViewTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractObjectIntMapKeyValuesViewTestCase::anySatisfyWith;
            this.payloads.count = AbstractObjectIntMapKeyValuesViewTestCase::count;
            this.payloads.countWith = AbstractObjectIntMapKeyValuesViewTestCase::countWith;
            this.payloads.collectIf = AbstractObjectIntMapKeyValuesViewTestCase::collectIf;
            this.payloads.collectWith = AbstractObjectIntMapKeyValuesViewTestCase::collectWith;
            this.payloads.collectWith_target = AbstractObjectIntMapKeyValuesViewTestCase::collectWith_target;
            this.payloads.getFirst = AbstractObjectIntMapKeyValuesViewTestCase::getFirst;
            this.payloads.getLast = AbstractObjectIntMapKeyValuesViewTestCase::getLast;
            this.payloads.isEmpty = AbstractObjectIntMapKeyValuesViewTestCase::isEmpty;
            this.payloads.iterator = AbstractObjectIntMapKeyValuesViewTestCase::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectIntMapKeyValuesViewTestCase::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = AbstractObjectIntMapKeyValuesViewTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractObjectIntMapKeyValuesViewTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractObjectIntMapKeyValuesViewTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractObjectIntMapKeyValuesViewTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractObjectIntMapKeyValuesViewTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractObjectIntMapKeyValuesViewTestCase::sumFloat;
            this.payloads.sumDouble = AbstractObjectIntMapKeyValuesViewTestCase::sumDouble;
            this.payloads.sumInteger = AbstractObjectIntMapKeyValuesViewTestCase::sumInteger;
            this.payloads.sumLong = AbstractObjectIntMapKeyValuesViewTestCase::sumLong;
            this.payloads.toArray = AbstractObjectIntMapKeyValuesViewTestCase::toArray;
            this.payloads.partition = AbstractObjectIntMapKeyValuesViewTestCase::partition;
            this.payloads.toList = AbstractObjectIntMapKeyValuesViewTestCase::toList;
            this.payloads.toBag = AbstractObjectIntMapKeyValuesViewTestCase::toBag;
            this.payloads.toSortedList_natural_ordering = AbstractObjectIntMapKeyValuesViewTestCase::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = AbstractObjectIntMapKeyValuesViewTestCase::toSortedList_with_comparator;
            this.payloads.toSortedListBy = AbstractObjectIntMapKeyValuesViewTestCase::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = AbstractObjectIntMapKeyValuesViewTestCase::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = AbstractObjectIntMapKeyValuesViewTestCase::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = AbstractObjectIntMapKeyValuesViewTestCase::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = AbstractObjectIntMapKeyValuesViewTestCase::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = AbstractObjectIntMapKeyValuesViewTestCase::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractObjectIntMapKeyValuesViewTestCase::toSortedSetBy;
            this.payloads.toSet = AbstractObjectIntMapKeyValuesViewTestCase::toSet;
            this.payloads.toMap = AbstractObjectIntMapKeyValuesViewTestCase::toMap;
            this.payloads.toSortedMap = AbstractObjectIntMapKeyValuesViewTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractObjectIntMapKeyValuesViewTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractObjectIntMapKeyValuesViewTestCase::toSortedMapBy;
            this.payloads.testToString = AbstractObjectIntMapKeyValuesViewTestCase::testToString;
            this.payloads.makeString = AbstractObjectIntMapKeyValuesViewTestCase::makeString;
            this.payloads.makeStringWithSeparator = AbstractObjectIntMapKeyValuesViewTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = AbstractObjectIntMapKeyValuesViewTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = AbstractObjectIntMapKeyValuesViewTestCase::appendString;
            this.payloads.appendStringWithSeparator = AbstractObjectIntMapKeyValuesViewTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = AbstractObjectIntMapKeyValuesViewTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = AbstractObjectIntMapKeyValuesViewTestCase::groupBy;
            this.payloads.groupByEach = AbstractObjectIntMapKeyValuesViewTestCase::groupByEach;
            this.payloads.zip = AbstractObjectIntMapKeyValuesViewTestCase::zip;
            this.payloads.zipWithIndex = AbstractObjectIntMapKeyValuesViewTestCase::zipWithIndex;
            this.payloads.chunk = AbstractObjectIntMapKeyValuesViewTestCase::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectIntMapKeyValuesViewTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractObjectIntMapKeyValuesViewTestCase::chunk_large_size;
            this.payloads.empty = AbstractObjectIntMapKeyValuesViewTestCase::empty;
            this.payloads.notEmpty = AbstractObjectIntMapKeyValuesViewTestCase::notEmpty;
            this.payloads.aggregateByMutating = AbstractObjectIntMapKeyValuesViewTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractObjectIntMapKeyValuesViewTestCase::aggregateByNonMutating;
        }
    }
}
