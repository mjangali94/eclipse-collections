/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl;

public final class IntegerWithCast {

    private final int value;

    public IntegerWithCast(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        IntegerWithCast that = (IntegerWithCast) o;
        return this.value == that.value;
    }

    @Override
    public int hashCode() {
        return this.value;
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private IntegerWithCast instance;

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<IntegerWithCast> payload) throws java.lang.Throwable {
            this.instance = new IntegerWithCast();
            payload.accept(this.instance);
        }

        private static class _Payloads {
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
        }
    }
}
