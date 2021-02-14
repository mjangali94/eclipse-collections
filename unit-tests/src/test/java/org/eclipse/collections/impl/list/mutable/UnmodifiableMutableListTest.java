/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.mutable;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.partition.list.PartitionMutableList;
import org.eclipse.collections.impl.Counter;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iList;

/**
 * JUnit test for {@link UnmodifiableMutableList}.
 */
public class UnmodifiableMutableListTest {

    private static final String LED_ZEPPELIN = "Led Zeppelin";

    private static final String METALLICA = "Metallica";

    private MutableList<String> mutableList;

    private MutableList<String> unmodifiableList;

    @Before
    public void setUp() {
        this.mutableList = Lists.mutable.of(METALLICA, "Bon Jovi", "Europe", "Scorpions");
        this.unmodifiableList = UnmodifiableMutableList.of(this.mutableList);
    }

    @Test
    public void equalsAndHashCode() {
        Verify.assertEqualsAndHashCode(this.mutableList, this.unmodifiableList);
        Verify.assertPostSerializedEqualsAndHashCode(this.unmodifiableList);
        Verify.assertInstanceOf(UnmodifiableMutableList.class, SerializeTestHelper.serializeDeserialize(this.unmodifiableList));
    }

    @Test
    public void delegatingMethods() {
        Verify.assertItemAtIndex("Europe", 2, this.unmodifiableList);
        Assert.assertEquals(2, this.unmodifiableList.indexOf("Europe"));
        Assert.assertEquals(0, this.unmodifiableList.lastIndexOf(METALLICA));
    }

    @Test
    public void forEachFromTo() {
        Counter counter = new Counter();
        this.unmodifiableList.forEach(1, 2, band -> counter.increment());
        Assert.assertEquals(2, counter.getCount());
    }

    @Test
    public void listIterator() {
        ListIterator<String> it = this.unmodifiableList.listIterator();
        Assert.assertFalse(it.hasPrevious());
        Assert.assertEquals(-1, it.previousIndex());
        Assert.assertEquals(METALLICA, it.next());
        Assert.assertTrue(it.hasNext());
        Assert.assertEquals(1, it.nextIndex());
        Assert.assertThrows(UnsupportedOperationException.class, () -> it.set("Rick Astley"));
        Assert.assertThrows(UnsupportedOperationException.class, it::remove);
        Assert.assertThrows(UnsupportedOperationException.class, () -> it.add("Gloria Gaynor"));
        Assert.assertEquals(METALLICA, it.previous());
    }

