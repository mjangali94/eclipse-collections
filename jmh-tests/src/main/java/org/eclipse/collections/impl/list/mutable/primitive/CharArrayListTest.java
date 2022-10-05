/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.mutable.primitive;

import java.lang.reflect.Field;
import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.internal.primitive.CharIterableIterate;
import org.eclipse.collections.impl.utility.internal.primitive.CharIteratorIterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link CharArrayList}.
 * This file was automatically generated from template file primitiveArrayListTest.stg.
 */
public class CharArrayListTest extends AbstractCharListTestCase {

    private final CharArrayList list = this.classUnderTest();

    @Override
    protected final CharArrayList classUnderTest() {
        return CharArrayList.newListWith((char) 1, (char) 2, (char) 3);
    }

    @Override
    protected CharArrayList newWith(char... elements) {
        return CharArrayList.newListWith(elements);
    }

    @Test
    public void testCharArrayListWithInitialCapacity() throws Exception {
        CharArrayList arrayList = new CharArrayList(7);
        Verify.assertEmpty(arrayList);
        Field items = CharArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        Assert.assertEquals(7L, ((char[]) items.get(arrayList)).length);
    }

    @Test
    public void newWithNValues() {
        CharArrayList newList = CharArrayList.newWithNValues(5, (char) 42);
        Verify.assertSize(5, newList);
        Assert.assertEquals(CharArrayList.newListWith((char) 42, (char) 42, (char) 42, (char) 42, (char) 42), newList);
        CharArrayList newList2 = CharArrayList.newWithNValues(0, (char) 2);
        Verify.assertSize(0, newList2);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void newWithNValues_throws_negative_size() {
        CharArrayList.newWithNValues(-5, (char) 42);
    }

    @Test
    public void wrapCopy() {
        char[] array = { (char) 0, (char) 1 };
        CharArrayList list = CharArrayList.wrapCopy(array);
        array[0] = (char) 1;
        Assert.assertTrue(list.get(0) < (char) 1);
    }

    @Test
    public void addAtIndexAtCapacity() throws Exception {
        CharArrayList listWithCapacity = new CharArrayList(4).with((char) 1, (char) 2, (char) 3, (char) 4);
        listWithCapacity.addAtIndex(3, (char) 5);
        Field items = CharArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        Assert.assertEquals(7L, ((char[]) items.get(listWithCapacity)).length);
    }

    @Test
    public void trimToSize() throws Exception {
        Field items = CharArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        CharArrayList arrayList = new CharArrayList().with((char) 1, (char) 2, (char) 3);
        Assert.assertEquals(10L, ((char[]) items.get(arrayList)).length);
        Assert.assertArrayEquals(new char[] { (char) 1, (char) 2, (char) 3, (char) 0, (char) 0, (char) 0, (char) 0, (char) 0, (char) 0, (char) 0 }, (char[]) items.get(arrayList));
        arrayList.trimToSize();
        Assert.assertArrayEquals(new char[] { (char) 1, (char) 2, (char) 3 }, (char[]) items.get(arrayList));
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(0, new CharArrayList());
        Verify.assertSize(3, CharLists.mutable.ofAll(this.list));
        Verify.assertSize(3, this.list);
    }

    @Override
    @Test
    public void dotProduct() {
        CharArrayList list1 = CharArrayList.newListWith((char) 1, (char) 2, (char) 3);
        CharArrayList list2 = CharArrayList.newListWith((char) 1, (char) 2, (char) 3);
        Assert.assertEquals(14L, list1.dotProduct(list2));
    }

    @Override
    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes() {
        CharArrayList list1 = CharArrayList.newListWith((char) 1, (char) 2, (char) 3);
        CharArrayList list2 = CharArrayList.newListWith((char) 1, (char) 2);
        list1.dotProduct(list2);
    }

    @Override
    @Test
    public void with() {
        super.with();
        CharArrayList emptyList = new CharArrayList();
        CharArrayList arrayList = emptyList.with((char) 1);
        CharArrayList arrayList0 = new CharArrayList().with((char) 1, (char) 2);
        CharArrayList arrayList1 = new CharArrayList().with((char) 1, (char) 2, (char) 3);
        CharArrayList arrayList2 = new CharArrayList().with((char) 1, (char) 2, (char) 3, (char) 4);
        CharArrayList arrayList3 = new CharArrayList().with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5);
        Assert.assertSame(emptyList, arrayList);
        Assert.assertEquals(CharArrayList.newListWith((char) 1), arrayList);
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2), arrayList0);
        Assert.assertEquals(this.list, arrayList1);
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4), arrayList2);
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5), arrayList3);
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(CharIterableIterate.class);
        Verify.assertClassNonInstantiable(CharIteratorIterate.class);
    }

    @Override
    @Test
    public void toImmutable() {
        super.toImmutable();
        CharArrayList list = new CharArrayList(1);
        Assert.assertEquals(list, list.toImmutable());
        list.add((char) 5);
        list.removeAtIndex(0);
        Assert.assertEquals(list, list.toImmutable());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.list.mutable.primitive.AbstractCharListTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testCharArrayListWithInitialCapacity() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testCharArrayListWithInitialCapacity, this.description("testCharArrayListWithInitialCapacity"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithNValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newWithNValues, this.description("newWithNValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithNValues_throws_negative_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::newWithNValues_throws_negative_size, this.description("newWithNValues_throws_negative_size"), java.lang.NegativeArraySizeException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_wrapCopy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::wrapCopy, this.description("wrapCopy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndexAtCapacity() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addAtIndexAtCapacity, this.description("addAtIndexAtCapacity"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_trimToSize() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::trimToSize, this.description("trimToSize"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::size, this.description("size"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dotProduct() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::dotProduct, this.description("dotProduct"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dotProduct_throwsOnListsOfDifferentSizes() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::dotProduct_throwsOnListsOfDifferentSizes, this.description("dotProduct_throwsOnListsOfDifferentSizes"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::with, this.description("with"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::classIsNonInstantiable, this.description("classIsNonInstantiable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutable, this.description("toImmutable"));
        }

        private CharArrayListTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new CharArrayListTest();
        }

        @java.lang.Override
        public CharArrayListTest implementation() {
            return this.implementation;
        }
    }
}
