/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.fixed;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.multimap.MutableMultimap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.Twin;
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.block.factory.Procedures2;
import org.eclipse.collections.impl.block.function.NegativeIntervalFunction;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.multimap.set.UnifiedSetMultimap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.mSet;

/**
 * JUnit test for {@link DoubletonSet}.
 */
public class DoubletonSetTest extends AbstractMemoryEfficientMutableSetTestCase {

    private DoubletonSet<String> set;

    @Before
    public void setUp() {
        this.set = new DoubletonSet<>("1", "2");
    }

    @Override
    protected MutableSet<String> classUnderTest() {
        return new DoubletonSet<>("1", "2");
    }

    @Override
    protected MutableSet<String> classUnderTestWithNull() {
        return new DoubletonSet<>(null, "2");
    }

    @Test
    public void nonUniqueWith() {
        Twin<String> twin1 = Tuples.twin("1", "1");
        Twin<String> twin2 = Tuples.twin("2", "2");
        DoubletonSet<Twin<String>> set = new DoubletonSet<>(twin1, twin2);
        Twin<String> twin3 = Tuples.twin("1", "1");
        set.with(twin3);
        Assert.assertSame(set.getFirst(), twin1);
        Twin<String> twin4 = Tuples.twin("2", "2");
        set.with(twin4);
        Assert.assertSame(set.getLast(), twin2);
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        MutableSet<String> one = Sets.fixedSize.of("1", "2");
        Verify.assertEqualsAndHashCode(one, mSet("1", "2"));
        Verify.assertPostSerializedEqualsAndHashCode(one);
    }

    @Test
    public void remove() {
        try {
            this.set.remove("1");
            Assert.fail("Cannot remove from DoubletonSet");
        } catch (UnsupportedOperationException ignored) {
            this.assertUnchanged();
        }
    }

    @Test
    public void addDuplicate() {
        try {
            this.set.add("1");
            Assert.fail("Cannot add to DoubletonSet");
        } catch (UnsupportedOperationException ignored) {
            this.assertUnchanged();
        }
    }

    @Test
    public void add() {
        try {
            this.set.add("3");
            Assert.fail("Cannot add to DoubletonSet");
        } catch (UnsupportedOperationException ignored) {
            this.assertUnchanged();
        }
    }

    @Test
    public void addingAllToOtherSet() {
        MutableSet<String> newSet = UnifiedSet.newSet(Sets.fixedSize.of("1", "2"));
        newSet.add("3");
        Verify.assertContainsAll(newSet, "1", "2", "3");
    }

    private void assertUnchanged() {
        Verify.assertSize(2, this.set);
        Verify.assertContainsAll(this.set, "1", "2");
        Verify.assertNotContains("3", this.set);
    }

    @Override
    @Test
    public void testClone() {
        try {
            Verify.assertShallowClone(this.set);
        } catch (Exception e) {
            // Suppress if a Java 9 specific exception related to reflection is thrown.
            if (!e.getClass().getCanonicalName().equals("java.lang.reflect.InaccessibleObjectException")) {
                throw e;
            }
        }
        MutableSet<String> cloneSet = this.set.clone();
        Assert.assertNotSame(cloneSet, this.set);
        Assert.assertEquals(UnifiedSet.newSetWith("1", "2"), cloneSet);
    }

    @Test
    public void newEmpty() {
        MutableSet<String> newEmpty = this.set.newEmpty();
        Verify.assertInstanceOf(UnifiedSet.class, newEmpty);
        Verify.assertEmpty(newEmpty);
    }

    @Test
    public void getLast() {
        Assert.assertEquals("2", this.set.getLast());
    }

    @Test
    public void forEach() {
        MutableList<String> result = Lists.mutable.of();
        MutableSet<String> source = Sets.fixedSize.of("1", "2");
        source.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(FastList.newListWith("1", "2"), result);
    }

    @Test
    public void forEachWithIndex() {
        int[] indexSum = new int[1];
        MutableList<String> result = Lists.mutable.of();
        MutableSet<String> source = Sets.fixedSize.of("1", "2");
        source.forEachWithIndex((each, index) -> {
            result.add(each);
            indexSum[0] += index;
        });
        Assert.assertEquals(FastList.newListWith("1", "2"), result);
        Assert.assertEquals(1, indexSum[0]);
    }

    @Test
    public void forEachWith() {
        MutableList<String> result = Lists.mutable.of();
        MutableSet<String> source = Sets.fixedSize.of("1", "2");
        source.forEachWith(Procedures2.fromProcedure(CollectionAddProcedure.on(result)), null);
        Assert.assertEquals(FastList.newListWith("1", "2"), result);
    }

    @Test
    public void getFirstGetLast() {
        MutableSet<String> source = Sets.fixedSize.of("1", "2");
        Assert.assertEquals("1", source.getFirst());
        Assert.assertEquals("2", source.getLast());
    }

    @Override
    @Test
    public void groupByEach() {
        super.groupByEach();
        MutableSet<Integer> set = Sets.fixedSize.of(1, 2);
        MutableMultimap<Integer, Integer> expected = UnifiedSetMultimap.newMultimap();
        set.forEach(Procedures.cast(value -> expected.putAll(-value, Interval.fromTo(value, set.size()))));
        Multimap<Integer, Integer> actual = set.groupByEach(new NegativeIntervalFunction());
        Assert.assertEquals(expected, actual);
        Multimap<Integer, Integer> actualWithTarget = set.groupByEach(new NegativeIntervalFunction(), UnifiedSetMultimap.newMultimap());
        Assert.assertEquals(expected, actualWithTarget);
    }

