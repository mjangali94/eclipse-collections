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

import org.eclipse.collections.api.map.primitive.IntBooleanMap;
import org.eclipse.collections.api.map.primitive.ImmutableIntBooleanMap;
import org.eclipse.collections.impl.factory.primitive.IntBooleanMaps;
import org.eclipse.collections.impl.map.mutable.primitive.IntBooleanHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractIntBooleanMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableIntBooleanMap}.
 * This file was automatically generated from template file abstractImmutablePrimitiveBooleanMapTestCase.stg.
 */
public abstract class AbstractImmutableIntBooleanMapTestCase extends AbstractIntBooleanMapTestCase {

    @Override
    protected ImmutableIntBooleanMap classUnderTest() {
        return IntBooleanMaps.immutable.withAll(IntBooleanHashMap.newWithKeysValues(0, true, 31, false, 32, true));
    }

    @Override
    protected ImmutableIntBooleanMap newWithKeysValues(int key1, boolean value1) {
        return IntBooleanMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableIntBooleanMap newWithKeysValues(int key1, boolean value1, int key2, boolean value2) {
        return IntBooleanMaps.immutable.withAll(new IntBooleanHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableIntBooleanMap newWithKeysValues(int key1, boolean value1, int key2, boolean value2, int key3, boolean value3) {
        return IntBooleanMaps.immutable.withAll(new IntBooleanHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableIntBooleanMap newWithKeysValues(int key1, boolean value1, int key2, boolean value2, int key3, boolean value3, int key4, boolean value4) {
        return IntBooleanMaps.immutable.withAll(new IntBooleanHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableIntBooleanMap getEmptyMap() {
        return IntBooleanMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        IntBooleanMap map1 = this.newWithKeysValues(0, true, 31, false, 32, true);
        IntBooleanMap map2 = this.newWithKeysValues(32, true, 0, true, 31, false);
        IntBooleanMap map3 = this.newWithKeysValues(0, true, 31, false, 32, true, 2, true);
        IntBooleanMap map4 = this.newWithKeysValues(0, false, 31, false, 32, true);
        IntBooleanMap map5 = this.newWithKeysValues(0, true, 31, false, 32, false);
        IntBooleanMap map6 = this.newWithKeysValues(50, true, 60, true, 70, false);
        IntBooleanMap map7 = this.newWithKeysValues(50, true, 60, true);
        IntBooleanMap map8 = this.newWithKeysValues(0, true, 1, false);
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
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractIntBooleanMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testEquals, this.description("testEquals"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractImmutableIntBooleanMapTestCase implementation();
    }
}
