/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.mutable;

import java.io.Serializable;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.list.MutableList;
import org.junit.Assert;
import org.junit.Test;

public class MultiReaderFastListAsReadUntouchableTest extends UnmodifiableMutableListTestCase {

    @Override
    protected MutableList<Integer> getCollection() {
        return MultiReaderFastList.newListWith(1).asReadUntouchable();
    }

    @Override
    @Test
    public void serialization() {
        MutableCollection<Integer> collection = this.getCollection();
        Assert.assertFalse(collection instanceof Serializable);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::serialization, this.description("serialization"));
        }

        private MultiReaderFastListAsReadUntouchableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MultiReaderFastListAsReadUntouchableTest();
        }

        @java.lang.Override
        public MultiReaderFastListAsReadUntouchableTest implementation() {
            return this.implementation;
        }
    }
}