    @Test
    public void getOnly() {
        Assert.assertThrows(IllegalStateException.class, () -> this.set.getOnly());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public DoubletonSetTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add_duplicate_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add_duplicate_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllIterable_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllIterable_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllIterable_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllIterable_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIfWith_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIfWith_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorRemove_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorRemove_throws);
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
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterationWithIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterationWithIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorWillGetUpsetIfYouPushItTooFar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorWillGetUpsetIfYouPushItTooFar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
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
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
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
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_without_comparator);
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
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_union() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.union);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unionInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.unionInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_difference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.difference);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_differenceInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.differenceInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifference);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifferenceInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifferenceInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isSubsetOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isProperSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isProperSubsetOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_powerSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.powerSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProduct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_nonUniqueWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.nonUniqueWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addDuplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addDuplicate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addingAllToOtherSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addingAllToOtherSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
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
        public void benchmark_getFirstGetLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirstGetLast);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> payload) throws java.lang.Throwable {
            this.instance = new DoubletonSetTest();
            this.instance.setUp();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> addAll_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> addAllIterable_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> add_duplicate_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> add_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> removeAll_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> removeAllIterable_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> retainAll_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> retainAllIterable_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> clear_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> removeIf_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> removeIfWith_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> iteratorRemove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> iterationWithIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> iteratorWillGetUpsetIfYouPushItTooFar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> unionInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> intersectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> differenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> symmetricDifferenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> powerSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> nonUniqueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> addDuplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> addingAllToOtherSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> getFirstGetLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonSetTest> getOnly;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.asSynchronized = DoubletonSetTest::asSynchronized;
            this.payloads.remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubletonSetTest::remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubletonSetTest::addAll_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllIterable_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubletonSetTest::addAllIterable_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.add_duplicate_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubletonSetTest::add_duplicate_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.add_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubletonSetTest::add_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubletonSetTest::removeAll_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllIterable_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubletonSetTest::removeAllIterable_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubletonSetTest::retainAll_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAllIterable_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubletonSetTest::retainAllIterable_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.clear_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubletonSetTest::clear_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubletonSetTest::removeIf_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIfWith_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubletonSetTest::removeIfWith_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.iterator = DoubletonSetTest::iterator;
            this.payloads.iteratorRemove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubletonSetTest::iteratorRemove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubletonSetTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubletonSetTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubletonSetTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubletonSetTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.iterationWithIterator = DoubletonSetTest::iterationWithIterator;
            this.payloads.iteratorWillGetUpsetIfYouPushItTooFar = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubletonSetTest::iteratorWillGetUpsetIfYouPushItTooFar, java.util.NoSuchElementException.class);
            this.payloads.groupBy = DoubletonSetTest::groupBy;
            this.payloads.zip = DoubletonSetTest::zip;
            this.payloads.zipWithIndex = DoubletonSetTest::zipWithIndex;
            this.payloads.asUnmodifiable = DoubletonSetTest::asUnmodifiable;
            this.payloads.toImmutable = DoubletonSetTest::toImmutable;
            this.payloads.min = DoubletonSetTest::min;
            this.payloads.max = DoubletonSetTest::max;
            this.payloads.min_without_comparator = DoubletonSetTest::min_without_comparator;
            this.payloads.max_without_comparator = DoubletonSetTest::max_without_comparator;
            this.payloads.minBy = DoubletonSetTest::minBy;
            this.payloads.maxBy = DoubletonSetTest::maxBy;
            this.payloads.chunk = DoubletonSetTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubletonSetTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = DoubletonSetTest::chunk_large_size;
            this.payloads.union = DoubletonSetTest::union;
            this.payloads.unionInto = DoubletonSetTest::unionInto;
            this.payloads.intersect = DoubletonSetTest::intersect;
            this.payloads.intersectInto = DoubletonSetTest::intersectInto;
            this.payloads.difference = DoubletonSetTest::difference;
            this.payloads.differenceInto = DoubletonSetTest::differenceInto;
            this.payloads.symmetricDifference = DoubletonSetTest::symmetricDifference;
            this.payloads.symmetricDifferenceInto = DoubletonSetTest::symmetricDifferenceInto;
            this.payloads.isSubsetOf = DoubletonSetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = DoubletonSetTest::isProperSubsetOf;
            this.payloads.powerSet = DoubletonSetTest::powerSet;
            this.payloads.cartesianProduct = DoubletonSetTest::cartesianProduct;
            this.payloads.with = DoubletonSetTest::with;
            this.payloads.withAll = DoubletonSetTest::withAll;
            this.payloads.without = DoubletonSetTest::without;
            this.payloads.withoutAll = DoubletonSetTest::withoutAll;
            this.payloads.nonUniqueWith = DoubletonSetTest::nonUniqueWith;
            this.payloads.equalsAndHashCode = DoubletonSetTest::equalsAndHashCode;
            this.payloads.remove = DoubletonSetTest::remove;
            this.payloads.addDuplicate = DoubletonSetTest::addDuplicate;
            this.payloads.add = DoubletonSetTest::add;
            this.payloads.addingAllToOtherSet = DoubletonSetTest::addingAllToOtherSet;
            this.payloads.testClone = DoubletonSetTest::testClone;
            this.payloads.newEmpty = DoubletonSetTest::newEmpty;
            this.payloads.getLast = DoubletonSetTest::getLast;
            this.payloads.forEach = DoubletonSetTest::forEach;
            this.payloads.forEachWithIndex = DoubletonSetTest::forEachWithIndex;
            this.payloads.forEachWith = DoubletonSetTest::forEachWith;
            this.payloads.getFirstGetLast = DoubletonSetTest::getFirstGetLast;
            this.payloads.groupByEach = DoubletonSetTest::groupByEach;
            this.payloads.getOnly = DoubletonSetTest::getOnly;
        }
    }
}
