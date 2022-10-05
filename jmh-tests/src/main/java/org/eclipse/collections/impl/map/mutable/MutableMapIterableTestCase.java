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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.concurrent.ConcurrentMap;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.ImmutableMapIterable;
import org.eclipse.collections.api.map.MapIterable;
import org.eclipse.collections.api.map.MutableMapIterable;
import org.eclipse.collections.impl.IntegerWithCast;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.AbstractSynchronizedMapIterable;
import org.eclipse.collections.impl.map.MapIterableTestCase;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.domain.Key;
import org.eclipse.collections.impl.tuple.ImmutableEntry;
import org.eclipse.collections.impl.tuple.Tuples;
import org.eclipse.collections.impl.utility.Iterate;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iMap;
import static org.eclipse.collections.impl.factory.Iterables.mList;

/**
 * Abstract JUnit TestCase for {@link MutableMapIterable}s.
 */
public abstract class MutableMapIterableTestCase extends MapIterableTestCase {

    @Override
    protected abstract <K, V> MutableMapIterable<K, V> newMap();

    @Override
    protected abstract <K, V> MutableMapIterable<K, V> newMapWithKeyValue(K key, V value);

    @Override
    protected abstract <K, V> MutableMapIterable<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2);

    @Override
    protected abstract <K, V> MutableMapIterable<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3);

    @Override
    protected abstract <K, V> MutableMapIterable<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4);

    @Test
    public void toImmutable() {
        MutableMapIterable<Integer, String> map = this.newMapWithKeyValue(1, "One");
        ImmutableMapIterable<Integer, String> immutable = map.toImmutable();
        Assert.assertEquals(Maps.immutable.with(1, "One"), immutable);
    }

    @Test
    public void clear() {
        MutableMapIterable<Integer, Object> map = this.newMapWithKeysValues(1, "One", 2, "Two", 3, "Three");
        map.clear();
        Verify.assertEmpty(map);
        MutableMapIterable<Object, Object> map2 = this.newMap();
        map2.clear();
        Verify.assertEmpty(map2);
    }

    @Test
    public void removeObject() {
        MutableMapIterable<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        map.remove("Two");
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues("One", 1, "Three", 3), map);
    }

    @Test
    public void removeFromEntrySet() {
        MutableMapIterable<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        Assert.assertTrue(map.entrySet().remove(ImmutableEntry.of("Two", 2)));
        Assert.assertEquals(UnifiedMap.newWithKeysValues("One", 1, "Three", 3), map);
        Assert.assertFalse(map.entrySet().remove(ImmutableEntry.of("Four", 4)));
        Assert.assertEquals(UnifiedMap.newWithKeysValues("One", 1, "Three", 3), map);
        Assert.assertFalse(map.entrySet().remove(null));
        MutableMapIterable<String, Integer> mapWithNullKey = this.newMapWithKeysValues("One", 1, null, 2, "Three", 3);
        Assert.assertTrue(mapWithNullKey.entrySet().remove(new ImmutableEntry<String, Integer>(null, 2)));
    }

    @Test
    public void removeAllFromEntrySet() {
        MutableMapIterable<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        Assert.assertTrue(map.entrySet().removeAll(FastList.newListWith(ImmutableEntry.of("One", 1), ImmutableEntry.of("Three", 3))));
        Assert.assertEquals(UnifiedMap.newWithKeysValues("Two", 2), map);
        Assert.assertFalse(map.entrySet().removeAll(FastList.newListWith(ImmutableEntry.of("Four", 4))));
        Assert.assertEquals(UnifiedMap.newWithKeysValues("Two", 2), map);
        Assert.assertFalse(map.entrySet().remove(null));
        MutableMapIterable<String, Integer> mapWithNullKey = this.newMapWithKeysValues("One", 1, null, 2, "Three", 3);
        Assert.assertTrue(mapWithNullKey.entrySet().removeAll(FastList.newListWith(ImmutableEntry.of(null, 2))));
    }

    @Test
    public void retainAllFromEntrySet() {
        MutableMapIterable<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        Assert.assertFalse(map.entrySet().retainAll(FastList.newListWith(ImmutableEntry.of("One", 1), ImmutableEntry.of("Two", 2), ImmutableEntry.of("Three", 3), ImmutableEntry.of("Four", 4))));
        Assert.assertTrue(map.entrySet().retainAll(FastList.newListWith(ImmutableEntry.of("One", 1), ImmutableEntry.of("Three", 3), ImmutableEntry.of("Four", 4))));
        Assert.assertEquals(UnifiedMap.newWithKeysValues("One", 1, "Three", 3), map);
        MutableMapIterable<Integer, Integer> integers = this.newMapWithKeysValues(1, 1, 2, 2, 3, 3);
        Integer copy = new Integer(1);
        Assert.assertTrue(integers.entrySet().retainAll(mList(ImmutableEntry.of(copy, copy))));
        Assert.assertEquals(iMap(copy, copy), integers);
        Assert.assertNotSame(copy, Iterate.getOnly(integers.entrySet()).getKey());
        Assert.assertNotSame(copy, Iterate.getOnly(integers.entrySet()).getValue());
    }

    @Test
    public void clearEntrySet() {
        MutableMapIterable<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        map.entrySet().clear();
        Verify.assertEmpty(map);
    }

    @Test
    public void entrySetEqualsAndHashCode() {
        MutableMapIterable<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        Verify.assertEqualsAndHashCode(UnifiedSet.newSetWith(ImmutableEntry.of("One", 1), ImmutableEntry.of("Two", 2), ImmutableEntry.of("Three", 3)), map.entrySet());
    }

    @Test
    public void removeFromKeySet() {
        MutableMapIterable<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        Assert.assertFalse(map.keySet().remove("Four"));
        Assert.assertTrue(map.keySet().remove("Two"));
        Assert.assertEquals(UnifiedMap.newWithKeysValues("One", 1, "Three", 3), map);
    }

    @Test
    public void removeNullFromKeySet() {
        if (this.newMap() instanceof ConcurrentMap || this.newMap() instanceof SortedMap) {
            return;
        }
        MutableMapIterable<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        Assert.assertFalse(map.keySet().remove(null));
        Assert.assertEquals(UnifiedMap.newWithKeysValues("One", 1, "Two", 2, "Three", 3), map);
        map.put(null, 4);
        Assert.assertTrue(map.keySet().remove(null));
        Assert.assertEquals(UnifiedMap.newWithKeysValues("One", 1, "Two", 2, "Three", 3), map);
    }

    @Test
    public void removeAllFromKeySet() {
        MutableMapIterable<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        Assert.assertFalse(map.keySet().removeAll(FastList.newListWith("Four")));
        Assert.assertTrue(map.keySet().removeAll(FastList.newListWith("Two", "Four")));
        Assert.assertEquals(UnifiedMap.newWithKeysValues("One", 1, "Three", 3), map);
    }

    @Test
    public void retainAllFromKeySet() {
        MutableMapIterable<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        Assert.assertFalse(map.keySet().retainAll(FastList.newListWith("One", "Two", "Three", "Four")));
        Assert.assertTrue(map.keySet().retainAll(FastList.newListWith("One", "Three")));
        Assert.assertEquals(UnifiedMap.newWithKeysValues("One", 1, "Three", 3), map);
    }

    @Test
    public void clearKeySet() {
        MutableMapIterable<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        map.keySet().clear();
        Verify.assertEmpty(map);
    }

    @Test
    public void keySetEqualsAndHashCode() {
        MutableMapIterable<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3, null, null);
        Verify.assertEqualsAndHashCode(UnifiedSet.newSetWith("One", "Two", "Three", null), map.keySet());
    }

    @Test
    public void keySetToArray() {
        MutableMapIterable<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        MutableList<String> expected = FastList.newListWith("One", "Two", "Three").toSortedList();
        Set<String> keySet = map.keySet();
        Assert.assertEquals(expected, FastList.newListWith(keySet.toArray()).toSortedList());
        Assert.assertEquals(expected, FastList.newListWith(keySet.toArray(new String[keySet.size()])).toSortedList());
    }

    @Test
    public void removeFromValues() {
        MutableMapIterable<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        Assert.assertFalse(map.values().remove(4));
        Assert.assertTrue(map.values().remove(2));
        Assert.assertEquals(UnifiedMap.newWithKeysValues("One", 1, "Three", 3), map);
    }

    @Test
    public void removeNullFromValues() {
        if (this.newMap() instanceof ConcurrentMap) {
            return;
        }
        MutableMapIterable<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        Assert.assertFalse(map.values().remove(null));
        Assert.assertEquals(UnifiedMap.newWithKeysValues("One", 1, "Two", 2, "Three", 3), map);
        map.put("Four", null);
        Assert.assertTrue(map.values().remove(null));
        Assert.assertEquals(UnifiedMap.newWithKeysValues("One", 1, "Two", 2, "Three", 3), map);
    }

    @Test
    public void removeAllFromValues() {
        MutableMapIterable<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        Assert.assertFalse(map.values().removeAll(FastList.newListWith(4)));
        Assert.assertTrue(map.values().removeAll(FastList.newListWith(2, 4)));
        Assert.assertEquals(UnifiedMap.newWithKeysValues("One", 1, "Three", 3), map);
    }

    @Test
    public void retainAllFromValues() {
        MutableMapIterable<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        Assert.assertFalse(map.values().retainAll(FastList.newListWith(1, 2, 3, 4)));
        Assert.assertTrue(map.values().retainAll(FastList.newListWith(1, 3)));
        Assert.assertEquals(UnifiedMap.newWithKeysValues("One", 1, "Three", 3), map);
    }

    @Test
    public void put() {
        MutableMapIterable<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two");
        Assert.assertNull(map.put(3, "Three"));
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, "One", 2, "Two", 3, "Three"), map);
        ImmutableList<Integer> key1 = Lists.immutable.with(null);
        ImmutableList<Integer> key2 = Lists.immutable.with(null);
        Object value1 = new Object();
        Object value2 = new Object();
        MutableMapIterable<ImmutableList<Integer>, Object> map2 = this.newMapWithKeyValue(key1, value1);
        Object previousValue = map2.put(key2, value2);
        Assert.assertSame(value1, previousValue);
        Assert.assertSame(key1, map2.keysView().getFirst());
    }

    @Test
    public void putAll() {
        MutableMapIterable<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "2");
        MutableMapIterable<Integer, String> toAdd = this.newMapWithKeysValues(2, "Two", 3, "Three");
        map.putAll(toAdd);
        Verify.assertSize(3, map);
        Verify.assertContainsAllKeyValues(map, 1, "One", 2, "Two", 3, "Three");
        // Testing JDK map
        MutableMapIterable<Integer, String> map2 = this.newMapWithKeysValues(1, "One", 2, "2");
        Map<Integer, String> hashMaptoAdd = new HashMap<>(toAdd);
        map2.putAll(hashMaptoAdd);
        Verify.assertSize(3, map2);
        Verify.assertContainsAllKeyValues(map2, 1, "One", 2, "Two", 3, "Three");
    }

    @Test
    public void removeKey() {
        MutableMapIterable<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
        Assert.assertEquals("1", map.removeKey(1));
        Verify.assertSize(1, map);
        Verify.denyContainsKey(1, map);
        Assert.assertNull(map.removeKey(42));
        Verify.assertSize(1, map);
        Assert.assertEquals("Two", map.removeKey(2));
        Verify.assertEmpty(map);
    }

    @Test
    public void removeAllKeys() {
        MutableMapIterable<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two", 3, "Three");
        Assert.assertThrows(NullPointerException.class, () -> map.removeAllKeys(null));
        Assert.assertFalse(map.removeAllKeys(Sets.mutable.with(4)));
        Assert.assertFalse(map.removeAllKeys(Sets.mutable.with(4, 5, 6)));
        Assert.assertFalse(map.removeAllKeys(Sets.mutable.with(4, 5, 6, 7, 8, 9)));
        Assert.assertTrue(map.removeAllKeys(Sets.mutable.with(1)));
        Verify.denyContainsKey(1, map);
        Assert.assertTrue(map.removeAllKeys(Sets.mutable.with(3, 4, 5, 6, 7)));
        Verify.denyContainsKey(3, map);
        map.putAll(Maps.mutable.with(4, "Four", 5, "Five", 6, "Six", 7, "Seven"));
        Assert.assertTrue(map.removeAllKeys(Sets.mutable.with(2, 3, 9, 10)));
        Verify.denyContainsKey(2, map);
        Assert.assertTrue(map.removeAllKeys(Sets.mutable.with(5, 3, 7, 8, 9)));
        Assert.assertEquals(Maps.mutable.with(4, "Four", 6, "Six"), map);
    }

    @Test
    public void removeIf() {
        MutableMapIterable<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
        Assert.assertFalse(map.removeIf(Predicates2.alwaysFalse()));
        Assert.assertEquals(this.newMapWithKeysValues(1, "1", 2, "Two"), map);
        Assert.assertTrue(map.removeIf(Predicates2.alwaysTrue()));
        Verify.assertEmpty(map);
        map.putAll(Maps.mutable.with(1, "One", 2, "TWO", 3, "THREE", 4, "four"));
        map.putAll(Maps.mutable.with(5, "Five", 6, "Six", 7, "Seven", 8, "Eight"));
        Assert.assertTrue(map.removeIf((each, value) -> each % 2 == 0 && value.length() < 4));
        Verify.denyContainsKey(2, map);
        Verify.denyContainsKey(6, map);
        MutableMapIterable<Integer, String> expected = this.newMapWithKeysValues(1, "One", 3, "THREE", 4, "four", 5, "Five");
        expected.put(7, "Seven");
        expected.put(8, "Eight");
        Assert.assertEquals(expected, map);
        Assert.assertTrue(map.removeIf((each, value) -> each % 2 != 0 && value.equals("THREE")));
        Verify.denyContainsKey(3, map);
        Verify.assertSize(5, map);
        Assert.assertTrue(map.removeIf((each, value) -> each % 2 != 0));
        Assert.assertFalse(map.removeIf((each, value) -> each % 2 != 0));
        Assert.assertEquals(this.newMapWithKeysValues(4, "four", 8, "Eight"), map);
    }

    @Test
    public void getIfAbsentPut() {
        MutableMapIterable<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        Assert.assertNull(map.get(4));
        Assert.assertEquals("4", map.getIfAbsentPut(4, new PassThruFunction0<>("4")));
        Assert.assertEquals("3", map.getIfAbsentPut(3, new PassThruFunction0<>("3")));
        Verify.assertContainsKeyValue(4, "4", map);
    }

    @Test
    public void getIfAbsentPutValue() {
        MutableMapIterable<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        Assert.assertNull(map.get(4));
        Assert.assertEquals("4", map.getIfAbsentPut(4, "4"));
        Assert.assertEquals("3", map.getIfAbsentPut(3, "5"));
        Verify.assertContainsKeyValue(1, "1", map);
        Verify.assertContainsKeyValue(2, "2", map);
        Verify.assertContainsKeyValue(3, "3", map);
        Verify.assertContainsKeyValue(4, "4", map);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        MutableMapIterable<Integer, Integer> map = this.newMapWithKeysValues(1, 1, 2, 2, 3, 3);
        Assert.assertNull(map.get(4));
        Assert.assertEquals(Integer.valueOf(4), map.getIfAbsentPutWithKey(4, Functions.getIntegerPassThru()));
        Assert.assertEquals(Integer.valueOf(3), map.getIfAbsentPutWithKey(3, Functions.getIntegerPassThru()));
        Verify.assertContainsKeyValue(Integer.valueOf(4), Integer.valueOf(4), map);
    }

    @Test
    public void getIfAbsentPutWith() {
        MutableMapIterable<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        Assert.assertNull(map.get(4));
        Assert.assertEquals("4", map.getIfAbsentPutWith(4, String::valueOf, 4));
        Assert.assertEquals("3", map.getIfAbsentPutWith(3, String::valueOf, 3));
        Verify.assertContainsKeyValue(4, "4", map);
    }

    @Test
    public void getIfAbsentPut_block_throws() {
        MutableMapIterable<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        Assert.assertThrows(RuntimeException.class, () -> map.getIfAbsentPut(4, () -> {
            throw new RuntimeException();
        }));
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, "1", 2, "2", 3, "3"), map);
    }

    @Test
    public void getIfAbsentPutWith_block_throws() {
        MutableMapIterable<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        Assert.assertThrows(RuntimeException.class, () -> map.getIfAbsentPutWith(4, object -> {
            throw new RuntimeException();
        }, null));
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, "1", 2, "2", 3, "3"), map);
    }

    @Test
    public void getKeysAndGetValues() {
        MutableMapIterable<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        Verify.assertContainsAll(map.keySet(), 1, 2, 3);
        Verify.assertContainsAll(map.values(), "1", "2", "3");
    }

    @Test
    public void newEmpty() {
        MutableMapIterable<Integer, Integer> map = this.newMapWithKeysValues(1, 1, 2, 2);
        Verify.assertEmpty(map.newEmpty());
    }

    @Test
    public void keysAndValues_toString() {
        MutableMapIterable<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2");
        Verify.assertContains(map.keySet().toString(), FastList.newListWith("[1, 2]", "[2, 1]"));
        Verify.assertContains(map.values().toString(), FastList.newListWith("[1, 2]", "[2, 1]"));
        Verify.assertContains(map.keysView().toString(), FastList.newListWith("[1, 2]", "[2, 1]"));
        Verify.assertContains(map.valuesView().toString(), FastList.newListWith("[1, 2]", "[2, 1]"));
    }

    @Test
    public void keyPreservation() {
        Key key = new Key("key");
        Key duplicateKey1 = new Key("key");
        MapIterable<Key, Integer> map1 = this.newMapWithKeysValues(key, 1, duplicateKey1, 2);
        Verify.assertSize(1, map1);
        Verify.assertContainsKeyValue(key, 2, map1);
        Assert.assertSame(key, map1.keysView().getFirst());
        Key duplicateKey2 = new Key("key");
        MapIterable<Key, Integer> map2 = this.newMapWithKeysValues(key, 1, duplicateKey1, 2, duplicateKey2, 3);
        Verify.assertSize(1, map2);
        Verify.assertContainsKeyValue(key, 3, map2);
        Assert.assertSame(key, map1.keysView().getFirst());
        Key duplicateKey3 = new Key("key");
        MapIterable<Key, Integer> map3 = this.newMapWithKeysValues(key, 1, new Key("not a dupe"), 2, duplicateKey3, 3);
        Verify.assertSize(2, map3);
        Verify.assertContainsAllKeyValues(map3, key, 3, new Key("not a dupe"), 2);
        Assert.assertSame(key, map3.keysView().detect(key::equals));
        Key duplicateKey4 = new Key("key");
        MapIterable<Key, Integer> map4 = this.newMapWithKeysValues(key, 1, new Key("still not a dupe"), 2, new Key("me neither"), 3, duplicateKey4, 4);
        Verify.assertSize(3, map4);
        Verify.assertContainsAllKeyValues(map4, key, 4, new Key("still not a dupe"), 2, new Key("me neither"), 3);
        Assert.assertSame(key, map4.keysView().detect(key::equals));
        MapIterable<Key, Integer> map5 = this.newMapWithKeysValues(key, 1, duplicateKey1, 2, duplicateKey3, 3, duplicateKey4, 4);
        Verify.assertSize(1, map5);
        Verify.assertContainsKeyValue(key, 4, map5);
        Assert.assertSame(key, map5.keysView().getFirst());
    }

    @Test
    public void asUnmodifiable() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeysValues(1, 1, 2, 2).asUnmodifiable().put(3, 3));
    }

    @Test
    public void asSynchronized() {
        MapIterable<Integer, Integer> map = this.newMapWithKeysValues(1, 1, 2, 2).asSynchronized();
        Verify.assertInstanceOf(AbstractSynchronizedMapIterable.class, map);
    }

    @Test
    public void add() {
        MutableMapIterable<String, Integer> map = this.newMapWithKeyValue("A", 1);
        Assert.assertEquals(Integer.valueOf(1), map.add(Tuples.pair("A", 3)));
        Assert.assertNull(map.add(Tuples.pair("B", 2)));
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues("A", 3, "B", 2), map);
    }

    @Test
    public void putPair() {
        MutableMapIterable<String, Integer> map = this.newMapWithKeyValue("A", 1);
        Assert.assertEquals(Integer.valueOf(1), map.putPair(Tuples.pair("A", 3)));
        Assert.assertNull(map.putPair(Tuples.pair("B", 2)));
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues("A", 3, "B", 2), map);
    }

    @Test
    public void withKeyValue() {
        MutableMapIterable<String, Integer> map = this.newMapWithKeyValue("A", 1);
        MutableMapIterable<String, Integer> mapWith = map.withKeyValue("B", 2);
        Assert.assertSame(map, mapWith);
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues("A", 1, "B", 2), mapWith);
        MutableMapIterable<String, Integer> mapWith2 = mapWith.withKeyValue("A", 11);
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues("A", 11, "B", 2), mapWith2);
        Assert.assertSame(mapWith, mapWith2);
    }

    @Test
    public void withMap() {
        MutableMapIterable<String, Integer> map = this.newMapWithKeysValues("A", 1, "B", 2);
        Map<String, Integer> simpleMap = Maps.mutable.with("B", 22, "C", 3);
        map.putAll(simpleMap);
        MutableMapIterable<String, Integer> mapWith = map.withMap(simpleMap);
        Assert.assertSame(map, mapWith);
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues("A", 1, "B", 22, "C", 3), mapWith);
    }

    @Test
    public void withMapEmpty() {
        MutableMapIterable<String, Integer> map = this.newMapWithKeysValues("A", 1, "B", 2);
        MutableMapIterable<String, Integer> mapWith = map.withMap(Maps.mutable.empty());
        Assert.assertSame(map, mapWith);
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues("A", 1, "B", 2), mapWith);
    }

    @Test
    public void withMapTargetEmpty() {
        MutableMapIterable<String, Integer> map = this.newMap();
        Map<String, Integer> simpleMap = Maps.mutable.with("A", 1, "B", 2);
        MutableMapIterable<String, Integer> mapWith = map.withMap(simpleMap);
        Assert.assertSame(map, mapWith);
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues("A", 1, "B", 2), mapWith);
    }

    @Test
    public void withMapEmptyAndTargetEmpty() {
        MutableMapIterable<String, Integer> map = this.newMap();
        MutableMapIterable<String, Integer> mapWith = map.withMap(Maps.mutable.empty());
        Assert.assertSame(map, mapWith);
        Verify.assertMapsEqual(UnifiedMap.newMap(), mapWith);
    }

    @Test
    public void withMapNull() {
        Assert.assertThrows(NullPointerException.class, () -> this.newMap().withMap(null));
    }

    @Test
    public void withMapIterable() {
        MutableMapIterable<String, Integer> map = this.newMapWithKeysValues("A", 1, "B", 2);
        MutableMapIterable<String, Integer> simpleMap = Maps.mutable.with("B", 22, "C", 3);
        map.putAll(simpleMap);
        MutableMapIterable<String, Integer> mapWith = map.withMapIterable(simpleMap);
        Assert.assertSame(map, mapWith);
        Verify.assertMapsEqual(Maps.mutable.with("A", 1, "B", 22, "C", 3), mapWith);
    }

    @Test
    public void withMapIterableEmpty() {
        MutableMapIterable<String, Integer> map = this.newMapWithKeysValues("A", 1, "B", 2);
        MutableMapIterable<String, Integer> mapWith = map.withMapIterable(Maps.mutable.empty());
        Assert.assertSame(map, mapWith);
        Verify.assertMapsEqual(Maps.mutable.with("A", 1, "B", 2), mapWith);
    }

    @Test
    public void withMapIterableTargetEmpty() {
        MutableMapIterable<String, Integer> map = this.newMap();
        MutableMapIterable<String, Integer> mapWith = map.withMapIterable(Maps.mutable.with("A", 1, "B", 2));
        Assert.assertSame(map, mapWith);
        Verify.assertMapsEqual(Maps.mutable.with("A", 1, "B", 2), mapWith);
    }

    @Test
    public void withMapIterableEmptyAndTargetEmpty() {
        MutableMapIterable<String, Integer> map = this.newMap();
        MutableMapIterable<String, Integer> mapWith = map.withMapIterable(Maps.mutable.empty());
        Assert.assertSame(map, mapWith);
        Verify.assertMapsEqual(Maps.mutable.withMapIterable(map), mapWith);
    }

    @Test
    public void withMapIterableNull() {
        Assert.assertThrows(NullPointerException.class, () -> this.newMap().withMapIterable(null));
    }

    @Test
    public void putAllMapIterable() {
        MutableMapIterable<String, Integer> map = this.newMapWithKeysValues("A", 1, "B", 2);
        MutableMapIterable<String, Integer> simpleMap = Maps.mutable.with("B", 22, "C", 3);
        map.putAllMapIterable(simpleMap);
        Verify.assertMapsEqual(Maps.mutable.with("A", 1, "B", 22, "C", 3), map);
    }

    @Test
    public void putAllMapIterableEmpty() {
        MutableMapIterable<String, Integer> map = this.newMapWithKeysValues("A", 1, "B", 2);
        map.putAllMapIterable(Maps.mutable.empty());
        Verify.assertMapsEqual(Maps.mutable.with("A", 1, "B", 2), map);
    }

    @Test
    public void putAllMapIterableTargetEmpty() {
        MutableMapIterable<String, Integer> map = this.newMap();
        map.putAllMapIterable(Maps.mutable.with("A", 1, "B", 2));
        Verify.assertMapsEqual(Maps.mutable.with("A", 1, "B", 2), map);
    }

    @Test
    public void putAllMapIterableEmptyAndTargetEmpty() {
        MutableMapIterable<String, Integer> map = this.newMap();
        map.putAllMapIterable(Maps.mutable.empty());
        Verify.assertMapsEqual(Maps.mutable.withMapIterable(map), map);
    }

    @Test
    public void putAllMapIterableNull() {
        Assert.assertThrows(NullPointerException.class, () -> this.newMap().putAllMapIterable(null));
    }

    @Test
    public void withAllKeyValues() {
        MutableMapIterable<String, Integer> map = this.newMapWithKeysValues("A", 1, "B", 2);
        MutableMapIterable<String, Integer> mapWith = map.withAllKeyValues(FastList.newListWith(Tuples.pair("B", 22), Tuples.pair("C", 3)));
        Assert.assertSame(map, mapWith);
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues("A", 1, "B", 22, "C", 3), mapWith);
    }

    @Test
    public void withAllKeyValueArguments() {
        MutableMapIterable<String, Integer> map = this.newMapWithKeysValues("A", 1, "B", 2);
        MutableMapIterable<String, Integer> mapWith = map.withAllKeyValueArguments(Tuples.pair("B", 22), Tuples.pair("C", 3));
        Assert.assertSame(map, mapWith);
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues("A", 1, "B", 22, "C", 3), mapWith);
    }

    @Test
    public void withoutKey() {
        MutableMapIterable<String, Integer> map = this.newMapWithKeysValues("A", 1, "B", 2);
        MutableMapIterable<String, Integer> mapWithout = map.withoutKey("B");
        Assert.assertSame(map, mapWithout);
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues("A", 1), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableMapIterable<String, Integer> map = this.newMapWithKeysValues("A", 1, "B", 2, "C", 3);
        MutableMapIterable<String, Integer> mapWithout = map.withoutAllKeys(FastList.newListWith("A", "C"));
        Assert.assertSame(map, mapWithout);
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues("B", 2), mapWithout);
    }

    @Test
    public void retainAllFromKeySet_null_collision() {
        if (this.newMap() instanceof ConcurrentMap || this.newMap() instanceof SortedMap) {
            return;
        }
        IntegerWithCast key = new IntegerWithCast(0);
        MutableMapIterable<IntegerWithCast, String> mutableMapIterable = this.newMapWithKeysValues(null, "Test 1", key, "Test 2");
        Assert.assertFalse(mutableMapIterable.keySet().retainAll(FastList.newListWith(key, null)));
        Assert.assertEquals(this.newMapWithKeysValues(null, "Test 1", key, "Test 2"), mutableMapIterable);
    }

    @Test
    public void rehash_null_collision() {
        if (this.newMap() instanceof ConcurrentMap || this.newMap() instanceof SortedMap) {
            return;
        }
        MutableMapIterable<IntegerWithCast, String> mutableMapIterable = this.newMapWithKeyValue(null, null);
        for (int i = 0; i < 256; i++) {
            mutableMapIterable.put(new IntegerWithCast(i), String.valueOf(i));
        }
    }

    @Test
    public void updateValue() {
        MutableMapIterable<Integer, Integer> map = this.newMap();
        Iterate.forEach(Interval.oneTo(1000), each -> map.updateValue(each % 10, () -> 0, integer -> integer + 1));
        Assert.assertEquals(Interval.zeroTo(9).toSet(), map.keySet());
        Assert.assertEquals(FastList.newList(Collections.nCopies(10, 100)), FastList.newList(map.values()));
    }

    @Test
    public void updateValue_collisions() {
        MutableMapIterable<Integer, Integer> map = this.newMap();
        MutableList<Integer> list = Interval.oneTo(2000).toList().shuffleThis();
        Iterate.forEach(list, each -> map.updateValue(each % 1000, () -> 0, integer -> integer + 1));
        Assert.assertEquals(Interval.zeroTo(999).toSet(), map.keySet());
        Assert.assertEquals(HashBag.newBag(map.values()).toStringOfItemToCount(), FastList.newList(Collections.nCopies(1000, 2)), FastList.newList(map.values()));
    }

    @Test
    public void updateValueWith() {
        MutableMapIterable<Integer, Integer> map = this.newMap();
        Iterate.forEach(Interval.oneTo(1000), each -> map.updateValueWith(each % 10, () -> 0, (integer, parameter) -> {
            Assert.assertEquals("test", parameter);
            return integer + 1;
        }, "test"));
        Assert.assertEquals(Interval.zeroTo(9).toSet(), map.keySet());
        Assert.assertEquals(FastList.newList(Collections.nCopies(10, 100)), FastList.newList(map.values()));
    }

    @Test
    public void updateValueWith_collisions() {
        MutableMapIterable<Integer, Integer> map = this.newMap();
        MutableList<Integer> list = Interval.oneTo(2000).toList().shuffleThis();
        Iterate.forEach(list, each -> map.updateValueWith(each % 1000, () -> 0, (integer, parameter) -> {
            Assert.assertEquals("test", parameter);
            return integer + 1;
        }, "test"));
        Assert.assertEquals(Interval.zeroTo(999).toSet(), map.keySet());
        Assert.assertEquals(HashBag.newBag(map.values()).toStringOfItemToCount(), FastList.newList(Collections.nCopies(1000, 2)), FastList.newList(map.values()));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MutableMapIterableTestCase instance;

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
        public void benchmark_removeFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromEntrySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromEntrySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromEntrySet);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> payload) throws java.lang.Throwable {
            this.instance = new MutableMapIterableTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> test_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> removeFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> removeAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> retainAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> clearEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> entrySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> keySetToArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> removeFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> removeNullFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> removeAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> retainAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> removeAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> getIfAbsentPutValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> getIfAbsentPut_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> getIfAbsentPutWith_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> getKeysAndGetValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> keysAndValues_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> keyPreservation;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> withKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> withMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> withMapEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> withMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> withMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> withMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> withMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> withMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> putAllMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> putAllMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> putAllMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> putAllMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> putAllMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> withAllKeyValueArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> retainAllFromKeySet_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> rehash_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> updateValue_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapIterableTestCase> updateValueWith_collisions;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = MutableMapIterableTestCase::stream;
            this.payloads.parallelStream = MutableMapIterableTestCase::parallelStream;
            this.payloads.equalsAndHashCode = MutableMapIterableTestCase::equalsAndHashCode;
            this.payloads.serialization = MutableMapIterableTestCase::serialization;
            this.payloads.isEmpty = MutableMapIterableTestCase::isEmpty;
            this.payloads.notEmpty = MutableMapIterableTestCase::notEmpty;
            this.payloads.ifPresentApply = MutableMapIterableTestCase::ifPresentApply;
            this.payloads.getIfAbsent_function = MutableMapIterableTestCase::getIfAbsent_function;
            this.payloads.getOrDefault = MutableMapIterableTestCase::getOrDefault;
            this.payloads.getIfAbsent = MutableMapIterableTestCase::getIfAbsent;
            this.payloads.getIfAbsentWith = MutableMapIterableTestCase::getIfAbsentWith;
            this.payloads.tap = MutableMapIterableTestCase::tap;
            this.payloads.forEach = MutableMapIterableTestCase::forEach;
            this.payloads.forEachWith = MutableMapIterableTestCase::forEachWith;
            this.payloads.forEachWithIndex = MutableMapIterableTestCase::forEachWithIndex;
            this.payloads.forEachKey = MutableMapIterableTestCase::forEachKey;
            this.payloads.forEachValue = MutableMapIterableTestCase::forEachValue;
            this.payloads.forEachKeyValue = MutableMapIterableTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = MutableMapIterableTestCase::injectIntoKeyValue;
            this.payloads.flipUniqueValues = MutableMapIterableTestCase::flipUniqueValues;
            this.payloads.collectMap = MutableMapIterableTestCase::collectMap;
            this.payloads.collectBoolean = MutableMapIterableTestCase::collectBoolean;
            this.payloads.collectBooleanWithTarget = MutableMapIterableTestCase::collectBooleanWithTarget;
            this.payloads.collectByte = MutableMapIterableTestCase::collectByte;
            this.payloads.collectByteWithTarget = MutableMapIterableTestCase::collectByteWithTarget;
            this.payloads.collectChar = MutableMapIterableTestCase::collectChar;
            this.payloads.collectCharWithTarget = MutableMapIterableTestCase::collectCharWithTarget;
            this.payloads.collectDouble = MutableMapIterableTestCase::collectDouble;
            this.payloads.collectDoubleWithTarget = MutableMapIterableTestCase::collectDoubleWithTarget;
            this.payloads.collectFloat = MutableMapIterableTestCase::collectFloat;
            this.payloads.collectFloatWithTarget = MutableMapIterableTestCase::collectFloatWithTarget;
            this.payloads.collectInt = MutableMapIterableTestCase::collectInt;
            this.payloads.collectIntWithTarget = MutableMapIterableTestCase::collectIntWithTarget;
            this.payloads.collectLong = MutableMapIterableTestCase::collectLong;
            this.payloads.collectLongWithTarget = MutableMapIterableTestCase::collectLongWithTarget;
            this.payloads.collectShort = MutableMapIterableTestCase::collectShort;
            this.payloads.collectShortWithTarget = MutableMapIterableTestCase::collectShortWithTarget;
            this.payloads.collectValues = MutableMapIterableTestCase::collectValues;
            this.payloads.select = MutableMapIterableTestCase::select;
            this.payloads.selectWith = MutableMapIterableTestCase::selectWith;
            this.payloads.reject = MutableMapIterableTestCase::reject;
            this.payloads.rejectWith = MutableMapIterableTestCase::rejectWith;
            this.payloads.collect = MutableMapIterableTestCase::collect;
            this.payloads.flatCollect = MutableMapIterableTestCase::flatCollect;
            this.payloads.flatCollectWith = MutableMapIterableTestCase::flatCollectWith;
            this.payloads.selectMap = MutableMapIterableTestCase::selectMap;
            this.payloads.rejectMap = MutableMapIterableTestCase::rejectMap;
            this.payloads.flip = MutableMapIterableTestCase::flip;
            this.payloads.detect = MutableMapIterableTestCase::detect;
            this.payloads.detectOptional = MutableMapIterableTestCase::detectOptional;
            this.payloads.anySatisfy = MutableMapIterableTestCase::anySatisfy;
            this.payloads.anySatisfyWith = MutableMapIterableTestCase::anySatisfyWith;
            this.payloads.allSatisfy = MutableMapIterableTestCase::allSatisfy;
            this.payloads.allSatisfyWith = MutableMapIterableTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = MutableMapIterableTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = MutableMapIterableTestCase::noneSatisfyWith;
            this.payloads.appendString = MutableMapIterableTestCase::appendString;
            this.payloads.toBag = MutableMapIterableTestCase::toBag;
            this.payloads.toSortedBag = MutableMapIterableTestCase::toSortedBag;
            this.payloads.toSortedBagBy = MutableMapIterableTestCase::toSortedBagBy;
            this.payloads.asLazy = MutableMapIterableTestCase::asLazy;
            this.payloads.toList = MutableMapIterableTestCase::toList;
            this.payloads.toMap = MutableMapIterableTestCase::toMap;
            this.payloads.toSet = MutableMapIterableTestCase::toSet;
            this.payloads.toSortedList = MutableMapIterableTestCase::toSortedList;
            this.payloads.toSortedListBy = MutableMapIterableTestCase::toSortedListBy;
            this.payloads.toSortedSet = MutableMapIterableTestCase::toSortedSet;
            this.payloads.toSortedSetBy = MutableMapIterableTestCase::toSortedSetBy;
            this.payloads.toSortedMap = MutableMapIterableTestCase::toSortedMap;
            this.payloads.chunk = MutableMapIterableTestCase::chunk;
            this.payloads.collect_value = MutableMapIterableTestCase::collect_value;
            this.payloads.collectIf = MutableMapIterableTestCase::collectIf;
            this.payloads.collectWith = MutableMapIterableTestCase::collectWith;
            this.payloads.collectWithToTarget = MutableMapIterableTestCase::collectWithToTarget;
            this.payloads.contains = MutableMapIterableTestCase::contains;
            this.payloads.containsAnyIterable = MutableMapIterableTestCase::containsAnyIterable;
            this.payloads.containsNoneIterable = MutableMapIterableTestCase::containsNoneIterable;
            this.payloads.containsAnyCollection = MutableMapIterableTestCase::containsAnyCollection;
            this.payloads.containsNoneCollection = MutableMapIterableTestCase::containsNoneCollection;
            this.payloads.containsAll = MutableMapIterableTestCase::containsAll;
            this.payloads.containsKey = MutableMapIterableTestCase::containsKey;
            this.payloads.containsValue = MutableMapIterableTestCase::containsValue;
            this.payloads.getFirst = MutableMapIterableTestCase::getFirst;
            this.payloads.getLast = MutableMapIterableTestCase::getLast;
            this.payloads.getOnly = MutableMapIterableTestCase::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableMapIterableTestCase::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableMapIterableTestCase::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = MutableMapIterableTestCase::containsAllIterable;
            this.payloads.containsAllArguments = MutableMapIterableTestCase::containsAllArguments;
            this.payloads.count = MutableMapIterableTestCase::count;
            this.payloads.countWith = MutableMapIterableTestCase::countWith;
            this.payloads.detect_value = MutableMapIterableTestCase::detect_value;
            this.payloads.detectOptional_value = MutableMapIterableTestCase::detectOptional_value;
            this.payloads.detectWith = MutableMapIterableTestCase::detectWith;
            this.payloads.detectWithOptional = MutableMapIterableTestCase::detectWithOptional;
            this.payloads.detectIfNone_value = MutableMapIterableTestCase::detectIfNone_value;
            this.payloads.detectWithIfNone = MutableMapIterableTestCase::detectWithIfNone;
            this.payloads.flatten_value = MutableMapIterableTestCase::flatten_value;
            this.payloads.countBy = MutableMapIterableTestCase::countBy;
            this.payloads.countByWith = MutableMapIterableTestCase::countByWith;
            this.payloads.countByEach = MutableMapIterableTestCase::countByEach;
            this.payloads.groupBy = MutableMapIterableTestCase::groupBy;
            this.payloads.groupByEach = MutableMapIterableTestCase::groupByEach;
            this.payloads.groupByUniqueKey = MutableMapIterableTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableMapIterableTestCase::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = MutableMapIterableTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableMapIterableTestCase::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = MutableMapIterableTestCase::injectInto;
            this.payloads.injectIntoInt = MutableMapIterableTestCase::injectIntoInt;
            this.payloads.injectIntoLong = MutableMapIterableTestCase::injectIntoLong;
            this.payloads.injectIntoFloat = MutableMapIterableTestCase::injectIntoFloat;
            this.payloads.injectIntoDouble = MutableMapIterableTestCase::injectIntoDouble;
            this.payloads.sumOfInt = MutableMapIterableTestCase::sumOfInt;
            this.payloads.sumOfLong = MutableMapIterableTestCase::sumOfLong;
            this.payloads.testAggregateBy = MutableMapIterableTestCase::testAggregateBy;
            this.payloads.sumOfFloat = MutableMapIterableTestCase::sumOfFloat;
            this.payloads.sumOfDouble = MutableMapIterableTestCase::sumOfDouble;
            this.payloads.sumByInt = MutableMapIterableTestCase::sumByInt;
            this.payloads.sumByFloat = MutableMapIterableTestCase::sumByFloat;
            this.payloads.sumByLong = MutableMapIterableTestCase::sumByLong;
            this.payloads.sumByDouble = MutableMapIterableTestCase::sumByDouble;
            this.payloads.makeString = MutableMapIterableTestCase::makeString;
            this.payloads.min = MutableMapIterableTestCase::min;
            this.payloads.max = MutableMapIterableTestCase::max;
            this.payloads.minBy = MutableMapIterableTestCase::minBy;
            this.payloads.maxBy = MutableMapIterableTestCase::maxBy;
            this.payloads.reject_value = MutableMapIterableTestCase::reject_value;
            this.payloads.rejectWith_value = MutableMapIterableTestCase::rejectWith_value;
            this.payloads.select_value = MutableMapIterableTestCase::select_value;
            this.payloads.selectWith_value = MutableMapIterableTestCase::selectWith_value;
            this.payloads.partition_value = MutableMapIterableTestCase::partition_value;
            this.payloads.partitionWith_value = MutableMapIterableTestCase::partitionWith_value;
            this.payloads.selectInstancesOf_value = MutableMapIterableTestCase::selectInstancesOf_value;
            this.payloads.toArray = MutableMapIterableTestCase::toArray;
            this.payloads.zip = MutableMapIterableTestCase::zip;
            this.payloads.zipWithIndex = MutableMapIterableTestCase::zipWithIndex;
            this.payloads.aggregateByMutating = MutableMapIterableTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = MutableMapIterableTestCase::aggregateByNonMutating;
            this.payloads.keyValuesView = MutableMapIterableTestCase::keyValuesView;
            this.payloads.nullCollisionWithCastInEquals = MutableMapIterableTestCase::nullCollisionWithCastInEquals;
            this.payloads.testNewMap = MutableMapIterableTestCase::testNewMap;
            this.payloads.testNewMapWithKeyValue = MutableMapIterableTestCase::testNewMapWithKeyValue;
            this.payloads.newMapWithWith = MutableMapIterableTestCase::newMapWithWith;
            this.payloads.newMapWithWithWith = MutableMapIterableTestCase::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = MutableMapIterableTestCase::newMapWithWithWithWith;
            this.payloads.iterator = MutableMapIterableTestCase::iterator;
            this.payloads.keysView = MutableMapIterableTestCase::keysView;
            this.payloads.valuesView = MutableMapIterableTestCase::valuesView;
            this.payloads.test_toString = MutableMapIterableTestCase::test_toString;
            this.payloads.toImmutable = MutableMapIterableTestCase::toImmutable;
            this.payloads.clear = MutableMapIterableTestCase::clear;
            this.payloads.removeObject = MutableMapIterableTestCase::removeObject;
            this.payloads.removeFromEntrySet = MutableMapIterableTestCase::removeFromEntrySet;
            this.payloads.removeAllFromEntrySet = MutableMapIterableTestCase::removeAllFromEntrySet;
            this.payloads.retainAllFromEntrySet = MutableMapIterableTestCase::retainAllFromEntrySet;
            this.payloads.clearEntrySet = MutableMapIterableTestCase::clearEntrySet;
            this.payloads.entrySetEqualsAndHashCode = MutableMapIterableTestCase::entrySetEqualsAndHashCode;
            this.payloads.removeFromKeySet = MutableMapIterableTestCase::removeFromKeySet;
            this.payloads.removeNullFromKeySet = MutableMapIterableTestCase::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = MutableMapIterableTestCase::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = MutableMapIterableTestCase::retainAllFromKeySet;
            this.payloads.clearKeySet = MutableMapIterableTestCase::clearKeySet;
            this.payloads.keySetEqualsAndHashCode = MutableMapIterableTestCase::keySetEqualsAndHashCode;
            this.payloads.keySetToArray = MutableMapIterableTestCase::keySetToArray;
            this.payloads.removeFromValues = MutableMapIterableTestCase::removeFromValues;
            this.payloads.removeNullFromValues = MutableMapIterableTestCase::removeNullFromValues;
            this.payloads.removeAllFromValues = MutableMapIterableTestCase::removeAllFromValues;
            this.payloads.retainAllFromValues = MutableMapIterableTestCase::retainAllFromValues;
            this.payloads.put = MutableMapIterableTestCase::put;
            this.payloads.putAll = MutableMapIterableTestCase::putAll;
            this.payloads.removeKey = MutableMapIterableTestCase::removeKey;
            this.payloads.removeAllKeys = MutableMapIterableTestCase::removeAllKeys;
            this.payloads.removeIf = MutableMapIterableTestCase::removeIf;
            this.payloads.getIfAbsentPut = MutableMapIterableTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPutValue = MutableMapIterableTestCase::getIfAbsentPutValue;
            this.payloads.getIfAbsentPutWithKey = MutableMapIterableTestCase::getIfAbsentPutWithKey;
            this.payloads.getIfAbsentPutWith = MutableMapIterableTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPut_block_throws = MutableMapIterableTestCase::getIfAbsentPut_block_throws;
            this.payloads.getIfAbsentPutWith_block_throws = MutableMapIterableTestCase::getIfAbsentPutWith_block_throws;
            this.payloads.getKeysAndGetValues = MutableMapIterableTestCase::getKeysAndGetValues;
            this.payloads.newEmpty = MutableMapIterableTestCase::newEmpty;
            this.payloads.keysAndValues_toString = MutableMapIterableTestCase::keysAndValues_toString;
            this.payloads.keyPreservation = MutableMapIterableTestCase::keyPreservation;
            this.payloads.asUnmodifiable = MutableMapIterableTestCase::asUnmodifiable;
            this.payloads.asSynchronized = MutableMapIterableTestCase::asSynchronized;
            this.payloads.add = MutableMapIterableTestCase::add;
            this.payloads.putPair = MutableMapIterableTestCase::putPair;
            this.payloads.withKeyValue = MutableMapIterableTestCase::withKeyValue;
            this.payloads.withMap = MutableMapIterableTestCase::withMap;
            this.payloads.withMapEmpty = MutableMapIterableTestCase::withMapEmpty;
            this.payloads.withMapTargetEmpty = MutableMapIterableTestCase::withMapTargetEmpty;
            this.payloads.withMapEmptyAndTargetEmpty = MutableMapIterableTestCase::withMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = MutableMapIterableTestCase::withMapNull;
            this.payloads.withMapIterable = MutableMapIterableTestCase::withMapIterable;
            this.payloads.withMapIterableEmpty = MutableMapIterableTestCase::withMapIterableEmpty;
            this.payloads.withMapIterableTargetEmpty = MutableMapIterableTestCase::withMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = MutableMapIterableTestCase::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = MutableMapIterableTestCase::withMapIterableNull;
            this.payloads.putAllMapIterable = MutableMapIterableTestCase::putAllMapIterable;
            this.payloads.putAllMapIterableEmpty = MutableMapIterableTestCase::putAllMapIterableEmpty;
            this.payloads.putAllMapIterableTargetEmpty = MutableMapIterableTestCase::putAllMapIterableTargetEmpty;
            this.payloads.putAllMapIterableEmptyAndTargetEmpty = MutableMapIterableTestCase::putAllMapIterableEmptyAndTargetEmpty;
            this.payloads.putAllMapIterableNull = MutableMapIterableTestCase::putAllMapIterableNull;
            this.payloads.withAllKeyValues = MutableMapIterableTestCase::withAllKeyValues;
            this.payloads.withAllKeyValueArguments = MutableMapIterableTestCase::withAllKeyValueArguments;
            this.payloads.withoutKey = MutableMapIterableTestCase::withoutKey;
            this.payloads.withoutAllKeys = MutableMapIterableTestCase::withoutAllKeys;
            this.payloads.retainAllFromKeySet_null_collision = MutableMapIterableTestCase::retainAllFromKeySet_null_collision;
            this.payloads.rehash_null_collision = MutableMapIterableTestCase::rehash_null_collision;
            this.payloads.updateValue = MutableMapIterableTestCase::updateValue;
            this.payloads.updateValue_collisions = MutableMapIterableTestCase::updateValue_collisions;
            this.payloads.updateValueWith = MutableMapIterableTestCase::updateValueWith;
            this.payloads.updateValueWith_collisions = MutableMapIterableTestCase::updateValueWith_collisions;
        }
    }
}
