/*
 * Copyright (c) 2021 The Bank of New York Mellon.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.partition.list;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.partition.list.PartitionImmutableList;
import org.eclipse.collections.api.partition.list.PartitionMutableList;
import org.junit.Assert;
import org.junit.Test;

public class PartitionFastListTest {

    @Test
    public void toImmutable() {
        MutableList<Integer> selected = Lists.mutable.of(1, 2, 3);
        MutableList<Integer> rejected = Lists.mutable.of(4, 5, 6);
        PartitionMutableList<Integer> partitionedList = new PartitionFastList<>();
        partitionedList.getSelected().addAll(selected);
        partitionedList.getRejected().addAll(rejected);
        PartitionImmutableList<Integer> immutable = partitionedList.toImmutable();
        Assert.assertEquals(selected, immutable.getSelected());
        Assert.assertEquals(rejected, immutable.getRejected());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private PartitionFastListTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<PartitionFastListTest> payload) throws java.lang.Throwable {
            this.instance = new PartitionFastListTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PartitionFastListTest> toImmutable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toImmutable = PartitionFastListTest::toImmutable;
        }
    }
}
