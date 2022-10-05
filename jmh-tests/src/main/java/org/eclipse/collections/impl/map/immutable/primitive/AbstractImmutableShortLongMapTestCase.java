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

import org.eclipse.collections.api.map.primitive.ShortLongMap;
import org.eclipse.collections.api.map.primitive.ImmutableShortLongMap;
import org.eclipse.collections.impl.factory.primitive.ShortLongMaps;
import org.eclipse.collections.impl.factory.primitive.LongShortMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ShortLongHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.LongShortHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractShortLongMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableShortLongMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableShortLongMapTestCase extends AbstractShortLongMapTestCase {

    @Override
    protected ImmutableShortLongMap classUnderTest() {
        return ShortLongMaps.immutable.withAll(ShortLongHashMap.newWithKeysValues((short) 0, 0L, (short) 31, 31L, (short) 32, 32L));
    }

    @Override
    protected ImmutableShortLongMap newWithKeysValues(short key1, long value1) {
        return ShortLongMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableShortLongMap newWithKeysValues(short key1, long value1, short key2, long value2) {
        return ShortLongMaps.immutable.withAll(new ShortLongHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableShortLongMap newWithKeysValues(short key1, long value1, short key2, long value2, short key3, long value3) {
        return ShortLongMaps.immutable.withAll(new ShortLongHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableShortLongMap newWithKeysValues(short key1, long value1, short key2, long value2, short key3, long value3, short key4, long value4) {
        return ShortLongMaps.immutable.withAll(new ShortLongHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableShortLongMap getEmptyMap() {
        return ShortLongMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        ShortLongMap map1 = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L, (short) 32, 32L);
        ShortLongMap map2 = this.newWithKeysValues((short) 32, 32L, (short) 0, 0L, (short) 1, 1L);
        ShortLongMap map3 = this.newWithKeysValues((short) 0, 0L, (short) 1, 2L, (short) 32, 32L);
        ShortLongMap map4 = this.newWithKeysValues((short) 0, 1L, (short) 1, 1L, (short) 32, 32L);
        ShortLongMap map5 = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L, (short) 32, 33L);
        ShortLongMap map6 = this.newWithKeysValues((short) 50, 0L, (short) 60, 1L, (short) 70, 33L);
        ShortLongMap map7 = this.newWithKeysValues((short) 50, 0L, (short) 60, 1L);
        ShortLongMap map8 = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0L));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(LongShortMaps.immutable.empty(), ShortLongMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableLongShortEmptyMap.class, ShortLongMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(LongShortMaps.immutable.with(2L, (short) 1), this.newWithKeysValues((short) 1, 2L).flipUniqueValues());
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(2L, (short) 1, 3L, (short) 2, 4L, (short) 3, 5L, (short) 4).toImmutable(), this.newWithKeysValues((short) 1, 2L, (short) 2, 3L, (short) 3, 4L, (short) 4, 5L).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((short) 1, 1L, (short) 2, 1L).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractShortLongMapTestCase._Benchmark {

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
        public abstract AbstractImmutableShortLongMapTestCase implementation();
    }
}
