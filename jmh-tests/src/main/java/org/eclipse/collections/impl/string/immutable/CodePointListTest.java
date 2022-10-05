/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.string.immutable;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.LazyIntIterable;
import org.eclipse.collections.api.list.primitive.ImmutableIntList;
import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.list.immutable.primitive.AbstractImmutableIntListTestCase;
import org.junit.Assert;
import org.junit.Test;

public class CodePointListTest extends AbstractImmutableIntListTestCase {

    private static final String UNICODE_STRING = "\u3042\uD840\uDC00\u3044\uD840\uDC03\u3046\uD83D\uDE09";

    private static final String UNICODE_EMOJI_STRING = "\uD83D\uDE09w\uD83D\uDE09i\uD83D\uDE09n\uD83D\uDE09k";

    private static final String UNICODE_EMOJI_STRING2 = "w\uD83D\uDE09i\uD83D\uDE09n\uD83D\uDE09k\uD83D\uDE09";

    @Override
    protected ImmutableIntList classUnderTest() {
        return CodePointList.from(1, 2, 3);
    }

    @Override
    protected ImmutableIntList newWith(int... elements) {
        return CodePointList.from(elements);
    }

    @SuppressWarnings("StringBufferReplaceableByString")
    @Test
    public void stringBuilder() {
        CodePointList list = CodePointList.from(UNICODE_STRING);
        Assert.assertEquals(UNICODE_STRING, new StringBuilder(list).toString());
        CodePointList list2 = CodePointList.from(UNICODE_EMOJI_STRING);
        Assert.assertEquals(UNICODE_EMOJI_STRING, new StringBuilder(list2).toString());
        CodePointList list3 = CodePointList.from(UNICODE_EMOJI_STRING2);
        Assert.assertEquals(UNICODE_EMOJI_STRING2, new StringBuilder(list3).toString());
        CodePointList list4 = CodePointList.from("Hello World!");
        Assert.assertEquals("Hello World!", new StringBuilder(list4).toString());
    }

    @Test
    public void subSequence() {
        CodePointList adapt = CodePointList.from(UNICODE_STRING);
        CharSequence sequence = adapt.subSequence(1, 3);
        Assert.assertEquals(UNICODE_STRING.subSequence(1, 3), sequence);
    }

    @Override
    @Test
    public void max() {
        Assert.assertEquals(9L, this.newWith(1, 2, 9).max());
        Assert.assertEquals(32L, this.newWith(1, 0, 9, 30, 31, 32).max());
        Assert.assertEquals(32L, this.newWith(0, 9, 30, 31, 32).max());
        Assert.assertEquals(31L, this.newWith(31, 0, 30).max());
        Assert.assertEquals(39L, this.newWith(32, 39, 35).max());
        Assert.assertEquals(this.classUnderTest().size(), this.classUnderTest().max());
    }

    @Override
    @Test
    public void min() {
        Assert.assertEquals(1L, this.newWith(1, 2, 9).min());
        Assert.assertEquals(0L, this.newWith(1, 0, 9, 30, 31, 32).min());
        Assert.assertEquals(31L, this.newWith(31, 32, 33).min());
        Assert.assertEquals(32L, this.newWith(32, 39, 35).min());
        Assert.assertEquals(1L, this.classUnderTest().min());
    }

    @Override
    @Test
    public void allSatisfy() {
        Assert.assertFalse(this.newWith(1, 0, 2).allSatisfy(IntPredicates.greaterThan(0)));
        Assert.assertTrue(this.newWith(1, 2, 3).allSatisfy(IntPredicates.greaterThan(0)));
        Assert.assertFalse(this.newWith(1, 0, 31, 32).allSatisfy(IntPredicates.greaterThan(0)));
        Assert.assertFalse(this.newWith(1, 0, 31, 32).allSatisfy(IntPredicates.greaterThan(0)));
        Assert.assertTrue(this.newWith(1, 2, 31, 32).allSatisfy(IntPredicates.greaterThan(0)));
        Assert.assertFalse(this.newWith(32).allSatisfy(IntPredicates.equal(33)));
        IntIterable iterable = this.newWith(0, 1, 2);
        Assert.assertFalse(iterable.allSatisfy(value -> 3 < value));
        Assert.assertTrue(iterable.allSatisfy(IntPredicates.lessThan(3)));
        IntIterable iterable1 = this.classUnderTest();
        int size = iterable1.size();
        Assert.assertEquals(size == 0, iterable1.allSatisfy(IntPredicates.greaterThan(3)));
        Assert.assertEquals(size < 3, iterable1.allSatisfy(IntPredicates.lessThan(3)));
    }

