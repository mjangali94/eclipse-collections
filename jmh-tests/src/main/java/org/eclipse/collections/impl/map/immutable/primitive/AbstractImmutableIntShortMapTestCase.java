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

import org.eclipse.collections.api.map.primitive.IntShortMap;
import org.eclipse.collections.api.map.primitive.ImmutableIntShortMap;
import org.eclipse.collections.impl.factory.primitive.IntShortMaps;
import org.eclipse.collections.impl.factory.primitive.ShortIntMaps;
import org.eclipse.collections.impl.map.mutable.primitive.IntShortHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.ShortIntHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractIntShortMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableIntShortMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableIntShortMapTestCase extends AbstractIntShortMapTestCase {

    @Override
    protected ImmutableIntShortMap classUnderTest() {
        return IntShortMaps.immutable.withAll(IntShortHashMap.newWithKeysValues(0, (short) 0, 31, (short) 31, 32, (short) 32));
    }

    @Override
    protected ImmutableIntShortMap newWithKeysValues(int key1, short value1) {
        return IntShortMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableIntShortMap newWithKeysValues(int key1, short value1, int key2, short value2) {
        return IntShortMaps.immutable.withAll(new IntShortHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableIntShortMap newWithKeysValues(int key1, short value1, int key2, short value2, int key3, short value3) {
        return IntShortMaps.immutable.withAll(new IntShortHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableIntShortMap newWithKeysValues(int key1, short value1, int key2, short value2, int key3, short value3, int key4, short value4) {
        return IntShortMaps.immutable.withAll(new IntShortHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableIntShortMap getEmptyMap() {
        return IntShortMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        IntShortMap map1 = this.newWithKeysValues(0, (short) 0, 1, (short) 1, 32, (short) 32);
        IntShortMap map2 = this.newWithKeysValues(32, (short) 32, 0, (short) 0, 1, (short) 1);
        IntShortMap map3 = this.newWithKeysValues(0, (short) 0, 1, (short) 2, 32, (short) 32);
        IntShortMap map4 = this.newWithKeysValues(0, (short) 1, 1, (short) 1, 32, (short) 32);
        IntShortMap map5 = this.newWithKeysValues(0, (short) 0, 1, (short) 1, 32, (short) 33);
        IntShortMap map6 = this.newWithKeysValues(50, (short) 0, 60, (short) 1, 70, (short) 33);
        IntShortMap map7 = this.newWithKeysValues(50, (short) 0, 60, (short) 1);
        IntShortMap map8 = this.newWithKeysValues(0, (short) 0, 1, (short) 1);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove((short) 0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(ShortIntMaps.immutable.empty(), IntShortMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableShortIntEmptyMap.class, IntShortMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(ShortIntMaps.immutable.with((short) 2, 1), this.newWithKeysValues(1, (short) 2).flipUniqueValues());
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 2, 1, (short) 3, 2, (short) 4, 3, (short) 5, 4).toImmutable(), this.newWithKeysValues(1, (short) 2, 2, (short) 3, 3, (short) 4, 4, (short) 5).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1, (short) 1, 2, (short) 1).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractIntShortMapTestCase._Benchmark {

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
        public abstract AbstractImmutableIntShortMapTestCase implementation();
    }
}
