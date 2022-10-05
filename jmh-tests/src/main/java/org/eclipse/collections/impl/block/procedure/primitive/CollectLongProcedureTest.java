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

import org.eclipse.collections.api.block.function.primitive.LongFunction;
import org.eclipse.collections.api.list.primitive.ImmutableLongList;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file CollectPrimitiveProcedureTest.stg.
 */
public class CollectLongProcedureTest {

    @Test
    public void basicCase() {
        LongFunction<String> stringToLengthFunction = (String string) -> string.length();
        MutableLongList targetList = LongLists.mutable.empty();
        CollectLongProcedure<String> procedure = new CollectLongProcedure(stringToLengthFunction, targetList);
        procedure.value("");
        procedure.value("0");
        procedure.value("00");
        ImmutableLongList expected = LongLists.immutable.with(0L, 1L, 2L);
        Assert.assertEquals(expected, targetList);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_basicCase() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::basicCase, this.description("basicCase"));
        }

        private CollectLongProcedureTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new CollectLongProcedureTest();
        }

        @java.lang.Override
        public CollectLongProcedureTest implementation() {
            return this.implementation;
        }
    }
}
