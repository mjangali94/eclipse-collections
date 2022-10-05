/*
 * Copyright (c) 2022 The Bank of New York Mellon.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.partition.bag.sorted;

import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.api.factory.SortedBags;
import org.eclipse.collections.api.partition.bag.sorted.PartitionImmutableSortedBag;
import org.eclipse.collections.api.partition.bag.sorted.PartitionMutableSortedBag;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.junit.Assert;
import org.junit.Test;

public class PartitionTreeBagTest {

    @Test
    public void toImmutable() {
        PartitionMutableSortedBag<Integer> partitionTreeBag = new PartitionTreeBag<>(Comparators.naturalOrder());
        MutableSortedBag<Integer> selected = SortedBags.mutable.of(1, 2, 3);
        MutableSortedBag<Integer> rejected = SortedBags.mutable.of(4, 5, 6);
        partitionTreeBag.getSelected().addAll(selected);
        partitionTreeBag.getRejected().addAll(rejected);
        PartitionImmutableSortedBag<Integer> immutableSortedBag = partitionTreeBag.toImmutable();
        Assert.assertEquals(selected, immutableSortedBag.getSelected());
        Assert.assertEquals(rejected, immutableSortedBag.getRejected());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutable, this.description("toImmutable"));
        }

        private PartitionTreeBagTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new PartitionTreeBagTest();
        }

        @java.lang.Override
        public PartitionTreeBagTest implementation() {
            return this.implementation;
        }
    }
}
