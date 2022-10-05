/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.immutable.primitive;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.predicate.Predicate;
import org.eclipse.collections.api.block.predicate.Predicate2;
import org.eclipse.collections.api.map.primitive.ImmutableCharObjectMap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.impl.bag.sorted.mutable.TreeBag;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.factory.StringFunctions;
import org.eclipse.collections.impl.block.factory.StringPredicates;
import org.eclipse.collections.impl.block.factory.StringPredicates2;
import org.eclipse.collections.impl.factory.primitive.ObjectDoubleMaps;
import org.eclipse.collections.impl.factory.primitive.ObjectLongMaps;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.StringIterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableCharObjectEmptyMap}.
 * This file was automatically generated from template file immutablePrimitiveObjectEmptyMapTest.stg.
 */
public class ImmutableCharObjectEmptyMapTest extends AbstractImmutableCharObjectMapTestCase {

    public static final Predicate2<String, String> ERROR_THROWING_PREDICATE_2 = (String argument1, String argument2) -> {
        throw new AssertionError();
    };

    public static final Predicate<String> ERROR_THROWING_PREDICATE = (String each) -> {
        throw new AssertionError();
    };

    @Override
    protected ImmutableCharObjectMap<String> classUnderTest() {
        return (ImmutableCharObjectMap<String>) ImmutableCharObjectEmptyMap.INSTANCE;
    }

    @Override
    @Test
    public void containsValue() {
        Assert.assertFalse(this.classUnderTest().containsValue(null));
        Assert.assertFalse(this.classUnderTest().containsValue("zero"));
        Assert.assertFalse(this.classUnderTest().containsValue("thirtyOne"));
        Assert.assertFalse(this.classUnderTest().containsValue("thirtyTwo"));
    }

    @Override
    @Test
    public void contains() {
        Assert.assertFalse(this.classUnderTest().contains(null));
        Assert.assertFalse(this.classUnderTest().contains("zero"));
        Assert.assertFalse(this.classUnderTest().contains("thirtyOne"));
        Assert.assertFalse(this.classUnderTest().contains("thirtyTwo"));
    }

    @Override
    @Test
    public void containsAllIterable() {
        Assert.assertFalse(this.classUnderTest().containsAllIterable(FastList.newListWith("zero", "thirtyOne")));
        Assert.assertFalse(this.classUnderTest().containsAllIterable(FastList.newListWith("zero", "thirtyOne", "thirtyTwo")));
        Assert.assertFalse(this.classUnderTest().containsAllIterable(FastList.newListWith("zero", "one", "thirtyTwo")));
        Assert.assertFalse(this.classUnderTest().containsAllIterable(FastList.newListWith("two", "one", "nine")));
        Assert.assertTrue(this.classUnderTest().containsAllIterable(FastList.newListWith()));
    }

    @Override
    @Test
    public void containsAll() {
        Assert.assertFalse(this.classUnderTest().containsAll(FastList.newListWith("zero", "thirtyOne")));
        Assert.assertFalse(this.classUnderTest().containsAll(FastList.newListWith("zero", "thirtyOne", "thirtyTwo")));
        Assert.assertFalse(this.classUnderTest().containsAll(FastList.newListWith("zero", "one", "thirtyTwo")));
        Assert.assertFalse(this.classUnderTest().containsAll(FastList.newListWith("two", "one", "nine")));
        Assert.assertTrue(this.classUnderTest().containsAll(FastList.newListWith()));
    }

    @Override
    @Test
    public void containsAnyIterable() {
        Assert.assertFalse(this.classUnderTest().containsAnyIterable(FastList.newListWith("zero", "thirtyOne")));
        Assert.assertFalse(this.classUnderTest().containsAnyIterable(FastList.newListWith("zero", "thirtyOne", "thirtyTwo")));
        Assert.assertFalse(this.classUnderTest().containsAnyIterable(FastList.newListWith("zero", "one", "thirtyTwo")));
        Assert.assertFalse(this.classUnderTest().containsAnyIterable(FastList.newListWith("two", "one", "nine")));
        Assert.assertFalse(this.classUnderTest().containsAnyIterable(FastList.newListWith()));
    }

    @Override
    @Test
    public void containsAny() {
        Assert.assertFalse(this.classUnderTest().containsAny(FastList.newListWith("zero", "thirtyOne")));
        Assert.assertFalse(this.classUnderTest().containsAny(FastList.newListWith("zero", "thirtyOne", "thirtyTwo")));
        Assert.assertFalse(this.classUnderTest().containsAny(FastList.newListWith("zero", "one", "thirtyTwo")));
        Assert.assertFalse(this.classUnderTest().containsAny(FastList.newListWith("two", "one", "nine")));
        Assert.assertFalse(this.classUnderTest().containsAny(FastList.newListWith()));
    }

