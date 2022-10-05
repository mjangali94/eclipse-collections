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

import org.eclipse.collections.api.map.primitive.FloatShortMap;
import org.eclipse.collections.api.map.primitive.ImmutableFloatShortMap;
import org.eclipse.collections.impl.factory.primitive.FloatShortMaps;
import org.eclipse.collections.impl.factory.primitive.ShortFloatMaps;
import org.eclipse.collections.impl.map.mutable.primitive.FloatShortHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.ShortFloatHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractFloatShortMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableFloatShortMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableFloatShortMapTestCase extends AbstractFloatShortMapTestCase {

    @Override
    protected ImmutableFloatShortMap classUnderTest() {
        return FloatShortMaps.immutable.withAll(FloatShortHashMap.newWithKeysValues(0.0f, (short) 0, 31.0f, (short) 31, 32.0f, (short) 32));
    }

    @Override
    protected ImmutableFloatShortMap newWithKeysValues(float key1, short value1) {
        return FloatShortMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableFloatShortMap newWithKeysValues(float key1, short value1, float key2, short value2) {
        return FloatShortMaps.immutable.withAll(new FloatShortHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableFloatShortMap newWithKeysValues(float key1, short value1, float key2, short value2, float key3, short value3) {
        return FloatShortMaps.immutable.withAll(new FloatShortHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableFloatShortMap newWithKeysValues(float key1, short value1, float key2, short value2, float key3, short value3, float key4, short value4) {
        return FloatShortMaps.immutable.withAll(new FloatShortHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableFloatShortMap getEmptyMap() {
        return FloatShortMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        FloatShortMap map1 = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1, 32.0f, (short) 32);
        FloatShortMap map2 = this.newWithKeysValues(32.0f, (short) 32, 0.0f, (short) 0, 1.0f, (short) 1);
        FloatShortMap map3 = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 2, 32.0f, (short) 32);
        FloatShortMap map4 = this.newWithKeysValues(0.0f, (short) 1, 1.0f, (short) 1, 32.0f, (short) 32);
        FloatShortMap map5 = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1, 32.0f, (short) 33);
        FloatShortMap map6 = this.newWithKeysValues(50.0f, (short) 0, 60.0f, (short) 1, 70.0f, (short) 33);
        FloatShortMap map7 = this.newWithKeysValues(50.0f, (short) 0, 60.0f, (short) 1);
        FloatShortMap map8 = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove((short) 0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(ShortFloatMaps.immutable.empty(), FloatShortMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableShortFloatEmptyMap.class, FloatShortMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(ShortFloatMaps.immutable.with((short) 2, 1.0f), this.newWithKeysValues(1.0f, (short) 2).flipUniqueValues());
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 2, 1.0f, (short) 3, 2.0f, (short) 4, 3.0f, (short) 5, 4.0f).toImmutable(), this.newWithKeysValues(1.0f, (short) 2, 2.0f, (short) 3, 3.0f, (short) 4, 4.0f, (short) 5).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0f, (short) 1, 2.0f, (short) 1).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractFloatShortMapTestCase._Benchmark {

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
        public abstract AbstractImmutableFloatShortMapTestCase implementation();
    }
}
