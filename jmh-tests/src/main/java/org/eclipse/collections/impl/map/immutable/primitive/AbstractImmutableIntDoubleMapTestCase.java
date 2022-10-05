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

import org.eclipse.collections.api.map.primitive.IntDoubleMap;
import org.eclipse.collections.api.map.primitive.ImmutableIntDoubleMap;
import org.eclipse.collections.impl.factory.primitive.IntDoubleMaps;
import org.eclipse.collections.impl.factory.primitive.DoubleIntMaps;
import org.eclipse.collections.impl.map.mutable.primitive.IntDoubleHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleIntHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractIntDoubleMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableIntDoubleMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableIntDoubleMapTestCase extends AbstractIntDoubleMapTestCase {

    @Override
    protected ImmutableIntDoubleMap classUnderTest() {
        return IntDoubleMaps.immutable.withAll(IntDoubleHashMap.newWithKeysValues(0, 0.0, 31, 31.0, 32, 32.0));
    }

    @Override
    protected ImmutableIntDoubleMap newWithKeysValues(int key1, double value1) {
        return IntDoubleMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableIntDoubleMap newWithKeysValues(int key1, double value1, int key2, double value2) {
        return IntDoubleMaps.immutable.withAll(new IntDoubleHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableIntDoubleMap newWithKeysValues(int key1, double value1, int key2, double value2, int key3, double value3) {
        return IntDoubleMaps.immutable.withAll(new IntDoubleHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableIntDoubleMap newWithKeysValues(int key1, double value1, int key2, double value2, int key3, double value3, int key4, double value4) {
        return IntDoubleMaps.immutable.withAll(new IntDoubleHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableIntDoubleMap getEmptyMap() {
        return IntDoubleMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        IntDoubleMap map1 = this.newWithKeysValues(0, 0.0, 1, 1.0, 32, 32.0);
        IntDoubleMap map2 = this.newWithKeysValues(32, 32.0, 0, 0.0, 1, 1.0);
        IntDoubleMap map3 = this.newWithKeysValues(0, 0.0, 1, 2.0, 32, 32.0);
        IntDoubleMap map4 = this.newWithKeysValues(0, 1.0, 1, 1.0, 32, 32.0);
        IntDoubleMap map5 = this.newWithKeysValues(0, 0.0, 1, 1.0, 32, 33.0);
        IntDoubleMap map6 = this.newWithKeysValues(50, 0.0, 60, 1.0, 70, 33.0);
        IntDoubleMap map7 = this.newWithKeysValues(50, 0.0, 60, 1.0);
        IntDoubleMap map8 = this.newWithKeysValues(0, 0.0, 1, 1.0);
        Verify.assertEqualsAndHashCode(map1, map2);
        Verify.assertPostSerializedEqualsAndHashCode(map1);
        Verify.assertPostSerializedEqualsAndHashCode(map6);
        Verify.assertPostSerializedEqualsAndHashCode(map8);
        Verify.assertPostSerializedIdentity(this.getEmptyMap());
        Assert.assertNotEquals(map1, map3);
        Assert.assertNotEquals(map1, map4);
        Assert.assertNotEquals(map1, map5);
        Assert.assertNotEquals(map7, map6);
        Assert.assertNotEquals(map7, map8);
    }

    @Override
    @Test
    public void keySet() {
        super.keySet();
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().keySet().remove(0));
    }

    @Override
    public void values() {
        super.values();
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0.0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(DoubleIntMaps.immutable.empty(), IntDoubleMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableDoubleIntEmptyMap.class, IntDoubleMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(DoubleIntMaps.immutable.with(2.0, 1), this.newWithKeysValues(1, 2.0).flipUniqueValues());
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(2.0, 1, 3.0, 2, 4.0, 3, 5.0, 4).toImmutable(), this.newWithKeysValues(1, 2.0, 2, 3.0, 3, 4.0, 4, 5.0).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1, 1.0, 2, 1.0).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractIntDoubleMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testEquals, this.description("testEquals"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::keySet, this.description("keySet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::flipUniqueValues, this.description("flipUniqueValues"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractImmutableIntDoubleMapTestCase implementation();
    }
}