    @Override
    @Test
    public void containsNoneIterable() {
        Assert.assertTrue(this.classUnderTest().containsNoneIterable(FastList.newListWith("zero", "thirtyOne")));
        Assert.assertTrue(this.classUnderTest().containsNoneIterable(FastList.newListWith("zero", "thirtyOne", "thirtyTwo")));
        Assert.assertTrue(this.classUnderTest().containsNoneIterable(FastList.newListWith("zero", "one", "thirtyTwo")));
        Assert.assertTrue(this.classUnderTest().containsNoneIterable(FastList.newListWith("two", "one", "nine")));
        Assert.assertTrue(this.classUnderTest().containsNoneIterable(FastList.newListWith()));
    }

    @Override
    @Test
    public void containsNone() {
        Assert.assertTrue(this.classUnderTest().containsNone(FastList.newListWith("zero", "thirtyOne")));
        Assert.assertTrue(this.classUnderTest().containsNone(FastList.newListWith("zero", "thirtyOne", "thirtyTwo")));
        Assert.assertTrue(this.classUnderTest().containsNone(FastList.newListWith("zero", "one", "thirtyTwo")));
        Assert.assertTrue(this.classUnderTest().containsNone(FastList.newListWith("two", "one", "nine")));
        Assert.assertTrue(this.classUnderTest().containsNone(FastList.newListWith()));
    }

    @Override
    @Test
    public void containsAllArguments() {
        Assert.assertFalse(this.classUnderTest().containsAllArguments("zero", "thirtyOne"));
        Assert.assertFalse(this.classUnderTest().containsAllArguments("zero", "thirtyOne", "thirtyTwo"));
        Assert.assertFalse(this.classUnderTest().containsAllArguments("zero", "one", "thirtyTwo"));
        Assert.assertFalse(this.classUnderTest().containsAllArguments("two", "one", "nine"));
        Assert.assertTrue(this.classUnderTest().containsAllArguments());
    }

    @Override
    @Test
    public void containsKey() {
        Assert.assertFalse(this.classUnderTest().containsKey((char) 0));
        Assert.assertFalse(this.classUnderTest().containsKey((char) 31));
        Assert.assertFalse(this.classUnderTest().containsKey((char) 32));
        Assert.assertFalse(this.classUnderTest().containsKey((char) 1));
        Assert.assertFalse(this.classUnderTest().containsKey((char) 5));
        Assert.assertFalse(this.classUnderTest().containsKey((char) 35));
    }

    @Override
    @Test
    public void getIfAbsent() {
        Function0<String> ifAbsent = () -> "ifAbsent";
        Assert.assertEquals("ifAbsent", this.classUnderTest().getIfAbsent((char) 0, ifAbsent));
        Assert.assertEquals("ifAbsent", this.classUnderTest().getIfAbsent((char) 31, ifAbsent));
        Assert.assertEquals("ifAbsent", this.classUnderTest().getIfAbsent((char) 32, ifAbsent));
        Assert.assertEquals("ifAbsent", this.classUnderTest().getIfAbsent((char) 1, ifAbsent));
        Assert.assertEquals("ifAbsent", this.classUnderTest().getIfAbsent((char) 33, ifAbsent));
    }

    @Override
    @Test
    public void get() {
        Assert.assertNull(this.classUnderTest().get((char) 0));
        Assert.assertNull(this.classUnderTest().get((char) 31));
        Assert.assertNull(this.classUnderTest().get((char) 32));
        Assert.assertNull(this.classUnderTest().get((char) 1));
        Assert.assertNull(this.classUnderTest().get((char) 33));
    }

