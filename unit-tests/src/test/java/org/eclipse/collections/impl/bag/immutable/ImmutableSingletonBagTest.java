/*
 * Copyright (c) 2017 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.immutable;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bag.primitive.ImmutableBooleanBag;
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.multimap.bag.ImmutableBagMultimap;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;
import org.eclipse.collections.impl.bag.mutable.primitive.BooleanHashBag;
import org.eclipse.collections.impl.bag.sorted.mutable.TreeBag;
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.multimap.bag.HashBagMultimap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iBag;

public class ImmutableSingletonBagTest extends ImmutableBagTestCase {

    private static final String VAL = "1";

    private static final String NOT_VAL = "2";

    @Override
    protected ImmutableBag<String> newBag() {
        return new ImmutableSingletonBag<>(VAL);
    }

    private ImmutableBag<String> newBagWithNull() {
        return new ImmutableSingletonBag<>(null);
    }

    @Override
    protected int numKeys() {
        return 1;
    }

    @Override
    public void toStringOfItemToCount() {
        Assert.assertEquals("{1=1}", new ImmutableSingletonBag<>(VAL).toStringOfItemToCount());
    }

    @Override
    @Test
    public void selectDuplicates() {
        Assert.assertEquals(Bags.immutable.empty(), this.newBag().selectDuplicates());
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        ImmutableSingletonBag<Integer> immutable = new ImmutableSingletonBag<>(1);
        Bag<Integer> mutable = Bags.mutable.of(1);
        Verify.assertEqualsAndHashCode(immutable, mutable);
        Assert.assertNotEquals(immutable, FastList.newList(mutable));
        Assert.assertNotEquals(immutable, Bags.mutable.of(1, 1));
        Verify.assertEqualsAndHashCode(UnifiedMap.newWithKeysValues(1, 1), immutable.toMapOfItemToCount());
    }

    @Override
    @Test
    public void anySatisfyWithOccurrences() {
        ImmutableBag<String> bag = this.newBag();
        Assert.assertTrue(bag.anySatisfyWithOccurrences((object, value) -> object.equals(VAL)));
        Assert.assertTrue(bag.anySatisfyWithOccurrences((object, value) -> object.equals(VAL) && value == 1));
        Assert.assertFalse(bag.anySatisfyWithOccurrences((object, value) -> object.equals(VAL) && value == 10));
        Assert.assertFalse(bag.anySatisfyWithOccurrences((object, value) -> object.equals(NOT_VAL) && value == 10));
        Assert.assertFalse(bag.anySatisfyWithOccurrences((object, value) -> object.equals(NOT_VAL)));
    }

    @Override
    @Test
    public void allSatisfyWithOccurrences() {
        ImmutableBag<String> bag = this.newBag();
        Assert.assertTrue(bag.allSatisfyWithOccurrences((object, value) -> object.equals(VAL)));
        Assert.assertTrue(bag.allSatisfyWithOccurrences((object, value) -> object.equals(VAL) && value == 1));
        Assert.assertFalse(bag.allSatisfyWithOccurrences((object, value) -> object.equals(VAL) && value == 10));
        Assert.assertFalse(bag.allSatisfyWithOccurrences((object, value) -> object.equals(NOT_VAL) && value == 10));
        Assert.assertFalse(bag.allSatisfyWithOccurrences((object, value) -> object.equals(NOT_VAL)));
    }

    @Override
    @Test
    public void noneSatisfyWithOccurrences() {
        ImmutableBag<String> bag = this.newBag();
        Assert.assertFalse(bag.noneSatisfyWithOccurrences((object, value) -> object.equals(VAL)));
        Assert.assertFalse(bag.noneSatisfyWithOccurrences((object, value) -> object.equals(VAL) && value == 1));
        Assert.assertTrue(bag.noneSatisfyWithOccurrences((object, value) -> object.equals(NOT_VAL)));
        Assert.assertTrue(bag.noneSatisfyWithOccurrences((object, value) -> object.equals(NOT_VAL) && value == 1));
    }

    @Override
    @Test
    public void detectWithOccurrences() {
        ImmutableBag<String> bag = this.newBag();
        Assert.assertEquals(VAL, bag.detectWithOccurrences((object, value) -> object.equals(VAL)));
        Assert.assertEquals(VAL, bag.detectWithOccurrences((object, value) -> object.equals(VAL) && value == 1));
        Assert.assertNull(bag.detectWithOccurrences((object, value) -> object.equals(NOT_VAL)));
        Assert.assertNull(bag.detectWithOccurrences((object, value) -> object.equals(NOT_VAL) && value == 1));
    }

    @Override
    @Test
    public void allSatisfy() {
        super.allSatisfy();
        Assert.assertTrue(this.newBag().allSatisfy(ignored -> true));
        Assert.assertFalse(this.newBag().allSatisfy(ignored -> false));
    }

    @Override
    @Test
    public void noneSatisfy() {
        super.noneSatisfy();
        Assert.assertFalse(this.newBag().noneSatisfy(ignored -> true));
        Assert.assertTrue(this.newBag().noneSatisfy(ignored -> false));
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        Assert.assertEquals(1, new ImmutableSingletonBag<>(1).injectInto(0, AddFunction.INTEGER).intValue());
    }

    @Override
    @Test
    public void toList() {
        super.toList();
        Assert.assertEquals(FastList.newListWith(VAL), this.newBag().toList());
    }

    @Override
    @Test
    public void toSortedList() {
        super.toSortedList();
        Assert.assertEquals(FastList.newListWith(VAL), this.newBag().toSortedList());
    }

    @Test
    public void toSortedListWithComparator() {
        Assert.assertEquals(FastList.newListWith(VAL), this.newBag().toSortedList(null));
    }

    @Override
    @Test
    public void toSet() {
        super.toSet();
        Assert.assertEquals(UnifiedSet.newSetWith(VAL), this.newBag().toSet());
    }

    @Override
    @Test
    public void toBag() {
        super.toBag();
        Assert.assertEquals(Bags.mutable.of(VAL), this.newBag().toBag());
    }

    @Override
    @Test
    public void toMap() {
        super.toMap();
        Assert.assertEquals(Maps.fixedSize.of(String.class, VAL), this.newBag().toMap(Object::getClass, String::valueOf));
    }

    @Test
    public void toArrayGivenArray() {
        Assert.assertArrayEquals(new String[] { VAL }, this.newBag().toArray(new String[1]));
        Assert.assertArrayEquals(new String[] { VAL }, this.newBag().toArray(new String[0]));
        Assert.assertArrayEquals(new String[] { VAL, null }, this.newBag().toArray(new String[2]));
    }

    @Test
    @Override
    public void min_null_throws() {
        // Collections with one element should not throw to emulate the JDK Collections behavior
        this.newBagWithNull().min(String::compareTo);
    }

    @Test
    @Override
    public void max_null_throws() {
        // Collections with one element should not throw to emulate the JDK Collections behavior
        this.newBagWithNull().max(String::compareTo);
    }

    @Test
    @Override
    public void max_null_throws_without_comparator() {
        // Collections with one element should not throw to emulate the JDK Collections behavior
        this.newBagWithNull().max();
    }

    @Test
    @Override
    public void min_null_throws_without_comparator() {
        // Collections with one element should not throw to emulate the JDK Collections behavior
        this.newBagWithNull().min();
    }

    @Override
    @Test
    public void newWith() {
        super.newWith();
        Assert.assertEquals(Bags.immutable.of(VAL, NOT_VAL), this.newBag().newWith(NOT_VAL));
    }

    @Override
    @Test
    public void newWithout() {
        super.newWithout();
        Assert.assertEquals(Bags.immutable.of(VAL), this.newBag().newWithout(NOT_VAL));
        Assert.assertEquals(Bags.immutable.of(), this.newBag().newWithout(VAL));
    }

    @Override
    @Test
    public void newWithAll() {
        super.newWithAll();
        Assert.assertEquals(Bags.immutable.of(VAL, NOT_VAL, "c"), this.newBag().newWithAll(FastList.newListWith(NOT_VAL, "c")));
    }

    @Override
    @Test
    public void newWithoutAll() {
        super.newWithoutAll();
        Assert.assertEquals(Bags.immutable.of(VAL), this.newBag().newWithoutAll(FastList.newListWith(NOT_VAL)));
        Assert.assertEquals(Bags.immutable.of(), this.newBag().newWithoutAll(FastList.newListWith(VAL, NOT_VAL)));
        Assert.assertEquals(Bags.immutable.of(), this.newBag().newWithoutAll(FastList.newListWith(VAL)));
    }

    @Override
    @Test
    public void testSize() {
        Verify.assertIterableSize(1, this.newBag());
    }

    @Override
    @Test
    public void isEmpty() {
        super.isEmpty();
        Assert.assertFalse(this.newBag().isEmpty());
    }

    @Test
    public void testNotEmpty() {
        Assert.assertTrue(this.newBag().notEmpty());
    }

    @Override
    @Test
    public void getFirst() {
        super.getFirst();
        Assert.assertEquals(VAL, this.newBag().getFirst());
    }

    @Override
    @Test
    public void getLast() {
        super.getLast();
        Assert.assertEquals(VAL, this.newBag().getLast());
    }

    @Override
    @Test
    public void getOnly() {
        super.getOnly();
        Assert.assertEquals(VAL, this.newBag().getOnly());
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        Assert.assertTrue(this.newBag().contains(VAL));
        Assert.assertFalse(this.newBag().contains(NOT_VAL));
    }

    @Override
    @Test
    public void containsAllIterable() {
        super.containsAllIterable();
        Assert.assertTrue(this.newBag().containsAllIterable(FastList.newListWith()));
        Assert.assertTrue(this.newBag().containsAllIterable(FastList.newListWith(VAL)));
        Assert.assertFalse(this.newBag().containsAllIterable(FastList.newListWith(NOT_VAL)));
        Assert.assertFalse(this.newBag().containsAllIterable(FastList.newListWith(42)));
        Assert.assertFalse(this.newBag().containsAllIterable(FastList.newListWith(VAL, NOT_VAL)));
    }

    @Test
    public void testContainsAllArguments() {
        Assert.assertTrue(this.newBag().containsAllArguments());
        Assert.assertTrue(this.newBag().containsAllArguments(VAL));
        Assert.assertFalse(this.newBag().containsAllArguments(NOT_VAL));
        Assert.assertFalse(this.newBag().containsAllArguments(42));
        Assert.assertFalse(this.newBag().containsAllArguments(VAL, NOT_VAL));
    }

    @Override
    @Test
    public void selectToTarget() {
        super.selectToTarget();
        MutableList<String> target = Lists.mutable.of();
        this.newBag().select(ignored1 -> false, target);
        Verify.assertEmpty(target);
        this.newBag().select(ignored -> true, target);
        Verify.assertContains(VAL, target);
    }

    @Override
    @Test
    public void rejectToTarget() {
        super.rejectToTarget();
        MutableList<String> target = Lists.mutable.of();
        this.newBag().reject(ignored -> true, target);
        Verify.assertEmpty(target);
        this.newBag().reject(ignored -> false, target);
        Verify.assertContains(VAL, target);
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        Assert.assertEquals(Bags.immutable.of(VAL), this.newBag().collect(String::valueOf));
    }

    @Override
    @Test
    public void collect_target() {
        super.collect_target();
        MutableList<Class<?>> target = Lists.mutable.of();
        this.newBag().collect(Object::getClass, target);
        Verify.assertContains(String.class, target);
    }

    @Override
    @Test
    public void collectIf() {
        super.collectIf();
        Assert.assertEquals(Bags.immutable.of(String.class), this.newBag().collectIf(ignored -> true, Object::getClass));
        Assert.assertEquals(Bags.immutable.of(), this.newBag().collectIf(ignored -> false, Object::getClass));
    }

    @Override
    @Test
    public void collectIfWithTarget() {
        super.collectIfWithTarget();
        MutableList<Class<?>> target = Lists.mutable.of();
        this.newBag().collectIf(ignored1 -> false, Object::getClass, target);
        Verify.assertEmpty(target);
        this.newBag().collectIf(ignored -> true, Object::getClass, target);
        Verify.assertContains(String.class, target);
    }

    @Override
    @Test
    public void flatCollect() {
        super.flatCollect();
        ImmutableBag<Integer> result = this.newBag().flatCollect(object -> Bags.mutable.of(1, 2, 3, 4, 5));
        Assert.assertEquals(Bags.immutable.of(1, 2, 3, 4, 5), result);
    }

    @Override
    @Test
    public void flatCollectWithTarget() {
        super.flatCollectWithTarget();
        MutableBag<Integer> target = Bags.mutable.of();
        MutableBag<Integer> result = this.newBag().flatCollect(object -> Bags.mutable.of(1, 2, 3, 4, 5), target);
        Assert.assertEquals(Bags.mutable.of(1, 2, 3, 4, 5), result);
    }

    @Override
    @Test
    public void detect() {
        super.detect();
        Assert.assertEquals(VAL, this.newBag().detect(ignored -> true));
        Assert.assertNull(this.newBag().detect(ignored -> false));
    }

    @Override
    @Test
    public void detectOptional() {
        Assert.assertEquals("1", this.newBag().detectOptional("1"::equals).get());
        Assert.assertNotNull(this.newBag().detectOptional("2"::equals));
        Assert.assertThrows(NoSuchElementException.class, () -> this.newBag().detectOptional("2"::equals).get());
    }

    @Override
    @Test
    public void detectWith() {
        super.detectWith();
        Assert.assertEquals(VAL, this.newBag().detectWith(Object::equals, "1"));
    }

    @Override
    @Test
    public void detectWithOptional() {
        Assert.assertEquals("1", this.newBag().detectWithOptional(Object::equals, "1").get());
        Assert.assertNotNull(this.newBag().detectWithOptional(Object::equals, "2"));
        Assert.assertThrows(NoSuchElementException.class, () -> this.newBag().detectWithOptional(Object::equals, "2").get());
    }

    @Override
    @Test
    public void detectWithIfNone() {
        super.detectWithIfNone();
        Assert.assertEquals(VAL, this.newBag().detectWithIfNone(Object::equals, "1", new PassThruFunction0<>("Not Found")));
        Assert.assertEquals("Not Found", this.newBag().detectWithIfNone(Object::equals, "10000", new PassThruFunction0<>("Not Found")));
    }

    @Override
    @Test
    public void detectIfNone() {
        super.detectIfNone();
        Assert.assertEquals(VAL, this.newBag().detectIfNone(ignored -> true, new PassThruFunction0<>(NOT_VAL)));
        Assert.assertEquals(NOT_VAL, this.newBag().detectIfNone(ignored -> false, new PassThruFunction0<>(NOT_VAL)));
    }

    @Override
    @Test
    public void count() {
        super.count();
        Assert.assertEquals(1, this.newBag().count(ignored -> true));
        Assert.assertEquals(0, this.newBag().count(ignored -> false));
    }

    @Override
    @Test
    public void anySatisfy() {
        super.anySatisfy();
        Assert.assertTrue(this.newBag().anySatisfy(ignored -> true));
        Assert.assertFalse(this.newBag().anySatisfy(ignored -> false));
    }

    @Test
    public void testGroupBy() {
        ImmutableBagMultimap<Class<?>, String> result = this.newBag().groupBy(Object::getClass);
        Assert.assertEquals(VAL, result.get(String.class).getFirst());
    }

    @Test
    public void testGroupByWithTarget() {
        HashBagMultimap<Class<?>, String> target = HashBagMultimap.newMultimap();
        this.newBag().groupBy(Object::getClass, target);
        Assert.assertEquals(VAL, target.get(String.class).getFirst());
    }

    @Override
    @Test
    public void groupByUniqueKey() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1", "1").toImmutable(), this.newBag().groupByUniqueKey(id -> id));
    }

    @Override
    @Test
    public void groupByUniqueKey_throws() {
        super.groupByUniqueKey_throws();
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1", "1").toImmutable(), this.newBag().groupByUniqueKey(id -> id));
    }

    @Override
    @Test
    public void groupByUniqueKey_target() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues("0", "0", "1", "1"), this.newBag().groupByUniqueKey(id -> id, UnifiedMap.newWithKeysValues("0", "0")));
    }

    @Test
    public void testOccurrencesOf() {
        Assert.assertEquals(1, this.newBag().occurrencesOf(VAL));
        Assert.assertEquals(0, this.newBag().occurrencesOf(NOT_VAL));
    }

    @Test
    public void testForEachWithOccurrences() {
        Object[] results = new Object[2];
        this.newBag().forEachWithOccurrences((each, index) -> {
            results[0] = each;
            results[1] = index;
        });
        Assert.assertEquals(VAL, results[0]);
        Assert.assertEquals(1, results[1]);
    }

    @Override
    @Test
    public void toMapOfItemToCount() {
        super.toMapOfItemToCount();
        Assert.assertEquals(Maps.fixedSize.of(VAL, 1), this.newBag().toMapOfItemToCount());
    }

    @Override
    @Test
    public void toImmutable() {
        super.toImmutable();
        ImmutableBag<String> immutableBag = this.newBag();
        Assert.assertSame(immutableBag, immutableBag.toImmutable());
    }

    @Override
    @Test
    public void forEach() {
        super.forEach();
        Object[] results = new Object[1];
        this.newBag().forEach(Procedures.cast(each -> results[0] = each));
        Assert.assertEquals(VAL, results[0]);
    }

    @Override
    @Test
    public void forEachWithIndex() {
        super.forEachWithIndex();
        Object[] results = new Object[2];
        this.newBag().forEachWithIndex((each, index) -> {
            results[0] = each;
            results[1] = index;
        });
        Assert.assertEquals(VAL, results[0]);
        Assert.assertEquals(0, results[1]);
    }

    /**
     * @since 9.1.
     */
    @Override
    @Test
    public void collectWithOccurrences() {
        Bag<String> bag = this.newBag();
        Bag<ObjectIntPair<String>> actual = bag.collectWithOccurrences(PrimitiveTuples::pair, Bags.mutable.empty());
        Bag<ObjectIntPair<String>> expected = Bags.immutable.with(PrimitiveTuples.pair(VAL, 1));
        Assert.assertEquals(expected, actual);
        Set<ObjectIntPair<String>> actual2 = bag.collectWithOccurrences(PrimitiveTuples::pair, Sets.mutable.empty());
        ImmutableSet<ObjectIntPair<String>> expected2 = Sets.immutable.with(PrimitiveTuples.pair(VAL, 1));
        Assert.assertEquals(expected2, actual2);
    }

    @Override
    @Test
    public void forEachWith() {
        super.forEachWith();
        Object[] results = new Object[2];
        this.newBag().forEachWith((each, index) -> {
            results[0] = each;
            results[1] = index;
        }, "second");
        Assert.assertEquals(VAL, results[0]);
        Assert.assertEquals("second", results[1]);
    }

    @Override
    @Test
    public void iterator() {
        super.iterator();
        Iterator<String> iterator = this.newBag().iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(VAL, iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void testSizeDistinct() {
        Assert.assertEquals(1, this.newBag().sizeDistinct());
    }

    @Override
    @Test
    public void selectInstancesOf() {
        ImmutableBag<Number> numbers = new ImmutableSingletonBag<>(1);
        Assert.assertEquals(iBag(1), numbers.selectInstancesOf(Integer.class));
        Assert.assertEquals(iBag(), numbers.selectInstancesOf(Double.class));
    }

    @Override
    @Test
    public void collectBoolean() {
        ImmutableBooleanBag result = this.newBag().collectBoolean("4"::equals);
        Assert.assertEquals(1, result.sizeDistinct());
        Assert.assertEquals(0, result.occurrencesOf(true));
        Assert.assertEquals(1, result.occurrencesOf(false));
    }

    @Override
    @Test
    public void collectBooleanWithTarget() {
        BooleanHashBag target = new BooleanHashBag();
        BooleanHashBag result = this.newBag().collectBoolean("4"::equals, target);
        Assert.assertSame("Target sent as parameter not returned", target, result);
        Assert.assertEquals(1, result.sizeDistinct());
        Assert.assertEquals(0, result.occurrencesOf(true));
        Assert.assertEquals(1, result.occurrencesOf(false));
    }

    @Override
    @Test
    public void toSortedBag() {
        ImmutableBag<String> immutableBag = this.newBag();
        MutableSortedBag<String> sortedBag = immutableBag.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith("1"), sortedBag);
        MutableSortedBag<String> reverse = immutableBag.toSortedBag(Comparator.reverseOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparator.reverseOrder(), "1"), reverse);
    }

    @Override
    @Test
    public void toSortedBagBy() {
        ImmutableBag<String> immutableBag = this.newBag();
        MutableSortedBag<String> sortedBag = immutableBag.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith("1"), sortedBag);
    }

    @Override
    @Test
    public void selectUnique() {
        super.selectUnique();
        ImmutableBag<String> bag = this.newBag();
        ImmutableSet<String> expected = Sets.immutable.of(VAL);
        ImmutableSet<String> actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectDuplicates() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectDuplicates, this.description("selectDuplicates"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::equalsAndHashCode, this.description("equalsAndHashCode"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWithOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfyWithOccurrences, this.description("anySatisfyWithOccurrences"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWithOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfyWithOccurrences, this.description("allSatisfyWithOccurrences"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWithOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::noneSatisfyWithOccurrences, this.description("noneSatisfyWithOccurrences"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectWithOccurrences, this.description("detectWithOccurrences"));
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
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectInto, this.description("injectInto"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toList, this.description("toList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedList, this.description("toSortedList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListWithComparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedListWithComparator, this.description("toSortedListWithComparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSet, this.description("toSet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toBag, this.description("toBag"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toMap, this.description("toMap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArrayGivenArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toArrayGivenArray, this.description("toArrayGivenArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::min_null_throws, this.description("min_null_throws"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::max_null_throws, this.description("max_null_throws"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::max_null_throws_without_comparator, this.description("max_null_throws_without_comparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::min_null_throws_without_comparator, this.description("min_null_throws_without_comparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newWith, this.description("newWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newWithout, this.description("newWithout"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newWithAll, this.description("newWithAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newWithoutAll, this.description("newWithoutAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSize() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testSize, this.description("testSize"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isEmpty, this.description("isEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNotEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testNotEmpty, this.description("testNotEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getFirst, this.description("getFirst"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getLast, this.description("getLast"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getOnly, this.description("getOnly"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::contains, this.description("contains"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsAllIterable, this.description("containsAllIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testContainsAllArguments() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testContainsAllArguments, this.description("testContainsAllArguments"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectToTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectToTarget, this.description("selectToTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectToTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::rejectToTarget, this.description("rejectToTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect, this.description("collect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_target() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect_target, this.description("collect_target"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectIf, this.description("collectIf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIfWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectIfWithTarget, this.description("collectIfWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::flatCollect, this.description("flatCollect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::flatCollectWithTarget, this.description("flatCollectWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detect, this.description("detect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectOptional, this.description("detectOptional"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectWith, this.description("detectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectWithOptional, this.description("detectWithOptional"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectWithIfNone, this.description("detectWithIfNone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectIfNone, this.description("detectIfNone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::count, this.description("count"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfy, this.description("anySatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testGroupBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testGroupBy, this.description("testGroupBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testGroupByWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testGroupByWithTarget, this.description("testGroupByWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupByUniqueKey, this.description("groupByUniqueKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupByUniqueKey_throws, this.description("groupByUniqueKey_throws"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupByUniqueKey_target, this.description("groupByUniqueKey_target"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testOccurrencesOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testOccurrencesOf, this.description("testOccurrencesOf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testForEachWithOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testForEachWithOccurrences, this.description("testForEachWithOccurrences"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapOfItemToCount() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toMapOfItemToCount, this.description("toMapOfItemToCount"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutable, this.description("toImmutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach, this.description("forEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWithIndex, this.description("forEachWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectWithOccurrences, this.description("collectWithOccurrences"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWith, this.description("forEachWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator, this.description("iterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSizeDistinct() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testSizeDistinct, this.description("testSizeDistinct"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectInstancesOf, this.description("selectInstancesOf"));
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
        public void benchmark_toSortedBag() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedBag, this.description("toSortedBag"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedBagBy, this.description("toSortedBagBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectUnique, this.description("selectUnique"));
        }

        private ImmutableSingletonBagTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableSingletonBagTest();
        }

        @java.lang.Override
        public ImmutableSingletonBagTest implementation() {
            return this.implementation;
        }
    }
}
