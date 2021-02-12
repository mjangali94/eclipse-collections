/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.utility.primitive;

import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.impl.factory.primitive.BooleanLists;
import org.junit.Assert;
import org.junit.Test;

public class LazyBooleanIterateTest {

    private final BooleanIterable iterable = BooleanLists.mutable.with(true, false);

    @Test
    public void adapt() {
        Assert.assertEquals(this.iterable, LazyBooleanIterate.adapt(this.iterable).toList());
    }

    @Test
    public void collectIf() {
        Assert.assertEquals(this.iterable.collect(each -> each), LazyBooleanIterate.collectIf(this.iterable, each -> true, each -> each).toList());
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

        private LazyBooleanIterateTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new LazyBooleanIterateTest();
        }

        @java.lang.Override
        public LazyBooleanIterateTest implementation() {
            return this.implementation;
        }
    }
}
