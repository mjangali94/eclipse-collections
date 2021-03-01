/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.immutable.primitive;

import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.api.list.primitive.ImmutableBooleanList;
import org.eclipse.collections.impl.block.factory.primitive.BooleanPredicates;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableBooleanEmptyListTest extends AbstractImmutableBooleanListTestCase {

    @Override
    protected ImmutableBooleanList classUnderTest() {
        return ImmutableBooleanEmptyList.INSTANCE;
    }

    @Override
    @Test
    public void newWithout() {
        ImmutableBooleanList emptyList = this.newWith();
        ImmutableBooleanList newList = emptyList.newWithout(true);
        Assert.assertEquals(this.newWith(), newList);
        Assert.assertSame(emptyList, newList);
        Assert.assertEquals(this.newMutableCollectionWith(), emptyList);
    }

    @Override
    @Test(expected = IndexOutOfBoundsException.class)
    public void get() {
        this.classUnderTest().get(0);
    }

    @Override
    @Test(expected = IndexOutOfBoundsException.class)
    public void getFirst() {
        this.classUnderTest().getFirst();
    }

    @Override
    @Test(expected = IndexOutOfBoundsException.class)
    public void getLast() {
        this.classUnderTest().getLast();
    }

    @Override
    @Test
    public void indexOf() {
        Assert.assertEquals(-1L, this.classUnderTest().indexOf(true));
        Assert.assertEquals(-1L, this.classUnderTest().indexOf(false));
    }

    @Override
    @Test
    public void lastIndexOf() {
        Assert.assertEquals(-1L, this.classUnderTest().lastIndexOf(true));
        Assert.assertEquals(-1L, this.classUnderTest().lastIndexOf(false));
    }

    @Override
    @Test
    public void forEachWithIndex() {
        String[] sum = new String[2];
        sum[0] = "";
        this.classUnderTest().forEachWithIndex((each, index) -> sum[0] += index + ":" + each);
        Assert.assertEquals("", sum[0]);
    }

    @Override
    @Test
    public void toReversed() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toReversed());
    }

    @Override
    @Test
    public void isEmpty() {
        Verify.assertEmpty(this.classUnderTest());
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertFalse(this.classUnderTest().notEmpty());
    }

    @Override
    @Test
    public void select() {
        super.select();
        BooleanIterable iterable = this.classUnderTest();
        Verify.assertEmpty(iterable.select(BooleanPredicates.isTrue()));
        BooleanIterable booleanIterable = iterable.select(BooleanPredicates.isFalse());
        Verify.assertEmpty(booleanIterable);
        Assert.assertSame(iterable, booleanIterable);
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        BooleanIterable iterable = this.classUnderTest();
        Verify.assertEmpty(iterable.reject(BooleanPredicates.isTrue()));
        BooleanIterable booleanIterable = iterable.reject(BooleanPredicates.isFalse());
        Verify.assertEmpty(booleanIterable);
        Assert.assertSame(iterable, booleanIterable);
    }

    @Override
    @Test
    public void testEquals() {
        Verify.assertEqualsAndHashCode(this.newMutableCollectionWith(), this.classUnderTest());
        Verify.assertPostSerializedIdentity(this.newWith());
        Assert.assertNotEquals(this.classUnderTest(), this.newWith(false, false, false, true));
        Assert.assertNotEquals(this.classUnderTest(), this.newWith(true));
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newWithout, this.description("newWithout"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::get, this.description("get"), java.lang.IndexOutOfBoundsException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::getFirst, this.description("getFirst"), java.lang.IndexOutOfBoundsException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::getLast, this.description("getLast"), java.lang.IndexOutOfBoundsException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::indexOf, this.description("indexOf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lastIndexOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::lastIndexOf, this.description("lastIndexOf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWithIndex, this.description("forEachWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversed() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toReversed, this.description("toReversed"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isEmpty, this.description("isEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::notEmpty, this.description("notEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::select, this.description("select"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reject, this.description("reject"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testEquals, this.description("testEquals"));
        }

        private ImmutableBooleanEmptyListTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableBooleanEmptyListTest();
        }

        @java.lang.Override
        public ImmutableBooleanEmptyListTest implementation() {
            return this.implementation;
        }
    }
}
