/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.immutable.primitive;

import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bag.primitive.ImmutableBooleanBag;
import org.eclipse.collections.api.bag.primitive.MutableBooleanBag;
import org.eclipse.collections.api.block.function.primitive.BooleanToObjectFunction;
import org.eclipse.collections.api.collection.primitive.ImmutableBooleanCollection;
import org.eclipse.collections.api.iterator.BooleanIterator;
import org.eclipse.collections.api.list.primitive.MutableBooleanList;
import org.eclipse.collections.api.set.primitive.ImmutableBooleanSet;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.BooleanHashBag;
import org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableBooleanCollectionTestCase;
import org.eclipse.collections.impl.factory.primitive.BooleanBags;
import org.eclipse.collections.impl.factory.primitive.BooleanSets;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableBooleanBag}.
 */
public abstract class AbstractImmutableBooleanBagTestCase extends AbstractImmutableBooleanCollectionTestCase {

    @Override
    protected abstract ImmutableBooleanBag classUnderTest();

    @Override
    protected ImmutableBooleanBag newWith(boolean... elements) {
        return BooleanBags.immutable.with(elements);
    }

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
    public void booleanIterator() {
        BooleanHashBag bag = BooleanHashBag.newBagWith();
        BooleanIterator iterator = this.classUnderTest().booleanIterator();
        for (int i = 0; i < this.classUnderTest().size(); i++) {
            Assert.assertTrue(iterator.hasNext());
            bag.add(iterator.next());
        }
        Assert.assertEquals(bag, this.classUnderTest());
        Assert.assertFalse(iterator.hasNext());
    }

    @Override
    @Test
    public void anySatisfy() {
        super.anySatisfy();
        long[] count = { 0 };
        ImmutableBooleanBag bag = this.newWith(false, true, false);
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
        ImmutableBooleanBag bag = this.newWith(false, true, false);
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
        ImmutableBooleanBag bag = this.newWith(false, true, false);
        Assert.assertFalse(bag.noneSatisfy(value -> value));
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        ImmutableBooleanBag bag = this.newWith(true, false, false, true, true, true);
        BooleanToObjectFunction<String> stringValueOf = parameter -> parameter ? "true" : "false";
        Assert.assertEquals(HashBag.newBagWith("true", "false", "false", "true", "true", "true"), bag.collect(stringValueOf));
        ImmutableBooleanBag bag1 = this.newWith(false, false);
        Assert.assertEquals(HashBag.newBagWith("false", "false"), bag1.collect(stringValueOf));
        ImmutableBooleanBag bag2 = this.newWith(true, true);
        Assert.assertEquals(HashBag.newBagWith("true", "true"), bag2.collect(stringValueOf));
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        ImmutableBooleanCollection collection1 = this.newWith(true, false, true, false);
        ImmutableBooleanCollection collection2 = this.newWith(true, false, false, true);
        ImmutableBooleanCollection collection3 = this.newWith(true, false);
        ImmutableBooleanCollection collection4 = this.newWith(true, true, false);
        Assert.assertEquals(collection1, collection2);
        Verify.assertPostSerializedIdentity(this.newWith());
        Assert.assertNotEquals(collection3, collection4);
        Assert.assertNotEquals(collection3, BooleanArrayList.newListWith(true, false));
        Assert.assertNotEquals(this.newWith(true), BooleanArrayList.newListWith(true));
        Assert.assertNotEquals(this.newWith(), BooleanArrayList.newListWith());
    }

    @Override
    @Test
    public void testHashCode() {
        super.testHashCode();
        ImmutableBooleanCollection collection1 = this.newWith(true, false, true, false);
        ImmutableBooleanCollection collection2 = this.newWith(true, false, false, true);
        ImmutableBooleanCollection collection3 = this.newWith(true, false);
        ImmutableBooleanCollection collection4 = this.newWith(true, true, false);
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
        ImmutableBooleanBag bag1 = this.newWith(false, false, true);
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
        ImmutableBooleanBag expected = this.classUnderTest();
        Assert.assertSame(expected, expected.toImmutable());
    }

    @Test
    public void selectUnique() {
        ImmutableBooleanBag bag = BooleanBags.immutable.with(false, false, true);
        ImmutableBooleanSet expected = BooleanSets.immutable.with(true);
        ImmutableBooleanSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
        ImmutableBooleanBag bag2 = BooleanBags.immutable.with(false, false, true, true);
        ImmutableBooleanSet expected2 = BooleanSets.immutable.empty();
        ImmutableBooleanSet actual2 = bag2.selectUnique();
        Assert.assertEquals(expected2, actual2);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sizeDistinct() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sizeDistinct, this.description("sizeDistinct"));
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
        public void benchmark_booleanIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::booleanIterator, this.description("booleanIterator"));
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
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectUnique, this.description("selectUnique"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractImmutableBooleanBagTestCase implementation();
    }
}
