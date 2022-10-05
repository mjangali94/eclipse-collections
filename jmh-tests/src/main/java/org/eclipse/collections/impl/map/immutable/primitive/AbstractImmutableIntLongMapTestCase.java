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

import org.eclipse.collections.api.map.primitive.IntLongMap;
import org.eclipse.collections.api.map.primitive.ImmutableIntLongMap;
import org.eclipse.collections.impl.factory.primitive.IntLongMaps;
import org.eclipse.collections.impl.factory.primitive.LongIntMaps;
import org.eclipse.collections.impl.map.mutable.primitive.IntLongHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.LongIntHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractIntLongMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableIntLongMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableIntLongMapTestCase extends AbstractIntLongMapTestCase {

    @Override
    protected ImmutableIntLongMap classUnderTest() {
        return IntLongMaps.immutable.withAll(IntLongHashMap.newWithKeysValues(0, 0L, 31, 31L, 32, 32L));
    }

    @Override
    protected ImmutableIntLongMap newWithKeysValues(int key1, long value1) {
        return IntLongMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableIntLongMap newWithKeysValues(int key1, long value1, int key2, long value2) {
        return IntLongMaps.immutable.withAll(new IntLongHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableIntLongMap newWithKeysValues(int key1, long value1, int key2, long value2, int key3, long value3) {
        return IntLongMaps.immutable.withAll(new IntLongHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableIntLongMap newWithKeysValues(int key1, long value1, int key2, long value2, int key3, long value3, int key4, long value4) {
        return IntLongMaps.immutable.withAll(new IntLongHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableIntLongMap getEmptyMap() {
        return IntLongMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        IntLongMap map1 = this.newWithKeysValues(0, 0L, 1, 1L, 32, 32L);
        IntLongMap map2 = this.newWithKeysValues(32, 32L, 0, 0L, 1, 1L);
        IntLongMap map3 = this.newWithKeysValues(0, 0L, 1, 2L, 32, 32L);
        IntLongMap map4 = this.newWithKeysValues(0, 1L, 1, 1L, 32, 32L);
        IntLongMap map5 = this.newWithKeysValues(0, 0L, 1, 1L, 32, 33L);
        IntLongMap map6 = this.newWithKeysValues(50, 0L, 60, 1L, 70, 33L);
        IntLongMap map7 = this.newWithKeysValues(50, 0L, 60, 1L);
        IntLongMap map8 = this.newWithKeysValues(0, 0L, 1, 1L);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0L));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(LongIntMaps.immutable.empty(), IntLongMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableLongIntEmptyMap.class, IntLongMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(LongIntMaps.immutable.with(2L, 1), this.newWithKeysValues(1, 2L).flipUniqueValues());
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(2L, 1, 3L, 2, 4L, 3, 5L, 4).toImmutable(), this.newWithKeysValues(1, 2L, 2, 3L, 3, 4L, 4, 5L).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1, 1L, 2, 1L).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractIntLongMapTestCase._Benchmark {

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
        public abstract AbstractImmutableIntLongMapTestCase implementation();
    }
}
