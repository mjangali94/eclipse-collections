/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.immutable;

import java.util.Collections;
import java.util.List;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.ImmutableMap;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.multimap.MutableMultimap;
import org.eclipse.collections.api.partition.PartitionImmutableCollection;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.block.function.NegativeIntervalFunction;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.math.IntegerSum;
import org.eclipse.collections.impl.math.Sum;
import org.eclipse.collections.impl.math.SumProcedure;
import org.eclipse.collections.impl.multimap.bag.HashBagMultimap;
import org.eclipse.collections.impl.multimap.list.FastListMultimap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iList;
import static org.eclipse.collections.impl.factory.Iterables.iSet;

public abstract class ImmutableMemoryEfficientMapTestCase extends ImmutableMapTestCase {

    protected abstract <K, V> ImmutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4);

    @Test
    public abstract void select();

    @Test
    public abstract void reject();

    @Test
    public abstract void detect();

    @Test
    public void collectValues() {
        ImmutableMap<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three", "4", "Four");
        ImmutableMap<String, String> result = map.collectValues((argument1, argument2) -> new StringBuilder(argument2).reverse().toString());
        switch(map.size()) {
            case 0:
                Verify.assertEmpty(result);
                break;
            case 1:
                Verify.assertContainsKeyValue("1", "enO", result);
                break;
            case 2:
                Verify.assertContainsAllKeyValues(result, "1", "enO", "2", "owT");
                break;
            case 3:
                Verify.assertContainsAllKeyValues(result, "1", "enO", "2", "owT", "3", "eerhT");
                break;
            case 4:
                Verify.assertContainsAllKeyValues(result, "1", "enO", "2", "owT", "3", "eerhT", "4", "ruoF");
                break;
            default:
                Assert.fail();
        }
    }

    @Test
    public void collect() {
        ImmutableMap<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three", "4", "Four");
        ImmutableMap<Integer, String> result = map.collect((Function2<String, String, Pair<Integer, String>>) (argument1, argument2) -> Tuples.pair(Integer.valueOf(argument1), argument1 + ':' + new StringBuilder(argument2).reverse()));
        switch(map.size()) {
            case 0:
                Verify.assertEmpty(result);
                break;
            case 1:
                Verify.assertContainsKeyValue(1, "1:enO", result);
                break;
            case 2:
                Verify.assertContainsAllKeyValues(result, 1, "1:enO", 2, "2:owT");
                break;
            case 3:
                Verify.assertContainsAllKeyValues(result, 1, "1:enO", 2, "2:owT", 3, "3:eerhT");
                break;
            case 4:
                Verify.assertContainsAllKeyValues(result, 1, "1:enO", 2, "2:owT", 3, "3:eerhT", 4, "4:ruoF");
                break;
            default:
                Assert.fail();
        }
    }

    @Test
    public void allSatisfy() {
        ImmutableMap<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three", "4", "Four");
        Assert.assertTrue(map.allSatisfy(String.class::isInstance));
        Assert.assertFalse(map.allSatisfy("Monkey"::equals));
    }

    @Test
    public void anySatisfy() {
        ImmutableMap<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three", "4", "Four");
        Assert.assertTrue(map.anySatisfy(String.class::isInstance));
        Assert.assertFalse(map.anySatisfy("Monkey"::equals));
    }

    @Test
    public void noneSatisfy() {
        ImmutableMap<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three", "4", "Four");
        Assert.assertTrue(map.noneSatisfy(Integer.class::isInstance));
        Assert.assertTrue(map.noneSatisfy("Monkey"::equals));
    }

    @Test
    public void appendString() {
        ImmutableMap<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three", "4", "Four");
        StringBuilder builder1 = new StringBuilder();
        map.appendString(builder1);
        String defaultString = builder1.toString();
        StringBuilder builder2 = new StringBuilder();
        map.appendString(builder2, "|");
        String delimitedString = builder2.toString();
        StringBuilder builder3 = new StringBuilder();
        map.appendString(builder3, "{", "|", "}");
        String wrappedString = builder3.toString();
        switch(map.size()) {
            case 1:
                Assert.assertEquals("One", defaultString);
                Assert.assertEquals("One", delimitedString);
                Assert.assertEquals("{One}", wrappedString);
                break;
            case 2:
                Assert.assertEquals(8, defaultString.length());
                Assert.assertEquals(7, delimitedString.length());
                Verify.assertContains("|", delimitedString);
                Assert.assertEquals(9, wrappedString.length());
                Verify.assertContains("|", wrappedString);
                Assert.assertTrue(wrappedString.startsWith("{"));
                Assert.assertTrue(wrappedString.endsWith("}"));
                break;
            case 3:
                Assert.assertEquals(15, defaultString.length());
                Assert.assertEquals(13, delimitedString.length());
                Verify.assertContains("|", delimitedString);
                Assert.assertEquals(15, wrappedString.length());
                Verify.assertContains("|", wrappedString);
                Assert.assertTrue(wrappedString.startsWith("{"));
                Assert.assertTrue(wrappedString.endsWith("}"));
                break;
            case 4:
                Assert.assertEquals(21, defaultString.length());
                Assert.assertEquals(18, delimitedString.length());
                Verify.assertContains("|", delimitedString);
                Assert.assertEquals(20, wrappedString.length());
                Verify.assertContains("|", wrappedString);
                Assert.assertTrue(wrappedString.startsWith("{"));
                Assert.assertTrue(wrappedString.endsWith("}"));
                break;
            default:
                Assert.assertEquals("", defaultString);
                Assert.assertEquals("", delimitedString);
                Assert.assertEquals("{}", wrappedString);
                break;
        }
    }

    @Test
    public void toBag() {
        ImmutableMap<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three", "4", "Four");
        MutableBag<String> bag = map.toBag();
        switch(map.size()) {
            case 1:
                Verify.assertContains("One", bag);
                break;
            case 2:
                Verify.assertContainsAll(bag, "One", "Two");
                break;
            case 3:
                Verify.assertContainsAll(bag, "One", "Two", "Three");
                break;
            case 4:
                Verify.assertContainsAll(bag, "One", "Two", "Three", "Four");
                break;
            default:
                Verify.assertEmpty(bag);
                break;
        }
    }

    @Test
    public void asLazy() {
        ImmutableMap<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three", "4", "Four");
        LazyIterable<String> lazy = map.asLazy();
        switch(map.size()) {
            case 1:
                Verify.assertContains("One", lazy.toList());
                break;
            case 2:
                Verify.assertContainsAll(lazy.toList(), "One", "Two");
                break;
            case 3:
                Verify.assertContainsAll(lazy.toList(), "One", "Two", "Three");
                break;
            case 4:
                Verify.assertContainsAll(lazy.toList(), "One", "Two", "Three", "Four");
                break;
            default:
                Verify.assertEmpty(lazy.toList());
                break;
        }
    }

    @Test
    public void toList() {
        ImmutableMap<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three", "4", "Four");
        MutableList<String> list = map.toList();
        switch(map.size()) {
            case 1:
                Verify.assertContains("One", list);
                break;
            case 2:
                Verify.assertContainsAll(list, "One", "Two");
                break;
            case 3:
                Verify.assertContainsAll(list, "One", "Two", "Three");
                break;
            case 4:
                Verify.assertContainsAll(list, "One", "Two", "Three", "Four");
                break;
            default:
                Verify.assertEmpty(list);
                break;
        }
    }

    @Test
    public void toMapWithFunction() {
        ImmutableMap<String, String> map = this.newMapWithKeysValues("1", "One", "3", "Three", "4", "Four", "11", "Eleven");
        MutableMap<Integer, String> actual = map.toMap(String::length, String::valueOf);
        switch(map.size()) {
            case 1:
                Assert.assertEquals(UnifiedMap.newWithKeysValues(3, "One"), actual);
                break;
            case 2:
                Assert.assertEquals(UnifiedMap.newWithKeysValues(3, "One", 5, "Three"), actual);
                break;
            case 3:
                Assert.assertEquals(UnifiedMap.newWithKeysValues(3, "One", 5, "Three", 4, "Four"), actual);
                break;
            case 4:
                Assert.assertEquals(UnifiedMap.newWithKeysValues(3, "One", 5, "Three", 4, "Four", 6, "Eleven"), actual);
                break;
            default:
                Verify.assertEmpty(actual);
                break;
        }
    }

    @Test
    public void toSet() {
        ImmutableMap<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three", "4", "Four");
        MutableSet<String> set = map.toSet();
        switch(map.size()) {
            case 1:
                Verify.assertContains("One", set);
                break;
            case 2:
                Verify.assertContainsAll(set, "One", "Two");
                break;
            case 3:
                Verify.assertContainsAll(set, "One", "Two", "Three");
                break;
            case 4:
                Verify.assertContainsAll(set, "One", "Two", "Three", "Four");
                break;
            default:
                Verify.assertEmpty(set);
                break;
        }
    }

    @Test
    public void toSortedList() {
        ImmutableMap<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        MutableList<Integer> sorted = map.toSortedList();
        switch(map.size()) {
            case 1:
                Assert.assertEquals(iList(1), sorted);
                break;
            case 2:
                Assert.assertEquals(iList(1, 2), sorted);
                break;
            case 3:
                Assert.assertEquals(iList(1, 2, 3), sorted);
                break;
            case 4:
                Assert.assertEquals(iList(1, 2, 3, 4), sorted);
                break;
            default:
                Verify.assertEmpty(sorted);
                break;
        }
        MutableList<Integer> reverse = map.toSortedList(Collections.reverseOrder());
        switch(map.size()) {
            case 1:
                Assert.assertEquals(iList(1), reverse);
                break;
            case 2:
                Assert.assertEquals(iList(2, 1), reverse);
                break;
            case 3:
                Assert.assertEquals(iList(3, 2, 1), reverse);
                break;
            case 4:
                Assert.assertEquals(iList(4, 3, 2, 1), reverse);
                break;
            default:
                Verify.assertEmpty(reverse);
                break;
        }
    }

    @Test
    public void toSortedListBy() {
        ImmutableMap<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        MutableList<Integer> list = map.toSortedListBy(String::valueOf);
        switch(map.size()) {
            case 1:
                Assert.assertEquals(iList(1), list);
                break;
            case 2:
                Assert.assertEquals(iList(1, 2), list);
                break;
            case 3:
                Assert.assertEquals(iList(1, 2, 3), list);
                break;
            case 4:
                Assert.assertEquals(iList(1, 2, 3, 4), list);
                break;
            default:
                Verify.assertEmpty(list);
                break;
        }
    }

    @Test
    public void chunk() {
        ImmutableMap<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three", "4", "Four");
        RichIterable<RichIterable<String>> chunks = map.chunk(2).toList();
        RichIterable<Integer> sizes = chunks.collect(RichIterable::size);
        switch(map.size()) {
            case 1:
                Assert.assertEquals(iList(1), sizes);
                break;
            case 2:
                Assert.assertEquals(iList(2), sizes);
                break;
            case 3:
                Assert.assertEquals(iList(2, 1), sizes);
                break;
            case 4:
                Assert.assertEquals(iList(2, 2), sizes);
                break;
            default:
                Assert.assertEquals(0, chunks.size());
                break;
        }
    }

    @Test
    public void collect_value() {
        ImmutableMap<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        MutableSet<String> collect = map.collect(Functions.getToString()).toSet();
        UnifiedSet<String> collectToTarget = map.collect(String::valueOf, UnifiedSet.newSet());
        switch(map.size()) {
            case 1:
                Verify.assertContainsAll(collect, "1");
                Verify.assertContainsAll(collectToTarget, "1");
                break;
            case 2:
                Verify.assertContainsAll(collect, "1", "2");
                Verify.assertContainsAll(collectToTarget, "1", "2");
                break;
            case 3:
                Verify.assertContainsAll(collect, "1", "2", "3");
                Verify.assertContainsAll(collectToTarget, "1", "2", "3");
                break;
            case 4:
                Verify.assertContainsAll(collect, "1", "2", "3", "4");
                Verify.assertContainsAll(collectToTarget, "1", "2", "3", "4");
                break;
            default:
                Verify.assertEmpty(collect);
                break;
        }
    }

    @Test
    public void collectIf() {
        ImmutableMap<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        MutableSet<String> collect = map.collectIf(Integer.class::isInstance, String::valueOf).toSet();
        UnifiedSet<String> collectToTarget = map.collectIf(Integer.class::isInstance, String::valueOf, UnifiedSet.newSet());
        switch(map.size()) {
            case 1:
                Verify.assertContainsAll(collect, "1");
                Verify.assertContainsAll(collectToTarget, "1");
                break;
            case 2:
                Verify.assertContainsAll(collect, "1", "2");
                Verify.assertContainsAll(collectToTarget, "1", "2");
                break;
            case 3:
                Verify.assertContainsAll(collect, "1", "2", "3");
                Verify.assertContainsAll(collectToTarget, "1", "2", "3");
                break;
            case 4:
                Verify.assertContainsAll(collect, "1", "2", "3", "4");
                Verify.assertContainsAll(collectToTarget, "1", "2", "3", "4");
                break;
            default:
                Verify.assertEmpty(collect);
                break;
        }
    }

    @Test
    public void collectWith() {
        ImmutableMap<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        MutableBag<Integer> collectWith = map.collectWith(AddFunction.INTEGER, 1, HashBag.newBag());
        switch(map.size()) {
            case 1:
                Assert.assertEquals(Bags.mutable.of(2), collectWith);
                break;
            case 2:
                Assert.assertEquals(Bags.mutable.of(2, 3), collectWith);
                break;
            case 3:
                Assert.assertEquals(Bags.mutable.of(2, 3, 4), collectWith);
                break;
            case 4:
                Assert.assertEquals(Bags.mutable.of(2, 3, 4, 5), collectWith);
                break;
            default:
                Verify.assertEmpty(collectWith);
                break;
        }
    }

    @Test
    public void contains() {
        ImmutableMap<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three", "4", "Four");
        switch(map.size()) {
            case 1:
                Assert.assertTrue(map.contains("One"));
                Assert.assertFalse(map.contains("Two"));
                break;
            case 2:
                Assert.assertTrue(map.contains("Two"));
                Assert.assertFalse(map.contains("Three"));
                break;
            case 3:
                Assert.assertTrue(map.contains("Three"));
                Assert.assertFalse(map.contains("Four"));
                break;
            case 4:
                Assert.assertTrue(map.contains("Four"));
                Assert.assertFalse(map.contains("Five"));
                break;
            default:
                Verify.assertEmpty(map);
                break;
        }
    }

    @Test
    public void getFirst() {
        ImmutableMap<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three", "4", "Four");
        if (map.isEmpty()) {
            String value = map.getFirst();
            Assert.assertNull(value);
        } else {
            String value = map.getFirst();
            Assert.assertNotNull(value);
            Verify.assertContains(value, UnifiedSet.newSetWith("One", "Two", "Three", "Four"));
        }
    }

    @Test
    public void getLast() {
        ImmutableMap<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three", "4", "Four");
        if (map.isEmpty()) {
            String value = map.getLast();
            Assert.assertNull(value);
        } else {
            String value = map.getLast();
            Assert.assertNotNull(value);
            Verify.assertContains(value, UnifiedSet.newSetWith("One", "Two", "Three", "Four"));
        }
    }

    @Test
    public void containsAllIterable() {
        ImmutableMap<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three", "4", "Four");
        switch(map.size()) {
            case 1:
                Assert.assertTrue(map.containsAllIterable(iList("One")));
                break;
            case 2:
                Assert.assertTrue(map.containsAllIterable(iList("One", "Two")));
                break;
            case 3:
                Assert.assertTrue(map.containsAllIterable(iList("One", "Two", "Three")));
                break;
            case 4:
                Assert.assertTrue(map.containsAllIterable(iList("One", "Two", "Three", "Four")));
                break;
            default:
                Verify.assertEmpty(map);
                break;
        }
    }

    @Test
    public void containsAllArguments() {
        ImmutableMap<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three", "4", "Four");
        switch(map.size()) {
            case 1:
                Assert.assertTrue(map.containsAllArguments("One"));
                break;
            case 2:
                Assert.assertTrue(map.containsAllArguments("One", "Two"));
                break;
            case 3:
                Assert.assertTrue(map.containsAllArguments("One", "Two", "Three"));
                break;
            case 4:
                Assert.assertTrue(map.containsAllArguments("One", "Two", "Three", "Four"));
                break;
            default:
                Verify.assertEmpty(map);
                break;
        }
    }

    @Test
    public void count() {
        ImmutableMap<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three", "4", "Four");
        int actual = map.count(Predicates.or("One"::equals, "Three"::equals));
        switch(map.size()) {
            case 1:
                Assert.assertEquals(1, actual);
                break;
            case 2:
                Assert.assertEquals(1, actual);
                break;
            case 3:
                Assert.assertEquals(2, actual);
                break;
            case 4:
                Assert.assertEquals(2, actual);
                break;
            default:
                Assert.assertEquals(0, actual);
                break;
        }
    }

    @Test
    public void detect_value() {
        ImmutableMap<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three", "4", "Four");
        if (map.isEmpty()) {
            String resultNotFound = map.detect(ignored -> true);
            Assert.assertNull(resultNotFound);
        } else {
            String resultFound = map.detect("One"::equals);
            Assert.assertEquals("One", resultFound);
            String resultNotFound = map.detect("Five"::equals);
            Assert.assertNull(resultNotFound);
        }
    }

    @Test
    public void detectIfNone_value() {
        ImmutableMap<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three", "4", "Four");
        if (map.isEmpty()) {
            String resultNotFound = map.detectIfNone(ignored -> true, () -> "Zero");
            Assert.assertEquals("Zero", resultNotFound);
        } else {
            String resultNotFound = map.detectIfNone("Five"::equals, () -> "Zero");
            Assert.assertEquals("Zero", resultNotFound);
            String resultFound = map.detectIfNone("One"::equals, () -> "Zero");
            Assert.assertEquals("One", resultFound);
        }
    }

    @Test
    public void flatCollect() {
        ImmutableMap<Integer, Integer> map = this.newMapWithKeysValues(1, 1, 2, 2, 3, 3, 4, 4);
        if (map.isEmpty()) {
            Function<Integer, Iterable<Object>> fail = each -> {
                throw new AssertionError();
            };
            Assert.assertEquals(Bags.immutable.empty(), map.flatCollect(fail));
            Assert.assertEquals(Bags.immutable.empty(), map.flatCollect(fail, HashBag.newBag()));
        } else {
            MutableBag<Integer> expected = Interval.oneTo(map.size()).flatCollect(Interval::oneTo).toBag();
            Assert.assertEquals(expected, map.flatCollect(Interval::oneTo));
            Assert.assertEquals(expected, map.flatCollect(Interval::oneTo, HashBag.newBag()));
        }
    }

    @Test
    public void groupBy() {
        ImmutableMap<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        Function<Integer, Boolean> isOddFunction = object -> IntegerPredicates.isOdd().accept(object);
        Multimap<Boolean, Integer> expected;
        switch(map.size()) {
            case 1:
                expected = FastListMultimap.newMultimap(Tuples.pair(Boolean.TRUE, 1));
                break;
            case 2:
                expected = FastListMultimap.newMultimap(Tuples.pair(Boolean.TRUE, 1), Tuples.pair(Boolean.FALSE, 2));
                break;
            case 3:
                expected = FastListMultimap.newMultimap(Tuples.pair(Boolean.TRUE, 1), Tuples.pair(Boolean.TRUE, 3), Tuples.pair(Boolean.FALSE, 2));
                break;
            case 4:
                expected = FastListMultimap.newMultimap(Tuples.pair(Boolean.TRUE, 1), Tuples.pair(Boolean.TRUE, 3), Tuples.pair(Boolean.FALSE, 2), Tuples.pair(Boolean.FALSE, 4));
                break;
            default:
                expected = FastListMultimap.newMultimap();
                break;
        }
        Multimap<Boolean, Integer> actual = map.groupBy(isOddFunction);
        Assert.assertEquals(HashBagMultimap.newMultimap(expected), HashBagMultimap.newMultimap(actual));
        Multimap<Boolean, Integer> actualFromTarget = map.groupBy(isOddFunction, FastListMultimap.newMultimap());
        Assert.assertEquals(HashBagMultimap.newMultimap(expected), HashBagMultimap.newMultimap(actualFromTarget));
    }

    @Test
    public void groupByEach() {
        ImmutableMap<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        MutableMultimap<Integer, Integer> expected = FastListMultimap.newMultimap();
        for (int i = 1; i < map.size(); i++) {
            expected.putAll(-i, Interval.fromTo(i, map.size()));
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
    public void injectInto() {
        ImmutableMap<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        Integer expectedInteger;
        IntegerSum expectedSum;
        switch(map.size()) {
            case 1:
                expectedSum = new IntegerSum(1);
                expectedInteger = Integer.valueOf(1);
                break;
            case 2:
                expectedSum = new IntegerSum(3);
                expectedInteger = Integer.valueOf(3);
                break;
            case 3:
                expectedSum = new IntegerSum(6);
                expectedInteger = Integer.valueOf(6);
                break;
            case 4:
                expectedSum = new IntegerSum(10);
                expectedInteger = Integer.valueOf(10);
                break;
            default:
                expectedSum = new IntegerSum(0);
                expectedInteger = Integer.valueOf(0);
                break;
        }
        Integer actual = map.injectInto(0, AddFunction.INTEGER);
        Assert.assertEquals(expectedInteger, actual);
        Sum sum = map.injectInto(new IntegerSum(0), SumProcedure.number());
        Assert.assertEquals(expectedSum, sum);
    }

    @Test
    public void makeString() {
        ImmutableMap<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three", "4", "Four");
        String defaultString = map.makeString();
        String delimitedString = map.makeString("|");
        String wrappedString = map.makeString("{", "|", "}");
        switch(map.size()) {
            case 1:
                Assert.assertEquals("One", defaultString);
                Assert.assertEquals("One", delimitedString);
                Assert.assertEquals("{One}", wrappedString);
                break;
            case 2:
                Assert.assertEquals(8, defaultString.length());
                Assert.assertEquals(7, delimitedString.length());
                Verify.assertContains("|", delimitedString);
                Assert.assertEquals(9, wrappedString.length());
                Verify.assertContains("|", wrappedString);
                Assert.assertTrue(wrappedString.startsWith("{"));
                Assert.assertTrue(wrappedString.endsWith("}"));
                break;
            case 3:
                Assert.assertEquals(15, defaultString.length());
                Assert.assertEquals(13, delimitedString.length());
                Verify.assertContains("|", delimitedString);
                Assert.assertEquals(15, wrappedString.length());
                Verify.assertContains("|", wrappedString);
                Assert.assertTrue(wrappedString.startsWith("{"));
                Assert.assertTrue(wrappedString.endsWith("}"));
                break;
            case 4:
                Assert.assertEquals(21, defaultString.length());
                Assert.assertEquals(18, delimitedString.length());
                Verify.assertContains("|", delimitedString);
                Assert.assertEquals(20, wrappedString.length());
                Verify.assertContains("|", wrappedString);
                Assert.assertTrue(wrappedString.startsWith("{"));
                Assert.assertTrue(wrappedString.endsWith("}"));
                break;
            default:
                Assert.assertEquals("", defaultString);
                Assert.assertEquals("", delimitedString);
                Assert.assertEquals("{}", wrappedString);
                break;
        }
    }

    @Test
    public void min() {
        ImmutableMap<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        Assert.assertEquals(Integer.valueOf(1), map.min());
        Assert.assertEquals(Integer.valueOf(1), map.min(Integer::compareTo));
    }

    @Test
    public void max() {
        ImmutableMap<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        Integer max;
        switch(map.size()) {
            case 1:
                max = Integer.valueOf(1);
                break;
            case 2:
                max = Integer.valueOf(2);
                break;
            case 3:
                max = Integer.valueOf(3);
                break;
            case 4:
                max = Integer.valueOf(4);
                break;
            default:
                max = Integer.valueOf(0);
                break;
        }
        Assert.assertEquals(max, map.max());
        Assert.assertEquals(max, map.max(Integer::compareTo));
    }

    @Test
    public void minBy() {
        ImmutableMap<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        Assert.assertEquals(Integer.valueOf(1), map.minBy(String::valueOf));
    }

    @Test
    public void maxBy() {
        ImmutableMap<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        Assert.assertEquals(Integer.valueOf(map.size()), map.maxBy(String::valueOf));
        Verify.assertContains(Integer.valueOf(map.size()), iList(1, 2, 3, 4));
    }

    @Test
    public void reject_value() {
        ImmutableMap<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        MutableSet<Integer> rejected = map.reject(IntegerPredicates.isEven()).toSet();
        UnifiedSet<Integer> rejectedIntoTarget = map.reject(IntegerPredicates.isEven(), UnifiedSet.newSet());
        ImmutableSet<Integer> expected = this.expectReject(map.size());
        Assert.assertEquals(expected, rejected);
        Assert.assertEquals(expected, rejectedIntoTarget);
    }

    private ImmutableSet<Integer> expectReject(int size) {
        switch(size) {
            case 0:
                return iSet();
            case 1:
            case 2:
                return iSet(1);
            case 3:
            case 4:
                return iSet(1, 3);
            default:
                throw new AssertionError();
        }
    }

    @Test
    public void rejectWith_value() {
        ImmutableMap<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        switch(map.size()) {
            case 1:
                Verify.assertEmpty(map.rejectWith(Predicates2.lessThan(), 2, UnifiedSet.newSet()));
                break;
            case 2:
                Verify.assertContainsAll(map.rejectWith(Predicates2.lessThan(), 2, UnifiedSet.newSet()), 2);
                break;
            case 3:
                Verify.assertContainsAll(map.rejectWith(Predicates2.lessThan(), 2, UnifiedSet.newSet()), 2, 3);
                break;
            case 4:
                Verify.assertContainsAll(map.rejectWith(Predicates2.lessThan(), 2, UnifiedSet.newSet()), 2, 3, 4);
                break;
            default:
                Verify.assertEmpty(map);
                break;
        }
    }

    @Test
    public void select_value() {
        ImmutableMap<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        ImmutableSet<Integer> expected = this.expectSelect(map.size());
        Assert.assertEquals(expected, map.select(IntegerPredicates.isEven()).toSet());
        Assert.assertEquals(expected, map.select(IntegerPredicates.isEven(), UnifiedSet.newSet()));
    }

    private ImmutableSet<Integer> expectSelect(int size) {
        switch(size) {
            case 0:
            case 1:
                return iSet();
            case 2:
            case 3:
                return iSet(2);
            case 4:
                return iSet(2, 4);
            default:
                throw new AssertionError();
        }
    }

    @Test
    public void selectWith_value() {
        ImmutableMap<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        switch(map.size()) {
            case 1:
                Verify.assertContainsAll(map.selectWith(Predicates2.lessThan(), 3, UnifiedSet.newSet()), 1);
                break;
            case 2:
            case 3:
            case 4:
                Verify.assertContainsAll(map.selectWith(Predicates2.lessThan(), 3, UnifiedSet.newSet()), 1, 2);
                break;
            default:
                Verify.assertEmpty(map);
                break;
        }
    }

    @Test
    public void partition_value() {
        ImmutableMap<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        PartitionImmutableCollection<Integer> partition = map.partition(IntegerPredicates.isEven());
        Assert.assertEquals(this.expectSelect(map.size()), partition.getSelected().toSet());
        Assert.assertEquals(this.expectReject(map.size()), partition.getRejected().toSet());
    }

    @Test
    public void partitionWith_value() {
        ImmutableMap<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        PartitionImmutableCollection<Integer> partition = map.partitionWith(Predicates2.in(), map.select(IntegerPredicates.isEven()));
        Assert.assertEquals(this.expectSelect(map.size()), partition.getSelected().toSet());
        Assert.assertEquals(this.expectReject(map.size()), partition.getRejected().toSet());
    }

    @Test
    public void toArray() {
        ImmutableMap<String, Integer> map = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4);
        Object[] array = map.toArray();
        Verify.assertSize(map.size(), array);
        Integer[] array2 = map.toArray(new Integer[0]);
        Verify.assertSize(map.size(), array2);
        Integer[] array3 = map.toArray(new Integer[map.size()]);
        Verify.assertSize(map.size(), array3);
        if (map.size() > 1) {
            Integer[] array4 = map.toArray(new Integer[map.size() - 1]);
            Verify.assertSize(map.size(), array4);
        }
        Integer[] array5 = map.toArray(new Integer[6]);
        Verify.assertSize(6, array5);
    }

    @Test
    public void zip() {
        ImmutableMap<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three", "4", "Four");
        List<Object> nulls = Collections.nCopies(map.size(), null);
        List<Object> nullsPlusOne = Collections.nCopies(map.size() + 1, null);
        RichIterable<Pair<String, Object>> pairs = map.zip(nulls);
        Assert.assertEquals(map.toSet(), pairs.collect((Function<Pair<String, ?>, String>) Pair::getOne).toSet());
        Assert.assertEquals(nulls, pairs.collect((Function<Pair<?, Object>, Object>) Pair::getTwo, Lists.mutable.of()));
        RichIterable<Pair<String, Object>> pairsPlusOne = map.zip(nullsPlusOne);
        Assert.assertEquals(map.toSet(), pairsPlusOne.collect((Function<Pair<String, ?>, String>) Pair::getOne).toSet());
        Assert.assertEquals(nulls, pairsPlusOne.collect((Function<Pair<?, Object>, Object>) Pair::getTwo, Lists.mutable.of()));
        if (map.notEmpty()) {
            List<Object> nullsMinusOne = Collections.nCopies(map.size() - 1, null);
            RichIterable<Pair<String, Object>> pairsMinusOne = map.zip(nullsMinusOne);
            Assert.assertEquals(map.size() - 1, pairsMinusOne.size());
        }
        Assert.assertEquals(map.zip(nulls).toSet(), map.zip(nulls, UnifiedSet.newSet()));
    }

    @Test
    public void zipWithIndex() {
        ImmutableMap<String, String> map = this.newMapWithKeysValues("1", "One", "2", "Two", "3", "Three", "4", "Four");
        RichIterable<Pair<String, Integer>> pairs = map.zipWithIndex();
        Assert.assertEquals(map.toSet(), pairs.collect((Function<Pair<String, ?>, String>) Pair::getOne).toSet());
        if (map.notEmpty()) {
            Assert.assertEquals(Interval.zeroTo(map.size() - 1).toSet(), pairs.collect((Function<Pair<?, Integer>, Integer>) Pair::getTwo, UnifiedSet.newSet()));
        }
        Assert.assertEquals(map.zipWithIndex().toSet(), map.zipWithIndex(UnifiedSet.newSet()));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableMemoryEfficientMapTestCase instance;

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
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
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
        public void benchmark_ifPresentApply() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ifPresentApply);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
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
        public void benchmark_keyValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyValuesView);
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
        public void benchmark_newWithKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithMap1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithMap1);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithMapTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithMapTargetEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithMapEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithMapEmptyAndTargetEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapNull);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithMapIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithMapIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithMapIterableTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithMapIterableTargetEmpty);
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
        public void benchmark_newWithAllKeyValuePairs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAllKeyValuePairs);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAllKeyValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutKeys);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_castToMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.castToMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
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
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapWithFunction() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapWithFunction);
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
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
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
        public void benchmark_detect_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
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
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new ImmutableMemoryEfficientMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> iteratorThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> newWithMap1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> newWithMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> newWithMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> newWithMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> newWithMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> newWithAllKeyValuePairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> newWithAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> newWithoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> newWithoutKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> castToMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> entrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> toMapWithFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMemoryEfficientMapTestCase> zipWithIndex;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.equalsAndHashCode = ImmutableMemoryEfficientMapTestCase::equalsAndHashCode;
            this.payloads.forEachKeyValue = ImmutableMemoryEfficientMapTestCase::forEachKeyValue;
            this.payloads.forEachValue = ImmutableMemoryEfficientMapTestCase::forEachValue;
            this.payloads.tap = ImmutableMemoryEfficientMapTestCase::tap;
            this.payloads.forEach = ImmutableMemoryEfficientMapTestCase::forEach;
            this.payloads.flipUniqueValues = ImmutableMemoryEfficientMapTestCase::flipUniqueValues;
            this.payloads.iterator = ImmutableMemoryEfficientMapTestCase::iterator;
            this.payloads.iteratorThrows = ImmutableMemoryEfficientMapTestCase::iteratorThrows;
            this.payloads.forEachKey = ImmutableMemoryEfficientMapTestCase::forEachKey;
            this.payloads.get = ImmutableMemoryEfficientMapTestCase::get;
            this.payloads.getIfAbsent_function = ImmutableMemoryEfficientMapTestCase::getIfAbsent_function;
            this.payloads.getOrDefault = ImmutableMemoryEfficientMapTestCase::getOrDefault;
            this.payloads.getIfAbsent = ImmutableMemoryEfficientMapTestCase::getIfAbsent;
            this.payloads.getIfAbsentWith = ImmutableMemoryEfficientMapTestCase::getIfAbsentWith;
            this.payloads.ifPresentApply = ImmutableMemoryEfficientMapTestCase::ifPresentApply;
            this.payloads.notEmpty = ImmutableMemoryEfficientMapTestCase::notEmpty;
            this.payloads.forEachWith = ImmutableMemoryEfficientMapTestCase::forEachWith;
            this.payloads.forEachWithIndex = ImmutableMemoryEfficientMapTestCase::forEachWithIndex;
            this.payloads.keyValuesView = ImmutableMemoryEfficientMapTestCase::keyValuesView;
            this.payloads.valuesView = ImmutableMemoryEfficientMapTestCase::valuesView;
            this.payloads.keysView = ImmutableMemoryEfficientMapTestCase::keysView;
            this.payloads.putAll = ImmutableMemoryEfficientMapTestCase::putAll;
            this.payloads.clear = ImmutableMemoryEfficientMapTestCase::clear;
            this.payloads.put = ImmutableMemoryEfficientMapTestCase::put;
            this.payloads.remove = ImmutableMemoryEfficientMapTestCase::remove;
            this.payloads.testToString = ImmutableMemoryEfficientMapTestCase::testToString;
            this.payloads.newWithKeyValue = ImmutableMemoryEfficientMapTestCase::newWithKeyValue;
            this.payloads.newWithMap1 = ImmutableMemoryEfficientMapTestCase::newWithMap1;
            this.payloads.newWithMapTargetEmpty = ImmutableMemoryEfficientMapTestCase::newWithMapTargetEmpty;
            this.payloads.newWithMapEmptyAndTargetEmpty = ImmutableMemoryEfficientMapTestCase::newWithMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = ImmutableMemoryEfficientMapTestCase::withMapNull;
            this.payloads.newWithMapIterable = ImmutableMemoryEfficientMapTestCase::newWithMapIterable;
            this.payloads.newWithMapIterableTargetEmpty = ImmutableMemoryEfficientMapTestCase::newWithMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = ImmutableMemoryEfficientMapTestCase::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = ImmutableMemoryEfficientMapTestCase::withMapIterableNull;
            this.payloads.newWithAllKeyValuePairs = ImmutableMemoryEfficientMapTestCase::newWithAllKeyValuePairs;
            this.payloads.newWithAllKeyValues = ImmutableMemoryEfficientMapTestCase::newWithAllKeyValues;
            this.payloads.newWithoutKey = ImmutableMemoryEfficientMapTestCase::newWithoutKey;
            this.payloads.newWithoutKeys = ImmutableMemoryEfficientMapTestCase::newWithoutKeys;
            this.payloads.castToMap = ImmutableMemoryEfficientMapTestCase::castToMap;
            this.payloads.toMap = ImmutableMemoryEfficientMapTestCase::toMap;
            this.payloads.entrySet = ImmutableMemoryEfficientMapTestCase::entrySet;
            this.payloads.select = ImmutableMemoryEfficientMapTestCase::select;
            this.payloads.reject = ImmutableMemoryEfficientMapTestCase::reject;
            this.payloads.detect = ImmutableMemoryEfficientMapTestCase::detect;
            this.payloads.collectValues = ImmutableMemoryEfficientMapTestCase::collectValues;
            this.payloads.collect = ImmutableMemoryEfficientMapTestCase::collect;
            this.payloads.allSatisfy = ImmutableMemoryEfficientMapTestCase::allSatisfy;
            this.payloads.anySatisfy = ImmutableMemoryEfficientMapTestCase::anySatisfy;
            this.payloads.noneSatisfy = ImmutableMemoryEfficientMapTestCase::noneSatisfy;
            this.payloads.appendString = ImmutableMemoryEfficientMapTestCase::appendString;
            this.payloads.toBag = ImmutableMemoryEfficientMapTestCase::toBag;
            this.payloads.asLazy = ImmutableMemoryEfficientMapTestCase::asLazy;
            this.payloads.toList = ImmutableMemoryEfficientMapTestCase::toList;
            this.payloads.toMapWithFunction = ImmutableMemoryEfficientMapTestCase::toMapWithFunction;
            this.payloads.toSet = ImmutableMemoryEfficientMapTestCase::toSet;
            this.payloads.toSortedList = ImmutableMemoryEfficientMapTestCase::toSortedList;
            this.payloads.toSortedListBy = ImmutableMemoryEfficientMapTestCase::toSortedListBy;
            this.payloads.chunk = ImmutableMemoryEfficientMapTestCase::chunk;
            this.payloads.collect_value = ImmutableMemoryEfficientMapTestCase::collect_value;
            this.payloads.collectIf = ImmutableMemoryEfficientMapTestCase::collectIf;
            this.payloads.collectWith = ImmutableMemoryEfficientMapTestCase::collectWith;
            this.payloads.contains = ImmutableMemoryEfficientMapTestCase::contains;
            this.payloads.getFirst = ImmutableMemoryEfficientMapTestCase::getFirst;
            this.payloads.getLast = ImmutableMemoryEfficientMapTestCase::getLast;
            this.payloads.containsAllIterable = ImmutableMemoryEfficientMapTestCase::containsAllIterable;
            this.payloads.containsAllArguments = ImmutableMemoryEfficientMapTestCase::containsAllArguments;
            this.payloads.count = ImmutableMemoryEfficientMapTestCase::count;
            this.payloads.detect_value = ImmutableMemoryEfficientMapTestCase::detect_value;
            this.payloads.detectIfNone_value = ImmutableMemoryEfficientMapTestCase::detectIfNone_value;
            this.payloads.flatCollect = ImmutableMemoryEfficientMapTestCase::flatCollect;
            this.payloads.groupBy = ImmutableMemoryEfficientMapTestCase::groupBy;
            this.payloads.groupByEach = ImmutableMemoryEfficientMapTestCase::groupByEach;
            this.payloads.injectInto = ImmutableMemoryEfficientMapTestCase::injectInto;
            this.payloads.makeString = ImmutableMemoryEfficientMapTestCase::makeString;
            this.payloads.min = ImmutableMemoryEfficientMapTestCase::min;
            this.payloads.max = ImmutableMemoryEfficientMapTestCase::max;
            this.payloads.minBy = ImmutableMemoryEfficientMapTestCase::minBy;
            this.payloads.maxBy = ImmutableMemoryEfficientMapTestCase::maxBy;
            this.payloads.reject_value = ImmutableMemoryEfficientMapTestCase::reject_value;
            this.payloads.rejectWith_value = ImmutableMemoryEfficientMapTestCase::rejectWith_value;
            this.payloads.select_value = ImmutableMemoryEfficientMapTestCase::select_value;
            this.payloads.selectWith_value = ImmutableMemoryEfficientMapTestCase::selectWith_value;
            this.payloads.partition_value = ImmutableMemoryEfficientMapTestCase::partition_value;
            this.payloads.partitionWith_value = ImmutableMemoryEfficientMapTestCase::partitionWith_value;
            this.payloads.toArray = ImmutableMemoryEfficientMapTestCase::toArray;
            this.payloads.zip = ImmutableMemoryEfficientMapTestCase::zip;
            this.payloads.zipWithIndex = ImmutableMemoryEfficientMapTestCase::zipWithIndex;
        }
    }
}
