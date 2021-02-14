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

import org.eclipse.collections.api.block.HashingStrategy;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.set.strategy.mutable.UnifiedSetWithHashingStrategy;

public class UnifiedSetWithHashingStrategyOverridesTest extends UnifiedSetWithHashingStrategyTest {

    public static class UnifiedSetWithHashingStrategyOverrides<T> extends UnifiedSetWithHashingStrategy<T> {

        public UnifiedSetWithHashingStrategyOverrides(HashingStrategy<? super T> hashingStrategy, int initialCapacity) {
            super(hashingStrategy, initialCapacity);
        }

        @Override
        protected int index(T key) {
            int h = this.hashingStrategy.computeHashCode(key);
            return h & this.table.length - 1;
        }

        @Override
        public UnifiedSetWithHashingStrategyOverrides<T> newEmpty() {
            return new UnifiedSetWithHashingStrategyOverrides<>(this.hashingStrategy, 0);
        }

        @Override
        public UnifiedSetWithHashingStrategyOverrides<T> newEmpty(int size) {
            return new UnifiedSetWithHashingStrategyOverrides<>(this.hashingStrategy, size);
        }
    }

    @Override
    protected <T> MutableSet<T> newWith(T... littleElements) {
        HashingStrategy<T> nshs = HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy());
        UnifiedSetWithHashingStrategyOverrides<T> set = new UnifiedSetWithHashingStrategyOverrides<>(nshs, littleElements.length);
        return set.with(littleElements);
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        private UnifiedSetWithHashingStrategyOverridesTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new UnifiedSetWithHashingStrategyOverridesTest();
        }

        @java.lang.Override
        public UnifiedSetWithHashingStrategyOverridesTest implementation() {
            return this.implementation;
        }
    }
}
