/*
 * Copyright (c) 2021 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.sorted.immutable;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.ImmutableMap;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.map.sorted.ImmutableSortedMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.factory.SortedMaps;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.fixed.ArrayAdapter;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.MapIterableTestCase;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.sorted.mutable.TreeSortedMap;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableSortedMap}.
 */
public abstract class ImmutableSortedMapTestCase extends MapIterableTestCase {

    private static final Comparator<? super Integer> REV_INT_COMPARATOR = Comparators.reverseNaturalOrder();

    /**
     * @return A map containing 1 => "1", 2 => "2", etc.
     */
    protected abstract ImmutableSortedMap<Integer, String> classUnderTest();

    protected abstract ImmutableSortedMap<Integer, String> classUnderTest(Comparator<? super Integer> comparator);

    /**
     * @return Size (and max key) of {@link #classUnderTest()}.
     */
    protected abstract int size();

    @Test
    public void castToSortedMap() {
        ImmutableSortedMap<Integer, String> immutable = this.classUnderTest();
        SortedMap<Integer, String> map = immutable.castToSortedMap();
        Assert.assertSame(immutable, map);
        Assert.assertEquals(immutable, new HashMap<>(map));
        ImmutableSortedMap<Integer, String> revImmutable = this.classUnderTest(REV_INT_COMPARATOR);
        SortedMap<Integer, String> revMap = revImmutable.castToSortedMap();
        Assert.assertSame(revImmutable, revMap);
        Assert.assertEquals(revImmutable, new HashMap<>(revMap));
    }

    @Override
    @Test
    public void toSortedMap() {
        super.toSortedMap();
        ImmutableSortedMap<Integer, String> immutable = this.classUnderTest();
        MutableSortedMap<Integer, String> map = immutable.toSortedMap();
        Assert.assertNotSame(immutable, map);
        Assert.assertEquals(immutable, map);
        ImmutableSortedMap<Integer, String> revImmutable = this.classUnderTest(REV_INT_COMPARATOR);
        MutableSortedMap<Integer, String> revMap = revImmutable.toSortedMap();
        Assert.assertNotSame(revImmutable, revMap);
        Assert.assertEquals(revImmutable, revMap);
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        MutableMap<Integer, String> expected = this.equalUnifiedMap();
        MutableSortedMap<Integer, String> sortedMap = this.equalSortedMap();
        Verify.assertEqualsAndHashCode(expected, this.classUnderTest());
        Verify.assertEqualsAndHashCode(sortedMap, this.classUnderTest());
        Verify.assertEqualsAndHashCode(expected, this.classUnderTest(REV_INT_COMPARATOR));
        Verify.assertEqualsAndHashCode(sortedMap, this.classUnderTest(REV_INT_COMPARATOR));
    }

    @Override
    @Test
    public void forEachKeyValue() {
        super.forEachKeyValue();
        MutableList<Integer> actualKeys = Lists.mutable.empty();
        MutableList<String> actualValues = Lists.mutable.empty();
        this.classUnderTest().forEachKeyValue((key, value) -> {
            actualKeys.add(key);
            actualValues.add(value);
        });
        MutableList<Integer> expectedKeys = this.expectedKeys();
        Verify.assertListsEqual(expectedKeys, actualKeys);
        MutableList<String> expectedValues = expectedKeys.collect(String::valueOf);
        Verify.assertListsEqual(expectedValues, actualValues);
        MutableList<Integer> revActualKeys = Lists.mutable.empty();
        MutableList<String> revActualValues = Lists.mutable.empty();
        this.classUnderTest(REV_INT_COMPARATOR).forEachKeyValue((key, value) -> {
            revActualKeys.add(key);
            revActualValues.add(value);
        });
        MutableList<Integer> reverseKeys = expectedKeys.reverseThis();
        Verify.assertListsEqual(reverseKeys, revActualKeys);
        MutableList<String> reverseValues = expectedValues.reverseThis();
        Verify.assertListsEqual(reverseValues, revActualValues);
    }

    @Override
    @Test
    public void forEachValue() {
        super.forEachValue();
        MutableList<String> actualValues = Lists.mutable.empty();
        this.classUnderTest().forEachValue(CollectionAddProcedure.on(actualValues));
        Verify.assertListsEqual(this.expectedValues(), actualValues);
        MutableList<String> revActualValues = Lists.mutable.empty();
        this.classUnderTest(REV_INT_COMPARATOR).forEachValue(CollectionAddProcedure.on(revActualValues));
        Verify.assertListsEqual(this.expectedValues().reverseThis(), revActualValues);
    }

    @Override
    @Test
    public void tap() {
        super.tap();
        MutableList<String> tapResult = Lists.mutable.empty();
        ImmutableSortedMap<Integer, String> map = this.classUnderTest();
        Assert.assertSame(map, map.tap(tapResult::add));
        Assert.assertEquals(map.toList(), tapResult);
        MutableList<String> revTapResult = Lists.mutable.empty();
        ImmutableSortedMap<Integer, String> revMap = this.classUnderTest(REV_INT_COMPARATOR);
        Assert.assertSame(revMap, revMap.tap(revTapResult::add));
        Assert.assertEquals(revMap.toList(), revTapResult);
    }

