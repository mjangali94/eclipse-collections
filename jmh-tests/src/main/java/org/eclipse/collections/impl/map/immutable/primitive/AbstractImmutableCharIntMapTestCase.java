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

import org.eclipse.collections.api.map.primitive.CharIntMap;
import org.eclipse.collections.api.map.primitive.ImmutableCharIntMap;
import org.eclipse.collections.impl.factory.primitive.CharIntMaps;
import org.eclipse.collections.impl.factory.primitive.IntCharMaps;
import org.eclipse.collections.impl.map.mutable.primitive.CharIntHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntCharHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractCharIntMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableCharIntMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableCharIntMapTestCase extends AbstractCharIntMapTestCase {

    @Override
    protected ImmutableCharIntMap classUnderTest() {
        return CharIntMaps.immutable.withAll(CharIntHashMap.newWithKeysValues((char) 0, 0, (char) 31, 31, (char) 32, 32));
    }

    @Override
    protected ImmutableCharIntMap newWithKeysValues(char key1, int value1) {
        return CharIntMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableCharIntMap newWithKeysValues(char key1, int value1, char key2, int value2) {
        return CharIntMaps.immutable.withAll(new CharIntHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableCharIntMap newWithKeysValues(char key1, int value1, char key2, int value2, char key3, int value3) {
        return CharIntMaps.immutable.withAll(new CharIntHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableCharIntMap newWithKeysValues(char key1, int value1, char key2, int value2, char key3, int value3, char key4, int value4) {
        return CharIntMaps.immutable.withAll(new CharIntHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableCharIntMap getEmptyMap() {
        return CharIntMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        CharIntMap map1 = this.newWithKeysValues((char) 0, 0, (char) 1, 1, (char) 32, 32);
        CharIntMap map2 = this.newWithKeysValues((char) 32, 32, (char) 0, 0, (char) 1, 1);
        CharIntMap map3 = this.newWithKeysValues((char) 0, 0, (char) 1, 2, (char) 32, 32);
        CharIntMap map4 = this.newWithKeysValues((char) 0, 1, (char) 1, 1, (char) 32, 32);
        CharIntMap map5 = this.newWithKeysValues((char) 0, 0, (char) 1, 1, (char) 32, 33);
        CharIntMap map6 = this.newWithKeysValues((char) 50, 0, (char) 60, 1, (char) 70, 33);
        CharIntMap map7 = this.newWithKeysValues((char) 50, 0, (char) 60, 1);
        CharIntMap map8 = this.newWithKeysValues((char) 0, 0, (char) 1, 1);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(IntCharMaps.immutable.empty(), CharIntMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableIntCharEmptyMap.class, CharIntMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(IntCharMaps.immutable.with(2, (char) 1), this.newWithKeysValues((char) 1, 2).flipUniqueValues());
        Assert.assertEquals(IntCharHashMap.newWithKeysValues(2, (char) 1, 3, (char) 2, 4, (char) 3, 5, (char) 4).toImmutable(), this.newWithKeysValues((char) 1, 2, (char) 2, 3, (char) 3, 4, (char) 4, 5).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((char) 1, 1, (char) 2, 1).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractCharIntMapTestCase._Benchmark {

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
        public abstract AbstractImmutableCharIntMapTestCase implementation();
    }
}
