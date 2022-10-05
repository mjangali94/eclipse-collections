/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.immutable.primitive;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.api.map.primitive.ImmutableObjectDoubleMap;
import org.eclipse.collections.api.map.primitive.ObjectDoubleMap;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectDoubleHashMap;
import org.eclipse.collections.impl.math.MutableDouble;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableObjectDoubleSingletonMap}.
 * This file was automatically generated from template file immutableObjectPrimitiveSingletonMapTest.stg.
 */
public class ImmutableObjectDoubleSingletonMapTest extends AbstractImmutableObjectDoubleMapTestCase {

    @Override
    protected ImmutableObjectDoubleMap<String> classUnderTest() {
        return ObjectDoubleHashMap.newWithKeysValues("1", 1.0).toImmutable();
    }

    @Test
    public void newWithKeyValue() {
        ImmutableObjectDoubleMap<String> map1 = this.classUnderTest();
        ImmutableObjectDoubleMap<String> expected = ObjectDoubleHashMap.newWithKeysValues("1", 1.0, "3", 3.0).toImmutable();
        Assert.assertEquals(expected, map1.newWithKeyValue("3", 3.0));
        Assert.assertNotSame(map1, map1.newWithKeyValue("3", 3.0));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue() {
        ImmutableObjectDoubleMap<String> map1 = this.classUnderTest();
        ImmutableObjectDoubleMap<String> expected1 = this.newWithKeysValues("1", 1.0);
        Assert.assertEquals(expected1, map1.newWithoutKey("2"));
        Assert.assertEquals(this.classUnderTest(), map1);
        ImmutableObjectDoubleMap<String> expected2 = this.getEmptyMap();
        Assert.assertEquals(expected2, map1.newWithoutKey("1"));
        Assert.assertNotSame(map1, map1.newWithoutKey("1"));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys() {
        ImmutableObjectDoubleMap<String> map1 = this.classUnderTest();
        ImmutableObjectDoubleMap<String> expected1 = this.newWithKeysValues("1", 1.0);
        Assert.assertEquals(expected1, map1.newWithoutAllKeys(FastList.newListWith("2", "3")));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(FastList.newListWith("2", "3")));
        Assert.assertEquals(this.classUnderTest(), map1);
        ImmutableObjectDoubleMap<String> expected2 = this.getEmptyMap();
        Assert.assertEquals(expected2, map1.newWithoutAllKeys(FastList.newListWith("1", "3")));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(FastList.newListWith("1", "3")));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Override
    @Test
    public void containsKey() {
        Assert.assertFalse(this.classUnderTest().containsKey("0"));
        Assert.assertTrue(this.classUnderTest().containsKey("1"));
        Assert.assertFalse(this.classUnderTest().containsKey("2"));
        Assert.assertFalse(this.classUnderTest().containsKey("3"));
        Assert.assertFalse(this.classUnderTest().containsKey(null));
    }

    @Override
    @Test
    public void containsValue() {
        Assert.assertFalse(this.classUnderTest().containsValue(0.0));
        Assert.assertTrue(this.classUnderTest().containsValue(1.0));
        Assert.assertFalse(this.classUnderTest().containsValue(2.0));
    }

    @Override
    @Test
    public void detectIfNone() {
        double detect = this.classUnderTest().detectIfNone((double value) -> true, 5.0);
        Assert.assertEquals(1.0, detect, 0.0);
        double detect1 = this.classUnderTest().detectIfNone((double value) -> false, 5.0);
        Assert.assertEquals(5.0, detect1, 0.0);
    }

    @Override
    @Test
    public void getIfAbsent() {
        Assert.assertEquals(1.0, this.classUnderTest().getIfAbsent("0", 1.0), 0.0);
        Assert.assertEquals(1.0, this.classUnderTest().getIfAbsent("1", 2.0), 0.0);
        Assert.assertEquals(3.0, this.classUnderTest().getIfAbsent("2", 3.0), 0.0);
        Assert.assertEquals(1.0, this.classUnderTest().getIfAbsent("5", 1.0), 0.0);
        Assert.assertEquals(0.0, this.classUnderTest().getIfAbsent("5", 0.0), 0.0);
        Assert.assertEquals(1.0, this.classUnderTest().getIfAbsent(null, 1.0), 0.0);
        Assert.assertEquals(0.0, this.classUnderTest().getIfAbsent(null, 0.0), 0.0);
    }

    @Override
    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(1.0, this.classUnderTest().maxIfEmpty(9.0), 0.0);
    }

    @Override
    @Test
    public void median() {
        Assert.assertEquals(1.0, this.classUnderTest().median(), 0.0);
    }

    @Override
    @Test
    public void allSatisfy() {
        Assert.assertFalse(this.classUnderTest().allSatisfy((double value) -> false));
        Assert.assertTrue(this.classUnderTest().allSatisfy((double value) -> true));
    }

