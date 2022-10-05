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

import org.eclipse.collections.api.map.primitive.ByteShortMap;
import org.eclipse.collections.api.map.primitive.ImmutableByteShortMap;
import org.eclipse.collections.impl.factory.primitive.ByteShortMaps;
import org.eclipse.collections.impl.factory.primitive.ShortByteMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteShortHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.ShortByteHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractByteShortMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableByteShortMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableByteShortMapTestCase extends AbstractByteShortMapTestCase {

    @Override
    protected ImmutableByteShortMap classUnderTest() {
        return ByteShortMaps.immutable.withAll(ByteShortHashMap.newWithKeysValues((byte) 0, (short) 0, (byte) 31, (short) 31, (byte) 32, (short) 32));
    }

    @Override
    protected ImmutableByteShortMap newWithKeysValues(byte key1, short value1) {
        return ByteShortMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableByteShortMap newWithKeysValues(byte key1, short value1, byte key2, short value2) {
        return ByteShortMaps.immutable.withAll(new ByteShortHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableByteShortMap newWithKeysValues(byte key1, short value1, byte key2, short value2, byte key3, short value3) {
        return ByteShortMaps.immutable.withAll(new ByteShortHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableByteShortMap newWithKeysValues(byte key1, short value1, byte key2, short value2, byte key3, short value3, byte key4, short value4) {
        return ByteShortMaps.immutable.withAll(new ByteShortHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableByteShortMap getEmptyMap() {
        return ByteShortMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        ByteShortMap map1 = this.newWithKeysValues((byte) 0, (short) 0, (byte) 1, (short) 1, (byte) 32, (short) 32);
        ByteShortMap map2 = this.newWithKeysValues((byte) 32, (short) 32, (byte) 0, (short) 0, (byte) 1, (short) 1);
        ByteShortMap map3 = this.newWithKeysValues((byte) 0, (short) 0, (byte) 1, (short) 2, (byte) 32, (short) 32);
        ByteShortMap map4 = this.newWithKeysValues((byte) 0, (short) 1, (byte) 1, (short) 1, (byte) 32, (short) 32);
        ByteShortMap map5 = this.newWithKeysValues((byte) 0, (short) 0, (byte) 1, (short) 1, (byte) 32, (short) 33);
        ByteShortMap map6 = this.newWithKeysValues((byte) 50, (short) 0, (byte) 60, (short) 1, (byte) 70, (short) 33);
        ByteShortMap map7 = this.newWithKeysValues((byte) 50, (short) 0, (byte) 60, (short) 1);
        ByteShortMap map8 = this.newWithKeysValues((byte) 0, (short) 0, (byte) 1, (short) 1);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove((short) 0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(ShortByteMaps.immutable.empty(), ByteShortMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableShortByteEmptyMap.class, ByteShortMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(ShortByteMaps.immutable.with((short) 2, (byte) 1), this.newWithKeysValues((byte) 1, (short) 2).flipUniqueValues());
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 2, (byte) 1, (short) 3, (byte) 2, (short) 4, (byte) 3, (short) 5, (byte) 4).toImmutable(), this.newWithKeysValues((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4, (byte) 4, (short) 5).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((byte) 1, (short) 1, (byte) 2, (short) 1).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractByteShortMapTestCase._Benchmark {

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
        public abstract AbstractImmutableByteShortMapTestCase implementation();
    }
}
