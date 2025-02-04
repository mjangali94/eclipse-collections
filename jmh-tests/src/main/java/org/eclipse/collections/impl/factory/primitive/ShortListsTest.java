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

import org.eclipse.collections.api.factory.list.primitive.ImmutableShortListFactory;
import org.eclipse.collections.api.factory.list.primitive.MutableShortListFactory;
import org.eclipse.collections.api.list.primitive.ImmutableShortList;
import org.eclipse.collections.api.list.primitive.MutableShortList;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ShortLists}.
 * This file was automatically generated from template file primitiveListsTest.stg.
 */
public class ShortListsTest {

    @Test
    public void immutables() {
        this.assertImmutableListFactory(ShortLists.immutable);
        this.assertImmutableListFactory(org.eclipse.collections.api.factory.primitive.ShortLists.immutable);
    }

    private void assertImmutableListFactory(ImmutableShortListFactory listFactory) {
        Assert.assertEquals(new ShortArrayList(), listFactory.of());
        Verify.assertInstanceOf(ImmutableShortList.class, listFactory.of());
        Assert.assertEquals(ShortArrayList.newListWith((short) 1), listFactory.of((short) 1));
        Verify.assertInstanceOf(ImmutableShortList.class, listFactory.of((short) 1));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2), listFactory.of((short) 1, (short) 2));
        Verify.assertInstanceOf(ImmutableShortList.class, listFactory.of((short) 1, (short) 2));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3), listFactory.of((short) 1, (short) 2, (short) 3));
        Verify.assertInstanceOf(ImmutableShortList.class, listFactory.of((short) 1, (short) 2, (short) 3));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4), listFactory.of((short) 1, (short) 2, (short) 3, (short) 4));
        Verify.assertInstanceOf(ImmutableShortList.class, listFactory.of((short) 1, (short) 2, (short) 3, (short) 4));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5), listFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        Verify.assertInstanceOf(ImmutableShortList.class, listFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6), listFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6));
        Verify.assertInstanceOf(ImmutableShortList.class, listFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7), listFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7));
        Verify.assertInstanceOf(ImmutableShortList.class, listFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8), listFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8));
        Verify.assertInstanceOf(ImmutableShortList.class, listFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9), listFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9));
        Verify.assertInstanceOf(ImmutableShortList.class, listFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10), listFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10));
        Verify.assertInstanceOf(ImmutableShortList.class, listFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3), listFactory.ofAll(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3)));
        Verify.assertInstanceOf(ImmutableShortList.class, listFactory.ofAll(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3)));
    }

    @Test
    public void mutables() {
        this.assertMutableListFactory(ShortLists.mutable);
        this.assertMutableListFactory(org.eclipse.collections.api.factory.primitive.ShortLists.mutable);
    }

    private void assertMutableListFactory(MutableShortListFactory listFactory) {
        Assert.assertEquals(new ShortArrayList(), listFactory.of());
        Verify.assertInstanceOf(MutableShortList.class, listFactory.of());
        Assert.assertEquals(ShortArrayList.newListWith((short) 1), listFactory.of((short) 1));
        Verify.assertInstanceOf(MutableShortList.class, listFactory.of((short) 1));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2), listFactory.of((short) 1, (short) 2));
        Verify.assertInstanceOf(MutableShortList.class, listFactory.of((short) 1, (short) 2));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3), listFactory.of((short) 1, (short) 2, (short) 3));
        Verify.assertInstanceOf(MutableShortList.class, listFactory.of((short) 1, (short) 2, (short) 3));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4), listFactory.of((short) 1, (short) 2, (short) 3, (short) 4));
        Verify.assertInstanceOf(MutableShortList.class, listFactory.of((short) 1, (short) 2, (short) 3, (short) 4));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5), listFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        Verify.assertInstanceOf(MutableShortList.class, listFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6), listFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6));
        Verify.assertInstanceOf(MutableShortList.class, listFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7), listFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7));
        Verify.assertInstanceOf(MutableShortList.class, listFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8), listFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8));
        Verify.assertInstanceOf(MutableShortList.class, listFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9), listFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9));
        Verify.assertInstanceOf(MutableShortList.class, listFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10), listFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10));
        Verify.assertInstanceOf(MutableShortList.class, listFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3), listFactory.ofAll(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3)));
        Verify.assertInstanceOf(MutableShortList.class, listFactory.ofAll(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3)));
    }

    @Test
    public void emptyList() {
        Verify.assertEmpty(ShortLists.immutable.of());
        Assert.assertSame(ShortLists.immutable.of(), ShortLists.immutable.of());
        Verify.assertPostSerializedIdentity(ShortLists.immutable.of());
    }

    @Test
    public void newListWith() {
        ImmutableShortList list = ShortLists.immutable.of();
        Assert.assertEquals(list, ShortLists.immutable.of(list.toArray()));
        Assert.assertEquals(list = list.newWith((short) 1), ShortLists.immutable.of((short) 1));
        Assert.assertEquals(list = list.newWith((short) 2), ShortLists.immutable.of((short) 1, (short) 2));
        Assert.assertEquals(list = list.newWith((short) 3), ShortLists.immutable.of((short) 1, (short) 2, (short) 3));
        Assert.assertEquals(list = list.newWith((short) 4), ShortLists.immutable.of((short) 1, (short) 2, (short) 3, (short) 4));
        Assert.assertEquals(list = list.newWith((short) 5), ShortLists.immutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        Assert.assertEquals(list = list.newWith((short) 6), ShortLists.immutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6));
        Assert.assertEquals(list = list.newWith((short) 7), ShortLists.immutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7));
        Assert.assertEquals(list = list.newWith((short) 8), ShortLists.immutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8));
        Assert.assertEquals(list = list.newWith((short) 9), ShortLists.immutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9));
        Assert.assertEquals(list = list.newWith((short) 10), ShortLists.immutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10));
        Assert.assertEquals(list = list.newWith((short) 11), ShortLists.immutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10, (short) 11));
        Assert.assertEquals(list = list.newWith((short) 12), ShortLists.immutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10, (short) 11, (short) 12));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newListWithArray_immutable() {
        ImmutableShortList list = ShortLists.immutable.of();
        Assert.assertEquals(list = list.newWith((short) 1), ShortLists.immutable.of(new short[] { 1 }));
        Assert.assertEquals(list = list.newWith((short) 2), ShortLists.immutable.of(new short[] { (short) 1, (short) 2 }));
        Assert.assertEquals(list = list.newWith((short) 3), ShortLists.immutable.of(new short[] { (short) 1, (short) 2, (short) 3 }));
        Assert.assertEquals(list = list.newWith((short) 4), ShortLists.immutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4 }));
        Assert.assertEquals(list = list.newWith((short) 5), ShortLists.immutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5 }));
        Assert.assertEquals(list = list.newWith((short) 6), ShortLists.immutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6 }));
        Assert.assertEquals(list = list.newWith((short) 7), ShortLists.immutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7 }));
        Assert.assertEquals(list = list.newWith((short) 8), ShortLists.immutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8 }));
        Assert.assertEquals(list = list.newWith((short) 9), ShortLists.immutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9 }));
        Assert.assertEquals(list = list.newWith((short) 10), ShortLists.immutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10 }));
        Assert.assertEquals(list = list.newWith((short) 11), ShortLists.immutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10, (short) 11 }));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newListWithArray_mutable() {
        MutableShortList list = ShortLists.mutable.of();
        Assert.assertEquals(list, ShortLists.mutable.of(null));
        Assert.assertEquals(list, ShortLists.mutable.of(new short[] {}));
        list.add((short) 1);
        Assert.assertEquals(list, ShortLists.immutable.of(new short[] { 1 }));
        list.add((short) 2);
        Assert.assertEquals(list, ShortLists.immutable.of(new short[] { (short) 1, (short) 2 }));
        list.add((short) 3);
        Assert.assertEquals(list, ShortLists.immutable.of(new short[] { (short) 1, (short) 2, (short) 3 }));
        list.add((short) 4);
        Assert.assertEquals(list, ShortLists.immutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4 }));
        list.add((short) 5);
        Assert.assertEquals(list, ShortLists.immutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5 }));
        list.add((short) 6);
        Assert.assertEquals(list, ShortLists.immutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6 }));
        list.add((short) 7);
        Assert.assertEquals(list, ShortLists.immutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7 }));
        list.add((short) 8);
        Assert.assertEquals(list, ShortLists.immutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8 }));
        list.add((short) 9);
        Assert.assertEquals(list, ShortLists.immutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9 }));
        list.add((short) 10);
        Assert.assertEquals(list, ShortLists.immutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10 }));
        list.add((short) 11);
        Assert.assertEquals(list, ShortLists.immutable.of(new short[] { (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10, (short) 11 }));
    }

    @Test
    public void wrapCopy() {
        short[] array = { (short) 0, (short) 1 };
        MutableShortList actual = ShortLists.mutable.wrapCopy(array);
        MutableShortList expected = ShortArrayList.newListWith((short) 0, (short) 1);
        array[0] = (short) 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void newListWithList() {
        ImmutableShortList list = ShortLists.immutable.of();
        ShortArrayList shortArrayList = ShortArrayList.newListWith((short) 1);
        Assert.assertEquals(list = list.newWith((short) 1), shortArrayList.toImmutable());
        Assert.assertEquals(list = list.newWith((short) 2), shortArrayList.with((short) 2).toImmutable());
        Assert.assertEquals(list = list.newWith((short) 3), shortArrayList.with((short) 3).toImmutable());
        Assert.assertEquals(list = list.newWith((short) 4), shortArrayList.with((short) 4).toImmutable());
        Assert.assertEquals(list = list.newWith((short) 5), shortArrayList.with((short) 5).toImmutable());
        Assert.assertEquals(list = list.newWith((short) 6), shortArrayList.with((short) 6).toImmutable());
        Assert.assertEquals(list = list.newWith((short) 7), shortArrayList.with((short) 7).toImmutable());
        Assert.assertEquals(list = list.newWith((short) 8), shortArrayList.with((short) 8).toImmutable());
        Assert.assertEquals(list = list.newWith((short) 9), shortArrayList.with((short) 9).toImmutable());
        Assert.assertEquals(list = list.newWith((short) 10), shortArrayList.with((short) 10).toImmutable());
        Assert.assertEquals(list = list.newWith((short) 11), shortArrayList.with((short) 11).toImmutable());
    }

    @Test
    public void newListWithWithList() {
        Assert.assertEquals(new ShortArrayList(), ShortLists.immutable.ofAll(new ShortArrayList()));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1), ShortLists.immutable.ofAll(ShortArrayList.newListWith((short) 1)));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2), ShortLists.immutable.ofAll(ShortArrayList.newListWith((short) 1, (short) 2)));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3), ShortLists.immutable.ofAll(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3)));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ShortLists.class);
    }

    @Test
    public void ofAllIterable() {
        Assert.assertEquals(new ShortArrayList(), ShortLists.immutable.ofAll(Lists.mutable.<Short>empty()));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1), ShortLists.immutable.ofAll(Lists.mutable.<Short>with((short) 1)));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2), ShortLists.immutable.ofAll(Lists.mutable.<Short>with((short) 1, (short) 2)));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3), ShortLists.immutable.ofAll(Lists.mutable.<Short>with((short) 1, (short) 2, (short) 3)));
        Assert.assertEquals(new ShortArrayList(), ShortLists.mutable.ofAll(Lists.mutable.<Short>empty()));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1), ShortLists.mutable.ofAll(Lists.mutable.<Short>with((short) 1)));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2), ShortLists.mutable.ofAll(Lists.mutable.<Short>with((short) 1, (short) 2)));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3), ShortLists.mutable.ofAll(Lists.mutable.<Short>with((short) 1, (short) 2, (short) 3)));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ShortListsTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ShortListsTest> payload) throws java.lang.Throwable {
            this.instance = new ShortListsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortListsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortListsTest> mutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortListsTest> emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortListsTest> newListWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortListsTest> newListWithArray_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortListsTest> newListWithArray_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortListsTest> wrapCopy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortListsTest> newListWithList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortListsTest> newListWithWithList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortListsTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortListsTest> ofAllIterable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = ShortListsTest::immutables;
            this.payloads.mutables = ShortListsTest::mutables;
            this.payloads.emptyList = ShortListsTest::emptyList;
            this.payloads.newListWith = ShortListsTest::newListWith;
            this.payloads.newListWithArray_immutable = ShortListsTest::newListWithArray_immutable;
            this.payloads.newListWithArray_mutable = ShortListsTest::newListWithArray_mutable;
            this.payloads.wrapCopy = ShortListsTest::wrapCopy;
            this.payloads.newListWithList = ShortListsTest::newListWithList;
            this.payloads.newListWithWithList = ShortListsTest::newListWithWithList;
            this.payloads.classIsNonInstantiable = ShortListsTest::classIsNonInstantiable;
            this.payloads.ofAllIterable = ShortListsTest::ofAllIterable;
        }
    }
}
