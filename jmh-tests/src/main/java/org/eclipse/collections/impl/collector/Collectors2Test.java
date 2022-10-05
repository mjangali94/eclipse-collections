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
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString0() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::makeString0, this.description("makeString0"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString0Parallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::makeString0Parallel, this.description("makeString0Parallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString1() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::makeString1, this.description("makeString1"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString1Parallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::makeString1Parallel, this.description("makeString1Parallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString3() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::makeString3, this.description("makeString3"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString3Parallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::makeString3Parallel, this.description("makeString3Parallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toList, this.description("toList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toListParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toListParallel, this.description("toListParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableList, this.description("toImmutableList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableListParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableListParallel, this.description("toImmutableListParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSet, this.description("toSet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSetParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSetParallel, this.description("toSetParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableSet, this.description("toImmutableSet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSetParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableSetParallel, this.description("toImmutableSetParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toBag, this.description("toBag"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBagParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toBagParallel, this.description("toBagParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBag() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableBag, this.description("toImmutableBag"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBagParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableBagParallel, this.description("toImmutableBagParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toListMultimap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toListMultimap, this.description("toListMultimap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toListMultimapParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toListMultimapParallel, this.description("toListMultimapParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toListMultimap2() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toListMultimap2, this.description("toListMultimap2"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toListMultimap2Parallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toListMultimap2Parallel, this.description("toListMultimap2Parallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSetMultimap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSetMultimap, this.description("toSetMultimap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSetMultimapParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSetMultimapParallel, this.description("toSetMultimapParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSetMultimap2() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSetMultimap2, this.description("toSetMultimap2"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSetMultimap2Parallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSetMultimap2Parallel, this.description("toSetMultimap2Parallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBagMultimap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toBagMultimap, this.description("toBagMultimap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBagMultimapParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toBagMultimapParallel, this.description("toBagMultimapParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBagMultimap2() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toBagMultimap2, this.description("toBagMultimap2"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBagMultimap2Parallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toBagMultimap2Parallel, this.description("toBagMultimap2Parallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupingByToBagMultimap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupingByToBagMultimap, this.description("groupingByToBagMultimap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupingByPartition() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupingByPartition, this.description("groupingByPartition"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupingByChunk() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupingByChunk, this.description("groupingByChunk"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupingByCollectInt() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupingByCollectInt, this.description("groupingByCollectInt"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupingBySumByInt() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupingBySumByInt, this.description("groupingBySumByInt"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStack() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toStack, this.description("toStack"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStackParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toStackParallel, this.description("toStackParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableStack() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableStack, this.description("toImmutableStack"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableStackParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableStackParallel, this.description("toImmutableStackParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toMap, this.description("toMap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toMapParallel, this.description("toMapParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableMap, this.description("toImmutableMap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableMapParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableMapParallel, this.description("toImmutableMapParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBiMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toBiMap, this.description("toBiMap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBiMapParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toBiMapParallel, this.description("toBiMapParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBiMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableBiMap, this.description("toImmutableBiMap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBiMapParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableBiMapParallel, this.description("toImmutableBiMapParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedSet, this.description("toSortedSet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedSetParallel, this.description("toSortedSetParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedSetBy, this.description("toSortedSetBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetByParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedSetByParallel, this.description("toSortedSetByParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableSortedSet, this.description("toImmutableSortedSet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSetParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableSortedSetParallel, this.description("toImmutableSortedSetParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSetBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableSortedSetBy, this.description("toImmutableSortedSetBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSetByParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableSortedSetByParallel, this.description("toImmutableSortedSetByParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedBag, this.description("toSortedBag"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedBagParallel, this.description("toSortedBagParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedBagBy, this.description("toSortedBagBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagByParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedBagByParallel, this.description("toSortedBagByParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableSortedBag, this.description("toImmutableSortedBag"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableSortedBagParallel, this.description("toImmutableSortedBagParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableSortedBagBy, this.description("toImmutableSortedBagBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagByParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableSortedBagByParallel, this.description("toImmutableSortedBagByParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetWithComparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedSetWithComparator, this.description("toSortedSetWithComparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetParallelWithComparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedSetParallelWithComparator, this.description("toSortedSetParallelWithComparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSetWithComparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableSortedSetWithComparator, this.description("toImmutableSortedSetWithComparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSetParallelWithComparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableSortedSetParallelWithComparator, this.description("toImmutableSortedSetParallelWithComparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagWithComparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedBagWithComparator, this.description("toSortedBagWithComparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagParallelWithComparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedBagParallelWithComparator, this.description("toSortedBagParallelWithComparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagWithComparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableSortedBagWithComparator, this.description("toImmutableSortedBagWithComparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagParallelWithComparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableSortedBagParallelWithComparator, this.description("toImmutableSortedBagParallelWithComparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedList, this.description("toSortedList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedListParallel, this.description("toSortedListParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedListBy, this.description("toSortedListBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedListByParallel, this.description("toSortedListByParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableSortedList, this.description("toImmutableSortedList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedListParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableSortedListParallel, this.description("toImmutableSortedListParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedListBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableSortedListBy, this.description("toImmutableSortedListBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedListByParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableSortedListByParallel, this.description("toImmutableSortedListByParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListWithComparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedListWithComparator, this.description("toSortedListWithComparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListParallelWithComparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedListParallelWithComparator, this.description("toSortedListParallelWithComparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedMap, this.description("toSortedMap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedMapParallel, this.description("toSortedMapParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapWithComparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedMapWithComparator, this.description("toSortedMapWithComparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapParallelWithComparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedMapParallelWithComparator, this.description("toSortedMapParallelWithComparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedMapBy, this.description("toSortedMapBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapByParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedMapByParallel, this.description("toSortedMapByParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableSortedMap, this.description("toImmutableSortedMap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedMapParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableSortedMapParallel, this.description("toImmutableSortedMapParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedMapWithComparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableSortedMapWithComparator, this.description("toImmutableSortedMapWithComparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedMapParallelWithComparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableSortedMapParallelWithComparator, this.description("toImmutableSortedMapParallelWithComparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedMapBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableSortedMapBy, this.description("toImmutableSortedMapBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedMapByParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableSortedMapByParallel, this.description("toImmutableSortedMapByParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedListWithComparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableSortedListWithComparator, this.description("toImmutableSortedListWithComparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedListParallelWithComparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableSortedListParallelWithComparator, this.description("toImmutableSortedListParallelWithComparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableListMultimap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableListMultimap, this.description("toImmutableListMultimap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableListMultimapParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableListMultimapParallel, this.description("toImmutableListMultimapParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableListMultimap2() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableListMultimap2, this.description("toImmutableListMultimap2"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableListMultimap2Parallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableListMultimap2Parallel, this.description("toImmutableListMultimap2Parallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSetMultimap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableSetMultimap, this.description("toImmutableSetMultimap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSetMultimapParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableSetMultimapParallel, this.description("toImmutableSetMultimapParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSetMultimap2() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableSetMultimap2, this.description("toImmutableSetMultimap2"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSetMultimap2Parallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableSetMultimap2Parallel, this.description("toImmutableSetMultimap2Parallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBagMultimap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableBagMultimap, this.description("toImmutableBagMultimap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBagMultimapParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableBagMultimapParallel, this.description("toImmutableBagMultimapParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBagMultimap2() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableBagMultimap2, this.description("toImmutableBagMultimap2"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBagMultimap2Parallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutableBagMultimap2Parallel, this.description("toImmutableBagMultimap2Parallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::countBy, this.description("countBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::countByParallel, this.description("countByParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::countByEach, this.description("countByEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEachParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::countByEachParallel, this.description("countByEachParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupByEach, this.description("groupByEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEachParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupByEachParallel, this.description("groupByEachParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupByUniqueKey, this.description("groupByUniqueKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws_for_duplicate() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::groupByUniqueKey_throws_for_duplicate, this.description("groupByUniqueKey_throws_for_duplicate"), java.lang.IllegalStateException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_parallelStream() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupByUniqueKey_parallelStream, this.description("groupByUniqueKey_parallelStream"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_parallelStream_throws_for_duplicate() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::groupByUniqueKey_parallelStream_throws_for_duplicate, this.description("groupByUniqueKey_parallelStream_throws_for_duplicate"), java.lang.IllegalStateException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_parallelStream_duplicate_from_combiner() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::groupByUniqueKey_parallelStream_duplicate_from_combiner, this.description("groupByUniqueKey_parallelStream_duplicate_from_combiner"), java.lang.IllegalStateException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::aggregateBy, this.description("aggregateBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateBy_parallelStream() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::aggregateBy_parallelStream, this.description("aggregateBy_parallelStream"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateBy_mutableSortedMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::aggregateBy_mutableSortedMap, this.description("aggregateBy_mutableSortedMap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateBy_parallelStream_mutableSortedMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::aggregateBy_parallelStream_mutableSortedMap, this.description("aggregateBy_parallelStream_mutableSortedMap"));
        }

        private Collectors2Test implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new Collectors2Test();
        }

        @java.lang.Override
        public Collectors2Test implementation() {
            return this.implementation;
        }
    }
}
