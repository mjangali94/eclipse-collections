/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.mutable;

public class UnifiedSetOverridesTest extends UnifiedSetTest {

    public static class UnifiedSetOverriddes<T> extends UnifiedSet<T> {

        public UnifiedSetOverriddes(int size) {
            super(size);
        }

        @Override
        protected int index(Object key) {
            int h = key == null ? 0 : key.hashCode();
            return h & this.table.length - 1;
        }

        @Override
        public UnifiedSetOverriddes<T> newEmpty(int size) {
            return new UnifiedSetOverriddes<>(size);
        }
    }

    @Override
    protected <T> UnifiedSet<T> newWith(T... littleElements) {
        UnifiedSet<T> set = new UnifiedSetOverriddes<>(littleElements.length);
        return set.with(littleElements);
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        private UnifiedSetOverridesTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new UnifiedSetOverridesTest();
        }

        @java.lang.Override
        public UnifiedSetOverridesTest implementation() {
            return this.implementation;
        }
    }
}
