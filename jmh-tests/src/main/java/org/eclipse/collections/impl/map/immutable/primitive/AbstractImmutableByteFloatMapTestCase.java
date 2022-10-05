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

import org.eclipse.collections.api.map.primitive.ByteFloatMap;
import org.eclipse.collections.api.map.primitive.ImmutableByteFloatMap;
import org.eclipse.collections.impl.factory.primitive.ByteFloatMaps;
import org.eclipse.collections.impl.factory.primitive.FloatByteMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteFloatHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.FloatByteHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractByteFloatMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableByteFloatMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableByteFloatMapTestCase extends AbstractByteFloatMapTestCase {

    @Override
    protected ImmutableByteFloatMap classUnderTest() {
        return ByteFloatMaps.immutable.withAll(ByteFloatHashMap.newWithKeysValues((byte) 0, 0.0f, (byte) 31, 31.0f, (byte) 32, 32.0f));
    }

    @Override
    protected ImmutableByteFloatMap newWithKeysValues(byte key1, float value1) {
        return ByteFloatMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableByteFloatMap newWithKeysValues(byte key1, float value1, byte key2, float value2) {
        return ByteFloatMaps.immutable.withAll(new ByteFloatHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableByteFloatMap newWithKeysValues(byte key1, float value1, byte key2, float value2, byte key3, float value3) {
        return ByteFloatMaps.immutable.withAll(new ByteFloatHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableByteFloatMap newWithKeysValues(byte key1, float value1, byte key2, float value2, byte key3, float value3, byte key4, float value4) {
        return ByteFloatMaps.immutable.withAll(new ByteFloatHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableByteFloatMap getEmptyMap() {
        return ByteFloatMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        ByteFloatMap map1 = this.newWithKeysValues((byte) 0, 0.0f, (byte) 1, 1.0f, (byte) 32, 32.0f);
        ByteFloatMap map2 = this.newWithKeysValues((byte) 32, 32.0f, (byte) 0, 0.0f, (byte) 1, 1.0f);
        ByteFloatMap map3 = this.newWithKeysValues((byte) 0, 0.0f, (byte) 1, 2.0f, (byte) 32, 32.0f);
        ByteFloatMap map4 = this.newWithKeysValues((byte) 0, 1.0f, (byte) 1, 1.0f, (byte) 32, 32.0f);
        ByteFloatMap map5 = this.newWithKeysValues((byte) 0, 0.0f, (byte) 1, 1.0f, (byte) 32, 33.0f);
        ByteFloatMap map6 = this.newWithKeysValues((byte) 50, 0.0f, (byte) 60, 1.0f, (byte) 70, 33.0f);
        ByteFloatMap map7 = this.newWithKeysValues((byte) 50, 0.0f, (byte) 60, 1.0f);
        ByteFloatMap map8 = this.newWithKeysValues((byte) 0, 0.0f, (byte) 1, 1.0f);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().keySet().remove((byte) 0));
    }

    @Override
    public void values() {
        super.values();
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0.0f));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(FloatByteMaps.immutable.empty(), ByteFloatMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableFloatByteEmptyMap.class, ByteFloatMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(FloatByteMaps.immutable.with(2.0f, (byte) 1), this.newWithKeysValues((byte) 1, 2.0f).flipUniqueValues());
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(2.0f, (byte) 1, 3.0f, (byte) 2, 4.0f, (byte) 3, 5.0f, (byte) 4).toImmutable(), this.newWithKeysValues((byte) 1, 2.0f, (byte) 2, 3.0f, (byte) 3, 4.0f, (byte) 4, 5.0f).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((byte) 1, 1.0f, (byte) 2, 1.0f).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractByteFloatMapTestCase._Benchmark {

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
        public abstract AbstractImmutableByteFloatMapTestCase implementation();
    }
}
