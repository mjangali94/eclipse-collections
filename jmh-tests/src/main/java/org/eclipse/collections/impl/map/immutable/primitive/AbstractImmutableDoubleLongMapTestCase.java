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

import org.eclipse.collections.api.map.primitive.DoubleLongMap;
import org.eclipse.collections.api.map.primitive.ImmutableDoubleLongMap;
import org.eclipse.collections.impl.factory.primitive.DoubleLongMaps;
import org.eclipse.collections.impl.factory.primitive.LongDoubleMaps;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleLongHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.LongDoubleHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractDoubleLongMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableDoubleLongMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableDoubleLongMapTestCase extends AbstractDoubleLongMapTestCase {

    @Override
    protected ImmutableDoubleLongMap classUnderTest() {
        return DoubleLongMaps.immutable.withAll(DoubleLongHashMap.newWithKeysValues(0.0, 0L, 31.0, 31L, 32.0, 32L));
    }

    @Override
    protected ImmutableDoubleLongMap newWithKeysValues(double key1, long value1) {
        return DoubleLongMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableDoubleLongMap newWithKeysValues(double key1, long value1, double key2, long value2) {
        return DoubleLongMaps.immutable.withAll(new DoubleLongHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableDoubleLongMap newWithKeysValues(double key1, long value1, double key2, long value2, double key3, long value3) {
        return DoubleLongMaps.immutable.withAll(new DoubleLongHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableDoubleLongMap newWithKeysValues(double key1, long value1, double key2, long value2, double key3, long value3, double key4, long value4) {
        return DoubleLongMaps.immutable.withAll(new DoubleLongHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableDoubleLongMap getEmptyMap() {
        return DoubleLongMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        DoubleLongMap map1 = this.newWithKeysValues(0.0, 0L, 1.0, 1L, 32.0, 32L);
        DoubleLongMap map2 = this.newWithKeysValues(32.0, 32L, 0.0, 0L, 1.0, 1L);
        DoubleLongMap map3 = this.newWithKeysValues(0.0, 0L, 1.0, 2L, 32.0, 32L);
        DoubleLongMap map4 = this.newWithKeysValues(0.0, 1L, 1.0, 1L, 32.0, 32L);
        DoubleLongMap map5 = this.newWithKeysValues(0.0, 0L, 1.0, 1L, 32.0, 33L);
        DoubleLongMap map6 = this.newWithKeysValues(50.0, 0L, 60.0, 1L, 70.0, 33L);
        DoubleLongMap map7 = this.newWithKeysValues(50.0, 0L, 60.0, 1L);
        DoubleLongMap map8 = this.newWithKeysValues(0.0, 0L, 1.0, 1L);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().keySet().remove(0.0));
    }

    @Override
    public void values() {
        super.values();
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0L));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(LongDoubleMaps.immutable.empty(), DoubleLongMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableLongDoubleEmptyMap.class, DoubleLongMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(LongDoubleMaps.immutable.with(2L, 1.0), this.newWithKeysValues(1.0, 2L).flipUniqueValues());
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(2L, 1.0, 3L, 2.0, 4L, 3.0, 5L, 4.0).toImmutable(), this.newWithKeysValues(1.0, 2L, 2.0, 3L, 3.0, 4L, 4.0, 5L).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0, 1L, 2.0, 1L).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractDoubleLongMapTestCase._Benchmark {

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
        public abstract AbstractImmutableDoubleLongMapTestCase implementation();
    }
}
