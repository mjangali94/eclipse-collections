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

import org.eclipse.collections.api.map.primitive.DoubleIntMap;
import org.eclipse.collections.api.map.primitive.ImmutableDoubleIntMap;
import org.eclipse.collections.impl.factory.primitive.DoubleIntMaps;
import org.eclipse.collections.impl.factory.primitive.IntDoubleMaps;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleIntHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntDoubleHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractDoubleIntMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableDoubleIntMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableDoubleIntMapTestCase extends AbstractDoubleIntMapTestCase {

    @Override
    protected ImmutableDoubleIntMap classUnderTest() {
        return DoubleIntMaps.immutable.withAll(DoubleIntHashMap.newWithKeysValues(0.0, 0, 31.0, 31, 32.0, 32));
    }

    @Override
    protected ImmutableDoubleIntMap newWithKeysValues(double key1, int value1) {
        return DoubleIntMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableDoubleIntMap newWithKeysValues(double key1, int value1, double key2, int value2) {
        return DoubleIntMaps.immutable.withAll(new DoubleIntHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableDoubleIntMap newWithKeysValues(double key1, int value1, double key2, int value2, double key3, int value3) {
        return DoubleIntMaps.immutable.withAll(new DoubleIntHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableDoubleIntMap newWithKeysValues(double key1, int value1, double key2, int value2, double key3, int value3, double key4, int value4) {
        return DoubleIntMaps.immutable.withAll(new DoubleIntHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableDoubleIntMap getEmptyMap() {
        return DoubleIntMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        DoubleIntMap map1 = this.newWithKeysValues(0.0, 0, 1.0, 1, 32.0, 32);
        DoubleIntMap map2 = this.newWithKeysValues(32.0, 32, 0.0, 0, 1.0, 1);
        DoubleIntMap map3 = this.newWithKeysValues(0.0, 0, 1.0, 2, 32.0, 32);
        DoubleIntMap map4 = this.newWithKeysValues(0.0, 1, 1.0, 1, 32.0, 32);
        DoubleIntMap map5 = this.newWithKeysValues(0.0, 0, 1.0, 1, 32.0, 33);
        DoubleIntMap map6 = this.newWithKeysValues(50.0, 0, 60.0, 1, 70.0, 33);
        DoubleIntMap map7 = this.newWithKeysValues(50.0, 0, 60.0, 1);
        DoubleIntMap map8 = this.newWithKeysValues(0.0, 0, 1.0, 1);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().keySet().remove(0.0));
    }

    @Override
    public void values() {
        super.values();
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(IntDoubleMaps.immutable.empty(), DoubleIntMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableIntDoubleEmptyMap.class, DoubleIntMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(IntDoubleMaps.immutable.with(2, 1.0), this.newWithKeysValues(1.0, 2).flipUniqueValues());
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(2, 1.0, 3, 2.0, 4, 3.0, 5, 4.0).toImmutable(), this.newWithKeysValues(1.0, 2, 2.0, 3, 3.0, 4, 4.0, 5).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0, 1, 2.0, 1).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractDoubleIntMapTestCase._Benchmark {

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
        public abstract AbstractImmutableDoubleIntMapTestCase implementation();
    }
}
