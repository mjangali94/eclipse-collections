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

import org.eclipse.collections.api.map.primitive.ByteCharMap;
import org.eclipse.collections.api.map.primitive.ImmutableByteCharMap;
import org.eclipse.collections.impl.factory.primitive.ByteCharMaps;
import org.eclipse.collections.impl.factory.primitive.CharByteMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteCharHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.CharByteHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractByteCharMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableByteCharMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableByteCharMapTestCase extends AbstractByteCharMapTestCase {

    @Override
    protected ImmutableByteCharMap classUnderTest() {
        return ByteCharMaps.immutable.withAll(ByteCharHashMap.newWithKeysValues((byte) 0, (char) 0, (byte) 31, (char) 31, (byte) 32, (char) 32));
    }

    @Override
    protected ImmutableByteCharMap newWithKeysValues(byte key1, char value1) {
        return ByteCharMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableByteCharMap newWithKeysValues(byte key1, char value1, byte key2, char value2) {
        return ByteCharMaps.immutable.withAll(new ByteCharHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableByteCharMap newWithKeysValues(byte key1, char value1, byte key2, char value2, byte key3, char value3) {
        return ByteCharMaps.immutable.withAll(new ByteCharHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableByteCharMap newWithKeysValues(byte key1, char value1, byte key2, char value2, byte key3, char value3, byte key4, char value4) {
        return ByteCharMaps.immutable.withAll(new ByteCharHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableByteCharMap getEmptyMap() {
        return ByteCharMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        ByteCharMap map1 = this.newWithKeysValues((byte) 0, (char) 0, (byte) 1, (char) 1, (byte) 32, (char) 32);
        ByteCharMap map2 = this.newWithKeysValues((byte) 32, (char) 32, (byte) 0, (char) 0, (byte) 1, (char) 1);
        ByteCharMap map3 = this.newWithKeysValues((byte) 0, (char) 0, (byte) 1, (char) 2, (byte) 32, (char) 32);
        ByteCharMap map4 = this.newWithKeysValues((byte) 0, (char) 1, (byte) 1, (char) 1, (byte) 32, (char) 32);
        ByteCharMap map5 = this.newWithKeysValues((byte) 0, (char) 0, (byte) 1, (char) 1, (byte) 32, (char) 33);
        ByteCharMap map6 = this.newWithKeysValues((byte) 50, (char) 0, (byte) 60, (char) 1, (byte) 70, (char) 33);
        ByteCharMap map7 = this.newWithKeysValues((byte) 50, (char) 0, (byte) 60, (char) 1);
        ByteCharMap map8 = this.newWithKeysValues((byte) 0, (char) 0, (byte) 1, (char) 1);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove((char) 0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(CharByteMaps.immutable.empty(), ByteCharMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableCharByteEmptyMap.class, ByteCharMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(CharByteMaps.immutable.with((char) 2, (byte) 1), this.newWithKeysValues((byte) 1, (char) 2).flipUniqueValues());
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 2, (byte) 1, (char) 3, (byte) 2, (char) 4, (byte) 3, (char) 5, (byte) 4).toImmutable(), this.newWithKeysValues((byte) 1, (char) 2, (byte) 2, (char) 3, (byte) 3, (char) 4, (byte) 4, (char) 5).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((byte) 1, (char) 1, (byte) 2, (char) 1).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractByteCharMapTestCase._Benchmark {

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
        public abstract AbstractImmutableByteCharMapTestCase implementation();
    }
}
