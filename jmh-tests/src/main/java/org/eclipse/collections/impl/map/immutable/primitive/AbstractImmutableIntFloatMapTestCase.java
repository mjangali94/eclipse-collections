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

import org.eclipse.collections.api.map.primitive.IntFloatMap;
import org.eclipse.collections.api.map.primitive.ImmutableIntFloatMap;
import org.eclipse.collections.impl.factory.primitive.IntFloatMaps;
import org.eclipse.collections.impl.factory.primitive.FloatIntMaps;
import org.eclipse.collections.impl.map.mutable.primitive.IntFloatHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.FloatIntHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractIntFloatMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableIntFloatMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableIntFloatMapTestCase extends AbstractIntFloatMapTestCase {

    @Override
    protected ImmutableIntFloatMap classUnderTest() {
        return IntFloatMaps.immutable.withAll(IntFloatHashMap.newWithKeysValues(0, 0.0f, 31, 31.0f, 32, 32.0f));
    }

    @Override
    protected ImmutableIntFloatMap newWithKeysValues(int key1, float value1) {
        return IntFloatMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableIntFloatMap newWithKeysValues(int key1, float value1, int key2, float value2) {
        return IntFloatMaps.immutable.withAll(new IntFloatHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableIntFloatMap newWithKeysValues(int key1, float value1, int key2, float value2, int key3, float value3) {
        return IntFloatMaps.immutable.withAll(new IntFloatHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableIntFloatMap newWithKeysValues(int key1, float value1, int key2, float value2, int key3, float value3, int key4, float value4) {
        return IntFloatMaps.immutable.withAll(new IntFloatHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableIntFloatMap getEmptyMap() {
        return IntFloatMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        IntFloatMap map1 = this.newWithKeysValues(0, 0.0f, 1, 1.0f, 32, 32.0f);
        IntFloatMap map2 = this.newWithKeysValues(32, 32.0f, 0, 0.0f, 1, 1.0f);
        IntFloatMap map3 = this.newWithKeysValues(0, 0.0f, 1, 2.0f, 32, 32.0f);
        IntFloatMap map4 = this.newWithKeysValues(0, 1.0f, 1, 1.0f, 32, 32.0f);
        IntFloatMap map5 = this.newWithKeysValues(0, 0.0f, 1, 1.0f, 32, 33.0f);
        IntFloatMap map6 = this.newWithKeysValues(50, 0.0f, 60, 1.0f, 70, 33.0f);
        IntFloatMap map7 = this.newWithKeysValues(50, 0.0f, 60, 1.0f);
        IntFloatMap map8 = this.newWithKeysValues(0, 0.0f, 1, 1.0f);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().keySet().remove(0));
    }

    @Override
    public void values() {
        super.values();
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0.0f));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(FloatIntMaps.immutable.empty(), IntFloatMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableFloatIntEmptyMap.class, IntFloatMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(FloatIntMaps.immutable.with(2.0f, 1), this.newWithKeysValues(1, 2.0f).flipUniqueValues());
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(2.0f, 1, 3.0f, 2, 4.0f, 3, 5.0f, 4).toImmutable(), this.newWithKeysValues(1, 2.0f, 2, 3.0f, 3, 4.0f, 4, 5.0f).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1, 1.0f, 2, 1.0f).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractIntFloatMapTestCase._Benchmark {

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
        public abstract AbstractImmutableIntFloatMapTestCase implementation();
    }
}
