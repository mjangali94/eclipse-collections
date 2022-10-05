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

import org.eclipse.collections.api.map.primitive.LongDoubleMap;
import org.eclipse.collections.api.map.primitive.ImmutableLongDoubleMap;
import org.eclipse.collections.impl.factory.primitive.LongDoubleMaps;
import org.eclipse.collections.impl.factory.primitive.DoubleLongMaps;
import org.eclipse.collections.impl.map.mutable.primitive.LongDoubleHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleLongHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractLongDoubleMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableLongDoubleMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableLongDoubleMapTestCase extends AbstractLongDoubleMapTestCase {

    @Override
    protected ImmutableLongDoubleMap classUnderTest() {
        return LongDoubleMaps.immutable.withAll(LongDoubleHashMap.newWithKeysValues(0L, 0.0, 31L, 31.0, 32L, 32.0));
    }

    @Override
    protected ImmutableLongDoubleMap newWithKeysValues(long key1, double value1) {
        return LongDoubleMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableLongDoubleMap newWithKeysValues(long key1, double value1, long key2, double value2) {
        return LongDoubleMaps.immutable.withAll(new LongDoubleHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableLongDoubleMap newWithKeysValues(long key1, double value1, long key2, double value2, long key3, double value3) {
        return LongDoubleMaps.immutable.withAll(new LongDoubleHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableLongDoubleMap newWithKeysValues(long key1, double value1, long key2, double value2, long key3, double value3, long key4, double value4) {
        return LongDoubleMaps.immutable.withAll(new LongDoubleHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableLongDoubleMap getEmptyMap() {
        return LongDoubleMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        LongDoubleMap map1 = this.newWithKeysValues(0L, 0.0, 1L, 1.0, 32L, 32.0);
        LongDoubleMap map2 = this.newWithKeysValues(32L, 32.0, 0L, 0.0, 1L, 1.0);
        LongDoubleMap map3 = this.newWithKeysValues(0L, 0.0, 1L, 2.0, 32L, 32.0);
        LongDoubleMap map4 = this.newWithKeysValues(0L, 1.0, 1L, 1.0, 32L, 32.0);
        LongDoubleMap map5 = this.newWithKeysValues(0L, 0.0, 1L, 1.0, 32L, 33.0);
        LongDoubleMap map6 = this.newWithKeysValues(50L, 0.0, 60L, 1.0, 70L, 33.0);
        LongDoubleMap map7 = this.newWithKeysValues(50L, 0.0, 60L, 1.0);
        LongDoubleMap map8 = this.newWithKeysValues(0L, 0.0, 1L, 1.0);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0.0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(DoubleLongMaps.immutable.empty(), LongDoubleMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableDoubleLongEmptyMap.class, LongDoubleMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(DoubleLongMaps.immutable.with(2.0, 1L), this.newWithKeysValues(1L, 2.0).flipUniqueValues());
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(2.0, 1L, 3.0, 2L, 4.0, 3L, 5.0, 4L).toImmutable(), this.newWithKeysValues(1L, 2.0, 2L, 3.0, 3L, 4.0, 4L, 5.0).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1L, 1.0, 2L, 1.0).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractLongDoubleMapTestCase._Benchmark {

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
        public abstract AbstractImmutableLongDoubleMapTestCase implementation();
    }
}