    @Override
    @Test
    public void forEach() {
        super.forEach();
        MutableList<String> actualValues = Lists.mutable.empty();
        this.classUnderTest().forEach(CollectionAddProcedure.on(actualValues));
        Verify.assertListsEqual(this.expectedValues(), actualValues);
        MutableList<String> revActualValues = Lists.mutable.empty();
        this.classUnderTest(REV_INT_COMPARATOR).forEach(CollectionAddProcedure.on(revActualValues));
        Verify.assertListsEqual(this.expectedValues().reverseThis(), revActualValues);
    }

    @Override
    @Test
    public void iterator() {
        super.iterator();
        MutableList<String> actualValues = Lists.mutable.empty();
        for (String eachValue : this.classUnderTest()) {
            actualValues.add(eachValue);
        }
        Verify.assertListsEqual(this.expectedValues(), actualValues);
        MutableList<String> revActualValues = Lists.mutable.empty();
        for (String eachValue : this.classUnderTest(REV_INT_COMPARATOR)) {
            revActualValues.add(eachValue);
        }
        Verify.assertListsEqual(this.expectedValues().reverseThis(), revActualValues);
    }

    @Test
    public void iteratorThrows() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> {
            Iterator<String> iterator = this.classUnderTest().iterator();
            iterator.remove();
        });
    }

    @Override
    @Test
    public void forEachKey() {
        super.forEachKey();
        MutableList<Integer> actualKeys = Lists.mutable.empty();
        this.classUnderTest().forEachKey(CollectionAddProcedure.on(actualKeys));
        Verify.assertListsEqual(this.expectedKeys(), actualKeys);
        MutableList<Integer> revActualKeys = Lists.mutable.empty();
        this.classUnderTest(REV_INT_COMPARATOR).forEachKey(CollectionAddProcedure.on(revActualKeys));
        Verify.assertListsEqual(this.expectedKeys().reverseThis(), revActualKeys);
    }

    @Test
    public void get() {
        // Absent key behavior
        ImmutableSortedMap<Integer, String> classUnderTest = this.classUnderTest();
        Integer absentKey = this.size() + 1;
        Assert.assertNull(classUnderTest.get(absentKey));
        String absentValue = String.valueOf(absentKey);
        Assert.assertFalse(classUnderTest.containsValue(absentValue));
        // Present key behavior
        Assert.assertEquals("1", classUnderTest.get(1));
        // Still unchanged
        Assert.assertEquals(this.equalUnifiedMap(), classUnderTest);
    }

    @Override
    @Test
    public void getOrDefault() {
        super.getOrDefault();
        Integer absentKey = this.size() + 1;
        String absentValue = String.valueOf(absentKey);
        // Absent key behavior
        ImmutableSortedMap<Integer, String> classUnderTest = this.classUnderTest();
        Assert.assertEquals(absentValue, classUnderTest.getOrDefault(absentKey, absentValue));
        // Present key behavior
        Assert.assertEquals("1", classUnderTest.getOrDefault(1, absentValue));
        // Still unchanged
        Assert.assertEquals(this.equalUnifiedMap(), classUnderTest);
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        Integer absentKey = this.size() + 1;
        String absentValue = String.valueOf(absentKey);
        // Absent key behavior
        ImmutableSortedMap<Integer, String> classUnderTest = this.classUnderTest();
        Assert.assertEquals(absentValue, classUnderTest.getIfAbsent(absentKey, new PassThruFunction0<>(absentValue)));
        // Present key behavior
        Assert.assertEquals("1", classUnderTest.getIfAbsent(1, new PassThruFunction0<>(absentValue)));
        // Still unchanged
        Assert.assertEquals(this.equalUnifiedMap(), classUnderTest);
    }

    @Test
    public void getIfAbsentValue() {
        Integer absentKey = this.size() + 1;
        String absentValue = String.valueOf(absentKey);
        // Absent key behavior
        ImmutableSortedMap<Integer, String> classUnderTest = this.classUnderTest();
        Assert.assertEquals(absentValue, classUnderTest.getIfAbsentValue(absentKey, absentValue));
        // Present key behavior
        Assert.assertEquals("1", classUnderTest.getIfAbsentValue(1, absentValue));
        // Still unchanged
        Assert.assertEquals(this.equalUnifiedMap(), classUnderTest);
    }

    @Override
    @Test
    public void getIfAbsentWith() {
        super.getIfAbsentWith();
        Integer absentKey = this.size() + 1;
        String absentValue = String.valueOf(absentKey);
        // Absent key behavior
        ImmutableSortedMap<Integer, String> classUnderTest = this.classUnderTest();
        Assert.assertEquals(absentValue, classUnderTest.getIfAbsentWith(absentKey, String::valueOf, absentValue));
        // Present key behavior
        Assert.assertEquals("1", classUnderTest.getIfAbsentWith(1, String::valueOf, absentValue));
        // Still unchanged
        Assert.assertEquals(this.equalUnifiedMap(), classUnderTest);
    }

    @Override
    @Test
    public void forEachWith() {
        super.forEachWith();
        Object actualParameter = new Object();
        MutableList<String> actualValues = Lists.mutable.empty();
        MutableList<Object> actualParameters = Lists.mutable.empty();
        this.classUnderTest().forEachWith((eachValue, parameter) -> {
            actualValues.add(eachValue);
            actualParameters.add(parameter);
        }, actualParameter);
        Verify.assertListsEqual(this.expectedKeys().collect(String::valueOf), actualValues);
        Verify.assertListsEqual(Collections.nCopies(this.size(), actualParameter), actualParameters);
        MutableList<String> revActualValues = Lists.mutable.empty();
        MutableList<Object> revActualParameters = Lists.mutable.empty();
        this.classUnderTest(REV_INT_COMPARATOR).forEachWith((eachValue, parameter) -> {
            revActualValues.add(eachValue);
            revActualParameters.add(parameter);
        }, actualParameter);
        Verify.assertListsEqual(this.expectedKeys().collect(String::valueOf).reverseThis(), revActualValues);
        Verify.assertListsEqual(Collections.nCopies(this.size(), actualParameter), revActualParameters);
    }

    @Override
    @Test
    public void forEachWithIndex() {
        super.forEachWithIndex();
        MutableList<String> actualValues = Lists.mutable.empty();
        MutableList<Integer> actualIndices = Lists.mutable.empty();
        this.classUnderTest().forEachWithIndex((eachValue, index) -> {
            actualValues.add(eachValue);
            actualIndices.add(index);
        });
        Verify.assertListsEqual(this.expectedKeys().collect(String::valueOf), actualValues);
        Verify.assertListsEqual(this.expectedIndices(), actualIndices);
        MutableList<String> revActualValues = Lists.mutable.empty();
        MutableList<Integer> revActualIndices = Lists.mutable.empty();
        this.classUnderTest(REV_INT_COMPARATOR).forEachWithIndex((eachValue, index) -> {
            revActualValues.add(eachValue);
            revActualIndices.add(index);
        });
        Verify.assertListsEqual(this.expectedKeys().collect(String::valueOf).reverseThis(), revActualValues);
        Verify.assertListsEqual(this.expectedIndices(), revActualIndices);
    }

    @Override
    @Test
    public void valuesView() {
        super.valuesView();
        MutableList<String> actualValues = Lists.mutable.empty();
        for (String eachValue : this.classUnderTest().valuesView()) {
            actualValues.add(eachValue);
        }
        MutableList<String> expectedValues = this.expectedValues();
        Verify.assertListsEqual(expectedValues, actualValues);
        MutableList<String> revActualValues = Lists.mutable.empty();
        for (String eachValue : this.classUnderTest(REV_INT_COMPARATOR).valuesView()) {
            revActualValues.add(eachValue);
        }
        Verify.assertListsEqual(this.expectedValues().reverseThis(), revActualValues);
    }

    @Override
    @Test
    public void keysView() {
        super.keysView();
        MutableList<Integer> actualKeys = Lists.mutable.empty();
        for (Integer eachKey : this.classUnderTest().keysView()) {
            actualKeys.add(eachKey);
        }
        Verify.assertListsEqual(this.expectedKeys(), actualKeys);
        MutableList<Integer> revActualKeys = Lists.mutable.empty();
        for (Integer eachKey : this.classUnderTest(REV_INT_COMPARATOR).keysView()) {
            revActualKeys.add(eachKey);
        }
        Verify.assertListsEqual(this.expectedKeys().reverseThis(), revActualKeys);
    }

    @Test
    public void putAll() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> ((Map<Integer, String>) this.classUnderTest()).putAll(null));
    }

    @Test
    public void clear() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> ((Map<Integer, String>) this.classUnderTest()).clear());
    }

    @Test
    public void entrySet() {
        ImmutableSortedMap<Integer, String> immutableSortedMap = this.classUnderTest();
        Map<Integer, String> map = new HashMap<>(immutableSortedMap.castToSortedMap());
        Assert.assertEquals(map.entrySet(), immutableSortedMap.castToSortedMap().entrySet());
        Set<Map.Entry<Integer, String>> entries = immutableSortedMap.castToSortedMap().entrySet();
        MutableList<Map.Entry<Integer, String>> entriesList = FastList.newList(entries);
        MutableList<Map.Entry<Integer, String>> sortedEntryList = entriesList.toSortedListBy(Functions.getKeyFunction());
        Assert.assertEquals(sortedEntryList, entriesList);
    }

    @Override
    @Test
    public void selectMap() {
        super.selectMap();
        ImmutableSortedMap<Integer, String> map = this.classUnderTest();
        ImmutableSortedMap<Integer, String> select = map.select((argument1, argument2) -> argument1 < this.size());
        Verify.assertListsEqual(Interval.oneTo(this.size() - 1), select.keysView().toList());
        Verify.assertListsEqual(Interval.oneTo(this.size() - 1).collect(String::valueOf).toList(), select.valuesView().toList());
        ImmutableSortedMap<Integer, String> revMap = this.classUnderTest(REV_INT_COMPARATOR);
        ImmutableSortedMap<Integer, String> revSelect = revMap.select((argument1, argument2) -> argument1 < this.size());
        Verify.assertListsEqual(Interval.oneTo(this.size() - 1).reverseThis(), revSelect.keysView().toList());
        Verify.assertListsEqual(Interval.oneTo(this.size() - 1).collect(String::valueOf).toList().reverseThis(), revSelect.valuesView().toList());
    }

    @Override
    @Test
    public void rejectMap() {
        super.rejectMap();
        ImmutableSortedMap<Integer, String> map = this.classUnderTest();
        ImmutableSortedMap<Integer, String> reject = map.reject((argument1, argument2) -> argument1 == 1);
        Verify.assertListsEqual(Interval.fromTo(2, this.size()), reject.keysView().toList());
        Verify.assertListsEqual(Interval.fromTo(2, this.size()).collect(String::valueOf).toList(), reject.valuesView().toList());
        ImmutableSortedMap<Integer, String> revMap = this.classUnderTest(REV_INT_COMPARATOR);
        ImmutableSortedMap<Integer, String> revReject = revMap.reject((argument1, argument2) -> argument1 == 1);
        Verify.assertListsEqual(Interval.fromTo(2, this.size()).reverseThis(), revReject.keysView().toList());
        Verify.assertListsEqual(Interval.fromTo(2, this.size()).collect(String::valueOf).toList().reverseThis(), revReject.valuesView().toList());
    }

    @Override
    @Test
    public void collectMap() {
        super.collectMap();
        ImmutableSortedMap<Integer, String> map = this.classUnderTest();
        Function2<Integer, String, Pair<String, Integer>> function = (Integer argument1, String argument2) -> Tuples.pair(argument2, argument1);
        ImmutableMap<String, Integer> collect = map.collect(function);
        Verify.assertSetsEqual(Interval.oneTo(this.size()).collect(String::valueOf).toSet(), collect.keysView().toSet());
        Verify.assertSetsEqual(Interval.oneTo(this.size()).toSet(), collect.valuesView().toSet());
        ImmutableSortedMap<Integer, String> revMap = this.classUnderTest(REV_INT_COMPARATOR);
        ImmutableMap<String, Integer> revCollect = revMap.collect(function);
        Verify.assertSetsEqual(Interval.oneTo(this.size()).collect(String::valueOf).toSet(), revCollect.keysView().toSet());
        Verify.assertSetsEqual(Interval.oneTo(this.size()).toSet(), revCollect.valuesView().toSet());
    }

    @Override
    @Test
    public void collectValues() {
        super.collectValues();
        ImmutableSortedMap<Integer, String> map = this.classUnderTest();
        ImmutableSortedMap<Integer, Integer> result = map.collectValues((argument1, argument2) -> argument1);
        Verify.assertListsEqual(result.keysView().toList(), result.valuesView().toList());
        ImmutableSortedMap<Integer, String> revMap = this.classUnderTest(REV_INT_COMPARATOR);
        ImmutableSortedMap<Integer, Integer> revResult = revMap.collectValues((argument1, argument2) -> argument1);
        Verify.assertListsEqual(revResult.keysView().toList(), revResult.valuesView().toList());
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex() {
        ImmutableSortedMap<Integer, String> integers = this.classUnderTest();
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair("1", 0), PrimitiveTuples.pair("2", 1), PrimitiveTuples.pair("3", 2), PrimitiveTuples.pair("4", 3)), integers.collectWithIndex(PrimitiveTuples::pair));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget() {
        ImmutableSortedMap<Integer, String> integers = this.classUnderTest();
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair("1", 0), PrimitiveTuples.pair("2", 1), PrimitiveTuples.pair("3", 2), PrimitiveTuples.pair("4", 3)), integers.collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty()));
    }

    /**
     * @since 11.0.
     */
    @Test
    public void selectWithIndexWithTarget() {
        ImmutableSortedMap<Integer, String> integers = this.classUnderTest();
        Assert.assertEquals(Lists.mutable.with("1", "3"), integers.selectWithIndex((each, index) -> index % 2 == 0, Lists.mutable.empty()));
    }

    /**
     * @since 11.0.
     */
    @Test
    public void rejectWithIndexWithTarget() {
        ImmutableSortedMap<Integer, String> integers = this.classUnderTest();
        Assert.assertEquals(Lists.mutable.with("2", "4"), integers.rejectWithIndex((each, index) -> index % 2 == 0, Lists.mutable.empty()));
    }

    @Test
    public void newWithKeyValue() {
        ImmutableSortedMap<Integer, String> immutable = this.classUnderTest();
        ImmutableSortedMap<Integer, String> immutable2 = immutable.newWithKeyValue(Integer.MAX_VALUE, Integer.toString(Integer.MAX_VALUE));
        Verify.assertSize(immutable.size() + 1, immutable2.castToSortedMap());
    }

    @Test
    public void newWithAllKeyValuePairs() {
        ImmutableSortedMap<Integer, String> immutable = this.classUnderTest();
        ImmutableSortedMap<Integer, String> immutable2 = immutable.newWithAllKeyValueArguments(Tuples.pair(Integer.MAX_VALUE, Integer.toString(Integer.MAX_VALUE)), Tuples.pair(Integer.MIN_VALUE, Integer.toString(Integer.MIN_VALUE)));
        Verify.assertSize(immutable.size() + 2, immutable2.castToSortedMap());
    }

    @Test
    public void newWithAllKeyValues() {
        ImmutableSortedMap<Integer, String> immutable = this.classUnderTest();
        ImmutableSortedMap<Integer, String> immutable2 = immutable.newWithAllKeyValues(ArrayAdapter.newArrayWith(Tuples.pair(Integer.MAX_VALUE, Integer.toString(Integer.MAX_VALUE)), Tuples.pair(Integer.MIN_VALUE, Integer.toString(Integer.MIN_VALUE))));
        Verify.assertSize(immutable.size() + 2, immutable2.castToSortedMap());
    }

    @Test
    public void newWithMap() {
        ImmutableSortedMap<Integer, String> immutable = this.classUnderTest();
        ImmutableSortedMap<Integer, String> immutable2 = immutable.newWithMap(UnifiedMap.newMapWith(Tuples.pair(Integer.MAX_VALUE, Integer.toString(Integer.MAX_VALUE)), Tuples.pair(Integer.MIN_VALUE, Integer.toString(Integer.MIN_VALUE))));
        Verify.assertSize(immutable.size() + 2, immutable2.castToSortedMap());
    }

    @Test
    public void newWithMapIterable() {
        ImmutableSortedMap<Integer, String> immutable = this.classUnderTest();
        ImmutableSortedMap<Integer, String> immutable2 = immutable.newWithMapIterable(Maps.immutable.of(Integer.MAX_VALUE, Integer.toString(Integer.MAX_VALUE), Integer.MIN_VALUE, Integer.toString(Integer.MIN_VALUE)));
        Verify.assertSize(immutable.size() + 2, immutable2.castToSortedMap());
    }

    @Test
    public void newWithoutKey() {
        ImmutableSortedMap<Integer, String> immutable = this.classUnderTest();
        ImmutableSortedMap<Integer, String> immutable3 = immutable.newWithoutKey(Integer.MAX_VALUE);
        Verify.assertSize(immutable.size(), immutable3.castToSortedMap());
    }

    @Test
    public void newWithoutAllKeys() {
        ImmutableSortedMap<Integer, String> immutable = this.classUnderTest();
        ImmutableSortedMap<Integer, String> immutable2 = immutable.newWithoutAllKeys(immutable.keysView());
        ImmutableSortedMap<Integer, String> immutable3 = immutable.newWithoutAllKeys(Lists.immutable.of());
        Assert.assertEquals(immutable, immutable3);
        Assert.assertEquals(Maps.immutable.of(), immutable2);
    }

    @Test
    public void toImmutable() {
        ImmutableSortedMap<Integer, String> immutableSortedMap = this.classUnderTest();
        Assert.assertSame(immutableSortedMap, immutableSortedMap.toImmutable());
    }

    @Test
    public void put() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> ((Map<Integer, String>) this.classUnderTest()).put(null, null));
    }

    @Test
    public void remove() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> ((Map<Integer, String>) this.classUnderTest()).remove(null));
    }

    @Test
    public abstract void testToString();

    @Test
    public void take() {
        ImmutableSortedMap<Integer, String> strings1 = this.classUnderTest();
        Assert.assertEquals(SortedMaps.immutable.of(strings1.comparator()), strings1.take(0));
        Assert.assertSame(strings1.comparator(), strings1.take(0).comparator());
        Assert.assertEquals(SortedMaps.immutable.of(strings1.comparator(), 1, "1", 2, "2", 3, "3"), strings1.take(3));
        Assert.assertSame(strings1.comparator(), strings1.take(3).comparator());
        Assert.assertEquals(SortedMaps.immutable.of(strings1.comparator(), 1, "1", 2, "2", 3, "3"), strings1.take(strings1.size() - 1));
        ImmutableSortedMap<Integer, String> strings2 = this.classUnderTest(Comparators.reverseNaturalOrder());
        Assert.assertSame(strings2, strings2.take(strings2.size()));
        Assert.assertSame(strings2, strings2.take(10));
        Assert.assertSame(strings2, strings2.take(Integer.MAX_VALUE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void take_throws() {
        this.classUnderTest().take(-1);
    }

    @Test
    public void drop() {
        ImmutableSortedMap<Integer, String> strings1 = this.classUnderTest();
        Assert.assertSame(strings1, strings1.drop(0));
        Assert.assertSame(strings1.comparator(), strings1.drop(0).comparator());
        Assert.assertEquals(SortedMaps.immutable.of(strings1.comparator(), 4, "4"), strings1.drop(3));
        Assert.assertSame(strings1.comparator(), strings1.drop(3).comparator());
        Assert.assertEquals(SortedMaps.immutable.of(strings1.comparator(), 4, "4"), strings1.drop(strings1.size() - 1));
        ImmutableSortedMap<Integer, String> expectedMap = SortedMaps.immutable.of(Comparators.reverseNaturalOrder());
        ImmutableSortedMap<Integer, String> strings2 = this.classUnderTest(Comparators.reverseNaturalOrder());
        Assert.assertEquals(expectedMap, strings2.drop(strings2.size()));
        Assert.assertEquals(expectedMap, strings2.drop(10));
        Assert.assertEquals(expectedMap, strings2.drop(Integer.MAX_VALUE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void drop_throws() {
        this.classUnderTest().drop(-1);
    }

    protected MutableMap<Integer, String> equalUnifiedMap() {
        MutableMap<Integer, String> expected = UnifiedMap.newMap();
        for (int i = 1; i <= this.size(); i++) {
            expected.put(i, String.valueOf(i));
        }
        return expected;
    }

    protected MutableSortedMap<Integer, String> equalSortedMap() {
        MutableSortedMap<Integer, String> expected = TreeSortedMap.newMap();
        for (int i = 1; i <= this.size(); i++) {
            expected.put(i, String.valueOf(i));
        }
        return expected;
    }

    private MutableList<String> expectedValues() {
        return this.expectedKeys().collect(String::valueOf);
    }

    private MutableList<Integer> expectedKeys() {
        if (this.size() == 0) {
            return Lists.mutable.empty();
        }
        return Interval.oneTo(this.size()).toList();
    }

    private MutableList<Integer> expectedIndices() {
        if (this.size() == 0) {
            return Lists.mutable.empty();
        }
        return Interval.zeroTo(this.size() - 1).toList();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableSortedMapTestCase instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
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
        public void benchmark_injectIntoKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
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
        public void benchmark_test_toString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.test_toString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_castToSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.castToSortedMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
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
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorThrows);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
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
        public void benchmark_getIfAbsentValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentWith);
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
        public void benchmark_valuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet);
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
        public void benchmark_collectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAllKeyValuePairs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAllKeyValuePairs);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAllKeyValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithMapIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithMapIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAllKeys);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop_throws);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new ImmutableSortedMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> test_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> castToSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> iteratorThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> getIfAbsentValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> entrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> newWithAllKeyValuePairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> newWithAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> newWithMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> newWithMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> newWithoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> newWithoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedMapTestCase> drop_throws;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = ImmutableSortedMapTestCase::stream;
            this.payloads.parallelStream = ImmutableSortedMapTestCase::parallelStream;
            this.payloads.serialization = ImmutableSortedMapTestCase::serialization;
            this.payloads.isEmpty = ImmutableSortedMapTestCase::isEmpty;
            this.payloads.notEmpty = ImmutableSortedMapTestCase::notEmpty;
            this.payloads.ifPresentApply = ImmutableSortedMapTestCase::ifPresentApply;
            this.payloads.getIfAbsent_function = ImmutableSortedMapTestCase::getIfAbsent_function;
            this.payloads.injectIntoKeyValue = ImmutableSortedMapTestCase::injectIntoKeyValue;
            this.payloads.flipUniqueValues = ImmutableSortedMapTestCase::flipUniqueValues;
            this.payloads.collectBoolean = ImmutableSortedMapTestCase::collectBoolean;
            this.payloads.collectBooleanWithTarget = ImmutableSortedMapTestCase::collectBooleanWithTarget;
            this.payloads.collectByte = ImmutableSortedMapTestCase::collectByte;
            this.payloads.collectByteWithTarget = ImmutableSortedMapTestCase::collectByteWithTarget;
            this.payloads.collectChar = ImmutableSortedMapTestCase::collectChar;
            this.payloads.collectCharWithTarget = ImmutableSortedMapTestCase::collectCharWithTarget;
            this.payloads.collectDouble = ImmutableSortedMapTestCase::collectDouble;
            this.payloads.collectDoubleWithTarget = ImmutableSortedMapTestCase::collectDoubleWithTarget;
            this.payloads.collectFloat = ImmutableSortedMapTestCase::collectFloat;
            this.payloads.collectFloatWithTarget = ImmutableSortedMapTestCase::collectFloatWithTarget;
            this.payloads.collectInt = ImmutableSortedMapTestCase::collectInt;
            this.payloads.collectIntWithTarget = ImmutableSortedMapTestCase::collectIntWithTarget;
            this.payloads.collectLong = ImmutableSortedMapTestCase::collectLong;
            this.payloads.collectLongWithTarget = ImmutableSortedMapTestCase::collectLongWithTarget;
            this.payloads.collectShort = ImmutableSortedMapTestCase::collectShort;
            this.payloads.collectShortWithTarget = ImmutableSortedMapTestCase::collectShortWithTarget;
            this.payloads.select = ImmutableSortedMapTestCase::select;
            this.payloads.selectWith = ImmutableSortedMapTestCase::selectWith;
            this.payloads.reject = ImmutableSortedMapTestCase::reject;
            this.payloads.rejectWith = ImmutableSortedMapTestCase::rejectWith;
            this.payloads.collect = ImmutableSortedMapTestCase::collect;
            this.payloads.flatCollect = ImmutableSortedMapTestCase::flatCollect;
            this.payloads.flatCollectWith = ImmutableSortedMapTestCase::flatCollectWith;
            this.payloads.flip = ImmutableSortedMapTestCase::flip;
            this.payloads.detect = ImmutableSortedMapTestCase::detect;
            this.payloads.detectOptional = ImmutableSortedMapTestCase::detectOptional;
            this.payloads.anySatisfy = ImmutableSortedMapTestCase::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableSortedMapTestCase::anySatisfyWith;
            this.payloads.allSatisfy = ImmutableSortedMapTestCase::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableSortedMapTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableSortedMapTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableSortedMapTestCase::noneSatisfyWith;
            this.payloads.appendString = ImmutableSortedMapTestCase::appendString;
            this.payloads.toBag = ImmutableSortedMapTestCase::toBag;
            this.payloads.toSortedBag = ImmutableSortedMapTestCase::toSortedBag;
            this.payloads.toSortedBagBy = ImmutableSortedMapTestCase::toSortedBagBy;
            this.payloads.asLazy = ImmutableSortedMapTestCase::asLazy;
            this.payloads.toList = ImmutableSortedMapTestCase::toList;
            this.payloads.toMap = ImmutableSortedMapTestCase::toMap;
            this.payloads.toSet = ImmutableSortedMapTestCase::toSet;
            this.payloads.toSortedList = ImmutableSortedMapTestCase::toSortedList;
            this.payloads.toSortedListBy = ImmutableSortedMapTestCase::toSortedListBy;
            this.payloads.toSortedSet = ImmutableSortedMapTestCase::toSortedSet;
            this.payloads.toSortedSetBy = ImmutableSortedMapTestCase::toSortedSetBy;
            this.payloads.chunk = ImmutableSortedMapTestCase::chunk;
            this.payloads.collect_value = ImmutableSortedMapTestCase::collect_value;
            this.payloads.collectIf = ImmutableSortedMapTestCase::collectIf;
            this.payloads.collectWith = ImmutableSortedMapTestCase::collectWith;
            this.payloads.collectWithToTarget = ImmutableSortedMapTestCase::collectWithToTarget;
            this.payloads.contains = ImmutableSortedMapTestCase::contains;
            this.payloads.containsAnyIterable = ImmutableSortedMapTestCase::containsAnyIterable;
            this.payloads.containsNoneIterable = ImmutableSortedMapTestCase::containsNoneIterable;
            this.payloads.containsAnyCollection = ImmutableSortedMapTestCase::containsAnyCollection;
            this.payloads.containsNoneCollection = ImmutableSortedMapTestCase::containsNoneCollection;
            this.payloads.containsAll = ImmutableSortedMapTestCase::containsAll;
            this.payloads.containsKey = ImmutableSortedMapTestCase::containsKey;
            this.payloads.containsValue = ImmutableSortedMapTestCase::containsValue;
            this.payloads.getFirst = ImmutableSortedMapTestCase::getFirst;
            this.payloads.getLast = ImmutableSortedMapTestCase::getLast;
            this.payloads.getOnly = ImmutableSortedMapTestCase::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedMapTestCase::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedMapTestCase::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = ImmutableSortedMapTestCase::containsAllIterable;
            this.payloads.containsAllArguments = ImmutableSortedMapTestCase::containsAllArguments;
            this.payloads.count = ImmutableSortedMapTestCase::count;
            this.payloads.countWith = ImmutableSortedMapTestCase::countWith;
            this.payloads.detect_value = ImmutableSortedMapTestCase::detect_value;
            this.payloads.detectOptional_value = ImmutableSortedMapTestCase::detectOptional_value;
            this.payloads.detectWith = ImmutableSortedMapTestCase::detectWith;
            this.payloads.detectWithOptional = ImmutableSortedMapTestCase::detectWithOptional;
            this.payloads.detectIfNone_value = ImmutableSortedMapTestCase::detectIfNone_value;
            this.payloads.detectWithIfNone = ImmutableSortedMapTestCase::detectWithIfNone;
            this.payloads.flatten_value = ImmutableSortedMapTestCase::flatten_value;
            this.payloads.countBy = ImmutableSortedMapTestCase::countBy;
            this.payloads.countByWith = ImmutableSortedMapTestCase::countByWith;
            this.payloads.countByEach = ImmutableSortedMapTestCase::countByEach;
            this.payloads.groupBy = ImmutableSortedMapTestCase::groupBy;
            this.payloads.groupByEach = ImmutableSortedMapTestCase::groupByEach;
            this.payloads.groupByUniqueKey = ImmutableSortedMapTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedMapTestCase::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ImmutableSortedMapTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedMapTestCase::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = ImmutableSortedMapTestCase::injectInto;
            this.payloads.injectIntoInt = ImmutableSortedMapTestCase::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableSortedMapTestCase::injectIntoLong;
            this.payloads.injectIntoFloat = ImmutableSortedMapTestCase::injectIntoFloat;
            this.payloads.injectIntoDouble = ImmutableSortedMapTestCase::injectIntoDouble;
            this.payloads.sumOfInt = ImmutableSortedMapTestCase::sumOfInt;
            this.payloads.sumOfLong = ImmutableSortedMapTestCase::sumOfLong;
            this.payloads.testAggregateBy = ImmutableSortedMapTestCase::testAggregateBy;
            this.payloads.sumOfFloat = ImmutableSortedMapTestCase::sumOfFloat;
            this.payloads.sumOfDouble = ImmutableSortedMapTestCase::sumOfDouble;
            this.payloads.sumByInt = ImmutableSortedMapTestCase::sumByInt;
            this.payloads.sumByFloat = ImmutableSortedMapTestCase::sumByFloat;
            this.payloads.sumByLong = ImmutableSortedMapTestCase::sumByLong;
            this.payloads.sumByDouble = ImmutableSortedMapTestCase::sumByDouble;
            this.payloads.makeString = ImmutableSortedMapTestCase::makeString;
            this.payloads.min = ImmutableSortedMapTestCase::min;
            this.payloads.max = ImmutableSortedMapTestCase::max;
            this.payloads.minBy = ImmutableSortedMapTestCase::minBy;
            this.payloads.maxBy = ImmutableSortedMapTestCase::maxBy;
            this.payloads.reject_value = ImmutableSortedMapTestCase::reject_value;
            this.payloads.rejectWith_value = ImmutableSortedMapTestCase::rejectWith_value;
            this.payloads.select_value = ImmutableSortedMapTestCase::select_value;
            this.payloads.selectWith_value = ImmutableSortedMapTestCase::selectWith_value;
            this.payloads.partition_value = ImmutableSortedMapTestCase::partition_value;
            this.payloads.partitionWith_value = ImmutableSortedMapTestCase::partitionWith_value;
            this.payloads.selectInstancesOf_value = ImmutableSortedMapTestCase::selectInstancesOf_value;
            this.payloads.toArray = ImmutableSortedMapTestCase::toArray;
            this.payloads.zip = ImmutableSortedMapTestCase::zip;
            this.payloads.zipWithIndex = ImmutableSortedMapTestCase::zipWithIndex;
            this.payloads.aggregateByMutating = ImmutableSortedMapTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableSortedMapTestCase::aggregateByNonMutating;
            this.payloads.keyValuesView = ImmutableSortedMapTestCase::keyValuesView;
            this.payloads.nullCollisionWithCastInEquals = ImmutableSortedMapTestCase::nullCollisionWithCastInEquals;
            this.payloads.testNewMap = ImmutableSortedMapTestCase::testNewMap;
            this.payloads.testNewMapWithKeyValue = ImmutableSortedMapTestCase::testNewMapWithKeyValue;
            this.payloads.newMapWithWith = ImmutableSortedMapTestCase::newMapWithWith;
            this.payloads.newMapWithWithWith = ImmutableSortedMapTestCase::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = ImmutableSortedMapTestCase::newMapWithWithWithWith;
            this.payloads.test_toString = ImmutableSortedMapTestCase::test_toString;
            this.payloads.castToSortedMap = ImmutableSortedMapTestCase::castToSortedMap;
            this.payloads.toSortedMap = ImmutableSortedMapTestCase::toSortedMap;
            this.payloads.equalsAndHashCode = ImmutableSortedMapTestCase::equalsAndHashCode;
            this.payloads.forEachKeyValue = ImmutableSortedMapTestCase::forEachKeyValue;
            this.payloads.forEachValue = ImmutableSortedMapTestCase::forEachValue;
            this.payloads.tap = ImmutableSortedMapTestCase::tap;
            this.payloads.forEach = ImmutableSortedMapTestCase::forEach;
            this.payloads.iterator = ImmutableSortedMapTestCase::iterator;
            this.payloads.iteratorThrows = ImmutableSortedMapTestCase::iteratorThrows;
            this.payloads.forEachKey = ImmutableSortedMapTestCase::forEachKey;
            this.payloads.get = ImmutableSortedMapTestCase::get;
            this.payloads.getOrDefault = ImmutableSortedMapTestCase::getOrDefault;
            this.payloads.getIfAbsent = ImmutableSortedMapTestCase::getIfAbsent;
            this.payloads.getIfAbsentValue = ImmutableSortedMapTestCase::getIfAbsentValue;
            this.payloads.getIfAbsentWith = ImmutableSortedMapTestCase::getIfAbsentWith;
            this.payloads.forEachWith = ImmutableSortedMapTestCase::forEachWith;
            this.payloads.forEachWithIndex = ImmutableSortedMapTestCase::forEachWithIndex;
            this.payloads.valuesView = ImmutableSortedMapTestCase::valuesView;
            this.payloads.keysView = ImmutableSortedMapTestCase::keysView;
            this.payloads.putAll = ImmutableSortedMapTestCase::putAll;
            this.payloads.clear = ImmutableSortedMapTestCase::clear;
            this.payloads.entrySet = ImmutableSortedMapTestCase::entrySet;
            this.payloads.selectMap = ImmutableSortedMapTestCase::selectMap;
            this.payloads.rejectMap = ImmutableSortedMapTestCase::rejectMap;
            this.payloads.collectMap = ImmutableSortedMapTestCase::collectMap;
            this.payloads.collectValues = ImmutableSortedMapTestCase::collectValues;
            this.payloads.collectWithIndex = ImmutableSortedMapTestCase::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ImmutableSortedMapTestCase::collectWithIndexWithTarget;
            this.payloads.selectWithIndexWithTarget = ImmutableSortedMapTestCase::selectWithIndexWithTarget;
            this.payloads.rejectWithIndexWithTarget = ImmutableSortedMapTestCase::rejectWithIndexWithTarget;
            this.payloads.newWithKeyValue = ImmutableSortedMapTestCase::newWithKeyValue;
            this.payloads.newWithAllKeyValuePairs = ImmutableSortedMapTestCase::newWithAllKeyValuePairs;
            this.payloads.newWithAllKeyValues = ImmutableSortedMapTestCase::newWithAllKeyValues;
            this.payloads.newWithMap = ImmutableSortedMapTestCase::newWithMap;
            this.payloads.newWithMapIterable = ImmutableSortedMapTestCase::newWithMapIterable;
            this.payloads.newWithoutKey = ImmutableSortedMapTestCase::newWithoutKey;
            this.payloads.newWithoutAllKeys = ImmutableSortedMapTestCase::newWithoutAllKeys;
            this.payloads.toImmutable = ImmutableSortedMapTestCase::toImmutable;
            this.payloads.put = ImmutableSortedMapTestCase::put;
            this.payloads.remove = ImmutableSortedMapTestCase::remove;
            this.payloads.testToString = ImmutableSortedMapTestCase::testToString;
            this.payloads.take = ImmutableSortedMapTestCase::take;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedMapTestCase::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = ImmutableSortedMapTestCase::drop;
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedMapTestCase::drop_throws, java.lang.IllegalArgumentException.class);
        }
    }
}
