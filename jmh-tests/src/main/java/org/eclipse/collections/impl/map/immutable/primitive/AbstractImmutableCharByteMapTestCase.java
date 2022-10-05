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

import org.eclipse.collections.api.map.primitive.CharByteMap;
import org.eclipse.collections.api.map.primitive.ImmutableCharByteMap;
import org.eclipse.collections.impl.factory.primitive.CharByteMaps;
import org.eclipse.collections.impl.factory.primitive.ByteCharMaps;
import org.eclipse.collections.impl.map.mutable.primitive.CharByteHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.ByteCharHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractCharByteMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableCharByteMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableCharByteMapTestCase extends AbstractCharByteMapTestCase {

    @Override
    protected ImmutableCharByteMap classUnderTest() {
        return CharByteMaps.immutable.withAll(CharByteHashMap.newWithKeysValues((char) 0, (byte) 0, (char) 31, (byte) 31, (char) 32, (byte) 32));
    }

    @Override
    protected ImmutableCharByteMap newWithKeysValues(char key1, byte value1) {
        return CharByteMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableCharByteMap newWithKeysValues(char key1, byte value1, char key2, byte value2) {
        return CharByteMaps.immutable.withAll(new CharByteHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableCharByteMap newWithKeysValues(char key1, byte value1, char key2, byte value2, char key3, byte value3) {
        return CharByteMaps.immutable.withAll(new CharByteHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableCharByteMap newWithKeysValues(char key1, byte value1, char key2, byte value2, char key3, byte value3, char key4, byte value4) {
        return CharByteMaps.immutable.withAll(new CharByteHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableCharByteMap getEmptyMap() {
        return CharByteMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        CharByteMap map1 = this.newWithKeysValues((char) 0, (byte) 0, (char) 1, (byte) 1, (char) 32, (byte) 32);
        CharByteMap map2 = this.newWithKeysValues((char) 32, (byte) 32, (char) 0, (byte) 0, (char) 1, (byte) 1);
        CharByteMap map3 = this.newWithKeysValues((char) 0, (byte) 0, (char) 1, (byte) 2, (char) 32, (byte) 32);
        CharByteMap map4 = this.newWithKeysValues((char) 0, (byte) 1, (char) 1, (byte) 1, (char) 32, (byte) 32);
        CharByteMap map5 = this.newWithKeysValues((char) 0, (byte) 0, (char) 1, (byte) 1, (char) 32, (byte) 33);
        CharByteMap map6 = this.newWithKeysValues((char) 50, (byte) 0, (char) 60, (byte) 1, (char) 70, (byte) 33);
        CharByteMap map7 = this.newWithKeysValues((char) 50, (byte) 0, (char) 60, (byte) 1);
        CharByteMap map8 = this.newWithKeysValues((char) 0, (byte) 0, (char) 1, (byte) 1);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().keySet().remove((char) 0));
    }

    @Override
    public void values() {
        super.values();
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove((byte) 0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(ByteCharMaps.immutable.empty(), CharByteMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableByteCharEmptyMap.class, CharByteMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(ByteCharMaps.immutable.with((byte) 2, (char) 1), this.newWithKeysValues((char) 1, (byte) 2).flipUniqueValues());
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 2, (char) 1, (byte) 3, (char) 2, (byte) 4, (char) 3, (byte) 5, (char) 4).toImmutable(), this.newWithKeysValues((char) 1, (byte) 2, (char) 2, (byte) 3, (char) 3, (byte) 4, (char) 4, (byte) 5).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((char) 1, (byte) 1, (char) 2, (byte) 1).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractCharByteMapTestCase._Benchmark {

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
        public abstract AbstractImmutableCharByteMapTestCase implementation();
    }
}
