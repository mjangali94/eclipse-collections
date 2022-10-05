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

import org.eclipse.collections.api.map.primitive.ByteBooleanMap;
import org.eclipse.collections.api.map.primitive.ImmutableByteBooleanMap;
import org.eclipse.collections.impl.factory.primitive.ByteBooleanMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteBooleanHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractByteBooleanMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableByteBooleanMap}.
 * This file was automatically generated from template file abstractImmutablePrimitiveBooleanMapTestCase.stg.
 */
public abstract class AbstractImmutableByteBooleanMapTestCase extends AbstractByteBooleanMapTestCase {

    @Override
    protected ImmutableByteBooleanMap classUnderTest() {
        return ByteBooleanMaps.immutable.withAll(ByteBooleanHashMap.newWithKeysValues((byte) 0, true, (byte) 31, false, (byte) 32, true));
    }

    @Override
    protected ImmutableByteBooleanMap newWithKeysValues(byte key1, boolean value1) {
        return ByteBooleanMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableByteBooleanMap newWithKeysValues(byte key1, boolean value1, byte key2, boolean value2) {
        return ByteBooleanMaps.immutable.withAll(new ByteBooleanHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableByteBooleanMap newWithKeysValues(byte key1, boolean value1, byte key2, boolean value2, byte key3, boolean value3) {
        return ByteBooleanMaps.immutable.withAll(new ByteBooleanHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableByteBooleanMap newWithKeysValues(byte key1, boolean value1, byte key2, boolean value2, byte key3, boolean value3, byte key4, boolean value4) {
        return ByteBooleanMaps.immutable.withAll(new ByteBooleanHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableByteBooleanMap getEmptyMap() {
        return ByteBooleanMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        ByteBooleanMap map1 = this.newWithKeysValues((byte) 0, true, (byte) 31, false, (byte) 32, true);
        ByteBooleanMap map2 = this.newWithKeysValues((byte) 32, true, (byte) 0, true, (byte) 31, false);
        ByteBooleanMap map3 = this.newWithKeysValues((byte) 0, true, (byte) 31, false, (byte) 32, true, (byte) 2, true);
        ByteBooleanMap map4 = this.newWithKeysValues((byte) 0, false, (byte) 31, false, (byte) 32, true);
        ByteBooleanMap map5 = this.newWithKeysValues((byte) 0, true, (byte) 31, false, (byte) 32, false);
        ByteBooleanMap map6 = this.newWithKeysValues((byte) 50, true, (byte) 60, true, (byte) 70, false);
        ByteBooleanMap map7 = this.newWithKeysValues((byte) 50, true, (byte) 60, true);
        ByteBooleanMap map8 = this.newWithKeysValues((byte) 0, true, (byte) 1, false);
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

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractByteBooleanMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testEquals, this.description("testEquals"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractImmutableByteBooleanMapTestCase implementation();
    }
}
