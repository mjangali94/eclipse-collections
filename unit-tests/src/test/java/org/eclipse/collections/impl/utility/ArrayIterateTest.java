/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.utility;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function3;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.MutableBooleanList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.map.primitive.ObjectDoubleMap;
import org.eclipse.collections.api.map.primitive.ObjectLongMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.multimap.MutableMultimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.Twin;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.Functions2;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.factory.PrimitiveFunctions;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.block.function.MaxSizeFunction;
import org.eclipse.collections.impl.block.function.MinSizeFunction;
import org.eclipse.collections.impl.block.function.NegativeIntervalFunction;
import org.eclipse.collections.impl.block.procedure.MapPutProcedure;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.AddToList;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.multimap.list.FastListMultimap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iList;

public class ArrayIterateTest {

    private static final Integer[] INTEGER_ARRAY = { 5, 4, 3, 2, 1 };

    @Test
    public void injectInto() {
        Integer[] objectArray = this.threeIntegerArray2();
        Assert.assertEquals(Integer.valueOf(7), ArrayIterate.injectInto(1, objectArray, AddFunction.INTEGER));
    }

    private Integer[] threeIntegerArray2() {
        return new Integer[] { 1, 2, 3 };
    }

    @Test
    public void injectIntoDouble() {
        Double[] objectArray = { (double) 1, (double) 2, (double) 3 };
        Assert.assertEquals(new Double(1 + 1 + 2 + 3), ArrayIterate.injectInto((double) 1, objectArray, AddFunction.DOUBLE));
    }

    @Test
    public void injectIntoPrimitives() {
        double doubleActual = ArrayIterate.injectInto(1.0d, new Double[] { 1.0d, 2.0d, 3.0d }, (doubleParameter, objectParameter) -> doubleParameter + objectParameter);
        Assert.assertEquals(7.0, doubleActual, 0.000001);
        Assert.assertEquals(1.0, ArrayIterate.injectInto(1.0d, new Double[] {}, (doubleParameter, objectParameter) -> doubleParameter + objectParameter), 0.000001);
        long longActual = ArrayIterate.injectInto(1L, new Long[] { 1L, 2L, 3L }, (long longParameter, Long objectParameter) -> longParameter + objectParameter);
        Assert.assertEquals(7L, longActual);
        Assert.assertEquals(1L, ArrayIterate.injectInto(1L, new Long[] {}, (long longParameter, Long objectParameter) -> longParameter + objectParameter));
        int intActual = ArrayIterate.injectInto(1, new Integer[] { 1, 2, 3 }, (int intParameter, Integer objectParameter) -> intParameter + objectParameter);
        Assert.assertEquals(7, intActual);
        Assert.assertEquals(1, ArrayIterate.injectInto(1, new Integer[] {}, (int intParameter, Integer objectParameter) -> intParameter + objectParameter));
        float floatActual = ArrayIterate.injectInto(1.0f, new Float[] { 1.0f, 2.0f, 3.0f }, (float floatParameter, Float objectParameter) -> floatParameter + objectParameter);
        Assert.assertEquals(7.0f, floatActual, 0.000001);
        Assert.assertEquals(1.0f, ArrayIterate.injectInto(1.0f, new Float[] {}, (float floatParameter, Float objectParameter) -> floatParameter + objectParameter), 0.000001);
    }

    @Test
    public void injectIntoWith() {
        Integer[] objectArray = this.threeIntegerArray2();
        Function3<Integer, Integer, Integer, Integer> function = (argument1, argument2, argument3) -> argument1 + argument2 + argument3;
        Assert.assertEquals(Integer.valueOf(10), ArrayIterate.injectIntoWith(1, objectArray, function, 1));
        Integer[] emptyArray = {};
        Assert.assertEquals(Integer.valueOf(1), ArrayIterate.injectIntoWith(1, emptyArray, function, 1));
    }

