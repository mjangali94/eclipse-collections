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

import org.eclipse.collections.api.map.primitive.IntIntMap;
import org.eclipse.collections.api.map.primitive.ImmutableIntIntMap;
import org.eclipse.collections.impl.factory.primitive.IntIntMaps;
import org.eclipse.collections.impl.map.mutable.primitive.IntIntHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractIntIntMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableIntIntMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableIntIntMapTestCase extends AbstractIntIntMapTestCase {

    @Override
    protected ImmutableIntIntMap classUnderTest() {
        return IntIntMaps.immutable.withAll(IntIntHashMap.newWithKeysValues(0, 0, 31, 31, 32, 32));
    }

    @Override
    protected ImmutableIntIntMap newWithKeysValues(int key1, int value1) {
        return IntIntMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableIntIntMap newWithKeysValues(int key1, int value1, int key2, int value2) {
        return IntIntMaps.immutable.withAll(new IntIntHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableIntIntMap newWithKeysValues(int key1, int value1, int key2, int value2, int key3, int value3) {
        return IntIntMaps.immutable.withAll(new IntIntHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableIntIntMap newWithKeysValues(int key1, int value1, int key2, int value2, int key3, int value3, int key4, int value4) {
        return IntIntMaps.immutable.withAll(new IntIntHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableIntIntMap getEmptyMap() {
        return IntIntMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        IntIntMap map1 = this.newWithKeysValues(0, 0, 1, 1, 32, 32);
        IntIntMap map2 = this.newWithKeysValues(32, 32, 0, 0, 1, 1);
        IntIntMap map3 = this.newWithKeysValues(0, 0, 1, 2, 32, 32);
        IntIntMap map4 = this.newWithKeysValues(0, 1, 1, 1, 32, 32);
        IntIntMap map5 = this.newWithKeysValues(0, 0, 1, 1, 32, 33);
        IntIntMap map6 = this.newWithKeysValues(50, 0, 60, 1, 70, 33);
        IntIntMap map7 = this.newWithKeysValues(50, 0, 60, 1);
        IntIntMap map8 = this.newWithKeysValues(0, 0, 1, 1);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(IntIntMaps.immutable.empty(), IntIntMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableIntIntEmptyMap.class, IntIntMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(IntIntMaps.immutable.with(2, 1), this.newWithKeysValues(1, 2).flipUniqueValues());
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(2, 1, 3, 2, 4, 3, 5, 4).toImmutable(), this.newWithKeysValues(1, 2, 2, 3, 3, 4, 4, 5).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1, 1, 2, 1).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractIntIntMapTestCase._Benchmark {

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
        public abstract AbstractImmutableIntIntMapTestCase implementation();
    }
}
