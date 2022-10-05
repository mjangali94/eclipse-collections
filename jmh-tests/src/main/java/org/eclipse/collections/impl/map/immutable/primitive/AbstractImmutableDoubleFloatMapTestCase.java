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

import org.eclipse.collections.api.map.primitive.DoubleFloatMap;
import org.eclipse.collections.api.map.primitive.ImmutableDoubleFloatMap;
import org.eclipse.collections.impl.factory.primitive.DoubleFloatMaps;
import org.eclipse.collections.impl.factory.primitive.FloatDoubleMaps;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleFloatHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.FloatDoubleHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractDoubleFloatMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableDoubleFloatMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableDoubleFloatMapTestCase extends AbstractDoubleFloatMapTestCase {

    @Override
    protected ImmutableDoubleFloatMap classUnderTest() {
        return DoubleFloatMaps.immutable.withAll(DoubleFloatHashMap.newWithKeysValues(0.0, 0.0f, 31.0, 31.0f, 32.0, 32.0f));
    }

    @Override
    protected ImmutableDoubleFloatMap newWithKeysValues(double key1, float value1) {
        return DoubleFloatMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableDoubleFloatMap newWithKeysValues(double key1, float value1, double key2, float value2) {
        return DoubleFloatMaps.immutable.withAll(new DoubleFloatHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableDoubleFloatMap newWithKeysValues(double key1, float value1, double key2, float value2, double key3, float value3) {
        return DoubleFloatMaps.immutable.withAll(new DoubleFloatHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableDoubleFloatMap newWithKeysValues(double key1, float value1, double key2, float value2, double key3, float value3, double key4, float value4) {
        return DoubleFloatMaps.immutable.withAll(new DoubleFloatHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableDoubleFloatMap getEmptyMap() {
        return DoubleFloatMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        DoubleFloatMap map1 = this.newWithKeysValues(0.0, 0.0f, 1.0, 1.0f, 32.0, 32.0f);
        DoubleFloatMap map2 = this.newWithKeysValues(32.0, 32.0f, 0.0, 0.0f, 1.0, 1.0f);
        DoubleFloatMap map3 = this.newWithKeysValues(0.0, 0.0f, 1.0, 2.0f, 32.0, 32.0f);
        DoubleFloatMap map4 = this.newWithKeysValues(0.0, 1.0f, 1.0, 1.0f, 32.0, 32.0f);
        DoubleFloatMap map5 = this.newWithKeysValues(0.0, 0.0f, 1.0, 1.0f, 32.0, 33.0f);
        DoubleFloatMap map6 = this.newWithKeysValues(50.0, 0.0f, 60.0, 1.0f, 70.0, 33.0f);
        DoubleFloatMap map7 = this.newWithKeysValues(50.0, 0.0f, 60.0, 1.0f);
        DoubleFloatMap map8 = this.newWithKeysValues(0.0, 0.0f, 1.0, 1.0f);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().keySet().remove(0.0));
    }

    @Override
    public void values() {
        super.values();
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0.0f));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(FloatDoubleMaps.immutable.empty(), DoubleFloatMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableFloatDoubleEmptyMap.class, DoubleFloatMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(FloatDoubleMaps.immutable.with(2.0f, 1.0), this.newWithKeysValues(1.0, 2.0f).flipUniqueValues());
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(2.0f, 1.0, 3.0f, 2.0, 4.0f, 3.0, 5.0f, 4.0).toImmutable(), this.newWithKeysValues(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f, 4.0, 5.0f).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0, 1.0f, 2.0, 1.0f).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractDoubleFloatMapTestCase._Benchmark {

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
        public abstract AbstractImmutableDoubleFloatMapTestCase implementation();
    }
}
