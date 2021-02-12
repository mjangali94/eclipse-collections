/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.utility;

import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.predicate.Predicate2;
import org.eclipse.collections.api.collection.primitive.MutableBooleanCollection;
import org.eclipse.collections.api.collection.primitive.MutableByteCollection;
import org.eclipse.collections.api.collection.primitive.MutableCharCollection;
import org.eclipse.collections.api.collection.primitive.MutableDoubleCollection;
import org.eclipse.collections.api.collection.primitive.MutableFloatCollection;
import org.eclipse.collections.api.collection.primitive.MutableIntCollection;
import org.eclipse.collections.api.collection.primitive.MutableLongCollection;
import org.eclipse.collections.api.collection.primitive.MutableShortCollection;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.BooleanHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.ByteHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.PrimitiveFunctions;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.block.predicate.MapEntryPredicate;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.block.procedure.MapPutProcedure;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Test;

public class MapIterateTest {

    @Test
    public void occurrencesOf() {
        MutableMap<String, Integer> map = this.getIntegerMap();
        Assert.assertEquals(0, MapIterate.occurrencesOf(map, -1));
        Assert.assertEquals(1, MapIterate.occurrencesOf(map, 1));
        Assert.assertEquals(1, MapIterate.occurrencesOf(map, 2));
    }

    @Test
    public void occurrencesOfAttribute() {
        MutableMap<String, Integer> map = this.getIntegerMap();
        Assert.assertEquals(0, MapIterate.occurrencesOfAttribute(map, String::valueOf, "-1"));
        Assert.assertEquals(1, MapIterate.occurrencesOfAttribute(map, String::valueOf, "1"));
        Assert.assertEquals(1, MapIterate.occurrencesOfAttribute(map, String::valueOf, "2"));
    }

    @Test
    public void toListOfPairs() {
        MutableMap<String, Integer> map = this.getIntegerMap();
        MutableList<Pair<String, Integer>> pairs = MapIterate.toListOfPairs(map);
        Verify.assertSize(5, pairs);
        Verify.assertContains(Tuples.pair("1", 1), pairs);
        Verify.assertContains(Tuples.pair("2", 2), pairs);
        Verify.assertContains(Tuples.pair("3", 3), pairs);
        Verify.assertContains(Tuples.pair("4", 4), pairs);
        Verify.assertContains(Tuples.pair("5", 5), pairs);
    }

    @Test
    public void injectInto() {
        MutableMap<String, Integer> map = this.getIntegerMap();
        Assert.assertEquals(Integer.valueOf(1 + 2 + 3 + 4 + 5), MapIterate.injectInto(0, map, AddFunction.INTEGER));
    }

    @Test
    public void functionMapTransformation() {
        MutableMap<Integer, Integer> input = Maps.fixedSize.of(1, 10, 2, 20);
        MutableMap<String, String> result = MapIterate.collect(input, Functions.getToString(), Functions.getToString());
        Verify.assertContainsKeyValue("1", "10", result);
        Verify.assertContainsKeyValue("2", "20", result);
        Verify.assertSize(2, result);
    }

    @Test
    public void simpleMapTransformation() {
        MutableMap<Locale, Currency> input = Maps.fixedSize.of(Locale.UK, Currency.getInstance(Locale.UK), Locale.JAPAN, Currency.getInstance(Locale.JAPAN));
        Function<Locale, String> getCountry = Locale::getCountry;
        Function<Currency, String> getCurrencyCode = Currency::getCurrencyCode;
        MutableMap<String, String> result = MapIterate.collect(input, getCountry, getCurrencyCode);
        Verify.assertContainsKeyValue("GB", "GBP", result);
        Verify.assertContainsKeyValue("JP", "JPY", result);
        Verify.assertSize(2, result);
    }

