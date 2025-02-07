/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.mutable;

import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.collection.mutable.AbstractCollectionTestCase;
import org.eclipse.collections.impl.factory.Sets;
import org.junit.Assert;
import org.junit.Test;

public class MultiReaderHashBagAsWriteUntouchableTest extends AbstractCollectionTestCase {

    @Override
    protected <T> MutableBag<T> newWith(T... littleElements) {
        return MultiReaderHashBag.newBagWith(littleElements).asWriteUntouchable();
    }

    @Override
    public void asSynchronized() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newWith().asSynchronized());
    }

    @Override
    public void asUnmodifiable() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newWith().asUnmodifiable());
    }

    @Test
    public void addOccurrences() {
        MutableBag<Integer> bag = this.newWith(1, 1);
        Assert.assertEquals(4, bag.addOccurrences(1, 2));
        MutableBagTestCase.assertBagsEqual(HashBag.newBagWith(1, 1, 1, 1), bag);
        Assert.assertEquals(0, bag.addOccurrences(2, 0));
        Assert.assertEquals(2, bag.addOccurrences(2, 2));
        MutableBagTestCase.assertBagsEqual(HashBag.newBagWith(1, 1, 1, 1, 2, 2), bag);
    }

    @Override
    @Test
    public void makeString() {
        Assert.assertEquals("[1, 1, 2, 3]", MultiReaderHashBag.newBagWith(1, 1, 2, 3).toString());
    }

    @Override
    @Test
    public void appendString() {
        Appendable builder = new StringBuilder();
        MultiReaderHashBag.newBagWith(1, 1, 2, 3).appendString(builder);
        Assert.assertEquals("1, 1, 2, 3", builder.toString());
    }

    @Override
    @Test
    public void testToString() {
        Assert.assertEquals("[1, 1, 2, 3]", MultiReaderHashBag.newBagWith(1, 1, 2, 3).toString());
    }

    @Test
    public void selectUnique() {
        MutableBag<String> bag = this.newWith("0", "1", "1", "1", "1", "2", "2", "2", "3", "3", "4", "5");
        MutableSet<String> expected = Sets.mutable.with("0", "4", "5");
        MutableSet<String> actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void distinctView() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newWith().distinctView());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public MultiReaderHashBagAsWriteUntouchableTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewCollection);
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
        public void benchmark_containsBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllCollection);
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
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
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
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_target);
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
        public void benchmark_rejectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
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
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxOptional);
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
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_safe);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_safe);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minByOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxByOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNoneBlock() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNoneBlock);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAny() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAny);
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
        public void benchmark_getOnly_not_only_one_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_not_only_one_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_empty_throws);
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
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
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
        public void benchmark_summarizeFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding1);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding1);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumInteger);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloatConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloatConsistentRounding);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDoubleConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDoubleConsistentRounding);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
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
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortSet_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSet_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy_with_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMapBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBiMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBiMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparatorAndStartAndEnd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_fusedCollectMakeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.fusedCollectMakeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparatorAndStartAndEnd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringThrows);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach);
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
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws_for_duplicate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_for_duplicate);
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
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_single() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_single);
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
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithVarArgs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithVarArgs);
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
        public void benchmark_injectIntoWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectAndRejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectAndRejectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIfWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIfWith);
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
        public void benchmark_largeCollectionStreamToBagMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.largeCollectionStreamToBagMultimap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectUnique);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctView);
        }

        public void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> payload) throws java.lang.Throwable {
            this.instance = new MultiReaderHashBagAsWriteUntouchableTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> addOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsWriteUntouchableTest> distinctView;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = MultiReaderHashBagAsWriteUntouchableTest::testNewCollection;
            this.payloads.equalsAndHashCode = MultiReaderHashBagAsWriteUntouchableTest::equalsAndHashCode;
            this.payloads.contains = MultiReaderHashBagAsWriteUntouchableTest::contains;
            this.payloads.containsBy = MultiReaderHashBagAsWriteUntouchableTest::containsBy;
            this.payloads.containsAllIterable = MultiReaderHashBagAsWriteUntouchableTest::containsAllIterable;
            this.payloads.containsAnyIterable = MultiReaderHashBagAsWriteUntouchableTest::containsAnyIterable;
            this.payloads.containsNoneIterable = MultiReaderHashBagAsWriteUntouchableTest::containsNoneIterable;
            this.payloads.containsAllArray = MultiReaderHashBagAsWriteUntouchableTest::containsAllArray;
            this.payloads.containsAnyCollection = MultiReaderHashBagAsWriteUntouchableTest::containsAnyCollection;
            this.payloads.containsNoneCollection = MultiReaderHashBagAsWriteUntouchableTest::containsNoneCollection;
            this.payloads.containsAllCollection = MultiReaderHashBagAsWriteUntouchableTest::containsAllCollection;
            this.payloads.tap = MultiReaderHashBagAsWriteUntouchableTest::tap;
            this.payloads.forEach = MultiReaderHashBagAsWriteUntouchableTest::forEach;
            this.payloads.forEachWith = MultiReaderHashBagAsWriteUntouchableTest::forEachWith;
            this.payloads.forEachWithIndex = MultiReaderHashBagAsWriteUntouchableTest::forEachWithIndex;
            this.payloads.select = MultiReaderHashBagAsWriteUntouchableTest::select;
            this.payloads.selectWith = MultiReaderHashBagAsWriteUntouchableTest::selectWith;
            this.payloads.selectWith_target = MultiReaderHashBagAsWriteUntouchableTest::selectWith_target;
            this.payloads.reject = MultiReaderHashBagAsWriteUntouchableTest::reject;
            this.payloads.rejectWith = MultiReaderHashBagAsWriteUntouchableTest::rejectWith;
            this.payloads.rejectWith_target = MultiReaderHashBagAsWriteUntouchableTest::rejectWith_target;
            this.payloads.selectInstancesOf = MultiReaderHashBagAsWriteUntouchableTest::selectInstancesOf;
            this.payloads.collect = MultiReaderHashBagAsWriteUntouchableTest::collect;
            this.payloads.collectTarget = MultiReaderHashBagAsWriteUntouchableTest::collectTarget;
            this.payloads.collectBoolean = MultiReaderHashBagAsWriteUntouchableTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = MultiReaderHashBagAsWriteUntouchableTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = MultiReaderHashBagAsWriteUntouchableTest::collectBooleanWithBagTarget;
            this.payloads.collectByte = MultiReaderHashBagAsWriteUntouchableTest::collectByte;
            this.payloads.collectByteWithTarget = MultiReaderHashBagAsWriteUntouchableTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = MultiReaderHashBagAsWriteUntouchableTest::collectByteWithBagTarget;
            this.payloads.collectChar = MultiReaderHashBagAsWriteUntouchableTest::collectChar;
            this.payloads.collectCharWithTarget = MultiReaderHashBagAsWriteUntouchableTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = MultiReaderHashBagAsWriteUntouchableTest::collectCharWithBagTarget;
            this.payloads.collectDouble = MultiReaderHashBagAsWriteUntouchableTest::collectDouble;
            this.payloads.collectDoubleWithTarget = MultiReaderHashBagAsWriteUntouchableTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = MultiReaderHashBagAsWriteUntouchableTest::collectDoubleWithBagTarget;
            this.payloads.collectFloat = MultiReaderHashBagAsWriteUntouchableTest::collectFloat;
            this.payloads.collectFloatWithTarget = MultiReaderHashBagAsWriteUntouchableTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = MultiReaderHashBagAsWriteUntouchableTest::collectFloatWithBagTarget;
            this.payloads.collectInt = MultiReaderHashBagAsWriteUntouchableTest::collectInt;
            this.payloads.collectIntWithTarget = MultiReaderHashBagAsWriteUntouchableTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = MultiReaderHashBagAsWriteUntouchableTest::collectIntWithBagTarget;
            this.payloads.collectLong = MultiReaderHashBagAsWriteUntouchableTest::collectLong;
            this.payloads.collectLongWithTarget = MultiReaderHashBagAsWriteUntouchableTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = MultiReaderHashBagAsWriteUntouchableTest::collectLongWithBagTarget;
            this.payloads.collectShort = MultiReaderHashBagAsWriteUntouchableTest::collectShort;
            this.payloads.collectShortWithTarget = MultiReaderHashBagAsWriteUntouchableTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = MultiReaderHashBagAsWriteUntouchableTest::collectShortWithBagTarget;
            this.payloads.flatCollect = MultiReaderHashBagAsWriteUntouchableTest::flatCollect;
            this.payloads.flatCollectWith = MultiReaderHashBagAsWriteUntouchableTest::flatCollectWith;
            this.payloads.flatCollectBoolean = MultiReaderHashBagAsWriteUntouchableTest::flatCollectBoolean;
            this.payloads.flatCollectByte = MultiReaderHashBagAsWriteUntouchableTest::flatCollectByte;
            this.payloads.flatCollectShort = MultiReaderHashBagAsWriteUntouchableTest::flatCollectShort;
            this.payloads.flatCollectInt = MultiReaderHashBagAsWriteUntouchableTest::flatCollectInt;
            this.payloads.flatCollectChar = MultiReaderHashBagAsWriteUntouchableTest::flatCollectChar;
            this.payloads.flatCollectLong = MultiReaderHashBagAsWriteUntouchableTest::flatCollectLong;
            this.payloads.flatCollectDouble = MultiReaderHashBagAsWriteUntouchableTest::flatCollectDouble;
            this.payloads.flatCollectFloat = MultiReaderHashBagAsWriteUntouchableTest::flatCollectFloat;
            this.payloads.detect = MultiReaderHashBagAsWriteUntouchableTest::detect;
            this.payloads.detectOptional = MultiReaderHashBagAsWriteUntouchableTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsWriteUntouchableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsWriteUntouchableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsWriteUntouchableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsWriteUntouchableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = MultiReaderHashBagAsWriteUntouchableTest::min;
            this.payloads.minOptional = MultiReaderHashBagAsWriteUntouchableTest::minOptional;
            this.payloads.max = MultiReaderHashBagAsWriteUntouchableTest::max;
            this.payloads.maxOptional = MultiReaderHashBagAsWriteUntouchableTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsWriteUntouchableTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsWriteUntouchableTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = MultiReaderHashBagAsWriteUntouchableTest::min_without_comparator;
            this.payloads.max_without_comparator = MultiReaderHashBagAsWriteUntouchableTest::max_without_comparator;
            this.payloads.min_null_safe = MultiReaderHashBagAsWriteUntouchableTest::min_null_safe;
            this.payloads.max_null_safe = MultiReaderHashBagAsWriteUntouchableTest::max_null_safe;
            this.payloads.minBy = MultiReaderHashBagAsWriteUntouchableTest::minBy;
            this.payloads.minByOptional = MultiReaderHashBagAsWriteUntouchableTest::minByOptional;
            this.payloads.maxBy = MultiReaderHashBagAsWriteUntouchableTest::maxBy;
            this.payloads.maxByOptional = MultiReaderHashBagAsWriteUntouchableTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsWriteUntouchableTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsWriteUntouchableTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = MultiReaderHashBagAsWriteUntouchableTest::detectWith;
            this.payloads.detectWithOptional = MultiReaderHashBagAsWriteUntouchableTest::detectWithOptional;
            this.payloads.detectIfNone = MultiReaderHashBagAsWriteUntouchableTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = MultiReaderHashBagAsWriteUntouchableTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = MultiReaderHashBagAsWriteUntouchableTest::allSatisfy;
            this.payloads.allSatisfyWith = MultiReaderHashBagAsWriteUntouchableTest::allSatisfyWith;
            this.payloads.noneSatisfy = MultiReaderHashBagAsWriteUntouchableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = MultiReaderHashBagAsWriteUntouchableTest::noneSatisfyWith;
            this.payloads.anySatisfy = MultiReaderHashBagAsWriteUntouchableTest::anySatisfy;
            this.payloads.anySatisfyWith = MultiReaderHashBagAsWriteUntouchableTest::anySatisfyWith;
            this.payloads.count = MultiReaderHashBagAsWriteUntouchableTest::count;
            this.payloads.countWith = MultiReaderHashBagAsWriteUntouchableTest::countWith;
            this.payloads.collectIf = MultiReaderHashBagAsWriteUntouchableTest::collectIf;
            this.payloads.collectWith = MultiReaderHashBagAsWriteUntouchableTest::collectWith;
            this.payloads.collectWith_target = MultiReaderHashBagAsWriteUntouchableTest::collectWith_target;
            this.payloads.getAny = MultiReaderHashBagAsWriteUntouchableTest::getAny;
            this.payloads.getFirst = MultiReaderHashBagAsWriteUntouchableTest::getFirst;
            this.payloads.getLast = MultiReaderHashBagAsWriteUntouchableTest::getLast;
            this.payloads.getOnly = MultiReaderHashBagAsWriteUntouchableTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsWriteUntouchableTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsWriteUntouchableTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = MultiReaderHashBagAsWriteUntouchableTest::isEmpty;
            this.payloads.iterator = MultiReaderHashBagAsWriteUntouchableTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsWriteUntouchableTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = MultiReaderHashBagAsWriteUntouchableTest::injectInto;
            this.payloads.injectIntoInt = MultiReaderHashBagAsWriteUntouchableTest::injectIntoInt;
            this.payloads.injectIntoLong = MultiReaderHashBagAsWriteUntouchableTest::injectIntoLong;
            this.payloads.injectIntoDouble = MultiReaderHashBagAsWriteUntouchableTest::injectIntoDouble;
            this.payloads.injectIntoFloat = MultiReaderHashBagAsWriteUntouchableTest::injectIntoFloat;
            this.payloads.sumFloat = MultiReaderHashBagAsWriteUntouchableTest::sumFloat;
            this.payloads.summarizeFloat = MultiReaderHashBagAsWriteUntouchableTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = MultiReaderHashBagAsWriteUntouchableTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = MultiReaderHashBagAsWriteUntouchableTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = MultiReaderHashBagAsWriteUntouchableTest::sumDouble;
            this.payloads.summarizeDouble = MultiReaderHashBagAsWriteUntouchableTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = MultiReaderHashBagAsWriteUntouchableTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = MultiReaderHashBagAsWriteUntouchableTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = MultiReaderHashBagAsWriteUntouchableTest::sumInteger;
            this.payloads.summarizeInt = MultiReaderHashBagAsWriteUntouchableTest::summarizeInt;
            this.payloads.sumLong = MultiReaderHashBagAsWriteUntouchableTest::sumLong;
            this.payloads.summarizeLong = MultiReaderHashBagAsWriteUntouchableTest::summarizeLong;
            this.payloads.sumByInt = MultiReaderHashBagAsWriteUntouchableTest::sumByInt;
            this.payloads.sumByFloat = MultiReaderHashBagAsWriteUntouchableTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = MultiReaderHashBagAsWriteUntouchableTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = MultiReaderHashBagAsWriteUntouchableTest::sumByLong;
            this.payloads.sumByDouble = MultiReaderHashBagAsWriteUntouchableTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = MultiReaderHashBagAsWriteUntouchableTest::sumByDoubleConsistentRounding;
            this.payloads.toArray = MultiReaderHashBagAsWriteUntouchableTest::toArray;
            this.payloads.partition = MultiReaderHashBagAsWriteUntouchableTest::partition;
            this.payloads.partitionWith = MultiReaderHashBagAsWriteUntouchableTest::partitionWith;
            this.payloads.toList = MultiReaderHashBagAsWriteUntouchableTest::toList;
            this.payloads.toImmutableList = MultiReaderHashBagAsWriteUntouchableTest::toImmutableList;
            this.payloads.toCollection = MultiReaderHashBagAsWriteUntouchableTest::toCollection;
            this.payloads.toBag = MultiReaderHashBagAsWriteUntouchableTest::toBag;
            this.payloads.toImmutableBag = MultiReaderHashBagAsWriteUntouchableTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = MultiReaderHashBagAsWriteUntouchableTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = MultiReaderHashBagAsWriteUntouchableTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = MultiReaderHashBagAsWriteUntouchableTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = MultiReaderHashBagAsWriteUntouchableTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsWriteUntouchableTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = MultiReaderHashBagAsWriteUntouchableTest::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = MultiReaderHashBagAsWriteUntouchableTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = MultiReaderHashBagAsWriteUntouchableTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = MultiReaderHashBagAsWriteUntouchableTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsWriteUntouchableTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = MultiReaderHashBagAsWriteUntouchableTest::toSortedBagBy;
            this.payloads.toImmutableSortedBagBy = MultiReaderHashBagAsWriteUntouchableTest::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = MultiReaderHashBagAsWriteUntouchableTest::toSortedListBy;
            this.payloads.toImmutableSortedListBy = MultiReaderHashBagAsWriteUntouchableTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = MultiReaderHashBagAsWriteUntouchableTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = MultiReaderHashBagAsWriteUntouchableTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = MultiReaderHashBagAsWriteUntouchableTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = MultiReaderHashBagAsWriteUntouchableTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = MultiReaderHashBagAsWriteUntouchableTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = MultiReaderHashBagAsWriteUntouchableTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsWriteUntouchableTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = MultiReaderHashBagAsWriteUntouchableTest::toSet;
            this.payloads.toImmutableSet = MultiReaderHashBagAsWriteUntouchableTest::toImmutableSet;
            this.payloads.toMap = MultiReaderHashBagAsWriteUntouchableTest::toMap;
            this.payloads.toImmutableMap = MultiReaderHashBagAsWriteUntouchableTest::toImmutableMap;
            this.payloads.toMapTarget = MultiReaderHashBagAsWriteUntouchableTest::toMapTarget;
            this.payloads.toSortedMap = MultiReaderHashBagAsWriteUntouchableTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = MultiReaderHashBagAsWriteUntouchableTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = MultiReaderHashBagAsWriteUntouchableTest::toSortedMapBy;
            this.payloads.toBiMap = MultiReaderHashBagAsWriteUntouchableTest::toBiMap;
            this.payloads.toImmutableBiMap = MultiReaderHashBagAsWriteUntouchableTest::toImmutableBiMap;
            this.payloads.makeStringWithSeparator = MultiReaderHashBagAsWriteUntouchableTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = MultiReaderHashBagAsWriteUntouchableTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = MultiReaderHashBagAsWriteUntouchableTest::fusedCollectMakeString;
            this.payloads.appendStringWithSeparator = MultiReaderHashBagAsWriteUntouchableTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = MultiReaderHashBagAsWriteUntouchableTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = MultiReaderHashBagAsWriteUntouchableTest::appendStringThrows;
            this.payloads.countBy = MultiReaderHashBagAsWriteUntouchableTest::countBy;
            this.payloads.countByWith = MultiReaderHashBagAsWriteUntouchableTest::countByWith;
            this.payloads.countByEach = MultiReaderHashBagAsWriteUntouchableTest::countByEach;
            this.payloads.groupBy = MultiReaderHashBagAsWriteUntouchableTest::groupBy;
            this.payloads.groupByEach = MultiReaderHashBagAsWriteUntouchableTest::groupByEach;
            this.payloads.groupByUniqueKey = MultiReaderHashBagAsWriteUntouchableTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsWriteUntouchableTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = MultiReaderHashBagAsWriteUntouchableTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsWriteUntouchableTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = MultiReaderHashBagAsWriteUntouchableTest::zip;
            this.payloads.zipWithIndex = MultiReaderHashBagAsWriteUntouchableTest::zipWithIndex;
            this.payloads.chunk = MultiReaderHashBagAsWriteUntouchableTest::chunk;
            this.payloads.chunk_empty = MultiReaderHashBagAsWriteUntouchableTest::chunk_empty;
            this.payloads.chunk_single = MultiReaderHashBagAsWriteUntouchableTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsWriteUntouchableTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = MultiReaderHashBagAsWriteUntouchableTest::chunk_large_size;
            this.payloads.empty = MultiReaderHashBagAsWriteUntouchableTest::empty;
            this.payloads.notEmpty = MultiReaderHashBagAsWriteUntouchableTest::notEmpty;
            this.payloads.aggregateByMutating = MultiReaderHashBagAsWriteUntouchableTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = MultiReaderHashBagAsWriteUntouchableTest::aggregateByNonMutating;
            this.payloads.reduceOptional = MultiReaderHashBagAsWriteUntouchableTest::reduceOptional;
            this.payloads.newEmpty = MultiReaderHashBagAsWriteUntouchableTest::newEmpty;
            this.payloads.toImmutable = MultiReaderHashBagAsWriteUntouchableTest::toImmutable;
            this.payloads.testNewWith = MultiReaderHashBagAsWriteUntouchableTest::testNewWith;
            this.payloads.testNewWithWith = MultiReaderHashBagAsWriteUntouchableTest::testNewWithWith;
            this.payloads.testNewWithWithWith = MultiReaderHashBagAsWriteUntouchableTest::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = MultiReaderHashBagAsWriteUntouchableTest::testNewWithVarArgs;
            this.payloads.addAll = MultiReaderHashBagAsWriteUntouchableTest::addAll;
            this.payloads.addAllIterable = MultiReaderHashBagAsWriteUntouchableTest::addAllIterable;
            this.payloads.removeAll = MultiReaderHashBagAsWriteUntouchableTest::removeAll;
            this.payloads.removeAllIterable = MultiReaderHashBagAsWriteUntouchableTest::removeAllIterable;
            this.payloads.retainAll = MultiReaderHashBagAsWriteUntouchableTest::retainAll;
            this.payloads.retainAllIterable = MultiReaderHashBagAsWriteUntouchableTest::retainAllIterable;
            this.payloads.clear = MultiReaderHashBagAsWriteUntouchableTest::clear;
            this.payloads.injectIntoWith = MultiReaderHashBagAsWriteUntouchableTest::injectIntoWith;
            this.payloads.removeObject = MultiReaderHashBagAsWriteUntouchableTest::removeObject;
            this.payloads.selectAndRejectWith = MultiReaderHashBagAsWriteUntouchableTest::selectAndRejectWith;
            this.payloads.removeIf = MultiReaderHashBagAsWriteUntouchableTest::removeIf;
            this.payloads.removeIfWith = MultiReaderHashBagAsWriteUntouchableTest::removeIfWith;
            this.payloads.with = MultiReaderHashBagAsWriteUntouchableTest::with;
            this.payloads.withAll = MultiReaderHashBagAsWriteUntouchableTest::withAll;
            this.payloads.without = MultiReaderHashBagAsWriteUntouchableTest::without;
            this.payloads.withoutAll = MultiReaderHashBagAsWriteUntouchableTest::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = MultiReaderHashBagAsWriteUntouchableTest::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = MultiReaderHashBagAsWriteUntouchableTest::asLazy;
            this.payloads.asSynchronized = MultiReaderHashBagAsWriteUntouchableTest::asSynchronized;
            this.payloads.asUnmodifiable = MultiReaderHashBagAsWriteUntouchableTest::asUnmodifiable;
            this.payloads.addOccurrences = MultiReaderHashBagAsWriteUntouchableTest::addOccurrences;
            this.payloads.makeString = MultiReaderHashBagAsWriteUntouchableTest::makeString;
            this.payloads.appendString = MultiReaderHashBagAsWriteUntouchableTest::appendString;
            this.payloads.testToString = MultiReaderHashBagAsWriteUntouchableTest::testToString;
            this.payloads.selectUnique = MultiReaderHashBagAsWriteUntouchableTest::selectUnique;
            this.payloads.distinctView = MultiReaderHashBagAsWriteUntouchableTest::distinctView;
        }
    }
}
