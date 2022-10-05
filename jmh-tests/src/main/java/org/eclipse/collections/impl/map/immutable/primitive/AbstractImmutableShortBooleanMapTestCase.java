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

import org.eclipse.collections.api.map.primitive.ShortBooleanMap;
import org.eclipse.collections.api.map.primitive.ImmutableShortBooleanMap;
import org.eclipse.collections.impl.factory.primitive.ShortBooleanMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ShortBooleanHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractShortBooleanMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableShortBooleanMap}.
 * This file was automatically generated from template file abstractImmutablePrimitiveBooleanMapTestCase.stg.
 */
public abstract class AbstractImmutableShortBooleanMapTestCase extends AbstractShortBooleanMapTestCase {

    @Override
    protected ImmutableShortBooleanMap classUnderTest() {
        return ShortBooleanMaps.immutable.withAll(ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 31, false, (short) 32, true));
    }

    @Override
    protected ImmutableShortBooleanMap newWithKeysValues(short key1, boolean value1) {
        return ShortBooleanMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableShortBooleanMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2) {
        return ShortBooleanMaps.immutable.withAll(new ShortBooleanHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableShortBooleanMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2, short key3, boolean value3) {
        return ShortBooleanMaps.immutable.withAll(new ShortBooleanHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableShortBooleanMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2, short key3, boolean value3, short key4, boolean value4) {
        return ShortBooleanMaps.immutable.withAll(new ShortBooleanHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableShortBooleanMap getEmptyMap() {
        return ShortBooleanMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        ShortBooleanMap map1 = this.newWithKeysValues((short) 0, true, (short) 31, false, (short) 32, true);
        ShortBooleanMap map2 = this.newWithKeysValues((short) 32, true, (short) 0, true, (short) 31, false);
        ShortBooleanMap map3 = this.newWithKeysValues((short) 0, true, (short) 31, false, (short) 32, true, (short) 2, true);
        ShortBooleanMap map4 = this.newWithKeysValues((short) 0, false, (short) 31, false, (short) 32, true);
        ShortBooleanMap map5 = this.newWithKeysValues((short) 0, true, (short) 31, false, (short) 32, false);
        ShortBooleanMap map6 = this.newWithKeysValues((short) 50, true, (short) 60, true, (short) 70, false);
        ShortBooleanMap map7 = this.newWithKeysValues((short) 50, true, (short) 60, true);
        ShortBooleanMap map8 = this.newWithKeysValues((short) 0, true, (short) 1, false);
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
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractShortBooleanMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testEquals, this.description("testEquals"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractImmutableShortBooleanMapTestCase implementation();
    }
}
