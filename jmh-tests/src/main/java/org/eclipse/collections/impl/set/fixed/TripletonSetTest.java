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
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.Twin;
import org.eclipse.collections.impl.block.factory.Procedures2;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test for {@link TripletonSet}.
 */
public class TripletonSetTest extends AbstractMemoryEfficientMutableSetTestCase {

    private TripletonSet<String> set;

    @Before
    public void setUp() {
        this.set = new TripletonSet<>("1", "2", "3");
    }

    @Override
    protected MutableSet<String> classUnderTest() {
        return new TripletonSet<>("1", "2", "3");
    }

    @Override
    protected MutableSet<String> classUnderTestWithNull() {
        return new TripletonSet<>(null, "2", "3");
    }

    @Test
    public void nonUniqueWith() {
        Twin<String> twin1 = Tuples.twin("1", "1");
        Twin<String> twin2 = Tuples.twin("2", "2");
        Twin<String> twin3 = Tuples.twin("3", "3");
        TripletonSet<Twin<String>> set = new TripletonSet<>(twin1, twin2, twin3);
        set.with(Tuples.twin("1", "1"));
        set.with(Tuples.twin("2", "2"));
        set.with(Tuples.twin("3", "3"));
        Assert.assertSame(set.getFirst(), twin1);
        Assert.assertSame(set.getSecond(), twin2);
        Assert.assertSame(set.getLast(), twin3);
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        MutableSet<String> one = Sets.fixedSize.of("1", "2", "3");
        MutableSet<String> oneA = UnifiedSet.newSetWith("1", "2", "3");
        Verify.assertEqualsAndHashCode(one, oneA);
        Verify.assertPostSerializedEqualsAndHashCode(one);
    }

    @Test
    public void contains() {
        Verify.assertContainsAll(this.set, "1", "2", "3");
        Verify.assertNotContains("4", this.set);
    }

    @Test
    public void remove() {
        try {
            this.set.remove("1");
            Assert.fail("Cannot remove from TripletonSet");
        } catch (UnsupportedOperationException ignored) {
            this.assertUnchanged();
        }
    }

    @Test
    public void addDuplicate() {
        try {
            this.set.add("1");
            Assert.fail("Cannot add to TripletonSet");
        } catch (UnsupportedOperationException ignored) {
            this.assertUnchanged();
        }
    }

    @Test
    public void add() {
        try {
            this.set.add("4");
            Assert.fail("Cannot add to TripletonSet");
        } catch (UnsupportedOperationException ignored) {
            this.assertUnchanged();
        }
    }

    @Test
    public void addingAllToOtherSet() {
        MutableSet<String> newSet = UnifiedSet.newSet(Sets.fixedSize.of("1", "2", "3"));
        newSet.add("4");
        Verify.assertContainsAll(newSet, "1", "2", "3", "4");
    }

    private void assertUnchanged() {
        Verify.assertEqualsAndHashCode(UnifiedSet.newSetWith("1", "2", "3"), this.set);
    }

    @Test
    public void serializable() {
        MutableSet<String> copyOfSet = SerializeTestHelper.serializeDeserialize(this.set);
        Verify.assertSetsEqual(this.set, copyOfSet);
        Assert.assertNotSame(this.set, copyOfSet);
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
        Verify.assertEqualsAndHashCode(UnifiedSet.newSetWith("1", "2", "3"), cloneSet);
    }

    @Test
    public void newEmpty() {
        MutableSet<String> newEmpty = this.set.newEmpty();
        Verify.assertInstanceOf(UnifiedSet.class, newEmpty);
        Verify.assertEmpty(newEmpty);
    }

    @Test
    public void getLast() {
        Assert.assertEquals("3", this.set.getLast());
    }

    @Test
    public void forEach() {
        MutableList<String> result = Lists.mutable.of();
        MutableSet<String> source = Sets.fixedSize.of("1", "2", "3");
        source.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(FastList.newListWith("1", "2", "3"), result);
    }

    @Test
    public void forEachWithIndex() {
        int[] indexSum = new int[1];
        MutableList<String> result = Lists.mutable.of();
        MutableSet<String> source = Sets.fixedSize.of("1", "2", "3");
        source.forEachWithIndex((each, index) -> {
            result.add(each);
            indexSum[0] += index;
        });
        Assert.assertEquals(FastList.newListWith("1", "2", "3"), result);
        Assert.assertEquals(3, indexSum[0]);
    }

    @Test
    public void forEachWith() {
        MutableList<String> result = Lists.mutable.of();
        MutableSet<String> source = Sets.fixedSize.of("1", "2", "3");
        source.forEachWith(Procedures2.fromProcedure(CollectionAddProcedure.on(result)), null);
        Assert.assertEquals(FastList.newListWith("1", "2", "3"), result);
    }

    @Test
    public void getFirstGetLast() {
        MutableSet<String> source = Sets.fixedSize.of("1", "2", "3");
        Assert.assertEquals("1", source.getFirst());
        Assert.assertEquals("3", source.getLast());
    }

