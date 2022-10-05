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

import org.eclipse.collections.api.map.primitive.LongIntMap;
import org.eclipse.collections.api.map.primitive.ImmutableLongIntMap;
import org.eclipse.collections.impl.factory.primitive.LongIntMaps;
import org.eclipse.collections.impl.factory.primitive.IntLongMaps;
import org.eclipse.collections.impl.map.mutable.primitive.LongIntHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntLongHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractLongIntMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableLongIntMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableLongIntMapTestCase extends AbstractLongIntMapTestCase {

    @Override
    protected ImmutableLongIntMap classUnderTest() {
        return LongIntMaps.immutable.withAll(LongIntHashMap.newWithKeysValues(0L, 0, 31L, 31, 32L, 32));
    }

    @Override
    protected ImmutableLongIntMap newWithKeysValues(long key1, int value1) {
        return LongIntMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableLongIntMap newWithKeysValues(long key1, int value1, long key2, int value2) {
        return LongIntMaps.immutable.withAll(new LongIntHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableLongIntMap newWithKeysValues(long key1, int value1, long key2, int value2, long key3, int value3) {
        return LongIntMaps.immutable.withAll(new LongIntHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableLongIntMap newWithKeysValues(long key1, int value1, long key2, int value2, long key3, int value3, long key4, int value4) {
        return LongIntMaps.immutable.withAll(new LongIntHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableLongIntMap getEmptyMap() {
        return LongIntMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        LongIntMap map1 = this.newWithKeysValues(0L, 0, 1L, 1, 32L, 32);
        LongIntMap map2 = this.newWithKeysValues(32L, 32, 0L, 0, 1L, 1);
        LongIntMap map3 = this.newWithKeysValues(0L, 0, 1L, 2, 32L, 32);
        LongIntMap map4 = this.newWithKeysValues(0L, 1, 1L, 1, 32L, 32);
        LongIntMap map5 = this.newWithKeysValues(0L, 0, 1L, 1, 32L, 33);
        LongIntMap map6 = this.newWithKeysValues(50L, 0, 60L, 1, 70L, 33);
        LongIntMap map7 = this.newWithKeysValues(50L, 0, 60L, 1);
        LongIntMap map8 = this.newWithKeysValues(0L, 0, 1L, 1);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(IntLongMaps.immutable.empty(), LongIntMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableIntLongEmptyMap.class, LongIntMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(IntLongMaps.immutable.with(2, 1L), this.newWithKeysValues(1L, 2).flipUniqueValues());
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(2, 1L, 3, 2L, 4, 3L, 5, 4L).toImmutable(), this.newWithKeysValues(1L, 2, 2L, 3, 3L, 4, 4L, 5).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1L, 1, 2L, 1).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractLongIntMapTestCase._Benchmark {

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
        public abstract AbstractImmutableLongIntMapTestCase implementation();
    }
}
