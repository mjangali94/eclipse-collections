/*
 * Copyright (c) 2021 The Bank of New York Mellon.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.api.block.function;

import org.eclipse.collections.impl.block.factory.Functions0;
import org.junit.Assert;
import org.junit.Test;

public class Function0Test {

    @Test
    public void get() {
        Function0<Boolean> alwaysTrueFunction = Functions0.getTrue();
        Assert.assertTrue(alwaysTrueFunction.get());
        Function0<Boolean> alwaysFalseFunction = Functions0.getFalse();
        Assert.assertFalse(alwaysFalseFunction.get());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::get, this.description("get"));
        }

        private Function0Test implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new Function0Test();
        }

        @java.lang.Override
        public Function0Test implementation() {
            return this.implementation;
        }
    }
}
