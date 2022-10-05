/*
 * Copyright (c) 2021 The Bank of New York Mellon.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.procedure;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.junit.Assert;
import org.junit.Test;

public class FastListSelectProcedureTest {

    @Test
    public void value() {
        FastListSelectProcedure<Integer> procedure = new FastListSelectProcedure<>(Predicates.greaterThan(5), FastList.newList());
        procedure.value(0);
        procedure.value(1);
        procedure.value(10);
        procedure.value(20);
        Assert.assertEquals(Lists.mutable.of(10, 20), procedure.getFastList());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_value() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::value, this.description("value"));
        }

        private FastListSelectProcedureTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new FastListSelectProcedureTest();
        }

        @java.lang.Override
        public FastListSelectProcedureTest implementation() {
            return this.implementation;
        }
    }
}
