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

import org.eclipse.collections.api.map.primitive.ByteByteMap;
import org.eclipse.collections.api.map.primitive.ImmutableByteByteMap;
import org.eclipse.collections.impl.factory.primitive.ByteByteMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteByteHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractByteByteMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableByteByteMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableByteByteMapTestCase extends AbstractByteByteMapTestCase {

    @Override
    protected ImmutableByteByteMap classUnderTest() {
        return ByteByteMaps.immutable.withAll(ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 0, (byte) 31, (byte) 31, (byte) 32, (byte) 32));
    }

    @Override
    protected ImmutableByteByteMap newWithKeysValues(byte key1, byte value1) {
        return ByteByteMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableByteByteMap newWithKeysValues(byte key1, byte value1, byte key2, byte value2) {
        return ByteByteMaps.immutable.withAll(new ByteByteHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableByteByteMap newWithKeysValues(byte key1, byte value1, byte key2, byte value2, byte key3, byte value3) {
        return ByteByteMaps.immutable.withAll(new ByteByteHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableByteByteMap newWithKeysValues(byte key1, byte value1, byte key2, byte value2, byte key3, byte value3, byte key4, byte value4) {
        return ByteByteMaps.immutable.withAll(new ByteByteHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableByteByteMap getEmptyMap() {
        return ByteByteMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        ByteByteMap map1 = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 32, (byte) 32);
        ByteByteMap map2 = this.newWithKeysValues((byte) 32, (byte) 32, (byte) 0, (byte) 0, (byte) 1, (byte) 1);
        ByteByteMap map3 = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 2, (byte) 32, (byte) 32);
        ByteByteMap map4 = this.newWithKeysValues((byte) 0, (byte) 1, (byte) 1, (byte) 1, (byte) 32, (byte) 32);
        ByteByteMap map5 = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 32, (byte) 33);
        ByteByteMap map6 = this.newWithKeysValues((byte) 50, (byte) 0, (byte) 60, (byte) 1, (byte) 70, (byte) 33);
        ByteByteMap map7 = this.newWithKeysValues((byte) 50, (byte) 0, (byte) 60, (byte) 1);
        ByteByteMap map8 = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove((byte) 0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(ByteByteMaps.immutable.empty(), ByteByteMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableByteByteEmptyMap.class, ByteByteMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(ByteByteMaps.immutable.with((byte) 2, (byte) 1), this.newWithKeysValues((byte) 1, (byte) 2).flipUniqueValues());
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 2, (byte) 1, (byte) 3, (byte) 2, (byte) 4, (byte) 3, (byte) 5, (byte) 4).toImmutable(), this.newWithKeysValues((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4, (byte) 4, (byte) 5).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((byte) 1, (byte) 1, (byte) 2, (byte) 1).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractByteByteMapTestCase._Benchmark {

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
        public abstract AbstractImmutableByteByteMapTestCase implementation();
    }
}
