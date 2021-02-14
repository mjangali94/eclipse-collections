/*
 * Copyright (c) 2015 Goldman Sachs.
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
import org.junit.Test;

public class MultiReaderFastListAsUnmodifiableTest extends UnmodifiableMutableListTestCase {

    @Override
    protected MutableList<Integer> getCollection() {
        return MultiReaderFastList.newListWith(1).asUnmodifiable();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void listIterator() {
        ListIterator<Integer> it = this.getCollection().listIterator();
        it.next();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void subListListIterator() {
        ListIterator<Integer> it = this.getCollection().subList(0, 1).listIterator();
        it.next();
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::listIterator, this.description("listIterator"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subListListIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::subListListIterator, this.description("subListListIterator"), java.lang.UnsupportedOperationException.class);
        }

        private MultiReaderFastListAsUnmodifiableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MultiReaderFastListAsUnmodifiableTest();
        }

        @java.lang.Override
        public MultiReaderFastListAsUnmodifiableTest implementation() {
            return this.implementation;
        }
    }
}
