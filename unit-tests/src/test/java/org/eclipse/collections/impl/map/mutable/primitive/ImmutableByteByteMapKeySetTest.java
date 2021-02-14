/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable.primitive;

import org.eclipse.collections.api.set.primitive.ByteSet;
import org.eclipse.collections.api.set.primitive.ImmutableByteSet;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableByteHashSetTestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableByteSet} created from the freeze() method.
 */
public class ImmutableByteByteMapKeySetTest extends AbstractImmutableByteHashSetTestCase {

    protected static ByteArrayList generateCollisions() {
        ByteArrayList collisions = new ByteArrayList();
        ImmutableByteByteMapKeySet set = (ImmutableByteByteMapKeySet) new ByteByteHashMap().keySet().freeze();
        for (byte i = 2; collisions.size() <= 10; i++) {
            if (set.spreadAndMask(i) == set.spreadAndMask((byte) 2)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Override
    protected ImmutableByteSet classUnderTest() {
        return (ImmutableByteSet) ByteByteHashMap.newWithKeysValues((byte) 1, (byte) -1, (byte) 2, (byte) 2, (byte) 3, (byte) 4).keySet().freeze();
    }

    @Override
    protected ImmutableByteSet newWith(byte... elements) {
        ByteByteHashMap byteByteHashMap = new ByteByteHashMap();
        for (byte element : elements) {
            byteByteHashMap.put(element, element);
        }
        return (ImmutableByteSet) byteByteHashMap.keySet().freeze();
    }

    @Test
    @Override
    public void contains() {
        super.contains();
        byte collision1 = ImmutableByteByteMapKeySetTest.generateCollisions().getFirst();
        byte collision2 = ImmutableByteByteMapKeySetTest.generateCollisions().get(1);
        ByteByteHashMap byteByteHashMap = ByteByteHashMap.newWithKeysValues(collision1, (byte) 0, collision2, (byte) 0);
        byteByteHashMap.removeKey(collision2);
        ByteSet byteSet = byteByteHashMap.keySet().freeze();
        Assert.assertTrue(byteSet.contains(collision1));
        Assert.assertFalse(byteSet.contains(collision2));
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::contains, this.description("contains"));
        }

        private ImmutableByteByteMapKeySetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableByteByteMapKeySetTest();
        }

        @java.lang.Override
        public ImmutableByteByteMapKeySetTest implementation() {
            return this.implementation;
        }
    }
}
