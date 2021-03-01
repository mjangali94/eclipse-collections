/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.procedure.checked;

import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.Iterator;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.multimap.list.FastListMultimap;
import org.junit.Assert;
import org.junit.Test;

public class MultimapKeyValuesSerializingProcedureTest {

    @Test
    public void testSerialization() {
        FastListMultimap<String, String> map = new FastListMultimap<>();
        map.put("A", "alpha");
        map.put("A", "beta");
        FastList<? extends Serializable> expectedWrites = FastList.newListWith("A", 2, "alpha", "beta");
        MultimapKeyValuesSerializingProcedure<String, String> procedure = new MultimapKeyValuesSerializingProcedure<>(new MockObjectOutput(expectedWrites));
        map.toMap().forEachKeyValue(procedure);
    }

    public static final class MockObjectOutput implements ObjectOutput {

        private final Iterator<? extends Serializable> iterator;

        public MockObjectOutput(Iterable<? extends Serializable> expectedWrites) {
            this.iterator = expectedWrites.iterator();
        }

        @Override
        public void writeObject(Object obj) {
            Assert.assertEquals(this.iterator.next(), obj);
        }

        @Override
        public void writeInt(int v) {
            Assert.assertEquals(this.iterator.next(), v);
        }

        @Override
        public void write(int i) {
            throw new RuntimeException("write not implemented");
        }

        @Override
        public void write(byte[] bs) {
            throw new RuntimeException("write not implemented");
        }

        @Override
        public void write(byte[] bs, int off, int len) {
            throw new RuntimeException("write not implemented");
        }

        @Override
        public void writeBoolean(boolean v) {
            throw new RuntimeException("writeBoolean not implemented");
        }

        @Override
        public void writeByte(int v) {
            throw new RuntimeException("writeByte not implemented");
        }

        @Override
        public void writeShort(int v) {
            throw new RuntimeException("writeShort not implemented");
        }

        @Override
        public void writeChar(int v) {
            throw new RuntimeException("writeChar not implemented");
        }

        @Override
        public void writeLong(long v) {
            throw new RuntimeException("writeLong not implemented");
        }

        @Override
        public void writeFloat(float v) {
            throw new RuntimeException("writeFloat not implemented");
        }

        @Override
        public void writeDouble(double v) {
            throw new RuntimeException("writeDouble not implemented");
        }

        @Override
        public void writeBytes(String s) {
            throw new RuntimeException("writeBytes not implemented");
        }

        @Override
        public void writeChars(String s) {
            throw new RuntimeException("writeChars not implemented");
        }

        @Override
        public void writeUTF(String s) {
            throw new RuntimeException("writeUTF not implemented");
        }

        @Override
        public void flush() {
            throw new RuntimeException("flush not implemented");
        }

        @Override
        public void close() {
            throw new RuntimeException("close not implemented");
        }
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSerialization() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testSerialization, this.description("testSerialization"));
        }

        private MultimapKeyValuesSerializingProcedureTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MultimapKeyValuesSerializingProcedureTest();
        }

        @java.lang.Override
        public MultimapKeyValuesSerializingProcedureTest implementation() {
            return this.implementation;
        }
    }
}
