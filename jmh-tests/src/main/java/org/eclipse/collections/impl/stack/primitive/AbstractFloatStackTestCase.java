/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.stack.primitive;

import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.MutableFloatList;
import org.eclipse.collections.api.stack.StackIterable;
import org.eclipse.collections.api.stack.primitive.FloatStack;
import org.eclipse.collections.api.stack.primitive.ImmutableFloatStack;
import org.eclipse.collections.api.tuple.primitive.FloatIntPair;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractFloatIterableTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.FloatStacks;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.FloatSets;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.eclipse.collections.impl.stack.mutable.primitive.FloatArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link FloatStack}.
 * This file was automatically generated from template file abstractPrimitiveStackTestCase.stg.
 */
public abstract class AbstractFloatStackTestCase extends AbstractFloatIterableTestCase {

    @Override
    protected abstract FloatStack classUnderTest();

    @Override
    protected abstract FloatStack newWith(float... elements);

    @Override
    protected FloatStack newMutableCollectionWith(float... elements) {
        return FloatArrayStack.newStackWith(elements);
    }

    @Override
    protected RichIterable<Float> newObjectCollectionWith(Float... elements) {
        return ArrayStack.newStackWith(elements);
    }

    protected abstract FloatStack newWithTopToBottom(float... elements);

