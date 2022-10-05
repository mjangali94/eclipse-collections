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

import org.eclipse.collections.api.map.primitive.ImmutableObjectFloatMap;
import org.eclipse.collections.impl.factory.primitive.FloatObjectMaps;
import org.eclipse.collections.impl.factory.primitive.ObjectFloatMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectFloatHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.FloatObjectHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractObjectFloatMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableObjectFloatHashMap}.
 * This file was automatically generated from template file abstractImmutableObjectPrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableObjectFloatMapTestCase extends AbstractObjectFloatMapTestCase {

    @Override
    protected abstract ImmutableObjectFloatMap<String> classUnderTest();

    @Override
    protected <T> ImmutableObjectFloatMap<T> newWithKeysValues(T key1, float value1) {
        return ObjectFloatHashMap.newWithKeysValues(key1, value1).toImmutable();
    }

    @Override
    protected <T> ImmutableObjectFloatMap<T> newWithKeysValues(T key1, float value1, T key2, float value2) {
        return ObjectFloatHashMap.newWithKeysValues(key1, value1, key2, value2).toImmutable();
    }

    @Override
    protected <T> ImmutableObjectFloatMap<T> newWithKeysValues(T key1, float value1, T key2, float value2, T key3, float value3) {
        return ObjectFloatHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    protected <T> ImmutableObjectFloatMap<T> newWithKeysValues(T key1, float value1, T key2, float value2, T key3, float value3, T key4, float value4) {
        return ObjectFloatHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4).toImmutable();
    }

    @Override
    protected <T> ImmutableObjectFloatMap<T> getEmptyMap() {
        return new ObjectFloatHashMap<T>().toImmutable();
    }

    @Override
    @Test
    public void toImmutable() {
        super.toImmutable();
        ImmutableObjectFloatMap<String> map = this.classUnderTest();
        Assert.assertSame(map, map.toImmutable());
    }

    @Override
    @Test
    public void keySet() {
        super.keySet();
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().keySet().remove("0"));
    }

    @Override
    public void values() {
        super.values();
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0.0f));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(FloatObjectMaps.immutable.empty(), ObjectFloatMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableFloatObjectEmptyMap.class, ObjectFloatMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(FloatObjectMaps.immutable.with(2.0f, "1"), this.newWithKeysValues("1", 2.0f).flipUniqueValues());
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(2.0f, "1", 3.0f, "2").toImmutable(), this.newWithKeysValues("1", 2.0f, "2", 3.0f).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues("1", 1.0f, "2", 1.0f).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractObjectFloatMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutable, this.description("toImmutable"));
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
        public abstract AbstractImmutableObjectFloatMapTestCase implementation();
    }
}
