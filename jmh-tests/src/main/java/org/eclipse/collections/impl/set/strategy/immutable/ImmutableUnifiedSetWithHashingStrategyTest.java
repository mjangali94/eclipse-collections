/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.strategy.immutable;

import org.eclipse.collections.api.block.HashingStrategy;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.math.IntegerSum;
import org.eclipse.collections.impl.math.Sum;
import org.eclipse.collections.impl.math.SumProcedure;
import org.eclipse.collections.impl.parallel.BatchIterable;
import org.eclipse.collections.impl.set.immutable.AbstractImmutableUnifiedSetTestCase;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableUnifiedSetWithHashingStrategy}.
 */
public class ImmutableUnifiedSetWithHashingStrategyTest extends AbstractImmutableUnifiedSetTestCase {

    // Not using the static factor method in order to have concrete types for test cases
    private static final HashingStrategy<Integer> HASHING_STRATEGY = HashingStrategies.nullSafeHashingStrategy(new HashingStrategy<Integer>() {

        public int computeHashCode(Integer object) {
            return object.hashCode();
        }

        public boolean equals(Integer object1, Integer object2) {
            return object1.equals(object2);
        }
    });

    @Override
    public ImmutableSet<Integer> newSet(Integer... elements) {
        return ImmutableUnifiedSetWithHashingStrategy.newSetWith(HASHING_STRATEGY, elements);
    }

    @Override
    public ImmutableSet<Integer> newSetWith(int one, int two) {
        return ImmutableUnifiedSetWithHashingStrategy.newSetWith(HASHING_STRATEGY, one, two);
    }

    @Override
    public ImmutableSet<Integer> newSetWith(int one, int two, int three) {
        return ImmutableUnifiedSetWithHashingStrategy.newSetWith(HASHING_STRATEGY, one, two, three);
    }

    @Override
    public ImmutableSet<Integer> newSetWith(int... littleElements) {
        Integer[] bigElements = new Integer[littleElements.length];
        for (int i = 0; i < littleElements.length; i++) {
            bigElements[i] = littleElements[i];
        }
        return ImmutableUnifiedSetWithHashingStrategy.newSetWith(HASHING_STRATEGY, bigElements);
    }

