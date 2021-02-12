/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.immutable;

import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableQuadrupletonListTest extends AbstractImmutableListTestCase {

    @Override
    protected ImmutableList<Integer> classUnderTest() {
        return new ImmutableQuadrupletonList<>(1, 2, 3, 4);
    }

    @Override
    @Test
    public void distinct() {
        super.distinct();
        ImmutableList<Integer> list = new ImmutableQuadrupletonList<>(2, 1, 1, 2);
        ImmutableList<Integer> distinctList = list.distinct();
        Assert.assertFalse(distinctList.isEmpty());
        Verify.assertInstanceOf(ImmutableDoubletonList.class, distinctList);
        Assert.assertEquals(FastList.newListWith(2, 1), distinctList);
    }

    @Test
    public void distinctWithHashingStrategies() {
        ImmutableList<String> list = new ImmutableQuadrupletonList<>("a", "a", "B", "c");
        ImmutableList<String> distinctList = list.distinct(HashingStrategies.fromFunction(String::toLowerCase));
        Assert.assertFalse(distinctList.isEmpty());
        Assert.assertEquals(FastList.newListWith("a", "B", "c"), distinctList);
    }

    @Test(expected = IllegalStateException.class)
    public void getOnly() {
        ImmutableList<Integer> list = this.classUnderTest();
        list.getOnly();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::distinct, this.description("distinct"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctWithHashingStrategies() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::distinctWithHashingStrategies, this.description("distinctWithHashingStrategies"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::getOnly, this.description("getOnly"), java.lang.IllegalStateException.class);
        }

        private ImmutableQuadrupletonListTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableQuadrupletonListTest();
        }

        @java.lang.Override
        public ImmutableQuadrupletonListTest implementation() {
            return this.implementation;
        }
    }
}
