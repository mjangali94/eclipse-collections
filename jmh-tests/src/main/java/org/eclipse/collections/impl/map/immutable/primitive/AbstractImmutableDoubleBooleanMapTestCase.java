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

import org.eclipse.collections.api.map.primitive.DoubleBooleanMap;
import org.eclipse.collections.api.map.primitive.ImmutableDoubleBooleanMap;
import org.eclipse.collections.impl.factory.primitive.DoubleBooleanMaps;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleBooleanHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractDoubleBooleanMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableDoubleBooleanMap}.
 * This file was automatically generated from template file abstractImmutablePrimitiveBooleanMapTestCase.stg.
 */
public abstract class AbstractImmutableDoubleBooleanMapTestCase extends AbstractDoubleBooleanMapTestCase {

    @Override
    protected ImmutableDoubleBooleanMap classUnderTest() {
        return DoubleBooleanMaps.immutable.withAll(DoubleBooleanHashMap.newWithKeysValues(0.0, true, 31.0, false, 32.0, true));
    }

    @Override
    protected ImmutableDoubleBooleanMap newWithKeysValues(double key1, boolean value1) {
        return DoubleBooleanMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableDoubleBooleanMap newWithKeysValues(double key1, boolean value1, double key2, boolean value2) {
        return DoubleBooleanMaps.immutable.withAll(new DoubleBooleanHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableDoubleBooleanMap newWithKeysValues(double key1, boolean value1, double key2, boolean value2, double key3, boolean value3) {
        return DoubleBooleanMaps.immutable.withAll(new DoubleBooleanHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableDoubleBooleanMap newWithKeysValues(double key1, boolean value1, double key2, boolean value2, double key3, boolean value3, double key4, boolean value4) {
        return DoubleBooleanMaps.immutable.withAll(new DoubleBooleanHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableDoubleBooleanMap getEmptyMap() {
        return DoubleBooleanMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        DoubleBooleanMap map1 = this.newWithKeysValues(0.0, true, 31.0, false, 32.0, true);
        DoubleBooleanMap map2 = this.newWithKeysValues(32.0, true, 0.0, true, 31.0, false);
        DoubleBooleanMap map3 = this.newWithKeysValues(0.0, true, 31.0, false, 32.0, true, 2.0, true);
        DoubleBooleanMap map4 = this.newWithKeysValues(0.0, false, 31.0, false, 32.0, true);
        DoubleBooleanMap map5 = this.newWithKeysValues(0.0, true, 31.0, false, 32.0, false);
        DoubleBooleanMap map6 = this.newWithKeysValues(50.0, true, 60.0, true, 70.0, false);
        DoubleBooleanMap map7 = this.newWithKeysValues(50.0, true, 60.0, true);
        DoubleBooleanMap map8 = this.newWithKeysValues(0.0, true, 1.0, false);
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
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractDoubleBooleanMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testEquals, this.description("testEquals"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractImmutableDoubleBooleanMapTestCase implementation();
    }
}
