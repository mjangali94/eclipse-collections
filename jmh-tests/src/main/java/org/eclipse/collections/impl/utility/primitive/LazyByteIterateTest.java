/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.utility.primitive;

import org.eclipse.collections.api.LazyByteIterable;
import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.block.procedure.primitive.ByteProcedure;
import org.eclipse.collections.api.list.primitive.MutableByteList;
import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LazyByteIterate}.
 * This file was automatically generated from template file lazyPrimitiveIterateTest.stg.
 */
public class LazyByteIterateTest {

    private final ByteIterable iterable = ByteLists.mutable.with((byte) 1, (byte) 2, (byte) 3);

    @Test
    public void adapt() {
        Assert.assertEquals(this.iterable, LazyByteIterate.adapt(this.iterable).toList());
    }

    @Test
    public void collectIf() {
        Assert.assertEquals(this.iterable.collect(each -> each), LazyByteIterate.collectIf(this.iterable, each -> true, each -> each).toList());
    }

    @Test
    public void empty() {
        Assert.assertTrue(LazyByteIterate.empty().isEmpty());
    }

    @Test
    public void tap() {
        MutableByteList list = ByteLists.mutable.empty();
        LazyByteIterable byteIterable = LazyByteIterate.tap(this.iterable, (ByteProcedure) list::add);
        Assert.assertEquals(this.iterable, ByteLists.mutable.ofAll(byteIterable));
        Assert.assertEquals(this.iterable, list);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_adapt() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::adapt, this.description("adapt"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectIf, this.description("collectIf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::empty, this.description("empty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::tap, this.description("tap"));
        }

        private LazyByteIterateTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new LazyByteIterateTest();
        }

        @java.lang.Override
        public LazyByteIterateTest implementation() {
            return this.implementation;
        }
    }
}