    @Test
    public void complexMapTransformation() {
        MutableMap<Locale, Currency> input = Maps.fixedSize.of(Locale.UK, Currency.getInstance(Locale.UK), Locale.JAPAN, Currency.getInstance(Locale.JAPAN));
        Function2<Locale, Currency, Pair<String, String>> function = (locale, currency) -> Tuples.pair(locale.getDisplayCountry(Locale.ENGLISH) + ':' + currency.getCurrencyCode(), currency.getCurrencyCode());
        MutableMap<String, String> result = MapIterate.collect(input, function);
        Verify.assertContainsKeyValue("United Kingdom:GBP", "GBP", result);
        Verify.assertContainsKeyValue("Japan:JPY", "JPY", result);
        Verify.assertSize(2, result);
    }

    @Test
    public void conditionalMapTransformation() {
        MutableMap<Locale, Currency> input = UnifiedMap.newWithKeysValues(Locale.UK, Currency.getInstance(Locale.UK), Locale.JAPAN, Currency.getInstance(Locale.JAPAN), Locale.CHINA, Currency.getInstance(Locale.GERMANY), Locale.GERMANY, Currency.getInstance(Locale.CHINA));
        MutableMap<String, String> result = MapIterate.collectIf(input, (locale, currency) -> Tuples.pair(locale.getDisplayCountry(Locale.ENGLISH) + ':' + currency.getCurrencyCode(), currency.getCurrencyCode()), (locale, currency) -> Currency.getInstance(locale).equals(currency));
        Verify.assertContainsKeyValue("United Kingdom:GBP", "GBP", result);
        Verify.assertContainsKeyValue("Japan:JPY", "JPY", result);
        Verify.assertSize(2, result);
    }

    @Test
    public void reverseMapping() {
        MutableMap<Integer, Integer> input = Maps.fixedSize.of(1, 10, 2, 20);
        MutableMap<Integer, Integer> result = MapIterate.reverseMapping(input);
        Verify.assertContainsKeyValue(10, 1, result);
        Verify.assertContainsKeyValue(20, 2, result);
        Verify.assertSize(2, result);
    }

    @Test
    public void toSortedList_with_comparator() {
        MutableMap<String, Integer> integers = this.getIntegerMap();
        MutableList<Integer> list = MapIterate.toSortedList(integers, Collections.reverseOrder());
        MutableList<Integer> expected = FastList.newList(integers.values()).sortThis(Collections.reverseOrder());
        Assert.assertEquals(expected, list);
    }

