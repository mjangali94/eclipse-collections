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

import org.eclipse.collections.api.map.primitive.ShortCharMap;
import org.eclipse.collections.api.map.primitive.ImmutableShortCharMap;
import org.eclipse.collections.impl.factory.primitive.ShortCharMaps;
import org.eclipse.collections.impl.factory.primitive.CharShortMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ShortCharHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.CharShortHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractShortCharMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableShortCharMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableShortCharMapTestCase extends AbstractShortCharMapTestCase {

    @Override
    protected ImmutableShortCharMap classUnderTest() {
        return ShortCharMaps.immutable.withAll(ShortCharHashMap.newWithKeysValues((short) 0, (char) 0, (short) 31, (char) 31, (short) 32, (char) 32));
    }

    @Override
    protected ImmutableShortCharMap newWithKeysValues(short key1, char value1) {
        return ShortCharMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableShortCharMap newWithKeysValues(short key1, char value1, short key2, char value2) {
        return ShortCharMaps.immutable.withAll(new ShortCharHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableShortCharMap newWithKeysValues(short key1, char value1, short key2, char value2, short key3, char value3) {
        return ShortCharMaps.immutable.withAll(new ShortCharHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableShortCharMap newWithKeysValues(short key1, char value1, short key2, char value2, short key3, char value3, short key4, char value4) {
        return ShortCharMaps.immutable.withAll(new ShortCharHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableShortCharMap getEmptyMap() {
        return ShortCharMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        ShortCharMap map1 = this.newWithKeysValues((short) 0, (char) 0, (short) 1, (char) 1, (short) 32, (char) 32);
        ShortCharMap map2 = this.newWithKeysValues((short) 32, (char) 32, (short) 0, (char) 0, (short) 1, (char) 1);
        ShortCharMap map3 = this.newWithKeysValues((short) 0, (char) 0, (short) 1, (char) 2, (short) 32, (char) 32);
        ShortCharMap map4 = this.newWithKeysValues((short) 0, (char) 1, (short) 1, (char) 1, (short) 32, (char) 32);
        ShortCharMap map5 = this.newWithKeysValues((short) 0, (char) 0, (short) 1, (char) 1, (short) 32, (char) 33);
        ShortCharMap map6 = this.newWithKeysValues((short) 50, (char) 0, (short) 60, (char) 1, (short) 70, (char) 33);
        ShortCharMap map7 = this.newWithKeysValues((short) 50, (char) 0, (short) 60, (char) 1);
        ShortCharMap map8 = this.newWithKeysValues((short) 0, (char) 0, (short) 1, (char) 1);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove((char) 0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(CharShortMaps.immutable.empty(), ShortCharMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableCharShortEmptyMap.class, ShortCharMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(CharShortMaps.immutable.with((char) 2, (short) 1), this.newWithKeysValues((short) 1, (char) 2).flipUniqueValues());
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 2, (short) 1, (char) 3, (short) 2, (char) 4, (short) 3, (char) 5, (short) 4).toImmutable(), this.newWithKeysValues((short) 1, (char) 2, (short) 2, (char) 3, (short) 3, (char) 4, (short) 4, (char) 5).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((short) 1, (char) 1, (short) 2, (char) 1).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractShortCharMapTestCase._Benchmark {

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
        public abstract AbstractImmutableShortCharMapTestCase implementation();
    }
}
