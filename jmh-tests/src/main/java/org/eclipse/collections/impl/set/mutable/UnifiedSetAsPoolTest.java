/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.mutable;

import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class UnifiedSetAsPoolTest {

    private final UnifiedSet<Integer> staticPool = UnifiedSet.newSet();

    @Test
    public void getReturnsNullIfObjectIsNotPooled() {
        Assert.assertNull(this.staticPool.get(1));
    }

    @Test
    public void getReturnsOriginalObjectForIdenticalObject() {
        Integer firstPooledObject = 1;
        this.staticPool.put(firstPooledObject);
        Assert.assertSame(firstPooledObject, this.staticPool.get(firstPooledObject));
    }

    @Test
    public void getReturnsPooledObjectForEqualObject() {
        UnifiedSet<AlwaysEqual> pool = UnifiedSet.newSet();
        AlwaysEqual firstObject = new AlwaysEqual();
        pool.put(firstObject);
        // deliberate new instance
        AlwaysEqual equalObject = new AlwaysEqual();
        Assert.assertSame(firstObject, pool.get(equalObject));
    }

    private static final class AlwaysEqual {

        @Override
        public boolean equals(Object obj) {
            return obj != null;
        }

        @Override
        public int hashCode() {
            return 0;
        }
    }

    @Test
    public void putReturnsPassedInObject() {
        Integer firstObject = 1;
        Object returnedObject = this.staticPool.put(firstObject);
        Assert.assertSame(returnedObject, firstObject);
    }

    @Test
    public void putAndGetReturnOriginalPooledObjectForEqualObject() {
        AlwaysEqual firstObject = new AlwaysEqual();
        UnifiedSet<AlwaysEqual> pool = UnifiedSet.newSet();
        pool.put(firstObject);
        // deliberate new instance
        AlwaysEqual secondObject = new AlwaysEqual();
        Object returnedObject = pool.put(secondObject);
        Assert.assertSame(returnedObject, firstObject);
        Assert.assertSame(firstObject, pool.get(secondObject));
    }

    @Test
    public void removeFromPool() {
        Integer firstObject = 1;
        this.staticPool.put(firstObject);
        Integer returnedObject = this.staticPool.removeFromPool(firstObject);
        Assert.assertSame(returnedObject, firstObject);
        Verify.assertEmpty(this.staticPool);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnifiedSetAsPoolTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getReturnsNullIfObjectIsNotPooled() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getReturnsNullIfObjectIsNotPooled);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getReturnsOriginalObjectForIdenticalObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getReturnsOriginalObjectForIdenticalObject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getReturnsPooledObjectForEqualObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getReturnsPooledObjectForEqualObject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putReturnsPassedInObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putReturnsPassedInObject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAndGetReturnOriginalPooledObjectForEqualObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAndGetReturnOriginalPooledObjectForEqualObject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromPool() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromPool);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetAsPoolTest> payload) throws java.lang.Throwable {
            this.instance = new UnifiedSetAsPoolTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetAsPoolTest> getReturnsNullIfObjectIsNotPooled;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetAsPoolTest> getReturnsOriginalObjectForIdenticalObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetAsPoolTest> getReturnsPooledObjectForEqualObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetAsPoolTest> putReturnsPassedInObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetAsPoolTest> putAndGetReturnOriginalPooledObjectForEqualObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetAsPoolTest> removeFromPool;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.getReturnsNullIfObjectIsNotPooled = UnifiedSetAsPoolTest::getReturnsNullIfObjectIsNotPooled;
            this.payloads.getReturnsOriginalObjectForIdenticalObject = UnifiedSetAsPoolTest::getReturnsOriginalObjectForIdenticalObject;
            this.payloads.getReturnsPooledObjectForEqualObject = UnifiedSetAsPoolTest::getReturnsPooledObjectForEqualObject;
            this.payloads.putReturnsPassedInObject = UnifiedSetAsPoolTest::putReturnsPassedInObject;
            this.payloads.putAndGetReturnOriginalPooledObjectForEqualObject = UnifiedSetAsPoolTest::putAndGetReturnOriginalPooledObjectForEqualObject;
            this.payloads.removeFromPool = UnifiedSetAsPoolTest::removeFromPool;
        }
    }
}