    @Test
    public void injectIntoThrowsOnNullArgument() {
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.injectInto(0, null, (int intParameter, Object objectParameter) -> 0));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.injectInto(0L, null, (long longParameter, Object objectParameter) -> 0));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.injectInto((double) 0, null, (doubleParameter, objectParameter) -> 0.0));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.injectInto(null, null, null));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.injectInto(5.0f, null, (float floatParameter, Object objectParameter) -> 5.0f));
    }

    @Test(expected = IllegalArgumentException.class)
    public void allSatisfyThrowsOnNullArgument() {
        ArrayIterate.allSatisfy(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void allSatisfyWithThrowsOnNullArgument() {
        ArrayIterate.allSatisfyWith(null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void anySatisfyThrowsOnNullArgument() {
        ArrayIterate.anySatisfy(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void anySatisfyWithThrowsOnNullArgument() {
        ArrayIterate.anySatisfyWith(null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void noneSatisfyThrowsOnNullArgument() {
        ArrayIterate.noneSatisfy(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void noneSatisfyWithThrowsOnNullArgument() {
        ArrayIterate.noneSatisfyWith(null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void selectThrowsOnNullArgument() {
        ArrayIterate.select(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void selectWithTargetThrowsOnNullArgument() {
        ArrayIterate.select(null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void selectWithThrowsOnNullArgument() {
        ArrayIterate.selectWith(null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void selectWithWithTargetThrowsOnNullArgument() {
        ArrayIterate.selectWith(null, null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rejectThrowsOnNullArgument() {
        ArrayIterate.reject(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rejectWithTargetThrowsOnNullArgument() {
        ArrayIterate.reject(null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rejectWithThrowsOnNullArgument() {
        ArrayIterate.rejectWith(null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rejectWithWithTargetThrowsOnNullArgument() {
        ArrayIterate.rejectWith(null, null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void collectThrowsOnNullArgument() {
        ArrayIterate.collect(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void collectIfThrowsOnNullArgument() {
        ArrayIterate.collectIf(null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void collectWithTargetThrowsOnNullArgument() {
        ArrayIterate.collect(null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void collectIfWithTargetThrowsOnNullArgument() {
        ArrayIterate.collectIf(null, null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void collectWithThrowsOnNullArgument() {
        ArrayIterate.collectWith(null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void collectWithWithTargetThrowsOnNullArgument() {
        ArrayIterate.collectWith(null, null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void flatCollectThrowsOnNullArgument() {
        ArrayIterate.flatCollect(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void flatCollectWithTargetThrowsOnNullArgument() {
        ArrayIterate.flatCollect(null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void forEachThrowsOnNullArgument() {
        ArrayIterate.forEach(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void forEachWithFromToThrowsOnNullArgument() {
        ArrayIterate.forEach(null, 0, 0, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void forEachWithIndexThrowsOnNullArgument() {
        ArrayIterate.forEachWithIndex(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void forEachWithIndexWithFromToThrowsOnNullArgument() {
        ArrayIterate.forEachWithIndex(null, 0, 0, null);
    }

    @Test
    public void partition() {
        PartitionIterable<Integer> result = ArrayIterate.partition(new Integer[] { 1, 2, 3, 3, 4, 4, 5, 5, 5, 2 }, Predicates.greaterThan(3));
        Assert.assertEquals(Lists.immutable.of(4, 4, 5, 5, 5), result.getSelected());
        Assert.assertEquals(Lists.immutable.of(1, 2, 3, 3, 2), result.getRejected());
    }

    @Test
    public void partitionWith() {
        PartitionIterable<Integer> result = ArrayIterate.partitionWith(new Integer[] { 1, 2, 3, 3, 4, 4, 5, 5, 5, 2 }, Predicates2.greaterThan(), 3);
        Assert.assertEquals(Lists.immutable.of(4, 4, 5, 5, 5), result.getSelected());
        Assert.assertEquals(Lists.immutable.of(1, 2, 3, 3, 2), result.getRejected());
    }

    @Test
    public void injectIntoString() {
        String[] objectArray1 = { "1", "2", "3" };
        Assert.assertEquals("0123", ArrayIterate.injectInto("0", objectArray1, AddFunction.STRING));
        String[] objectArray2 = { "A", "AB", "ABC", "ABCD" };
        Assert.assertEquals(Integer.valueOf(4), ArrayIterate.injectInto(2, objectArray2, MaxSizeFunction.STRING));
        Assert.assertEquals(Integer.valueOf(1), ArrayIterate.injectInto(2, objectArray2, MinSizeFunction.STRING));
    }

    @Test
    public void collect() {
        Boolean[] objectArray = { true, false, null };
        Assert.assertEquals(iList("true", "false", "null"), ArrayIterate.collect(objectArray, String::valueOf));
    }

    @Test
    public void collectBoolean() {
        Integer[] objectArray = { -1, 0, 42 };
        Assert.assertEquals(this.getExpectedBooleanResults(), ArrayIterate.collectBoolean(objectArray, PrimitiveFunctions.integerIsPositive()));
    }

    @Test
    public void collectBooleanWithTarget() {
        Integer[] objectArray = { -1, 0, 42 };
        BooleanArrayList target = new BooleanArrayList();
        MutableBooleanList result = ArrayIterate.collectBoolean(objectArray, PrimitiveFunctions.integerIsPositive(), target);
        Assert.assertEquals(this.getExpectedBooleanResults(), result);
        Assert.assertSame("Target List not returned as result", target, result);
    }

    private BooleanArrayList getExpectedBooleanResults() {
        return BooleanArrayList.newListWith(false, false, true);
    }

    @Test
    public void collectByte() {
        Integer[] objectArray = { -1, 0, 42 };
        Assert.assertEquals(this.getExpectedByteResults(), ArrayIterate.collectByte(objectArray, PrimitiveFunctions.unboxIntegerToByte()));
    }

    @Test
    public void collectByteWithTarget() {
        Integer[] objectArray = { -1, 0, 42 };
        ByteArrayList target = new ByteArrayList();
        ByteArrayList result = ArrayIterate.collectByte(objectArray, PrimitiveFunctions.unboxIntegerToByte(), target);
        Assert.assertEquals(this.getExpectedByteResults(), result);
        Assert.assertSame("Target List not returned as result", target, result);
    }

    private ByteArrayList getExpectedByteResults() {
        return ByteArrayList.newListWith((byte) -1, (byte) 0, (byte) 42);
    }

    @Test
    public void collectChar() {
        Integer[] objectArray = { -1, 0, 42 };
        Assert.assertEquals(this.getExpectedCharResults(), ArrayIterate.collectChar(objectArray, PrimitiveFunctions.unboxIntegerToChar()));
    }

    @Test
    public void collectCharWithTarget() {
        Integer[] objectArray = { -1, 0, 42 };
        CharArrayList target = new CharArrayList();
        CharArrayList result = ArrayIterate.collectChar(objectArray, PrimitiveFunctions.unboxIntegerToChar(), target);
        Assert.assertEquals(this.getExpectedCharResults(), result);
        Assert.assertSame("Target List not returned as result", target, result);
    }

    private CharArrayList getExpectedCharResults() {
        return CharArrayList.newListWith((char) -1, (char) 0, (char) 42);
    }

    @Test
    public void collectDouble() {
        Integer[] objectArray = { -1, 0, 42 };
        Assert.assertEquals(this.getExpectedDoubleResults(), ArrayIterate.collectDouble(objectArray, PrimitiveFunctions.unboxIntegerToDouble()));
    }

    @Test
    public void collectDoubleWithTarget() {
        Integer[] objectArray = { -1, 0, 42 };
        DoubleArrayList target = new DoubleArrayList();
        DoubleArrayList result = ArrayIterate.collectDouble(objectArray, PrimitiveFunctions.unboxIntegerToDouble(), target);
        Assert.assertEquals(this.getExpectedDoubleResults(), result);
        Assert.assertSame("Target List not returned as result", target, result);
    }

    private DoubleArrayList getExpectedDoubleResults() {
        return DoubleArrayList.newListWith(-1.0d, 0.0d, 42.0d);
    }

    @Test
    public void collectFloat() {
        Integer[] objectArray = { -1, 0, 42 };
        Assert.assertEquals(this.getExpectedFloatResults(), ArrayIterate.collectFloat(objectArray, PrimitiveFunctions.unboxIntegerToFloat()));
    }

    @Test
    public void collectFloatWithTarget() {
        Integer[] objectArray = { -1, 0, 42 };
        FloatArrayList target = new FloatArrayList();
        FloatArrayList result = ArrayIterate.collectFloat(objectArray, PrimitiveFunctions.unboxIntegerToFloat(), target);
        Assert.assertEquals(this.getExpectedFloatResults(), result);
        Assert.assertSame("Target List not returned as result", target, result);
    }

    private FloatArrayList getExpectedFloatResults() {
        return FloatArrayList.newListWith(-1.0f, 0.0f, 42.0f);
    }

    @Test
    public void collectInt() {
        Integer[] objectArray = { -1, 0, 42 };
        Assert.assertEquals(this.getExpectedIntResults(), ArrayIterate.collectInt(objectArray, PrimitiveFunctions.unboxIntegerToInt()));
    }

    @Test
    public void collectIntWithTarget() {
        Integer[] objectArray = { -1, 0, 42 };
        IntArrayList target = new IntArrayList();
        IntArrayList result = ArrayIterate.collectInt(objectArray, PrimitiveFunctions.unboxIntegerToInt(), target);
        Assert.assertEquals(this.getExpectedIntResults(), result);
        Assert.assertSame("Target List not returned as result", target, result);
    }

    private IntArrayList getExpectedIntResults() {
        return IntArrayList.newListWith(-1, 0, 42);
    }

    @Test
    public void collectLong() {
        Integer[] objectArray = { -1, 0, 42 };
        Assert.assertEquals(this.getExpectedLongResults(), ArrayIterate.collectLong(objectArray, PrimitiveFunctions.unboxIntegerToLong()));
    }

    @Test
    public void collectLongWithTarget() {
        Integer[] objectArray = { -1, 0, 42 };
        LongArrayList target = new LongArrayList();
        LongArrayList result = ArrayIterate.collectLong(objectArray, PrimitiveFunctions.unboxIntegerToLong(), target);
        Assert.assertEquals(this.getExpectedLongResults(), result);
        Assert.assertSame("Target List not returned as result", target, result);
    }

    private LongArrayList getExpectedLongResults() {
        return LongArrayList.newListWith(-1L, 0L, 42L);
    }

    @Test
    public void collectShort() {
        Integer[] objectArray = { -1, 0, 42 };
        Assert.assertEquals(this.getExpectedShortResults(), ArrayIterate.collectShort(objectArray, PrimitiveFunctions.unboxIntegerToShort()));
    }

    @Test
    public void collectShortWithTarget() {
        Integer[] objectArray = { -1, 0, 42 };
        ShortArrayList target = new ShortArrayList();
        ShortArrayList result = ArrayIterate.collectShort(objectArray, PrimitiveFunctions.unboxIntegerToShort(), target);
        Assert.assertEquals(this.getExpectedShortResults(), result);
        Assert.assertSame("Target List not returned as result", target, result);
    }

    private ShortArrayList getExpectedShortResults() {
        return ShortArrayList.newListWith((short) -1, (short) 0, (short) 42);
    }

    @Test
    public void collectWith() {
        Boolean[] objectArray = { true, false, null };
        Assert.assertEquals(iList("true", "false", "null"), ArrayIterate.collectWith(objectArray, Functions2.fromFunction(String::valueOf), null));
    }

    @Test
    public void flatCollect() {
        Integer[] objectArray = { 1, 2, 3, 4 };
        Function<Integer, Interval> function = Interval::zeroTo;
        Assert.assertEquals(Lists.immutable.with(0, 1, 0, 1, 2, 0, 1, 2, 3, 0, 1, 2, 3, 4), ArrayIterate.flatCollect(objectArray, function));
        Assert.assertEquals(Lists.immutable.with(5, 0, 1, 0, 1, 2, 0, 1, 2, 3, 0, 1, 2, 3, 4), ArrayIterate.flatCollect(objectArray, function, FastList.newListWith(5)));
    }

    @Test
    public void addAllTo() {
        MutableList<Integer> result = Lists.mutable.of();
        ArrayIterate.addAllTo(new Integer[] { 1, 2, 3 }, result);
        Assert.assertEquals(FastList.newListWith(1, 2, 3), result);
    }

    @Test
    public void getFirstAndLast() {
        List<Boolean> list = new ArrayList<>();
        list.add(Boolean.TRUE);
        list.add(null);
        list.add(Boolean.FALSE);
        Object[] objectArray = list.toArray();
        Assert.assertEquals(Boolean.TRUE, ArrayIterate.getFirst(objectArray));
        Assert.assertEquals(Boolean.FALSE, ArrayIterate.getLast(objectArray));
    }

    @Test
    public void getFirstAndLastOnEmpty() {
        Object[] objectArray = {};
        Assert.assertNull(ArrayIterate.getFirst(objectArray));
        Assert.assertNull(ArrayIterate.getLast(objectArray));
    }

    @Test
    public void select() {
        Assert.assertEquals(FastList.newListWith(5, 4, 3, 2, 1), ArrayIterate.select(INTEGER_ARRAY, Integer.class::isInstance));
    }

    @Test
    public void reject() {
        Assert.assertEquals(FastList.newListWith(5, 4, 3, 2, 1), ArrayIterate.reject(INTEGER_ARRAY, String.class::isInstance));
    }

    @Test
    public void distinct() {
        List<Integer> result = FastList.newList();
        ArrayIterate.distinct(new Integer[] { 5, 3, 1, 5, 7, 1 }, result);
        Assert.assertEquals(FastList.newListWith(5, 3, 1, 7), result);
        result.clear();
        ArrayIterate.distinct(INTEGER_ARRAY, result);
        Assert.assertEquals(FastList.newListWith(INTEGER_ARRAY), result);
        MutableList<Integer> list = ArrayIterate.distinct(new Integer[] { 5, 3, 1, 5, 7, 1 });
        Assert.assertEquals(FastList.newListWith(5, 3, 1, 7), list);
    }

    @Test
    public void distinctWithHashingStrategies() {
        String[] objectArray = { "A", "a", "b", "c", "B", "D", "e", "e", "E", "D" };
        MutableList<String> objectArrayExpected = FastList.newListWith("A", "b", "c", "D", "e");
        Assert.assertEquals(ArrayIterate.distinct(objectArray, HashingStrategies.fromFunction(String::toLowerCase)), objectArrayExpected);
    }

    @Test
    public void distinct_throws() {
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.distinct(null));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.distinct(null, HashingStrategies.defaultStrategy()));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.distinct(null, FastList.newList()));
    }

    @Test
    public void selectWith() {
        Assert.assertEquals(FastList.newListWith(5, 4, 3, 2, 1), ArrayIterate.selectWith(INTEGER_ARRAY, Predicates2.instanceOf(), Integer.class));
    }

    @Test
    public void selectInstancesOf() {
        Assert.assertEquals(iList(1, 3, 5), ArrayIterate.selectInstancesOf(new Number[] { 1, 2.0, 3, 4.0, 5 }, Integer.class));
    }

    @Test
    public void countOnNullOrEmptyArray() {
        Assert.assertEquals(0, ArrayIterate.count(null, ignored1 -> true));
        Assert.assertEquals(0, ArrayIterate.count(new Object[] {}, ignored -> true));
    }

    @Test
    public void count() {
        Assert.assertEquals(3, ArrayIterate.count(INTEGER_ARRAY, Predicates.lessThan(4)));
    }

    @Test
    public void countWith() {
        Assert.assertEquals(5, ArrayIterate.countWith(INTEGER_ARRAY, Predicates2.instanceOf(), Integer.class));
        Assert.assertEquals(0, ArrayIterate.countWith(new Integer[] {}, Predicates2.instanceOf(), Integer.class));
        Assert.assertEquals(1, ArrayIterate.countWith(new Object[] { "test", null, Integer.valueOf(2) }, Predicates2.instanceOf(), Integer.class));
        Assert.assertEquals(0, ArrayIterate.countWith(null, Predicates2.instanceOf(), Integer.class));
    }

    @Test
    public void selectAndRejectWith() {
        Twin<MutableList<Integer>> result = ArrayIterate.selectAndRejectWith(INTEGER_ARRAY, Predicates2.lessThan(), 3);
        MutableList<Integer> positive = result.getOne();
        MutableList<Integer> negative = result.getTwo();
        Verify.assertSize(2, positive);
        Verify.assertContains(2, positive);
        Verify.assertNotContains(3, positive);
        Verify.assertSize(3, negative);
        Verify.assertNotContains(2, negative);
        Verify.assertContains(3, negative);
    }

    @Test
    public void selectWithDifferentTargetCollection() {
        Assert.assertEquals(FastList.newListWith(5, 4, 3, 2, 1), ArrayIterate.select(INTEGER_ARRAY, Integer.class::isInstance, new ArrayList<>()));
    }

    @Test
    public void rejectDifferentTargetCollection() {
        Verify.assertEmpty(ArrayIterate.reject(INTEGER_ARRAY, Integer.class::isInstance, new ArrayList<>()));
    }

    @Test
    public void rejectWith() {
        Verify.assertEmpty(ArrayIterate.rejectWith(INTEGER_ARRAY, Predicates2.instanceOf(), Integer.class));
        Verify.assertEmpty(ArrayIterate.rejectWith(INTEGER_ARRAY, Predicates2.instanceOf(), Integer.class, new ArrayList<>()));
    }

    @Test
    public void collectIf() {
        Object[] integers = Lists.fixedSize.of(1, 2, 3).toArray();
        Verify.assertContainsAll(ArrayIterate.collectIf(integers, Integer.class::isInstance, String::valueOf), "1", "2", "3");
        Verify.assertContainsAll(ArrayIterate.collectIf(integers, Integer.class::isInstance, String::valueOf, FastList.newList()), "1", "2", "3");
    }

    @Test
    public void toMap() {
        MutableMap<String, Integer> map = ArrayIterate.toMap(INTEGER_ARRAY, String::valueOf);
        Verify.assertSize(5, map);
        Verify.assertContainsKeyValue("1", 1, map);
        Verify.assertContainsKeyValue("2", 2, map);
        Verify.assertContainsKeyValue("3", 3, map);
        Verify.assertContainsKeyValue("4", 4, map);
        Verify.assertContainsKeyValue("5", 5, map);
    }

    @Test
    public void toMap2() {
        MutableMap<String, Integer> map = ArrayIterate.toMap(INTEGER_ARRAY, String::valueOf, Functions.squaredInteger());
        Verify.assertSize(5, map);
        Verify.assertContainsKeyValue("1", 1, map);
        Verify.assertContainsKeyValue("2", 4, map);
        Verify.assertContainsKeyValue("3", 9, map);
        Verify.assertContainsKeyValue("4", 16, map);
        Verify.assertContainsKeyValue("5", 25, map);
    }

    @Test
    public void contains() {
        Assert.assertTrue(ArrayIterate.contains(INTEGER_ARRAY, 5));
        Assert.assertFalse(ArrayIterate.contains(INTEGER_ARRAY, 6));
        Assert.assertFalse(ArrayIterate.contains(INTEGER_ARRAY, null));
        Assert.assertTrue(ArrayIterate.contains(new Object[] { null }, null));
    }

    @Test
    public void containsInt() {
        int[] array = { 1, 2, 3, 4, 5 };
        Assert.assertTrue(ArrayIterate.contains(array, 5));
        Assert.assertFalse(ArrayIterate.contains(array, 6));
    }

    @Test
    public void containsLong() {
        long[] array = { 1, 2, 3, 4, 5 };
        Assert.assertTrue(ArrayIterate.contains(array, 5));
        Assert.assertFalse(ArrayIterate.contains(array, 6));
    }

    @Test
    public void containsDouble() {
        double[] array = { 1, 2, 3, 4, 5 };
        Assert.assertTrue(ArrayIterate.contains(array, 5));
        Assert.assertFalse(ArrayIterate.contains(array, 6));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(ArrayIterate.anySatisfy(INTEGER_ARRAY, Integer.class::isInstance));
        Assert.assertFalse(ArrayIterate.anySatisfy(INTEGER_ARRAY, Predicates.isNull()));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertTrue(ArrayIterate.anySatisfyWith(INTEGER_ARRAY, Predicates2.instanceOf(), Integer.class));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(ArrayIterate.allSatisfy(INTEGER_ARRAY, Integer.class::isInstance));
        Assert.assertFalse(ArrayIterate.allSatisfy(INTEGER_ARRAY, Predicates.isNull()));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertTrue(ArrayIterate.allSatisfyWith(INTEGER_ARRAY, Predicates2.instanceOf(), Integer.class));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(ArrayIterate.noneSatisfy(INTEGER_ARRAY, String.class::isInstance));
        Assert.assertFalse(ArrayIterate.noneSatisfy(INTEGER_ARRAY, Predicates.notNull()));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertTrue(ArrayIterate.noneSatisfyWith(INTEGER_ARRAY, Predicates2.instanceOf(), String.class));
    }

    @Test
    public void isEmpty() {
        Assert.assertFalse(ArrayIterate.isEmpty(INTEGER_ARRAY));
        Assert.assertTrue(ArrayIterate.isEmpty(new Object[] {}));
        Assert.assertTrue(ArrayIterate.isEmpty(null));
    }

    @Test
    public void notEmpty() {
        Assert.assertTrue(ArrayIterate.notEmpty(new Integer[] { 5, 4, 3, 2, 1 }));
        Assert.assertFalse(ArrayIterate.notEmpty(new Object[] {}));
        Assert.assertFalse(ArrayIterate.notEmpty(null));
    }

    @Test
    public void size() {
        Assert.assertEquals(5, ArrayIterate.size(new Integer[] { 5, 4, 3, 2, 1 }));
        Assert.assertEquals(0, ArrayIterate.size(null));
    }

    @Test
    public void sort() {
        for (int i = 1; i < 20; i++) {
            MutableList<Integer> integers = Interval.oneTo(i).toList().shuffleThis();
            Integer[] array = integers.toArray(new Integer[i]);
            ArrayIterate.sort(array, array.length, null);
            Assert.assertArrayEquals(array, Interval.oneTo(i).toArray());
            ArrayIterate.sort(array, array.length, Comparator.reverseOrder());
            Integer[] expected = Interval.oneTo(i).reverseThis().toArray();
            Assert.assertArrayEquals(array, expected);
        }
    }

    @Test
    public void get() {
        Assert.assertEquals(Integer.valueOf(1), new Integer[] { 5, 4, 3, 2, 1 }[4]);
    }

    @Test
    public void forEachInBoth() {
        MutableMap<String, String> map = UnifiedMap.newMap();
        ArrayIterate.forEachInBoth(new String[] { "1", "2", "3" }, new String[] { "a", "b", "c" }, new MapPutProcedure<>(map));
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1", "a", "2", "b", "3", "c"), map);
        ArrayIterate.forEachInBoth(null, null, (argument1, argument2) -> Assert.fail());
    }

    @Test(expected = RuntimeException.class)
    public void forEachInBothThrowsOnDifferentLengthArrays() {
        ArrayIterate.forEachInBoth(new Integer[] { 1, 2, 3 }, new Integer[] { 1, 2 }, (argument1, argument2) -> Assert.fail());
    }

    @Test
    public void forEachWithIndex() {
        Integer[] objectArray = { 1, 2, 3, 4 };
        ArrayIterate.forEachWithIndex(objectArray, (i, index) -> Assert.assertEquals(index, i - 1));
    }

    @Test
    public void forEachWithIndexWithFromTo() {
        Integer[] integers = { 4, 4, 4, 4, 3, 3, 3, 2, 2, 1 };
        StringBuilder builder = new StringBuilder();
        ArrayIterate.forEachWithIndex(integers, 5, 7, (each, index) -> builder.append(each).append(index));
        Assert.assertEquals("353627", builder.toString());
        StringBuilder builder2 = new StringBuilder();
        ArrayIterate.forEachWithIndex(integers, 5, 5, (each, index) -> builder2.append(each).append(index));
        Assert.assertEquals("35", builder2.toString());
        StringBuilder builder3 = new StringBuilder();
        ArrayIterate.forEachWithIndex(integers, 0, 9, (each, index) -> builder3.append(each).append(index));
        Assert.assertEquals("40414243343536272819", builder3.toString());
        StringBuilder builder4 = new StringBuilder();
        ArrayIterate.forEachWithIndex(integers, 7, 5, (each, index) -> builder4.append(each).append(index));
        Assert.assertEquals("273635", builder4.toString());
        StringBuilder builder5 = new StringBuilder();
        ArrayIterate.forEachWithIndex(integers, 9, 0, (each, index) -> builder5.append(each).append(index));
        Assert.assertEquals("19282736353443424140", builder5.toString());
        MutableList<Integer> result = Lists.mutable.of();
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> ArrayIterate.forEachWithIndex(integers, -1, 0, new AddToList(result)));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> ArrayIterate.forEachWithIndex(integers, 0, -1, new AddToList(result)));
    }

    private Integer[] createIntegerArray(int size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = 1;
        }
        return array;
    }

    @Test
    public void detect() {
        Integer[] array = this.createIntegerArray(1);
        Assert.assertEquals(Integer.valueOf(1), ArrayIterate.detect(array, integer -> integer == 1));
    }

    @Test
    public void detectWith() {
        Integer[] array = this.createIntegerArray(1);
        Assert.assertEquals(Integer.valueOf(1), ArrayIterate.detectWith(array, Predicates2.lessThan(), 2));
        Assert.assertNull(ArrayIterate.detectWith(new Integer[0], Predicates2.lessThan(), 2));
    }

    @Test
    public void detectIfNone() {
        Integer[] array = this.createIntegerArray(1);
        Assert.assertEquals(Integer.valueOf(7), ArrayIterate.detectIfNone(array, Integer.valueOf(2)::equals, 7));
        Assert.assertEquals(Integer.valueOf(1), ArrayIterate.detectIfNone(array, Integer.valueOf(1)::equals, 7));
    }

    @Test
    public void detectWithIfNone() {
        Integer[] array = this.createIntegerArray(1);
        Assert.assertEquals(Integer.valueOf(7), ArrayIterate.detectWithIfNone(array, Object::equals, 2, 7));
        Assert.assertEquals(Integer.valueOf(1), ArrayIterate.detectWithIfNone(array, Object::equals, 1, 7));
    }

    @Test
    public void indexOf() {
        String[] array = { "1", "2", "3", null };
        Assert.assertEquals(0, ArrayIterate.indexOf(array, "1"));
        Assert.assertEquals(1, ArrayIterate.indexOf(array, "2"));
        Assert.assertEquals(2, ArrayIterate.indexOf(array, "3"));
        Assert.assertEquals(3, ArrayIterate.indexOf(array, null));
        Assert.assertEquals(-1, ArrayIterate.indexOf(array, "4"));
    }

    @Test
    public void indexOfPredicates() {
        String[] array = { "1", "2", "3", null };
        Assert.assertEquals(0, ArrayIterate.detectIndex(array, String.class::isInstance));
        Assert.assertEquals(3, ArrayIterate.detectIndex(array, Predicates.isNull()));
        Assert.assertEquals(0, ArrayIterate.detectIndexWith(array, Predicates2.instanceOf(), String.class));
    }

    @Test
    public void detectLastIndex() {
        Integer[] array = { 1, 2, 2, 3, 3, 3, 4, 2 };
        Assert.assertEquals(7, ArrayIterate.detectLastIndex(array, integer -> integer == 2));
        Assert.assertEquals(6, ArrayIterate.detectLastIndex(array, integer -> integer != 2));
        Assert.assertEquals(-1, ArrayIterate.detectLastIndex(array, integer -> integer == 5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void detectLastIndex_throws() {
        ArrayIterate.detectLastIndex(null, Predicates.alwaysTrue());
    }

    @Test
    public void take() {
        Assert.assertEquals(ListIterate.take(Interval.zeroTo(0), 0), ArrayIterate.take(Interval.zeroTo(0).toArray(), 0));
        Assert.assertEquals(ListIterate.take(Interval.zeroTo(5), 1), ArrayIterate.take(Interval.zeroTo(5).toArray(), 1));
        Assert.assertEquals(ListIterate.take(Interval.zeroTo(5), 2), ArrayIterate.take(Interval.zeroTo(5).toArray(), 2));
        Assert.assertEquals(ListIterate.take(Interval.zeroTo(0), 5), ArrayIterate.take(Interval.zeroTo(0).toArray(), 5));
        Assert.assertEquals(ListIterate.take(Interval.zeroTo(5), 5), ArrayIterate.take(Interval.zeroTo(5).toArray(), 5));
        Assert.assertEquals(ListIterate.take(Interval.zeroTo(10), 5), ArrayIterate.take(Interval.zeroTo(10).toArray(), 5));
        Assert.assertEquals(ListIterate.take(Interval.zeroTo(10), 15), ArrayIterate.take(Interval.zeroTo(10).toArray(), 15));
        Assert.assertEquals(ListIterate.take(Interval.zeroTo(10), Integer.MAX_VALUE), ArrayIterate.take(Interval.zeroTo(10).toArray(), Integer.MAX_VALUE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void take_negative_throws() {
        ArrayIterate.take(Interval.zeroTo(0).toArray(), -1);
    }

    @Test
    public void take_target() {
        Assert.assertEquals(ListIterate.take(Interval.zeroTo(0), 0, FastList.newListWith(-1)), ArrayIterate.take(Interval.zeroTo(0).toArray(), 0, FastList.newListWith(-1)));
        Assert.assertEquals(ListIterate.take(Interval.zeroTo(0), 5, FastList.newListWith(-1)), ArrayIterate.take(Interval.zeroTo(0).toArray(), 5, FastList.newListWith(-1)));
        Assert.assertEquals(ListIterate.take(Interval.zeroTo(5), 5, FastList.newListWith(-1)), ArrayIterate.take(Interval.zeroTo(5).toArray(), 5, FastList.newListWith(-1)));
        Assert.assertEquals(ListIterate.take(Interval.zeroTo(10), 5, FastList.newListWith(-1)), ArrayIterate.take(Interval.zeroTo(10).toArray(), 5, FastList.newListWith(-1)));
        Assert.assertEquals(ListIterate.take(Interval.zeroTo(10), 15, FastList.newListWith(-1)), ArrayIterate.take(Interval.zeroTo(10).toArray(), 15, FastList.newListWith(-1)));
        Assert.assertEquals(ListIterate.take(Interval.zeroTo(10), Integer.MAX_VALUE, FastList.newListWith(-1)), ArrayIterate.take(Interval.zeroTo(10).toArray(), Integer.MAX_VALUE, FastList.newListWith(-1)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void take_target_negative_throws() {
        ArrayIterate.take(Interval.zeroTo(0).toArray(), -1, FastList.newList());
    }

    @Test
    public void drop() {
        Assert.assertEquals(ListIterate.drop(Interval.zeroTo(5).toList(), 0), ArrayIterate.drop(Interval.zeroTo(5).toList().toArray(), 0));
        Assert.assertEquals(ListIterate.drop(Interval.zeroTo(5).toList(), 1), ArrayIterate.drop(Interval.zeroTo(5).toList().toArray(), 1));
        Assert.assertEquals(ListIterate.drop(Interval.zeroTo(0).toList(), 5), ArrayIterate.drop(Interval.zeroTo(0).toList().toArray(), 5));
        Assert.assertEquals(ListIterate.drop(Interval.zeroTo(5), 5), ArrayIterate.drop(Interval.zeroTo(5).toArray(), 5));
        Assert.assertEquals(ListIterate.drop(Interval.zeroTo(10), 5), ArrayIterate.drop(Interval.zeroTo(10).toArray(), 5));
        Assert.assertEquals(ListIterate.drop(Interval.zeroTo(10), 15), ArrayIterate.drop(Interval.zeroTo(10).toArray(), 15));
        Assert.assertEquals(ListIterate.drop(Interval.zeroTo(10), Integer.MAX_VALUE), ArrayIterate.drop(Interval.zeroTo(10).toArray(), Integer.MAX_VALUE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void drop_negative_throws() {
        ArrayIterate.drop(Interval.zeroTo(0).toArray(), -1);
    }

    @Test
    public void drop_target() {
        Assert.assertEquals(ListIterate.drop(Interval.zeroTo(0).toList(), 5, FastList.newListWith(-1)), ArrayIterate.drop(Interval.zeroTo(0).toList().toArray(), 5, FastList.newListWith(-1)));
        Assert.assertEquals(ListIterate.drop(Interval.zeroTo(5), 5, FastList.newListWith(-1)), ArrayIterate.drop(Interval.zeroTo(5).toArray(), 5, FastList.newListWith(-1)));
        Assert.assertEquals(ListIterate.drop(Interval.zeroTo(10), 5, FastList.newListWith(-1)), ArrayIterate.drop(Interval.zeroTo(10).toArray(), 5, FastList.newListWith(-1)));
        Assert.assertEquals(ListIterate.drop(Interval.zeroTo(10), 15, FastList.newListWith(-1)), ArrayIterate.drop(Interval.zeroTo(10).toArray(), 15, FastList.newListWith(-1)));
        Assert.assertEquals(ListIterate.drop(Interval.zeroTo(10), Integer.MAX_VALUE, FastList.newListWith(-1)), ArrayIterate.drop(Interval.zeroTo(10).toArray(), Integer.MAX_VALUE, FastList.newListWith(-1)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void drop_target_negative_throws() {
        ArrayIterate.drop(Interval.zeroTo(0).toArray(), -1, FastList.newListWith(-1));
    }

    @Test
    public void groupBy() {
        Integer[] array = { 1, 2, 3, 4, 5, 6, 7 };
        Function<Integer, Boolean> isOddFunction = object -> IntegerPredicates.isOdd().accept(object);
        MutableMap<Boolean, RichIterable<Integer>> expected = UnifiedMap.newWithKeysValues(Boolean.TRUE, FastList.newListWith(1, 3, 5, 7), Boolean.FALSE, FastList.newListWith(2, 4, 6));
        Multimap<Boolean, Integer> multimap = ArrayIterate.groupBy(array, isOddFunction);
        Assert.assertEquals(expected, multimap.toMap());
    }

    @Test
    public void groupByEach() {
        MutableMultimap<Integer, Integer> expected = FastListMultimap.newMultimap();
        for (int i = 1; i < 8; i++) {
            expected.putAll(-i, Interval.fromTo(i, 7));
        }
        Multimap<Integer, Integer> actual = ArrayIterate.groupByEach(new Integer[] { 1, 2, 3, 4, 5, 6, 7 }, new NegativeIntervalFunction());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void groupByUniqueKey() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, 1, 2, 2, 3, 3), ArrayIterate.groupByUniqueKey(new Integer[] { 1, 2, 3 }, id -> id));
    }

    @Test(expected = IllegalArgumentException.class)
    public void groupByUniqueKey_throws_for_null() {
        ArrayIterate.groupByUniqueKey(null, id -> id);
    }

    @Test(expected = IllegalStateException.class)
    public void groupByUniqueKey_throws_for_duplicate() {
        ArrayIterate.groupByUniqueKey(new Integer[] { 1, 2, 3, 2 }, id -> id);
    }

    @Test
    public void groupByUniqueKey_target() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues(0, 0, 1, 1, 2, 2, 3, 3), ArrayIterate.groupByUniqueKey(new Integer[] { 1, 2, 3 }, id -> id, UnifiedMap.newWithKeysValues(0, 0)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void groupByUniqueKey_target_throws_for_null() {
        ArrayIterate.groupByUniqueKey(null, id -> id, UnifiedMap.newMap());
    }

    @Test(expected = IllegalStateException.class)
    public void groupByUniqueKey_target_throws_for_duplicate() {
        ArrayIterate.groupByUniqueKey(new Integer[] { 1, 2, 3 }, id -> id, UnifiedMap.newWithKeysValues(2, 2));
    }

    @Test
    public void zip() {
        String[] array = { "1", "2", "3", "4", "5", "6", "7" };
        Object[] nulls = Collections.nCopies(array.length, null).toArray();
        Object[] nullsPlusOne = Collections.nCopies(array.length + 1, null).toArray();
        Object[] nullsMinusOne = Collections.nCopies(array.length - 1, null).toArray();
        MutableList<Pair<String, Object>> pairs = ArrayIterate.zip(array, nulls);
        Assert.assertEquals(FastList.newListWith(array), pairs.collect((Function<Pair<String, ?>, String>) Pair::getOne));
        Assert.assertEquals(FastList.newListWith(nulls), pairs.collect((Function<Pair<?, Object>, Object>) Pair::getTwo, Lists.mutable.of()));
        MutableList<Pair<String, Object>> pairsPlusOne = ArrayIterate.zip(array, nullsPlusOne);
        Assert.assertEquals(FastList.newListWith(array), pairsPlusOne.collect((Function<Pair<String, ?>, String>) Pair::getOne));
        Assert.assertEquals(FastList.newListWith(nulls), pairsPlusOne.collect((Function<Pair<?, Object>, Object>) Pair::getTwo, Lists.mutable.of()));
        MutableList<Pair<String, Object>> pairsMinusOne = ArrayIterate.zip(array, nullsMinusOne);
        Assert.assertEquals(array.length - 1, pairsMinusOne.size());
        Assert.assertTrue(FastList.newListWith(array).containsAll(pairsMinusOne.collect((Function<Pair<String, ?>, String>) Pair::getOne)));
        Assert.assertEquals(ArrayIterate.zip(array, nulls), ArrayIterate.zip(array, nulls, FastList.newList()));
    }

    @Test
    public void zipWithIndex() {
        String[] array = { "1", "2", "3", "4", "5", "6", "7" };
        MutableList<Pair<String, Integer>> pairs = ArrayIterate.zipWithIndex(array);
        Assert.assertEquals(FastList.newListWith(array), pairs.collect((Function<Pair<String, ?>, String>) Pair::getOne));
        Assert.assertEquals(Interval.zeroTo(array.length - 1).toList(), pairs.collect((Function<Pair<?, Integer>, Integer>) Pair::getTwo, FastList.newList()));
        Assert.assertEquals(ArrayIterate.zipWithIndex(array), ArrayIterate.zipWithIndex(array, FastList.newList()));
    }

    @Test
    public void chunk() {
        String[] array = { "1", "2", "3", "4", "5", "6", "7" };
        RichIterable<RichIterable<String>> groups = ArrayIterate.chunk(array, 2);
        Assert.assertEquals(Lists.immutable.with(Lists.immutable.with("1", "2"), Lists.immutable.with("3", "4"), Lists.immutable.with("5", "6"), Lists.immutable.with("7")), groups);
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        String[] array = { "1", "2", "3", "4", "5", "6", "7" };
        ArrayIterate.chunk(array, 0);
    }

    @Test
    public void chunk_large_size() {
        String[] array = { "1", "2", "3", "4", "5", "6", "7" };
        Assert.assertEquals(FastList.newListWith(array), ArrayIterate.chunk(array, 10).getFirst());
    }

    @Test
    public void makeString() {
        String[] array = { "1", "2", "3", "4", "5" };
        Assert.assertEquals("1, 2, 3, 4, 5", ArrayIterate.makeString(array));
    }

    @Test
    public void appendString() {
        String[] array = { "1", "2", "3", "4", "5" };
        StringBuilder stringBuilder = new StringBuilder();
        ArrayIterate.appendString(array, stringBuilder);
        Assert.assertEquals("1, 2, 3, 4, 5", stringBuilder.toString());
        String[] emptyArray = {};
        ArrayIterate.appendString(emptyArray, stringBuilder);
        Assert.assertEquals("1, 2, 3, 4, 5", stringBuilder.toString());
    }

    @Test(expected = RuntimeException.class)
    public void appendStringThrowsIOException() {
        ArrayIterate.appendString(new String[] { "1", "2", "3" }, new Appendable() {

            public Appendable append(CharSequence csq) throws IOException {
                throw new IOException();
            }

            public Appendable append(CharSequence csq, int start, int end) throws IOException {
                throw new IOException();
            }

            public Appendable append(char c) throws IOException {
                throw new IOException();
            }
        });
    }

    @Test
    public void sumFloat() {
        Integer[] objects = { 1, 2, 3 };
        float expected = ArrayIterate.injectInto(0.0f, objects, AddFunction.INTEGER_TO_FLOAT);
        double actual = ArrayIterate.sumOfFloat(objects, Integer::floatValue);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void sumDouble() {
        Integer[] objects = { 1, 2, 3 };
        double expected = ArrayIterate.injectInto(0.0d, objects, AddFunction.INTEGER_TO_DOUBLE);
        double actual = ArrayIterate.sumOfDouble(objects, Integer::doubleValue);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void sumInteger() {
        Integer[] objects = { 1, 2, 3 };
        long expected = ArrayIterate.injectInto(0, objects, AddFunction.INTEGER_TO_LONG);
        long actual = ArrayIterate.sumOfInt(objects, integer -> integer);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sumLong() {
        Integer[] objects = { 1, 2, 3 };
        long expected = ArrayIterate.injectInto(0L, objects, AddFunction.INTEGER_TO_LONG);
        long actual = ArrayIterate.sumOfLong(objects, Integer::longValue);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sumOfBigDecimal() {
        Integer[] objects = { 1, 2, 3, 4, 5 };
        Assert.assertEquals(new BigDecimal(15), ArrayIterate.sumOfBigDecimal(objects, BigDecimal::new));
    }

    @Test
    public void sumOfBigInteger() {
        Integer[] objects = { 1, 2, 3, 4, 5 };
        Assert.assertEquals(new BigInteger("15"), ArrayIterate.sumOfBigInteger(objects, integer -> new BigInteger(integer.toString())));
    }

    @Test
    public void sumByInt() {
        Integer[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        ObjectLongMap<Integer> result = ArrayIterate.sumByInt(values, i -> i % 2, e -> e);
        Assert.assertEquals(25, result.get(1));
        Assert.assertEquals(30, result.get(0));
    }

    @Test
    public void sumByFloat() {
        Integer[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        ObjectDoubleMap<Integer> result = ArrayIterate.sumByFloat(values, f -> f % 2, e -> e);
        Assert.assertEquals(25.0f, result.get(1), 0.0);
        Assert.assertEquals(30.0f, result.get(0), 0.0);
    }

    @Test
    public void sumByLong() {
        Integer[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        ObjectLongMap<Integer> result = ArrayIterate.sumByLong(values, l -> l % 2, e -> e);
        Assert.assertEquals(25, result.get(1));
        Assert.assertEquals(30, result.get(0));
    }

    @Test
    public void sumByDouble() {
        Integer[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        ObjectDoubleMap<Integer> result = ArrayIterate.sumByDouble(values, d -> d % 2, e -> e);
        Assert.assertEquals(25.0d, result.get(1), 0.0);
        Assert.assertEquals(30.0d, result.get(0), 0.0);
    }

    @Test
    public void sumByBigDecimal() {
        Integer[] integers = { 1, 2, 3, 4, 5 };
        MutableMap<Integer, BigDecimal> result = ArrayIterate.sumByBigDecimal(integers, e -> e % 2, BigDecimal::new);
        Assert.assertEquals(new BigDecimal(9), result.get(1));
        Assert.assertEquals(new BigDecimal(6), result.get(0));
    }

    @Test
    public void sumByBigInteger() {
        Integer[] integers = { 1, 2, 3, 4, 5 };
        MutableMap<Integer, BigInteger> result = ArrayIterate.sumByBigInteger(integers, e -> e % 2, i -> new BigInteger(i.toString()));
        Assert.assertEquals(new BigInteger("9"), result.get(1));
        Assert.assertEquals(new BigInteger("6"), result.get(0));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ArrayIterate.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectInto, this.description("injectInto"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoDouble, this.description("injectIntoDouble"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoPrimitives() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoPrimitives, this.description("injectIntoPrimitives"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoWith, this.description("injectIntoWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoThrowsOnNullArgument() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoThrowsOnNullArgument, this.description("injectIntoThrowsOnNullArgument"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyThrowsOnNullArgument() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::allSatisfyThrowsOnNullArgument, this.description("allSatisfyThrowsOnNullArgument"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWithThrowsOnNullArgument() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::allSatisfyWithThrowsOnNullArgument, this.description("allSatisfyWithThrowsOnNullArgument"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyThrowsOnNullArgument() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::anySatisfyThrowsOnNullArgument, this.description("anySatisfyThrowsOnNullArgument"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWithThrowsOnNullArgument() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::anySatisfyWithThrowsOnNullArgument, this.description("anySatisfyWithThrowsOnNullArgument"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyThrowsOnNullArgument() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::noneSatisfyThrowsOnNullArgument, this.description("noneSatisfyThrowsOnNullArgument"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWithThrowsOnNullArgument() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::noneSatisfyWithThrowsOnNullArgument, this.description("noneSatisfyWithThrowsOnNullArgument"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectThrowsOnNullArgument() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::selectThrowsOnNullArgument, this.description("selectThrowsOnNullArgument"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithTargetThrowsOnNullArgument() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::selectWithTargetThrowsOnNullArgument, this.description("selectWithTargetThrowsOnNullArgument"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithThrowsOnNullArgument() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::selectWithThrowsOnNullArgument, this.description("selectWithThrowsOnNullArgument"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithWithTargetThrowsOnNullArgument() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::selectWithWithTargetThrowsOnNullArgument, this.description("selectWithWithTargetThrowsOnNullArgument"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectThrowsOnNullArgument() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::rejectThrowsOnNullArgument, this.description("rejectThrowsOnNullArgument"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithTargetThrowsOnNullArgument() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::rejectWithTargetThrowsOnNullArgument, this.description("rejectWithTargetThrowsOnNullArgument"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithThrowsOnNullArgument() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::rejectWithThrowsOnNullArgument, this.description("rejectWithThrowsOnNullArgument"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithWithTargetThrowsOnNullArgument() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::rejectWithWithTargetThrowsOnNullArgument, this.description("rejectWithWithTargetThrowsOnNullArgument"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectThrowsOnNullArgument() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::collectThrowsOnNullArgument, this.description("collectThrowsOnNullArgument"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIfThrowsOnNullArgument() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::collectIfThrowsOnNullArgument, this.description("collectIfThrowsOnNullArgument"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTargetThrowsOnNullArgument() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::collectWithTargetThrowsOnNullArgument, this.description("collectWithTargetThrowsOnNullArgument"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIfWithTargetThrowsOnNullArgument() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::collectIfWithTargetThrowsOnNullArgument, this.description("collectIfWithTargetThrowsOnNullArgument"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithThrowsOnNullArgument() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::collectWithThrowsOnNullArgument, this.description("collectWithThrowsOnNullArgument"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithWithTargetThrowsOnNullArgument() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::collectWithWithTargetThrowsOnNullArgument, this.description("collectWithWithTargetThrowsOnNullArgument"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectThrowsOnNullArgument() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::flatCollectThrowsOnNullArgument, this.description("flatCollectThrowsOnNullArgument"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTargetThrowsOnNullArgument() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::flatCollectWithTargetThrowsOnNullArgument, this.description("flatCollectWithTargetThrowsOnNullArgument"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachThrowsOnNullArgument() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::forEachThrowsOnNullArgument, this.description("forEachThrowsOnNullArgument"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithFromToThrowsOnNullArgument() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::forEachWithFromToThrowsOnNullArgument, this.description("forEachWithFromToThrowsOnNullArgument"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexThrowsOnNullArgument() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::forEachWithIndexThrowsOnNullArgument, this.description("forEachWithIndexThrowsOnNullArgument"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexWithFromToThrowsOnNullArgument() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::forEachWithIndexWithFromToThrowsOnNullArgument, this.description("forEachWithIndexWithFromToThrowsOnNullArgument"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::partition, this.description("partition"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::partitionWith, this.description("partitionWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoString, this.description("injectIntoString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect, this.description("collect"));
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
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectByte, this.description("collectByte"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectByteWithTarget, this.description("collectByteWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectChar, this.description("collectChar"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectCharWithTarget, this.description("collectCharWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectDouble, this.description("collectDouble"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectDoubleWithTarget, this.description("collectDoubleWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectFloat, this.description("collectFloat"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectFloatWithTarget, this.description("collectFloatWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectInt, this.description("collectInt"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectIntWithTarget, this.description("collectIntWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectLong, this.description("collectLong"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectLongWithTarget, this.description("collectLongWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectShort, this.description("collectShort"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectShortWithTarget, this.description("collectShortWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectWith, this.description("collectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::flatCollect, this.description("flatCollect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllTo() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addAllTo, this.description("addAllTo"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirstAndLast() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getFirstAndLast, this.description("getFirstAndLast"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirstAndLastOnEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getFirstAndLastOnEmpty, this.description("getFirstAndLastOnEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::select, this.description("select"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reject, this.description("reject"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::distinct, this.description("distinct"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctWithHashingStrategies() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::distinctWithHashingStrategies, this.description("distinctWithHashingStrategies"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::distinct_throws, this.description("distinct_throws"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectWith, this.description("selectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectInstancesOf, this.description("selectInstancesOf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countOnNullOrEmptyArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::countOnNullOrEmptyArray, this.description("countOnNullOrEmptyArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::count, this.description("count"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::countWith, this.description("countWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectAndRejectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectAndRejectWith, this.description("selectAndRejectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithDifferentTargetCollection() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectWithDifferentTargetCollection, this.description("selectWithDifferentTargetCollection"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectDifferentTargetCollection() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::rejectDifferentTargetCollection, this.description("rejectDifferentTargetCollection"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::rejectWith, this.description("rejectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectIf, this.description("collectIf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toMap, this.description("toMap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap2() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toMap2, this.description("toMap2"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::contains, this.description("contains"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsInt() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsInt, this.description("containsInt"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsLong() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsLong, this.description("containsLong"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsDouble() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsDouble, this.description("containsDouble"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfy, this.description("anySatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfyWith, this.description("anySatisfyWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfy, this.description("allSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfyWith, this.description("allSatisfyWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::noneSatisfy, this.description("noneSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::noneSatisfyWith, this.description("noneSatisfyWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isEmpty, this.description("isEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::notEmpty, this.description("notEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::size, this.description("size"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sort() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sort, this.description("sort"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::get, this.description("get"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachInBoth() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachInBoth, this.description("forEachInBoth"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachInBothThrowsOnDifferentLengthArrays() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::forEachInBothThrowsOnDifferentLengthArrays, this.description("forEachInBothThrowsOnDifferentLengthArrays"), java.lang.RuntimeException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWithIndex, this.description("forEachWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexWithFromTo() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWithIndexWithFromTo, this.description("forEachWithIndexWithFromTo"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detect, this.description("detect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectWith, this.description("detectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectIfNone, this.description("detectIfNone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectWithIfNone, this.description("detectWithIfNone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::indexOf, this.description("indexOf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOfPredicates() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::indexOfPredicates, this.description("indexOfPredicates"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectLastIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectLastIndex, this.description("detectLastIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectLastIndex_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::detectLastIndex_throws, this.description("detectLastIndex_throws"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::take, this.description("take"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take_negative_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::take_negative_throws, this.description("take_negative_throws"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take_target() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::take_target, this.description("take_target"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take_target_negative_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::take_target_negative_throws, this.description("take_target_negative_throws"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::drop, this.description("drop"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop_negative_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::drop_negative_throws, this.description("drop_negative_throws"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop_target() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::drop_target, this.description("drop_target"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop_target_negative_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::drop_target_negative_throws, this.description("drop_target_negative_throws"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupBy, this.description("groupBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupByEach, this.description("groupByEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupByUniqueKey, this.description("groupByUniqueKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws_for_null() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::groupByUniqueKey_throws_for_null, this.description("groupByUniqueKey_throws_for_null"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws_for_duplicate() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::groupByUniqueKey_throws_for_duplicate, this.description("groupByUniqueKey_throws_for_duplicate"), java.lang.IllegalStateException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupByUniqueKey_target, this.description("groupByUniqueKey_target"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_for_null() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::groupByUniqueKey_target_throws_for_null, this.description("groupByUniqueKey_target_throws_for_null"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_for_duplicate() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::groupByUniqueKey_target_throws_for_duplicate, this.description("groupByUniqueKey_target_throws_for_duplicate"), java.lang.IllegalStateException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zip, this.description("zip"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zipWithIndex, this.description("zipWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::chunk, this.description("chunk"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::chunk_zero_throws, this.description("chunk_zero_throws"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::chunk_large_size, this.description("chunk_large_size"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::makeString, this.description("makeString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::appendString, this.description("appendString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringThrowsIOException() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::appendStringThrowsIOException, this.description("appendStringThrowsIOException"), java.lang.RuntimeException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloat() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumFloat, this.description("sumFloat"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumDouble, this.description("sumDouble"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumInteger, this.description("sumInteger"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumLong, this.description("sumLong"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfBigDecimal() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumOfBigDecimal, this.description("sumOfBigDecimal"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfBigInteger() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumOfBigInteger, this.description("sumOfBigInteger"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumByInt, this.description("sumByInt"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumByFloat, this.description("sumByFloat"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumByLong, this.description("sumByLong"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumByDouble, this.description("sumByDouble"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByBigDecimal() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumByBigDecimal, this.description("sumByBigDecimal"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByBigInteger() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumByBigInteger, this.description("sumByBigInteger"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::classIsNonInstantiable, this.description("classIsNonInstantiable"));
        }

        private ArrayIterateTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ArrayIterateTest();
        }

        @java.lang.Override
        public ArrayIterateTest implementation() {
            return this.implementation;
        }
    }
}
