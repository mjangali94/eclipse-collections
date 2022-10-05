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
import org.eclipse.collections.api.map.primitive.ImmutableDoubleObjectMap;
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
 * JUnit test for {@link ImmutableDoubleObjectEmptyMap}.
 * This file was automatically generated from template file immutablePrimitiveObjectEmptyMapTest.stg.
 */
public class ImmutableDoubleObjectEmptyMapTest extends AbstractImmutableDoubleObjectMapTestCase {

    public static final Predicate2<String, String> ERROR_THROWING_PREDICATE_2 = (String argument1, String argument2) -> {
        throw new AssertionError();
    };

    public static final Predicate<String> ERROR_THROWING_PREDICATE = (String each) -> {
        throw new AssertionError();
    };

    @Override
    protected ImmutableDoubleObjectMap<String> classUnderTest() {
        return (ImmutableDoubleObjectMap<String>) ImmutableDoubleObjectEmptyMap.INSTANCE;
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
        Assert.assertFalse(this.classUnderTest().containsKey(0.0));
        Assert.assertFalse(this.classUnderTest().containsKey(31.0));
        Assert.assertFalse(this.classUnderTest().containsKey(32.0));
        Assert.assertFalse(this.classUnderTest().containsKey(1.0));
        Assert.assertFalse(this.classUnderTest().containsKey(5.0));
        Assert.assertFalse(this.classUnderTest().containsKey(35.0));
    }

    @Override
    @Test
    public void getIfAbsent() {
        Function0<String> ifAbsent = () -> "ifAbsent";
        Assert.assertEquals("ifAbsent", this.classUnderTest().getIfAbsent(0.0, ifAbsent));
        Assert.assertEquals("ifAbsent", this.classUnderTest().getIfAbsent(31.0, ifAbsent));
        Assert.assertEquals("ifAbsent", this.classUnderTest().getIfAbsent(32.0, ifAbsent));
        Assert.assertEquals("ifAbsent", this.classUnderTest().getIfAbsent(1.0, ifAbsent));
        Assert.assertEquals("ifAbsent", this.classUnderTest().getIfAbsent(33.0, ifAbsent));
    }

    @Override
    @Test
    public void get() {
        Assert.assertNull(this.classUnderTest().get(0.0));
        Assert.assertNull(this.classUnderTest().get(31.0));
        Assert.assertNull(this.classUnderTest().get(32.0));
        Assert.assertNull(this.classUnderTest().get(1.0));
        Assert.assertNull(this.classUnderTest().get(33.0));
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
        ImmutableDoubleObjectMap<String> map = this.classUnderTest();
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
        this.classUnderTest().forEachKey((double each) -> Assert.fail());
    }

    @Override
    @Test
    public void forEachValue() {
        this.classUnderTest().forEachValue((String each) -> Assert.fail());
    }

    @Override
    @Test
    public void forEachKeyValue() {
        this.classUnderTest().forEachKeyValue((double eachKey, String eachValue) -> Assert.fail());
    }

    @Override
    @Test
    public void select() {
        Verify.assertIterableEmpty(this.classUnderTest().select(Predicates.alwaysTrue()));
        Verify.assertIterableEmpty(this.classUnderTest().select((double value, String object) -> true));
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
        Verify.assertIterableEmpty(this.classUnderTest().reject((double value, String object) -> false));
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
        ImmutableDoubleObjectMap<String> map1 = this.classUnderTest();
        ImmutableDoubleObjectMap<String> map2 = this.classUnderTest();
        Verify.assertSortedBagsEqual(TreeBag.newBag(), map1.toSortedBag());
        Verify.assertSortedBagsEqual(TreeBag.newBag(Comparator.<String>reverseOrder()), map2.toSortedBag(Comparator.<String>reverseOrder()));
    }

    @Override
    @Test
    public void toSortedBagBy() {
        ImmutableDoubleObjectMap<String> map1 = this.classUnderTest();
        Verify.assertSortedBagsEqual(TreeBag.newBag(Comparators.byFunction(String::valueOf)), map1.toSortedBagBy(String::valueOf));
    }

