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

import org.eclipse.collections.api.map.primitive.ByteDoubleMap;
import org.eclipse.collections.api.map.primitive.ImmutableByteDoubleMap;
import org.eclipse.collections.impl.factory.primitive.ByteDoubleMaps;
import org.eclipse.collections.impl.factory.primitive.DoubleByteMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteDoubleHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleByteHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractByteDoubleMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableByteDoubleMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableByteDoubleMapTestCase extends AbstractByteDoubleMapTestCase {

    @Override
    protected ImmutableByteDoubleMap classUnderTest() {
        return ByteDoubleMaps.immutable.withAll(ByteDoubleHashMap.newWithKeysValues((byte) 0, 0.0, (byte) 31, 31.0, (byte) 32, 32.0));
    }

    @Override
    protected ImmutableByteDoubleMap newWithKeysValues(byte key1, double value1) {
        return ByteDoubleMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableByteDoubleMap newWithKeysValues(byte key1, double value1, byte key2, double value2) {
        return ByteDoubleMaps.immutable.withAll(new ByteDoubleHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableByteDoubleMap newWithKeysValues(byte key1, double value1, byte key2, double value2, byte key3, double value3) {
        return ByteDoubleMaps.immutable.withAll(new ByteDoubleHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableByteDoubleMap newWithKeysValues(byte key1, double value1, byte key2, double value2, byte key3, double value3, byte key4, double value4) {
        return ByteDoubleMaps.immutable.withAll(new ByteDoubleHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableByteDoubleMap getEmptyMap() {
        return ByteDoubleMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        ByteDoubleMap map1 = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0, (byte) 32, 32.0);
        ByteDoubleMap map2 = this.newWithKeysValues((byte) 32, 32.0, (byte) 0, 0.0, (byte) 1, 1.0);
        ByteDoubleMap map3 = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 2.0, (byte) 32, 32.0);
        ByteDoubleMap map4 = this.newWithKeysValues((byte) 0, 1.0, (byte) 1, 1.0, (byte) 32, 32.0);
        ByteDoubleMap map5 = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0, (byte) 32, 33.0);
        ByteDoubleMap map6 = this.newWithKeysValues((byte) 50, 0.0, (byte) 60, 1.0, (byte) 70, 33.0);
        ByteDoubleMap map7 = this.newWithKeysValues((byte) 50, 0.0, (byte) 60, 1.0);
        ByteDoubleMap map8 = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0.0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(DoubleByteMaps.immutable.empty(), ByteDoubleMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableDoubleByteEmptyMap.class, ByteDoubleMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(DoubleByteMaps.immutable.with(2.0, (byte) 1), this.newWithKeysValues((byte) 1, 2.0).flipUniqueValues());
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(2.0, (byte) 1, 3.0, (byte) 2, 4.0, (byte) 3, 5.0, (byte) 4).toImmutable(), this.newWithKeysValues((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0, (byte) 4, 5.0).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((byte) 1, 1.0, (byte) 2, 1.0).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractByteDoubleMapTestCase._Benchmark {

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
        public abstract AbstractImmutableByteDoubleMapTestCase implementation();
    }
}
