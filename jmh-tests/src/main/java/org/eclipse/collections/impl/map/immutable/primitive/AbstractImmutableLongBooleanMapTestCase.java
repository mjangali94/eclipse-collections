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

import org.eclipse.collections.api.map.primitive.LongBooleanMap;
import org.eclipse.collections.api.map.primitive.ImmutableLongBooleanMap;
import org.eclipse.collections.impl.factory.primitive.LongBooleanMaps;
import org.eclipse.collections.impl.map.mutable.primitive.LongBooleanHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractLongBooleanMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableLongBooleanMap}.
 * This file was automatically generated from template file abstractImmutablePrimitiveBooleanMapTestCase.stg.
 */
public abstract class AbstractImmutableLongBooleanMapTestCase extends AbstractLongBooleanMapTestCase {

    @Override
    protected ImmutableLongBooleanMap classUnderTest() {
        return LongBooleanMaps.immutable.withAll(LongBooleanHashMap.newWithKeysValues(0L, true, 31L, false, 32L, true));
    }

    @Override
    protected ImmutableLongBooleanMap newWithKeysValues(long key1, boolean value1) {
        return LongBooleanMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableLongBooleanMap newWithKeysValues(long key1, boolean value1, long key2, boolean value2) {
        return LongBooleanMaps.immutable.withAll(new LongBooleanHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableLongBooleanMap newWithKeysValues(long key1, boolean value1, long key2, boolean value2, long key3, boolean value3) {
        return LongBooleanMaps.immutable.withAll(new LongBooleanHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableLongBooleanMap newWithKeysValues(long key1, boolean value1, long key2, boolean value2, long key3, boolean value3, long key4, boolean value4) {
        return LongBooleanMaps.immutable.withAll(new LongBooleanHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableLongBooleanMap getEmptyMap() {
        return LongBooleanMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        LongBooleanMap map1 = this.newWithKeysValues(0L, true, 31L, false, 32L, true);
        LongBooleanMap map2 = this.newWithKeysValues(32L, true, 0L, true, 31L, false);
        LongBooleanMap map3 = this.newWithKeysValues(0L, true, 31L, false, 32L, true, 2L, true);
        LongBooleanMap map4 = this.newWithKeysValues(0L, false, 31L, false, 32L, true);
        LongBooleanMap map5 = this.newWithKeysValues(0L, true, 31L, false, 32L, false);
        LongBooleanMap map6 = this.newWithKeysValues(50L, true, 60L, true, 70L, false);
        LongBooleanMap map7 = this.newWithKeysValues(50L, true, 60L, true);
        LongBooleanMap map8 = this.newWithKeysValues(0L, true, 1L, false);
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

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractLongBooleanMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testEquals, this.description("testEquals"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractImmutableLongBooleanMapTestCase implementation();
    }
}