    @Override
    @Test
    public void newCollection() {
        super.newCollection();
        ImmutableSet<Integer> set = ImmutableUnifiedSetWithHashingStrategy.newSet(HASHING_STRATEGY, UnifiedSet.newSet());
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

    @Override
    @Test
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        ImmutableSet<Integer> deserialized = SerializeTestHelper.serializeDeserialize(this.newSet(1, 2, 3, 4, 5));
        Verify.assertInstanceOf(ImmutableUnifiedSetWithHashingStrategy.class, deserialized);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public ImmutableUnifiedSetWithHashingStrategyTest instance;

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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        public void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableUnifiedSetWithHashingStrategyTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> newWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> newWithOut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> newSetWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> newListWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> asSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> powerSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> getBatchCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> batchForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyTest> equalsAndHashCode;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newWith = ImmutableUnifiedSetWithHashingStrategyTest::newWith;
            this.payloads.newWithAll = ImmutableUnifiedSetWithHashingStrategyTest::newWithAll;
            this.payloads.newWithOut = ImmutableUnifiedSetWithHashingStrategyTest::newWithOut;
            this.payloads.newWithoutAll = ImmutableUnifiedSetWithHashingStrategyTest::newWithoutAll;
            this.payloads.newSetWith = ImmutableUnifiedSetWithHashingStrategyTest::newSetWith;
            this.payloads.newListWithVarArgs = ImmutableUnifiedSetWithHashingStrategyTest::newListWithVarArgs;
            this.payloads.tap = ImmutableUnifiedSetWithHashingStrategyTest::tap;
            this.payloads.forEach = ImmutableUnifiedSetWithHashingStrategyTest::forEach;
            this.payloads.forEachWithIndex = ImmutableUnifiedSetWithHashingStrategyTest::forEachWithIndex;
            this.payloads.select = ImmutableUnifiedSetWithHashingStrategyTest::select;
            this.payloads.reject = ImmutableUnifiedSetWithHashingStrategyTest::reject;
            this.payloads.collect = ImmutableUnifiedSetWithHashingStrategyTest::collect;
            this.payloads.detect = ImmutableUnifiedSetWithHashingStrategyTest::detect;
            this.payloads.detectIfNone = ImmutableUnifiedSetWithHashingStrategyTest::detectIfNone;
            this.payloads.allSatisfy = ImmutableUnifiedSetWithHashingStrategyTest::allSatisfy;
            this.payloads.anySatisfy = ImmutableUnifiedSetWithHashingStrategyTest::anySatisfy;
            this.payloads.noneSatisfy = ImmutableUnifiedSetWithHashingStrategyTest::noneSatisfy;
            this.payloads.count = ImmutableUnifiedSetWithHashingStrategyTest::count;
            this.payloads.collectIf = ImmutableUnifiedSetWithHashingStrategyTest::collectIf;
            this.payloads.getFirst = ImmutableUnifiedSetWithHashingStrategyTest::getFirst;
            this.payloads.getLast = ImmutableUnifiedSetWithHashingStrategyTest::getLast;
            this.payloads.getOnly = ImmutableUnifiedSetWithHashingStrategyTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedSetWithHashingStrategyTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedSetWithHashingStrategyTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = ImmutableUnifiedSetWithHashingStrategyTest::isEmpty;
            this.payloads.iterator = ImmutableUnifiedSetWithHashingStrategyTest::iterator;
            this.payloads.injectInto = ImmutableUnifiedSetWithHashingStrategyTest::injectInto;
            this.payloads.injectIntoInt = ImmutableUnifiedSetWithHashingStrategyTest::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableUnifiedSetWithHashingStrategyTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableUnifiedSetWithHashingStrategyTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ImmutableUnifiedSetWithHashingStrategyTest::injectIntoFloat;
            this.payloads.sumFloat = ImmutableUnifiedSetWithHashingStrategyTest::sumFloat;
            this.payloads.sumDouble = ImmutableUnifiedSetWithHashingStrategyTest::sumDouble;
            this.payloads.sumInteger = ImmutableUnifiedSetWithHashingStrategyTest::sumInteger;
            this.payloads.sumLong = ImmutableUnifiedSetWithHashingStrategyTest::sumLong;
            this.payloads.toArray = ImmutableUnifiedSetWithHashingStrategyTest::toArray;
            this.payloads.forEachWith = ImmutableUnifiedSetWithHashingStrategyTest::forEachWith;
            this.payloads.toList = ImmutableUnifiedSetWithHashingStrategyTest::toList;
            this.payloads.toSortedList = ImmutableUnifiedSetWithHashingStrategyTest::toSortedList;
            this.payloads.toSortedListBy = ImmutableUnifiedSetWithHashingStrategyTest::toSortedListBy;
            this.payloads.asSortedSet = ImmutableUnifiedSetWithHashingStrategyTest::asSortedSet;
            this.payloads.toSortedSet_with_comparator = ImmutableUnifiedSetWithHashingStrategyTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = ImmutableUnifiedSetWithHashingStrategyTest::toSortedSetBy;
            this.payloads.toSet = ImmutableUnifiedSetWithHashingStrategyTest::toSet;
            this.payloads.toMap = ImmutableUnifiedSetWithHashingStrategyTest::toMap;
            this.payloads.serialization = ImmutableUnifiedSetWithHashingStrategyTest::serialization;
            this.payloads.testToString = ImmutableUnifiedSetWithHashingStrategyTest::testToString;
            this.payloads.powerSet = ImmutableUnifiedSetWithHashingStrategyTest::powerSet;
            this.payloads.groupByUniqueKey = ImmutableUnifiedSetWithHashingStrategyTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedSetWithHashingStrategyTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ImmutableUnifiedSetWithHashingStrategyTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedSetWithHashingStrategyTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.newCollection = ImmutableUnifiedSetWithHashingStrategyTest::newCollection;
            this.payloads.getBatchCount = ImmutableUnifiedSetWithHashingStrategyTest::getBatchCount;
            this.payloads.batchForEach = ImmutableUnifiedSetWithHashingStrategyTest::batchForEach;
            this.payloads.equalsAndHashCode = ImmutableUnifiedSetWithHashingStrategyTest::equalsAndHashCode;
        }
    }
}
