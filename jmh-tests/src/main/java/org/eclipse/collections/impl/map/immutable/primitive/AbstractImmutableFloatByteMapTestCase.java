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

import org.eclipse.collections.api.map.primitive.FloatByteMap;
import org.eclipse.collections.api.map.primitive.ImmutableFloatByteMap;
import org.eclipse.collections.impl.factory.primitive.FloatByteMaps;
import org.eclipse.collections.impl.factory.primitive.ByteFloatMaps;
import org.eclipse.collections.impl.map.mutable.primitive.FloatByteHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.ByteFloatHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractFloatByteMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableFloatByteMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableFloatByteMapTestCase extends AbstractFloatByteMapTestCase {

    @Override
    protected ImmutableFloatByteMap classUnderTest() {
        return FloatByteMaps.immutable.withAll(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 0, 31.0f, (byte) 31, 32.0f, (byte) 32));
    }

    @Override
    protected ImmutableFloatByteMap newWithKeysValues(float key1, byte value1) {
        return FloatByteMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableFloatByteMap newWithKeysValues(float key1, byte value1, float key2, byte value2) {
        return FloatByteMaps.immutable.withAll(new FloatByteHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableFloatByteMap newWithKeysValues(float key1, byte value1, float key2, byte value2, float key3, byte value3) {
        return FloatByteMaps.immutable.withAll(new FloatByteHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableFloatByteMap newWithKeysValues(float key1, byte value1, float key2, byte value2, float key3, byte value3, float key4, byte value4) {
        return FloatByteMaps.immutable.withAll(new FloatByteHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableFloatByteMap getEmptyMap() {
        return FloatByteMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        FloatByteMap map1 = this.newWithKeysValues(0.0f, (byte) 0, 1.0f, (byte) 1, 32.0f, (byte) 32);
        FloatByteMap map2 = this.newWithKeysValues(32.0f, (byte) 32, 0.0f, (byte) 0, 1.0f, (byte) 1);
        FloatByteMap map3 = this.newWithKeysValues(0.0f, (byte) 0, 1.0f, (byte) 2, 32.0f, (byte) 32);
        FloatByteMap map4 = this.newWithKeysValues(0.0f, (byte) 1, 1.0f, (byte) 1, 32.0f, (byte) 32);
        FloatByteMap map5 = this.newWithKeysValues(0.0f, (byte) 0, 1.0f, (byte) 1, 32.0f, (byte) 33);
        FloatByteMap map6 = this.newWithKeysValues(50.0f, (byte) 0, 60.0f, (byte) 1, 70.0f, (byte) 33);
        FloatByteMap map7 = this.newWithKeysValues(50.0f, (byte) 0, 60.0f, (byte) 1);
        FloatByteMap map8 = this.newWithKeysValues(0.0f, (byte) 0, 1.0f, (byte) 1);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove((byte) 0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(ByteFloatMaps.immutable.empty(), FloatByteMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableByteFloatEmptyMap.class, FloatByteMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(ByteFloatMaps.immutable.with((byte) 2, 1.0f), this.newWithKeysValues(1.0f, (byte) 2).flipUniqueValues());
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 2, 1.0f, (byte) 3, 2.0f, (byte) 4, 3.0f, (byte) 5, 4.0f).toImmutable(), this.newWithKeysValues(1.0f, (byte) 2, 2.0f, (byte) 3, 3.0f, (byte) 4, 4.0f, (byte) 5).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0f, (byte) 1, 2.0f, (byte) 1).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractFloatByteMapTestCase._Benchmark {

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
        public abstract AbstractImmutableFloatByteMapTestCase implementation();
    }
}
