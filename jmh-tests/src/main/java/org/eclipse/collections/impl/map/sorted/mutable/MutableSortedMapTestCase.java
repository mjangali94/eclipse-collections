/*
 * Copyright (c) 2021 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.sorted.mutable;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MapIterable;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.map.sorted.ImmutableSortedMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.sortedset.MutableSortedSetMultimap;
import org.eclipse.collections.api.partition.list.PartitionMutableList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.factory.SortedMaps;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.MutableMapIterableTestCase;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.sorted.immutable.ImmutableTreeMap;
import org.eclipse.collections.impl.multimap.set.sorted.TreeSortedSetMultimap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.ImmutableEntry;
import org.eclipse.collections.impl.tuple.Tuples;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iList;

/**
 * Abstract JUnit TestCase for {@link MutableSortedMap}s.
 */
public abstract class MutableSortedMapTestCase extends MutableMapIterableTestCase {

    static final Comparator<Integer> REV_INT_ORDER = Comparators.reverseNaturalOrder();

    public abstract <K, V> MutableSortedMap<K, V> newMap(Comparator<? super K> comparator);

    public abstract <K, V> MutableSortedMap<K, V> newMapWithKeyValue(Comparator<? super K> comparator, K key, V value);

    public abstract <K, V> MutableSortedMap<K, V> newMapWithKeysValues(Comparator<? super K> comparator, K key1, V value1, K key2, V value2);

    public abstract <K, V> MutableSortedMap<K, V> newMapWithKeysValues(Comparator<? super K> comparator, K key1, V value1, K key2, V value2, K key3, V value3);

    public abstract <K, V> MutableSortedMap<K, V> newMapWithKeysValues(Comparator<? super K> comparator, K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4);

    @Override
    protected abstract <K, V> MutableSortedMap<K, V> newMap();

    @Override
    protected abstract <K, V> MutableSortedMap<K, V> newMapWithKeyValue(K key, V value);

