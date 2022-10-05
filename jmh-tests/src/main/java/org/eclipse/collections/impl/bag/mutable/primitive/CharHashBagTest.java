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

import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link CharHashBag}.
 * This file was automatically generated from template file primitiveHashBagTest.stg.
 */
public class CharHashBagTest extends AbstractMutableCharBagTestCase {

    @Override
    protected final CharHashBag classUnderTest() {
        return CharHashBag.newBagWith((char) 1, (char) 2, (char) 3);
    }

    @Override
    protected CharHashBag newWith(char... elements) {
        return CharHashBag.newBagWith(elements);
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(0, new CharHashBag(3));
        Verify.assertSize(0, CharHashBag.newBag(3));
        Verify.assertSize(3, CharHashBag.newBagWith((char) 0, (char) 1, (char) 2));
        Verify.assertSize(3, new CharHashBag(CharHashBag.newBagWith((char) 0, (char) 1, (char) 2)));
        Verify.assertSize(3, CharHashBag.newBag(CharHashBag.newBagWith((char) 0, (char) 1, (char) 2)));
        Verify.assertSize(3, CharHashBag.newBag(CharArrayList.newListWith((char) 0, (char) 1, (char) 2)));
        Verify.assertSize(3, new CharHashBag(CharArrayList.newListWith((char) 0, (char) 1, (char) 2)));
    }

    @Override
    @Test
    public void with() {
        super.with();
        CharHashBag hashBag = new CharHashBag().with((char) 1);
        CharHashBag hashBag0 = new CharHashBag().with((char) 1, (char) 2);
        CharHashBag hashBag1 = new CharHashBag().with((char) 1, (char) 2, (char) 3);
        CharHashBag hashBag2 = new CharHashBag().with((char) 1).with((char) 2).with((char) 3).with((char) 4);
        CharHashBag hashBag3 = new CharHashBag().with((char) 1).with((char) 2).with((char) 3).with((char) 4).with((char) 5);
        Assert.assertEquals(CharHashBag.newBagWith((char) 1), hashBag);
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2), hashBag0);
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), hashBag1);
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3, (char) 4), hashBag2);
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5), hashBag3);
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        CharHashBag hashBag = CharHashBag.newBagWith((char) 1, (char) 1, (char) 2, (char) 2, (char) 2, (char) 2, (char) 3);
        Character sum = hashBag.injectInto(Character.valueOf((char) 4), (Character result, char value) -> Character.valueOf((char) (result + value)));
        Assert.assertEquals(Character.valueOf((char) 17), sum);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.bag.mutable.primitive.AbstractMutableCharBagTestCase._Benchmark {

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

        private CharHashBagTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new CharHashBagTest();
        }

        @java.lang.Override
        public CharHashBagTest implementation() {
            return this.implementation;
        }
    }
}