    @Test
    public void sortThis() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.unmodifiableList.sortThis());
    }

    @Test
    public void sortThisWithComparator() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.unmodifiableList.sortThis(String::compareTo));
    }

    @Test
    public void sortThisBy() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.unmodifiableList.sortThisBy(Functions.getStringToInteger()));
    }

    @Test
    public void sortThisByBoolean() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.unmodifiableList.sortThisByBoolean(null));
    }

    @Test
    public void sortThisByChar() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.unmodifiableList.sortThisByChar(null));
    }

    @Test
    public void sortThisByByte() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.unmodifiableList.sortThisByByte(null));
    }

    @Test
    public void sortThisByShort() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.unmodifiableList.sortThisByShort(null));
    }

    @Test
    public void sortThisByInt() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.unmodifiableList.sortThisByInt(null));
    }

    @Test
    public void sortThisByFloat() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.unmodifiableList.sortThisByFloat(null));
    }

    @Test
    public void sortThisByLong() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.unmodifiableList.sortThisByLong(null));
    }

    @Test
    public void sortThisByDouble() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.unmodifiableList.sortThisByDouble(null));
    }

    @Test
    public void shuffleThis() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.unmodifiableList.shuffleThis(null));
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.unmodifiableList.shuffleThis(new Random(4)));
    }

    @Test
    public void reverseThis() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.unmodifiableList.reverseThis());
    }

    @Test
    public void addAllAtIndex() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.unmodifiableList.addAll(0, Lists.mutable.of("Madonna")));
    }

    @Test
    public void set() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.unmodifiableList.set(0, "Madonna"));
    }

    @Test
    public void addAtIndex() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.unmodifiableList.add(0, "Madonna"));
    }

    @Test
    public void removeFromIndex() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.unmodifiableList.remove(0));
    }

    @Test
    public void replaceAll() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.unmodifiableList.replaceAll(e -> e));
    }

    @Test
    public void sort() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.unmodifiableList.sort(Comparator.naturalOrder()));
    }

    @Test
    public void subList() {
        MutableList<String> subList = this.unmodifiableList.subList(1, 3);
        Assert.assertEquals(Lists.immutable.of("Bon Jovi", "Europe"), subList);
        Assert.assertThrows(UnsupportedOperationException.class, subList::clear);
    }

    @Test
    public void newEmpty() {
        MutableList<String> list = this.unmodifiableList.newEmpty();
        list.add(LED_ZEPPELIN);
        Verify.assertContains(LED_ZEPPELIN, list);
    }

    @Test
    public void toImmutable() {
        Verify.assertInstanceOf(ImmutableList.class, this.unmodifiableList.toImmutable());
        Assert.assertEquals(this.unmodifiableList, this.unmodifiableList.toImmutable());
    }

    @Test
    public void asUnmodifiable() {
        Assert.assertSame(this.unmodifiableList, this.unmodifiableList.asUnmodifiable());
    }

    @Test
    public void asSynchronized() {
        MutableList<String> synchronizedList = this.unmodifiableList.asSynchronized();
        Verify.assertInstanceOf(SynchronizedMutableList.class, synchronizedList);
        Assert.assertThrows(UnsupportedOperationException.class, () -> {
            Iterator<String> iterator = synchronizedList.iterator();
            iterator.next();
            iterator.remove();
        });
    }

    @Test
    public void asReversed() {
        LazyIterable<String> lazyIterable = this.unmodifiableList.asReversed();
        Assert.assertThrows(UnsupportedOperationException.class, () -> {
            Iterator<String> iterator = lazyIterable.iterator();
            iterator.next();
            iterator.remove();
        });
    }

    @Test
    public void toReversed() {
        Assert.assertEquals(Lists.mutable.ofAll(this.unmodifiableList).toReversed(), this.unmodifiableList.toReversed());
    }

    @Test
    public void selectInstancesOf() {
        MutableList<Number> numbers = UnmodifiableMutableList.of(FastList.newListWith(1, 2.0, 3, 4.0, 5));
        Assert.assertEquals(iList(1, 3, 5), numbers.selectInstancesOf(Integer.class));
        Assert.assertEquals(iList(1, 2.0, 3, 4.0, 5), numbers.selectInstancesOf(Number.class));
    }

    @Test
    public void distinct() {
        MutableList<Integer> list = UnmodifiableMutableList.of(Lists.mutable.with(3, 1, 2, 2, 1, 3));
        Verify.assertListsEqual(FastList.newListWith(3, 1, 2), list.distinct());
    }

    @Test
    public void distinctWithHashingStrategy() {
        MutableList<String> letters = UnmodifiableMutableList.of(Lists.mutable.with("a", "A", "b", "C", "b", "D", "E", "e"));
        MutableList<String> expectedLetters = UnmodifiableMutableList.of(FastList.newListWith("a", "b", "C", "D", "E"));
        Verify.assertListsEqual(letters.distinct(HashingStrategies.fromFunction(String::toLowerCase)), expectedLetters);
    }

    /**
     * @since 9.0.
     */
    @Test
    public void distinctBy() {
        MutableList<String> letters = UnmodifiableMutableList.of(Lists.mutable.with("a", "A", "b", "C", "b", "D", "E", "e"));
        MutableList<String> expectedLetters = UnmodifiableMutableList.of(Lists.mutable.with("a", "b", "C", "D", "E"));
        Verify.assertListsEqual(letters.distinctBy(String::toLowerCase), expectedLetters);
    }

    @Test
    public void take() {
        UnmodifiableMutableList<Integer> unmodifiableList = UnmodifiableMutableList.of(FastList.newListWith(1, 2, 3, 4, 5));
        Assert.assertEquals(iList(), unmodifiableList.take(0));
        Assert.assertEquals(iList(1, 2, 3), unmodifiableList.take(3));
        Assert.assertEquals(iList(1, 2, 3, 4), unmodifiableList.take(unmodifiableList.size() - 1));
        Assert.assertEquals(iList(1, 2, 3, 4, 5), unmodifiableList.take(unmodifiableList.size()));
        Assert.assertEquals(iList(1, 2, 3, 4, 5), unmodifiableList.take(10));
        Assert.assertEquals(iList(1, 2, 3, 4, 5), unmodifiableList.take(Integer.MAX_VALUE));
        Assert.assertNotSame(unmodifiableList, unmodifiableList.take(Integer.MAX_VALUE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void take_throws() {
        UnmodifiableMutableList.of(FastList.newListWith(1, 2, 3, 4, 5)).take(-1);
    }

    @Test
    public void takeWhile() {
        Assert.assertEquals(iList(1, 2, 3), UnmodifiableMutableList.of(FastList.newListWith(1, 2, 3, 4, 5)).takeWhile(Predicates.lessThan(4)));
    }

    @Test
    public void drop() {
        UnmodifiableMutableList<Integer> unmodifiableList = UnmodifiableMutableList.of(FastList.newListWith(1, 2, 3, 4, 5));
        Assert.assertEquals(iList(1, 2, 3, 4, 5), unmodifiableList.drop(0));
        Assert.assertNotSame(unmodifiableList, unmodifiableList.drop(0));
        Assert.assertEquals(iList(4, 5), unmodifiableList.drop(3));
        Assert.assertEquals(iList(5), unmodifiableList.drop(unmodifiableList.size() - 1));
        Assert.assertEquals(iList(), unmodifiableList.drop(unmodifiableList.size()));
        Assert.assertEquals(iList(), unmodifiableList.drop(10));
        Assert.assertEquals(iList(), unmodifiableList.drop(Integer.MAX_VALUE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void drop_throws() {
        UnmodifiableMutableList.of(FastList.newListWith(1, 2, 3, 4, 5)).drop(-1);
    }

    @Test
    public void dropWhile() {
        Assert.assertEquals(iList(4, 5), UnmodifiableMutableList.of(FastList.newListWith(1, 2, 3, 4, 5)).dropWhile(Predicates.lessThan(4)));
    }

    @Test
    public void partitionWhile() {
        PartitionMutableList<Integer> partition = UnmodifiableMutableList.of(FastList.newListWith(1, 2, 3, 4, 5)).partitionWhile(Predicates.lessThan(4));
        MutableList<Integer> selected = partition.getSelected();
        MutableList<Integer> rejected = partition.getRejected();
        Assert.assertEquals(iList(1, 2, 3), selected);
        Assert.assertEquals(iList(4, 5), rejected);
    }

    @Test
    public void binarySearch() {
        UnmodifiableMutableList<Integer> sortedList = UnmodifiableMutableList.of(FastList.newListWith(1, 2, 3, 4, 5, 7));
        Assert.assertEquals(1, sortedList.binarySearch(2));
        Assert.assertEquals(-6, sortedList.binarySearch(6));
        for (Integer integer : sortedList) {
            Assert.assertEquals(Collections.binarySearch(sortedList, integer), sortedList.binarySearch(integer));
        }
    }

    @Test
    public void binarySearchWithComparator() {
        UnmodifiableMutableList<Integer> sortedList = UnmodifiableMutableList.of(FastList.newListWith(1, 2, 3, 4, 5, 7).toSortedList(Comparators.reverseNaturalOrder()));
        Assert.assertEquals(sortedList.size() - 1, sortedList.binarySearch(1, Comparators.reverseNaturalOrder()));
        Assert.assertEquals(-1 - sortedList.size(), sortedList.binarySearch(-1, Comparators.reverseNaturalOrder()));
        for (Integer integer : sortedList) {
            Assert.assertEquals(Collections.binarySearch(sortedList, integer, Comparators.reverseNaturalOrder()), sortedList.binarySearch(integer, Comparators.reverseNaturalOrder()));
        }
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::equalsAndHashCode, this.description("equalsAndHashCode"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_delegatingMethods() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::delegatingMethods, this.description("delegatingMethods"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachFromTo() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachFromTo, this.description("forEachFromTo"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::listIterator, this.description("listIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortThis, this.description("sortThis"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisWithComparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortThisWithComparator, this.description("sortThisWithComparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortThisBy, this.description("sortThisBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByBoolean() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortThisByBoolean, this.description("sortThisByBoolean"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByChar() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortThisByChar, this.description("sortThisByChar"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByByte() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortThisByByte, this.description("sortThisByByte"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByShort() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortThisByShort, this.description("sortThisByShort"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByInt() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortThisByInt, this.description("sortThisByInt"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByFloat() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortThisByFloat, this.description("sortThisByFloat"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByLong() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortThisByLong, this.description("sortThisByLong"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByDouble() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortThisByDouble, this.description("sortThisByDouble"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shuffleThis() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::shuffleThis, this.description("shuffleThis"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseThis() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reverseThis, this.description("reverseThis"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllAtIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addAllAtIndex, this.description("addAllAtIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_set() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::set, this.description("set"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addAtIndex, this.description("addAtIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeFromIndex, this.description("removeFromIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_replaceAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::replaceAll, this.description("replaceAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sort() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sort, this.description("sort"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::subList, this.description("subList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newEmpty, this.description("newEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutable, this.description("toImmutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asUnmodifiable, this.description("asUnmodifiable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asReversed() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asReversed, this.description("asReversed"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversed() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toReversed, this.description("toReversed"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectInstancesOf, this.description("selectInstancesOf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::distinct, this.description("distinct"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctWithHashingStrategy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::distinctWithHashingStrategy, this.description("distinctWithHashingStrategy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::distinctBy, this.description("distinctBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::take, this.description("take"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::take_throws, this.description("take_throws"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_takeWhile() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::takeWhile, this.description("takeWhile"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::drop, this.description("drop"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::drop_throws, this.description("drop_throws"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dropWhile() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::dropWhile, this.description("dropWhile"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWhile() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::partitionWhile, this.description("partitionWhile"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_binarySearch() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::binarySearch, this.description("binarySearch"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_binarySearchWithComparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::binarySearchWithComparator, this.description("binarySearchWithComparator"));
        }

        @java.lang.Override
        public void before() throws java.lang.Throwable {
            super.before();
            this.implementation().setUp();
        }

        private UnmodifiableMutableListTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new UnmodifiableMutableListTest();
        }

        @java.lang.Override
        public UnmodifiableMutableListTest implementation() {
            return this.implementation;
        }
    }
}
