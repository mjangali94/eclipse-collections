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

import org.eclipse.collections.api.map.primitive.ImmutableObjectFloatMap;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectFloatHashMap;
import org.eclipse.collections.impl.math.MutableFloat;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableObjectFloatHashMap}.
 * This file was automatically generated from template file immutableObjectPrimitiveHashMapTest.stg.
 */
public class ImmutableObjectFloatHashMapTest extends AbstractImmutableObjectFloatMapTestCase {

    @Override
    protected ImmutableObjectFloatMap<String> classUnderTest() {
        return ObjectFloatHashMap.newWithKeysValues("0", 0.0f, "1", 1.0f, "2", 2.0f).toImmutable();
    }

    @Test
    public void newWithKeyValue() {
        ImmutableObjectFloatMap<String> map1 = this.classUnderTest();
        ImmutableObjectFloatMap<String> expected = ObjectFloatHashMap.newWithKeysValues("0", 0.0f, "1", 1.0f, "2", 2.0f, "3", 3.0f).toImmutable();
        Assert.assertEquals(expected, map1.newWithKeyValue("3", 3.0f));
        Assert.assertNotSame(map1, map1.newWithKeyValue("3", 3.0f));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue() {
        ImmutableObjectFloatMap<String> map1 = this.classUnderTest();
        ImmutableObjectFloatMap<String> expected = this.newWithKeysValues("0", 0.0f, "1", 1.0f);
        Assert.assertEquals(expected, map1.newWithoutKey("2"));
        Assert.assertNotSame(map1, map1.newWithoutKey("2"));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys() {
        ImmutableObjectFloatMap<String> map1 = this.classUnderTest();
        ImmutableObjectFloatMap<String> expected = this.newWithKeysValues("1", 1.0f);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(FastList.newListWith("0", "2")));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(FastList.newListWith("0", "2")));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto() {
        ImmutableObjectFloatHashMap<String> iterable = new ImmutableObjectFloatHashMap<>(ObjectFloatHashMap.newWithKeysValues("3", 3.0f, "1", 1.0f, "2", 2.0f));
        MutableFloat result = iterable.injectInto(new MutableFloat(0.0f), (MutableFloat object, float value) -> object.add(value));
        Assert.assertEquals(new MutableFloat(6.0f), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.immutable.primitive.AbstractImmutableObjectFloatMapTestCase._Benchmark {

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
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectInto, this.description("injectInto"));
        }

        private ImmutableObjectFloatHashMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableObjectFloatHashMapTest();
        }

        @java.lang.Override
        public ImmutableObjectFloatHashMapTest implementation() {
            return this.implementation;
        }
    }
}
