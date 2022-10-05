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

import org.eclipse.collections.api.map.primitive.FloatIntMap;
import org.eclipse.collections.api.map.primitive.ImmutableFloatIntMap;
import org.eclipse.collections.impl.factory.primitive.FloatIntMaps;
import org.eclipse.collections.impl.factory.primitive.IntFloatMaps;
import org.eclipse.collections.impl.map.mutable.primitive.FloatIntHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntFloatHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractFloatIntMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableFloatIntMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableFloatIntMapTestCase extends AbstractFloatIntMapTestCase {

    @Override
    protected ImmutableFloatIntMap classUnderTest() {
        return FloatIntMaps.immutable.withAll(FloatIntHashMap.newWithKeysValues(0.0f, 0, 31.0f, 31, 32.0f, 32));
    }

    @Override
    protected ImmutableFloatIntMap newWithKeysValues(float key1, int value1) {
        return FloatIntMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableFloatIntMap newWithKeysValues(float key1, int value1, float key2, int value2) {
        return FloatIntMaps.immutable.withAll(new FloatIntHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableFloatIntMap newWithKeysValues(float key1, int value1, float key2, int value2, float key3, int value3) {
        return FloatIntMaps.immutable.withAll(new FloatIntHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableFloatIntMap newWithKeysValues(float key1, int value1, float key2, int value2, float key3, int value3, float key4, int value4) {
        return FloatIntMaps.immutable.withAll(new FloatIntHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableFloatIntMap getEmptyMap() {
        return FloatIntMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        FloatIntMap map1 = this.newWithKeysValues(0.0f, 0, 1.0f, 1, 32.0f, 32);
        FloatIntMap map2 = this.newWithKeysValues(32.0f, 32, 0.0f, 0, 1.0f, 1);
        FloatIntMap map3 = this.newWithKeysValues(0.0f, 0, 1.0f, 2, 32.0f, 32);
        FloatIntMap map4 = this.newWithKeysValues(0.0f, 1, 1.0f, 1, 32.0f, 32);
        FloatIntMap map5 = this.newWithKeysValues(0.0f, 0, 1.0f, 1, 32.0f, 33);
        FloatIntMap map6 = this.newWithKeysValues(50.0f, 0, 60.0f, 1, 70.0f, 33);
        FloatIntMap map7 = this.newWithKeysValues(50.0f, 0, 60.0f, 1);
        FloatIntMap map8 = this.newWithKeysValues(0.0f, 0, 1.0f, 1);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(IntFloatMaps.immutable.empty(), FloatIntMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableIntFloatEmptyMap.class, FloatIntMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(IntFloatMaps.immutable.with(2, 1.0f), this.newWithKeysValues(1.0f, 2).flipUniqueValues());
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(2, 1.0f, 3, 2.0f, 4, 3.0f, 5, 4.0f).toImmutable(), this.newWithKeysValues(1.0f, 2, 2.0f, 3, 3.0f, 4, 4.0f, 5).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0f, 1, 2.0f, 1).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractFloatIntMapTestCase._Benchmark {

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
        public abstract AbstractImmutableFloatIntMapTestCase implementation();
    }
}
