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

import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link DoubleHashBag}.
 * This file was automatically generated from template file primitiveHashBagTest.stg.
 */
public class DoubleHashBagTest extends AbstractMutableDoubleBagTestCase {

    @Override
    protected final DoubleHashBag classUnderTest() {
        return DoubleHashBag.newBagWith(1.0, 2.0, 3.0);
    }

    @Override
    protected DoubleHashBag newWith(double... elements) {
        return DoubleHashBag.newBagWith(elements);
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(0, new DoubleHashBag(3));
        Verify.assertSize(0, DoubleHashBag.newBag(3));
        Verify.assertSize(3, DoubleHashBag.newBagWith(0.0, 1.0, 2.0));
        Verify.assertSize(3, new DoubleHashBag(DoubleHashBag.newBagWith(0.0, 1.0, 2.0)));
        Verify.assertSize(3, DoubleHashBag.newBag(DoubleHashBag.newBagWith(0.0, 1.0, 2.0)));
        Verify.assertSize(3, DoubleHashBag.newBag(DoubleArrayList.newListWith(0.0, 1.0, 2.0)));
        Verify.assertSize(3, new DoubleHashBag(DoubleArrayList.newListWith(0.0, 1.0, 2.0)));
    }

    @Override
    @Test
    public void with() {
        super.with();
        DoubleHashBag hashBag = new DoubleHashBag().with(1.0);
        DoubleHashBag hashBag0 = new DoubleHashBag().with(1.0, 2.0);
        DoubleHashBag hashBag1 = new DoubleHashBag().with(1.0, 2.0, 3.0);
        DoubleHashBag hashBag2 = new DoubleHashBag().with(1.0).with(2.0).with(3.0).with(4.0);
        DoubleHashBag hashBag3 = new DoubleHashBag().with(1.0).with(2.0).with(3.0).with(4.0).with(5.0);
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0), hashBag);
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0), hashBag0);
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), hashBag1);
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0, 4.0), hashBag2);
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0, 4.0, 5.0), hashBag3);
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        DoubleHashBag hashBag = DoubleHashBag.newBagWith(1.0, 1.0, 2.0, 2.0, 2.0, 2.0, 3.0);
        Double sum = hashBag.injectInto(Double.valueOf(4.0), (Double result, double value) -> Double.valueOf((double) (result + value)));
        Assert.assertEquals(Double.valueOf(17.0), sum);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.bag.mutable.primitive.AbstractMutableDoubleBagTestCase._Benchmark {

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

        private DoubleHashBagTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new DoubleHashBagTest();
        }

        @java.lang.Override
        public DoubleHashBagTest implementation() {
            return this.implementation;
        }
    }
}
