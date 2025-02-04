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

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedMutableSet}.
 */
public class SynchronizedMutableSet2Test extends AbstractMutableSetTestCase {

    @Override
    protected <T> MutableSet<T> newWith(T... littleElements) {
        return new SynchronizedMutableSet<>(SetAdapter.adapt(new HashSet<>(UnifiedSet.newSetWith(littleElements))));
    }

    @Test(expected = NoSuchElementException.class)
    public void min_empty_throws_without_comparator() {
        this.newWith().min();
    }

    @Test(expected = NoSuchElementException.class)
    public void max_empty_throws_without_comparator() {
        this.newWith().max();
    }

    @Override
    @Test
    public void testToString() {
        MutableSet<Integer> integer = this.newWith(1);
        Assert.assertEquals("[1]", integer.toString());
    }

    @Override
    @Test
    public void makeString() {
        MutableSet<Integer> integer = this.newWith(1);
        Assert.assertEquals("{1}", integer.makeString("{", ",", "}"));
    }

    @Override
    @Test
    public void appendString() {
        Appendable stringBuilder = new StringBuilder();
        MutableSet<Integer> integer = this.newWith(1);
        integer.appendString(stringBuilder, "{", ",", "}");
        Assert.assertEquals("{1}", stringBuilder.toString());
    }

    @Override
    @Test
    public void removeIf() {
        MutableSet<Integer> integers = this.newWith(1, 2, 3, 4);
        integers.remove(3);
        Verify.assertSetsEqual(UnifiedSet.newSetWith(1, 2, 4), integers);
    }

    @Override
    public void selectInstancesOf() {
        MutableSet<Number> numbers = new SynchronizedMutableSet<Number>(SetAdapter.adapt(new TreeSet<>((o1, o2) -> Double.compare(o1.doubleValue(), o2.doubleValue())))).withAll(FastList.newListWith(1, 2.0, 3, 4.0, 5));
        MutableSet<Integer> integers = numbers.selectInstancesOf(Integer.class);
        Assert.assertEquals(UnifiedSet.newSetWith(1, 3, 5), integers);
        Assert.assertEquals(FastList.newListWith(1, 3, 5), integers.toList());
    }

    @Test
    @Override
    public void getFirst() {
        Assert.assertNotNull(this.newWith(1, 2, 3).getFirst());
        Assert.assertNull(this.newWith().getFirst());
        Assert.assertEquals(Integer.valueOf(1), this.newWith(1).getFirst());
        int first = this.newWith(1, 2).getFirst().intValue();
        Assert.assertTrue(first == 1 || first == 2);
    }

    @Test
    @Override
    public void getLast() {
        Assert.assertNotNull(this.newWith(1, 2, 3).getLast());
        Assert.assertNull(this.newWith().getLast());
        Assert.assertEquals(Integer.valueOf(1), this.newWith(1).getLast());
        int last = this.newWith(1, 2).getLast().intValue();
        Assert.assertTrue(last == 1 || last == 2);
    }

