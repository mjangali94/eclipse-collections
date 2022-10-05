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

import org.eclipse.collections.api.map.primitive.IntByteMap;
import org.eclipse.collections.api.map.primitive.ImmutableIntByteMap;
import org.eclipse.collections.impl.factory.primitive.IntByteMaps;
import org.eclipse.collections.impl.factory.primitive.ByteIntMaps;
import org.eclipse.collections.impl.map.mutable.primitive.IntByteHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.ByteIntHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractIntByteMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableIntByteMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableIntByteMapTestCase extends AbstractIntByteMapTestCase {

    @Override
    protected ImmutableIntByteMap classUnderTest() {
        return IntByteMaps.immutable.withAll(IntByteHashMap.newWithKeysValues(0, (byte) 0, 31, (byte) 31, 32, (byte) 32));
    }

    @Override
    protected ImmutableIntByteMap newWithKeysValues(int key1, byte value1) {
        return IntByteMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableIntByteMap newWithKeysValues(int key1, byte value1, int key2, byte value2) {
        return IntByteMaps.immutable.withAll(new IntByteHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableIntByteMap newWithKeysValues(int key1, byte value1, int key2, byte value2, int key3, byte value3) {
        return IntByteMaps.immutable.withAll(new IntByteHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableIntByteMap newWithKeysValues(int key1, byte value1, int key2, byte value2, int key3, byte value3, int key4, byte value4) {
        return IntByteMaps.immutable.withAll(new IntByteHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableIntByteMap getEmptyMap() {
        return IntByteMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        IntByteMap map1 = this.newWithKeysValues(0, (byte) 0, 1, (byte) 1, 32, (byte) 32);
        IntByteMap map2 = this.newWithKeysValues(32, (byte) 32, 0, (byte) 0, 1, (byte) 1);
        IntByteMap map3 = this.newWithKeysValues(0, (byte) 0, 1, (byte) 2, 32, (byte) 32);
        IntByteMap map4 = this.newWithKeysValues(0, (byte) 1, 1, (byte) 1, 32, (byte) 32);
        IntByteMap map5 = this.newWithKeysValues(0, (byte) 0, 1, (byte) 1, 32, (byte) 33);
        IntByteMap map6 = this.newWithKeysValues(50, (byte) 0, 60, (byte) 1, 70, (byte) 33);
        IntByteMap map7 = this.newWithKeysValues(50, (byte) 0, 60, (byte) 1);
        IntByteMap map8 = this.newWithKeysValues(0, (byte) 0, 1, (byte) 1);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove((byte) 0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(ByteIntMaps.immutable.empty(), IntByteMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableByteIntEmptyMap.class, IntByteMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(ByteIntMaps.immutable.with((byte) 2, 1), this.newWithKeysValues(1, (byte) 2).flipUniqueValues());
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 2, 1, (byte) 3, 2, (byte) 4, 3, (byte) 5, 4).toImmutable(), this.newWithKeysValues(1, (byte) 2, 2, (byte) 3, 3, (byte) 4, 4, (byte) 5).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1, (byte) 1, 2, (byte) 1).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractIntByteMapTestCase._Benchmark {

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
        public abstract AbstractImmutableIntByteMapTestCase implementation();
    }
}
