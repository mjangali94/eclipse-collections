/*
 * Copyright (c) 2020 The Bank of New York Mellon.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.factory;

import org.eclipse.collections.impl.string.immutable.CharAdapter;
import org.eclipse.collections.impl.string.immutable.CodePointAdapter;
import org.junit.Assert;
import org.junit.Test;

public class StringsTest {

    @Test
    public void asChars() {
        CharAdapter adapter = Strings.asChars("The quick brown fox jumps over the lazy dog.");
        Assert.assertTrue(adapter.contains('T'));
    }

    @Test
    public void toChars() {
        CharAdapter adapter = Strings.toChars('H', 'e', 'l', 'l', 'o');
        Assert.assertEquals(2, adapter.count(c -> c == 'l'));
    }

    @Test
    public void asCodePoints() {
        CodePointAdapter adapter = Strings.asCodePoints("The quick brown fox jumps over the lazy dog.");
        Assert.assertTrue(adapter.contains((int) 'T'));
    }

    @Test
    public void toCodePoints() {
        CodePointAdapter adapter = Strings.toCodePoints((int) 'H', (int) 'e', (int) 'l', (int) 'l', (int) 'o');
        Assert.assertEquals(2, adapter.count(i -> i == (int) 'l'));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asChars() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asChars, this.description("asChars"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toChars() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toChars, this.description("toChars"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asCodePoints() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asCodePoints, this.description("asCodePoints"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toCodePoints() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toCodePoints, this.description("toCodePoints"));
        }

        private StringsTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new StringsTest();
        }

        @java.lang.Override
        public StringsTest implementation() {
            return this.implementation;
        }
    }
}
