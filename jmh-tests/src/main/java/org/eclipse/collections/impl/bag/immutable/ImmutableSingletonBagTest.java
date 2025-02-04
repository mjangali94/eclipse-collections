/*
 * Copyright (c) 2022 Goldman Sachs and others.
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
        ImmutableBag<Integer> immutable = new ImmutableSingletonBag<>(1);
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
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableSingletonBagTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsBy);
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
        public void benchmark_containsAllCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_safe);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_safe);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minByOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxByOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNoneBlock() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNoneBlock);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAny() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAny);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_not_only_one_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_not_only_one_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding1);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding1);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeLong);
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
        public void benchmark_sumByFloatConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloatConsistentRounding);
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
        public void benchmark_sumByDoubleConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDoubleConsistentRounding);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortSet_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSet_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy_with_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBiMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBiMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparatorAndStartAndEnd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_fusedCollectMakeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.fusedCollectMakeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparatorAndStartAndEnd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringThrows);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws_for_duplicate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_for_duplicate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_single() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_single);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
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
        public void benchmark_reduceOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStringOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStringOfItemToCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectByOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectByOccurrences);
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
        public void benchmark_selectWithToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithToTarget);
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
        public void benchmark_rejectWithToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithToTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
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
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith_target);
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
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
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
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_without_comparator);
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
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
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
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumInteger);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forLoop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forLoop);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorRemove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorRemove);
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
        public void benchmark_groupBy_with_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy_with_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMapBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString_with_separator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString_with_separator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString_with_start_separator_end() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString_with_start_separator_end);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectDuplicates() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectDuplicates);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArrayGivenArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArrayGivenArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSize);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNotEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNotEmpty);
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
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testContainsAllArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testContainsAllArguments);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectToTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectToTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIfWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIfWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
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
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testGroupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testGroupBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testGroupByWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testGroupByWithTarget);
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
        public void benchmark_testOccurrencesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testOccurrencesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testForEachWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testForEachWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapOfItemToCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSizeDistinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSizeDistinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
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
        public void benchmark_toSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectUnique);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableSingletonBagTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> selectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> rejectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> forLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> groupBy_with_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> appendString_with_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> appendString_with_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> distinctView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> anySatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> allSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> noneSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> detectWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toSortedListWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toArrayGivenArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> newWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> testSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> testNotEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> testContainsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> selectToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> rejectToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collect_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> testGroupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> testGroupByWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> testOccurrencesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> testForEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toMapOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collectWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> testSizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonBagTest> selectUnique;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = ImmutableSingletonBagTest::testNewCollection;
            this.payloads.containsBy = ImmutableSingletonBagTest::containsBy;
            this.payloads.containsAnyIterable = ImmutableSingletonBagTest::containsAnyIterable;
            this.payloads.containsNoneIterable = ImmutableSingletonBagTest::containsNoneIterable;
            this.payloads.containsAnyCollection = ImmutableSingletonBagTest::containsAnyCollection;
            this.payloads.containsNoneCollection = ImmutableSingletonBagTest::containsNoneCollection;
            this.payloads.containsAllCollection = ImmutableSingletonBagTest::containsAllCollection;
            this.payloads.selectWith_target = ImmutableSingletonBagTest::selectWith_target;
            this.payloads.rejectWith_target = ImmutableSingletonBagTest::rejectWith_target;
            this.payloads.collectTarget = ImmutableSingletonBagTest::collectTarget;
            this.payloads.collectBooleanWithBagTarget = ImmutableSingletonBagTest::collectBooleanWithBagTarget;
            this.payloads.collectByteWithBagTarget = ImmutableSingletonBagTest::collectByteWithBagTarget;
            this.payloads.collectCharWithBagTarget = ImmutableSingletonBagTest::collectCharWithBagTarget;
            this.payloads.collectDoubleWithBagTarget = ImmutableSingletonBagTest::collectDoubleWithBagTarget;
            this.payloads.collectFloatWithBagTarget = ImmutableSingletonBagTest::collectFloatWithBagTarget;
            this.payloads.collectIntWithBagTarget = ImmutableSingletonBagTest::collectIntWithBagTarget;
            this.payloads.collectLongWithBagTarget = ImmutableSingletonBagTest::collectLongWithBagTarget;
            this.payloads.collectShortWithBagTarget = ImmutableSingletonBagTest::collectShortWithBagTarget;
            this.payloads.flatCollectWith = ImmutableSingletonBagTest::flatCollectWith;
            this.payloads.flatCollectBoolean = ImmutableSingletonBagTest::flatCollectBoolean;
            this.payloads.flatCollectByte = ImmutableSingletonBagTest::flatCollectByte;
            this.payloads.flatCollectShort = ImmutableSingletonBagTest::flatCollectShort;
            this.payloads.flatCollectInt = ImmutableSingletonBagTest::flatCollectInt;
            this.payloads.flatCollectChar = ImmutableSingletonBagTest::flatCollectChar;
            this.payloads.flatCollectLong = ImmutableSingletonBagTest::flatCollectLong;
            this.payloads.flatCollectDouble = ImmutableSingletonBagTest::flatCollectDouble;
            this.payloads.flatCollectFloat = ImmutableSingletonBagTest::flatCollectFloat;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSingletonBagTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSingletonBagTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minOptional = ImmutableSingletonBagTest::minOptional;
            this.payloads.maxOptional = ImmutableSingletonBagTest::maxOptional;
            this.payloads.min_null_safe = ImmutableSingletonBagTest::min_null_safe;
            this.payloads.max_null_safe = ImmutableSingletonBagTest::max_null_safe;
            this.payloads.minByOptional = ImmutableSingletonBagTest::minByOptional;
            this.payloads.maxByOptional = ImmutableSingletonBagTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSingletonBagTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSingletonBagTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWithIfNoneBlock = ImmutableSingletonBagTest::detectWithIfNoneBlock;
            this.payloads.allSatisfyWith = ImmutableSingletonBagTest::allSatisfyWith;
            this.payloads.noneSatisfyWith = ImmutableSingletonBagTest::noneSatisfyWith;
            this.payloads.anySatisfyWith = ImmutableSingletonBagTest::anySatisfyWith;
            this.payloads.getAny = ImmutableSingletonBagTest::getAny;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSingletonBagTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSingletonBagTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSingletonBagTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.summarizeFloat = ImmutableSingletonBagTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = ImmutableSingletonBagTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = ImmutableSingletonBagTest::sumFloatConsistentRounding2;
            this.payloads.summarizeDouble = ImmutableSingletonBagTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = ImmutableSingletonBagTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = ImmutableSingletonBagTest::sumDoubleConsistentRounding2;
            this.payloads.summarizeInt = ImmutableSingletonBagTest::summarizeInt;
            this.payloads.summarizeLong = ImmutableSingletonBagTest::summarizeLong;
            this.payloads.sumByInt = ImmutableSingletonBagTest::sumByInt;
            this.payloads.sumByFloat = ImmutableSingletonBagTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = ImmutableSingletonBagTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = ImmutableSingletonBagTest::sumByLong;
            this.payloads.sumByDouble = ImmutableSingletonBagTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = ImmutableSingletonBagTest::sumByDoubleConsistentRounding;
            this.payloads.toImmutableList = ImmutableSingletonBagTest::toImmutableList;
            this.payloads.toCollection = ImmutableSingletonBagTest::toCollection;
            this.payloads.toImmutableBag = ImmutableSingletonBagTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = ImmutableSingletonBagTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = ImmutableSingletonBagTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = ImmutableSingletonBagTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = ImmutableSingletonBagTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSingletonBagTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = ImmutableSingletonBagTest::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = ImmutableSingletonBagTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = ImmutableSingletonBagTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = ImmutableSingletonBagTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSingletonBagTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBagBy = ImmutableSingletonBagTest::toImmutableSortedBagBy;
            this.payloads.toImmutableSortedListBy = ImmutableSingletonBagTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = ImmutableSingletonBagTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = ImmutableSingletonBagTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = ImmutableSingletonBagTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = ImmutableSingletonBagTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = ImmutableSingletonBagTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = ImmutableSingletonBagTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSingletonBagTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSet = ImmutableSingletonBagTest::toImmutableSet;
            this.payloads.toImmutableMap = ImmutableSingletonBagTest::toImmutableMap;
            this.payloads.toBiMap = ImmutableSingletonBagTest::toBiMap;
            this.payloads.toImmutableBiMap = ImmutableSingletonBagTest::toImmutableBiMap;
            this.payloads.makeStringWithSeparator = ImmutableSingletonBagTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = ImmutableSingletonBagTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = ImmutableSingletonBagTest::fusedCollectMakeString;
            this.payloads.appendStringWithSeparator = ImmutableSingletonBagTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = ImmutableSingletonBagTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = ImmutableSingletonBagTest::appendStringThrows;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSingletonBagTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSingletonBagTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.chunk = ImmutableSingletonBagTest::chunk;
            this.payloads.chunk_empty = ImmutableSingletonBagTest::chunk_empty;
            this.payloads.chunk_single = ImmutableSingletonBagTest::chunk_single;
            this.payloads.empty = ImmutableSingletonBagTest::empty;
            this.payloads.notEmpty = ImmutableSingletonBagTest::notEmpty;
            this.payloads.aggregateByMutating = ImmutableSingletonBagTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableSingletonBagTest::aggregateByNonMutating;
            this.payloads.reduceOptional = ImmutableSingletonBagTest::reduceOptional;
            this.payloads.toStringOfItemToCount = ImmutableSingletonBagTest::toStringOfItemToCount;
            this.payloads.containsAllArray = ImmutableSingletonBagTest::containsAllArray;
            this.payloads.add = ImmutableSingletonBagTest::add;
            this.payloads.remove = ImmutableSingletonBagTest::remove;
            this.payloads.addAll = ImmutableSingletonBagTest::addAll;
            this.payloads.removeAll = ImmutableSingletonBagTest::removeAll;
            this.payloads.retainAll = ImmutableSingletonBagTest::retainAll;
            this.payloads.clear = ImmutableSingletonBagTest::clear;
            this.payloads.tap = ImmutableSingletonBagTest::tap;
            this.payloads.selectByOccurrences = ImmutableSingletonBagTest::selectByOccurrences;
            this.payloads.select = ImmutableSingletonBagTest::select;
            this.payloads.selectWith = ImmutableSingletonBagTest::selectWith;
            this.payloads.selectWithToTarget = ImmutableSingletonBagTest::selectWithToTarget;
            this.payloads.reject = ImmutableSingletonBagTest::reject;
            this.payloads.rejectWith = ImmutableSingletonBagTest::rejectWith;
            this.payloads.rejectWithToTarget = ImmutableSingletonBagTest::rejectWithToTarget;
            this.payloads.partition = ImmutableSingletonBagTest::partition;
            this.payloads.partitionWith = ImmutableSingletonBagTest::partitionWith;
            this.payloads.collectByte = ImmutableSingletonBagTest::collectByte;
            this.payloads.collectByteWithTarget = ImmutableSingletonBagTest::collectByteWithTarget;
            this.payloads.collectChar = ImmutableSingletonBagTest::collectChar;
            this.payloads.collectCharWithTarget = ImmutableSingletonBagTest::collectCharWithTarget;
            this.payloads.collectDouble = ImmutableSingletonBagTest::collectDouble;
            this.payloads.collectDoubleWithTarget = ImmutableSingletonBagTest::collectDoubleWithTarget;
            this.payloads.collectFloat = ImmutableSingletonBagTest::collectFloat;
            this.payloads.collectFloatWithTarget = ImmutableSingletonBagTest::collectFloatWithTarget;
            this.payloads.collectInt = ImmutableSingletonBagTest::collectInt;
            this.payloads.collectIntWithTarget = ImmutableSingletonBagTest::collectIntWithTarget;
            this.payloads.collectLong = ImmutableSingletonBagTest::collectLong;
            this.payloads.collectLongWithTarget = ImmutableSingletonBagTest::collectLongWithTarget;
            this.payloads.collectShort = ImmutableSingletonBagTest::collectShort;
            this.payloads.collectShortWithTarget = ImmutableSingletonBagTest::collectShortWithTarget;
            this.payloads.collectWith = ImmutableSingletonBagTest::collectWith;
            this.payloads.collectWith_target = ImmutableSingletonBagTest::collectWith_target;
            this.payloads.zip = ImmutableSingletonBagTest::zip;
            this.payloads.zipWithIndex = ImmutableSingletonBagTest::zipWithIndex;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSingletonBagTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = ImmutableSingletonBagTest::chunk_large_size;
            this.payloads.min = ImmutableSingletonBagTest::min;
            this.payloads.max = ImmutableSingletonBagTest::max;
            this.payloads.min_without_comparator = ImmutableSingletonBagTest::min_without_comparator;
            this.payloads.max_without_comparator = ImmutableSingletonBagTest::max_without_comparator;
            this.payloads.minBy = ImmutableSingletonBagTest::minBy;
            this.payloads.maxBy = ImmutableSingletonBagTest::maxBy;
            this.payloads.countWith = ImmutableSingletonBagTest::countWith;
            this.payloads.injectIntoInt = ImmutableSingletonBagTest::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableSingletonBagTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableSingletonBagTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ImmutableSingletonBagTest::injectIntoFloat;
            this.payloads.sumFloat = ImmutableSingletonBagTest::sumFloat;
            this.payloads.sumDouble = ImmutableSingletonBagTest::sumDouble;
            this.payloads.sumInteger = ImmutableSingletonBagTest::sumInteger;
            this.payloads.sumLong = ImmutableSingletonBagTest::sumLong;
            this.payloads.toArray = ImmutableSingletonBagTest::toArray;
            this.payloads.testToString = ImmutableSingletonBagTest::testToString;
            this.payloads.toSortedListBy = ImmutableSingletonBagTest::toSortedListBy;
            this.payloads.forLoop = ImmutableSingletonBagTest::forLoop;
            this.payloads.iteratorRemove = ImmutableSingletonBagTest::iteratorRemove;
            this.payloads.countBy = ImmutableSingletonBagTest::countBy;
            this.payloads.countByWith = ImmutableSingletonBagTest::countByWith;
            this.payloads.countByEach = ImmutableSingletonBagTest::countByEach;
            this.payloads.groupBy = ImmutableSingletonBagTest::groupBy;
            this.payloads.groupBy_with_target = ImmutableSingletonBagTest::groupBy_with_target;
            this.payloads.groupByEach = ImmutableSingletonBagTest::groupByEach;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSingletonBagTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.toMapTarget = ImmutableSingletonBagTest::toMapTarget;
            this.payloads.toSortedMap = ImmutableSingletonBagTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = ImmutableSingletonBagTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = ImmutableSingletonBagTest::toSortedMapBy;
            this.payloads.asLazy = ImmutableSingletonBagTest::asLazy;
            this.payloads.makeString = ImmutableSingletonBagTest::makeString;
            this.payloads.appendString = ImmutableSingletonBagTest::appendString;
            this.payloads.appendString_with_separator = ImmutableSingletonBagTest::appendString_with_separator;
            this.payloads.appendString_with_start_separator_end = ImmutableSingletonBagTest::appendString_with_start_separator_end;
            this.payloads.serialization = ImmutableSingletonBagTest::serialization;
            this.payloads.distinctView = ImmutableSingletonBagTest::distinctView;
            this.payloads.selectDuplicates = ImmutableSingletonBagTest::selectDuplicates;
            this.payloads.equalsAndHashCode = ImmutableSingletonBagTest::equalsAndHashCode;
            this.payloads.anySatisfyWithOccurrences = ImmutableSingletonBagTest::anySatisfyWithOccurrences;
            this.payloads.allSatisfyWithOccurrences = ImmutableSingletonBagTest::allSatisfyWithOccurrences;
            this.payloads.noneSatisfyWithOccurrences = ImmutableSingletonBagTest::noneSatisfyWithOccurrences;
            this.payloads.detectWithOccurrences = ImmutableSingletonBagTest::detectWithOccurrences;
            this.payloads.allSatisfy = ImmutableSingletonBagTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableSingletonBagTest::noneSatisfy;
            this.payloads.injectInto = ImmutableSingletonBagTest::injectInto;
            this.payloads.toList = ImmutableSingletonBagTest::toList;
            this.payloads.toSortedList = ImmutableSingletonBagTest::toSortedList;
            this.payloads.toSortedListWithComparator = ImmutableSingletonBagTest::toSortedListWithComparator;
            this.payloads.toSet = ImmutableSingletonBagTest::toSet;
            this.payloads.toBag = ImmutableSingletonBagTest::toBag;
            this.payloads.toMap = ImmutableSingletonBagTest::toMap;
            this.payloads.toArrayGivenArray = ImmutableSingletonBagTest::toArrayGivenArray;
            this.payloads.min_null_throws = ImmutableSingletonBagTest::min_null_throws;
            this.payloads.max_null_throws = ImmutableSingletonBagTest::max_null_throws;
            this.payloads.max_null_throws_without_comparator = ImmutableSingletonBagTest::max_null_throws_without_comparator;
            this.payloads.min_null_throws_without_comparator = ImmutableSingletonBagTest::min_null_throws_without_comparator;
            this.payloads.newWith = ImmutableSingletonBagTest::newWith;
            this.payloads.newWithout = ImmutableSingletonBagTest::newWithout;
            this.payloads.newWithAll = ImmutableSingletonBagTest::newWithAll;
            this.payloads.newWithoutAll = ImmutableSingletonBagTest::newWithoutAll;
            this.payloads.testSize = ImmutableSingletonBagTest::testSize;
            this.payloads.isEmpty = ImmutableSingletonBagTest::isEmpty;
            this.payloads.testNotEmpty = ImmutableSingletonBagTest::testNotEmpty;
            this.payloads.getFirst = ImmutableSingletonBagTest::getFirst;
            this.payloads.getLast = ImmutableSingletonBagTest::getLast;
            this.payloads.getOnly = ImmutableSingletonBagTest::getOnly;
            this.payloads.contains = ImmutableSingletonBagTest::contains;
            this.payloads.containsAllIterable = ImmutableSingletonBagTest::containsAllIterable;
            this.payloads.testContainsAllArguments = ImmutableSingletonBagTest::testContainsAllArguments;
            this.payloads.selectToTarget = ImmutableSingletonBagTest::selectToTarget;
            this.payloads.rejectToTarget = ImmutableSingletonBagTest::rejectToTarget;
            this.payloads.collect = ImmutableSingletonBagTest::collect;
            this.payloads.collect_target = ImmutableSingletonBagTest::collect_target;
            this.payloads.collectIf = ImmutableSingletonBagTest::collectIf;
            this.payloads.collectIfWithTarget = ImmutableSingletonBagTest::collectIfWithTarget;
            this.payloads.flatCollect = ImmutableSingletonBagTest::flatCollect;
            this.payloads.flatCollectWithTarget = ImmutableSingletonBagTest::flatCollectWithTarget;
            this.payloads.detect = ImmutableSingletonBagTest::detect;
            this.payloads.detectOptional = ImmutableSingletonBagTest::detectOptional;
            this.payloads.detectWith = ImmutableSingletonBagTest::detectWith;
            this.payloads.detectWithOptional = ImmutableSingletonBagTest::detectWithOptional;
            this.payloads.detectWithIfNone = ImmutableSingletonBagTest::detectWithIfNone;
            this.payloads.detectIfNone = ImmutableSingletonBagTest::detectIfNone;
            this.payloads.count = ImmutableSingletonBagTest::count;
            this.payloads.anySatisfy = ImmutableSingletonBagTest::anySatisfy;
            this.payloads.testGroupBy = ImmutableSingletonBagTest::testGroupBy;
            this.payloads.testGroupByWithTarget = ImmutableSingletonBagTest::testGroupByWithTarget;
            this.payloads.groupByUniqueKey = ImmutableSingletonBagTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = ImmutableSingletonBagTest::groupByUniqueKey_throws;
            this.payloads.groupByUniqueKey_target = ImmutableSingletonBagTest::groupByUniqueKey_target;
            this.payloads.testOccurrencesOf = ImmutableSingletonBagTest::testOccurrencesOf;
            this.payloads.testForEachWithOccurrences = ImmutableSingletonBagTest::testForEachWithOccurrences;
            this.payloads.toMapOfItemToCount = ImmutableSingletonBagTest::toMapOfItemToCount;
            this.payloads.toImmutable = ImmutableSingletonBagTest::toImmutable;
            this.payloads.forEach = ImmutableSingletonBagTest::forEach;
            this.payloads.forEachWithIndex = ImmutableSingletonBagTest::forEachWithIndex;
            this.payloads.collectWithOccurrences = ImmutableSingletonBagTest::collectWithOccurrences;
            this.payloads.forEachWith = ImmutableSingletonBagTest::forEachWith;
            this.payloads.iterator = ImmutableSingletonBagTest::iterator;
            this.payloads.testSizeDistinct = ImmutableSingletonBagTest::testSizeDistinct;
            this.payloads.selectInstancesOf = ImmutableSingletonBagTest::selectInstancesOf;
            this.payloads.collectBoolean = ImmutableSingletonBagTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = ImmutableSingletonBagTest::collectBooleanWithTarget;
            this.payloads.toSortedBag = ImmutableSingletonBagTest::toSortedBag;
            this.payloads.toSortedBagBy = ImmutableSingletonBagTest::toSortedBagBy;
            this.payloads.selectUnique = ImmutableSingletonBagTest::selectUnique;
        }
    }
}
