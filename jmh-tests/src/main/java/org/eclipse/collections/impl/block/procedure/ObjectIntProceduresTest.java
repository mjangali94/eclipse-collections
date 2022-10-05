/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.procedure;

import org.eclipse.collections.api.block.procedure.primitive.ObjectIntProcedure;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.block.factory.ObjectIntProcedures;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class ObjectIntProceduresTest {

    @Test
    public void fromObjectIntProcedure() {
        MutableList<Integer> result = FastList.newList();
        ObjectIntProcedure<Integer> objectIntProcedure = ObjectIntProcedures.fromProcedure(result::add);
        objectIntProcedure.value(1, 0);
        Assert.assertEquals(FastList.newListWith(1), result);
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ObjectIntProcedures.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectIntProceduresTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_fromObjectIntProcedure() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.fromObjectIntProcedure);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntProceduresTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectIntProceduresTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntProceduresTest> fromObjectIntProcedure;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntProceduresTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.fromObjectIntProcedure = ObjectIntProceduresTest::fromObjectIntProcedure;
            this.payloads.classIsNonInstantiable = ObjectIntProceduresTest::classIsNonInstantiable;
        }
    }
}
