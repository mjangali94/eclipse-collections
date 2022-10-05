/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.fixed.ArrayAdapter;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.ImmutableEntry;
import org.eclipse.collections.impl.utility.ArrayIterate;
import org.eclipse.collections.impl.utility.Iterate;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iMap;
import static org.eclipse.collections.impl.factory.Iterables.mList;

public abstract class UnifiedMapTestCase extends MutableMapTestCase {

    protected static final Integer COLLISION_1 = 0;

    protected static final Integer COLLISION_2 = 17;

    protected static final Integer COLLISION_3 = 34;

    protected static final Integer COLLISION_4 = 51;

    protected static final Integer COLLISION_5 = 68;

    protected static final Integer COLLISION_6 = 85;

    protected static final Integer COLLISION_7 = 102;

    protected static final Integer COLLISION_8 = 119;

    protected static final Integer COLLISION_9 = 136;

    protected static final Integer COLLISION_10 = 152;

    protected static final MutableList<Integer> COLLISIONS = Lists.mutable.of(COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4, COLLISION_5);

    protected static final MutableList<Integer> MORE_COLLISIONS = FastList.newList(COLLISIONS).with(COLLISION_6, COLLISION_7, COLLISION_8, COLLISION_9);

    protected static final String[] FREQUENT_COLLISIONS = { "\u9103\ufffe", "\u9104\uffdf", "\u9105\uffc0", "\u9106\uffa1", "\u9107\uff82", "\u9108\uff63", "\u9109\uff44", "\u910a\uff25", "\u910b\uff06", "\u910c\ufee7" };

    @Test
    public void valuesCollection_toArray() {
        MutableMap<Integer, String> map = this.newMapWithKeyValue(1, "One").asUnmodifiable();
        Object[] values = map.values().toArray();
        Verify.assertItemAtIndex("One", 0, values);
        // map containing chain
        MutableMap<Integer, Integer> chainedMap = this.mapWithCollisionsOfSize(2);
        Object[] chainedValues = chainedMap.values().toArray();
        Arrays.sort(chainedValues);
        Assert.assertArrayEquals(new Integer[] { COLLISION_1, COLLISION_2 }, chainedValues);
        // map containing chain with empty slots
        MutableMap<Integer, Integer> chainedMapWithEmpties = this.mapWithCollisionsOfSize(3);
        Object[] chainedValuesWithEmpties = chainedMapWithEmpties.values().toArray();
        Arrays.sort(chainedValuesWithEmpties);
        Assert.assertArrayEquals(new Integer[] { COLLISION_1, COLLISION_2, COLLISION_3 }, chainedValuesWithEmpties);
    }

    @Test
    public void valuesCollection_toArray_WithEmptyTarget() {
        MutableMap<Integer, String> map = this.newMapWithKeyValue(1, "One");
        String[] values = map.values().toArray(new String[0]);
        Assert.assertArrayEquals(new String[] { "One" }, values);
        Object[] objects = map.values().toArray(new Object[0]);
        Assert.assertArrayEquals(new String[] { "One" }, objects);
    }

    @Test
    public void valuesCollection_toArray_withPreSizedTarget() {
        MutableMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two");
        String[] values = map.values().toArray(new String[2]);
        Arrays.sort(values);
        Assert.assertArrayEquals(new String[] { "One", "Two" }, values);
        String[] target = new String[3];
        target[0] = "HERE";
        target[1] = "HERE";
        target[2] = "HERE";
        String[] array = this.newMapWithKeyValue(1, "One").values().toArray(target);
        Assert.assertArrayEquals(new String[] { "One", null, "HERE" }, array);
    }

    @Test
    public void valuesCollection_toArray_withLargeTarget() {
        MutableMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two");
        String[] target = new String[3];
        target[2] = "yow!";
        String[] values = map.values().toArray(target);
        ArrayIterate.sort(values, values.length, Comparators.safeNullsHigh(String::compareTo));
        Assert.assertArrayEquals(new String[] { "One", "Two", null }, values);
    }

    @Test
    public void entrySet_clear() {
        MutableMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two");
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        entries.clear();
        Verify.assertEmpty(entries);
        Verify.assertEmpty(map);
    }

    @Test
    public void valuesCollection_clear() {
        MutableMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two", 3, "Three");
        Collection<String> values = map.values();
        values.clear();
        Verify.assertEmpty(values);
        Verify.assertEmpty(map);
    }

