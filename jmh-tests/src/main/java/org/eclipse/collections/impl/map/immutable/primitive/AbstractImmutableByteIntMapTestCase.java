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

import org.eclipse.collections.api.map.primitive.ByteIntMap;
import org.eclipse.collections.api.map.primitive.ImmutableByteIntMap;
import org.eclipse.collections.impl.factory.primitive.ByteIntMaps;
import org.eclipse.collections.impl.factory.primitive.IntByteMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteIntHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntByteHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractByteIntMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableByteIntMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableByteIntMapTestCase extends AbstractByteIntMapTestCase {

    @Override
    protected ImmutableByteIntMap classUnderTest() {
        return ByteIntMaps.immutable.withAll(ByteIntHashMap.newWithKeysValues((byte) 0, 0, (byte) 31, 31, (byte) 32, 32));
    }

    @Override
    protected ImmutableByteIntMap newWithKeysValues(byte key1, int value1) {
        return ByteIntMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableByteIntMap newWithKeysValues(byte key1, int value1, byte key2, int value2) {
        return ByteIntMaps.immutable.withAll(new ByteIntHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableByteIntMap newWithKeysValues(byte key1, int value1, byte key2, int value2, byte key3, int value3) {
        return ByteIntMaps.immutable.withAll(new ByteIntHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableByteIntMap newWithKeysValues(byte key1, int value1, byte key2, int value2, byte key3, int value3, byte key4, int value4) {
        return ByteIntMaps.immutable.withAll(new ByteIntHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableByteIntMap getEmptyMap() {
        return ByteIntMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        ByteIntMap map1 = this.newWithKeysValues((byte) 0, 0, (byte) 1, 1, (byte) 32, 32);
        ByteIntMap map2 = this.newWithKeysValues((byte) 32, 32, (byte) 0, 0, (byte) 1, 1);
        ByteIntMap map3 = this.newWithKeysValues((byte) 0, 0, (byte) 1, 2, (byte) 32, 32);
        ByteIntMap map4 = this.newWithKeysValues((byte) 0, 1, (byte) 1, 1, (byte) 32, 32);
        ByteIntMap map5 = this.newWithKeysValues((byte) 0, 0, (byte) 1, 1, (byte) 32, 33);
        ByteIntMap map6 = this.newWithKeysValues((byte) 50, 0, (byte) 60, 1, (byte) 70, 33);
        ByteIntMap map7 = this.newWithKeysValues((byte) 50, 0, (byte) 60, 1);
        ByteIntMap map8 = this.newWithKeysValues((byte) 0, 0, (byte) 1, 1);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(IntByteMaps.immutable.empty(), ByteIntMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableIntByteEmptyMap.class, ByteIntMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(IntByteMaps.immutable.with(2, (byte) 1), this.newWithKeysValues((byte) 1, 2).flipUniqueValues());
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(2, (byte) 1, 3, (byte) 2, 4, (byte) 3, 5, (byte) 4).toImmutable(), this.newWithKeysValues((byte) 1, 2, (byte) 2, 3, (byte) 3, 4, (byte) 4, 5).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((byte) 1, 1, (byte) 2, 1).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractByteIntMapTestCase._Benchmark {

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
        public abstract AbstractImmutableByteIntMapTestCase implementation();
    }
}
