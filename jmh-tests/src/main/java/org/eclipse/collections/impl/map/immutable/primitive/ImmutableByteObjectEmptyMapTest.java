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
import org.eclipse.collections.api.map.primitive.ImmutableByteObjectMap;
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
 * JUnit test for {@link ImmutableByteObjectEmptyMap}.
 * This file was automatically generated from template file immutablePrimitiveObjectEmptyMapTest.stg.
 */
public class ImmutableByteObjectEmptyMapTest extends AbstractImmutableByteObjectMapTestCase {

    public static final Predicate2<String, String> ERROR_THROWING_PREDICATE_2 = (String argument1, String argument2) -> {
        throw new AssertionError();
    };

    public static final Predicate<String> ERROR_THROWING_PREDICATE = (String each) -> {
        throw new AssertionError();
    };

    @Override
    protected ImmutableByteObjectMap<String> classUnderTest() {
        return (ImmutableByteObjectMap<String>) ImmutableByteObjectEmptyMap.INSTANCE;
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
        Assert.assertFalse(this.classUnderTest().containsKey((byte) 0));
        Assert.assertFalse(this.classUnderTest().containsKey((byte) 31));
        Assert.assertFalse(this.classUnderTest().containsKey((byte) 32));
        Assert.assertFalse(this.classUnderTest().containsKey((byte) 1));
        Assert.assertFalse(this.classUnderTest().containsKey((byte) 5));
        Assert.assertFalse(this.classUnderTest().containsKey((byte) 35));
    }

    @Override
    @Test
    public void getIfAbsent() {
        Function0<String> ifAbsent = () -> "ifAbsent";
        Assert.assertEquals("ifAbsent", this.classUnderTest().getIfAbsent((byte) 0, ifAbsent));
        Assert.assertEquals("ifAbsent", this.classUnderTest().getIfAbsent((byte) 31, ifAbsent));
        Assert.assertEquals("ifAbsent", this.classUnderTest().getIfAbsent((byte) 32, ifAbsent));
        Assert.assertEquals("ifAbsent", this.classUnderTest().getIfAbsent((byte) 1, ifAbsent));
        Assert.assertEquals("ifAbsent", this.classUnderTest().getIfAbsent((byte) 33, ifAbsent));
    }

    @Override
    @Test
    public void get() {
        Assert.assertNull(this.classUnderTest().get((byte) 0));
        Assert.assertNull(this.classUnderTest().get((byte) 31));
        Assert.assertNull(this.classUnderTest().get((byte) 32));
        Assert.assertNull(this.classUnderTest().get((byte) 1));
        Assert.assertNull(this.classUnderTest().get((byte) 33));
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
        ImmutableByteObjectMap<String> map = this.classUnderTest();
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
        this.classUnderTest().forEachKey((byte each) -> Assert.fail());
    }

    @Override
    @Test
    public void forEachValue() {
        this.classUnderTest().forEachValue((String each) -> Assert.fail());
    }

    @Override
    @Test
    public void forEachKeyValue() {
        this.classUnderTest().forEachKeyValue((byte eachKey, String eachValue) -> Assert.fail());
    }

    @Override
    @Test
    public void select() {
        Verify.assertIterableEmpty(this.classUnderTest().select(Predicates.alwaysTrue()));
        Verify.assertIterableEmpty(this.classUnderTest().select((byte value, String object) -> true));
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
        Verify.assertIterableEmpty(this.classUnderTest().reject((byte value, String object) -> false));
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
        ImmutableByteObjectMap<String> map1 = this.classUnderTest();
        ImmutableByteObjectMap<String> map2 = this.classUnderTest();
        Verify.assertSortedBagsEqual(TreeBag.newBag(), map1.toSortedBag());
        Verify.assertSortedBagsEqual(TreeBag.newBag(Comparator.<String>reverseOrder()), map2.toSortedBag(Comparator.<String>reverseOrder()));
    }

    @Override
    @Test
    public void toSortedBagBy() {
        ImmutableByteObjectMap<String> map1 = this.classUnderTest();
        Verify.assertSortedBagsEqual(TreeBag.newBag(Comparators.byFunction(String::valueOf)), map1.toSortedBagBy(String::valueOf));
    }

