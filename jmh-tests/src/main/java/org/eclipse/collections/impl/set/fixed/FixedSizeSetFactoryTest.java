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

import org.eclipse.collections.api.factory.set.FixedSizeSetFactory;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.FixedSizeSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.block.factory.Procedures2;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.domain.Key;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FixedSizeSetFactoryTest {

    private FixedSizeSetFactory setFactory;

    @Before
    public void setUp() {
        this.setFactory = FixedSizeSetFactoryImpl.INSTANCE;
    }

    @Test
    public void testCreateWith3Args() {
        this.assertCreateSet(this.setFactory.of("a", "a"), "a");
        this.assertCreateSet(this.setFactory.of("a", "a", "c"), "a", "c");
        this.assertCreateSet(this.setFactory.of("a", "b", "a"), "a", "b");
        this.assertCreateSet(this.setFactory.of("a", "b", "b"), "a", "b");
    }

    @Test
    public void testCreateWith4Args() {
        this.assertCreateSet(this.setFactory.of("a", "a", "c", "d"), "a", "c", "d");
        this.assertCreateSet(this.setFactory.of("a", "b", "a", "d"), "a", "b", "d");
        this.assertCreateSet(this.setFactory.of("a", "b", "c", "a"), "a", "b", "c");
        this.assertCreateSet(this.setFactory.of("a", "b", "b", "d"), "a", "b", "d");
        this.assertCreateSet(this.setFactory.of("a", "b", "c", "b"), "a", "b", "c");
        this.assertCreateSet(this.setFactory.of("a", "b", "c", "c"), "a", "b", "c");
    }

    private void assertCreateSet(FixedSizeSet<String> undertest, String... expected) {
        Assert.assertEquals(UnifiedSet.newSetWith(expected), undertest);
        Verify.assertInstanceOf(FixedSizeSet.class, undertest);
    }

    @Test
    public void keyPreservation() {
        Key key = new Key("key");
        Key duplicateKey1 = new Key("key");
        MutableSet<Key> set1 = this.setFactory.of(key, duplicateKey1);
        Verify.assertSize(1, set1);
        Verify.assertContains(key, set1);
        Assert.assertSame(key, set1.getFirst());
        Key duplicateKey2 = new Key("key");
        MutableSet<Key> set2 = this.setFactory.of(key, duplicateKey1, duplicateKey2);
        Verify.assertSize(1, set2);
        Verify.assertContains(key, set2);
        Assert.assertSame(key, set1.getFirst());
        Key duplicateKey3 = new Key("key");
        MutableSet<Key> set3 = this.setFactory.of(key, new Key("not a dupe"), duplicateKey3);
        Verify.assertSize(2, set3);
        Verify.assertContainsAll(set3, key, new Key("not a dupe"));
        Assert.assertSame(key, set3.detect(key::equals));
        Key duplicateKey4 = new Key("key");
        MutableSet<Key> set4 = this.setFactory.of(key, new Key("not a dupe"), duplicateKey3, duplicateKey4);
        Verify.assertSize(2, set4);
        Verify.assertContainsAll(set4, key, new Key("not a dupe"));
        Assert.assertSame(key, set4.detect(key::equals));
        MutableSet<Key> set5 = this.setFactory.of(key, new Key("not a dupe"), new Key("me neither"), duplicateKey4);
        Verify.assertSize(3, set5);
        Verify.assertContainsAll(set5, key, new Key("not a dupe"), new Key("me neither"));
        Assert.assertSame(key, set5.detect(key::equals));
        MutableSet<Key> set6 = this.setFactory.of(key, duplicateKey2, duplicateKey3, duplicateKey4);
        Verify.assertSize(1, set6);
        Verify.assertContains(key, set6);
        Assert.assertSame(key, set6.detect(key::equals));
    }

    @Test
    public void create1() {
        FixedSizeSet<String> set = Sets.fixedSize.of("1");
        Verify.assertSize(1, set);
        Verify.assertContains("1", set);
    }

    @Test
    public void create2() {
        FixedSizeSet<String> set = Sets.fixedSize.of("1", "2");
        Assert.assertEquals(UnifiedSet.newSetWith("1", "2"), set);
    }

    @Test
    public void create3() {
        FixedSizeSet<String> set = Sets.fixedSize.of("1", "2", "3");
        Assert.assertEquals(UnifiedSet.newSetWith("1", "2", "3"), set);
    }

    @Test
    public void create4() {
        FixedSizeSet<String> set = Sets.fixedSize.of("1", "2", "3", "4");
        Assert.assertEquals(UnifiedSet.newSetWith("1", "2", "3", "4"), set);
    }

    @Test
    public void createWithDuplicates() {
        FixedSizeSet<String> set1 = Sets.fixedSize.of("1", "1");
        Assert.assertEquals(UnifiedSet.newSetWith("1"), set1);
        FixedSizeSet<String> set2 = Sets.fixedSize.of("1", "1", "1");
        Assert.assertEquals(UnifiedSet.newSetWith("1"), set2);
        FixedSizeSet<String> set3 = Sets.fixedSize.of("2", "3", "2");
        Assert.assertEquals(UnifiedSet.newSetWith("2", "3"), set3);
        FixedSizeSet<String> set4 = Sets.fixedSize.of("3", "4", "4");
        Assert.assertEquals(UnifiedSet.newSetWith("3", "4"), set4);
        FixedSizeSet<String> set5 = Sets.fixedSize.of("4", "4", "4", "4");
        Assert.assertEquals(UnifiedSet.newSetWith("4"), set5);
        FixedSizeSet<String> set6 = Sets.fixedSize.of("4", "3", "4", "4");
        Assert.assertEquals(UnifiedSet.newSetWith("4", "3"), set6);
        FixedSizeSet<String> set7 = Sets.fixedSize.of("4", "2", "3", "4");
        Assert.assertEquals(UnifiedSet.newSetWith("4", "3", "2"), set7);
        FixedSizeSet<String> set8 = Sets.fixedSize.of("2", "3", "4", "4");
        Assert.assertEquals(UnifiedSet.newSetWith("4", "3", "2"), set8);
        FixedSizeSet<String> set9 = Sets.fixedSize.of("2", "4", "3", "4");
        Assert.assertEquals(UnifiedSet.newSetWith("4", "3", "2"), set9);
        FixedSizeSet<String> set10 = Sets.fixedSize.of("2", "4", "3", "4");
        Assert.assertEquals(UnifiedSet.newSetWith("4", "3", "2"), set10);
        FixedSizeSet<String> set11 = Sets.fixedSize.of("4", "3", "4", "2");
        Assert.assertEquals(UnifiedSet.newSetWith("4", "3", "2"), set11);
        FixedSizeSet<String> set12 = Sets.fixedSize.of("3", "4", "4", "2");
        Assert.assertEquals(UnifiedSet.newSetWith("4", "3", "2"), set12);
    }

    @Test
    public void createSet() {
        MutableSet<String> set1 = Sets.fixedSize.of();
        Verify.assertEmpty(set1);
        MutableSet<String> set2 = Sets.fixedSize.of();
        Verify.assertEmpty(set2);
        Assert.assertSame(Sets.fixedSize.of(), Sets.fixedSize.of());
    }

    @Test
    public void forEach() {
        MutableList<String> result = Lists.mutable.of();
        MutableSet<String> source = Sets.fixedSize.of("1", "2", "3", "4");
        source.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(FastList.newListWith("1", "2", "3", "4"), result);
    }

    @Test
    public void forEachWithIndex() {
        int[] indexSum = new int[1];
        MutableList<String> result = Lists.mutable.of();
        MutableSet<String> source = Sets.fixedSize.of("1", "2", "3", "4");
        source.forEachWithIndex((each, index) -> {
            result.add(each);
            indexSum[0] += index;
        });
        Assert.assertEquals(6, indexSum[0]);
        Assert.assertEquals(FastList.newListWith("1", "2", "3", "4"), result);
    }

    @Test
    public void forEachWith() {
        MutableList<String> result = Lists.mutable.of();
        MutableSet<String> source = Sets.fixedSize.of("1", "2", "3", "4");
        source.forEachWith(Procedures2.fromProcedure(CollectionAddProcedure.on(result)), null);
        Assert.assertEquals(FastList.newListWith("1", "2", "3", "4"), result);
    }

    @Test
    public void ofAllSizeZero() {
        MutableSet<Integer> set = Sets.fixedSize.ofAll(FastList.newList());
        Assert.assertEquals(UnifiedSet.<Integer>newSetWith(), set);
        Verify.assertInstanceOf(FixedSizeSet.class, set);
    }

    @Test
    public void ofAllSizeOne() {
        MutableSet<Integer> set = Sets.fixedSize.ofAll(FastList.newListWith(1));
        Assert.assertEquals(UnifiedSet.newSetWith(1), set);
        Verify.assertInstanceOf(FixedSizeSet.class, set);
    }

    @Test
    public void ofAllSizeTwo() {
        MutableSet<Integer> set = Sets.fixedSize.ofAll(FastList.newListWith(1, 2));
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2), set);
        Verify.assertInstanceOf(FixedSizeSet.class, set);
    }

    @Test
    public void ofAllSizeThree() {
        MutableSet<Integer> set = Sets.fixedSize.ofAll(FastList.newListWith(1, 2, 3));
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3), set);
        Verify.assertInstanceOf(FixedSizeSet.class, set);
    }

    @Test
    public void ofAllSizeFour() {
        MutableSet<Integer> set = Sets.fixedSize.ofAll(FastList.newListWith(1, 2, 3, 4));
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3, 4), set);
        Verify.assertInstanceOf(FixedSizeSet.class, set);
    }

    @Test
    public void ofAllSizeFive() {
        MutableSet<Integer> set = Sets.fixedSize.ofAll(FastList.newListWith(1, 2, 3, 4, 5));
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3, 4, 5), set);
        Verify.assertInstanceOf(UnifiedSet.class, set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FixedSizeSetFactoryTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testCreateWith3Args() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testCreateWith3Args);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testCreateWith4Args() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testCreateWith4Args);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyPreservation() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyPreservation);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_create1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.create1);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_create2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.create2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_create3() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.create3);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_create4() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.create4);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_createWithDuplicates() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.createWithDuplicates);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_createSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.createSet);
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
        public void benchmark_ofAllSizeZero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAllSizeZero);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAllSizeOne() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAllSizeOne);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAllSizeTwo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAllSizeTwo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAllSizeThree() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAllSizeThree);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAllSizeFour() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAllSizeFour);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAllSizeFive() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAllSizeFive);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FixedSizeSetFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new FixedSizeSetFactoryTest();
            this.instance.setUp();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FixedSizeSetFactoryTest> testCreateWith3Args;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FixedSizeSetFactoryTest> testCreateWith4Args;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FixedSizeSetFactoryTest> keyPreservation;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FixedSizeSetFactoryTest> create1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FixedSizeSetFactoryTest> create2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FixedSizeSetFactoryTest> create3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FixedSizeSetFactoryTest> create4;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FixedSizeSetFactoryTest> createWithDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FixedSizeSetFactoryTest> createSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FixedSizeSetFactoryTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FixedSizeSetFactoryTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FixedSizeSetFactoryTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FixedSizeSetFactoryTest> ofAllSizeZero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FixedSizeSetFactoryTest> ofAllSizeOne;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FixedSizeSetFactoryTest> ofAllSizeTwo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FixedSizeSetFactoryTest> ofAllSizeThree;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FixedSizeSetFactoryTest> ofAllSizeFour;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FixedSizeSetFactoryTest> ofAllSizeFive;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testCreateWith3Args = FixedSizeSetFactoryTest::testCreateWith3Args;
            this.payloads.testCreateWith4Args = FixedSizeSetFactoryTest::testCreateWith4Args;
            this.payloads.keyPreservation = FixedSizeSetFactoryTest::keyPreservation;
            this.payloads.create1 = FixedSizeSetFactoryTest::create1;
            this.payloads.create2 = FixedSizeSetFactoryTest::create2;
            this.payloads.create3 = FixedSizeSetFactoryTest::create3;
            this.payloads.create4 = FixedSizeSetFactoryTest::create4;
            this.payloads.createWithDuplicates = FixedSizeSetFactoryTest::createWithDuplicates;
            this.payloads.createSet = FixedSizeSetFactoryTest::createSet;
            this.payloads.forEach = FixedSizeSetFactoryTest::forEach;
            this.payloads.forEachWithIndex = FixedSizeSetFactoryTest::forEachWithIndex;
            this.payloads.forEachWith = FixedSizeSetFactoryTest::forEachWith;
            this.payloads.ofAllSizeZero = FixedSizeSetFactoryTest::ofAllSizeZero;
            this.payloads.ofAllSizeOne = FixedSizeSetFactoryTest::ofAllSizeOne;
            this.payloads.ofAllSizeTwo = FixedSizeSetFactoryTest::ofAllSizeTwo;
            this.payloads.ofAllSizeThree = FixedSizeSetFactoryTest::ofAllSizeThree;
            this.payloads.ofAllSizeFour = FixedSizeSetFactoryTest::ofAllSizeFour;
            this.payloads.ofAllSizeFive = FixedSizeSetFactoryTest::ofAllSizeFive;
        }
    }
}
