/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.stack.mutable;

import java.util.EmptyStackException;
import org.eclipse.collections.api.map.primitive.MutableObjectDoubleMap;
import org.eclipse.collections.api.map.primitive.MutableObjectLongMap;
import org.eclipse.collections.api.stack.MutableStack;
import org.eclipse.collections.impl.factory.Stacks;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.stack.StackIterableTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public abstract class MutableStackTestCase extends StackIterableTestCase {

    @Override
    protected abstract <T> MutableStack<T> newStackWith(T... elements);

    @Override
    protected abstract <T> MutableStack<T> newStackFromTopToBottom(T... elements);

    @Override
    protected abstract <T> MutableStack<T> newStackFromTopToBottom(Iterable<T> elements);

    @Override
    protected abstract <T> MutableStack<T> newStack(Iterable<T> elements);

    @Test
    public void testPushPopAndPeek() {
        MutableStack<String> stack = this.newStackWith();
        stack.push("1");
        Assert.assertEquals("1", stack.peek());
        Assert.assertEquals(this.newStackWith("1"), stack);
        stack.push("2");
        Assert.assertEquals("2", stack.peek());
        Assert.assertEquals(this.newStackWith("1", "2"), stack);
        stack.push("3");
        Assert.assertEquals("3", stack.peek());
        Assert.assertEquals(this.newStackWith("1", "2", "3"), stack);
        Assert.assertEquals("2", stack.peekAt(1));
        Assert.assertEquals("3", stack.pop());
        Assert.assertEquals("2", stack.peek());
        Assert.assertEquals("2", stack.pop());
        Assert.assertEquals("1", stack.peek());
        Assert.assertEquals("1", stack.pop());
        MutableStack<Integer> stack2 = this.newStackFromTopToBottom(5, 4, 3, 2, 1);
        stack2.pop(2);
        Assert.assertEquals(this.newStackFromTopToBottom(3, 2, 1), stack2);
        Assert.assertEquals(FastList.newListWith(3, 2), stack2.peek(2));
        MutableStack<Integer> stack3 = Stacks.mutable.ofReversed(1, 2, 3);
        Assert.assertEquals(this.newStackFromTopToBottom(1, 2, 3), stack3);
        MutableStack<Integer> stack4 = Stacks.mutable.ofAll(FastList.newListWith(1, 2, 3));
        MutableStack<Integer> stack5 = Stacks.mutable.ofAllReversed(FastList.newListWith(1, 2, 3));
        Assert.assertEquals(this.newStackFromTopToBottom(3, 2, 1), stack4);
        Assert.assertEquals(this.newStackFromTopToBottom(1, 2, 3), stack5);
        MutableStack<Integer> stack6 = this.newStackFromTopToBottom(1, 2, 3, 4);
        Assert.assertEquals(FastList.newListWith(1, 2), stack6.pop(2, FastList.newList()));
        MutableStack<Integer> stack7 = this.newStackFromTopToBottom(1, 2, 3, 4);
        Assert.assertEquals(ArrayStack.newStackFromTopToBottom(2, 1), stack7.pop(2, ArrayStack.newStack()));
        MutableStack<Integer> stack8 = this.newStackFromTopToBottom(1, 2, 3, 4);
        Verify.assertIterableEmpty(stack8.pop(0));
        Assert.assertEquals(ArrayStack.newStackFromTopToBottom(1, 2, 3, 4), stack8);
        Assert.assertEquals(FastList.newList(), stack8.peek(0));
        MutableStack<Integer> stack9 = ArrayStack.newStack();
        Assert.assertEquals(FastList.newList(), stack9.pop(0));
        Assert.assertEquals(FastList.newList(), stack9.peek(0));
        Assert.assertEquals(FastList.newList(), stack9.pop(0, FastList.newList()));
        Assert.assertEquals(ArrayStack.newStack(), stack9.pop(0, ArrayStack.newStack()));
    }

    @Test
    public void clear() {
        MutableStack<Integer> stack = this.newStackFromTopToBottom(1, 2, 3);
        stack.clear();
        Assert.assertEquals(ArrayStack.newStack(), stack);
        Verify.assertIterableEmpty(stack);
    }

    @Test
    public void testNewStackWithOrder() {
        MutableStack<String> stack = this.newStackWith("1", "2", "3");
        Assert.assertEquals("3", stack.pop());
        Assert.assertEquals("2", stack.pop());
        Assert.assertEquals("1", stack.pop());
    }

    @Test
    public void testNewStackIterableOrder() {
        MutableStack<String> stack = this.newStack(FastList.newListWith("1", "2", "3"));
        Assert.assertEquals("3", stack.pop());
        Assert.assertEquals("2", stack.pop());
        Assert.assertEquals("1", stack.pop());
    }

    @Test
    public void testNewStackFromTopToBottomOrder() {
        MutableStack<String> stack = this.newStackFromTopToBottom("3", "2", "1");
        Assert.assertEquals("3", stack.pop());
        Assert.assertEquals("2", stack.pop());
        Assert.assertEquals("1", stack.pop());
    }

    @Test
    public void testNewStackFromTopToBottomIterableOrder() {
        MutableStack<String> stack = this.newStackFromTopToBottom(FastList.newListWith("3", "2", "1"));
        Assert.assertEquals("3", stack.pop());
        Assert.assertEquals("2", stack.pop());
        Assert.assertEquals("1", stack.pop());
    }

    @Test(expected = EmptyStackException.class)
    public void pop_empty_throws() {
        this.newStackWith().pop();
    }

    @Test(expected = EmptyStackException.class)
    public void pop_int_empty_throws() {
        this.newStackWith().pop(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void pop_int_count_throws() {
        this.newStackWith(1, 2, 3).pop(4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void pop_int_neg_throws() {
        this.newStackWith(1, 2, 3).pop(-1);
    }

    @Test(expected = EmptyStackException.class)
    public void pop_target_empty_throws() {
        this.newStackWith().pop(5, FastList.newList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void pop_target_count_throws() {
        this.newStackWith(1, 2, 3).pop(5, FastList.newList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void pop_target_neg_throws() {
        this.newStackWith(1, 2, 3).pop(-1, FastList.newList());
    }

    @Test(expected = EmptyStackException.class)
    public void pop_targetStack_empty_throws() {
        this.newStackWith().pop(5, ArrayStack.newStack());
    }

    @Test(expected = IllegalArgumentException.class)
    public void pop_targetStack_count_throws() {
        this.newStackWith(1, 2, 3).pop(5, ArrayStack.newStack());
    }

    @Test(expected = IllegalArgumentException.class)
    public void pop_targetStack_neg_throws() {
        this.newStackWith(1, 2, 3).pop(-1, ArrayStack.newStack());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableStack.class, this.newStackWith().asUnmodifiable());
    }

    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedStack.class, this.newStackWith().asSynchronized());
    }

    public void sumByInt() {
        MutableStack<Integer> values = this.newStackFromTopToBottom(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        MutableObjectLongMap<Integer> result = values.sumByInt(i -> i % 2, e -> e);
        Assert.assertEquals(25, result.get(1));
        Assert.assertEquals(30, result.get(0));
    }

    public void sumByFloat() {
        MutableStack<Integer> values = this.newStackFromTopToBottom(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        MutableObjectDoubleMap<Integer> result = values.sumByFloat(f -> f % 2, e -> e);
        Assert.assertEquals(25.0f, result.get(1), 0.0);
        Assert.assertEquals(30.0f, result.get(0), 0.0);
    }

    public void sumByLong() {
        MutableStack<Integer> values = this.newStackFromTopToBottom(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        MutableObjectLongMap<Integer> result = values.sumByLong(l -> l % 2, e -> e);
        Assert.assertEquals(25, result.get(1));
        Assert.assertEquals(30, result.get(0));
    }

    public void sumByDouble() {
        MutableStack<Integer> values = this.newStackFromTopToBottom(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        MutableObjectDoubleMap<Integer> result = values.sumByDouble(d -> d % 2, e -> e);
        Assert.assertEquals(25.0d, result.get(1), 0.0);
        Assert.assertEquals(30.0d, result.get(0), 0.0);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MutableStackTestCase instance;

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

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testPushPopAndPeek() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testPushPopAndPeek);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewStackWithOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewStackWithOrder);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewStackIterableOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewStackIterableOrder);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewStackFromTopToBottomOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewStackFromTopToBottomOrder);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewStackFromTopToBottomIterableOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewStackFromTopToBottomIterableOrder);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_int_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_int_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_int_count_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_int_count_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_int_neg_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_int_neg_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_target_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_target_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_target_count_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_target_count_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_target_neg_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_target_neg_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_targetStack_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_targetStack_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_targetStack_count_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_targetStack_count_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_targetStack_neg_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_targetStack_neg_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> payload) throws java.lang.Throwable {
            this.instance = new MutableStackTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> testNewStackFromTopToBottom;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> peek_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> peek_int_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> peek_int_count_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> peek_int_neg_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> peek_illegal_arguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> peek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> peekAt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> peekAt_illegal_arguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> sumOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> testPushPopAndPeek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> testNewStackWithOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> testNewStackIterableOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> testNewStackFromTopToBottomOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> testNewStackFromTopToBottomIterableOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> pop_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> pop_int_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> pop_int_count_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> pop_int_neg_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> pop_target_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> pop_target_count_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> pop_target_neg_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> pop_targetStack_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> pop_targetStack_count_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> pop_targetStack_neg_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableStackTestCase> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = MutableStackTestCase::testNewCollection;
            this.payloads.equalsAndHashCode = MutableStackTestCase::equalsAndHashCode;
            this.payloads.contains = MutableStackTestCase::contains;
            this.payloads.containsBy = MutableStackTestCase::containsBy;
            this.payloads.containsAllIterable = MutableStackTestCase::containsAllIterable;
            this.payloads.containsAnyIterable = MutableStackTestCase::containsAnyIterable;
            this.payloads.containsNoneIterable = MutableStackTestCase::containsNoneIterable;
            this.payloads.containsAllArray = MutableStackTestCase::containsAllArray;
            this.payloads.containsAnyCollection = MutableStackTestCase::containsAnyCollection;
            this.payloads.containsNoneCollection = MutableStackTestCase::containsNoneCollection;
            this.payloads.containsAllCollection = MutableStackTestCase::containsAllCollection;
            this.payloads.selectWith_target = MutableStackTestCase::selectWith_target;
            this.payloads.rejectWith_target = MutableStackTestCase::rejectWith_target;
            this.payloads.collectTarget = MutableStackTestCase::collectTarget;
            this.payloads.collectBooleanWithBagTarget = MutableStackTestCase::collectBooleanWithBagTarget;
            this.payloads.collectByteWithBagTarget = MutableStackTestCase::collectByteWithBagTarget;
            this.payloads.collectCharWithBagTarget = MutableStackTestCase::collectCharWithBagTarget;
            this.payloads.collectDoubleWithBagTarget = MutableStackTestCase::collectDoubleWithBagTarget;
            this.payloads.collectFloatWithBagTarget = MutableStackTestCase::collectFloatWithBagTarget;
            this.payloads.collectIntWithBagTarget = MutableStackTestCase::collectIntWithBagTarget;
            this.payloads.collectLongWithBagTarget = MutableStackTestCase::collectLongWithBagTarget;
            this.payloads.collectShortWithBagTarget = MutableStackTestCase::collectShortWithBagTarget;
            this.payloads.flatCollectWith = MutableStackTestCase::flatCollectWith;
            this.payloads.flatCollectBoolean = MutableStackTestCase::flatCollectBoolean;
            this.payloads.flatCollectByte = MutableStackTestCase::flatCollectByte;
            this.payloads.flatCollectShort = MutableStackTestCase::flatCollectShort;
            this.payloads.flatCollectInt = MutableStackTestCase::flatCollectInt;
            this.payloads.flatCollectChar = MutableStackTestCase::flatCollectChar;
            this.payloads.flatCollectLong = MutableStackTestCase::flatCollectLong;
            this.payloads.flatCollectDouble = MutableStackTestCase::flatCollectDouble;
            this.payloads.flatCollectFloat = MutableStackTestCase::flatCollectFloat;
            this.payloads.detectOptional = MutableStackTestCase::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minOptional = MutableStackTestCase::minOptional;
            this.payloads.maxOptional = MutableStackTestCase::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = MutableStackTestCase::min_without_comparator;
            this.payloads.max_without_comparator = MutableStackTestCase::max_without_comparator;
            this.payloads.min_null_safe = MutableStackTestCase::min_null_safe;
            this.payloads.max_null_safe = MutableStackTestCase::max_null_safe;
            this.payloads.minByOptional = MutableStackTestCase::minByOptional;
            this.payloads.maxByOptional = MutableStackTestCase::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWithOptional = MutableStackTestCase::detectWithOptional;
            this.payloads.detectWithIfNoneBlock = MutableStackTestCase::detectWithIfNoneBlock;
            this.payloads.collectWith_target = MutableStackTestCase::collectWith_target;
            this.payloads.getAny = MutableStackTestCase::getAny;
            this.payloads.getOnly = MutableStackTestCase::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = MutableStackTestCase::isEmpty;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectIntoInt = MutableStackTestCase::injectIntoInt;
            this.payloads.injectIntoLong = MutableStackTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = MutableStackTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = MutableStackTestCase::injectIntoFloat;
            this.payloads.sumFloat = MutableStackTestCase::sumFloat;
            this.payloads.summarizeFloat = MutableStackTestCase::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = MutableStackTestCase::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = MutableStackTestCase::sumFloatConsistentRounding2;
            this.payloads.sumDouble = MutableStackTestCase::sumDouble;
            this.payloads.summarizeDouble = MutableStackTestCase::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = MutableStackTestCase::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = MutableStackTestCase::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = MutableStackTestCase::sumInteger;
            this.payloads.summarizeInt = MutableStackTestCase::summarizeInt;
            this.payloads.sumLong = MutableStackTestCase::sumLong;
            this.payloads.summarizeLong = MutableStackTestCase::summarizeLong;
            this.payloads.sumByInt = MutableStackTestCase::sumByInt;
            this.payloads.sumByFloat = MutableStackTestCase::sumByFloat;
            this.payloads.sumByLong = MutableStackTestCase::sumByLong;
            this.payloads.sumByDouble = MutableStackTestCase::sumByDouble;
            this.payloads.toImmutableList = MutableStackTestCase::toImmutableList;
            this.payloads.toCollection = MutableStackTestCase::toCollection;
            this.payloads.toImmutableBag = MutableStackTestCase::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = MutableStackTestCase::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = MutableStackTestCase::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = MutableStackTestCase::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = MutableStackTestCase::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = MutableStackTestCase::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = MutableStackTestCase::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = MutableStackTestCase::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = MutableStackTestCase::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBagBy = MutableStackTestCase::toImmutableSortedBagBy;
            this.payloads.toImmutableSortedListBy = MutableStackTestCase::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = MutableStackTestCase::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = MutableStackTestCase::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = MutableStackTestCase::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = MutableStackTestCase::toImmutableSortedSet_with_comparator;
            this.payloads.toImmutableSortedSetBy = MutableStackTestCase::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSet = MutableStackTestCase::toImmutableSet;
            this.payloads.toImmutableMap = MutableStackTestCase::toImmutableMap;
            this.payloads.toMapTarget = MutableStackTestCase::toMapTarget;
            this.payloads.toSortedMap_with_comparator = MutableStackTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = MutableStackTestCase::toSortedMapBy;
            this.payloads.toBiMap = MutableStackTestCase::toBiMap;
            this.payloads.toImmutableBiMap = MutableStackTestCase::toImmutableBiMap;
            this.payloads.makeStringWithSeparator = MutableStackTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = MutableStackTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = MutableStackTestCase::fusedCollectMakeString;
            this.payloads.appendStringWithSeparator = MutableStackTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = MutableStackTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = MutableStackTestCase::appendStringThrows;
            this.payloads.countBy = MutableStackTestCase::countBy;
            this.payloads.countByWith = MutableStackTestCase::countByWith;
            this.payloads.countByEach = MutableStackTestCase::countByEach;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.chunk_empty = MutableStackTestCase::chunk_empty;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.empty = MutableStackTestCase::empty;
            this.payloads.notEmpty = MutableStackTestCase::notEmpty;
            this.payloads.reduceOptional = MutableStackTestCase::reduceOptional;
            this.payloads.testNewStackFromTopToBottom = MutableStackTestCase::testNewStackFromTopToBottom;
            this.payloads.peek_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::peek_empty_throws, java.util.EmptyStackException.class);
            this.payloads.peek_int_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::peek_int_empty_throws, java.util.EmptyStackException.class);
            this.payloads.peek_int_count_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::peek_int_count_throws, java.lang.IllegalArgumentException.class);
            this.payloads.peek_int_neg_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::peek_int_neg_throws, java.lang.IllegalArgumentException.class);
            this.payloads.peek_illegal_arguments = MutableStackTestCase::peek_illegal_arguments;
            this.payloads.peek = MutableStackTestCase::peek;
            this.payloads.peekAt = MutableStackTestCase::peekAt;
            this.payloads.peekAt_illegal_arguments = MutableStackTestCase::peekAt_illegal_arguments;
            this.payloads.size = MutableStackTestCase::size;
            this.payloads.getFirst = MutableStackTestCase::getFirst;
            this.payloads.getLast = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::getLast, java.lang.UnsupportedOperationException.class);
            this.payloads.containsAll = MutableStackTestCase::containsAll;
            this.payloads.containsAllArguments = MutableStackTestCase::containsAllArguments;
            this.payloads.collect = MutableStackTestCase::collect;
            this.payloads.collectWithIndex = MutableStackTestCase::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = MutableStackTestCase::collectWithIndexWithTarget;
            this.payloads.selectWithIndexWithTarget = MutableStackTestCase::selectWithIndexWithTarget;
            this.payloads.rejectWithIndexWithTarget = MutableStackTestCase::rejectWithIndexWithTarget;
            this.payloads.collectBoolean = MutableStackTestCase::collectBoolean;
            this.payloads.collectBooleanWithTarget = MutableStackTestCase::collectBooleanWithTarget;
            this.payloads.collectByte = MutableStackTestCase::collectByte;
            this.payloads.collectByteWithTarget = MutableStackTestCase::collectByteWithTarget;
            this.payloads.collectChar = MutableStackTestCase::collectChar;
            this.payloads.collectCharWithTarget = MutableStackTestCase::collectCharWithTarget;
            this.payloads.collectDouble = MutableStackTestCase::collectDouble;
            this.payloads.collectDoubleWithTarget = MutableStackTestCase::collectDoubleWithTarget;
            this.payloads.collectFloat = MutableStackTestCase::collectFloat;
            this.payloads.collectFloatWithTarget = MutableStackTestCase::collectFloatWithTarget;
            this.payloads.collectInt = MutableStackTestCase::collectInt;
            this.payloads.collectIntWithTarget = MutableStackTestCase::collectIntWithTarget;
            this.payloads.collectLong = MutableStackTestCase::collectLong;
            this.payloads.collectLongWithTarget = MutableStackTestCase::collectLongWithTarget;
            this.payloads.collectShort = MutableStackTestCase::collectShort;
            this.payloads.collectShortWithTarget = MutableStackTestCase::collectShortWithTarget;
            this.payloads.collectIf = MutableStackTestCase::collectIf;
            this.payloads.collectWith = MutableStackTestCase::collectWith;
            this.payloads.collectWithTarget = MutableStackTestCase::collectWithTarget;
            this.payloads.flatCollect = MutableStackTestCase::flatCollect;
            this.payloads.select = MutableStackTestCase::select;
            this.payloads.selectInstancesOf = MutableStackTestCase::selectInstancesOf;
            this.payloads.selectWith = MutableStackTestCase::selectWith;
            this.payloads.selectWithTarget = MutableStackTestCase::selectWithTarget;
            this.payloads.reject = MutableStackTestCase::reject;
            this.payloads.rejectWith = MutableStackTestCase::rejectWith;
            this.payloads.rejectWithTarget = MutableStackTestCase::rejectWithTarget;
            this.payloads.detect = MutableStackTestCase::detect;
            this.payloads.detectWith = MutableStackTestCase::detectWith;
            this.payloads.detectIfNone = MutableStackTestCase::detectIfNone;
            this.payloads.detectWithIfNone = MutableStackTestCase::detectWithIfNone;
            this.payloads.partition = MutableStackTestCase::partition;
            this.payloads.partitionWith = MutableStackTestCase::partitionWith;
            this.payloads.zip = MutableStackTestCase::zip;
            this.payloads.zipWithIndex = MutableStackTestCase::zipWithIndex;
            this.payloads.count = MutableStackTestCase::count;
            this.payloads.countWith = MutableStackTestCase::countWith;
            this.payloads.anySatisfy = MutableStackTestCase::anySatisfy;
            this.payloads.allSatisfy = MutableStackTestCase::allSatisfy;
            this.payloads.noneSatisfy = MutableStackTestCase::noneSatisfy;
            this.payloads.anySatisfyWith = MutableStackTestCase::anySatisfyWith;
            this.payloads.allSatisfyWith = MutableStackTestCase::allSatisfyWith;
            this.payloads.noneSatisfyWith = MutableStackTestCase::noneSatisfyWith;
            this.payloads.injectInto = MutableStackTestCase::injectInto;
            this.payloads.sumOf = MutableStackTestCase::sumOf;
            this.payloads.sumOfFloatConsistentRounding = MutableStackTestCase::sumOfFloatConsistentRounding;
            this.payloads.sumOfDoubleConsistentRounding = MutableStackTestCase::sumOfDoubleConsistentRounding;
            this.payloads.sumByFloatConsistentRounding = MutableStackTestCase::sumByFloatConsistentRounding;
            this.payloads.sumByDoubleConsistentRounding = MutableStackTestCase::sumByDoubleConsistentRounding;
            this.payloads.max = MutableStackTestCase::max;
            this.payloads.maxBy = MutableStackTestCase::maxBy;
            this.payloads.min = MutableStackTestCase::min;
            this.payloads.minBy = MutableStackTestCase::minBy;
            this.payloads.testToString = MutableStackTestCase::testToString;
            this.payloads.makeString = MutableStackTestCase::makeString;
            this.payloads.appendString = MutableStackTestCase::appendString;
            this.payloads.groupBy = MutableStackTestCase::groupBy;
            this.payloads.groupByEach = MutableStackTestCase::groupByEach;
            this.payloads.groupByUniqueKey = MutableStackTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = MutableStackTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.chunk = MutableStackTestCase::chunk;
            this.payloads.chunk_single = MutableStackTestCase::chunk_single;
            this.payloads.chunk_large_size = MutableStackTestCase::chunk_large_size;
            this.payloads.tap = MutableStackTestCase::tap;
            this.payloads.forEach = MutableStackTestCase::forEach;
            this.payloads.forEachWith = MutableStackTestCase::forEachWith;
            this.payloads.forEachWithIndex = MutableStackTestCase::forEachWithIndex;
            this.payloads.toList = MutableStackTestCase::toList;
            this.payloads.toStack = MutableStackTestCase::toStack;
            this.payloads.toSortedList = MutableStackTestCase::toSortedList;
            this.payloads.toSortedListBy = MutableStackTestCase::toSortedListBy;
            this.payloads.toSet = MutableStackTestCase::toSet;
            this.payloads.toSortedSet = MutableStackTestCase::toSortedSet;
            this.payloads.toSortedSetBy = MutableStackTestCase::toSortedSetBy;
            this.payloads.toBag = MutableStackTestCase::toBag;
            this.payloads.toSortedBag = MutableStackTestCase::toSortedBag;
            this.payloads.toSortedBagBy = MutableStackTestCase::toSortedBagBy;
            this.payloads.toMap = MutableStackTestCase::toMap;
            this.payloads.toSortedMap = MutableStackTestCase::toSortedMap;
            this.payloads.asLazy = MutableStackTestCase::asLazy;
            this.payloads.toArray = MutableStackTestCase::toArray;
            this.payloads.iterator = MutableStackTestCase::iterator;
            this.payloads.testEquals = MutableStackTestCase::testEquals;
            this.payloads.testHashCode = MutableStackTestCase::testHashCode;
            this.payloads.aggregateByMutating = MutableStackTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = MutableStackTestCase::aggregateByNonMutating;
            this.payloads.testPushPopAndPeek = MutableStackTestCase::testPushPopAndPeek;
            this.payloads.clear = MutableStackTestCase::clear;
            this.payloads.testNewStackWithOrder = MutableStackTestCase::testNewStackWithOrder;
            this.payloads.testNewStackIterableOrder = MutableStackTestCase::testNewStackIterableOrder;
            this.payloads.testNewStackFromTopToBottomOrder = MutableStackTestCase::testNewStackFromTopToBottomOrder;
            this.payloads.testNewStackFromTopToBottomIterableOrder = MutableStackTestCase::testNewStackFromTopToBottomIterableOrder;
            this.payloads.pop_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::pop_empty_throws, java.util.EmptyStackException.class);
            this.payloads.pop_int_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::pop_int_empty_throws, java.util.EmptyStackException.class);
            this.payloads.pop_int_count_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::pop_int_count_throws, java.lang.IllegalArgumentException.class);
            this.payloads.pop_int_neg_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::pop_int_neg_throws, java.lang.IllegalArgumentException.class);
            this.payloads.pop_target_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::pop_target_empty_throws, java.util.EmptyStackException.class);
            this.payloads.pop_target_count_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::pop_target_count_throws, java.lang.IllegalArgumentException.class);
            this.payloads.pop_target_neg_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::pop_target_neg_throws, java.lang.IllegalArgumentException.class);
            this.payloads.pop_targetStack_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::pop_targetStack_empty_throws, java.util.EmptyStackException.class);
            this.payloads.pop_targetStack_count_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::pop_targetStack_count_throws, java.lang.IllegalArgumentException.class);
            this.payloads.pop_targetStack_neg_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableStackTestCase::pop_targetStack_neg_throws, java.lang.IllegalArgumentException.class);
            this.payloads.asUnmodifiable = MutableStackTestCase::asUnmodifiable;
            this.payloads.asSynchronized = MutableStackTestCase::asSynchronized;
        }
    }
*/
}
