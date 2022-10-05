/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.function.primitive.CharFunction;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MapIterable;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.map.primitive.ObjectDoubleMap;
import org.eclipse.collections.api.map.primitive.ObjectLongMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.multimap.MutableMultimap;
import org.eclipse.collections.api.multimap.set.MutableSetMultimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.IntegerWithCast;
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
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.factory.StringFunctions;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.block.function.NegativeIntervalFunction;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.sorted.mutable.TreeSortedMap;
import org.eclipse.collections.impl.math.IntegerSum;
import org.eclipse.collections.impl.math.Sum;
import org.eclipse.collections.impl.math.SumProcedure;
import org.eclipse.collections.impl.multimap.list.FastListMultimap;
import org.eclipse.collections.impl.multimap.set.UnifiedSetMultimap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;
import org.eclipse.collections.impl.string.immutable.CharAdapter;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iBag;
import static org.eclipse.collections.impl.factory.Iterables.iSet;

public abstract class MapIterableTestCase {

    protected abstract <K, V> MapIterable<K, V> newMap();

    protected abstract <K, V> MapIterable<K, V> newMapWithKeyValue(K key1, V value1);

    protected abstract <K, V> MapIterable<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2);

    protected abstract <K, V> MapIterable<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3);

    protected abstract <K, V> MapIterable<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4);

    @Test
    public void stream() {
        MapIterable<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        Assert.assertEquals("123", CharAdapter.adapt(map.stream().reduce("", (r, s) -> r + s)).toSortedList().makeString(""));
        Assert.assertEquals(map.reduce((r, s) -> r + s), map.stream().reduce((r, s) -> r + s));
    }

    @Test
    public void parallelStream() {
        MapIterable<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        Assert.assertEquals("123", CharAdapter.adapt(map.stream().reduce("", (r, s) -> r + s)).toSortedList().makeString(""));
        Assert.assertEquals(map.reduce((r, s) -> r + s), map.stream().reduce((r, s) -> r + s));
    }

    @Test
    public void equalsAndHashCode() {
        MapIterable<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        Verify.assertPostSerializedEqualsAndHashCode(map);
        Verify.assertEqualsAndHashCode(Maps.mutable.of(1, "1", 2, "2", 3, "3"), map);
        Verify.assertEqualsAndHashCode(Maps.immutable.of(1, "1", 2, "2", 3, "3"), map);
        Assert.assertNotEquals(map, this.newMapWithKeysValues(1, "1", 2, "2"));
        Assert.assertNotEquals(map, this.newMapWithKeysValues(1, "1", 2, "2", 3, "3", 4, "4"));
        Assert.assertNotEquals(map, this.newMapWithKeysValues(1, "1", 2, "2", 4, "4"));
        Verify.assertEqualsAndHashCode(Maps.immutable.with(1, "1", 2, "2", 3, null), this.newMapWithKeysValues(1, "1", 2, "2", 3, null));
    }

    @Test
    public void serialization() {
        MapIterable<Integer, String> original = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        MapIterable<Integer, String> copy = SerializeTestHelper.serializeDeserialize(original);
        Verify.assertIterableSize(3, copy);
        Assert.assertEquals(original, copy);
    }

    @Test
    public void isEmpty() {
        Assert.assertFalse(this.newMapWithKeysValues(1, "1", 2, "2").isEmpty());
        Assert.assertTrue(this.newMap().isEmpty());
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.newMap().notEmpty());
        Assert.assertTrue(this.newMapWithKeysValues(1, "1", 2, "2").notEmpty());
    }

    @Test
    public void ifPresentApply() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2);
        Assert.assertEquals("1", map.ifPresentApply("1", String::valueOf));
        Assert.assertNull(map.ifPresentApply("3", String::valueOf));
    }

    @Test
    public void getIfAbsent_function() {
        MapIterable<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        Assert.assertNull(map.get(4));
        Assert.assertEquals("1", map.getIfAbsent(1, new PassThruFunction0<>("4")));
        Assert.assertEquals("4", map.getIfAbsent(4, new PassThruFunction0<>("4")));
        Assert.assertEquals("3", map.getIfAbsent(3, new PassThruFunction0<>("3")));
        Assert.assertNull(map.get(4));
    }

    @Test
    public void getOrDefault() {
        MapIterable<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        Assert.assertNull(map.get(4));
        Assert.assertEquals("1", map.getOrDefault(1, "4"));
        Assert.assertEquals("4", map.getOrDefault(4, "4"));
        Assert.assertEquals("3", map.getOrDefault(3, "3"));
        Assert.assertNull(map.get(4));
    }

    @Test
    public void getIfAbsent() {
        MapIterable<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        Assert.assertNull(map.get(4));
        Assert.assertEquals("1", map.getIfAbsentValue(1, "4"));
        Assert.assertEquals("4", map.getIfAbsentValue(4, "4"));
        Assert.assertEquals("3", map.getIfAbsentValue(3, "3"));
        Assert.assertNull(map.get(4));
    }

    @Test
    public void getIfAbsentWith() {
        MapIterable<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        Assert.assertNull(map.get(4));
        Assert.assertEquals("1", map.getIfAbsentWith(1, String::valueOf, 4));
        Assert.assertEquals("4", map.getIfAbsentWith(4, String::valueOf, 4));
        Assert.assertEquals("3", map.getIfAbsentWith(3, String::valueOf, 3));
        Assert.assertNull(map.get(4));
    }

    @Test
    public void tap() {
        MutableList<String> tapResult = Lists.mutable.of();
        MapIterable<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two", 3, "Three", 4, "Four");
        Assert.assertSame(map, map.tap(tapResult::add));
        Assert.assertEquals(tapResult.toList(), tapResult);
    }

    @Test
    public void forEach() {
        MutableBag<String> result = Bags.mutable.of();
        MapIterable<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two", 3, "Three", 4, "Four");
        map.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(Bags.mutable.of("One", "Two", "Three", "Four"), result);
    }

    @Test
    public void forEachWith() {
        MutableList<Integer> result = Lists.mutable.of();
        MapIterable<Integer, Integer> map = this.newMapWithKeysValues(-1, 1, -2, 2, -3, 3, -4, 4);
        map.forEachWith((argument1, argument2) -> result.add(argument1 + argument2), 10);
        Verify.assertSize(4, result);
        Verify.assertContainsAll(result, 11, 12, 13, 14);
    }

    @Test
    public void forEachWithIndex() {
        MutableList<String> result = Lists.mutable.of();
        MapIterable<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two", 3, "Three", 4, "Four");
        map.forEachWithIndex((value, index) -> {
            result.add(value);
            result.add(String.valueOf(index));
        });
        Verify.assertSize(8, result);
        Verify.assertContainsAll(result, // Map values
        "One", // Map values
        "Two", // Map values
        "Three", // Map values
        "Four", "0", "1", "2", // Stringified index values
        "3");
    }

    @Test
    public void forEachKey() {
        UnifiedSet<Integer> result = UnifiedSet.newSet();
        MapIterable<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        map.forEachKey(CollectionAddProcedure.on(result));
        Verify.assertSetsEqual(UnifiedSet.newSetWith(1, 2, 3), result);
    }

    @Test
    public void forEachValue() {
        UnifiedSet<String> result = UnifiedSet.newSet();
        MapIterable<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        map.forEachValue(CollectionAddProcedure.on(result));
        Verify.assertSetsEqual(UnifiedSet.newSetWith("1", "2", "3"), result);
    }

    @Test
    public void forEachKeyValue() {
        UnifiedMap<Integer, String> result = UnifiedMap.newMap();
        MapIterable<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        map.forEachKeyValue(result::put);
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, "1", 2, "2", 3, "3"), result);
        MutableBag<String> result2 = Bags.mutable.of();
        MapIterable<Integer, String> map2 = this.newMapWithKeysValues(1, "One", 2, "Two", 3, "Three");
        map2.forEachKeyValue((key, value) -> result2.add(key + value));
        Assert.assertEquals(Bags.mutable.of("1One", "2Two", "3Three"), result2);
    }

    @Test
    public void injectIntoKeyValue() {
        MapIterable<Integer, Integer> map1 = this.newMapWithKeysValues(3, 3, 2, 2, 1, 1);
        Integer sum1 = map1.injectIntoKeyValue(0, (sum, key, value) -> sum + key + value);
        Assert.assertEquals(Integer.valueOf(12), sum1);
        MutableMap<Integer, String> result = map1.injectIntoKeyValue(Maps.mutable.empty(), (map, key, value) -> map.withKeyValue(key, value.toString()));
        Assert.assertEquals(Maps.mutable.with(3, "3", 2, "2", 1, "1"), result);
    }

    @Test
    public void flipUniqueValues() {
        MapIterable<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        MapIterable<String, Integer> result = map.flipUniqueValues();
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1", 1, "2", 2, "3", 3), result);
        Assert.assertThrows(IllegalStateException.class, () -> this.newMapWithKeysValues(1, "2", 2, "2").flipUniqueValues());
    }

    @Test
    public void collectMap() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        MapIterable<Integer, String> actual = map.collect((Function2<String, String, Pair<Integer, String>>) (argument1, argument2) -> Tuples.pair(Integer.valueOf(argument1), argument1 + ':' + new StringBuilder(argument2).reverse()));
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, "1:enO", 2, "2:owT", 3, "3:eerhT"), actual);
    }

    @Test
    public void collectBoolean() {
        MapIterable<String, String> map = this.newMapWithKeysValues("One", "true", "Two", "nah", "Three", "TrUe");
        BooleanIterable actual = map.collectBoolean(Boolean::parseBoolean);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, true), actual.toBag());
    }

    @Test
    public void collectBooleanWithTarget() {
        BooleanHashBag target = new BooleanHashBag();
        MapIterable<String, String> map = this.newMapWithKeysValues("One", "true", "Two", "nah", "Three", "TrUe");
        BooleanHashBag result = map.collectBoolean(Boolean::parseBoolean, target);
        Assert.assertSame("Target sent as parameter not returned", target, result);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, true), result.toBag());
    }

    @Test
    public void collectByte() {
        MapIterable<String, String> map = this.newMapWithKeysValues("One", "1", "Two", "2", "Three", "3");
        ByteIterable actual = map.collectByte(Byte::parseByte);
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), actual.toBag());
    }

    @Test
    public void collectByteWithTarget() {
        ByteHashBag target = new ByteHashBag();
        MapIterable<String, String> map = this.newMapWithKeysValues("One", "1", "Two", "2", "Three", "3");
        ByteHashBag result = map.collectByte(Byte::parseByte, target);
        Assert.assertSame("Target sent as parameter not returned", target, result);
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), result.toBag());
    }

    @Test
    public void collectChar() {
        MapIterable<String, String> map = this.newMapWithKeysValues("One", "A1", "Two", "B", "Three", "C#++");
        CharIterable actual = map.collectChar((CharFunction<String>) string -> string.charAt(0));
        Assert.assertEquals(CharHashBag.newBagWith('A', 'B', 'C'), actual.toBag());
    }

    @Test
    public void collectCharWithTarget() {
        CharHashBag target = new CharHashBag();
        MapIterable<String, String> map = this.newMapWithKeysValues("One", "A1", "Two", "B", "Three", "C#++");
        CharHashBag result = map.collectChar((CharFunction<String>) string -> string.charAt(0), target);
        Assert.assertSame("Target sent as parameter not returned", target, result);
        Assert.assertEquals(CharHashBag.newBagWith('A', 'B', 'C'), result.toBag());
    }

    @Test
    public void collectDouble() {
        MapIterable<String, String> map = this.newMapWithKeysValues("One", "1", "Two", "2", "Three", "3");
        DoubleIterable actual = map.collectDouble(Double::parseDouble);
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0d, 2.0d, 3.0d), actual.toBag());
    }

    @Test
    public void collectDoubleWithTarget() {
        DoubleHashBag target = new DoubleHashBag();
        MapIterable<String, String> map = this.newMapWithKeysValues("One", "1", "Two", "2", "Three", "3");
        DoubleHashBag result = map.collectDouble(Double::parseDouble, target);
        Assert.assertSame("Target sent as parameter not returned", target, result);
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0d, 2.0d, 3.0d), result.toBag());
    }

    @Test
    public void collectFloat() {
        MapIterable<String, String> map = this.newMapWithKeysValues("One", "1", "Two", "2", "Three", "3");
        FloatIterable actual = map.collectFloat(Float::parseFloat);
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), actual.toBag());
    }

    @Test
    public void collectFloatWithTarget() {
        FloatHashBag target = new FloatHashBag();
        MapIterable<String, String> map = this.newMapWithKeysValues("One", "1", "Two", "2", "Three", "3");
        FloatHashBag result = map.collectFloat(Float::parseFloat, target);
        Assert.assertSame("Target sent as parameter not returned", target, result);
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), result.toBag());
    }

    @Test
    public void collectInt() {
        MapIterable<String, String> map = this.newMapWithKeysValues("One", "1", "Two", "2", "Three", "3");
        IntIterable actual = map.collectInt(Integer::parseInt);
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), actual.toBag());
    }

    @Test
    public void collectIntWithTarget() {
        IntHashBag target = new IntHashBag();
        MapIterable<String, String> map = this.newMapWithKeysValues("One", "1", "Two", "2", "Three", "3");
        IntHashBag result = map.collectInt(Integer::parseInt, target);
        Assert.assertSame("Target sent as parameter not returned", target, result);
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), result.toBag());
    }

    @Test
    public void collectLong() {
        MapIterable<String, String> map = this.newMapWithKeysValues("One", "1", "Two", "2", "Three", "3");
        LongIterable actual = map.collectLong(Long::parseLong);
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), actual.toBag());
    }

    @Test
    public void collectLongWithTarget() {
        LongHashBag target = new LongHashBag();
        MapIterable<String, String> map = this.newMapWithKeysValues("One", "1", "Two", "2", "Three", "3");
        LongHashBag result = map.collectLong(Long::parseLong, target);
        Assert.assertSame("Target sent as parameter not returned", target, result);
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort() {
        MapIterable<String, String> map = this.newMapWithKeysValues("One", "1", "Two", "2", "Three", "3");
        ShortIterable actual = map.collectShort(Short::parseShort);
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), actual.toBag());
    }

    @Test
    public void collectShortWithTarget() {
        ShortHashBag target = new ShortHashBag();
        MapIterable<String, String> map = this.newMapWithKeysValues("One", "1", "Two", "2", "Three", "3");
        ShortHashBag result = map.collectShort(Short::parseShort, target);
        Assert.assertSame("Target sent as parameter not returned", target, result);
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), result.toBag());
    }

    @Test
    public void collectValues() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        MapIterable<String, String> actual = map.collectValues((argument1, argument2) -> new StringBuilder(argument2).reverse().toString());
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1", "enO", "2", "owT", "3", "eerhT"), actual);
    }

    @Test
    public void select() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        RichIterable<String> actual = map.select("Two"::equals);
        Assert.assertEquals(HashBag.newBagWith("Two"), actual.toBag());
    }

    @Test
    public void selectWith() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        RichIterable<String> actual = map.selectWith(Object::equals, "Two");
        Assert.assertEquals(HashBag.newBagWith("Two"), actual.toBag());
    }

    @Test
    public void reject() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        RichIterable<String> actual = map.reject("Two"::equals);
        Assert.assertEquals(HashBag.newBagWith("One", "Three"), actual.toBag());
    }

    @Test
    public void rejectWith() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        RichIterable<String> actual = map.rejectWith(Object::equals, "Two");
        Assert.assertEquals(HashBag.newBagWith("One", "Three"), actual.toBag());
    }

    @Test
    public void collect() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        RichIterable<String> actual = map.collect(StringFunctions.toLowerCase());
        Assert.assertEquals(HashBag.newBagWith("one", "two", "three"), actual.toBag());
    }

    @Test
    public void flatCollect() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "1", "2", "2", "3", "3", "4", "4");
        Function<String, MutableList<String>> function = Lists.mutable::with;
        Verify.assertListsEqual(Lists.mutable.with("1", "2", "3", "4"), map.flatCollect(function).toSortedList());
        Verify.assertSetsEqual(UnifiedSet.newSetWith("1", "2", "3", "4"), map.flatCollect(function, UnifiedSet.newSet()));
    }

    @Test
    public void flatCollectWith() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("4", 4, "5", 5, "6", 6, "7", 7);
        Verify.assertSetsEqual(Sets.mutable.with(1, 2, 3, 4, 5, 6, 7), map.flatCollectWith(Interval::fromTo, 1).toSet());
        Verify.assertBagsEqual(Bags.mutable.with(4, 3, 2, 1, 5, 4, 3, 2, 1, 6, 5, 4, 3, 2, 1, 7, 6, 5, 4, 3, 2, 1), map.flatCollectWith(Interval::fromTo, 1, Bags.mutable.empty()));
    }

    @Test
    public void selectMap() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        MapIterable<String, String> actual = map.select((argument1, argument2) -> "1".equals(argument1) || "Two".equals(argument2));
        Assert.assertEquals(2, actual.size());
        Assert.assertTrue(actual.keysView().containsAllArguments("1", "2"));
        Assert.assertTrue(actual.valuesView().containsAllArguments("One", "Two"));
    }

    @Test
    public void rejectMap() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        MapIterable<String, String> actual = map.reject((argument1, argument2) -> "1".equals(argument1) || "Two".equals(argument2));
        Assert.assertEquals(UnifiedMap.newWithKeysValues("3", "Three"), actual);
    }

    @Test
    public void flip() {
        Verify.assertEmpty(this.newMap().flip());
        MutableSetMultimap<String, String> expected = UnifiedSetMultimap.newMultimap();
        expected.put("odd", "One");
        expected.put("even", "Two");
        expected.put("odd", "Three");
        expected.put("even", "Four");
        Assert.assertEquals(expected, this.newMapWithKeysValues("One", "odd", "Two", "even", "Three", "odd", "Four", "even").flip());
    }

    @Test
    public void detect() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        Pair<String, String> one = map.detect((argument1, argument2) -> "1".equals(argument1));
        Assert.assertNotNull(one);
        Assert.assertEquals("1", one.getOne());
        Assert.assertEquals("One", one.getTwo());
        Pair<String, String> two = map.detect((argument1, argument2) -> "Two".equals(argument2));
        Assert.assertNotNull(two);
        Assert.assertEquals("2", two.getOne());
        Assert.assertEquals("Two", two.getTwo());
        Assert.assertNull(map.detect((ignored1, ignored2) -> false));
    }

    @Test
    public void detectOptional() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        Pair<String, String> one = map.detectOptional((argument1, argument2) -> "1".equals(argument1)).get();
        Assert.assertNotNull(one);
        Assert.assertEquals("1", one.getOne());
        Assert.assertEquals("One", one.getTwo());
        Pair<String, String> two = map.detectOptional((argument1, argument2) -> "Two".equals(argument2)).get();
        Assert.assertNotNull(two);
        Assert.assertEquals("2", two.getOne());
        Assert.assertEquals("Two", two.getTwo());
        Assert.assertFalse(map.detectOptional((ignored1, ignored2) -> false).isPresent());
    }

    @Test
    public void anySatisfy() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        Verify.assertAnySatisfy((Map<String, String>) map, String.class::isInstance);
        Assert.assertFalse(map.anySatisfy("Monkey"::equals));
    }

    @Test
    public void anySatisfyWith() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        Assert.assertTrue(map.anySatisfyWith(Predicates2.instanceOf(), String.class));
        Assert.assertFalse(map.anySatisfyWith(Object::equals, "Monkey"));
    }

    @Test
    public void allSatisfy() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        Verify.assertAllSatisfy((Map<String, String>) map, String.class::isInstance);
        Assert.assertFalse(map.allSatisfy("Monkey"::equals));
    }

    @Test
    public void allSatisfyWith() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        Assert.assertTrue(map.allSatisfyWith(Predicates2.instanceOf(), String.class));
        Assert.assertFalse(map.allSatisfyWith(Object::equals, "Monkey"));
    }

    @Test
    public void noneSatisfy() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        Verify.assertNoneSatisfy((Map<String, String>) map, Integer.class::isInstance);
        Assert.assertTrue(map.noneSatisfy("Monkey"::equals));
        Assert.assertFalse(map.noneSatisfy("Two"::equals));
    }

    @Test
    public void noneSatisfyWith() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        Assert.assertTrue(map.noneSatisfyWith(Predicates2.instanceOf(), Integer.class));
        Assert.assertTrue(map.noneSatisfyWith(Object::equals, "Monkey"));
        Assert.assertFalse(map.noneSatisfyWith(Object::equals, "Two"));
    }

    @Test
    public void appendString() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        StringBuilder builder1 = new StringBuilder();
        map.appendString(builder1);
        String defaultString = builder1.toString();
        Assert.assertEquals(15, defaultString.length());
        StringBuilder builder2 = new StringBuilder();
        map.appendString(builder2, "|");
        String delimitedString = builder2.toString();
        Assert.assertEquals(13, delimitedString.length());
        Verify.assertContains("|", delimitedString);
        StringBuilder builder3 = new StringBuilder();
        map.appendString(builder3, "{", "|", "}");
        String wrappedString = builder3.toString();
        Assert.assertEquals(15, wrappedString.length());
        Verify.assertContains("|", wrappedString);
        Assert.assertTrue(wrappedString.startsWith("{"));
        Assert.assertTrue(wrappedString.endsWith("}"));
    }

    @Test
    public void toBag() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        MutableBag<String> bag = map.toBag();
        Assert.assertEquals(Bags.mutable.of("One", "Two", "Three"), bag);
    }

    @Test
    public void toSortedBag() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        MutableSortedBag<Integer> sorted = map.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(1, 2, 3, 4), sorted);
        MutableSortedBag<Integer> reverse = map.toSortedBag(Collections.reverseOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 1, 2, 3, 4), reverse);
    }

    @Test
    public void toSortedBagBy() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        MutableSortedBag<Integer> sorted = map.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(1, 2, 3, 4), sorted);
    }

    @Test
    public void asLazy() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        LazyIterable<String> lazy = map.asLazy();
        Verify.assertContainsAll(lazy.toList(), "One", "Two", "Three");
    }

    @Test
    public void toList() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        MutableList<String> list = map.toList();
        Verify.assertContainsAll(list, "One", "Two", "Three");
    }

    @Test
    public void toMap() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "3", "Three", "4", "Four");
        MapIterable<Integer, String> actual = map.toMap(String::length, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues(3, "One", 5, "Three", 4, "Four"), actual);
    }

    @Test
    public void toSet() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        MutableSet<String> set = map.toSet();
        Verify.assertContainsAll(set, "One", "Two", "Three");
    }

    @Test
    public void toSortedList() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        MutableList<Integer> sorted = map.toSortedList();
        Assert.assertEquals(FastList.newListWith(1, 2, 3, 4), sorted);
        MutableList<Integer> reverse = map.toSortedList(Collections.reverseOrder());
        Assert.assertEquals(FastList.newListWith(4, 3, 2, 1), reverse);
    }

    @Test
    public void toSortedListBy() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        MutableList<Integer> list = map.toSortedListBy(String::valueOf);
        Assert.assertEquals(FastList.newListWith(1, 2, 3, 4), list);
    }

    @Test
    public void toSortedSet() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        MutableSortedSet<Integer> sorted = map.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(1, 2, 3, 4), sorted);
        MutableSortedSet<Integer> reverse = map.toSortedSet(Collections.reverseOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), 1, 2, 3, 4), reverse);
    }

    @Test
    public void toSortedSetBy() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        MutableSortedSet<Integer> sorted = map.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(1, 2, 3, 4), sorted);
    }

    @Test
    public void toSortedMap() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "3", "Three", "4", "Four");
        MapIterable<Integer, String> actual = map.toSortedMap(String::length, String::valueOf);
        MapIterable<Integer, String> actualWithComparator = map.toSortedMap(Comparators.reverseNaturalOrder(), String::length, String::valueOf);
        MapIterable<Integer, String> actualWithFunction = map.toSortedMapBy(key -> -key, String::length, String::valueOf);
        Verify.assertIterablesEqual(TreeSortedMap.newMapWith(3, "One", 5, "Three", 4, "Four"), actual);
        TreeSortedMap<Object, Object> expectedIterable = TreeSortedMap.newMap(Comparators.reverseNaturalOrder());
        expectedIterable.put(3, "One");
        expectedIterable.put(5, "Three");
        expectedIterable.put(4, "Four");
        Verify.assertIterablesEqual(expectedIterable, actualWithComparator);
        Verify.assertIterablesEqual(expectedIterable, actualWithFunction);
    }

    @Test
    public void chunk() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        RichIterable<RichIterable<String>> chunks = map.chunk(2).toList();
        RichIterable<Integer> sizes = chunks.collect(RichIterable::size);
        Assert.assertEquals(FastList.newListWith(2, 1), sizes);
    }

    @Test
    public void collect_value() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        Verify.assertContainsAll(map.collect(Functions.getToString()).toSet(), "1", "2", "3", "4");
        Verify.assertContainsAll(map.collect(String::valueOf, UnifiedSet.newSet()), "1", "2", "3", "4");
    }

    @Test
    public void collectIf() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        Bag<String> odd = map.collectIf(IntegerPredicates.isOdd(), Functions.getToString()).toBag();
        Assert.assertEquals(Bags.mutable.of("1", "3"), odd);
        Bag<String> even = map.collectIf(IntegerPredicates.isEven(), String::valueOf, HashBag.newBag());
        Assert.assertEquals(Bags.mutable.of("2", "4"), even);
    }

    @Test
    public void collectWith() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        RichIterable<Integer> actual = map.collectWith(AddFunction.INTEGER, 1);
        Verify.assertContainsAll(actual, 2, 3, 4, 5);
    }

    @Test
    public void collectWithToTarget() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        FastList<Integer> actual = map.collectWith(AddFunction.INTEGER, 1, FastList.newList());
        Verify.assertContainsAll(actual, 2, 3, 4, 5);
    }

    @Test
    public void contains() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        Assert.assertTrue(map.contains("Two"));
    }

    @Test
    public void containsAnyIterable() {
        RichIterable<Integer> collection = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        Assert.assertTrue(collection.containsAnyIterable(Lists.mutable.with(0, 1)));
        Assert.assertTrue(collection.containsAnyIterable(Arrays.asList(0, 1)));
        Assert.assertFalse(collection.containsAnyIterable(Lists.mutable.with(5, 6)));
        Assert.assertFalse(collection.containsAnyIterable(Arrays.asList(5, 6)));
        Assert.assertTrue(collection.containsAnyIterable(Interval.oneTo(100)));
        Assert.assertFalse(collection.containsAnyIterable(Interval.fromTo(5, 100)));
        Assert.assertTrue(Interval.oneTo(100).containsAnyIterable(collection));
        Assert.assertFalse(Interval.fromTo(5, 100).containsAnyIterable(collection));
    }

    @Test
    public void containsNoneIterable() {
        RichIterable<Integer> collection = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        Assert.assertTrue(collection.containsNoneIterable(Lists.mutable.with(0, 5, 6, 7)));
        Assert.assertTrue(collection.containsNoneIterable(Arrays.asList(0, 5, 6, 7)));
        Assert.assertFalse(collection.containsNoneIterable(Lists.mutable.with(0, 1, 5, 6)));
        Assert.assertFalse(collection.containsNoneIterable(Arrays.asList(0, 1, 5, 6)));
        Assert.assertFalse(collection.containsNoneIterable(Interval.oneTo(100)));
        Assert.assertTrue(collection.containsNoneIterable(Interval.fromTo(5, 100)));
        Assert.assertFalse(Interval.oneTo(100).containsNoneIterable(collection));
        Assert.assertTrue(Interval.fromTo(5, 100).containsNoneIterable(collection));
    }

    @Test
    public void containsAnyCollection() {
        RichIterable<Integer> collection = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        Assert.assertTrue(collection.containsAny(Lists.mutable.with(0, 1)));
        Assert.assertTrue(collection.containsAny(Arrays.asList(0, 1)));
        Assert.assertFalse(collection.containsAny(Lists.mutable.with(5, 6)));
        Assert.assertFalse(collection.containsAny(Arrays.asList(5, 6)));
        Assert.assertTrue(collection.containsAny(Interval.oneTo(100)));
        Assert.assertFalse(collection.containsAny(Interval.fromTo(5, 100)));
    }

    @Test
    public void containsNoneCollection() {
        RichIterable<Integer> collection = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        Assert.assertTrue(collection.containsNone(Lists.mutable.with(0, 5, 6, 7)));
        Assert.assertTrue(collection.containsNone(Arrays.asList(0, 5, 6, 7)));
        Assert.assertFalse(collection.containsNone(Lists.mutable.with(0, 1, 5, 6)));
        Assert.assertFalse(collection.containsNone(Arrays.asList(0, 1, 5, 6)));
        Assert.assertFalse(collection.containsNone(Interval.oneTo(100)));
        Assert.assertTrue(collection.containsNone(Interval.fromTo(5, 100)));
    }

    @Test
    public void containsAll() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        Assert.assertTrue(map.containsAll(FastList.newListWith("One", "Two")));
        Assert.assertTrue(map.containsAll(FastList.newListWith("One", "Two", "Three")));
        Assert.assertFalse(map.containsAll(FastList.newListWith("One", "Two", "Three", "Four")));
    }

    @Test
    public void containsKey() {
        MapIterable<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        Assert.assertTrue(map.containsKey(1));
        Assert.assertFalse(map.containsKey(4));
    }

    @Test
    public void containsValue() {
        MapIterable<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        Assert.assertTrue(map.containsValue("1"));
        Assert.assertFalse(map.containsValue("4"));
        MapIterable<Integer, String> map2 = this.newMapWithKeysValues(3, "1", 2, "2", 1, "3");
        Assert.assertTrue(map2.containsValue("1"));
        Assert.assertFalse(map2.containsValue("4"));
    }

    @Test
    public void getFirst() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        String value = map.getFirst();
        Assert.assertNotNull(value);
        Assert.assertTrue(value, map.valuesView().contains(value));
        Assert.assertNull(this.newMap().getFirst());
    }

    @Test
    public void getLast() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        String value = map.getLast();
        Assert.assertNotNull(value);
        Assert.assertTrue(value, map.valuesView().contains(value));
        Assert.assertNull(this.newMap().getLast());
    }

    @Test
    public void getOnly() {
        MapIterable<String, String> map = this.newMapWithKeyValue("1", "One");
        Assert.assertEquals("One", map.getOnly());
    }

    @Test(expected = IllegalStateException.class)
    public void getOnly_throws_when_empty() {
        this.newMap().getOnly();
    }

    @Test(expected = IllegalStateException.class)
    public void getOnly_throws_when_multiple_values() {
        this.newMapWithKeysValues("1", "One", "2", "Two").getOnly();
    }

    @Test
    public void containsAllIterable() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        Assert.assertTrue(map.containsAllIterable(FastList.newListWith("One", "Two")));
        Assert.assertFalse(map.containsAllIterable(FastList.newListWith("One", "Four")));
    }

    @Test
    public void containsAllArguments() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        Assert.assertTrue(map.containsAllArguments("One", "Two"));
        Assert.assertFalse(map.containsAllArguments("One", "Four"));
    }

    @Test
    public void count() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        int actual = map.count(Predicates.or("One"::equals, "Three"::equals));
        Assert.assertEquals(2, actual);
    }

    @Test
    public void countWith() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        int actual = map.countWith(Object::equals, "One");
        Assert.assertEquals(1, actual);
    }

    @Test
    public void detect_value() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        String resultFound = map.detect("One"::equals);
        Assert.assertEquals("One", resultFound);
        String resultNotFound = map.detect("Four"::equals);
        Assert.assertNull(resultNotFound);
    }

    @Test
    public void detectOptional_value() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        String resultFound = map.detectOptional("One"::equals).get();
        Assert.assertEquals("One", resultFound);
        Assert.assertFalse(map.detectOptional("Four"::equals).isPresent());
    }

    @Test
    public void detectWith() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        String resultFound = map.detectWith(Object::equals, "One");
        Assert.assertEquals("One", resultFound);
        String resultNotFound = map.detectWith(Object::equals, "Four");
        Assert.assertNull(resultNotFound);
    }

    @Test
    public void detectWithOptional() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        String resultFound = map.detectWithOptional(Object::equals, "One").get();
        Assert.assertEquals("One", resultFound);
        Assert.assertFalse(map.detectWithOptional(Object::equals, "Four").isPresent());
    }

    @Test
    public void detectIfNone_value() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        String resultNotFound = map.detectIfNone("Four"::equals, () -> "Zero");
        Assert.assertEquals("Zero", resultNotFound);
        String resultFound = map.detectIfNone("One"::equals, () -> "Zero");
        Assert.assertEquals("One", resultFound);
    }

    @Test
    public void detectWithIfNone() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        String resultNotFound = map.detectWithIfNone(Object::equals, "Four", () -> "Zero");
        Assert.assertEquals("Zero", resultNotFound);
        String resultFound = map.detectWithIfNone(Object::equals, "One", () -> "Zero");
        Assert.assertEquals("One", resultFound);
    }

    @Test
    public void flatten_value() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two");
        Function<String, Iterable<Character>> function = object -> {
            MutableList<Character> result = Lists.mutable.of();
            char[] chars = object.toCharArray();
            for (char aChar : chars) {
                result.add(Character.valueOf(aChar));
            }
            return result;
        };
        RichIterable<Character> blob = map.flatCollect(function);
        Assert.assertTrue(blob.containsAllArguments(Character.valueOf('O'), Character.valueOf('n'), Character.valueOf('e'), Character.valueOf('T'), Character.valueOf('w'), Character.valueOf('o')));
        RichIterable<Character> blobFromTarget = map.flatCollect(function, FastList.newList());
        Assert.assertTrue(blobFromTarget.containsAllArguments(Character.valueOf('O'), Character.valueOf('n'), Character.valueOf('e'), Character.valueOf('T'), Character.valueOf('w'), Character.valueOf('o')));
    }

    /**
     * @since 9.0
     */
    @Test
    public void countBy() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        Bag<Integer> evensAndOdds = map.countBy(each -> Integer.valueOf(each % 2));
        Assert.assertEquals(2, evensAndOdds.occurrencesOf(1));
        Assert.assertEquals(2, evensAndOdds.occurrencesOf(0));
        Bag<Integer> evensAndOdds2 = map.countBy(each -> Integer.valueOf(each % 2), Bags.mutable.empty());
        Assert.assertEquals(2, evensAndOdds2.occurrencesOf(1));
        Assert.assertEquals(2, evensAndOdds2.occurrencesOf(0));
    }

    /**
     * @since 9.0
     */
    @Test
    public void countByWith() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        Bag<Integer> evensAndOdds = map.countByWith((each, parm) -> Integer.valueOf(each % parm), 2);
        Assert.assertEquals(2, evensAndOdds.occurrencesOf(1));
        Assert.assertEquals(2, evensAndOdds.occurrencesOf(0));
        Bag<Integer> evensAndOdds2 = map.countByWith((each, parm) -> Integer.valueOf(each % parm), 2, Bags.mutable.empty());
        Assert.assertEquals(2, evensAndOdds2.occurrencesOf(1));
        Assert.assertEquals(2, evensAndOdds2.occurrencesOf(0));
    }

    /**
     * @since 10.0.0
     */
    @Test
    public void countByEach() {
        RichIterable<Integer> integerList = this.newMapWithKeysValues("1", 1, "2", 2, "4", 4);
        Bag<Integer> integerBag1 = integerList.countByEach(each -> IntInterval.oneTo(5).collect(i -> each * i));
        Assert.assertEquals(1, integerBag1.occurrencesOf(1));
        Assert.assertEquals(2, integerBag1.occurrencesOf(2));
        Assert.assertEquals(3, integerBag1.occurrencesOf(4));
        Assert.assertEquals(2, integerBag1.occurrencesOf(8));
        Assert.assertEquals(1, integerBag1.occurrencesOf(12));
        Bag<Integer> integerBag2 = integerList.countByEach(each -> IntInterval.oneTo(5).collect(i -> each * i), Bags.mutable.empty());
        Assert.assertEquals(1, integerBag2.occurrencesOf(1));
        Assert.assertEquals(2, integerBag2.occurrencesOf(2));
        Assert.assertEquals(3, integerBag2.occurrencesOf(4));
        Assert.assertEquals(2, integerBag2.occurrencesOf(8));
        Assert.assertEquals(1, integerBag2.occurrencesOf(12));
    }

    @Test
    public void groupBy() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        Function<Integer, Boolean> isOddFunction = object -> IntegerPredicates.isOdd().accept(object);
        Multimap<Boolean, Integer> expected = FastListMultimap.newMultimap(Tuples.pair(Boolean.TRUE, 1), Tuples.pair(Boolean.TRUE, 3), Tuples.pair(Boolean.FALSE, 2), Tuples.pair(Boolean.FALSE, 4));
        Multimap<Boolean, Integer> actual = map.groupBy(isOddFunction);
        expected.forEachKey(each -> {
            Assert.assertTrue(actual.containsKey(each));
            MutableList<Integer> values = actual.get(each).toList();
            Verify.assertNotEmpty(values);
            Assert.assertTrue(expected.get(each).containsAllIterable(values));
        });
        Multimap<Boolean, Integer> actualFromTarget = map.groupBy(isOddFunction, FastListMultimap.newMultimap());
        expected.forEachKey(each -> {
            Assert.assertTrue(actualFromTarget.containsKey(each));
            MutableList<Integer> values = actualFromTarget.get(each).toList();
            Verify.assertNotEmpty(values);
            Assert.assertTrue(expected.get(each).containsAllIterable(values));
        });
    }

    @Test
    public void groupByEach() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        MutableMultimap<Integer, Integer> expected = FastListMultimap.newMultimap();
        for (int i = 1; i < 4; i++) {
            expected.putAll(-i, Interval.fromTo(i, 4));
        }
        NegativeIntervalFunction function = new NegativeIntervalFunction();
        Multimap<Integer, Integer> actual = map.groupByEach(function);
        expected.forEachKey(each -> {
            Assert.assertTrue(actual.containsKey(each));
            MutableList<Integer> values = actual.get(each).toList();
            Verify.assertNotEmpty(values);
            Assert.assertTrue(expected.get(each).containsAllIterable(values));
        });
        Multimap<Integer, Integer> actualFromTarget = map.groupByEach(function, FastListMultimap.newMultimap());
        expected.forEachKey(each -> {
            Assert.assertTrue(actualFromTarget.containsKey(each));
            MutableList<Integer> values = actualFromTarget.get(each).toList();
            Verify.assertNotEmpty(values);
            Assert.assertTrue(expected.get(each).containsAllIterable(values));
        });
    }

    @Test
    public void groupByUniqueKey() {
        MapIterable<Integer, Integer> map = this.newMapWithKeysValues(1, 1, 2, 2, 3, 3);
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, 1, 2, 2, 3, 3), map.groupByUniqueKey(id -> id));
    }

    @Test(expected = IllegalStateException.class)
    public void groupByUniqueKey_throws() {
        this.newMapWithKeysValues(1, 1, 2, 2, 3, 3).groupByUniqueKey(Functions.getFixedValue(1));
    }

    @Test
    public void groupByUniqueKey_target() {
        MapIterable<Integer, Integer> map = this.newMapWithKeysValues(1, 1, 2, 2, 3, 3);
        MutableMap<Integer, Integer> integers = map.groupByUniqueKey(id -> id, UnifiedMap.newWithKeysValues(0, 0));
        Assert.assertEquals(UnifiedMap.newWithKeysValues(0, 0, 1, 1, 2, 2, 3, 3), integers);
    }

    @Test(expected = IllegalStateException.class)
    public void groupByUniqueKey_target_throws() {
        this.newMapWithKeysValues(1, 1, 2, 2, 3, 3).groupByUniqueKey(id -> id, UnifiedMap.newWithKeysValues(2, 2));
    }

    @Test
    public void injectInto() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        Integer actual = map.injectInto(0, AddFunction.INTEGER);
        Assert.assertEquals(Integer.valueOf(10), actual);
        Sum sum = map.injectInto(new IntegerSum(0), SumProcedure.number());
        Assert.assertEquals(new IntegerSum(10), sum);
    }

    @Test
    public void injectIntoInt() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        int actual = map.injectInto(0, AddFunction.INTEGER_TO_INT);
        Assert.assertEquals(10, actual);
    }

    @Test
    public void injectIntoLong() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        long actual = map.injectInto(0, AddFunction.INTEGER_TO_LONG);
        Assert.assertEquals(10, actual);
    }

    @Test
    public void injectIntoFloat() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        float actual = map.injectInto(0, AddFunction.INTEGER_TO_FLOAT);
        Assert.assertEquals(10.0F, actual, 0.01);
    }

    @Test
    public void injectIntoDouble() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        double actual = map.injectInto(0, AddFunction.INTEGER_TO_DOUBLE);
        Assert.assertEquals(10.0d, actual, 0.01);
    }

    @Test
    public void sumOfInt() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        long actual = map.sumOfInt(integer -> integer);
        Assert.assertEquals(10L, actual);
    }

    @Test
    public void sumOfLong() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        long actual = map.sumOfLong(Integer::longValue);
        Assert.assertEquals(10, actual);
    }

    @Test
    public void testAggregateBy() {
        String oneToFive = "oneToFive";
        String sixToNine = "sixToNine";
        String tenToFifteen = "tenToFifteen";
        String sixteenToTwenty = "sixteenToTwenty";
        MapIterable<String, Interval> map = Maps.mutable.with(oneToFive, Interval.fromTo(1, 5), sixToNine, Interval.fromTo(6, 9), tenToFifteen, Interval.fromTo(10, 15), sixteenToTwenty, Interval.fromTo(16, 20));
        String lessThanTen = "lessThanTen";
        String greaterOrEqualsToTen = "greaterOrEqualsToTen";
        MapIterable<String, Long> result = map.aggregateBy(eachKey -> {
            return eachKey.equals(oneToFive) || eachKey.equals(sixToNine) ? lessThanTen : greaterOrEqualsToTen;
        }, each -> each.sumOfInt(Integer::intValue), () -> 0L, (argument1, argument2) -> argument1 + argument2);
        MapIterable<String, Long> expected = Maps.mutable.with(lessThanTen, Interval.fromTo(1, 9).sumOfInt(Integer::intValue), greaterOrEqualsToTen, Interval.fromTo(10, 20).sumOfInt(Integer::intValue));
        Assert.assertEquals(expected, result);
    }

    @Test
    public void sumOfFloat() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        double actual = map.sumOfFloat(Integer::floatValue);
        Assert.assertEquals(10.0d, actual, 0.01);
    }

    @Test
    public void sumOfDouble() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        double actual = map.sumOfDouble(Integer::doubleValue);
        Assert.assertEquals(10.0d, actual, 0.01);
    }

    @Test
    public void sumByInt() {
        RichIterable<String> values = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        ObjectLongMap<Integer> result = values.sumByInt(s -> Integer.parseInt(s) % 2, Integer::parseInt);
        Assert.assertEquals(4, result.get(1));
        Assert.assertEquals(2, result.get(0));
    }

    @Test
    public void sumByFloat() {
        RichIterable<String> values = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        ObjectDoubleMap<Integer> result = values.sumByFloat(s -> Integer.parseInt(s) % 2, Float::parseFloat);
        Assert.assertEquals(4.0f, result.get(1), 0.0);
        Assert.assertEquals(2.0f, result.get(0), 0.0);
    }

    @Test
    public void sumByLong() {
        RichIterable<String> values = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        ObjectLongMap<Integer> result = values.sumByLong(s -> Integer.parseInt(s) % 2, Long::parseLong);
        Assert.assertEquals(4, result.get(1));
        Assert.assertEquals(2, result.get(0));
    }

    @Test
    public void sumByDouble() {
        RichIterable<String> values = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        ObjectDoubleMap<Integer> result = values.sumByDouble(s -> Integer.parseInt(s) % 2, Double::parseDouble);
        Assert.assertEquals(4.0d, result.get(1), 0.0);
        Assert.assertEquals(2.0d, result.get(0), 0.0);
    }

    @Test
    public void makeString() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        String defaultString = map.makeString();
        Assert.assertEquals(15, defaultString.length());
        String delimitedString = map.makeString("|");
        Assert.assertEquals(13, delimitedString.length());
        Verify.assertContains("|", delimitedString);
        String wrappedString = map.makeString("{", "|", "}");
        Assert.assertEquals(15, wrappedString.length());
        Verify.assertContains("|", wrappedString);
        Assert.assertTrue(wrappedString.startsWith("{"));
        Assert.assertTrue(wrappedString.endsWith("}"));
    }

    @Test
    public void min() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        Assert.assertEquals(Integer.valueOf(1), map.min());
        Assert.assertEquals(Integer.valueOf(1), map.min(Integer::compareTo));
    }

    @Test
    public void max() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        Assert.assertEquals(Integer.valueOf(4), map.max());
        Assert.assertEquals(Integer.valueOf(4), map.max(Integer::compareTo));
    }

    @Test
    public void minBy() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        Assert.assertEquals(Integer.valueOf(1), map.minBy(String::valueOf));
    }

    @Test
    public void maxBy() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        Assert.assertEquals(Integer.valueOf(4), map.maxBy(String::valueOf));
    }

    @Test
    public void reject_value() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        Verify.assertContainsAll(map.reject(Predicates.lessThan(3)).toSet(), 3, 4);
        Verify.assertContainsAll(map.reject(Predicates.lessThan(3), UnifiedSet.newSet()), 3, 4);
    }

    @Test
    public void rejectWith_value() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        Verify.assertContainsAll(map.rejectWith(Predicates2.lessThan(), 3, UnifiedSet.newSet()), 3, 4);
    }

    @Test
    public void select_value() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        Verify.assertContainsAll(map.select(Predicates.lessThan(3)).toSet(), 1, 2);
        Verify.assertContainsAll(map.select(Predicates.lessThan(3), UnifiedSet.newSet()), 1, 2);
    }

    @Test
    public void selectWith_value() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        Verify.assertContainsAll(map.selectWith(Predicates2.lessThan(), 3, UnifiedSet.newSet()), 1, 2);
    }

    @Test
    public void partition_value() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("A", 1, "B", 2, "C", 3, "D", 4);
        PartitionIterable<Integer> partition = map.partition(IntegerPredicates.isEven());
        Assert.assertEquals(iSet(4, 2), partition.getSelected().toSet());
        Assert.assertEquals(iSet(3, 1), partition.getRejected().toSet());
    }

    @Test
    public void partitionWith_value() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("A", 1, "B", 2, "C", 3, "D", 4);
        PartitionIterable<Integer> partition = map.partitionWith(Predicates2.in(), map.select(IntegerPredicates.isEven()));
        Assert.assertEquals(iSet(4, 2), partition.getSelected().toSet());
        Assert.assertEquals(iSet(3, 1), partition.getRejected().toSet());
    }

    @Test
    public void selectInstancesOf_value() {
        MapIterable<String, Number> map = this.newMapWithKeysValues("1", 1, "2", 2.0, "3", 3, "4", 4.0);
        Assert.assertEquals(iBag(1, 3), map.selectInstancesOf(Integer.class).toBag());
    }

    @Test
    public void toArray() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        Object[] array = map.toArray();
        Verify.assertSize(4, array);
        Integer[] array2 = map.toArray(new Integer[0]);
        Verify.assertSize(4, array2);
        Integer[] array3 = map.toArray(new Integer[4]);
        Verify.assertSize(4, array3);
        Integer[] array4 = map.toArray(new Integer[5]);
        Verify.assertSize(5, array4);
    }

    @Test
    public void zip() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        List<Object> nulls = Collections.nCopies(map.size(), null);
        List<Object> nullsPlusOne = Collections.nCopies(map.size() + 1, null);
        List<Object> nullsMinusOne = Collections.nCopies(map.size() - 1, null);
        RichIterable<Pair<String, Object>> pairs = map.zip(nulls);
        Assert.assertEquals(map.toSet(), pairs.collect((Function<Pair<String, ?>, String>) Pair::getOne).toSet());
        Assert.assertEquals(nulls, pairs.collect((Function<Pair<?, Object>, Object>) Pair::getTwo, Lists.mutable.of()));
        RichIterable<Pair<String, Object>> pairsPlusOne = map.zip(nullsPlusOne);
        Assert.assertEquals(map.toSet(), pairsPlusOne.collect((Function<Pair<String, ?>, String>) Pair::getOne).toSet());
        Assert.assertEquals(nulls, pairsPlusOne.collect((Function<Pair<?, Object>, Object>) Pair::getTwo, Lists.mutable.of()));
        RichIterable<Pair<String, Object>> pairsMinusOne = map.zip(nullsMinusOne);
        Assert.assertEquals(map.size() - 1, pairsMinusOne.size());
        Assert.assertTrue(map.valuesView().containsAllIterable(pairsMinusOne.collect((Function<Pair<String, ?>, String>) Pair::getOne).toSet()));
        Assert.assertEquals(map.zip(nulls).toSet(), map.zip(nulls, UnifiedSet.newSet()));
    }

    @Test
    public void zipWithIndex() {
        MapIterable<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        RichIterable<Pair<String, Integer>> pairs = map.zipWithIndex();
        Assert.assertEquals(map.toSet(), pairs.collect(Pair::getOne).toSet());
        Assert.assertEquals(Interval.zeroTo(map.size() - 1).toSet(), pairs.collect(Pair::getTwo, UnifiedSet.newSet()));
        Assert.assertEquals(map.zipWithIndex().toSet(), map.zipWithIndex(UnifiedSet.newSet()));
    }

    @Test
    public void aggregateByMutating() {
        Function0<AtomicInteger> valueCreator = AtomicInteger::new;
        RichIterable<Integer> collection = this.newMapWithKeysValues(1, 1, 2, 2, 3, 3);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, AtomicInteger::addAndGet);
        Assert.assertEquals(1, aggregation.get("1").intValue());
        Assert.assertEquals(2, aggregation.get("2").intValue());
        Assert.assertEquals(3, aggregation.get("3").intValue());
    }

    @Test
    public void aggregateByNonMutating() {
        Function0<Integer> valueCreator = () -> 0;
        Function2<Integer, Integer, Integer> sumAggregator = (integer1, integer2) -> integer1 + integer2;
        RichIterable<Integer> collection = this.newMapWithKeysValues(1, 1, 2, 2, 3, 3);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(1, aggregation.get("1").intValue());
        Assert.assertEquals(2, aggregation.get("2").intValue());
        Assert.assertEquals(3, aggregation.get("3").intValue());
    }

    @Test
    public void keyValuesView() {
        MapIterable<Integer, String> map = this.newMapWithKeysValues(1, "A", 2, "B", 3, "C", 4, "D");
        MutableSet<Pair<Integer, String>> keyValues = map.keyValuesView().toSet();
        Assert.assertEquals(UnifiedSet.newSetWith(Tuples.pair(1, "A"), Tuples.pair(2, "B"), Tuples.pair(3, "C"), Tuples.pair(4, "D")), keyValues);
    }

    @Test
    public void nullCollisionWithCastInEquals() {
        if (this.newMap() instanceof SortedMap || this.newMap() instanceof ConcurrentMap) {
            return;
        }
        MapIterable<IntegerWithCast, String> mutableMap = this.newMapWithKeysValues(new IntegerWithCast(0), "Test 2", new IntegerWithCast(0), "Test 3", null, "Test 1");
        Assert.assertEquals(this.newMapWithKeysValues(new IntegerWithCast(0), "Test 3", null, "Test 1"), mutableMap);
        Assert.assertEquals("Test 3", mutableMap.get(new IntegerWithCast(0)));
        Assert.assertEquals("Test 1", mutableMap.get(null));
    }

    @Test
    public void testNewMap() {
        MapIterable<Integer, Integer> map = this.newMap();
        Verify.assertEmpty(map);
        Verify.assertSize(0, map);
    }

    @Test
    public void testNewMapWithKeyValue() {
        MapIterable<Integer, String> map = this.newMapWithKeyValue(1, "One");
        Verify.assertNotEmpty(map);
        Verify.assertSize(1, map);
        Verify.assertContainsKeyValue(1, "One", map);
    }

    @Test
    public void newMapWithWith() {
        MapIterable<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two");
        Verify.assertNotEmpty(map);
        Verify.assertSize(2, map);
        Verify.assertContainsAllKeyValues(map, 1, "One", 2, "Two");
    }

    @Test
    public void newMapWithWithWith() {
        MapIterable<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two", 3, "Three");
        Verify.assertNotEmpty(map);
        Verify.assertSize(3, map);
        Verify.assertContainsAllKeyValues(map, 1, "One", 2, "Two", 3, "Three");
    }

    @Test
    public void newMapWithWithWithWith() {
        MapIterable<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two", 3, "Three", 4, "Four");
        Verify.assertNotEmpty(map);
        Verify.assertSize(4, map);
        Verify.assertContainsAllKeyValues(map, 1, "One", 2, "Two", 3, "Three", 4, "Four");
    }

    @Test
    public void iterator() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        Iterator<Integer> iterator = map.iterator();
        Assert.assertTrue(iterator.hasNext());
        int sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(6, sum);
    }

    @Test
    public void keysView() {
        MutableList<Integer> keys = this.newMapWithKeysValues(1, 1, 2, 2).keysView().toSortedList();
        Assert.assertEquals(FastList.newListWith(1, 2), keys);
    }

    @Test
    public void valuesView() {
        MutableList<Integer> values = this.newMapWithKeysValues(1, 1, 2, 2).valuesView().toSortedList();
        Assert.assertEquals(FastList.newListWith(1, 2), values);
    }

    @Test
    public void test_toString() {
        MapIterable<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two", 3, "Three");
        String stringToSearch = map.toString();
        Verify.assertContains("1=One", stringToSearch);
        Verify.assertContains("2=Two", stringToSearch);
        Verify.assertContains("3=Three", stringToSearch);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MapIterableTestCase instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ifPresentApply() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ifPresentApply);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent_function() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent_function);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrDefault() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrDefault);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
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
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectValues);
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
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
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
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect_value);
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
        public void benchmark_collectWithToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithToTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
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
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_throws_when_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_throws_when_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_throws_when_multiple_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_throws_when_multiple_values);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArguments);
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
        public void benchmark_detect_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatten_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatten_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach);
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
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws);
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
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAggregateBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAggregateBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
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
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
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
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyValuesView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_nullCollisionWithCastInEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.nullCollisionWithCastInEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMapWithKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMapWithKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWithWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWithWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWithWithWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_test_toString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.test_toString);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> payload) throws java.lang.Throwable {
            this.instance = new MapIterableTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapIterableTestCase> test_toString;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = MapIterableTestCase::stream;
            this.payloads.parallelStream = MapIterableTestCase::parallelStream;
            this.payloads.equalsAndHashCode = MapIterableTestCase::equalsAndHashCode;
            this.payloads.serialization = MapIterableTestCase::serialization;
            this.payloads.isEmpty = MapIterableTestCase::isEmpty;
            this.payloads.notEmpty = MapIterableTestCase::notEmpty;
            this.payloads.ifPresentApply = MapIterableTestCase::ifPresentApply;
            this.payloads.getIfAbsent_function = MapIterableTestCase::getIfAbsent_function;
            this.payloads.getOrDefault = MapIterableTestCase::getOrDefault;
            this.payloads.getIfAbsent = MapIterableTestCase::getIfAbsent;
            this.payloads.getIfAbsentWith = MapIterableTestCase::getIfAbsentWith;
            this.payloads.tap = MapIterableTestCase::tap;
            this.payloads.forEach = MapIterableTestCase::forEach;
            this.payloads.forEachWith = MapIterableTestCase::forEachWith;
            this.payloads.forEachWithIndex = MapIterableTestCase::forEachWithIndex;
            this.payloads.forEachKey = MapIterableTestCase::forEachKey;
            this.payloads.forEachValue = MapIterableTestCase::forEachValue;
            this.payloads.forEachKeyValue = MapIterableTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = MapIterableTestCase::injectIntoKeyValue;
            this.payloads.flipUniqueValues = MapIterableTestCase::flipUniqueValues;
            this.payloads.collectMap = MapIterableTestCase::collectMap;
            this.payloads.collectBoolean = MapIterableTestCase::collectBoolean;
            this.payloads.collectBooleanWithTarget = MapIterableTestCase::collectBooleanWithTarget;
            this.payloads.collectByte = MapIterableTestCase::collectByte;
            this.payloads.collectByteWithTarget = MapIterableTestCase::collectByteWithTarget;
            this.payloads.collectChar = MapIterableTestCase::collectChar;
            this.payloads.collectCharWithTarget = MapIterableTestCase::collectCharWithTarget;
            this.payloads.collectDouble = MapIterableTestCase::collectDouble;
            this.payloads.collectDoubleWithTarget = MapIterableTestCase::collectDoubleWithTarget;
            this.payloads.collectFloat = MapIterableTestCase::collectFloat;
            this.payloads.collectFloatWithTarget = MapIterableTestCase::collectFloatWithTarget;
            this.payloads.collectInt = MapIterableTestCase::collectInt;
            this.payloads.collectIntWithTarget = MapIterableTestCase::collectIntWithTarget;
            this.payloads.collectLong = MapIterableTestCase::collectLong;
            this.payloads.collectLongWithTarget = MapIterableTestCase::collectLongWithTarget;
            this.payloads.collectShort = MapIterableTestCase::collectShort;
            this.payloads.collectShortWithTarget = MapIterableTestCase::collectShortWithTarget;
            this.payloads.collectValues = MapIterableTestCase::collectValues;
            this.payloads.select = MapIterableTestCase::select;
            this.payloads.selectWith = MapIterableTestCase::selectWith;
            this.payloads.reject = MapIterableTestCase::reject;
            this.payloads.rejectWith = MapIterableTestCase::rejectWith;
            this.payloads.collect = MapIterableTestCase::collect;
            this.payloads.flatCollect = MapIterableTestCase::flatCollect;
            this.payloads.flatCollectWith = MapIterableTestCase::flatCollectWith;
            this.payloads.selectMap = MapIterableTestCase::selectMap;
            this.payloads.rejectMap = MapIterableTestCase::rejectMap;
            this.payloads.flip = MapIterableTestCase::flip;
            this.payloads.detect = MapIterableTestCase::detect;
            this.payloads.detectOptional = MapIterableTestCase::detectOptional;
            this.payloads.anySatisfy = MapIterableTestCase::anySatisfy;
            this.payloads.anySatisfyWith = MapIterableTestCase::anySatisfyWith;
            this.payloads.allSatisfy = MapIterableTestCase::allSatisfy;
            this.payloads.allSatisfyWith = MapIterableTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = MapIterableTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = MapIterableTestCase::noneSatisfyWith;
            this.payloads.appendString = MapIterableTestCase::appendString;
            this.payloads.toBag = MapIterableTestCase::toBag;
            this.payloads.toSortedBag = MapIterableTestCase::toSortedBag;
            this.payloads.toSortedBagBy = MapIterableTestCase::toSortedBagBy;
            this.payloads.asLazy = MapIterableTestCase::asLazy;
            this.payloads.toList = MapIterableTestCase::toList;
            this.payloads.toMap = MapIterableTestCase::toMap;
            this.payloads.toSet = MapIterableTestCase::toSet;
            this.payloads.toSortedList = MapIterableTestCase::toSortedList;
            this.payloads.toSortedListBy = MapIterableTestCase::toSortedListBy;
            this.payloads.toSortedSet = MapIterableTestCase::toSortedSet;
            this.payloads.toSortedSetBy = MapIterableTestCase::toSortedSetBy;
            this.payloads.toSortedMap = MapIterableTestCase::toSortedMap;
            this.payloads.chunk = MapIterableTestCase::chunk;
            this.payloads.collect_value = MapIterableTestCase::collect_value;
            this.payloads.collectIf = MapIterableTestCase::collectIf;
            this.payloads.collectWith = MapIterableTestCase::collectWith;
            this.payloads.collectWithToTarget = MapIterableTestCase::collectWithToTarget;
            this.payloads.contains = MapIterableTestCase::contains;
            this.payloads.containsAnyIterable = MapIterableTestCase::containsAnyIterable;
            this.payloads.containsNoneIterable = MapIterableTestCase::containsNoneIterable;
            this.payloads.containsAnyCollection = MapIterableTestCase::containsAnyCollection;
            this.payloads.containsNoneCollection = MapIterableTestCase::containsNoneCollection;
            this.payloads.containsAll = MapIterableTestCase::containsAll;
            this.payloads.containsKey = MapIterableTestCase::containsKey;
            this.payloads.containsValue = MapIterableTestCase::containsValue;
            this.payloads.getFirst = MapIterableTestCase::getFirst;
            this.payloads.getLast = MapIterableTestCase::getLast;
            this.payloads.getOnly = MapIterableTestCase::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(MapIterableTestCase::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(MapIterableTestCase::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = MapIterableTestCase::containsAllIterable;
            this.payloads.containsAllArguments = MapIterableTestCase::containsAllArguments;
            this.payloads.count = MapIterableTestCase::count;
            this.payloads.countWith = MapIterableTestCase::countWith;
            this.payloads.detect_value = MapIterableTestCase::detect_value;
            this.payloads.detectOptional_value = MapIterableTestCase::detectOptional_value;
            this.payloads.detectWith = MapIterableTestCase::detectWith;
            this.payloads.detectWithOptional = MapIterableTestCase::detectWithOptional;
            this.payloads.detectIfNone_value = MapIterableTestCase::detectIfNone_value;
            this.payloads.detectWithIfNone = MapIterableTestCase::detectWithIfNone;
            this.payloads.flatten_value = MapIterableTestCase::flatten_value;
            this.payloads.countBy = MapIterableTestCase::countBy;
            this.payloads.countByWith = MapIterableTestCase::countByWith;
            this.payloads.countByEach = MapIterableTestCase::countByEach;
            this.payloads.groupBy = MapIterableTestCase::groupBy;
            this.payloads.groupByEach = MapIterableTestCase::groupByEach;
            this.payloads.groupByUniqueKey = MapIterableTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MapIterableTestCase::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = MapIterableTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MapIterableTestCase::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = MapIterableTestCase::injectInto;
            this.payloads.injectIntoInt = MapIterableTestCase::injectIntoInt;
            this.payloads.injectIntoLong = MapIterableTestCase::injectIntoLong;
            this.payloads.injectIntoFloat = MapIterableTestCase::injectIntoFloat;
            this.payloads.injectIntoDouble = MapIterableTestCase::injectIntoDouble;
            this.payloads.sumOfInt = MapIterableTestCase::sumOfInt;
            this.payloads.sumOfLong = MapIterableTestCase::sumOfLong;
            this.payloads.testAggregateBy = MapIterableTestCase::testAggregateBy;
            this.payloads.sumOfFloat = MapIterableTestCase::sumOfFloat;
            this.payloads.sumOfDouble = MapIterableTestCase::sumOfDouble;
            this.payloads.sumByInt = MapIterableTestCase::sumByInt;
            this.payloads.sumByFloat = MapIterableTestCase::sumByFloat;
            this.payloads.sumByLong = MapIterableTestCase::sumByLong;
            this.payloads.sumByDouble = MapIterableTestCase::sumByDouble;
            this.payloads.makeString = MapIterableTestCase::makeString;
            this.payloads.min = MapIterableTestCase::min;
            this.payloads.max = MapIterableTestCase::max;
            this.payloads.minBy = MapIterableTestCase::minBy;
            this.payloads.maxBy = MapIterableTestCase::maxBy;
            this.payloads.reject_value = MapIterableTestCase::reject_value;
            this.payloads.rejectWith_value = MapIterableTestCase::rejectWith_value;
            this.payloads.select_value = MapIterableTestCase::select_value;
            this.payloads.selectWith_value = MapIterableTestCase::selectWith_value;
            this.payloads.partition_value = MapIterableTestCase::partition_value;
            this.payloads.partitionWith_value = MapIterableTestCase::partitionWith_value;
            this.payloads.selectInstancesOf_value = MapIterableTestCase::selectInstancesOf_value;
            this.payloads.toArray = MapIterableTestCase::toArray;
            this.payloads.zip = MapIterableTestCase::zip;
            this.payloads.zipWithIndex = MapIterableTestCase::zipWithIndex;
            this.payloads.aggregateByMutating = MapIterableTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = MapIterableTestCase::aggregateByNonMutating;
            this.payloads.keyValuesView = MapIterableTestCase::keyValuesView;
            this.payloads.nullCollisionWithCastInEquals = MapIterableTestCase::nullCollisionWithCastInEquals;
            this.payloads.testNewMap = MapIterableTestCase::testNewMap;
            this.payloads.testNewMapWithKeyValue = MapIterableTestCase::testNewMapWithKeyValue;
            this.payloads.newMapWithWith = MapIterableTestCase::newMapWithWith;
            this.payloads.newMapWithWithWith = MapIterableTestCase::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = MapIterableTestCase::newMapWithWithWithWith;
            this.payloads.iterator = MapIterableTestCase::iterator;
            this.payloads.keysView = MapIterableTestCase::keysView;
            this.payloads.valuesView = MapIterableTestCase::valuesView;
            this.payloads.test_toString = MapIterableTestCase::test_toString;
        }
    }
}
