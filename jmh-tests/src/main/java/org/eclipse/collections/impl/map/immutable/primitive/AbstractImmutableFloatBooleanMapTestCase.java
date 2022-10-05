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

import org.eclipse.collections.api.map.primitive.FloatBooleanMap;
import org.eclipse.collections.api.map.primitive.ImmutableFloatBooleanMap;
import org.eclipse.collections.impl.factory.primitive.FloatBooleanMaps;
import org.eclipse.collections.impl.map.mutable.primitive.FloatBooleanHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractFloatBooleanMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableFloatBooleanMap}.
 * This file was automatically generated from template file abstractImmutablePrimitiveBooleanMapTestCase.stg.
 */
public abstract class AbstractImmutableFloatBooleanMapTestCase extends AbstractFloatBooleanMapTestCase {

    @Override
    protected ImmutableFloatBooleanMap classUnderTest() {
        return FloatBooleanMaps.immutable.withAll(FloatBooleanHashMap.newWithKeysValues(0.0f, true, 31.0f, false, 32.0f, true));
    }

    @Override
    protected ImmutableFloatBooleanMap newWithKeysValues(float key1, boolean value1) {
        return FloatBooleanMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableFloatBooleanMap newWithKeysValues(float key1, boolean value1, float key2, boolean value2) {
        return FloatBooleanMaps.immutable.withAll(new FloatBooleanHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableFloatBooleanMap newWithKeysValues(float key1, boolean value1, float key2, boolean value2, float key3, boolean value3) {
        return FloatBooleanMaps.immutable.withAll(new FloatBooleanHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableFloatBooleanMap newWithKeysValues(float key1, boolean value1, float key2, boolean value2, float key3, boolean value3, float key4, boolean value4) {
        return FloatBooleanMaps.immutable.withAll(new FloatBooleanHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableFloatBooleanMap getEmptyMap() {
        return FloatBooleanMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        FloatBooleanMap map1 = this.newWithKeysValues(0.0f, true, 31.0f, false, 32.0f, true);
        FloatBooleanMap map2 = this.newWithKeysValues(32.0f, true, 0.0f, true, 31.0f, false);
        FloatBooleanMap map3 = this.newWithKeysValues(0.0f, true, 31.0f, false, 32.0f, true, 2.0f, true);
        FloatBooleanMap map4 = this.newWithKeysValues(0.0f, false, 31.0f, false, 32.0f, true);
        FloatBooleanMap map5 = this.newWithKeysValues(0.0f, true, 31.0f, false, 32.0f, false);
        FloatBooleanMap map6 = this.newWithKeysValues(50.0f, true, 60.0f, true, 70.0f, false);
        FloatBooleanMap map7 = this.newWithKeysValues(50.0f, true, 60.0f, true);
        FloatBooleanMap map8 = this.newWithKeysValues(0.0f, true, 1.0f, false);
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
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractFloatBooleanMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testEquals, this.description("testEquals"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractImmutableFloatBooleanMapTestCase implementation();
    }
}
