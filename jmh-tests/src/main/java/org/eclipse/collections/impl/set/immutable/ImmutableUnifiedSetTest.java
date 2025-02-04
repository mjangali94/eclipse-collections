/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.immutable;

import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.impl.math.IntegerSum;
import org.eclipse.collections.impl.math.Sum;
import org.eclipse.collections.impl.math.SumProcedure;
import org.eclipse.collections.impl.parallel.BatchIterable;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableUnifiedSet}.
 */
public class ImmutableUnifiedSetTest extends AbstractImmutableUnifiedSetTestCase {

    @Override
    public ImmutableSet<Integer> newSet(Integer... elements) {
        return ImmutableUnifiedSet.newSetWith(elements);
    }

    @Override
    public ImmutableSet<Integer> newSetWith(int one, int two) {
        return ImmutableUnifiedSet.newSetWith(one, two);
    }

    @Override
    public ImmutableSet<Integer> newSetWith(int one, int two, int three) {
        return ImmutableUnifiedSet.newSetWith(one, two, three);
    }

    @Override
    public ImmutableSet<Integer> newSetWith(int... littleElements) {
        Integer[] bigElements = new Integer[littleElements.length];
        for (int i = 0; i < littleElements.length; i++) {
            bigElements[i] = littleElements[i];
        }
        return ImmutableUnifiedSet.newSetWith(bigElements);
    }

    @Override
    @Test
    public void newCollection() {
        super.newCollection();
        ImmutableSet<Integer> set = ImmutableUnifiedSet.newSet(UnifiedSet.newSet());
        Assert.assertTrue(set.isEmpty());
        Verify.assertSize(0, set);
    }

    @Test
    public void getBatchCount() {
        BatchIterable<Integer> integerBatchIterable = (BatchIterable<Integer>) this.newSet(1, 2, 3, 4, 5, 6);
        Assert.assertEquals(2, integerBatchIterable.getBatchCount(3));
    }

    @Test
    public void batchForEach() {
        Sum sum = new IntegerSum(0);
        BatchIterable<Integer> integerBatchIterable = (BatchIterable<Integer>) this.newSet(1, 2, 3, 4, 5);
        integerBatchIterable.batchForEach(new SumProcedure<>(sum), 0, 1);
        Assert.assertEquals(15, sum.getValue());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableUnifiedSetTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithOut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithOut);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newSetWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newSetWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWithVarArgs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWithVarArgs);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
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
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_throws_when_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_throws_when_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_throws_when_multiple_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_throws_when_multiple_values);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
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
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumInteger);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSortedSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_powerSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.powerSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getBatchCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getBatchCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEach);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableUnifiedSetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> newWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> newWithOut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> newSetWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> newListWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> asSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> powerSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> getBatchCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetTest> batchForEach;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newWith = ImmutableUnifiedSetTest::newWith;
            this.payloads.newWithAll = ImmutableUnifiedSetTest::newWithAll;
            this.payloads.newWithOut = ImmutableUnifiedSetTest::newWithOut;
            this.payloads.newWithoutAll = ImmutableUnifiedSetTest::newWithoutAll;
            this.payloads.newSetWith = ImmutableUnifiedSetTest::newSetWith;
            this.payloads.newListWithVarArgs = ImmutableUnifiedSetTest::newListWithVarArgs;
            this.payloads.tap = ImmutableUnifiedSetTest::tap;
            this.payloads.forEach = ImmutableUnifiedSetTest::forEach;
            this.payloads.forEachWithIndex = ImmutableUnifiedSetTest::forEachWithIndex;
            this.payloads.select = ImmutableUnifiedSetTest::select;
            this.payloads.reject = ImmutableUnifiedSetTest::reject;
            this.payloads.collect = ImmutableUnifiedSetTest::collect;
            this.payloads.detect = ImmutableUnifiedSetTest::detect;
            this.payloads.detectIfNone = ImmutableUnifiedSetTest::detectIfNone;
            this.payloads.allSatisfy = ImmutableUnifiedSetTest::allSatisfy;
            this.payloads.anySatisfy = ImmutableUnifiedSetTest::anySatisfy;
            this.payloads.noneSatisfy = ImmutableUnifiedSetTest::noneSatisfy;
            this.payloads.count = ImmutableUnifiedSetTest::count;
            this.payloads.collectIf = ImmutableUnifiedSetTest::collectIf;
            this.payloads.getFirst = ImmutableUnifiedSetTest::getFirst;
            this.payloads.getLast = ImmutableUnifiedSetTest::getLast;
            this.payloads.getOnly = ImmutableUnifiedSetTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedSetTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedSetTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = ImmutableUnifiedSetTest::isEmpty;
            this.payloads.iterator = ImmutableUnifiedSetTest::iterator;
            this.payloads.injectInto = ImmutableUnifiedSetTest::injectInto;
            this.payloads.injectIntoInt = ImmutableUnifiedSetTest::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableUnifiedSetTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableUnifiedSetTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ImmutableUnifiedSetTest::injectIntoFloat;
            this.payloads.sumFloat = ImmutableUnifiedSetTest::sumFloat;
            this.payloads.sumDouble = ImmutableUnifiedSetTest::sumDouble;
            this.payloads.sumInteger = ImmutableUnifiedSetTest::sumInteger;
            this.payloads.sumLong = ImmutableUnifiedSetTest::sumLong;
            this.payloads.toArray = ImmutableUnifiedSetTest::toArray;
            this.payloads.equalsAndHashCode = ImmutableUnifiedSetTest::equalsAndHashCode;
            this.payloads.forEachWith = ImmutableUnifiedSetTest::forEachWith;
            this.payloads.toList = ImmutableUnifiedSetTest::toList;
            this.payloads.toSortedList = ImmutableUnifiedSetTest::toSortedList;
            this.payloads.toSortedListBy = ImmutableUnifiedSetTest::toSortedListBy;
            this.payloads.asSortedSet = ImmutableUnifiedSetTest::asSortedSet;
            this.payloads.toSortedSet_with_comparator = ImmutableUnifiedSetTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = ImmutableUnifiedSetTest::toSortedSetBy;
            this.payloads.toSet = ImmutableUnifiedSetTest::toSet;
            this.payloads.toMap = ImmutableUnifiedSetTest::toMap;
            this.payloads.serialization = ImmutableUnifiedSetTest::serialization;
            this.payloads.testToString = ImmutableUnifiedSetTest::testToString;
            this.payloads.powerSet = ImmutableUnifiedSetTest::powerSet;
            this.payloads.groupByUniqueKey = ImmutableUnifiedSetTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedSetTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ImmutableUnifiedSetTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedSetTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.newCollection = ImmutableUnifiedSetTest::newCollection;
            this.payloads.getBatchCount = ImmutableUnifiedSetTest::getBatchCount;
            this.payloads.batchForEach = ImmutableUnifiedSetTest::batchForEach;
        }
    }
}
