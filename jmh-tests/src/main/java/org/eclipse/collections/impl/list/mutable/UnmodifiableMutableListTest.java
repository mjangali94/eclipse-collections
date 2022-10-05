/*
 * Copyright (c) 2021 Goldman Sachs and others.
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
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableMutableListTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_delegatingMethods() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.delegatingMethods);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachFromTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.listIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shuffleThis() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shuffleThis);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseThis() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseThis);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_set() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.set);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_replaceAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.replaceAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
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
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asReversed);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toReversed);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctWithHashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctWithHashingStrategy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctBy);
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
        public void benchmark_takeWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.takeWhile);
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
        public void benchmark_dropWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dropWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_binarySearch() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.binarySearch);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_binarySearchWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.binarySearchWithComparator);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableMutableListTest();
            this.instance.setUp();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> delegatingMethods;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> listIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> sortThisWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> sortThisBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> sortThisByBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> sortThisByChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> sortThisByByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> sortThisByShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> sortThisByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> sortThisByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> sortThisByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> sortThisByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> shuffleThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> removeFromIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> replaceAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> sort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> asReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> distinctWithHashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> distinctBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> binarySearch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTest> binarySearchWithComparator;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.equalsAndHashCode = UnmodifiableMutableListTest::equalsAndHashCode;
            this.payloads.delegatingMethods = UnmodifiableMutableListTest::delegatingMethods;
            this.payloads.forEachFromTo = UnmodifiableMutableListTest::forEachFromTo;
            this.payloads.listIterator = UnmodifiableMutableListTest::listIterator;
            this.payloads.sortThis = UnmodifiableMutableListTest::sortThis;
            this.payloads.sortThisWithComparator = UnmodifiableMutableListTest::sortThisWithComparator;
            this.payloads.sortThisBy = UnmodifiableMutableListTest::sortThisBy;
            this.payloads.sortThisByBoolean = UnmodifiableMutableListTest::sortThisByBoolean;
            this.payloads.sortThisByChar = UnmodifiableMutableListTest::sortThisByChar;
            this.payloads.sortThisByByte = UnmodifiableMutableListTest::sortThisByByte;
            this.payloads.sortThisByShort = UnmodifiableMutableListTest::sortThisByShort;
            this.payloads.sortThisByInt = UnmodifiableMutableListTest::sortThisByInt;
            this.payloads.sortThisByFloat = UnmodifiableMutableListTest::sortThisByFloat;
            this.payloads.sortThisByLong = UnmodifiableMutableListTest::sortThisByLong;
            this.payloads.sortThisByDouble = UnmodifiableMutableListTest::sortThisByDouble;
            this.payloads.shuffleThis = UnmodifiableMutableListTest::shuffleThis;
            this.payloads.reverseThis = UnmodifiableMutableListTest::reverseThis;
            this.payloads.addAllAtIndex = UnmodifiableMutableListTest::addAllAtIndex;
            this.payloads.set = UnmodifiableMutableListTest::set;
            this.payloads.addAtIndex = UnmodifiableMutableListTest::addAtIndex;
            this.payloads.removeFromIndex = UnmodifiableMutableListTest::removeFromIndex;
            this.payloads.replaceAll = UnmodifiableMutableListTest::replaceAll;
            this.payloads.sort = UnmodifiableMutableListTest::sort;
            this.payloads.subList = UnmodifiableMutableListTest::subList;
            this.payloads.newEmpty = UnmodifiableMutableListTest::newEmpty;
            this.payloads.toImmutable = UnmodifiableMutableListTest::toImmutable;
            this.payloads.asUnmodifiable = UnmodifiableMutableListTest::asUnmodifiable;
            this.payloads.asSynchronized = UnmodifiableMutableListTest::asSynchronized;
            this.payloads.asReversed = UnmodifiableMutableListTest::asReversed;
            this.payloads.toReversed = UnmodifiableMutableListTest::toReversed;
            this.payloads.selectInstancesOf = UnmodifiableMutableListTest::selectInstancesOf;
            this.payloads.distinct = UnmodifiableMutableListTest::distinct;
            this.payloads.distinctWithHashingStrategy = UnmodifiableMutableListTest::distinctWithHashingStrategy;
            this.payloads.distinctBy = UnmodifiableMutableListTest::distinctBy;
            this.payloads.take = UnmodifiableMutableListTest::take;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableListTest::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = UnmodifiableMutableListTest::takeWhile;
            this.payloads.drop = UnmodifiableMutableListTest::drop;
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableListTest::drop_throws, java.lang.IllegalArgumentException.class);
            this.payloads.dropWhile = UnmodifiableMutableListTest::dropWhile;
            this.payloads.partitionWhile = UnmodifiableMutableListTest::partitionWhile;
            this.payloads.binarySearch = UnmodifiableMutableListTest::binarySearch;
            this.payloads.binarySearchWithComparator = UnmodifiableMutableListTest::binarySearchWithComparator;
        }
    }
}
