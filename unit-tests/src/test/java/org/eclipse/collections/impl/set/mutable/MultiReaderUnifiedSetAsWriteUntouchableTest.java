/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.mutable;

import java.util.Collections;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.bag.sorted.mutable.TreeBag;
import org.eclipse.collections.impl.collection.mutable.AbstractCollectionTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class MultiReaderUnifiedSetAsWriteUntouchableTest extends AbstractCollectionTestCase {

    @Override
    protected <T> MutableSet<T> newWith(T... littleElements) {
        return MultiReaderUnifiedSet.newSetWith(littleElements).asWriteUntouchable();
    }

    @Override
    public void getLast() {
        Assert.assertNotNull(this.newWith(1, 2, 3).getLast());
        Assert.assertNull(this.newWith().getLast());
    }

    @Override
    @Test
    public void makeString() {
        Assert.assertEquals("1, 2, 3", this.newWith(1, 2, 3).makeString());
    }

    @Override
    @Test
    public void appendString() {
        Appendable builder = new StringBuilder();
        this.newWith(1, 2, 3).appendString(builder);
        Assert.assertEquals("1, 2, 3", builder.toString());
    }

    @Override
    @Test
    public void testToString() {
        Assert.assertEquals("[1, 2, 3]", this.newWith(1, 2, 3).toString());
    }

    @Override
    @Test
    public void asSynchronized() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newWith().asSynchronized());
    }

    @Override
    @Test
    public void asUnmodifiable() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newWith().asUnmodifiable());
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
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::makeString, this.description("makeString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::appendString, this.description("appendString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testToString, this.description("testToString"));
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
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedBag_natural_ordering, this.description("toSortedBag_natural_ordering"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedBag_with_comparator, this.description("toSortedBag_with_comparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_null() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::toSortedBag_with_null, this.description("toSortedBag_with_null"), java.lang.NullPointerException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedBagBy, this.description("toSortedBagBy"));
        }

        private MultiReaderUnifiedSetAsWriteUntouchableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MultiReaderUnifiedSetAsWriteUntouchableTest();
        }

        @java.lang.Override
        public MultiReaderUnifiedSetAsWriteUntouchableTest implementation() {
            return this.implementation;
        }
    }
}