    @Test
    public void toSortedBag_empty() {
        ImmutableByteObjectMap<String> map1 = this.classUnderTest();
        MutableSortedBag<String> sortedBag = map1.toSortedBag(Comparator.reverseOrder());
        sortedBag.addOccurrences("apple", 3);
        sortedBag.addOccurrences("orange", 2);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), "orange", "orange", "apple", "apple", "apple"), sortedBag);
    }

    @Test
    public void toSortedBagBy_empty() {
        ImmutableByteObjectMap<Integer> map = new ImmutableByteObjectEmptyMap<>();
        Function<Integer, Integer> function = object -> object * -1;
        MutableSortedBag<Integer> sortedBag = map.toSortedBagBy(function);
        sortedBag.addOccurrences(1, 3);
        sortedBag.addOccurrences(10, 2);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.byFunction(function), 10, 10, 1, 1, 1), sortedBag);
    }

    @Test
    public void toMapTarget() {
        ImmutableByteObjectMap<String> map = this.newWithKeysValues((byte) 0, "a", (byte) 9, "abcd");
        ImmutableByteObjectMap<String> map1 = new ImmutableByteObjectEmptyMap<>();
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
        ImmutableByteObjectMap<Integer> map = new ImmutableByteObjectEmptyMap<>();
        Assert.assertEquals(ObjectLongMaps.immutable.empty(), map.sumByInt(Object::toString, Integer::valueOf));
    }

    @Test
    public void sumByFloat() {
        ImmutableByteObjectMap<Integer> map = new ImmutableByteObjectEmptyMap<>();
        Assert.assertEquals(ObjectDoubleMaps.immutable.empty(), map.sumByFloat(Object::toString, Float::valueOf));
    }

    @Test
    public void sumByLong() {
        ImmutableByteObjectMap<Integer> map = new ImmutableByteObjectEmptyMap<>();
        Assert.assertEquals(ObjectLongMaps.immutable.empty(), map.sumByLong(Object::toString, Long::valueOf));
    }

    @Test
    public void sumByDouble() {
        ImmutableByteObjectMap<Integer> map = new ImmutableByteObjectEmptyMap<>();
        Assert.assertEquals(ObjectDoubleMaps.immutable.empty(), map.sumByDouble(Object::toString, Double::valueOf));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableByteObjectEmptyMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableByteObjectEmptyMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> intInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> longInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> floatInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> doubleInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> toImmutableSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> toImmutableSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> toImmutableSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> min_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> max_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> chunk_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> chunk_throws_zero_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> groupByUniqueKey_target_throws_1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> groupByUniqueKey_target_throws_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> groupByUniqueKey_target_throws_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> containsAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> containsNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> selectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> rejectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> min_withComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> max_withComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> collectBoolean_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> collectByte_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> collectChar_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> collectDouble_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> collectFloat_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> collectInt_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> collectLong_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> collectShort_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> toSortedBag_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> toSortedBagBy_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectEmptyMapTest> sumByDouble;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = ImmutableByteObjectEmptyMapTest::values;
            this.payloads.collectWithTarget = ImmutableByteObjectEmptyMapTest::collectWithTarget;
            this.payloads.injectInto = ImmutableByteObjectEmptyMapTest::injectInto;
            this.payloads.intInjectInto = ImmutableByteObjectEmptyMapTest::intInjectInto;
            this.payloads.longInjectInto = ImmutableByteObjectEmptyMapTest::longInjectInto;
            this.payloads.floatInjectInto = ImmutableByteObjectEmptyMapTest::floatInjectInto;
            this.payloads.doubleInjectInto = ImmutableByteObjectEmptyMapTest::doubleInjectInto;
            this.payloads.toList = ImmutableByteObjectEmptyMapTest::toList;
            this.payloads.toSortedList = ImmutableByteObjectEmptyMapTest::toSortedList;
            this.payloads.toSet = ImmutableByteObjectEmptyMapTest::toSet;
            this.payloads.toSortedSet = ImmutableByteObjectEmptyMapTest::toSortedSet;
            this.payloads.toBag = ImmutableByteObjectEmptyMapTest::toBag;
            this.payloads.toMap = ImmutableByteObjectEmptyMapTest::toMap;
            this.payloads.toSortedMap = ImmutableByteObjectEmptyMapTest::toSortedMap;
            this.payloads.toImmutableList = ImmutableByteObjectEmptyMapTest::toImmutableList;
            this.payloads.toImmutableSortedList = ImmutableByteObjectEmptyMapTest::toImmutableSortedList;
            this.payloads.toImmutableSet = ImmutableByteObjectEmptyMapTest::toImmutableSet;
            this.payloads.toImmutableSortedSet = ImmutableByteObjectEmptyMapTest::toImmutableSortedSet;
            this.payloads.toImmutableBag = ImmutableByteObjectEmptyMapTest::toImmutableBag;
            this.payloads.toImmutableSortedBag = ImmutableByteObjectEmptyMapTest::toImmutableSortedBag;
            this.payloads.toImmutableSortedBagBy = ImmutableByteObjectEmptyMapTest::toImmutableSortedBagBy;
            this.payloads.toArray = ImmutableByteObjectEmptyMapTest::toArray;
            this.payloads.min_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteObjectEmptyMapTest::min_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.max_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteObjectEmptyMapTest::max_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.keysView = ImmutableByteObjectEmptyMapTest::keysView;
            this.payloads.injectIntoKeyValue = ImmutableByteObjectEmptyMapTest::injectIntoKeyValue;
            this.payloads.size = ImmutableByteObjectEmptyMapTest::size;
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteObjectEmptyMapTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteObjectEmptyMapTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.testEquals = ImmutableByteObjectEmptyMapTest::testEquals;
            this.payloads.testHashCode = ImmutableByteObjectEmptyMapTest::testHashCode;
            this.payloads.testToString = ImmutableByteObjectEmptyMapTest::testToString;
            this.payloads.zip = ImmutableByteObjectEmptyMapTest::zip;
            this.payloads.zipWithIndex = ImmutableByteObjectEmptyMapTest::zipWithIndex;
            this.payloads.chunk = ImmutableByteObjectEmptyMapTest::chunk;
            this.payloads.chunk_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteObjectEmptyMapTest::chunk_throws_negative_size, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_throws_zero_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteObjectEmptyMapTest::chunk_throws_zero_size, java.lang.IllegalArgumentException.class);
            this.payloads.aggregateInPlaceBy = ImmutableByteObjectEmptyMapTest::aggregateInPlaceBy;
            this.payloads.aggregateBy = ImmutableByteObjectEmptyMapTest::aggregateBy;
            this.payloads.groupBy = ImmutableByteObjectEmptyMapTest::groupBy;
            this.payloads.groupByEach = ImmutableByteObjectEmptyMapTest::groupByEach;
            this.payloads.groupByUniqueKey = ImmutableByteObjectEmptyMapTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteObjectEmptyMapTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ImmutableByteObjectEmptyMapTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_1 = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteObjectEmptyMapTest::groupByUniqueKey_target_throws_1, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_2 = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteObjectEmptyMapTest::groupByUniqueKey_target_throws_2, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_3 = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteObjectEmptyMapTest::groupByUniqueKey_target_throws_3, java.lang.IllegalStateException.class);
            this.payloads.makeString = ImmutableByteObjectEmptyMapTest::makeString;
            this.payloads.appendString = ImmutableByteObjectEmptyMapTest::appendString;
            this.payloads.stream = ImmutableByteObjectEmptyMapTest::stream;
            this.payloads.parallelStream = ImmutableByteObjectEmptyMapTest::parallelStream;
            this.payloads.toImmutable = ImmutableByteObjectEmptyMapTest::toImmutable;
            this.payloads.keySet = ImmutableByteObjectEmptyMapTest::keySet;
            this.payloads.flipUniqueValues = ImmutableByteObjectEmptyMapTest::flipUniqueValues;
            this.payloads.containsValue = ImmutableByteObjectEmptyMapTest::containsValue;
            this.payloads.contains = ImmutableByteObjectEmptyMapTest::contains;
            this.payloads.containsAllIterable = ImmutableByteObjectEmptyMapTest::containsAllIterable;
            this.payloads.containsAll = ImmutableByteObjectEmptyMapTest::containsAll;
            this.payloads.containsAnyIterable = ImmutableByteObjectEmptyMapTest::containsAnyIterable;
            this.payloads.containsAny = ImmutableByteObjectEmptyMapTest::containsAny;
            this.payloads.containsNoneIterable = ImmutableByteObjectEmptyMapTest::containsNoneIterable;
            this.payloads.containsNone = ImmutableByteObjectEmptyMapTest::containsNone;
            this.payloads.containsAllArguments = ImmutableByteObjectEmptyMapTest::containsAllArguments;
            this.payloads.containsKey = ImmutableByteObjectEmptyMapTest::containsKey;
            this.payloads.getIfAbsent = ImmutableByteObjectEmptyMapTest::getIfAbsent;
            this.payloads.get = ImmutableByteObjectEmptyMapTest::get;
            this.payloads.iterator = ImmutableByteObjectEmptyMapTest::iterator;
            this.payloads.isEmpty = ImmutableByteObjectEmptyMapTest::isEmpty;
            this.payloads.notEmpty = ImmutableByteObjectEmptyMapTest::notEmpty;
            this.payloads.getFirst = ImmutableByteObjectEmptyMapTest::getFirst;
            this.payloads.getLast = ImmutableByteObjectEmptyMapTest::getLast;
            this.payloads.getOnly = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteObjectEmptyMapTest::getOnly, java.lang.IllegalStateException.class);
            this.payloads.tap = ImmutableByteObjectEmptyMapTest::tap;
            this.payloads.forEach = ImmutableByteObjectEmptyMapTest::forEach;
            this.payloads.forEachWithIndex = ImmutableByteObjectEmptyMapTest::forEachWithIndex;
            this.payloads.forEachWith = ImmutableByteObjectEmptyMapTest::forEachWith;
            this.payloads.forEachKey = ImmutableByteObjectEmptyMapTest::forEachKey;
            this.payloads.forEachValue = ImmutableByteObjectEmptyMapTest::forEachValue;
            this.payloads.forEachKeyValue = ImmutableByteObjectEmptyMapTest::forEachKeyValue;
            this.payloads.select = ImmutableByteObjectEmptyMapTest::select;
            this.payloads.selectWith = ImmutableByteObjectEmptyMapTest::selectWith;
            this.payloads.selectWith_withTarget = ImmutableByteObjectEmptyMapTest::selectWith_withTarget;
            this.payloads.selectInstancesOf = ImmutableByteObjectEmptyMapTest::selectInstancesOf;
            this.payloads.reject = ImmutableByteObjectEmptyMapTest::reject;
            this.payloads.rejectWith = ImmutableByteObjectEmptyMapTest::rejectWith;
            this.payloads.rejectWith_withTarget = ImmutableByteObjectEmptyMapTest::rejectWith_withTarget;
            this.payloads.detect = ImmutableByteObjectEmptyMapTest::detect;
            this.payloads.detectWith = ImmutableByteObjectEmptyMapTest::detectWith;
            this.payloads.detectOptional = ImmutableByteObjectEmptyMapTest::detectOptional;
            this.payloads.detectWithOptional = ImmutableByteObjectEmptyMapTest::detectWithOptional;
            this.payloads.detectIfNone = ImmutableByteObjectEmptyMapTest::detectIfNone;
            this.payloads.detectWithIfNone = ImmutableByteObjectEmptyMapTest::detectWithIfNone;
            this.payloads.count = ImmutableByteObjectEmptyMapTest::count;
            this.payloads.countWith = ImmutableByteObjectEmptyMapTest::countWith;
            this.payloads.anySatisfy = ImmutableByteObjectEmptyMapTest::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableByteObjectEmptyMapTest::anySatisfyWith;
            this.payloads.allSatisfy = ImmutableByteObjectEmptyMapTest::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableByteObjectEmptyMapTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableByteObjectEmptyMapTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableByteObjectEmptyMapTest::noneSatisfyWith;
            this.payloads.partition = ImmutableByteObjectEmptyMapTest::partition;
            this.payloads.partitionWith = ImmutableByteObjectEmptyMapTest::partitionWith;
            this.payloads.min_withComparator = ImmutableByteObjectEmptyMapTest::min_withComparator;
            this.payloads.max_withComparator = ImmutableByteObjectEmptyMapTest::max_withComparator;
            this.payloads.minBy = ImmutableByteObjectEmptyMapTest::minBy;
            this.payloads.maxBy = ImmutableByteObjectEmptyMapTest::maxBy;
            this.payloads.min = ImmutableByteObjectEmptyMapTest::min;
            this.payloads.max = ImmutableByteObjectEmptyMapTest::max;
            this.payloads.sumOfInt = ImmutableByteObjectEmptyMapTest::sumOfInt;
            this.payloads.sumOfFloat = ImmutableByteObjectEmptyMapTest::sumOfFloat;
            this.payloads.sumOfLong = ImmutableByteObjectEmptyMapTest::sumOfLong;
            this.payloads.sumOfDouble = ImmutableByteObjectEmptyMapTest::sumOfDouble;
            this.payloads.collectIf = ImmutableByteObjectEmptyMapTest::collectIf;
            this.payloads.flatCollect = ImmutableByteObjectEmptyMapTest::flatCollect;
            this.payloads.collect = ImmutableByteObjectEmptyMapTest::collect;
            this.payloads.collectWith = ImmutableByteObjectEmptyMapTest::collectWith;
            this.payloads.collectBoolean = ImmutableByteObjectEmptyMapTest::collectBoolean;
            this.payloads.collectBoolean_withTarget = ImmutableByteObjectEmptyMapTest::collectBoolean_withTarget;
            this.payloads.collectByte = ImmutableByteObjectEmptyMapTest::collectByte;
            this.payloads.collectByte_withTarget = ImmutableByteObjectEmptyMapTest::collectByte_withTarget;
            this.payloads.collectChar = ImmutableByteObjectEmptyMapTest::collectChar;
            this.payloads.collectChar_withTarget = ImmutableByteObjectEmptyMapTest::collectChar_withTarget;
            this.payloads.collectDouble = ImmutableByteObjectEmptyMapTest::collectDouble;
            this.payloads.collectDouble_withTarget = ImmutableByteObjectEmptyMapTest::collectDouble_withTarget;
            this.payloads.collectFloat = ImmutableByteObjectEmptyMapTest::collectFloat;
            this.payloads.collectFloat_withTarget = ImmutableByteObjectEmptyMapTest::collectFloat_withTarget;
            this.payloads.collectInt = ImmutableByteObjectEmptyMapTest::collectInt;
            this.payloads.collectInt_withTarget = ImmutableByteObjectEmptyMapTest::collectInt_withTarget;
            this.payloads.collectLong = ImmutableByteObjectEmptyMapTest::collectLong;
            this.payloads.collectLong_withTarget = ImmutableByteObjectEmptyMapTest::collectLong_withTarget;
            this.payloads.collectShort = ImmutableByteObjectEmptyMapTest::collectShort;
            this.payloads.collectShort_withTarget = ImmutableByteObjectEmptyMapTest::collectShort_withTarget;
            this.payloads.toSortedBag = ImmutableByteObjectEmptyMapTest::toSortedBag;
            this.payloads.toSortedBagBy = ImmutableByteObjectEmptyMapTest::toSortedBagBy;
            this.payloads.toSortedBag_empty = ImmutableByteObjectEmptyMapTest::toSortedBag_empty;
            this.payloads.toSortedBagBy_empty = ImmutableByteObjectEmptyMapTest::toSortedBagBy_empty;
            this.payloads.toMapTarget = ImmutableByteObjectEmptyMapTest::toMapTarget;
            this.payloads.sumByInt = ImmutableByteObjectEmptyMapTest::sumByInt;
            this.payloads.sumByFloat = ImmutableByteObjectEmptyMapTest::sumByFloat;
            this.payloads.sumByLong = ImmutableByteObjectEmptyMapTest::sumByLong;
            this.payloads.sumByDouble = ImmutableByteObjectEmptyMapTest::sumByDouble;
        }
    }
}
