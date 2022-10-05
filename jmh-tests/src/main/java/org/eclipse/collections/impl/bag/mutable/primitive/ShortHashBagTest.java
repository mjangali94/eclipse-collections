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

import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ShortHashBag}.
 * This file was automatically generated from template file primitiveHashBagTest.stg.
 */
public class ShortHashBagTest extends AbstractMutableShortBagTestCase {

    @Override
    protected final ShortHashBag classUnderTest() {
        return ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3);
    }

    @Override
    protected ShortHashBag newWith(short... elements) {
        return ShortHashBag.newBagWith(elements);
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(0, new ShortHashBag(3));
        Verify.assertSize(0, ShortHashBag.newBag(3));
        Verify.assertSize(3, ShortHashBag.newBagWith((short) 0, (short) 1, (short) 2));
        Verify.assertSize(3, new ShortHashBag(ShortHashBag.newBagWith((short) 0, (short) 1, (short) 2)));
        Verify.assertSize(3, ShortHashBag.newBag(ShortHashBag.newBagWith((short) 0, (short) 1, (short) 2)));
        Verify.assertSize(3, ShortHashBag.newBag(ShortArrayList.newListWith((short) 0, (short) 1, (short) 2)));
        Verify.assertSize(3, new ShortHashBag(ShortArrayList.newListWith((short) 0, (short) 1, (short) 2)));
    }

    @Override
    @Test
    public void with() {
        super.with();
        ShortHashBag hashBag = new ShortHashBag().with((short) 1);
        ShortHashBag hashBag0 = new ShortHashBag().with((short) 1, (short) 2);
        ShortHashBag hashBag1 = new ShortHashBag().with((short) 1, (short) 2, (short) 3);
        ShortHashBag hashBag2 = new ShortHashBag().with((short) 1).with((short) 2).with((short) 3).with((short) 4);
        ShortHashBag hashBag3 = new ShortHashBag().with((short) 1).with((short) 2).with((short) 3).with((short) 4).with((short) 5);
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1), hashBag);
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2), hashBag0);
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), hashBag1);
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3, (short) 4), hashBag2);
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5), hashBag3);
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        ShortHashBag hashBag = ShortHashBag.newBagWith((short) 1, (short) 1, (short) 2, (short) 2, (short) 2, (short) 2, (short) 3);
        Short sum = hashBag.injectInto(Short.valueOf((short) 4), (Short result, short value) -> Short.valueOf((short) (result + value)));
        Assert.assertEquals(Short.valueOf((short) 17), sum);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.bag.mutable.primitive.AbstractMutableShortBagTestCase._Benchmark {

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

        private ShortHashBagTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ShortHashBagTest();
        }

        @java.lang.Override
        public ShortHashBagTest implementation() {
            return this.implementation;
        }
    }
}
