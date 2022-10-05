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

import org.eclipse.collections.api.map.primitive.LongShortMap;
import org.eclipse.collections.api.map.primitive.ImmutableLongShortMap;
import org.eclipse.collections.impl.factory.primitive.LongShortMaps;
import org.eclipse.collections.impl.factory.primitive.ShortLongMaps;
import org.eclipse.collections.impl.map.mutable.primitive.LongShortHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.ShortLongHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractLongShortMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableLongShortMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableLongShortMapTestCase extends AbstractLongShortMapTestCase {

    @Override
    protected ImmutableLongShortMap classUnderTest() {
        return LongShortMaps.immutable.withAll(LongShortHashMap.newWithKeysValues(0L, (short) 0, 31L, (short) 31, 32L, (short) 32));
    }

    @Override
    protected ImmutableLongShortMap newWithKeysValues(long key1, short value1) {
        return LongShortMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableLongShortMap newWithKeysValues(long key1, short value1, long key2, short value2) {
        return LongShortMaps.immutable.withAll(new LongShortHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableLongShortMap newWithKeysValues(long key1, short value1, long key2, short value2, long key3, short value3) {
        return LongShortMaps.immutable.withAll(new LongShortHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableLongShortMap newWithKeysValues(long key1, short value1, long key2, short value2, long key3, short value3, long key4, short value4) {
        return LongShortMaps.immutable.withAll(new LongShortHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableLongShortMap getEmptyMap() {
        return LongShortMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        LongShortMap map1 = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1, 32L, (short) 32);
        LongShortMap map2 = this.newWithKeysValues(32L, (short) 32, 0L, (short) 0, 1L, (short) 1);
        LongShortMap map3 = this.newWithKeysValues(0L, (short) 0, 1L, (short) 2, 32L, (short) 32);
        LongShortMap map4 = this.newWithKeysValues(0L, (short) 1, 1L, (short) 1, 32L, (short) 32);
        LongShortMap map5 = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1, 32L, (short) 33);
        LongShortMap map6 = this.newWithKeysValues(50L, (short) 0, 60L, (short) 1, 70L, (short) 33);
        LongShortMap map7 = this.newWithKeysValues(50L, (short) 0, 60L, (short) 1);
        LongShortMap map8 = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove((short) 0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(ShortLongMaps.immutable.empty(), LongShortMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableShortLongEmptyMap.class, LongShortMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(ShortLongMaps.immutable.with((short) 2, 1L), this.newWithKeysValues(1L, (short) 2).flipUniqueValues());
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 2, 1L, (short) 3, 2L, (short) 4, 3L, (short) 5, 4L).toImmutable(), this.newWithKeysValues(1L, (short) 2, 2L, (short) 3, 3L, (short) 4, 4L, (short) 5).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1L, (short) 1, 2L, (short) 1).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractLongShortMapTestCase._Benchmark {

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
        public abstract AbstractImmutableLongShortMapTestCase implementation();
    }
}
