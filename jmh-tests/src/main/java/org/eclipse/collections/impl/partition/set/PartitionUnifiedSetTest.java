/*
 * Copyright (c) 2022 The Bank of New York Mellon.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.partition.set;

import org.eclipse.collections.api.factory.Sets;
import org.eclipse.collections.api.partition.set.PartitionImmutableSet;
import org.eclipse.collections.api.partition.set.PartitionMutableSet;
import org.eclipse.collections.api.set.MutableSet;
import org.junit.Assert;
import org.junit.Test;

public class PartitionUnifiedSetTest {

    @Test
    public void toImmutable() {
        PartitionMutableSet<Integer> partitionMutableSet = new PartitionUnifiedSet<>();
        MutableSet<Integer> selected = Sets.mutable.of(1, 2, 3);
        MutableSet<Integer> rejected = Sets.mutable.of(4, 5, 6);
        partitionMutableSet.getSelected().addAll(selected);
        partitionMutableSet.getRejected().addAll(rejected);
        PartitionImmutableSet<Integer> integerPartitionImmutableSet = partitionMutableSet.toImmutable();
        Assert.assertEquals(selected, integerPartitionImmutableSet.getSelected());
        Assert.assertEquals(rejected, integerPartitionImmutableSet.getRejected());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutable, this.description("toImmutable"));
        }

        private PartitionUnifiedSetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new PartitionUnifiedSetTest();
        }

        @java.lang.Override
        public PartitionUnifiedSetTest implementation() {
            return this.implementation;
        }
    }
}
