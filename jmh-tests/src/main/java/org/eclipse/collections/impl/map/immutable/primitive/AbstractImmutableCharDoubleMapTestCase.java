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

import org.eclipse.collections.api.map.primitive.CharDoubleMap;
import org.eclipse.collections.api.map.primitive.ImmutableCharDoubleMap;
import org.eclipse.collections.impl.factory.primitive.CharDoubleMaps;
import org.eclipse.collections.impl.factory.primitive.DoubleCharMaps;
import org.eclipse.collections.impl.map.mutable.primitive.CharDoubleHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleCharHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractCharDoubleMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableCharDoubleMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableCharDoubleMapTestCase extends AbstractCharDoubleMapTestCase {

    @Override
    protected ImmutableCharDoubleMap classUnderTest() {
        return CharDoubleMaps.immutable.withAll(CharDoubleHashMap.newWithKeysValues((char) 0, 0.0, (char) 31, 31.0, (char) 32, 32.0));
    }

    @Override
    protected ImmutableCharDoubleMap newWithKeysValues(char key1, double value1) {
        return CharDoubleMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableCharDoubleMap newWithKeysValues(char key1, double value1, char key2, double value2) {
        return CharDoubleMaps.immutable.withAll(new CharDoubleHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableCharDoubleMap newWithKeysValues(char key1, double value1, char key2, double value2, char key3, double value3) {
        return CharDoubleMaps.immutable.withAll(new CharDoubleHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableCharDoubleMap newWithKeysValues(char key1, double value1, char key2, double value2, char key3, double value3, char key4, double value4) {
        return CharDoubleMaps.immutable.withAll(new CharDoubleHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableCharDoubleMap getEmptyMap() {
        return CharDoubleMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        CharDoubleMap map1 = this.newWithKeysValues((char) 0, 0.0, (char) 1, 1.0, (char) 32, 32.0);
        CharDoubleMap map2 = this.newWithKeysValues((char) 32, 32.0, (char) 0, 0.0, (char) 1, 1.0);
        CharDoubleMap map3 = this.newWithKeysValues((char) 0, 0.0, (char) 1, 2.0, (char) 32, 32.0);
        CharDoubleMap map4 = this.newWithKeysValues((char) 0, 1.0, (char) 1, 1.0, (char) 32, 32.0);
        CharDoubleMap map5 = this.newWithKeysValues((char) 0, 0.0, (char) 1, 1.0, (char) 32, 33.0);
        CharDoubleMap map6 = this.newWithKeysValues((char) 50, 0.0, (char) 60, 1.0, (char) 70, 33.0);
        CharDoubleMap map7 = this.newWithKeysValues((char) 50, 0.0, (char) 60, 1.0);
        CharDoubleMap map8 = this.newWithKeysValues((char) 0, 0.0, (char) 1, 1.0);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0.0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(DoubleCharMaps.immutable.empty(), CharDoubleMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableDoubleCharEmptyMap.class, CharDoubleMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(DoubleCharMaps.immutable.with(2.0, (char) 1), this.newWithKeysValues((char) 1, 2.0).flipUniqueValues());
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(2.0, (char) 1, 3.0, (char) 2, 4.0, (char) 3, 5.0, (char) 4).toImmutable(), this.newWithKeysValues((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0, (char) 4, 5.0).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((char) 1, 1.0, (char) 2, 1.0).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractCharDoubleMapTestCase._Benchmark {

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
        public abstract AbstractImmutableCharDoubleMapTestCase implementation();
    }
}
