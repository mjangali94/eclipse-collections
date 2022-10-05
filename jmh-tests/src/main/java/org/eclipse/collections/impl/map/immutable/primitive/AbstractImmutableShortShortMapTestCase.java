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

import org.eclipse.collections.api.map.primitive.ShortShortMap;
import org.eclipse.collections.api.map.primitive.ImmutableShortShortMap;
import org.eclipse.collections.impl.factory.primitive.ShortShortMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ShortShortHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractShortShortMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableShortShortMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableShortShortMapTestCase extends AbstractShortShortMapTestCase {

    @Override
    protected ImmutableShortShortMap classUnderTest() {
        return ShortShortMaps.immutable.withAll(ShortShortHashMap.newWithKeysValues((short) 0, (short) 0, (short) 31, (short) 31, (short) 32, (short) 32));
    }

    @Override
    protected ImmutableShortShortMap newWithKeysValues(short key1, short value1) {
        return ShortShortMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableShortShortMap newWithKeysValues(short key1, short value1, short key2, short value2) {
        return ShortShortMaps.immutable.withAll(new ShortShortHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableShortShortMap newWithKeysValues(short key1, short value1, short key2, short value2, short key3, short value3) {
        return ShortShortMaps.immutable.withAll(new ShortShortHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableShortShortMap newWithKeysValues(short key1, short value1, short key2, short value2, short key3, short value3, short key4, short value4) {
        return ShortShortMaps.immutable.withAll(new ShortShortHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableShortShortMap getEmptyMap() {
        return ShortShortMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        ShortShortMap map1 = this.newWithKeysValues((short) 0, (short) 0, (short) 1, (short) 1, (short) 32, (short) 32);
        ShortShortMap map2 = this.newWithKeysValues((short) 32, (short) 32, (short) 0, (short) 0, (short) 1, (short) 1);
        ShortShortMap map3 = this.newWithKeysValues((short) 0, (short) 0, (short) 1, (short) 2, (short) 32, (short) 32);
        ShortShortMap map4 = this.newWithKeysValues((short) 0, (short) 1, (short) 1, (short) 1, (short) 32, (short) 32);
        ShortShortMap map5 = this.newWithKeysValues((short) 0, (short) 0, (short) 1, (short) 1, (short) 32, (short) 33);
        ShortShortMap map6 = this.newWithKeysValues((short) 50, (short) 0, (short) 60, (short) 1, (short) 70, (short) 33);
        ShortShortMap map7 = this.newWithKeysValues((short) 50, (short) 0, (short) 60, (short) 1);
        ShortShortMap map8 = this.newWithKeysValues((short) 0, (short) 0, (short) 1, (short) 1);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove((short) 0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(ShortShortMaps.immutable.empty(), ShortShortMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableShortShortEmptyMap.class, ShortShortMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(ShortShortMaps.immutable.with((short) 2, (short) 1), this.newWithKeysValues((short) 1, (short) 2).flipUniqueValues());
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 2, (short) 1, (short) 3, (short) 2, (short) 4, (short) 3, (short) 5, (short) 4).toImmutable(), this.newWithKeysValues((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 4, (short) 4, (short) 5).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((short) 1, (short) 1, (short) 2, (short) 1).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractShortShortMapTestCase._Benchmark {

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
        public abstract AbstractImmutableShortShortMapTestCase implementation();
    }
}