    @Test
    public void getOnly() {
        Assert.assertThrows(IllegalStateException.class, () -> this.set.getOnly());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public TripletonSetTest instance;

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
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
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
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
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
        public void benchmark_serializable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serializable);
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
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> payload) throws java.lang.Throwable {
            this.instance = new TripletonSetTest();
            this.instance.setUp();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> addAll_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> addAllIterable_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> add_duplicate_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> add_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> removeAll_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> removeAllIterable_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> retainAll_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> retainAllIterable_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> clear_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> removeIf_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> removeIfWith_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> iteratorRemove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> iterationWithIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> iteratorWillGetUpsetIfYouPushItTooFar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> unionInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> intersectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> differenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> symmetricDifferenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> powerSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> nonUniqueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> addDuplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> addingAllToOtherSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> serializable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> getFirstGetLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonSetTest> getOnly;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.asSynchronized = TripletonSetTest::asSynchronized;
            this.payloads.remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TripletonSetTest::remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TripletonSetTest::addAll_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllIterable_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TripletonSetTest::addAllIterable_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.add_duplicate_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TripletonSetTest::add_duplicate_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.add_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TripletonSetTest::add_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TripletonSetTest::removeAll_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllIterable_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TripletonSetTest::removeAllIterable_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TripletonSetTest::retainAll_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAllIterable_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TripletonSetTest::retainAllIterable_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.clear_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TripletonSetTest::clear_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TripletonSetTest::removeIf_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIfWith_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TripletonSetTest::removeIfWith_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.iterator = TripletonSetTest::iterator;
            this.payloads.iteratorRemove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TripletonSetTest::iteratorRemove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TripletonSetTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TripletonSetTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(TripletonSetTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(TripletonSetTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.iterationWithIterator = TripletonSetTest::iterationWithIterator;
            this.payloads.iteratorWillGetUpsetIfYouPushItTooFar = new se.chalmers.ju2jmh.api.ExceptionTest<>(TripletonSetTest::iteratorWillGetUpsetIfYouPushItTooFar, java.util.NoSuchElementException.class);
            this.payloads.groupBy = TripletonSetTest::groupBy;
            this.payloads.groupByEach = TripletonSetTest::groupByEach;
            this.payloads.zip = TripletonSetTest::zip;
            this.payloads.zipWithIndex = TripletonSetTest::zipWithIndex;
            this.payloads.asUnmodifiable = TripletonSetTest::asUnmodifiable;
            this.payloads.toImmutable = TripletonSetTest::toImmutable;
            this.payloads.min = TripletonSetTest::min;
            this.payloads.max = TripletonSetTest::max;
            this.payloads.min_without_comparator = TripletonSetTest::min_without_comparator;
            this.payloads.max_without_comparator = TripletonSetTest::max_without_comparator;
            this.payloads.minBy = TripletonSetTest::minBy;
            this.payloads.maxBy = TripletonSetTest::maxBy;
            this.payloads.chunk = TripletonSetTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TripletonSetTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = TripletonSetTest::chunk_large_size;
            this.payloads.union = TripletonSetTest::union;
            this.payloads.unionInto = TripletonSetTest::unionInto;
            this.payloads.intersect = TripletonSetTest::intersect;
            this.payloads.intersectInto = TripletonSetTest::intersectInto;
            this.payloads.difference = TripletonSetTest::difference;
            this.payloads.differenceInto = TripletonSetTest::differenceInto;
            this.payloads.symmetricDifference = TripletonSetTest::symmetricDifference;
            this.payloads.symmetricDifferenceInto = TripletonSetTest::symmetricDifferenceInto;
            this.payloads.isSubsetOf = TripletonSetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = TripletonSetTest::isProperSubsetOf;
            this.payloads.powerSet = TripletonSetTest::powerSet;
            this.payloads.cartesianProduct = TripletonSetTest::cartesianProduct;
            this.payloads.with = TripletonSetTest::with;
            this.payloads.withAll = TripletonSetTest::withAll;
            this.payloads.without = TripletonSetTest::without;
            this.payloads.withoutAll = TripletonSetTest::withoutAll;
            this.payloads.nonUniqueWith = TripletonSetTest::nonUniqueWith;
            this.payloads.equalsAndHashCode = TripletonSetTest::equalsAndHashCode;
            this.payloads.contains = TripletonSetTest::contains;
            this.payloads.remove = TripletonSetTest::remove;
            this.payloads.addDuplicate = TripletonSetTest::addDuplicate;
            this.payloads.add = TripletonSetTest::add;
            this.payloads.addingAllToOtherSet = TripletonSetTest::addingAllToOtherSet;
            this.payloads.serializable = TripletonSetTest::serializable;
            this.payloads.testClone = TripletonSetTest::testClone;
            this.payloads.newEmpty = TripletonSetTest::newEmpty;
            this.payloads.getLast = TripletonSetTest::getLast;
            this.payloads.forEach = TripletonSetTest::forEach;
            this.payloads.forEachWithIndex = TripletonSetTest::forEachWithIndex;
            this.payloads.forEachWith = TripletonSetTest::forEachWith;
            this.payloads.getFirstGetLast = TripletonSetTest::getFirstGetLast;
            this.payloads.getOnly = TripletonSetTest::getOnly;
        }
    }
}
