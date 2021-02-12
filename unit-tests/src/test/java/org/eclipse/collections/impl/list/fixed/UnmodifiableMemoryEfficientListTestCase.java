/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.fixed;

import java.util.ListIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.collection.mutable.UnmodifiableMutableCollectionTestCase;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test to check that {@link AbstractMemoryEfficientMutableList}s are Unmodifiable.
 */
public abstract class UnmodifiableMemoryEfficientListTestCase<T> extends UnmodifiableMutableCollectionTestCase<T> {

    @Override
    protected abstract MutableList<T> getCollection();

    @Test
    public void listIterator() {
        MutableList<T> collection = this.getCollection();
        ListIterator<T> it = collection.listIterator();
        Assert.assertFalse(it.hasPrevious());
        Assert.assertEquals(-1, it.previousIndex());
        Assert.assertEquals(0, it.nextIndex());
        it.next();
        Assert.assertEquals(1, it.nextIndex());
        Assert.assertThrows(UnsupportedOperationException.class, it::remove);
        Assert.assertThrows(UnsupportedOperationException.class, () -> it.add(null));
        it.set(null);
        Assert.assertNotEquals(this.getCollection(), collection);
    }

    @Test
    public void addAllAtIndex() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().addAll(0, FastList.<T>newList().with((T) null)));
    }

    @Test
    public void addAtIndex() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().add(0, null));
    }

    @Test
    public void removeFromIndex() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().remove(0));
    }

    @Test
    public void subList() {
        MutableList<T> subList = this.getCollection().subList(0, 1);
        Assert.assertThrows(UnsupportedOperationException.class, subList::clear);
    }

    @Override
    @Test
    public void newEmpty() {
        MutableList<T> list = this.getCollection().newEmpty();
        list.add(null);
        Verify.assertContains(null, list);
    }

    @Test
    public void corresponds() {
        MutableList<T> mutableList1 = this.getCollection();
        MutableList<Integer> mutableList2 = mutableList1.collect(element -> Integer.valueOf(element.toString()) + 1);
        Assert.assertTrue(mutableList1.corresponds(mutableList2, (argument1, argument2) -> Integer.valueOf(argument1.toString()) < argument2));
        Assert.assertFalse(mutableList1.corresponds(mutableList2, (argument1, argument2) -> Integer.valueOf(argument1.toString()) > argument2));
        MutableList<Integer> mutableList3 = this.getCollection().collect(element -> Integer.valueOf(element.toString()));
        mutableList3.add(0);
        Assert.assertFalse(mutableList1.corresponds(mutableList3, Predicates2.alwaysTrue()));
    }

    @Test
    public void detectIndex() {
        MutableList<T> mutableList = this.getCollection();
        Assert.assertEquals(0, mutableList.detectIndex(element -> Integer.valueOf(element.toString()) == 1));
        Assert.assertEquals(-1, mutableList.detectIndex(element -> Integer.valueOf(element.toString()) == 0));
    }

    @Test
    public void detectLastIndex() {
        MutableList<T> mutableList = this.getCollection();
        Assert.assertEquals(0, mutableList.detectLastIndex(element -> Integer.valueOf(element.toString()) == 1));
        Assert.assertEquals(-1, mutableList.detectLastIndex(element -> Integer.valueOf(element.toString()) == 0));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::listIterator, this.description("listIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllAtIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addAllAtIndex, this.description("addAllAtIndex"));
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
        public void benchmark_corresponds() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::corresponds, this.description("corresponds"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectIndex, this.description("detectIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectLastIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectLastIndex, this.description("detectLastIndex"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract UnmodifiableMemoryEfficientListTestCase implementation();
    }
}
