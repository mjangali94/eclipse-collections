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

import java.util.Collections;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class HashBagTest extends MutableBagTestCase {

    @Override
    protected <T> MutableBag<T> newWith(T... littleElements) {
        return HashBag.newBagWith(littleElements);
    }

    @Override
    protected <T> MutableBag<T> newWithOccurrences(ObjectIntPair<T>... elementsWithOccurrences) {
        MutableBag<T> bag = this.newWith();
        for (int i = 0; i < elementsWithOccurrences.length; i++) {
            ObjectIntPair<T> itemToAdd = elementsWithOccurrences[i];
            bag.addOccurrences(itemToAdd.getOne(), itemToAdd.getTwo());
        }
        return bag;
    }

    @Test
    public void newBagWith() {
        HashBag<String> bag = new HashBag<String>().with("apple", "apple");
        assertBagsEqual(HashBag.newBagWith("apple", "apple"), bag);
        bag.with("hope", "hope", "hope");
        assertBagsEqual(HashBag.newBagWith("apple", "apple", "hope", "hope", "hope"), bag);
        bag.withAll(Collections.nCopies(5, "ubermench"));
        Assert.assertEquals(UnifiedMap.newWithKeysValues("apple", 2, "hope", 3, "ubermench", 5), bag.toMapOfItemToCount());
    }

    @Override
    @Test
    public void addAll() {
        super.addAll();
        MutableBag<Integer> bag1 = this.newWith();
        Assert.assertTrue(bag1.addAll(this.newWith(1, 1, 2, 3)));
        Verify.assertContainsAll(bag1, 1, 2, 3);
        Assert.assertTrue(bag1.addAll(this.newWith(1, 2, 3)));
        Verify.assertSize(7, bag1);
        Assert.assertFalse(bag1.addAll(this.newWith()));
        Verify.assertContainsAll(bag1, 1, 2, 3);
        MutableBag<Integer> bag2 = this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
        bag2.addAll(this.newWith(5, 5, 5, 5, 5));
        Verify.assertBagsEqual(this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5), bag2);
        MutableBag<Integer> bag3 = this.newWith(1, 2, 2, 3, 3, 3);
        bag3.addAll(this.newWith(1));
        Verify.assertBagsEqual(this.newWith(1, 1, 2, 2, 3, 3, 3), bag3);
    }

    @Test
    public void newBagFromIterable() {
        assertBagsEqual(HashBag.newBagWith(1, 2, 2, 3, 3, 3), HashBag.newBag(FastList.newListWith(1, 2, 2, 3, 3, 3)));
    }

    @Test
    public void newBagFromBag() {
        Assert.assertEquals(HashBag.newBagWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4), HashBag.newBag(HashBag.newBagWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4)));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private HashBagTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewCollection);
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
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
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
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
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
        public void benchmark_selectAndRejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectAndRejectWith);
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
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStringOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStringOfItemToCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapOfItemToCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorRemove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorRemove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorRemove2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorRemove2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occurrencesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occurrencesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addOccurrences_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeOccurrences_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeOccurrences_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_setOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.setOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_setOccurrences_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.setOccurrences_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
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
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
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
        public void benchmark_selectByOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectByOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectDuplicates() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectDuplicates);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_topOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.topOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_bottomOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.bottomOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectUnique);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newBagWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newBagWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newBagFromIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newBagFromIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newBagFromBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newBagFromBag);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> payload) throws java.lang.Throwable {
            this.instance = new HashBagTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toMapOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> iteratorRemove2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> collectWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> occurrencesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> addOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> addOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> removeOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> removeOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> setOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> setOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toSortedListWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> anySatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> noneSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> allSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> detectWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> distinctView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> newBagWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> newBagFromIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagTest> newBagFromBag;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = HashBagTest::testNewCollection;
            this.payloads.contains = HashBagTest::contains;
            this.payloads.containsBy = HashBagTest::containsBy;
            this.payloads.containsAllIterable = HashBagTest::containsAllIterable;
            this.payloads.containsAnyIterable = HashBagTest::containsAnyIterable;
            this.payloads.containsNoneIterable = HashBagTest::containsNoneIterable;
            this.payloads.containsAllArray = HashBagTest::containsAllArray;
            this.payloads.containsAnyCollection = HashBagTest::containsAnyCollection;
            this.payloads.containsNoneCollection = HashBagTest::containsNoneCollection;
            this.payloads.containsAllCollection = HashBagTest::containsAllCollection;
            this.payloads.tap = HashBagTest::tap;
            this.payloads.forEachWith = HashBagTest::forEachWith;
            this.payloads.forEachWithIndex = HashBagTest::forEachWithIndex;
            this.payloads.select = HashBagTest::select;
            this.payloads.selectWith = HashBagTest::selectWith;
            this.payloads.selectWith_target = HashBagTest::selectWith_target;
            this.payloads.reject = HashBagTest::reject;
            this.payloads.rejectWith = HashBagTest::rejectWith;
            this.payloads.rejectWith_target = HashBagTest::rejectWith_target;
            this.payloads.selectInstancesOf = HashBagTest::selectInstancesOf;
            this.payloads.collect = HashBagTest::collect;
            this.payloads.collectTarget = HashBagTest::collectTarget;
            this.payloads.collectBoolean = HashBagTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = HashBagTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = HashBagTest::collectBooleanWithBagTarget;
            this.payloads.collectByte = HashBagTest::collectByte;
            this.payloads.collectByteWithTarget = HashBagTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = HashBagTest::collectByteWithBagTarget;
            this.payloads.collectChar = HashBagTest::collectChar;
            this.payloads.collectCharWithTarget = HashBagTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = HashBagTest::collectCharWithBagTarget;
            this.payloads.collectDouble = HashBagTest::collectDouble;
            this.payloads.collectDoubleWithTarget = HashBagTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = HashBagTest::collectDoubleWithBagTarget;
            this.payloads.collectFloat = HashBagTest::collectFloat;
            this.payloads.collectFloatWithTarget = HashBagTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = HashBagTest::collectFloatWithBagTarget;
            this.payloads.collectInt = HashBagTest::collectInt;
            this.payloads.collectIntWithTarget = HashBagTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = HashBagTest::collectIntWithBagTarget;
            this.payloads.collectLong = HashBagTest::collectLong;
            this.payloads.collectLongWithTarget = HashBagTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = HashBagTest::collectLongWithBagTarget;
            this.payloads.collectShort = HashBagTest::collectShort;
            this.payloads.collectShortWithTarget = HashBagTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = HashBagTest::collectShortWithBagTarget;
            this.payloads.flatCollect = HashBagTest::flatCollect;
            this.payloads.flatCollectWith = HashBagTest::flatCollectWith;
            this.payloads.flatCollectBoolean = HashBagTest::flatCollectBoolean;
            this.payloads.flatCollectByte = HashBagTest::flatCollectByte;
            this.payloads.flatCollectShort = HashBagTest::flatCollectShort;
            this.payloads.flatCollectInt = HashBagTest::flatCollectInt;
            this.payloads.flatCollectChar = HashBagTest::flatCollectChar;
            this.payloads.flatCollectLong = HashBagTest::flatCollectLong;
            this.payloads.flatCollectDouble = HashBagTest::flatCollectDouble;
            this.payloads.flatCollectFloat = HashBagTest::flatCollectFloat;
            this.payloads.detect = HashBagTest::detect;
            this.payloads.detectOptional = HashBagTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = HashBagTest::min;
            this.payloads.minOptional = HashBagTest::minOptional;
            this.payloads.max = HashBagTest::max;
            this.payloads.maxOptional = HashBagTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = HashBagTest::min_without_comparator;
            this.payloads.max_without_comparator = HashBagTest::max_without_comparator;
            this.payloads.min_null_safe = HashBagTest::min_null_safe;
            this.payloads.max_null_safe = HashBagTest::max_null_safe;
            this.payloads.minBy = HashBagTest::minBy;
            this.payloads.minByOptional = HashBagTest::minByOptional;
            this.payloads.maxBy = HashBagTest::maxBy;
            this.payloads.maxByOptional = HashBagTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = HashBagTest::detectWith;
            this.payloads.detectWithOptional = HashBagTest::detectWithOptional;
            this.payloads.detectIfNone = HashBagTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = HashBagTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = HashBagTest::allSatisfy;
            this.payloads.allSatisfyWith = HashBagTest::allSatisfyWith;
            this.payloads.noneSatisfy = HashBagTest::noneSatisfy;
            this.payloads.noneSatisfyWith = HashBagTest::noneSatisfyWith;
            this.payloads.anySatisfy = HashBagTest::anySatisfy;
            this.payloads.anySatisfyWith = HashBagTest::anySatisfyWith;
            this.payloads.count = HashBagTest::count;
            this.payloads.countWith = HashBagTest::countWith;
            this.payloads.collectIf = HashBagTest::collectIf;
            this.payloads.collectWith = HashBagTest::collectWith;
            this.payloads.collectWith_target = HashBagTest::collectWith_target;
            this.payloads.getAny = HashBagTest::getAny;
            this.payloads.getFirst = HashBagTest::getFirst;
            this.payloads.getOnly = HashBagTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = HashBagTest::isEmpty;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = HashBagTest::injectInto;
            this.payloads.injectIntoInt = HashBagTest::injectIntoInt;
            this.payloads.injectIntoLong = HashBagTest::injectIntoLong;
            this.payloads.injectIntoDouble = HashBagTest::injectIntoDouble;
            this.payloads.injectIntoFloat = HashBagTest::injectIntoFloat;
            this.payloads.sumFloat = HashBagTest::sumFloat;
            this.payloads.summarizeFloat = HashBagTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = HashBagTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = HashBagTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = HashBagTest::sumDouble;
            this.payloads.summarizeDouble = HashBagTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = HashBagTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = HashBagTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = HashBagTest::sumInteger;
            this.payloads.summarizeInt = HashBagTest::summarizeInt;
            this.payloads.sumLong = HashBagTest::sumLong;
            this.payloads.summarizeLong = HashBagTest::summarizeLong;
            this.payloads.sumByInt = HashBagTest::sumByInt;
            this.payloads.sumByFloat = HashBagTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = HashBagTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = HashBagTest::sumByLong;
            this.payloads.sumByDouble = HashBagTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = HashBagTest::sumByDoubleConsistentRounding;
            this.payloads.toArray = HashBagTest::toArray;
            this.payloads.toImmutableList = HashBagTest::toImmutableList;
            this.payloads.toCollection = HashBagTest::toCollection;
            this.payloads.toBag = HashBagTest::toBag;
            this.payloads.toImmutableBag = HashBagTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = HashBagTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = HashBagTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = HashBagTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = HashBagTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = HashBagTest::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = HashBagTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = HashBagTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = HashBagTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = HashBagTest::toSortedBagBy;
            this.payloads.toImmutableSortedBagBy = HashBagTest::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = HashBagTest::toSortedListBy;
            this.payloads.toImmutableSortedListBy = HashBagTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = HashBagTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = HashBagTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = HashBagTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = HashBagTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = HashBagTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = HashBagTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSet = HashBagTest::toImmutableSet;
            this.payloads.toMap = HashBagTest::toMap;
            this.payloads.toImmutableMap = HashBagTest::toImmutableMap;
            this.payloads.toMapTarget = HashBagTest::toMapTarget;
            this.payloads.toSortedMap = HashBagTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = HashBagTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = HashBagTest::toSortedMapBy;
            this.payloads.toBiMap = HashBagTest::toBiMap;
            this.payloads.toImmutableBiMap = HashBagTest::toImmutableBiMap;
            this.payloads.testToString = HashBagTest::testToString;
            this.payloads.makeString = HashBagTest::makeString;
            this.payloads.makeStringWithSeparator = HashBagTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = HashBagTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = HashBagTest::fusedCollectMakeString;
            this.payloads.appendString = HashBagTest::appendString;
            this.payloads.appendStringWithSeparator = HashBagTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = HashBagTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = HashBagTest::appendStringThrows;
            this.payloads.countBy = HashBagTest::countBy;
            this.payloads.countByWith = HashBagTest::countByWith;
            this.payloads.countByEach = HashBagTest::countByEach;
            this.payloads.groupBy = HashBagTest::groupBy;
            this.payloads.groupByEach = HashBagTest::groupByEach;
            this.payloads.groupByUniqueKey = HashBagTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = HashBagTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zipWithIndex = HashBagTest::zipWithIndex;
            this.payloads.chunk = HashBagTest::chunk;
            this.payloads.chunk_empty = HashBagTest::chunk_empty;
            this.payloads.chunk_single = HashBagTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = HashBagTest::chunk_large_size;
            this.payloads.empty = HashBagTest::empty;
            this.payloads.notEmpty = HashBagTest::notEmpty;
            this.payloads.aggregateByMutating = HashBagTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = HashBagTest::aggregateByNonMutating;
            this.payloads.reduceOptional = HashBagTest::reduceOptional;
            this.payloads.newEmpty = HashBagTest::newEmpty;
            this.payloads.testNewWith = HashBagTest::testNewWith;
            this.payloads.testNewWithWith = HashBagTest::testNewWithWith;
            this.payloads.testNewWithWithWith = HashBagTest::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = HashBagTest::testNewWithVarArgs;
            this.payloads.addAllIterable = HashBagTest::addAllIterable;
            this.payloads.removeAll = HashBagTest::removeAll;
            this.payloads.removeAllIterable = HashBagTest::removeAllIterable;
            this.payloads.retainAll = HashBagTest::retainAll;
            this.payloads.retainAllIterable = HashBagTest::retainAllIterable;
            this.payloads.clear = HashBagTest::clear;
            this.payloads.injectIntoWith = HashBagTest::injectIntoWith;
            this.payloads.selectAndRejectWith = HashBagTest::selectAndRejectWith;
            this.payloads.removeIfWith = HashBagTest::removeIfWith;
            this.payloads.with = HashBagTest::with;
            this.payloads.withAll = HashBagTest::withAll;
            this.payloads.without = HashBagTest::without;
            this.payloads.withoutAll = HashBagTest::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = HashBagTest::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = HashBagTest::asLazy;
            this.payloads.equalsAndHashCode = HashBagTest::equalsAndHashCode;
            this.payloads.toStringOfItemToCount = HashBagTest::toStringOfItemToCount;
            this.payloads.toMapOfItemToCount = HashBagTest::toMapOfItemToCount;
            this.payloads.add = HashBagTest::add;
            this.payloads.iterator = HashBagTest::iterator;
            this.payloads.iteratorRemove = HashBagTest::iteratorRemove;
            this.payloads.iteratorRemove2 = HashBagTest::iteratorRemove2;
            this.payloads.removeIf = HashBagTest::removeIf;
            this.payloads.forEach = HashBagTest::forEach;
            this.payloads.forEachWithOccurrences = HashBagTest::forEachWithOccurrences;
            this.payloads.collectWithOccurrences = HashBagTest::collectWithOccurrences;
            this.payloads.toImmutable = HashBagTest::toImmutable;
            this.payloads.getLast = HashBagTest::getLast;
            this.payloads.occurrencesOf = HashBagTest::occurrencesOf;
            this.payloads.addOccurrences = HashBagTest::addOccurrences;
            this.payloads.addOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagTest::addOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.removeOccurrences = HashBagTest::removeOccurrences;
            this.payloads.removeOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagTest::removeOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.setOccurrences = HashBagTest::setOccurrences;
            this.payloads.setOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagTest::setOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.toSortedListWith = HashBagTest::toSortedListWith;
            this.payloads.toSet = HashBagTest::toSet;
            this.payloads.toList = HashBagTest::toList;
            this.payloads.removeObject = HashBagTest::removeObject;
            this.payloads.asSynchronized = HashBagTest::asSynchronized;
            this.payloads.asUnmodifiable = HashBagTest::asUnmodifiable;
            this.payloads.serialization = HashBagTest::serialization;
            this.payloads.partition = HashBagTest::partition;
            this.payloads.partitionWith = HashBagTest::partitionWith;
            this.payloads.selectByOccurrences = HashBagTest::selectByOccurrences;
            this.payloads.selectDuplicates = HashBagTest::selectDuplicates;
            this.payloads.topOccurrences = HashBagTest::topOccurrences;
            this.payloads.anySatisfyWithOccurrences = HashBagTest::anySatisfyWithOccurrences;
            this.payloads.noneSatisfyWithOccurrences = HashBagTest::noneSatisfyWithOccurrences;
            this.payloads.allSatisfyWithOccurrences = HashBagTest::allSatisfyWithOccurrences;
            this.payloads.detectWithOccurrences = HashBagTest::detectWithOccurrences;
            this.payloads.bottomOccurrences = HashBagTest::bottomOccurrences;
            this.payloads.selectUnique = HashBagTest::selectUnique;
            this.payloads.zip = HashBagTest::zip;
            this.payloads.distinctView = HashBagTest::distinctView;
            this.payloads.newBagWith = HashBagTest::newBagWith;
            this.payloads.addAll = HashBagTest::addAll;
            this.payloads.newBagFromIterable = HashBagTest::newBagFromIterable;
            this.payloads.newBagFromBag = HashBagTest::newBagFromBag;
        }
    }
}
