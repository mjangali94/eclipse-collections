/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.strategy.immutable;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.block.HashingStrategy;
import org.eclipse.collections.api.map.ImmutableMap;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
import org.eclipse.collections.impl.map.immutable.ImmutableMemoryEfficientMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableEmptyMapWithHashingStrategy}.
 */
public class ImmutableEmptyMapWithHashingStrategyTest extends ImmutableMemoryEfficientMapTestCase {

    // Not using the static factor method in order to have concrete types for test cases
    private static final HashingStrategy<Integer> HASHING_STRATEGY = HashingStrategies.nullSafeHashingStrategy(new HashingStrategy<Integer>() {

        public int computeHashCode(Integer object) {
            return object.hashCode();
        }

        public boolean equals(Integer object1, Integer object2) {
            return object1.equals(object2);
        }
    });

    @Override
    protected ImmutableMap<Integer, String> classUnderTest() {
        return new ImmutableEmptyMapWithHashingStrategy<>(HASHING_STRATEGY);
    }

    @Override
    protected int size() {
        return 0;
    }

    @Override
    @Test
    public void testToString() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        Assert.assertEquals("{}", map.toString());
    }

    @Override
    @Test
    public void flipUniqueValues() {
        Verify.assertEmpty(this.classUnderTest().flipUniqueValues());
    }

    @Override
    @Test
    public void get() {
        // Absent key behavior
        ImmutableMap<Integer, String> classUnderTest = this.classUnderTest();
        Integer absentKey = this.size() + 1;
        Assert.assertNull(classUnderTest.get(absentKey));
        String absentValue = String.valueOf(absentKey);
        Assert.assertFalse(classUnderTest.containsValue(absentValue));
        // Still unchanged
        Assert.assertEquals(this.equalUnifiedMap(), classUnderTest);
    }

    @Override
    @Test
    public void getIfAbsent_function() {
        Integer absentKey = this.size() + 1;
        String absentValue = String.valueOf(absentKey);
        // Absent key behavior
        ImmutableMap<Integer, String> classUnderTest = this.classUnderTest();
        Assert.assertEquals(absentValue, classUnderTest.getIfAbsent(absentKey, new PassThruFunction0<>(absentValue)));
        // Still unchanged
        Assert.assertEquals(this.equalUnifiedMap(), classUnderTest);
    }

    @Override
    @Test
    public void getOrDefault() {
        super.getOrDefault();
        Integer absentKey = this.size() + 1;
        String absentValue = String.valueOf(absentKey);
        // Absent key behavior
        ImmutableMap<Integer, String> classUnderTest = this.classUnderTest();
        Assert.assertEquals(absentValue, classUnderTest.getOrDefault(absentKey, absentValue));
        // Still unchanged
        Assert.assertEquals(this.equalUnifiedMap(), classUnderTest);
    }

    @Override
    @Test
    public void getIfAbsent() {
        Integer absentKey = this.size() + 1;
        String absentValue = String.valueOf(absentKey);
        // Absent key behavior
        ImmutableMap<Integer, String> classUnderTest = this.classUnderTest();
        Assert.assertEquals(absentValue, classUnderTest.getIfAbsentValue(absentKey, absentValue));
        // Still unchanged
        Assert.assertEquals(this.equalUnifiedMap(), classUnderTest);
    }

    @Override
    @Test
    public void getIfAbsentWith() {
        Integer absentKey = this.size() + 1;
        String absentValue = String.valueOf(absentKey);
        // Absent key behavior
        ImmutableMap<Integer, String> classUnderTest = this.classUnderTest();
        Assert.assertEquals(absentValue, classUnderTest.getIfAbsentWith(absentKey, String::valueOf, absentValue));
        // Still unchanged
        Assert.assertEquals(this.equalUnifiedMap(), classUnderTest);
    }

    @Override
    @Test
    public void ifPresentApply() {
        Integer absentKey = this.size() + 1;
        ImmutableMap<Integer, String> classUnderTest = this.classUnderTest();
        Assert.assertNull(classUnderTest.ifPresentApply(absentKey, Functions.getPassThru()));
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertFalse(this.classUnderTest().notEmpty());
    }

    @Override
    @Test
    public void allSatisfy() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        Assert.assertTrue(map.allSatisfy(String.class::isInstance));
        Assert.assertTrue(map.allSatisfy("Monkey"::equals));
    }

    @Override
    @Test
    public void noneSatisfy() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        Assert.assertTrue(map.noneSatisfy(Integer.class::isInstance));
        Assert.assertTrue(map.noneSatisfy("Monkey"::equals));
    }

    @Override
    @Test
    public void anySatisfy() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        Assert.assertFalse(map.anySatisfy(String.class::isInstance));
        Assert.assertFalse(map.anySatisfy("Monkey"::equals));
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void max() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        map.max();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void maxBy() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        map.maxBy(Functions.getStringPassThru());
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void min() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        map.min();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void minBy() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        map.minBy(Functions.getStringPassThru());
    }

    @Test(expected = IllegalStateException.class)
    public void getOnly() {
        this.classUnderTest().getOnly();
    }

    @Override
    public void select() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        ImmutableMap<Integer, String> actual = map.select((ignored1, ignored2) -> true);
        Verify.assertInstanceOf(ImmutableEmptyMapWithHashingStrategy.class, actual);
    }

    @Override
    public void reject() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        ImmutableMap<Integer, String> actual = map.reject((ignored1, ignored2) -> false);
        Verify.assertInstanceOf(ImmutableEmptyMapWithHashingStrategy.class, actual);
    }

    @Override
    public void detect() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        Assert.assertNull(map.detect((ignored1, ignored2) -> true));
    }

    @Override
    protected <K, V> ImmutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return new ImmutableEmptyMapWithHashingStrategy<>(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy()));
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testToString, this.description("testToString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::flipUniqueValues, this.description("flipUniqueValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::get, this.description("get"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent_function() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsent_function, this.description("getIfAbsent_function"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrDefault() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getOrDefault, this.description("getOrDefault"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsent, this.description("getIfAbsent"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentWith, this.description("getIfAbsentWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ifPresentApply() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::ifPresentApply, this.description("ifPresentApply"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::notEmpty, this.description("notEmpty"));
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
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfy, this.description("anySatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::max, this.description("max"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::maxBy, this.description("maxBy"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::min, this.description("min"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::minBy, this.description("minBy"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::getOnly, this.description("getOnly"), java.lang.IllegalStateException.class);
        }

        private ImmutableEmptyMapWithHashingStrategyTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableEmptyMapWithHashingStrategyTest();
        }

        @java.lang.Override
        public ImmutableEmptyMapWithHashingStrategyTest implementation() {
            return this.implementation;
        }
    }
}
