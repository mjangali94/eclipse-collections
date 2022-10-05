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

import org.eclipse.collections.api.map.primitive.CharBooleanMap;
import org.eclipse.collections.api.map.primitive.ImmutableCharBooleanMap;
import org.eclipse.collections.impl.factory.primitive.CharBooleanMaps;
import org.eclipse.collections.impl.map.mutable.primitive.CharBooleanHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractCharBooleanMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableCharBooleanMap}.
 * This file was automatically generated from template file abstractImmutablePrimitiveBooleanMapTestCase.stg.
 */
public abstract class AbstractImmutableCharBooleanMapTestCase extends AbstractCharBooleanMapTestCase {

    @Override
    protected ImmutableCharBooleanMap classUnderTest() {
        return CharBooleanMaps.immutable.withAll(CharBooleanHashMap.newWithKeysValues((char) 0, true, (char) 31, false, (char) 32, true));
    }

    @Override
    protected ImmutableCharBooleanMap newWithKeysValues(char key1, boolean value1) {
        return CharBooleanMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableCharBooleanMap newWithKeysValues(char key1, boolean value1, char key2, boolean value2) {
        return CharBooleanMaps.immutable.withAll(new CharBooleanHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableCharBooleanMap newWithKeysValues(char key1, boolean value1, char key2, boolean value2, char key3, boolean value3) {
        return CharBooleanMaps.immutable.withAll(new CharBooleanHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableCharBooleanMap newWithKeysValues(char key1, boolean value1, char key2, boolean value2, char key3, boolean value3, char key4, boolean value4) {
        return CharBooleanMaps.immutable.withAll(new CharBooleanHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableCharBooleanMap getEmptyMap() {
        return CharBooleanMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        CharBooleanMap map1 = this.newWithKeysValues((char) 0, true, (char) 31, false, (char) 32, true);
        CharBooleanMap map2 = this.newWithKeysValues((char) 32, true, (char) 0, true, (char) 31, false);
        CharBooleanMap map3 = this.newWithKeysValues((char) 0, true, (char) 31, false, (char) 32, true, (char) 2, true);
        CharBooleanMap map4 = this.newWithKeysValues((char) 0, false, (char) 31, false, (char) 32, true);
        CharBooleanMap map5 = this.newWithKeysValues((char) 0, true, (char) 31, false, (char) 32, false);
        CharBooleanMap map6 = this.newWithKeysValues((char) 50, true, (char) 60, true, (char) 70, false);
        CharBooleanMap map7 = this.newWithKeysValues((char) 50, true, (char) 60, true);
        CharBooleanMap map8 = this.newWithKeysValues((char) 0, true, (char) 1, false);
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
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractCharBooleanMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testEquals, this.description("testEquals"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractImmutableCharBooleanMapTestCase implementation();
    }
}
