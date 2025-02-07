/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.mutable;

import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.UnsortedSetIterable;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.collection.mutable.UnmodifiableMutableCollectionTestCase;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class MultiReaderUnifiedSetAsReadUntouchableTest extends UnmodifiableMutableCollectionTestCase<Integer> {

    @Override
    protected MutableCollection<Integer> getCollection() {
        return MultiReaderUnifiedSet.newSetWith(1).asReadUntouchable();
    }

    @Test
    public void union() {
        MutableSet<String> set = MultiReaderUnifiedSet.newSetWith("1", "2", "3", "4").asReadUntouchable();
        MutableSet<String> union = set.union(UnifiedSet.newSetWith("a", "b", "c", "1"));
        Verify.assertSize(set.size() + 3, union);
        Assert.assertTrue(union.containsAllIterable(Interval.oneTo(set.size()).collect(String::valueOf)));
        Verify.assertContainsAll(union, "a", "b", "c");
        Assert.assertEquals(set, set.union(UnifiedSet.newSetWith("1")));
    }

    @Test
    public void unionInto() {
        MutableSet<String> set = MultiReaderUnifiedSet.newSetWith("1", "2", "3", "4").asReadUntouchable();
        MutableSet<String> union = set.unionInto(UnifiedSet.newSetWith("a", "b", "c", "1"), UnifiedSet.newSet());
        Verify.assertSize(set.size() + 3, union);
        Assert.assertTrue(union.containsAllIterable(Interval.oneTo(set.size()).collect(String::valueOf)));
        Verify.assertContainsAll(union, "a", "b", "c");
        Assert.assertEquals(set, set.unionInto(UnifiedSet.newSetWith("1"), UnifiedSet.newSet()));
    }

    @Test
    public void intersect() {
        MutableSet<String> set = MultiReaderUnifiedSet.newSetWith("1", "2", "3", "4").asReadUntouchable();
        MutableSet<String> intersect = set.intersect(UnifiedSet.newSetWith("a", "b", "c", "1"));
        Verify.assertSize(1, intersect);
        Assert.assertEquals(UnifiedSet.newSetWith("1"), intersect);
        Verify.assertEmpty(set.intersect(UnifiedSet.newSetWith("not present")));
    }

    @Test
    public void intersectInto() {
        MutableSet<String> set = MultiReaderUnifiedSet.newSetWith("1", "2", "3", "4").asReadUntouchable();
        MutableSet<String> intersect = set.intersectInto(UnifiedSet.newSetWith("a", "b", "c", "1"), UnifiedSet.newSet());
        Verify.assertSize(1, intersect);
        Assert.assertEquals(UnifiedSet.newSetWith("1"), intersect);
        Verify.assertEmpty(set.intersectInto(UnifiedSet.newSetWith("not present"), UnifiedSet.newSet()));
    }

    @Test
    public void difference() {
        MutableSet<String> set = MultiReaderUnifiedSet.newSetWith("1", "2", "3", "4").asReadUntouchable();
        MutableSet<String> difference = set.difference(UnifiedSet.newSetWith("2", "3", "4", "not present"));
        Assert.assertEquals(UnifiedSet.newSetWith("1"), difference);
        Assert.assertEquals(set, set.difference(UnifiedSet.newSetWith("not present")));
    }

    @Test
    public void differenceInto() {
        MutableSet<String> set = MultiReaderUnifiedSet.newSetWith("1", "2", "3", "4").asReadUntouchable();
        MutableSet<String> difference = set.differenceInto(UnifiedSet.newSetWith("2", "3", "4", "not present"), UnifiedSet.newSet());
        Assert.assertEquals(UnifiedSet.newSetWith("1"), difference);
        Assert.assertEquals(set, set.differenceInto(UnifiedSet.newSetWith("not present"), UnifiedSet.newSet()));
    }

    @Test
    public void symmetricDifference() {
        MutableSet<String> set = MultiReaderUnifiedSet.newSetWith("1", "2", "3", "4").asReadUntouchable();
        MutableSet<String> difference = set.symmetricDifference(UnifiedSet.newSetWith("2", "3", "4", "5", "not present"));
        Verify.assertContains("1", difference);
        Assert.assertTrue(difference.containsAllIterable(Interval.fromTo(set.size() + 1, 5).collect(String::valueOf)));
        for (int i = 2; i <= set.size(); i++) {
            Verify.assertNotContains(String.valueOf(i), difference);
        }
        Verify.assertSize(set.size() + 1, set.symmetricDifference(UnifiedSet.newSetWith("not present")));
    }

    @Test
    public void symmetricDifferenceInto() {
        MutableSet<String> set = MultiReaderUnifiedSet.newSetWith("1", "2", "3", "4").asReadUntouchable();
        MutableSet<String> difference = set.symmetricDifferenceInto(UnifiedSet.newSetWith("2", "3", "4", "5", "not present"), UnifiedSet.newSet());
        Verify.assertContains("1", difference);
        Assert.assertTrue(difference.containsAllIterable(Interval.fromTo(set.size() + 1, 5).collect(String::valueOf)));
        for (int i = 2; i <= set.size(); i++) {
            Verify.assertNotContains(String.valueOf(i), difference);
        }
        Verify.assertSize(set.size() + 1, set.symmetricDifferenceInto(UnifiedSet.newSetWith("not present"), UnifiedSet.newSet()));
    }

    @Test
    public void isSubsetOf() {
        MutableSet<String> set = MultiReaderUnifiedSet.newSetWith("1", "2", "3", "4").asReadUntouchable();
        Assert.assertTrue(set.isSubsetOf(UnifiedSet.newSetWith("1", "2", "3", "4", "5")));
    }

    @Test
    public void isProperSubsetOf() {
        MutableSet<String> set = MultiReaderUnifiedSet.newSetWith("1", "2", "3", "4").asReadUntouchable();
        Assert.assertTrue(set.isProperSubsetOf(UnifiedSet.newSetWith("1", "2", "3", "4", "5")));
        Assert.assertFalse(set.isProperSubsetOf(set));
    }

    @Test
    public void powerSet() {
        MutableSet<String> set = MultiReaderUnifiedSet.newSetWith("1", "2", "3", "4").asReadUntouchable();
        MutableSet<UnsortedSetIterable<String>> powerSet = set.powerSet();
        Verify.assertSize((int) StrictMath.pow(2, set.size()), powerSet);
        Verify.assertContains(UnifiedSet.<String>newSet(), powerSet);
        Verify.assertContains(set, powerSet);
    }

    @Test
    public void cartesianProduct() {
        MutableSet<String> set = MultiReaderUnifiedSet.newSetWith("1", "2", "3", "4").asReadUntouchable();
        LazyIterable<Pair<String, String>> cartesianProduct = set.cartesianProduct(UnifiedSet.newSetWith("One", "Two"));
        Verify.assertIterableSize(set.size() * 2, cartesianProduct);
        Assert.assertEquals(set, cartesianProduct.select(Predicates.attributeEqual((Function<Pair<?, String>, String>) Pair::getTwo, "One")).collect((Function<Pair<String, ?>, String>) Pair::getOne).toSet());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public MultiReaderUnifiedSetAsReadUntouchableTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIfWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIfWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorRemove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorRemove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testMakeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testMakeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAppendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAppendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
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
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
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
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> payload) throws java.lang.Throwable {
            this.instance = new MultiReaderUnifiedSetAsReadUntouchableTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> testMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> testAppendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> unionInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> intersectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> differenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> symmetricDifferenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> powerSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsReadUntouchableTest> cartesianProduct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.removeIfWith = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsReadUntouchableTest::removeIfWith, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsReadUntouchableTest::removeIf, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsReadUntouchableTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.iteratorRemove = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsReadUntouchableTest::iteratorRemove, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsReadUntouchableTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsReadUntouchableTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsReadUntouchableTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsReadUntouchableTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsReadUntouchableTest::removeAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsReadUntouchableTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsReadUntouchableTest::retainAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsReadUntouchableTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.testMakeString = MultiReaderUnifiedSetAsReadUntouchableTest::testMakeString;
            this.payloads.testAppendString = MultiReaderUnifiedSetAsReadUntouchableTest::testAppendString;
            this.payloads.select = MultiReaderUnifiedSetAsReadUntouchableTest::select;
            this.payloads.selectWith = MultiReaderUnifiedSetAsReadUntouchableTest::selectWith;
            this.payloads.reject = MultiReaderUnifiedSetAsReadUntouchableTest::reject;
            this.payloads.rejectWith = MultiReaderUnifiedSetAsReadUntouchableTest::rejectWith;
            this.payloads.partition = MultiReaderUnifiedSetAsReadUntouchableTest::partition;
            this.payloads.partitionWith = MultiReaderUnifiedSetAsReadUntouchableTest::partitionWith;
            this.payloads.collect = MultiReaderUnifiedSetAsReadUntouchableTest::collect;
            this.payloads.collectInt = MultiReaderUnifiedSetAsReadUntouchableTest::collectInt;
            this.payloads.collectBoolean = MultiReaderUnifiedSetAsReadUntouchableTest::collectBoolean;
            this.payloads.collectByte = MultiReaderUnifiedSetAsReadUntouchableTest::collectByte;
            this.payloads.collectChar = MultiReaderUnifiedSetAsReadUntouchableTest::collectChar;
            this.payloads.collectDouble = MultiReaderUnifiedSetAsReadUntouchableTest::collectDouble;
            this.payloads.collectFloat = MultiReaderUnifiedSetAsReadUntouchableTest::collectFloat;
            this.payloads.collectLong = MultiReaderUnifiedSetAsReadUntouchableTest::collectLong;
            this.payloads.collectShort = MultiReaderUnifiedSetAsReadUntouchableTest::collectShort;
            this.payloads.collectWith = MultiReaderUnifiedSetAsReadUntouchableTest::collectWith;
            this.payloads.collectIf = MultiReaderUnifiedSetAsReadUntouchableTest::collectIf;
            this.payloads.newEmpty = MultiReaderUnifiedSetAsReadUntouchableTest::newEmpty;
            this.payloads.groupBy = MultiReaderUnifiedSetAsReadUntouchableTest::groupBy;
            this.payloads.zip = MultiReaderUnifiedSetAsReadUntouchableTest::zip;
            this.payloads.zipWithIndex = MultiReaderUnifiedSetAsReadUntouchableTest::zipWithIndex;
            this.payloads.flatCollect = MultiReaderUnifiedSetAsReadUntouchableTest::flatCollect;
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsReadUntouchableTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsReadUntouchableTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsReadUntouchableTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsReadUntouchableTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.tap = MultiReaderUnifiedSetAsReadUntouchableTest::tap;
            this.payloads.union = MultiReaderUnifiedSetAsReadUntouchableTest::union;
            this.payloads.unionInto = MultiReaderUnifiedSetAsReadUntouchableTest::unionInto;
            this.payloads.intersect = MultiReaderUnifiedSetAsReadUntouchableTest::intersect;
            this.payloads.intersectInto = MultiReaderUnifiedSetAsReadUntouchableTest::intersectInto;
            this.payloads.difference = MultiReaderUnifiedSetAsReadUntouchableTest::difference;
            this.payloads.differenceInto = MultiReaderUnifiedSetAsReadUntouchableTest::differenceInto;
            this.payloads.symmetricDifference = MultiReaderUnifiedSetAsReadUntouchableTest::symmetricDifference;
            this.payloads.symmetricDifferenceInto = MultiReaderUnifiedSetAsReadUntouchableTest::symmetricDifferenceInto;
            this.payloads.isSubsetOf = MultiReaderUnifiedSetAsReadUntouchableTest::isSubsetOf;
            this.payloads.isProperSubsetOf = MultiReaderUnifiedSetAsReadUntouchableTest::isProperSubsetOf;
            this.payloads.powerSet = MultiReaderUnifiedSetAsReadUntouchableTest::powerSet;
            this.payloads.cartesianProduct = MultiReaderUnifiedSetAsReadUntouchableTest::cartesianProduct;
        }
    }
}
