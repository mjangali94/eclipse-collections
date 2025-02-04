/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.math;

import java.io.Serializable;

/**
 * A sum is a mutable or immutable object that may have either other objects or values added to it.
 *
 * @deprecated Don't use in new tests
 */
@Deprecated
public interface Sum extends Serializable {

    Sum add(Object number);

    Sum add(Number number);

    Sum add(Sum otherSum);

    Sum add(int value);

    Number getValue();

    Sum speciesNew();

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private Sum instance;

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<Sum> payload) throws java.lang.Throwable {
            this.instance = new Sum();
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
