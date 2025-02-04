/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable;

import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.ConcurrentMutableMap;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.parallel.ParallelIterate;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class ConcurrentHashMapTestCase extends MutableMapTestCase {

    protected ExecutorService executor;

    @Before
    public void setUp() {
        this.executor = Executors.newFixedThreadPool(20);
    }

    @After
    public void tearDown() {
        this.executor.shutdown();
    }

    @Override
    protected abstract <K, V> ConcurrentMutableMap<K, V> newMap();

    @Override
    @Test
    public void updateValue() {
        super.updateValue();
        ConcurrentMutableMap<Integer, Integer> map = this.newMap();
        ParallelIterate.forEach(Interval.oneTo(100), each -> map.updateValue(each % 10, () -> 0, integer -> integer + 1), 1, this.executor);
        Assert.assertEquals(Interval.zeroTo(9).toSet(), map.keySet());
        Assert.assertEquals(FastList.newList(Collections.nCopies(10, 10)), FastList.newList(map.values()));
    }

    @Override
    @Test
    public void updateValue_collisions() {
        super.updateValue_collisions();
        ConcurrentMutableMap<Integer, Integer> map = this.newMap();
        MutableList<Integer> list = Interval.oneTo(100).toList().shuffleThis();
        ParallelIterate.forEach(list, each -> map.updateValue(each % 50, () -> 0, integer -> integer + 1), 1, this.executor);
        Assert.assertEquals(Interval.zeroTo(49).toSet(), map.keySet());
        Assert.assertEquals(HashBag.newBag(map.values()).toStringOfItemToCount(), FastList.newList(Collections.nCopies(50, 2)), FastList.newList(map.values()));
    }

    @Override
    @Test
    public void updateValueWith() {
        super.updateValueWith();
        ConcurrentMutableMap<Integer, Integer> map = this.newMap();
        ParallelIterate.forEach(Interval.oneTo(100), each -> map.updateValueWith(each % 10, () -> 0, (integer, parameter) -> {
            Assert.assertEquals("test", parameter);
            return integer + 1;
        }, "test"), 1, this.executor);
        Assert.assertEquals(Interval.zeroTo(9).toSet(), map.keySet());
        Assert.assertEquals(FastList.newList(Collections.nCopies(10, 10)), FastList.newList(map.values()));
    }

    @Override
    @Test
    public void updateValueWith_collisions() {
        super.updateValueWith_collisions();
        ConcurrentMutableMap<Integer, Integer> map = this.newMap();
        MutableList<Integer> list = Interval.oneTo(200).toList().shuffleThis();
        ParallelIterate.forEach(list, each -> map.updateValueWith(each % 100, () -> 0, (integer, parameter) -> {
            Assert.assertEquals("test", parameter);
            return integer + 1;
        }, "test"), 1, this.executor);
        Assert.assertEquals(Interval.zeroTo(99).toSet(), map.keySet());
        Assert.assertEquals(HashBag.newBag(map.values()).toStringOfItemToCount(), FastList.newList(Collections.nCopies(100, 2)), FastList.newList(map.values()));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ConcurrentHashMapTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ifPresentApply() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ifPresentApply);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent_function() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent_function);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrDefault() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrDefault);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithToTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_throws_when_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_throws_when_empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_throws_when_multiple_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_throws_when_multiple_values);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArguments);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatten_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatten_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAggregateBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAggregateBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyValuesView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_nullCollisionWithCastInEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.nullCollisionWithCastInEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMapWithKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMapWithKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWithWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWithWithWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWithWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWithWithWithWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_test_toString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.test_toString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromEntrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromEntrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromEntrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clearEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clearEntrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySetEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySetEqualsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeNullFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeNullFromKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clearKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clearKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetEqualsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetToArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetToArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeNullFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeNullFromValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllKeys);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_block_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_block_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith_block_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith_block_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getKeysAndGetValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getKeysAndGetValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysAndValues_toString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysAndValues_toString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyPreservation() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyPreservation);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapEmptyAndTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapNull);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableEmptyAndTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableNull);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableEmptyAndTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableNull);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValueArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValueArguments);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAllKeys);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromKeySet_null_collision() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromKeySet_null_collision);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rehash_null_collision() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rehash_null_collision);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectKeysAndValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectKeysAndValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue_collisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue_collisions);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith_collisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith_collisions);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new ConcurrentHashMapTestCase();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> test_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> removeFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> removeAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> retainAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> clearEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> entrySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> keySetToArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> removeFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> removeNullFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> removeAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> retainAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> removeAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> getIfAbsentPutValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> getIfAbsentPut_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> getIfAbsentPutWith_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> getKeysAndGetValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> keysAndValues_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> keyPreservation;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> withKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> withMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> withMapEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> withMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> withMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> withMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> withMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> withMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> putAllMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> putAllMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> putAllMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> putAllMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> putAllMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> withAllKeyValueArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> retainAllFromKeySet_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> rehash_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> collectKeysAndValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> updateValue_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentHashMapTestCase> updateValueWith_collisions;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = ConcurrentHashMapTestCase::stream;
            this.payloads.parallelStream = ConcurrentHashMapTestCase::parallelStream;
            this.payloads.equalsAndHashCode = ConcurrentHashMapTestCase::equalsAndHashCode;
            this.payloads.serialization = ConcurrentHashMapTestCase::serialization;
            this.payloads.isEmpty = ConcurrentHashMapTestCase::isEmpty;
            this.payloads.notEmpty = ConcurrentHashMapTestCase::notEmpty;
            this.payloads.ifPresentApply = ConcurrentHashMapTestCase::ifPresentApply;
            this.payloads.getIfAbsent_function = ConcurrentHashMapTestCase::getIfAbsent_function;
            this.payloads.getOrDefault = ConcurrentHashMapTestCase::getOrDefault;
            this.payloads.getIfAbsent = ConcurrentHashMapTestCase::getIfAbsent;
            this.payloads.getIfAbsentWith = ConcurrentHashMapTestCase::getIfAbsentWith;
            this.payloads.tap = ConcurrentHashMapTestCase::tap;
            this.payloads.forEach = ConcurrentHashMapTestCase::forEach;
            this.payloads.forEachWith = ConcurrentHashMapTestCase::forEachWith;
            this.payloads.forEachWithIndex = ConcurrentHashMapTestCase::forEachWithIndex;
            this.payloads.forEachKey = ConcurrentHashMapTestCase::forEachKey;
            this.payloads.forEachValue = ConcurrentHashMapTestCase::forEachValue;
            this.payloads.forEachKeyValue = ConcurrentHashMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ConcurrentHashMapTestCase::injectIntoKeyValue;
            this.payloads.flipUniqueValues = ConcurrentHashMapTestCase::flipUniqueValues;
            this.payloads.collectMap = ConcurrentHashMapTestCase::collectMap;
            this.payloads.collectBoolean = ConcurrentHashMapTestCase::collectBoolean;
            this.payloads.collectBooleanWithTarget = ConcurrentHashMapTestCase::collectBooleanWithTarget;
            this.payloads.collectByte = ConcurrentHashMapTestCase::collectByte;
            this.payloads.collectByteWithTarget = ConcurrentHashMapTestCase::collectByteWithTarget;
            this.payloads.collectChar = ConcurrentHashMapTestCase::collectChar;
            this.payloads.collectCharWithTarget = ConcurrentHashMapTestCase::collectCharWithTarget;
            this.payloads.collectDouble = ConcurrentHashMapTestCase::collectDouble;
            this.payloads.collectDoubleWithTarget = ConcurrentHashMapTestCase::collectDoubleWithTarget;
            this.payloads.collectFloat = ConcurrentHashMapTestCase::collectFloat;
            this.payloads.collectFloatWithTarget = ConcurrentHashMapTestCase::collectFloatWithTarget;
            this.payloads.collectInt = ConcurrentHashMapTestCase::collectInt;
            this.payloads.collectIntWithTarget = ConcurrentHashMapTestCase::collectIntWithTarget;
            this.payloads.collectLong = ConcurrentHashMapTestCase::collectLong;
            this.payloads.collectLongWithTarget = ConcurrentHashMapTestCase::collectLongWithTarget;
            this.payloads.collectShort = ConcurrentHashMapTestCase::collectShort;
            this.payloads.collectShortWithTarget = ConcurrentHashMapTestCase::collectShortWithTarget;
            this.payloads.collectValues = ConcurrentHashMapTestCase::collectValues;
            this.payloads.select = ConcurrentHashMapTestCase::select;
            this.payloads.selectWith = ConcurrentHashMapTestCase::selectWith;
            this.payloads.reject = ConcurrentHashMapTestCase::reject;
            this.payloads.rejectWith = ConcurrentHashMapTestCase::rejectWith;
            this.payloads.collect = ConcurrentHashMapTestCase::collect;
            this.payloads.flatCollect = ConcurrentHashMapTestCase::flatCollect;
            this.payloads.flatCollectWith = ConcurrentHashMapTestCase::flatCollectWith;
            this.payloads.selectMap = ConcurrentHashMapTestCase::selectMap;
            this.payloads.rejectMap = ConcurrentHashMapTestCase::rejectMap;
            this.payloads.flip = ConcurrentHashMapTestCase::flip;
            this.payloads.detect = ConcurrentHashMapTestCase::detect;
            this.payloads.detectOptional = ConcurrentHashMapTestCase::detectOptional;
            this.payloads.anySatisfy = ConcurrentHashMapTestCase::anySatisfy;
            this.payloads.anySatisfyWith = ConcurrentHashMapTestCase::anySatisfyWith;
            this.payloads.allSatisfy = ConcurrentHashMapTestCase::allSatisfy;
            this.payloads.allSatisfyWith = ConcurrentHashMapTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = ConcurrentHashMapTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = ConcurrentHashMapTestCase::noneSatisfyWith;
            this.payloads.appendString = ConcurrentHashMapTestCase::appendString;
            this.payloads.toBag = ConcurrentHashMapTestCase::toBag;
            this.payloads.toSortedBag = ConcurrentHashMapTestCase::toSortedBag;
            this.payloads.toSortedBagBy = ConcurrentHashMapTestCase::toSortedBagBy;
            this.payloads.asLazy = ConcurrentHashMapTestCase::asLazy;
            this.payloads.toList = ConcurrentHashMapTestCase::toList;
            this.payloads.toMap = ConcurrentHashMapTestCase::toMap;
            this.payloads.toSet = ConcurrentHashMapTestCase::toSet;
            this.payloads.toSortedList = ConcurrentHashMapTestCase::toSortedList;
            this.payloads.toSortedListBy = ConcurrentHashMapTestCase::toSortedListBy;
            this.payloads.toSortedSet = ConcurrentHashMapTestCase::toSortedSet;
            this.payloads.toSortedSetBy = ConcurrentHashMapTestCase::toSortedSetBy;
            this.payloads.toSortedMap = ConcurrentHashMapTestCase::toSortedMap;
            this.payloads.chunk = ConcurrentHashMapTestCase::chunk;
            this.payloads.collect_value = ConcurrentHashMapTestCase::collect_value;
            this.payloads.collectIf = ConcurrentHashMapTestCase::collectIf;
            this.payloads.collectWith = ConcurrentHashMapTestCase::collectWith;
            this.payloads.collectWithToTarget = ConcurrentHashMapTestCase::collectWithToTarget;
            this.payloads.contains = ConcurrentHashMapTestCase::contains;
            this.payloads.containsAnyIterable = ConcurrentHashMapTestCase::containsAnyIterable;
            this.payloads.containsNoneIterable = ConcurrentHashMapTestCase::containsNoneIterable;
            this.payloads.containsAnyCollection = ConcurrentHashMapTestCase::containsAnyCollection;
            this.payloads.containsNoneCollection = ConcurrentHashMapTestCase::containsNoneCollection;
            this.payloads.containsAll = ConcurrentHashMapTestCase::containsAll;
            this.payloads.containsKey = ConcurrentHashMapTestCase::containsKey;
            this.payloads.containsValue = ConcurrentHashMapTestCase::containsValue;
            this.payloads.getFirst = ConcurrentHashMapTestCase::getFirst;
            this.payloads.getLast = ConcurrentHashMapTestCase::getLast;
            this.payloads.getOnly = ConcurrentHashMapTestCase::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ConcurrentHashMapTestCase::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(ConcurrentHashMapTestCase::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = ConcurrentHashMapTestCase::containsAllIterable;
            this.payloads.containsAllArguments = ConcurrentHashMapTestCase::containsAllArguments;
            this.payloads.count = ConcurrentHashMapTestCase::count;
            this.payloads.countWith = ConcurrentHashMapTestCase::countWith;
            this.payloads.detect_value = ConcurrentHashMapTestCase::detect_value;
            this.payloads.detectOptional_value = ConcurrentHashMapTestCase::detectOptional_value;
            this.payloads.detectWith = ConcurrentHashMapTestCase::detectWith;
            this.payloads.detectWithOptional = ConcurrentHashMapTestCase::detectWithOptional;
            this.payloads.detectIfNone_value = ConcurrentHashMapTestCase::detectIfNone_value;
            this.payloads.detectWithIfNone = ConcurrentHashMapTestCase::detectWithIfNone;
            this.payloads.flatten_value = ConcurrentHashMapTestCase::flatten_value;
            this.payloads.countBy = ConcurrentHashMapTestCase::countBy;
            this.payloads.countByWith = ConcurrentHashMapTestCase::countByWith;
            this.payloads.countByEach = ConcurrentHashMapTestCase::countByEach;
            this.payloads.groupBy = ConcurrentHashMapTestCase::groupBy;
            this.payloads.groupByEach = ConcurrentHashMapTestCase::groupByEach;
            this.payloads.groupByUniqueKey = ConcurrentHashMapTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ConcurrentHashMapTestCase::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ConcurrentHashMapTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ConcurrentHashMapTestCase::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = ConcurrentHashMapTestCase::injectInto;
            this.payloads.injectIntoInt = ConcurrentHashMapTestCase::injectIntoInt;
            this.payloads.injectIntoLong = ConcurrentHashMapTestCase::injectIntoLong;
            this.payloads.injectIntoFloat = ConcurrentHashMapTestCase::injectIntoFloat;
            this.payloads.injectIntoDouble = ConcurrentHashMapTestCase::injectIntoDouble;
            this.payloads.sumOfInt = ConcurrentHashMapTestCase::sumOfInt;
            this.payloads.sumOfLong = ConcurrentHashMapTestCase::sumOfLong;
            this.payloads.testAggregateBy = ConcurrentHashMapTestCase::testAggregateBy;
            this.payloads.sumOfFloat = ConcurrentHashMapTestCase::sumOfFloat;
            this.payloads.sumOfDouble = ConcurrentHashMapTestCase::sumOfDouble;
            this.payloads.sumByInt = ConcurrentHashMapTestCase::sumByInt;
            this.payloads.sumByFloat = ConcurrentHashMapTestCase::sumByFloat;
            this.payloads.sumByLong = ConcurrentHashMapTestCase::sumByLong;
            this.payloads.sumByDouble = ConcurrentHashMapTestCase::sumByDouble;
            this.payloads.makeString = ConcurrentHashMapTestCase::makeString;
            this.payloads.min = ConcurrentHashMapTestCase::min;
            this.payloads.max = ConcurrentHashMapTestCase::max;
            this.payloads.minBy = ConcurrentHashMapTestCase::minBy;
            this.payloads.maxBy = ConcurrentHashMapTestCase::maxBy;
            this.payloads.reject_value = ConcurrentHashMapTestCase::reject_value;
            this.payloads.rejectWith_value = ConcurrentHashMapTestCase::rejectWith_value;
            this.payloads.select_value = ConcurrentHashMapTestCase::select_value;
            this.payloads.selectWith_value = ConcurrentHashMapTestCase::selectWith_value;
            this.payloads.partition_value = ConcurrentHashMapTestCase::partition_value;
            this.payloads.partitionWith_value = ConcurrentHashMapTestCase::partitionWith_value;
            this.payloads.selectInstancesOf_value = ConcurrentHashMapTestCase::selectInstancesOf_value;
            this.payloads.toArray = ConcurrentHashMapTestCase::toArray;
            this.payloads.zip = ConcurrentHashMapTestCase::zip;
            this.payloads.zipWithIndex = ConcurrentHashMapTestCase::zipWithIndex;
            this.payloads.aggregateByMutating = ConcurrentHashMapTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ConcurrentHashMapTestCase::aggregateByNonMutating;
            this.payloads.keyValuesView = ConcurrentHashMapTestCase::keyValuesView;
            this.payloads.nullCollisionWithCastInEquals = ConcurrentHashMapTestCase::nullCollisionWithCastInEquals;
            this.payloads.testNewMap = ConcurrentHashMapTestCase::testNewMap;
            this.payloads.testNewMapWithKeyValue = ConcurrentHashMapTestCase::testNewMapWithKeyValue;
            this.payloads.newMapWithWith = ConcurrentHashMapTestCase::newMapWithWith;
            this.payloads.newMapWithWithWith = ConcurrentHashMapTestCase::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = ConcurrentHashMapTestCase::newMapWithWithWithWith;
            this.payloads.iterator = ConcurrentHashMapTestCase::iterator;
            this.payloads.keysView = ConcurrentHashMapTestCase::keysView;
            this.payloads.valuesView = ConcurrentHashMapTestCase::valuesView;
            this.payloads.test_toString = ConcurrentHashMapTestCase::test_toString;
            this.payloads.toImmutable = ConcurrentHashMapTestCase::toImmutable;
            this.payloads.clear = ConcurrentHashMapTestCase::clear;
            this.payloads.removeObject = ConcurrentHashMapTestCase::removeObject;
            this.payloads.removeFromEntrySet = ConcurrentHashMapTestCase::removeFromEntrySet;
            this.payloads.removeAllFromEntrySet = ConcurrentHashMapTestCase::removeAllFromEntrySet;
            this.payloads.retainAllFromEntrySet = ConcurrentHashMapTestCase::retainAllFromEntrySet;
            this.payloads.clearEntrySet = ConcurrentHashMapTestCase::clearEntrySet;
            this.payloads.entrySetEqualsAndHashCode = ConcurrentHashMapTestCase::entrySetEqualsAndHashCode;
            this.payloads.removeFromKeySet = ConcurrentHashMapTestCase::removeFromKeySet;
            this.payloads.removeNullFromKeySet = ConcurrentHashMapTestCase::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = ConcurrentHashMapTestCase::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = ConcurrentHashMapTestCase::retainAllFromKeySet;
            this.payloads.clearKeySet = ConcurrentHashMapTestCase::clearKeySet;
            this.payloads.keySetEqualsAndHashCode = ConcurrentHashMapTestCase::keySetEqualsAndHashCode;
            this.payloads.keySetToArray = ConcurrentHashMapTestCase::keySetToArray;
            this.payloads.removeFromValues = ConcurrentHashMapTestCase::removeFromValues;
            this.payloads.removeNullFromValues = ConcurrentHashMapTestCase::removeNullFromValues;
            this.payloads.removeAllFromValues = ConcurrentHashMapTestCase::removeAllFromValues;
            this.payloads.retainAllFromValues = ConcurrentHashMapTestCase::retainAllFromValues;
            this.payloads.put = ConcurrentHashMapTestCase::put;
            this.payloads.putAll = ConcurrentHashMapTestCase::putAll;
            this.payloads.removeKey = ConcurrentHashMapTestCase::removeKey;
            this.payloads.removeAllKeys = ConcurrentHashMapTestCase::removeAllKeys;
            this.payloads.removeIf = ConcurrentHashMapTestCase::removeIf;
            this.payloads.getIfAbsentPut = ConcurrentHashMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPutValue = ConcurrentHashMapTestCase::getIfAbsentPutValue;
            this.payloads.getIfAbsentPutWithKey = ConcurrentHashMapTestCase::getIfAbsentPutWithKey;
            this.payloads.getIfAbsentPutWith = ConcurrentHashMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPut_block_throws = ConcurrentHashMapTestCase::getIfAbsentPut_block_throws;
            this.payloads.getIfAbsentPutWith_block_throws = ConcurrentHashMapTestCase::getIfAbsentPutWith_block_throws;
            this.payloads.getKeysAndGetValues = ConcurrentHashMapTestCase::getKeysAndGetValues;
            this.payloads.newEmpty = ConcurrentHashMapTestCase::newEmpty;
            this.payloads.keysAndValues_toString = ConcurrentHashMapTestCase::keysAndValues_toString;
            this.payloads.keyPreservation = ConcurrentHashMapTestCase::keyPreservation;
            this.payloads.asUnmodifiable = ConcurrentHashMapTestCase::asUnmodifiable;
            this.payloads.asSynchronized = ConcurrentHashMapTestCase::asSynchronized;
            this.payloads.add = ConcurrentHashMapTestCase::add;
            this.payloads.putPair = ConcurrentHashMapTestCase::putPair;
            this.payloads.withKeyValue = ConcurrentHashMapTestCase::withKeyValue;
            this.payloads.withMap = ConcurrentHashMapTestCase::withMap;
            this.payloads.withMapEmpty = ConcurrentHashMapTestCase::withMapEmpty;
            this.payloads.withMapTargetEmpty = ConcurrentHashMapTestCase::withMapTargetEmpty;
            this.payloads.withMapEmptyAndTargetEmpty = ConcurrentHashMapTestCase::withMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = ConcurrentHashMapTestCase::withMapNull;
            this.payloads.withMapIterable = ConcurrentHashMapTestCase::withMapIterable;
            this.payloads.withMapIterableEmpty = ConcurrentHashMapTestCase::withMapIterableEmpty;
            this.payloads.withMapIterableTargetEmpty = ConcurrentHashMapTestCase::withMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = ConcurrentHashMapTestCase::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = ConcurrentHashMapTestCase::withMapIterableNull;
            this.payloads.putAllMapIterable = ConcurrentHashMapTestCase::putAllMapIterable;
            this.payloads.putAllMapIterableEmpty = ConcurrentHashMapTestCase::putAllMapIterableEmpty;
            this.payloads.putAllMapIterableTargetEmpty = ConcurrentHashMapTestCase::putAllMapIterableTargetEmpty;
            this.payloads.putAllMapIterableEmptyAndTargetEmpty = ConcurrentHashMapTestCase::putAllMapIterableEmptyAndTargetEmpty;
            this.payloads.putAllMapIterableNull = ConcurrentHashMapTestCase::putAllMapIterableNull;
            this.payloads.withAllKeyValues = ConcurrentHashMapTestCase::withAllKeyValues;
            this.payloads.withAllKeyValueArguments = ConcurrentHashMapTestCase::withAllKeyValueArguments;
            this.payloads.withoutKey = ConcurrentHashMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = ConcurrentHashMapTestCase::withoutAllKeys;
            this.payloads.retainAllFromKeySet_null_collision = ConcurrentHashMapTestCase::retainAllFromKeySet_null_collision;
            this.payloads.rehash_null_collision = ConcurrentHashMapTestCase::rehash_null_collision;
            this.payloads.collectKeysAndValues = ConcurrentHashMapTestCase::collectKeysAndValues;
            this.payloads.testClone = ConcurrentHashMapTestCase::testClone;
            this.payloads.updateValue = ConcurrentHashMapTestCase::updateValue;
            this.payloads.updateValue_collisions = ConcurrentHashMapTestCase::updateValue_collisions;
            this.payloads.updateValueWith = ConcurrentHashMapTestCase::updateValueWith;
            this.payloads.updateValueWith_collisions = ConcurrentHashMapTestCase::updateValueWith_collisions;
        }
    }
*/
}
