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
    public static class _Benchmark {

        private _Payloads payloads;

        private PartitionUnifiedSetTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<PartitionUnifiedSetTest> payload) throws java.lang.Throwable {
            this.instance = new PartitionUnifiedSetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PartitionUnifiedSetTest> toImmutable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toImmutable = PartitionUnifiedSetTest::toImmutable;
        }
    }
}
