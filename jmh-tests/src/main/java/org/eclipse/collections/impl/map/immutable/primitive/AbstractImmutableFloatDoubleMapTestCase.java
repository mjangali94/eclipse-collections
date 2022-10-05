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

import org.eclipse.collections.api.map.primitive.FloatDoubleMap;
import org.eclipse.collections.api.map.primitive.ImmutableFloatDoubleMap;
import org.eclipse.collections.impl.factory.primitive.FloatDoubleMaps;
import org.eclipse.collections.impl.factory.primitive.DoubleFloatMaps;
import org.eclipse.collections.impl.map.mutable.primitive.FloatDoubleHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleFloatHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractFloatDoubleMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableFloatDoubleMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableFloatDoubleMapTestCase extends AbstractFloatDoubleMapTestCase {

    @Override
    protected ImmutableFloatDoubleMap classUnderTest() {
        return FloatDoubleMaps.immutable.withAll(FloatDoubleHashMap.newWithKeysValues(0.0f, 0.0, 31.0f, 31.0, 32.0f, 32.0));
    }

    @Override
    protected ImmutableFloatDoubleMap newWithKeysValues(float key1, double value1) {
        return FloatDoubleMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableFloatDoubleMap newWithKeysValues(float key1, double value1, float key2, double value2) {
        return FloatDoubleMaps.immutable.withAll(new FloatDoubleHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableFloatDoubleMap newWithKeysValues(float key1, double value1, float key2, double value2, float key3, double value3) {
        return FloatDoubleMaps.immutable.withAll(new FloatDoubleHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableFloatDoubleMap newWithKeysValues(float key1, double value1, float key2, double value2, float key3, double value3, float key4, double value4) {
        return FloatDoubleMaps.immutable.withAll(new FloatDoubleHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableFloatDoubleMap getEmptyMap() {
        return FloatDoubleMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        FloatDoubleMap map1 = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0, 32.0f, 32.0);
        FloatDoubleMap map2 = this.newWithKeysValues(32.0f, 32.0, 0.0f, 0.0, 1.0f, 1.0);
        FloatDoubleMap map3 = this.newWithKeysValues(0.0f, 0.0, 1.0f, 2.0, 32.0f, 32.0);
        FloatDoubleMap map4 = this.newWithKeysValues(0.0f, 1.0, 1.0f, 1.0, 32.0f, 32.0);
        FloatDoubleMap map5 = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0, 32.0f, 33.0);
        FloatDoubleMap map6 = this.newWithKeysValues(50.0f, 0.0, 60.0f, 1.0, 70.0f, 33.0);
        FloatDoubleMap map7 = this.newWithKeysValues(50.0f, 0.0, 60.0f, 1.0);
        FloatDoubleMap map8 = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().keySet().remove(0.0f));
    }

    @Override
    public void values() {
        super.values();
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0.0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(DoubleFloatMaps.immutable.empty(), FloatDoubleMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableDoubleFloatEmptyMap.class, FloatDoubleMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(DoubleFloatMaps.immutable.with(2.0, 1.0f), this.newWithKeysValues(1.0f, 2.0).flipUniqueValues());
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(2.0, 1.0f, 3.0, 2.0f, 4.0, 3.0f, 5.0, 4.0f).toImmutable(), this.newWithKeysValues(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f, 5.0).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0f, 1.0, 2.0f, 1.0).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractFloatDoubleMapTestCase._Benchmark {

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
        public abstract AbstractImmutableFloatDoubleMapTestCase implementation();
    }
}
