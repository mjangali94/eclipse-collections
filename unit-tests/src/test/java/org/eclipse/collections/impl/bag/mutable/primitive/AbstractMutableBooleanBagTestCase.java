/*
 * Copyright (c) 2017 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.mutable.primitive;

import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bag.primitive.ImmutableBooleanBag;
import org.eclipse.collections.api.bag.primitive.MutableBooleanBag;
import org.eclipse.collections.api.block.function.primitive.BooleanToObjectFunction;
import org.eclipse.collections.api.collection.primitive.MutableBooleanCollection;
import org.eclipse.collections.api.list.primitive.MutableBooleanList;
import org.eclipse.collections.api.set.primitive.MutableBooleanSet;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableBooleanCollectionTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.BooleanBags;
import org.eclipse.collections.impl.factory.primitive.BooleanSets;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableBooleanBag}.
 */
public abstract class AbstractMutableBooleanBagTestCase extends AbstractMutableBooleanCollectionTestCase {

    @Override
    protected abstract MutableBooleanBag classUnderTest();

    @Override
    protected abstract MutableBooleanBag newWith(boolean... elements);

    @Override
    protected MutableBooleanBag newMutableCollectionWith(boolean... elements) {
        return BooleanHashBag.newBagWith(elements);
    }

    @Override
    protected MutableBag<Object> newObjectCollectionWith(Object... elements) {
        return HashBag.newBagWith(elements);
    }

    @Test
    public void sizeDistinct() {
        Assert.assertEquals(0L, this.newWith().sizeDistinct());
        Assert.assertEquals(1L, this.newWith(true).sizeDistinct());
        Assert.assertEquals(1L, this.newWith(true, true, true).sizeDistinct());
        Assert.assertEquals(2L, this.newWith(true, false, true, false, true).sizeDistinct());
    }

