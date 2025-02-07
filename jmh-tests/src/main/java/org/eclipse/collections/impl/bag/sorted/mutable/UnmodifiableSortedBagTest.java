/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.sorted.mutable;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableSortedBag}.
 *
 * @since 4.2
 */
public class UnmodifiableSortedBagTest extends AbstractMutableSortedBagTestCase {

    @Override
    protected <T> MutableSortedBag<T> newWith(T... elements) {
        return TreeBag.newBagWith(elements).asUnmodifiable();
    }

    @SafeVarargs
    @Override
    protected final <T> MutableSortedBag<T> newWithOccurrences(ObjectIntPair<T>... elementsWithOccurrences) {
        MutableSortedBag<T> bag = TreeBag.newBag();
        for (int i = 0; i < elementsWithOccurrences.length; i++) {
            ObjectIntPair<T> itemToAdd = elementsWithOccurrences[i];
            bag.addOccurrences(itemToAdd.getOne(), itemToAdd.getTwo());
        }
        return bag.asUnmodifiable();
    }

    @Override
    protected <T> MutableSortedBag<T> newWith(Comparator<? super T> comparator, T... elements) {
        return TreeBag.newBagWith(comparator, elements).asUnmodifiable();
    }

    @Override
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        Verify.assertInstanceOf(UnmodifiableSortedBag.class, SerializeTestHelper.serializeDeserialize(this.newWith(Comparators.reverseNaturalOrder(), 1, 2, 3)));
        Verify.assertInstanceOf(UnmodifiableSortedBag.class, SerializeTestHelper.serializeDeserialize(this.newWith(1, 2, 3)));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void toString_with_collection_containing_self() {
        super.toString_with_collection_containing_self();
        MutableCollection<Object> collection = this.newWith(1);
        collection.add(collection);
        String simpleName = collection.getClass().getSimpleName();
        String string = collection.toString();
        Assert.assertTrue(("[1, (this " + simpleName + ")]").equals(string) || ("[(this " + simpleName + "), 1]").equals(string));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void makeString_with_collection_containing_self() {
        super.makeString_with_collection_containing_self();
        MutableCollection<Object> collection = this.newWith(1, 2, 3);
        collection.add(collection);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void appendString_with_collection_containing_self() {
        super.appendString_with_collection_containing_self();
        MutableCollection<Object> collection = this.newWith(1, 2, 3);
        collection.add(collection);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Override
    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedSortedBag.class, this.newWith().asSynchronized());
    }

    @Override
    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableSortedBag.class, this.newWith());
    }

    @Override
    @Test
    public void iterator() {
        MutableSortedBag<Integer> bag = this.newWith(-1, 0, 1, 1, 2);
        Iterator<Integer> iterator = bag.iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(Integer.valueOf(-1), iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(Integer.valueOf(0), iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(Integer.valueOf(1), iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(Integer.valueOf(1), iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(Integer.valueOf(2), iterator.next());
        Assert.assertFalse(iterator.hasNext());
        MutableSortedBag<Integer> revBag = this.newWith(Comparators.reverseNaturalOrder(), -1, 0, 1, 1, 2);
        Iterator<Integer> revIterator = revBag.iterator();
        Assert.assertTrue(revIterator.hasNext());
        Assert.assertEquals(Integer.valueOf(2), revIterator.next());
        Assert.assertTrue(revIterator.hasNext());
        Assert.assertEquals(Integer.valueOf(1), revIterator.next());
        Assert.assertTrue(revIterator.hasNext());
        Assert.assertEquals(Integer.valueOf(1), revIterator.next());
        Assert.assertTrue(revIterator.hasNext());
        Assert.assertEquals(Integer.valueOf(0), revIterator.next());
        Assert.assertTrue(revIterator.hasNext());
        Assert.assertEquals(Integer.valueOf(-1), revIterator.next());
        Assert.assertFalse(revIterator.hasNext());
        Iterator<Integer> iterator3 = this.newWith(Comparators.reverseNaturalOrder(), 2, 1, 1, 0, -1).iterator();
        Assert.assertThrows(UnsupportedOperationException.class, iterator3::remove);
        Assert.assertEquals(Integer.valueOf(2), iterator3.next());
        Assert.assertThrows(UnsupportedOperationException.class, iterator3::remove);
    }

    @Override
    @Test
    public void iteratorRemove() {
        MutableSortedBag<Integer> bag = this.newWith(-1, 0, 1, 1, 2);
        Iterator<Integer> iterator = bag.iterator();
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void iteratorRemove2() {
    }

    @Test
    public void testAsUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableSortedBag.class, this.newWith().asUnmodifiable());
        MutableSortedBag<Object> bag = this.newWith();
        Assert.assertSame(bag, bag.asUnmodifiable());
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
    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        super.add();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addOccurrences() {
        super.addOccurrences();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addOccurrences_throws() {
        super.addOccurrences_throws();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeObject() {
        super.removeObject();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeOccurrences() {
        super.removeOccurrences();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeOccurrences_throws() {
        super.removeOccurrences_throws();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void setOccurrences() {
        super.setOccurrences();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void setOccurrences_throws() {
        super.setOccurrences_throws();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void forEachWithOccurrences() {
        super.forEachWithOccurrences();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with() {
        super.with();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll() {
        super.withAll();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without() {
        super.without();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll() {
        super.withoutAll();
    }

    @Override
    @Test
    public void testClone() {
        MutableSortedBag<Integer> set = this.newWith(1, 2, 3);
        MutableSortedBag<Integer> clone = set.clone();
        Assert.assertSame(set, clone);
        Verify.assertSortedBagsEqual(set, clone);
    }

    @Override
    @Test
    public void collectWithOccurrences() {
        Bag<Integer> bag1 = this.newWith(3, 3, 3, 2, 2, 1);
        Bag<ObjectIntPair<Integer>> actual1 = bag1.collectWithOccurrences(PrimitiveTuples::pair, Bags.mutable.empty());
        Assert.assertEquals(Bags.immutable.with(PrimitiveTuples.pair(Integer.valueOf(3), 3), PrimitiveTuples.pair(Integer.valueOf(2), 2), PrimitiveTuples.pair(Integer.valueOf(1), 1)), actual1);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(Integer.valueOf(1), 1), PrimitiveTuples.pair(Integer.valueOf(2), 2), PrimitiveTuples.pair(Integer.valueOf(3), 3)), bag1.collectWithOccurrences(PrimitiveTuples::pair));
        Set<ObjectIntPair<Integer>> actual2 = bag1.collectWithOccurrences(PrimitiveTuples::pair, Sets.mutable.empty());
        Assert.assertEquals(Sets.immutable.with(PrimitiveTuples.pair(Integer.valueOf(3), 3), PrimitiveTuples.pair(Integer.valueOf(2), 2), PrimitiveTuples.pair(Integer.valueOf(1), 1)), actual2);
        Bag<Integer> bag2 = this.newWith(3, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 1, 1, 4, 5, 7);
        Assert.assertEquals(Lists.mutable.with(6, 5, 8, 5, 6, 8), bag2.collectWithOccurrences((each, index) -> each + index));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public UnmodifiableSortedBagTest instance;

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
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
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
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectTarget);
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
        public void benchmark_collectByteWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithBagTarget);
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
        public void benchmark_collectDoubleWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithBagTarget);
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
        public void benchmark_collectIntWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithBagTarget);
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
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
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
        public void benchmark_summarizeInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeInt);
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
        public void benchmark_toImmutableList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_natural_ordering);
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
        public void benchmark_toImmutableSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagBy);
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
        public void benchmark_toImmutableSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSet_with_comparator);
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
        public void benchmark_toImmutableMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapTarget);
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
        public void benchmark_largeCollectionStreamToBagMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.largeCollectionStreamToBagMultimap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListWith);
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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
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
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
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
        public void benchmark_selectAndRejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectAndRejectWith);
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
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
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
        public void benchmark_toStringOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStringOfItemToCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
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
        public void benchmark_forEachFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachFromTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexWithFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexWithFromTo);
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
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occurrencesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occurrencesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStack);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_natural_ordering);
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
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
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
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
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
        public void benchmark_toMapOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapOfItemToCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_compareTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.compareTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
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
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
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
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
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
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
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
        public void benchmark_corresponds() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.corresponds);
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
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWith);
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
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
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
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_topOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.topOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_bottomOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.bottomOccurrences);
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
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectUnique);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toString_with_collection_containing_self() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toString_with_collection_containing_self);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString_with_collection_containing_self() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString_with_collection_containing_self);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString_with_collection_containing_self() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString_with_collection_containing_self);
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
        public void benchmark_testAsUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAsUnmodifiable);
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
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
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
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
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
        public void benchmark_forEachWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithOccurrences);
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
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithOccurrences);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableSortedBagTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toSortedListWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> anySatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> noneSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> allSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> detectWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> forEachWithIndexWithFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> occurrencesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toMapOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> compareTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> distinctView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> toString_with_collection_containing_self;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> makeString_with_collection_containing_self;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> appendString_with_collection_containing_self;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> iteratorRemove2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> testAsUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> addOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> addOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> removeOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> removeOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> setOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> setOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableSortedBagTest> collectWithOccurrences;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = UnmodifiableSortedBagTest::testNewCollection;
            this.payloads.contains = UnmodifiableSortedBagTest::contains;
            this.payloads.containsBy = UnmodifiableSortedBagTest::containsBy;
            this.payloads.containsAnyIterable = UnmodifiableSortedBagTest::containsAnyIterable;
            this.payloads.containsNoneIterable = UnmodifiableSortedBagTest::containsNoneIterable;
            this.payloads.containsAnyCollection = UnmodifiableSortedBagTest::containsAnyCollection;
            this.payloads.containsNoneCollection = UnmodifiableSortedBagTest::containsNoneCollection;
            this.payloads.containsAllCollection = UnmodifiableSortedBagTest::containsAllCollection;
            this.payloads.selectInstancesOf = UnmodifiableSortedBagTest::selectInstancesOf;
            this.payloads.collectTarget = UnmodifiableSortedBagTest::collectTarget;
            this.payloads.collectBooleanWithTarget = UnmodifiableSortedBagTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = UnmodifiableSortedBagTest::collectBooleanWithBagTarget;
            this.payloads.collectByteWithTarget = UnmodifiableSortedBagTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = UnmodifiableSortedBagTest::collectByteWithBagTarget;
            this.payloads.collectCharWithTarget = UnmodifiableSortedBagTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = UnmodifiableSortedBagTest::collectCharWithBagTarget;
            this.payloads.collectDoubleWithTarget = UnmodifiableSortedBagTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = UnmodifiableSortedBagTest::collectDoubleWithBagTarget;
            this.payloads.collectFloatWithTarget = UnmodifiableSortedBagTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = UnmodifiableSortedBagTest::collectFloatWithBagTarget;
            this.payloads.collectIntWithTarget = UnmodifiableSortedBagTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = UnmodifiableSortedBagTest::collectIntWithBagTarget;
            this.payloads.collectLongWithTarget = UnmodifiableSortedBagTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = UnmodifiableSortedBagTest::collectLongWithBagTarget;
            this.payloads.collectShortWithTarget = UnmodifiableSortedBagTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = UnmodifiableSortedBagTest::collectShortWithBagTarget;
            this.payloads.flatCollectWith = UnmodifiableSortedBagTest::flatCollectWith;
            this.payloads.flatCollectBoolean = UnmodifiableSortedBagTest::flatCollectBoolean;
            this.payloads.flatCollectByte = UnmodifiableSortedBagTest::flatCollectByte;
            this.payloads.flatCollectShort = UnmodifiableSortedBagTest::flatCollectShort;
            this.payloads.flatCollectInt = UnmodifiableSortedBagTest::flatCollectInt;
            this.payloads.flatCollectChar = UnmodifiableSortedBagTest::flatCollectChar;
            this.payloads.flatCollectLong = UnmodifiableSortedBagTest::flatCollectLong;
            this.payloads.flatCollectDouble = UnmodifiableSortedBagTest::flatCollectDouble;
            this.payloads.flatCollectFloat = UnmodifiableSortedBagTest::flatCollectFloat;
            this.payloads.detectOptional = UnmodifiableSortedBagTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minOptional = UnmodifiableSortedBagTest::minOptional;
            this.payloads.maxOptional = UnmodifiableSortedBagTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = UnmodifiableSortedBagTest::min_without_comparator;
            this.payloads.max_without_comparator = UnmodifiableSortedBagTest::max_without_comparator;
            this.payloads.minByOptional = UnmodifiableSortedBagTest::minByOptional;
            this.payloads.maxByOptional = UnmodifiableSortedBagTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWithOptional = UnmodifiableSortedBagTest::detectWithOptional;
            this.payloads.getAny = UnmodifiableSortedBagTest::getAny;
            this.payloads.getOnly = UnmodifiableSortedBagTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = UnmodifiableSortedBagTest::isEmpty;
            this.payloads.summarizeFloat = UnmodifiableSortedBagTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = UnmodifiableSortedBagTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = UnmodifiableSortedBagTest::sumFloatConsistentRounding2;
            this.payloads.summarizeDouble = UnmodifiableSortedBagTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = UnmodifiableSortedBagTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = UnmodifiableSortedBagTest::sumDoubleConsistentRounding2;
            this.payloads.summarizeInt = UnmodifiableSortedBagTest::summarizeInt;
            this.payloads.summarizeLong = UnmodifiableSortedBagTest::summarizeLong;
            this.payloads.sumByInt = UnmodifiableSortedBagTest::sumByInt;
            this.payloads.sumByFloat = UnmodifiableSortedBagTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = UnmodifiableSortedBagTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = UnmodifiableSortedBagTest::sumByLong;
            this.payloads.sumByDouble = UnmodifiableSortedBagTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = UnmodifiableSortedBagTest::sumByDoubleConsistentRounding;
            this.payloads.toImmutableList = UnmodifiableSortedBagTest::toImmutableList;
            this.payloads.toCollection = UnmodifiableSortedBagTest::toCollection;
            this.payloads.toImmutableBag = UnmodifiableSortedBagTest::toImmutableBag;
            this.payloads.toImmutableSortedList_natural_ordering = UnmodifiableSortedBagTest::toImmutableSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_with_comparator = UnmodifiableSortedBagTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBag_natural_ordering = UnmodifiableSortedBagTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_with_comparator = UnmodifiableSortedBagTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBagBy = UnmodifiableSortedBagTest::toImmutableSortedBagBy;
            this.payloads.toImmutableSortedListBy = UnmodifiableSortedBagTest::toImmutableSortedListBy;
            this.payloads.toImmutableSortSet_natural_ordering = UnmodifiableSortedBagTest::toImmutableSortSet_natural_ordering;
            this.payloads.toImmutableSortedSet_with_comparator = UnmodifiableSortedBagTest::toImmutableSortedSet_with_comparator;
            this.payloads.toImmutableSortedSetBy = UnmodifiableSortedBagTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSet = UnmodifiableSortedBagTest::toImmutableSet;
            this.payloads.toImmutableMap = UnmodifiableSortedBagTest::toImmutableMap;
            this.payloads.toMapTarget = UnmodifiableSortedBagTest::toMapTarget;
            this.payloads.toBiMap = UnmodifiableSortedBagTest::toBiMap;
            this.payloads.toImmutableBiMap = UnmodifiableSortedBagTest::toImmutableBiMap;
            this.payloads.makeStringWithSeparator = UnmodifiableSortedBagTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = UnmodifiableSortedBagTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = UnmodifiableSortedBagTest::fusedCollectMakeString;
            this.payloads.appendStringWithSeparator = UnmodifiableSortedBagTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = UnmodifiableSortedBagTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = UnmodifiableSortedBagTest::appendStringThrows;
            this.payloads.countBy = UnmodifiableSortedBagTest::countBy;
            this.payloads.countByWith = UnmodifiableSortedBagTest::countByWith;
            this.payloads.countByEach = UnmodifiableSortedBagTest::countByEach;
            this.payloads.groupByUniqueKey = UnmodifiableSortedBagTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = UnmodifiableSortedBagTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.chunk_empty = UnmodifiableSortedBagTest::chunk_empty;
            this.payloads.chunk_single = UnmodifiableSortedBagTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = UnmodifiableSortedBagTest::chunk_large_size;
            this.payloads.empty = UnmodifiableSortedBagTest::empty;
            this.payloads.notEmpty = UnmodifiableSortedBagTest::notEmpty;
            this.payloads.reduceOptional = UnmodifiableSortedBagTest::reduceOptional;
            this.payloads.newEmpty = UnmodifiableSortedBagTest::newEmpty;
            this.payloads.testNewWith = UnmodifiableSortedBagTest::testNewWith;
            this.payloads.testNewWithWith = UnmodifiableSortedBagTest::testNewWithWith;
            this.payloads.testNewWithWithWith = UnmodifiableSortedBagTest::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = UnmodifiableSortedBagTest::testNewWithVarArgs;
            this.payloads.largeCollectionStreamToBagMultimap = UnmodifiableSortedBagTest::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = UnmodifiableSortedBagTest::asLazy;
            this.payloads.toSortedListWith = UnmodifiableSortedBagTest::toSortedListWith;
            this.payloads.anySatisfyWithOccurrences = UnmodifiableSortedBagTest::anySatisfyWithOccurrences;
            this.payloads.noneSatisfyWithOccurrences = UnmodifiableSortedBagTest::noneSatisfyWithOccurrences;
            this.payloads.allSatisfyWithOccurrences = UnmodifiableSortedBagTest::allSatisfyWithOccurrences;
            this.payloads.detectWithOccurrences = UnmodifiableSortedBagTest::detectWithOccurrences;
            this.payloads.toImmutable = UnmodifiableSortedBagTest::toImmutable;
            this.payloads.testToString = UnmodifiableSortedBagTest::testToString;
            this.payloads.makeString = UnmodifiableSortedBagTest::makeString;
            this.payloads.appendString = UnmodifiableSortedBagTest::appendString;
            this.payloads.equalsAndHashCode = UnmodifiableSortedBagTest::equalsAndHashCode;
            this.payloads.select = UnmodifiableSortedBagTest::select;
            this.payloads.selectWith = UnmodifiableSortedBagTest::selectWith;
            this.payloads.selectWith_target = UnmodifiableSortedBagTest::selectWith_target;
            this.payloads.reject = UnmodifiableSortedBagTest::reject;
            this.payloads.rejectWith = UnmodifiableSortedBagTest::rejectWith;
            this.payloads.rejectWith_target = UnmodifiableSortedBagTest::rejectWith_target;
            this.payloads.partition = UnmodifiableSortedBagTest::partition;
            this.payloads.partitionWith = UnmodifiableSortedBagTest::partitionWith;
            this.payloads.partitionWhile = UnmodifiableSortedBagTest::partitionWhile;
            this.payloads.selectAndRejectWith = UnmodifiableSortedBagTest::selectAndRejectWith;
            this.payloads.collect = UnmodifiableSortedBagTest::collect;
            this.payloads.collectWithIndex = UnmodifiableSortedBagTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = UnmodifiableSortedBagTest::collectWithIndexWithTarget;
            this.payloads.flatCollect = UnmodifiableSortedBagTest::flatCollect;
            this.payloads.distinct = UnmodifiableSortedBagTest::distinct;
            this.payloads.takeWhile = UnmodifiableSortedBagTest::takeWhile;
            this.payloads.dropWhile = UnmodifiableSortedBagTest::dropWhile;
            this.payloads.collectIf = UnmodifiableSortedBagTest::collectIf;
            this.payloads.collectWith = UnmodifiableSortedBagTest::collectWith;
            this.payloads.collectWith_target = UnmodifiableSortedBagTest::collectWith_target;
            this.payloads.groupBy = UnmodifiableSortedBagTest::groupBy;
            this.payloads.groupByEach = UnmodifiableSortedBagTest::groupByEach;
            this.payloads.zip = UnmodifiableSortedBagTest::zip;
            this.payloads.zipWithIndex = UnmodifiableSortedBagTest::zipWithIndex;
            this.payloads.toStringOfItemToCount = UnmodifiableSortedBagTest::toStringOfItemToCount;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.tap = UnmodifiableSortedBagTest::tap;
            this.payloads.forEach = UnmodifiableSortedBagTest::forEach;
            this.payloads.forEachFromTo = UnmodifiableSortedBagTest::forEachFromTo;
            this.payloads.forEachWithIndexWithFromTo = UnmodifiableSortedBagTest::forEachWithIndexWithFromTo;
            this.payloads.getFirst = UnmodifiableSortedBagTest::getFirst;
            this.payloads.getLast = UnmodifiableSortedBagTest::getLast;
            this.payloads.indexOf = UnmodifiableSortedBagTest::indexOf;
            this.payloads.occurrencesOf = UnmodifiableSortedBagTest::occurrencesOf;
            this.payloads.toList = UnmodifiableSortedBagTest::toList;
            this.payloads.toSet = UnmodifiableSortedBagTest::toSet;
            this.payloads.toBag = UnmodifiableSortedBagTest::toBag;
            this.payloads.toStack = UnmodifiableSortedBagTest::toStack;
            this.payloads.toSortedList_natural_ordering = UnmodifiableSortedBagTest::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = UnmodifiableSortedBagTest::toSortedList_with_comparator;
            this.payloads.toSortedListBy = UnmodifiableSortedBagTest::toSortedListBy;
            this.payloads.toSortedSet_natural_ordering = UnmodifiableSortedBagTest::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = UnmodifiableSortedBagTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = UnmodifiableSortedBagTest::toSortedSetBy;
            this.payloads.toMap = UnmodifiableSortedBagTest::toMap;
            this.payloads.toSortedMap = UnmodifiableSortedBagTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = UnmodifiableSortedBagTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = UnmodifiableSortedBagTest::toSortedMapBy;
            this.payloads.serialization = UnmodifiableSortedBagTest::serialization;
            this.payloads.selectByOccurrences = UnmodifiableSortedBagTest::selectByOccurrences;
            this.payloads.selectDuplicates = UnmodifiableSortedBagTest::selectDuplicates;
            this.payloads.toMapOfItemToCount = UnmodifiableSortedBagTest::toMapOfItemToCount;
            this.payloads.compareTo = UnmodifiableSortedBagTest::compareTo;
            this.payloads.containsAllIterable = UnmodifiableSortedBagTest::containsAllIterable;
            this.payloads.containsAllArray = UnmodifiableSortedBagTest::containsAllArray;
            this.payloads.forEachWith = UnmodifiableSortedBagTest::forEachWith;
            this.payloads.forEachWithIndex = UnmodifiableSortedBagTest::forEachWithIndex;
            this.payloads.collectBoolean = UnmodifiableSortedBagTest::collectBoolean;
            this.payloads.collectByte = UnmodifiableSortedBagTest::collectByte;
            this.payloads.collectChar = UnmodifiableSortedBagTest::collectChar;
            this.payloads.collectDouble = UnmodifiableSortedBagTest::collectDouble;
            this.payloads.collectFloat = UnmodifiableSortedBagTest::collectFloat;
            this.payloads.collectInt = UnmodifiableSortedBagTest::collectInt;
            this.payloads.collectLong = UnmodifiableSortedBagTest::collectLong;
            this.payloads.collectShort = UnmodifiableSortedBagTest::collectShort;
            this.payloads.detect = UnmodifiableSortedBagTest::detect;
            this.payloads.min = UnmodifiableSortedBagTest::min;
            this.payloads.max = UnmodifiableSortedBagTest::max;
            this.payloads.minBy = UnmodifiableSortedBagTest::minBy;
            this.payloads.maxBy = UnmodifiableSortedBagTest::maxBy;
            this.payloads.detectWith = UnmodifiableSortedBagTest::detectWith;
            this.payloads.detectIfNone = UnmodifiableSortedBagTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = UnmodifiableSortedBagTest::detectWithIfNoneBlock;
            this.payloads.corresponds = UnmodifiableSortedBagTest::corresponds;
            this.payloads.allSatisfy = UnmodifiableSortedBagTest::allSatisfy;
            this.payloads.allSatisfyWith = UnmodifiableSortedBagTest::allSatisfyWith;
            this.payloads.noneSatisfy = UnmodifiableSortedBagTest::noneSatisfy;
            this.payloads.noneSatisfyWith = UnmodifiableSortedBagTest::noneSatisfyWith;
            this.payloads.anySatisfy = UnmodifiableSortedBagTest::anySatisfy;
            this.payloads.anySatisfyWith = UnmodifiableSortedBagTest::anySatisfyWith;
            this.payloads.count = UnmodifiableSortedBagTest::count;
            this.payloads.countWith = UnmodifiableSortedBagTest::countWith;
            this.payloads.injectInto = UnmodifiableSortedBagTest::injectInto;
            this.payloads.injectIntoWith = UnmodifiableSortedBagTest::injectIntoWith;
            this.payloads.injectIntoInt = UnmodifiableSortedBagTest::injectIntoInt;
            this.payloads.injectIntoLong = UnmodifiableSortedBagTest::injectIntoLong;
            this.payloads.injectIntoDouble = UnmodifiableSortedBagTest::injectIntoDouble;
            this.payloads.injectIntoFloat = UnmodifiableSortedBagTest::injectIntoFloat;
            this.payloads.sumFloat = UnmodifiableSortedBagTest::sumFloat;
            this.payloads.sumDouble = UnmodifiableSortedBagTest::sumDouble;
            this.payloads.sumInteger = UnmodifiableSortedBagTest::sumInteger;
            this.payloads.sumLong = UnmodifiableSortedBagTest::sumLong;
            this.payloads.toArray = UnmodifiableSortedBagTest::toArray;
            this.payloads.chunk = UnmodifiableSortedBagTest::chunk;
            this.payloads.aggregateByMutating = UnmodifiableSortedBagTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = UnmodifiableSortedBagTest::aggregateByNonMutating;
            this.payloads.toSortedBag_natural_ordering = UnmodifiableSortedBagTest::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = UnmodifiableSortedBagTest::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = UnmodifiableSortedBagTest::toSortedBagBy;
            this.payloads.topOccurrences = UnmodifiableSortedBagTest::topOccurrences;
            this.payloads.bottomOccurrences = UnmodifiableSortedBagTest::bottomOccurrences;
            this.payloads.min_null_safe = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::min_null_safe, java.lang.NullPointerException.class);
            this.payloads.max_null_safe = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::max_null_safe, java.lang.NullPointerException.class);
            this.payloads.detectIndex = UnmodifiableSortedBagTest::detectIndex;
            this.payloads.take = UnmodifiableSortedBagTest::take;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = UnmodifiableSortedBagTest::drop;
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::drop_throws, java.lang.IllegalArgumentException.class);
            this.payloads.selectUnique = UnmodifiableSortedBagTest::selectUnique;
            this.payloads.distinctView = UnmodifiableSortedBagTest::distinctView;
            this.payloads.toString_with_collection_containing_self = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::toString_with_collection_containing_self, java.lang.UnsupportedOperationException.class);
            this.payloads.makeString_with_collection_containing_self = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::makeString_with_collection_containing_self, java.lang.UnsupportedOperationException.class);
            this.payloads.appendString_with_collection_containing_self = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::appendString_with_collection_containing_self, java.lang.UnsupportedOperationException.class);
            this.payloads.asSynchronized = UnmodifiableSortedBagTest::asSynchronized;
            this.payloads.asUnmodifiable = UnmodifiableSortedBagTest::asUnmodifiable;
            this.payloads.iterator = UnmodifiableSortedBagTest::iterator;
            this.payloads.iteratorRemove = UnmodifiableSortedBagTest::iteratorRemove;
            this.payloads.iteratorRemove2 = UnmodifiableSortedBagTest::iteratorRemove2;
            this.payloads.testAsUnmodifiable = UnmodifiableSortedBagTest::testAsUnmodifiable;
            this.payloads.removeIfWith = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::removeIfWith, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::removeIf, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::removeAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::retainAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addOccurrences = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::addOccurrences, java.lang.UnsupportedOperationException.class);
            this.payloads.addOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::addOccurrences_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.removeObject = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::removeObject, java.lang.UnsupportedOperationException.class);
            this.payloads.removeOccurrences = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::removeOccurrences, java.lang.UnsupportedOperationException.class);
            this.payloads.removeOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::removeOccurrences_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.setOccurrences = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::setOccurrences, java.lang.UnsupportedOperationException.class);
            this.payloads.setOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::setOccurrences_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.forEachWithOccurrences = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::forEachWithOccurrences, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableSortedBagTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.testClone = UnmodifiableSortedBagTest::testClone;
            this.payloads.collectWithOccurrences = UnmodifiableSortedBagTest::collectWithOccurrences;
        }
    }
}