    @Test
    public void keySet_toArray_withSmallTarget() {
        MutableMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two", 3, "Three", 4, "Four");
        // deliberately to small to force the method to allocate one of the correct size
        Integer[] destination = new Integer[2];
        Integer[] result = map.keySet().toArray(destination);
        Arrays.sort(result);
        Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 4 }, result);
    }

    @Test
    public void keySet_ToArray_withLargeTarget() {
        MutableMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two", 3, "Three", 4, "Four");
        // deliberately large to force the extra to be set to null
        Integer[] target = new Integer[6];
        target[4] = 42;
        target[5] = 42;
        Integer[] result = map.keySet().toArray(target);
        ArrayIterate.sort(result, result.length, Comparators.safeNullsHigh(Integer::compareTo));
        Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 4, 42, null }, result);
    }

    @Test
    public void noInstanceOfEquals() {
        MutableMap<NoInstanceOfInEquals, Integer> map = this.newMap();
        map.put(new NoInstanceOfInEquals(10), 12);
        map.put(new NoInstanceOfInEquals(12), 15);
        map.put(new NoInstanceOfInEquals(14), 18);
        Assert.assertEquals(3, map.size());
    }

    @Test
    public void keySet_hashCode() {
        // a map with a null key
        MutableMap<Integer, Integer> map1 = this.newMapWithKeyValue(null, 0);
        UnifiedSet<Object> set = UnifiedSet.newSet();
        set.add(null);
        Verify.assertEqualsAndHashCode(set, map1.keySet());
        // a map with a chain containing empty slots
        MutableMap<Integer, Integer> map2 = this.mapWithCollisionsOfSize(5);
        Verify.assertEqualsAndHashCode(UnifiedSet.newSetWith(0, 17, 34, 51, 68), map2.keySet());
        // a map with a chain containing empty slots and a null key
        MutableMap<Integer, Integer> map3 = this.mapWithCollisionsOfSize(5);
        map3.put(null, 42);
        Verify.assertEqualsAndHashCode(UnifiedSet.newSetWith(0, 17, 34, 51, 68, null), map3.keySet());
    }

    @Test
    public void keySet_copyKeys() {
        // a map with a null key
        MutableMap<Integer, Integer> map1 = this.newMapWithKeyValue(null, 0);
        Assert.assertArrayEquals(new Object[] { null }, map1.keySet().toArray());
        // a map with a chain containing empty slots
        MutableMap<Integer, Integer> map2 = this.mapWithCollisionsOfSize(5);
        Assert.assertArrayEquals(new Object[] { 0, 17, 34, 51, 68 }, map2.keySet().toArray());
        // a map with a chain containing empty slots and null key
        MutableMap<Integer, Integer> map3 = this.mapWithCollisionsOfSize(5);
        map3.put(null, 42);
        Integer[] array = map3.keySet().toArray(new Integer[map3.size()]);
        ArrayIterate.sort(array, array.length, Comparators.safeNullsHigh(Integer::compareTo));
        Assert.assertArrayEquals(new Object[] { 0, 17, 34, 51, 68, null }, array);
    }

    @Test
    public void entrySet_toArray() {
        MutableMap<Integer, String> map = this.newMapWithKeyValue(1, "One");
        Object[] entries = map.entrySet().toArray();
        Assert.assertArrayEquals(new Map.Entry[] { ImmutableEntry.of(1, "One") }, entries);
    }

    @Test
    public void entrySet_toArray_withEmptyTarget() {
        MutableMap<Integer, String> map = this.newMapWithKeyValue(1, "One");
        Map.Entry<Integer, String>[] entries = map.entrySet().toArray(new Map.Entry[0]);
        Assert.assertArrayEquals(new Map.Entry[] { ImmutableEntry.of(1, "One") }, entries);
        Object[] objects = map.entrySet().toArray(new Object[0]);
        Assert.assertArrayEquals(new Map.Entry[] { ImmutableEntry.of(1, "One") }, objects);
    }

    @Test
    public void entrySet_toArray_withPreSizedTarget() {
        MutableMap<Integer, String> map = this.newMapWithKeyValue(1, "One");
        Map.Entry<Integer, String>[] entries = map.entrySet().toArray(new Map.Entry[map.size()]);
        Assert.assertArrayEquals(new Map.Entry[] { ImmutableEntry.of(1, "One") }, entries);
    }

    @Test
    public void entrySet_toArray_withLargeTarget() {
        MutableMap<Integer, String> map = this.newMapWithKeyValue(1, "One");
        Map.Entry<Integer, String>[] target = new Map.Entry[4];
        Map.Entry<Integer, String> immutableEntry = new ImmutableEntry<>(null, null);
        target[1] = immutableEntry;
        target[2] = immutableEntry;
        target[3] = immutableEntry;
        Map.Entry<Integer, String>[] entries = map.entrySet().toArray(target);
        Assert.assertArrayEquals(new Map.Entry[] { ImmutableEntry.of(1, "One"), null, immutableEntry, immutableEntry }, entries);
    }

    protected MutableMap<Integer, Integer> mapWithCollisionsOfSize(int size) {
        MutableMap<Integer, Integer> map = this.newMap();
        return this.populateMapWithCollisionsOfSize(size, map);
    }

    protected <M extends MutableMap<Integer, Integer>> M populateMapWithCollisionsOfSize(int size, M map) {
        MORE_COLLISIONS.subList(0, size).forEach(Procedures.cast(each -> map.put(each, each)));
        return map;
    }

    @Test
    public void entrySet_PostSerializedEqualsAndHashCode() {
        MutableMap<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        Verify.assertPostSerializedEqualsAndHashCode(map.entrySet());
    }

    @Test
    public void keySet_PostSerializedEqualsAndHashCode() {
        MutableMap<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        Verify.assertPostSerializedEqualsAndHashCode(map.keySet());
    }

    @Test
    public void keySet_PostSerializedEqualsAndHashCode_chainWithEmptySlot() {
        MutableMap<Integer, Integer> map = this.mapWithCollisionsOfSize(5);
        Verify.assertPostSerializedEqualsAndHashCode(map.keySet());
    }

    @Test
    public void valuesCollection_PostSerializedEquality() {
        MutableMap<Integer, Integer> map = this.newMapWithKeysValues(1, 1, 2, 2, 3, 3);
        Collection<Integer> values = map.values();
        // This test is not using Verify.assertPostSerializedEqualsAndHashCode b/c the deserialized form of the values view is a FastList, which will not be equals to the original view (a Collection).
        Collection<Integer> revived = SerializeTestHelper.serializeDeserialize(values);
        Assert.assertNotNull(revived);
        Verify.assertSize(values.size(), revived);
        Assert.assertTrue(revived.containsAll(values));
    }

    @Test
    public void valuesCollection_PostSerializedEquality_chainedMap() {
        MutableMap<Integer, Integer> map = this.mapWithCollisionsOfSize(2);
        Collection<Integer> values = map.values();
        Collection<Integer> revived = SerializeTestHelper.serializeDeserialize(values);
        Assert.assertNotNull(revived);
        Verify.assertSize(values.size(), revived);
        Assert.assertTrue(revived.containsAll(values));
    }

    @Test
    public void valuesCollection_PostSerializedEquality_chainedMapWithEmptySlot() {
        MutableMap<Integer, Integer> map = this.mapWithCollisionsOfSize(4);
        // add non-colliding key
        map.put(42, 42);
        Collection<Integer> values = map.values();
        // This test is not using Verify.assertPostSerializedEqualsAndHashCode b/c the deserialized form of the values view is a FastList, which will not be equals to the orginal view (a Collection).
        Collection<Integer> revived = SerializeTestHelper.serializeDeserialize(values);
        Assert.assertNotNull(revived);
        Verify.assertSize(values.size(), revived);
        Assert.assertTrue(revived.containsAll(values));
    }

    @Test
    public void contains_key_and_value() {
        for (int i = 1; i < COLLISIONS.size(); i++) {
            MutableMap<Integer, Integer> map = this.mapWithCollisionsOfSize(i);
            Assert.assertTrue(map.containsKey(COLLISIONS.get(i - 1)));
            Assert.assertTrue(map.containsValue(COLLISIONS.get(i - 1)));
            Assert.assertFalse(map.containsKey(COLLISION_10));
            Assert.assertFalse(map.containsValue(COLLISION_10));
            Assert.assertFalse(map.containsKey(null));
            Assert.assertFalse(map.containsValue(null));
            map.put(null, null);
            Assert.assertTrue(map.containsKey(null));
            Assert.assertTrue(map.containsValue(null));
        }
    }

    @Test
    public void remove() {
        for (int i = 1; i < COLLISIONS.size(); i++) {
            MutableMap<Integer, Integer> map = this.mapWithCollisionsOfSize(i);
            Assert.assertNull(map.put(null, null));
            Assert.assertNull(map.remove(null));
            Assert.assertNull(map.remove(COLLISION_10));
            Integer biggestValue = COLLISIONS.get(i - 1);
            Assert.assertEquals(biggestValue, map.remove(biggestValue));
        }
    }

    @Test
    public void getIfAbsentPutValueWithCollisions() {
        MutableMap<Integer, Object> map = this.newMapWithKeyValue(COLLISION_1, null);
        Assert.assertNull(map.getIfAbsentPut(COLLISION_1, 5));
        Assert.assertNull(map.getIfAbsentPut(COLLISION_3, (Integer) null));
        Assert.assertNull(map.getIfAbsentPut(COLLISION_3, 7));
        Assert.assertEquals(Integer.valueOf(9), map.getIfAbsentPut(COLLISION_2, 9));
        Assert.assertEquals(Integer.valueOf(10), map.getIfAbsentPut(COLLISION_4, 10));
        Assert.assertEquals(UnifiedMap.newWithKeysValues(COLLISION_1, null, COLLISION_2, 9, COLLISION_3, null, COLLISION_4, 10), map);
    }

    @Test
    public void getIfAbsentPutWithWithCollisions() {
        MutableMap<Integer, Object> map = this.newMapWithKeyValue(COLLISION_1, null);
        Assert.assertNull(map.getIfAbsentPutWith(COLLISION_1, String::valueOf, 5));
        Assert.assertNull(map.getIfAbsentPutWith(COLLISION_3, Functions.getPassThru(), null));
        Assert.assertNull(map.getIfAbsentPutWith(COLLISION_3, String::valueOf, 7));
        Assert.assertEquals("9", map.getIfAbsentPutWith(COLLISION_2, String::valueOf, 9));
        Assert.assertEquals(Integer.valueOf(10), map.getIfAbsentPutWith(COLLISION_4, Functions.getIntegerPassThru(), 10));
        Assert.assertEquals(UnifiedMap.newWithKeysValues(COLLISION_1, null, COLLISION_2, "9", COLLISION_3, null, COLLISION_4, 10), map);
    }

    @Override
    @Test
    public void removeFromEntrySet() {
        super.removeFromEntrySet();
        for (int i = 1; i < COLLISIONS.size(); i++) {
            MutableMap<Integer, Integer> map = this.mapWithCollisionsOfSize(i);
            Integer biggestValue = COLLISIONS.get(i - 1);
            Assert.assertTrue(map.entrySet().remove(ImmutableEntry.of(biggestValue, biggestValue)));
            Assert.assertEquals(this.mapWithCollisionsOfSize(i - 1), map);
            Assert.assertFalse(map.entrySet().remove(ImmutableEntry.of(COLLISION_10, COLLISION_10)));
            Assert.assertEquals(this.mapWithCollisionsOfSize(i - 1), map);
            Assert.assertFalse(map.entrySet().remove(null));
        }
    }

    @Override
    @Test
    public void retainAllFromEntrySet() {
        super.retainAllFromEntrySet();
        for (int i = 1; i < COLLISIONS.size(); i++) {
            MutableMap<Integer, Integer> map = this.mapWithCollisionsOfSize(i);
            Assert.assertFalse(map.entrySet().retainAll(FastList.newList(map.entrySet()).with(ImmutableEntry.of(COLLISION_10, COLLISION_10))));
            Assert.assertTrue(map.entrySet().retainAll(this.mapWithCollisionsOfSize(i - 1).entrySet()));
            Assert.assertEquals(this.mapWithCollisionsOfSize(i - 1), map);
        }
        for (Integer item : MORE_COLLISIONS) {
            MutableMap<Integer, Integer> integers = this.mapWithCollisionsOfSize(9);
            @SuppressWarnings("BoxingBoxedValue")
            Integer keyCopy = new Integer(item);
            Assert.assertTrue(integers.entrySet().retainAll(mList(ImmutableEntry.of(keyCopy, keyCopy))));
            Assert.assertEquals(iMap(keyCopy, keyCopy), integers);
            Assert.assertNotSame(keyCopy, Iterate.getOnly(integers.entrySet()).getKey());
        }
        // simple map, collection to retain contains non-entry element
        MutableMap<Integer, String> map4 = this.newMapWithKeysValues(1, "One", 2, "Two");
        FastList<Object> toRetain = FastList.newListWith(ImmutableEntry.of(1, "One"), "explosion!", ImmutableEntry.of(2, "Two"));
        Assert.assertFalse(map4.entrySet().retainAll(toRetain));
    }

    @Override
    @Test
    public void forEachWith() {
        super.forEachWith();
        for (int i = 1; i < COLLISIONS.size(); i++) {
            MutableMap<Integer, Integer> map = this.mapWithCollisionsOfSize(i);
            Object sentinel = new Object();
            UnifiedSet<Integer> result = UnifiedSet.newSet();
            map.forEachWith((argument1, argument2) -> {
                Assert.assertSame(sentinel, argument2);
                result.add(argument1);
            }, sentinel);
            Assert.assertEquals(map.keySet(), result);
        }
    }

    @Test
    public void keySet_retainAll() {
        // a map with a null key
        MutableMap<Integer, Integer> map = this.newMapWithKeyValue(null, 0);
        MutableList<Object> retained = Lists.mutable.of();
        retained.add(null);
        Assert.assertFalse(map.keySet().retainAll(retained));
        Verify.assertContains(null, map.keySet());
        // a map with a chain containing empty slots
        MutableMap<Integer, Integer> map2 = this.mapWithCollisionsOfSize(5);
        Assert.assertFalse(map2.keySet().retainAll(FastList.newListWith(0, 17, 34, 51, 68)));
        Verify.assertContainsAll(map2.keySet(), 0, 17, 34, 51, 68);
        // a map with no chaining, nothing retained
        MutableMap<Integer, String> map3 = this.newMapWithKeyValue(1, "One");
        Assert.assertTrue(map3.keySet().retainAll(FastList.newListWith(9)));
        Verify.assertEmpty(map3);
        Set<Integer> keys = this.newMapWithKeysValues(1, "One", 2, "Two", 3, "Three", 4, "Four").keySet();
        Assert.assertTrue(keys.retainAll(FastList.newListWith(1, 2, 3)));
        Verify.assertContainsAll(keys, 1, 2, 3);
    }

    @Test
    public void keySet_containsAll() {
        MutableMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two", 3, "Three", 4, "Four");
        Assert.assertFalse(map.keySet().containsAll(FastList.newListWith(5)));
        Assert.assertTrue(map.keySet().containsAll(FastList.newListWith(1, 2, 4)));
    }

    @Test
    public void keySet_equals() {
        MutableMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two", 3, "Three", 4, "Four");
        Assert.assertNotEquals(UnifiedSet.newSetWith(1, 2, 3, 4, 5), map.keySet());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void keySet_add() {
        MutableMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two", 3, "Three", 4, "Four");
        map.keySet().add(5);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void keySet_addAll() {
        MutableMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two", 3, "Three", 4, "Four");
        map.keySet().addAll(UnifiedSet.newSetWith(5, 6));
    }

    @Test(expected = NoSuchElementException.class)
    public void keySet_Iterator() {
        MutableMap<Integer, String> map = this.newMapWithKeyValue(1, "One");
        Iterator<Integer> iterator = map.keySet().iterator();
        iterator.next();
        iterator.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void entrySet_Iterator_incrementPastEnd() {
        MutableMap<Integer, String> map = this.newMapWithKeyValue(1, "One");
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        iterator.next();
        iterator.next();
    }

    @Test(expected = IllegalStateException.class)
    public void keySet_Iterator_removeBeforeIncrement() {
        // remove w/o incrementing
        MutableMap<Integer, String> map = this.newMapWithKeyValue(1, "One");
        Iterator<Integer> iterator = map.keySet().iterator();
        iterator.remove();
    }

    @Test
    public void valuesCollection_Iterator_remove() {
        // a map with a chain, remove one
        MutableMap<Integer, Integer> map = this.mapWithCollisionsOfSize(3);
        Iterator<Integer> iterator = map.iterator();
        iterator.next();
        iterator.remove();
        Verify.assertSize(2, map);
        // remove all values in chain
        iterator.next();
        iterator.remove();
        iterator.next();
        iterator.remove();
        Verify.assertEmpty(map);
    }

    @Test
    public void iterator_many_collisions() {
        Iterator<Integer> iterator = this.mapWithCollisionsOfSize(9).iterator();
        for (Integer collision : MORE_COLLISIONS) {
            Assert.assertTrue(iterator.hasNext());
            Assert.assertEquals(collision, iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void entry_setValue() {
        MutableMap<Integer, String> map = this.newMapWithKeyValue(1, "One");
        Map.Entry<Integer, String> entry = Iterate.getFirst(map.entrySet());
        String value = "Ninety-Nine";
        Assert.assertEquals("One", entry.setValue(value));
        Assert.assertEquals(value, entry.getValue());
        Verify.assertContainsKeyValue(1, value, map);
        map.remove(1);
        Verify.assertEmpty(map);
        Assert.assertNull(entry.setValue("Ignored"));
    }

    @Test
    public void entry_hashCodeForNullKeyAndValue() {
        MutableMap<Integer, String> map = this.newMapWithKeyValue(null, null);
        Map.Entry<Integer, String> entry = Iterate.getFirst(map.entrySet());
        Assert.assertEquals(0, entry.hashCode());
    }

    @Test
    public void entry_equalsWithNonEntry() {
        MutableMap<Integer, String> map = this.newMapWithKeyValue(null, null);
        Map.Entry<Integer, String> entry = Iterate.getFirst(map.entrySet());
        Assert.assertNotEquals(entry, new Object());
    }

    @Test
    public void entrySet_remove() {
        // map with chaining, attempt to remove non-existent entry
        MutableMap<Integer, Integer> chainedMap = this.mapWithCollisionsOfSize(3);
        Set<Map.Entry<Integer, Integer>> chainedEntries = chainedMap.entrySet();
        Assert.assertFalse(chainedEntries.remove(ImmutableEntry.of(5, 5)));
        // map with chaining, attempt to remove non-existent collding entry
        MutableMap<Integer, Integer> chainedMap2 = this.mapWithCollisionsOfSize(2);
        Set<Map.Entry<Integer, Integer>> chainedEntries2 = chainedMap2.entrySet();
        Assert.assertFalse(chainedEntries2.remove(ImmutableEntry.of(COLLISION_4, COLLISION_4)));
        // map with chaining, attempt to remove non-existent colliding entry (key exists, but value does not)
        MutableMap<Integer, Integer> chainedMap3 = this.mapWithCollisionsOfSize(3);
        Set<Map.Entry<Integer, Integer>> chainedEntries3 = chainedMap3.entrySet();
        Assert.assertFalse(chainedEntries3.remove(ImmutableEntry.of(COLLISION_2, COLLISION_4)));
        // map with no chaining, attempt to remove non-existent entry
        MutableMap<Integer, String> unchainedMap = this.newMapWithKeyValue(1, "One");
        Set<Map.Entry<Integer, String>> unchainedEntries = unchainedMap.entrySet();
        Assert.assertFalse(unchainedEntries.remove(ImmutableEntry.of(5, "Five")));
    }

    @Test
    public void entrySet_contains() {
        // simple map, test for null key
        MutableMap<Integer, String> map = this.newMapWithKeyValue(1, "One");
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        Verify.assertNotContains(ImmutableEntry.of(null, "Null"), entries);
        // chained map, test for null value
        MutableMap<Integer, Integer> chainedMap = this.newMapWithKeysValues(COLLISION_1, COLLISION_1, COLLISION_2, null);
        Set<Map.Entry<Integer, Integer>> chainedEntries = chainedMap.entrySet();
        Verify.assertContains(ImmutableEntry.of(COLLISION_2, null), chainedEntries);
    }

    @Test
    public void entrySet_containsAll() {
        // simple map, test for non-existent entries
        MutableMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 3, "Three");
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        Assert.assertFalse(entries.containsAll(FastList.newListWith(ImmutableEntry.of(2, "Two"))));
        Assert.assertTrue(entries.containsAll(FastList.newListWith(ImmutableEntry.of(1, "One"), ImmutableEntry.of(3, "Three"))));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void entrySet_add() {
        MutableMap<Integer, String> map = this.newMapWithKeyValue(1, "One");
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        entries.add(ImmutableEntry.of(2, "Two"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void entrySet_addAll() {
        MutableMap<Integer, String> map = this.newMapWithKeyValue(1, "One");
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        entries.addAll(FastList.newListWith(ImmutableEntry.of(2, "Two")));
    }

    @Test
    public void entrySet_equals() {
        MutableMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two", 3, "Three", null, null);
        Assert.assertNotEquals(UnifiedSet.newSetWith(ImmutableEntry.of(5, "Five")), map.entrySet());
        UnifiedSet<ImmutableEntry<Integer, String>> expected = UnifiedSet.newSetWith(ImmutableEntry.of(1, "One"), ImmutableEntry.of(2, "Two"), ImmutableEntry.of(3, "Three"), ImmutableEntry.of(null, null));
        Verify.assertEqualsAndHashCode(expected, map.entrySet());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void valuesCollection_add() {
        MutableMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two", 3, "Three", 4, "Four");
        map.values().add("explosion!");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void valuesCollection_addAll() {
        MutableMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two", 3, "Three", 4, "Four");
        map.values().addAll(UnifiedSet.newSetWith("explosion!", "kaboom!"));
    }

    @Test(expected = NoSuchElementException.class)
    public void valueCollection_Iterator() {
        MutableMap<Integer, String> map = this.newMapWithKeyValue(1, "One");
        Iterator<String> iterator = map.values().iterator();
        iterator.next();
        iterator.next();
    }

    @Test
    public void valueCollection_equals() {
        MutableMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two", 3, "Three", null, null);
        Assert.assertNotEquals(UnifiedSet.newSetWith("One", "Two", "Three", null), map.values());
    }

    @Override
    @Test
    public void forEachWithIndex() {
        super.forEachWithIndex();
        UnifiedSet<String> set = UnifiedSet.newSet();
        // map with a chain and no empty slots
        MutableMap<Integer, Integer> map = this.mapWithCollisionsOfSize(2);
        map.forEachWithIndex((each, index) -> set.add(index + ":" + each));
        Assert.assertEquals(UnifiedSet.newSetWith("0:0", "1:17"), set);
        set.clear();
        // map with a chain and empty slots
        MutableMap<Integer, Integer> map2 = this.mapWithCollisionsOfSize(5);
        map2.forEachWithIndex((each, index) -> set.add(index + ":" + each));
        Assert.assertEquals(UnifiedSet.newSetWith("0:0", "1:17", "2:34", "3:51", "4:68"), set);
    }

    @Override
    @Test
    public void forEachKey() {
        super.forEachKey();
        UnifiedSet<String> set = UnifiedSet.newSet(5);
        // map with a chain and empty slots
        MutableMap<Integer, Integer> map = this.mapWithCollisionsOfSize(5);
        map.forEachKey(each -> set.add(each.toString()));
        Assert.assertEquals(UnifiedSet.newSetWith("0", "17", "34", "51", "68"), set);
    }

    @Override
    @Test
    public void forEachValue() {
        super.forEachValue();
        MutableMap<Integer, Integer> map = this.mapWithCollisionsOfSize(9).withKeyValue(null, null);
        MutableSet<Integer> result = UnifiedSet.newSet();
        map.forEachValue(each -> {
            Assert.assertTrue(each == null || each.getClass() == Integer.class);
            result.add(each);
        });
        Assert.assertEquals(MORE_COLLISIONS.toSet().with(null), result);
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        for (int i = 1; i < COLLISIONS.size(); i++) {
            MutableMap<Integer, Integer> map = this.mapWithCollisionsOfSize(i);
            Map<Integer, Integer> expectedMap = new HashMap<>(map);
            Verify.assertEqualsAndHashCode(expectedMap, map);
            MutableMap<Integer, Integer> clone1 = map.clone();
            clone1.put(COLLISION_10, COLLISION_10);
            Assert.assertNotEquals(expectedMap, clone1);
            MutableMap<Integer, Integer> clone2 = map.clone();
            clone2.put(null, null);
            Assert.assertNotEquals(expectedMap, clone2);
            expectedMap.put(null, null);
            Assert.assertNotEquals(expectedMap, map);
            expectedMap.remove(null);
            expectedMap.put(COLLISION_10, COLLISION_10);
            Assert.assertNotEquals(expectedMap, map);
        }
        MutableMap<Integer, Integer> mapA = this.mapWithCollisionsOfSize(3);
        MutableMap<Integer, Integer> mapB = this.mapWithCollisionsOfSize(3);
        // map with a chain, compare the null key (and value) with a non-null key
        mapA.put(null, null);
        mapB.put(42, 84);
        Assert.assertNotEquals(mapA, mapB);
        Assert.assertNotEquals(mapA.hashCode(), mapB.hashCode());
        // map with a chain, compare the two null keys with different values (one null, one not)
        mapB.remove(42);
        mapB.put(null, 42);
        Assert.assertNotEquals(mapA, mapB);
        // map with a chain, compare a non-null key (null value) with a non-null key and value
        mapB.remove(null);
        mapB.remove(42);
        mapA.remove(null);
        mapA.put(17, null);
        Assert.assertNotEquals(mapA, mapB);
        MutableMap<Integer, String> mapC = this.newMapWithKeysValues(1, "One", 2, "Two", null, null);
        MutableMap<Integer, String> mapD = this.newMapWithKeysValues(1, "One", 2, "Two", 3, "Three");
        // compare the null key (and value) with a non-null key
        Assert.assertNotEquals(mapC, mapD);
        // compare a non-null key (and null value) with a non-null key
        mapC.remove(null);
        mapC.put(3, null);
        Assert.assertNotEquals(mapC, mapD);
        // reset
        mapC.remove(3);
        mapC.put(null, null);
        // compare the null key (and null value) with a null key (and non-null value)
        mapD.remove(3);
        mapD.put(null, "Three");
        // compare the two null keys with different values (one null, one not)
        Assert.assertNotEquals(mapC, mapD);
        Assert.assertEquals(0, this.newMapWithKeyValue(null, null).hashCode());
    }

    @Test
    public void frequentCollision() {
        String[] expected = ArrayAdapter.adapt(FREQUENT_COLLISIONS).subList(0, FREQUENT_COLLISIONS.length - 2).toArray(new String[FREQUENT_COLLISIONS.length - 2]);
        MutableMap<String, String> map = this.newMap();
        MutableSet<String> set = Sets.mutable.of(expected);
        ArrayIterate.forEach(FREQUENT_COLLISIONS, each -> map.put(each, each));
        Iterator<String> itr = map.iterator();
        while (itr.hasNext()) {
            if (!set.contains(itr.next())) {
                itr.remove();
            }
        }
        Assert.assertArrayEquals(expected, map.keysView().toArray());
    }

    @Override
    public void getFirst() {
        super.getFirst();
        MutableMap<String, String> map = this.newMap();
        map.collectKeysAndValues(Arrays.asList(FREQUENT_COLLISIONS), Functions.identity(), Functions.identity());
        Assert.assertEquals(FREQUENT_COLLISIONS[0], map.getFirst());
    }

    private static final class NoInstanceOfInEquals {

        private final int value;

        private NoInstanceOfInEquals(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            NoInstanceOfInEquals that = (NoInstanceOfInEquals) o;
            return this.value == that.value;
        }

        @Override
        public int hashCode() {
            return 12;
        }
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnifiedMapTestCase instance;

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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromEntrySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clearEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clearEntrySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySetEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySetEqualsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromKeySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeNullFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeNullFromKeySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromKeySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromKeySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clearKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clearKeySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetEqualsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetToArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetToArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeNullFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeNullFromValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllKeys);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_block_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_block_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith_block_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith_block_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getKeysAndGetValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getKeysAndGetValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysAndValues_toString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysAndValues_toString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyPreservation() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyPreservation);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapTargetEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapEmptyAndTargetEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapNull);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableTargetEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableEmptyAndTargetEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableNull);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableTargetEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableEmptyAndTargetEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableNull);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValueArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValueArguments);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAllKeys);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromKeySet_null_collision() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromKeySet_null_collision);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rehash_null_collision() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rehash_null_collision);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue_collisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue_collisions);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith_collisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith_collisions);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectKeysAndValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectKeysAndValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_toArray_WithEmptyTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_toArray_WithEmptyTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_toArray_withPreSizedTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_toArray_withPreSizedTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_toArray_withLargeTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_toArray_withLargeTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_toArray_withSmallTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_toArray_withSmallTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_ToArray_withLargeTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_ToArray_withLargeTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noInstanceOfEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noInstanceOfEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_hashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_hashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_copyKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_copyKeys);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_toArray_withEmptyTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_toArray_withEmptyTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_toArray_withPreSizedTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_toArray_withPreSizedTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_toArray_withLargeTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_toArray_withLargeTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_PostSerializedEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_PostSerializedEqualsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_PostSerializedEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_PostSerializedEqualsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_PostSerializedEqualsAndHashCode_chainWithEmptySlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_PostSerializedEqualsAndHashCode_chainWithEmptySlot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_PostSerializedEquality() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_PostSerializedEquality);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_PostSerializedEquality_chainedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_PostSerializedEquality_chainedMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_PostSerializedEquality_chainedMapWithEmptySlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_PostSerializedEquality_chainedMapWithEmptySlot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_key_and_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_key_and_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutValueWithCollisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutValueWithCollisions);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithWithCollisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithWithCollisions);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromEntrySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromEntrySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_equals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_equals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_Iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_Iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_Iterator_incrementPastEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_Iterator_incrementPastEnd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_Iterator_removeBeforeIncrement() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_Iterator_removeBeforeIncrement);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_Iterator_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_Iterator_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_many_collisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_many_collisions);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_setValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_setValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_hashCodeForNullKeyAndValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_hashCodeForNullKeyAndValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_equalsWithNonEntry() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_equalsWithNonEntry);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_equals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_equals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valueCollection_Iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valueCollection_Iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valueCollection_equals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valueCollection_equals);
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
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_frequentCollision() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.frequentCollision);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new UnifiedMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> test_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> removeAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> clearEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> entrySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> keySetToArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> removeFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> removeNullFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> removeAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> retainAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> removeAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> getIfAbsentPutValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> getIfAbsentPut_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> getIfAbsentPutWith_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> getKeysAndGetValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> keysAndValues_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> keyPreservation;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> withKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> withMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> withMapEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> withMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> withMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> withMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> withMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> withMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> putAllMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> putAllMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> putAllMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> putAllMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> putAllMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> withAllKeyValueArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> retainAllFromKeySet_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> rehash_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> updateValue_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> updateValueWith_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> collectKeysAndValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> valuesCollection_toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> valuesCollection_toArray_WithEmptyTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> valuesCollection_toArray_withPreSizedTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> valuesCollection_toArray_withLargeTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> entrySet_clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> valuesCollection_clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> keySet_toArray_withSmallTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> keySet_ToArray_withLargeTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> noInstanceOfEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> keySet_hashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> keySet_copyKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> entrySet_toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> entrySet_toArray_withEmptyTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> entrySet_toArray_withPreSizedTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> entrySet_toArray_withLargeTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> entrySet_PostSerializedEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> keySet_PostSerializedEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> keySet_PostSerializedEqualsAndHashCode_chainWithEmptySlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> valuesCollection_PostSerializedEquality;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> valuesCollection_PostSerializedEquality_chainedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> valuesCollection_PostSerializedEquality_chainedMapWithEmptySlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> contains_key_and_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> getIfAbsentPutValueWithCollisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> getIfAbsentPutWithWithCollisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> removeFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> retainAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> keySet_retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> keySet_containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> keySet_equals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> keySet_add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> keySet_addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> keySet_Iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> entrySet_Iterator_incrementPastEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> keySet_Iterator_removeBeforeIncrement;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> valuesCollection_Iterator_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> iterator_many_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> entry_setValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> entry_hashCodeForNullKeyAndValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> entry_equalsWithNonEntry;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> entrySet_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> entrySet_contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> entrySet_containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> entrySet_add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> entrySet_addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> entrySet_equals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> valuesCollection_add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> valuesCollection_addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> valueCollection_Iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> valueCollection_equals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapTestCase> frequentCollision;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = UnifiedMapTestCase::stream;
            this.payloads.parallelStream = UnifiedMapTestCase::parallelStream;
            this.payloads.serialization = UnifiedMapTestCase::serialization;
            this.payloads.isEmpty = UnifiedMapTestCase::isEmpty;
            this.payloads.notEmpty = UnifiedMapTestCase::notEmpty;
            this.payloads.ifPresentApply = UnifiedMapTestCase::ifPresentApply;
            this.payloads.getIfAbsent_function = UnifiedMapTestCase::getIfAbsent_function;
            this.payloads.getOrDefault = UnifiedMapTestCase::getOrDefault;
            this.payloads.getIfAbsent = UnifiedMapTestCase::getIfAbsent;
            this.payloads.getIfAbsentWith = UnifiedMapTestCase::getIfAbsentWith;
            this.payloads.tap = UnifiedMapTestCase::tap;
            this.payloads.forEach = UnifiedMapTestCase::forEach;
            this.payloads.forEachKeyValue = UnifiedMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = UnifiedMapTestCase::injectIntoKeyValue;
            this.payloads.flipUniqueValues = UnifiedMapTestCase::flipUniqueValues;
            this.payloads.collectMap = UnifiedMapTestCase::collectMap;
            this.payloads.collectBoolean = UnifiedMapTestCase::collectBoolean;
            this.payloads.collectBooleanWithTarget = UnifiedMapTestCase::collectBooleanWithTarget;
            this.payloads.collectByte = UnifiedMapTestCase::collectByte;
            this.payloads.collectByteWithTarget = UnifiedMapTestCase::collectByteWithTarget;
            this.payloads.collectChar = UnifiedMapTestCase::collectChar;
            this.payloads.collectCharWithTarget = UnifiedMapTestCase::collectCharWithTarget;
            this.payloads.collectDouble = UnifiedMapTestCase::collectDouble;
            this.payloads.collectDoubleWithTarget = UnifiedMapTestCase::collectDoubleWithTarget;
            this.payloads.collectFloat = UnifiedMapTestCase::collectFloat;
            this.payloads.collectFloatWithTarget = UnifiedMapTestCase::collectFloatWithTarget;
            this.payloads.collectInt = UnifiedMapTestCase::collectInt;
            this.payloads.collectIntWithTarget = UnifiedMapTestCase::collectIntWithTarget;
            this.payloads.collectLong = UnifiedMapTestCase::collectLong;
            this.payloads.collectLongWithTarget = UnifiedMapTestCase::collectLongWithTarget;
            this.payloads.collectShort = UnifiedMapTestCase::collectShort;
            this.payloads.collectShortWithTarget = UnifiedMapTestCase::collectShortWithTarget;
            this.payloads.collectValues = UnifiedMapTestCase::collectValues;
            this.payloads.select = UnifiedMapTestCase::select;
            this.payloads.selectWith = UnifiedMapTestCase::selectWith;
            this.payloads.reject = UnifiedMapTestCase::reject;
            this.payloads.rejectWith = UnifiedMapTestCase::rejectWith;
            this.payloads.collect = UnifiedMapTestCase::collect;
            this.payloads.flatCollect = UnifiedMapTestCase::flatCollect;
            this.payloads.flatCollectWith = UnifiedMapTestCase::flatCollectWith;
            this.payloads.selectMap = UnifiedMapTestCase::selectMap;
            this.payloads.rejectMap = UnifiedMapTestCase::rejectMap;
            this.payloads.flip = UnifiedMapTestCase::flip;
            this.payloads.detect = UnifiedMapTestCase::detect;
            this.payloads.detectOptional = UnifiedMapTestCase::detectOptional;
            this.payloads.anySatisfy = UnifiedMapTestCase::anySatisfy;
            this.payloads.anySatisfyWith = UnifiedMapTestCase::anySatisfyWith;
            this.payloads.allSatisfy = UnifiedMapTestCase::allSatisfy;
            this.payloads.allSatisfyWith = UnifiedMapTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = UnifiedMapTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = UnifiedMapTestCase::noneSatisfyWith;
            this.payloads.appendString = UnifiedMapTestCase::appendString;
            this.payloads.toBag = UnifiedMapTestCase::toBag;
            this.payloads.toSortedBag = UnifiedMapTestCase::toSortedBag;
            this.payloads.toSortedBagBy = UnifiedMapTestCase::toSortedBagBy;
            this.payloads.asLazy = UnifiedMapTestCase::asLazy;
            this.payloads.toList = UnifiedMapTestCase::toList;
            this.payloads.toMap = UnifiedMapTestCase::toMap;
            this.payloads.toSet = UnifiedMapTestCase::toSet;
            this.payloads.toSortedList = UnifiedMapTestCase::toSortedList;
            this.payloads.toSortedListBy = UnifiedMapTestCase::toSortedListBy;
            this.payloads.toSortedSet = UnifiedMapTestCase::toSortedSet;
            this.payloads.toSortedSetBy = UnifiedMapTestCase::toSortedSetBy;
            this.payloads.toSortedMap = UnifiedMapTestCase::toSortedMap;
            this.payloads.chunk = UnifiedMapTestCase::chunk;
            this.payloads.collect_value = UnifiedMapTestCase::collect_value;
            this.payloads.collectIf = UnifiedMapTestCase::collectIf;
            this.payloads.collectWith = UnifiedMapTestCase::collectWith;
            this.payloads.collectWithToTarget = UnifiedMapTestCase::collectWithToTarget;
            this.payloads.contains = UnifiedMapTestCase::contains;
            this.payloads.containsAnyIterable = UnifiedMapTestCase::containsAnyIterable;
            this.payloads.containsNoneIterable = UnifiedMapTestCase::containsNoneIterable;
            this.payloads.containsAnyCollection = UnifiedMapTestCase::containsAnyCollection;
            this.payloads.containsNoneCollection = UnifiedMapTestCase::containsNoneCollection;
            this.payloads.containsAll = UnifiedMapTestCase::containsAll;
            this.payloads.containsKey = UnifiedMapTestCase::containsKey;
            this.payloads.containsValue = UnifiedMapTestCase::containsValue;
            this.payloads.getFirst = UnifiedMapTestCase::getFirst;
            this.payloads.getLast = UnifiedMapTestCase::getLast;
            this.payloads.getOnly = UnifiedMapTestCase::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapTestCase::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapTestCase::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = UnifiedMapTestCase::containsAllIterable;
            this.payloads.containsAllArguments = UnifiedMapTestCase::containsAllArguments;
            this.payloads.count = UnifiedMapTestCase::count;
            this.payloads.countWith = UnifiedMapTestCase::countWith;
            this.payloads.detect_value = UnifiedMapTestCase::detect_value;
            this.payloads.detectOptional_value = UnifiedMapTestCase::detectOptional_value;
            this.payloads.detectWith = UnifiedMapTestCase::detectWith;
            this.payloads.detectWithOptional = UnifiedMapTestCase::detectWithOptional;
            this.payloads.detectIfNone_value = UnifiedMapTestCase::detectIfNone_value;
            this.payloads.detectWithIfNone = UnifiedMapTestCase::detectWithIfNone;
            this.payloads.flatten_value = UnifiedMapTestCase::flatten_value;
            this.payloads.countBy = UnifiedMapTestCase::countBy;
            this.payloads.countByWith = UnifiedMapTestCase::countByWith;
            this.payloads.countByEach = UnifiedMapTestCase::countByEach;
            this.payloads.groupBy = UnifiedMapTestCase::groupBy;
            this.payloads.groupByEach = UnifiedMapTestCase::groupByEach;
            this.payloads.groupByUniqueKey = UnifiedMapTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapTestCase::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = UnifiedMapTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapTestCase::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = UnifiedMapTestCase::injectInto;
            this.payloads.injectIntoInt = UnifiedMapTestCase::injectIntoInt;
            this.payloads.injectIntoLong = UnifiedMapTestCase::injectIntoLong;
            this.payloads.injectIntoFloat = UnifiedMapTestCase::injectIntoFloat;
            this.payloads.injectIntoDouble = UnifiedMapTestCase::injectIntoDouble;
            this.payloads.sumOfInt = UnifiedMapTestCase::sumOfInt;
            this.payloads.sumOfLong = UnifiedMapTestCase::sumOfLong;
            this.payloads.testAggregateBy = UnifiedMapTestCase::testAggregateBy;
            this.payloads.sumOfFloat = UnifiedMapTestCase::sumOfFloat;
            this.payloads.sumOfDouble = UnifiedMapTestCase::sumOfDouble;
            this.payloads.sumByInt = UnifiedMapTestCase::sumByInt;
            this.payloads.sumByFloat = UnifiedMapTestCase::sumByFloat;
            this.payloads.sumByLong = UnifiedMapTestCase::sumByLong;
            this.payloads.sumByDouble = UnifiedMapTestCase::sumByDouble;
            this.payloads.makeString = UnifiedMapTestCase::makeString;
            this.payloads.min = UnifiedMapTestCase::min;
            this.payloads.max = UnifiedMapTestCase::max;
            this.payloads.minBy = UnifiedMapTestCase::minBy;
            this.payloads.maxBy = UnifiedMapTestCase::maxBy;
            this.payloads.reject_value = UnifiedMapTestCase::reject_value;
            this.payloads.rejectWith_value = UnifiedMapTestCase::rejectWith_value;
            this.payloads.select_value = UnifiedMapTestCase::select_value;
            this.payloads.selectWith_value = UnifiedMapTestCase::selectWith_value;
            this.payloads.partition_value = UnifiedMapTestCase::partition_value;
            this.payloads.partitionWith_value = UnifiedMapTestCase::partitionWith_value;
            this.payloads.selectInstancesOf_value = UnifiedMapTestCase::selectInstancesOf_value;
            this.payloads.toArray = UnifiedMapTestCase::toArray;
            this.payloads.zip = UnifiedMapTestCase::zip;
            this.payloads.zipWithIndex = UnifiedMapTestCase::zipWithIndex;
            this.payloads.aggregateByMutating = UnifiedMapTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = UnifiedMapTestCase::aggregateByNonMutating;
            this.payloads.keyValuesView = UnifiedMapTestCase::keyValuesView;
            this.payloads.nullCollisionWithCastInEquals = UnifiedMapTestCase::nullCollisionWithCastInEquals;
            this.payloads.testNewMap = UnifiedMapTestCase::testNewMap;
            this.payloads.testNewMapWithKeyValue = UnifiedMapTestCase::testNewMapWithKeyValue;
            this.payloads.newMapWithWith = UnifiedMapTestCase::newMapWithWith;
            this.payloads.newMapWithWithWith = UnifiedMapTestCase::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = UnifiedMapTestCase::newMapWithWithWithWith;
            this.payloads.iterator = UnifiedMapTestCase::iterator;
            this.payloads.keysView = UnifiedMapTestCase::keysView;
            this.payloads.valuesView = UnifiedMapTestCase::valuesView;
            this.payloads.test_toString = UnifiedMapTestCase::test_toString;
            this.payloads.toImmutable = UnifiedMapTestCase::toImmutable;
            this.payloads.clear = UnifiedMapTestCase::clear;
            this.payloads.removeObject = UnifiedMapTestCase::removeObject;
            this.payloads.removeAllFromEntrySet = UnifiedMapTestCase::removeAllFromEntrySet;
            this.payloads.clearEntrySet = UnifiedMapTestCase::clearEntrySet;
            this.payloads.entrySetEqualsAndHashCode = UnifiedMapTestCase::entrySetEqualsAndHashCode;
            this.payloads.removeFromKeySet = UnifiedMapTestCase::removeFromKeySet;
            this.payloads.removeNullFromKeySet = UnifiedMapTestCase::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = UnifiedMapTestCase::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = UnifiedMapTestCase::retainAllFromKeySet;
            this.payloads.clearKeySet = UnifiedMapTestCase::clearKeySet;
            this.payloads.keySetEqualsAndHashCode = UnifiedMapTestCase::keySetEqualsAndHashCode;
            this.payloads.keySetToArray = UnifiedMapTestCase::keySetToArray;
            this.payloads.removeFromValues = UnifiedMapTestCase::removeFromValues;
            this.payloads.removeNullFromValues = UnifiedMapTestCase::removeNullFromValues;
            this.payloads.removeAllFromValues = UnifiedMapTestCase::removeAllFromValues;
            this.payloads.retainAllFromValues = UnifiedMapTestCase::retainAllFromValues;
            this.payloads.put = UnifiedMapTestCase::put;
            this.payloads.putAll = UnifiedMapTestCase::putAll;
            this.payloads.removeKey = UnifiedMapTestCase::removeKey;
            this.payloads.removeAllKeys = UnifiedMapTestCase::removeAllKeys;
            this.payloads.removeIf = UnifiedMapTestCase::removeIf;
            this.payloads.getIfAbsentPut = UnifiedMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPutValue = UnifiedMapTestCase::getIfAbsentPutValue;
            this.payloads.getIfAbsentPutWithKey = UnifiedMapTestCase::getIfAbsentPutWithKey;
            this.payloads.getIfAbsentPutWith = UnifiedMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPut_block_throws = UnifiedMapTestCase::getIfAbsentPut_block_throws;
            this.payloads.getIfAbsentPutWith_block_throws = UnifiedMapTestCase::getIfAbsentPutWith_block_throws;
            this.payloads.getKeysAndGetValues = UnifiedMapTestCase::getKeysAndGetValues;
            this.payloads.newEmpty = UnifiedMapTestCase::newEmpty;
            this.payloads.keysAndValues_toString = UnifiedMapTestCase::keysAndValues_toString;
            this.payloads.keyPreservation = UnifiedMapTestCase::keyPreservation;
            this.payloads.asUnmodifiable = UnifiedMapTestCase::asUnmodifiable;
            this.payloads.asSynchronized = UnifiedMapTestCase::asSynchronized;
            this.payloads.add = UnifiedMapTestCase::add;
            this.payloads.putPair = UnifiedMapTestCase::putPair;
            this.payloads.withKeyValue = UnifiedMapTestCase::withKeyValue;
            this.payloads.withMap = UnifiedMapTestCase::withMap;
            this.payloads.withMapEmpty = UnifiedMapTestCase::withMapEmpty;
            this.payloads.withMapTargetEmpty = UnifiedMapTestCase::withMapTargetEmpty;
            this.payloads.withMapEmptyAndTargetEmpty = UnifiedMapTestCase::withMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = UnifiedMapTestCase::withMapNull;
            this.payloads.withMapIterable = UnifiedMapTestCase::withMapIterable;
            this.payloads.withMapIterableEmpty = UnifiedMapTestCase::withMapIterableEmpty;
            this.payloads.withMapIterableTargetEmpty = UnifiedMapTestCase::withMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = UnifiedMapTestCase::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = UnifiedMapTestCase::withMapIterableNull;
            this.payloads.putAllMapIterable = UnifiedMapTestCase::putAllMapIterable;
            this.payloads.putAllMapIterableEmpty = UnifiedMapTestCase::putAllMapIterableEmpty;
            this.payloads.putAllMapIterableTargetEmpty = UnifiedMapTestCase::putAllMapIterableTargetEmpty;
            this.payloads.putAllMapIterableEmptyAndTargetEmpty = UnifiedMapTestCase::putAllMapIterableEmptyAndTargetEmpty;
            this.payloads.putAllMapIterableNull = UnifiedMapTestCase::putAllMapIterableNull;
            this.payloads.withAllKeyValues = UnifiedMapTestCase::withAllKeyValues;
            this.payloads.withAllKeyValueArguments = UnifiedMapTestCase::withAllKeyValueArguments;
            this.payloads.withoutKey = UnifiedMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = UnifiedMapTestCase::withoutAllKeys;
            this.payloads.retainAllFromKeySet_null_collision = UnifiedMapTestCase::retainAllFromKeySet_null_collision;
            this.payloads.rehash_null_collision = UnifiedMapTestCase::rehash_null_collision;
            this.payloads.updateValue = UnifiedMapTestCase::updateValue;
            this.payloads.updateValue_collisions = UnifiedMapTestCase::updateValue_collisions;
            this.payloads.updateValueWith = UnifiedMapTestCase::updateValueWith;
            this.payloads.updateValueWith_collisions = UnifiedMapTestCase::updateValueWith_collisions;
            this.payloads.collectKeysAndValues = UnifiedMapTestCase::collectKeysAndValues;
            this.payloads.testClone = UnifiedMapTestCase::testClone;
            this.payloads.valuesCollection_toArray = UnifiedMapTestCase::valuesCollection_toArray;
            this.payloads.valuesCollection_toArray_WithEmptyTarget = UnifiedMapTestCase::valuesCollection_toArray_WithEmptyTarget;
            this.payloads.valuesCollection_toArray_withPreSizedTarget = UnifiedMapTestCase::valuesCollection_toArray_withPreSizedTarget;
            this.payloads.valuesCollection_toArray_withLargeTarget = UnifiedMapTestCase::valuesCollection_toArray_withLargeTarget;
            this.payloads.entrySet_clear = UnifiedMapTestCase::entrySet_clear;
            this.payloads.valuesCollection_clear = UnifiedMapTestCase::valuesCollection_clear;
            this.payloads.keySet_toArray_withSmallTarget = UnifiedMapTestCase::keySet_toArray_withSmallTarget;
            this.payloads.keySet_ToArray_withLargeTarget = UnifiedMapTestCase::keySet_ToArray_withLargeTarget;
            this.payloads.noInstanceOfEquals = UnifiedMapTestCase::noInstanceOfEquals;
            this.payloads.keySet_hashCode = UnifiedMapTestCase::keySet_hashCode;
            this.payloads.keySet_copyKeys = UnifiedMapTestCase::keySet_copyKeys;
            this.payloads.entrySet_toArray = UnifiedMapTestCase::entrySet_toArray;
            this.payloads.entrySet_toArray_withEmptyTarget = UnifiedMapTestCase::entrySet_toArray_withEmptyTarget;
            this.payloads.entrySet_toArray_withPreSizedTarget = UnifiedMapTestCase::entrySet_toArray_withPreSizedTarget;
            this.payloads.entrySet_toArray_withLargeTarget = UnifiedMapTestCase::entrySet_toArray_withLargeTarget;
            this.payloads.entrySet_PostSerializedEqualsAndHashCode = UnifiedMapTestCase::entrySet_PostSerializedEqualsAndHashCode;
            this.payloads.keySet_PostSerializedEqualsAndHashCode = UnifiedMapTestCase::keySet_PostSerializedEqualsAndHashCode;
            this.payloads.keySet_PostSerializedEqualsAndHashCode_chainWithEmptySlot = UnifiedMapTestCase::keySet_PostSerializedEqualsAndHashCode_chainWithEmptySlot;
            this.payloads.valuesCollection_PostSerializedEquality = UnifiedMapTestCase::valuesCollection_PostSerializedEquality;
            this.payloads.valuesCollection_PostSerializedEquality_chainedMap = UnifiedMapTestCase::valuesCollection_PostSerializedEquality_chainedMap;
            this.payloads.valuesCollection_PostSerializedEquality_chainedMapWithEmptySlot = UnifiedMapTestCase::valuesCollection_PostSerializedEquality_chainedMapWithEmptySlot;
            this.payloads.contains_key_and_value = UnifiedMapTestCase::contains_key_and_value;
            this.payloads.remove = UnifiedMapTestCase::remove;
            this.payloads.getIfAbsentPutValueWithCollisions = UnifiedMapTestCase::getIfAbsentPutValueWithCollisions;
            this.payloads.getIfAbsentPutWithWithCollisions = UnifiedMapTestCase::getIfAbsentPutWithWithCollisions;
            this.payloads.removeFromEntrySet = UnifiedMapTestCase::removeFromEntrySet;
            this.payloads.retainAllFromEntrySet = UnifiedMapTestCase::retainAllFromEntrySet;
            this.payloads.forEachWith = UnifiedMapTestCase::forEachWith;
            this.payloads.keySet_retainAll = UnifiedMapTestCase::keySet_retainAll;
            this.payloads.keySet_containsAll = UnifiedMapTestCase::keySet_containsAll;
            this.payloads.keySet_equals = UnifiedMapTestCase::keySet_equals;
            this.payloads.keySet_add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapTestCase::keySet_add, java.lang.UnsupportedOperationException.class);
            this.payloads.keySet_addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapTestCase::keySet_addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.keySet_Iterator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapTestCase::keySet_Iterator, java.util.NoSuchElementException.class);
            this.payloads.entrySet_Iterator_incrementPastEnd = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapTestCase::entrySet_Iterator_incrementPastEnd, java.util.NoSuchElementException.class);
            this.payloads.keySet_Iterator_removeBeforeIncrement = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapTestCase::keySet_Iterator_removeBeforeIncrement, java.lang.IllegalStateException.class);
            this.payloads.valuesCollection_Iterator_remove = UnifiedMapTestCase::valuesCollection_Iterator_remove;
            this.payloads.iterator_many_collisions = UnifiedMapTestCase::iterator_many_collisions;
            this.payloads.entry_setValue = UnifiedMapTestCase::entry_setValue;
            this.payloads.entry_hashCodeForNullKeyAndValue = UnifiedMapTestCase::entry_hashCodeForNullKeyAndValue;
            this.payloads.entry_equalsWithNonEntry = UnifiedMapTestCase::entry_equalsWithNonEntry;
            this.payloads.entrySet_remove = UnifiedMapTestCase::entrySet_remove;
            this.payloads.entrySet_contains = UnifiedMapTestCase::entrySet_contains;
            this.payloads.entrySet_containsAll = UnifiedMapTestCase::entrySet_containsAll;
            this.payloads.entrySet_add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapTestCase::entrySet_add, java.lang.UnsupportedOperationException.class);
            this.payloads.entrySet_addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapTestCase::entrySet_addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.entrySet_equals = UnifiedMapTestCase::entrySet_equals;
            this.payloads.valuesCollection_add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapTestCase::valuesCollection_add, java.lang.UnsupportedOperationException.class);
            this.payloads.valuesCollection_addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapTestCase::valuesCollection_addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.valueCollection_Iterator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapTestCase::valueCollection_Iterator, java.util.NoSuchElementException.class);
            this.payloads.valueCollection_equals = UnifiedMapTestCase::valueCollection_equals;
            this.payloads.forEachWithIndex = UnifiedMapTestCase::forEachWithIndex;
            this.payloads.forEachKey = UnifiedMapTestCase::forEachKey;
            this.payloads.forEachValue = UnifiedMapTestCase::forEachValue;
            this.payloads.equalsAndHashCode = UnifiedMapTestCase::equalsAndHashCode;
            this.payloads.frequentCollision = UnifiedMapTestCase::frequentCollision;
        }
    }
}
