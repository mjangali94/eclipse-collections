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

import org.eclipse.collections.api.map.primitive.LongLongMap;
import org.eclipse.collections.api.map.primitive.ImmutableLongLongMap;
import org.eclipse.collections.impl.factory.primitive.LongLongMaps;
import org.eclipse.collections.impl.map.mutable.primitive.LongLongHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractLongLongMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableLongLongMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableLongLongMapTestCase extends AbstractLongLongMapTestCase {

    @Override
    protected ImmutableLongLongMap classUnderTest() {
        return LongLongMaps.immutable.withAll(LongLongHashMap.newWithKeysValues(0L, 0L, 31L, 31L, 32L, 32L));
    }

    @Override
    protected ImmutableLongLongMap newWithKeysValues(long key1, long value1) {
        return LongLongMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableLongLongMap newWithKeysValues(long key1, long value1, long key2, long value2) {
        return LongLongMaps.immutable.withAll(new LongLongHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableLongLongMap newWithKeysValues(long key1, long value1, long key2, long value2, long key3, long value3) {
        return LongLongMaps.immutable.withAll(new LongLongHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableLongLongMap newWithKeysValues(long key1, long value1, long key2, long value2, long key3, long value3, long key4, long value4) {
        return LongLongMaps.immutable.withAll(new LongLongHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableLongLongMap getEmptyMap() {
        return LongLongMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        LongLongMap map1 = this.newWithKeysValues(0L, 0L, 1L, 1L, 32L, 32L);
        LongLongMap map2 = this.newWithKeysValues(32L, 32L, 0L, 0L, 1L, 1L);
        LongLongMap map3 = this.newWithKeysValues(0L, 0L, 1L, 2L, 32L, 32L);
        LongLongMap map4 = this.newWithKeysValues(0L, 1L, 1L, 1L, 32L, 32L);
        LongLongMap map5 = this.newWithKeysValues(0L, 0L, 1L, 1L, 32L, 33L);
        LongLongMap map6 = this.newWithKeysValues(50L, 0L, 60L, 1L, 70L, 33L);
        LongLongMap map7 = this.newWithKeysValues(50L, 0L, 60L, 1L);
        LongLongMap map8 = this.newWithKeysValues(0L, 0L, 1L, 1L);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0L));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(LongLongMaps.immutable.empty(), LongLongMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableLongLongEmptyMap.class, LongLongMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(LongLongMaps.immutable.with(2L, 1L), this.newWithKeysValues(1L, 2L).flipUniqueValues());
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(2L, 1L, 3L, 2L, 4L, 3L, 5L, 4L).toImmutable(), this.newWithKeysValues(1L, 2L, 2L, 3L, 3L, 4L, 4L, 5L).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1L, 1L, 2L, 1L).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractLongLongMapTestCase._Benchmark {

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
        public abstract AbstractImmutableLongLongMapTestCase implementation();
    }
}