    @Override
    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newWith(1, 2).anySatisfy(IntPredicates.greaterThan(0)));
        Assert.assertFalse(this.newWith(1, 2).anySatisfy(IntPredicates.equal(0)));
        Assert.assertTrue(this.newWith(31, 32).anySatisfy(IntPredicates.greaterThan(0)));
        Assert.assertTrue(this.newWith(2, 31, 32).anySatisfy(IntPredicates.greaterThan(0)));
        Assert.assertFalse(this.newWith(1, 31, 32).anySatisfy(IntPredicates.equal(0)));
        Assert.assertTrue(this.newWith(32).anySatisfy(IntPredicates.greaterThan(0)));
        IntIterable iterable = this.newWith(0, 1, 2);
        Assert.assertTrue(iterable.anySatisfy(value -> value < 3));
        Assert.assertFalse(iterable.anySatisfy(IntPredicates.greaterThan(3)));
        IntIterable iterable1 = this.classUnderTest();
        int size = iterable1.size();
        Assert.assertEquals(size > 3, iterable1.anySatisfy(IntPredicates.greaterThan(3)));
        Assert.assertEquals(size != 0, iterable1.anySatisfy(IntPredicates.lessThan(3)));
    }

    @Override
    @Test
    public void testToString() {
        StringBuilder expectedString = new StringBuilder();
        int size = this.classUnderTest().size();
        for (int each = 0; each < size; each++) {
            expectedString.appendCodePoint(each + 1);
        }
        Assert.assertEquals(expectedString.toString(), this.classUnderTest().toString());
    }

    @Override
    @Test
    public void makeString() {
        ImmutableIntList list = this.classUnderTest();
        StringBuilder expectedString = new StringBuilder();
        StringBuilder expectedString1 = new StringBuilder();
        int size = list.size();
        for (int each = 0; each < size; each++) {
            expectedString.appendCodePoint(each + 1);
            expectedString1.appendCodePoint(each + 1);
            expectedString.append(each == size - 1 ? "" : ", ");
            expectedString1.append(each == size - 1 ? "" : "/");
        }
        Assert.assertEquals(expectedString.toString(), list.makeString());
        Assert.assertEquals(expectedString1.toString(), list.makeString("/"));
        Assert.assertEquals(this.classUnderTest().toString(), this.classUnderTest().makeString("", "", ""));
    }

    @Override
    @Test
    public void appendString() {
        StringBuilder expectedString = new StringBuilder();
        StringBuilder expectedString1 = new StringBuilder();
        int size = this.classUnderTest().size();
        for (int each = 0; each < size; each++) {
            expectedString.appendCodePoint(each + 1);
            expectedString1.appendCodePoint(each + 1);
            expectedString.append(each == size - 1 ? "" : ", ");
            expectedString1.append(each == size - 1 ? "" : "/");
        }
        ImmutableIntList list = this.classUnderTest();
        StringBuilder appendable2 = new StringBuilder();
        list.appendString(appendable2);
        Assert.assertEquals(expectedString.toString(), appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        list.appendString(appendable3, "/");
        Assert.assertEquals(expectedString1.toString(), appendable3.toString());
        StringBuilder appendable4 = new StringBuilder();
        this.classUnderTest().appendString(appendable4, "", "", "");
        Assert.assertEquals(this.classUnderTest().toString(), appendable4.toString());
    }

    @SuppressWarnings("StringBufferMayBeStringBuilder")
    @Test
    public void appendStringStringBuffer() {
        StringBuffer expectedString = new StringBuffer();
        StringBuffer expectedString1 = new StringBuffer();
        int size = this.classUnderTest().size();
        for (int each = 0; each < size; each++) {
            expectedString.appendCodePoint(each + 1);
            expectedString1.appendCodePoint(each + 1);
            expectedString.append(each == size - 1 ? "" : ", ");
            expectedString1.append(each == size - 1 ? "" : "/");
        }
        ImmutableIntList list = this.classUnderTest();
        StringBuffer appendable2 = new StringBuffer();
        list.appendString(appendable2);
        Assert.assertEquals(expectedString.toString(), appendable2.toString());
        StringBuffer appendable3 = new StringBuffer();
        list.appendString(appendable3, "/");
        Assert.assertEquals(expectedString1.toString(), appendable3.toString());
        StringBuffer appendable4 = new StringBuffer();
        this.classUnderTest().appendString(appendable4, "", "", "");
        Assert.assertEquals(this.classUnderTest().toString(), appendable4.toString());
    }

    @Test
    public void appendStringAppendable() {
        StringBuilder expectedString = new StringBuilder();
        StringBuilder expectedString1 = new StringBuilder();
        int size = this.classUnderTest().size();
        for (int each = 0; each < size; each++) {
            expectedString.appendCodePoint(each + 1);
            expectedString1.appendCodePoint(each + 1);
            expectedString.append(each == size - 1 ? "" : ", ");
            expectedString1.append(each == size - 1 ? "" : "/");
        }
        ImmutableIntList list = this.classUnderTest();
        SBAppendable appendable2 = new SBAppendable();
        list.appendString(appendable2);
        Assert.assertEquals(expectedString.toString(), appendable2.toString());
        SBAppendable appendable3 = new SBAppendable();
        list.appendString(appendable3, "/");
        Assert.assertEquals(expectedString1.toString(), appendable3.toString());
        SBAppendable appendable4 = new SBAppendable();
        this.classUnderTest().appendString(appendable4, "", "", "");
        Assert.assertEquals(this.classUnderTest().toString(), appendable4.toString());
    }

    @Test
    public void collectCodePointUnicode() {
        Assert.assertEquals(UNICODE_STRING.codePoints().boxed().collect(Collectors.toList()), CodePointList.from(UNICODE_STRING).collect(i -> i));
        Assert.assertEquals(UNICODE_STRING.codePoints().boxed().collect(Collectors.toList()), CodePointList.from(UNICODE_STRING).collect(i -> i));
    }

    @Test
    public void selectCodePointUnicode() {
        String string = CodePointList.from(UNICODE_STRING).select(Character::isBmpCodePoint).toString();
        Assert.assertEquals("\u3042\u3044\u3046", string);
    }

    @Test
    public void allSatisfyUnicode() {
        Assert.assertTrue(CodePointList.from("\u3042\u3044\u3046").allSatisfy(Character::isBmpCodePoint));
        Assert.assertFalse(CodePointList.from("\uD840\uDC00\uD840\uDC03\uD83D\uDE09").allSatisfy(Character::isBmpCodePoint));
    }

    @Test
    public void anySatisfyUnicode() {
        Assert.assertTrue(CodePointList.from("\u3042\u3044\u3046").anySatisfy(Character::isBmpCodePoint));
        Assert.assertFalse(CodePointList.from("\uD840\uDC00\uD840\uDC03\uD83D\uDE09").anySatisfy(Character::isBmpCodePoint));
    }

    @Test
    public void noneSatisfyUnicode() {
        Assert.assertFalse(CodePointList.from("\u3042\u3044\u3046").noneSatisfy(Character::isBmpCodePoint));
        Assert.assertTrue(CodePointList.from("\uD840\uDC00\uD840\uDC03\uD83D\uDE09").noneSatisfy(Character::isBmpCodePoint));
    }

    @Test
    public void forEachUnicode() {
        StringBuilder builder = new StringBuilder();
        CodePointList.from(UNICODE_STRING).forEach(builder::appendCodePoint);
        Assert.assertEquals(UNICODE_STRING, builder.toString());
    }

    @Test
    public void asReversedForEachUnicode() {
        StringBuilder builder = new StringBuilder();
        CodePointList.from(UNICODE_STRING).asReversed().forEach(builder::appendCodePoint);
        Assert.assertEquals("\uD83D\uDE09\u3046\uD840\uDC03\u3044\uD840\uDC00\u3042", builder.toString());
        StringBuilder builder2 = new StringBuilder();
        CodePointList.from("\uD840\uDC00\u3042\uD840\uDC03\u3044\uD83D\uDE09\u3046").asReversed().forEach(builder2::appendCodePoint);
        Assert.assertEquals("\u3046\uD83D\uDE09\u3044\uD840\uDC03\u3042\uD840\uDC00", builder2.toString());
        CodePointList.from("").asReversed().forEach((int codePoint) -> Assert.fail());
    }

    @Test
    public void asReversedForEachInvalidUnicode() {
        StringBuilder builder = new StringBuilder();
        CodePointList.from("\u3042\uDC00\uD840\u3044\uDC03\uD840\u3046\uDE09\uD83D").asReversed().forEach(builder::appendCodePoint);
        Assert.assertEquals("\uD83D\uDE09\u3046\uD840\uDC03\u3044\uD840\uDC00\u3042", builder.toString());
        StringBuilder builder2 = new StringBuilder();
        CodePointList.from("\u3042\uD840\u3044\uD840\u3046\uD840").asReversed().forEach(builder2::appendCodePoint);
        Assert.assertEquals("\uD840\u3046\uD840\u3044\uD840\u3042", builder2.toString());
        StringBuilder builder3 = new StringBuilder();
        CodePointList.from("\u3042\uDC00\u3044\uDC03\u3046\uDC06").asReversed().forEach(builder3::appendCodePoint);
        Assert.assertEquals("\uDC06\u3046\uDC03\u3044\uDC00\u3042", builder3.toString());
        CodePointList.from("").asReversed().forEach((int codePoint) -> Assert.fail());
    }

    @Test
    public void toReversedForEachUnicode() {
        StringBuilder builder = new StringBuilder();
        CodePointList.from(UNICODE_STRING).toReversed().forEach(builder::appendCodePoint);
        Assert.assertEquals("\uD83D\uDE09\u3046\uD840\uDC03\u3044\uD840\uDC00\u3042", builder.toString());
        StringBuilder builder2 = new StringBuilder();
        CodePointList.from("\uD840\uDC00\u3042\uD840\uDC03\u3044\uD83D\uDE09\u3046").toReversed().forEach(builder2::appendCodePoint);
        Assert.assertEquals("\u3046\uD83D\uDE09\u3044\uD840\uDC03\u3042\uD840\uDC00", builder2.toString());
        CodePointList.from("").toReversed().forEach((int codePoint) -> Assert.fail());
    }

    @Test
    public void toReversedForEachInvalidUnicode() {
        StringBuilder builder = new StringBuilder();
        CodePointList.from("\u3042\uDC00\uD840\u3044\uDC03\uD840\u3046\uDE09\uD83D").toReversed().forEach(builder::appendCodePoint);
        Assert.assertEquals("\uD83D\uDE09\u3046\uD840\uDC03\u3044\uD840\uDC00\u3042", builder.toString());
        StringBuilder builder2 = new StringBuilder();
        CodePointList.from("\u3042\uD840\u3044\uD840\u3046\uD840").toReversed().forEach(builder2::appendCodePoint);
        Assert.assertEquals("\uD840\u3046\uD840\u3044\uD840\u3042", builder2.toString());
        StringBuilder builder3 = new StringBuilder();
        CodePointList.from("\u3042\uDC00\u3044\uDC03\u3046\uDC06").toReversed().forEach(builder3::appendCodePoint);
        Assert.assertEquals("\uDC06\u3046\uDC03\u3044\uDC00\u3042", builder3.toString());
        CodePointList.from("").toReversed().forEach((int codePoint) -> Assert.fail());
    }

    @Test
    public void newWithUnicode() {
        CodePointList codePointList = CodePointList.from("");
        CodePointList collection = codePointList.newWith(12354);
        CodePointList collection0 = codePointList.newWith(12354).newWith(131072);
        CodePointList collection1 = codePointList.newWith(12354).newWith(131072).newWith(12356);
        CodePointList collection2 = codePointList.newWith(12354).newWith(131072).newWith(12356).newWith(131075);
        CodePointList collection3 = codePointList.newWith(12354).newWith(131072).newWith(12356).newWith(131075).newWith(12358);
        this.assertSizeAndContains(codePointList);
        this.assertSizeAndContains(collection, 12354);
        this.assertSizeAndContains(collection0, 12354, 131072);
        this.assertSizeAndContains(collection1, 12354, 131072, 12356);
        this.assertSizeAndContains(collection2, 12354, 131072, 12356, 131075);
        this.assertSizeAndContains(collection3, 12354, 131072, 12356, 131075, 12358);
    }

    @Test
    public void newWithoutUnicode() {
        CodePointList collection0 = CodePointList.from("\u3042\uD840\uDC00\u3044\uD840\uDC03\u3046");
        CodePointList collection1 = collection0.newWithout(12358);
        CodePointList collection2 = collection1.newWithout(131075);
        CodePointList collection3 = collection2.newWithout(12356);
        CodePointList collection4 = collection3.newWithout(131072);
        CodePointList collection5 = collection4.newWithout(12354);
        CodePointList collection6 = collection5.newWithout(131078);
        this.assertSizeAndContains(collection6);
        this.assertSizeAndContains(collection5);
        this.assertSizeAndContains(collection4, 12354);
        this.assertSizeAndContains(collection3, 12354, 131072);
        this.assertSizeAndContains(collection2, 12354, 131072, 12356);
        this.assertSizeAndContains(collection1, 12354, 131072, 12356, 131075);
    }

    @Test
    public void distinctUnicode() {
        Assert.assertEquals("\uD840\uDC00\uD840\uDC03\uD83D\uDE09", CodePointList.from("\uD840\uDC00\uD840\uDC03\uD83D\uDE09\uD840\uDC00\uD840\uDC03\uD83D\uDE09").distinct().toString());
    }

    @Override
    public void toReversed() {
        super.toReversed();
        Assert.assertEquals("cba", CodePointList.from("abc").toReversed().toString());
    }

    @Test
    public void primitiveStream() {
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4, 5), CodePointList.from(1, 2, 3, 4, 5).primitiveStream().boxed().collect(Collectors.toList()));
    }

    @Test
    public void primitiveParallelStream() {
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4, 5), CodePointList.from(1, 2, 3, 4, 5).primitiveParallelStream().boxed().collect(Collectors.toList()));
    }

    @Test
    public void toImmutable() {
        CodePointList list = CodePointList.from("123");
        ImmutableIntList immutable = list.toImmutable();
        Assert.assertSame(list, immutable);
    }

    @Test
    public void asReversed() {
        CodePointList list = CodePointList.from("123");
        LazyIntIterable iterable = list.asReversed();
        String string = iterable.collectChar(each -> (char) each).makeString("");
        Assert.assertEquals("321", string);
    }

    @Test
    public void dotProduct() {
        CodePointList list = CodePointList.from("123");
        long actual = list.dotProduct(list);
        MutableIntList mutable = IntLists.mutable.with((int) '1', (int) '2', (int) '3');
        long expected = mutable.dotProduct(mutable);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void binarySearch() {
        CodePointList list = CodePointList.from("123");
        Assert.assertEquals(1, list.binarySearch((int) '2'));
    }

    private static class SBAppendable implements Appendable {

        private final StringBuilder builder = new StringBuilder();

        @Override
        public Appendable append(char c) {
            return this.builder.append(c);
        }

        @Override
        public Appendable append(CharSequence csq) {
            return this.builder.append(csq);
        }

        @Override
        public Appendable append(CharSequence csq, int start, int end) {
            return this.builder.append(csq, start, end);
        }

        @Override
        public String toString() {
            return this.builder.toString();
        }
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CodePointListTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectIterableWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectIterableWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToLists() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToLists);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToSets() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToSets);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summaryStatistics() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summaryStatistics);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArrayWithTargetArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArrayWithTargetArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionNaturalOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionNaturalOrder);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOnEmptyThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOnEmptyThrows);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduce() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduce);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get_throws_index_greater_than_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get_throws_index_negative);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lastIndexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lastIndexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toReversed);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stringBuilder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stringBuilder);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subSequence() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subSequence);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringStringBuffer() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringStringBuffer);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringAppendable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringAppendable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCodePointUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCodePointUnicode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectCodePointUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectCodePointUnicode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyUnicode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyUnicode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyUnicode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachUnicode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asReversedForEachUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asReversedForEachUnicode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asReversedForEachInvalidUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asReversedForEachInvalidUnicode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversedForEachUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toReversedForEachUnicode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversedForEachInvalidUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toReversedForEachInvalidUnicode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithUnicode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutUnicode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctUnicode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_primitiveStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.primitiveStream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_primitiveParallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.primitiveParallelStream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asReversed);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dotProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dotProduct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_binarySearch() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.binarySearch);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> payload) throws java.lang.Throwable {
            this.instance = new CodePointListTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> intIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> intIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> zipInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> stringBuilder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> subSequence;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> appendStringStringBuffer;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> appendStringAppendable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> collectCodePointUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> selectCodePointUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> allSatisfyUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> anySatisfyUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> noneSatisfyUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> forEachUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> asReversedForEachUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> asReversedForEachInvalidUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> toReversedForEachUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> toReversedForEachInvalidUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> newWithUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> newWithoutUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> distinctUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> primitiveStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> primitiveParallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> asReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> dotProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointListTest> binarySearch;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = CodePointListTest::newCollectionWith;
            this.payloads.newCollection = CodePointListTest::newCollection;
            this.payloads.isEmpty = CodePointListTest::isEmpty;
            this.payloads.notEmpty = CodePointListTest::notEmpty;
            this.payloads.tap = CodePointListTest::tap;
            this.payloads.contains = CodePointListTest::contains;
            this.payloads.containsAllArray = CodePointListTest::containsAllArray;
            this.payloads.containsAllIterable = CodePointListTest::containsAllIterable;
            this.payloads.containsAnyArray = CodePointListTest::containsAnyArray;
            this.payloads.containsAnyIterable = CodePointListTest::containsAnyIterable;
            this.payloads.containsNoneArray = CodePointListTest::containsNoneArray;
            this.payloads.containsNoneIterable = CodePointListTest::containsNoneIterable;
            this.payloads.intIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CodePointListTest::intIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.intIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(CodePointListTest::intIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = CodePointListTest::forEach;
            this.payloads.size = CodePointListTest::size;
            this.payloads.count = CodePointListTest::count;
            this.payloads.noneSatisfy = CodePointListTest::noneSatisfy;
            this.payloads.collect = CodePointListTest::collect;
            this.payloads.collectWithTarget = CodePointListTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = CodePointListTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = CodePointListTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = CodePointListTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = CodePointListTest::collectPrimitivesToSets;
            this.payloads.select = CodePointListTest::select;
            this.payloads.selectWithTarget = CodePointListTest::selectWithTarget;
            this.payloads.reject = CodePointListTest::reject;
            this.payloads.rejectWithTarget = CodePointListTest::rejectWithTarget;
            this.payloads.detectIfNone = CodePointListTest::detectIfNone;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(CodePointListTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(CodePointListTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = CodePointListTest::minIfEmpty;
            this.payloads.maxIfEmpty = CodePointListTest::maxIfEmpty;
            this.payloads.sum = CodePointListTest::sum;
            this.payloads.summaryStatistics = CodePointListTest::summaryStatistics;
            this.payloads.average = CodePointListTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CodePointListTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = CodePointListTest::averageIfEmpty;
            this.payloads.median = CodePointListTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CodePointListTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = CodePointListTest::medianIfEmpty;
            this.payloads.toArrayWithTargetArray = CodePointListTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = CodePointListTest::toSortedArray;
            this.payloads.testHashCode = CodePointListTest::testHashCode;
            this.payloads.toSortedList = CodePointListTest::toSortedList;
            this.payloads.toSortedListByComparator = CodePointListTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = CodePointListTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = CodePointListTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = CodePointListTest::toSet;
            this.payloads.toBag = CodePointListTest::toBag;
            this.payloads.asLazy = CodePointListTest::asLazy;
            this.payloads.injectIntoBoolean = CodePointListTest::injectIntoBoolean;
            this.payloads.injectIntoByte = CodePointListTest::injectIntoByte;
            this.payloads.injectIntoChar = CodePointListTest::injectIntoChar;
            this.payloads.injectIntoShort = CodePointListTest::injectIntoShort;
            this.payloads.injectIntoInt = CodePointListTest::injectIntoInt;
            this.payloads.injectIntoFloat = CodePointListTest::injectIntoFloat;
            this.payloads.injectIntoLong = CodePointListTest::injectIntoLong;
            this.payloads.injectIntoDouble = CodePointListTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(CodePointListTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = CodePointListTest::reduce;
            this.payloads.reduceIfEmpty = CodePointListTest::reduceIfEmpty;
            this.payloads.chunk = CodePointListTest::chunk;
            this.payloads.testNewWith = CodePointListTest::testNewWith;
            this.payloads.newWithAll = CodePointListTest::newWithAll;
            this.payloads.newWithout = CodePointListTest::newWithout;
            this.payloads.newWithoutAll = CodePointListTest::newWithoutAll;
            this.payloads.get = CodePointListTest::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(CodePointListTest::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(CodePointListTest::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = CodePointListTest::getFirst;
            this.payloads.getLast = CodePointListTest::getLast;
            this.payloads.indexOf = CodePointListTest::indexOf;
            this.payloads.lastIndexOf = CodePointListTest::lastIndexOf;
            this.payloads.intIterator = CodePointListTest::intIterator;
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(CodePointListTest::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.toArray = CodePointListTest::toArray;
            this.payloads.injectInto = CodePointListTest::injectInto;
            this.payloads.injectIntoWithIndex = CodePointListTest::injectIntoWithIndex;
            this.payloads.selectWithIndex = CodePointListTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = CodePointListTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = CodePointListTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = CodePointListTest::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = CodePointListTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = CodePointListTest::collectWithIndexWithTarget;
            this.payloads.distinct = CodePointListTest::distinct;
            this.payloads.toReversed = CodePointListTest::toReversed;
            this.payloads.forEachWithIndex = CodePointListTest::forEachWithIndex;
            this.payloads.testEquals = CodePointListTest::testEquals;
            this.payloads.toList = CodePointListTest::toList;
            this.payloads.zipInt = CodePointListTest::zipInt;
            this.payloads.zip = CodePointListTest::zip;
            this.payloads.stream = CodePointListTest::stream;
            this.payloads.parallelStream = CodePointListTest::parallelStream;
            this.payloads.stringBuilder = CodePointListTest::stringBuilder;
            this.payloads.subSequence = CodePointListTest::subSequence;
            this.payloads.max = CodePointListTest::max;
            this.payloads.min = CodePointListTest::min;
            this.payloads.allSatisfy = CodePointListTest::allSatisfy;
            this.payloads.anySatisfy = CodePointListTest::anySatisfy;
            this.payloads.testToString = CodePointListTest::testToString;
            this.payloads.makeString = CodePointListTest::makeString;
            this.payloads.appendString = CodePointListTest::appendString;
            this.payloads.appendStringStringBuffer = CodePointListTest::appendStringStringBuffer;
            this.payloads.appendStringAppendable = CodePointListTest::appendStringAppendable;
            this.payloads.collectCodePointUnicode = CodePointListTest::collectCodePointUnicode;
            this.payloads.selectCodePointUnicode = CodePointListTest::selectCodePointUnicode;
            this.payloads.allSatisfyUnicode = CodePointListTest::allSatisfyUnicode;
            this.payloads.anySatisfyUnicode = CodePointListTest::anySatisfyUnicode;
            this.payloads.noneSatisfyUnicode = CodePointListTest::noneSatisfyUnicode;
            this.payloads.forEachUnicode = CodePointListTest::forEachUnicode;
            this.payloads.asReversedForEachUnicode = CodePointListTest::asReversedForEachUnicode;
            this.payloads.asReversedForEachInvalidUnicode = CodePointListTest::asReversedForEachInvalidUnicode;
            this.payloads.toReversedForEachUnicode = CodePointListTest::toReversedForEachUnicode;
            this.payloads.toReversedForEachInvalidUnicode = CodePointListTest::toReversedForEachInvalidUnicode;
            this.payloads.newWithUnicode = CodePointListTest::newWithUnicode;
            this.payloads.newWithoutUnicode = CodePointListTest::newWithoutUnicode;
            this.payloads.distinctUnicode = CodePointListTest::distinctUnicode;
            this.payloads.primitiveStream = CodePointListTest::primitiveStream;
            this.payloads.primitiveParallelStream = CodePointListTest::primitiveParallelStream;
            this.payloads.toImmutable = CodePointListTest::toImmutable;
            this.payloads.asReversed = CodePointListTest::asReversed;
            this.payloads.dotProduct = CodePointListTest::dotProduct;
            this.payloads.binarySearch = CodePointListTest::binarySearch;
        }
    }
}