    @Override
    @Test
    public void reject() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().reject((String object, double value) -> false));
        Assert.assertEquals(this.getEmptyMap(), this.classUnderTest().reject((String object, double value) -> true));
        Assert.assertEquals(new DoubleHashBag(), this.classUnderTest().reject((double value) -> true).toBag());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0), this.classUnderTest().reject((double value) -> false).toBag());
    }

    @Override
    @Test
    public void select() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().select((String object, double value) -> true));
        Assert.assertEquals(this.getEmptyMap(), this.classUnderTest().select((String object, double value) -> false));
        Assert.assertEquals(new DoubleHashBag(), this.classUnderTest().select((double value) -> false).toBag());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0), this.classUnderTest().select((double value) -> true).toBag());
    }

    @Test
    public void keysView() {
        Assert.assertEquals(FastList.newListWith("1"), this.classUnderTest().keysView().toList());
    }

    @Override
    @Test
    public void doubleIterator() {
        DoubleIterator iterator = this.classUnderTest().doubleIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(1.0, iterator.next(), 0.0);
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void contains() {
        Assert.assertFalse(this.classUnderTest().contains(0.0));
        Assert.assertTrue(this.classUnderTest().contains(1.0));
        Assert.assertFalse(this.classUnderTest().contains(2.0));
    }

    @Override
    @Test
    public void getOrThrow() {
        Assert.assertEquals(1.0, this.classUnderTest().getOrThrow("1"), 0.0);
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow("5"));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow("0"));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow(null));
    }

    @Override
    @Test
    public void get() {
        Assert.assertEquals(0.0, this.classUnderTest().get("0"), 0.0);
        Assert.assertEquals(1.0, this.classUnderTest().get("1"), 0.0);
        Assert.assertEquals(0.0, this.classUnderTest().get(null), 0.0);
    }

    @Override
    @Test
    public void max() {
        Assert.assertEquals(1.0, this.classUnderTest().max(), 0.0);
    }

    @Override
    @Test
    public void min() {
        Assert.assertEquals(1.0, this.classUnderTest().max(), 0.0);
    }

    @Override
    @Test
    public void sum() {
        Assert.assertEquals(1.0, this.classUnderTest().sum(), 0.0);
    }

    @Override
    @Test
    public void count() {
        Assert.assertEquals(1L, this.classUnderTest().count((double value) -> true));
        Assert.assertEquals(0L, this.classUnderTest().count((double value) -> false));
    }

    @Override
    @Test
    public void toBag() {
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0), this.classUnderTest().toBag());
    }

    @Override
    @Test
    public void toSet() {
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0), this.classUnderTest().toSet());
    }

    @Override
    @Test
    public void containsAll() {
        Assert.assertFalse(this.classUnderTest().containsAll(0.0, 1.0, 2.0));
        Assert.assertFalse(this.classUnderTest().containsAll(0.0, 1.0, 5.0));
        Assert.assertTrue(this.classUnderTest().containsAll(1.0));
        Assert.assertTrue(this.classUnderTest().containsAll());
    }

    @Override
    @Test
    public void containsAll_Iterable() {
        Assert.assertFalse(this.classUnderTest().containsAll(DoubleArrayList.newListWith(0.0, 1.0, 2.0)));
        Assert.assertFalse(this.classUnderTest().containsAll(DoubleArrayList.newListWith(0.0, 1.0, 5.0)));
        Assert.assertTrue(this.classUnderTest().containsAll(DoubleArrayList.newListWith(1.0)));
        Assert.assertTrue(this.classUnderTest().containsAll(new DoubleArrayList()));
    }

    @Override
    @Test
    public void minIfEmpty() {
        Assert.assertEquals(1.0, this.classUnderTest().minIfEmpty(6.0), 0.0);
    }

    @Override
    @Test
    public void testEquals() {
        ObjectDoubleMap<String> map1 = this.newWithKeysValues("1", 1.0);
        ObjectDoubleMap<String> map2 = this.newWithKeysValues("0", 0.0);
        ObjectDoubleMap<String> map3 = this.newWithKeysValues("0", 0.0, "1", 1.0);
        Assert.assertNotEquals(this.classUnderTest(), map3);
        Assert.assertNotEquals(this.classUnderTest(), map2);
        Verify.assertEqualsAndHashCode(this.classUnderTest(), map1);
        Verify.assertPostSerializedEqualsAndHashCode(this.classUnderTest());
    }

    @Override
    @Test
    public void isEmpty() {
        Verify.assertNotEmpty(this.classUnderTest());
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertTrue(this.classUnderTest().notEmpty());
    }

    @Override
    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.classUnderTest().noneSatisfy((double value) -> true));
        Assert.assertTrue(this.classUnderTest().noneSatisfy((double value) -> false));
    }

    @Test
    public void injectInto() {
        ImmutableObjectDoubleSingletonMap<String> iterable = new ImmutableObjectDoubleSingletonMap<>("1", 1.0);
        MutableDouble result = iterable.injectInto(new MutableDouble(1.0), (MutableDouble object, double value) -> object.add(value));
        Assert.assertEquals(new MutableDouble(2.0), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.immutable.primitive.AbstractImmutableObjectDoubleMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithKeyValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newWithKeyValue, this.description("newWithKeyValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutKeyValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newWithoutKeyValue, this.description("newWithoutKeyValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAllKeys() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newWithoutAllKeys, this.description("newWithoutAllKeys"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsKey, this.description("containsKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsValue, this.description("containsValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectIfNone, this.description("detectIfNone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsent, this.description("getIfAbsent"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::maxIfEmpty, this.description("maxIfEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::median, this.description("median"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfy, this.description("allSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reject, this.description("reject"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::select, this.description("select"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::keysView, this.description("keysView"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::doubleIterator, this.description("doubleIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::contains, this.description("contains"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrThrow() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getOrThrow, this.description("getOrThrow"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::get, this.description("get"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::max, this.description("max"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::min, this.description("min"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sum, this.description("sum"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::count, this.description("count"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toBag, this.description("toBag"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSet, this.description("toSet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsAll, this.description("containsAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll_Iterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsAll_Iterable, this.description("containsAll_Iterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::minIfEmpty, this.description("minIfEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testEquals, this.description("testEquals"));
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
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::noneSatisfy, this.description("noneSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectInto, this.description("injectInto"));
        }

        private ImmutableObjectDoubleSingletonMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableObjectDoubleSingletonMapTest();
        }

        @java.lang.Override
        public ImmutableObjectDoubleSingletonMapTest implementation() {
            return this.implementation;
        }
    }
}
