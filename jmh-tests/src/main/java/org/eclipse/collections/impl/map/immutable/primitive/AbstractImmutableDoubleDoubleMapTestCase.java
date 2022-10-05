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

import org.eclipse.collections.api.map.primitive.DoubleDoubleMap;
import org.eclipse.collections.api.map.primitive.ImmutableDoubleDoubleMap;
import org.eclipse.collections.impl.factory.primitive.DoubleDoubleMaps;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleDoubleHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractDoubleDoubleMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableDoubleDoubleMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableDoubleDoubleMapTestCase extends AbstractDoubleDoubleMapTestCase {

    @Override
    protected ImmutableDoubleDoubleMap classUnderTest() {
        return DoubleDoubleMaps.immutable.withAll(DoubleDoubleHashMap.newWithKeysValues(0.0, 0.0, 31.0, 31.0, 32.0, 32.0));
    }

    @Override
    protected ImmutableDoubleDoubleMap newWithKeysValues(double key1, double value1) {
        return DoubleDoubleMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableDoubleDoubleMap newWithKeysValues(double key1, double value1, double key2, double value2) {
        return DoubleDoubleMaps.immutable.withAll(new DoubleDoubleHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableDoubleDoubleMap newWithKeysValues(double key1, double value1, double key2, double value2, double key3, double value3) {
        return DoubleDoubleMaps.immutable.withAll(new DoubleDoubleHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableDoubleDoubleMap newWithKeysValues(double key1, double value1, double key2, double value2, double key3, double value3, double key4, double value4) {
        return DoubleDoubleMaps.immutable.withAll(new DoubleDoubleHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableDoubleDoubleMap getEmptyMap() {
        return DoubleDoubleMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        DoubleDoubleMap map1 = this.newWithKeysValues(0.0, 0.0, 1.0, 1.0, 32.0, 32.0);
        DoubleDoubleMap map2 = this.newWithKeysValues(32.0, 32.0, 0.0, 0.0, 1.0, 1.0);
        DoubleDoubleMap map3 = this.newWithKeysValues(0.0, 0.0, 1.0, 2.0, 32.0, 32.0);
        DoubleDoubleMap map4 = this.newWithKeysValues(0.0, 1.0, 1.0, 1.0, 32.0, 32.0);
        DoubleDoubleMap map5 = this.newWithKeysValues(0.0, 0.0, 1.0, 1.0, 32.0, 33.0);
        DoubleDoubleMap map6 = this.newWithKeysValues(50.0, 0.0, 60.0, 1.0, 70.0, 33.0);
        DoubleDoubleMap map7 = this.newWithKeysValues(50.0, 0.0, 60.0, 1.0);
        DoubleDoubleMap map8 = this.newWithKeysValues(0.0, 0.0, 1.0, 1.0);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0.0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(DoubleDoubleMaps.immutable.empty(), DoubleDoubleMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableDoubleDoubleEmptyMap.class, DoubleDoubleMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(DoubleDoubleMaps.immutable.with(2.0, 1.0), this.newWithKeysValues(1.0, 2.0).flipUniqueValues());
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(2.0, 1.0, 3.0, 2.0, 4.0, 3.0, 5.0, 4.0).toImmutable(), this.newWithKeysValues(1.0, 2.0, 2.0, 3.0, 3.0, 4.0, 4.0, 5.0).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0, 1.0, 2.0, 1.0).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractDoubleDoubleMapTestCase._Benchmark {

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
        public abstract AbstractImmutableDoubleDoubleMapTestCase implementation();
    }
}
