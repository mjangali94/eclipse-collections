/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.fixed;

import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.PrimitiveFunctions;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class EmptyListTest {

    @Test
    public void size() {
        Verify.assertSize(0, new EmptyList<>());
    }

    @Test
    public void contains() {
        Assert.assertFalse(new EmptyList<>().contains(null));
        Assert.assertFalse(new EmptyList<>().contains(new Object()));
    }

    @Test
    public void get() {
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> new EmptyList<>().get(0));
    }

    @Test
    public void set() {
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> new EmptyList<>().set(0, null));
    }

    @Test
    public void empty() {
        Verify.assertEmpty(new EmptyList<>());
        Assert.assertFalse(new EmptyList<>().notEmpty());
        Verify.assertEmpty(Lists.fixedSize.of());
        Assert.assertFalse(Lists.fixedSize.of().notEmpty());
    }

    @Test
    public void getFirstLast() {
        Assert.assertNull(new EmptyList<>().getFirst());
        Assert.assertNull(new EmptyList<>().getLast());
    }

    @Test
    public void getOnly() {
        Assert.assertThrows(IllegalStateException.class, () -> new EmptyList<>().getOnly());
    }

    @Test
    public void readResolve() {
        Verify.assertInstanceOf(EmptyList.class, Lists.fixedSize.of());
        Verify.assertPostSerializedIdentity(Lists.fixedSize.of());
    }

    @Test
    public void testClone() {
        Assert.assertSame(Lists.fixedSize.of().clone(), Lists.fixedSize.of());
    }

    @Test
    public void min() {
        Assert.assertThrows(NoSuchElementException.class, () -> Lists.fixedSize.of().min(Comparators.naturalOrder()));
    }

    @Test
    public void max() {
        Assert.assertThrows(NoSuchElementException.class, () -> Lists.fixedSize.of().max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator() {
        Assert.assertThrows(NoSuchElementException.class, () -> Lists.fixedSize.of().min());
    }

    @Test
    public void max_without_comparator() {
        Assert.assertThrows(NoSuchElementException.class, () -> Lists.fixedSize.of().max());
    }

    @Test
    public void minBy() {
        Assert.assertThrows(NoSuchElementException.class, () -> Lists.fixedSize.of().minBy(String::valueOf));
    }

    @Test
    public void maxBy() {
        Assert.assertThrows(NoSuchElementException.class, () -> Lists.fixedSize.of().maxBy(String::valueOf));
    }

    @Test
    public void zip() {
        Assert.assertEquals(Lists.fixedSize.of(), Lists.fixedSize.of().zip(FastList.newListWith(1, 2, 3)));
    }

    @Test
    public void zipWithIndex() {
        Assert.assertEquals(Lists.fixedSize.of(), Lists.fixedSize.of().zipWithIndex());
    }

    @Test
    public void chunk_large_size() {
        Assert.assertEquals(Lists.fixedSize.of(), Lists.fixedSize.of().chunk(10));
    }

    @Test
    public void sortThis() {
        MutableList<Object> expected = Lists.fixedSize.of();
        MutableList<Object> list = Lists.fixedSize.of();
        MutableList<Object> sortedList = list.sortThis();
        Assert.assertEquals(expected, sortedList);
        Assert.assertSame(sortedList, list);
    }

    @Test
    public void sortThisBy() {
        MutableList<Object> expected = Lists.fixedSize.of();
        MutableList<Object> list = Lists.fixedSize.of();
        MutableList<Object> sortedList = list.sortThisBy(String::valueOf);
        Assert.assertEquals(expected, sortedList);
        Assert.assertSame(sortedList, list);
    }

    @Test
    public void sortThisByPrimitive() {
        MutableList<Object> expected = Lists.fixedSize.of();
        MutableList<Object> list = Lists.fixedSize.of();
        Assert.assertEquals(expected, list.sortThisByBoolean(anObject -> true));
        Assert.assertSame(list, list.sortThisByBoolean(anObject -> true));
        Assert.assertEquals(expected, list.sortThisByByte(anObject -> (byte) 0));
        Assert.assertSame(list, list.sortThisByByte(anObject -> (byte) 0));
        Assert.assertEquals(expected, list.sortThisByChar(anObject -> (char) 0));
        Assert.assertSame(list, list.sortThisByChar(anObject -> (char) 0));
        Assert.assertEquals(expected, list.sortThisByDouble(anObject -> 0.0));
        Assert.assertSame(list, list.sortThisByDouble(anObject -> 0.0));
        Assert.assertEquals(expected, list.sortThisByFloat(anObject -> 0.0f));
        Assert.assertSame(list, list.sortThisByFloat(anObject -> 0.0f));
        Assert.assertEquals(expected, list.sortThisByInt(anObject -> 0));
        Assert.assertSame(list, list.sortThisByInt(anObject -> 0));
        Assert.assertEquals(expected, list.sortThisByLong(anObject -> 0L));
        Assert.assertSame(list, list.sortThisByLong(anObject -> 0L));
        Assert.assertEquals(expected, list.sortThisByShort(anObject -> (short) 0));
        Assert.assertSame(list, list.sortThisByShort(anObject -> (short) 0));
    }

    @Test
    public void with() {
        MutableList<Integer> list = new EmptyList<Integer>().with(1);
        Verify.assertListsEqual(FastList.newListWith(1), list);
        Verify.assertInstanceOf(SingletonList.class, list);
    }

    @Test
    public void withAll() {
        MutableList<Integer> list = new EmptyList<Integer>().withAll(FastList.newListWith(1, 2));
        Verify.assertListsEqual(FastList.newListWith(1, 2), list);
        Verify.assertInstanceOf(DoubletonList.class, list);
    }

    @Test
    public void without() {
        MutableList<Integer> list = new EmptyList<>();
        Assert.assertSame(list, list.without(2));
    }

    @Test
    public void withoutAll() {
        MutableList<Integer> list = new EmptyList<>();
        Assert.assertEquals(list, list.withoutAll(FastList.newListWith(1, 2)));
    }

    @Test
    public void collectPrimitives() {
        MutableList<Integer> list = new EmptyList<>();
        Verify.assertEmpty(list.collectBoolean(PrimitiveFunctions.integerIsPositive()));
        Verify.assertEmpty(list.collectByte(PrimitiveFunctions.unboxIntegerToByte()));
        Verify.assertEmpty(list.collectChar(PrimitiveFunctions.unboxIntegerToChar()));
        Verify.assertEmpty(list.collectDouble(PrimitiveFunctions.unboxIntegerToDouble()));
        Verify.assertEmpty(list.collectFloat(PrimitiveFunctions.unboxIntegerToFloat()));
        Verify.assertEmpty(list.collectInt(PrimitiveFunctions.unboxIntegerToInt()));
        Verify.assertEmpty(list.collectLong(PrimitiveFunctions.unboxIntegerToLong()));
        Verify.assertEmpty(list.collectShort(PrimitiveFunctions.unboxIntegerToShort()));
    }

    @Test
    public void replaceAll() {
        MutableList<String> emptyStrings = new EmptyList<>();
        emptyStrings.replaceAll(s -> "1");
        Verify.assertEmpty(emptyStrings);
    }

    @Test
    public void sort() {
        MutableList<String> emptyStrings = new EmptyList<>();
        emptyStrings.sort(Comparator.naturalOrder());
        Verify.assertEmpty(emptyStrings);
    }

    @Test
    public void each() {
        AtomicInteger integer = new AtomicInteger();
        new EmptyList<>().each(each -> integer.incrementAndGet());
        Assert.assertEquals(0, integer.get());
    }

    @Test
    public void forEachWith() {
        AtomicInteger integer = new AtomicInteger();
        new EmptyList<>().forEachWith((argument1, argument2) -> integer.incrementAndGet(), null);
        Assert.assertEquals(0, integer.get());
    }

    @Test
    public void iterator() {
        Iterator<Object> iterator = new EmptyList<>().iterator();
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void listIterator() {
        ListIterator<Object> iterator = new EmptyList<>().listIterator();
        Assert.assertFalse(iterator.hasNext());
        Assert.assertFalse(iterator.hasPrevious());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
        Assert.assertThrows(NoSuchElementException.class, iterator::previous);
    }

    @Test
    public void listIteratorWithIndex() {
        ListIterator<Object> iterator = new EmptyList<>().listIterator(0);
        Assert.assertFalse(iterator.hasNext());
        Assert.assertFalse(iterator.hasPrevious());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
        Assert.assertThrows(NoSuchElementException.class, iterator::previous);
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> new EmptyList<>().listIterator(1));
    }

    @Test
    public void toImmutable() {
        Assert.assertSame(Lists.immutable.empty(), new EmptyList<>().toImmutable());
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::size, this.description("size"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::contains, this.description("contains"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::get, this.description("get"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_set() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::set, this.description("set"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::empty, this.description("empty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirstLast() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getFirstLast, this.description("getFirstLast"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getOnly, this.description("getOnly"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_readResolve() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::readResolve, this.description("readResolve"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testClone, this.description("testClone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::min, this.description("min"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::max, this.description("max"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::min_without_comparator, this.description("min_without_comparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::max_without_comparator, this.description("max_without_comparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::minBy, this.description("minBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::maxBy, this.description("maxBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zip, this.description("zip"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zipWithIndex, this.description("zipWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::chunk_large_size, this.description("chunk_large_size"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortThis, this.description("sortThis"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortThisBy, this.description("sortThisBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByPrimitive() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortThisByPrimitive, this.description("sortThisByPrimitive"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::with, this.description("with"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withAll, this.description("withAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::without, this.description("without"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withoutAll, this.description("withoutAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitives() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectPrimitives, this.description("collectPrimitives"));
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
        public void benchmark_each() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::each, this.description("each"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWith, this.description("forEachWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator, this.description("iterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::listIterator, this.description("listIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIteratorWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::listIteratorWithIndex, this.description("listIteratorWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutable, this.description("toImmutable"));
        }

        private EmptyListTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new EmptyListTest();
        }

        @java.lang.Override
        public EmptyListTest implementation() {
            return this.implementation;
        }
    }
}
