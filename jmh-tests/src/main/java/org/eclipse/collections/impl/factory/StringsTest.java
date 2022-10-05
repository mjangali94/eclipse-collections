/*
 * Copyright (c) 2021 The Bank of New York Mellon.
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
    public static class _Benchmark {

        private _Payloads payloads;

        private StringsTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asChars() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asChars);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toChars() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toChars);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asCodePoints() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asCodePoints);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toCodePoints() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toCodePoints);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<StringsTest> payload) throws java.lang.Throwable {
            this.instance = new StringsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringsTest> asChars;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringsTest> toChars;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringsTest> asCodePoints;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringsTest> toCodePoints;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.asChars = StringsTest::asChars;
            this.payloads.toChars = StringsTest::toChars;
            this.payloads.asCodePoints = StringsTest::asCodePoints;
            this.payloads.toCodePoints = StringsTest::toCodePoints;
        }
    }
}
