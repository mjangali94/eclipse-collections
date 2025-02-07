/*
 * Copyright (c) 2021 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.sorted.mutable;

import java.util.Comparator;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableSortedSet}.
 */
public class UnmodifiableSortedSetTest extends AbstractSortedSetTestCase {

    private static final String LED_ZEPPELIN = "Led Zeppelin";

    private static final String METALLICA = "Metallica";

    private MutableSortedSet<String> mutableSet;

    private MutableSortedSet<String> unmodifiableSet;

    @Before
    public void setUp() {
        this.mutableSet = TreeSortedSet.newSetWith(METALLICA, "Bon Jovi", "Europe", "Scorpions");
        this.unmodifiableSet = this.mutableSet.asUnmodifiable();
    }

    @Override
    protected <T> MutableSortedSet<T> newWith(T... elements) {
        return TreeSortedSet.newSetWith(elements).asUnmodifiable();
    }

    @Override
    protected <T> MutableSortedSet<T> newWith(Comparator<? super T> comparator, T... elements) {
        return TreeSortedSet.newSetWith(comparator, elements).asUnmodifiable();
    }

    @Override
    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedSortedSet.class, this.newWith().asSynchronized());
    }

    @Override
    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableSortedSet.class, this.newWith());
    }

    @Test
    public void testAsUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableSortedSet.class, this.newWith().asUnmodifiable());
        MutableSortedSet<Object> set = this.newWith();
        Assert.assertSame(set, set.asUnmodifiable());
    }

    @Test
    public void testEqualsAndHashCode() {
        Verify.assertEqualsAndHashCode(this.mutableSet, this.unmodifiableSet);
        Verify.assertPostSerializedEqualsAndHashCode(this.unmodifiableSet);
        Verify.assertInstanceOf(UnmodifiableSortedSet.class, SerializeTestHelper.serializeDeserialize(this.unmodifiableSet));
    }

    @Test
    public void testNewEmpty() {
        MutableSortedSet<String> set = this.unmodifiableSet.newEmpty();
        set.add(LED_ZEPPELIN);
        Verify.assertContains(LED_ZEPPELIN, set);
    }

    @Override
    @Test
    public void testClone() {
        MutableSortedSet<String> set = this.newWith();
        MutableSortedSet<String> clone = set.clone();
        Assert.assertSame(clone, set);
    }

    @Override
    @Test
    public void min() {
        super.min();
        Assert.assertEquals("1", this.newWith("1", "3", "2").min(String::compareTo));
    }

    @Override
    @Test
    public void max() {
        super.max();
        Assert.assertEquals("3", this.newWith("1", "3", "2").max(String::compareTo));
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
    @Test(expected = NullPointerException.class)
    public void min_null_throws_without_comparator() {
        super.min_null_throws_without_comparator();
        this.newWith("1", null, "2").min();
    }

    @Override
    @Test(expected = NullPointerException.class)
    public void max_null_throws_without_comparator() {
        super.max_null_throws_without_comparator();
        this.newWith("1", null, "2").max();
    }

    @Override
    @Test
    public void min_without_comparator() {
        super.min_without_comparator();
        Assert.assertEquals("1", this.newWith("1", "3", "2").min());
    }

    @Override
    @Test
    public void max_without_comparator() {
        super.max_without_comparator();
        Assert.assertEquals("3", this.newWith("1", "3", "2").max());
    }

    @Override
    @Test
    public void minBy() {
        super.minBy();
        Assert.assertEquals("1", this.newWith("1", "3", "2").minBy(Functions.getStringToInteger()));
    }

    @Override
    @Test
    public void maxBy() {
        super.maxBy();
        Assert.assertEquals("3", this.newWith("1", "3", "2").maxBy(Functions.getStringToInteger()));
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
        super.testToString();
        MutableCollection<Object> collection = this.newWith(1, 2);
        String toString = collection.toString();
        Assert.assertTrue("[1, 2]".equals(toString) || "[2, 1]".equals(toString));
    }

    @Override
    @Test
    public void makeString() {
        super.makeString();
        MutableCollection<Object> collection = this.newWith(1, 2, 3);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Override
    @Test
    public void appendString() {
        super.appendString();
        MutableCollection<Object> collection = this.newWith(1, 2, 3);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void getFirst() {
        super.getFirst();
        Assert.assertNotNull(this.newWith(1, 2, 3).getFirst());
        Assert.assertNull(this.newWith().getFirst());
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void getLast() {
        super.getLast();
        Assert.assertNotNull(this.newWith(1, 2, 3).getLast());
        Assert.assertNull(this.newWith().getLast());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void subSet() {
        this.newWith(1, 2, 3).subSet(1, 3).clear();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void headSet() {
        this.newWith(1, 2, 3, 4).headSet(3).add(4);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void tailSet() {
        this.newWith(1, 2, 3, 4).tailSet(3).remove(1);
    }

    @Test
    public void serialization() {
        Verify.assertPostSerializedEqualsAndHashCode(this.newWith(1, 2, 3, 4, 5));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with() {
        this.newWith().with(1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll() {
        this.newWith().withAll(FastList.newListWith(1, 2));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without() {
        this.newWith().without(2);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll() {
        this.newWith().withoutAll(FastList.newListWith(1, 2));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void detectLastIndex() {
        this.newWith(1, 2, 3).detectLastIndex(each -> each % 2 == 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void reverseForEach() {
        this.newWith(1, 2, 3).reverseForEach(each -> Assert.fail("Should not be evaluated"));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void reverseForEachWithIndex() {
        this.newWith(1, 2, 3).reverseForEachWithIndex((each, index) -> Assert.fail("Should not be evaluated"));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void toReversed() {
        this.newWith(1, 2, 3).toReversed();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public UnmodifiableSortedSetTest instance;

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
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
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
        public void benchmark_minOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minByOptional);
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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
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
        public void benchmark_corresponds() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.corresponds);
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
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_takeWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.takeWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dropWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dropWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexAllRejected() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexAllRejected);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexNoneRejected() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexNoneRejected);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
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
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
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
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
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
        public void benchmark_firstLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.firstLast);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStack);
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
        public void benchmark_min_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_safe);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_safe);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexWithFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexWithFromTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexOnRange() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexOnRange);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirstOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirstOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLastOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLastOptional);
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
        public void benchmark_testAsUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAsUnmodifiable);
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
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
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
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
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
        public void benchmark_subSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_headSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.headSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tailSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tailSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
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
        public void benchmark_detectLastIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectLastIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseForEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseForEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseForEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toReversed);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableSortedSetTest();
            this.instance.setUp();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> selectWithIndexAllRejected;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> rejectWithIndexNoneRejected;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> unionInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> intersectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> differenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> symmetricDifferenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> powerSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> firstLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> forEachWithIndexWithFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> forEachWithIndexOnRange;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> getFirstOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> getLastOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> testAsUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> testEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> testNewEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> subSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> headSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> tailSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> detectLastIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> reverseForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> reverseForEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedSetTest> toReversed;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = UnmodifiableSortedSetTest::testNewCollection;
            this.payloads.contains = UnmodifiableSortedSetTest::contains;
            this.payloads.containsBy = UnmodifiableSortedSetTest::containsBy;
            this.payloads.containsAllIterable = UnmodifiableSortedSetTest::containsAllIterable;
            this.payloads.containsAnyIterable = UnmodifiableSortedSetTest::containsAnyIterable;
            this.payloads.containsNoneIterable = UnmodifiableSortedSetTest::containsNoneIterable;
            this.payloads.containsAllArray = UnmodifiableSortedSetTest::containsAllArray;
            this.payloads.containsAnyCollection = UnmodifiableSortedSetTest::containsAnyCollection;
            this.payloads.containsNoneCollection = UnmodifiableSortedSetTest::containsNoneCollection;
            this.payloads.containsAllCollection = UnmodifiableSortedSetTest::containsAllCollection;
            this.payloads.forEach = UnmodifiableSortedSetTest::forEach;
            this.payloads.forEachWith = UnmodifiableSortedSetTest::forEachWith;
            this.payloads.forEachWithIndex = UnmodifiableSortedSetTest::forEachWithIndex;
            this.payloads.selectInstancesOf = UnmodifiableSortedSetTest::selectInstancesOf;
            this.payloads.collectTarget = UnmodifiableSortedSetTest::collectTarget;
            this.payloads.collectBoolean = UnmodifiableSortedSetTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = UnmodifiableSortedSetTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = UnmodifiableSortedSetTest::collectBooleanWithBagTarget;
            this.payloads.collectByte = UnmodifiableSortedSetTest::collectByte;
            this.payloads.collectByteWithTarget = UnmodifiableSortedSetTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = UnmodifiableSortedSetTest::collectByteWithBagTarget;
            this.payloads.collectChar = UnmodifiableSortedSetTest::collectChar;
            this.payloads.collectCharWithTarget = UnmodifiableSortedSetTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = UnmodifiableSortedSetTest::collectCharWithBagTarget;
            this.payloads.collectDouble = UnmodifiableSortedSetTest::collectDouble;
            this.payloads.collectDoubleWithTarget = UnmodifiableSortedSetTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = UnmodifiableSortedSetTest::collectDoubleWithBagTarget;
            this.payloads.collectFloat = UnmodifiableSortedSetTest::collectFloat;
            this.payloads.collectFloatWithTarget = UnmodifiableSortedSetTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = UnmodifiableSortedSetTest::collectFloatWithBagTarget;
            this.payloads.collectInt = UnmodifiableSortedSetTest::collectInt;
            this.payloads.collectIntWithTarget = UnmodifiableSortedSetTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = UnmodifiableSortedSetTest::collectIntWithBagTarget;
            this.payloads.collectLong = UnmodifiableSortedSetTest::collectLong;
            this.payloads.collectLongWithTarget = UnmodifiableSortedSetTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = UnmodifiableSortedSetTest::collectLongWithBagTarget;
            this.payloads.collectShort = UnmodifiableSortedSetTest::collectShort;
            this.payloads.collectShortWithTarget = UnmodifiableSortedSetTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = UnmodifiableSortedSetTest::collectShortWithBagTarget;
            this.payloads.flatCollectWith = UnmodifiableSortedSetTest::flatCollectWith;
            this.payloads.flatCollectBoolean = UnmodifiableSortedSetTest::flatCollectBoolean;
            this.payloads.flatCollectByte = UnmodifiableSortedSetTest::flatCollectByte;
            this.payloads.flatCollectShort = UnmodifiableSortedSetTest::flatCollectShort;
            this.payloads.flatCollectInt = UnmodifiableSortedSetTest::flatCollectInt;
            this.payloads.flatCollectChar = UnmodifiableSortedSetTest::flatCollectChar;
            this.payloads.flatCollectLong = UnmodifiableSortedSetTest::flatCollectLong;
            this.payloads.flatCollectDouble = UnmodifiableSortedSetTest::flatCollectDouble;
            this.payloads.flatCollectFloat = UnmodifiableSortedSetTest::flatCollectFloat;
            this.payloads.detect = UnmodifiableSortedSetTest::detect;
            this.payloads.detectOptional = UnmodifiableSortedSetTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minOptional = UnmodifiableSortedSetTest::minOptional;
            this.payloads.maxOptional = UnmodifiableSortedSetTest::maxOptional;
            this.payloads.minByOptional = UnmodifiableSortedSetTest::minByOptional;
            this.payloads.maxByOptional = UnmodifiableSortedSetTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = UnmodifiableSortedSetTest::detectWith;
            this.payloads.detectWithOptional = UnmodifiableSortedSetTest::detectWithOptional;
            this.payloads.detectIfNone = UnmodifiableSortedSetTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = UnmodifiableSortedSetTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = UnmodifiableSortedSetTest::allSatisfy;
            this.payloads.allSatisfyWith = UnmodifiableSortedSetTest::allSatisfyWith;
            this.payloads.noneSatisfy = UnmodifiableSortedSetTest::noneSatisfy;
            this.payloads.noneSatisfyWith = UnmodifiableSortedSetTest::noneSatisfyWith;
            this.payloads.anySatisfy = UnmodifiableSortedSetTest::anySatisfy;
            this.payloads.anySatisfyWith = UnmodifiableSortedSetTest::anySatisfyWith;
            this.payloads.count = UnmodifiableSortedSetTest::count;
            this.payloads.countWith = UnmodifiableSortedSetTest::countWith;
            this.payloads.collectIf = UnmodifiableSortedSetTest::collectIf;
            this.payloads.getAny = UnmodifiableSortedSetTest::getAny;
            this.payloads.getOnly = UnmodifiableSortedSetTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = UnmodifiableSortedSetTest::isEmpty;
            this.payloads.iterator = UnmodifiableSortedSetTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = UnmodifiableSortedSetTest::injectInto;
            this.payloads.injectIntoInt = UnmodifiableSortedSetTest::injectIntoInt;
            this.payloads.injectIntoLong = UnmodifiableSortedSetTest::injectIntoLong;
            this.payloads.injectIntoDouble = UnmodifiableSortedSetTest::injectIntoDouble;
            this.payloads.injectIntoFloat = UnmodifiableSortedSetTest::injectIntoFloat;
            this.payloads.sumFloat = UnmodifiableSortedSetTest::sumFloat;
            this.payloads.summarizeFloat = UnmodifiableSortedSetTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = UnmodifiableSortedSetTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = UnmodifiableSortedSetTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = UnmodifiableSortedSetTest::sumDouble;
            this.payloads.summarizeDouble = UnmodifiableSortedSetTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = UnmodifiableSortedSetTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = UnmodifiableSortedSetTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = UnmodifiableSortedSetTest::sumInteger;
            this.payloads.summarizeInt = UnmodifiableSortedSetTest::summarizeInt;
            this.payloads.sumLong = UnmodifiableSortedSetTest::sumLong;
            this.payloads.summarizeLong = UnmodifiableSortedSetTest::summarizeLong;
            this.payloads.sumByInt = UnmodifiableSortedSetTest::sumByInt;
            this.payloads.sumByFloat = UnmodifiableSortedSetTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = UnmodifiableSortedSetTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = UnmodifiableSortedSetTest::sumByLong;
            this.payloads.sumByDouble = UnmodifiableSortedSetTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = UnmodifiableSortedSetTest::sumByDoubleConsistentRounding;
            this.payloads.toArray = UnmodifiableSortedSetTest::toArray;
            this.payloads.toList = UnmodifiableSortedSetTest::toList;
            this.payloads.toImmutableList = UnmodifiableSortedSetTest::toImmutableList;
            this.payloads.toCollection = UnmodifiableSortedSetTest::toCollection;
            this.payloads.toBag = UnmodifiableSortedSetTest::toBag;
            this.payloads.toImmutableBag = UnmodifiableSortedSetTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = UnmodifiableSortedSetTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = UnmodifiableSortedSetTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = UnmodifiableSortedSetTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = UnmodifiableSortedSetTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBag_natural_ordering = UnmodifiableSortedSetTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBagBy = UnmodifiableSortedSetTest::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = UnmodifiableSortedSetTest::toSortedListBy;
            this.payloads.toImmutableSortedListBy = UnmodifiableSortedSetTest::toImmutableSortedListBy;
            this.payloads.toImmutableSortSet_natural_ordering = UnmodifiableSortedSetTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = UnmodifiableSortedSetTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = UnmodifiableSortedSetTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = UnmodifiableSortedSetTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = UnmodifiableSortedSetTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = UnmodifiableSortedSetTest::toSet;
            this.payloads.toImmutableSet = UnmodifiableSortedSetTest::toImmutableSet;
            this.payloads.toMap = UnmodifiableSortedSetTest::toMap;
            this.payloads.toImmutableMap = UnmodifiableSortedSetTest::toImmutableMap;
            this.payloads.toMapTarget = UnmodifiableSortedSetTest::toMapTarget;
            this.payloads.toSortedMap = UnmodifiableSortedSetTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = UnmodifiableSortedSetTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = UnmodifiableSortedSetTest::toSortedMapBy;
            this.payloads.toBiMap = UnmodifiableSortedSetTest::toBiMap;
            this.payloads.toImmutableBiMap = UnmodifiableSortedSetTest::toImmutableBiMap;
            this.payloads.makeStringWithSeparator = UnmodifiableSortedSetTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = UnmodifiableSortedSetTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = UnmodifiableSortedSetTest::fusedCollectMakeString;
            this.payloads.appendStringWithSeparator = UnmodifiableSortedSetTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = UnmodifiableSortedSetTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = UnmodifiableSortedSetTest::appendStringThrows;
            this.payloads.countBy = UnmodifiableSortedSetTest::countBy;
            this.payloads.countByWith = UnmodifiableSortedSetTest::countByWith;
            this.payloads.countByEach = UnmodifiableSortedSetTest::countByEach;
            this.payloads.groupByUniqueKey = UnmodifiableSortedSetTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = UnmodifiableSortedSetTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.chunk = UnmodifiableSortedSetTest::chunk;
            this.payloads.chunk_empty = UnmodifiableSortedSetTest::chunk_empty;
            this.payloads.chunk_single = UnmodifiableSortedSetTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = UnmodifiableSortedSetTest::chunk_large_size;
            this.payloads.empty = UnmodifiableSortedSetTest::empty;
            this.payloads.notEmpty = UnmodifiableSortedSetTest::notEmpty;
            this.payloads.aggregateByMutating = UnmodifiableSortedSetTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = UnmodifiableSortedSetTest::aggregateByNonMutating;
            this.payloads.reduceOptional = UnmodifiableSortedSetTest::reduceOptional;
            this.payloads.newEmpty = UnmodifiableSortedSetTest::newEmpty;
            this.payloads.testNewWith = UnmodifiableSortedSetTest::testNewWith;
            this.payloads.testNewWithWith = UnmodifiableSortedSetTest::testNewWithWith;
            this.payloads.testNewWithWithWith = UnmodifiableSortedSetTest::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = UnmodifiableSortedSetTest::testNewWithVarArgs;
            this.payloads.injectIntoWith = UnmodifiableSortedSetTest::injectIntoWith;
            this.payloads.selectAndRejectWith = UnmodifiableSortedSetTest::selectAndRejectWith;
            this.payloads.largeCollectionStreamToBagMultimap = UnmodifiableSortedSetTest::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = UnmodifiableSortedSetTest::asLazy;
            this.payloads.toImmutable = UnmodifiableSortedSetTest::toImmutable;
            this.payloads.equalsAndHashCode = UnmodifiableSortedSetTest::equalsAndHashCode;
            this.payloads.tap = UnmodifiableSortedSetTest::tap;
            this.payloads.corresponds = UnmodifiableSortedSetTest::corresponds;
            this.payloads.select = UnmodifiableSortedSetTest::select;
            this.payloads.selectWith = UnmodifiableSortedSetTest::selectWith;
            this.payloads.selectWith_target = UnmodifiableSortedSetTest::selectWith_target;
            this.payloads.reject = UnmodifiableSortedSetTest::reject;
            this.payloads.rejectWith = UnmodifiableSortedSetTest::rejectWith;
            this.payloads.rejectWith_target = UnmodifiableSortedSetTest::rejectWith_target;
            this.payloads.partition = UnmodifiableSortedSetTest::partition;
            this.payloads.partitionWith = UnmodifiableSortedSetTest::partitionWith;
            this.payloads.partitionWhile = UnmodifiableSortedSetTest::partitionWhile;
            this.payloads.takeWhile = UnmodifiableSortedSetTest::takeWhile;
            this.payloads.dropWhile = UnmodifiableSortedSetTest::dropWhile;
            this.payloads.distinct = UnmodifiableSortedSetTest::distinct;
            this.payloads.collect = UnmodifiableSortedSetTest::collect;
            this.payloads.collectWithIndex = UnmodifiableSortedSetTest::collectWithIndex;
            this.payloads.selectWithIndex = UnmodifiableSortedSetTest::selectWithIndex;
            this.payloads.selectWithIndexAllRejected = UnmodifiableSortedSetTest::selectWithIndexAllRejected;
            this.payloads.rejectWithIndexNoneRejected = UnmodifiableSortedSetTest::rejectWithIndexNoneRejected;
            this.payloads.rejectWithIndex = UnmodifiableSortedSetTest::rejectWithIndex;
            this.payloads.collectWithIndexWithTarget = UnmodifiableSortedSetTest::collectWithIndexWithTarget;
            this.payloads.selectWithIndexWithTarget = UnmodifiableSortedSetTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndexWithTarget = UnmodifiableSortedSetTest::rejectWithIndexWithTarget;
            this.payloads.collectWith = UnmodifiableSortedSetTest::collectWith;
            this.payloads.collectWith_target = UnmodifiableSortedSetTest::collectWith_target;
            this.payloads.flatCollect = UnmodifiableSortedSetTest::flatCollect;
            this.payloads.groupBy = UnmodifiableSortedSetTest::groupBy;
            this.payloads.groupByEach = UnmodifiableSortedSetTest::groupByEach;
            this.payloads.zip = UnmodifiableSortedSetTest::zip;
            this.payloads.zipWithIndex = UnmodifiableSortedSetTest::zipWithIndex;
            this.payloads.union = UnmodifiableSortedSetTest::union;
            this.payloads.unionInto = UnmodifiableSortedSetTest::unionInto;
            this.payloads.intersect = UnmodifiableSortedSetTest::intersect;
            this.payloads.intersectInto = UnmodifiableSortedSetTest::intersectInto;
            this.payloads.difference = UnmodifiableSortedSetTest::difference;
            this.payloads.differenceInto = UnmodifiableSortedSetTest::differenceInto;
            this.payloads.symmetricDifference = UnmodifiableSortedSetTest::symmetricDifference;
            this.payloads.symmetricDifferenceInto = UnmodifiableSortedSetTest::symmetricDifferenceInto;
            this.payloads.isSubsetOf = UnmodifiableSortedSetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = UnmodifiableSortedSetTest::isProperSubsetOf;
            this.payloads.powerSet = UnmodifiableSortedSetTest::powerSet;
            this.payloads.cartesianProduct = UnmodifiableSortedSetTest::cartesianProduct;
            this.payloads.firstLast = UnmodifiableSortedSetTest::firstLast;
            this.payloads.toSortedSet_natural_ordering = UnmodifiableSortedSetTest::toSortedSet_natural_ordering;
            this.payloads.toStack = UnmodifiableSortedSetTest::toStack;
            this.payloads.toSortedBag_natural_ordering = UnmodifiableSortedSetTest::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = UnmodifiableSortedSetTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = UnmodifiableSortedSetTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = UnmodifiableSortedSetTest::toSortedBagBy;
            this.payloads.min_null_safe = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::min_null_safe, java.lang.NullPointerException.class);
            this.payloads.max_null_safe = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::max_null_safe, java.lang.NullPointerException.class);
            this.payloads.forEachWithIndexWithFromTo = UnmodifiableSortedSetTest::forEachWithIndexWithFromTo;
            this.payloads.forEachWithIndexOnRange = UnmodifiableSortedSetTest::forEachWithIndexOnRange;
            this.payloads.indexOf = UnmodifiableSortedSetTest::indexOf;
            this.payloads.detectIndex = UnmodifiableSortedSetTest::detectIndex;
            this.payloads.take = UnmodifiableSortedSetTest::take;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = UnmodifiableSortedSetTest::drop;
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::drop_throws, java.lang.IllegalArgumentException.class);
            this.payloads.getFirstOptional = UnmodifiableSortedSetTest::getFirstOptional;
            this.payloads.getLastOptional = UnmodifiableSortedSetTest::getLastOptional;
            this.payloads.asSynchronized = UnmodifiableSortedSetTest::asSynchronized;
            this.payloads.asUnmodifiable = UnmodifiableSortedSetTest::asUnmodifiable;
            this.payloads.testAsUnmodifiable = UnmodifiableSortedSetTest::testAsUnmodifiable;
            this.payloads.testEqualsAndHashCode = UnmodifiableSortedSetTest::testEqualsAndHashCode;
            this.payloads.testNewEmpty = UnmodifiableSortedSetTest::testNewEmpty;
            this.payloads.testClone = UnmodifiableSortedSetTest::testClone;
            this.payloads.min = UnmodifiableSortedSetTest::min;
            this.payloads.max = UnmodifiableSortedSetTest::max;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = UnmodifiableSortedSetTest::min_without_comparator;
            this.payloads.max_without_comparator = UnmodifiableSortedSetTest::max_without_comparator;
            this.payloads.minBy = UnmodifiableSortedSetTest::minBy;
            this.payloads.maxBy = UnmodifiableSortedSetTest::maxBy;
            this.payloads.removeObject = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::removeObject, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIfWith = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::removeIfWith, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::removeIf, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::removeAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::retainAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.testToString = UnmodifiableSortedSetTest::testToString;
            this.payloads.makeString = UnmodifiableSortedSetTest::makeString;
            this.payloads.appendString = UnmodifiableSortedSetTest::appendString;
            this.payloads.getFirst = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::getFirst, java.util.NoSuchElementException.class);
            this.payloads.getLast = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::getLast, java.util.NoSuchElementException.class);
            this.payloads.subSet = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::subSet, java.lang.UnsupportedOperationException.class);
            this.payloads.headSet = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::headSet, java.lang.UnsupportedOperationException.class);
            this.payloads.tailSet = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::tailSet, java.lang.UnsupportedOperationException.class);
            this.payloads.serialization = UnmodifiableSortedSetTest::serialization;
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.detectLastIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::detectLastIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.reverseForEach = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::reverseForEach, java.lang.UnsupportedOperationException.class);
            this.payloads.reverseForEachWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::reverseForEachWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.toReversed = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedSetTest::toReversed, java.lang.UnsupportedOperationException.class);
        }
    }
}
