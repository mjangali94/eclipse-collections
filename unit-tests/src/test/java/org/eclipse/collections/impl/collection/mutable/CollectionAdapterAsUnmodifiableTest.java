/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.collection.mutable;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.partition.PartitionMutableCollection;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.Functions2;
import org.junit.Assert;
import org.junit.Test;

public class CollectionAdapterAsUnmodifiableTest extends UnmodifiableMutableCollectionTestCase<Integer> {

    @Override
    protected MutableCollection<Integer> getCollection() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        return new CollectionAdapter<>(list).asUnmodifiable();
    }

    @Override
    @Test
    public void select() {
        Assert.assertEquals(this.getCollection().toList(), this.getCollection().select(ignored -> true));
        Assert.assertNotEquals(this.getCollection().toList(), this.getCollection().select(ignored -> false));
    }

    @Override
    @Test
    public void selectWith() {
        Assert.assertEquals(this.getCollection().toList(), this.getCollection().selectWith((ignored1, ignored2) -> true, null));
        Assert.assertNotEquals(this.getCollection().toList(), this.getCollection().selectWith((ignored1, ignored2) -> false, null));
    }

    @Override
    @Test
    public void reject() {
        Assert.assertEquals(this.getCollection().toList(), this.getCollection().reject(ignored1 -> false));
        Assert.assertNotEquals(this.getCollection().toList(), this.getCollection().reject(ignored -> true));
    }

    @Override
    @Test
    public void rejectWith() {
        Assert.assertEquals(this.getCollection().toList(), this.getCollection().rejectWith((ignored11, ignored21) -> false, null));
        Assert.assertNotEquals(this.getCollection().toList(), this.getCollection().rejectWith((ignored1, ignored2) -> true, null));
    }

    @Override
    @Test
    public void partition() {
        PartitionMutableCollection<?> partition = this.getCollection().partition(ignored -> true);
        Assert.assertEquals(this.getCollection().toList(), partition.getSelected());
        Assert.assertNotEquals(this.getCollection().toList(), partition.getRejected());
    }

    @Override
    @Test
    public void partitionWith() {
        PartitionMutableCollection<?> partition = this.getCollection().partitionWith((ignored1, ignored2) -> true, null);
        Assert.assertEquals(this.getCollection().toList(), partition.getSelected());
        Assert.assertNotEquals(this.getCollection().toList(), partition.getRejected());
    }

    @Override
    @Test
    public void collect() {
        Assert.assertEquals(this.getCollection().toList(), this.getCollection().collect(Functions.getPassThru()));
        Assert.assertNotEquals(this.getCollection().toList(), this.getCollection().collect(Object::getClass));
    }

    @Override
    @Test
    public void collectWith() {
        Assert.assertEquals(this.getCollection().toList(), this.getCollection().collectWith(Functions2.fromFunction(Functions.getPassThru()), null));
        Assert.assertNotEquals(this.getCollection().toList(), this.getCollection().collectWith(Functions2.fromFunction(Object::getClass), null));
    }

    @Override
    @Test
    public void collectIf() {
        Assert.assertEquals(this.getCollection().toList(), this.getCollection().collectIf(ignored -> true, Functions.getPassThru()));
        Assert.assertNotEquals(this.getCollection().toList(), this.getCollection().collectIf(ignored -> false, Object::getClass));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::select, this.description("select"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectWith, this.description("selectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reject, this.description("reject"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::rejectWith, this.description("rejectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::partition, this.description("partition"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::partitionWith, this.description("partitionWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect, this.description("collect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectWith, this.description("collectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectIf, this.description("collectIf"));
        }

        private CollectionAdapterAsUnmodifiableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new CollectionAdapterAsUnmodifiableTest();
        }

        @java.lang.Override
        public CollectionAdapterAsUnmodifiableTest implementation() {
            return this.implementation;
        }
    }
}