    @Override
    @Test
    public void addAllIterable() {
        super.addAllIterable();
        MutableBooleanBag bag = this.newWith();
        Assert.assertTrue(bag.addAll(BooleanArrayList.newListWith(true, false, true, false, true)));
        Assert.assertFalse(bag.addAll(new BooleanArrayList()));
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, true, false, true), bag);
        Assert.assertTrue(bag.addAll(BooleanHashBag.newBagWith(true, false, true, false, true)));
        Assert.assertEquals(BooleanHashBag.newBagWith(false, false, false, false, true, true, true, true, true, true), bag);
    }

    @Test
    public void addOccurrences() {
        MutableBooleanBag bag = this.newWith();
        bag.addOccurrences(false, 3);
        Assert.assertEquals(BooleanHashBag.newBagWith(false, false, false), bag);
        bag.addOccurrences(false, 2);
        Assert.assertEquals(BooleanHashBag.newBagWith(false, false, false, false, false), bag);
        bag.addOccurrences(false, 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(false, false, false, false, false), bag);
        bag.addOccurrences(true, 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(false, false, false, false, false), bag);
        bag.addOccurrences(true, 1);
        Assert.assertEquals(BooleanHashBag.newBagWith(false, false, false, false, false, true), bag);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addOccurrences_throws() {
        this.newWith().addOccurrences(true, -1);
    }

    @Test
    public void removeOccurrences() {
        MutableBooleanBag bag1 = this.newWith();
        Assert.assertFalse(bag1.removeOccurrences(true, 5));
        bag1.addOccurrences(true, 5);
        Assert.assertTrue(bag1.removeOccurrences(true, 2));
        Assert.assertEquals(BooleanHashBag.newBagWith(true, true, true), bag1);
        Assert.assertFalse(bag1.removeOccurrences(true, 0));
        Assert.assertEquals(BooleanHashBag.newBagWith(true, true, true), bag1);
        Assert.assertTrue(bag1.removeOccurrences(true, 5));
        Assert.assertEquals(new BooleanHashBag(), bag1);
        Assert.assertFalse(bag1.removeOccurrences(true, 5));
        Assert.assertEquals(new BooleanHashBag(), bag1);
        MutableBooleanBag bag2 = this.newWith();
        Assert.assertFalse(bag2.removeOccurrences(false, 5));
        bag2.addOccurrences(false, 5);
        Assert.assertTrue(bag2.removeOccurrences(false, 2));
        Assert.assertEquals(BooleanHashBag.newBagWith(false, false, false), bag2);
        Assert.assertFalse(bag2.removeOccurrences(false, 0));
        Assert.assertEquals(BooleanHashBag.newBagWith(false, false, false), bag2);
        Assert.assertTrue(bag2.removeOccurrences(false, 5));
        Assert.assertEquals(new BooleanHashBag(), bag2);
        Assert.assertFalse(bag2.removeOccurrences(false, 5));
        Assert.assertEquals(new BooleanHashBag(), bag2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeOccurrences_throws() {
        this.newWith().removeOccurrences(true, -1);
    }

    @Test
    public void forEachWithOccurrences() {
        StringBuilder stringBuilder = new StringBuilder();
        this.classUnderTest().forEachWithOccurrences((argument1, argument2) -> stringBuilder.append(argument1).append(argument2));
        String string = stringBuilder.toString();
        Assert.assertTrue("true2false1".equals(string) || "false1true2".equals(string));
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(3, this.classUnderTest());
    }

    @Override
    @Test
    public void anySatisfy() {
        super.anySatisfy();
        long[] count = { 0 };
        MutableBooleanBag bag = this.newWith(false, true, false);
        Assert.assertTrue(bag.anySatisfy(value -> {
            count[0]++;
            return value;
        }));
        Assert.assertEquals(2L, count[0]);
    }

    @Override
    @Test
    public void allSatisfy() {
        super.allSatisfy();
        int[] count = { 0 };
        MutableBooleanBag bag = this.newWith(false, true, false);
        Assert.assertFalse(bag.allSatisfy(value -> {
            count[0]++;
            return !value;
        }));
        Assert.assertEquals(2L, count[0]);
    }

    @Override
    @Test
    public void noneSatisfy() {
        super.noneSatisfy();
        MutableBooleanBag bag = this.newWith(false, true, false);
        Assert.assertFalse(bag.noneSatisfy(value -> value));
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        MutableBooleanBag bag = this.newWith(true, false, false, true, true, true);
        BooleanToObjectFunction<String> stringValueOf = parameter -> parameter ? "true" : "false";
        Assert.assertEquals(HashBag.newBagWith("true", "false", "false", "true", "true", "true"), bag.collect(stringValueOf));
        MutableBooleanBag bag1 = this.newWith(false, false);
        Assert.assertEquals(HashBag.newBagWith("false", "false"), bag1.collect(stringValueOf));
        MutableBooleanBag bag2 = this.newWith(true, true);
        Assert.assertEquals(HashBag.newBagWith("true", "true"), bag2.collect(stringValueOf));
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        MutableBooleanCollection collection1 = this.newWith(true, false, true, false);
        MutableBooleanCollection collection2 = this.newWith(true, false, false, true);
        MutableBooleanCollection collection3 = this.newWith(true, false);
        MutableBooleanCollection collection4 = this.newWith(true, true, false);
        Assert.assertEquals(collection1, collection2);
        Assert.assertNotEquals(collection3, collection4);
    }

    @Override
    @Test
    public void testHashCode() {
        super.testHashCode();
        MutableBooleanCollection collection1 = this.newWith(true, false, true, false);
        MutableBooleanCollection collection2 = this.newWith(true, false, false, true);
        MutableBooleanCollection collection3 = this.newWith(true, false);
        MutableBooleanCollection collection4 = this.newWith(true, true, false);
        Verify.assertEqualsAndHashCode(collection1, collection2);
        Assert.assertNotEquals(collection3.hashCode(), collection4.hashCode());
    }

    @Override
    @Test
    public void testToString() {
        super.testToString();
        Assert.assertEquals("[true, true, true]", BooleanHashBag.newBagWith(true, true, true).toString());
    }

    @Override
    @Test
    public void makeString() {
        super.makeString();
        Assert.assertEquals("true, true, true", BooleanHashBag.newBagWith(true, true, true).makeString());
    }

    @Override
    @Test
    public void appendString() {
        super.appendString();
        StringBuilder appendable1 = new StringBuilder();
        this.newWith(true, true, true).appendString(appendable1);
        Assert.assertEquals("true, true, true", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();
        MutableBooleanBag bag1 = this.newWith(false, false, true);
        bag1.appendString(appendable2);
        Assert.assertTrue(appendable2.toString(), "false, false, true".equals(appendable2.toString()) || "true, false, false".equals(appendable2.toString()) || "false, true, false".equals(appendable2.toString()));
    }

    @Override
    @Test
    public void toList() {
        super.toList();
        MutableBooleanList list = this.newWith(false, false, true).toList();
        Assert.assertTrue(list.equals(BooleanArrayList.newListWith(false, false, true)) || list.equals(BooleanArrayList.newListWith(true, false, false)) || list.equals(BooleanArrayList.newListWith(false, true, false)));
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Assert.assertNotSame(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableBooleanBag.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void topOccurrences() {
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWith().topOccurrences(-1));
        Assert.assertTrue(this.newWith().topOccurrences(1).isEmpty());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(true, 2)), this.newWith(true, true, false).topOccurrences(1));
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(false, 2)), this.newWith(false, true, false).topOccurrences(1));
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(true, 2), PrimitiveTuples.pair(false, 1)), this.newWith(true, true, false).topOccurrences(2));
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(true, 1), PrimitiveTuples.pair(false, 1)).toBag(), this.newWith(true, false).topOccurrences(1).toBag());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(false, 2), PrimitiveTuples.pair(true, 1)).toBag(), this.newWith(true, false, false).topOccurrences(2).toBag());
    }

    @Test
    public void bottomOccurrences() {
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWith().bottomOccurrences(-1));
        Assert.assertTrue(this.newWith().bottomOccurrences(1).isEmpty());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(false, 1)), this.newWith(true, true, false).bottomOccurrences(1));
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(true, 1)), this.newWith(false, true, false).bottomOccurrences(1));
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(true, 1), PrimitiveTuples.pair(false, 2)), this.newWith(false, true, false).bottomOccurrences(2));
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(true, 1), PrimitiveTuples.pair(false, 1)), this.newWith(true, false).bottomOccurrences(1));
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(false, 1), PrimitiveTuples.pair(true, 2)), this.newWith(true, true, false).bottomOccurrences(2));
    }

    @Test
    public void selectUnique() {
        MutableBooleanBag bag = BooleanBags.mutable.with(false, false, true);
        MutableBooleanSet expected = BooleanSets.mutable.with(true);
        MutableBooleanSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
        MutableBooleanBag bag2 = BooleanBags.mutable.with(false, false, true, true);
        MutableBooleanSet expected2 = BooleanSets.mutable.empty();
        MutableBooleanSet actual2 = bag2.selectUnique();
        Assert.assertEquals(expected2, actual2);
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static abstract class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sizeDistinct() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sizeDistinct, this.description("sizeDistinct"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addAllIterable, this.description("addAllIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addOccurrences, this.description("addOccurrences"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::addOccurrences_throws, this.description("addOccurrences_throws"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeOccurrences, this.description("removeOccurrences"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeOccurrences_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::removeOccurrences_throws, this.description("removeOccurrences_throws"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWithOccurrences, this.description("forEachWithOccurrences"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::size, this.description("size"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfy, this.description("anySatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfy, this.description("allSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::noneSatisfy, this.description("noneSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect, this.description("collect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testEquals, this.description("testEquals"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testHashCode, this.description("testHashCode"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testToString, this.description("testToString"));
        }

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
        public void benchmark_toList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toList, this.description("toList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutable, this.description("toImmutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_topOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::topOccurrences, this.description("topOccurrences"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_bottomOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::bottomOccurrences, this.description("bottomOccurrences"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectUnique, this.description("selectUnique"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractMutableBooleanBagTestCase implementation();
    }
}
