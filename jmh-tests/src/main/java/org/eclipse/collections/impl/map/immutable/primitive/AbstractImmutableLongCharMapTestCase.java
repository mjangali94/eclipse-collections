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

import org.eclipse.collections.api.map.primitive.LongCharMap;
import org.eclipse.collections.api.map.primitive.ImmutableLongCharMap;
import org.eclipse.collections.impl.factory.primitive.LongCharMaps;
import org.eclipse.collections.impl.factory.primitive.CharLongMaps;
import org.eclipse.collections.impl.map.mutable.primitive.LongCharHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.CharLongHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractLongCharMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableLongCharMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableLongCharMapTestCase extends AbstractLongCharMapTestCase {

    @Override
    protected ImmutableLongCharMap classUnderTest() {
        return LongCharMaps.immutable.withAll(LongCharHashMap.newWithKeysValues(0L, (char) 0, 31L, (char) 31, 32L, (char) 32));
    }

    @Override
    protected ImmutableLongCharMap newWithKeysValues(long key1, char value1) {
        return LongCharMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableLongCharMap newWithKeysValues(long key1, char value1, long key2, char value2) {
        return LongCharMaps.immutable.withAll(new LongCharHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableLongCharMap newWithKeysValues(long key1, char value1, long key2, char value2, long key3, char value3) {
        return LongCharMaps.immutable.withAll(new LongCharHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableLongCharMap newWithKeysValues(long key1, char value1, long key2, char value2, long key3, char value3, long key4, char value4) {
        return LongCharMaps.immutable.withAll(new LongCharHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableLongCharMap getEmptyMap() {
        return LongCharMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        LongCharMap map1 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 32L, (char) 32);
        LongCharMap map2 = this.newWithKeysValues(32L, (char) 32, 0L, (char) 0, 1L, (char) 1);
        LongCharMap map3 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 2, 32L, (char) 32);
        LongCharMap map4 = this.newWithKeysValues(0L, (char) 1, 1L, (char) 1, 32L, (char) 32);
        LongCharMap map5 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 32L, (char) 33);
        LongCharMap map6 = this.newWithKeysValues(50L, (char) 0, 60L, (char) 1, 70L, (char) 33);
        LongCharMap map7 = this.newWithKeysValues(50L, (char) 0, 60L, (char) 1);
        LongCharMap map8 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove((char) 0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(CharLongMaps.immutable.empty(), LongCharMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableCharLongEmptyMap.class, LongCharMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(CharLongMaps.immutable.with((char) 2, 1L), this.newWithKeysValues(1L, (char) 2).flipUniqueValues());
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 2, 1L, (char) 3, 2L, (char) 4, 3L, (char) 5, 4L).toImmutable(), this.newWithKeysValues(1L, (char) 2, 2L, (char) 3, 3L, (char) 4, 4L, (char) 5).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1L, (char) 1, 2L, (char) 1).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractLongCharMapTestCase._Benchmark {

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
        public abstract AbstractImmutableLongCharMapTestCase implementation();
    }
}
