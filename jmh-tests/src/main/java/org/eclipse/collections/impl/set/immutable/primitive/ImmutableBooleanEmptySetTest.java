/*
 * Copyright (c) 2021 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.immutable.primitive;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.collection.primitive.ImmutableBooleanCollection;
import org.eclipse.collections.api.collection.primitive.MutableBooleanCollection;
import org.eclipse.collections.api.set.primitive.ImmutableBooleanSet;
import org.eclipse.collections.impl.block.factory.primitive.BooleanPredicates;
import org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableBooleanCollectionTestCase;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.primitive.BooleanBags;
import org.eclipse.collections.impl.factory.primitive.BooleanSets;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableBooleanEmptySet}.
 */
public class ImmutableBooleanEmptySetTest extends AbstractImmutableBooleanCollectionTestCase {

    @Override
    protected ImmutableBooleanCollection newWith(boolean... elements) {
        return BooleanSets.immutable.with(elements);
    }

    @Override
    protected MutableBooleanCollection newMutableCollectionWith(boolean... elements) {
        return BooleanSets.mutable.with(elements);
    }

    @Override
    protected RichIterable<Object> newObjectCollectionWith(Object... elements) {
        return Sets.immutable.with(elements);
    }

    @Override
    protected final ImmutableBooleanSet classUnderTest() {
        return BooleanSets.immutable.empty();
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertFalse(this.classUnderTest().notEmpty());
    }

    @Override
    @Test
    public void isEmpty() {
        Verify.assertEmpty(this.newWith());
    }

    @Override
    @Test
    public void size() {
        Verify.assertSize(0, this.classUnderTest());
    }

    @Override
    @Test
    public void testNewWith() {
        Assert.assertEquals(BooleanSets.immutable.with(true), this.classUnderTest().newWith(true));
    }

    @Override
    @Test
    public void newWithAll() {
        Assert.assertEquals(BooleanSets.immutable.with(true), this.classUnderTest().newWithAll(BooleanSets.mutable.with(true)));
    }

    @Override
    @Test
    public void testEquals() {
        Verify.assertEqualsAndHashCode(this.newMutableCollectionWith(), this.classUnderTest());
        Verify.assertPostSerializedIdentity(this.newWith());
        Assert.assertNotEquals(this.classUnderTest(), this.newWith(false, false, false, true));
        Assert.assertNotEquals(this.classUnderTest(), this.newWith(true));
    }

    @Override
    @Test
    public void forEach() {
        this.classUnderTest().forEach(each -> {
            throw new RuntimeException();
        });
    }

    @Override
    @Test
    public void newCollectionWith() {
    }

    @Override
    @Test
    public void newWithout() {
        Assert.assertEquals(BooleanSets.mutable.empty(), this.classUnderTest().newWithout(true));
    }

    @Override
    @Test
    public void injectInto() {
        this.classUnderTest().injectInto(null, (object, bool) -> {
            throw new RuntimeException();
        });
    }

    @Override
    @Test
    public void toBag() {
        Assert.assertEquals(BooleanBags.mutable.empty(), this.classUnderTest().toBag());
    }