    @Test
    public void toSortedSetBy() {
        MutableMap<String, Integer> integers = this.getIntegerMap();
        MutableSortedSet<Integer> set = integers.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSet(integers.values()), set);
    }

    private MutableMap<String, Integer> getIntegerMap() {
        MutableMap<String, Integer> map = UnifiedMap.newMap();
        this.populateIntegerMap(map);
        return map;
    }

    private void populateIntegerMap(Map<String, Integer> map) {
        map.put("5", 5);
        map.put("4", 4);
        map.put("3", 3);
        map.put("2", 2);
        map.put("1", 1);
    }

    @Test
    public void selectWithDifferentTargetCollection() {
        MutableMap<String, Integer> map = this.getIntegerMap();
        Collection<Integer> results = MapIterate.select(map, Integer.class::isInstance, FastList.newList());
        Assert.assertEquals(Bags.mutable.of(1, 2, 3, 4, 5), HashBag.newBag(results));
    }

    @Test
    public void count() {
        MutableMap<String, Integer> map = this.getIntegerMap();
        Assert.assertEquals(5, MapIterate.count(map, Integer.class::isInstance));
    }

    @Test
    public void rejectWithDifferentTargetCollection() {
        MutableMap<String, Integer> map = this.getIntegerMap();
        MutableList<Integer> list = MapIterate.reject(map, Integer.class::isInstance, FastList.newList());
        Verify.assertEmpty(list);
    }

    @Test
    public void forEachValue() {
        MutableMap<String, Integer> map = UnifiedMap.newMap();
        map.putAll(this.getIntegerMap());
        MutableList<Integer> list = Lists.mutable.of();
        MapIterate.forEachValue(map, CollectionAddProcedure.on(list));
        MapIterate.forEachValue(new HashMap<>(map), CollectionAddProcedure.on(list));
        MapIterate.forEachValue(new HashMap<>(), CollectionAddProcedure.on(list));
        Verify.assertSize(10, list);
        Assert.assertEquals(30, list.injectInto(0, AddFunction.INTEGER_TO_INT));
    }

    @Test(expected = IllegalArgumentException.class)
    public void forEachValueThrowsOnNull() {
        MapIterate.forEachValue(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void forEachKeyThrowsOnNull() {
        MapIterate.forEachKey(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void forEachKeyValueThrowsOnNull() {
        MapIterate.forEachKeyValue(null, null);
    }

    @Test
    public void forEachKeyWithEmpty() {
        MapIterate.forEachKey(UnifiedMap.newMap(), null);
    // the implicit assertion is that it doesn't blow up with a NPE
    }

    @Test
    public void forEachKey() {
        MutableMap<String, Integer> map = UnifiedMap.newMap();
        map.putAll(this.getIntegerMap());
        MutableBag<String> bag = Bags.mutable.of();
        MapIterate.forEachKey(map, CollectionAddProcedure.on(bag));
        MapIterate.forEachKey(new HashMap<>(map), CollectionAddProcedure.on(bag));
        MapIterate.forEachKey(new HashMap<>(), CollectionAddProcedure.on(bag));
        Assert.assertEquals(HashBag.newBagWith("1", "1", "2", "2", "3", "3", "4", "4", "5", "5"), bag);
    }

    @Test
    public void forEachKeyValueWithEmpty() {
        MapIterate.forEachKeyValue(UnifiedMap.newMap(), null);
    // the implicit assertion is that it doesn't blow up with a NPE
    }

    @Test
    public void forEachKeyValue() {
        MutableMap<String, Integer> map = UnifiedMap.newMap();
        map.putAll(UnifiedMap.newMap(this.getIntegerMap()));
        MutableMap<String, Integer> newMap = UnifiedMap.newMap();
        MapPutProcedure<String, Integer> procedure = new MapPutProcedure<>(newMap);
        MapIterate.forEachKeyValue(map, procedure);
        Verify.assertMapsEqual(map, newMap);
    }

    @Test
    public void getIfAbsentPut() {
        MutableMap<String, String> unifiedMap = UnifiedMap.newMap();
        Map<String, String> hashMap = new HashMap<>();
        String value = "value";
        String value1 = MapIterate.getIfAbsentPut(unifiedMap, "key", () -> value);
        String value2 = MapIterate.getIfAbsentPut(unifiedMap, "key", () -> value);
        Assert.assertEquals("value", value1);
        Assert.assertSame(value1, value2);
        String value3 = MapIterate.getIfAbsentPut(hashMap, "key", () -> value);
        String value4 = MapIterate.getIfAbsentPut(hashMap, "key", () -> value);
        Assert.assertEquals("value", value3);
        Assert.assertSame(value3, value4);
    }

    @Test
    public void getIfAbsentPutWith() {
        MutableMap<String, String> map = UnifiedMap.newMap();
        Function<String, String> function = object -> "value:" + object;
        String value1 = MapIterate.getIfAbsentPutWith(map, "key", function, "1");
        String value2 = MapIterate.getIfAbsentPutWith(map, "key", function, "2");
        Assert.assertSame(value1, value2);
    }

    @Test
    public void getIfAbsentPutWithNullValue() {
        MutableMap<String, String> map = UnifiedMap.newMap();
        map.put("nullValueKey", null);
        Assert.assertNull(MapIterate.getIfAbsentPut(map, "nullValueKey", () -> "aValue"));
    }

    @SuppressWarnings("StringOperationCanBeSimplified")
    @Test
    public void getIfAbsent() {
        MutableMap<String, String> unifiedMap = UnifiedMap.newMapWith(Tuples.pair("key1", "key1Value"));
        Map<String, String> hashMap = new HashMap<>(unifiedMap);
        String value1 = MapIterate.getIfAbsent(unifiedMap, "key", () -> new String("value"));
        String value2 = MapIterate.getIfAbsent(unifiedMap, "key", () -> new String("value"));
        String value3 = MapIterate.getIfAbsent(hashMap, "key", () -> new String("value"));
        Assert.assertEquals("value", value1);
        Assert.assertEquals("value", value2);
        Assert.assertEquals("value", value3);
        Assert.assertNotSame(value1, value2);
        Assert.assertNotSame(value1, value3);
        Assert.assertEquals("key1Value", MapIterate.getIfAbsent(hashMap, "key1", () -> "value"));
        Assert.assertEquals("key1Value", MapIterate.getIfAbsent(unifiedMap, "key1", () -> "value"));
    }

    @Test
    public void getIfAbsentDefault() {
        MutableMap<String, String> map = UnifiedMap.<String, String>newMap().withKeysValues("key", "value");
        Assert.assertEquals("value", MapIterate.getIfAbsentDefault(map, "key", "defaultValue1"));
        Assert.assertEquals("defaultValue2", MapIterate.getIfAbsentDefault(map, "noKey", "defaultValue2"));
        Verify.assertNotContainsKey("noKey", map);
        Verify.assertSize(1, map);
    }

    @Test
    public void getIfAbsentWith() {
        MutableMap<String, Integer> unifiedMap = UnifiedMap.newMap();
        this.populateIntegerMap(unifiedMap);
        Map<String, Integer> hashMap = new HashMap<>(unifiedMap);
        Function<Integer, Integer> function = Functions.getPassThru();
        Integer ifAbsentValue = Integer.valueOf(6);
        Assert.assertEquals(ifAbsentValue, MapIterate.getIfAbsentWith(unifiedMap, "six", function, ifAbsentValue));
        Assert.assertEquals(Integer.valueOf(5), MapIterate.getIfAbsentWith(unifiedMap, "5", function, ifAbsentValue));
        Assert.assertEquals(ifAbsentValue, MapIterate.getIfAbsentWith(hashMap, "six", function, ifAbsentValue));
        Assert.assertEquals(Integer.valueOf(5), MapIterate.getIfAbsentWith(hashMap, "5", function, ifAbsentValue));
    }

    @Test
    public void withNullValue() {
        MutableMap<String, String> map = UnifiedMap.newWithKeysValues("key", null);
        String value = "value";
        Assert.assertNull(MapIterate.getIfAbsent(map, "key", () -> value));
        Assert.assertNull(MapIterate.getIfAbsentPut(map, "key", () -> value));
        Assert.assertEquals("result", MapIterate.ifPresentApply(map, "key", object -> "result"));
    }

    @Test
    public void ifPresentApply() {
        MutableMap<String, String> unifiedMap = UnifiedMap.newWithKeysValues("testKey", "testValue");
        Map<String, String> hashMap = new HashMap<>(unifiedMap);
        Assert.assertEquals("TESTVALUE", MapIterate.ifPresentApply(unifiedMap, "testKey", String::toUpperCase));
        Assert.assertEquals("TESTVALUE", MapIterate.ifPresentApply(hashMap, "testKey", String::toUpperCase));
    }

    @Test
    public void selectMapOnEntry() {
        MutableMap<String, String> map = UnifiedMap.newWithKeysValues("1", "2", "2", "1", "3", "3");
        MutableMap<String, String> resultMap = MapIterate.selectMapOnEntry(map, (argument1, argument2) -> "1".equals(argument1) || "1".equals(argument2));
        Verify.assertSize(2, resultMap);
        Verify.assertContainsKeyValue("1", "2", resultMap);
        Verify.assertContainsKeyValue("2", "1", resultMap);
    }

    @Test
    public void rejectMapOnEntry() {
        MutableMap<String, String> map = UnifiedMap.newWithKeysValues("1", "2", "2", "1", "3", "3");
        MutableMap<String, String> resultMap = MapIterate.rejectMapOnEntry(map, (argument1, argument2) -> "1".equals(argument1) || "1".equals(argument2));
        Verify.assertSize(1, resultMap);
        Verify.assertContainsKeyValue("3", "3", resultMap);
    }

    @Test
    public void select() {
        MutableMap<String, String> map = UnifiedMap.newWithKeysValues("1", "2", "2", "1", "3", "3");
        Assert.assertEquals(FastList.newListWith("1"), MapIterate.select(map, "1"::equals));
    }

    @Test
    public void selectMapEntries() {
        MutableMap<String, String> map = UnifiedMap.newWithKeysValues("1", "2", "2", "1", "3", "3");
        Collection<Map.Entry<String, String>> results = Iterate.select(map.entrySet(), new MapEntryPredicate<String, String>() {

            public boolean accept(String argument1, String argument2) {
                return "1".equals(argument1) || "1".equals(argument2);
            }
        });
        Verify.assertSize(2, results);
    }

    @Test
    public void selectMapOnKey() {
        MutableMap<String, String> map = UnifiedMap.newWithKeysValues("1", "2", "2", "1", "3", "3");
        MutableMap<String, String> resultMap = MapIterate.selectMapOnKey(map, "1"::equals);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1", "2"), resultMap);
    }

    @Test
    public void selectMapOnValue() {
        MutableMap<String, String> map = UnifiedMap.newWithKeysValues("1", "2", "2", "1", "3", "3");
        MutableMap<String, String> resultMap = MapIterate.selectMapOnValue(map, "1"::equals);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("2", "1"), resultMap);
    }

    @Test
    public void detect() {
        MutableMap<String, String> map = UnifiedMap.newWithKeysValues("1", "2", "2", "1", "3", "3");
        String resultFound = MapIterate.detect(map, "1"::equals);
        Assert.assertEquals("1", resultFound);
        String resultNotFound = MapIterate.detect(map, "4"::equals);
        Assert.assertNull(resultNotFound);
    }

    @Test(expected = IllegalArgumentException.class)
    public void detectThrowsOnNull() {
        MapIterate.detect(null, (Predicate2<? super Object, ? super Object>) null);
    }

    @Test
    public void detectIfNone() {
        MutableMap<String, String> map = UnifiedMap.newWithKeysValues("1", "2", "2", "1", "3", "3");
        String resultNotFound = MapIterate.detectIfNone(map, "4"::equals, "0");
        Assert.assertEquals("0", resultNotFound);
        String resultFound = MapIterate.detectIfNone(map, "1"::equals, "0");
        Assert.assertEquals("1", resultFound);
    }

    @Test
    public void anySatisfy() {
        MutableMap<String, String> map = UnifiedMap.newWithKeysValues("1", "2", "2", "1", "3", "3");
        Assert.assertTrue(MapIterate.anySatisfy(map, "1"::equals));
        Assert.assertTrue(MapIterate.anySatisfy(map, "3"::equals));
        Assert.assertFalse(MapIterate.anySatisfy(map, "4"::equals));
    }

    @Test
    public void allSatisfy() {
        MutableMap<String, String> map = UnifiedMap.newWithKeysValues("1", "2", "2", "1", "3", "3");
        Assert.assertFalse(MapIterate.allSatisfy(map, Predicates.notEqual("1")));
        Assert.assertFalse(MapIterate.allSatisfy(map, Predicates.notEqual("3")));
        Assert.assertTrue(MapIterate.anySatisfy(map, Predicates.notEqual("4")));
    }

    @Test
    public void noneSatisfy() {
        MutableMap<String, String> map = UnifiedMap.newWithKeysValues("1", "2", "2", "1", "3", "3");
        Assert.assertFalse(MapIterate.noneSatisfy(map, "1"::equals));
        Assert.assertFalse(MapIterate.noneSatisfy(map, "3"::equals));
        Assert.assertTrue(MapIterate.noneSatisfy(map, "4"::equals));
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(MapIterate.isEmpty(null));
        Assert.assertTrue(MapIterate.isEmpty(UnifiedMap.newMap()));
        Assert.assertFalse(MapIterate.isEmpty(Maps.fixedSize.of("1", "1")));
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(MapIterate.notEmpty(null));
        Assert.assertFalse(MapIterate.notEmpty(UnifiedMap.newMap()));
        Assert.assertTrue(MapIterate.notEmpty(Maps.fixedSize.of("1", "1")));
    }

    @Test
    public void reject() {
        MutableList<Integer> result = MapIterate.reject(newLittleMap(), Predicates.greaterThanOrEqualTo(2));
        Assert.assertEquals(FastList.newListWith(1), result);
    }

    private static MutableMap<Character, Integer> newLittleMap() {
        return UnifiedMap.<Character, Integer>newMap().withKeysValues('a', 1).withKeysValues('b', 2);
    }

    @Test
    public void addAllKeysToCollection() {
        MutableList<Character> target = Lists.mutable.of();
        MapIterate.addAllKeysTo(newLittleMap(), target);
        Assert.assertEquals(FastList.newListWith('a', 'b').toBag(), target.toBag());
    }

    @Test
    public void addAllValuesToCollection() {
        MutableList<Integer> target = Lists.mutable.of();
        MapIterate.addAllValuesTo(newLittleMap(), target);
        Assert.assertEquals(FastList.newListWith(1, 2).toBag(), target.toBag());
    }

    @Test
    public void collect() {
        MutableList<String> result = MapIterate.collect(newLittleMap(), Functions.getToString());
        Assert.assertEquals(FastList.newListWith("1", "2").toBag(), result.toBag());
    }

    @Test
    public void collectBoolean() {
        MutableBooleanCollection result = MapIterate.collectBoolean(MapIterateTest.newLittleMap(), PrimitiveFunctions.integerIsPositive());
        Assert.assertEquals(BooleanHashBag.newBagWith(true, true), result.toBag());
    }

    @Test
    public void collectBooleanWithTarget() {
        BooleanHashBag target = new BooleanHashBag();
        BooleanHashBag result = MapIterate.collectBoolean(MapIterateTest.newLittleMap(), PrimitiveFunctions.integerIsPositive(), target);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, true), result.toBag());
        Assert.assertSame("Target sent as parameter was not returned as result", target, result);
    }

    @Test
    public void collectByte() {
        MutableByteCollection result = MapIterate.collectByte(MapIterateTest.newLittleMap(), PrimitiveFunctions.unboxIntegerToByte());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2), result.toBag());
    }

    @Test
    public void collectByteWithTarget() {
        ByteHashBag target = new ByteHashBag();
        ByteHashBag result = MapIterate.collectByte(MapIterateTest.newLittleMap(), PrimitiveFunctions.unboxIntegerToByte(), target);
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2), result.toBag());
        Assert.assertSame("Target sent as parameter was not returned as result", target, result);
    }

    @Test
    public void collectChar() {
        MutableCharCollection result = MapIterate.collectChar(MapIterateTest.newLittleMap(), PrimitiveFunctions.unboxIntegerToChar());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2), result.toBag());
    }

    @Test
    public void collectCharWithTarget() {
        CharHashBag target = new CharHashBag();
        CharHashBag result = MapIterate.collectChar(MapIterateTest.newLittleMap(), PrimitiveFunctions.unboxIntegerToChar(), target);
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2), result.toBag());
        Assert.assertSame("Target sent as parameter was not returned as result", target, result);
    }

    @Test
    public void collectDouble() {
        MutableDoubleCollection result = MapIterate.collectDouble(MapIterateTest.newLittleMap(), PrimitiveFunctions.unboxIntegerToDouble());
        Assert.assertEquals(DoubleHashBag.newBagWith(1, 2), result.toBag());
    }

    @Test
    public void collectDoubleWithTarget() {
        DoubleHashBag target = new DoubleHashBag();
        DoubleHashBag result = MapIterate.collectDouble(MapIterateTest.newLittleMap(), PrimitiveFunctions.unboxIntegerToDouble(), target);
        Assert.assertEquals(DoubleHashBag.newBagWith(1, 2), result.toBag());
        Assert.assertSame("Target sent as parameter was not returned as result", target, result);
    }

    @Test
    public void collectFloat() {
        MutableFloatCollection result = MapIterate.collectFloat(MapIterateTest.newLittleMap(), PrimitiveFunctions.unboxIntegerToFloat());
        Assert.assertEquals(FloatHashBag.newBagWith(1, 2), result.toBag());
    }

    @Test
    public void collectFloatWithTarget() {
        FloatHashBag target = new FloatHashBag();
        FloatHashBag result = MapIterate.collectFloat(MapIterateTest.newLittleMap(), PrimitiveFunctions.unboxIntegerToFloat(), target);
        Assert.assertEquals(FloatHashBag.newBagWith(1, 2), result.toBag());
        Assert.assertSame("Target sent as parameter was not returned as result", target, result);
    }

    @Test
    public void collectInt() {
        MutableIntCollection result = MapIterate.collectInt(MapIterateTest.newLittleMap(), PrimitiveFunctions.unboxIntegerToInt());
        Assert.assertEquals(IntHashBag.newBagWith(1, 2), result.toBag());
    }

    @Test
    public void collectIntWithTarget() {
        IntHashBag target = new IntHashBag();
        IntHashBag result = MapIterate.collectInt(MapIterateTest.newLittleMap(), PrimitiveFunctions.unboxIntegerToInt(), target);
        Assert.assertEquals(IntHashBag.newBagWith(1, 2), result.toBag());
        Assert.assertSame("Target sent as parameter was not returned as result", target, result);
    }

    @Test
    public void collectLong() {
        MutableLongCollection result = MapIterate.collectLong(MapIterateTest.newLittleMap(), PrimitiveFunctions.unboxIntegerToLong());
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L), result.toBag());
    }

    @Test
    public void collectLongWithTarget() {
        LongHashBag target = new LongHashBag();
        LongHashBag result = MapIterate.collectLong(MapIterateTest.newLittleMap(), PrimitiveFunctions.unboxIntegerToLong(), target);
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L), result.toBag());
        Assert.assertSame("Target sent as parameter was not returned as result", target, result);
    }

    @Test
    public void collectShort() {
        MutableShortCollection result = MapIterate.collectShort(MapIterateTest.newLittleMap(), PrimitiveFunctions.unboxIntegerToShort());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2), result.toBag());
    }

    @Test
    public void collectShortWithTarget() {
        ShortHashBag target = new ShortHashBag();
        MutableShortCollection result = MapIterate.collectShort(MapIterateTest.newLittleMap(), PrimitiveFunctions.unboxIntegerToShort(), target);
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2), result.toBag());
        Assert.assertSame("Target sent as parameter was not returned as result", target, result);
    }

    @Test
    public void collectValues() {
        MutableMap<Character, String> result = MapIterate.collectValues(newLittleMap(), (argument1, argument2) -> argument2.toString());
        Assert.assertEquals(UnifiedMap.newWithKeysValues('a', "1", 'b', "2").toBag(), result.toBag());
    }

    @Test
    public void collectIntoTarget() {
        MutableList<String> target = Lists.mutable.of();
        MutableList<String> result = MapIterate.collect(newLittleMap(), String::valueOf, target);
        Assert.assertEquals(FastList.newListWith("1", "2").toBag(), result.toBag());
        Assert.assertSame(target, result);
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(MapIterate.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occurrencesOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::occurrencesOf, this.description("occurrencesOf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occurrencesOfAttribute() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::occurrencesOfAttribute, this.description("occurrencesOfAttribute"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toListOfPairs() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toListOfPairs, this.description("toListOfPairs"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectInto, this.description("injectInto"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_functionMapTransformation() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::functionMapTransformation, this.description("functionMapTransformation"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_simpleMapTransformation() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::simpleMapTransformation, this.description("simpleMapTransformation"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_complexMapTransformation() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::complexMapTransformation, this.description("complexMapTransformation"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_conditionalMapTransformation() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::conditionalMapTransformation, this.description("conditionalMapTransformation"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseMapping() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reverseMapping, this.description("reverseMapping"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedList_with_comparator, this.description("toSortedList_with_comparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedSetBy, this.description("toSortedSetBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithDifferentTargetCollection() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectWithDifferentTargetCollection, this.description("selectWithDifferentTargetCollection"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::count, this.description("count"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithDifferentTargetCollection() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::rejectWithDifferentTargetCollection, this.description("rejectWithDifferentTargetCollection"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachValue, this.description("forEachValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValueThrowsOnNull() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::forEachValueThrowsOnNull, this.description("forEachValueThrowsOnNull"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyThrowsOnNull() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::forEachKeyThrowsOnNull, this.description("forEachKeyThrowsOnNull"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValueThrowsOnNull() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::forEachKeyValueThrowsOnNull, this.description("forEachKeyValueThrowsOnNull"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyWithEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachKeyWithEmpty, this.description("forEachKeyWithEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachKey, this.description("forEachKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValueWithEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachKeyValueWithEmpty, this.description("forEachKeyValueWithEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachKeyValue, this.description("forEachKeyValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPut, this.description("getIfAbsentPut"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPutWith, this.description("getIfAbsentPutWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithNullValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPutWithNullValue, this.description("getIfAbsentPutWithNullValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsent, this.description("getIfAbsent"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentDefault() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentDefault, this.description("getIfAbsentDefault"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentWith, this.description("getIfAbsentWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withNullValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withNullValue, this.description("withNullValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ifPresentApply() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::ifPresentApply, this.description("ifPresentApply"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectMapOnEntry() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectMapOnEntry, this.description("selectMapOnEntry"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectMapOnEntry() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::rejectMapOnEntry, this.description("rejectMapOnEntry"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::select, this.description("select"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectMapEntries() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectMapEntries, this.description("selectMapEntries"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectMapOnKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectMapOnKey, this.description("selectMapOnKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectMapOnValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectMapOnValue, this.description("selectMapOnValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detect, this.description("detect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectThrowsOnNull() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::detectThrowsOnNull, this.description("detectThrowsOnNull"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectIfNone, this.description("detectIfNone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfy, this.description("anySatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfy, this.description("allSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::noneSatisfy, this.description("noneSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isEmpty, this.description("isEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::notEmpty, this.description("notEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reject, this.description("reject"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllKeysToCollection() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addAllKeysToCollection, this.description("addAllKeysToCollection"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllValuesToCollection() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addAllValuesToCollection, this.description("addAllValuesToCollection"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect, this.description("collect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectBoolean, this.description("collectBoolean"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectBooleanWithTarget, this.description("collectBooleanWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectByte, this.description("collectByte"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectByteWithTarget, this.description("collectByteWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectChar, this.description("collectChar"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectCharWithTarget, this.description("collectCharWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectDouble, this.description("collectDouble"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectDoubleWithTarget, this.description("collectDoubleWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectFloat, this.description("collectFloat"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectFloatWithTarget, this.description("collectFloatWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectInt, this.description("collectInt"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectIntWithTarget, this.description("collectIntWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectLong, this.description("collectLong"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectLongWithTarget, this.description("collectLongWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectShort, this.description("collectShort"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectShortWithTarget, this.description("collectShortWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectValues, this.description("collectValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntoTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectIntoTarget, this.description("collectIntoTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::classIsNonInstantiable, this.description("classIsNonInstantiable"));
        }

        private MapIterateTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MapIterateTest();
        }

        @java.lang.Override
        public MapIterateTest implementation() {
            return this.implementation;
        }
    }
}
