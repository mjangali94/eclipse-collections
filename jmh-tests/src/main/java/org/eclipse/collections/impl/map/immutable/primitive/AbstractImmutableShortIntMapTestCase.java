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

import org.eclipse.collections.api.map.primitive.ShortIntMap;
import org.eclipse.collections.api.map.primitive.ImmutableShortIntMap;
import org.eclipse.collections.impl.factory.primitive.ShortIntMaps;
import org.eclipse.collections.impl.factory.primitive.IntShortMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ShortIntHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntShortHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractShortIntMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableShortIntMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableShortIntMapTestCase extends AbstractShortIntMapTestCase {

    @Override
    protected ImmutableShortIntMap classUnderTest() {
        return ShortIntMaps.immutable.withAll(ShortIntHashMap.newWithKeysValues((short) 0, 0, (short) 31, 31, (short) 32, 32));
    }

    @Override
    protected ImmutableShortIntMap newWithKeysValues(short key1, int value1) {
        return ShortIntMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableShortIntMap newWithKeysValues(short key1, int value1, short key2, int value2) {
        return ShortIntMaps.immutable.withAll(new ShortIntHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableShortIntMap newWithKeysValues(short key1, int value1, short key2, int value2, short key3, int value3) {
        return ShortIntMaps.immutable.withAll(new ShortIntHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableShortIntMap newWithKeysValues(short key1, int value1, short key2, int value2, short key3, int value3, short key4, int value4) {
        return ShortIntMaps.immutable.withAll(new ShortIntHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableShortIntMap getEmptyMap() {
        return ShortIntMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        ShortIntMap map1 = this.newWithKeysValues((short) 0, 0, (short) 1, 1, (short) 32, 32);
        ShortIntMap map2 = this.newWithKeysValues((short) 32, 32, (short) 0, 0, (short) 1, 1);
        ShortIntMap map3 = this.newWithKeysValues((short) 0, 0, (short) 1, 2, (short) 32, 32);
        ShortIntMap map4 = this.newWithKeysValues((short) 0, 1, (short) 1, 1, (short) 32, 32);
        ShortIntMap map5 = this.newWithKeysValues((short) 0, 0, (short) 1, 1, (short) 32, 33);
        ShortIntMap map6 = this.newWithKeysValues((short) 50, 0, (short) 60, 1, (short) 70, 33);
        ShortIntMap map7 = this.newWithKeysValues((short) 50, 0, (short) 60, 1);
        ShortIntMap map8 = this.newWithKeysValues((short) 0, 0, (short) 1, 1);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(IntShortMaps.immutable.empty(), ShortIntMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableIntShortEmptyMap.class, ShortIntMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(IntShortMaps.immutable.with(2, (short) 1), this.newWithKeysValues((short) 1, 2).flipUniqueValues());
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(2, (short) 1, 3, (short) 2, 4, (short) 3, 5, (short) 4).toImmutable(), this.newWithKeysValues((short) 1, 2, (short) 2, 3, (short) 3, 4, (short) 4, 5).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((short) 1, 1, (short) 2, 1).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractShortIntMapTestCase._Benchmark {

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
        public abstract AbstractImmutableShortIntMapTestCase implementation();
    }
}