    @Override
    @Test
    public void iterator() {
        Iterator<String> iterator = this.classUnderTest().iterator();
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void isEmpty() {
        Assert.assertTrue(this.classUnderTest().isEmpty());
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertFalse(this.classUnderTest().notEmpty());
    }

    @Override
    @Test
    public void getFirst() {
        Assert.assertNull(this.classUnderTest().getFirst());
    }

    @Override
    @Test
    public void getLast() {
        Assert.assertNull(this.classUnderTest().getLast());
    }

    @Override
    @Test(expected = IllegalStateException.class)
    public void getOnly() {
        this.classUnderTest().getOnly();
    }

    @Override
    @Test
    public void tap() {
        ImmutableCharObjectMap<String> map = this.classUnderTest();
        Assert.assertSame(map, map.tap(Procedures.cast(each -> Assert.fail())));
    }

    @Override
    @Test
    public void forEach() {
        this.classUnderTest().forEach(Procedures.cast(each -> Assert.fail()));
    }

    @Override
    @Test
    public void forEachWithIndex() {
        this.classUnderTest().forEachWithIndex((String each, int param) -> Assert.fail());
    }

    @Override
    @Test
    public void forEachWith() {
        this.classUnderTest().forEachWith((String each, String param) -> Assert.fail(), "");
    }

    @Override
    @Test
    public void forEachKey() {
        this.classUnderTest().forEachKey((char each) -> Assert.fail());
    }

    @Override
    @Test
    public void forEachValue() {
        this.classUnderTest().forEachValue((String each) -> Assert.fail());
    }

    @Override
    @Test
    public void forEachKeyValue() {
        this.classUnderTest().forEachKeyValue((char eachKey, String eachValue) -> Assert.fail());
    }

    @Override
    @Test
    public void select() {
        Verify.assertIterableEmpty(this.classUnderTest().select(Predicates.alwaysTrue()));
        Verify.assertIterableEmpty(this.classUnderTest().select((char value, String object) -> true));
        FastList<String> target = FastList.newList();
        Assert.assertSame(target, this.classUnderTest().select(Predicates.alwaysTrue(), target));
        Verify.assertEmpty(target);
    }

    @Override
    @Test
    public void selectWith() {
        Verify.assertIterableEmpty(this.classUnderTest().selectWith(Predicates2.alwaysTrue(), ""));
    }

    @Override
    @Test
    public void selectWith_withTarget() {
        FastList<String> target = FastList.newList();
        Assert.assertSame(target, this.classUnderTest().selectWith(Predicates2.alwaysTrue(), "", target));
        Verify.assertEmpty(target);
    }

    @Override
    @Test
    public void selectInstancesOf() {
        Verify.assertIterableEmpty(this.classUnderTest().selectInstancesOf(Object.class));
    }

    @Override
    @Test
    public void reject() {
        Verify.assertIterableEmpty(this.classUnderTest().reject(Predicates.alwaysFalse()));
        Verify.assertIterableEmpty(this.classUnderTest().reject((char value, String object) -> false));
        FastList<String> target = FastList.newList();
        Assert.assertSame(target, this.classUnderTest().reject(Predicates.alwaysFalse(), target));
        Verify.assertEmpty(target);
    }

    @Override
    @Test
    public void rejectWith() {
        Verify.assertIterableEmpty(this.classUnderTest().rejectWith(Predicates2.alwaysFalse(), ""));
    }

    @Override
    @Test
    public void rejectWith_withTarget() {
        FastList<String> target = FastList.newList();
        Assert.assertSame(target, this.classUnderTest().rejectWith(Predicates2.alwaysFalse(), "", target));
        Verify.assertEmpty(target);
    }

    @Override
    @Test
    public void detect() {
        Assert.assertNull(this.classUnderTest().detect(Predicates.alwaysTrue()));
    }

    @Override
    @Test
    public void detectWith() {
        Assert.assertNull(this.classUnderTest().detectWith(Predicates2.alwaysTrue(), ""));
    }

    @Override
    @Test
    public void detectOptional() {
        Assert.assertEquals(Optional.empty(), this.classUnderTest().detectOptional(Predicates.alwaysTrue()));
    }

    @Override
    @Test
    public void detectWithOptional() {
        Assert.assertEquals(Optional.empty(), this.classUnderTest().detectWithOptional(Predicates2.alwaysTrue(), ""));
    }

    @Override
    @Test
    public void detectIfNone() {
        Assert.assertEquals("default", this.classUnderTest().detectIfNone(Predicates.alwaysTrue(), Functions0.value("default")));
    }

    @Override
    @Test
    public void detectWithIfNone() {
        Assert.assertEquals("default", this.classUnderTest().detectWithIfNone(Predicates2.alwaysTrue(), "", Functions0.value("default")));
    }

    @Override
    @Test
    public void count() {
        Assert.assertEquals(0, this.classUnderTest().count(Predicates.alwaysTrue()));
    }

    @Override
    @Test
    public void countWith() {
        Assert.assertEquals(0, this.classUnderTest().countWith(Predicates2.alwaysTrue(), ""));
    }

    @Override
    @Test
    public void anySatisfy() {
        Assert.assertFalse(this.classUnderTest().anySatisfy(ERROR_THROWING_PREDICATE));
    }

    @Override
    @Test
    public void anySatisfyWith() {
        Assert.assertFalse(this.classUnderTest().anySatisfyWith(ERROR_THROWING_PREDICATE_2, "e"));
    }

    @Override
    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.classUnderTest().allSatisfy(ERROR_THROWING_PREDICATE));
    }

    @Override
    @Test
    public void allSatisfyWith() {
        Assert.assertTrue(this.classUnderTest().allSatisfyWith(ERROR_THROWING_PREDICATE_2, "e"));
    }

    @Override
    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.classUnderTest().noneSatisfy(ERROR_THROWING_PREDICATE));
    }

    @Override
    @Test
    public void noneSatisfyWith() {
        Assert.assertTrue(this.classUnderTest().noneSatisfyWith(ERROR_THROWING_PREDICATE_2, "e"));
    }

    @Override
    @Test
    public void partition() {
        PartitionIterable<String> result = this.classUnderTest().partition(StringPredicates.endsWith("ne"));
        Verify.assertIterableEmpty(result.getSelected());
        Verify.assertIterableEmpty(result.getRejected());
    }

    @Override
    @Test
    public void partitionWith() {
        PartitionIterable<String> result = this.classUnderTest().partitionWith(StringPredicates2.endsWith(), "ne");
        Verify.assertIterableEmpty(result.getSelected());
        Verify.assertIterableEmpty(result.getRejected());
    }

    @Test
    public void min_withComparator() {
        Assert.assertThrows(NoSuchElementException.class, () -> this.classUnderTest().min(Comparators.naturalOrder()));
    }

    @Test
    public void max_withComparator() {
        Assert.assertThrows(NoSuchElementException.class, () -> this.classUnderTest().max(Comparators.naturalOrder()));
    }

    @Override
    @Test
    public void minBy() {
        Assert.assertThrows(NoSuchElementException.class, () -> this.classUnderTest().minBy(String::valueOf));
    }

    @Override
    @Test
    public void maxBy() {
        Assert.assertThrows(NoSuchElementException.class, () -> this.classUnderTest().maxBy(String::valueOf));
    }

    @Override
    @Test
    public void min() {
        Assert.assertThrows(NoSuchElementException.class, () -> this.classUnderTest().min());
    }

    @Override
    @Test
    public void max() {
        Assert.assertThrows(NoSuchElementException.class, () -> this.classUnderTest().max());
    }

    @Override
    @Test
    public void sumOfInt() {
        Assert.assertEquals(0L, this.classUnderTest().sumOfInt(String::length));
    }

    @Override
    @Test
    public void sumOfFloat() {
        Assert.assertEquals(0.0d, this.classUnderTest().sumOfFloat((String value) -> (float) value.length()), 0.0d);
    }

    @Override
    @Test
    public void sumOfLong() {
        Assert.assertEquals(0L, this.classUnderTest().sumOfLong((String value) -> (long) value.length()));
    }

    @Override
    @Test
    public void sumOfDouble() {
        Assert.assertEquals(0.0d, this.classUnderTest().sumOfDouble((String value) -> (double) value.length()), 0.0d);
    }

    @Override
    @Test
    public void collectIf() {
        Verify.assertIterableEmpty(this.classUnderTest().collectIf(Predicates.alwaysTrue(), StringFunctions.toUpperCase()));
        Verify.assertIterableEmpty(this.classUnderTest().collectIf(Predicates.alwaysFalse(), StringFunctions.toUpperCase()));
    }

    @Override
    @Test
    public void flatCollect() {
        Verify.assertIterableEmpty(this.classUnderTest().flatCollect(StringIterate::toSet));
        UnifiedSet<Character> target = UnifiedSet.newSet();
        Assert.assertSame(target, this.classUnderTest().flatCollect(StringIterate::toSet, target));
        Verify.assertIterableEmpty(target);
    }

    @Override
    @Test
    public void collect() {
        Verify.assertIterableEmpty(this.classUnderTest().collect(StringFunctions.toUpperCase()));
        FastList<String> target = FastList.newList();
        Assert.assertSame(target, this.classUnderTest().collect(StringFunctions.toUpperCase(), target));
        Verify.assertEmpty(target);
    }

    @Override
    @Test
    public void collectWith() {
        Function2<String, String, String> function = (String each, String param) -> each.toUpperCase() + param;
        Verify.assertIterableEmpty(this.classUnderTest().collectWith(function, "!"));
        FastList<String> target = FastList.newList();
        Assert.assertSame(target, this.classUnderTest().collectWith(function, "!", target));
        Verify.assertEmpty(target);
    }

    @Override
    @Test
    public void collectBoolean() {
        Verify.assertEmpty(this.classUnderTest().collectBoolean(StringFunctions.toPrimitiveBoolean()));
    }

    @Override
    @Test
    public void collectBoolean_withTarget() {
        BooleanArrayList target = new BooleanArrayList();
        Assert.assertSame(target, this.classUnderTest().collectBoolean(StringFunctions.toPrimitiveBoolean(), target));
        Verify.assertEmpty(target);
    }

    @Override
    @Test
    public void collectByte() {
        Verify.assertEmpty(this.classUnderTest().collectByte(Byte::parseByte));
    }

    @Override
    @Test
    public void collectByte_withTarget() {
        ByteArrayList target = new ByteArrayList();
        Assert.assertSame(target, this.classUnderTest().collectByte(Byte::parseByte, target));
        Verify.assertEmpty(target);
    }

    @Override
    @Test
    public void collectChar() {
        Verify.assertEmpty(this.classUnderTest().collectChar(StringFunctions.toPrimitiveChar()));
    }

    @Override
    @Test
    public void collectChar_withTarget() {
        CharArrayList target = new CharArrayList();
        Assert.assertSame(target, this.classUnderTest().collectChar(StringFunctions.toPrimitiveChar(), target));
        Verify.assertEmpty(target);
    }

    @Override
    @Test
    public void collectDouble() {
        Verify.assertEmpty(this.classUnderTest().collectDouble(Double::parseDouble));
    }

    @Override
    @Test
    public void collectDouble_withTarget() {
        DoubleArrayList target = new DoubleArrayList();
        Assert.assertSame(target, this.classUnderTest().collectDouble(Double::parseDouble, target));
        Verify.assertEmpty(target);
    }

    @Override
    @Test
    public void collectFloat() {
        Verify.assertEmpty(this.classUnderTest().collectFloat(Float::parseFloat));
    }

    @Override
    @Test
    public void collectFloat_withTarget() {
        FloatArrayList target = new FloatArrayList();
        Assert.assertSame(target, this.classUnderTest().collectFloat(Float::parseFloat, target));
        Verify.assertEmpty(target);
    }

    @Override
    @Test
    public void collectInt() {
        Verify.assertEmpty(this.classUnderTest().collectInt(Integer::parseInt));
    }

    @Override
    @Test
    public void collectInt_withTarget() {
        IntArrayList target = new IntArrayList();
        Assert.assertSame(target, this.classUnderTest().collectInt(Integer::parseInt, target));
        Verify.assertEmpty(target);
    }

    @Override
    @Test
    public void collectLong() {
        Verify.assertEmpty(this.classUnderTest().collectLong(Long::parseLong));
    }

    @Override
    @Test
    public void collectLong_withTarget() {
        LongArrayList target = new LongArrayList();
        Assert.assertSame(target, this.classUnderTest().collectLong(Long::parseLong, target));
        Verify.assertEmpty(target);
    }

    @Override
    @Test
    public void collectShort() {
        Verify.assertEmpty(this.classUnderTest().collectShort(Short::parseShort));
    }

    @Override
    @Test
    public void collectShort_withTarget() {
        ShortArrayList target = new ShortArrayList();
        Assert.assertSame(target, this.classUnderTest().collectShort(Short::parseShort, target));
        Verify.assertEmpty(target);
    }

    @Override
    @Test
    public void toSortedBag() {
        ImmutableCharObjectMap<String> map1 = this.classUnderTest();
        ImmutableCharObjectMap<String> map2 = this.classUnderTest();
        Verify.assertSortedBagsEqual(TreeBag.newBag(), map1.toSortedBag());
        Verify.assertSortedBagsEqual(TreeBag.newBag(Comparator.<String>reverseOrder()), map2.toSortedBag(Comparator.<String>reverseOrder()));
    }

    @Override
    @Test
    public void toSortedBagBy() {
        ImmutableCharObjectMap<String> map1 = this.classUnderTest();
        Verify.assertSortedBagsEqual(TreeBag.newBag(Comparators.byFunction(String::valueOf)), map1.toSortedBagBy(String::valueOf));
    }

    @Test
    public void toSortedBag_empty() {
        ImmutableCharObjectMap<String> map1 = this.classUnderTest();
        MutableSortedBag<String> sortedBag = map1.toSortedBag(Comparator.reverseOrder());
        sortedBag.addOccurrences("apple", 3);
        sortedBag.addOccurrences("orange", 2);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), "orange", "orange", "apple", "apple", "apple"), sortedBag);
    }

    @Test
    public void toSortedBagBy_empty() {
        ImmutableCharObjectMap<Integer> map = new ImmutableCharObjectEmptyMap<>();
        Function<Integer, Integer> function = object -> object * -1;
        MutableSortedBag<Integer> sortedBag = map.toSortedBagBy(function);
        sortedBag.addOccurrences(1, 3);
        sortedBag.addOccurrences(10, 2);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.byFunction(function), 10, 10, 1, 1, 1), sortedBag);
    }

    @Test
    public void toMapTarget() {
        ImmutableCharObjectMap<String> map = this.newWithKeysValues((char) 0, "a", (char) 9, "abcd");
        ImmutableCharObjectMap<String> map1 = new ImmutableCharObjectEmptyMap<>();
        Function<String, String> keyStringFunction = (Function<String, String>) each -> String.valueOf(each.length());
        Function<String, Long> keyLongFunction = (Function<String, Long>) each -> Long.valueOf(each.length());
        Function<String, String> valueFunction = Functions.getPassThru();
        Map<String, String> targetMap1 = new HashMap<>();
        targetMap1.put("1", "a");
        targetMap1.put("4", "abcd");
        Map<Long, String> targetMap2 = new HashMap<>();
        targetMap2.put(1L, "a");
        targetMap2.put(4L, "abcd");
        Map<Long, String> targetMap3 = new HashMap<>();
        Assert.assertEquals(targetMap1, map.toMap(keyStringFunction, valueFunction, new HashMap<String, String>()));
        Assert.assertEquals(targetMap2, map.toMap(keyLongFunction, valueFunction, new HashMap<Long, String>()));
        Assert.assertEquals(targetMap3, map1.toMap(keyLongFunction, valueFunction, new HashMap<Long, String>()));
        Assert.assertTrue(map.toMap(keyLongFunction, valueFunction, new HashMap<Long, String>()) instanceof HashMap);
    }

    @Test
    public void sumByInt() {
        ImmutableCharObjectMap<Integer> map = new ImmutableCharObjectEmptyMap<>();
        Assert.assertEquals(ObjectLongMaps.immutable.empty(), map.sumByInt(Object::toString, Integer::valueOf));
    }

    @Test
    public void sumByFloat() {
        ImmutableCharObjectMap<Integer> map = new ImmutableCharObjectEmptyMap<>();
        Assert.assertEquals(ObjectDoubleMaps.immutable.empty(), map.sumByFloat(Object::toString, Float::valueOf));
    }

    @Test
    public void sumByLong() {
        ImmutableCharObjectMap<Integer> map = new ImmutableCharObjectEmptyMap<>();
        Assert.assertEquals(ObjectLongMaps.immutable.empty(), map.sumByLong(Object::toString, Long::valueOf));
    }

    @Test
    public void sumByDouble() {
        ImmutableCharObjectMap<Integer> map = new ImmutableCharObjectEmptyMap<>();
        Assert.assertEquals(ObjectDoubleMaps.immutable.empty(), map.sumByDouble(Object::toString, Double::valueOf));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableCharObjectEmptyMapTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intInjectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longInjectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatInjectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleInjectInto);
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
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
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
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_not_only_one_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_not_only_one_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
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
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_throws_negative_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_throws_negative_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_throws_zero_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_throws_zero_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateInPlaceBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateInPlaceBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateBy);
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
        public void benchmark_groupByUniqueKey_target_throws_1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_1);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_3() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_3);
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
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
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
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAny() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAny);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArguments);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
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
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
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
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
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
        public void benchmark_rejectWith_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
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
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_withComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_withComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_withComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_withComparator);
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
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort_withTarget);
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
        public void benchmark_toSortedBag_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapTarget);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableCharObjectEmptyMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> intInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> longInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> floatInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> doubleInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> toImmutableSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> toImmutableSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> toImmutableSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> min_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> max_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> chunk_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> chunk_throws_zero_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> groupByUniqueKey_target_throws_1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> groupByUniqueKey_target_throws_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> groupByUniqueKey_target_throws_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> containsAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> containsNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> selectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> rejectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> min_withComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> max_withComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> collectBoolean_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> collectByte_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> collectChar_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> collectDouble_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> collectFloat_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> collectInt_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> collectLong_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> collectShort_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> toSortedBag_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> toSortedBagBy_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectEmptyMapTest> sumByDouble;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = ImmutableCharObjectEmptyMapTest::values;
            this.payloads.collectWithTarget = ImmutableCharObjectEmptyMapTest::collectWithTarget;
            this.payloads.injectInto = ImmutableCharObjectEmptyMapTest::injectInto;
            this.payloads.intInjectInto = ImmutableCharObjectEmptyMapTest::intInjectInto;
            this.payloads.longInjectInto = ImmutableCharObjectEmptyMapTest::longInjectInto;
            this.payloads.floatInjectInto = ImmutableCharObjectEmptyMapTest::floatInjectInto;
            this.payloads.doubleInjectInto = ImmutableCharObjectEmptyMapTest::doubleInjectInto;
            this.payloads.toList = ImmutableCharObjectEmptyMapTest::toList;
            this.payloads.toSortedList = ImmutableCharObjectEmptyMapTest::toSortedList;
            this.payloads.toSet = ImmutableCharObjectEmptyMapTest::toSet;
            this.payloads.toSortedSet = ImmutableCharObjectEmptyMapTest::toSortedSet;
            this.payloads.toBag = ImmutableCharObjectEmptyMapTest::toBag;
            this.payloads.toMap = ImmutableCharObjectEmptyMapTest::toMap;
            this.payloads.toSortedMap = ImmutableCharObjectEmptyMapTest::toSortedMap;
            this.payloads.toImmutableList = ImmutableCharObjectEmptyMapTest::toImmutableList;
            this.payloads.toImmutableSortedList = ImmutableCharObjectEmptyMapTest::toImmutableSortedList;
            this.payloads.toImmutableSet = ImmutableCharObjectEmptyMapTest::toImmutableSet;
            this.payloads.toImmutableSortedSet = ImmutableCharObjectEmptyMapTest::toImmutableSortedSet;
            this.payloads.toImmutableBag = ImmutableCharObjectEmptyMapTest::toImmutableBag;
            this.payloads.toImmutableSortedBag = ImmutableCharObjectEmptyMapTest::toImmutableSortedBag;
            this.payloads.toImmutableSortedBagBy = ImmutableCharObjectEmptyMapTest::toImmutableSortedBagBy;
            this.payloads.toArray = ImmutableCharObjectEmptyMapTest::toArray;
            this.payloads.min_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharObjectEmptyMapTest::min_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.max_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharObjectEmptyMapTest::max_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.keysView = ImmutableCharObjectEmptyMapTest::keysView;
            this.payloads.injectIntoKeyValue = ImmutableCharObjectEmptyMapTest::injectIntoKeyValue;
            this.payloads.size = ImmutableCharObjectEmptyMapTest::size;
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharObjectEmptyMapTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharObjectEmptyMapTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.testEquals = ImmutableCharObjectEmptyMapTest::testEquals;
            this.payloads.testHashCode = ImmutableCharObjectEmptyMapTest::testHashCode;
            this.payloads.testToString = ImmutableCharObjectEmptyMapTest::testToString;
            this.payloads.zip = ImmutableCharObjectEmptyMapTest::zip;
            this.payloads.zipWithIndex = ImmutableCharObjectEmptyMapTest::zipWithIndex;
            this.payloads.chunk = ImmutableCharObjectEmptyMapTest::chunk;
            this.payloads.chunk_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharObjectEmptyMapTest::chunk_throws_negative_size, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_throws_zero_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharObjectEmptyMapTest::chunk_throws_zero_size, java.lang.IllegalArgumentException.class);
            this.payloads.aggregateInPlaceBy = ImmutableCharObjectEmptyMapTest::aggregateInPlaceBy;
            this.payloads.aggregateBy = ImmutableCharObjectEmptyMapTest::aggregateBy;
            this.payloads.groupBy = ImmutableCharObjectEmptyMapTest::groupBy;
            this.payloads.groupByEach = ImmutableCharObjectEmptyMapTest::groupByEach;
            this.payloads.groupByUniqueKey = ImmutableCharObjectEmptyMapTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharObjectEmptyMapTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ImmutableCharObjectEmptyMapTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_1 = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharObjectEmptyMapTest::groupByUniqueKey_target_throws_1, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_2 = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharObjectEmptyMapTest::groupByUniqueKey_target_throws_2, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_3 = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharObjectEmptyMapTest::groupByUniqueKey_target_throws_3, java.lang.IllegalStateException.class);
            this.payloads.makeString = ImmutableCharObjectEmptyMapTest::makeString;
            this.payloads.appendString = ImmutableCharObjectEmptyMapTest::appendString;
            this.payloads.stream = ImmutableCharObjectEmptyMapTest::stream;
            this.payloads.parallelStream = ImmutableCharObjectEmptyMapTest::parallelStream;
            this.payloads.toImmutable = ImmutableCharObjectEmptyMapTest::toImmutable;
            this.payloads.keySet = ImmutableCharObjectEmptyMapTest::keySet;
            this.payloads.flipUniqueValues = ImmutableCharObjectEmptyMapTest::flipUniqueValues;
            this.payloads.containsValue = ImmutableCharObjectEmptyMapTest::containsValue;
            this.payloads.contains = ImmutableCharObjectEmptyMapTest::contains;
            this.payloads.containsAllIterable = ImmutableCharObjectEmptyMapTest::containsAllIterable;
            this.payloads.containsAll = ImmutableCharObjectEmptyMapTest::containsAll;
            this.payloads.containsAnyIterable = ImmutableCharObjectEmptyMapTest::containsAnyIterable;
            this.payloads.containsAny = ImmutableCharObjectEmptyMapTest::containsAny;
            this.payloads.containsNoneIterable = ImmutableCharObjectEmptyMapTest::containsNoneIterable;
            this.payloads.containsNone = ImmutableCharObjectEmptyMapTest::containsNone;
            this.payloads.containsAllArguments = ImmutableCharObjectEmptyMapTest::containsAllArguments;
            this.payloads.containsKey = ImmutableCharObjectEmptyMapTest::containsKey;
            this.payloads.getIfAbsent = ImmutableCharObjectEmptyMapTest::getIfAbsent;
            this.payloads.get = ImmutableCharObjectEmptyMapTest::get;
            this.payloads.iterator = ImmutableCharObjectEmptyMapTest::iterator;
            this.payloads.isEmpty = ImmutableCharObjectEmptyMapTest::isEmpty;
            this.payloads.notEmpty = ImmutableCharObjectEmptyMapTest::notEmpty;
            this.payloads.getFirst = ImmutableCharObjectEmptyMapTest::getFirst;
            this.payloads.getLast = ImmutableCharObjectEmptyMapTest::getLast;
            this.payloads.getOnly = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharObjectEmptyMapTest::getOnly, java.lang.IllegalStateException.class);
            this.payloads.tap = ImmutableCharObjectEmptyMapTest::tap;
            this.payloads.forEach = ImmutableCharObjectEmptyMapTest::forEach;
            this.payloads.forEachWithIndex = ImmutableCharObjectEmptyMapTest::forEachWithIndex;
            this.payloads.forEachWith = ImmutableCharObjectEmptyMapTest::forEachWith;
            this.payloads.forEachKey = ImmutableCharObjectEmptyMapTest::forEachKey;
            this.payloads.forEachValue = ImmutableCharObjectEmptyMapTest::forEachValue;
            this.payloads.forEachKeyValue = ImmutableCharObjectEmptyMapTest::forEachKeyValue;
            this.payloads.select = ImmutableCharObjectEmptyMapTest::select;
            this.payloads.selectWith = ImmutableCharObjectEmptyMapTest::selectWith;
            this.payloads.selectWith_withTarget = ImmutableCharObjectEmptyMapTest::selectWith_withTarget;
            this.payloads.selectInstancesOf = ImmutableCharObjectEmptyMapTest::selectInstancesOf;
            this.payloads.reject = ImmutableCharObjectEmptyMapTest::reject;
            this.payloads.rejectWith = ImmutableCharObjectEmptyMapTest::rejectWith;
            this.payloads.rejectWith_withTarget = ImmutableCharObjectEmptyMapTest::rejectWith_withTarget;
            this.payloads.detect = ImmutableCharObjectEmptyMapTest::detect;
            this.payloads.detectWith = ImmutableCharObjectEmptyMapTest::detectWith;
            this.payloads.detectOptional = ImmutableCharObjectEmptyMapTest::detectOptional;
            this.payloads.detectWithOptional = ImmutableCharObjectEmptyMapTest::detectWithOptional;
            this.payloads.detectIfNone = ImmutableCharObjectEmptyMapTest::detectIfNone;
            this.payloads.detectWithIfNone = ImmutableCharObjectEmptyMapTest::detectWithIfNone;
            this.payloads.count = ImmutableCharObjectEmptyMapTest::count;
            this.payloads.countWith = ImmutableCharObjectEmptyMapTest::countWith;
            this.payloads.anySatisfy = ImmutableCharObjectEmptyMapTest::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableCharObjectEmptyMapTest::anySatisfyWith;
            this.payloads.allSatisfy = ImmutableCharObjectEmptyMapTest::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableCharObjectEmptyMapTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableCharObjectEmptyMapTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableCharObjectEmptyMapTest::noneSatisfyWith;
            this.payloads.partition = ImmutableCharObjectEmptyMapTest::partition;
            this.payloads.partitionWith = ImmutableCharObjectEmptyMapTest::partitionWith;
            this.payloads.min_withComparator = ImmutableCharObjectEmptyMapTest::min_withComparator;
            this.payloads.max_withComparator = ImmutableCharObjectEmptyMapTest::max_withComparator;
            this.payloads.minBy = ImmutableCharObjectEmptyMapTest::minBy;
            this.payloads.maxBy = ImmutableCharObjectEmptyMapTest::maxBy;
            this.payloads.min = ImmutableCharObjectEmptyMapTest::min;
            this.payloads.max = ImmutableCharObjectEmptyMapTest::max;
            this.payloads.sumOfInt = ImmutableCharObjectEmptyMapTest::sumOfInt;
            this.payloads.sumOfFloat = ImmutableCharObjectEmptyMapTest::sumOfFloat;
            this.payloads.sumOfLong = ImmutableCharObjectEmptyMapTest::sumOfLong;
            this.payloads.sumOfDouble = ImmutableCharObjectEmptyMapTest::sumOfDouble;
            this.payloads.collectIf = ImmutableCharObjectEmptyMapTest::collectIf;
            this.payloads.flatCollect = ImmutableCharObjectEmptyMapTest::flatCollect;
            this.payloads.collect = ImmutableCharObjectEmptyMapTest::collect;
            this.payloads.collectWith = ImmutableCharObjectEmptyMapTest::collectWith;
            this.payloads.collectBoolean = ImmutableCharObjectEmptyMapTest::collectBoolean;
            this.payloads.collectBoolean_withTarget = ImmutableCharObjectEmptyMapTest::collectBoolean_withTarget;
            this.payloads.collectByte = ImmutableCharObjectEmptyMapTest::collectByte;
            this.payloads.collectByte_withTarget = ImmutableCharObjectEmptyMapTest::collectByte_withTarget;
            this.payloads.collectChar = ImmutableCharObjectEmptyMapTest::collectChar;
            this.payloads.collectChar_withTarget = ImmutableCharObjectEmptyMapTest::collectChar_withTarget;
            this.payloads.collectDouble = ImmutableCharObjectEmptyMapTest::collectDouble;
            this.payloads.collectDouble_withTarget = ImmutableCharObjectEmptyMapTest::collectDouble_withTarget;
            this.payloads.collectFloat = ImmutableCharObjectEmptyMapTest::collectFloat;
            this.payloads.collectFloat_withTarget = ImmutableCharObjectEmptyMapTest::collectFloat_withTarget;
            this.payloads.collectInt = ImmutableCharObjectEmptyMapTest::collectInt;
            this.payloads.collectInt_withTarget = ImmutableCharObjectEmptyMapTest::collectInt_withTarget;
            this.payloads.collectLong = ImmutableCharObjectEmptyMapTest::collectLong;
            this.payloads.collectLong_withTarget = ImmutableCharObjectEmptyMapTest::collectLong_withTarget;
            this.payloads.collectShort = ImmutableCharObjectEmptyMapTest::collectShort;
            this.payloads.collectShort_withTarget = ImmutableCharObjectEmptyMapTest::collectShort_withTarget;
            this.payloads.toSortedBag = ImmutableCharObjectEmptyMapTest::toSortedBag;
            this.payloads.toSortedBagBy = ImmutableCharObjectEmptyMapTest::toSortedBagBy;
            this.payloads.toSortedBag_empty = ImmutableCharObjectEmptyMapTest::toSortedBag_empty;
            this.payloads.toSortedBagBy_empty = ImmutableCharObjectEmptyMapTest::toSortedBagBy_empty;
            this.payloads.toMapTarget = ImmutableCharObjectEmptyMapTest::toMapTarget;
            this.payloads.sumByInt = ImmutableCharObjectEmptyMapTest::sumByInt;
            this.payloads.sumByFloat = ImmutableCharObjectEmptyMapTest::sumByFloat;
            this.payloads.sumByLong = ImmutableCharObjectEmptyMapTest::sumByLong;
            this.payloads.sumByDouble = ImmutableCharObjectEmptyMapTest::sumByDouble;
        }
    }
}
