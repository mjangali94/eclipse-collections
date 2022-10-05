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

import org.eclipse.collections.api.map.primitive.FloatLongMap;
import org.eclipse.collections.api.map.primitive.ImmutableFloatLongMap;
import org.eclipse.collections.impl.factory.primitive.FloatLongMaps;
import org.eclipse.collections.impl.factory.primitive.LongFloatMaps;
import org.eclipse.collections.impl.map.mutable.primitive.FloatLongHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.LongFloatHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractFloatLongMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableFloatLongMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableFloatLongMapTestCase extends AbstractFloatLongMapTestCase {

    @Override
    protected ImmutableFloatLongMap classUnderTest() {
        return FloatLongMaps.immutable.withAll(FloatLongHashMap.newWithKeysValues(0.0f, 0L, 31.0f, 31L, 32.0f, 32L));
    }

    @Override
    protected ImmutableFloatLongMap newWithKeysValues(float key1, long value1) {
        return FloatLongMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableFloatLongMap newWithKeysValues(float key1, long value1, float key2, long value2) {
        return FloatLongMaps.immutable.withAll(new FloatLongHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableFloatLongMap newWithKeysValues(float key1, long value1, float key2, long value2, float key3, long value3) {
        return FloatLongMaps.immutable.withAll(new FloatLongHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableFloatLongMap newWithKeysValues(float key1, long value1, float key2, long value2, float key3, long value3, float key4, long value4) {
        return FloatLongMaps.immutable.withAll(new FloatLongHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableFloatLongMap getEmptyMap() {
        return FloatLongMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        FloatLongMap map1 = this.newWithKeysValues(0.0f, 0L, 1.0f, 1L, 32.0f, 32L);
        FloatLongMap map2 = this.newWithKeysValues(32.0f, 32L, 0.0f, 0L, 1.0f, 1L);
        FloatLongMap map3 = this.newWithKeysValues(0.0f, 0L, 1.0f, 2L, 32.0f, 32L);
        FloatLongMap map4 = this.newWithKeysValues(0.0f, 1L, 1.0f, 1L, 32.0f, 32L);
        FloatLongMap map5 = this.newWithKeysValues(0.0f, 0L, 1.0f, 1L, 32.0f, 33L);
        FloatLongMap map6 = this.newWithKeysValues(50.0f, 0L, 60.0f, 1L, 70.0f, 33L);
        FloatLongMap map7 = this.newWithKeysValues(50.0f, 0L, 60.0f, 1L);
        FloatLongMap map8 = this.newWithKeysValues(0.0f, 0L, 1.0f, 1L);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0L));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(LongFloatMaps.immutable.empty(), FloatLongMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableLongFloatEmptyMap.class, FloatLongMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(LongFloatMaps.immutable.with(2L, 1.0f), this.newWithKeysValues(1.0f, 2L).flipUniqueValues());
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(2L, 1.0f, 3L, 2.0f, 4L, 3.0f, 5L, 4.0f).toImmutable(), this.newWithKeysValues(1.0f, 2L, 2.0f, 3L, 3.0f, 4L, 4.0f, 5L).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0f, 1L, 2.0f, 1L).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractFloatLongMapTestCase._Benchmark {

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
        public abstract AbstractImmutableFloatLongMapTestCase implementation();
    }
}
