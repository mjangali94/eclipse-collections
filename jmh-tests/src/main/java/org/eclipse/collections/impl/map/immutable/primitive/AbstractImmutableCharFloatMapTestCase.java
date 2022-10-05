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

import org.eclipse.collections.api.map.primitive.CharFloatMap;
import org.eclipse.collections.api.map.primitive.ImmutableCharFloatMap;
import org.eclipse.collections.impl.factory.primitive.CharFloatMaps;
import org.eclipse.collections.impl.factory.primitive.FloatCharMaps;
import org.eclipse.collections.impl.map.mutable.primitive.CharFloatHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.FloatCharHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractCharFloatMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableCharFloatMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableCharFloatMapTestCase extends AbstractCharFloatMapTestCase {

    @Override
    protected ImmutableCharFloatMap classUnderTest() {
        return CharFloatMaps.immutable.withAll(CharFloatHashMap.newWithKeysValues((char) 0, 0.0f, (char) 31, 31.0f, (char) 32, 32.0f));
    }

    @Override
    protected ImmutableCharFloatMap newWithKeysValues(char key1, float value1) {
        return CharFloatMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableCharFloatMap newWithKeysValues(char key1, float value1, char key2, float value2) {
        return CharFloatMaps.immutable.withAll(new CharFloatHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableCharFloatMap newWithKeysValues(char key1, float value1, char key2, float value2, char key3, float value3) {
        return CharFloatMaps.immutable.withAll(new CharFloatHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableCharFloatMap newWithKeysValues(char key1, float value1, char key2, float value2, char key3, float value3, char key4, float value4) {
        return CharFloatMaps.immutable.withAll(new CharFloatHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableCharFloatMap getEmptyMap() {
        return CharFloatMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        CharFloatMap map1 = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f, (char) 32, 32.0f);
        CharFloatMap map2 = this.newWithKeysValues((char) 32, 32.0f, (char) 0, 0.0f, (char) 1, 1.0f);
        CharFloatMap map3 = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 2.0f, (char) 32, 32.0f);
        CharFloatMap map4 = this.newWithKeysValues((char) 0, 1.0f, (char) 1, 1.0f, (char) 32, 32.0f);
        CharFloatMap map5 = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f, (char) 32, 33.0f);
        CharFloatMap map6 = this.newWithKeysValues((char) 50, 0.0f, (char) 60, 1.0f, (char) 70, 33.0f);
        CharFloatMap map7 = this.newWithKeysValues((char) 50, 0.0f, (char) 60, 1.0f);
        CharFloatMap map8 = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0.0f));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(FloatCharMaps.immutable.empty(), CharFloatMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableFloatCharEmptyMap.class, CharFloatMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(FloatCharMaps.immutable.with(2.0f, (char) 1), this.newWithKeysValues((char) 1, 2.0f).flipUniqueValues());
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(2.0f, (char) 1, 3.0f, (char) 2, 4.0f, (char) 3, 5.0f, (char) 4).toImmutable(), this.newWithKeysValues((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4, 5.0f).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((char) 1, 1.0f, (char) 2, 1.0f).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractCharFloatMapTestCase._Benchmark {

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
        public abstract AbstractImmutableCharFloatMapTestCase implementation();
    }
}