    @Override
    @Test
    public void count() {
        Assert.assertEquals(0, this.classUnderTest().count(BooleanPredicates.alwaysTrue()));
        Assert.assertEquals(0, this.classUnderTest().count(BooleanPredicates.alwaysFalse()));
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void booleanIterator() {
        Assert.assertFalse(this.classUnderTest().booleanIterator().hasNext());
        this.classUnderTest().booleanIterator().next();
    }

    @Override
    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.classUnderTest().noneSatisfy(BooleanPredicates.alwaysTrue()));
        Assert.assertTrue(this.classUnderTest().noneSatisfy(BooleanPredicates.alwaysFalse()));
    }

    @Test
    public void cartesianProduct() {
        Assert.assertEquals(Sets.immutable.empty(), this.classUnderTest().cartesianProduct(BooleanSets.immutable.with(true)).toSet());
        Assert.assertEquals(Sets.immutable.empty(), this.classUnderTest().cartesianProduct(BooleanSets.immutable.with(false)).toSet());
        Assert.assertEquals(Sets.immutable.empty(), this.classUnderTest().cartesianProduct(BooleanSets.immutable.with(true, false)).toSet());
        Assert.assertEquals(Sets.immutable.empty(), this.classUnderTest().cartesianProduct(BooleanSets.immutable.empty()).toSet());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public ImmutableBooleanEmptySetTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_emptyList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOnEmptyThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOnEmptyThrows);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduce() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduce);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
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
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProduct);
        }

        public void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableBooleanEmptySetTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> iterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> iterator_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptySetTest> cartesianProduct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollection = ImmutableBooleanEmptySetTest::newCollection;
            this.payloads.contains = ImmutableBooleanEmptySetTest::contains;
            this.payloads.containsAllArray = ImmutableBooleanEmptySetTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableBooleanEmptySetTest::containsAllIterable;
            this.payloads.containsAnyArray = ImmutableBooleanEmptySetTest::containsAnyArray;
            this.payloads.containsAnyIterable = ImmutableBooleanEmptySetTest::containsAnyIterable;
            this.payloads.containsNoneArray = ImmutableBooleanEmptySetTest::containsNoneArray;
            this.payloads.containsNoneIterable = ImmutableBooleanEmptySetTest::containsNoneIterable;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBooleanEmptySetTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBooleanEmptySetTest::iterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBooleanEmptySetTest::iterator_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.anySatisfy = ImmutableBooleanEmptySetTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableBooleanEmptySetTest::allSatisfy;
            this.payloads.select = ImmutableBooleanEmptySetTest::select;
            this.payloads.reject = ImmutableBooleanEmptySetTest::reject;
            this.payloads.detectIfNone = ImmutableBooleanEmptySetTest::detectIfNone;
            this.payloads.collect = ImmutableBooleanEmptySetTest::collect;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBooleanEmptySetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ImmutableBooleanEmptySetTest::reduce;
            this.payloads.reduceIfEmpty = ImmutableBooleanEmptySetTest::reduceIfEmpty;
            this.payloads.toArray = ImmutableBooleanEmptySetTest::toArray;
            this.payloads.testHashCode = ImmutableBooleanEmptySetTest::testHashCode;
            this.payloads.testToString = ImmutableBooleanEmptySetTest::testToString;
            this.payloads.makeString = ImmutableBooleanEmptySetTest::makeString;
            this.payloads.appendString = ImmutableBooleanEmptySetTest::appendString;
            this.payloads.toList = ImmutableBooleanEmptySetTest::toList;
            this.payloads.toSet = ImmutableBooleanEmptySetTest::toSet;
            this.payloads.asLazy = ImmutableBooleanEmptySetTest::asLazy;
            this.payloads.newWithoutAll = ImmutableBooleanEmptySetTest::newWithoutAll;
            this.payloads.notEmpty = ImmutableBooleanEmptySetTest::notEmpty;
            this.payloads.isEmpty = ImmutableBooleanEmptySetTest::isEmpty;
            this.payloads.size = ImmutableBooleanEmptySetTest::size;
            this.payloads.testNewWith = ImmutableBooleanEmptySetTest::testNewWith;
            this.payloads.newWithAll = ImmutableBooleanEmptySetTest::newWithAll;
            this.payloads.testEquals = ImmutableBooleanEmptySetTest::testEquals;
            this.payloads.forEach = ImmutableBooleanEmptySetTest::forEach;
            this.payloads.newCollectionWith = ImmutableBooleanEmptySetTest::newCollectionWith;
            this.payloads.newWithout = ImmutableBooleanEmptySetTest::newWithout;
            this.payloads.injectInto = ImmutableBooleanEmptySetTest::injectInto;
            this.payloads.toBag = ImmutableBooleanEmptySetTest::toBag;
            this.payloads.count = ImmutableBooleanEmptySetTest::count;
            this.payloads.booleanIterator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBooleanEmptySetTest::booleanIterator, java.util.NoSuchElementException.class);
            this.payloads.noneSatisfy = ImmutableBooleanEmptySetTest::noneSatisfy;
            this.payloads.cartesianProduct = ImmutableBooleanEmptySetTest::cartesianProduct;
        }
    }
}
