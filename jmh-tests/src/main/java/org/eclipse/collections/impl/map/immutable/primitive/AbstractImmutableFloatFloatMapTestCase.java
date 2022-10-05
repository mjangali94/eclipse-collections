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

import org.eclipse.collections.api.map.primitive.FloatFloatMap;
import org.eclipse.collections.api.map.primitive.ImmutableFloatFloatMap;
import org.eclipse.collections.impl.factory.primitive.FloatFloatMaps;
import org.eclipse.collections.impl.map.mutable.primitive.FloatFloatHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractFloatFloatMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableFloatFloatMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableFloatFloatMapTestCase extends AbstractFloatFloatMapTestCase {

    @Override
    protected ImmutableFloatFloatMap classUnderTest() {
        return FloatFloatMaps.immutable.withAll(FloatFloatHashMap.newWithKeysValues(0.0f, 0.0f, 31.0f, 31.0f, 32.0f, 32.0f));
    }

    @Override
    protected ImmutableFloatFloatMap newWithKeysValues(float key1, float value1) {
        return FloatFloatMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableFloatFloatMap newWithKeysValues(float key1, float value1, float key2, float value2) {
        return FloatFloatMaps.immutable.withAll(new FloatFloatHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableFloatFloatMap newWithKeysValues(float key1, float value1, float key2, float value2, float key3, float value3) {
        return FloatFloatMaps.immutable.withAll(new FloatFloatHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableFloatFloatMap newWithKeysValues(float key1, float value1, float key2, float value2, float key3, float value3, float key4, float value4) {
        return FloatFloatMaps.immutable.withAll(new FloatFloatHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableFloatFloatMap getEmptyMap() {
        return FloatFloatMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        FloatFloatMap map1 = this.newWithKeysValues(0.0f, 0.0f, 1.0f, 1.0f, 32.0f, 32.0f);
        FloatFloatMap map2 = this.newWithKeysValues(32.0f, 32.0f, 0.0f, 0.0f, 1.0f, 1.0f);
        FloatFloatMap map3 = this.newWithKeysValues(0.0f, 0.0f, 1.0f, 2.0f, 32.0f, 32.0f);
        FloatFloatMap map4 = this.newWithKeysValues(0.0f, 1.0f, 1.0f, 1.0f, 32.0f, 32.0f);
        FloatFloatMap map5 = this.newWithKeysValues(0.0f, 0.0f, 1.0f, 1.0f, 32.0f, 33.0f);
        FloatFloatMap map6 = this.newWithKeysValues(50.0f, 0.0f, 60.0f, 1.0f, 70.0f, 33.0f);
        FloatFloatMap map7 = this.newWithKeysValues(50.0f, 0.0f, 60.0f, 1.0f);
        FloatFloatMap map8 = this.newWithKeysValues(0.0f, 0.0f, 1.0f, 1.0f);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().keySet().remove(0.0f));
    }

    @Override
    public void values() {
        super.values();
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0.0f));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(FloatFloatMaps.immutable.empty(), FloatFloatMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableFloatFloatEmptyMap.class, FloatFloatMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(FloatFloatMaps.immutable.with(2.0f, 1.0f), this.newWithKeysValues(1.0f, 2.0f).flipUniqueValues());
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(2.0f, 1.0f, 3.0f, 2.0f, 4.0f, 3.0f, 5.0f, 4.0f).toImmutable(), this.newWithKeysValues(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f, 5.0f).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0f, 1.0f, 2.0f, 1.0f).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractFloatFloatMapTestCase._Benchmark {

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
        public abstract AbstractImmutableFloatFloatMapTestCase implementation();
    }
}
