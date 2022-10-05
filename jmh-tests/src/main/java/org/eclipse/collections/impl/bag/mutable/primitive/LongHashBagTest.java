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

import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LongHashBag}.
 * This file was automatically generated from template file primitiveHashBagTest.stg.
 */
public class LongHashBagTest extends AbstractMutableLongBagTestCase {

    @Override
    protected final LongHashBag classUnderTest() {
        return LongHashBag.newBagWith(1L, 2L, 3L);
    }

    @Override
    protected LongHashBag newWith(long... elements) {
        return LongHashBag.newBagWith(elements);
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(0, new LongHashBag(3));
        Verify.assertSize(0, LongHashBag.newBag(3));
        Verify.assertSize(3, LongHashBag.newBagWith(0L, 1L, 2L));
        Verify.assertSize(3, new LongHashBag(LongHashBag.newBagWith(0L, 1L, 2L)));
        Verify.assertSize(3, LongHashBag.newBag(LongHashBag.newBagWith(0L, 1L, 2L)));
        Verify.assertSize(3, LongHashBag.newBag(LongArrayList.newListWith(0L, 1L, 2L)));
        Verify.assertSize(3, new LongHashBag(LongArrayList.newListWith(0L, 1L, 2L)));
    }

    @Override
    @Test
    public void with() {
        super.with();
        LongHashBag hashBag = new LongHashBag().with(1L);
        LongHashBag hashBag0 = new LongHashBag().with(1L, 2L);
        LongHashBag hashBag1 = new LongHashBag().with(1L, 2L, 3L);
        LongHashBag hashBag2 = new LongHashBag().with(1L).with(2L).with(3L).with(4L);
        LongHashBag hashBag3 = new LongHashBag().with(1L).with(2L).with(3L).with(4L).with(5L);
        Assert.assertEquals(LongHashBag.newBagWith(1L), hashBag);
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L), hashBag0);
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), hashBag1);
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L, 4L), hashBag2);
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L, 4L, 5L), hashBag3);
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        LongHashBag hashBag = LongHashBag.newBagWith(1L, 1L, 2L, 2L, 2L, 2L, 3L);
        Long sum = hashBag.injectInto(Long.valueOf(4L), (Long result, long value) -> Long.valueOf((long) (result + value)));
        Assert.assertEquals(Long.valueOf(17L), sum);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.bag.mutable.primitive.AbstractMutableLongBagTestCase._Benchmark {

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

        private LongHashBagTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new LongHashBagTest();
        }

        @java.lang.Override
        public LongHashBagTest implementation() {
            return this.implementation;
        }
    }
}
