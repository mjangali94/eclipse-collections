/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.mutable.primitive;

import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ByteHashBag}.
 * This file was automatically generated from template file primitiveHashBagTest.stg.
 */
public class ByteHashBagTest extends AbstractMutableByteBagTestCase {

    @Override
    protected final ByteHashBag classUnderTest() {
        return ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3);
    }

    @Override
    protected ByteHashBag newWith(byte... elements) {
        return ByteHashBag.newBagWith(elements);
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(0, new ByteHashBag(3));
        Verify.assertSize(0, ByteHashBag.newBag(3));
        Verify.assertSize(3, ByteHashBag.newBagWith((byte) 0, (byte) 1, (byte) 2));
        Verify.assertSize(3, new ByteHashBag(ByteHashBag.newBagWith((byte) 0, (byte) 1, (byte) 2)));
        Verify.assertSize(3, ByteHashBag.newBag(ByteHashBag.newBagWith((byte) 0, (byte) 1, (byte) 2)));
        Verify.assertSize(3, ByteHashBag.newBag(ByteArrayList.newListWith((byte) 0, (byte) 1, (byte) 2)));
        Verify.assertSize(3, new ByteHashBag(ByteArrayList.newListWith((byte) 0, (byte) 1, (byte) 2)));
    }

    @Override
    @Test
    public void with() {
        super.with();
        ByteHashBag hashBag = new ByteHashBag().with((byte) 1);
        ByteHashBag hashBag0 = new ByteHashBag().with((byte) 1, (byte) 2);
        ByteHashBag hashBag1 = new ByteHashBag().with((byte) 1, (byte) 2, (byte) 3);
        ByteHashBag hashBag2 = new ByteHashBag().with((byte) 1).with((byte) 2).with((byte) 3).with((byte) 4);
        ByteHashBag hashBag3 = new ByteHashBag().with((byte) 1).with((byte) 2).with((byte) 3).with((byte) 4).with((byte) 5);
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1), hashBag);
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2), hashBag0);
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), hashBag1);
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3, (byte) 4), hashBag2);
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), hashBag3);
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        ByteHashBag hashBag = ByteHashBag.newBagWith((byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 3);
        Byte sum = hashBag.injectInto(Byte.valueOf((byte) 4), (Byte result, byte value) -> Byte.valueOf((byte) (result + value)));
        Assert.assertEquals(Byte.valueOf((byte) 17), sum);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.bag.mutable.primitive.AbstractMutableByteBagTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::size, this.description("size"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::with, this.description("with"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectInto, this.description("injectInto"));
        }

        private ByteHashBagTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ByteHashBagTest();
        }

        @java.lang.Override
        public ByteHashBagTest implementation() {
            return this.implementation;
        }
    }
}
