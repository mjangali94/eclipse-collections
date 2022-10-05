/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.procedure.primitive;

import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.list.primitive.ImmutableFloatList;
import org.eclipse.collections.api.list.primitive.MutableFloatList;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file CollectPrimitiveProcedureTest.stg.
 */
public class CollectFloatProcedureTest {

    @Test
    public void basicCase() {
        FloatFunction<String> stringToLengthFunction = (String string) -> string.length();
        MutableFloatList targetList = FloatLists.mutable.empty();
        CollectFloatProcedure<String> procedure = new CollectFloatProcedure(stringToLengthFunction, targetList);
        procedure.value("");
        procedure.value("0");
        procedure.value("00");
        ImmutableFloatList expected = FloatLists.immutable.with(0.0f, 1.0f, 2.0f);
        Assert.assertEquals(expected, targetList);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_basicCase() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::basicCase, this.description("basicCase"));
        }

        private CollectFloatProcedureTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new CollectFloatProcedureTest();
        }

        @java.lang.Override
        public CollectFloatProcedureTest implementation() {
            return this.implementation;
        }
    }
}
