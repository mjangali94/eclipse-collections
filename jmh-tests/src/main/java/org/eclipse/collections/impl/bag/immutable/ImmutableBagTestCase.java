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

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bag.primitive.ImmutableBooleanBag;
import org.eclipse.collections.api.bag.primitive.ImmutableByteBag;
import org.eclipse.collections.api.bag.primitive.ImmutableCharBag;
import org.eclipse.collections.api.bag.primitive.ImmutableDoubleBag;
import org.eclipse.collections.api.bag.primitive.ImmutableFloatBag;
import org.eclipse.collections.api.bag.primitive.ImmutableIntBag;
import org.eclipse.collections.api.bag.primitive.ImmutableLongBag;
import org.eclipse.collections.api.bag.primitive.ImmutableShortBag;
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.function.primitive.CharFunction;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MapIterable;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.multimap.MutableMultimap;
import org.eclipse.collections.api.multimap.bag.ImmutableBagMultimap;
import org.eclipse.collections.api.partition.bag.PartitionImmutableBag;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;
import org.eclipse.collections.impl.AbstractRichIterableTestCase;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.BooleanHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.ByteHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.bag.sorted.mutable.TreeBag;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.factory.ObjectIntProcedures;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.block.function.NegativeIntervalFunction;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.multimap.bag.HashBagMultimap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.eclipse.collections.impl.utility.StringIterate;
import org.junit.Assert;
import org.junit.Test;

public abstract class ImmutableBagTestCase extends AbstractRichIterableTestCase {

    /**
     * @return A bag containing "1", "2", "2", "3", "3", "3", etc.
     */
    protected abstract ImmutableBag<String> newBag();

    @Override
    protected <T> ImmutableBag<T> newWith(T... littleElements) {
        return ImmutableHashBag.newBagWith(littleElements);
    }

    /**
     * @return The number of unique keys.
     */
    protected abstract int numKeys();

    @Test
    public abstract void testSize();

