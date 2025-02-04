/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.factory.primitive;

import org.eclipse.collections.api.factory.list.primitive.ImmutableByteListFactory;
import org.eclipse.collections.api.factory.list.primitive.MutableByteListFactory;
import org.eclipse.collections.api.list.primitive.ImmutableByteList;
import org.eclipse.collections.api.list.primitive.MutableByteList;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ByteLists}.
 * This file was automatically generated from template file primitiveListsTest.stg.
 */
public class ByteListsTest {

    @Test
    public void immutables() {
        this.assertImmutableListFactory(ByteLists.immutable);
        this.assertImmutableListFactory(org.eclipse.collections.api.factory.primitive.ByteLists.immutable);
    }

    private void assertImmutableListFactory(ImmutableByteListFactory listFactory) {
        Assert.assertEquals(new ByteArrayList(), listFactory.of());
        Verify.assertInstanceOf(ImmutableByteList.class, listFactory.of());
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1), listFactory.of((byte) 1));
        Verify.assertInstanceOf(ImmutableByteList.class, listFactory.of((byte) 1));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2), listFactory.of((byte) 1, (byte) 2));
        Verify.assertInstanceOf(ImmutableByteList.class, listFactory.of((byte) 1, (byte) 2));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3), listFactory.of((byte) 1, (byte) 2, (byte) 3));
        Verify.assertInstanceOf(ImmutableByteList.class, listFactory.of((byte) 1, (byte) 2, (byte) 3));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4), listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Verify.assertInstanceOf(ImmutableByteList.class, listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        Verify.assertInstanceOf(ImmutableByteList.class, listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6), listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        Verify.assertInstanceOf(ImmutableByteList.class, listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7), listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7));
        Verify.assertInstanceOf(ImmutableByteList.class, listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8), listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8));
        Verify.assertInstanceOf(ImmutableByteList.class, listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9), listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9));
        Verify.assertInstanceOf(ImmutableByteList.class, listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10), listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10));
        Verify.assertInstanceOf(ImmutableByteList.class, listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3), listFactory.ofAll(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3)));
        Verify.assertInstanceOf(ImmutableByteList.class, listFactory.ofAll(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3)));
    }

    @Test
    public void mutables() {
        this.assertMutableListFactory(ByteLists.mutable);
        this.assertMutableListFactory(org.eclipse.collections.api.factory.primitive.ByteLists.mutable);
    }

    private void assertMutableListFactory(MutableByteListFactory listFactory) {
        Assert.assertEquals(new ByteArrayList(), listFactory.of());
        Verify.assertInstanceOf(MutableByteList.class, listFactory.of());
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1), listFactory.of((byte) 1));
        Verify.assertInstanceOf(MutableByteList.class, listFactory.of((byte) 1));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2), listFactory.of((byte) 1, (byte) 2));
        Verify.assertInstanceOf(MutableByteList.class, listFactory.of((byte) 1, (byte) 2));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3), listFactory.of((byte) 1, (byte) 2, (byte) 3));
        Verify.assertInstanceOf(MutableByteList.class, listFactory.of((byte) 1, (byte) 2, (byte) 3));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4), listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Verify.assertInstanceOf(MutableByteList.class, listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        Verify.assertInstanceOf(MutableByteList.class, listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6), listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        Verify.assertInstanceOf(MutableByteList.class, listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7), listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7));
        Verify.assertInstanceOf(MutableByteList.class, listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8), listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8));
        Verify.assertInstanceOf(MutableByteList.class, listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9), listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9));
        Verify.assertInstanceOf(MutableByteList.class, listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10), listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10));
        Verify.assertInstanceOf(MutableByteList.class, listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3), listFactory.ofAll(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3)));
        Verify.assertInstanceOf(MutableByteList.class, listFactory.ofAll(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3)));
    }

    @Test
    public void emptyList() {
        Verify.assertEmpty(ByteLists.immutable.of());
        Assert.assertSame(ByteLists.immutable.of(), ByteLists.immutable.of());
        Verify.assertPostSerializedIdentity(ByteLists.immutable.of());
    }

    @Test
    public void newListWith() {
        ImmutableByteList list = ByteLists.immutable.of();
        Assert.assertEquals(list, ByteLists.immutable.of(list.toArray()));
        Assert.assertEquals(list = list.newWith((byte) 1), ByteLists.immutable.of((byte) 1));
        Assert.assertEquals(list = list.newWith((byte) 2), ByteLists.immutable.of((byte) 1, (byte) 2));
        Assert.assertEquals(list = list.newWith((byte) 3), ByteLists.immutable.of((byte) 1, (byte) 2, (byte) 3));
        Assert.assertEquals(list = list.newWith((byte) 4), ByteLists.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Assert.assertEquals(list = list.newWith((byte) 5), ByteLists.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        Assert.assertEquals(list = list.newWith((byte) 6), ByteLists.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        Assert.assertEquals(list = list.newWith((byte) 7), ByteLists.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7));
        Assert.assertEquals(list = list.newWith((byte) 8), ByteLists.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8));
        Assert.assertEquals(list = list.newWith((byte) 9), ByteLists.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9));
        Assert.assertEquals(list = list.newWith((byte) 10), ByteLists.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10));
        Assert.assertEquals(list = list.newWith((byte) 11), ByteLists.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11));
        Assert.assertEquals(list = list.newWith((byte) 12), ByteLists.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newListWithArray_immutable() {
        ImmutableByteList list = ByteLists.immutable.of();
        Assert.assertEquals(list = list.newWith((byte) 1), ByteLists.immutable.of(new byte[] { 1 }));
        Assert.assertEquals(list = list.newWith((byte) 2), ByteLists.immutable.of(new byte[] { (byte) 1, (byte) 2 }));
        Assert.assertEquals(list = list.newWith((byte) 3), ByteLists.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3 }));
        Assert.assertEquals(list = list.newWith((byte) 4), ByteLists.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4 }));
        Assert.assertEquals(list = list.newWith((byte) 5), ByteLists.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5 }));
        Assert.assertEquals(list = list.newWith((byte) 6), ByteLists.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6 }));
        Assert.assertEquals(list = list.newWith((byte) 7), ByteLists.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7 }));
        Assert.assertEquals(list = list.newWith((byte) 8), ByteLists.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8 }));
        Assert.assertEquals(list = list.newWith((byte) 9), ByteLists.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9 }));
        Assert.assertEquals(list = list.newWith((byte) 10), ByteLists.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10 }));
        Assert.assertEquals(list = list.newWith((byte) 11), ByteLists.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11 }));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newListWithArray_mutable() {
        MutableByteList list = ByteLists.mutable.of();
        Assert.assertEquals(list, ByteLists.mutable.of(null));
        Assert.assertEquals(list, ByteLists.mutable.of(new byte[] {}));
        list.add((byte) 1);
        Assert.assertEquals(list, ByteLists.immutable.of(new byte[] { 1 }));
        list.add((byte) 2);
        Assert.assertEquals(list, ByteLists.immutable.of(new byte[] { (byte) 1, (byte) 2 }));
        list.add((byte) 3);
        Assert.assertEquals(list, ByteLists.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3 }));
        list.add((byte) 4);
        Assert.assertEquals(list, ByteLists.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4 }));
        list.add((byte) 5);
        Assert.assertEquals(list, ByteLists.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5 }));
        list.add((byte) 6);
        Assert.assertEquals(list, ByteLists.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6 }));
        list.add((byte) 7);
        Assert.assertEquals(list, ByteLists.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7 }));
        list.add((byte) 8);
        Assert.assertEquals(list, ByteLists.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8 }));
        list.add((byte) 9);
        Assert.assertEquals(list, ByteLists.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9 }));
        list.add((byte) 10);
        Assert.assertEquals(list, ByteLists.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10 }));
        list.add((byte) 11);
        Assert.assertEquals(list, ByteLists.immutable.of(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11 }));
    }

    @Test
    public void wrapCopy() {
        byte[] array = { (byte) 0, (byte) 1 };
        MutableByteList actual = ByteLists.mutable.wrapCopy(array);
        MutableByteList expected = ByteArrayList.newListWith((byte) 0, (byte) 1);
        array[0] = (byte) 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void newListWithList() {
        ImmutableByteList list = ByteLists.immutable.of();
        ByteArrayList byteArrayList = ByteArrayList.newListWith((byte) 1);
        Assert.assertEquals(list = list.newWith((byte) 1), byteArrayList.toImmutable());
        Assert.assertEquals(list = list.newWith((byte) 2), byteArrayList.with((byte) 2).toImmutable());
        Assert.assertEquals(list = list.newWith((byte) 3), byteArrayList.with((byte) 3).toImmutable());
        Assert.assertEquals(list = list.newWith((byte) 4), byteArrayList.with((byte) 4).toImmutable());
        Assert.assertEquals(list = list.newWith((byte) 5), byteArrayList.with((byte) 5).toImmutable());
        Assert.assertEquals(list = list.newWith((byte) 6), byteArrayList.with((byte) 6).toImmutable());
        Assert.assertEquals(list = list.newWith((byte) 7), byteArrayList.with((byte) 7).toImmutable());
        Assert.assertEquals(list = list.newWith((byte) 8), byteArrayList.with((byte) 8).toImmutable());
        Assert.assertEquals(list = list.newWith((byte) 9), byteArrayList.with((byte) 9).toImmutable());
        Assert.assertEquals(list = list.newWith((byte) 10), byteArrayList.with((byte) 10).toImmutable());
        Assert.assertEquals(list = list.newWith((byte) 11), byteArrayList.with((byte) 11).toImmutable());
    }

    @Test
    public void newListWithWithList() {
        Assert.assertEquals(new ByteArrayList(), ByteLists.immutable.ofAll(new ByteArrayList()));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1), ByteLists.immutable.ofAll(ByteArrayList.newListWith((byte) 1)));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2), ByteLists.immutable.ofAll(ByteArrayList.newListWith((byte) 1, (byte) 2)));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3), ByteLists.immutable.ofAll(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3)));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ByteLists.class);
    }

    @Test
    public void ofAllIterable() {
        Assert.assertEquals(new ByteArrayList(), ByteLists.immutable.ofAll(Lists.mutable.<Byte>empty()));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1), ByteLists.immutable.ofAll(Lists.mutable.<Byte>with((byte) 1)));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2), ByteLists.immutable.ofAll(Lists.mutable.<Byte>with((byte) 1, (byte) 2)));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3), ByteLists.immutable.ofAll(Lists.mutable.<Byte>with((byte) 1, (byte) 2, (byte) 3)));
        Assert.assertEquals(new ByteArrayList(), ByteLists.mutable.ofAll(Lists.mutable.<Byte>empty()));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1), ByteLists.mutable.ofAll(Lists.mutable.<Byte>with((byte) 1)));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2), ByteLists.mutable.ofAll(Lists.mutable.<Byte>with((byte) 1, (byte) 2)));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3), ByteLists.mutable.ofAll(Lists.mutable.<Byte>with((byte) 1, (byte) 2, (byte) 3)));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ByteListsTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.immutables);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mutables);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.emptyList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWithArray_immutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWithArray_immutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWithArray_mutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWithArray_mutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_wrapCopy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.wrapCopy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWithList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWithList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWithWithList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWithWithList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAllIterable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ByteListsTest> payload) throws java.lang.Throwable {
            this.instance = new ByteListsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteListsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteListsTest> mutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteListsTest> emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteListsTest> newListWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteListsTest> newListWithArray_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteListsTest> newListWithArray_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteListsTest> wrapCopy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteListsTest> newListWithList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteListsTest> newListWithWithList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteListsTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteListsTest> ofAllIterable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = ByteListsTest::immutables;
            this.payloads.mutables = ByteListsTest::mutables;
            this.payloads.emptyList = ByteListsTest::emptyList;
            this.payloads.newListWith = ByteListsTest::newListWith;
            this.payloads.newListWithArray_immutable = ByteListsTest::newListWithArray_immutable;
            this.payloads.newListWithArray_mutable = ByteListsTest::newListWithArray_mutable;
            this.payloads.wrapCopy = ByteListsTest::wrapCopy;
            this.payloads.newListWithList = ByteListsTest::newListWithList;
            this.payloads.newListWithWithList = ByteListsTest::newListWithWithList;
            this.payloads.classIsNonInstantiable = ByteListsTest::classIsNonInstantiable;
            this.payloads.ofAllIterable = ByteListsTest::ofAllIterable;
        }
    }
*/
}
