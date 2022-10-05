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

import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.MutableShortList;
import org.eclipse.collections.api.stack.StackIterable;
import org.eclipse.collections.api.stack.primitive.ShortStack;
import org.eclipse.collections.api.stack.primitive.ImmutableShortStack;
import org.eclipse.collections.api.tuple.primitive.ShortIntPair;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractShortIterableTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ShortStacks;
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.ShortSets;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.eclipse.collections.impl.stack.mutable.primitive.ShortArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ShortStack}.
 * This file was automatically generated from template file abstractPrimitiveStackTestCase.stg.
 */
public abstract class AbstractShortStackTestCase extends AbstractShortIterableTestCase {

    @Override
    protected abstract ShortStack classUnderTest();

    @Override
    protected abstract ShortStack newWith(short... elements);

    @Override
    protected ShortStack newMutableCollectionWith(short... elements) {
        return ShortArrayStack.newStackWith(elements);
    }

    @Override
    protected RichIterable<Short> newObjectCollectionWith(Short... elements) {
        return ArrayStack.newStackWith(elements);
    }

    protected abstract ShortStack newWithTopToBottom(short... elements);

    @Override
    @Test
    public void shortIterator() {
        ShortIterator iterator = this.classUnderTest().shortIterator();
        int size = this.classUnderTest().size();
        for (int i = 0; i < size; i++) {
            Assert.assertTrue(iterator.hasNext());
            Assert.assertEquals((short) (size - i), iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(size, this.classUnderTest().shortIterator().next());
    }

    @Test
    public void peek() {
        Assert.assertEquals(this.classUnderTest().size(), this.classUnderTest().peek());
        Assert.assertEquals(ShortArrayList.newListWith(), this.classUnderTest().peek(0));
        Assert.assertEquals(ShortArrayList.newListWith((short) this.classUnderTest().size(), (short) (this.classUnderTest().size() - 1)), this.classUnderTest().peek(2));
    }

    @Test
    public void peekAtIndex() {
        int size = this.classUnderTest().size();
        for (int i = 0; i < size; i++) {
            Assert.assertEquals((short) (size - i), this.classUnderTest().peekAt(i));
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
        ShortArrayList list = new ShortArrayList();
        int size = this.classUnderTest().size();
        for (int i = 0; i < size; i++) {
            list.add((short) (size - i));
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
        for (short each = 0; each < size; each++) {
            expectedString.append((short) (size - each));
            expectedString.append(each == size - 1 ? "" : sep);
        }
        expectedString.append(end);
        return expectedString.toString();
    }

    @Override
    @Test
    public void detectIfNone() {
        ShortIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Assert.assertEquals(size >= 4 ? 4L : 0L, iterable.detectIfNone(ShortPredicates.equal((short) 4), (short) 0));
        Assert.assertEquals(size >= 2 ? 2L : 0L, iterable.detectIfNone(ShortPredicates.equal((short) 2), (short) 0));
        Assert.assertEquals(size > 0 ? 3L : 0L, iterable.detectIfNone(ShortPredicates.lessThan((short) 4), (short) 0));
        Assert.assertEquals(size > 3 ? 4L : 0L, iterable.detectIfNone(ShortPredicates.greaterThan((short) 3), (short) 0));
        ShortIterable iterable1 = this.newWith((short) 0, (short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3);
        Assert.assertEquals(0L, iterable1.detectIfNone(ShortPredicates.lessThan((short) 1), (short) 4));
        Assert.assertEquals(3L, iterable1.detectIfNone(ShortPredicates.greaterThan((short) 2), (short) 4));
        Assert.assertEquals(4L, iterable1.detectIfNone(ShortPredicates.greaterThan((short) 4), (short) 4));
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
        Verify.assertInstanceOf(ImmutableShortStack.class, this.classUnderTest().toImmutable());
    }

    /**
     * @since 11.1.
     */
    @Test
    public void selectWithIndex() {
        ShortStack stack = this.newWith((short) 3, (short) 1, (short) 9, (short) 7);
        ShortStack selected = stack.selectWithIndex((value, i) -> i % 2 == 0);
        Assert.assertEquals(ShortStacks.immutable.with((short) 1, (short) 7), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void selectWithIndexWithTarget() {
        ShortStack stack = this.newWith((short) 3, (short) 1, (short) 9, (short) 7);
        MutableShortList selected = stack.selectWithIndex((value, i) -> i % 2 == 0, ShortLists.mutable.empty());
        Assert.assertEquals(ShortLists.immutable.with((short) 7, (short) 1), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void rejectWithIndex() {
        ShortStack stack = this.newWith((short) 3, (short) 1, (short) 9, (short) 7);
        ShortStack rejected = stack.rejectWithIndex((value, i) -> i % 2 == 0);
        Assert.assertEquals(ShortStacks.mutable.with((short) 3, (short) 9), rejected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void rejectWithIndexWithTarget() {
        ShortStack stack = this.newWith((short) 3, (short) 1, (short) 9, (short) 7);
        MutableShortList rejected = stack.rejectWithIndex((value, i) -> i % 2 == 0, ShortLists.mutable.empty());
        Assert.assertEquals(ShortLists.immutable.with((short) 9, (short) 3), rejected);
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex() {
        StackIterable<ShortIntPair> pairs = this.newWith((short) 3, (short) 1, (short) 9, (short) 7).collectWithIndex(PrimitiveTuples::pair);
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(ShortIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(ShortLists.mutable.with((short) 7, (short) 9, (short) 1, (short) 3), pairs.collectShort(ShortIntPair::getOne, ShortLists.mutable.empty()));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget() {
        MutableList<ShortIntPair> pairs = this.newWith((short) 3, (short) 1, (short) 9, (short) 7).collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty());
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(ShortIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(ShortLists.mutable.with((short) 7, (short) 9, (short) 1, (short) 3), pairs.collectShort(ShortIntPair::getOne, ShortLists.mutable.empty()));
        Assert.assertEquals(IntSets.mutable.with(0, 1, 2, 3), pairs.collectInt(ShortIntPair::getTwo, IntSets.mutable.empty()));
        Assert.assertEquals(ShortSets.mutable.with((short) 3, (short) 1, (short) 9, (short) 7), pairs.collectShort(ShortIntPair::getOne, ShortSets.mutable.empty()));
    }

    @Test
    public void chunk() {
        ShortIterable iterable = this.newWith((short) 5, (short) 4, (short) 3, (short) 2, (short) 1, (short) 0);
        Verify.assertIterablesEqual(Lists.mutable.with(ShortLists.mutable.with((short) 0), ShortLists.mutable.with((short) 1), ShortLists.mutable.with((short) 2), ShortLists.mutable.with((short) 3), ShortLists.mutable.with((short) 4), ShortLists.mutable.with((short) 5)).toSet(), iterable.chunk(1).toSet());
        Verify.assertIterablesEqual(Lists.mutable.with(ShortLists.mutable.with((short) 0, (short) 1), ShortLists.mutable.with((short) 2, (short) 3), ShortLists.mutable.with((short) 4, (short) 5)).toSet(), iterable.chunk(2).toSet());
        Verify.assertIterablesEqual(Lists.mutable.with(ShortLists.mutable.with((short) 0, (short) 1, (short) 2), ShortLists.mutable.with((short) 3, (short) 4, (short) 5)).toSet(), iterable.chunk(3).toSet());
        Verify.assertIterablesEqual(Lists.mutable.with(ShortLists.mutable.with((short) 0, (short) 1, (short) 2, (short) 3), ShortLists.mutable.with((short) 4, (short) 5)).toSet(), iterable.chunk(4).toSet());
        Verify.assertIterablesEqual(Lists.mutable.with(ShortLists.mutable.with((short) 0, (short) 1, (short) 2, (short) 3, (short) 4, (short) 5)).toSet(), iterable.chunk(6).toSet());
        Verify.assertIterablesEqual(Lists.mutable.with(ShortLists.mutable.with((short) 0, (short) 1, (short) 2, (short) 3, (short) 4, (short) 5)).toSet(), iterable.chunk(7).toSet());
        Verify.assertIterablesEqual(Lists.mutable.with(), this.newWith().chunk(1));
        if (this.newWith() instanceof ImmutableShortStack) {
            Verify.assertIterablesEqual(Lists.mutable.with(ShortStacks.immutable.with((short) 0)), this.newWith((short) 0).chunk(1));
        } else {
            Verify.assertIterablesEqual(Lists.mutable.with(ShortLists.mutable.with((short) 0)), this.newWith((short) 0).chunk(1));
        }
        Verify.assertIterablesEqual(Lists.mutable.with(), this.newWith().chunk(1));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWith((short) 0).chunk(-1));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getFirst() {
        this.classUnderTest().getFirst();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void indexOf() {
        this.classUnderTest().indexOf((short) 0);
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

        private AbstractShortStackTestCase instance;

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
        public void benchmark_shortIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_non_empty_collection);
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
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractShortStackTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> shortIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> shortIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> peek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> peekAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> peek_at_index_less_than_zero_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> peek_at_index_greater_than_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> peek_at_index_equal_to_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortStackTestCase> forEachWithIndex;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractShortStackTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractShortStackTestCase::newCollection;
            this.payloads.isEmpty = AbstractShortStackTestCase::isEmpty;
            this.payloads.notEmpty = AbstractShortStackTestCase::notEmpty;
            this.payloads.tap = AbstractShortStackTestCase::tap;
            this.payloads.contains = AbstractShortStackTestCase::contains;
            this.payloads.containsAllArray = AbstractShortStackTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractShortStackTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractShortStackTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractShortStackTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractShortStackTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractShortStackTestCase::containsNoneIterable;
            this.payloads.shortIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortStackTestCase::shortIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.shortIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortStackTestCase::shortIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractShortStackTestCase::forEach;
            this.payloads.size = AbstractShortStackTestCase::size;
            this.payloads.count = AbstractShortStackTestCase::count;
            this.payloads.anySatisfy = AbstractShortStackTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractShortStackTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractShortStackTestCase::noneSatisfy;
            this.payloads.collect = AbstractShortStackTestCase::collect;
            this.payloads.collectWithTarget = AbstractShortStackTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractShortStackTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractShortStackTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractShortStackTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractShortStackTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractShortStackTestCase::select;
            this.payloads.selectWithTarget = AbstractShortStackTestCase::selectWithTarget;
            this.payloads.reject = AbstractShortStackTestCase::reject;
            this.payloads.rejectWithTarget = AbstractShortStackTestCase::rejectWithTarget;
            this.payloads.max = AbstractShortStackTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortStackTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractShortStackTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortStackTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractShortStackTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractShortStackTestCase::maxIfEmpty;
            this.payloads.sum = AbstractShortStackTestCase::sum;
            this.payloads.summaryStatistics = AbstractShortStackTestCase::summaryStatistics;
            this.payloads.average = AbstractShortStackTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortStackTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractShortStackTestCase::averageIfEmpty;
            this.payloads.median = AbstractShortStackTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortStackTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractShortStackTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractShortStackTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractShortStackTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractShortStackTestCase::toSortedArray;
            this.payloads.testEquals = AbstractShortStackTestCase::testEquals;
            this.payloads.testHashCode = AbstractShortStackTestCase::testHashCode;
            this.payloads.toSortedList = AbstractShortStackTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractShortStackTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractShortStackTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractShortStackTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractShortStackTestCase::toSet;
            this.payloads.toBag = AbstractShortStackTestCase::toBag;
            this.payloads.asLazy = AbstractShortStackTestCase::asLazy;
            this.payloads.injectInto = AbstractShortStackTestCase::injectInto;
            this.payloads.injectIntoBoolean = AbstractShortStackTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractShortStackTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractShortStackTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractShortStackTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractShortStackTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractShortStackTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractShortStackTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractShortStackTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortStackTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractShortStackTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractShortStackTestCase::reduceIfEmpty;
            this.payloads.shortIterator = AbstractShortStackTestCase::shortIterator;
            this.payloads.peek = AbstractShortStackTestCase::peek;
            this.payloads.peekAtIndex = AbstractShortStackTestCase::peekAtIndex;
            this.payloads.peek_at_index_less_than_zero_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortStackTestCase::peek_at_index_less_than_zero_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_greater_than_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortStackTestCase::peek_at_index_greater_than_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_equal_to_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortStackTestCase::peek_at_index_equal_to_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.testToString = AbstractShortStackTestCase::testToString;
            this.payloads.toList = AbstractShortStackTestCase::toList;
            this.payloads.makeString = AbstractShortStackTestCase::makeString;
            this.payloads.detectIfNone = AbstractShortStackTestCase::detectIfNone;
            this.payloads.appendString = AbstractShortStackTestCase::appendString;
            this.payloads.toImmutable = AbstractShortStackTestCase::toImmutable;
            this.payloads.selectWithIndex = AbstractShortStackTestCase::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = AbstractShortStackTestCase::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = AbstractShortStackTestCase::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = AbstractShortStackTestCase::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = AbstractShortStackTestCase::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = AbstractShortStackTestCase::collectWithIndexWithTarget;
            this.payloads.chunk = AbstractShortStackTestCase::chunk;
            this.payloads.getFirst = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortStackTestCase::getFirst, java.lang.UnsupportedOperationException.class);
            this.payloads.indexOf = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortStackTestCase::indexOf, java.lang.UnsupportedOperationException.class);
            this.payloads.injectIntoWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortStackTestCase::injectIntoWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.forEachWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortStackTestCase::forEachWithIndex, java.lang.UnsupportedOperationException.class);
        }
    }
}
