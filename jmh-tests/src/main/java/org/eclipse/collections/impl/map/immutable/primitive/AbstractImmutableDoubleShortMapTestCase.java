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

import org.eclipse.collections.api.map.primitive.DoubleShortMap;
import org.eclipse.collections.api.map.primitive.ImmutableDoubleShortMap;
import org.eclipse.collections.impl.factory.primitive.DoubleShortMaps;
import org.eclipse.collections.impl.factory.primitive.ShortDoubleMaps;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleShortHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.ShortDoubleHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractDoubleShortMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableDoubleShortMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableDoubleShortMapTestCase extends AbstractDoubleShortMapTestCase {

    @Override
    protected ImmutableDoubleShortMap classUnderTest() {
        return DoubleShortMaps.immutable.withAll(DoubleShortHashMap.newWithKeysValues(0.0, (short) 0, 31.0, (short) 31, 32.0, (short) 32));
    }

    @Override
    protected ImmutableDoubleShortMap newWithKeysValues(double key1, short value1) {
        return DoubleShortMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableDoubleShortMap newWithKeysValues(double key1, short value1, double key2, short value2) {
        return DoubleShortMaps.immutable.withAll(new DoubleShortHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableDoubleShortMap newWithKeysValues(double key1, short value1, double key2, short value2, double key3, short value3) {
        return DoubleShortMaps.immutable.withAll(new DoubleShortHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableDoubleShortMap newWithKeysValues(double key1, short value1, double key2, short value2, double key3, short value3, double key4, short value4) {
        return DoubleShortMaps.immutable.withAll(new DoubleShortHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableDoubleShortMap getEmptyMap() {
        return DoubleShortMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        DoubleShortMap map1 = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1, 32.0, (short) 32);
        DoubleShortMap map2 = this.newWithKeysValues(32.0, (short) 32, 0.0, (short) 0, 1.0, (short) 1);
        DoubleShortMap map3 = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 2, 32.0, (short) 32);
        DoubleShortMap map4 = this.newWithKeysValues(0.0, (short) 1, 1.0, (short) 1, 32.0, (short) 32);
        DoubleShortMap map5 = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1, 32.0, (short) 33);
        DoubleShortMap map6 = this.newWithKeysValues(50.0, (short) 0, 60.0, (short) 1, 70.0, (short) 33);
        DoubleShortMap map7 = this.newWithKeysValues(50.0, (short) 0, 60.0, (short) 1);
        DoubleShortMap map8 = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove((short) 0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(ShortDoubleMaps.immutable.empty(), DoubleShortMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableShortDoubleEmptyMap.class, DoubleShortMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(ShortDoubleMaps.immutable.with((short) 2, 1.0), this.newWithKeysValues(1.0, (short) 2).flipUniqueValues());
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 2, 1.0, (short) 3, 2.0, (short) 4, 3.0, (short) 5, 4.0).toImmutable(), this.newWithKeysValues(1.0, (short) 2, 2.0, (short) 3, 3.0, (short) 4, 4.0, (short) 5).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0, (short) 1, 2.0, (short) 1).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractDoubleShortMapTestCase._Benchmark {

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
        public abstract AbstractImmutableDoubleShortMapTestCase implementation();
    }
}
