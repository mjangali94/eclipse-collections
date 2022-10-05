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

import org.eclipse.collections.api.map.primitive.CharShortMap;
import org.eclipse.collections.api.map.primitive.ImmutableCharShortMap;
import org.eclipse.collections.impl.factory.primitive.CharShortMaps;
import org.eclipse.collections.impl.factory.primitive.ShortCharMaps;
import org.eclipse.collections.impl.map.mutable.primitive.CharShortHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.ShortCharHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractCharShortMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableCharShortMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableCharShortMapTestCase extends AbstractCharShortMapTestCase {

    @Override
    protected ImmutableCharShortMap classUnderTest() {
        return CharShortMaps.immutable.withAll(CharShortHashMap.newWithKeysValues((char) 0, (short) 0, (char) 31, (short) 31, (char) 32, (short) 32));
    }

    @Override
    protected ImmutableCharShortMap newWithKeysValues(char key1, short value1) {
        return CharShortMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableCharShortMap newWithKeysValues(char key1, short value1, char key2, short value2) {
        return CharShortMaps.immutable.withAll(new CharShortHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableCharShortMap newWithKeysValues(char key1, short value1, char key2, short value2, char key3, short value3) {
        return CharShortMaps.immutable.withAll(new CharShortHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableCharShortMap newWithKeysValues(char key1, short value1, char key2, short value2, char key3, short value3, char key4, short value4) {
        return CharShortMaps.immutable.withAll(new CharShortHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableCharShortMap getEmptyMap() {
        return CharShortMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        CharShortMap map1 = this.newWithKeysValues((char) 0, (short) 0, (char) 1, (short) 1, (char) 32, (short) 32);
        CharShortMap map2 = this.newWithKeysValues((char) 32, (short) 32, (char) 0, (short) 0, (char) 1, (short) 1);
        CharShortMap map3 = this.newWithKeysValues((char) 0, (short) 0, (char) 1, (short) 2, (char) 32, (short) 32);
        CharShortMap map4 = this.newWithKeysValues((char) 0, (short) 1, (char) 1, (short) 1, (char) 32, (short) 32);
        CharShortMap map5 = this.newWithKeysValues((char) 0, (short) 0, (char) 1, (short) 1, (char) 32, (short) 33);
        CharShortMap map6 = this.newWithKeysValues((char) 50, (short) 0, (char) 60, (short) 1, (char) 70, (short) 33);
        CharShortMap map7 = this.newWithKeysValues((char) 50, (short) 0, (char) 60, (short) 1);
        CharShortMap map8 = this.newWithKeysValues((char) 0, (short) 0, (char) 1, (short) 1);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().keySet().remove((char) 0));
    }

    @Override
    public void values() {
        super.values();
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove((short) 0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(ShortCharMaps.immutable.empty(), CharShortMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableShortCharEmptyMap.class, CharShortMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(ShortCharMaps.immutable.with((short) 2, (char) 1), this.newWithKeysValues((char) 1, (short) 2).flipUniqueValues());
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 2, (char) 1, (short) 3, (char) 2, (short) 4, (char) 3, (short) 5, (char) 4).toImmutable(), this.newWithKeysValues((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4, (char) 4, (short) 5).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((char) 1, (short) 1, (char) 2, (short) 1).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractCharShortMapTestCase._Benchmark {

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
        public abstract AbstractImmutableCharShortMapTestCase implementation();
    }
}
