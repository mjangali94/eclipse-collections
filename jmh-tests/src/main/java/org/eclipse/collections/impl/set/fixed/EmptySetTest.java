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

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.multimap.set.MutableSetMultimap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmptySetTest extends AbstractMemoryEfficientMutableSetTestCase {

    private EmptySet<Object> emptySet;

    @Before
    public void setUp() {
        this.emptySet = new EmptySet<>();
    }

    @Override
    protected MutableSet<String> classUnderTest() {
        return new EmptySet<>();
    }

    @Override
    protected MutableSet<String> classUnderTestWithNull() {
        throw new AssertionError();
    }

    @Test
    public void testEmpty() {
        Assert.assertTrue(this.emptySet.isEmpty());
        Assert.assertFalse(this.emptySet.notEmpty());
        Assert.assertTrue(Sets.fixedSize.of().isEmpty());
        Assert.assertFalse(Sets.fixedSize.of().notEmpty());
    }

    @Test
    public void testSize() {
        Verify.assertSize(0, this.emptySet);
    }

    @Test
    public void testContains() {
        Assert.assertFalse(this.emptySet.contains("Something"));
        Assert.assertFalse(this.emptySet.contains(null));
    }

    @Test
    public void testGetFirstLast() {
        Assert.assertNull(this.emptySet.getFirst());
        Assert.assertNull(this.emptySet.getLast());
    }

    @Test
    public void testReadResolve() {
        Verify.assertInstanceOf(EmptySet.class, Sets.fixedSize.of());
        Verify.assertPostSerializedIdentity(Sets.fixedSize.of());
    }

    @Override
    @Test
    public void testClone() {
        Assert.assertSame(Sets.fixedSize.of().clone(), Sets.fixedSize.of());
    }

    @Test
    public void testForEach() {
        this.emptySet.forEach(Procedures.cast(each -> Assert.fail()));
    }

    @Test
    public void testForEachWithIndex() {
        this.emptySet.forEachWithIndex((each, index) -> Assert.fail());
    }

    @Test
    public void testForEachWith() {
        this.emptySet.forEachWith((argument1, argument2) -> Assert.fail(), "param");
    }

    @Test
    public void testIterator() {
        Iterator<Object> it = this.emptySet.iterator();
        Assert.assertFalse(it.hasNext());
        Assert.assertThrows(NoSuchElementException.class, it::next);
        Assert.assertThrows(UnsupportedOperationException.class, it::remove);
    }

    @Test
    @Override
    public void groupBy() {
        MutableSetMultimap<Class<?>, String> multimap = this.classUnderTest().groupBy(Object::getClass);
        Verify.assertSize(this.classUnderTest().size(), multimap);
        Assert.assertTrue(multimap.keysView().isEmpty());
        Assert.assertEquals(this.classUnderTest(), multimap.get(String.class));
    }

    @Test(expected = NoSuchElementException.class)
    @Override
    public void min() {
        this.classUnderTest().min(String::compareTo);
    }

    @Test(expected = NoSuchElementException.class)
    @Override
    public void max() {
        this.classUnderTest().max(String::compareTo);
    }

    @Test
    @Override
    public void min_null_throws() {
        // Not applicable for empty collections
    }

    @Test
    @Override
    public void max_null_throws() {
        // Not applicable for empty collections
    }

    @Test(expected = NoSuchElementException.class)
    @Override
    public void min_without_comparator() {
        this.classUnderTest().min();
    }

    @Test(expected = NoSuchElementException.class)
    @Override
    public void max_without_comparator() {
        this.classUnderTest().max();
    }

    @Test
    @Override
    public void min_null_throws_without_comparator() {
        // Not applicable for empty collections
    }

    @Test
    @Override
    public void max_null_throws_without_comparator() {
        // Not applicable for empty collections
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void minBy() {
        this.classUnderTest().minBy(String::valueOf);
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void maxBy() {
        this.classUnderTest().maxBy(String::valueOf);
    }

    @Override
    @Test
    public void zip() {
        MutableSet<String> set = this.classUnderTest();
        List<Object> nulls = Collections.nCopies(set.size(), null);
        List<Object> nullsPlusOne = Collections.nCopies(set.size() + 1, null);
        MutableSet<Pair<String, Object>> pairs = set.zip(nulls);
        Assert.assertEquals(set, pairs.collect((Function<Pair<String, ?>, String>) Pair::getOne));
        Assert.assertEquals(nulls, pairs.collect((Function<Pair<?, Object>, Object>) Pair::getTwo, Lists.mutable.of()));
        MutableSet<Pair<String, Object>> pairsPlusOne = set.zip(nullsPlusOne);
        Assert.assertEquals(set, pairsPlusOne.collect((Function<Pair<String, ?>, String>) Pair::getOne));
        Assert.assertEquals(nulls, pairsPlusOne.collect((Function<Pair<?, Object>, Object>) Pair::getTwo, Lists.mutable.of()));
        Assert.assertEquals(set.zip(nulls), set.zip(nulls, UnifiedSet.newSet()));
    }

    @Override
    @Test
    public void zipWithIndex() {
        MutableSet<String> set = this.classUnderTest();
        MutableSet<Pair<String, Integer>> pairs = set.zipWithIndex();
        Assert.assertEquals(set, pairs.collect((Function<Pair<String, ?>, String>) Pair::getOne));
        Assert.assertEquals(UnifiedSet.newSet(), pairs.collect((Function<Pair<?, Integer>, Integer>) Pair::getTwo));
        Assert.assertEquals(set.zipWithIndex(), set.zipWithIndex(UnifiedSet.newSet()));
    }

    @Override
    @Test
    public void chunk_large_size() {
        Assert.assertEquals(Lists.mutable.of(), this.classUnderTest().chunk(10));
    }

    @Override
    @Test
    public void union() {
        Assert.assertEquals(UnifiedSet.newSetWith("a", "b", "c"), this.classUnderTest().union(UnifiedSet.newSetWith("a", "b", "c")));
    }

    @Override
    @Test
    public void unionInto() {
        Assert.assertEquals(UnifiedSet.newSetWith("a", "b", "c"), this.classUnderTest().unionInto(UnifiedSet.newSetWith("a", "b", "c"), UnifiedSet.newSet()));
    }

    @Override
    @Test
    public void intersect() {
        Assert.assertEquals(UnifiedSet.<String>newSet(), this.classUnderTest().intersect(UnifiedSet.newSetWith("1", "2", "3")));
    }

    @Override
    @Test
    public void intersectInto() {
        Assert.assertEquals(UnifiedSet.<String>newSet(), this.classUnderTest().intersectInto(UnifiedSet.newSetWith("1", "2", "3"), UnifiedSet.newSet()));
    }

    @Override
    @Test
    public void difference() {
        MutableSet<String> set = this.classUnderTest();
        MutableSet<String> difference = set.difference(UnifiedSet.newSetWith("2", "3", "4", "not present"));
        Assert.assertEquals(UnifiedSet.<String>newSet(), difference);
        Assert.assertEquals(set, set.difference(UnifiedSet.newSetWith("not present")));
    }

    @Override
    @Test
    public void differenceInto() {
        MutableSet<String> set = this.classUnderTest();
        MutableSet<String> difference = set.differenceInto(UnifiedSet.newSetWith("2", "3", "4", "not present"), UnifiedSet.newSet());
        Assert.assertEquals(UnifiedSet.<String>newSet(), difference);
        Assert.assertEquals(set, set.differenceInto(UnifiedSet.newSetWith("not present"), UnifiedSet.newSet()));
    }

    @Override
    @Test
    public void symmetricDifference() {
        Assert.assertEquals(UnifiedSet.newSetWith("not present"), this.classUnderTest().symmetricDifference(UnifiedSet.newSetWith("not present")));
    }

    @Override
    @Test
    public void symmetricDifferenceInto() {
        Assert.assertEquals(UnifiedSet.newSetWith("not present"), this.classUnderTest().symmetricDifferenceInto(UnifiedSet.newSetWith("not present"), UnifiedSet.newSet()));
    }

    @Test
    public void getOnly() {
        Assert.assertThrows(IllegalStateException.class, () -> this.emptySet.getOnly());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public EmptySetTest instance;

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
        public void benchmark_iterationWithIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterationWithIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorWillGetUpsetIfYouPushItTooFar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorWillGetUpsetIfYouPushItTooFar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
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
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
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
        public void benchmark_testEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSize);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testContains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testContains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testGetFirstLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testGetFirstLast);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testReadResolve() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testReadResolve);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testForEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testForEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testForEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testForEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testForEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
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
        public void benchmark_min_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws);
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
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws_without_comparator);
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
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
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
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> payload) throws java.lang.Throwable {
            this.instance = new EmptySetTest();
            this.instance.setUp();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> addAll_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> addAllIterable_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> add_duplicate_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> add_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> removeAll_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> removeAllIterable_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> retainAll_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> retainAllIterable_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> clear_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> removeIf_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> removeIfWith_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> iteratorRemove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> iterationWithIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> iteratorWillGetUpsetIfYouPushItTooFar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> powerSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> testEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> testSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> testContains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> testGetFirstLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> testReadResolve;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> testForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> testForEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> testForEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> testIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> unionInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> intersectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> differenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> symmetricDifferenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<EmptySetTest> getOnly;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.asSynchronized = EmptySetTest::asSynchronized;
            this.payloads.remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptySetTest::remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptySetTest::addAll_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllIterable_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptySetTest::addAllIterable_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.add_duplicate_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptySetTest::add_duplicate_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.add_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptySetTest::add_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptySetTest::removeAll_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllIterable_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptySetTest::removeAllIterable_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptySetTest::retainAll_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAllIterable_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptySetTest::retainAllIterable_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.clear_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptySetTest::clear_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptySetTest::removeIf_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIfWith_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptySetTest::removeIfWith_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.iterator = EmptySetTest::iterator;
            this.payloads.iteratorRemove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptySetTest::iteratorRemove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.iterationWithIterator = EmptySetTest::iterationWithIterator;
            this.payloads.iteratorWillGetUpsetIfYouPushItTooFar = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptySetTest::iteratorWillGetUpsetIfYouPushItTooFar, java.util.NoSuchElementException.class);
            this.payloads.equalsAndHashCode = EmptySetTest::equalsAndHashCode;
            this.payloads.groupByEach = EmptySetTest::groupByEach;
            this.payloads.asUnmodifiable = EmptySetTest::asUnmodifiable;
            this.payloads.toImmutable = EmptySetTest::toImmutable;
            this.payloads.chunk = EmptySetTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptySetTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.isSubsetOf = EmptySetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = EmptySetTest::isProperSubsetOf;
            this.payloads.powerSet = EmptySetTest::powerSet;
            this.payloads.cartesianProduct = EmptySetTest::cartesianProduct;
            this.payloads.with = EmptySetTest::with;
            this.payloads.withAll = EmptySetTest::withAll;
            this.payloads.without = EmptySetTest::without;
            this.payloads.withoutAll = EmptySetTest::withoutAll;
            this.payloads.testEmpty = EmptySetTest::testEmpty;
            this.payloads.testSize = EmptySetTest::testSize;
            this.payloads.testContains = EmptySetTest::testContains;
            this.payloads.testGetFirstLast = EmptySetTest::testGetFirstLast;
            this.payloads.testReadResolve = EmptySetTest::testReadResolve;
            this.payloads.testClone = EmptySetTest::testClone;
            this.payloads.testForEach = EmptySetTest::testForEach;
            this.payloads.testForEachWithIndex = EmptySetTest::testForEachWithIndex;
            this.payloads.testForEachWith = EmptySetTest::testForEachWith;
            this.payloads.testIterator = EmptySetTest::testIterator;
            this.payloads.groupBy = EmptySetTest::groupBy;
            this.payloads.min = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptySetTest::min, java.util.NoSuchElementException.class);
            this.payloads.max = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptySetTest::max, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = EmptySetTest::min_null_throws;
            this.payloads.max_null_throws = EmptySetTest::max_null_throws;
            this.payloads.min_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptySetTest::min_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptySetTest::max_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws_without_comparator = EmptySetTest::min_null_throws_without_comparator;
            this.payloads.max_null_throws_without_comparator = EmptySetTest::max_null_throws_without_comparator;
            this.payloads.minBy = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptySetTest::minBy, java.util.NoSuchElementException.class);
            this.payloads.maxBy = new se.chalmers.ju2jmh.api.ExceptionTest<>(EmptySetTest::maxBy, java.util.NoSuchElementException.class);
            this.payloads.zip = EmptySetTest::zip;
            this.payloads.zipWithIndex = EmptySetTest::zipWithIndex;
            this.payloads.chunk_large_size = EmptySetTest::chunk_large_size;
            this.payloads.union = EmptySetTest::union;
            this.payloads.unionInto = EmptySetTest::unionInto;
            this.payloads.intersect = EmptySetTest::intersect;
            this.payloads.intersectInto = EmptySetTest::intersectInto;
            this.payloads.difference = EmptySetTest::difference;
            this.payloads.differenceInto = EmptySetTest::differenceInto;
            this.payloads.symmetricDifference = EmptySetTest::symmetricDifference;
            this.payloads.symmetricDifferenceInto = EmptySetTest::symmetricDifferenceInto;
            this.payloads.getOnly = EmptySetTest::getOnly;
        }
    }
}
