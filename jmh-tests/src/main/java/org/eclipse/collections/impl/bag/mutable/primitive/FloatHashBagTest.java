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

import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link FloatHashBag}.
 * This file was automatically generated from template file primitiveHashBagTest.stg.
 */
public class FloatHashBagTest extends AbstractMutableFloatBagTestCase {

    @Override
    protected final FloatHashBag classUnderTest() {
        return FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f);
    }

    @Override
    protected FloatHashBag newWith(float... elements) {
        return FloatHashBag.newBagWith(elements);
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(0, new FloatHashBag(3));
        Verify.assertSize(0, FloatHashBag.newBag(3));
        Verify.assertSize(3, FloatHashBag.newBagWith(0.0f, 1.0f, 2.0f));
        Verify.assertSize(3, new FloatHashBag(FloatHashBag.newBagWith(0.0f, 1.0f, 2.0f)));
        Verify.assertSize(3, FloatHashBag.newBag(FloatHashBag.newBagWith(0.0f, 1.0f, 2.0f)));
        Verify.assertSize(3, FloatHashBag.newBag(FloatArrayList.newListWith(0.0f, 1.0f, 2.0f)));
        Verify.assertSize(3, new FloatHashBag(FloatArrayList.newListWith(0.0f, 1.0f, 2.0f)));
    }

    @Override
    @Test
    public void with() {
        super.with();
        FloatHashBag hashBag = new FloatHashBag().with(1.0f);
        FloatHashBag hashBag0 = new FloatHashBag().with(1.0f, 2.0f);
        FloatHashBag hashBag1 = new FloatHashBag().with(1.0f, 2.0f, 3.0f);
        FloatHashBag hashBag2 = new FloatHashBag().with(1.0f).with(2.0f).with(3.0f).with(4.0f);
        FloatHashBag hashBag3 = new FloatHashBag().with(1.0f).with(2.0f).with(3.0f).with(4.0f).with(5.0f);
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f), hashBag);
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f), hashBag0);
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), hashBag1);
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f, 4.0f), hashBag2);
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f), hashBag3);
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        FloatHashBag hashBag = FloatHashBag.newBagWith(1.0f, 1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 3.0f);
        Float sum = hashBag.injectInto(Float.valueOf(4.0f), (Float result, float value) -> Float.valueOf((float) (result + value)));
        Assert.assertEquals(Float.valueOf(17.0f), sum);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.bag.mutable.primitive.AbstractMutableFloatBagTestCase._Benchmark {

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

        private FloatHashBagTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new FloatHashBagTest();
        }

        @java.lang.Override
        public FloatHashBagTest implementation() {
            return this.implementation;
        }
    }
}
