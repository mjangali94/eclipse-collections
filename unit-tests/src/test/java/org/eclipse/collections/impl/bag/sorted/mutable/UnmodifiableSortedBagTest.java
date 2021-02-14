/*
 * Copyright (c) 2018 Goldman Sachs.
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
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toString_with_collection_containing_self() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::toString_with_collection_containing_self, this.description("toString_with_collection_containing_self"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString_with_collection_containing_self() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::makeString_with_collection_containing_self, this.description("makeString_with_collection_containing_self"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString_with_collection_containing_self() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::appendString_with_collection_containing_self, this.description("appendString_with_collection_containing_self"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asUnmodifiable, this.description("asUnmodifiable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator, this.description("iterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorRemove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iteratorRemove, this.description("iteratorRemove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorRemove2() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iteratorRemove2, this.description("iteratorRemove2"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAsUnmodifiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testAsUnmodifiable, this.description("testAsUnmodifiable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIfWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::removeIfWith, this.description("removeIfWith"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::clear, this.description("clear"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::addAll, this.description("addAll"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::addAllIterable, this.description("addAllIterable"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::removeIf, this.description("removeIf"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::removeAll, this.description("removeAll"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::removeAllIterable, this.description("removeAllIterable"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::retainAll, this.description("retainAll"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::retainAllIterable, this.description("retainAllIterable"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::add, this.description("add"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::addOccurrences, this.description("addOccurrences"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::addOccurrences_throws, this.description("addOccurrences_throws"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::removeObject, this.description("removeObject"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::removeOccurrences, this.description("removeOccurrences"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeOccurrences_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::removeOccurrences_throws, this.description("removeOccurrences_throws"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_setOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::setOccurrences, this.description("setOccurrences"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_setOccurrences_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::setOccurrences_throws, this.description("setOccurrences_throws"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::forEachWithOccurrences, this.description("forEachWithOccurrences"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::with, this.description("with"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::withAll, this.description("withAll"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::without, this.description("without"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::withoutAll, this.description("withoutAll"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testClone, this.description("testClone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectWithOccurrences, this.description("collectWithOccurrences"));
        }

        private UnmodifiableSortedBagTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new UnmodifiableSortedBagTest();
        }

        @java.lang.Override
        public UnmodifiableSortedBagTest implementation() {
            return this.implementation;
        }
    }
}
