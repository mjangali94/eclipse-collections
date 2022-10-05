/*
 * Copyright (c) 2022 The Bank of New York Mellon.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.partition.stack;

import org.eclipse.collections.api.partition.stack.PartitionImmutableStack;
import org.eclipse.collections.api.partition.stack.PartitionMutableStack;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.junit.Assert;
import org.junit.Test;

public class PartitionArrayStackTest {

    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        new PartitionArrayStack<Integer>().add(4);
    }

    @Test
    public void toImmutable() {
        PartitionMutableStack<Integer> partitionMutableStack = ArrayStack.newStackFromTopToBottom(1, 2, 3, 4, 5, 6).partition(Predicates.lessThan(4));
        PartitionImmutableStack<Integer> partitionImmutableStack = partitionMutableStack.toImmutable();
        Assert.assertEquals(ArrayStack.newStackFromTopToBottom(1, 2, 3), partitionImmutableStack.getSelected());
        Assert.assertEquals(ArrayStack.newStackFromTopToBottom(4, 5, 6), partitionImmutableStack.getRejected());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::add, this.description("add"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutable, this.description("toImmutable"));
        }

        private PartitionArrayStackTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new PartitionArrayStackTest();
        }

        @java.lang.Override
        public PartitionArrayStackTest implementation() {
            return this.implementation;
        }
    }
}
