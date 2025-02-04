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

import org.eclipse.collections.impl.parallel.AbstractProcedureCombiner;

/**
 * Combines instances of SumProcedure.
 *
 * @deprecated Don't use in new tests
 */
@Deprecated
public final class SumCombiner<T> extends AbstractProcedureCombiner<SumProcedure<T>> {

    private static final long serialVersionUID = 1L;

    private final Sum sum;

    public SumCombiner(Sum initialSum) {
        super(true);
        this.sum = initialSum;
    }

    @Override
    public void combineOne(SumProcedure<T> sumProcedure) {
        this.sum.add(sumProcedure.getSum());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SumCombiner instance;

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SumCombiner> payload) throws java.lang.Throwable {
            this.instance = new SumCombiner();
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
