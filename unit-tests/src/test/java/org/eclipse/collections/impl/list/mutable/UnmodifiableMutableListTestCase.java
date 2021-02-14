/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.mutable;

import java.util.ListIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.list.fixed.UnmodifiableMemoryEfficientListTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link UnmodifiableMutableList}.
 */
public abstract class UnmodifiableMutableListTestCase extends UnmodifiableMemoryEfficientListTestCase<Integer> {

    @Test
    public void testClone() {
        Assert.assertEquals(this.getCollection(), this.getCollection().clone());
        Assert.assertNotSame(this.getCollection(), this.getCollection().clone());
    }

    @Test
    public void serialization() {
        Verify.assertPostSerializedEqualsAndHashCode(this.getCollection());
    }

    @Override
    @Test
    public void subList() {
        super.subList();
        MutableList<Integer> subList = this.getCollection().subList(0, 1);
        Assert.assertThrows(UnsupportedOperationException.class, subList::clear);
        Assert.assertThrows(UnsupportedOperationException.class, () -> subList.set(0, null));
        Assert.assertThrows(UnsupportedOperationException.class, () -> subList.add(0, null));
        Assert.assertThrows(UnsupportedOperationException.class, () -> subList.add(null));
        Assert.assertThrows(UnsupportedOperationException.class, () -> subList.remove(0));
        Assert.assertThrows(UnsupportedOperationException.class, () -> subList.remove(null));
    }

    @Override
    @Test
    public void listIterator() {
        ListIterator<Integer> it = this.getCollection().listIterator();
        Assert.assertFalse(it.hasPrevious());
        Assert.assertEquals(-1, it.previousIndex());
        Assert.assertEquals(0, it.nextIndex());
        it.next();
        Assert.assertEquals(1, it.nextIndex());
        Assert.assertThrows(UnsupportedOperationException.class, () -> it.set(null));
        Assert.assertThrows(UnsupportedOperationException.class, it::remove);
        Assert.assertThrows(UnsupportedOperationException.class, () -> it.add(null));
    }

    @Test
    public void subListListIterator() {
        ListIterator<Integer> it = this.getCollection().subList(0, 1).listIterator();
        Assert.assertFalse(it.hasPrevious());
        Assert.assertEquals(-1, it.previousIndex());
        Assert.assertEquals(0, it.nextIndex());
        it.next();
        Assert.assertEquals(1, it.nextIndex());
        Assert.assertThrows(UnsupportedOperationException.class, () -> it.set(null));
        Assert.assertThrows(UnsupportedOperationException.class, it::remove);
        Assert.assertThrows(UnsupportedOperationException.class, () -> it.add(null));
    }

    @Test
    public void set() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().set(0, null));
    }

    @Override
    @Test
    public void addAtIndex() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().add(0, null));
    }

    @Override
    @Test
    public void addAllAtIndex() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().addAll(0, null));
    }

    @Test
    public void removeAtIndex() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().remove(0));
    }

    @Test
    public void setAtIndex() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().set(0, null));
    }

    @Test
    public void sortThis() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().sortThis());
    }

    @Test
    public void sortThisWithComparator() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().sortThis(Comparators.naturalOrder()));
    }

    @Test
    public void sortThisBy() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().sortThisBy(String::valueOf));
    }

    @Test
    public void sortThisByBoolean() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().sortThisByBoolean(null));
    }

    @Test
    public void sortThisByChar() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().sortThisByChar(null));
    }

    @Test
    public void sortThisByByte() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().sortThisByByte(null));
    }

    @Test
    public void sortThisByShort() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().sortThisByShort(null));
    }

    @Test
    public void sortThisByInt() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().sortThisByInt(null));
    }

    @Test
    public void sortThisByFloat() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().sortThisByFloat(null));
    }

    @Test
    public void sortThisByLong() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().sortThisByLong(null));
    }

    @Test
    public void sortThisByDouble() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().sortThisByDouble(null));
    }

    @Test
    public void reverseThis() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().reverseThis());
    }

    @Test
    public void testEquals() {
        Assert.assertEquals(this.getCollection(), this.getCollection());
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static abstract class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testClone, this.description("testClone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::serialization, this.description("serialization"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::subList, this.description("subList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::listIterator, this.description("listIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subListListIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::subListListIterator, this.description("subListListIterator"));
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
        public void benchmark_addAllAtIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addAllAtIndex, this.description("addAllAtIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAtIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeAtIndex, this.description("removeAtIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_setAtIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::setAtIndex, this.description("setAtIndex"));
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
        public void benchmark_reverseThis() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reverseThis, this.description("reverseThis"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testEquals, this.description("testEquals"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract UnmodifiableMutableListTestCase implementation();
    }
}
