/*
 * Copyright (c) 2021 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.collector;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bag.sorted.ImmutableSortedBag;
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.api.bimap.ImmutableBiMap;
import org.eclipse.collections.api.bimap.MutableBiMap;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.collection.primitive.MutableIntCollection;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.ImmutableMap;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.map.primitive.MutableObjectLongMap;
import org.eclipse.collections.api.map.sorted.ImmutableSortedMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.multimap.bag.ImmutableBagMultimap;
import org.eclipse.collections.api.multimap.bag.MutableBagMultimap;
import org.eclipse.collections.api.multimap.list.ImmutableListMultimap;
import org.eclipse.collections.api.multimap.list.MutableListMultimap;
import org.eclipse.collections.api.multimap.set.ImmutableSetMultimap;
import org.eclipse.collections.api.multimap.set.MutableSetMultimap;
import org.eclipse.collections.api.partition.PartitionMutableCollection;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.stack.ImmutableStack;
import org.eclipse.collections.api.stack.MutableStack;
import org.eclipse.collections.impl.factory.BiMaps;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.factory.Multimaps;
import org.eclipse.collections.impl.factory.SortedMaps;
import org.eclipse.collections.impl.factory.Stacks;
import org.eclipse.collections.impl.factory.primitive.IntBags;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.partition.bag.PartitionHashBag;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public final class Collectors2Test {

    public static final Interval SMALL_INTERVAL = Interval.oneTo(5);

    public static final Interval LARGE_INTERVAL = Interval.oneTo(20000);

    public static final Integer HALF_SIZE = Integer.valueOf(LARGE_INTERVAL.size() / 2);

    private final List<Integer> smallData = new ArrayList<>(SMALL_INTERVAL);

    private final List<Integer> bigData = new ArrayList<>(LARGE_INTERVAL);

    @Test
    public void makeString0() {
        Assert.assertEquals(SMALL_INTERVAL.makeString(), this.smallData.stream().collect(Collectors2.makeString()));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.makeString()), this.smallData.stream().collect(Collectors2.makeString()));
        Assert.assertEquals(LARGE_INTERVAL.makeString(), this.bigData.stream().collect(Collectors2.makeString()));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.makeString()), this.bigData.stream().collect(Collectors2.makeString()));
    }

    @Test
    public void makeString0Parallel() {
        Assert.assertEquals(SMALL_INTERVAL.makeString(), this.smallData.parallelStream().collect(Collectors2.makeString()));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.makeString()), this.smallData.parallelStream().collect(Collectors2.makeString()));
        Assert.assertEquals(LARGE_INTERVAL.makeString(), this.bigData.parallelStream().collect(Collectors2.makeString()));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.makeString()), this.bigData.parallelStream().collect(Collectors2.makeString()));
    }

    @Test
    public void makeString1() {
        Assert.assertEquals(SMALL_INTERVAL.makeString("/"), this.smallData.stream().collect(Collectors2.makeString("/")));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.makeString("/")), this.smallData.stream().collect(Collectors2.makeString("/")));
        Assert.assertEquals(LARGE_INTERVAL.makeString("/"), this.bigData.stream().collect(Collectors2.makeString("/")));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.makeString("/")), this.bigData.stream().collect(Collectors2.makeString("/")));
    }

    @Test
    public void makeString1Parallel() {
        Assert.assertEquals(SMALL_INTERVAL.makeString("/"), this.smallData.parallelStream().collect(Collectors2.makeString("/")));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.makeString("/")), this.smallData.parallelStream().collect(Collectors2.makeString("/")));
        Assert.assertEquals(LARGE_INTERVAL.makeString("/"), this.bigData.parallelStream().collect(Collectors2.makeString("/")));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.makeString("/")), this.bigData.parallelStream().collect(Collectors2.makeString("/")));
    }

    @Test
    public void makeString3() {
        Assert.assertEquals(SMALL_INTERVAL.makeString("[", "/", "]"), this.smallData.stream().collect(Collectors2.makeString("[", "/", "]")));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.makeString("[", "/", "]")), this.smallData.stream().collect(Collectors2.makeString("[", "/", "]")));
        Assert.assertEquals(LARGE_INTERVAL.makeString("[", "/", "]"), this.bigData.stream().collect(Collectors2.makeString("[", "/", "]")));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.makeString("[", "/", "]")), this.bigData.stream().collect(Collectors2.makeString("[", "/", "]")));
    }

    @Test
    public void makeString3Parallel() {
        Assert.assertEquals(SMALL_INTERVAL.makeString("[", "/", "]"), this.smallData.parallelStream().collect(Collectors2.makeString("[", "/", "]")));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.makeString("[", "/", "]")), this.smallData.parallelStream().collect(Collectors2.makeString("[", "/", "]")));
        Assert.assertEquals(LARGE_INTERVAL.makeString("[", "/", "]"), this.bigData.parallelStream().collect(Collectors2.makeString("[", "/", "]")));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.makeString("[", "/", "]")), this.bigData.parallelStream().collect(Collectors2.makeString("[", "/", "]")));
    }

    @Test
    public void toList() {
        MutableList<Integer> expected = SMALL_INTERVAL.toList();
        MutableList<Integer> actual = this.smallData.stream().collect(Collectors2.toList());
        Assert.assertEquals(expected, actual);
        MutableList<Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toList());
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toListParallel() {
        MutableList<Integer> expected = LARGE_INTERVAL.toList();
        MutableList<Integer> actual = this.bigData.parallelStream().collect(Collectors2.toList());
        Assert.assertEquals(expected, actual);
        MutableList<Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toList());
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableList() {
        MutableList<Integer> expected = SMALL_INTERVAL.toList();
        ImmutableList<Integer> actual = this.smallData.stream().collect(Collectors2.toImmutableList());
        Assert.assertEquals(expected, actual);
        ImmutableList<Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableList());
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableListParallel() {
        MutableList<Integer> expected = LARGE_INTERVAL.toList();
        ImmutableList<Integer> actual = this.bigData.parallelStream().collect(Collectors2.toImmutableList());
        Assert.assertEquals(expected, actual);
        ImmutableList<Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableList());
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toSet() {
        MutableSet<Integer> expected = SMALL_INTERVAL.toSet();
        MutableSet<Integer> actual = this.smallData.stream().collect(Collectors2.toSet());
        Assert.assertEquals(expected, actual);
        MutableSet<Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toSet());
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toSetParallel() {
        MutableSet<Integer> expected = LARGE_INTERVAL.toSet();
        MutableSet<Integer> actual = this.bigData.parallelStream().collect(Collectors2.toSet());
        Assert.assertEquals(expected, actual);
        MutableSet<Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toSet());
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableSet() {
        MutableSet<Integer> expected = SMALL_INTERVAL.toSet();
        ImmutableSet<Integer> actual = this.smallData.stream().collect(Collectors2.toImmutableSet());
        Assert.assertEquals(expected, actual);
        ImmutableSet<Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableSet());
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableSetParallel() {
        MutableSet<Integer> expected = LARGE_INTERVAL.toSet();
        ImmutableSet<Integer> actual = this.bigData.parallelStream().collect(Collectors2.toImmutableSet());
        Assert.assertEquals(expected, actual);
        ImmutableSet<Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableSet());
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toBag() {
        MutableBag<Integer> expected = SMALL_INTERVAL.toBag();
        MutableBag<Integer> actual = this.smallData.stream().collect(Collectors2.toBag());
        Assert.assertEquals(expected, actual);
        MutableBag<Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toBag());
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toBagParallel() {
        MutableBag<Integer> expected = LARGE_INTERVAL.toBag();
        MutableBag<Integer> actual = this.bigData.parallelStream().collect(Collectors2.toBag());
        Assert.assertEquals(expected, actual);
        MutableBag<Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toBag());
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableBag() {
        MutableBag<Integer> expected = SMALL_INTERVAL.toBag();
        ImmutableBag<Integer> actual = this.smallData.stream().collect(Collectors2.toImmutableBag());
        Assert.assertEquals(expected, actual);
        ImmutableBag<Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableBag());
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableBagParallel() {
        MutableBag<Integer> expected = LARGE_INTERVAL.toBag();
        ImmutableBag<Integer> actual = this.bigData.parallelStream().collect(Collectors2.toImmutableBag());
        Assert.assertEquals(expected, actual);
        ImmutableBag<Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableBag());
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toListMultimap() {
        Multimap<String, Integer> expected = SMALL_INTERVAL.groupBy(Object::toString);
        MutableListMultimap<String, Integer> actual = this.smallData.stream().collect(Collectors2.toListMultimap(Object::toString));
        Assert.assertEquals(expected, actual);
        MutableListMultimap<String, Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toListMultimap(Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toListMultimapParallel() {
        Multimap<String, Integer> expected = LARGE_INTERVAL.groupBy(Object::toString);
        MutableListMultimap<String, Integer> actual = this.bigData.parallelStream().collect(Collectors2.toListMultimap(Object::toString));
        Assert.assertEquals(expected, actual);
        MutableListMultimap<String, Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toListMultimap(Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toListMultimap2() {
        Multimap<String, String> expected = SMALL_INTERVAL.collect(Object::toString).groupBy(Object::toString);
        MutableListMultimap<String, String> actual = this.smallData.stream().collect(Collectors2.toListMultimap(Object::toString, Object::toString));
        Assert.assertEquals(expected, actual);
        MutableListMultimap<String, String> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toListMultimap(Object::toString, Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toListMultimap2Parallel() {
        Multimap<String, String> expected = LARGE_INTERVAL.collect(Object::toString).groupBy(Object::toString);
        MutableListMultimap<String, String> actual = this.bigData.parallelStream().collect(Collectors2.toListMultimap(Object::toString, Object::toString));
        Assert.assertEquals(expected, actual);
        MutableListMultimap<String, String> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toListMultimap(Object::toString, Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toSetMultimap() {
        MutableSetMultimap<String, Integer> expected = SMALL_INTERVAL.toSet().groupBy(Object::toString);
        MutableSetMultimap<String, Integer> actual = this.smallData.stream().collect(Collectors2.toSetMultimap(Object::toString));
        Assert.assertEquals(expected, actual);
        MutableSetMultimap<String, Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toSetMultimap(Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toSetMultimapParallel() {
        MutableSetMultimap<String, Integer> expected = LARGE_INTERVAL.toSet().groupBy(Object::toString);
        MutableSetMultimap<String, Integer> actual = this.bigData.parallelStream().collect(Collectors2.toSetMultimap(Object::toString));
        Assert.assertEquals(expected, actual);
        MutableSetMultimap<String, Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toSetMultimap(Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toSetMultimap2() {
        MutableSetMultimap<String, String> expected = SMALL_INTERVAL.toSet().collect(Object::toString).groupBy(Object::toString);
        MutableSetMultimap<String, String> actual = this.smallData.stream().collect(Collectors2.toSetMultimap(Object::toString, Object::toString));
        Assert.assertEquals(expected, actual);
        MutableSetMultimap<String, String> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toSetMultimap(Object::toString, Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toSetMultimap2Parallel() {
        MutableSetMultimap<String, String> expected = LARGE_INTERVAL.toSet().collect(Object::toString).groupBy(Object::toString);
        MutableSetMultimap<String, String> actual = this.bigData.parallelStream().collect(Collectors2.toSetMultimap(Object::toString, Object::toString));
        Assert.assertEquals(expected, actual);
        MutableSetMultimap<String, String> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toSetMultimap(Object::toString, Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toBagMultimap() {
        MutableBagMultimap<String, Integer> expected = SMALL_INTERVAL.toBag().groupBy(Object::toString);
        MutableBagMultimap<String, Integer> actual = this.smallData.stream().collect(Collectors2.toBagMultimap(Object::toString));
        Assert.assertEquals(expected, actual);
        MutableBagMultimap<String, Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toBagMultimap(Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toBagMultimapParallel() {
        MutableBagMultimap<String, Integer> expected = LARGE_INTERVAL.toBag().groupBy(Object::toString);
        MutableBagMultimap<String, Integer> actual = this.bigData.parallelStream().collect(Collectors2.toBagMultimap(Object::toString));
        Assert.assertEquals(expected, actual);
        MutableBagMultimap<String, Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toBagMultimap(Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toBagMultimap2() {
        MutableBagMultimap<String, String> expected = SMALL_INTERVAL.toBag().collect(Object::toString).groupBy(Object::toString);
        MutableBagMultimap<String, String> actual = this.smallData.stream().collect(Collectors2.toBagMultimap(Object::toString, Object::toString));
        Assert.assertEquals(expected, actual);
        MutableBagMultimap<String, String> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toBagMultimap(Object::toString, Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toBagMultimap2Parallel() {
        MutableBagMultimap<String, String> expected = LARGE_INTERVAL.toBag().collect(Object::toString).groupBy(Object::toString);
        MutableBagMultimap<String, String> actual = this.bigData.parallelStream().collect(Collectors2.toBagMultimap(Object::toString, Object::toString));
        Assert.assertEquals(expected, actual);
        MutableBagMultimap<String, String> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toBagMultimap(Object::toString, Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void groupingByToBagMultimap() {
        Map<Integer, MutableBagMultimap<Integer, Integer>> expected = Interval.oneTo(100).stream().collect(Collectors.groupingBy(each -> each % 2, Collectors2.toBagMultimap(each -> each % 5)));
        Map<Integer, MutableBagMultimap<Integer, Integer>> actual = Interval.oneTo(100).reduceInPlace(Collectors.groupingBy(each -> each % 2, Collectors2.toBagMultimap(each -> each % 5)));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void groupingByPartition() {
        Map<Integer, PartitionMutableCollection<Integer>> expected = Interval.oneTo(100).stream().collect(Collectors.groupingBy(each -> each % 2, Collectors2.partition(each -> each % 5 == 0, PartitionHashBag::new)));
        Map<Integer, PartitionMutableCollection<Integer>> actual = Interval.oneTo(100).reduceInPlace(Collectors.groupingBy(each -> each % 2, Collectors2.partition(each -> each % 5 == 0, PartitionHashBag::new)));
        Assert.assertEquals(expected.get(0).getSelected(), actual.get(0).getSelected());
        Assert.assertEquals(expected.get(0).getRejected(), actual.get(0).getRejected());
    }

    @Test
    public void groupingByChunk() {
        Map<Integer, MutableList<MutableList<Integer>>> expected = Interval.oneTo(100).stream().collect(Collectors.groupingBy(each -> each % 2, Collectors2.chunk(10)));
        Map<Integer, MutableList<MutableList<Integer>>> actual = Interval.oneTo(100).reduceInPlace(Collectors.groupingBy(each -> each % 2, Collectors2.chunk(10)));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void groupingByCollectInt() {
        Map<Integer, MutableIntCollection> expected = Interval.oneTo(100).stream().collect(Collectors.groupingBy(each -> each % 2, Collectors2.collectInt(Integer::intValue, IntBags.mutable::empty)));
        Map<Integer, MutableIntCollection> actual = Interval.oneTo(100).reduceInPlace(Collectors.groupingBy(each -> each % 2, Collectors2.collectInt(Integer::intValue, IntBags.mutable::empty)));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void groupingBySumByInt() {
        Map<Integer, MutableObjectLongMap<Integer>> expected = Interval.oneTo(100).stream().collect(Collectors.groupingBy(each -> each % 2, Collectors2.sumByInt(each -> each % 5, Integer::intValue)));
        Map<Integer, MutableObjectLongMap<Integer>> actual = Interval.oneTo(100).reduceInPlace(Collectors.groupingBy(each -> each % 2, Collectors2.sumByInt(each -> each % 5, Integer::intValue)));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStack() {
        MutableStack<Integer> expected = Stacks.mutable.ofAll(SMALL_INTERVAL);
        MutableStack<Integer> actual = this.smallData.stream().collect(Collectors2.toStack());
        Assert.assertEquals(expected, actual);
        MutableStack<Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toStack());
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toStackParallel() {
        MutableStack<Integer> expected = Stacks.mutable.ofAll(LARGE_INTERVAL);
        MutableStack<Integer> actual = this.bigData.parallelStream().collect(Collectors2.toStack());
        Assert.assertEquals(expected, actual);
        MutableStack<Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toStack());
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableStack() {
        MutableStack<Integer> expected = Stacks.mutable.ofAll(SMALL_INTERVAL);
        ImmutableStack<Integer> actual = this.smallData.stream().collect(Collectors2.toImmutableStack());
        Assert.assertEquals(expected, actual);
        ImmutableStack<Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableStack());
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableStackParallel() {
        MutableStack<Integer> expected = Stacks.mutable.ofAll(LARGE_INTERVAL);
        ImmutableStack<Integer> actual = this.bigData.parallelStream().collect(Collectors2.toImmutableStack());
        Assert.assertEquals(expected, actual);
        ImmutableStack<Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableStack());
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toMap() {
        MutableMap<String, Integer> expected = SMALL_INTERVAL.toMap(Object::toString, i -> i);
        MutableMap<String, Integer> actual = this.smallData.stream().collect(Collectors2.toMap(Object::toString, i -> i));
        Assert.assertEquals(expected, actual);
        MutableMap<String, Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toMap(Object::toString, i -> i));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toMapParallel() {
        MutableMap<String, Integer> expected = LARGE_INTERVAL.toMap(Object::toString, i -> i);
        MutableMap<String, Integer> actual = this.bigData.parallelStream().collect(Collectors2.toMap(Object::toString, i -> i));
        Assert.assertEquals(expected, actual);
        MutableMap<String, Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toMap(Object::toString, i -> i));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableMap() {
        MutableMap<String, Integer> expected = SMALL_INTERVAL.toMap(Object::toString, i -> i);
        ImmutableMap<String, Integer> actual = this.smallData.stream().collect(Collectors2.toImmutableMap(Object::toString, i -> i));
        Assert.assertEquals(expected, actual);
        ImmutableMap<String, Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableMap(Object::toString, i -> i));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableMapParallel() {
        MutableMap<String, Integer> expected = LARGE_INTERVAL.toMap(Object::toString, i -> i);
        ImmutableMap<String, Integer> actual = this.bigData.parallelStream().collect(Collectors2.toImmutableMap(Object::toString, i -> i));
        Assert.assertEquals(expected, actual);
        ImmutableMap<String, Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableMap(Object::toString, i -> i));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toBiMap() {
        MutableBiMap<Object, Object> expected = SMALL_INTERVAL.injectInto(BiMaps.mutable.empty(), (mbm, e) -> {
            mbm.put(e.toString(), e);
            return mbm;
        });
        MutableBiMap<String, Integer> actual = this.smallData.stream().collect(Collectors2.toBiMap(Object::toString, i -> i));
        Assert.assertEquals(expected, actual);
        MutableBiMap<String, Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toBiMap(Object::toString, i -> i));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toBiMapParallel() {
        MutableBiMap<Object, Object> expected = LARGE_INTERVAL.injectInto(BiMaps.mutable.empty(), (mbm, e) -> {
            mbm.put(e.toString(), e);
            return mbm;
        });
        MutableBiMap<String, Integer> actual = this.bigData.parallelStream().collect(Collectors2.toBiMap(Object::toString, i -> i));
        Assert.assertEquals(expected, actual);
        MutableBiMap<String, Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toBiMap(Object::toString, i -> i));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableBiMap() {
        MutableBiMap<Object, Object> expected = SMALL_INTERVAL.injectInto(BiMaps.mutable.empty(), (mbm, e) -> {
            mbm.put(e.toString(), e);
            return mbm;
        });
        ImmutableBiMap<String, Integer> actual = this.smallData.stream().collect(Collectors2.toImmutableBiMap(Object::toString, i -> i));
        Assert.assertEquals(expected, actual);
        ImmutableBiMap<String, Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableBiMap(Object::toString, i -> i));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableBiMapParallel() {
        MutableBiMap<Object, Object> expected = LARGE_INTERVAL.injectInto(BiMaps.mutable.empty(), (mbm, e) -> {
            mbm.put(e.toString(), e);
            return mbm;
        });
        ImmutableBiMap<String, Integer> actual = this.bigData.parallelStream().collect(Collectors2.toImmutableBiMap(Object::toString, i -> i));
        Assert.assertEquals(expected, actual);
        ImmutableBiMap<String, Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableBiMap(Object::toString, i -> i));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toSortedSet() {
        MutableSortedSet<Integer> expected = SMALL_INTERVAL.toSortedSet();
        MutableSortedSet<Integer> actual = this.smallData.stream().collect(Collectors2.toSortedSet());
        Assert.assertEquals(expected, actual);
        MutableSortedSet<Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toSortedSet());
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toSortedSetParallel() {
        MutableSortedSet<Integer> expected = LARGE_INTERVAL.toSortedSet();
        MutableSortedSet<Integer> actual = this.bigData.parallelStream().collect(Collectors2.toSortedSet());
        Assert.assertEquals(expected, actual);
        MutableSortedSet<Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toSortedSet());
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toSortedSetBy() {
        MutableSortedSet<Integer> expected = SMALL_INTERVAL.toSortedSetBy(Object::toString);
        MutableSortedSet<Integer> actual = this.smallData.stream().collect(Collectors2.toSortedSetBy(Object::toString));
        Assert.assertEquals(expected, actual);
        MutableSortedSet<Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toSortedSetBy(Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toSortedSetByParallel() {
        MutableSortedSet<Integer> expected = LARGE_INTERVAL.toSortedSetBy(Object::toString);
        MutableSortedSet<Integer> actual = this.bigData.parallelStream().collect(Collectors2.toSortedSetBy(Object::toString));
        Assert.assertEquals(expected, actual);
        MutableSortedSet<Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toSortedSetBy(Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableSortedSet() {
        MutableSortedSet<Integer> expected = SMALL_INTERVAL.toSortedSet();
        ImmutableSortedSet<Integer> actual = this.smallData.stream().collect(Collectors2.toImmutableSortedSet());
        Assert.assertEquals(expected, actual);
        ImmutableSortedSet<Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedSet());
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableSortedSetParallel() {
        MutableSortedSet<Integer> expected = LARGE_INTERVAL.toSortedSet();
        ImmutableSortedSet<Integer> actual = this.bigData.parallelStream().collect(Collectors2.toImmutableSortedSet());
        Assert.assertEquals(expected, actual);
        ImmutableSortedSet<Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedSet());
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableSortedSetBy() {
        MutableSortedSet<Integer> expected = SMALL_INTERVAL.toSortedSetBy(Object::toString);
        ImmutableSortedSet<Integer> actual = this.smallData.stream().collect(Collectors2.toImmutableSortedSetBy(Object::toString));
        Assert.assertEquals(expected, actual);
        ImmutableSortedSet<Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedSetBy(Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableSortedSetByParallel() {
        MutableSortedSet<Integer> expected = LARGE_INTERVAL.toSortedSetBy(Object::toString);
        ImmutableSortedSet<Integer> actual = this.bigData.parallelStream().collect(Collectors2.toImmutableSortedSetBy(Object::toString));
        Assert.assertEquals(expected, actual);
        ImmutableSortedSet<Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedSetBy(Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toSortedBag() {
        MutableSortedBag<Integer> expected = SMALL_INTERVAL.toSortedBag();
        MutableSortedBag<Integer> actual = this.smallData.stream().collect(Collectors2.toSortedBag());
        Assert.assertEquals(expected, actual);
        MutableSortedBag<Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toSortedBag());
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toSortedBagParallel() {
        MutableSortedBag<Integer> expected = LARGE_INTERVAL.toSortedBag();
        MutableSortedBag<Integer> actual = this.bigData.parallelStream().collect(Collectors2.toSortedBag());
        Assert.assertEquals(expected, actual);
        MutableSortedBag<Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toSortedBag());
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toSortedBagBy() {
        MutableSortedBag<Integer> expected = SMALL_INTERVAL.toSortedBagBy(Object::toString);
        MutableSortedBag<Integer> actual = this.smallData.stream().collect(Collectors2.toSortedBagBy(Object::toString));
        Assert.assertEquals(expected, actual);
        MutableSortedBag<Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toSortedBagBy(Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toSortedBagByParallel() {
        MutableSortedBag<Integer> expected = LARGE_INTERVAL.toSortedBagBy(Object::toString);
        MutableSortedBag<Integer> actual = this.bigData.parallelStream().collect(Collectors2.toSortedBagBy(Object::toString));
        Assert.assertEquals(expected, actual);
        MutableSortedBag<Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toSortedBagBy(Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableSortedBag() {
        MutableSortedBag<Integer> expected = SMALL_INTERVAL.toSortedBag();
        ImmutableSortedBag<Integer> actual = this.smallData.stream().collect(Collectors2.toImmutableSortedBag());
        Assert.assertEquals(expected, actual);
        ImmutableSortedBag<Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedBag());
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableSortedBagParallel() {
        MutableSortedBag<Integer> expected = LARGE_INTERVAL.toSortedBag();
        ImmutableSortedBag<Integer> actual = this.bigData.parallelStream().collect(Collectors2.toImmutableSortedBag());
        Assert.assertEquals(expected, actual);
        ImmutableSortedBag<Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedBag());
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableSortedBagBy() {
        MutableSortedBag<Integer> expected = SMALL_INTERVAL.toSortedBagBy(Object::toString);
        ImmutableSortedBag<Integer> actual = this.smallData.stream().collect(Collectors2.toImmutableSortedBagBy(Object::toString));
        Assert.assertEquals(expected, actual);
        ImmutableSortedBag<Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedBagBy(Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableSortedBagByParallel() {
        MutableSortedBag<Integer> expected = LARGE_INTERVAL.toSortedBagBy(Object::toString);
        ImmutableSortedBag<Integer> actual = this.bigData.parallelStream().collect(Collectors2.toImmutableSortedBagBy(Object::toString));
        Assert.assertEquals(expected, actual);
        ImmutableSortedBag<Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedBagBy(Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toSortedSetWithComparator() {
        MutableSortedSet<Integer> expected = SMALL_INTERVAL.toSortedSet(Comparator.reverseOrder());
        MutableSortedSet<Integer> actual = this.smallData.stream().collect(Collectors2.toSortedSet(Comparator.reverseOrder()));
        Assert.assertEquals(expected, actual);
        MutableSortedSet<Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toSortedSet(Comparator.reverseOrder()));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toSortedSetParallelWithComparator() {
        MutableSortedSet<Integer> expected = LARGE_INTERVAL.toSortedSet(Comparator.reverseOrder());
        MutableSortedSet<Integer> actual = this.bigData.parallelStream().collect(Collectors2.toSortedSet(Comparator.reverseOrder()));
        Assert.assertEquals(expected, actual);
        MutableSortedSet<Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toSortedSet(Comparator.reverseOrder()));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableSortedSetWithComparator() {
        MutableSortedSet<Integer> expected = SMALL_INTERVAL.toSortedSet(Comparator.reverseOrder());
        ImmutableSortedSet<Integer> actual = this.smallData.stream().collect(Collectors2.toImmutableSortedSet(Comparator.reverseOrder()));
        Assert.assertEquals(expected, actual);
        ImmutableSortedSet<Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedSet(Comparator.reverseOrder()));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableSortedSetParallelWithComparator() {
        MutableSortedSet<Integer> expected = LARGE_INTERVAL.toSortedSet(Comparator.reverseOrder());
        ImmutableSortedSet<Integer> actual = this.bigData.parallelStream().collect(Collectors2.toImmutableSortedSet(Comparator.reverseOrder()));
        Assert.assertEquals(expected, actual);
        ImmutableSortedSet<Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedSet(Comparator.reverseOrder()));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toSortedBagWithComparator() {
        MutableSortedBag<Integer> expected = SMALL_INTERVAL.toSortedBag(Comparator.reverseOrder());
        MutableSortedBag<Integer> actual = this.smallData.stream().collect(Collectors2.toSortedBag(Comparator.reverseOrder()));
        Assert.assertEquals(expected, actual);
        MutableSortedBag<Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toSortedBag(Comparator.reverseOrder()));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toSortedBagParallelWithComparator() {
        MutableSortedBag<Integer> expected = LARGE_INTERVAL.toSortedBag(Comparator.reverseOrder());
        MutableSortedBag<Integer> actual = this.bigData.parallelStream().collect(Collectors2.toSortedBag(Comparator.reverseOrder()));
        Assert.assertEquals(expected, actual);
        MutableSortedBag<Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toSortedBag(Comparator.reverseOrder()));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableSortedBagWithComparator() {
        MutableSortedBag<Integer> expected = SMALL_INTERVAL.toSortedBag(Comparator.reverseOrder());
        ImmutableSortedBag<Integer> actual = this.smallData.stream().collect(Collectors2.toImmutableSortedBag(Comparator.reverseOrder()));
        Assert.assertEquals(expected, actual);
        ImmutableSortedBag<Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedBag(Comparator.reverseOrder()));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableSortedBagParallelWithComparator() {
        MutableSortedBag<Integer> expected = LARGE_INTERVAL.toSortedBag(Comparator.reverseOrder());
        ImmutableSortedBag<Integer> actual = this.bigData.parallelStream().collect(Collectors2.toImmutableSortedBag(Comparator.reverseOrder()));
        Assert.assertEquals(expected, actual);
        ImmutableSortedBag<Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedBag(Comparator.reverseOrder()));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toSortedList() {
        MutableList<Integer> expected = SMALL_INTERVAL.toSortedList();
        MutableList<Integer> actual = this.smallData.stream().collect(Collectors2.toSortedList());
        Assert.assertEquals(expected, actual);
        MutableList<Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toSortedList());
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toSortedListParallel() {
        MutableList<Integer> expected = LARGE_INTERVAL.toSortedList();
        MutableList<Integer> actual = this.bigData.parallelStream().collect(Collectors2.toSortedList());
        Assert.assertEquals(expected, actual);
        MutableList<Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toSortedList());
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toSortedListBy() {
        MutableList<Integer> expected = SMALL_INTERVAL.toSortedListBy(Object::toString);
        MutableList<Integer> actual = this.smallData.stream().collect(Collectors2.toSortedListBy(Object::toString));
        Assert.assertEquals(expected, actual);
        MutableList<Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toSortedListBy(Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toSortedListByParallel() {
        MutableList<Integer> expected = LARGE_INTERVAL.toSortedListBy(Object::toString);
        MutableList<Integer> actual = this.bigData.parallelStream().collect(Collectors2.toSortedListBy(Object::toString));
        Assert.assertEquals(expected, actual);
        MutableList<Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toSortedListBy(Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableSortedList() {
        MutableList<Integer> expected = SMALL_INTERVAL.toSortedList();
        ImmutableList<Integer> actual = this.smallData.stream().collect(Collectors2.toImmutableSortedList());
        Assert.assertEquals(expected, actual);
        ImmutableList<Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedList());
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableSortedListParallel() {
        MutableList<Integer> expected = LARGE_INTERVAL.toSortedList();
        ImmutableList<Integer> actual = this.bigData.parallelStream().collect(Collectors2.toImmutableSortedList());
        Assert.assertEquals(expected, actual);
        ImmutableList<Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedList());
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableSortedListBy() {
        MutableList<Integer> expected = SMALL_INTERVAL.toSortedListBy(Object::toString);
        ImmutableList<Integer> actual = this.smallData.stream().collect(Collectors2.toImmutableSortedListBy(Object::toString));
        Assert.assertEquals(expected, actual);
        ImmutableList<Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedListBy(Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableSortedListByParallel() {
        MutableList<Integer> expected = LARGE_INTERVAL.toSortedListBy(Object::toString);
        ImmutableList<Integer> actual = this.bigData.parallelStream().collect(Collectors2.toImmutableSortedListBy(Object::toString));
        Assert.assertEquals(expected, actual);
        ImmutableList<Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedListBy(Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toSortedListWithComparator() {
        MutableList<Integer> expected = SMALL_INTERVAL.toSortedList(Comparator.reverseOrder());
        MutableList<Integer> actual = this.smallData.stream().collect(Collectors2.toSortedList(Comparator.reverseOrder()));
        Assert.assertEquals(expected, actual);
        MutableList<Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toSortedList(Comparator.reverseOrder()));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toSortedListParallelWithComparator() {
        MutableList<Integer> expected = LARGE_INTERVAL.toSortedList(Comparator.reverseOrder());
        MutableList<Integer> actual = this.bigData.parallelStream().collect(Collectors2.toSortedList(Comparator.reverseOrder()));
        Assert.assertEquals(expected, actual);
        MutableList<Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toSortedList(Comparator.reverseOrder()));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toSortedMap() {
        MutableSortedMap<String, Integer> expected = SMALL_INTERVAL.toSortedMap(Object::toString, i -> i);
        MutableSortedMap<String, Integer> actual = this.smallData.stream().collect(Collectors2.toSortedMap(Object::toString, i -> i));
        Assert.assertEquals(expected, actual);
        MutableSortedMap<String, Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toSortedMap(Object::toString, i -> i));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toSortedMapParallel() {
        MutableSortedMap<String, Integer> expected = LARGE_INTERVAL.toSortedMap(Object::toString, i -> i);
        MutableSortedMap<String, Integer> actual = this.bigData.parallelStream().collect(Collectors2.toSortedMap(Object::toString, i -> i));
        Assert.assertEquals(expected, actual);
        MutableSortedMap<String, Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toSortedMap(Object::toString, i -> i));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toSortedMapWithComparator() {
        MutableSortedMap<String, Integer> expected = SMALL_INTERVAL.toSortedMap(Comparator.reverseOrder(), Object::toString, i -> i);
        MutableSortedMap<String, Integer> actual = this.smallData.stream().collect(Collectors2.toSortedMap(Comparator.reverseOrder(), Object::toString, i -> i));
        Assert.assertEquals(expected, actual);
        MutableSortedMap<String, Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toSortedMap(Comparator.reverseOrder(), Object::toString, i -> i));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toSortedMapParallelWithComparator() {
        MutableSortedMap<String, Integer> expected = LARGE_INTERVAL.toSortedMap(Comparator.reverseOrder(), Object::toString, i -> i);
        MutableSortedMap<String, Integer> actual = this.bigData.parallelStream().collect(Collectors2.toSortedMap(Comparator.reverseOrder(), Object::toString, i -> i));
        Assert.assertEquals(expected, actual);
        MutableSortedMap<String, Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toSortedMap(Comparator.reverseOrder(), Object::toString, i -> i));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toSortedMapBy() {
        MutableSortedMap<String, Integer> expected = SMALL_INTERVAL.toSortedMapBy(Object::toString, Object::toString, i -> i);
        MutableSortedMap<String, Integer> actual = this.smallData.stream().collect(Collectors2.toSortedMapBy(Object::toString, Object::toString, i -> i));
        Assert.assertEquals(expected, actual);
        MutableSortedMap<String, Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toSortedMapBy(Object::toString, Object::toString, i -> i));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toSortedMapByParallel() {
        MutableSortedMap<String, Integer> expected = LARGE_INTERVAL.toSortedMapBy(Object::toString, Object::toString, i -> i);
        MutableSortedMap<String, Integer> actual = this.bigData.parallelStream().collect(Collectors2.toSortedMapBy(Object::toString, Object::toString, i -> i));
        Assert.assertEquals(expected, actual);
        MutableSortedMap<String, Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toSortedMapBy(Object::toString, Object::toString, i -> i));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableSortedMap() {
        ImmutableSortedMap<String, Integer> expected = SMALL_INTERVAL.toSortedMap(Object::toString, i -> i).toImmutable();
        ImmutableSortedMap<String, Integer> actual = this.smallData.stream().collect(Collectors2.toImmutableSortedMap(Object::toString, i -> i));
        Assert.assertEquals(expected, actual);
        ImmutableSortedMap<String, Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedMap(Object::toString, i -> i));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableSortedMapParallel() {
        ImmutableSortedMap<String, Integer> expected = LARGE_INTERVAL.toSortedMap(Object::toString, i -> i).toImmutable();
        ImmutableSortedMap<String, Integer> actual = this.bigData.parallelStream().collect(Collectors2.toImmutableSortedMap(Object::toString, i -> i));
        Assert.assertEquals(expected, actual);
        ImmutableSortedMap<String, Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedMap(Object::toString, i -> i));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableSortedMapWithComparator() {
        ImmutableSortedMap<String, Integer> expected = SMALL_INTERVAL.toSortedMap(Comparator.reverseOrder(), Object::toString, i -> i).toImmutable();
        ImmutableSortedMap<String, Integer> actual = this.smallData.stream().collect(Collectors2.toImmutableSortedMap(Comparator.reverseOrder(), Object::toString, i -> i));
        Assert.assertEquals(expected, actual);
        ImmutableSortedMap<String, Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedMap(Comparator.reverseOrder(), Object::toString, i -> i));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableSortedMapParallelWithComparator() {
        ImmutableSortedMap<String, Integer> expected = LARGE_INTERVAL.toSortedMap(Comparator.reverseOrder(), Object::toString, i -> i).toImmutable();
        ImmutableSortedMap<String, Integer> actual = this.bigData.parallelStream().collect(Collectors2.toImmutableSortedMap(Comparator.reverseOrder(), Object::toString, i -> i));
        Assert.assertEquals(expected, actual);
        ImmutableSortedMap<String, Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedMap(Comparator.reverseOrder(), Object::toString, i -> i));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableSortedMapBy() {
        ImmutableSortedMap<String, Integer> expected = SMALL_INTERVAL.toSortedMapBy(Object::toString, Object::toString, i -> i).toImmutable();
        ImmutableSortedMap<String, Integer> actual = this.smallData.stream().collect(Collectors2.toImmutableSortedMapBy(Object::toString, Object::toString, i -> i));
        Assert.assertEquals(expected, actual);
        ImmutableSortedMap<String, Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedMapBy(Object::toString, Object::toString, i -> i));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableSortedMapByParallel() {
        ImmutableSortedMap<String, Integer> expected = LARGE_INTERVAL.toSortedMapBy(Object::toString, Object::toString, i -> i).toImmutable();
        ImmutableSortedMap<String, Integer> actual = this.bigData.parallelStream().collect(Collectors2.toImmutableSortedMapBy(Object::toString, Object::toString, i -> i));
        Assert.assertEquals(expected, actual);
        ImmutableSortedMap<String, Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedMapBy(Object::toString, Object::toString, i -> i));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableSortedListWithComparator() {
        MutableList<Integer> expected = SMALL_INTERVAL.toSortedList(Comparator.reverseOrder());
        ImmutableList<Integer> actual = this.smallData.stream().collect(Collectors2.toImmutableSortedList(Comparator.reverseOrder()));
        Assert.assertEquals(expected, actual);
        ImmutableList<Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedList(Comparator.reverseOrder()));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableSortedListParallelWithComparator() {
        MutableList<Integer> expected = LARGE_INTERVAL.toSortedList(Comparator.reverseOrder());
        ImmutableList<Integer> actual = this.bigData.parallelStream().collect(Collectors2.toImmutableSortedList(Comparator.reverseOrder()));
        Assert.assertEquals(expected, actual);
        ImmutableList<Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedList(Comparator.reverseOrder()));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableListMultimap() {
        Multimap<String, Integer> expected = SMALL_INTERVAL.groupBy(Object::toString);
        ImmutableListMultimap<String, Integer> actual = this.smallData.stream().collect(Collectors2.toImmutableListMultimap(Object::toString));
        Assert.assertEquals(expected, actual);
        ImmutableListMultimap<String, Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableListMultimap(Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableListMultimapParallel() {
        Multimap<String, Integer> expected = LARGE_INTERVAL.groupBy(Object::toString);
        ImmutableListMultimap<String, Integer> actual = this.bigData.parallelStream().collect(Collectors2.toImmutableListMultimap(Object::toString));
        Assert.assertEquals(expected, actual);
        ImmutableListMultimap<String, Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableListMultimap(Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableListMultimap2() {
        Multimap<String, String> expected = SMALL_INTERVAL.collect(Object::toString).groupBy(Object::toString);
        ImmutableListMultimap<String, String> actual = this.smallData.stream().collect(Collectors2.toImmutableListMultimap(Object::toString, Object::toString));
        Assert.assertEquals(expected, actual);
        ImmutableListMultimap<String, String> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableListMultimap(Object::toString, Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableListMultimap2Parallel() {
        Multimap<String, String> expected = LARGE_INTERVAL.collect(Object::toString).groupBy(Object::toString);
        ImmutableListMultimap<String, String> actual = this.bigData.parallelStream().collect(Collectors2.toImmutableListMultimap(Object::toString, Object::toString));
        Assert.assertEquals(expected, actual);
        ImmutableListMultimap<String, String> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableListMultimap(Object::toString, Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableSetMultimap() {
        MutableSetMultimap<String, Integer> expected = SMALL_INTERVAL.toSet().groupBy(Object::toString);
        ImmutableSetMultimap<String, Integer> actual = this.smallData.stream().collect(Collectors2.toImmutableSetMultimap(Object::toString));
        Assert.assertEquals(expected, actual);
        ImmutableSetMultimap<String, Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableSetMultimap(Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableSetMultimapParallel() {
        MutableSetMultimap<String, Integer> expected = LARGE_INTERVAL.toSet().groupBy(Object::toString);
        ImmutableSetMultimap<String, Integer> actual = this.bigData.parallelStream().collect(Collectors2.toImmutableSetMultimap(Object::toString));
        Assert.assertEquals(expected, actual);
        ImmutableSetMultimap<String, Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableSetMultimap(Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableSetMultimap2() {
        MutableSetMultimap<String, String> expected = SMALL_INTERVAL.toSet().collect(Object::toString).groupBy(Object::toString);
        ImmutableSetMultimap<String, String> actual = this.smallData.stream().collect(Collectors2.toImmutableSetMultimap(Object::toString, Object::toString));
        Assert.assertEquals(expected, actual);
        ImmutableSetMultimap<String, String> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableSetMultimap(Object::toString, Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableSetMultimap2Parallel() {
        MutableSetMultimap<String, String> expected = LARGE_INTERVAL.toSet().collect(Object::toString).groupBy(Object::toString);
        ImmutableSetMultimap<String, String> actual = this.bigData.parallelStream().collect(Collectors2.toImmutableSetMultimap(Object::toString, Object::toString));
        Assert.assertEquals(expected, actual);
        ImmutableSetMultimap<String, String> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableSetMultimap(Object::toString, Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableBagMultimap() {
        MutableBagMultimap<String, Integer> expected = SMALL_INTERVAL.toBag().groupBy(Object::toString);
        ImmutableBagMultimap<String, Integer> actual = this.smallData.stream().collect(Collectors2.toImmutableBagMultimap(Object::toString));
        Assert.assertEquals(expected, actual);
        ImmutableBagMultimap<String, Integer> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableBagMultimap(Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableBagMultimapParallel() {
        MutableBagMultimap<String, Integer> expected = LARGE_INTERVAL.toBag().groupBy(Object::toString);
        ImmutableBagMultimap<String, Integer> actual = this.bigData.parallelStream().collect(Collectors2.toImmutableBagMultimap(Object::toString));
        Assert.assertEquals(expected, actual);
        ImmutableBagMultimap<String, Integer> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableBagMultimap(Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableBagMultimap2() {
        MutableBagMultimap<String, String> expected = SMALL_INTERVAL.toBag().collect(Object::toString).groupBy(Object::toString);
        ImmutableBagMultimap<String, String> actual = this.smallData.stream().collect(Collectors2.toImmutableBagMultimap(Object::toString, Object::toString));
        Assert.assertEquals(expected, actual);
        ImmutableBagMultimap<String, String> actual2 = SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableBagMultimap(Object::toString, Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void toImmutableBagMultimap2Parallel() {
        MutableBagMultimap<String, String> expected = LARGE_INTERVAL.toBag().collect(Object::toString).groupBy(Object::toString);
        ImmutableBagMultimap<String, String> actual = this.bigData.parallelStream().collect(Collectors2.toImmutableBagMultimap(Object::toString, Object::toString));
        Assert.assertEquals(expected, actual);
        ImmutableBagMultimap<String, String> actual2 = LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableBagMultimap(Object::toString, Object::toString));
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void countBy() {
        Interval integers = Interval.oneTo(100);
        MutableBag<Integer> counts = integers.stream().collect(Collectors2.countBy(i -> i % 2));
        Assert.assertEquals(integers.countBy(i -> i % 2), counts);
        Assert.assertEquals(50, counts.occurrencesOf(0));
        Assert.assertEquals(50, counts.occurrencesOf(1));
    }

    @Test
    public void countByParallel() {
        Interval integers = Interval.oneTo(100000);
        MutableBag<Integer> counts = integers.parallelStream().collect(Collectors2.countBy(i -> i % 2));
        Assert.assertEquals(integers.countBy(i -> i % 2), counts);
        Assert.assertEquals(50000, counts.occurrencesOf(0));
        Assert.assertEquals(50000, counts.occurrencesOf(1));
    }

    @Test
    public void countByEach() {
        List<Interval> intervals = FastList.newListWith(Interval.evensFromTo(1, 100), Interval.oddsFromTo(1, 100));
        MutableBag<Integer> counts = intervals.stream().collect(Collectors2.countByEach(iv -> iv.collect(i -> i % 2)));
        Assert.assertEquals(Interval.oneTo(100).countBy(i -> i % 2), counts);
        Assert.assertEquals(50, counts.occurrencesOf(0));
        Assert.assertEquals(50, counts.occurrencesOf(1));
    }

    @Test
    public void countByEachParallel() {
        List<Interval> intervals = FastList.newListWith(Interval.evensFromTo(1, 100000), Interval.oddsFromTo(1, 100000));
        MutableBag<Integer> counts = intervals.parallelStream().collect(Collectors2.countByEach(iv -> iv.collect(i -> i % 2)));
        Assert.assertEquals(Interval.oneTo(100000).countBy(i -> i % 2), counts);
        Assert.assertEquals(50000, counts.occurrencesOf(0));
        Assert.assertEquals(50000, counts.occurrencesOf(1));
    }

    @Test
    public void groupByEach() {
        Function<Integer, Iterable<Integer>> groupByFunction = (Integer each) -> SMALL_INTERVAL.collect((Integer i) -> each * i);
        MutableListMultimap<Integer, Integer> products = this.smallData.stream().collect(Collectors2.groupByEach(groupByFunction, Multimaps.mutable.list::empty));
        Verify.assertIterableSize(1, products.get(1));
        Verify.assertIterableSize(2, products.get(2));
        Verify.assertIterableSize(2, products.get(3));
        Verify.assertIterableSize(3, products.get(4));
        Verify.assertIterableSize(2, products.get(5));
        Assert.assertEquals(SMALL_INTERVAL.toList().groupByEach(groupByFunction), products);
    }

    @Test
    public void groupByEachParallel() {
        Function<Integer, Iterable<Integer>> groupByFunction = (Integer each) -> SMALL_INTERVAL.collect((Integer i) -> each * i);
        MutableListMultimap<Integer, Integer> products = this.smallData.parallelStream().collect(Collectors2.groupByEach(groupByFunction, Multimaps.mutable.list::empty));
        Verify.assertIterableSize(1, products.get(1));
        Verify.assertIterableSize(2, products.get(2));
        Verify.assertIterableSize(2, products.get(3));
        Verify.assertIterableSize(3, products.get(4));
        Verify.assertIterableSize(2, products.get(5));
        Assert.assertEquals(SMALL_INTERVAL.toList().groupByEach(groupByFunction), products);
    }

    @Test
    public void groupByUniqueKey() {
        MutableMap<Integer, Integer> expectedMap = SMALL_INTERVAL.groupByUniqueKey(id -> id, Maps.mutable.empty());
        MutableMap<Integer, Integer> actualMap = SMALL_INTERVAL.stream().collect(Collectors2.groupByUniqueKey(id -> id, Maps.mutable::empty));
        Assert.assertEquals(expectedMap, actualMap);
    }

    @Test(expected = IllegalStateException.class)
    public void groupByUniqueKey_throws_for_duplicate() {
        SMALL_INTERVAL.stream().collect(Collectors2.groupByUniqueKey(id -> 1, Maps.mutable::empty));
    }

    @Test
    public void groupByUniqueKey_parallelStream() {
        MutableMap<Integer, Integer> expectedMap = LARGE_INTERVAL.groupByUniqueKey(id -> id, Maps.mutable.empty());
        MutableMap<Integer, Integer> actualMap = LARGE_INTERVAL.parallelStream().collect(Collectors2.groupByUniqueKey(id -> id, Maps.mutable::empty));
        Assert.assertEquals(expectedMap, actualMap);
    }

    @Test(expected = IllegalStateException.class)
    public void groupByUniqueKey_parallelStream_throws_for_duplicate() {
        LARGE_INTERVAL.parallelStream().collect(Collectors2.groupByUniqueKey(id -> 1, Maps.mutable::empty));
    }

    @Test(expected = IllegalStateException.class)
    public void groupByUniqueKey_parallelStream_duplicate_from_combiner() {
        LARGE_INTERVAL.parallelStream().collect(Collectors2.groupByUniqueKey(id -> id == 15000 ? 1 : id, Maps.mutable::empty));
    }

    @Test
    public void aggregateBy() {
        MutableMap<Integer, Integer> expectedMap = SMALL_INTERVAL.toList().aggregateBy(each -> each % 2, () -> 0, Integer::sum);
        MutableMap<Integer, Integer> actualMap = SMALL_INTERVAL.stream().collect(Collectors2.aggregateBy(each -> each % 2, () -> 0, Integer::sum, Maps.mutable::empty));
        Assert.assertEquals(expectedMap, actualMap);
    }

    @Test
    public void aggregateBy_parallelStream() {
        MutableMap<Integer, Integer> expectedMap = LARGE_INTERVAL.toList().aggregateBy(each -> each % 2, () -> 0, Integer::sum);
        MutableMap<Integer, Integer> actualMap = LARGE_INTERVAL.parallelStream().collect(Collectors2.aggregateBy(each -> each % 2, () -> 0, Integer::sum, Maps.mutable::empty));
        Assert.assertEquals(expectedMap, actualMap);
    }

    @Test
    public void aggregateBy_mutableSortedMap() {
        Verify.assertInstanceOf(MutableSortedMap.class, SMALL_INTERVAL.stream().collect(Collectors2.aggregateBy(each -> each % 2, () -> 0, Integer::sum, SortedMaps.mutable::empty)));
    }

    @Test
    public void aggregateBy_parallelStream_mutableSortedMap() {
        Verify.assertInstanceOf(MutableSortedMap.class, LARGE_INTERVAL.parallelStream().collect(Collectors2.aggregateBy(each -> each % 2, () -> 0, Integer::sum, SortedMaps.mutable::empty)));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private Collectors2Test instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString0() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString0);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString0Parallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString0Parallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString1);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString1Parallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString1Parallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString3() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString3);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString3Parallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString3Parallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toListParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toListParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableListParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableListParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSetParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSetParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSetParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSetParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBagParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBagParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBagParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBagParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toListMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toListMultimap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toListMultimapParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toListMultimapParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toListMultimap2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toListMultimap2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toListMultimap2Parallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toListMultimap2Parallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSetMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSetMultimap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSetMultimapParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSetMultimapParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSetMultimap2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSetMultimap2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSetMultimap2Parallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSetMultimap2Parallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBagMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBagMultimap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBagMultimapParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBagMultimapParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBagMultimap2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBagMultimap2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBagMultimap2Parallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBagMultimap2Parallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupingByToBagMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupingByToBagMultimap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupingByPartition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupingByPartition);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupingByChunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupingByChunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupingByCollectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupingByCollectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupingBySumByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupingBySumByInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStack);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStackParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStackParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableStack);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableStackParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableStackParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableMapParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableMapParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBiMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBiMapParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBiMapParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBiMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBiMapParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBiMapParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetByParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetByParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSetParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSetParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSetByParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSetByParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagByParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagByParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagByParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagByParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetParallelWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetParallelWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSetWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSetWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSetParallelWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSetParallelWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagParallelWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagParallelWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagParallelWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagParallelWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedListParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedListParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedListByParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedListByParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListParallelWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListParallelWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMapParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMapWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapParallelWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMapParallelWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMapBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapByParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMapByParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedMapParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedMapParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedMapWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedMapWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedMapParallelWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedMapParallelWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedMapBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedMapBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedMapByParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedMapByParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedListWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedListWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedListParallelWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedListParallelWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableListMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableListMultimap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableListMultimapParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableListMultimapParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableListMultimap2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableListMultimap2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableListMultimap2Parallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableListMultimap2Parallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSetMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSetMultimap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSetMultimapParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSetMultimapParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSetMultimap2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSetMultimap2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSetMultimap2Parallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSetMultimap2Parallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBagMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBagMultimap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBagMultimapParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBagMultimapParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBagMultimap2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBagMultimap2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBagMultimap2Parallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBagMultimap2Parallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEachParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEachParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEachParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEachParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws_for_duplicate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_parallelStream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_parallelStream_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_parallelStream_throws_for_duplicate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_parallelStream_duplicate_from_combiner() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_parallelStream_duplicate_from_combiner);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateBy_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateBy_parallelStream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateBy_mutableSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateBy_mutableSortedMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateBy_parallelStream_mutableSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateBy_parallelStream_mutableSortedMap);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> payload) throws java.lang.Throwable {
            this.instance = new Collectors2Test();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> makeString0;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> makeString0Parallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> makeString1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> makeString1Parallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> makeString3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> makeString3Parallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toListParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableListParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toSetParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableSetParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toBagParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableBagParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toListMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toListMultimapParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toListMultimap2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toListMultimap2Parallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toSetMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toSetMultimapParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toSetMultimap2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toSetMultimap2Parallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toBagMultimapParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toBagMultimap2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toBagMultimap2Parallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> groupingByToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> groupingByPartition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> groupingByChunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> groupingByCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> groupingBySumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toStackParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableStackParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toMapParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableMapParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toBiMapParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableBiMapParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toSortedSetParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toSortedSetByParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableSortedSetParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableSortedSetByParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toSortedBagParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toSortedBagByParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableSortedBagParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableSortedBagByParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toSortedSetWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toSortedSetParallelWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableSortedSetWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableSortedSetParallelWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toSortedBagWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toSortedBagParallelWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableSortedBagWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableSortedBagParallelWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toSortedListParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toSortedListByParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableSortedListParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableSortedListByParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toSortedListWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toSortedListParallelWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toSortedMapParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toSortedMapWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toSortedMapParallelWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toSortedMapByParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableSortedMapParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableSortedMapWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableSortedMapParallelWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableSortedMapByParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableSortedListWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableSortedListParallelWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableListMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableListMultimapParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableListMultimap2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableListMultimap2Parallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableSetMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableSetMultimapParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableSetMultimap2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableSetMultimap2Parallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableBagMultimapParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableBagMultimap2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> toImmutableBagMultimap2Parallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> countByParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> countByEachParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> groupByEachParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> groupByUniqueKey_parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> groupByUniqueKey_parallelStream_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> groupByUniqueKey_parallelStream_duplicate_from_combiner;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> aggregateBy_parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> aggregateBy_mutableSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2Test> aggregateBy_parallelStream_mutableSortedMap;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.makeString0 = Collectors2Test::makeString0;
            this.payloads.makeString0Parallel = Collectors2Test::makeString0Parallel;
            this.payloads.makeString1 = Collectors2Test::makeString1;
            this.payloads.makeString1Parallel = Collectors2Test::makeString1Parallel;
            this.payloads.makeString3 = Collectors2Test::makeString3;
            this.payloads.makeString3Parallel = Collectors2Test::makeString3Parallel;
            this.payloads.toList = Collectors2Test::toList;
            this.payloads.toListParallel = Collectors2Test::toListParallel;
            this.payloads.toImmutableList = Collectors2Test::toImmutableList;
            this.payloads.toImmutableListParallel = Collectors2Test::toImmutableListParallel;
            this.payloads.toSet = Collectors2Test::toSet;
            this.payloads.toSetParallel = Collectors2Test::toSetParallel;
            this.payloads.toImmutableSet = Collectors2Test::toImmutableSet;
            this.payloads.toImmutableSetParallel = Collectors2Test::toImmutableSetParallel;
            this.payloads.toBag = Collectors2Test::toBag;
            this.payloads.toBagParallel = Collectors2Test::toBagParallel;
            this.payloads.toImmutableBag = Collectors2Test::toImmutableBag;
            this.payloads.toImmutableBagParallel = Collectors2Test::toImmutableBagParallel;
            this.payloads.toListMultimap = Collectors2Test::toListMultimap;
            this.payloads.toListMultimapParallel = Collectors2Test::toListMultimapParallel;
            this.payloads.toListMultimap2 = Collectors2Test::toListMultimap2;
            this.payloads.toListMultimap2Parallel = Collectors2Test::toListMultimap2Parallel;
            this.payloads.toSetMultimap = Collectors2Test::toSetMultimap;
            this.payloads.toSetMultimapParallel = Collectors2Test::toSetMultimapParallel;
            this.payloads.toSetMultimap2 = Collectors2Test::toSetMultimap2;
            this.payloads.toSetMultimap2Parallel = Collectors2Test::toSetMultimap2Parallel;
            this.payloads.toBagMultimap = Collectors2Test::toBagMultimap;
            this.payloads.toBagMultimapParallel = Collectors2Test::toBagMultimapParallel;
            this.payloads.toBagMultimap2 = Collectors2Test::toBagMultimap2;
            this.payloads.toBagMultimap2Parallel = Collectors2Test::toBagMultimap2Parallel;
            this.payloads.groupingByToBagMultimap = Collectors2Test::groupingByToBagMultimap;
            this.payloads.groupingByPartition = Collectors2Test::groupingByPartition;
            this.payloads.groupingByChunk = Collectors2Test::groupingByChunk;
            this.payloads.groupingByCollectInt = Collectors2Test::groupingByCollectInt;
            this.payloads.groupingBySumByInt = Collectors2Test::groupingBySumByInt;
            this.payloads.toStack = Collectors2Test::toStack;
            this.payloads.toStackParallel = Collectors2Test::toStackParallel;
            this.payloads.toImmutableStack = Collectors2Test::toImmutableStack;
            this.payloads.toImmutableStackParallel = Collectors2Test::toImmutableStackParallel;
            this.payloads.toMap = Collectors2Test::toMap;
            this.payloads.toMapParallel = Collectors2Test::toMapParallel;
            this.payloads.toImmutableMap = Collectors2Test::toImmutableMap;
            this.payloads.toImmutableMapParallel = Collectors2Test::toImmutableMapParallel;
            this.payloads.toBiMap = Collectors2Test::toBiMap;
            this.payloads.toBiMapParallel = Collectors2Test::toBiMapParallel;
            this.payloads.toImmutableBiMap = Collectors2Test::toImmutableBiMap;
            this.payloads.toImmutableBiMapParallel = Collectors2Test::toImmutableBiMapParallel;
            this.payloads.toSortedSet = Collectors2Test::toSortedSet;
            this.payloads.toSortedSetParallel = Collectors2Test::toSortedSetParallel;
            this.payloads.toSortedSetBy = Collectors2Test::toSortedSetBy;
            this.payloads.toSortedSetByParallel = Collectors2Test::toSortedSetByParallel;
            this.payloads.toImmutableSortedSet = Collectors2Test::toImmutableSortedSet;
            this.payloads.toImmutableSortedSetParallel = Collectors2Test::toImmutableSortedSetParallel;
            this.payloads.toImmutableSortedSetBy = Collectors2Test::toImmutableSortedSetBy;
            this.payloads.toImmutableSortedSetByParallel = Collectors2Test::toImmutableSortedSetByParallel;
            this.payloads.toSortedBag = Collectors2Test::toSortedBag;
            this.payloads.toSortedBagParallel = Collectors2Test::toSortedBagParallel;
            this.payloads.toSortedBagBy = Collectors2Test::toSortedBagBy;
            this.payloads.toSortedBagByParallel = Collectors2Test::toSortedBagByParallel;
            this.payloads.toImmutableSortedBag = Collectors2Test::toImmutableSortedBag;
            this.payloads.toImmutableSortedBagParallel = Collectors2Test::toImmutableSortedBagParallel;
            this.payloads.toImmutableSortedBagBy = Collectors2Test::toImmutableSortedBagBy;
            this.payloads.toImmutableSortedBagByParallel = Collectors2Test::toImmutableSortedBagByParallel;
            this.payloads.toSortedSetWithComparator = Collectors2Test::toSortedSetWithComparator;
            this.payloads.toSortedSetParallelWithComparator = Collectors2Test::toSortedSetParallelWithComparator;
            this.payloads.toImmutableSortedSetWithComparator = Collectors2Test::toImmutableSortedSetWithComparator;
            this.payloads.toImmutableSortedSetParallelWithComparator = Collectors2Test::toImmutableSortedSetParallelWithComparator;
            this.payloads.toSortedBagWithComparator = Collectors2Test::toSortedBagWithComparator;
            this.payloads.toSortedBagParallelWithComparator = Collectors2Test::toSortedBagParallelWithComparator;
            this.payloads.toImmutableSortedBagWithComparator = Collectors2Test::toImmutableSortedBagWithComparator;
            this.payloads.toImmutableSortedBagParallelWithComparator = Collectors2Test::toImmutableSortedBagParallelWithComparator;
            this.payloads.toSortedList = Collectors2Test::toSortedList;
            this.payloads.toSortedListParallel = Collectors2Test::toSortedListParallel;
            this.payloads.toSortedListBy = Collectors2Test::toSortedListBy;
            this.payloads.toSortedListByParallel = Collectors2Test::toSortedListByParallel;
            this.payloads.toImmutableSortedList = Collectors2Test::toImmutableSortedList;
            this.payloads.toImmutableSortedListParallel = Collectors2Test::toImmutableSortedListParallel;
            this.payloads.toImmutableSortedListBy = Collectors2Test::toImmutableSortedListBy;
            this.payloads.toImmutableSortedListByParallel = Collectors2Test::toImmutableSortedListByParallel;
            this.payloads.toSortedListWithComparator = Collectors2Test::toSortedListWithComparator;
            this.payloads.toSortedListParallelWithComparator = Collectors2Test::toSortedListParallelWithComparator;
            this.payloads.toSortedMap = Collectors2Test::toSortedMap;
            this.payloads.toSortedMapParallel = Collectors2Test::toSortedMapParallel;
            this.payloads.toSortedMapWithComparator = Collectors2Test::toSortedMapWithComparator;
            this.payloads.toSortedMapParallelWithComparator = Collectors2Test::toSortedMapParallelWithComparator;
            this.payloads.toSortedMapBy = Collectors2Test::toSortedMapBy;
            this.payloads.toSortedMapByParallel = Collectors2Test::toSortedMapByParallel;
            this.payloads.toImmutableSortedMap = Collectors2Test::toImmutableSortedMap;
            this.payloads.toImmutableSortedMapParallel = Collectors2Test::toImmutableSortedMapParallel;
            this.payloads.toImmutableSortedMapWithComparator = Collectors2Test::toImmutableSortedMapWithComparator;
            this.payloads.toImmutableSortedMapParallelWithComparator = Collectors2Test::toImmutableSortedMapParallelWithComparator;
            this.payloads.toImmutableSortedMapBy = Collectors2Test::toImmutableSortedMapBy;
            this.payloads.toImmutableSortedMapByParallel = Collectors2Test::toImmutableSortedMapByParallel;
            this.payloads.toImmutableSortedListWithComparator = Collectors2Test::toImmutableSortedListWithComparator;
            this.payloads.toImmutableSortedListParallelWithComparator = Collectors2Test::toImmutableSortedListParallelWithComparator;
            this.payloads.toImmutableListMultimap = Collectors2Test::toImmutableListMultimap;
            this.payloads.toImmutableListMultimapParallel = Collectors2Test::toImmutableListMultimapParallel;
            this.payloads.toImmutableListMultimap2 = Collectors2Test::toImmutableListMultimap2;
            this.payloads.toImmutableListMultimap2Parallel = Collectors2Test::toImmutableListMultimap2Parallel;
            this.payloads.toImmutableSetMultimap = Collectors2Test::toImmutableSetMultimap;
            this.payloads.toImmutableSetMultimapParallel = Collectors2Test::toImmutableSetMultimapParallel;
            this.payloads.toImmutableSetMultimap2 = Collectors2Test::toImmutableSetMultimap2;
            this.payloads.toImmutableSetMultimap2Parallel = Collectors2Test::toImmutableSetMultimap2Parallel;
            this.payloads.toImmutableBagMultimap = Collectors2Test::toImmutableBagMultimap;
            this.payloads.toImmutableBagMultimapParallel = Collectors2Test::toImmutableBagMultimapParallel;
            this.payloads.toImmutableBagMultimap2 = Collectors2Test::toImmutableBagMultimap2;
            this.payloads.toImmutableBagMultimap2Parallel = Collectors2Test::toImmutableBagMultimap2Parallel;
            this.payloads.countBy = Collectors2Test::countBy;
            this.payloads.countByParallel = Collectors2Test::countByParallel;
            this.payloads.countByEach = Collectors2Test::countByEach;
            this.payloads.countByEachParallel = Collectors2Test::countByEachParallel;
            this.payloads.groupByEach = Collectors2Test::groupByEach;
            this.payloads.groupByEachParallel = Collectors2Test::groupByEachParallel;
            this.payloads.groupByUniqueKey = Collectors2Test::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(Collectors2Test::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_parallelStream = Collectors2Test::groupByUniqueKey_parallelStream;
            this.payloads.groupByUniqueKey_parallelStream_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(Collectors2Test::groupByUniqueKey_parallelStream_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_parallelStream_duplicate_from_combiner = new se.chalmers.ju2jmh.api.ExceptionTest<>(Collectors2Test::groupByUniqueKey_parallelStream_duplicate_from_combiner, java.lang.IllegalStateException.class);
            this.payloads.aggregateBy = Collectors2Test::aggregateBy;
            this.payloads.aggregateBy_parallelStream = Collectors2Test::aggregateBy_parallelStream;
            this.payloads.aggregateBy_mutableSortedMap = Collectors2Test::aggregateBy_mutableSortedMap;
            this.payloads.aggregateBy_parallelStream_mutableSortedMap = Collectors2Test::aggregateBy_parallelStream_mutableSortedMap;
        }
    }
}