    @Override
    @Test
    public void floatIterator() {
        FloatIterator iterator = this.classUnderTest().floatIterator();
        int size = this.classUnderTest().size();
        for (int i = 0; i < size; i++) {
            Assert.assertTrue(iterator.hasNext());
            Assert.assertEquals(size - i, iterator.next(), 0.0);
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(size, this.classUnderTest().floatIterator().next(), 0.0);
    }

    @Test
    public void peek() {
        Assert.assertEquals(this.classUnderTest().size(), this.classUnderTest().peek(), 0.0);
        Assert.assertEquals(FloatArrayList.newListWith(), this.classUnderTest().peek(0));
        Assert.assertEquals(FloatArrayList.newListWith(this.classUnderTest().size(), this.classUnderTest().size() - 1), this.classUnderTest().peek(2));
    }

    @Test
    public void peekAtIndex() {
        int size = this.classUnderTest().size();
        for (int i = 0; i < size; i++) {
            Assert.assertEquals(size - i, this.classUnderTest().peekAt(i), 0.0);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void peek_at_index_less_than_zero_throws_exception() {
        this.classUnderTest().peekAt(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void peek_at_index_greater_than_size_throws_exception() {
        this.classUnderTest().peekAt(this.classUnderTest().size() + 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void peek_at_index_equal_to_size_throws_exception() {
        this.classUnderTest().peekAt(this.classUnderTest().size());
    }

    @Override
    @Test
    public void testToString() {
        super.testToString();
        Assert.assertEquals(this.createExpectedString("[", ", ", "]"), this.classUnderTest().toString());
    }

    @Override
    @Test
    public void toList() {
        super.toList();
        FloatArrayList list = new FloatArrayList();
        int size = this.classUnderTest().size();
        for (int i = 0; i < size; i++) {
            list.add(size - i);
        }
        Assert.assertEquals(list, this.classUnderTest().toList());
    }

    @Override
    @Test
    public void makeString() {
        super.makeString();
        Assert.assertEquals(this.createExpectedString("", ", ", ""), this.classUnderTest().makeString());
        Assert.assertEquals(this.createExpectedString("", "|", ""), this.classUnderTest().makeString("|"));
        Assert.assertEquals(this.createExpectedString("{", "|", "}"), this.classUnderTest().makeString("{", "|", "}"));
    }

    protected String createExpectedString(String start, String sep, String end) {
        StringBuilder expectedString = new StringBuilder(start);
        int size = this.classUnderTest().size();
        for (float each = 0; each < size; each++) {
            expectedString.append((float) (size - each));
            expectedString.append((int) each == size - 1 ? "" : sep);
        }
        expectedString.append(end);
        return expectedString.toString();
    }

    @Override
    @Test
    public void detectIfNone() {
        FloatIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Assert.assertEquals(size >= 4 ? 4.0 : 0.0, iterable.detectIfNone(FloatPredicates.equal(4.0f), 0.0f), 0.0);
        Assert.assertEquals(size >= 2 ? 2.0 : 0.0, iterable.detectIfNone(FloatPredicates.equal(2.0f), 0.0f), 0.0);
        Assert.assertEquals(size > 0 ? 3.0 : 0.0, iterable.detectIfNone(FloatPredicates.lessThan(4.0f), 0.0f), 0.0);
        Assert.assertEquals(size > 3 ? 4.0 : 0.0, iterable.detectIfNone(FloatPredicates.greaterThan(3.0f), 0.0f), 0.0);
        FloatIterable iterable1 = this.newWith(0.0f, 1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f);
        Assert.assertEquals(0.0, iterable1.detectIfNone(FloatPredicates.lessThan(1.0f), 4.0f), 0.0);
        Assert.assertEquals(3.0, iterable1.detectIfNone(FloatPredicates.greaterThan(2.0f), 4.0f), 0.0);
        Assert.assertEquals(4.0, iterable1.detectIfNone(FloatPredicates.greaterThan(4.0f), 4.0f), 0.0);
    }

    @Override
    @Test
    public void appendString() {
        super.appendString();
        StringBuilder appendable1 = new StringBuilder();
        this.classUnderTest().appendString(appendable1);
        Assert.assertEquals(this.createExpectedString("", ", ", ""), appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();
        this.classUnderTest().appendString(appendable2, "|");
        Assert.assertEquals(this.createExpectedString("", "|", ""), appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        this.classUnderTest().appendString(appendable3, "{", "|", "}");
        Assert.assertEquals(this.createExpectedString("{", "|", "}"), appendable3.toString());
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableFloatStack.class, this.classUnderTest().toImmutable());
    }

    /**
     * @since 11.1.
     */
    @Test
    public void selectWithIndex() {
        FloatStack stack = this.newWith(3.0f, 1.0f, 9.0f, 7.0f);
        FloatStack selected = stack.selectWithIndex((value, i) -> i % 2 == 0);
        Assert.assertEquals(FloatStacks.immutable.with(1.0f, 7.0f), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void selectWithIndexWithTarget() {
        FloatStack stack = this.newWith(3.0f, 1.0f, 9.0f, 7.0f);
        MutableFloatList selected = stack.selectWithIndex((value, i) -> i % 2 == 0, FloatLists.mutable.empty());
        Assert.assertEquals(FloatLists.immutable.with(7.0f, 1.0f), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void rejectWithIndex() {
        FloatStack stack = this.newWith(3.0f, 1.0f, 9.0f, 7.0f);
        FloatStack rejected = stack.rejectWithIndex((value, i) -> i % 2 == 0);
        Assert.assertEquals(FloatStacks.mutable.with(3.0f, 9.0f), rejected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void rejectWithIndexWithTarget() {
        FloatStack stack = this.newWith(3.0f, 1.0f, 9.0f, 7.0f);
        MutableFloatList rejected = stack.rejectWithIndex((value, i) -> i % 2 == 0, FloatLists.mutable.empty());
        Assert.assertEquals(FloatLists.immutable.with(9.0f, 3.0f), rejected);
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex() {
        StackIterable<FloatIntPair> pairs = this.newWith(3.0f, 1.0f, 9.0f, 7.0f).collectWithIndex(PrimitiveTuples::pair);
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(FloatIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(FloatLists.mutable.with(7.0f, 9.0f, 1.0f, 3.0f), pairs.collectFloat(FloatIntPair::getOne, FloatLists.mutable.empty()));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget() {
        MutableList<FloatIntPair> pairs = this.newWith(3.0f, 1.0f, 9.0f, 7.0f).collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty());
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(FloatIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(FloatLists.mutable.with(7.0f, 9.0f, 1.0f, 3.0f), pairs.collectFloat(FloatIntPair::getOne, FloatLists.mutable.empty()));
        Assert.assertEquals(IntSets.mutable.with(0, 1, 2, 3), pairs.collectInt(FloatIntPair::getTwo, IntSets.mutable.empty()));
        Assert.assertEquals(FloatSets.mutable.with(3.0f, 1.0f, 9.0f, 7.0f), pairs.collectFloat(FloatIntPair::getOne, FloatSets.mutable.empty()));
    }

    @Test
    public void chunk() {
        FloatIterable iterable = this.newWith(5.0f, 4.0f, 3.0f, 2.0f, 1.0f, 0.0f);
        Verify.assertIterablesEqual(Lists.mutable.with(FloatLists.mutable.with(0.0f), FloatLists.mutable.with(1.0f), FloatLists.mutable.with(2.0f), FloatLists.mutable.with(3.0f), FloatLists.mutable.with(4.0f), FloatLists.mutable.with(5.0f)).toSet(), iterable.chunk(1).toSet());
        Verify.assertIterablesEqual(Lists.mutable.with(FloatLists.mutable.with(0.0f, 1.0f), FloatLists.mutable.with(2.0f, 3.0f), FloatLists.mutable.with(4.0f, 5.0f)).toSet(), iterable.chunk(2).toSet());
        Verify.assertIterablesEqual(Lists.mutable.with(FloatLists.mutable.with(0.0f, 1.0f, 2.0f), FloatLists.mutable.with(3.0f, 4.0f, 5.0f)).toSet(), iterable.chunk(3).toSet());
        Verify.assertIterablesEqual(Lists.mutable.with(FloatLists.mutable.with(0.0f, 1.0f, 2.0f, 3.0f), FloatLists.mutable.with(4.0f, 5.0f)).toSet(), iterable.chunk(4).toSet());
        Verify.assertIterablesEqual(Lists.mutable.with(FloatLists.mutable.with(0.0f, 1.0f, 2.0f, 3.0f, 4.0f, 5.0f)).toSet(), iterable.chunk(6).toSet());
        Verify.assertIterablesEqual(Lists.mutable.with(FloatLists.mutable.with(0.0f, 1.0f, 2.0f, 3.0f, 4.0f, 5.0f)).toSet(), iterable.chunk(7).toSet());
        Verify.assertIterablesEqual(Lists.mutable.with(), this.newWith().chunk(1));
        if (this.newWith() instanceof ImmutableFloatStack) {
            Verify.assertIterablesEqual(Lists.mutable.with(FloatStacks.immutable.with(0.0f)), this.newWith(0.0f).chunk(1));
        } else {
            Verify.assertIterablesEqual(Lists.mutable.with(FloatLists.mutable.with(0.0f)), this.newWith(0.0f).chunk(1));
        }
        Verify.assertIterablesEqual(Lists.mutable.with(), this.newWith().chunk(1));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWith(0.0f).chunk(-1));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getFirst() {
        this.classUnderTest().getFirst();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void indexOf() {
        this.classUnderTest().indexOf(0.0f);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void injectIntoWithIndex() {
        this.classUnderTest().injectIntoWithIndex(null, null);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void forEachWithIndex() {
        this.classUnderTest().forEachWithIndex(null);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractFloatStackTestCase instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NaN);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NEGATIVE_INFINITY);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_POSITIVE_INFINITY);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_zero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_zero);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals_NaN);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_different_NaNs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_different_NaNs);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectIterableWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectIterableWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToLists() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToLists);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToSets() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToSets);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
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
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summaryStatistics() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summaryStatistics);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArrayWithTargetArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArrayWithTargetArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
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
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionNaturalOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionNaturalOrder);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionWithComparator);
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
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
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
        public void benchmark_reduceOnEmptyThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOnEmptyThrows);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduce() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduce);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peekAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peekAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_at_index_less_than_zero_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_at_index_less_than_zero_throws_exception);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_at_index_greater_than_size_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_at_index_greater_than_size_throws_exception);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_at_index_equal_to_size_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_at_index_equal_to_size_throws_exception);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
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
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractFloatStackTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> floatIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> floatIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> peek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> peekAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> peek_at_index_less_than_zero_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> peek_at_index_greater_than_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> peek_at_index_equal_to_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatStackTestCase> forEachWithIndex;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractFloatStackTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractFloatStackTestCase::newCollection;
            this.payloads.isEmpty = AbstractFloatStackTestCase::isEmpty;
            this.payloads.notEmpty = AbstractFloatStackTestCase::notEmpty;
            this.payloads.tap = AbstractFloatStackTestCase::tap;
            this.payloads.contains = AbstractFloatStackTestCase::contains;
            this.payloads.contains_NaN = AbstractFloatStackTestCase::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = AbstractFloatStackTestCase::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = AbstractFloatStackTestCase::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = AbstractFloatStackTestCase::contains_zero;
            this.payloads.testEquals_NaN = AbstractFloatStackTestCase::testEquals_NaN;
            this.payloads.contains_different_NaNs = AbstractFloatStackTestCase::contains_different_NaNs;
            this.payloads.containsAllArray = AbstractFloatStackTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractFloatStackTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractFloatStackTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractFloatStackTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractFloatStackTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractFloatStackTestCase::containsNoneIterable;
            this.payloads.floatIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatStackTestCase::floatIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.floatIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatStackTestCase::floatIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractFloatStackTestCase::forEach;
            this.payloads.size = AbstractFloatStackTestCase::size;
            this.payloads.count = AbstractFloatStackTestCase::count;
            this.payloads.anySatisfy = AbstractFloatStackTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractFloatStackTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractFloatStackTestCase::noneSatisfy;
            this.payloads.collect = AbstractFloatStackTestCase::collect;
            this.payloads.collectWithTarget = AbstractFloatStackTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractFloatStackTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractFloatStackTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractFloatStackTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractFloatStackTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractFloatStackTestCase::select;
            this.payloads.selectWithTarget = AbstractFloatStackTestCase::selectWithTarget;
            this.payloads.reject = AbstractFloatStackTestCase::reject;
            this.payloads.rejectWithTarget = AbstractFloatStackTestCase::rejectWithTarget;
            this.payloads.max = AbstractFloatStackTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatStackTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractFloatStackTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatStackTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractFloatStackTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractFloatStackTestCase::maxIfEmpty;
            this.payloads.sum = AbstractFloatStackTestCase::sum;
            this.payloads.summaryStatistics = AbstractFloatStackTestCase::summaryStatistics;
            this.payloads.sumConsistentRounding = AbstractFloatStackTestCase::sumConsistentRounding;
            this.payloads.average = AbstractFloatStackTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatStackTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractFloatStackTestCase::averageIfEmpty;
            this.payloads.median = AbstractFloatStackTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatStackTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractFloatStackTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractFloatStackTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractFloatStackTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractFloatStackTestCase::toSortedArray;
            this.payloads.testEquals = AbstractFloatStackTestCase::testEquals;
            this.payloads.testHashCode = AbstractFloatStackTestCase::testHashCode;
            this.payloads.toSortedList = AbstractFloatStackTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractFloatStackTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractFloatStackTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractFloatStackTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractFloatStackTestCase::toSet;
            this.payloads.toBag = AbstractFloatStackTestCase::toBag;
            this.payloads.asLazy = AbstractFloatStackTestCase::asLazy;
            this.payloads.injectInto = AbstractFloatStackTestCase::injectInto;
            this.payloads.injectIntoBoolean = AbstractFloatStackTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractFloatStackTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractFloatStackTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractFloatStackTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractFloatStackTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractFloatStackTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractFloatStackTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractFloatStackTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatStackTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractFloatStackTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractFloatStackTestCase::reduceIfEmpty;
            this.payloads.floatIterator = AbstractFloatStackTestCase::floatIterator;
            this.payloads.peek = AbstractFloatStackTestCase::peek;
            this.payloads.peekAtIndex = AbstractFloatStackTestCase::peekAtIndex;
            this.payloads.peek_at_index_less_than_zero_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatStackTestCase::peek_at_index_less_than_zero_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_greater_than_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatStackTestCase::peek_at_index_greater_than_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_equal_to_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatStackTestCase::peek_at_index_equal_to_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.testToString = AbstractFloatStackTestCase::testToString;
            this.payloads.toList = AbstractFloatStackTestCase::toList;
            this.payloads.makeString = AbstractFloatStackTestCase::makeString;
            this.payloads.detectIfNone = AbstractFloatStackTestCase::detectIfNone;
            this.payloads.appendString = AbstractFloatStackTestCase::appendString;
            this.payloads.toImmutable = AbstractFloatStackTestCase::toImmutable;
            this.payloads.selectWithIndex = AbstractFloatStackTestCase::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = AbstractFloatStackTestCase::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = AbstractFloatStackTestCase::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = AbstractFloatStackTestCase::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = AbstractFloatStackTestCase::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = AbstractFloatStackTestCase::collectWithIndexWithTarget;
            this.payloads.chunk = AbstractFloatStackTestCase::chunk;
            this.payloads.getFirst = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatStackTestCase::getFirst, java.lang.UnsupportedOperationException.class);
            this.payloads.indexOf = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatStackTestCase::indexOf, java.lang.UnsupportedOperationException.class);
            this.payloads.injectIntoWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatStackTestCase::injectIntoWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.forEachWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatStackTestCase::forEachWithIndex, java.lang.UnsupportedOperationException.class);
        }
    }
}
