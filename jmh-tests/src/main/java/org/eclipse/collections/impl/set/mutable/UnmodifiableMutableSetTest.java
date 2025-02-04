/*
 * Copyright (c) 2021 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.mutable;

import java.util.Collections;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.sorted.ImmutableSortedBag;
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.bag.sorted.mutable.TreeBag;
import org.eclipse.collections.impl.collection.mutable.AbstractCollectionTestCase;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableMutableSet}.
 */
public class UnmodifiableMutableSetTest extends AbstractCollectionTestCase {

    private static final String LED_ZEPPELIN = "Led Zeppelin";

    private static final String METALLICA = "Metallica";

    private MutableSet<String> mutableSet;

    private MutableSet<String> unmodifiableSet;

    @Before
    public void setUp() {
        this.mutableSet = UnifiedSet.newSetWith(METALLICA, "Bon Jovi", "Europe", "Scorpions");
        this.unmodifiableSet = this.mutableSet.asUnmodifiable();
    }

    @Override
    protected <T> MutableSet<T> newWith(T... elements) {
        return UnifiedSet.newSetWith(elements).asUnmodifiable();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeObject() {
        super.removeObject();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeIfWith() {
        super.removeIfWith();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void clear() {
        super.clear();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAll() {
        super.addAll();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable() {
        super.addAllIterable();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeIf() {
        super.removeIf();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll() {
        super.removeAll();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAllIterable() {
        super.removeAllIterable();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll() {
        super.retainAll();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAllIterable() {
        super.retainAllIterable();
    }

    @Override
    @Test
    public void testToString() {
        MutableCollection<Object> collection = this.newWith(1, 2);
        String string = collection.toString();
        Assert.assertTrue("[1, 2]".equals(string) || "[2, 1]".equals(string));
    }

    @Override
    @Test
    public void makeString() {
        MutableCollection<Object> collection = this.newWith(1, 2, 3);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Override
    @Test
    public void appendString() {
        MutableCollection<Object> collection = this.newWith(1, 2, 3);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Override
    @Test
    public void getFirst() {
        Assert.assertNotNull(this.newWith(1, 2, 3).getFirst());
        Assert.assertNull(this.newWith().getFirst());
    }

    @Override
    @Test
    public void getLast() {
        Assert.assertNotNull(this.newWith(1, 2, 3).getLast());
        Assert.assertNull(this.newWith().getLast());
    }

    @Override
    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedMutableSet.class, this.newWith().asSynchronized());
    }

    @Override
    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableMutableSet.class, this.newWith().asUnmodifiable());
    }

    @Test
    public void testEqualsAndHashCode() {
        Verify.assertEqualsAndHashCode(this.mutableSet, this.unmodifiableSet);
        Verify.assertPostSerializedEqualsAndHashCode(this.unmodifiableSet);
        Verify.assertInstanceOf(UnmodifiableMutableSet.class, SerializeTestHelper.serializeDeserialize(this.unmodifiableSet));
    }

    @Test
    public void testNewEmpty() {
        MutableSet<String> set = this.unmodifiableSet.newEmpty();
        set.add(LED_ZEPPELIN);
        Verify.assertContains(LED_ZEPPELIN, set);
    }

    @Test
    public void testClone() {
        MutableSet<String> set = this.newWith();
        MutableSet<String> clone = set.clone();
        Assert.assertSame(clone, set);
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
    @Test(expected = UnsupportedOperationException.class)
    public void with() {
        this.newWith(1, 2, 3).with(4);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll() {
        this.newWith(1, 2, 3).withAll(FastList.newListWith(4, 5));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without() {
        this.newWith(1, 2, 3).without(2);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll() {
        this.newWith(1, 2, 3, 4, 5).withoutAll(FastList.newListWith(2, 4));
    }

    @Override
    @Test
    public void toSortedBag_natural_ordering() {
        RichIterable<Integer> integers = this.newWith(1, 2, 5, 3, 4);
        MutableSortedBag<Integer> bag = integers.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(1, 2, 3, 4, 5), bag);
    }

    @Override
    @Test
    public void toSortedBag_with_comparator() {
        RichIterable<Integer> integers = this.newWith(2, 4, 1, 3);
        MutableSortedBag<Integer> bag = integers.toSortedBag(Collections.reverseOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), 4, 3, 2, 1), bag);
    }

    @Override
    @Test
    public void toImmutableSortedBag_with_comparator() {
        RichIterable<Integer> integers = this.newWith(2, 4, 1, 3);
        ImmutableSortedBag<Integer> bag = integers.toImmutableSortedBag(Collections.reverseOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), 4, 3, 2, 1), bag);
    }

    @Override
    @Test(expected = NullPointerException.class)
    public void toSortedBag_with_null() {
        this.newWith(3, 4, null, 1, 2).toSortedBag();
    }

    @Override
    @Test
    public void toSortedBagBy() {
        RichIterable<Integer> integers = this.newWith(2, 4, 1, 3);
        MutableSortedBag<Integer> bag = integers.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(1, 2, 3, 4), bag);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableMutableSetTest instance;

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
        public void benchmark_injectIntoWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectAndRejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectAndRejectWith);
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
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIfWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIfWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
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
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
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
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
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
        public void benchmark_testEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEqualsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableMutableSetTest();
            this.instance.setUp();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> testEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> testNewEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableSetTest> toSortedBagBy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = UnmodifiableMutableSetTest::testNewCollection;
            this.payloads.equalsAndHashCode = UnmodifiableMutableSetTest::equalsAndHashCode;
            this.payloads.contains = UnmodifiableMutableSetTest::contains;
            this.payloads.containsBy = UnmodifiableMutableSetTest::containsBy;
            this.payloads.containsAllIterable = UnmodifiableMutableSetTest::containsAllIterable;
            this.payloads.containsAnyIterable = UnmodifiableMutableSetTest::containsAnyIterable;
            this.payloads.containsNoneIterable = UnmodifiableMutableSetTest::containsNoneIterable;
            this.payloads.containsAllArray = UnmodifiableMutableSetTest::containsAllArray;
            this.payloads.containsAnyCollection = UnmodifiableMutableSetTest::containsAnyCollection;
            this.payloads.containsNoneCollection = UnmodifiableMutableSetTest::containsNoneCollection;
            this.payloads.containsAllCollection = UnmodifiableMutableSetTest::containsAllCollection;
            this.payloads.tap = UnmodifiableMutableSetTest::tap;
            this.payloads.forEach = UnmodifiableMutableSetTest::forEach;
            this.payloads.forEachWith = UnmodifiableMutableSetTest::forEachWith;
            this.payloads.forEachWithIndex = UnmodifiableMutableSetTest::forEachWithIndex;
            this.payloads.select = UnmodifiableMutableSetTest::select;
            this.payloads.selectWith = UnmodifiableMutableSetTest::selectWith;
            this.payloads.selectWith_target = UnmodifiableMutableSetTest::selectWith_target;
            this.payloads.reject = UnmodifiableMutableSetTest::reject;
            this.payloads.rejectWith = UnmodifiableMutableSetTest::rejectWith;
            this.payloads.rejectWith_target = UnmodifiableMutableSetTest::rejectWith_target;
            this.payloads.selectInstancesOf = UnmodifiableMutableSetTest::selectInstancesOf;
            this.payloads.collect = UnmodifiableMutableSetTest::collect;
            this.payloads.collectTarget = UnmodifiableMutableSetTest::collectTarget;
            this.payloads.collectBoolean = UnmodifiableMutableSetTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = UnmodifiableMutableSetTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = UnmodifiableMutableSetTest::collectBooleanWithBagTarget;
            this.payloads.collectByte = UnmodifiableMutableSetTest::collectByte;
            this.payloads.collectByteWithTarget = UnmodifiableMutableSetTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = UnmodifiableMutableSetTest::collectByteWithBagTarget;
            this.payloads.collectChar = UnmodifiableMutableSetTest::collectChar;
            this.payloads.collectCharWithTarget = UnmodifiableMutableSetTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = UnmodifiableMutableSetTest::collectCharWithBagTarget;
            this.payloads.collectDouble = UnmodifiableMutableSetTest::collectDouble;
            this.payloads.collectDoubleWithTarget = UnmodifiableMutableSetTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = UnmodifiableMutableSetTest::collectDoubleWithBagTarget;
            this.payloads.collectFloat = UnmodifiableMutableSetTest::collectFloat;
            this.payloads.collectFloatWithTarget = UnmodifiableMutableSetTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = UnmodifiableMutableSetTest::collectFloatWithBagTarget;
            this.payloads.collectInt = UnmodifiableMutableSetTest::collectInt;
            this.payloads.collectIntWithTarget = UnmodifiableMutableSetTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = UnmodifiableMutableSetTest::collectIntWithBagTarget;
            this.payloads.collectLong = UnmodifiableMutableSetTest::collectLong;
            this.payloads.collectLongWithTarget = UnmodifiableMutableSetTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = UnmodifiableMutableSetTest::collectLongWithBagTarget;
            this.payloads.collectShort = UnmodifiableMutableSetTest::collectShort;
            this.payloads.collectShortWithTarget = UnmodifiableMutableSetTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = UnmodifiableMutableSetTest::collectShortWithBagTarget;
            this.payloads.flatCollect = UnmodifiableMutableSetTest::flatCollect;
            this.payloads.flatCollectWith = UnmodifiableMutableSetTest::flatCollectWith;
            this.payloads.flatCollectBoolean = UnmodifiableMutableSetTest::flatCollectBoolean;
            this.payloads.flatCollectByte = UnmodifiableMutableSetTest::flatCollectByte;
            this.payloads.flatCollectShort = UnmodifiableMutableSetTest::flatCollectShort;
            this.payloads.flatCollectInt = UnmodifiableMutableSetTest::flatCollectInt;
            this.payloads.flatCollectChar = UnmodifiableMutableSetTest::flatCollectChar;
            this.payloads.flatCollectLong = UnmodifiableMutableSetTest::flatCollectLong;
            this.payloads.flatCollectDouble = UnmodifiableMutableSetTest::flatCollectDouble;
            this.payloads.flatCollectFloat = UnmodifiableMutableSetTest::flatCollectFloat;
            this.payloads.detect = UnmodifiableMutableSetTest::detect;
            this.payloads.detectOptional = UnmodifiableMutableSetTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = UnmodifiableMutableSetTest::min;
            this.payloads.minOptional = UnmodifiableMutableSetTest::minOptional;
            this.payloads.max = UnmodifiableMutableSetTest::max;
            this.payloads.maxOptional = UnmodifiableMutableSetTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = UnmodifiableMutableSetTest::min_without_comparator;
            this.payloads.max_without_comparator = UnmodifiableMutableSetTest::max_without_comparator;
            this.payloads.min_null_safe = UnmodifiableMutableSetTest::min_null_safe;
            this.payloads.max_null_safe = UnmodifiableMutableSetTest::max_null_safe;
            this.payloads.minBy = UnmodifiableMutableSetTest::minBy;
            this.payloads.minByOptional = UnmodifiableMutableSetTest::minByOptional;
            this.payloads.maxBy = UnmodifiableMutableSetTest::maxBy;
            this.payloads.maxByOptional = UnmodifiableMutableSetTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = UnmodifiableMutableSetTest::detectWith;
            this.payloads.detectWithOptional = UnmodifiableMutableSetTest::detectWithOptional;
            this.payloads.detectIfNone = UnmodifiableMutableSetTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = UnmodifiableMutableSetTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = UnmodifiableMutableSetTest::allSatisfy;
            this.payloads.allSatisfyWith = UnmodifiableMutableSetTest::allSatisfyWith;
            this.payloads.noneSatisfy = UnmodifiableMutableSetTest::noneSatisfy;
            this.payloads.noneSatisfyWith = UnmodifiableMutableSetTest::noneSatisfyWith;
            this.payloads.anySatisfy = UnmodifiableMutableSetTest::anySatisfy;
            this.payloads.anySatisfyWith = UnmodifiableMutableSetTest::anySatisfyWith;
            this.payloads.count = UnmodifiableMutableSetTest::count;
            this.payloads.countWith = UnmodifiableMutableSetTest::countWith;
            this.payloads.collectIf = UnmodifiableMutableSetTest::collectIf;
            this.payloads.collectWith = UnmodifiableMutableSetTest::collectWith;
            this.payloads.collectWith_target = UnmodifiableMutableSetTest::collectWith_target;
            this.payloads.getAny = UnmodifiableMutableSetTest::getAny;
            this.payloads.getOnly = UnmodifiableMutableSetTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = UnmodifiableMutableSetTest::isEmpty;
            this.payloads.iterator = UnmodifiableMutableSetTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = UnmodifiableMutableSetTest::injectInto;
            this.payloads.injectIntoInt = UnmodifiableMutableSetTest::injectIntoInt;
            this.payloads.injectIntoLong = UnmodifiableMutableSetTest::injectIntoLong;
            this.payloads.injectIntoDouble = UnmodifiableMutableSetTest::injectIntoDouble;
            this.payloads.injectIntoFloat = UnmodifiableMutableSetTest::injectIntoFloat;
            this.payloads.sumFloat = UnmodifiableMutableSetTest::sumFloat;
            this.payloads.summarizeFloat = UnmodifiableMutableSetTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = UnmodifiableMutableSetTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = UnmodifiableMutableSetTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = UnmodifiableMutableSetTest::sumDouble;
            this.payloads.summarizeDouble = UnmodifiableMutableSetTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = UnmodifiableMutableSetTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = UnmodifiableMutableSetTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = UnmodifiableMutableSetTest::sumInteger;
            this.payloads.summarizeInt = UnmodifiableMutableSetTest::summarizeInt;
            this.payloads.sumLong = UnmodifiableMutableSetTest::sumLong;
            this.payloads.summarizeLong = UnmodifiableMutableSetTest::summarizeLong;
            this.payloads.sumByInt = UnmodifiableMutableSetTest::sumByInt;
            this.payloads.sumByFloat = UnmodifiableMutableSetTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = UnmodifiableMutableSetTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = UnmodifiableMutableSetTest::sumByLong;
            this.payloads.sumByDouble = UnmodifiableMutableSetTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = UnmodifiableMutableSetTest::sumByDoubleConsistentRounding;
            this.payloads.toArray = UnmodifiableMutableSetTest::toArray;
            this.payloads.partition = UnmodifiableMutableSetTest::partition;
            this.payloads.partitionWith = UnmodifiableMutableSetTest::partitionWith;
            this.payloads.toList = UnmodifiableMutableSetTest::toList;
            this.payloads.toImmutableList = UnmodifiableMutableSetTest::toImmutableList;
            this.payloads.toCollection = UnmodifiableMutableSetTest::toCollection;
            this.payloads.toBag = UnmodifiableMutableSetTest::toBag;
            this.payloads.toImmutableBag = UnmodifiableMutableSetTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = UnmodifiableMutableSetTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = UnmodifiableMutableSetTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = UnmodifiableMutableSetTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = UnmodifiableMutableSetTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBag_natural_ordering = UnmodifiableMutableSetTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBagBy = UnmodifiableMutableSetTest::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = UnmodifiableMutableSetTest::toSortedListBy;
            this.payloads.toImmutableSortedListBy = UnmodifiableMutableSetTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = UnmodifiableMutableSetTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = UnmodifiableMutableSetTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = UnmodifiableMutableSetTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = UnmodifiableMutableSetTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = UnmodifiableMutableSetTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = UnmodifiableMutableSetTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = UnmodifiableMutableSetTest::toSet;
            this.payloads.toImmutableSet = UnmodifiableMutableSetTest::toImmutableSet;
            this.payloads.toMap = UnmodifiableMutableSetTest::toMap;
            this.payloads.toImmutableMap = UnmodifiableMutableSetTest::toImmutableMap;
            this.payloads.toMapTarget = UnmodifiableMutableSetTest::toMapTarget;
            this.payloads.toSortedMap = UnmodifiableMutableSetTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = UnmodifiableMutableSetTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = UnmodifiableMutableSetTest::toSortedMapBy;
            this.payloads.toBiMap = UnmodifiableMutableSetTest::toBiMap;
            this.payloads.toImmutableBiMap = UnmodifiableMutableSetTest::toImmutableBiMap;
            this.payloads.makeStringWithSeparator = UnmodifiableMutableSetTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = UnmodifiableMutableSetTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = UnmodifiableMutableSetTest::fusedCollectMakeString;
            this.payloads.appendStringWithSeparator = UnmodifiableMutableSetTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = UnmodifiableMutableSetTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = UnmodifiableMutableSetTest::appendStringThrows;
            this.payloads.countBy = UnmodifiableMutableSetTest::countBy;
            this.payloads.countByWith = UnmodifiableMutableSetTest::countByWith;
            this.payloads.countByEach = UnmodifiableMutableSetTest::countByEach;
            this.payloads.groupBy = UnmodifiableMutableSetTest::groupBy;
            this.payloads.groupByEach = UnmodifiableMutableSetTest::groupByEach;
            this.payloads.groupByUniqueKey = UnmodifiableMutableSetTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = UnmodifiableMutableSetTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = UnmodifiableMutableSetTest::zip;
            this.payloads.zipWithIndex = UnmodifiableMutableSetTest::zipWithIndex;
            this.payloads.chunk = UnmodifiableMutableSetTest::chunk;
            this.payloads.chunk_empty = UnmodifiableMutableSetTest::chunk_empty;
            this.payloads.chunk_single = UnmodifiableMutableSetTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = UnmodifiableMutableSetTest::chunk_large_size;
            this.payloads.empty = UnmodifiableMutableSetTest::empty;
            this.payloads.notEmpty = UnmodifiableMutableSetTest::notEmpty;
            this.payloads.aggregateByMutating = UnmodifiableMutableSetTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = UnmodifiableMutableSetTest::aggregateByNonMutating;
            this.payloads.reduceOptional = UnmodifiableMutableSetTest::reduceOptional;
            this.payloads.newEmpty = UnmodifiableMutableSetTest::newEmpty;
            this.payloads.toImmutable = UnmodifiableMutableSetTest::toImmutable;
            this.payloads.testNewWith = UnmodifiableMutableSetTest::testNewWith;
            this.payloads.testNewWithWith = UnmodifiableMutableSetTest::testNewWithWith;
            this.payloads.testNewWithWithWith = UnmodifiableMutableSetTest::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = UnmodifiableMutableSetTest::testNewWithVarArgs;
            this.payloads.injectIntoWith = UnmodifiableMutableSetTest::injectIntoWith;
            this.payloads.selectAndRejectWith = UnmodifiableMutableSetTest::selectAndRejectWith;
            this.payloads.largeCollectionStreamToBagMultimap = UnmodifiableMutableSetTest::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = UnmodifiableMutableSetTest::asLazy;
            this.payloads.removeObject = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::removeObject, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIfWith = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::removeIfWith, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::removeIf, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::removeAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::retainAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.testToString = UnmodifiableMutableSetTest::testToString;
            this.payloads.makeString = UnmodifiableMutableSetTest::makeString;
            this.payloads.appendString = UnmodifiableMutableSetTest::appendString;
            this.payloads.getFirst = UnmodifiableMutableSetTest::getFirst;
            this.payloads.getLast = UnmodifiableMutableSetTest::getLast;
            this.payloads.asSynchronized = UnmodifiableMutableSetTest::asSynchronized;
            this.payloads.asUnmodifiable = UnmodifiableMutableSetTest::asUnmodifiable;
            this.payloads.testEqualsAndHashCode = UnmodifiableMutableSetTest::testEqualsAndHashCode;
            this.payloads.testNewEmpty = UnmodifiableMutableSetTest::testNewEmpty;
            this.payloads.testClone = UnmodifiableMutableSetTest::testClone;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.toSortedBag_natural_ordering = UnmodifiableMutableSetTest::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = UnmodifiableMutableSetTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = UnmodifiableMutableSetTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableSetTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = UnmodifiableMutableSetTest::toSortedBagBy;
        }
    }
}