    @Test
    public void toSortedBag_empty() {
        ImmutableDoubleObjectMap<String> map1 = this.classUnderTest();
        MutableSortedBag<String> sortedBag = map1.toSortedBag(Comparator.reverseOrder());
        sortedBag.addOccurrences("apple", 3);
        sortedBag.addOccurrences("orange", 2);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), "orange", "orange", "apple", "apple", "apple"), sortedBag);
    }

    @Test
    public void toSortedBagBy_empty() {
        ImmutableDoubleObjectMap<Integer> map = new ImmutableDoubleObjectEmptyMap<>();
        Function<Integer, Integer> function = object -> object * -1;
        MutableSortedBag<Integer> sortedBag = map.toSortedBagBy(function);
        sortedBag.addOccurrences(1, 3);
        sortedBag.addOccurrences(10, 2);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.byFunction(function), 10, 10, 1, 1, 1), sortedBag);
    }

    @Test
    public void toMapTarget() {
        ImmutableDoubleObjectMap<String> map = this.newWithKeysValues(0.0, "a", 9.0, "abcd");
        ImmutableDoubleObjectMap<String> map1 = new ImmutableDoubleObjectEmptyMap<>();
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
        ImmutableDoubleObjectMap<Integer> map = new ImmutableDoubleObjectEmptyMap<>();
        Assert.assertEquals(ObjectLongMaps.immutable.empty(), map.sumByInt(Object::toString, Integer::valueOf));
    }

    @Test
    public void sumByFloat() {
        ImmutableDoubleObjectMap<Integer> map = new ImmutableDoubleObjectEmptyMap<>();
        Assert.assertEquals(ObjectDoubleMaps.immutable.empty(), map.sumByFloat(Object::toString, Float::valueOf));
    }

    @Test
    public void sumByLong() {
        ImmutableDoubleObjectMap<Integer> map = new ImmutableDoubleObjectEmptyMap<>();
        Assert.assertEquals(ObjectLongMaps.immutable.empty(), map.sumByLong(Object::toString, Long::valueOf));
    }

    @Test
    public void sumByDouble() {
        ImmutableDoubleObjectMap<Integer> map = new ImmutableDoubleObjectEmptyMap<>();
        Assert.assertEquals(ObjectDoubleMaps.immutable.empty(), map.sumByDouble(Object::toString, Double::valueOf));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableDoubleObjectEmptyMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableDoubleObjectEmptyMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> intInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> longInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> floatInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> doubleInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> toImmutableSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> toImmutableSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> toImmutableSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> min_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> max_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> chunk_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> chunk_throws_zero_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> groupByUniqueKey_target_throws_1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> groupByUniqueKey_target_throws_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> groupByUniqueKey_target_throws_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> containsAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> containsNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> selectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> rejectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> min_withComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> max_withComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> collectBoolean_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> collectByte_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> collectChar_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> collectDouble_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> collectFloat_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> collectInt_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> collectLong_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> collectShort_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> toSortedBag_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> toSortedBagBy_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectEmptyMapTest> sumByDouble;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = ImmutableDoubleObjectEmptyMapTest::values;
            this.payloads.collectWithTarget = ImmutableDoubleObjectEmptyMapTest::collectWithTarget;
            this.payloads.injectInto = ImmutableDoubleObjectEmptyMapTest::injectInto;
            this.payloads.intInjectInto = ImmutableDoubleObjectEmptyMapTest::intInjectInto;
            this.payloads.longInjectInto = ImmutableDoubleObjectEmptyMapTest::longInjectInto;
            this.payloads.floatInjectInto = ImmutableDoubleObjectEmptyMapTest::floatInjectInto;
            this.payloads.doubleInjectInto = ImmutableDoubleObjectEmptyMapTest::doubleInjectInto;
            this.payloads.toList = ImmutableDoubleObjectEmptyMapTest::toList;
            this.payloads.toSortedList = ImmutableDoubleObjectEmptyMapTest::toSortedList;
            this.payloads.toSet = ImmutableDoubleObjectEmptyMapTest::toSet;
            this.payloads.toSortedSet = ImmutableDoubleObjectEmptyMapTest::toSortedSet;
            this.payloads.toBag = ImmutableDoubleObjectEmptyMapTest::toBag;
            this.payloads.toMap = ImmutableDoubleObjectEmptyMapTest::toMap;
            this.payloads.toSortedMap = ImmutableDoubleObjectEmptyMapTest::toSortedMap;
            this.payloads.toImmutableList = ImmutableDoubleObjectEmptyMapTest::toImmutableList;
            this.payloads.toImmutableSortedList = ImmutableDoubleObjectEmptyMapTest::toImmutableSortedList;
            this.payloads.toImmutableSet = ImmutableDoubleObjectEmptyMapTest::toImmutableSet;
            this.payloads.toImmutableSortedSet = ImmutableDoubleObjectEmptyMapTest::toImmutableSortedSet;
            this.payloads.toImmutableBag = ImmutableDoubleObjectEmptyMapTest::toImmutableBag;
            this.payloads.toImmutableSortedBag = ImmutableDoubleObjectEmptyMapTest::toImmutableSortedBag;
            this.payloads.toImmutableSortedBagBy = ImmutableDoubleObjectEmptyMapTest::toImmutableSortedBagBy;
            this.payloads.toArray = ImmutableDoubleObjectEmptyMapTest::toArray;
            this.payloads.min_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleObjectEmptyMapTest::min_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.max_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleObjectEmptyMapTest::max_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.keysView = ImmutableDoubleObjectEmptyMapTest::keysView;
            this.payloads.injectIntoKeyValue = ImmutableDoubleObjectEmptyMapTest::injectIntoKeyValue;
            this.payloads.size = ImmutableDoubleObjectEmptyMapTest::size;
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleObjectEmptyMapTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleObjectEmptyMapTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.testEquals = ImmutableDoubleObjectEmptyMapTest::testEquals;
            this.payloads.testHashCode = ImmutableDoubleObjectEmptyMapTest::testHashCode;
            this.payloads.testToString = ImmutableDoubleObjectEmptyMapTest::testToString;
            this.payloads.zip = ImmutableDoubleObjectEmptyMapTest::zip;
            this.payloads.zipWithIndex = ImmutableDoubleObjectEmptyMapTest::zipWithIndex;
            this.payloads.chunk = ImmutableDoubleObjectEmptyMapTest::chunk;
            this.payloads.chunk_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleObjectEmptyMapTest::chunk_throws_negative_size, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_throws_zero_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleObjectEmptyMapTest::chunk_throws_zero_size, java.lang.IllegalArgumentException.class);
            this.payloads.aggregateInPlaceBy = ImmutableDoubleObjectEmptyMapTest::aggregateInPlaceBy;
            this.payloads.aggregateBy = ImmutableDoubleObjectEmptyMapTest::aggregateBy;
            this.payloads.groupBy = ImmutableDoubleObjectEmptyMapTest::groupBy;
            this.payloads.groupByEach = ImmutableDoubleObjectEmptyMapTest::groupByEach;
            this.payloads.groupByUniqueKey = ImmutableDoubleObjectEmptyMapTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleObjectEmptyMapTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ImmutableDoubleObjectEmptyMapTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_1 = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleObjectEmptyMapTest::groupByUniqueKey_target_throws_1, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_2 = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleObjectEmptyMapTest::groupByUniqueKey_target_throws_2, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_3 = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleObjectEmptyMapTest::groupByUniqueKey_target_throws_3, java.lang.IllegalStateException.class);
            this.payloads.makeString = ImmutableDoubleObjectEmptyMapTest::makeString;
            this.payloads.appendString = ImmutableDoubleObjectEmptyMapTest::appendString;
            this.payloads.stream = ImmutableDoubleObjectEmptyMapTest::stream;
            this.payloads.parallelStream = ImmutableDoubleObjectEmptyMapTest::parallelStream;
            this.payloads.toImmutable = ImmutableDoubleObjectEmptyMapTest::toImmutable;
            this.payloads.keySet = ImmutableDoubleObjectEmptyMapTest::keySet;
            this.payloads.flipUniqueValues = ImmutableDoubleObjectEmptyMapTest::flipUniqueValues;
            this.payloads.containsValue = ImmutableDoubleObjectEmptyMapTest::containsValue;
            this.payloads.contains = ImmutableDoubleObjectEmptyMapTest::contains;
            this.payloads.containsAllIterable = ImmutableDoubleObjectEmptyMapTest::containsAllIterable;
            this.payloads.containsAll = ImmutableDoubleObjectEmptyMapTest::containsAll;
            this.payloads.containsAnyIterable = ImmutableDoubleObjectEmptyMapTest::containsAnyIterable;
            this.payloads.containsAny = ImmutableDoubleObjectEmptyMapTest::containsAny;
            this.payloads.containsNoneIterable = ImmutableDoubleObjectEmptyMapTest::containsNoneIterable;
            this.payloads.containsNone = ImmutableDoubleObjectEmptyMapTest::containsNone;
            this.payloads.containsAllArguments = ImmutableDoubleObjectEmptyMapTest::containsAllArguments;
            this.payloads.containsKey = ImmutableDoubleObjectEmptyMapTest::containsKey;
            this.payloads.getIfAbsent = ImmutableDoubleObjectEmptyMapTest::getIfAbsent;
            this.payloads.get = ImmutableDoubleObjectEmptyMapTest::get;
            this.payloads.iterator = ImmutableDoubleObjectEmptyMapTest::iterator;
            this.payloads.isEmpty = ImmutableDoubleObjectEmptyMapTest::isEmpty;
            this.payloads.notEmpty = ImmutableDoubleObjectEmptyMapTest::notEmpty;
            this.payloads.getFirst = ImmutableDoubleObjectEmptyMapTest::getFirst;
            this.payloads.getLast = ImmutableDoubleObjectEmptyMapTest::getLast;
            this.payloads.getOnly = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleObjectEmptyMapTest::getOnly, java.lang.IllegalStateException.class);
            this.payloads.tap = ImmutableDoubleObjectEmptyMapTest::tap;
            this.payloads.forEach = ImmutableDoubleObjectEmptyMapTest::forEach;
            this.payloads.forEachWithIndex = ImmutableDoubleObjectEmptyMapTest::forEachWithIndex;
            this.payloads.forEachWith = ImmutableDoubleObjectEmptyMapTest::forEachWith;
            this.payloads.forEachKey = ImmutableDoubleObjectEmptyMapTest::forEachKey;
            this.payloads.forEachValue = ImmutableDoubleObjectEmptyMapTest::forEachValue;
            this.payloads.forEachKeyValue = ImmutableDoubleObjectEmptyMapTest::forEachKeyValue;
            this.payloads.select = ImmutableDoubleObjectEmptyMapTest::select;
            this.payloads.selectWith = ImmutableDoubleObjectEmptyMapTest::selectWith;
            this.payloads.selectWith_withTarget = ImmutableDoubleObjectEmptyMapTest::selectWith_withTarget;
            this.payloads.selectInstancesOf = ImmutableDoubleObjectEmptyMapTest::selectInstancesOf;
            this.payloads.reject = ImmutableDoubleObjectEmptyMapTest::reject;
            this.payloads.rejectWith = ImmutableDoubleObjectEmptyMapTest::rejectWith;
            this.payloads.rejectWith_withTarget = ImmutableDoubleObjectEmptyMapTest::rejectWith_withTarget;
            this.payloads.detect = ImmutableDoubleObjectEmptyMapTest::detect;
            this.payloads.detectWith = ImmutableDoubleObjectEmptyMapTest::detectWith;
            this.payloads.detectOptional = ImmutableDoubleObjectEmptyMapTest::detectOptional;
            this.payloads.detectWithOptional = ImmutableDoubleObjectEmptyMapTest::detectWithOptional;
            this.payloads.detectIfNone = ImmutableDoubleObjectEmptyMapTest::detectIfNone;
            this.payloads.detectWithIfNone = ImmutableDoubleObjectEmptyMapTest::detectWithIfNone;
            this.payloads.count = ImmutableDoubleObjectEmptyMapTest::count;
            this.payloads.countWith = ImmutableDoubleObjectEmptyMapTest::countWith;
            this.payloads.anySatisfy = ImmutableDoubleObjectEmptyMapTest::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableDoubleObjectEmptyMapTest::anySatisfyWith;
            this.payloads.allSatisfy = ImmutableDoubleObjectEmptyMapTest::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableDoubleObjectEmptyMapTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableDoubleObjectEmptyMapTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableDoubleObjectEmptyMapTest::noneSatisfyWith;
            this.payloads.partition = ImmutableDoubleObjectEmptyMapTest::partition;
            this.payloads.partitionWith = ImmutableDoubleObjectEmptyMapTest::partitionWith;
            this.payloads.min_withComparator = ImmutableDoubleObjectEmptyMapTest::min_withComparator;
            this.payloads.max_withComparator = ImmutableDoubleObjectEmptyMapTest::max_withComparator;
            this.payloads.minBy = ImmutableDoubleObjectEmptyMapTest::minBy;
            this.payloads.maxBy = ImmutableDoubleObjectEmptyMapTest::maxBy;
            this.payloads.min = ImmutableDoubleObjectEmptyMapTest::min;
            this.payloads.max = ImmutableDoubleObjectEmptyMapTest::max;
            this.payloads.sumOfInt = ImmutableDoubleObjectEmptyMapTest::sumOfInt;
            this.payloads.sumOfFloat = ImmutableDoubleObjectEmptyMapTest::sumOfFloat;
            this.payloads.sumOfLong = ImmutableDoubleObjectEmptyMapTest::sumOfLong;
            this.payloads.sumOfDouble = ImmutableDoubleObjectEmptyMapTest::sumOfDouble;
            this.payloads.collectIf = ImmutableDoubleObjectEmptyMapTest::collectIf;
            this.payloads.flatCollect = ImmutableDoubleObjectEmptyMapTest::flatCollect;
            this.payloads.collect = ImmutableDoubleObjectEmptyMapTest::collect;
            this.payloads.collectWith = ImmutableDoubleObjectEmptyMapTest::collectWith;
            this.payloads.collectBoolean = ImmutableDoubleObjectEmptyMapTest::collectBoolean;
            this.payloads.collectBoolean_withTarget = ImmutableDoubleObjectEmptyMapTest::collectBoolean_withTarget;
            this.payloads.collectByte = ImmutableDoubleObjectEmptyMapTest::collectByte;
            this.payloads.collectByte_withTarget = ImmutableDoubleObjectEmptyMapTest::collectByte_withTarget;
            this.payloads.collectChar = ImmutableDoubleObjectEmptyMapTest::collectChar;
            this.payloads.collectChar_withTarget = ImmutableDoubleObjectEmptyMapTest::collectChar_withTarget;
            this.payloads.collectDouble = ImmutableDoubleObjectEmptyMapTest::collectDouble;
            this.payloads.collectDouble_withTarget = ImmutableDoubleObjectEmptyMapTest::collectDouble_withTarget;
            this.payloads.collectFloat = ImmutableDoubleObjectEmptyMapTest::collectFloat;
            this.payloads.collectFloat_withTarget = ImmutableDoubleObjectEmptyMapTest::collectFloat_withTarget;
            this.payloads.collectInt = ImmutableDoubleObjectEmptyMapTest::collectInt;
            this.payloads.collectInt_withTarget = ImmutableDoubleObjectEmptyMapTest::collectInt_withTarget;
            this.payloads.collectLong = ImmutableDoubleObjectEmptyMapTest::collectLong;
            this.payloads.collectLong_withTarget = ImmutableDoubleObjectEmptyMapTest::collectLong_withTarget;
            this.payloads.collectShort = ImmutableDoubleObjectEmptyMapTest::collectShort;
            this.payloads.collectShort_withTarget = ImmutableDoubleObjectEmptyMapTest::collectShort_withTarget;
            this.payloads.toSortedBag = ImmutableDoubleObjectEmptyMapTest::toSortedBag;
            this.payloads.toSortedBagBy = ImmutableDoubleObjectEmptyMapTest::toSortedBagBy;
            this.payloads.toSortedBag_empty = ImmutableDoubleObjectEmptyMapTest::toSortedBag_empty;
            this.payloads.toSortedBagBy_empty = ImmutableDoubleObjectEmptyMapTest::toSortedBagBy_empty;
            this.payloads.toMapTarget = ImmutableDoubleObjectEmptyMapTest::toMapTarget;
            this.payloads.sumByInt = ImmutableDoubleObjectEmptyMapTest::sumByInt;
            this.payloads.sumByFloat = ImmutableDoubleObjectEmptyMapTest::sumByFloat;
            this.payloads.sumByLong = ImmutableDoubleObjectEmptyMapTest::sumByLong;
            this.payloads.sumByDouble = ImmutableDoubleObjectEmptyMapTest::sumByDouble;
        }
    }
}
