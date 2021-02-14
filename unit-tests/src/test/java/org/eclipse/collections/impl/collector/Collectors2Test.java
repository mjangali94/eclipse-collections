/*
 * Copyright (c) 2018 Goldman Sachs and others.
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
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.collection.primitive.MutableIntCollection;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.map.primitive.MutableObjectLongMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.bag.MutableBagMultimap;
import org.eclipse.collections.api.multimap.list.MutableListMultimap;
import org.eclipse.collections.api.partition.PartitionMutableCollection;
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
        Assert.assertEquals(SMALL_INTERVAL.toList(), this.smallData.stream().collect(Collectors2.toList()));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toList()), this.smallData.stream().collect(Collectors2.toList()));
    }

    @Test
    public void toListParallel() {
        Assert.assertEquals(LARGE_INTERVAL.toList(), this.bigData.parallelStream().collect(Collectors2.toList()));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toList()), this.bigData.parallelStream().collect(Collectors2.toList()));
    }

    @Test
    public void toImmutableList() {
        Assert.assertEquals(SMALL_INTERVAL.toList(), this.smallData.stream().collect(Collectors2.toImmutableList()));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toList()), this.smallData.stream().collect(Collectors2.toImmutableList()));
    }

    @Test
    public void toImmutableListParallel() {
        Assert.assertEquals(LARGE_INTERVAL.toList(), this.bigData.parallelStream().collect(Collectors2.toImmutableList()));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toList()), this.bigData.parallelStream().collect(Collectors2.toImmutableList()));
    }

    @Test
    public void toSet() {
        Assert.assertEquals(SMALL_INTERVAL.toSet(), this.smallData.stream().collect(Collectors2.toSet()));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toSet()), this.smallData.stream().collect(Collectors2.toSet()));
    }

    @Test
    public void toSetParallel() {
        Assert.assertEquals(LARGE_INTERVAL.toSet(), this.bigData.parallelStream().collect(Collectors2.toSet()));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toSet()), this.bigData.parallelStream().collect(Collectors2.toSet()));
    }

    @Test
    public void toImmutableSet() {
        Assert.assertEquals(SMALL_INTERVAL.toSet(), this.smallData.stream().collect(Collectors2.toImmutableSet()));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toSet()), this.smallData.stream().collect(Collectors2.toImmutableSet()));
    }

    @Test
    public void toImmutableSetParallel() {
        Assert.assertEquals(LARGE_INTERVAL.toSet(), this.bigData.parallelStream().collect(Collectors2.toImmutableSet()));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toSet()), this.bigData.parallelStream().collect(Collectors2.toImmutableSet()));
    }

    @Test
    public void toBag() {
        Assert.assertEquals(SMALL_INTERVAL.toBag(), this.smallData.stream().collect(Collectors2.toBag()));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toBag()), this.smallData.stream().collect(Collectors2.toBag()));
    }

    @Test
    public void toBagParallel() {
        Assert.assertEquals(LARGE_INTERVAL.toBag(), this.bigData.parallelStream().collect(Collectors2.toBag()));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toBag()), this.bigData.parallelStream().collect(Collectors2.toBag()));
    }

    @Test
    public void toImmutableBag() {
        Assert.assertEquals(SMALL_INTERVAL.toBag(), this.smallData.stream().collect(Collectors2.toImmutableBag()));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toBag()), this.smallData.stream().collect(Collectors2.toImmutableBag()));
    }

    @Test
    public void toImmutableBagParallel() {
        Assert.assertEquals(LARGE_INTERVAL.toBag(), this.bigData.parallelStream().collect(Collectors2.toImmutableBag()));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toBag()), this.bigData.parallelStream().collect(Collectors2.toImmutableBag()));
    }

    @Test
    public void toListMultimap() {
        Assert.assertEquals(SMALL_INTERVAL.groupBy(Object::toString), this.smallData.stream().collect(Collectors2.toListMultimap(Object::toString)));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toListMultimap(Object::toString)), this.smallData.stream().collect(Collectors2.toListMultimap(Object::toString)));
    }

    @Test
    public void toListMultimapParallel() {
        Assert.assertEquals(LARGE_INTERVAL.groupBy(Object::toString), this.bigData.parallelStream().collect(Collectors2.toListMultimap(Object::toString)));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toListMultimap(Object::toString)), this.bigData.parallelStream().collect(Collectors2.toListMultimap(Object::toString)));
    }

    @Test
    public void toListMultimap2() {
        Assert.assertEquals(SMALL_INTERVAL.collect(Object::toString).groupBy(Object::toString), this.smallData.stream().collect(Collectors2.toListMultimap(Object::toString, Object::toString)));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toListMultimap(Object::toString, Object::toString)), this.smallData.stream().collect(Collectors2.toListMultimap(Object::toString, Object::toString)));
    }

    @Test
    public void toListMultimap2Parallel() {
        Assert.assertEquals(LARGE_INTERVAL.collect(Object::toString).groupBy(Object::toString), this.bigData.parallelStream().collect(Collectors2.toListMultimap(Object::toString, Object::toString)));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toListMultimap(Object::toString, Object::toString)), this.bigData.parallelStream().collect(Collectors2.toListMultimap(Object::toString, Object::toString)));
    }

    @Test
    public void toSetMultimap() {
        Assert.assertEquals(SMALL_INTERVAL.toSet().groupBy(Object::toString), this.smallData.stream().collect(Collectors2.toSetMultimap(Object::toString)));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toSetMultimap(Object::toString)), this.smallData.stream().collect(Collectors2.toSetMultimap(Object::toString)));
    }

    @Test
    public void toSetMultimapParallel() {
        Assert.assertEquals(LARGE_INTERVAL.toSet().groupBy(Object::toString), this.bigData.parallelStream().collect(Collectors2.toSetMultimap(Object::toString)));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toSetMultimap(Object::toString)), this.bigData.parallelStream().collect(Collectors2.toSetMultimap(Object::toString)));
    }

    @Test
    public void toSetMultimap2() {
        Assert.assertEquals(SMALL_INTERVAL.toSet().collect(Object::toString).groupBy(Object::toString), this.smallData.stream().collect(Collectors2.toSetMultimap(Object::toString, Object::toString)));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toSetMultimap(Object::toString, Object::toString)), this.smallData.stream().collect(Collectors2.toSetMultimap(Object::toString, Object::toString)));
    }

    @Test
    public void toSetMultimap2Parallel() {
        Assert.assertEquals(LARGE_INTERVAL.toSet().collect(Object::toString).groupBy(Object::toString), this.bigData.parallelStream().collect(Collectors2.toSetMultimap(Object::toString, Object::toString)));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toSetMultimap(Object::toString, Object::toString)), this.bigData.parallelStream().collect(Collectors2.toSetMultimap(Object::toString, Object::toString)));
    }

    @Test
    public void toBagMultimap() {
        Assert.assertEquals(SMALL_INTERVAL.toBag().groupBy(Object::toString), this.smallData.stream().collect(Collectors2.toBagMultimap(Object::toString)));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toBagMultimap(Object::toString)), this.smallData.stream().collect(Collectors2.toBagMultimap(Object::toString)));
    }

    @Test
    public void toBagMultimapParallel() {
        Assert.assertEquals(LARGE_INTERVAL.toBag().groupBy(Object::toString), this.bigData.parallelStream().collect(Collectors2.toBagMultimap(Object::toString)));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toBagMultimap(Object::toString)), this.bigData.parallelStream().collect(Collectors2.toBagMultimap(Object::toString)));
    }

    @Test
    public void toBagMultimap2() {
        Assert.assertEquals(SMALL_INTERVAL.toBag().collect(Object::toString).groupBy(Object::toString), this.smallData.stream().collect(Collectors2.toBagMultimap(Object::toString, Object::toString)));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toBagMultimap(Object::toString, Object::toString)), this.smallData.stream().collect(Collectors2.toBagMultimap(Object::toString, Object::toString)));
    }

    @Test
    public void toBagMultimap2Parallel() {
        Assert.assertEquals(LARGE_INTERVAL.toBag().collect(Object::toString).groupBy(Object::toString), this.bigData.parallelStream().collect(Collectors2.toBagMultimap(Object::toString, Object::toString)));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toBagMultimap(Object::toString, Object::toString)), this.bigData.parallelStream().collect(Collectors2.toBagMultimap(Object::toString, Object::toString)));
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
        Assert.assertEquals(Stacks.mutable.ofAll(SMALL_INTERVAL), this.smallData.stream().collect(Collectors2.toStack()));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toStack()), this.smallData.stream().collect(Collectors2.toStack()));
        Assert.assertEquals(SMALL_INTERVAL.toList().toStack(), SMALL_INTERVAL.reduceInPlace(Collectors2.toStack()));
    }

    @Test
    public void toStackParallel() {
        Assert.assertEquals(Stacks.mutable.ofAll(LARGE_INTERVAL), this.bigData.parallelStream().collect(Collectors2.toStack()));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toStack()), this.bigData.parallelStream().collect(Collectors2.toStack()));
    }

    @Test
    public void toImmutableStack() {
        Assert.assertEquals(Stacks.mutable.ofAll(SMALL_INTERVAL), this.smallData.stream().collect(Collectors2.toImmutableStack()));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toStack()), this.smallData.stream().collect(Collectors2.toImmutableStack()));
        Assert.assertEquals(SMALL_INTERVAL.toList().toStack().toImmutable(), SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableStack()));
    }

    @Test
    public void toImmutableStackParallel() {
        Assert.assertEquals(Stacks.mutable.ofAll(LARGE_INTERVAL), this.bigData.parallelStream().collect(Collectors2.toImmutableStack()));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toStack()), this.bigData.parallelStream().collect(Collectors2.toImmutableStack()));
    }

    @Test
    public void toMap() {
        Assert.assertEquals(SMALL_INTERVAL.toMap(Object::toString, i -> i), this.smallData.stream().collect(Collectors2.toMap(Object::toString, i -> i)));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toMap(Object::toString, i -> i)), this.smallData.stream().collect(Collectors2.toMap(Object::toString, i -> i)));
        Assert.assertEquals(SMALL_INTERVAL.stream().collect(Collectors.toMap(Object::toString, i -> i)), SMALL_INTERVAL.reduceInPlace(Collectors2.toMap(Object::toString, i -> i)));
    }

    @Test
    public void toMapParallel() {
        Assert.assertEquals(LARGE_INTERVAL.toMap(Object::toString, i -> i), this.bigData.parallelStream().collect(Collectors2.toMap(Object::toString, i -> i)));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toMap(Object::toString, i -> i)), this.bigData.parallelStream().collect(Collectors2.toMap(Object::toString, i -> i)));
    }

    @Test
    public void toImmutableMap() {
        Assert.assertEquals(SMALL_INTERVAL.toMap(Object::toString, i -> i), this.smallData.stream().collect(Collectors2.toImmutableMap(Object::toString, i -> i)));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toMap(Object::toString, i -> i)), this.smallData.stream().collect(Collectors2.toImmutableMap(Object::toString, i -> i)));
        Assert.assertEquals(SMALL_INTERVAL.stream().collect(Collectors.toMap(Object::toString, i -> i)), SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableMap(Object::toString, i -> i)));
    }

    @Test
    public void toImmutableMapParallel() {
        Assert.assertEquals(LARGE_INTERVAL.toMap(Object::toString, i -> i), this.bigData.parallelStream().collect(Collectors2.toImmutableMap(Object::toString, i -> i)));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toMap(Object::toString, i -> i)), this.bigData.parallelStream().collect(Collectors2.toImmutableMap(Object::toString, i -> i)));
    }

    @Test
    public void toBiMap() {
        Assert.assertEquals(SMALL_INTERVAL.injectInto(BiMaps.mutable.empty(), (mbm, e) -> {
            mbm.put(e.toString(), e);
            return mbm;
        }), this.smallData.stream().collect(Collectors2.toBiMap(Object::toString, i -> i)));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toBiMap(Object::toString, i -> i)), this.smallData.stream().collect(Collectors2.toBiMap(Object::toString, i -> i)));
    }

    @Test
    public void toBiMapParallel() {
        Assert.assertEquals(LARGE_INTERVAL.injectInto(BiMaps.mutable.empty(), (mbm, e) -> {
            mbm.put(e.toString(), e);
            return mbm;
        }), this.bigData.parallelStream().collect(Collectors2.toBiMap(Object::toString, i -> i)));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toBiMap(Object::toString, i -> i)), this.bigData.parallelStream().collect(Collectors2.toBiMap(Object::toString, i -> i)));
    }

    @Test
    public void toImmutableBiMap() {
        Assert.assertEquals(SMALL_INTERVAL.injectInto(BiMaps.mutable.empty(), (mbm, e) -> {
            mbm.put(e.toString(), e);
            return mbm;
        }), this.smallData.stream().collect(Collectors2.toImmutableBiMap(Object::toString, i -> i)));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toBiMap(Object::toString, i -> i)), this.smallData.stream().collect(Collectors2.toImmutableBiMap(Object::toString, i -> i)));
    }

    @Test
    public void toImmutableBiMapParallel() {
        Assert.assertEquals(LARGE_INTERVAL.injectInto(BiMaps.mutable.empty(), (mbm, e) -> {
            mbm.put(e.toString(), e);
            return mbm;
        }), this.bigData.parallelStream().collect(Collectors2.toImmutableBiMap(Object::toString, i -> i)));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toBiMap(Object::toString, i -> i)), this.bigData.parallelStream().collect(Collectors2.toImmutableBiMap(Object::toString, i -> i)));
    }

    @Test
    public void toSortedSet() {
        Assert.assertEquals(SMALL_INTERVAL.toSortedSet(), this.smallData.stream().collect(Collectors2.toSortedSet()));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toSortedSet()), this.smallData.stream().collect(Collectors2.toSortedSet()));
    }

    @Test
    public void toSortedSetParallel() {
        Assert.assertEquals(LARGE_INTERVAL.toSortedSet(), this.bigData.parallelStream().collect(Collectors2.toSortedSet()));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toSortedSet()), this.bigData.parallelStream().collect(Collectors2.toSortedSet()));
    }

    @Test
    public void toSortedSetBy() {
        Assert.assertEquals(SMALL_INTERVAL.toSortedSetBy(Object::toString), this.smallData.stream().collect(Collectors2.toSortedSetBy(Object::toString)));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toSortedSetBy(Object::toString)), this.smallData.stream().collect(Collectors2.toSortedSetBy(Object::toString)));
    }

    @Test
    public void toSortedSetByParallel() {
        Assert.assertEquals(LARGE_INTERVAL.toSortedSetBy(Object::toString), this.bigData.parallelStream().collect(Collectors2.toSortedSetBy(Object::toString)));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toSortedSetBy(Object::toString)), this.bigData.parallelStream().collect(Collectors2.toSortedSetBy(Object::toString)));
    }

    @Test
    public void toImmutableSortedSet() {
        Assert.assertEquals(SMALL_INTERVAL.toSortedSet(), this.smallData.stream().collect(Collectors2.toImmutableSortedSet()));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedSet()), this.smallData.stream().collect(Collectors2.toImmutableSortedSet()));
    }

    @Test
    public void toImmutableSortedSetParallel() {
        Assert.assertEquals(LARGE_INTERVAL.toSortedSet(), this.bigData.parallelStream().collect(Collectors2.toImmutableSortedSet()));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedSet()), this.bigData.parallelStream().collect(Collectors2.toImmutableSortedSet()));
    }

    @Test
    public void toSortedBag() {
        Assert.assertEquals(SMALL_INTERVAL.toSortedBag(), this.smallData.stream().collect(Collectors2.toSortedBag()));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toSortedBag()), this.smallData.stream().collect(Collectors2.toSortedBag()));
    }

    @Test
    public void toSortedBagParallel() {
        Assert.assertEquals(LARGE_INTERVAL.toSortedBag(), this.bigData.parallelStream().collect(Collectors2.toSortedBag()));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toSortedBag()), this.bigData.parallelStream().collect(Collectors2.toSortedBag()));
    }

    @Test
    public void toSortedBagBy() {
        Assert.assertEquals(SMALL_INTERVAL.toSortedBagBy(Object::toString), this.smallData.stream().collect(Collectors2.toSortedBagBy(Object::toString)));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toSortedBagBy(Object::toString)), this.smallData.stream().collect(Collectors2.toSortedBagBy(Object::toString)));
    }

    @Test
    public void toSortedBagByParallel() {
        Assert.assertEquals(LARGE_INTERVAL.toSortedBagBy(Object::toString), this.bigData.parallelStream().collect(Collectors2.toSortedBagBy(Object::toString)));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toSortedBagBy(Object::toString)), this.bigData.parallelStream().collect(Collectors2.toSortedBagBy(Object::toString)));
    }

    @Test
    public void toImmutableSortedBag() {
        Assert.assertEquals(SMALL_INTERVAL.toSortedBag(), this.smallData.stream().collect(Collectors2.toImmutableSortedBag()));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedBag()), this.smallData.stream().collect(Collectors2.toImmutableSortedBag()));
    }

    @Test
    public void toImmutableSortedBagParallel() {
        Assert.assertEquals(LARGE_INTERVAL.toSortedBag(), this.bigData.parallelStream().collect(Collectors2.toImmutableSortedBag()));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedBag()), this.bigData.parallelStream().collect(Collectors2.toImmutableSortedBag()));
    }

    @Test
    public void toSortedSetWithComparator() {
        Assert.assertEquals(SMALL_INTERVAL.toSortedSet(Comparator.reverseOrder()), this.smallData.stream().collect(Collectors2.toSortedSet(Comparator.reverseOrder())));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toSortedSet(Comparator.reverseOrder())), this.smallData.stream().collect(Collectors2.toSortedSet(Comparator.reverseOrder())));
    }

    @Test
    public void toSortedSetParallelWithComparator() {
        Assert.assertEquals(LARGE_INTERVAL.toSortedSet(Comparator.reverseOrder()), this.bigData.parallelStream().collect(Collectors2.toSortedSet(Comparator.reverseOrder())));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toSortedSet(Comparator.reverseOrder())), this.bigData.parallelStream().collect(Collectors2.toSortedSet(Comparator.reverseOrder())));
    }

    @Test
    public void toImmutableSortedSetWithComparator() {
        Assert.assertEquals(SMALL_INTERVAL.toSortedSet(Comparator.reverseOrder()), this.smallData.stream().collect(Collectors2.toImmutableSortedSet(Comparator.reverseOrder())));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedSet(Comparator.reverseOrder())), this.smallData.stream().collect(Collectors2.toImmutableSortedSet(Comparator.reverseOrder())));
    }

    @Test
    public void toImmutableSortedSetParallelWithComparator() {
        Assert.assertEquals(LARGE_INTERVAL.toSortedSet(Comparator.reverseOrder()), this.bigData.parallelStream().collect(Collectors2.toImmutableSortedSet(Comparator.reverseOrder())));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedSet(Comparator.reverseOrder())), this.bigData.parallelStream().collect(Collectors2.toImmutableSortedSet(Comparator.reverseOrder())));
    }

    @Test
    public void toSortedBagWithComparator() {
        Assert.assertEquals(SMALL_INTERVAL.toSortedBag(Comparator.reverseOrder()), this.smallData.stream().collect(Collectors2.toSortedBag(Comparator.reverseOrder())));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toSortedBag(Comparator.reverseOrder())), this.smallData.stream().collect(Collectors2.toSortedBag()));
    }

    @Test
    public void toSortedBagParallelWithComparator() {
        Assert.assertEquals(LARGE_INTERVAL.toSortedBag(Comparator.reverseOrder()), this.bigData.parallelStream().collect(Collectors2.toSortedBag(Comparator.reverseOrder())));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toSortedBag(Comparator.reverseOrder())), this.bigData.parallelStream().collect(Collectors2.toSortedBag(Comparator.reverseOrder())));
    }

    @Test
    public void toImmutableSortedBagWithComparator() {
        Assert.assertEquals(SMALL_INTERVAL.toSortedBag(Comparator.reverseOrder()), this.smallData.stream().collect(Collectors2.toImmutableSortedBag(Comparator.reverseOrder())));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedBag(Comparator.reverseOrder())), this.smallData.stream().collect(Collectors2.toImmutableSortedBag(Comparator.reverseOrder())));
    }

    @Test
    public void toImmutableSortedBagParallelWithComparator() {
        Assert.assertEquals(LARGE_INTERVAL.toSortedBag(Comparator.reverseOrder()), this.bigData.parallelStream().collect(Collectors2.toImmutableSortedBag(Comparator.reverseOrder())));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedBag(Comparator.reverseOrder())), this.bigData.parallelStream().collect(Collectors2.toImmutableSortedBag(Comparator.reverseOrder())));
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(SMALL_INTERVAL.toSortedList(), this.smallData.stream().collect(Collectors2.toSortedList()));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toSortedList()), this.smallData.stream().collect(Collectors2.toSortedList()));
    }

    @Test
    public void toSortedListParallel() {
        Assert.assertEquals(LARGE_INTERVAL.toSortedList(), this.bigData.parallelStream().collect(Collectors2.toSortedList()));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toSortedList()), this.bigData.parallelStream().collect(Collectors2.toSortedList()));
    }

    @Test
    public void toSortedListBy() {
        Assert.assertEquals(SMALL_INTERVAL.toSortedListBy(Object::toString), this.smallData.stream().collect(Collectors2.toSortedListBy(Object::toString)));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toSortedListBy(Object::toString)), this.smallData.stream().collect(Collectors2.toSortedListBy(Object::toString)));
    }

    @Test
    public void toSortedListByParallel() {
        Assert.assertEquals(LARGE_INTERVAL.toSortedListBy(Object::toString), this.bigData.parallelStream().collect(Collectors2.toSortedListBy(Object::toString)));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toSortedListBy(Object::toString)), this.bigData.parallelStream().collect(Collectors2.toSortedListBy(Object::toString)));
    }

    @Test
    public void toImmutableSortedList() {
        Assert.assertEquals(SMALL_INTERVAL.toSortedList(), this.smallData.stream().collect(Collectors2.toImmutableSortedList()));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedList()), this.smallData.stream().collect(Collectors2.toImmutableSortedList()));
    }

    @Test
    public void toImmutableSortedListParallel() {
        Assert.assertEquals(LARGE_INTERVAL.toSortedList(), this.bigData.parallelStream().collect(Collectors2.toImmutableSortedList()));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedList()), this.bigData.parallelStream().collect(Collectors2.toImmutableSortedList()));
    }

    @Test
    public void toSortedListWithComparator() {
        Assert.assertEquals(SMALL_INTERVAL.toSortedList(Comparator.reverseOrder()), this.smallData.stream().collect(Collectors2.toSortedList(Comparator.reverseOrder())));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toSortedList(Comparator.reverseOrder())), this.smallData.stream().collect(Collectors2.toSortedList(Comparator.reverseOrder())));
    }

    @Test
    public void toSortedListParallelWithComparator() {
        Assert.assertEquals(LARGE_INTERVAL.toSortedList(Comparator.reverseOrder()), this.bigData.parallelStream().collect(Collectors2.toSortedList(Comparator.reverseOrder())));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toSortedList(Comparator.reverseOrder())), this.bigData.parallelStream().collect(Collectors2.toSortedList(Comparator.reverseOrder())));
    }

    @Test
    public void toImmutableSortedListWithComparator() {
        Assert.assertEquals(SMALL_INTERVAL.toSortedList(Comparator.reverseOrder()), this.smallData.stream().collect(Collectors2.toImmutableSortedList(Comparator.reverseOrder())));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedList(Comparator.reverseOrder())), this.smallData.stream().collect(Collectors2.toImmutableSortedList(Comparator.reverseOrder())));
    }

    @Test
    public void toImmutableSortedListParallelWithComparator() {
        Assert.assertEquals(LARGE_INTERVAL.toSortedList(Comparator.reverseOrder()), this.bigData.parallelStream().collect(Collectors2.toImmutableSortedList(Comparator.reverseOrder())));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableSortedList(Comparator.reverseOrder())), this.bigData.parallelStream().collect(Collectors2.toImmutableSortedList(Comparator.reverseOrder())));
    }

    @Test
    public void toImmutableListMultimap() {
        Assert.assertEquals(SMALL_INTERVAL.groupBy(Object::toString), this.smallData.stream().collect(Collectors2.toImmutableListMultimap(Object::toString)));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableListMultimap(Object::toString)), this.smallData.stream().collect(Collectors2.toImmutableListMultimap(Object::toString)));
    }

    @Test
    public void toImmutableListMultimapParallel() {
        Assert.assertEquals(LARGE_INTERVAL.groupBy(Object::toString), this.bigData.parallelStream().collect(Collectors2.toImmutableListMultimap(Object::toString)));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableListMultimap(Object::toString)), this.bigData.parallelStream().collect(Collectors2.toImmutableListMultimap(Object::toString)));
    }

    @Test
    public void toImmutableListMultimap2() {
        Assert.assertEquals(SMALL_INTERVAL.collect(Object::toString).groupBy(Object::toString), this.smallData.stream().collect(Collectors2.toImmutableListMultimap(Object::toString, Object::toString)));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableListMultimap(Object::toString, Object::toString)), this.smallData.stream().collect(Collectors2.toImmutableListMultimap(Object::toString, Object::toString)));
    }

    @Test
    public void toImmutableListMultimap2Parallel() {
        Assert.assertEquals(LARGE_INTERVAL.collect(Object::toString).groupBy(Object::toString), this.bigData.parallelStream().collect(Collectors2.toImmutableListMultimap(Object::toString, Object::toString)));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableListMultimap(Object::toString, Object::toString)), this.bigData.parallelStream().collect(Collectors2.toImmutableListMultimap(Object::toString, Object::toString)));
    }

    @Test
    public void toImmutableSetMultimap() {
        Assert.assertEquals(SMALL_INTERVAL.toSet().groupBy(Object::toString), this.smallData.stream().collect(Collectors2.toImmutableSetMultimap(Object::toString)));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableSetMultimap(Object::toString)), this.smallData.stream().collect(Collectors2.toImmutableSetMultimap(Object::toString)));
    }

    @Test
    public void toImmutableSetMultimapParallel() {
        Assert.assertEquals(LARGE_INTERVAL.toSet().groupBy(Object::toString), this.bigData.parallelStream().collect(Collectors2.toImmutableSetMultimap(Object::toString)));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableSetMultimap(Object::toString)), this.bigData.parallelStream().collect(Collectors2.toImmutableSetMultimap(Object::toString)));
    }

    @Test
    public void toImmutableSetMultimap2() {
        Assert.assertEquals(SMALL_INTERVAL.toSet().collect(Object::toString).groupBy(Object::toString), this.smallData.stream().collect(Collectors2.toImmutableSetMultimap(Object::toString, Object::toString)));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableSetMultimap(Object::toString, Object::toString)), this.smallData.stream().collect(Collectors2.toImmutableSetMultimap(Object::toString, Object::toString)));
    }

    @Test
    public void toImmutableSetMultimap2Parallel() {
        Assert.assertEquals(LARGE_INTERVAL.toSet().collect(Object::toString).groupBy(Object::toString), this.bigData.parallelStream().collect(Collectors2.toImmutableSetMultimap(Object::toString, Object::toString)));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableSetMultimap(Object::toString, Object::toString)), this.bigData.parallelStream().collect(Collectors2.toImmutableSetMultimap(Object::toString, Object::toString)));
    }

    @Test
    public void toImmutableBagMultimap() {
        Assert.assertEquals(SMALL_INTERVAL.toBag().groupBy(Object::toString), this.smallData.stream().collect(Collectors2.toImmutableBagMultimap(Object::toString)));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableBagMultimap(Object::toString)), this.smallData.stream().collect(Collectors2.toImmutableBagMultimap(Object::toString)));
    }

    @Test
    public void toImmutableBagMultimapParallel() {
        Assert.assertEquals(LARGE_INTERVAL.toBag().groupBy(Object::toString), this.bigData.parallelStream().collect(Collectors2.toImmutableBagMultimap(Object::toString)));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableBagMultimap(Object::toString)), this.bigData.parallelStream().collect(Collectors2.toImmutableBagMultimap(Object::toString)));
    }

    @Test
    public void toImmutableBagMultimap2() {
        Assert.assertEquals(SMALL_INTERVAL.toBag().collect(Object::toString).groupBy(Object::toString), this.smallData.stream().collect(Collectors2.toImmutableBagMultimap(Object::toString, Object::toString)));
        Assert.assertEquals(SMALL_INTERVAL.reduceInPlace(Collectors2.toImmutableBagMultimap(Object::toString, Object::toString)), this.smallData.stream().collect(Collectors2.toImmutableBagMultimap(Object::toString, Object::toString)));
    }

    @Test
    public void toImmutableBagMultimap2Parallel() {
        Assert.assertEquals(LARGE_INTERVAL.toBag().collect(Object::toString).groupBy(Object::toString), this.bigData.parallelStream().collect(Collectors2.toImmutableBagMultimap(Object::toString, Object::toString)));
        Assert.assertEquals(LARGE_INTERVAL.reduceInPlace(Collectors2.toImmutableBagMultimap(Object::toString, Object::toString)), this.bigData.parallelStream().collect(Collectors2.toImmutableBagMultimap(Object::toString, Object::toString)));
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
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
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
