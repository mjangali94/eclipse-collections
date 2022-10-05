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

import org.eclipse.collections.api.map.primitive.LongFloatMap;
import org.eclipse.collections.api.map.primitive.ImmutableLongFloatMap;
import org.eclipse.collections.impl.factory.primitive.LongFloatMaps;
import org.eclipse.collections.impl.factory.primitive.FloatLongMaps;
import org.eclipse.collections.impl.map.mutable.primitive.LongFloatHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.FloatLongHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractLongFloatMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableLongFloatMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableLongFloatMapTestCase extends AbstractLongFloatMapTestCase {

    @Override
    protected ImmutableLongFloatMap classUnderTest() {
        return LongFloatMaps.immutable.withAll(LongFloatHashMap.newWithKeysValues(0L, 0.0f, 31L, 31.0f, 32L, 32.0f));
    }

    @Override
    protected ImmutableLongFloatMap newWithKeysValues(long key1, float value1) {
        return LongFloatMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableLongFloatMap newWithKeysValues(long key1, float value1, long key2, float value2) {
        return LongFloatMaps.immutable.withAll(new LongFloatHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableLongFloatMap newWithKeysValues(long key1, float value1, long key2, float value2, long key3, float value3) {
        return LongFloatMaps.immutable.withAll(new LongFloatHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableLongFloatMap newWithKeysValues(long key1, float value1, long key2, float value2, long key3, float value3, long key4, float value4) {
        return LongFloatMaps.immutable.withAll(new LongFloatHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableLongFloatMap getEmptyMap() {
        return LongFloatMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        LongFloatMap map1 = this.newWithKeysValues(0L, 0.0f, 1L, 1.0f, 32L, 32.0f);
        LongFloatMap map2 = this.newWithKeysValues(32L, 32.0f, 0L, 0.0f, 1L, 1.0f);
        LongFloatMap map3 = this.newWithKeysValues(0L, 0.0f, 1L, 2.0f, 32L, 32.0f);
        LongFloatMap map4 = this.newWithKeysValues(0L, 1.0f, 1L, 1.0f, 32L, 32.0f);
        LongFloatMap map5 = this.newWithKeysValues(0L, 0.0f, 1L, 1.0f, 32L, 33.0f);
        LongFloatMap map6 = this.newWithKeysValues(50L, 0.0f, 60L, 1.0f, 70L, 33.0f);
        LongFloatMap map7 = this.newWithKeysValues(50L, 0.0f, 60L, 1.0f);
        LongFloatMap map8 = this.newWithKeysValues(0L, 0.0f, 1L, 1.0f);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().keySet().remove(0L));
    }

    @Override
    public void values() {
        super.values();
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0.0f));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(FloatLongMaps.immutable.empty(), LongFloatMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableFloatLongEmptyMap.class, LongFloatMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(FloatLongMaps.immutable.with(2.0f, 1L), this.newWithKeysValues(1L, 2.0f).flipUniqueValues());
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(2.0f, 1L, 3.0f, 2L, 4.0f, 3L, 5.0f, 4L).toImmutable(), this.newWithKeysValues(1L, 2.0f, 2L, 3.0f, 3L, 4.0f, 4L, 5.0f).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1L, 1.0f, 2L, 1.0f).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractLongFloatMapTestCase._Benchmark {

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
        public abstract AbstractImmutableLongFloatMapTestCase implementation();
    }
}
