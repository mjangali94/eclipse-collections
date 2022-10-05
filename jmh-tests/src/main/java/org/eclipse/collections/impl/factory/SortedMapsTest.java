/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.factory;

import org.eclipse.collections.api.factory.map.sorted.MutableSortedMapFactory;
import org.junit.Assert;
import org.junit.Test;

public class SortedMapsTest {

    @Test
    public void mutables() {
        MutableSortedMapFactory factory = SortedMaps.mutable;
        Assert.assertEquals(SortedMaps.mutable.empty(), factory.empty());
        Assert.assertEquals(SortedMaps.mutable.empty(Integer::compare), factory.empty(Integer::compare));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::mutables, this.description("mutables"));
        }

        private SortedMapsTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SortedMapsTest();
        }

        @java.lang.Override
        public SortedMapsTest implementation() {
            return this.implementation;
        }
    }
}
