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

import org.eclipse.collections.api.map.primitive.ShortDoubleMap;
import org.eclipse.collections.api.map.primitive.ImmutableShortDoubleMap;
import org.eclipse.collections.impl.factory.primitive.ShortDoubleMaps;
import org.eclipse.collections.impl.factory.primitive.DoubleShortMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ShortDoubleHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleShortHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractShortDoubleMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableShortDoubleMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableShortDoubleMapTestCase extends AbstractShortDoubleMapTestCase {

    @Override
    protected ImmutableShortDoubleMap classUnderTest() {
        return ShortDoubleMaps.immutable.withAll(ShortDoubleHashMap.newWithKeysValues((short) 0, 0.0, (short) 31, 31.0, (short) 32, 32.0));
    }

    @Override
    protected ImmutableShortDoubleMap newWithKeysValues(short key1, double value1) {
        return ShortDoubleMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableShortDoubleMap newWithKeysValues(short key1, double value1, short key2, double value2) {
        return ShortDoubleMaps.immutable.withAll(new ShortDoubleHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableShortDoubleMap newWithKeysValues(short key1, double value1, short key2, double value2, short key3, double value3) {
        return ShortDoubleMaps.immutable.withAll(new ShortDoubleHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableShortDoubleMap newWithKeysValues(short key1, double value1, short key2, double value2, short key3, double value3, short key4, double value4) {
        return ShortDoubleMaps.immutable.withAll(new ShortDoubleHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableShortDoubleMap getEmptyMap() {
        return ShortDoubleMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        ShortDoubleMap map1 = this.newWithKeysValues((short) 0, 0.0, (short) 1, 1.0, (short) 32, 32.0);
        ShortDoubleMap map2 = this.newWithKeysValues((short) 32, 32.0, (short) 0, 0.0, (short) 1, 1.0);
        ShortDoubleMap map3 = this.newWithKeysValues((short) 0, 0.0, (short) 1, 2.0, (short) 32, 32.0);
        ShortDoubleMap map4 = this.newWithKeysValues((short) 0, 1.0, (short) 1, 1.0, (short) 32, 32.0);
        ShortDoubleMap map5 = this.newWithKeysValues((short) 0, 0.0, (short) 1, 1.0, (short) 32, 33.0);
        ShortDoubleMap map6 = this.newWithKeysValues((short) 50, 0.0, (short) 60, 1.0, (short) 70, 33.0);
        ShortDoubleMap map7 = this.newWithKeysValues((short) 50, 0.0, (short) 60, 1.0);
        ShortDoubleMap map8 = this.newWithKeysValues((short) 0, 0.0, (short) 1, 1.0);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().keySet().remove((short) 0));
    }

    @Override
    public void values() {
        super.values();
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0.0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(DoubleShortMaps.immutable.empty(), ShortDoubleMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableDoubleShortEmptyMap.class, ShortDoubleMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(DoubleShortMaps.immutable.with(2.0, (short) 1), this.newWithKeysValues((short) 1, 2.0).flipUniqueValues());
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(2.0, (short) 1, 3.0, (short) 2, 4.0, (short) 3, 5.0, (short) 4).toImmutable(), this.newWithKeysValues((short) 1, 2.0, (short) 2, 3.0, (short) 3, 4.0, (short) 4, 5.0).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((short) 1, 1.0, (short) 2, 1.0).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractShortDoubleMapTestCase._Benchmark {

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
        public abstract AbstractImmutableShortDoubleMapTestCase implementation();
    }
}
