/*
 * Copyright (c) 2021 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.stack;

import java.util.Collections;
import java.util.EmptyStackException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.sorted.SortedBag;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.predicate.Predicate;
import org.eclipse.collections.api.block.predicate.Predicate2;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MapIterable;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.map.primitive.ObjectDoubleMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.multimap.MutableMultimap;
import org.eclipse.collections.api.multimap.list.ListMultimap;
import org.eclipse.collections.api.partition.stack.PartitionStack;
import org.eclipse.collections.api.set.SetIterable;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.stack.StackIterable;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;
import org.eclipse.collections.impl.AbstractRichIterableTestCase;
import org.eclipse.collections.impl.bag.sorted.mutable.TreeBag;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.factory.PrimitiveFunctions;
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.block.function.NegativeIntervalFunction;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Stacks;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.sorted.mutable.TreeSortedMap;
import org.eclipse.collections.impl.multimap.list.FastListMultimap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.BooleanHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.eclipse.collections.impl.stack.mutable.primitive.BooleanArrayStack;
import org.eclipse.collections.impl.stack.mutable.primitive.ByteArrayStack;
import org.eclipse.collections.impl.stack.mutable.primitive.CharArrayStack;
import org.eclipse.collections.impl.stack.mutable.primitive.DoubleArrayStack;
import org.eclipse.collections.impl.stack.mutable.primitive.FloatArrayStack;
import org.eclipse.collections.impl.stack.mutable.primitive.IntArrayStack;
import org.eclipse.collections.impl.stack.mutable.primitive.LongArrayStack;
import org.eclipse.collections.impl.stack.mutable.primitive.ShortArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

public abstract class StackIterableTestCase extends AbstractRichIterableTestCase {

    @Override
    protected <T> StackIterable<T> newWith(T... littleElements) {
        return this.newStackWith(littleElements);
    }

    protected abstract <T> StackIterable<T> newStackWith(T... elements);

    protected abstract <T> StackIterable<T> newStackFromTopToBottom(T... elements);

    protected abstract <T> StackIterable<T> newStackFromTopToBottom(Iterable<T> elements);

    protected abstract <T> StackIterable<T> newStack(Iterable<T> elements);

    @Test
    public void testNewStackFromTopToBottom() {
        Assert.assertEquals(this.newStackWith(3, 2, 1), this.newStackFromTopToBottom(1, 2, 3));
    }

    @Test(expected = EmptyStackException.class)
    public void peek_empty_throws() {
        this.newStackWith().peek();
    }

    @Test(expected = EmptyStackException.class)
    public void peek_int_empty_throws() {
        this.newStackWith().peek(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void peek_int_count_throws() {
        this.newStackWith(1, 2, 3).peek(4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void peek_int_neg_throws() {
        this.newStackWith(1, 2, 3).peek(-1);
    }

    @Test
    public void peek_illegal_arguments() {
        StackIterable<Integer> stack = this.newStackFromTopToBottom(1, 2, 3);
        Assert.assertThrows(IllegalArgumentException.class, () -> stack.peek(-1));
        Assert.assertThrows(IllegalArgumentException.class, () -> stack.peek(4));
        Assert.assertEquals(Lists.mutable.with(1, 2, 3), stack.peek(3));
    }

    @Test
    public void peek() {
        Assert.assertEquals("3", this.newStackWith("1", "2", "3").peek());
        Assert.assertEquals(Lists.mutable.with(), this.newStackWith("1", "2", "3").peek(0));
        Assert.assertEquals(Lists.mutable.with("3", "2"), this.newStackWith("1", "2", "3").peek(2));
    }

    @Test
    public void peekAt() {
        Assert.assertEquals("3", this.newStackWith("1", "2", "3").peekAt(0));
        Assert.assertEquals("2", this.newStackWith("1", "2", "3").peekAt(1));
        Assert.assertEquals("1", this.newStackWith("1", "2", "3").peekAt(2));
    }

    @Test
    public void peekAt_illegal_arguments() {
        StackIterable<String> stack = this.newStackWith("1", "2", "3");
        Assert.assertThrows(IllegalArgumentException.class, () -> stack.peekAt(stack.size()));
    }

    @Test
    public void size() {
        StackIterable<Integer> stack1 = this.newStackWith();
        Assert.assertEquals(0, stack1.size());
        StackIterable<Integer> stack2 = this.newStackWith(1, 2);
        Assert.assertEquals(2, stack2.size());
    }

    @Override
    @Test
    public void getFirst() {
        StackIterable<Integer> stack = this.newStackWith(1, 2, 3);
        Assert.assertEquals(Integer.valueOf(3), stack.getFirst());
        Assert.assertEquals(stack.peek(), stack.getFirst());
        Assert.assertThrows(EmptyStackException.class, () -> this.newStackWith().getFirst());
        StackIterable<Integer> stack2 = this.newStackFromTopToBottom(1, 2, 3);
        Assert.assertEquals(Integer.valueOf(1), stack2.getFirst());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void getLast() {
        StackIterable<Integer> stack = this.newStackWith(1, 2, 3);
        Assert.assertEquals(Integer.valueOf(1), stack.getLast());
    }

    @Test
    public void containsAll() {
        StackIterable<Integer> stack = this.newStackWith(1, 2, 3, 4);
        Assert.assertTrue(stack.containsAll(Interval.oneTo(2)));
        Assert.assertFalse(stack.containsAll(Lists.mutable.with(1, 2, 5)));
    }

    @Test
    public void containsAllArguments() {
        StackIterable<Integer> stack = this.newStackWith(1, 2, 3, 4);
        Assert.assertTrue(stack.containsAllArguments(2, 1, 3));
        Assert.assertFalse(stack.containsAllArguments(2, 1, 3, 5));
    }

    @Override
    @Test
    public void collect() {
        StackIterable<Boolean> stack = this.newStackFromTopToBottom(Boolean.TRUE, Boolean.FALSE, null);
        CountingFunction<Object, String> function = CountingFunction.of(String::valueOf);
        Assert.assertEquals(this.newStackFromTopToBottom("true", "false", "null"), stack.collect(function));
        Assert.assertEquals(3, function.count);
        Assert.assertEquals(Lists.mutable.with("true", "false", "null"), stack.collect(String::valueOf, FastList.newList()));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex() {
        StackIterable<String> stack = this.newStackFromTopToBottom("4", "3", "2", "1");
        StackIterable<ObjectIntPair<String>> expected = this.newStackFromTopToBottom(PrimitiveTuples.pair("4", 0), PrimitiveTuples.pair("3", 1), PrimitiveTuples.pair("2", 2), PrimitiveTuples.pair("1", 3));
        Assert.assertEquals(expected, stack.collectWithIndex(PrimitiveTuples::pair));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget() {
        StackIterable<String> stack = this.newStackFromTopToBottom("4", "3", "2", "1");
        MutableList<ObjectIntPair<String>> expected = Lists.mutable.with(PrimitiveTuples.pair("4", 0), PrimitiveTuples.pair("3", 1), PrimitiveTuples.pair("2", 2), PrimitiveTuples.pair("1", 3));
        Assert.assertEquals(expected, stack.collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty()));
    }

    /**
     * @since 11.0.
     */
    @Test
    public void selectWithIndexWithTarget() {
        StackIterable<String> stack = this.newStackFromTopToBottom("4", "3", "2", "1");
        List<String> expected = Lists.mutable.with("4", "2");
        Assert.assertEquals(expected, stack.selectWithIndex((each, index) -> index % 2 == 0, Lists.mutable.empty()));
    }

    /**
     * @since 11.0.
     */
    @Test
    public void rejectWithIndexWithTarget() {
        StackIterable<String> stack = this.newStackFromTopToBottom("4", "3", "2", "1");
        List<String> expected = Lists.mutable.with("3", "1");
        Assert.assertEquals(expected, stack.rejectWithIndex((each, index) -> index % 2 == 0, Lists.mutable.empty()));
    }

    @Override
    @Test
    public void collectBoolean() {
        StackIterable<String> stack = this.newStackFromTopToBottom("true", "nah", "TrUe", "false");
        Assert.assertEquals(BooleanArrayStack.newStackFromTopToBottom(true, false, true, false), stack.collectBoolean(Boolean::parseBoolean));
    }

    @Override
    @Test
    public void collectBooleanWithTarget() {
        BooleanHashSet target = new BooleanHashSet();
        StackIterable<String> stack = this.newStackFromTopToBottom("true", "nah", "TrUe", "false");
        BooleanHashSet result = stack.collectBoolean(Boolean::parseBoolean, target);
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false, true, false), result);
        Assert.assertSame("Target sent as parameter not returned", target, result);
    }

    @Override
    @Test
    public void collectByte() {
        StackIterable<Integer> stack = this.newStackFromTopToBottom(1, 2, 3);
        Assert.assertEquals(ByteArrayStack.newStackFromTopToBottom((byte) 1, (byte) 2, (byte) 3), stack.collectByte(PrimitiveFunctions.unboxIntegerToByte()));
    }

    @Override
    @Test
    public void collectByteWithTarget() {
        ByteHashSet target = new ByteHashSet();
        StackIterable<Integer> stack = this.newStackFromTopToBottom(1, 2, 3);
        ByteHashSet result = stack.collectByte(PrimitiveFunctions.unboxIntegerToByte(), target);
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3), result);
        Assert.assertSame("Target sent as parameter not returned", target, result);
    }

    @Override
    @Test
    public void collectChar() {
        StackIterable<Integer> stack = this.newStackFromTopToBottom(1, 2, 3);
        Assert.assertEquals(CharArrayStack.newStackFromTopToBottom((char) 1, (char) 2, (char) 3), stack.collectChar(PrimitiveFunctions.unboxIntegerToChar()));
    }

    @Override
    @Test
    public void collectCharWithTarget() {
        CharHashSet target = new CharHashSet();
        StackIterable<Integer> stack = this.newStackFromTopToBottom(1, 2, 3);
        CharHashSet result = stack.collectChar(PrimitiveFunctions.unboxIntegerToChar(), target);
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3), result);
        Assert.assertSame("Target sent as parameter not returned", target, result);
    }

    @Override
    @Test
    public void collectDouble() {
        StackIterable<Integer> stack = this.newStackFromTopToBottom(1, 2, 3);
        Assert.assertEquals(DoubleArrayStack.newStackFromTopToBottom(1, 2, 3), stack.collectDouble(PrimitiveFunctions.unboxIntegerToDouble()));
    }

    @Override
    @Test
    public void collectDoubleWithTarget() {
        DoubleHashSet target = new DoubleHashSet();
        StackIterable<Integer> stack = this.newStackFromTopToBottom(1, 2, 3);
        DoubleHashSet result = stack.collectDouble(PrimitiveFunctions.unboxIntegerToDouble(), target);
        Assert.assertEquals(DoubleHashSet.newSetWith(1, 2, 3), result);
        Assert.assertSame("Target sent as parameter not returned", target, result);
    }

    @Override
    @Test
    public void collectFloat() {
        StackIterable<Integer> stack = this.newStackFromTopToBottom(1, 2, 3);
        Assert.assertEquals(FloatArrayStack.newStackFromTopToBottom(1, 2, 3), stack.collectFloat(PrimitiveFunctions.unboxIntegerToFloat()));
    }

    @Override
    @Test
    public void collectFloatWithTarget() {
        FloatHashSet target = new FloatHashSet();
        StackIterable<Integer> stack = this.newStackFromTopToBottom(1, 2, 3);
        FloatHashSet result = stack.collectFloat(PrimitiveFunctions.unboxIntegerToFloat(), target);
        Assert.assertEquals(FloatHashSet.newSetWith(1, 2, 3), result);
        Assert.assertSame("Target sent as parameter not returned", target, result);
    }

    @Override
    @Test
    public void collectInt() {
        StackIterable<Integer> stack = this.newStackFromTopToBottom(1, 2, 3);
        Assert.assertEquals(IntArrayStack.newStackFromTopToBottom(1, 2, 3), stack.collectInt(PrimitiveFunctions.unboxIntegerToInt()));
    }

    @Override
    @Test
    public void collectIntWithTarget() {
        IntHashSet target = new IntHashSet();
        StackIterable<Integer> stack = this.newStackFromTopToBottom(1, 2, 3);
        IntHashSet result = stack.collectInt(PrimitiveFunctions.unboxIntegerToInt(), target);
        Assert.assertEquals(IntHashSet.newSetWith(1, 2, 3), result);
        Assert.assertSame("Target sent as parameter not returned", target, result);
    }

    @Override
    @Test
    public void collectLong() {
        StackIterable<Integer> stack = this.newStackFromTopToBottom(1, 2, 3);
        Assert.assertEquals(LongArrayStack.newStackFromTopToBottom(1, 2, 3), stack.collectLong(PrimitiveFunctions.unboxIntegerToLong()));
    }

    @Override
    @Test
    public void collectLongWithTarget() {
        LongHashSet target = new LongHashSet();
        StackIterable<Integer> stack = this.newStackFromTopToBottom(1, 2, 3);
        LongHashSet result = stack.collectLong(PrimitiveFunctions.unboxIntegerToLong(), target);
        Assert.assertEquals(LongHashSet.newSetWith(1, 2, 3), result);
        Assert.assertSame("Target sent as parameter not returned", target, result);
    }

    @Override
    @Test
    public void collectShort() {
        StackIterable<Integer> stack = this.newStackFromTopToBottom(1, 2, 3);
        Assert.assertEquals(ShortArrayStack.newStackFromTopToBottom((short) 1, (short) 2, (short) 3), stack.collectShort(PrimitiveFunctions.unboxIntegerToShort()));
    }

    @Override
    @Test
    public void collectShortWithTarget() {
        ShortHashSet target = new ShortHashSet();
        StackIterable<Integer> stack = this.newStackFromTopToBottom(1, 2, 3);
        ShortHashSet result = stack.collectShort(PrimitiveFunctions.unboxIntegerToShort(), target);
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3), result);
        Assert.assertSame("Target sent as parameter not returned", target, result);
    }

    @Override
    @Test
    public void collectIf() {
        StackIterable<Integer> stack = this.newStackFromTopToBottom(1, 2, 3, 4, 5);
        CountingPredicate<Integer> predicate1 = CountingPredicate.of(Predicates.lessThan(3));
        CountingFunction<Object, String> function1 = CountingFunction.of(String::valueOf);
        Assert.assertEquals(this.newStackFromTopToBottom("1", "2"), stack.collectIf(predicate1, function1));
        Assert.assertEquals(5, predicate1.count);
        Assert.assertEquals(2, function1.count);
        CountingPredicate<Integer> predicate2 = CountingPredicate.of(Predicates.lessThan(3));
        CountingFunction<Object, String> function2 = CountingFunction.of(String::valueOf);
        Assert.assertEquals(Lists.mutable.with("1", "2"), stack.collectIf(predicate2, function2, FastList.newList()));
        Assert.assertEquals(5, predicate2.count);
        Assert.assertEquals(2, function2.count);
    }

    @Override
    @Test
    public void collectWith() {
        StackIterable<Integer> stack = this.newStackFromTopToBottom(3, 2, 1);
        Assert.assertEquals(ArrayStack.newStackFromTopToBottom(4, 3, 2), stack.collectWith(AddFunction.INTEGER, 1));
    }

    @Test
    public void collectWithTarget() {
        StackIterable<Integer> stack = this.newStackFromTopToBottom(3, 2, 1);
        Assert.assertEquals(Lists.mutable.with(4, 3, 2), stack.collectWith(AddFunction.INTEGER, 1, FastList.newList()));
    }

    @Override
    @Test
    public void flatCollect() {
        StackIterable<String> stack = this.newStackFromTopToBottom("1", "One", "2", "Two");
        CountingFunction<String, Iterable<Character>> function = CountingFunction.of(object -> {
            MutableList<Character> result = Lists.mutable.of();
            char[] chars = object.toCharArray();
            for (char aChar : chars) {
                result.add(Character.valueOf(aChar));
            }
            return result;
        });
        Assert.assertEquals(this.newStackFromTopToBottom('1', 'O', 'n', 'e', '2', 'T', 'w', 'o'), stack.flatCollect(function));
        Assert.assertEquals(4, function.count);
        Assert.assertEquals(Lists.mutable.with('1', 'O', 'n', 'e', '2', 'T', 'w', 'o'), stack.flatCollect(function, FastList.newList()));
    }

    @Override
    @Test
    public void select() {
        StackIterable<Integer> stack = this.newStackFromTopToBottom(1, 2, 3);
        CountingPredicate<Object> predicate = new CountingPredicate<>(Integer.valueOf(1)::equals);
        StackIterable<Integer> actual = stack.select(predicate);
        Assert.assertEquals(this.newStackFromTopToBottom(1), actual);
        Assert.assertEquals(3, predicate.count);
        Assert.assertEquals(this.newStackFromTopToBottom(2, 3), stack.select(Predicates.greaterThan(1)));
        Assert.assertEquals(Lists.mutable.with(2, 3), stack.select(Predicates.greaterThan(1), FastList.newList()));
    }

    @Override
    @Test
    public void selectInstancesOf() {
        StackIterable<Number> numbers = this.newStackFromTopToBottom(1, 2.0, 3, 4.0, 5);
        Assert.assertEquals(this.newStackFromTopToBottom(1, 3, 5), numbers.selectInstancesOf(Integer.class));
        Assert.assertEquals(this.<Number>newStackFromTopToBottom(1, 2.0, 3, 4.0, 5), numbers.selectInstancesOf(Number.class));
    }

    @Override
    @Test
    public void selectWith() {
        Assert.assertEquals(ArrayStack.newStackFromTopToBottom(2, 1), this.newStackFromTopToBottom(5, 4, 3, 2, 1).selectWith(Predicates2.lessThan(), 3));
    }

    @Test
    public void selectWithTarget() {
        Assert.assertEquals(UnifiedSet.newSetWith(2, 1), this.newStackFromTopToBottom(5, 4, 3, 2, 1).selectWith(Predicates2.lessThan(), 3, UnifiedSet.newSet()));
    }

    @Override
    @Test
    public void reject() {
        StackIterable<Integer> stack = this.newStackFromTopToBottom(3, 2, 1);
        CountingPredicate<Integer> predicate = new CountingPredicate<>(Predicates.greaterThan(2));
        Assert.assertEquals(this.newStackFromTopToBottom(2, 1), stack.reject(predicate));
        Assert.assertEquals(3, predicate.count);
        Assert.assertEquals(Lists.mutable.with(2, 1), stack.reject(Predicates.greaterThan(2), FastList.newList()));
    }

    @Override
    @Test
    public void rejectWith() {
        StackIterable<Integer> stack = this.newStackFromTopToBottom(3, 2, 1);
        Assert.assertEquals(this.newStackFromTopToBottom(2, 1), stack.rejectWith(Predicates2.greaterThan(), 2));
    }

    @Test
    public void rejectWithTarget() {
        Assert.assertEquals(UnifiedSet.newSetWith(5, 4, 3), this.newStackFromTopToBottom(5, 4, 3, 2, 1).rejectWith(Predicates2.lessThan(), 3, UnifiedSet.newSet()));
    }

    @Override
    @Test
    public void detect() {
        StackIterable<Integer> stack = this.newStackFromTopToBottom(1, 2, 3);
        CountingPredicate<Integer> predicate = new CountingPredicate<>(Predicates.lessThan(3));
        Assert.assertEquals(Integer.valueOf(1), stack.detect(predicate));
        Assert.assertEquals(1, predicate.count);
        Assert.assertNull(stack.detect(Integer.valueOf(4)::equals));
    }

    @Override
    @Test
    public void detectWith() {
        StackIterable<Integer> stack = this.newStackFromTopToBottom(1, 2, 3);
        CountingPredicate2<Integer, Integer> predicate = new CountingPredicate2<>(Predicates2.<Integer>lessThan());
        Assert.assertEquals(Integer.valueOf(1), stack.detectWith(predicate, 3));
        Assert.assertEquals(1, predicate.count);
        Assert.assertNull(stack.detectWith(Object::equals, Integer.valueOf(4)));
    }

    @Override
    @Test
    public void detectIfNone() {
        Function0<Integer> defaultResultFunction = new PassThruFunction0<>(-1);
        CountingPredicate<Integer> predicate = new CountingPredicate<>(Predicates.lessThan(3));
        Assert.assertEquals(Integer.valueOf(1), this.newStackFromTopToBottom(1, 2, 3, 4, 5).detectIfNone(predicate, defaultResultFunction));
        Assert.assertEquals(1, predicate.count);
        Assert.assertEquals(Integer.valueOf(-1), this.newStackWith(1, 2, 3, 4, 5).detectIfNone(Predicates.lessThan(-1), defaultResultFunction));
    }

    @Test
    public void detectWithIfNone() {
        Function0<Integer> defaultResultFunction = new PassThruFunction0<>(-1);
        CountingPredicate2<Integer, Integer> predicate = new CountingPredicate2<>(Predicates2.<Integer>lessThan());
        Assert.assertEquals(Integer.valueOf(1), this.newStackFromTopToBottom(1, 2, 3, 4, 5).detectWithIfNone(predicate, Integer.valueOf(3), defaultResultFunction));
        Assert.assertEquals(1, predicate.count);
        Assert.assertEquals(Integer.valueOf(-1), this.newStackWith(1, 2, 3, 4, 5).detectIfNone(Predicates.lessThan(-1), defaultResultFunction));
    }

    @Override
    @Test
    public void partition() {
        CountingPredicate<Integer> predicate = new CountingPredicate<>(Predicates.lessThan(3));
        PartitionStack<Integer> partition = this.newStackFromTopToBottom(1, 2, 3, 4, 5).partition(predicate);
        Assert.assertEquals(5, predicate.count);
        Assert.assertEquals(this.newStackFromTopToBottom(1, 2), partition.getSelected());
        Assert.assertEquals(this.newStackFromTopToBottom(3, 4, 5), partition.getRejected());
    }

    @Override
    @Test
    public void partitionWith() {
        PartitionStack<Integer> partition = this.newStackFromTopToBottom(1, 2, 3, 4, 5).partitionWith(Predicates2.lessThan(), 3);
        Assert.assertEquals(this.newStackFromTopToBottom(1, 2), partition.getSelected());
        Assert.assertEquals(this.newStackFromTopToBottom(3, 4, 5), partition.getRejected());
    }

    @Override
    @Test
    public void zip() {
        StackIterable<String> stack = this.newStackFromTopToBottom("7", "6", "5", "4", "3", "2", "1");
        List<Integer> interval = Interval.oneTo(7);
        StackIterable<Pair<String, Integer>> expected = this.newStackFromTopToBottom(Tuples.pair("7", 1), Tuples.pair("6", 2), Tuples.pair("5", 3), Tuples.pair("4", 4), Tuples.pair("3", 5), Tuples.pair("2", 6), Tuples.pair("1", 7));
        Assert.assertEquals(expected, stack.zip(interval));
        Assert.assertEquals(expected.toSet(), stack.zip(interval, UnifiedSet.newSet()));
    }

    @Override
    @Test
    public void zipWithIndex() {
        StackIterable<String> stack = this.newStackFromTopToBottom("4", "3", "2", "1");
        StackIterable<Pair<String, Integer>> expected = this.newStackFromTopToBottom(Tuples.pair("4", 0), Tuples.pair("3", 1), Tuples.pair("2", 2), Tuples.pair("1", 3));
        Assert.assertEquals(expected, stack.zipWithIndex());
        Assert.assertEquals(expected.toSet(), stack.zipWithIndex(UnifiedSet.newSet()));
    }

    @Override
    @Test
    public void count() {
        StackIterable<Integer> stack = this.newStackFromTopToBottom(1, 2, 3, 4, 5);
        CountingPredicate<Integer> predicate = new CountingPredicate<>(Predicates.greaterThan(2));
        Assert.assertEquals(3, stack.count(predicate));
        Assert.assertEquals(5, predicate.count);
        Assert.assertEquals(0, stack.count(Predicates.greaterThan(6)));
    }

    @Override
    @Test
    public void countWith() {
        StackIterable<Integer> stack = this.newStackFromTopToBottom(1, 2, 3, 4, 5);
        CountingPredicate2<Object, Object> predicate = new CountingPredicate2<>(Object::equals);
        Assert.assertEquals(1, stack.countWith(predicate, 1));
        Assert.assertEquals(5, predicate.count);
        Assert.assertNotEquals(2, stack.countWith(predicate, 4));
    }

    @Override
    @Test
    public void anySatisfy() {
        StackIterable<Integer> stack = this.newStackFromTopToBottom(1, 2, 3);
        CountingPredicate<Object> predicate = new CountingPredicate<>(Integer.valueOf(1)::equals);
        Assert.assertTrue(stack.anySatisfy(predicate));
        Assert.assertEquals(1, predicate.count);
        Assert.assertFalse(stack.anySatisfy(Integer.valueOf(4)::equals));
    }

    @Override
    @Test
    public void allSatisfy() {
        StackIterable<Integer> stack = this.newStackWith(3, 3, 3);
        CountingPredicate<Object> predicate = new CountingPredicate<>(Integer.valueOf(3)::equals);
        Assert.assertTrue(stack.allSatisfy(predicate));
        Assert.assertEquals(3, predicate.count);
        Assert.assertFalse(stack.allSatisfy(Integer.valueOf(2)::equals));
    }

    @Override
    @Test
    public void noneSatisfy() {
        StackIterable<Integer> stack = this.newStackWith(3, 3, 3);
        CountingPredicate<Object> predicate = new CountingPredicate<>(Integer.valueOf(4)::equals);
        Assert.assertTrue(stack.noneSatisfy(predicate));
        Assert.assertEquals(3, predicate.count);
        Assert.assertTrue(stack.noneSatisfy(Integer.valueOf(2)::equals));
    }

    @Override
    @Test
    public void anySatisfyWith() {
        StackIterable<Integer> stack = this.newStackFromTopToBottom(1, 2, 3);
        CountingPredicate2<Object, Object> predicate = new CountingPredicate2<>(Object::equals);
        Assert.assertTrue(stack.anySatisfyWith(predicate, 1));
        Assert.assertEquals(1, predicate.count);
        Assert.assertFalse(stack.anySatisfyWith(Object::equals, 4));
    }

    @Override
    @Test
    public void allSatisfyWith() {
        StackIterable<Integer> stack = this.newStackWith(3, 3, 3);
        CountingPredicate2<Object, Object> predicate = new CountingPredicate2<>(Object::equals);
        Assert.assertTrue(stack.allSatisfyWith(predicate, 3));
        Assert.assertEquals(3, predicate.count);
        Assert.assertFalse(stack.allSatisfyWith(Object::equals, 2));
    }

    @Override
    @Test
    public void noneSatisfyWith() {
        StackIterable<Integer> stack = this.newStackWith(3, 3, 3);
        CountingPredicate2<Object, Object> predicate = new CountingPredicate2<>(Object::equals);
        Assert.assertTrue(stack.noneSatisfyWith(predicate, 4));
        Assert.assertEquals(3, predicate.count);
        Assert.assertTrue(stack.noneSatisfyWith(Object::equals, 2));
    }

    @Override
    @Test
    public void injectInto() {
        Assert.assertEquals(Integer.valueOf(10), this.newStackWith(1, 2, 3, 4).injectInto(Integer.valueOf(0), AddFunction.INTEGER));
        Assert.assertEquals(10, this.newStackWith(1, 2, 3, 4).injectInto(0, AddFunction.INTEGER_TO_INT));
        Assert.assertEquals(7.0, this.newStackWith(1.0, 2.0, 3.0).injectInto(1.0d, AddFunction.DOUBLE_TO_DOUBLE), 0.001);
        Assert.assertEquals(7, this.newStackWith(1, 2, 3).injectInto(1L, AddFunction.INTEGER_TO_LONG));
        Assert.assertEquals(7.0, this.newStackWith(1, 2, 3).injectInto(1.0f, AddFunction.INTEGER_TO_FLOAT), 0.001);
    }

    @Test
    public void sumOf() {
        StackIterable<Integer> stack = this.newStackFromTopToBottom(1, 2, 3, 4);
        Assert.assertEquals(10, stack.sumOfInt(integer -> integer));
        Assert.assertEquals(10, stack.sumOfLong(Integer::longValue));
        Assert.assertEquals(10.0d, stack.sumOfDouble(Integer::doubleValue), 0.001);
        Assert.assertEquals(10.0f, stack.sumOfFloat(Integer::floatValue), 0.001);
    }

    @Test
    public void sumOfFloatConsistentRounding() {
        MutableList<Integer> list = Interval.oneTo(100_000).toList().shuffleThis();
        StackIterable<Integer> stack = this.newStackWith(list.toArray(new Integer[] {}));
        // The test only ensures the consistency/stability of rounding. This is not meant to test the "correctness" of the float calculation result.
        // Indeed, the lower bits of this calculation result are always incorrect due to the information loss of original float values.
        Assert.assertEquals(1.082323233761663, stack.sumOfFloat(i -> 1.0f / (i.floatValue() * i.floatValue() * i.floatValue() * i.floatValue())), 1.0e-15);
    }

    @Test
    public void sumOfDoubleConsistentRounding() {
        MutableList<Integer> list = Interval.oneTo(100_000).toList().shuffleThis();
        StackIterable<Integer> stack = this.newStackWith(list.toArray(new Integer[] {}));
        Assert.assertEquals(1.082323233711138, stack.sumOfDouble(i -> 1.0d / (i.doubleValue() * i.doubleValue() * i.doubleValue() * i.doubleValue())), 1.0e-15);
    }

    @Override
    @Test
    public void sumByFloatConsistentRounding() {
        MutableList<Integer> group1 = Interval.oneTo(100_000).toList().shuffleThis();
        MutableList<Integer> group2 = Interval.fromTo(100_001, 200_000).toList().shuffleThis();
        MutableList<Integer> integers = Lists.mutable.withAll(group1);
        integers.addAll(group2);
        StackIterable<Integer> values = this.newStackWith(integers.toArray(new Integer[] {}));
        ObjectDoubleMap<Integer> result = values.sumByFloat(integer -> integer > 100_000 ? 2 : 1, integer -> {
            Integer i = integer > 100_000 ? integer - 100_000 : integer;
            return 1.0f / (i.floatValue() * i.floatValue() * i.floatValue() * i.floatValue());
        });
        // The test only ensures the consistency/stability of rounding. This is not meant to test the "correctness" of the float calculation result.
        // Indeed, the lower bits of this calculation result are always incorrect due to the information loss of original float values.
        Assert.assertEquals(1.082323233761663, result.get(1), 1.0e-15);
        Assert.assertEquals(1.082323233761663, result.get(2), 1.0e-15);
    }

    @Override
    @Test
    public void sumByDoubleConsistentRounding() {
        MutableList<Integer> group1 = Interval.oneTo(100_000).toList().shuffleThis();
        MutableList<Integer> group2 = Interval.fromTo(100_001, 200_000).toList().shuffleThis();
        MutableList<Integer> integers = Lists.mutable.withAll(group1);
        integers.addAll(group2);
        StackIterable<Integer> values = this.newStackWith(integers.toArray(new Integer[] {}));
        ObjectDoubleMap<Integer> result = values.sumByDouble(integer -> integer > 100_000 ? 2 : 1, integer -> {
            Integer i = integer > 100_000 ? integer - 100_000 : integer;
            return 1.0d / (i.doubleValue() * i.doubleValue() * i.doubleValue() * i.doubleValue());
        });
        Assert.assertEquals(1.082323233711138, result.get(1), 1.0e-15);
        Assert.assertEquals(1.082323233711138, result.get(2), 1.0e-15);
    }

    @Override
    @Test
    public void max() {
        Assert.assertEquals(Integer.valueOf(4), this.newStackFromTopToBottom(4, 3, 2, 1).max());
        Assert.assertEquals(Integer.valueOf(1), this.newStackFromTopToBottom(4, 3, 2, 1).max(Comparators.reverseNaturalOrder()));
    }

    @Override
    @Test
    public void maxBy() {
        Assert.assertEquals(Integer.valueOf(3), this.newStackWith(1, 2, 3).maxBy(String::valueOf));
    }

    @Override
    @Test
    public void min() {
        Assert.assertEquals(Integer.valueOf(1), this.newStackWith(1, 2, 3, 4).min());
        Assert.assertEquals(Integer.valueOf(4), this.newStackWith(1, 2, 3, 4).min(Comparators.reverseNaturalOrder()));
    }

    @Override
    @Test
    public void minBy() {
        CountingFunction<Object, String> function = CountingFunction.of(String::valueOf);
        Assert.assertEquals(Integer.valueOf(1), this.newStackWith(1, 2, 3).minBy(function));
        Assert.assertEquals(3, function.count);
    }

    @Override
    @Test
    public void testToString() {
        StackIterable<Integer> stack = this.newStackFromTopToBottom(4, 3, 2, 1);
        Assert.assertEquals("[4, 3, 2, 1]", stack.toString());
    }

    @Override
    @Test
    public void makeString() {
        Assert.assertEquals("3, 2, 1", this.newStackFromTopToBottom(3, 2, 1).makeString());
        Assert.assertEquals("3~2~1", this.newStackFromTopToBottom(3, 2, 1).makeString("~"));
        Assert.assertEquals("[3/2/1]", this.newStackFromTopToBottom(3, 2, 1).makeString("[", "/", "]"));
    }

    @Override
    @Test
    public void appendString() {
        StackIterable<String> stack = this.newStackFromTopToBottom("3", "2", "1");
        Appendable appendable = new StringBuilder();
        stack.appendString(appendable);
        Assert.assertEquals("3, 2, 1", appendable.toString());
        Appendable appendable2 = new StringBuilder();
        stack.appendString(appendable2, "/");
        Assert.assertEquals("3/2/1", appendable2.toString());
        Appendable appendable3 = new StringBuilder();
        stack.appendString(appendable3, "[", "/", "]");
        Assert.assertEquals("[3/2/1]", appendable3.toString());
    }

    @Override
    @Test
    public void groupBy() {
        StackIterable<String> stack = this.newStackWith("1", "2", "3");
        ListMultimap<Boolean, String> expected = FastListMultimap.newMultimap(Tuples.pair(Boolean.TRUE, "3"), Tuples.pair(Boolean.FALSE, "2"), Tuples.pair(Boolean.TRUE, "1"));
        Assert.assertEquals(expected, stack.groupBy(object -> IntegerPredicates.isOdd().accept(Integer.parseInt(object))));
        Assert.assertEquals(expected, stack.groupBy(object -> IntegerPredicates.isOdd().accept(Integer.parseInt(object)), FastListMultimap.newMultimap()));
    }

    @Override
    @Test
    public void groupByEach() {
        StackIterable<Integer> stack = this.newStackFromTopToBottom(1, 2, 3);
        MutableMultimap<Integer, Integer> expected = FastListMultimap.newMultimap();
        stack.forEach(Procedures.cast(value -> expected.putAll(-value, Interval.fromTo(value, stack.size()))));
        Multimap<Integer, Integer> actual = stack.groupByEach(new NegativeIntervalFunction());
        Assert.assertEquals(expected, actual);
        Multimap<Integer, Integer> actualWithTarget = stack.groupByEach(new NegativeIntervalFunction(), FastListMultimap.newMultimap());
        Assert.assertEquals(expected, actualWithTarget);
    }

    @Override
    @Test
    public void groupByUniqueKey() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, 1, 2, 2, 3, 3), this.newStackWith(1, 2, 3).groupByUniqueKey(id -> id));
    }

    @Test(expected = IllegalStateException.class)
    public void groupByUniqueKey_throws() {
        this.newStackWith(1, 2, 3).groupByUniqueKey(Functions.getFixedValue(1));
    }

    @Override
    @Test
    public void groupByUniqueKey_target() {
        MutableMap<Integer, Integer> integers = this.newStackWith(1, 2, 3).groupByUniqueKey(id -> id, UnifiedMap.newWithKeysValues(0, 0));
        Assert.assertEquals(UnifiedMap.newWithKeysValues(0, 0, 1, 1, 2, 2, 3, 3), integers);
    }

    @Test(expected = IllegalStateException.class)
    public void groupByUniqueKey_target_throws() {
        this.newStackWith(1, 2, 3).groupByUniqueKey(id -> id, UnifiedMap.newWithKeysValues(2, 2));
    }

    @Override
    @Test
    public void chunk() {
        Verify.assertIterablesEqual(FastList.<RichIterable<String>>newListWith(Lists.mutable.with("7", "6"), Lists.mutable.with("5", "4"), Lists.mutable.with("3", "2"), Lists.mutable.with("1")), this.newStackFromTopToBottom("7", "6", "5", "4", "3", "2", "1").chunk(2));
    }

    @Override
    @Test
    public void chunk_single() {
        RichIterable<String> collection = this.newWith("1");
        RichIterable<RichIterable<String>> groups = collection.chunk(2);
        Verify.assertIterablesEqual(Lists.mutable.with(1), groups.collect(RichIterable::size));
    }

    @Override
    @Test
    public void chunk_large_size() {
        RichIterable<String> collection = this.newWith("1", "2", "3", "4", "5", "6", "7");
        Verify.assertIterablesEqual(collection, collection.chunk(10).getOnly());
    }

    @Override
    @Test
    public void tap() {
        MutableList<String> tapResult = Lists.mutable.of();
        StackIterable<String> stack = this.newStackWith("1", "2", "3", "4", "5");
        Assert.assertSame(stack, stack.tap(tapResult::add));
        Assert.assertEquals(stack.toList(), tapResult);
    }

    @Override
    @Test
    public void forEach() {
        StackIterable<String> stack = this.newStackWith("1", "2", "3", "4", "5");
        Appendable builder = new StringBuilder();
        Procedure<String> appendProcedure = Procedures.append(builder);
        stack.forEach(appendProcedure);
        Assert.assertEquals("54321", builder.toString());
    }

    @Override
    @Test
    public void forEachWith() {
        StackIterable<String> stack = this.newStackWith("1", "2", "3", "4");
        StringBuilder builder = new StringBuilder();
        stack.forEachWith((argument1, argument2) -> builder.append(argument1).append(argument2), 0);
        Assert.assertEquals("40302010", builder.toString());
    }

    @Override
    @Test
    public void forEachWithIndex() {
        StackIterable<String> stack = this.newStackFromTopToBottom("5", "4", "3", "2", "1");
        StringBuilder builder = new StringBuilder();
        stack.forEachWithIndex((each, index) -> builder.append(each).append(index));
        Assert.assertEquals("5041322314", builder.toString());
    }

    @Override
    @Test
    public void toList() {
        Assert.assertEquals(Lists.mutable.with(4, 3, 2, 1), this.newStackFromTopToBottom(4, 3, 2, 1).toList());
    }

    @Test
    public void toStack() {
        Assert.assertEquals(this.newStackFromTopToBottom(3, 2, 1), this.newStackFromTopToBottom(3, 2, 1).toStack());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(Interval.oneTo(4), this.newStackFromTopToBottom(4, 3, 1, 2).toSortedList());
        Assert.assertEquals(Interval.fromTo(4, 1), this.newStackFromTopToBottom(4, 3, 1, 2).toSortedList(Collections.reverseOrder()));
    }

    @Override
    @Test
    public void toSortedListBy() {
        MutableList<Integer> list = FastList.newList(Interval.oneTo(10)).shuffleThis();
        Assert.assertEquals(Interval.oneTo(10), this.newStack(list).toSortedListBy(Functions.getIntegerPassThru()));
    }

    @Override
    @Test
    public void toSet() {
        Assert.assertEquals(UnifiedSet.newSetWith(4, 3, 2, 1), this.newStackWith(1, 2, 3, 4).toSet());
    }

    @Test
    public void toSortedSet() {
        MutableSortedSet<Integer> expected = TreeSortedSet.newSetWith(1, 2, 4, 5);
        StackIterable<Integer> stack = this.newStackWith(2, 1, 5, 4);
        Assert.assertEquals(expected, stack.toSortedSet());
        Assert.assertEquals(Lists.mutable.with(1, 2, 4, 5), stack.toSortedSet().toList());
        MutableSortedSet<Integer> reversed = stack.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(reversed, stack.toSortedSet(Comparators.reverseNaturalOrder()));
        Assert.assertEquals(Lists.mutable.with(5, 4, 2, 1), stack.toSortedSet(Comparators.reverseNaturalOrder()).toList());
    }

    @Override
    @Test
    public void toSortedSetBy() {
        SetIterable<Integer> expected = UnifiedSet.newSetWith(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
        StackIterable<Integer> stack = this.newStackWith(5, 2, 4, 3, 1, 6, 7, 8, 9, 10);
        Assert.assertEquals(expected, stack.toSortedSetBy(String::valueOf));
        Assert.assertEquals(Lists.mutable.with(1, 10, 2, 3, 4, 5, 6, 7, 8, 9), stack.toSortedSetBy(String::valueOf).toList());
    }

    @Override
    @Test
    public void toBag() {
        Assert.assertEquals(Bags.mutable.of("C", "B", "A"), this.newStackFromTopToBottom("C", "B", "A").toBag());
    }

    @Test
    public void toSortedBag() {
        SortedBag<Integer> expected = TreeBag.newBagWith(1, 2, 2, 4, 5);
        StackIterable<Integer> stack = this.newStackWith(2, 2, 1, 5, 4);
        Verify.assertSortedBagsEqual(expected, stack.toSortedBag());
        Assert.assertEquals(Lists.mutable.with(1, 2, 2, 4, 5), stack.toSortedBag().toList());
        SortedBag<Integer> expected2 = TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 1, 2, 2, 4, 5);
        Verify.assertSortedBagsEqual(expected2, stack.toSortedBag(Comparators.reverseNaturalOrder()));
        Assert.assertEquals(Lists.mutable.with(5, 4, 2, 2, 1), stack.toSortedBag(Comparators.reverseNaturalOrder()).toList());
    }

    @Override
    @Test
    public void toSortedBagBy() {
        SortedBag<Integer> expected = TreeBag.newBagWith(1, 2, 3, 3, 4, 5);
        StackIterable<Integer> stack = this.newStackWith(1, 2, 3, 3, 4, 5);
        Verify.assertSortedBagsEqual(expected, stack.toSortedBagBy(String::valueOf));
    }

    @Override
    @Test
    public void toMap() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues("4", "4", "3", "3", "2", "2", "1", "1"), this.newStackFromTopToBottom(4, 3, 2, 1).toMap(String::valueOf, String::valueOf));
    }

    @Override
    @Test
    public void toSortedMap() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues(3, "3", 2, "2", 1, "1"), this.newStackFromTopToBottom(3, 2, 1).toSortedMap(Functions.getIntegerPassThru(), String::valueOf));
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), 3, "3", 2, "2", 1, "1"), this.newStackFromTopToBottom(3, 2, 1).toSortedMap(Comparators.reverseNaturalOrder(), Functions.getIntegerPassThru(), String::valueOf));
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), 3, "3", 2, "2", 1, "1"), this.newStackFromTopToBottom(3, 2, 1).toSortedMapBy(key -> -key, Functions.getIntegerPassThru(), String::valueOf));
    }

    @Test
    public void asLazy() {
        Assert.assertEquals(Lists.mutable.with("3", "2", "1"), this.newStackFromTopToBottom("3", "2", "1").asLazy().toList());
    }

    @Override
    @Test
    public void toArray() {
        Assert.assertArrayEquals(new Object[] { 4, 3, 2, 1 }, this.newStackFromTopToBottom(4, 3, 2, 1).toArray());
        Assert.assertArrayEquals(new Integer[] { 4, 3, 2, 1 }, this.newStackFromTopToBottom(4, 3, 2, 1).toArray(new Integer[0]));
    }

    @Override
    @Test
    public void iterator() {
        StringBuilder builder = new StringBuilder();
        StackIterable<String> stack = this.newStackFromTopToBottom("5", "4", "3", "2", "1");
        for (String string : stack) {
            builder.append(string);
        }
        Assert.assertEquals("54321", builder.toString());
    }

    @Test
    public void testEquals() {
        StackIterable<Integer> stack1 = this.newStackFromTopToBottom(1, 2, 3, 4);
        StackIterable<Integer> stack2 = this.newStackFromTopToBottom(1, 2, 3, 4);
        StackIterable<Integer> stack3 = this.newStackFromTopToBottom(5, 2, 1, 4);
        StackIterable<Integer> stack4 = this.newStackFromTopToBottom(1, 2, 3);
        StackIterable<Integer> stack5 = this.newStackFromTopToBottom(1, 2, 3, 4, 5);
        StackIterable<Integer> stack6 = this.newStackFromTopToBottom(1, 2, 3, null);
        Verify.assertEqualsAndHashCode(stack1, stack2);
        Verify.assertPostSerializedEqualsAndHashCode(this.newStackWith(1, 2, 3, 4));
        Assert.assertNotEquals(stack1, stack3);
        Assert.assertNotEquals(stack1, stack4);
        Assert.assertNotEquals(stack1, stack5);
        Assert.assertNotEquals(stack1, stack6);
        Verify.assertPostSerializedEqualsAndHashCode(this.newStackWith(null, null, null));
        Assert.assertEquals(Stacks.mutable.of(), this.newStackWith());
    }

    @Test
    public void testHashCode() {
        StackIterable<Integer> stack1 = this.newStackWith(1, 2, 3, 5);
        StackIterable<Integer> stack2 = this.newStackWith(1, 2, 3, 4);
        Assert.assertNotEquals(stack1.hashCode(), stack2.hashCode());
        Assert.assertEquals(31 * 31 * 31 * 31 + 1 * 31 * 31 * 31 + 2 * 31 * 31 + 3 * 31 + 4, this.newStackFromTopToBottom(1, 2, 3, 4).hashCode());
        Assert.assertEquals(31 * 31 * 31, this.newStackFromTopToBottom(null, null, null).hashCode());
        Assert.assertNotEquals(this.newStackFromTopToBottom(1, 2, 3, 4).hashCode(), this.newStackFromTopToBottom(4, 3, 2, 1).hashCode());
    }

    @Override
    @Test
    public void aggregateByMutating() {
        Function0<AtomicInteger> valueCreator = AtomicInteger::new;
        StackIterable<Integer> collection = this.newStackWith(1, 1, 1, 2, 2, 3);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, AtomicInteger::addAndGet);
        Assert.assertEquals(3, aggregation.get("1").intValue());
        Assert.assertEquals(4, aggregation.get("2").intValue());
        Assert.assertEquals(3, aggregation.get("3").intValue());
    }

    @Override
    @Test
    public void aggregateByNonMutating() {
        Function0<Integer> valueCreator = () -> 0;
        Function2<Integer, Integer, Integer> sumAggregator = (integer1, integer2) -> integer1 + integer2;
        StackIterable<Integer> collection = this.newStackWith(1, 1, 1, 2, 2, 3);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("1").intValue());
        Assert.assertEquals(4, aggregation.get("2").intValue());
        Assert.assertEquals(3, aggregation.get("3").intValue());
    }

    private static final class CountingPredicate<T> implements Predicate<T> {

        private static final long serialVersionUID = 1L;

        private final Predicate<T> predicate;

        private int count;

        private CountingPredicate(Predicate<T> predicate) {
            this.predicate = predicate;
        }

        private static <T> CountingPredicate<T> of(Predicate<T> predicate) {
            return new CountingPredicate<>(predicate);
        }

        @Override
        public boolean accept(T anObject) {
            this.count++;
            return this.predicate.accept(anObject);
        }
    }

    private static final class CountingPredicate2<T1, T2> implements Predicate2<T1, T2> {

        private static final long serialVersionUID = 1L;

        private final Predicate2<T1, T2> predicate;

        private int count;

        private CountingPredicate2(Predicate2<T1, T2> predicate) {
            this.predicate = predicate;
        }

        private static <T1, T2> CountingPredicate2<T1, T2> of(Predicate2<T1, T2> predicate) {
            return new CountingPredicate2<>(predicate);
        }

        @Override
        public boolean accept(T1 each, T2 parameter) {
            this.count++;
            return this.predicate.accept(each, parameter);
        }
    }

    private static final class CountingFunction<T, V> implements Function<T, V> {

        private static final long serialVersionUID = 1L;

        private int count;

        private final Function<T, V> function;

        private CountingFunction(Function<T, V> function) {
            this.function = function;
        }

        private static <T, V> CountingFunction<T, V> of(Function<T, V> function) {
            return new CountingFunction<>(function);
        }

        @Override
        public V valueOf(T object) {
            this.count++;
            return this.function.valueOf(object);
        }
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private StackIterableTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
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
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
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
        public void benchmark_min_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws);
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
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith_target);
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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
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
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDouble);
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
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumInteger);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumLong);
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
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
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
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapTarget);
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
        public void benchmark_groupByUniqueKey_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws_for_duplicate);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_for_duplicate);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
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
        public void benchmark_reduceOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewStackFromTopToBottom() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewStackFromTopToBottom);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_int_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_int_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_int_count_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_int_count_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_int_neg_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_int_neg_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_illegal_arguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_illegal_arguments);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peekAt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peekAt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peekAt_illegal_arguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peekAt_illegal_arguments);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArguments);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
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
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
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
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
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
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
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
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
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
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
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
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloatConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfFloatConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDoubleConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfDoubleConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloatConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloatConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDoubleConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDoubleConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
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
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
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
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_single() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_single);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
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
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStack);
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
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
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
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> payload) throws java.lang.Throwable {
            this.instance = new StackIterableTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> testNewStackFromTopToBottom;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> peek_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> peek_int_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> peek_int_count_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> peek_int_neg_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> peek_illegal_arguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> peek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> peekAt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> peekAt_illegal_arguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> sumOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StackIterableTestCase> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = StackIterableTestCase::testNewCollection;
            this.payloads.equalsAndHashCode = StackIterableTestCase::equalsAndHashCode;
            this.payloads.contains = StackIterableTestCase::contains;
            this.payloads.containsBy = StackIterableTestCase::containsBy;
            this.payloads.containsAllIterable = StackIterableTestCase::containsAllIterable;
            this.payloads.containsAnyIterable = StackIterableTestCase::containsAnyIterable;
            this.payloads.containsNoneIterable = StackIterableTestCase::containsNoneIterable;
            this.payloads.containsAllArray = StackIterableTestCase::containsAllArray;
            this.payloads.containsAnyCollection = StackIterableTestCase::containsAnyCollection;
            this.payloads.containsNoneCollection = StackIterableTestCase::containsNoneCollection;
            this.payloads.containsAllCollection = StackIterableTestCase::containsAllCollection;
            this.payloads.selectWith_target = StackIterableTestCase::selectWith_target;
            this.payloads.rejectWith_target = StackIterableTestCase::rejectWith_target;
            this.payloads.collectTarget = StackIterableTestCase::collectTarget;
            this.payloads.collectBooleanWithBagTarget = StackIterableTestCase::collectBooleanWithBagTarget;
            this.payloads.collectByteWithBagTarget = StackIterableTestCase::collectByteWithBagTarget;
            this.payloads.collectCharWithBagTarget = StackIterableTestCase::collectCharWithBagTarget;
            this.payloads.collectDoubleWithBagTarget = StackIterableTestCase::collectDoubleWithBagTarget;
            this.payloads.collectFloatWithBagTarget = StackIterableTestCase::collectFloatWithBagTarget;
            this.payloads.collectIntWithBagTarget = StackIterableTestCase::collectIntWithBagTarget;
            this.payloads.collectLongWithBagTarget = StackIterableTestCase::collectLongWithBagTarget;
            this.payloads.collectShortWithBagTarget = StackIterableTestCase::collectShortWithBagTarget;
            this.payloads.flatCollectWith = StackIterableTestCase::flatCollectWith;
            this.payloads.flatCollectBoolean = StackIterableTestCase::flatCollectBoolean;
            this.payloads.flatCollectByte = StackIterableTestCase::flatCollectByte;
            this.payloads.flatCollectShort = StackIterableTestCase::flatCollectShort;
            this.payloads.flatCollectInt = StackIterableTestCase::flatCollectInt;
            this.payloads.flatCollectChar = StackIterableTestCase::flatCollectChar;
            this.payloads.flatCollectLong = StackIterableTestCase::flatCollectLong;
            this.payloads.flatCollectDouble = StackIterableTestCase::flatCollectDouble;
            this.payloads.flatCollectFloat = StackIterableTestCase::flatCollectFloat;
            this.payloads.detectOptional = StackIterableTestCase::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(StackIterableTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(StackIterableTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(StackIterableTestCase::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(StackIterableTestCase::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minOptional = StackIterableTestCase::minOptional;
            this.payloads.maxOptional = StackIterableTestCase::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(StackIterableTestCase::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(StackIterableTestCase::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = StackIterableTestCase::min_without_comparator;
            this.payloads.max_without_comparator = StackIterableTestCase::max_without_comparator;
            this.payloads.min_null_safe = StackIterableTestCase::min_null_safe;
            this.payloads.max_null_safe = StackIterableTestCase::max_null_safe;
            this.payloads.minByOptional = StackIterableTestCase::minByOptional;
            this.payloads.maxByOptional = StackIterableTestCase::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(StackIterableTestCase::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(StackIterableTestCase::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWithOptional = StackIterableTestCase::detectWithOptional;
            this.payloads.detectWithIfNoneBlock = StackIterableTestCase::detectWithIfNoneBlock;
            this.payloads.collectWith_target = StackIterableTestCase::collectWith_target;
            this.payloads.getAny = StackIterableTestCase::getAny;
            this.payloads.getOnly = StackIterableTestCase::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(StackIterableTestCase::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(StackIterableTestCase::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = StackIterableTestCase::isEmpty;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(StackIterableTestCase::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectIntoInt = StackIterableTestCase::injectIntoInt;
            this.payloads.injectIntoLong = StackIterableTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = StackIterableTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = StackIterableTestCase::injectIntoFloat;
            this.payloads.sumFloat = StackIterableTestCase::sumFloat;
            this.payloads.summarizeFloat = StackIterableTestCase::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = StackIterableTestCase::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = StackIterableTestCase::sumFloatConsistentRounding2;
            this.payloads.sumDouble = StackIterableTestCase::sumDouble;
            this.payloads.summarizeDouble = StackIterableTestCase::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = StackIterableTestCase::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = StackIterableTestCase::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = StackIterableTestCase::sumInteger;
            this.payloads.summarizeInt = StackIterableTestCase::summarizeInt;
            this.payloads.sumLong = StackIterableTestCase::sumLong;
            this.payloads.summarizeLong = StackIterableTestCase::summarizeLong;
            this.payloads.sumByInt = StackIterableTestCase::sumByInt;
            this.payloads.sumByFloat = StackIterableTestCase::sumByFloat;
            this.payloads.sumByLong = StackIterableTestCase::sumByLong;
            this.payloads.sumByDouble = StackIterableTestCase::sumByDouble;
            this.payloads.toImmutableList = StackIterableTestCase::toImmutableList;
            this.payloads.toCollection = StackIterableTestCase::toCollection;
            this.payloads.toImmutableBag = StackIterableTestCase::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = StackIterableTestCase::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = StackIterableTestCase::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = StackIterableTestCase::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = StackIterableTestCase::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(StackIterableTestCase::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = StackIterableTestCase::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = StackIterableTestCase::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = StackIterableTestCase::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = StackIterableTestCase::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(StackIterableTestCase::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBagBy = StackIterableTestCase::toImmutableSortedBagBy;
            this.payloads.toImmutableSortedListBy = StackIterableTestCase::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = StackIterableTestCase::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = StackIterableTestCase::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = StackIterableTestCase::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = StackIterableTestCase::toImmutableSortedSet_with_comparator;
            this.payloads.toImmutableSortedSetBy = StackIterableTestCase::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(StackIterableTestCase::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSet = StackIterableTestCase::toImmutableSet;
            this.payloads.toImmutableMap = StackIterableTestCase::toImmutableMap;
            this.payloads.toMapTarget = StackIterableTestCase::toMapTarget;
            this.payloads.toSortedMap_with_comparator = StackIterableTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = StackIterableTestCase::toSortedMapBy;
            this.payloads.toBiMap = StackIterableTestCase::toBiMap;
            this.payloads.toImmutableBiMap = StackIterableTestCase::toImmutableBiMap;
            this.payloads.makeStringWithSeparator = StackIterableTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = StackIterableTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = StackIterableTestCase::fusedCollectMakeString;
            this.payloads.appendStringWithSeparator = StackIterableTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = StackIterableTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = StackIterableTestCase::appendStringThrows;
            this.payloads.countBy = StackIterableTestCase::countBy;
            this.payloads.countByWith = StackIterableTestCase::countByWith;
            this.payloads.countByEach = StackIterableTestCase::countByEach;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(StackIterableTestCase::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(StackIterableTestCase::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.chunk_empty = StackIterableTestCase::chunk_empty;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(StackIterableTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.empty = StackIterableTestCase::empty;
            this.payloads.notEmpty = StackIterableTestCase::notEmpty;
            this.payloads.reduceOptional = StackIterableTestCase::reduceOptional;
            this.payloads.testNewStackFromTopToBottom = StackIterableTestCase::testNewStackFromTopToBottom;
            this.payloads.peek_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(StackIterableTestCase::peek_empty_throws, java.util.EmptyStackException.class);
            this.payloads.peek_int_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(StackIterableTestCase::peek_int_empty_throws, java.util.EmptyStackException.class);
            this.payloads.peek_int_count_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(StackIterableTestCase::peek_int_count_throws, java.lang.IllegalArgumentException.class);
            this.payloads.peek_int_neg_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(StackIterableTestCase::peek_int_neg_throws, java.lang.IllegalArgumentException.class);
            this.payloads.peek_illegal_arguments = StackIterableTestCase::peek_illegal_arguments;
            this.payloads.peek = StackIterableTestCase::peek;
            this.payloads.peekAt = StackIterableTestCase::peekAt;
            this.payloads.peekAt_illegal_arguments = StackIterableTestCase::peekAt_illegal_arguments;
            this.payloads.size = StackIterableTestCase::size;
            this.payloads.getFirst = StackIterableTestCase::getFirst;
            this.payloads.getLast = new se.chalmers.ju2jmh.api.ExceptionTest<>(StackIterableTestCase::getLast, java.lang.UnsupportedOperationException.class);
            this.payloads.containsAll = StackIterableTestCase::containsAll;
            this.payloads.containsAllArguments = StackIterableTestCase::containsAllArguments;
            this.payloads.collect = StackIterableTestCase::collect;
            this.payloads.collectWithIndex = StackIterableTestCase::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = StackIterableTestCase::collectWithIndexWithTarget;
            this.payloads.selectWithIndexWithTarget = StackIterableTestCase::selectWithIndexWithTarget;
            this.payloads.rejectWithIndexWithTarget = StackIterableTestCase::rejectWithIndexWithTarget;
            this.payloads.collectBoolean = StackIterableTestCase::collectBoolean;
            this.payloads.collectBooleanWithTarget = StackIterableTestCase::collectBooleanWithTarget;
            this.payloads.collectByte = StackIterableTestCase::collectByte;
            this.payloads.collectByteWithTarget = StackIterableTestCase::collectByteWithTarget;
            this.payloads.collectChar = StackIterableTestCase::collectChar;
            this.payloads.collectCharWithTarget = StackIterableTestCase::collectCharWithTarget;
            this.payloads.collectDouble = StackIterableTestCase::collectDouble;
            this.payloads.collectDoubleWithTarget = StackIterableTestCase::collectDoubleWithTarget;
            this.payloads.collectFloat = StackIterableTestCase::collectFloat;
            this.payloads.collectFloatWithTarget = StackIterableTestCase::collectFloatWithTarget;
            this.payloads.collectInt = StackIterableTestCase::collectInt;
            this.payloads.collectIntWithTarget = StackIterableTestCase::collectIntWithTarget;
            this.payloads.collectLong = StackIterableTestCase::collectLong;
            this.payloads.collectLongWithTarget = StackIterableTestCase::collectLongWithTarget;
            this.payloads.collectShort = StackIterableTestCase::collectShort;
            this.payloads.collectShortWithTarget = StackIterableTestCase::collectShortWithTarget;
            this.payloads.collectIf = StackIterableTestCase::collectIf;
            this.payloads.collectWith = StackIterableTestCase::collectWith;
            this.payloads.collectWithTarget = StackIterableTestCase::collectWithTarget;
            this.payloads.flatCollect = StackIterableTestCase::flatCollect;
            this.payloads.select = StackIterableTestCase::select;
            this.payloads.selectInstancesOf = StackIterableTestCase::selectInstancesOf;
            this.payloads.selectWith = StackIterableTestCase::selectWith;
            this.payloads.selectWithTarget = StackIterableTestCase::selectWithTarget;
            this.payloads.reject = StackIterableTestCase::reject;
            this.payloads.rejectWith = StackIterableTestCase::rejectWith;
            this.payloads.rejectWithTarget = StackIterableTestCase::rejectWithTarget;
            this.payloads.detect = StackIterableTestCase::detect;
            this.payloads.detectWith = StackIterableTestCase::detectWith;
            this.payloads.detectIfNone = StackIterableTestCase::detectIfNone;
            this.payloads.detectWithIfNone = StackIterableTestCase::detectWithIfNone;
            this.payloads.partition = StackIterableTestCase::partition;
            this.payloads.partitionWith = StackIterableTestCase::partitionWith;
            this.payloads.zip = StackIterableTestCase::zip;
            this.payloads.zipWithIndex = StackIterableTestCase::zipWithIndex;
            this.payloads.count = StackIterableTestCase::count;
            this.payloads.countWith = StackIterableTestCase::countWith;
            this.payloads.anySatisfy = StackIterableTestCase::anySatisfy;
            this.payloads.allSatisfy = StackIterableTestCase::allSatisfy;
            this.payloads.noneSatisfy = StackIterableTestCase::noneSatisfy;
            this.payloads.anySatisfyWith = StackIterableTestCase::anySatisfyWith;
            this.payloads.allSatisfyWith = StackIterableTestCase::allSatisfyWith;
            this.payloads.noneSatisfyWith = StackIterableTestCase::noneSatisfyWith;
            this.payloads.injectInto = StackIterableTestCase::injectInto;
            this.payloads.sumOf = StackIterableTestCase::sumOf;
            this.payloads.sumOfFloatConsistentRounding = StackIterableTestCase::sumOfFloatConsistentRounding;
            this.payloads.sumOfDoubleConsistentRounding = StackIterableTestCase::sumOfDoubleConsistentRounding;
            this.payloads.sumByFloatConsistentRounding = StackIterableTestCase::sumByFloatConsistentRounding;
            this.payloads.sumByDoubleConsistentRounding = StackIterableTestCase::sumByDoubleConsistentRounding;
            this.payloads.max = StackIterableTestCase::max;
            this.payloads.maxBy = StackIterableTestCase::maxBy;
            this.payloads.min = StackIterableTestCase::min;
            this.payloads.minBy = StackIterableTestCase::minBy;
            this.payloads.testToString = StackIterableTestCase::testToString;
            this.payloads.makeString = StackIterableTestCase::makeString;
            this.payloads.appendString = StackIterableTestCase::appendString;
            this.payloads.groupBy = StackIterableTestCase::groupBy;
            this.payloads.groupByEach = StackIterableTestCase::groupByEach;
            this.payloads.groupByUniqueKey = StackIterableTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(StackIterableTestCase::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = StackIterableTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(StackIterableTestCase::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.chunk = StackIterableTestCase::chunk;
            this.payloads.chunk_single = StackIterableTestCase::chunk_single;
            this.payloads.chunk_large_size = StackIterableTestCase::chunk_large_size;
            this.payloads.tap = StackIterableTestCase::tap;
            this.payloads.forEach = StackIterableTestCase::forEach;
            this.payloads.forEachWith = StackIterableTestCase::forEachWith;
            this.payloads.forEachWithIndex = StackIterableTestCase::forEachWithIndex;
            this.payloads.toList = StackIterableTestCase::toList;
            this.payloads.toStack = StackIterableTestCase::toStack;
            this.payloads.toSortedList = StackIterableTestCase::toSortedList;
            this.payloads.toSortedListBy = StackIterableTestCase::toSortedListBy;
            this.payloads.toSet = StackIterableTestCase::toSet;
            this.payloads.toSortedSet = StackIterableTestCase::toSortedSet;
            this.payloads.toSortedSetBy = StackIterableTestCase::toSortedSetBy;
            this.payloads.toBag = StackIterableTestCase::toBag;
            this.payloads.toSortedBag = StackIterableTestCase::toSortedBag;
            this.payloads.toSortedBagBy = StackIterableTestCase::toSortedBagBy;
            this.payloads.toMap = StackIterableTestCase::toMap;
            this.payloads.toSortedMap = StackIterableTestCase::toSortedMap;
            this.payloads.asLazy = StackIterableTestCase::asLazy;
            this.payloads.toArray = StackIterableTestCase::toArray;
            this.payloads.iterator = StackIterableTestCase::iterator;
            this.payloads.testEquals = StackIterableTestCase::testEquals;
            this.payloads.testHashCode = StackIterableTestCase::testHashCode;
            this.payloads.aggregateByMutating = StackIterableTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = StackIterableTestCase::aggregateByNonMutating;
        }
    }
*/
}