    @Override
    @Test
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        ImmutableBag<String> immutable = this.newBag();
        MutableBag<String> mutable = HashBag.newBag(immutable);
        Verify.assertEqualsAndHashCode(immutable, mutable);
        Assert.assertNotEquals(immutable, FastList.newList(mutable));
        Assert.assertEquals(this.newBag().toMapOfItemToCount().hashCode(), this.newBag().hashCode());
        Assert.assertNotEquals(immutable, mutable.with("5").without("1"));
    }

    @Test
    public void anySatisfyWithOccurrences() {
        ImmutableBag<String> bag = this.newBag();
        Assert.assertTrue(bag.anySatisfyWithOccurrences((object, value) -> object.equals("2")));
        Assert.assertTrue(bag.anySatisfyWithOccurrences((object, value) -> object.equals("2") && value == 2));
        Assert.assertFalse(bag.anySatisfyWithOccurrences((object, value) -> object.equals("2") && value == 6));
        Assert.assertFalse(bag.anySatisfyWithOccurrences((object, value) -> object.equals("20")));
    }

    @Test
    public void allSatisfyWithOccurrences() {
        ImmutableBag<String> bag = this.newBag();
        Assert.assertTrue(bag.allSatisfyWithOccurrences((object, value) -> Integer.parseInt(object) > 0));
        Assert.assertFalse(bag.allSatisfyWithOccurrences((object, value) -> object.equals("1") && value == 1));
    }

    @Test
    public void noneSatisfyWithOccurrences() {
        ImmutableBag<String> bag = this.newBag();
        Assert.assertTrue(bag.noneSatisfyWithOccurrences((object, value) -> Integer.parseInt(object) > 100));
        Assert.assertFalse(bag.noneSatisfyWithOccurrences((object, value) -> object.equals("1") && value == 1));
    }

    @Test
    public void detectWithOccurrences() {
        ImmutableBag<String> bag = this.newBag();
        Assert.assertEquals("1", bag.detectWithOccurrences((object, value) -> object.equals("1") && value == 1));
        Assert.assertNull(bag.detectWithOccurrences((object, value) -> object.equals("100")));
        Assert.assertNull(bag.detectWithOccurrences((object, value) -> object.equals("1") && value == 100));
    }

    @Test
    public void newWith() {
        ImmutableBag<String> bag = this.newBag();
        ImmutableBag<String> newBag = bag.newWith("1");
        Assert.assertNotEquals(bag, newBag);
        Assert.assertEquals(bag.size() + 1, newBag.size());
        Assert.assertEquals(bag.sizeDistinct(), newBag.sizeDistinct());
        ImmutableBag<String> newBag2 = bag.newWith("0");
        Assert.assertNotEquals(bag, newBag2);
        Assert.assertEquals(bag.size() + 1, newBag2.size());
        Assert.assertEquals(newBag.sizeDistinct() + 1, newBag2.sizeDistinct());
    }

    @Test
    public void newWithout() {
        ImmutableBag<String> bag = this.newBag();
        ImmutableBag<String> newBag = bag.newWithout("1");
        Assert.assertNotEquals(bag, newBag);
        Assert.assertEquals(bag.size() - 1, newBag.size());
        Assert.assertEquals(bag.sizeDistinct() - 1, newBag.sizeDistinct());
        ImmutableBag<String> newBag2 = bag.newWithout("0");
        Assert.assertEquals(bag, newBag2);
        Assert.assertEquals(bag.size(), newBag2.size());
        Assert.assertEquals(bag.sizeDistinct(), newBag2.sizeDistinct());
    }

    @Test
    public void newWithAll() {
        ImmutableBag<String> bag = this.newBag();
        ImmutableBag<String> newBag = bag.newWithAll(Bags.mutable.of("0"));
        Assert.assertNotEquals(bag, newBag);
        Assert.assertEquals(HashBag.newBag(bag).with("0"), newBag);
        Assert.assertEquals(newBag.size(), bag.size() + 1);
    }

    @Test
    public abstract void toStringOfItemToCount();

    @Test
    public void newWithoutAll() {
        ImmutableBag<String> bag = this.newBag();
        ImmutableBag<String> withoutAll = bag.newWithoutAll(UnifiedSet.newSet(this.newBag()));
        Assert.assertEquals(Bags.immutable.of(), withoutAll);
        ImmutableBag<String> newBag = bag.newWithAll(Lists.fixedSize.of("0", "0", "0")).newWithoutAll(Lists.fixedSize.of("0"));
        Assert.assertEquals(0, newBag.occurrencesOf("0"));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        ImmutableBag<String> bag = this.newBag();
        for (int i = 1; i <= this.numKeys(); i++) {
            String key = String.valueOf(i);
            Assert.assertTrue(bag.contains(key));
            Assert.assertEquals(i, bag.occurrencesOf(key));
        }
        String missingKey = "0";
        Assert.assertFalse(bag.contains(missingKey));
        Assert.assertEquals(0, bag.occurrencesOf(missingKey));
    }

    @Override
    @Test
    public void containsAllArray() {
        super.containsAllArray();
        Assert.assertTrue(this.newBag().containsAllArguments(this.newBag().toArray()));
    }

    @Override
    @Test
    public void containsAllIterable() {
        super.containsAllIterable();
        Assert.assertTrue(this.newBag().containsAllIterable(this.newBag()));
    }

    @Test
    public void add() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> ((Collection<String>) this.newBag()).add("1"));
    }

    @Test
    public void remove() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> ((Collection<String>) this.newBag()).remove("1"));
    }

    @Test
    public void addAll() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> ((Collection<String>) this.newBag()).addAll(FastList.newListWith("1", "2", "3")));
    }

    @Test
    public void removeAll() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> ((Collection<String>) this.newBag()).removeAll(FastList.newListWith("1", "2", "3")));
    }

    @Test
    public void retainAll() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> ((Collection<String>) this.newBag()).retainAll(FastList.newListWith("1", "2", "3")));
    }

    @Test
    public void clear() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> ((Collection<String>) this.newBag()).clear());
    }

    @Override
    @Test
    public void tap() {
        super.tap();
        MutableList<String> tapResult = Lists.mutable.of();
        ImmutableBag<String> collection = this.newBag();
        Assert.assertSame(collection, collection.tap(tapResult::add));
        Assert.assertEquals(collection.toList(), tapResult);
    }

    @Override
    @Test
    public void forEach() {
        super.forEach();
        MutableBag<String> result = Bags.mutable.of();
        ImmutableBag<String> collection = this.newBag();
        collection.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(collection, result);
    }

    @Override
    @Test
    public void forEachWith() {
        super.forEachWith();
        MutableBag<String> result = Bags.mutable.of();
        ImmutableBag<String> bag = this.newBag();
        bag.forEachWith((argument1, argument2) -> result.add(argument1 + argument2), "");
        Assert.assertEquals(bag, result);
    }

    @Override
    @Test
    public void forEachWithIndex() {
        super.forEachWithIndex();
        MutableBag<String> result = Bags.mutable.of();
        ImmutableBag<String> strings = this.newBag();
        strings.forEachWithIndex(ObjectIntProcedures.fromProcedure(result::add));
        Assert.assertEquals(strings, result);
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithOccurrences() {
        Bag<String> bag = this.newBag();
        Bag<ObjectIntPair<String>> actual = bag.collectWithOccurrences(PrimitiveTuples::pair, Bags.mutable.empty());
        Bag<ObjectIntPair<String>> expected = Bags.immutable.with(PrimitiveTuples.pair("4", 4), PrimitiveTuples.pair("3", 3), PrimitiveTuples.pair("2", 2), PrimitiveTuples.pair("1", 1));
        Assert.assertEquals(expected, actual);
        Set<ObjectIntPair<String>> actual2 = bag.collectWithOccurrences(PrimitiveTuples::pair, Sets.mutable.empty());
        ImmutableSet<ObjectIntPair<String>> expected2 = Sets.immutable.with(PrimitiveTuples.pair("4", 4), PrimitiveTuples.pair("3", 3), PrimitiveTuples.pair("2", 2), PrimitiveTuples.pair("1", 1));
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void selectByOccurrences() {
        ImmutableBag<String> strings = this.newBag().selectByOccurrences(IntPredicates.isEven());
        ImmutableBag<Integer> collect = strings.collect(Integer::valueOf);
        Verify.assertAllSatisfy(collect, IntegerPredicates.isEven());
    }

    @Test
    public void selectDuplicates() {
        Verify.assertBagsEqual(Bags.immutable.ofOccurrences(PrimitiveTuples.pair("2", 2), PrimitiveTuples.pair("3", 3), PrimitiveTuples.pair("4", 4)), this.newBag().selectDuplicates());
    }

    @Override
    @Test
    public void select() {
        super.select();
        ImmutableBag<String> strings = this.newBag();
        Verify.assertContainsAll(FastList.newList(strings.select(Predicates.greaterThan("0"))), strings.toArray());
        Verify.assertIterableEmpty(strings.select(Predicates.lessThan("0")));
        Verify.assertIterableSize(strings.size() - 1, strings.select(Predicates.greaterThan("1")));
    }

    @Override
    @Test
    public void selectWith() {
        super.selectWith();
        ImmutableBag<String> strings = this.newBag();
        Assert.assertEquals(strings, strings.selectWith(Predicates2.greaterThan(), "0"));
    }

    @Test
    public void selectWithToTarget() {
        ImmutableBag<String> strings = this.newBag();
        Assert.assertEquals(strings, strings.selectWith(Predicates2.greaterThan(), "0", FastList.newList()).toBag());
    }

    @Test
    public void selectToTarget() {
        ImmutableBag<String> strings = this.newBag();
        Assert.assertEquals(strings, strings.select(Predicates.greaterThan("0"), FastList.newList()).toBag());
        Verify.assertEmpty(strings.select(Predicates.lessThan("0"), FastList.newList()));
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        ImmutableBag<String> strings = this.newBag();
        Verify.assertIterableEmpty(strings.reject(Predicates.greaterThan("0")));
        Assert.assertEquals(strings, strings.reject(Predicates.lessThan("0")));
        Verify.assertIterableSize(strings.size() - 1, strings.reject(Predicates.lessThan("2")));
    }

    @Override
    @Test
    public void rejectWith() {
        super.rejectWith();
        ImmutableBag<String> strings = this.newBag();
        Assert.assertEquals(strings, strings.rejectWith(Predicates2.lessThan(), "0"));
    }

    @Test
    public void rejectWithToTarget() {
        ImmutableBag<String> strings = this.newBag();
        Assert.assertEquals(strings, strings.reject(Predicates.lessThan("0")));
        Verify.assertEmpty(strings.rejectWith(Predicates2.greaterThan(), "0", FastList.newList()));
    }

    @Test
    public void rejectToTarget() {
        ImmutableBag<String> strings = this.newBag();
        Assert.assertEquals(strings, strings.reject(Predicates.lessThan("0"), FastList.newList()).toBag());
        Verify.assertEmpty(strings.reject(Predicates.greaterThan("0"), FastList.newList()));
    }

    @Override
    @Test
    public void partition() {
        super.partition();
        ImmutableBag<String> strings = this.newBag();
        PartitionImmutableBag<String> partition = strings.partition(Predicates.greaterThan("0"));
        Assert.assertEquals(strings, partition.getSelected());
        Verify.assertIterableEmpty(partition.getRejected());
        Verify.assertIterableSize(strings.size() - 1, strings.partition(Predicates.greaterThan("1")).getSelected());
    }

    @Override
    @Test
    public void partitionWith() {
        super.partitionWith();
        ImmutableBag<String> strings = this.newBag();
        PartitionImmutableBag<String> partition = strings.partitionWith(Predicates2.greaterThan(), "0");
        Assert.assertEquals(strings, partition.getSelected());
        Verify.assertIterableEmpty(partition.getRejected());
        Verify.assertIterableSize(strings.size() - 1, strings.partitionWith(Predicates2.greaterThan(), "1").getSelected());
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        Assert.assertEquals(this.newBag(), this.newBag().collect(Functions.getStringPassThru()));
    }

    @Override
    @Test
    public void collectBoolean() {
        super.collectBoolean();
        ImmutableBooleanBag result = this.newBag().collectBoolean("4"::equals);
        Assert.assertEquals(2, result.sizeDistinct());
        Assert.assertEquals(4, result.occurrencesOf(true));
        Assert.assertEquals(6, result.occurrencesOf(false));
    }

    @Override
    @Test
    public void collectBooleanWithTarget() {
        super.collectBooleanWithTarget();
        BooleanHashBag target = new BooleanHashBag();
        BooleanHashBag result = this.newBag().collectBoolean("4"::equals, target);
        Assert.assertSame("Target sent as parameter not returned", target, result);
        Assert.assertEquals(2, result.sizeDistinct());
        Assert.assertEquals(4, result.occurrencesOf(true));
        Assert.assertEquals(6, result.occurrencesOf(false));
    }

    @Override
    @Test
    public void collectByte() {
        super.collectByte();
        ImmutableByteBag result = this.newBag().collectByte(Byte::parseByte);
        Assert.assertEquals(this.numKeys(), result.sizeDistinct());
        for (int i = 1; i <= this.numKeys(); i++) {
            Assert.assertEquals(i, result.occurrencesOf((byte) i));
        }
    }

    @Override
    @Test
    public void collectByteWithTarget() {
        super.collectByteWithTarget();
        ByteHashBag target = new ByteHashBag();
        ByteHashBag result = this.newBag().collectByte(Byte::parseByte, target);
        Assert.assertSame("Target sent as parameter not returned", target, result);
        Assert.assertEquals(this.numKeys(), result.sizeDistinct());
        for (int i = 1; i <= this.numKeys(); i++) {
            Assert.assertEquals(i, result.occurrencesOf((byte) i));
        }
    }

    @Override
    @Test
    public void collectChar() {
        super.collectChar();
        ImmutableCharBag result = this.newBag().collectChar((CharFunction<String>) string -> string.charAt(0));
        Assert.assertEquals(this.numKeys(), result.sizeDistinct());
        for (int i = 1; i <= this.numKeys(); i++) {
            Assert.assertEquals(i, result.occurrencesOf((char) ('0' + i)));
        }
    }

    @Override
    @Test
    public void collectCharWithTarget() {
        super.collectCharWithTarget();
        CharHashBag target = new CharHashBag();
        CharHashBag result = this.newBag().collectChar((CharFunction<String>) string -> string.charAt(0), target);
        Assert.assertSame("Target sent as parameter not returned", target, result);
        Assert.assertEquals(this.numKeys(), result.sizeDistinct());
        for (int i = 1; i <= this.numKeys(); i++) {
            Assert.assertEquals(i, result.occurrencesOf((char) ('0' + i)));
        }
    }

    @Override
    @Test
    public void collectDouble() {
        super.collectDouble();
        ImmutableDoubleBag result = this.newBag().collectDouble(Double::parseDouble);
        Assert.assertEquals(this.numKeys(), result.sizeDistinct());
        for (int i = 1; i <= this.numKeys(); i++) {
            Assert.assertEquals(i, result.occurrencesOf(i));
        }
    }

    @Override
    @Test
    public void collectDoubleWithTarget() {
        super.collectDoubleWithTarget();
        DoubleHashBag target = new DoubleHashBag();
        DoubleHashBag result = this.newBag().collectDouble(Double::parseDouble, target);
        Assert.assertSame("Target sent as parameter not returned", target, result);
        Assert.assertEquals(this.numKeys(), result.sizeDistinct());
        for (int i = 1; i <= this.numKeys(); i++) {
            Assert.assertEquals(i, result.occurrencesOf(i));
        }
    }

    @Override
    @Test
    public void collectFloat() {
        super.collectFloat();
        ImmutableFloatBag result = this.newBag().collectFloat(Float::parseFloat);
        Assert.assertEquals(this.numKeys(), result.sizeDistinct());
        for (int i = 1; i <= this.numKeys(); i++) {
            Assert.assertEquals(i, result.occurrencesOf(i));
        }
    }

    @Override
    @Test
    public void collectFloatWithTarget() {
        super.collectFloatWithTarget();
        FloatHashBag target = new FloatHashBag();
        FloatHashBag result = this.newBag().collectFloat(Float::parseFloat, target);
        Assert.assertSame("Target sent as parameter not returned", target, result);
        Assert.assertEquals(this.numKeys(), result.sizeDistinct());
        for (int i = 1; i <= this.numKeys(); i++) {
            Assert.assertEquals(i, result.occurrencesOf(i));
        }
    }

    @Override
    @Test
    public void collectInt() {
        super.collectInt();
        ImmutableIntBag result = this.newBag().collectInt(Integer::parseInt);
        Assert.assertEquals(this.numKeys(), result.sizeDistinct());
        for (int i = 1; i <= this.numKeys(); i++) {
            Assert.assertEquals(i, result.occurrencesOf(i));
        }
    }

    @Override
    @Test
    public void collectIntWithTarget() {
        super.collectIntWithTarget();
        IntHashBag target = new IntHashBag();
        IntHashBag result = this.newBag().collectInt(Integer::parseInt, target);
        Assert.assertSame("Target sent as parameter not returned", target, result);
        Assert.assertEquals(this.numKeys(), result.sizeDistinct());
        for (int i = 1; i <= this.numKeys(); i++) {
            Assert.assertEquals(i, result.occurrencesOf(i));
        }
    }

    @Override
    @Test
    public void collectLong() {
        super.collectLong();
        ImmutableLongBag result = this.newBag().collectLong(Long::parseLong);
        Assert.assertEquals(this.numKeys(), result.sizeDistinct());
        for (int i = 1; i <= this.numKeys(); i++) {
            Assert.assertEquals(i, result.occurrencesOf(i));
        }
    }

    @Override
    @Test
    public void collectLongWithTarget() {
        super.collectLongWithTarget();
        LongHashBag target = new LongHashBag();
        LongHashBag result = this.newBag().collectLong(Long::parseLong, target);
        Assert.assertSame("Target sent as parameter not returned", target, result);
        Assert.assertEquals(this.numKeys(), result.sizeDistinct());
        for (int i = 1; i <= this.numKeys(); i++) {
            Assert.assertEquals(i, result.occurrencesOf(i));
        }
    }

    @Override
    @Test
    public void collectShort() {
        super.collectShort();
        ImmutableShortBag result = this.newBag().collectShort(Short::parseShort);
        Assert.assertEquals(this.numKeys(), result.sizeDistinct());
        for (int i = 1; i <= this.numKeys(); i++) {
            Assert.assertEquals(i, result.occurrencesOf((short) i));
        }
    }

    @Override
    @Test
    public void collectShortWithTarget() {
        super.collectShortWithTarget();
        ShortHashBag target = new ShortHashBag();
        ShortHashBag result = this.newBag().collectShort(Short::parseShort, target);
        Assert.assertEquals(this.numKeys(), result.sizeDistinct());
        for (int i = 1; i <= this.numKeys(); i++) {
            Assert.assertEquals(i, result.occurrencesOf((short) i));
        }
    }

    private Function2<String, String, String> generateAssertingPassThroughFunction2(String valueToAssert) {
        return (argument1, argument2) -> {
            Assert.assertEquals(valueToAssert, argument2);
            return argument1;
        };
    }

    @Override
    @Test
    public void collectWith() {
        super.collectWith();
        ImmutableBag<String> strings = this.newBag();
        String argument = "thing";
        Assert.assertEquals(strings, strings.collectWith(this.generateAssertingPassThroughFunction2(argument), argument));
    }

    @Override
    @Test
    public void collectWith_target() {
        super.collectWith_target();
        ImmutableBag<String> strings = this.newBag();
        String argument = "thing";
        HashBag<String> targetCollection = HashBag.newBag();
        HashBag<String> actual = strings.collectWith(this.generateAssertingPassThroughFunction2(argument), argument, targetCollection);
        Assert.assertEquals(strings, actual);
        Assert.assertSame(targetCollection, actual);
    }

    @Test
    public void collect_target() {
        ImmutableBag<String> strings = this.newBag();
        HashBag<String> target = HashBag.newBag();
        HashBag<String> actual = strings.collect(Functions.getStringPassThru(), target);
        Assert.assertEquals(strings, actual);
        Assert.assertSame(target, actual);
        Assert.assertEquals(strings, strings.collect(Functions.getStringPassThru(), FastList.newList()).toBag());
    }

    @Override
    @Test
    public void flatCollect() {
        super.flatCollect();
        ImmutableBag<String> actual = this.newBag().flatCollect(Lists.fixedSize::of);
        ImmutableBag<String> expected = this.newBag().collect(String::valueOf);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void flatCollectWithTarget() {
        MutableBag<String> actual = this.newBag().flatCollect(Lists.fixedSize::of, HashBag.newBag());
        ImmutableBag<String> expected = this.newBag().collect(String::valueOf);
        Assert.assertEquals(expected, actual);
    }

    @Override
    @Test
    public void detect() {
        super.detect();
        ImmutableBag<String> strings = this.newBag();
        Assert.assertEquals("1", strings.detect("1"::equals));
        Assert.assertNull(strings.detect(String.valueOf(this.numKeys() + 1)::equals));
    }

    @Override
    @Test
    public void detectWith() {
        super.detectWith();
        ImmutableBag<String> immutableStrings = this.newBag();
        Assert.assertEquals("1", immutableStrings.detectWith(Object::equals, "1"));
    }

    @Test
    public void detectWithIfNone() {
        ImmutableBag<String> immutableStrings = this.newBag();
        Assert.assertEquals("1", immutableStrings.detectWithIfNone(Object::equals, "1", new PassThruFunction0<>("Not Found")));
        Assert.assertEquals("Not Found", immutableStrings.detectWithIfNone(Object::equals, "10000", new PassThruFunction0<>("Not Found")));
    }

    @Override
    @Test
    public void zip() {
        super.zip();
        ImmutableBag<String> immutableBag = this.newBag();
        List<Object> nulls = Collections.nCopies(immutableBag.size(), null);
        List<Object> nullsPlusOne = Collections.nCopies(immutableBag.size() + 1, null);
        List<Object> nullsMinusOne = Collections.nCopies(immutableBag.size() - 1, null);
        ImmutableBag<Pair<String, Object>> pairs = immutableBag.zip(nulls);
        Assert.assertEquals(immutableBag, pairs.collect((Function<Pair<String, ?>, String>) Pair::getOne));
        Assert.assertEquals(HashBag.newBag(nulls), pairs.collect((Function<Pair<?, Object>, Object>) Pair::getTwo));
        ImmutableBag<Pair<String, Object>> pairsPlusOne = immutableBag.zip(nullsPlusOne);
        Assert.assertEquals(immutableBag, pairsPlusOne.collect((Function<Pair<String, ?>, String>) Pair::getOne));
        Assert.assertEquals(HashBag.newBag(nulls), pairsPlusOne.collect((Function<Pair<?, Object>, Object>) Pair::getTwo));
        ImmutableBag<Pair<String, Object>> pairsMinusOne = immutableBag.zip(nullsMinusOne);
        Assert.assertEquals(immutableBag.size() - 1, pairsMinusOne.size());
        Assert.assertTrue(immutableBag.containsAllIterable(pairsMinusOne.collect((Function<Pair<String, ?>, String>) Pair::getOne)));
        Assert.assertEquals(immutableBag.zip(nulls), immutableBag.zip(nulls, HashBag.newBag()));
    }

    @Override
    @Test
    public void zipWithIndex() {
        super.zipWithIndex();
        ImmutableBag<String> immutableBag = this.newBag();
        ImmutableSet<Pair<String, Integer>> pairs = immutableBag.zipWithIndex();
        Assert.assertEquals(immutableBag, pairs.collect((Function<Pair<String, ?>, String>) Pair::getOne, HashBag.newBag()));
        Assert.assertEquals(Interval.zeroTo(immutableBag.size() - 1).toSet(), pairs.collect((Function<Pair<?, Integer>, Integer>) Pair::getTwo));
        Assert.assertEquals(immutableBag.zipWithIndex(), immutableBag.zipWithIndex(UnifiedSet.newSet()));
    }

    @Override
    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        super.chunk_zero_throws();
        this.newBag().chunk(0);
    }

    @Override
    @Test
    public void chunk_large_size() {
        super.chunk_large_size();
        Assert.assertEquals(this.newBag(), this.newBag().chunk(10).getOnly());
        Verify.assertInstanceOf(ImmutableBag.class, this.newBag().chunk(10).getOnly());
    }

    private ImmutableBag<String> classUnderTestWithNull() {
        return this.newBag().newWith(null);
    }

    @Override
    @Test(expected = NullPointerException.class)
    public void min_null_throws() {
        this.classUnderTestWithNull().min(String::compareTo);
    }

    @Override
    @Test(expected = NullPointerException.class)
    public void max_null_throws() {
        this.classUnderTestWithNull().max(String::compareTo);
    }

    @Override
    @Test
    public void min() {
        super.min();
        Assert.assertEquals("1", this.newBag().min(String::compareTo));
    }

    @Override
    @Test
    public void max() {
        super.max();
        Assert.assertEquals(String.valueOf(this.numKeys()), this.newBag().max(String::compareTo));
    }

    @Override
    @Test(expected = NullPointerException.class)
    public void min_null_throws_without_comparator() {
        this.classUnderTestWithNull().min();
    }

    @Override
    @Test(expected = NullPointerException.class)
    public void max_null_throws_without_comparator() {
        this.classUnderTestWithNull().max();
    }

    @Override
    @Test
    public void min_without_comparator() {
        super.min_without_comparator();
        Assert.assertEquals("1", this.newBag().min());
    }

    @Override
    @Test
    public void max_without_comparator() {
        super.max_without_comparator();
        Assert.assertEquals(String.valueOf(this.numKeys()), this.newBag().max());
    }

    @Override
    @Test
    public void minBy() {
        super.minBy();
        Assert.assertEquals("1", this.newBag().minBy(String::valueOf));
    }

    @Override
    @Test
    public void maxBy() {
        super.maxBy();
        Assert.assertEquals(String.valueOf(this.numKeys()), this.newBag().maxBy(String::valueOf));
    }

    @Override
    @Test
    public void detectIfNone() {
        super.detectIfNone();
        ImmutableBag<String> strings = this.newBag();
        Function0<String> function = new PassThruFunction0<>(String.valueOf(this.numKeys() + 1));
        Assert.assertEquals("1", strings.detectIfNone("1"::equals, function));
        Assert.assertEquals(String.valueOf(this.numKeys() + 1), strings.detectIfNone(String.valueOf(this.numKeys() + 1)::equals, function));
    }

    @Override
    @Test
    public void allSatisfy() {
        super.allSatisfy();
        ImmutableBag<String> strings = this.newBag();
        Assert.assertTrue(strings.allSatisfy(String.class::isInstance));
        Assert.assertFalse(strings.allSatisfy("0"::equals));
    }

    @Override
    @Test
    public void anySatisfy() {
        super.anySatisfy();
        ImmutableBag<String> strings = this.newBag();
        Assert.assertFalse(strings.anySatisfy(Integer.class::isInstance));
        Assert.assertTrue(strings.anySatisfy(String.class::isInstance));
    }

    @Override
    @Test
    public void noneSatisfy() {
        super.noneSatisfy();
        ImmutableBag<String> strings = this.newBag();
        Assert.assertTrue(strings.noneSatisfy(Integer.class::isInstance));
        Assert.assertTrue(strings.noneSatisfy("0"::equals));
    }

    @Override
    @Test
    public void count() {
        super.count();
        ImmutableBag<String> strings = this.newBag();
        Assert.assertEquals(strings.size(), strings.count(String.class::isInstance));
        Assert.assertEquals(0, strings.count(Integer.class::isInstance));
    }

    @Override
    @Test
    public void countWith() {
        super.countWith();
        ImmutableBag<String> strings = this.newBag();
        Assert.assertEquals(strings.size(), strings.countWith(Predicates2.instanceOf(), String.class));
        Assert.assertEquals(0, strings.countWith(Predicates2.instanceOf(), Integer.class));
    }

    @Override
    @Test
    public void collectIf() {
        super.collectIf();
        ImmutableBag<String> strings = this.newBag();
        Assert.assertEquals(strings, strings.collectIf(String.class::isInstance, Functions.getStringPassThru()));
    }

    @Test
    public void collectIfWithTarget() {
        ImmutableBag<String> strings = this.newBag();
        Assert.assertEquals(strings, strings.collectIf(String.class::isInstance, Functions.getStringPassThru(), HashBag.newBag()));
    }

    @Override
    @Test
    public void getFirst() {
        super.getFirst();
        // Cannot assert much here since there's no order.
        ImmutableBag<String> bag = this.newBag();
        Assert.assertTrue(bag.contains(bag.getFirst()));
    }

    @Override
    @Test
    public void getLast() {
        super.getLast();
        // Cannot assert much here since there's no order.
        ImmutableBag<String> bag = this.newBag();
        Assert.assertTrue(bag.contains(bag.getLast()));
    }

    @Override
    @Test
    public void isEmpty() {
        super.isEmpty();
        ImmutableBag<String> bag = this.newBag();
        Assert.assertFalse(bag.isEmpty());
        Assert.assertTrue(bag.notEmpty());
    }

    @Override
    @Test
    public void iterator() {
        super.iterator();
        ImmutableBag<String> strings = this.newBag();
        MutableBag<String> result = Bags.mutable.of();
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String string = iterator.next();
            result.add(string);
        }
        Assert.assertEquals(strings, result);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        ImmutableBag<Integer> integers = this.newWith(4, 4, 4, 4, 3, 3, 3, 2, 2, 1);
        Integer result = integers.injectInto(0, AddFunction.INTEGER);
        Assert.assertEquals(FastList.newList(integers).injectInto(0, AddFunction.INTEGER_TO_INT), result.intValue());
        String result1 = this.newBag().injectInto("0", String::concat);
        Assert.assertEquals(FastList.newList(this.newBag()).injectInto("0", String::concat), result1);
    }

    @Override
    @Test
    public void injectIntoInt() {
        super.injectIntoInt();
        ImmutableBag<Integer> integers = this.newWith(4, 4, 4, 4, 3, 3, 3, 2, 2, 1);
        int result = integers.injectInto(0, AddFunction.INTEGER_TO_INT);
        Assert.assertEquals(FastList.newList(integers).injectInto(0, AddFunction.INTEGER_TO_INT), result);
    }

    @Override
    @Test
    public void injectIntoLong() {
        super.injectIntoLong();
        ImmutableBag<Integer> integers = this.newWith(4, 4, 4, 4, 3, 3, 3, 2, 2, 1);
        long result = integers.injectInto(0, AddFunction.INTEGER_TO_LONG);
        Assert.assertEquals(FastList.newList(integers).injectInto(0, AddFunction.INTEGER_TO_INT), result);
    }

    @Override
    @Test
    public void injectIntoDouble() {
        super.injectIntoDouble();
        ImmutableBag<Integer> integers = this.newWith(4, 4, 4, 4, 3, 3, 3, 2, 2, 1);
        double result = integers.injectInto(0, AddFunction.INTEGER_TO_DOUBLE);
        double expected = FastList.newList(integers).injectInto(0, AddFunction.INTEGER_TO_DOUBLE);
        Assert.assertEquals(expected, result, 0.001);
    }

    @Override
    @Test
    public void injectIntoFloat() {
        super.injectIntoFloat();
        ImmutableBag<Integer> integers = this.newWith(4, 4, 4, 4, 3, 3, 3, 2, 2, 1);
        float result = integers.injectInto(0, AddFunction.INTEGER_TO_FLOAT);
        float expected = FastList.newList(integers).injectInto(0, AddFunction.INTEGER_TO_FLOAT);
        Assert.assertEquals(expected, result, 0.001);
    }

    @Override
    @Test
    public void sumFloat() {
        super.sumFloat();
        ImmutableBag<Integer> integers = this.newWith(4, 4, 4, 4, 3, 3, 3, 2, 2, 1);
        double result = integers.sumOfFloat(Integer::floatValue);
        float expected = FastList.newList(integers).injectInto(0, AddFunction.INTEGER_TO_FLOAT);
        Assert.assertEquals(expected, result, 0.001);
    }

    @Override
    @Test
    public void sumDouble() {
        super.sumDouble();
        ImmutableBag<Integer> integers = this.newWith(4, 4, 4, 4, 3, 3, 3, 2, 2, 1);
        double result = integers.sumOfDouble(Integer::doubleValue);
        double expected = FastList.newList(integers).injectInto(0, AddFunction.INTEGER_TO_DOUBLE);
        Assert.assertEquals(expected, result, 0.001);
    }

    @Override
    @Test
    public void sumInteger() {
        super.sumInteger();
        ImmutableBag<Integer> integers = this.newWith(4, 4, 4, 4, 3, 3, 3, 2, 2, 1);
        long result = integers.sumOfInt(integer -> integer);
        int expected = FastList.newList(integers).injectInto(0, AddFunction.INTEGER_TO_INT);
        Assert.assertEquals(expected, result);
    }

    @Override
    @Test
    public void sumLong() {
        super.sumLong();
        ImmutableBag<Integer> integers = this.newWith(4, 4, 4, 4, 3, 3, 3, 2, 2, 1);
        long result = integers.sumOfLong(Integer::longValue);
        long expected = FastList.newList(integers).injectInto(0, AddFunction.INTEGER_TO_LONG);
        Assert.assertEquals(expected, result);
    }

    @Override
    @Test
    public void toArray() {
        super.toArray();
        ImmutableBag<String> bag = this.newBag();
        Object[] array = bag.toArray();
        Verify.assertSize(bag.size(), array);
        String[] array2 = bag.toArray(new String[bag.size() + 1]);
        Verify.assertSize(bag.size() + 1, array2);
        Assert.assertNull(array2[bag.size()]);
    }

    @Override
    @Test
    public void testToString() {
        super.testToString();
        String string = this.newBag().toString();
        for (int i = 1; i < this.numKeys(); i++) {
            Assert.assertEquals(i, StringIterate.occurrencesOf(string, String.valueOf(i)));
        }
    }

    @Override
    @Test
    public void toList() {
        super.toList();
        ImmutableBag<String> strings = this.newBag();
        MutableList<String> list = strings.toList();
        Verify.assertEqualsAndHashCode(FastList.newList(strings), list);
    }

    @Test
    public void toSortedList() {
        ImmutableBag<String> strings = this.newBag();
        MutableList<String> copy = FastList.newList(strings);
        MutableList<String> list = strings.toSortedList(Collections.reverseOrder());
        Assert.assertEquals(copy.sortThis(Collections.reverseOrder()), list);
        MutableList<String> list2 = strings.toSortedList();
        Assert.assertEquals(copy.sortThis(), list2);
    }

    @Override
    @Test
    public void toSortedListBy() {
        super.toSortedListBy();
        MutableList<String> expected = this.newBag().toList();
        Collections.sort(expected);
        ImmutableBag<String> immutableBag = this.newBag();
        MutableList<String> sortedList = immutableBag.toSortedListBy(String::valueOf);
        Assert.assertEquals(expected, sortedList);
    }

    @Test
    public void forLoop() {
        ImmutableBag<String> bag = this.newBag();
        for (String each : bag) {
            Assert.assertNotNull(each);
        }
    }

    @Test
    public void iteratorRemove() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newBag().iterator().remove());
    }

    @Test
    public void toMapOfItemToCount() {
        MapIterable<String, Integer> mapOfItemToCount = this.newBag().toMapOfItemToCount();
        for (int i = 1; i <= this.numKeys(); i++) {
            String key = String.valueOf(i);
            Assert.assertTrue(mapOfItemToCount.containsKey(key));
            Assert.assertEquals(Integer.valueOf(i), mapOfItemToCount.get(key));
        }
        String missingKey = "0";
        Assert.assertFalse(mapOfItemToCount.containsKey(missingKey));
        Assert.assertNull(mapOfItemToCount.get(missingKey));
    }

    @Test
    public void toImmutable() {
        ImmutableBag<String> bag = this.newBag();
        Assert.assertSame(bag, bag.toImmutable());
    }

    /**
     * @since 9.0
     */
    @Override
    @Test
    public void countBy() {
        super.countBy();
        ImmutableBag<String> integers = this.newBag();
        ImmutableBag<String> results = integers.countBy(each -> each);
        Verify.assertSize(integers.size(), results);
        MutableBag<String> results2 = integers.countBy(each -> each, Bags.mutable.empty());
        Verify.assertSize(integers.size(), results2);
    }

    /**
     * @since 9.0
     */
    @Override
    @Test
    public void countByWith() {
        super.countByWith();
        ImmutableBag<String> integers = this.newBag();
        ImmutableBag<String> results = integers.countByWith((each, parm) -> each, null);
        Verify.assertSize(integers.size(), results);
        MutableBag<String> results2 = integers.countByWith((each, parm) -> each, null, Bags.mutable.empty());
        Verify.assertSize(integers.size(), results2);
    }

    /**
     * @since 10.0.0
     */
    @Override
    @Test
    public void countByEach() {
        super.countByEach();
        ImmutableBag<String> integers = this.newBag();
        ImmutableBag<String> results = integers.countByEach(each -> IntInterval.oneTo(5).collect(i -> each + i));
        Verify.assertSize(integers.size() * 5, results);
        MutableBag<String> results2 = integers.countByEach(each -> IntInterval.oneTo(5).collect(i -> each + i), Bags.mutable.empty());
        Verify.assertSize(integers.size() * 5, results2);
    }

    @Override
    @Test
    public void groupBy() {
        super.groupBy();
        ImmutableBagMultimap<Boolean, String> multimap = this.newBag().groupBy(string -> IntegerPredicates.isOdd().accept(Integer.valueOf(string)));
        this.groupByAssertions(multimap);
    }

    @Test
    public void groupBy_with_target() {
        ImmutableBagMultimap<Boolean, String> multimap = this.newBag().groupBy(string -> IntegerPredicates.isOdd().accept(Integer.valueOf(string)), new HashBagMultimap<>()).toImmutable();
        this.groupByAssertions(multimap);
    }

    @Override
    @Test
    public void groupByEach() {
        super.groupByEach();
        ImmutableBag<Integer> immutableBag = this.newBag().collect(Integer::valueOf);
        MutableMultimap<Integer, Integer> expected = HashBagMultimap.newMultimap();
        int keys = this.numKeys();
        immutableBag.forEachWithOccurrences((each, parameter) -> {
            HashBag<Integer> bag = HashBag.newBag();
            Interval.fromTo(each, keys).forEach((int eachInt) -> bag.addOccurrences(eachInt, eachInt));
            expected.putAll(-each, bag);
        });
        Multimap<Integer, Integer> actual = immutableBag.groupByEach(new NegativeIntervalFunction());
        Assert.assertEquals(expected, actual);
        Multimap<Integer, Integer> actualWithTarget = immutableBag.groupByEach(new NegativeIntervalFunction(), HashBagMultimap.newMultimap());
        Assert.assertEquals(expected, actualWithTarget);
    }

    private void groupByAssertions(ImmutableBagMultimap<Boolean, String> multimap) {
        Verify.assertIterableEmpty(multimap.get(null));
        ImmutableBag<String> odds = multimap.get(true);
        ImmutableBag<String> evens = multimap.get(false);
        for (int i = 1; i <= this.numKeys(); i++) {
            String key = String.valueOf(i);
            ImmutableBag<String> containingBag = IntegerPredicates.isOdd().accept(i) ? odds : evens;
            ImmutableBag<String> nonContainingBag = IntegerPredicates.isOdd().accept(i) ? evens : odds;
            Assert.assertTrue(containingBag.contains(key));
            Assert.assertFalse(nonContainingBag.contains(key));
            Assert.assertEquals(i, containingBag.occurrencesOf(key));
        }
    }

    @Override
    @Test(expected = IllegalStateException.class)
    public abstract void groupByUniqueKey();

    @Test(expected = IllegalStateException.class)
    public void groupByUniqueKey_throws() {
        this.newBag().groupByUniqueKey(id -> id);
    }

    @Override
    @Test(expected = IllegalStateException.class)
    public abstract void groupByUniqueKey_target();

    @Test(expected = IllegalStateException.class)
    public void groupByUniqueKey_target_throws() {
        this.newBag().groupByUniqueKey(id -> id, UnifiedMap.newWithKeysValues("1", "1"));
    }

    @Override
    @Test
    public void toSet() {
        super.toSet();
        MutableSet<String> expectedSet = this.numKeys() == 0 ? UnifiedSet.newSet() : Interval.oneTo(this.numKeys()).collect(String::valueOf).toSet();
        Assert.assertEquals(expectedSet, this.newBag().toSet());
    }

    @Override
    @Test
    public void toBag() {
        super.toBag();
        ImmutableBag<String> immutableBag = this.newBag();
        MutableBag<String> mutableBag = immutableBag.toBag();
        Assert.assertEquals(immutableBag, mutableBag);
    }

    @Override
    @Test
    public void toMap() {
        super.toMap();
        MutableMap<String, String> map = this.newBag().toMap(Functions.getPassThru(), Functions.getPassThru());
        for (int i = 1; i <= this.numKeys(); i++) {
            String key = String.valueOf(i);
            Assert.assertTrue(map.containsKey(key));
            Assert.assertEquals(key, map.get(key));
        }
        String missingKey = "0";
        Assert.assertFalse(map.containsKey(missingKey));
        Assert.assertNull(map.get(missingKey));
    }

    @Override
    @Test
    public void toMapTarget() {
        super.toMapTarget();
        Map<String, String> map = this.newBag().toMap(Functions.getPassThru(), Functions.getPassThru(), new HashMap<>());
        for (int i = 1; i <= this.numKeys(); i++) {
            String key = String.valueOf(i);
            Assert.assertTrue(map.containsKey(key));
            Assert.assertEquals(key, map.get(key));
        }
        String missingKey = "0";
        Assert.assertFalse(map.containsKey(missingKey));
        Assert.assertNull(map.get(missingKey));
    }

    @Override
    @Test
    public void toSortedMap() {
        super.toSortedMap();
        MutableSortedMap<Integer, String> map = this.newBag().toSortedMap(Integer::valueOf, Functions.getPassThru());
        Verify.assertMapsEqual(this.newBag().toMap(Integer::valueOf, Functions.getPassThru()), map);
        Verify.assertListsEqual(Interval.oneTo(this.numKeys()), map.keySet().toList());
    }

    @Override
    @Test
    public void toSortedMap_with_comparator() {
        super.toSortedMap_with_comparator();
        MutableSortedMap<Integer, String> map = this.newBag().toSortedMap(Comparators.reverseNaturalOrder(), Integer::valueOf, Functions.getPassThru());
        Verify.assertMapsEqual(this.newBag().toMap(Integer::valueOf, Functions.getPassThru()), map);
        Verify.assertListsEqual(Interval.fromTo(this.numKeys(), 1), map.keySet().toList());
    }

    @Override
    @Test
    public void toSortedMapBy() {
        super.toSortedMapBy();
        MutableSortedMap<Integer, String> map = this.newBag().toSortedMapBy(key -> -key, Integer::valueOf, Functions.getPassThru());
        Verify.assertMapsEqual(this.newBag().toMap(Integer::valueOf, Functions.getPassThru()), map);
        Verify.assertListsEqual(Interval.fromTo(this.numKeys(), 1), map.keySet().toList());
    }

    @Test
    public void asLazy() {
        ImmutableBag<String> bag = this.newBag();
        LazyIterable<String> lazyIterable = bag.asLazy();
        Verify.assertInstanceOf(LazyIterable.class, lazyIterable);
        Assert.assertEquals(bag, lazyIterable.toBag());
    }

    @Override
    @Test
    public void makeString() {
        super.makeString();
        ImmutableBag<String> bag = this.newBag();
        Assert.assertEquals(FastList.newList(bag).makeString(), bag.makeString());
        Assert.assertEquals(bag.toString(), '[' + bag.makeString() + ']');
        Assert.assertEquals(bag.toString(), '[' + bag.makeString(", ") + ']');
        Assert.assertEquals(bag.toString(), bag.makeString("[", ", ", "]"));
    }

    @Override
    @Test
    public void appendString() {
        super.appendString();
        ImmutableBag<String> bag = this.newBag();
        Appendable builder = new StringBuilder();
        bag.appendString(builder);
        Assert.assertEquals(FastList.newList(bag).makeString(), builder.toString());
    }

    @Test
    public void appendString_with_separator() {
        ImmutableBag<String> bag = this.newBag();
        Appendable builder = new StringBuilder();
        bag.appendString(builder, ", ");
        Assert.assertEquals(bag.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendString_with_start_separator_end() {
        ImmutableBag<String> bag = this.newBag();
        Appendable builder = new StringBuilder();
        bag.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(bag.toString(), builder.toString());
    }

    @Test
    public void serialization() {
        ImmutableBag<String> bag = this.newBag();
        Verify.assertPostSerializedEqualsAndHashCode(bag);
    }

    @Test
    public void toSortedBag() {
        ImmutableBag<String> immutableBag = this.newBag();
        MutableSortedBag<String> sortedBag = immutableBag.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith("1", "2", "2", "3", "3", "3", "4", "4", "4", "4"), sortedBag);
        MutableSortedBag<String> reverse = immutableBag.toSortedBag(Comparator.reverseOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparator.reverseOrder(), "1", "2", "2", "3", "3", "3", "4", "4", "4", "4"), reverse);
    }

    @Override
    @Test
    public void toSortedBagBy() {
        super.toSortedBagBy();
        ImmutableBag<String> immutableBag = this.newBag();
        MutableSortedBag<String> sortedBag = immutableBag.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith("1", "2", "2", "3", "3", "3", "4", "4", "4", "4"), sortedBag);
    }

    @Test
    public void selectUnique() {
        ImmutableBag<String> bag = Bags.immutable.with("1", "2", "2", "3", "3", "3", "3", "4", "5", "5", "6");
        ImmutableSet<String> expected = Sets.immutable.with("1", "4", "6");
        ImmutableSet<String> actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void distinctView() {
        ImmutableBag<String> bag = this.newBag();
        RichIterable<String> expected = bag.toSet();
        RichIterable<String> actual = bag.distinctView();
        Assert.assertEquals(expected, actual);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableBagTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsBy);
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
        public void benchmark_containsAllCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_safe);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_safe);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minByOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxByOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNoneBlock() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNoneBlock);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAny() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAny);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_not_only_one_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_not_only_one_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding1);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding2);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding1);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding2);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeLong);
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
        public void benchmark_sumByFloatConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloatConsistentRounding);
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
        public void benchmark_sumByDoubleConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDoubleConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_null);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_null);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedListBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortSet_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSet_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSetBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy_with_null);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBiMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBiMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparatorAndStartAndEnd);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_fusedCollectMakeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.fusedCollectMakeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparatorAndStartAndEnd);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringThrows);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws_for_duplicate);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_for_duplicate);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_single() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_single);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
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
        public void benchmark_reduceOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSize);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWithOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWithOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWithOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStringOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStringOfItemToCount);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
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
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectByOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectByOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectDuplicates() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectDuplicates);
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
        public void benchmark_selectWithToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithToTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectToTarget);
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
        public void benchmark_rejectWithToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithToTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectToTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws);
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
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_without_comparator);
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
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
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
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIfWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIfWithTarget);
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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
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
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumInteger);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
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
        public void benchmark_forLoop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forLoop);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorRemove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorRemove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapOfItemToCount);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
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
        public void benchmark_groupBy_with_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy_with_target);
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
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMapBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString_with_separator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString_with_separator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString_with_start_separator_end() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString_with_start_separator_end);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
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
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectUnique);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctView);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> payload) throws java.lang.Throwable {
            this.instance = new ImmutableBagTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> testSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> anySatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> allSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> noneSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> detectWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> newWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collectWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> selectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> selectToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> rejectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> rejectToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collect_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> forLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toMapOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> groupBy_with_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> appendString_with_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> appendString_with_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBagTestCase> distinctView;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = ImmutableBagTestCase::testNewCollection;
            this.payloads.containsBy = ImmutableBagTestCase::containsBy;
            this.payloads.containsAnyIterable = ImmutableBagTestCase::containsAnyIterable;
            this.payloads.containsNoneIterable = ImmutableBagTestCase::containsNoneIterable;
            this.payloads.containsAnyCollection = ImmutableBagTestCase::containsAnyCollection;
            this.payloads.containsNoneCollection = ImmutableBagTestCase::containsNoneCollection;
            this.payloads.containsAllCollection = ImmutableBagTestCase::containsAllCollection;
            this.payloads.selectWith_target = ImmutableBagTestCase::selectWith_target;
            this.payloads.rejectWith_target = ImmutableBagTestCase::rejectWith_target;
            this.payloads.selectInstancesOf = ImmutableBagTestCase::selectInstancesOf;
            this.payloads.collectTarget = ImmutableBagTestCase::collectTarget;
            this.payloads.collectBooleanWithBagTarget = ImmutableBagTestCase::collectBooleanWithBagTarget;
            this.payloads.collectByteWithBagTarget = ImmutableBagTestCase::collectByteWithBagTarget;
            this.payloads.collectCharWithBagTarget = ImmutableBagTestCase::collectCharWithBagTarget;
            this.payloads.collectDoubleWithBagTarget = ImmutableBagTestCase::collectDoubleWithBagTarget;
            this.payloads.collectFloatWithBagTarget = ImmutableBagTestCase::collectFloatWithBagTarget;
            this.payloads.collectIntWithBagTarget = ImmutableBagTestCase::collectIntWithBagTarget;
            this.payloads.collectLongWithBagTarget = ImmutableBagTestCase::collectLongWithBagTarget;
            this.payloads.collectShortWithBagTarget = ImmutableBagTestCase::collectShortWithBagTarget;
            this.payloads.flatCollectWith = ImmutableBagTestCase::flatCollectWith;
            this.payloads.flatCollectBoolean = ImmutableBagTestCase::flatCollectBoolean;
            this.payloads.flatCollectByte = ImmutableBagTestCase::flatCollectByte;
            this.payloads.flatCollectShort = ImmutableBagTestCase::flatCollectShort;
            this.payloads.flatCollectInt = ImmutableBagTestCase::flatCollectInt;
            this.payloads.flatCollectChar = ImmutableBagTestCase::flatCollectChar;
            this.payloads.flatCollectLong = ImmutableBagTestCase::flatCollectLong;
            this.payloads.flatCollectDouble = ImmutableBagTestCase::flatCollectDouble;
            this.payloads.flatCollectFloat = ImmutableBagTestCase::flatCollectFloat;
            this.payloads.detectOptional = ImmutableBagTestCase::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBagTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBagTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minOptional = ImmutableBagTestCase::minOptional;
            this.payloads.maxOptional = ImmutableBagTestCase::maxOptional;
            this.payloads.min_null_safe = ImmutableBagTestCase::min_null_safe;
            this.payloads.max_null_safe = ImmutableBagTestCase::max_null_safe;
            this.payloads.minByOptional = ImmutableBagTestCase::minByOptional;
            this.payloads.maxByOptional = ImmutableBagTestCase::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBagTestCase::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBagTestCase::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWithOptional = ImmutableBagTestCase::detectWithOptional;
            this.payloads.detectWithIfNoneBlock = ImmutableBagTestCase::detectWithIfNoneBlock;
            this.payloads.allSatisfyWith = ImmutableBagTestCase::allSatisfyWith;
            this.payloads.noneSatisfyWith = ImmutableBagTestCase::noneSatisfyWith;
            this.payloads.anySatisfyWith = ImmutableBagTestCase::anySatisfyWith;
            this.payloads.getAny = ImmutableBagTestCase::getAny;
            this.payloads.getOnly = ImmutableBagTestCase::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBagTestCase::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBagTestCase::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBagTestCase::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.summarizeFloat = ImmutableBagTestCase::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = ImmutableBagTestCase::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = ImmutableBagTestCase::sumFloatConsistentRounding2;
            this.payloads.summarizeDouble = ImmutableBagTestCase::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = ImmutableBagTestCase::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = ImmutableBagTestCase::sumDoubleConsistentRounding2;
            this.payloads.summarizeInt = ImmutableBagTestCase::summarizeInt;
            this.payloads.summarizeLong = ImmutableBagTestCase::summarizeLong;
            this.payloads.sumByInt = ImmutableBagTestCase::sumByInt;
            this.payloads.sumByFloat = ImmutableBagTestCase::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = ImmutableBagTestCase::sumByFloatConsistentRounding;
            this.payloads.sumByLong = ImmutableBagTestCase::sumByLong;
            this.payloads.sumByDouble = ImmutableBagTestCase::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = ImmutableBagTestCase::sumByDoubleConsistentRounding;
            this.payloads.toImmutableList = ImmutableBagTestCase::toImmutableList;
            this.payloads.toCollection = ImmutableBagTestCase::toCollection;
            this.payloads.toImmutableBag = ImmutableBagTestCase::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = ImmutableBagTestCase::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = ImmutableBagTestCase::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = ImmutableBagTestCase::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = ImmutableBagTestCase::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBagTestCase::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = ImmutableBagTestCase::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = ImmutableBagTestCase::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = ImmutableBagTestCase::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = ImmutableBagTestCase::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBagTestCase::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBagBy = ImmutableBagTestCase::toImmutableSortedBagBy;
            this.payloads.toImmutableSortedListBy = ImmutableBagTestCase::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = ImmutableBagTestCase::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = ImmutableBagTestCase::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = ImmutableBagTestCase::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = ImmutableBagTestCase::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = ImmutableBagTestCase::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = ImmutableBagTestCase::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBagTestCase::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSet = ImmutableBagTestCase::toImmutableSet;
            this.payloads.toImmutableMap = ImmutableBagTestCase::toImmutableMap;
            this.payloads.toBiMap = ImmutableBagTestCase::toBiMap;
            this.payloads.toImmutableBiMap = ImmutableBagTestCase::toImmutableBiMap;
            this.payloads.makeStringWithSeparator = ImmutableBagTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = ImmutableBagTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = ImmutableBagTestCase::fusedCollectMakeString;
            this.payloads.appendStringWithSeparator = ImmutableBagTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = ImmutableBagTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = ImmutableBagTestCase::appendStringThrows;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBagTestCase::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBagTestCase::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.chunk = ImmutableBagTestCase::chunk;
            this.payloads.chunk_empty = ImmutableBagTestCase::chunk_empty;
            this.payloads.chunk_single = ImmutableBagTestCase::chunk_single;
            this.payloads.empty = ImmutableBagTestCase::empty;
            this.payloads.notEmpty = ImmutableBagTestCase::notEmpty;
            this.payloads.aggregateByMutating = ImmutableBagTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableBagTestCase::aggregateByNonMutating;
            this.payloads.reduceOptional = ImmutableBagTestCase::reduceOptional;
            this.payloads.testSize = ImmutableBagTestCase::testSize;
            this.payloads.equalsAndHashCode = ImmutableBagTestCase::equalsAndHashCode;
            this.payloads.anySatisfyWithOccurrences = ImmutableBagTestCase::anySatisfyWithOccurrences;
            this.payloads.allSatisfyWithOccurrences = ImmutableBagTestCase::allSatisfyWithOccurrences;
            this.payloads.noneSatisfyWithOccurrences = ImmutableBagTestCase::noneSatisfyWithOccurrences;
            this.payloads.detectWithOccurrences = ImmutableBagTestCase::detectWithOccurrences;
            this.payloads.newWith = ImmutableBagTestCase::newWith;
            this.payloads.newWithout = ImmutableBagTestCase::newWithout;
            this.payloads.newWithAll = ImmutableBagTestCase::newWithAll;
            this.payloads.toStringOfItemToCount = ImmutableBagTestCase::toStringOfItemToCount;
            this.payloads.newWithoutAll = ImmutableBagTestCase::newWithoutAll;
            this.payloads.contains = ImmutableBagTestCase::contains;
            this.payloads.containsAllArray = ImmutableBagTestCase::containsAllArray;
            this.payloads.containsAllIterable = ImmutableBagTestCase::containsAllIterable;
            this.payloads.add = ImmutableBagTestCase::add;
            this.payloads.remove = ImmutableBagTestCase::remove;
            this.payloads.addAll = ImmutableBagTestCase::addAll;
            this.payloads.removeAll = ImmutableBagTestCase::removeAll;
            this.payloads.retainAll = ImmutableBagTestCase::retainAll;
            this.payloads.clear = ImmutableBagTestCase::clear;
            this.payloads.tap = ImmutableBagTestCase::tap;
            this.payloads.forEach = ImmutableBagTestCase::forEach;
            this.payloads.forEachWith = ImmutableBagTestCase::forEachWith;
            this.payloads.forEachWithIndex = ImmutableBagTestCase::forEachWithIndex;
            this.payloads.collectWithOccurrences = ImmutableBagTestCase::collectWithOccurrences;
            this.payloads.selectByOccurrences = ImmutableBagTestCase::selectByOccurrences;
            this.payloads.selectDuplicates = ImmutableBagTestCase::selectDuplicates;
            this.payloads.select = ImmutableBagTestCase::select;
            this.payloads.selectWith = ImmutableBagTestCase::selectWith;
            this.payloads.selectWithToTarget = ImmutableBagTestCase::selectWithToTarget;
            this.payloads.selectToTarget = ImmutableBagTestCase::selectToTarget;
            this.payloads.reject = ImmutableBagTestCase::reject;
            this.payloads.rejectWith = ImmutableBagTestCase::rejectWith;
            this.payloads.rejectWithToTarget = ImmutableBagTestCase::rejectWithToTarget;
            this.payloads.rejectToTarget = ImmutableBagTestCase::rejectToTarget;
            this.payloads.partition = ImmutableBagTestCase::partition;
            this.payloads.partitionWith = ImmutableBagTestCase::partitionWith;
            this.payloads.collect = ImmutableBagTestCase::collect;
            this.payloads.collectBoolean = ImmutableBagTestCase::collectBoolean;
            this.payloads.collectBooleanWithTarget = ImmutableBagTestCase::collectBooleanWithTarget;
            this.payloads.collectByte = ImmutableBagTestCase::collectByte;
            this.payloads.collectByteWithTarget = ImmutableBagTestCase::collectByteWithTarget;
            this.payloads.collectChar = ImmutableBagTestCase::collectChar;
            this.payloads.collectCharWithTarget = ImmutableBagTestCase::collectCharWithTarget;
            this.payloads.collectDouble = ImmutableBagTestCase::collectDouble;
            this.payloads.collectDoubleWithTarget = ImmutableBagTestCase::collectDoubleWithTarget;
            this.payloads.collectFloat = ImmutableBagTestCase::collectFloat;
            this.payloads.collectFloatWithTarget = ImmutableBagTestCase::collectFloatWithTarget;
            this.payloads.collectInt = ImmutableBagTestCase::collectInt;
            this.payloads.collectIntWithTarget = ImmutableBagTestCase::collectIntWithTarget;
            this.payloads.collectLong = ImmutableBagTestCase::collectLong;
            this.payloads.collectLongWithTarget = ImmutableBagTestCase::collectLongWithTarget;
            this.payloads.collectShort = ImmutableBagTestCase::collectShort;
            this.payloads.collectShortWithTarget = ImmutableBagTestCase::collectShortWithTarget;
            this.payloads.collectWith = ImmutableBagTestCase::collectWith;
            this.payloads.collectWith_target = ImmutableBagTestCase::collectWith_target;
            this.payloads.collect_target = ImmutableBagTestCase::collect_target;
            this.payloads.flatCollect = ImmutableBagTestCase::flatCollect;
            this.payloads.flatCollectWithTarget = ImmutableBagTestCase::flatCollectWithTarget;
            this.payloads.detect = ImmutableBagTestCase::detect;
            this.payloads.detectWith = ImmutableBagTestCase::detectWith;
            this.payloads.detectWithIfNone = ImmutableBagTestCase::detectWithIfNone;
            this.payloads.zip = ImmutableBagTestCase::zip;
            this.payloads.zipWithIndex = ImmutableBagTestCase::zipWithIndex;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBagTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = ImmutableBagTestCase::chunk_large_size;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBagTestCase::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBagTestCase::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = ImmutableBagTestCase::min;
            this.payloads.max = ImmutableBagTestCase::max;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBagTestCase::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBagTestCase::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = ImmutableBagTestCase::min_without_comparator;
            this.payloads.max_without_comparator = ImmutableBagTestCase::max_without_comparator;
            this.payloads.minBy = ImmutableBagTestCase::minBy;
            this.payloads.maxBy = ImmutableBagTestCase::maxBy;
            this.payloads.detectIfNone = ImmutableBagTestCase::detectIfNone;
            this.payloads.allSatisfy = ImmutableBagTestCase::allSatisfy;
            this.payloads.anySatisfy = ImmutableBagTestCase::anySatisfy;
            this.payloads.noneSatisfy = ImmutableBagTestCase::noneSatisfy;
            this.payloads.count = ImmutableBagTestCase::count;
            this.payloads.countWith = ImmutableBagTestCase::countWith;
            this.payloads.collectIf = ImmutableBagTestCase::collectIf;
            this.payloads.collectIfWithTarget = ImmutableBagTestCase::collectIfWithTarget;
            this.payloads.getFirst = ImmutableBagTestCase::getFirst;
            this.payloads.getLast = ImmutableBagTestCase::getLast;
            this.payloads.isEmpty = ImmutableBagTestCase::isEmpty;
            this.payloads.iterator = ImmutableBagTestCase::iterator;
            this.payloads.injectInto = ImmutableBagTestCase::injectInto;
            this.payloads.injectIntoInt = ImmutableBagTestCase::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableBagTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableBagTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = ImmutableBagTestCase::injectIntoFloat;
            this.payloads.sumFloat = ImmutableBagTestCase::sumFloat;
            this.payloads.sumDouble = ImmutableBagTestCase::sumDouble;
            this.payloads.sumInteger = ImmutableBagTestCase::sumInteger;
            this.payloads.sumLong = ImmutableBagTestCase::sumLong;
            this.payloads.toArray = ImmutableBagTestCase::toArray;
            this.payloads.testToString = ImmutableBagTestCase::testToString;
            this.payloads.toList = ImmutableBagTestCase::toList;
            this.payloads.toSortedList = ImmutableBagTestCase::toSortedList;
            this.payloads.toSortedListBy = ImmutableBagTestCase::toSortedListBy;
            this.payloads.forLoop = ImmutableBagTestCase::forLoop;
            this.payloads.iteratorRemove = ImmutableBagTestCase::iteratorRemove;
            this.payloads.toMapOfItemToCount = ImmutableBagTestCase::toMapOfItemToCount;
            this.payloads.toImmutable = ImmutableBagTestCase::toImmutable;
            this.payloads.countBy = ImmutableBagTestCase::countBy;
            this.payloads.countByWith = ImmutableBagTestCase::countByWith;
            this.payloads.countByEach = ImmutableBagTestCase::countByEach;
            this.payloads.groupBy = ImmutableBagTestCase::groupBy;
            this.payloads.groupBy_with_target = ImmutableBagTestCase::groupBy_with_target;
            this.payloads.groupByEach = ImmutableBagTestCase::groupByEach;
            this.payloads.groupByUniqueKey = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBagTestCase::groupByUniqueKey, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBagTestCase::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBagTestCase::groupByUniqueKey_target, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBagTestCase::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.toSet = ImmutableBagTestCase::toSet;
            this.payloads.toBag = ImmutableBagTestCase::toBag;
            this.payloads.toMap = ImmutableBagTestCase::toMap;
            this.payloads.toMapTarget = ImmutableBagTestCase::toMapTarget;
            this.payloads.toSortedMap = ImmutableBagTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = ImmutableBagTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = ImmutableBagTestCase::toSortedMapBy;
            this.payloads.asLazy = ImmutableBagTestCase::asLazy;
            this.payloads.makeString = ImmutableBagTestCase::makeString;
            this.payloads.appendString = ImmutableBagTestCase::appendString;
            this.payloads.appendString_with_separator = ImmutableBagTestCase::appendString_with_separator;
            this.payloads.appendString_with_start_separator_end = ImmutableBagTestCase::appendString_with_start_separator_end;
            this.payloads.serialization = ImmutableBagTestCase::serialization;
            this.payloads.toSortedBag = ImmutableBagTestCase::toSortedBag;
            this.payloads.toSortedBagBy = ImmutableBagTestCase::toSortedBagBy;
            this.payloads.selectUnique = ImmutableBagTestCase::selectUnique;
            this.payloads.distinctView = ImmutableBagTestCase::distinctView;
        }
    }
}
