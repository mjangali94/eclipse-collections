/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.stack.immutable;

import java.util.EmptyStackException;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ListIterable;
import org.eclipse.collections.api.stack.ImmutableStack;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.factory.Stacks;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableArrayStackTest extends ImmutableStackTestCase {

    @Override
    protected <T> ImmutableStack<T> newStackWith(T... elements) {
        return Stacks.immutable.of(elements);
    }

    @Override
    protected <T> ImmutableStack<T> newStackFromTopToBottom(T... elements) {
        return Stacks.immutable.ofReversed(elements);
    }

    @Override
    protected <T> ImmutableStack<T> newStackFromTopToBottom(Iterable<T> elements) {
        return Stacks.immutable.ofAllReversed(elements);
    }

    @Override
    protected <T> ImmutableStack<T> newStack(Iterable<T> elements) {
        return Stacks.immutable.ofAll(elements);
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        Assert.assertEquals(ImmutableArrayStack.newStack(), ArrayStack.newStackWith());
        Assert.assertNotEquals(this.newStackWith(4, 5, 6), ArrayStack.newStackWith(1, 2, 3));
    }

    @Test
    public void push() {
        ImmutableStack<Integer> stack = this.newStackWith(1, 2, 3);
        ImmutableStack<Integer> modifiedStack = stack.push(4);
        Assert.assertEquals(this.newStackWith(1, 2, 3, 4), modifiedStack);
        Assert.assertNotSame(modifiedStack, stack);
        Assert.assertEquals(this.newStackWith(1, 2, 3), stack);
        modifiedStack.push(5);
        Assert.assertEquals(this.newStackWith(1, 2, 3), stack);
        ImmutableStack<Integer> stack1 = this.newStackWith();
        ImmutableStack<Integer> modifiedStack1 = stack1.push(1);
        Assert.assertEquals(this.newStackWith(1), modifiedStack1);
        Assert.assertNotSame(modifiedStack1, stack1);
        Assert.assertEquals(this.newStackWith(), stack1);
        modifiedStack1.push(5);
        Assert.assertEquals(this.newStackWith(), stack1);
    }

    @Test
    public void pop() {
        Assert.assertThrows(EmptyStackException.class, () -> this.newStackWith().pop());
        ImmutableStack<Integer> stack = this.newStackWith(1, 2, 3);
        ImmutableStack<Integer> modifiedStack = stack.pop();
        Assert.assertEquals(this.newStackWith(1, 2), modifiedStack);
        Assert.assertNotSame(modifiedStack, stack);
        Assert.assertEquals(this.newStackWith(1, 2, 3), stack);
        ImmutableStack<Integer> stack1 = this.newStackWith(1);
        ImmutableStack<Integer> modifiedStack1 = stack1.pop();
        Assert.assertEquals(this.newStackWith(), modifiedStack1);
        Assert.assertNotSame(modifiedStack1, stack1);
        Assert.assertEquals(this.newStackWith(1), stack1);
    }

    @Test
    public void popCount() {
        Assert.assertThrows(EmptyStackException.class, () -> this.newStackWith().pop(1));
        Assert.assertEquals(this.newStackWith(), this.newStackWith().pop(0));
        ImmutableStack<Integer> stack = this.newStackWith(1, 2, 3);
        ImmutableStack<Integer> modifiedStack = stack.pop(1);
        Assert.assertEquals(this.newStackWith(1, 2), modifiedStack);
        Assert.assertNotSame(modifiedStack, stack);
        Assert.assertNotSame(this.newStackWith(1, 2, 3), stack);
        ImmutableStack<Integer> stack1 = this.newStackWith(1);
        Assert.assertThrows(IllegalArgumentException.class, () -> stack1.pop(2));
        ImmutableStack<Integer> modifiedStack1 = stack1.pop(1);
        Assert.assertEquals(this.newStackWith(), modifiedStack1);
        Assert.assertNotSame(modifiedStack1, stack1);
        Assert.assertEquals(this.newStackWith(1), stack1);
    }

    @Test
    public void peekAndPop() {
        Assert.assertThrows(EmptyStackException.class, () -> this.newStackWith().pop());
        ImmutableStack<Integer> stack = this.newStackWith(1, 2, 3);
        Pair<Integer, ImmutableStack<Integer>> elementAndStack = stack.peekAndPop();
        Integer poppedElement = elementAndStack.getOne();
        ImmutableStack<Integer> modifiedStack = elementAndStack.getTwo();
        Assert.assertEquals(3, poppedElement.intValue());
        Assert.assertEquals(this.newStackWith(1, 2), modifiedStack);
        Assert.assertNotSame(modifiedStack, stack);
        Assert.assertEquals(this.newStackWith(1, 2, 3), stack);
        ImmutableStack<Integer> stack1 = this.newStackWith(1);
        Pair<Integer, ImmutableStack<Integer>> elementAndStack1 = stack1.peekAndPop();
        Integer poppedElement1 = elementAndStack1.getOne();
        ImmutableStack<Integer> modifiedStack1 = elementAndStack1.getTwo();
        Assert.assertEquals(1, poppedElement1.intValue());
        Assert.assertEquals(this.newStackWith(), modifiedStack1);
        Assert.assertNotSame(modifiedStack1, stack1);
        Assert.assertEquals(this.newStackWith(1), stack1);
    }

    @Test
    public void peekAndPopCount() {
        Assert.assertThrows(EmptyStackException.class, () -> this.newStackWith().peekAndPop(1));
        Assert.assertEquals(this.newStackWith(), this.newStackWith().peekAndPop(0).getTwo());
        ImmutableStack<Integer> stack = this.newStackWith(1, 2, 3);
        Pair<ListIterable<Integer>, ImmutableStack<Integer>> elementsAndStack = stack.peekAndPop(1);
        ListIterable<Integer> poppedElements = elementsAndStack.getOne();
        ImmutableStack<Integer> modifiedStack = elementsAndStack.getTwo();
        Assert.assertEquals(Lists.fixedSize.of(3), poppedElements);
        Assert.assertEquals(this.newStackWith(1, 2), modifiedStack);
        Assert.assertNotSame(modifiedStack, stack);
        Assert.assertNotSame(this.newStackWith(1, 2, 3), stack);
        ImmutableStack<Integer> stack1 = this.newStackWith(1);
        Assert.assertThrows(IllegalArgumentException.class, () -> stack1.pop(2));
        Pair<ListIterable<Integer>, ImmutableStack<Integer>> elementsAndStack1 = stack1.peekAndPop(1);
        ListIterable<Integer> poppedElements1 = elementsAndStack1.getOne();
        ImmutableStack<Integer> modifiedStack1 = elementsAndStack1.getTwo();
        Assert.assertEquals(Lists.fixedSize.of(1), poppedElements1);
        Assert.assertEquals(this.newStackWith(), modifiedStack1);
        Assert.assertNotSame(modifiedStack1, stack1);
        Assert.assertEquals(this.newStackWith(1), stack1);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableArrayStackTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
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
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
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
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
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
        public void benchmark_min_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws);
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
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws_without_comparator);
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
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNoneBlock() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNoneBlock);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAny() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAny);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
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
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDouble);
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
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumInteger);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumLong);
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
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
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
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapTarget);
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
        public void benchmark_groupByUniqueKey_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws_for_duplicate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_for_duplicate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
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
        public void benchmark_reduceOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewStackFromTopToBottom() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewStackFromTopToBottom);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_int_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_int_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_int_count_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_int_count_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_int_neg_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_int_neg_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_illegal_arguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_illegal_arguments);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peekAt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peekAt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peekAt_illegal_arguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peekAt_illegal_arguments);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArguments);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
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
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
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
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
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
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
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
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
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
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
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
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloatConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfFloatConsistentRounding);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDoubleConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfDoubleConsistentRounding);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloatConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloatConsistentRounding);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDoubleConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDoubleConsistentRounding);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
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
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
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
        public void benchmark_groupByUniqueKey_target_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_single() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_single);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
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
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStack);
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
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
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
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
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
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_push() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.push);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_popCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.popCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peekAndPop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peekAndPop);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peekAndPopCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peekAndPopCount);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableArrayStackTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> testNewStackFromTopToBottom;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> peek_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> peek_int_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> peek_int_count_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> peek_int_neg_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> peek_illegal_arguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> peek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> peekAt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> peekAt_illegal_arguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> sumOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> push;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> pop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> popCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> peekAndPop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayStackTest> peekAndPopCount;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = ImmutableArrayStackTest::testNewCollection;
            this.payloads.equalsAndHashCode = ImmutableArrayStackTest::equalsAndHashCode;
            this.payloads.contains = ImmutableArrayStackTest::contains;
            this.payloads.containsBy = ImmutableArrayStackTest::containsBy;
            this.payloads.containsAllIterable = ImmutableArrayStackTest::containsAllIterable;
            this.payloads.containsAnyIterable = ImmutableArrayStackTest::containsAnyIterable;
            this.payloads.containsNoneIterable = ImmutableArrayStackTest::containsNoneIterable;
            this.payloads.containsAllArray = ImmutableArrayStackTest::containsAllArray;
            this.payloads.containsAnyCollection = ImmutableArrayStackTest::containsAnyCollection;
            this.payloads.containsNoneCollection = ImmutableArrayStackTest::containsNoneCollection;
            this.payloads.containsAllCollection = ImmutableArrayStackTest::containsAllCollection;
            this.payloads.selectWith_target = ImmutableArrayStackTest::selectWith_target;
            this.payloads.rejectWith_target = ImmutableArrayStackTest::rejectWith_target;
            this.payloads.collectTarget = ImmutableArrayStackTest::collectTarget;
            this.payloads.collectBooleanWithBagTarget = ImmutableArrayStackTest::collectBooleanWithBagTarget;
            this.payloads.collectByteWithBagTarget = ImmutableArrayStackTest::collectByteWithBagTarget;
            this.payloads.collectCharWithBagTarget = ImmutableArrayStackTest::collectCharWithBagTarget;
            this.payloads.collectDoubleWithBagTarget = ImmutableArrayStackTest::collectDoubleWithBagTarget;
            this.payloads.collectFloatWithBagTarget = ImmutableArrayStackTest::collectFloatWithBagTarget;
            this.payloads.collectIntWithBagTarget = ImmutableArrayStackTest::collectIntWithBagTarget;
            this.payloads.collectLongWithBagTarget = ImmutableArrayStackTest::collectLongWithBagTarget;
            this.payloads.collectShortWithBagTarget = ImmutableArrayStackTest::collectShortWithBagTarget;
            this.payloads.flatCollectWith = ImmutableArrayStackTest::flatCollectWith;
            this.payloads.flatCollectBoolean = ImmutableArrayStackTest::flatCollectBoolean;
            this.payloads.flatCollectByte = ImmutableArrayStackTest::flatCollectByte;
            this.payloads.flatCollectShort = ImmutableArrayStackTest::flatCollectShort;
            this.payloads.flatCollectInt = ImmutableArrayStackTest::flatCollectInt;
            this.payloads.flatCollectChar = ImmutableArrayStackTest::flatCollectChar;
            this.payloads.flatCollectLong = ImmutableArrayStackTest::flatCollectLong;
            this.payloads.flatCollectDouble = ImmutableArrayStackTest::flatCollectDouble;
            this.payloads.flatCollectFloat = ImmutableArrayStackTest::flatCollectFloat;
            this.payloads.detectOptional = ImmutableArrayStackTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayStackTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayStackTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayStackTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayStackTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minOptional = ImmutableArrayStackTest::minOptional;
            this.payloads.maxOptional = ImmutableArrayStackTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayStackTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayStackTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = ImmutableArrayStackTest::min_without_comparator;
            this.payloads.max_without_comparator = ImmutableArrayStackTest::max_without_comparator;
            this.payloads.min_null_safe = ImmutableArrayStackTest::min_null_safe;
            this.payloads.max_null_safe = ImmutableArrayStackTest::max_null_safe;
            this.payloads.minByOptional = ImmutableArrayStackTest::minByOptional;
            this.payloads.maxByOptional = ImmutableArrayStackTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayStackTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayStackTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWithOptional = ImmutableArrayStackTest::detectWithOptional;
            this.payloads.detectWithIfNoneBlock = ImmutableArrayStackTest::detectWithIfNoneBlock;
            this.payloads.collectWith_target = ImmutableArrayStackTest::collectWith_target;
            this.payloads.getAny = ImmutableArrayStackTest::getAny;
            this.payloads.getOnly = ImmutableArrayStackTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayStackTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayStackTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = ImmutableArrayStackTest::isEmpty;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayStackTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectIntoInt = ImmutableArrayStackTest::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableArrayStackTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableArrayStackTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ImmutableArrayStackTest::injectIntoFloat;
            this.payloads.sumFloat = ImmutableArrayStackTest::sumFloat;
            this.payloads.summarizeFloat = ImmutableArrayStackTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = ImmutableArrayStackTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = ImmutableArrayStackTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = ImmutableArrayStackTest::sumDouble;
            this.payloads.summarizeDouble = ImmutableArrayStackTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = ImmutableArrayStackTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = ImmutableArrayStackTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = ImmutableArrayStackTest::sumInteger;
            this.payloads.summarizeInt = ImmutableArrayStackTest::summarizeInt;
            this.payloads.sumLong = ImmutableArrayStackTest::sumLong;
            this.payloads.summarizeLong = ImmutableArrayStackTest::summarizeLong;
            this.payloads.sumByInt = ImmutableArrayStackTest::sumByInt;
            this.payloads.sumByFloat = ImmutableArrayStackTest::sumByFloat;
            this.payloads.sumByLong = ImmutableArrayStackTest::sumByLong;
            this.payloads.sumByDouble = ImmutableArrayStackTest::sumByDouble;
            this.payloads.toImmutableList = ImmutableArrayStackTest::toImmutableList;
            this.payloads.toCollection = ImmutableArrayStackTest::toCollection;
            this.payloads.toImmutableBag = ImmutableArrayStackTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = ImmutableArrayStackTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = ImmutableArrayStackTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = ImmutableArrayStackTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = ImmutableArrayStackTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayStackTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = ImmutableArrayStackTest::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = ImmutableArrayStackTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = ImmutableArrayStackTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = ImmutableArrayStackTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayStackTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBagBy = ImmutableArrayStackTest::toImmutableSortedBagBy;
            this.payloads.toImmutableSortedListBy = ImmutableArrayStackTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = ImmutableArrayStackTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = ImmutableArrayStackTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = ImmutableArrayStackTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = ImmutableArrayStackTest::toImmutableSortedSet_with_comparator;
            this.payloads.toImmutableSortedSetBy = ImmutableArrayStackTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayStackTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSet = ImmutableArrayStackTest::toImmutableSet;
            this.payloads.toImmutableMap = ImmutableArrayStackTest::toImmutableMap;
            this.payloads.toMapTarget = ImmutableArrayStackTest::toMapTarget;
            this.payloads.toSortedMap_with_comparator = ImmutableArrayStackTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = ImmutableArrayStackTest::toSortedMapBy;
            this.payloads.toBiMap = ImmutableArrayStackTest::toBiMap;
            this.payloads.toImmutableBiMap = ImmutableArrayStackTest::toImmutableBiMap;
            this.payloads.makeStringWithSeparator = ImmutableArrayStackTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = ImmutableArrayStackTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = ImmutableArrayStackTest::fusedCollectMakeString;
            this.payloads.appendStringWithSeparator = ImmutableArrayStackTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = ImmutableArrayStackTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = ImmutableArrayStackTest::appendStringThrows;
            this.payloads.countBy = ImmutableArrayStackTest::countBy;
            this.payloads.countByWith = ImmutableArrayStackTest::countByWith;
            this.payloads.countByEach = ImmutableArrayStackTest::countByEach;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayStackTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayStackTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.chunk_empty = ImmutableArrayStackTest::chunk_empty;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayStackTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.empty = ImmutableArrayStackTest::empty;
            this.payloads.notEmpty = ImmutableArrayStackTest::notEmpty;
            this.payloads.reduceOptional = ImmutableArrayStackTest::reduceOptional;
            this.payloads.testNewStackFromTopToBottom = ImmutableArrayStackTest::testNewStackFromTopToBottom;
            this.payloads.peek_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayStackTest::peek_empty_throws, java.util.EmptyStackException.class);
            this.payloads.peek_int_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayStackTest::peek_int_empty_throws, java.util.EmptyStackException.class);
            this.payloads.peek_int_count_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayStackTest::peek_int_count_throws, java.lang.IllegalArgumentException.class);
            this.payloads.peek_int_neg_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayStackTest::peek_int_neg_throws, java.lang.IllegalArgumentException.class);
            this.payloads.peek_illegal_arguments = ImmutableArrayStackTest::peek_illegal_arguments;
            this.payloads.peek = ImmutableArrayStackTest::peek;
            this.payloads.peekAt = ImmutableArrayStackTest::peekAt;
            this.payloads.peekAt_illegal_arguments = ImmutableArrayStackTest::peekAt_illegal_arguments;
            this.payloads.size = ImmutableArrayStackTest::size;
            this.payloads.getFirst = ImmutableArrayStackTest::getFirst;
            this.payloads.getLast = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayStackTest::getLast, java.lang.UnsupportedOperationException.class);
            this.payloads.containsAll = ImmutableArrayStackTest::containsAll;
            this.payloads.containsAllArguments = ImmutableArrayStackTest::containsAllArguments;
            this.payloads.collect = ImmutableArrayStackTest::collect;
            this.payloads.collectWithIndex = ImmutableArrayStackTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ImmutableArrayStackTest::collectWithIndexWithTarget;
            this.payloads.selectWithIndexWithTarget = ImmutableArrayStackTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndexWithTarget = ImmutableArrayStackTest::rejectWithIndexWithTarget;
            this.payloads.collectBoolean = ImmutableArrayStackTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = ImmutableArrayStackTest::collectBooleanWithTarget;
            this.payloads.collectByte = ImmutableArrayStackTest::collectByte;
            this.payloads.collectByteWithTarget = ImmutableArrayStackTest::collectByteWithTarget;
            this.payloads.collectChar = ImmutableArrayStackTest::collectChar;
            this.payloads.collectCharWithTarget = ImmutableArrayStackTest::collectCharWithTarget;
            this.payloads.collectDouble = ImmutableArrayStackTest::collectDouble;
            this.payloads.collectDoubleWithTarget = ImmutableArrayStackTest::collectDoubleWithTarget;
            this.payloads.collectFloat = ImmutableArrayStackTest::collectFloat;
            this.payloads.collectFloatWithTarget = ImmutableArrayStackTest::collectFloatWithTarget;
            this.payloads.collectInt = ImmutableArrayStackTest::collectInt;
            this.payloads.collectIntWithTarget = ImmutableArrayStackTest::collectIntWithTarget;
            this.payloads.collectLong = ImmutableArrayStackTest::collectLong;
            this.payloads.collectLongWithTarget = ImmutableArrayStackTest::collectLongWithTarget;
            this.payloads.collectShort = ImmutableArrayStackTest::collectShort;
            this.payloads.collectShortWithTarget = ImmutableArrayStackTest::collectShortWithTarget;
            this.payloads.collectIf = ImmutableArrayStackTest::collectIf;
            this.payloads.collectWith = ImmutableArrayStackTest::collectWith;
            this.payloads.collectWithTarget = ImmutableArrayStackTest::collectWithTarget;
            this.payloads.flatCollect = ImmutableArrayStackTest::flatCollect;
            this.payloads.select = ImmutableArrayStackTest::select;
            this.payloads.selectInstancesOf = ImmutableArrayStackTest::selectInstancesOf;
            this.payloads.selectWith = ImmutableArrayStackTest::selectWith;
            this.payloads.selectWithTarget = ImmutableArrayStackTest::selectWithTarget;
            this.payloads.reject = ImmutableArrayStackTest::reject;
            this.payloads.rejectWith = ImmutableArrayStackTest::rejectWith;
            this.payloads.rejectWithTarget = ImmutableArrayStackTest::rejectWithTarget;
            this.payloads.detect = ImmutableArrayStackTest::detect;
            this.payloads.detectWith = ImmutableArrayStackTest::detectWith;
            this.payloads.detectIfNone = ImmutableArrayStackTest::detectIfNone;
            this.payloads.detectWithIfNone = ImmutableArrayStackTest::detectWithIfNone;
            this.payloads.partition = ImmutableArrayStackTest::partition;
            this.payloads.partitionWith = ImmutableArrayStackTest::partitionWith;
            this.payloads.zip = ImmutableArrayStackTest::zip;
            this.payloads.zipWithIndex = ImmutableArrayStackTest::zipWithIndex;
            this.payloads.count = ImmutableArrayStackTest::count;
            this.payloads.countWith = ImmutableArrayStackTest::countWith;
            this.payloads.anySatisfy = ImmutableArrayStackTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableArrayStackTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableArrayStackTest::noneSatisfy;
            this.payloads.anySatisfyWith = ImmutableArrayStackTest::anySatisfyWith;
            this.payloads.allSatisfyWith = ImmutableArrayStackTest::allSatisfyWith;
            this.payloads.noneSatisfyWith = ImmutableArrayStackTest::noneSatisfyWith;
            this.payloads.injectInto = ImmutableArrayStackTest::injectInto;
            this.payloads.sumOf = ImmutableArrayStackTest::sumOf;
            this.payloads.sumOfFloatConsistentRounding = ImmutableArrayStackTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDoubleConsistentRounding = ImmutableArrayStackTest::sumOfDoubleConsistentRounding;
            this.payloads.sumByFloatConsistentRounding = ImmutableArrayStackTest::sumByFloatConsistentRounding;
            this.payloads.sumByDoubleConsistentRounding = ImmutableArrayStackTest::sumByDoubleConsistentRounding;
            this.payloads.max = ImmutableArrayStackTest::max;
            this.payloads.maxBy = ImmutableArrayStackTest::maxBy;
            this.payloads.min = ImmutableArrayStackTest::min;
            this.payloads.minBy = ImmutableArrayStackTest::minBy;
            this.payloads.testToString = ImmutableArrayStackTest::testToString;
            this.payloads.makeString = ImmutableArrayStackTest::makeString;
            this.payloads.appendString = ImmutableArrayStackTest::appendString;
            this.payloads.groupBy = ImmutableArrayStackTest::groupBy;
            this.payloads.groupByEach = ImmutableArrayStackTest::groupByEach;
            this.payloads.groupByUniqueKey = ImmutableArrayStackTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayStackTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ImmutableArrayStackTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayStackTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.chunk = ImmutableArrayStackTest::chunk;
            this.payloads.chunk_single = ImmutableArrayStackTest::chunk_single;
            this.payloads.chunk_large_size = ImmutableArrayStackTest::chunk_large_size;
            this.payloads.tap = ImmutableArrayStackTest::tap;
            this.payloads.forEach = ImmutableArrayStackTest::forEach;
            this.payloads.forEachWith = ImmutableArrayStackTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableArrayStackTest::forEachWithIndex;
            this.payloads.toList = ImmutableArrayStackTest::toList;
            this.payloads.toStack = ImmutableArrayStackTest::toStack;
            this.payloads.toSortedList = ImmutableArrayStackTest::toSortedList;
            this.payloads.toSortedListBy = ImmutableArrayStackTest::toSortedListBy;
            this.payloads.toSet = ImmutableArrayStackTest::toSet;
            this.payloads.toSortedSet = ImmutableArrayStackTest::toSortedSet;
            this.payloads.toSortedSetBy = ImmutableArrayStackTest::toSortedSetBy;
            this.payloads.toBag = ImmutableArrayStackTest::toBag;
            this.payloads.toSortedBag = ImmutableArrayStackTest::toSortedBag;
            this.payloads.toSortedBagBy = ImmutableArrayStackTest::toSortedBagBy;
            this.payloads.toMap = ImmutableArrayStackTest::toMap;
            this.payloads.toSortedMap = ImmutableArrayStackTest::toSortedMap;
            this.payloads.asLazy = ImmutableArrayStackTest::asLazy;
            this.payloads.toArray = ImmutableArrayStackTest::toArray;
            this.payloads.iterator = ImmutableArrayStackTest::iterator;
            this.payloads.testHashCode = ImmutableArrayStackTest::testHashCode;
            this.payloads.aggregateByMutating = ImmutableArrayStackTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableArrayStackTest::aggregateByNonMutating;
            this.payloads.testEquals = ImmutableArrayStackTest::testEquals;
            this.payloads.push = ImmutableArrayStackTest::push;
            this.payloads.pop = ImmutableArrayStackTest::pop;
            this.payloads.popCount = ImmutableArrayStackTest::popCount;
            this.payloads.peekAndPop = ImmutableArrayStackTest::peekAndPop;
            this.payloads.peekAndPopCount = ImmutableArrayStackTest::peekAndPopCount;
        }
    }
}
