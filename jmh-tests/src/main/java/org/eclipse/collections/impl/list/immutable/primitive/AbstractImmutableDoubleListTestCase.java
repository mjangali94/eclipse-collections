/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.immutable.primitive;

import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.ImmutableDoubleList;
import org.eclipse.collections.api.list.primitive.MutableDoubleList;
import org.eclipse.collections.api.tuple.primitive.DoubleIntPair;
import org.eclipse.collections.api.tuple.primitive.DoubleDoublePair;
import org.eclipse.collections.api.tuple.primitive.DoubleObjectPair;
import org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableDoubleCollectionTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.DoubleSets;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.math.MutableDouble;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Collections;

/**
 * Abstract JUnit test for {@link ImmutableDoubleList}.
 * This file was automatically generated from template file abstractImmutablePrimitiveListTestCase.stg.
 */
public abstract class AbstractImmutableDoubleListTestCase extends AbstractImmutableDoubleCollectionTestCase {

    @Override
    protected abstract ImmutableDoubleList classUnderTest();

    @Override
    protected ImmutableDoubleList newWith(double... elements) {
        return DoubleLists.immutable.of(elements);
    }

    @Override
    protected MutableDoubleList newMutableCollectionWith(double... elements) {
        return DoubleArrayList.newListWith(elements);
    }

    @Override
    protected MutableList<Double> newObjectCollectionWith(Double... elements) {
        return FastList.newListWith(elements);
    }

