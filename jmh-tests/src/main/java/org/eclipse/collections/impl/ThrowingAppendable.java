/*
 * Copyright (c) 2021 The Bank of New York Mellon.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl;

import java.io.IOException;

public class ThrowingAppendable implements Appendable {

    @Override
    public Appendable append(CharSequence csq) throws IOException {
        throw new IOException();
    }

    @Override
    public Appendable append(CharSequence csq, int start, int end) throws IOException {
        throw new IOException();
    }

    @Override
    public Appendable append(char c) throws IOException {
        throw new IOException();
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ThrowingAppendable instance;

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ThrowingAppendable> payload) throws java.lang.Throwable {
            this.instance = new ThrowingAppendable();
            payload.accept(this.instance);
        }

        private static class _Payloads {
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
        }
    }
*/
}
