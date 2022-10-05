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

import org.eclipse.collections.api.map.primitive.ByteLongMap;
import org.eclipse.collections.api.map.primitive.ImmutableByteLongMap;
import org.eclipse.collections.impl.factory.primitive.ByteLongMaps;
import org.eclipse.collections.impl.factory.primitive.LongByteMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteLongHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.LongByteHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractByteLongMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableByteLongMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableByteLongMapTestCase extends AbstractByteLongMapTestCase {

    @Override
    protected ImmutableByteLongMap classUnderTest() {
        return ByteLongMaps.immutable.withAll(ByteLongHashMap.newWithKeysValues((byte) 0, 0L, (byte) 31, 31L, (byte) 32, 32L));
    }

    @Override
    protected ImmutableByteLongMap newWithKeysValues(byte key1, long value1) {
        return ByteLongMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableByteLongMap newWithKeysValues(byte key1, long value1, byte key2, long value2) {
        return ByteLongMaps.immutable.withAll(new ByteLongHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableByteLongMap newWithKeysValues(byte key1, long value1, byte key2, long value2, byte key3, long value3) {
        return ByteLongMaps.immutable.withAll(new ByteLongHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableByteLongMap newWithKeysValues(byte key1, long value1, byte key2, long value2, byte key3, long value3, byte key4, long value4) {
        return ByteLongMaps.immutable.withAll(new ByteLongHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableByteLongMap getEmptyMap() {
        return ByteLongMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        ByteLongMap map1 = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L, (byte) 32, 32L);
        ByteLongMap map2 = this.newWithKeysValues((byte) 32, 32L, (byte) 0, 0L, (byte) 1, 1L);
        ByteLongMap map3 = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 2L, (byte) 32, 32L);
        ByteLongMap map4 = this.newWithKeysValues((byte) 0, 1L, (byte) 1, 1L, (byte) 32, 32L);
        ByteLongMap map5 = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L, (byte) 32, 33L);
        ByteLongMap map6 = this.newWithKeysValues((byte) 50, 0L, (byte) 60, 1L, (byte) 70, 33L);
        ByteLongMap map7 = this.newWithKeysValues((byte) 50, 0L, (byte) 60, 1L);
        ByteLongMap map8 = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0L));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(LongByteMaps.immutable.empty(), ByteLongMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableLongByteEmptyMap.class, ByteLongMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(LongByteMaps.immutable.with(2L, (byte) 1), this.newWithKeysValues((byte) 1, 2L).flipUniqueValues());
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(2L, (byte) 1, 3L, (byte) 2, 4L, (byte) 3, 5L, (byte) 4).toImmutable(), this.newWithKeysValues((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L, (byte) 4, 5L).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((byte) 1, 1L, (byte) 2, 1L).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractByteLongMapTestCase._Benchmark {

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
        public abstract AbstractImmutableByteLongMapTestCase implementation();
    }
}
