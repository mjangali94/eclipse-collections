/*
 * Copyright (c) 2016 Goldman Sachs.
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
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_nonUniqueWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::nonUniqueWith, this.description("nonUniqueWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::equalsAndHashCode, this.description("equalsAndHashCode"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::contains, this.description("contains"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::remove, this.description("remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addDuplicate() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addDuplicate, this.description("addDuplicate"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::add, this.description("add"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addingAllToOtherSet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addingAllToOtherSet, this.description("addingAllToOtherSet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serializable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::serializable, this.description("serializable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testClone, this.description("testClone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newEmpty, this.description("newEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getLast, this.description("getLast"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach, this.description("forEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWithIndex, this.description("forEachWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWith, this.description("forEachWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirstGetLast() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getFirstGetLast, this.description("getFirstGetLast"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getOnly, this.description("getOnly"));
        }

        @java.lang.Override
        public void before() throws java.lang.Throwable {
            super.before();
            this.implementation().setUp();
        }

        private TripletonSetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new TripletonSetTest();
        }

        @java.lang.Override
        public TripletonSetTest implementation() {
            return this.implementation;
        }
    }
}