    @Override
    protected abstract <K, V> MutableSortedMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2);

    @Override
    protected abstract <K, V> MutableSortedMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3);

    @Override
    protected abstract <K, V> MutableSortedMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4);

    protected <T> MutableSortedMap<?, T> newWith(T... littleElements) {
        int i = 0;
        MutableSortedMap<Integer, T> result = this.newMap();
        for (T each : littleElements) {
            result.put(i, each);
            i++;
        }
        return result;
    }

    @Test
    public void testNewEmpty() {
        MutableSortedMap<Integer, Integer> map = this.newMapWithKeysValues(1, 1, 2, 2);
        MutableSortedMap<Integer, Integer> revMap = this.newMapWithKeysValues(Comparators.reverseNaturalOrder(), 1, 1, 2, 2);
        Verify.assertEmpty(map.newEmpty());
        Verify.assertEmpty(revMap.newEmpty());
        Assert.assertEquals(Comparators.<Integer>reverseNaturalOrder(), revMap.newEmpty().comparator());
    }

    @Override
    @Test
    public void testNewMap() {
        super.testNewMap();
        MutableSortedMap<Integer, Integer> map = this.newMap();
        Verify.assertEmpty(map);
        MutableSortedMap<Integer, Integer> revMap = this.newMap(REV_INT_ORDER);
        Verify.assertEmpty(revMap);
    }

    @Override
    @Test
    public void toImmutable() {
        super.toImmutable();
        MutableSortedMap<Integer, String> sortedMap = this.newMapWithKeyValue(1, "One");
        ImmutableSortedMap<Integer, String> result = sortedMap.toImmutable();
        Verify.assertSize(1, result.castToSortedMap());
        Assert.assertEquals("One", result.get(1));
        Verify.assertInstanceOf(ImmutableTreeMap.class, result);
    }

    @Override
    @Test
    public void testNewMapWithKeyValue() {
        super.testNewMapWithKeyValue();
        MutableSortedMap<Integer, String> map = this.newMapWithKeyValue(1, "One");
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues(1, "One"), map);
        MutableSortedMap<Integer, String> revMap = this.newMapWithKeyValue(REV_INT_ORDER, 4, "Four");
        Verify.assertNotEmpty(revMap);
        Verify.assertListsEqual(FastList.newListWith("Four"), revMap.valuesView().toList());
    }

    @Test
    public void newMapWith_2() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two");
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues(1, "One", 2, "Two"), map);
        MutableSortedMap<Integer, String> revMap = this.newMapWithKeysValues(REV_INT_ORDER, 3, "Three", 4, "Four");
        Verify.assertNotEmpty(revMap);
        Verify.assertListsEqual(FastList.newListWith("Four", "Three"), revMap.valuesView().toList());
    }

    @Test
    public void newMapWith_3() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two", 3, "Three");
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues(1, "One", 2, "Two", 3, "Three"), map);
        MutableSortedMap<Integer, String> revMap = this.newMapWithKeysValues(REV_INT_ORDER, 3, "Three", 2, "Two", 4, "Four");
        Verify.assertNotEmpty(revMap);
        Verify.assertListsEqual(FastList.newListWith("Four", "Three", "Two"), revMap.valuesView().toList());
    }

    @Test
    public void newMapWith_4() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two", 3, "Three", 4, "Four");
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues(1, "One", 2, "Two", 3, "Three", 4, "Four"), map);
        MutableSortedMap<Integer, String> revMap = this.newMapWithKeysValues(REV_INT_ORDER, 1, "One", 3, "Three", 2, "Two", 4, "Four");
        Verify.assertNotEmpty(revMap);
        Verify.assertListsEqual(FastList.newListWith("Four", "Three", "Two", "One"), revMap.valuesView().toList());
    }

    @Test
    public void with() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2");
        Verify.assertSortedMapsEqual(TreeSortedMap.newMapWith(1, "1", 2, "2", 3, "3"), map.with(Tuples.pair(3, "3")));
        Verify.assertSortedMapsEqual(TreeSortedMap.newMapWith(1, "1", 2, "2", 3, "3", 4, "4"), map.with(Tuples.pair(3, "3"), Tuples.pair(4, "4")));
        MutableSortedMap<Integer, String> revMap = this.newMapWithKeysValues(REV_INT_ORDER, 1, "1", 2, "2");
        Verify.assertSortedMapsEqual(TreeSortedMap.newMap(REV_INT_ORDER).with(1, "1", 2, "2", 3, "3"), revMap.with(Tuples.pair(3, "3")));
        Verify.assertSortedMapsEqual(TreeSortedMap.newMap(REV_INT_ORDER).with(1, "1", 2, "2", 3, "3", 4, "4"), revMap.with(Tuples.pair(3, "3"), Tuples.pair(4, "4")));
    }

    @Override
    @Test
    public void tap() {
        MutableList<String> tapResult = Lists.mutable.empty();
        MapIterable<Integer, String> map = this.newMapWithKeysValues(1, "One", 3, "Three", 2, "Two", 4, "Four");
        Assert.assertSame(map, map.tap(tapResult::add));
        Assert.assertEquals(map.toList(), tapResult);
        MutableList<String> revTapResult = Lists.mutable.empty();
        MapIterable<Integer, String> revMap = this.newMapWithKeysValues(REV_INT_ORDER, 1, "One", 3, "Three", 2, "Two", 4, "Four");
        Assert.assertSame(revMap, revMap.tap(revTapResult::add));
        Assert.assertEquals(revMap.toList(), revTapResult);
    }

    @Override
    @Test
    public void forEach() {
        super.forEach();
        MutableList<String> list = Lists.mutable.empty();
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 3, "Three", 2, "Two", 4, "Four");
        map.forEach(CollectionAddProcedure.on(list));
        Verify.assertListsEqual(FastList.newListWith("One", "Two", "Three", "Four"), list);
        MutableList<String> list2 = Lists.mutable.empty();
        MutableSortedMap<Integer, String> revMap = this.newMapWithKeysValues(REV_INT_ORDER, 1, "One", 3, "Three", 2, "Two", 4, "Four");
        revMap.forEach(CollectionAddProcedure.on(list2));
        Verify.assertListsEqual(FastList.newListWith("Four", "Three", "Two", "One"), list2);
    }

    @Override
    @Test
    public void forEachWith() {
        super.forEachWith();
        MutableList<Integer> list = Lists.mutable.empty();
        MutableSortedMap<Integer, Integer> map = this.newMapWithKeysValues(-1, 1, -2, 2, -3, 3, -4, 4);
        map.forEachWith((argument1, argument2) -> list.add(argument1 + argument2), 10);
        Verify.assertListsEqual(FastList.newListWith(14, 13, 12, 11), list);
    }

    @Test
    public void forEachWith_reverse() {
        MutableList<Integer> list2 = Lists.mutable.empty();
        MutableSortedMap<Integer, Integer> revMap = this.newMapWithKeysValues(REV_INT_ORDER, -1, 1, -2, 2, -3, 3, -4, 4);
        revMap.forEachWith((argument1, argument2) -> list2.add(argument1 + argument2), 10);
        Verify.assertListsEqual(FastList.newListWith(11, 12, 13, 14), list2);
    }

    @Override
    @Test
    public void forEachWithIndex() {
        super.forEachWithIndex();
        MutableList<String> list = Lists.mutable.empty();
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two", 3, "Three", 4, "Four");
        map.forEachWithIndex((value, index) -> {
            list.add(value);
            list.add(String.valueOf(index));
        });
        Verify.assertListsEqual(FastList.newListWith("One", "0", "Two", "1", "Three", "2", "Four", "3"), list);
    }

    @Test
    public void forEachWithIndex_reverse() {
        MutableList<String> list2 = Lists.mutable.empty();
        MutableSortedMap<Integer, String> revMap = this.newMapWithKeysValues(REV_INT_ORDER, 1, "One", 2, "Two", 3, "Three", 4, "Four");
        revMap.forEachWithIndex((value, index) -> {
            list2.add(value);
            list2.add(String.valueOf(index));
        });
        Verify.assertListsEqual(FastList.newListWith("Four", "0", "Three", "1", "Two", "2", "One", "3"), list2);
    }

    @Override
    @Test
    public void forEachKeyValue() {
        super.forEachKeyValue();
        MutableList<String> result = Lists.mutable.empty();
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(REV_INT_ORDER, 1, "One", 2, "Two", 3, "Three");
        map.forEachKeyValue((key, value) -> result.add(key + value));
        Verify.assertListsEqual(FastList.newListWith("3Three", "2Two", "1One"), result);
    }

    @Override
    @Test
    public void forEachKey() {
        super.forEachKey();
        MutableList<Integer> result = Lists.mutable.empty();
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(REV_INT_ORDER, 1, "1", 2, "2", 3, "3");
        map.forEachKey(CollectionAddProcedure.on(result));
        Verify.assertListsEqual(FastList.newListWith(3, 2, 1), result);
    }

    @Override
    @Test
    public void collectValues() {
        super.collectValues();
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(REV_INT_ORDER, 1, "One", 2, "Two", 3, "Three");
        MutableSortedMap<Integer, String> actual = map.collectValues((argument1, argument2) -> new StringBuilder(argument2).reverse().toString());
        Assert.assertEquals(TreeSortedMap.<Integer, String>newMap(REV_INT_ORDER).with(1, "enO", 2, "owT", 3, "eerhT"), actual);
    }

    @Override
    @Test
    public void zipWithIndex() {
        super.zipWithIndex();
        MutableSortedMap<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three");
        MutableList<Pair<String, Integer>> pairs = map.zipWithIndex();
        Verify.assertListsEqual(map.toList(), pairs.collect((Function<Pair<String, ?>, String>) Pair::getOne));
        Verify.assertListsEqual(Interval.zeroTo(map.size() - 1), pairs.collect((Function<Pair<?, Integer>, Integer>) Pair::getTwo));
        Assert.assertEquals(map.zipWithIndex().toSet(), map.zipWithIndex(UnifiedSet.newSet()));
    }

    @Override
    @Test
    public void zip() {
        super.zip();
        MutableSortedMap<String, Integer> map = this.newMapWithKeysValues("A", 1, "B", 2, "C", 3);
        MutableList<Pair<Integer, String>> zip = map.zip(FastList.newListWith("One", "Two", "Three"));
        Verify.assertListsEqual(FastList.newListWith(Tuples.pair(1, "One"), Tuples.pair(2, "Two"), Tuples.pair(3, "Three")), zip);
    }

    @Override
    @Test
    public void select_value() {
        super.select_value();
        MutableSortedMap<String, Integer> map = this.newMapWithKeysValues(Comparators.reverseNaturalOrder(), "A", 1, "B", 2, "C", 3);
        Verify.assertListsEqual(FastList.newListWith(2, 1), map.select(Predicates.lessThan(3)));
    }

    @Override
    @Test
    public void reject_value() {
        super.reject_value();
        MutableSortedMap<String, Integer> map = this.newMapWithKeysValues(Comparators.reverseNaturalOrder(), "A", 1, "B", 2, "C", 3);
        Verify.assertListsEqual(FastList.newListWith(2, 1), map.reject(Predicates.greaterThan(2)));
    }

    @Override
    @Test
    public void partition_value() {
        MutableSortedMap<String, Integer> map = this.newMapWithKeysValues(Comparators.reverseNaturalOrder(), "A", 1, "B", 2, "C", 3, "D", 4);
        PartitionMutableList<Integer> partition = map.partition(IntegerPredicates.isEven());
        Assert.assertEquals(iList(4, 2), partition.getSelected());
        Assert.assertEquals(iList(3, 1), partition.getRejected());
    }

    @Override
    @Test
    public void partitionWith_value() {
        MutableSortedMap<String, Integer> map = this.newMapWithKeysValues(Comparators.reverseNaturalOrder(), "A", 1, "B", 2, "C", 3, "D", 4);
        PartitionMutableList<Integer> partition = map.partitionWith(Predicates2.in(), map.select(IntegerPredicates.isEven()));
        Assert.assertEquals(iList(4, 2), partition.getSelected());
        Assert.assertEquals(iList(3, 1), partition.getRejected());
    }

    @Override
    @Test
    public void collect_value() {
        super.collect_value();
        MutableSortedMap<String, Integer> map = this.newMapWithKeysValues(Comparators.reverseNaturalOrder(), "A", 1, "B", 2, "C", 3);
        MutableList<String> collect = map.collect(Functions.getToString());
        Verify.assertListsEqual(FastList.newListWith("3", "2", "1"), collect);
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex() {
        MutableSortedMap<Integer, String> integers = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3", 4, "4");
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair("1", 0), PrimitiveTuples.pair("2", 1), PrimitiveTuples.pair("3", 2), PrimitiveTuples.pair("4", 3)), integers.collectWithIndex(PrimitiveTuples::pair));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget() {
        MutableSortedMap<Integer, String> integers = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3", 4, "4");
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair("1", 0), PrimitiveTuples.pair("2", 1), PrimitiveTuples.pair("3", 2), PrimitiveTuples.pair("4", 3)), integers.collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty()));
    }

    /**
     * @since 11.0.
     */
    @Test
    public void selectWithIndexWithTarget() {
        MutableSortedMap<Integer, String> integers = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3", 4, "4");
        Assert.assertEquals(Lists.mutable.with("1", "3"), integers.selectWithIndex((each, index) -> index % 2 == 0, Lists.mutable.empty()));
    }

    /**
     * @since 11.0.
     */
    @Test
    public void rejectWithIndexWithTarget() {
        MutableSortedMap<Integer, String> integers = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3", 4, "4");
        Assert.assertEquals(Lists.mutable.with("2", "4"), integers.rejectWithIndex((each, index) -> index % 2 == 0, Lists.mutable.empty()));
    }

    @Override
    @Test
    public void flatten_value() {
        super.flatten_value();
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(REV_INT_ORDER, 1, "cd", 2, "ab");
        Function<String, Iterable<Character>> function = object -> {
            MutableList<Character> result = Lists.mutable.empty();
            char[] chars = object.toCharArray();
            for (char aChar : chars) {
                result.add(Character.valueOf(aChar));
            }
            return result;
        };
        Verify.assertListsEqual(FastList.newListWith('a', 'b', 'c', 'd'), map.flatCollect(function));
    }

    @Override
    @Test
    public void collectMap() {
        super.collectMap();
        MutableSortedMap<String, Integer> map = this.newMapWithKeysValues(Comparators.reverseNaturalOrder(), "1", 1, "2", 2, "3", 3);
        Function2<String, Integer, Pair<Integer, String>> function = (String argument1, Integer argument2) -> Tuples.pair(argument2.intValue(), String.valueOf(argument2));
        MutableMap<Integer, String> collect = map.collect(function);
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues(1, "1", 2, "2", 3, "3"), collect);
    }

    @Override
    @Test
    public void selectMap() {
        super.selectMap();
        MutableSortedMap<String, Integer> map = this.newMapWithKeysValues(Comparators.reverseNaturalOrder(), "1", 1, "2", 3, "3", 2, "4", 1);
        MutableSortedMap<String, Integer> select = map.select((argument1, argument2) -> argument2 != 1);
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues("2", 3, "3", 2), select);
        Verify.assertListsEqual(FastList.newListWith("3", "2"), select.keySet().toList());
    }

    @Override
    @Test
    public void rejectMap() {
        super.rejectMap();
        MutableSortedMap<String, Integer> map = this.newMapWithKeysValues(Comparators.reverseNaturalOrder(), "1", 1, "2", 3, "3", 2, "4", 1);
        MutableSortedMap<String, Integer> select = map.reject((argument1, argument2) -> argument2 == 1);
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues("2", 3, "3", 2), select);
        Verify.assertListsEqual(FastList.newListWith("3", "2"), select.keySet().toList());
    }

    @Override
    @Test
    public void flip() {
        super.flip();
        MutableSortedSetMultimap<String, String> expected = TreeSortedSetMultimap.newMultimap(Comparators.reverseNaturalOrder());
        expected.put("odd", "One");
        expected.put("even", "Two");
        expected.put("odd", "Three");
        expected.put("even", "Four");
        MutableSortedMap<String, String> map = this.newMapWithKeysValues(Comparators.reverseNaturalOrder(), "One", "odd", "Two", "even", "Three", "odd", "Four", "even");
        MutableSortedSetMultimap<String, String> flip = map.flip();
        Assert.assertEquals(expected, flip);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), "Two", "Four"), flip.get("even"));
    }

    @Override
    @Test
    public void collectIf() {
        super.collectIf();
        MutableSortedMap<String, Integer> map = this.newMapWithKeysValues(Comparators.reverseNaturalOrder(), "1", 4, "2", 3, "3", 2, "4", 1);
        MutableList<String> collect = map.collectIf(Predicates.greaterThan(1), String::valueOf);
        Verify.assertListsEqual(FastList.newListWith("2", "3", "4"), collect);
    }

    @Override
    @Test
    public void iterator() {
        super.iterator();
        MutableSortedMap<Integer, Integer> map = this.newMapWithKeysValues(REV_INT_ORDER, -1, 1, -2, 2, -3, 3);
        Iterator<Integer> iterator = map.iterator();
        Assert.assertTrue(iterator.hasNext());
        for (int i = 1; i < 4; ++i) {
            Assert.assertEquals(i, iterator.next().intValue());
        }
        Assert.assertFalse(iterator.hasNext());
    }

    @Override
    @Test
    public void removeFromEntrySet() {
        // Test without using null
        MutableSortedMap<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        Assert.assertTrue(map.entrySet().remove(ImmutableEntry.of("Two", 2)));
        Assert.assertEquals(UnifiedMap.newWithKeysValues("One", 1, "Three", 3), map);
        Assert.assertFalse(map.entrySet().remove(ImmutableEntry.of("Four", 4)));
        Assert.assertEquals(UnifiedMap.newWithKeysValues("One", 1, "Three", 3), map);
        Assert.assertFalse(map.entrySet().remove(null));
    }

    @Override
    @Test
    public void removeAllFromEntrySet() {
        // Test without using null
        MutableSortedMap<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        Assert.assertTrue(map.entrySet().removeAll(FastList.newListWith(ImmutableEntry.of("One", 1), ImmutableEntry.of("Three", 3))));
        Assert.assertEquals(UnifiedMap.newWithKeysValues("Two", 2), map);
        Assert.assertFalse(map.entrySet().removeAll(FastList.newListWith(ImmutableEntry.of("Four", 4))));
        Assert.assertEquals(UnifiedMap.newWithKeysValues("Two", 2), map);
        Assert.assertFalse(map.entrySet().remove(null));
    }

    @Override
    @Test
    public void retainAllFromEntrySet() {
        super.retainAllFromEntrySet();
        // TODO: delete?
        MutableSortedMap<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        Assert.assertFalse(map.entrySet().retainAll(FastList.newListWith(ImmutableEntry.of("One", 1), ImmutableEntry.of("Two", 2), ImmutableEntry.of("Three", 3), ImmutableEntry.of("Four", 4))));
        Assert.assertTrue(map.entrySet().retainAll(FastList.newListWith(ImmutableEntry.of("One", 1), ImmutableEntry.of("Three", 3), ImmutableEntry.of("Four", 4))));
        Assert.assertEquals(UnifiedMap.newWithKeysValues("One", 1, "Three", 3), map);
    }

    @Test
    public void entrySet_sorted() {
        LazyIterable<Pair<String, Integer>> pairs = Interval.oneTo(100).collect(Functions.pair(Functions.getToString(), Functions.getPassThru()));
        MutableSortedMap<String, Integer> mutableSortedMap = new TreeSortedMap<>(pairs.toArray(new Pair[] {}));
        MutableList<Map.Entry<String, Integer>> entries = FastList.newList(mutableSortedMap.entrySet());
        MutableList<Map.Entry<String, Integer>> sortedEntries = entries.toSortedListBy(Functions.getKeyFunction());
        Assert.assertEquals(sortedEntries, entries);
    }

    @Test
    public void keySet() {
        MutableSortedMap<Integer, Integer> map = this.newMapWithKeysValues(1, -1, 2, -2, 3, -3);
        Verify.assertListsEqual(FastList.newListWith(1, 2, 3), map.keySet().toList());
        Verify.assertInstanceOf(MutableSet.class, map.keySet());
        MutableSortedMap<Integer, Integer> revMap = this.newMapWithKeysValues(REV_INT_ORDER, 1, -1, 2, -2, 3, -3);
        Verify.assertListsEqual(FastList.newListWith(3, 2, 1), revMap.keySet().toList());
    }

    @Override
    @Test
    public void keySetEqualsAndHashCode() {
        // Test without using null
        MutableSortedMap<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        Verify.assertEqualsAndHashCode(TreeSortedSet.newSetWith("One", "Two", "Three"), map.keySet());
    }

    @Override
    @Test
    public void put() {
        // Only use Comparable objects
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two");
        Assert.assertNull(map.put(3, "Three"));
        Assert.assertEquals(TreeSortedMap.newMapWith(1, "One", 2, "Two", 3, "Three"), map);
        MutableSortedMap<Integer, String> revMap = this.newMapWithKeysValues(REV_INT_ORDER, 1, "One", 2, "Two");
        Assert.assertNull(revMap.put(0, "Zero"));
        Assert.assertEquals(TreeSortedMap.<Integer, String>newMap(REV_INT_ORDER).with(0, "Zero", 1, "One", 2, "Two"), revMap);
    }

    @Override
    @Test
    public void putAll() {
        super.putAll();
        // TODO: delete?
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "2");
        MutableSortedMap<Integer, String> toAdd = this.newMapWithKeysValues(2, "Two", 3, "Three");
        map.putAll(toAdd);
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues(1, "One", 2, "Two", 3, "Three"), map);
        MutableSortedMap<Integer, String> revMap = this.newMapWithKeysValues(REV_INT_ORDER, 1, "One", 2, "2");
        revMap.putAll(toAdd);
        Assert.assertEquals(TreeSortedMap.<Integer, String>newMap(REV_INT_ORDER).with(1, "One", 2, "Two", 3, "Three"), revMap);
    }

    @Test
    public void putAllFromCollection() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
        MutableList<Integer> toAdd = FastList.newListWith(2, 3);
        map.collectKeysAndValues(toAdd, Functions.getIntegerPassThru(), String::valueOf);
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues(1, "1", 2, "2", 3, "3"), map);
        MutableSortedMap<Integer, String> revMap = this.newMapWithKeysValues(REV_INT_ORDER, 1, "1", 2, "Two");
        revMap.collectKeysAndValues(toAdd, Functions.getIntegerPassThru(), String::valueOf);
        Verify.assertSortedMapsEqual(TreeSortedMap.<Integer, String>newMap(REV_INT_ORDER).with(1, "1", 2, "2", 3, "3"), revMap);
    }

    @Test
    public void testEquals() {
        MutableSortedMap<Integer, String> map1 = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        MutableSortedMap<Integer, String> map2 = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        MutableSortedMap<Integer, String> map3 = this.newMapWithKeysValues(2, "2", 3, "3", 4, "4");
        MutableSortedMap<Integer, String> revMap1 = this.newMapWithKeysValues(REV_INT_ORDER, 1, "1", 2, "2", 3, "3");
        MutableSortedMap<Integer, String> revMap3 = this.newMapWithKeysValues(REV_INT_ORDER, 2, "2", 3, "3", 4, "4");
        Verify.assertSortedMapsEqual(map1, map2);
        Verify.assertMapsEqual(revMap1, map2);
        Verify.assertMapsEqual(revMap3, map3);
        Assert.assertNotEquals(map2, map3);
        Assert.assertNotEquals(revMap1, revMap3);
        Assert.assertNotEquals(map1, revMap3);
    }

    @Test
    public void testHashCode() {
        MutableSortedMap<Integer, String> map1 = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        MutableSortedMap<Integer, String> map2 = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        Verify.assertEqualsAndHashCode(map1, map2);
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        MapIterable<Integer, String> map = this.newMapWithKeysValues(Comparators.reverseNaturalOrder(), 1, "1", 2, "2", 3, "3");
        Verify.assertPostSerializedEqualsAndHashCode(map);
        Verify.assertEqualsAndHashCode(Maps.mutable.of(1, "1", 2, "2", 3, "3"), map);
        Verify.assertEqualsAndHashCode(Maps.immutable.of(1, "1", 2, "2", 3, "3"), map);
        Assert.assertNotEquals(map, this.newMapWithKeysValues(1, "1", 2, "2"));
        Assert.assertNotEquals(map, this.newMapWithKeysValues(1, "1", 2, "2", 3, "3", 4, "4"));
        Assert.assertNotEquals(map, this.newMapWithKeysValues(1, "1", 2, "2", 4, "4"));
        Assert.assertNotEquals(map, this.newMapWithKeysValues(Comparators.reverseNaturalOrder(), 1, "1", 2, "2"));
        Assert.assertNotEquals(map, this.newMapWithKeysValues(Comparators.reverseNaturalOrder(), 1, "1", 2, "2", 3, "3", 4, "4"));
        Assert.assertNotEquals(map, this.newMapWithKeysValues(Comparators.reverseNaturalOrder(), 1, "1", 2, "2", 4, "4"));
    }

    @Override
    @Test
    public void serialization() {
        super.serialization();
        MutableSortedMap<Integer, String> original = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        MutableSortedMap<Integer, String> copy = SerializeTestHelper.serializeDeserialize(original);
        Verify.assertSortedMapsEqual(original, copy);
        MutableSortedMap<Integer, String> revMap = this.newMapWithKeysValues(REV_INT_ORDER, 1, "One", 2, "Two");
        MutableSortedMap<Integer, String> deserialized = SerializeTestHelper.serializeDeserialize(revMap);
        Verify.assertSortedMapsEqual(revMap, deserialized);
        Verify.assertListsEqual(FastList.newListWith(2, 1), deserialized.keySet().toList());
    }

    @Override
    @Test
    public void asUnmodifiable() {
        super.asUnmodifiable();
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeysValues(1, 1, 2, 2).asUnmodifiable().put(3, 3));
        Verify.assertInstanceOf(UnmodifiableTreeMap.class, this.newMapWithKeysValues(1, "1", 2, "2").asUnmodifiable());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two").asSynchronized();
        Verify.assertInstanceOf(SynchronizedSortedMap.class, map);
    }

    @Test
    public void firstKey() {
        MutableSortedMap<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Four", 4);
        Assert.assertEquals("Four", map.firstKey());
        MutableSortedMap<String, Integer> revMap = this.newMapWithKeysValues(Comparators.reverseNaturalOrder(), "One", 1, "Two", 2, "Four", 4);
        Assert.assertEquals("Two", revMap.firstKey());
        MutableSortedMap<Object, Object> emptyMap = this.newMap();
        Assert.assertThrows(NoSuchElementException.class, emptyMap::firstKey);
    }

    @Test
    public void lastKey() {
        MutableSortedMap<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Four", 4);
        Assert.assertEquals("Two", map.lastKey());
        MutableSortedMap<String, Integer> revMap = this.newMapWithKeysValues(Comparators.reverseNaturalOrder(), "One", 1, "Two", 2, "Four", 4);
        Assert.assertEquals("Four", revMap.lastKey());
        MutableSortedMap<Object, Object> emptyMap = this.newMap();
        Assert.assertThrows(NoSuchElementException.class, emptyMap::lastKey);
    }

    @Test
    public void headMap() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two", 3, "Three", 4, "Four");
        MutableSortedMap<Integer, String> subMap = map.headMap(3);
        Verify.assertSortedMapsEqual(TreeSortedMap.newMapWith(1, "One", 2, "Two"), subMap);
        Verify.assertListsEqual(FastList.newListWith(1, 2), subMap.keySet().toList());
        subMap.put(0, "Zero");
        Verify.assertContainsKeyValue(0, "Zero", map);
        subMap.removeKey(2);
        Verify.assertNotContainsKey(2, map);
        map.clear();
        Verify.assertEmpty(subMap);
        Assert.assertThrows(IllegalArgumentException.class, () -> subMap.put(4, "Illegal"));
    }

    @Test
    public void tailMap() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two", 3, "Three", 4, "Four");
        MutableSortedMap<Integer, String> subMap = map.tailMap(2);
        Verify.assertSortedMapsEqual(TreeSortedMap.newMapWith(2, "Two", 3, "Three", 4, "Four"), subMap);
        Verify.assertListsEqual(FastList.newListWith(2, 3, 4), subMap.keySet().toList());
        subMap.put(5, "Five");
        Verify.assertContainsKeyValue(5, "Five", map);
        subMap.removeKey(2);
        Verify.assertNotContainsKey(2, map);
        map.clear();
        Verify.assertEmpty(subMap);
        Assert.assertThrows(IllegalArgumentException.class, () -> subMap.put(1, "Illegal"));
    }

    @Test
    public void subMap() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two", 3, "Three", 4, "Four");
        MutableSortedMap<Integer, String> subMap = map.subMap(2, 4);
        Verify.assertSortedMapsEqual(TreeSortedMap.newMapWith(3, "Three", 2, "Two"), subMap);
        Verify.assertListsEqual(FastList.newListWith(2, 3), subMap.keySet().toList());
        map.clear();
        Verify.assertEmpty(subMap);
        Verify.assertEmpty(map);
        subMap.put(2, "Two");
        map.put(3, "Three");
        Verify.assertContainsKeyValue(2, "Two", map);
        Verify.assertContainsKeyValue(3, "Three", subMap);
        subMap.removeKey(2);
        Verify.assertNotContainsKey(2, map);
        Assert.assertThrows(IllegalArgumentException.class, () -> subMap.put(4, "Illegal"));
        Assert.assertThrows(IllegalArgumentException.class, () -> subMap.put(1, "Illegal"));
    }

    @Test
    public void testToString() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two");
        Assert.assertEquals("{1=One, 2=Two}", map.toString());
    }

    @Test
    public void testClone() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two");
        MutableSortedMap<Integer, String> clone = map.clone();
        Assert.assertNotSame(map, clone);
        Verify.assertEqualsAndHashCode(map, clone);
    }

    @Test
    public void take() {
        MutableSortedMap<Integer, String> strings1 = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3", 4, "4");
        Assert.assertEquals(SortedMaps.mutable.of(strings1.comparator()), strings1.take(0));
        Assert.assertSame(strings1.comparator(), strings1.take(0).comparator());
        Assert.assertEquals(SortedMaps.mutable.of(strings1.comparator(), 1, "1", 2, "2", 3, "3"), strings1.take(3));
        Assert.assertSame(strings1.comparator(), strings1.take(3).comparator());
        Assert.assertEquals(SortedMaps.mutable.of(strings1.comparator(), 1, "1", 2, "2", 3, "3"), strings1.take(strings1.size() - 1));
        MutableSortedMap<Integer, String> expectedMap = this.newMapWithKeysValues(Comparators.reverseNaturalOrder(), 1, "1", 2, "2", 3, "3", 4, "4");
        MutableSortedMap<Integer, String> strings2 = this.newMapWithKeysValues(Comparators.reverseNaturalOrder(), 1, "1", 2, "2", 3, "3", 4, "4");
        Assert.assertEquals(expectedMap, strings2.take(strings2.size()));
        Assert.assertEquals(expectedMap, strings2.take(10));
        Assert.assertEquals(expectedMap, strings2.take(Integer.MAX_VALUE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void take_throws() {
        this.newMapWithKeysValues(1, "1", 2, "2", 3, "3", 4, "4").take(-1);
    }

    @Test
    public void drop() {
        MutableSortedMap<Integer, String> strings1 = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3", 4, "4");
        Assert.assertEquals(strings1, strings1.drop(0));
        Assert.assertNotSame(strings1, strings1.drop(0));
        Assert.assertSame(strings1.comparator(), strings1.drop(0).comparator());
        Assert.assertEquals(SortedMaps.mutable.of(strings1.comparator(), 4, "4"), strings1.drop(3));
        Assert.assertSame(strings1.comparator(), strings1.drop(3).comparator());
        Assert.assertEquals(SortedMaps.mutable.of(strings1.comparator(), 4, "4"), strings1.drop(strings1.size() - 1));
        MutableSortedMap<Integer, String> expectedMap = SortedMaps.mutable.of(Comparators.reverseNaturalOrder());
        MutableSortedMap<Integer, String> strings2 = this.newMapWithKeysValues(Comparators.reverseNaturalOrder(), 1, "1", 2, "2", 3, "3", 4, "4");
        Assert.assertEquals(expectedMap, strings2.drop(strings2.size()));
        Assert.assertEquals(expectedMap, strings2.drop(10));
        Assert.assertEquals(expectedMap, strings2.drop(Integer.MAX_VALUE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void drop_throws() {
        this.newMapWithKeysValues(1, "1", 2, "2", 3, "3", 4, "4").drop(-1);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MutableSortedMapTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ifPresentApply() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ifPresentApply);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent_function() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent_function);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrDefault() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrDefault);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithTarget);
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
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
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
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithToTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
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
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_throws_when_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_throws_when_empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_throws_when_multiple_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_throws_when_multiple_values);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArguments);
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
        public void benchmark_detect_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach);
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
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws);
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
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAggregateBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAggregateBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
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
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyValuesView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_nullCollisionWithCastInEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.nullCollisionWithCastInEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWithWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWithWithWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWithWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWithWithWithWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_test_toString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.test_toString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clearEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clearEntrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySetEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySetEqualsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeNullFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeNullFromKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clearKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clearKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetToArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetToArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeNullFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeNullFromValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllKeys);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_block_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_block_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith_block_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith_block_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getKeysAndGetValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getKeysAndGetValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysAndValues_toString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysAndValues_toString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyPreservation() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyPreservation);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapEmptyAndTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapNull);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableEmptyAndTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableNull);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableEmptyAndTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableNull);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValueArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValueArguments);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAllKeys);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromKeySet_null_collision() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromKeySet_null_collision);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rehash_null_collision() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rehash_null_collision);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue_collisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue_collisions);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith_collisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith_collisions);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMapWithKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMapWithKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWith_2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWith_2);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWith_3() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWith_3);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWith_4() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWith_4);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
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
        public void benchmark_forEachWith_reverse() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith_reverse);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex_reverse() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex_reverse);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatten_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatten_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromEntrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromEntrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromEntrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_sorted() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_sorted);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetEqualsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllFromCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllFromCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_firstKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.firstKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lastKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lastKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_headMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.headMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tailMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tailMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop_throws);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new MutableSortedMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> test_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> clearEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> entrySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> keySetToArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> removeFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> removeNullFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> removeAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> retainAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> removeAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> getIfAbsentPutValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> getIfAbsentPut_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> getIfAbsentPutWith_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> getKeysAndGetValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> keysAndValues_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> keyPreservation;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> withKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> withMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> withMapEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> withMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> withMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> withMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> withMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> withMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> putAllMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> putAllMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> putAllMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> putAllMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> putAllMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> withAllKeyValueArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> retainAllFromKeySet_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> rehash_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> updateValue_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> updateValueWith_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> testNewEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> newMapWith_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> newMapWith_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> newMapWith_4;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> forEachWith_reverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> forEachWithIndex_reverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> removeFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> removeAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> retainAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> entrySet_sorted;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> putAllFromCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> firstKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> lastKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> headMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> tailMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> subMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedMapTestCase> drop_throws;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = MutableSortedMapTestCase::stream;
            this.payloads.parallelStream = MutableSortedMapTestCase::parallelStream;
            this.payloads.isEmpty = MutableSortedMapTestCase::isEmpty;
            this.payloads.notEmpty = MutableSortedMapTestCase::notEmpty;
            this.payloads.ifPresentApply = MutableSortedMapTestCase::ifPresentApply;
            this.payloads.getIfAbsent_function = MutableSortedMapTestCase::getIfAbsent_function;
            this.payloads.getOrDefault = MutableSortedMapTestCase::getOrDefault;
            this.payloads.getIfAbsent = MutableSortedMapTestCase::getIfAbsent;
            this.payloads.getIfAbsentWith = MutableSortedMapTestCase::getIfAbsentWith;
            this.payloads.forEachValue = MutableSortedMapTestCase::forEachValue;
            this.payloads.injectIntoKeyValue = MutableSortedMapTestCase::injectIntoKeyValue;
            this.payloads.flipUniqueValues = MutableSortedMapTestCase::flipUniqueValues;
            this.payloads.collectBoolean = MutableSortedMapTestCase::collectBoolean;
            this.payloads.collectBooleanWithTarget = MutableSortedMapTestCase::collectBooleanWithTarget;
            this.payloads.collectByte = MutableSortedMapTestCase::collectByte;
            this.payloads.collectByteWithTarget = MutableSortedMapTestCase::collectByteWithTarget;
            this.payloads.collectChar = MutableSortedMapTestCase::collectChar;
            this.payloads.collectCharWithTarget = MutableSortedMapTestCase::collectCharWithTarget;
            this.payloads.collectDouble = MutableSortedMapTestCase::collectDouble;
            this.payloads.collectDoubleWithTarget = MutableSortedMapTestCase::collectDoubleWithTarget;
            this.payloads.collectFloat = MutableSortedMapTestCase::collectFloat;
            this.payloads.collectFloatWithTarget = MutableSortedMapTestCase::collectFloatWithTarget;
            this.payloads.collectInt = MutableSortedMapTestCase::collectInt;
            this.payloads.collectIntWithTarget = MutableSortedMapTestCase::collectIntWithTarget;
            this.payloads.collectLong = MutableSortedMapTestCase::collectLong;
            this.payloads.collectLongWithTarget = MutableSortedMapTestCase::collectLongWithTarget;
            this.payloads.collectShort = MutableSortedMapTestCase::collectShort;
            this.payloads.collectShortWithTarget = MutableSortedMapTestCase::collectShortWithTarget;
            this.payloads.select = MutableSortedMapTestCase::select;
            this.payloads.selectWith = MutableSortedMapTestCase::selectWith;
            this.payloads.reject = MutableSortedMapTestCase::reject;
            this.payloads.rejectWith = MutableSortedMapTestCase::rejectWith;
            this.payloads.collect = MutableSortedMapTestCase::collect;
            this.payloads.flatCollect = MutableSortedMapTestCase::flatCollect;
            this.payloads.flatCollectWith = MutableSortedMapTestCase::flatCollectWith;
            this.payloads.detect = MutableSortedMapTestCase::detect;
            this.payloads.detectOptional = MutableSortedMapTestCase::detectOptional;
            this.payloads.anySatisfy = MutableSortedMapTestCase::anySatisfy;
            this.payloads.anySatisfyWith = MutableSortedMapTestCase::anySatisfyWith;
            this.payloads.allSatisfy = MutableSortedMapTestCase::allSatisfy;
            this.payloads.allSatisfyWith = MutableSortedMapTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = MutableSortedMapTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = MutableSortedMapTestCase::noneSatisfyWith;
            this.payloads.appendString = MutableSortedMapTestCase::appendString;
            this.payloads.toBag = MutableSortedMapTestCase::toBag;
            this.payloads.toSortedBag = MutableSortedMapTestCase::toSortedBag;
            this.payloads.toSortedBagBy = MutableSortedMapTestCase::toSortedBagBy;
            this.payloads.asLazy = MutableSortedMapTestCase::asLazy;
            this.payloads.toList = MutableSortedMapTestCase::toList;
            this.payloads.toMap = MutableSortedMapTestCase::toMap;
            this.payloads.toSet = MutableSortedMapTestCase::toSet;
            this.payloads.toSortedList = MutableSortedMapTestCase::toSortedList;
            this.payloads.toSortedListBy = MutableSortedMapTestCase::toSortedListBy;
            this.payloads.toSortedSet = MutableSortedMapTestCase::toSortedSet;
            this.payloads.toSortedSetBy = MutableSortedMapTestCase::toSortedSetBy;
            this.payloads.toSortedMap = MutableSortedMapTestCase::toSortedMap;
            this.payloads.chunk = MutableSortedMapTestCase::chunk;
            this.payloads.collectWith = MutableSortedMapTestCase::collectWith;
            this.payloads.collectWithToTarget = MutableSortedMapTestCase::collectWithToTarget;
            this.payloads.contains = MutableSortedMapTestCase::contains;
            this.payloads.containsAnyIterable = MutableSortedMapTestCase::containsAnyIterable;
            this.payloads.containsNoneIterable = MutableSortedMapTestCase::containsNoneIterable;
            this.payloads.containsAnyCollection = MutableSortedMapTestCase::containsAnyCollection;
            this.payloads.containsNoneCollection = MutableSortedMapTestCase::containsNoneCollection;
            this.payloads.containsAll = MutableSortedMapTestCase::containsAll;
            this.payloads.containsKey = MutableSortedMapTestCase::containsKey;
            this.payloads.containsValue = MutableSortedMapTestCase::containsValue;
            this.payloads.getFirst = MutableSortedMapTestCase::getFirst;
            this.payloads.getLast = MutableSortedMapTestCase::getLast;
            this.payloads.getOnly = MutableSortedMapTestCase::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableSortedMapTestCase::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableSortedMapTestCase::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = MutableSortedMapTestCase::containsAllIterable;
            this.payloads.containsAllArguments = MutableSortedMapTestCase::containsAllArguments;
            this.payloads.count = MutableSortedMapTestCase::count;
            this.payloads.countWith = MutableSortedMapTestCase::countWith;
            this.payloads.detect_value = MutableSortedMapTestCase::detect_value;
            this.payloads.detectOptional_value = MutableSortedMapTestCase::detectOptional_value;
            this.payloads.detectWith = MutableSortedMapTestCase::detectWith;
            this.payloads.detectWithOptional = MutableSortedMapTestCase::detectWithOptional;
            this.payloads.detectIfNone_value = MutableSortedMapTestCase::detectIfNone_value;
            this.payloads.detectWithIfNone = MutableSortedMapTestCase::detectWithIfNone;
            this.payloads.countBy = MutableSortedMapTestCase::countBy;
            this.payloads.countByWith = MutableSortedMapTestCase::countByWith;
            this.payloads.countByEach = MutableSortedMapTestCase::countByEach;
            this.payloads.groupBy = MutableSortedMapTestCase::groupBy;
            this.payloads.groupByEach = MutableSortedMapTestCase::groupByEach;
            this.payloads.groupByUniqueKey = MutableSortedMapTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableSortedMapTestCase::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = MutableSortedMapTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableSortedMapTestCase::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = MutableSortedMapTestCase::injectInto;
            this.payloads.injectIntoInt = MutableSortedMapTestCase::injectIntoInt;
            this.payloads.injectIntoLong = MutableSortedMapTestCase::injectIntoLong;
            this.payloads.injectIntoFloat = MutableSortedMapTestCase::injectIntoFloat;
            this.payloads.injectIntoDouble = MutableSortedMapTestCase::injectIntoDouble;
            this.payloads.sumOfInt = MutableSortedMapTestCase::sumOfInt;
            this.payloads.sumOfLong = MutableSortedMapTestCase::sumOfLong;
            this.payloads.testAggregateBy = MutableSortedMapTestCase::testAggregateBy;
            this.payloads.sumOfFloat = MutableSortedMapTestCase::sumOfFloat;
            this.payloads.sumOfDouble = MutableSortedMapTestCase::sumOfDouble;
            this.payloads.sumByInt = MutableSortedMapTestCase::sumByInt;
            this.payloads.sumByFloat = MutableSortedMapTestCase::sumByFloat;
            this.payloads.sumByLong = MutableSortedMapTestCase::sumByLong;
            this.payloads.sumByDouble = MutableSortedMapTestCase::sumByDouble;
            this.payloads.makeString = MutableSortedMapTestCase::makeString;
            this.payloads.min = MutableSortedMapTestCase::min;
            this.payloads.max = MutableSortedMapTestCase::max;
            this.payloads.minBy = MutableSortedMapTestCase::minBy;
            this.payloads.maxBy = MutableSortedMapTestCase::maxBy;
            this.payloads.rejectWith_value = MutableSortedMapTestCase::rejectWith_value;
            this.payloads.selectWith_value = MutableSortedMapTestCase::selectWith_value;
            this.payloads.selectInstancesOf_value = MutableSortedMapTestCase::selectInstancesOf_value;
            this.payloads.toArray = MutableSortedMapTestCase::toArray;
            this.payloads.aggregateByMutating = MutableSortedMapTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = MutableSortedMapTestCase::aggregateByNonMutating;
            this.payloads.keyValuesView = MutableSortedMapTestCase::keyValuesView;
            this.payloads.nullCollisionWithCastInEquals = MutableSortedMapTestCase::nullCollisionWithCastInEquals;
            this.payloads.newMapWithWith = MutableSortedMapTestCase::newMapWithWith;
            this.payloads.newMapWithWithWith = MutableSortedMapTestCase::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = MutableSortedMapTestCase::newMapWithWithWithWith;
            this.payloads.keysView = MutableSortedMapTestCase::keysView;
            this.payloads.valuesView = MutableSortedMapTestCase::valuesView;
            this.payloads.test_toString = MutableSortedMapTestCase::test_toString;
            this.payloads.clear = MutableSortedMapTestCase::clear;
            this.payloads.removeObject = MutableSortedMapTestCase::removeObject;
            this.payloads.clearEntrySet = MutableSortedMapTestCase::clearEntrySet;
            this.payloads.entrySetEqualsAndHashCode = MutableSortedMapTestCase::entrySetEqualsAndHashCode;
            this.payloads.removeFromKeySet = MutableSortedMapTestCase::removeFromKeySet;
            this.payloads.removeNullFromKeySet = MutableSortedMapTestCase::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = MutableSortedMapTestCase::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = MutableSortedMapTestCase::retainAllFromKeySet;
            this.payloads.clearKeySet = MutableSortedMapTestCase::clearKeySet;
            this.payloads.keySetToArray = MutableSortedMapTestCase::keySetToArray;
            this.payloads.removeFromValues = MutableSortedMapTestCase::removeFromValues;
            this.payloads.removeNullFromValues = MutableSortedMapTestCase::removeNullFromValues;
            this.payloads.removeAllFromValues = MutableSortedMapTestCase::removeAllFromValues;
            this.payloads.retainAllFromValues = MutableSortedMapTestCase::retainAllFromValues;
            this.payloads.removeKey = MutableSortedMapTestCase::removeKey;
            this.payloads.removeAllKeys = MutableSortedMapTestCase::removeAllKeys;
            this.payloads.removeIf = MutableSortedMapTestCase::removeIf;
            this.payloads.getIfAbsentPut = MutableSortedMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPutValue = MutableSortedMapTestCase::getIfAbsentPutValue;
            this.payloads.getIfAbsentPutWithKey = MutableSortedMapTestCase::getIfAbsentPutWithKey;
            this.payloads.getIfAbsentPutWith = MutableSortedMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPut_block_throws = MutableSortedMapTestCase::getIfAbsentPut_block_throws;
            this.payloads.getIfAbsentPutWith_block_throws = MutableSortedMapTestCase::getIfAbsentPutWith_block_throws;
            this.payloads.getKeysAndGetValues = MutableSortedMapTestCase::getKeysAndGetValues;
            this.payloads.newEmpty = MutableSortedMapTestCase::newEmpty;
            this.payloads.keysAndValues_toString = MutableSortedMapTestCase::keysAndValues_toString;
            this.payloads.keyPreservation = MutableSortedMapTestCase::keyPreservation;
            this.payloads.add = MutableSortedMapTestCase::add;
            this.payloads.putPair = MutableSortedMapTestCase::putPair;
            this.payloads.withKeyValue = MutableSortedMapTestCase::withKeyValue;
            this.payloads.withMap = MutableSortedMapTestCase::withMap;
            this.payloads.withMapEmpty = MutableSortedMapTestCase::withMapEmpty;
            this.payloads.withMapTargetEmpty = MutableSortedMapTestCase::withMapTargetEmpty;
            this.payloads.withMapEmptyAndTargetEmpty = MutableSortedMapTestCase::withMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = MutableSortedMapTestCase::withMapNull;
            this.payloads.withMapIterable = MutableSortedMapTestCase::withMapIterable;
            this.payloads.withMapIterableEmpty = MutableSortedMapTestCase::withMapIterableEmpty;
            this.payloads.withMapIterableTargetEmpty = MutableSortedMapTestCase::withMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = MutableSortedMapTestCase::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = MutableSortedMapTestCase::withMapIterableNull;
            this.payloads.putAllMapIterable = MutableSortedMapTestCase::putAllMapIterable;
            this.payloads.putAllMapIterableEmpty = MutableSortedMapTestCase::putAllMapIterableEmpty;
            this.payloads.putAllMapIterableTargetEmpty = MutableSortedMapTestCase::putAllMapIterableTargetEmpty;
            this.payloads.putAllMapIterableEmptyAndTargetEmpty = MutableSortedMapTestCase::putAllMapIterableEmptyAndTargetEmpty;
            this.payloads.putAllMapIterableNull = MutableSortedMapTestCase::putAllMapIterableNull;
            this.payloads.withAllKeyValues = MutableSortedMapTestCase::withAllKeyValues;
            this.payloads.withAllKeyValueArguments = MutableSortedMapTestCase::withAllKeyValueArguments;
            this.payloads.withoutKey = MutableSortedMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = MutableSortedMapTestCase::withoutAllKeys;
            this.payloads.retainAllFromKeySet_null_collision = MutableSortedMapTestCase::retainAllFromKeySet_null_collision;
            this.payloads.rehash_null_collision = MutableSortedMapTestCase::rehash_null_collision;
            this.payloads.updateValue = MutableSortedMapTestCase::updateValue;
            this.payloads.updateValue_collisions = MutableSortedMapTestCase::updateValue_collisions;
            this.payloads.updateValueWith = MutableSortedMapTestCase::updateValueWith;
            this.payloads.updateValueWith_collisions = MutableSortedMapTestCase::updateValueWith_collisions;
            this.payloads.testNewEmpty = MutableSortedMapTestCase::testNewEmpty;
            this.payloads.testNewMap = MutableSortedMapTestCase::testNewMap;
            this.payloads.toImmutable = MutableSortedMapTestCase::toImmutable;
            this.payloads.testNewMapWithKeyValue = MutableSortedMapTestCase::testNewMapWithKeyValue;
            this.payloads.newMapWith_2 = MutableSortedMapTestCase::newMapWith_2;
            this.payloads.newMapWith_3 = MutableSortedMapTestCase::newMapWith_3;
            this.payloads.newMapWith_4 = MutableSortedMapTestCase::newMapWith_4;
            this.payloads.with = MutableSortedMapTestCase::with;
            this.payloads.tap = MutableSortedMapTestCase::tap;
            this.payloads.forEach = MutableSortedMapTestCase::forEach;
            this.payloads.forEachWith = MutableSortedMapTestCase::forEachWith;
            this.payloads.forEachWith_reverse = MutableSortedMapTestCase::forEachWith_reverse;
            this.payloads.forEachWithIndex = MutableSortedMapTestCase::forEachWithIndex;
            this.payloads.forEachWithIndex_reverse = MutableSortedMapTestCase::forEachWithIndex_reverse;
            this.payloads.forEachKeyValue = MutableSortedMapTestCase::forEachKeyValue;
            this.payloads.forEachKey = MutableSortedMapTestCase::forEachKey;
            this.payloads.collectValues = MutableSortedMapTestCase::collectValues;
            this.payloads.zipWithIndex = MutableSortedMapTestCase::zipWithIndex;
            this.payloads.zip = MutableSortedMapTestCase::zip;
            this.payloads.select_value = MutableSortedMapTestCase::select_value;
            this.payloads.reject_value = MutableSortedMapTestCase::reject_value;
            this.payloads.partition_value = MutableSortedMapTestCase::partition_value;
            this.payloads.partitionWith_value = MutableSortedMapTestCase::partitionWith_value;
            this.payloads.collect_value = MutableSortedMapTestCase::collect_value;
            this.payloads.collectWithIndex = MutableSortedMapTestCase::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = MutableSortedMapTestCase::collectWithIndexWithTarget;
            this.payloads.selectWithIndexWithTarget = MutableSortedMapTestCase::selectWithIndexWithTarget;
            this.payloads.rejectWithIndexWithTarget = MutableSortedMapTestCase::rejectWithIndexWithTarget;
            this.payloads.flatten_value = MutableSortedMapTestCase::flatten_value;
            this.payloads.collectMap = MutableSortedMapTestCase::collectMap;
            this.payloads.selectMap = MutableSortedMapTestCase::selectMap;
            this.payloads.rejectMap = MutableSortedMapTestCase::rejectMap;
            this.payloads.flip = MutableSortedMapTestCase::flip;
            this.payloads.collectIf = MutableSortedMapTestCase::collectIf;
            this.payloads.iterator = MutableSortedMapTestCase::iterator;
            this.payloads.removeFromEntrySet = MutableSortedMapTestCase::removeFromEntrySet;
            this.payloads.removeAllFromEntrySet = MutableSortedMapTestCase::removeAllFromEntrySet;
            this.payloads.retainAllFromEntrySet = MutableSortedMapTestCase::retainAllFromEntrySet;
            this.payloads.entrySet_sorted = MutableSortedMapTestCase::entrySet_sorted;
            this.payloads.keySet = MutableSortedMapTestCase::keySet;
            this.payloads.keySetEqualsAndHashCode = MutableSortedMapTestCase::keySetEqualsAndHashCode;
            this.payloads.put = MutableSortedMapTestCase::put;
            this.payloads.putAll = MutableSortedMapTestCase::putAll;
            this.payloads.putAllFromCollection = MutableSortedMapTestCase::putAllFromCollection;
            this.payloads.testEquals = MutableSortedMapTestCase::testEquals;
            this.payloads.testHashCode = MutableSortedMapTestCase::testHashCode;
            this.payloads.equalsAndHashCode = MutableSortedMapTestCase::equalsAndHashCode;
            this.payloads.serialization = MutableSortedMapTestCase::serialization;
            this.payloads.asUnmodifiable = MutableSortedMapTestCase::asUnmodifiable;
            this.payloads.asSynchronized = MutableSortedMapTestCase::asSynchronized;
            this.payloads.firstKey = MutableSortedMapTestCase::firstKey;
            this.payloads.lastKey = MutableSortedMapTestCase::lastKey;
            this.payloads.headMap = MutableSortedMapTestCase::headMap;
            this.payloads.tailMap = MutableSortedMapTestCase::tailMap;
            this.payloads.subMap = MutableSortedMapTestCase::subMap;
            this.payloads.testToString = MutableSortedMapTestCase::testToString;
            this.payloads.testClone = MutableSortedMapTestCase::testClone;
            this.payloads.take = MutableSortedMapTestCase::take;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableSortedMapTestCase::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = MutableSortedMapTestCase::drop;
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableSortedMapTestCase::drop_throws, java.lang.IllegalArgumentException.class);
        }
    }
*/
}