    @Test
    @Override
    public void iterator() {
        MutableSet<Integer> objects = this.newWith(1, 2, 3);
        MutableBag<Integer> actual = Bags.mutable.of();
        Iterator<Integer> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(Bags.mutable.of(1, 2, 3), actual);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedMutableSet2Test instance;

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
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_target);
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
        public void benchmark_toImmutableSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_natural_ordering);
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
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllIterable);
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
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
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
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
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
        public void benchmark_unifiedSetKeySetToArrayDest() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.unifiedSetKeySetToArrayDest);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unifiedSetToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.unifiedSetToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
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
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
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
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_increment_past_end() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_increment_past_end);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_remove_without_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_remove_without_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_natural_ordering);
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
        public void benchmark_frequentCollisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.frequentCollisions);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws_without_comparator);
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
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
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
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedMutableSet2Test();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> unionInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> intersectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> differenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> symmetricDifferenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> powerSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> unifiedSetKeySetToArrayDest;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> unifiedSetToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> iterator_increment_past_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> iterator_remove_without_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> frequentCollisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableSet2Test> iterator;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = SynchronizedMutableSet2Test::testNewCollection;
            this.payloads.contains = SynchronizedMutableSet2Test::contains;
            this.payloads.containsBy = SynchronizedMutableSet2Test::containsBy;
            this.payloads.containsAllIterable = SynchronizedMutableSet2Test::containsAllIterable;
            this.payloads.containsAnyIterable = SynchronizedMutableSet2Test::containsAnyIterable;
            this.payloads.containsNoneIterable = SynchronizedMutableSet2Test::containsNoneIterable;
            this.payloads.containsAllArray = SynchronizedMutableSet2Test::containsAllArray;
            this.payloads.containsAnyCollection = SynchronizedMutableSet2Test::containsAnyCollection;
            this.payloads.containsNoneCollection = SynchronizedMutableSet2Test::containsNoneCollection;
            this.payloads.containsAllCollection = SynchronizedMutableSet2Test::containsAllCollection;
            this.payloads.selectWith = SynchronizedMutableSet2Test::selectWith;
            this.payloads.selectWith_target = SynchronizedMutableSet2Test::selectWith_target;
            this.payloads.rejectWith = SynchronizedMutableSet2Test::rejectWith;
            this.payloads.rejectWith_target = SynchronizedMutableSet2Test::rejectWith_target;
            this.payloads.selectInstancesOf = SynchronizedMutableSet2Test::selectInstancesOf;
            this.payloads.collect = SynchronizedMutableSet2Test::collect;
            this.payloads.collectTarget = SynchronizedMutableSet2Test::collectTarget;
            this.payloads.collectBoolean = SynchronizedMutableSet2Test::collectBoolean;
            this.payloads.collectBooleanWithTarget = SynchronizedMutableSet2Test::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = SynchronizedMutableSet2Test::collectBooleanWithBagTarget;
            this.payloads.collectByte = SynchronizedMutableSet2Test::collectByte;
            this.payloads.collectByteWithTarget = SynchronizedMutableSet2Test::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = SynchronizedMutableSet2Test::collectByteWithBagTarget;
            this.payloads.collectChar = SynchronizedMutableSet2Test::collectChar;
            this.payloads.collectCharWithTarget = SynchronizedMutableSet2Test::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = SynchronizedMutableSet2Test::collectCharWithBagTarget;
            this.payloads.collectDouble = SynchronizedMutableSet2Test::collectDouble;
            this.payloads.collectDoubleWithTarget = SynchronizedMutableSet2Test::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = SynchronizedMutableSet2Test::collectDoubleWithBagTarget;
            this.payloads.collectFloat = SynchronizedMutableSet2Test::collectFloat;
            this.payloads.collectFloatWithTarget = SynchronizedMutableSet2Test::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = SynchronizedMutableSet2Test::collectFloatWithBagTarget;
            this.payloads.collectInt = SynchronizedMutableSet2Test::collectInt;
            this.payloads.collectIntWithTarget = SynchronizedMutableSet2Test::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = SynchronizedMutableSet2Test::collectIntWithBagTarget;
            this.payloads.collectLong = SynchronizedMutableSet2Test::collectLong;
            this.payloads.collectLongWithTarget = SynchronizedMutableSet2Test::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = SynchronizedMutableSet2Test::collectLongWithBagTarget;
            this.payloads.collectShort = SynchronizedMutableSet2Test::collectShort;
            this.payloads.collectShortWithTarget = SynchronizedMutableSet2Test::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = SynchronizedMutableSet2Test::collectShortWithBagTarget;
            this.payloads.flatCollect = SynchronizedMutableSet2Test::flatCollect;
            this.payloads.flatCollectWith = SynchronizedMutableSet2Test::flatCollectWith;
            this.payloads.flatCollectBoolean = SynchronizedMutableSet2Test::flatCollectBoolean;
            this.payloads.flatCollectByte = SynchronizedMutableSet2Test::flatCollectByte;
            this.payloads.flatCollectShort = SynchronizedMutableSet2Test::flatCollectShort;
            this.payloads.flatCollectInt = SynchronizedMutableSet2Test::flatCollectInt;
            this.payloads.flatCollectChar = SynchronizedMutableSet2Test::flatCollectChar;
            this.payloads.flatCollectLong = SynchronizedMutableSet2Test::flatCollectLong;
            this.payloads.flatCollectDouble = SynchronizedMutableSet2Test::flatCollectDouble;
            this.payloads.flatCollectFloat = SynchronizedMutableSet2Test::flatCollectFloat;
            this.payloads.detectOptional = SynchronizedMutableSet2Test::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableSet2Test::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableSet2Test::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableSet2Test::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableSet2Test::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = SynchronizedMutableSet2Test::min;
            this.payloads.minOptional = SynchronizedMutableSet2Test::minOptional;
            this.payloads.max = SynchronizedMutableSet2Test::max;
            this.payloads.maxOptional = SynchronizedMutableSet2Test::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableSet2Test::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableSet2Test::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = SynchronizedMutableSet2Test::min_without_comparator;
            this.payloads.max_without_comparator = SynchronizedMutableSet2Test::max_without_comparator;
            this.payloads.min_null_safe = SynchronizedMutableSet2Test::min_null_safe;
            this.payloads.max_null_safe = SynchronizedMutableSet2Test::max_null_safe;
            this.payloads.minBy = SynchronizedMutableSet2Test::minBy;
            this.payloads.minByOptional = SynchronizedMutableSet2Test::minByOptional;
            this.payloads.maxBy = SynchronizedMutableSet2Test::maxBy;
            this.payloads.maxByOptional = SynchronizedMutableSet2Test::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableSet2Test::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableSet2Test::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = SynchronizedMutableSet2Test::detectWith;
            this.payloads.detectWithOptional = SynchronizedMutableSet2Test::detectWithOptional;
            this.payloads.detectIfNone = SynchronizedMutableSet2Test::detectIfNone;
            this.payloads.detectWithIfNoneBlock = SynchronizedMutableSet2Test::detectWithIfNoneBlock;
            this.payloads.count = SynchronizedMutableSet2Test::count;
            this.payloads.countWith = SynchronizedMutableSet2Test::countWith;
            this.payloads.collectIf = SynchronizedMutableSet2Test::collectIf;
            this.payloads.collectWith = SynchronizedMutableSet2Test::collectWith;
            this.payloads.collectWith_target = SynchronizedMutableSet2Test::collectWith_target;
            this.payloads.getAny = SynchronizedMutableSet2Test::getAny;
            this.payloads.getOnly = SynchronizedMutableSet2Test::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableSet2Test::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableSet2Test::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableSet2Test::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = SynchronizedMutableSet2Test::injectInto;
            this.payloads.injectIntoInt = SynchronizedMutableSet2Test::injectIntoInt;
            this.payloads.injectIntoLong = SynchronizedMutableSet2Test::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedMutableSet2Test::injectIntoDouble;
            this.payloads.injectIntoFloat = SynchronizedMutableSet2Test::injectIntoFloat;
            this.payloads.sumFloat = SynchronizedMutableSet2Test::sumFloat;
            this.payloads.summarizeFloat = SynchronizedMutableSet2Test::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = SynchronizedMutableSet2Test::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = SynchronizedMutableSet2Test::sumFloatConsistentRounding2;
            this.payloads.sumDouble = SynchronizedMutableSet2Test::sumDouble;
            this.payloads.summarizeDouble = SynchronizedMutableSet2Test::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = SynchronizedMutableSet2Test::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = SynchronizedMutableSet2Test::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = SynchronizedMutableSet2Test::sumInteger;
            this.payloads.summarizeInt = SynchronizedMutableSet2Test::summarizeInt;
            this.payloads.sumLong = SynchronizedMutableSet2Test::sumLong;
            this.payloads.summarizeLong = SynchronizedMutableSet2Test::summarizeLong;
            this.payloads.sumByInt = SynchronizedMutableSet2Test::sumByInt;
            this.payloads.sumByFloat = SynchronizedMutableSet2Test::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = SynchronizedMutableSet2Test::sumByFloatConsistentRounding;
            this.payloads.sumByLong = SynchronizedMutableSet2Test::sumByLong;
            this.payloads.sumByDouble = SynchronizedMutableSet2Test::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = SynchronizedMutableSet2Test::sumByDoubleConsistentRounding;
            this.payloads.partition = SynchronizedMutableSet2Test::partition;
            this.payloads.partitionWith = SynchronizedMutableSet2Test::partitionWith;
            this.payloads.toList = SynchronizedMutableSet2Test::toList;
            this.payloads.toImmutableList = SynchronizedMutableSet2Test::toImmutableList;
            this.payloads.toCollection = SynchronizedMutableSet2Test::toCollection;
            this.payloads.toBag = SynchronizedMutableSet2Test::toBag;
            this.payloads.toImmutableBag = SynchronizedMutableSet2Test::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = SynchronizedMutableSet2Test::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = SynchronizedMutableSet2Test::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = SynchronizedMutableSet2Test::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = SynchronizedMutableSet2Test::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableSet2Test::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBag_natural_ordering = SynchronizedMutableSet2Test::toImmutableSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBagBy = SynchronizedMutableSet2Test::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = SynchronizedMutableSet2Test::toSortedListBy;
            this.payloads.toImmutableSortedListBy = SynchronizedMutableSet2Test::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = SynchronizedMutableSet2Test::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = SynchronizedMutableSet2Test::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = SynchronizedMutableSet2Test::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = SynchronizedMutableSet2Test::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = SynchronizedMutableSet2Test::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = SynchronizedMutableSet2Test::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableSet2Test::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = SynchronizedMutableSet2Test::toSet;
            this.payloads.toImmutableSet = SynchronizedMutableSet2Test::toImmutableSet;
            this.payloads.toMap = SynchronizedMutableSet2Test::toMap;
            this.payloads.toImmutableMap = SynchronizedMutableSet2Test::toImmutableMap;
            this.payloads.toMapTarget = SynchronizedMutableSet2Test::toMapTarget;
            this.payloads.toSortedMap = SynchronizedMutableSet2Test::toSortedMap;
            this.payloads.toSortedMap_with_comparator = SynchronizedMutableSet2Test::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = SynchronizedMutableSet2Test::toSortedMapBy;
            this.payloads.toBiMap = SynchronizedMutableSet2Test::toBiMap;
            this.payloads.toImmutableBiMap = SynchronizedMutableSet2Test::toImmutableBiMap;
            this.payloads.makeStringWithSeparator = SynchronizedMutableSet2Test::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = SynchronizedMutableSet2Test::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = SynchronizedMutableSet2Test::fusedCollectMakeString;
            this.payloads.appendStringWithSeparator = SynchronizedMutableSet2Test::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = SynchronizedMutableSet2Test::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = SynchronizedMutableSet2Test::appendStringThrows;
            this.payloads.countBy = SynchronizedMutableSet2Test::countBy;
            this.payloads.countByWith = SynchronizedMutableSet2Test::countByWith;
            this.payloads.countByEach = SynchronizedMutableSet2Test::countByEach;
            this.payloads.groupBy = SynchronizedMutableSet2Test::groupBy;
            this.payloads.groupByEach = SynchronizedMutableSet2Test::groupByEach;
            this.payloads.groupByUniqueKey = SynchronizedMutableSet2Test::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableSet2Test::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = SynchronizedMutableSet2Test::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableSet2Test::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = SynchronizedMutableSet2Test::zip;
            this.payloads.zipWithIndex = SynchronizedMutableSet2Test::zipWithIndex;
            this.payloads.chunk = SynchronizedMutableSet2Test::chunk;
            this.payloads.chunk_empty = SynchronizedMutableSet2Test::chunk_empty;
            this.payloads.chunk_single = SynchronizedMutableSet2Test::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableSet2Test::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = SynchronizedMutableSet2Test::chunk_large_size;
            this.payloads.empty = SynchronizedMutableSet2Test::empty;
            this.payloads.notEmpty = SynchronizedMutableSet2Test::notEmpty;
            this.payloads.aggregateByMutating = SynchronizedMutableSet2Test::aggregateByMutating;
            this.payloads.aggregateByNonMutating = SynchronizedMutableSet2Test::aggregateByNonMutating;
            this.payloads.reduceOptional = SynchronizedMutableSet2Test::reduceOptional;
            this.payloads.newEmpty = SynchronizedMutableSet2Test::newEmpty;
            this.payloads.toImmutable = SynchronizedMutableSet2Test::toImmutable;
            this.payloads.testNewWith = SynchronizedMutableSet2Test::testNewWith;
            this.payloads.testNewWithWith = SynchronizedMutableSet2Test::testNewWithWith;
            this.payloads.testNewWithWithWith = SynchronizedMutableSet2Test::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = SynchronizedMutableSet2Test::testNewWithVarArgs;
            this.payloads.removeAll = SynchronizedMutableSet2Test::removeAll;
            this.payloads.removeAllIterable = SynchronizedMutableSet2Test::removeAllIterable;
            this.payloads.retainAllIterable = SynchronizedMutableSet2Test::retainAllIterable;
            this.payloads.clear = SynchronizedMutableSet2Test::clear;
            this.payloads.injectIntoWith = SynchronizedMutableSet2Test::injectIntoWith;
            this.payloads.removeObject = SynchronizedMutableSet2Test::removeObject;
            this.payloads.selectAndRejectWith = SynchronizedMutableSet2Test::selectAndRejectWith;
            this.payloads.removeIfWith = SynchronizedMutableSet2Test::removeIfWith;
            this.payloads.with = SynchronizedMutableSet2Test::with;
            this.payloads.withAll = SynchronizedMutableSet2Test::withAll;
            this.payloads.without = SynchronizedMutableSet2Test::without;
            this.payloads.withoutAll = SynchronizedMutableSet2Test::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = SynchronizedMutableSet2Test::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = SynchronizedMutableSet2Test::asLazy;
            this.payloads.asSynchronized = SynchronizedMutableSet2Test::asSynchronized;
            this.payloads.addAll = SynchronizedMutableSet2Test::addAll;
            this.payloads.addAllIterable = SynchronizedMutableSet2Test::addAllIterable;
            this.payloads.union = SynchronizedMutableSet2Test::union;
            this.payloads.unionInto = SynchronizedMutableSet2Test::unionInto;
            this.payloads.intersect = SynchronizedMutableSet2Test::intersect;
            this.payloads.intersectInto = SynchronizedMutableSet2Test::intersectInto;
            this.payloads.difference = SynchronizedMutableSet2Test::difference;
            this.payloads.differenceInto = SynchronizedMutableSet2Test::differenceInto;
            this.payloads.symmetricDifference = SynchronizedMutableSet2Test::symmetricDifference;
            this.payloads.symmetricDifferenceInto = SynchronizedMutableSet2Test::symmetricDifferenceInto;
            this.payloads.isSubsetOf = SynchronizedMutableSet2Test::isSubsetOf;
            this.payloads.isProperSubsetOf = SynchronizedMutableSet2Test::isProperSubsetOf;
            this.payloads.powerSet = SynchronizedMutableSet2Test::powerSet;
            this.payloads.cartesianProduct = SynchronizedMutableSet2Test::cartesianProduct;
            this.payloads.asUnmodifiable = SynchronizedMutableSet2Test::asUnmodifiable;
            this.payloads.select = SynchronizedMutableSet2Test::select;
            this.payloads.reject = SynchronizedMutableSet2Test::reject;
            this.payloads.unifiedSetKeySetToArrayDest = SynchronizedMutableSet2Test::unifiedSetKeySetToArrayDest;
            this.payloads.unifiedSetToString = SynchronizedMutableSet2Test::unifiedSetToString;
            this.payloads.testClone = SynchronizedMutableSet2Test::testClone;
            this.payloads.isEmpty = SynchronizedMutableSet2Test::isEmpty;
            this.payloads.add = SynchronizedMutableSet2Test::add;
            this.payloads.retainAll = SynchronizedMutableSet2Test::retainAll;
            this.payloads.equalsAndHashCode = SynchronizedMutableSet2Test::equalsAndHashCode;
            this.payloads.tap = SynchronizedMutableSet2Test::tap;
            this.payloads.forEach = SynchronizedMutableSet2Test::forEach;
            this.payloads.forEachWith = SynchronizedMutableSet2Test::forEachWith;
            this.payloads.forEachWithIndex = SynchronizedMutableSet2Test::forEachWithIndex;
            this.payloads.anySatisfy = SynchronizedMutableSet2Test::anySatisfy;
            this.payloads.anySatisfyWith = SynchronizedMutableSet2Test::anySatisfyWith;
            this.payloads.allSatisfy = SynchronizedMutableSet2Test::allSatisfy;
            this.payloads.allSatisfyWith = SynchronizedMutableSet2Test::allSatisfyWith;
            this.payloads.noneSatisfy = SynchronizedMutableSet2Test::noneSatisfy;
            this.payloads.noneSatisfyWith = SynchronizedMutableSet2Test::noneSatisfyWith;
            this.payloads.detect = SynchronizedMutableSet2Test::detect;
            this.payloads.iterator_increment_past_end = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableSet2Test::iterator_increment_past_end, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_without_next = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableSet2Test::iterator_remove_without_next, java.lang.IllegalStateException.class);
            this.payloads.toArray = SynchronizedMutableSet2Test::toArray;
            this.payloads.toSortedBag_natural_ordering = SynchronizedMutableSet2Test::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = SynchronizedMutableSet2Test::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = SynchronizedMutableSet2Test::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableSet2Test::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = SynchronizedMutableSet2Test::toSortedBagBy;
            this.payloads.frequentCollisions = SynchronizedMutableSet2Test::frequentCollisions;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableSet2Test::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableSet2Test::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.testToString = SynchronizedMutableSet2Test::testToString;
            this.payloads.makeString = SynchronizedMutableSet2Test::makeString;
            this.payloads.appendString = SynchronizedMutableSet2Test::appendString;
            this.payloads.removeIf = SynchronizedMutableSet2Test::removeIf;
            this.payloads.getFirst = SynchronizedMutableSet2Test::getFirst;
            this.payloads.getLast = SynchronizedMutableSet2Test::getLast;
            this.payloads.iterator = SynchronizedMutableSet2Test::iterator;
        }
    }
}