    @Test
    public void get() {
        ImmutableDoubleList list = this.classUnderTest();
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(i + 1, list.get(i), 0.0);
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get_throws_index_greater_than_size() {
        this.classUnderTest().get(this.classUnderTest().size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get_throws_index_negative() {
        this.classUnderTest().get(-1);
    }

    @Test
    public void getFirst() {
        Assert.assertEquals(1.0, this.classUnderTest().getFirst(), 0.0);
    }

    @Test
    public void getLast() {
        ImmutableDoubleList list = this.classUnderTest();
        Assert.assertEquals(list.size(), list.getLast(), 0.0);
    }

    @Test
    public void indexOf() {
        ImmutableDoubleList list = this.classUnderTest();
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(i, list.indexOf(i + 1));
        }
        Assert.assertEquals(-1L, list.indexOf(list.size() + 1), 0.0);
        ImmutableDoubleList arrayList = this.newWith(1.0, 2.0, 1.0);
        Assert.assertEquals(0L, arrayList.indexOf(1.0));
        Assert.assertEquals(1L, arrayList.indexOf(2.0));
        Assert.assertEquals(-1L, arrayList.indexOf(9.0));
    }

    @Test
    public void lastIndexOf() {
        ImmutableDoubleList list = this.classUnderTest();
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(i, list.lastIndexOf(i + 1));
        }
        Assert.assertEquals(-1L, list.lastIndexOf(list.size() + 1), 0.0);
        ImmutableDoubleList arrayList = this.newWith(1.0, 2.0, 1.0);
        Assert.assertEquals(2L, arrayList.lastIndexOf(1.0));
        Assert.assertEquals(1L, arrayList.lastIndexOf(2.0));
        Assert.assertEquals(-1L, arrayList.lastIndexOf(9.0));
    }

    @Override
    @Test
    public void doubleIterator() {
        DoubleIterator iterator = this.classUnderTest().doubleIterator();
        for (int i = 0; iterator.hasNext(); i++) {
            Assert.assertEquals(i + 1, iterator.next(), 0.0);
        }
        Assert.assertFalse(iterator.hasNext());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void subList() {
        this.classUnderTest().subList(0, 1);
    }

    @Override
    @Test
    public void toArray() {
        super.toArray();
        ImmutableDoubleList list = this.classUnderTest();
        double[] array = list.toArray();
        Assert.assertEquals(list.size(), array.length);
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(list.get(i), array[i], 0.0);
        }
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        ImmutableDoubleList iterable = this.newWith(1.0, 2.0, 3.0);
        MutableDouble result = iterable.injectInto(new MutableDouble(0.0), MutableDouble::add);
        Assert.assertEquals(new MutableDouble(6.0), result);
    }

    @Test
    public void injectIntoWithIndex() {
        ImmutableDoubleList list1 = this.newWith(1.0, 2.0, 3.0);
        ImmutableDoubleList list2 = this.newWith(1.0, 2.0, 3.0);
        MutableDouble result = list1.injectIntoWithIndex(new MutableDouble(0.0), (MutableDouble object, double value, int index) -> object.add(value * list2.get(index)));
        Assert.assertEquals(new MutableDouble(14.0), result);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void selectWithIndex() {
        ImmutableDoubleList list = this.newWith(3.0, 1.0, 9.0, 7.0);
        ImmutableDoubleList selected = list.selectWithIndex((value, i) -> i % 2 == 0);
        Assert.assertEquals(DoubleLists.immutable.with(3.0, 9.0), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void selectWithIndexWithTarget() {
        ImmutableDoubleList list = this.newWith(3.0, 1.0, 9.0, 7.0);
        MutableDoubleList selected = list.selectWithIndex((value, i) -> i % 2 == 0, DoubleLists.mutable.empty());
        Assert.assertEquals(DoubleLists.immutable.with(3.0, 9.0), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void rejectWithIndex() {
        ImmutableDoubleList list = this.newWith(3.0, 1.0, 9.0, 7.0);
        ImmutableDoubleList rejected = list.rejectWithIndex((value, i) -> i % 2 == 0);
        Assert.assertEquals(DoubleLists.immutable.with(1.0, 7.0), rejected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void rejectWithIndexWithTarget() {
        ImmutableDoubleList list = this.newWith(3.0, 1.0, 9.0, 7.0);
        MutableDoubleList rejected = list.rejectWithIndex((value, i) -> i % 2 == 0, DoubleLists.mutable.empty());
        Assert.assertEquals(DoubleLists.immutable.with(1.0, 7.0), rejected);
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex() {
        ImmutableList<DoubleIntPair> pairs = this.newWith(3.0, 1.0, 9.0, 7.0).collectWithIndex(PrimitiveTuples::pair);
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(DoubleIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(DoubleLists.mutable.with(3.0, 1.0, 9.0, 7.0), pairs.collectDouble(DoubleIntPair::getOne, DoubleLists.mutable.empty()));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget() {
        MutableList<DoubleIntPair> pairs = this.newWith(3.0, 1.0, 9.0, 7.0).collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty());
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(DoubleIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(DoubleLists.mutable.with(3.0, 1.0, 9.0, 7.0), pairs.collectDouble(DoubleIntPair::getOne, DoubleLists.mutable.empty()));
        Assert.assertEquals(IntSets.mutable.with(0, 1, 2, 3), pairs.collectInt(DoubleIntPair::getTwo, IntSets.mutable.empty()));
        Assert.assertEquals(DoubleSets.mutable.with(3.0, 1.0, 9.0, 7.0), pairs.collectDouble(DoubleIntPair::getOne, DoubleSets.mutable.empty()));
    }

    @Test
    public void distinct() {
        ImmutableDoubleList list1 = this.newWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0, 4.0, 4.0, 4.0, 4.0).distinct();
        ImmutableDoubleList list2 = this.newWith(1.0, 2.0, 3.0, 4.0);
        Assert.assertEquals(list1, list2);
    }

    @Test
    public void toReversed() {
        Assert.assertEquals(ImmutableDoubleArrayList.newListWith(3.0, 1.0, 9.0, 7.0), this.newWith(7.0, 9.0, 1.0, 3.0).toReversed());
        ImmutableDoubleList list1 = this.newWith(3.0, 1.0, 9.0, 7.0);
        Assert.assertNotSame(list1, list1.toReversed());
        Assert.assertEquals(DoubleArrayList.newListWith(3.0, 1.0, 9.0, 7.0, 8.0), this.newWith(8.0, 7.0, 9.0, 1.0, 3.0).toReversed());
        ImmutableDoubleList list2 = this.newWith(3.0, 1.0, 9.0, 7.0, 8.0);
        Assert.assertNotSame(list2, list2.toReversed());
    }

    @Test
    public void forEachWithIndex() {
        double[] sum = new double[1];
        this.classUnderTest().forEachWithIndex((double each, int index) -> sum[0] += each + index);
        Assert.assertEquals(9.0, sum[0], 0.0);
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        ImmutableDoubleList list1 = this.newWith(1.0, 2.0, 3.0, 4.0);
        ImmutableDoubleList list2 = this.newWith(4.0, 3.0, 2.0, 1.0);
        Assert.assertNotEquals(list1, list2);
    }

    @Override
    @Test
    public void testToString() {
        super.testToString();
        StringBuilder expectedString = new StringBuilder("[");
        int size = this.classUnderTest().size();
        for (double each = 0; each < size; each++) {
            expectedString.append((double) (each + 1.0));
            expectedString.append((int) each == size - 1 ? "" : ", ");
        }
        expectedString.append(']');
        Assert.assertEquals(expectedString.toString(), this.classUnderTest().toString());
    }

    @Override
    @Test
    public void makeString() {
        super.makeString();
        ImmutableDoubleList list = this.classUnderTest();
        StringBuilder expectedString = new StringBuilder();
        StringBuilder expectedString1 = new StringBuilder();
        int size = list.size();
        for (double each = 0; each < size; each++) {
            expectedString.append((double) (each + 1.0));
            expectedString1.append((double) (each + 1.0));
            expectedString.append((int) each == size - 1 ? "" : ", ");
            expectedString1.append((int) each == size - 1 ? "" : "/");
        }
        Assert.assertEquals(expectedString.toString(), list.makeString());
        Assert.assertEquals(expectedString1.toString(), list.makeString("/"));
        Assert.assertEquals(this.classUnderTest().toString(), this.classUnderTest().makeString("[", ", ", "]"));
    }

    @Override
    @Test
    public void appendString() {
        super.appendString();
        StringBuilder expectedString = new StringBuilder();
        StringBuilder expectedString1 = new StringBuilder();
        int size = this.classUnderTest().size();
        for (double each = 0; each < size; each++) {
            expectedString.append((double) (each + 1.0));
            expectedString1.append((double) (each + 1.0));
            expectedString.append((int) each == size - 1 ? "" : ", ");
            expectedString1.append((int) each == size - 1 ? "" : "/");
        }
        ImmutableDoubleList list = this.classUnderTest();
        StringBuilder appendable2 = new StringBuilder();
        list.appendString(appendable2);
        Assert.assertEquals(expectedString.toString(), appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        list.appendString(appendable3, "/");
        Assert.assertEquals(expectedString1.toString(), appendable3.toString());
        StringBuilder appendable4 = new StringBuilder();
        this.classUnderTest().appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(this.classUnderTest().toString(), appendable4.toString());
    }

    @Override
    @Test
    public void toList() {
        super.toList();
        ImmutableDoubleList immutableList = this.classUnderTest();
        MutableDoubleList list = immutableList.toList();
        Verify.assertEqualsAndHashCode(immutableList, list);
        Assert.assertNotSame(immutableList, list);
    }

    @Test
    public void zipDouble() {
        ImmutableDoubleList list1 = this.newWith(1.0, 2.0, 3.0);
        ImmutableDoubleList list2 = this.newWith(1.0);
        ImmutableList<DoubleDoublePair> zipSame = list1.zipDouble(list1);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1.0, 1.0), PrimitiveTuples.pair(2.0, 2.0), PrimitiveTuples.pair(3.0, 3.0)), zipSame);
        ImmutableList<DoubleDoublePair> zipSameLazy = list1.zipDouble(list1.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1.0, 1.0), PrimitiveTuples.pair(2.0, 2.0), PrimitiveTuples.pair(3.0, 3.0)), zipSameLazy);
        ImmutableList<DoubleDoublePair> zipLess = list1.zipDouble(list2);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1.0, 1.0)), zipLess);
        ImmutableList<DoubleDoublePair> zipLessLazy = list1.zipDouble(list2.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1.0, 1.0)), zipLessLazy);
        ImmutableList<DoubleDoublePair> zipMore = list2.zipDouble(list1);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1.0, 1.0)), zipMore);
        ImmutableList<DoubleDoublePair> zipMoreLazy = list2.zipDouble(list1.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1.0, 1.0)), zipMoreLazy);
        ImmutableList<DoubleDoublePair> zipEmpty1 = list1.zipDouble(this.newWith());
        Assert.assertTrue(zipEmpty1.isEmpty());
        ImmutableList<DoubleDoublePair> zipEmpty2 = this.newWith().zipDouble(list1);
        Assert.assertTrue(zipEmpty2.isEmpty());
    }

    @Test
    public void zip() {
        ImmutableDoubleList list1 = this.newWith(1.0, 2.0, 3.0);
        ImmutableDoubleList list2 = this.newWith(1.0);
        ImmutableList<String> list3 = Lists.immutable.with("1", "2", "3");
        ImmutableList<String> list4 = Lists.immutable.with("1");
        ImmutableList<DoubleObjectPair<String>> zipSame = list1.zip(list3);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1.0, "1"), PrimitiveTuples.pair(2.0, "2"), PrimitiveTuples.pair(3.0, "3")), zipSame);
        ImmutableList<DoubleObjectPair<String>> zipSameLazy = list1.zip(list3.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1.0, "1"), PrimitiveTuples.pair(2.0, "2"), PrimitiveTuples.pair(3.0, "3")), zipSameLazy);
        ImmutableList<DoubleObjectPair<String>> zipLess = list1.zip(list4);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1.0, "1")), zipLess);
        ImmutableList<DoubleObjectPair<String>> zipLessLazy = list1.zip(list4.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1.0, "1")), zipLessLazy);
        ImmutableList<DoubleObjectPair<String>> zipMore = list2.zip(list3);
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1.0, "1")), zipMore);
        ImmutableList<DoubleObjectPair<String>> zipMoreLazy = list2.zip(list3.asLazy());
        Assert.assertEquals(Lists.immutable.with(PrimitiveTuples.pair(1.0, "1")), zipMoreLazy);
        ImmutableList<DoubleObjectPair<String>> zipEmpty1 = list1.zip(Lists.immutable.empty());
        Assert.assertTrue(zipEmpty1.isEmpty());
        ImmutableList<DoubleObjectPair<String>> zipEmpty2 = this.newWith().zip(Lists.immutable.with("1", "2"));
        Assert.assertTrue(zipEmpty2.isEmpty());
    }

    @Test
    public void stream() {
        Assert.assertEquals(Collections.emptyList(), DoubleLists.immutable.empty().primitiveStream().boxed().collect(Collectors.toList()));
        Assert.assertEquals(Collections.singletonList(1.0), this.newWith(1.0).primitiveStream().boxed().collect(Collectors.toList()));
        Assert.assertEquals(Arrays.asList(1.0, 2.0, 3.0), ImmutableDoubleArrayList.newListWith(1.0, 2.0, 3.0).primitiveStream().boxed().collect(Collectors.toList()));
    }

    @Test
    public void parallelStream() {
        Assert.assertEquals(Collections.emptyList(), DoubleLists.immutable.empty().primitiveParallelStream().boxed().collect(Collectors.toList()));
        Assert.assertEquals(Collections.singletonList(1.0), this.newWith(1.0).primitiveParallelStream().boxed().collect(Collectors.toList()));
        Assert.assertEquals(Arrays.asList(1.0, 2.0, 3.0), ImmutableDoubleArrayList.newListWith(1.0, 2.0, 3.0).primitiveParallelStream().boxed().collect(Collectors.toList()));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableDoubleListTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NaN);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NEGATIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_POSITIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_zero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_zero);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals_NaN);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_different_NaNs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_different_NaNs);
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
        public void benchmark_containsAnyArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
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
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectIterableWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectIterableWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToLists() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToLists);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToSets() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToSets);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
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
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summaryStatistics() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summaryStatistics);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArrayWithTargetArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArrayWithTargetArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionNaturalOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionNaturalOrder);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionWithComparator);
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
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
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
        public void benchmark_reduceOnEmptyThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOnEmptyThrows);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduce() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduce);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get_throws_index_greater_than_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get_throws_index_negative);
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
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lastIndexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lastIndexOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
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
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toReversed);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
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
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableDoubleListTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> doubleIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> doubleIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> zipDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleListTestCase> parallelStream;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractImmutableDoubleListTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractImmutableDoubleListTestCase::newCollection;
            this.payloads.isEmpty = AbstractImmutableDoubleListTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableDoubleListTestCase::notEmpty;
            this.payloads.tap = AbstractImmutableDoubleListTestCase::tap;
            this.payloads.contains = AbstractImmutableDoubleListTestCase::contains;
            this.payloads.contains_NaN = AbstractImmutableDoubleListTestCase::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = AbstractImmutableDoubleListTestCase::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = AbstractImmutableDoubleListTestCase::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = AbstractImmutableDoubleListTestCase::contains_zero;
            this.payloads.testEquals_NaN = AbstractImmutableDoubleListTestCase::testEquals_NaN;
            this.payloads.contains_different_NaNs = AbstractImmutableDoubleListTestCase::contains_different_NaNs;
            this.payloads.containsAllArray = AbstractImmutableDoubleListTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractImmutableDoubleListTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractImmutableDoubleListTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractImmutableDoubleListTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractImmutableDoubleListTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractImmutableDoubleListTestCase::containsNoneIterable;
            this.payloads.doubleIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleListTestCase::doubleIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.doubleIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleListTestCase::doubleIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractImmutableDoubleListTestCase::forEach;
            this.payloads.size = AbstractImmutableDoubleListTestCase::size;
            this.payloads.count = AbstractImmutableDoubleListTestCase::count;
            this.payloads.anySatisfy = AbstractImmutableDoubleListTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractImmutableDoubleListTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractImmutableDoubleListTestCase::noneSatisfy;
            this.payloads.collect = AbstractImmutableDoubleListTestCase::collect;
            this.payloads.collectWithTarget = AbstractImmutableDoubleListTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractImmutableDoubleListTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractImmutableDoubleListTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractImmutableDoubleListTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractImmutableDoubleListTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractImmutableDoubleListTestCase::select;
            this.payloads.selectWithTarget = AbstractImmutableDoubleListTestCase::selectWithTarget;
            this.payloads.reject = AbstractImmutableDoubleListTestCase::reject;
            this.payloads.rejectWithTarget = AbstractImmutableDoubleListTestCase::rejectWithTarget;
            this.payloads.detectIfNone = AbstractImmutableDoubleListTestCase::detectIfNone;
            this.payloads.max = AbstractImmutableDoubleListTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleListTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractImmutableDoubleListTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleListTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractImmutableDoubleListTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractImmutableDoubleListTestCase::maxIfEmpty;
            this.payloads.sum = AbstractImmutableDoubleListTestCase::sum;
            this.payloads.summaryStatistics = AbstractImmutableDoubleListTestCase::summaryStatistics;
            this.payloads.sumConsistentRounding = AbstractImmutableDoubleListTestCase::sumConsistentRounding;
            this.payloads.average = AbstractImmutableDoubleListTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleListTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractImmutableDoubleListTestCase::averageIfEmpty;
            this.payloads.median = AbstractImmutableDoubleListTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleListTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractImmutableDoubleListTestCase::medianIfEmpty;
            this.payloads.toArrayWithTargetArray = AbstractImmutableDoubleListTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractImmutableDoubleListTestCase::toSortedArray;
            this.payloads.testHashCode = AbstractImmutableDoubleListTestCase::testHashCode;
            this.payloads.toSortedList = AbstractImmutableDoubleListTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractImmutableDoubleListTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractImmutableDoubleListTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractImmutableDoubleListTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractImmutableDoubleListTestCase::toSet;
            this.payloads.toBag = AbstractImmutableDoubleListTestCase::toBag;
            this.payloads.asLazy = AbstractImmutableDoubleListTestCase::asLazy;
            this.payloads.injectIntoBoolean = AbstractImmutableDoubleListTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractImmutableDoubleListTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractImmutableDoubleListTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractImmutableDoubleListTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractImmutableDoubleListTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractImmutableDoubleListTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractImmutableDoubleListTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractImmutableDoubleListTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleListTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractImmutableDoubleListTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractImmutableDoubleListTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractImmutableDoubleListTestCase::chunk;
            this.payloads.testNewWith = AbstractImmutableDoubleListTestCase::testNewWith;
            this.payloads.newWithAll = AbstractImmutableDoubleListTestCase::newWithAll;
            this.payloads.newWithout = AbstractImmutableDoubleListTestCase::newWithout;
            this.payloads.newWithoutAll = AbstractImmutableDoubleListTestCase::newWithoutAll;
            this.payloads.get = AbstractImmutableDoubleListTestCase::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleListTestCase::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleListTestCase::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = AbstractImmutableDoubleListTestCase::getFirst;
            this.payloads.getLast = AbstractImmutableDoubleListTestCase::getLast;
            this.payloads.indexOf = AbstractImmutableDoubleListTestCase::indexOf;
            this.payloads.lastIndexOf = AbstractImmutableDoubleListTestCase::lastIndexOf;
            this.payloads.doubleIterator = AbstractImmutableDoubleListTestCase::doubleIterator;
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleListTestCase::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.toArray = AbstractImmutableDoubleListTestCase::toArray;
            this.payloads.injectInto = AbstractImmutableDoubleListTestCase::injectInto;
            this.payloads.injectIntoWithIndex = AbstractImmutableDoubleListTestCase::injectIntoWithIndex;
            this.payloads.selectWithIndex = AbstractImmutableDoubleListTestCase::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = AbstractImmutableDoubleListTestCase::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = AbstractImmutableDoubleListTestCase::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = AbstractImmutableDoubleListTestCase::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = AbstractImmutableDoubleListTestCase::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = AbstractImmutableDoubleListTestCase::collectWithIndexWithTarget;
            this.payloads.distinct = AbstractImmutableDoubleListTestCase::distinct;
            this.payloads.toReversed = AbstractImmutableDoubleListTestCase::toReversed;
            this.payloads.forEachWithIndex = AbstractImmutableDoubleListTestCase::forEachWithIndex;
            this.payloads.testEquals = AbstractImmutableDoubleListTestCase::testEquals;
            this.payloads.testToString = AbstractImmutableDoubleListTestCase::testToString;
            this.payloads.makeString = AbstractImmutableDoubleListTestCase::makeString;
            this.payloads.appendString = AbstractImmutableDoubleListTestCase::appendString;
            this.payloads.toList = AbstractImmutableDoubleListTestCase::toList;
            this.payloads.zipDouble = AbstractImmutableDoubleListTestCase::zipDouble;
            this.payloads.zip = AbstractImmutableDoubleListTestCase::zip;
            this.payloads.stream = AbstractImmutableDoubleListTestCase::stream;
            this.payloads.parallelStream = AbstractImmutableDoubleListTestCase::parallelStream;
        }
    }
}
