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
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.factory.Strings;
import org.eclipse.collections.impl.list.immutable.primitive.AbstractImmutableIntListTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class CodePointAdapterTest extends AbstractImmutableIntListTestCase {

    private static final String UNICODE_STRING = "\u3042\uD840\uDC00\u3044\uD840\uDC03\u3046\uD83D\uDE09";

    @Override
    protected ImmutableIntList classUnderTest() {
        return CodePointAdapter.from(1, 2, 3);
    }

    @Override
    protected ImmutableIntList newWith(int... elements) {
        return CodePointAdapter.from(elements);
    }

    @SuppressWarnings("StringBufferReplaceableByString")
    @Test
    public void stringBuilder() {
        CodePointAdapter adapt = CodePointAdapter.adapt(UNICODE_STRING);
        Assert.assertEquals(UNICODE_STRING, new StringBuilder(adapt).toString());
    }

    @Test
    public void subSequence() {
        CodePointAdapter adapt = CodePointAdapter.adapt(UNICODE_STRING);
        CharSequence sequence = adapt.subSequence(1, 3);
        Assert.assertEquals(UNICODE_STRING.subSequence(1, 3), sequence);
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        ImmutableIntList list1 = this.newWith(1, 2, 3, 4);
        ImmutableIntList list2 = this.newWith(4, 3, 2, 1);
        Assert.assertNotEquals(list1, list2);
        Assert.assertEquals(CodePointAdapter.adapt(UNICODE_STRING), CodePointAdapter.adapt(UNICODE_STRING));
        Assert.assertNotEquals(CodePointAdapter.adapt("\u3042\uD840\uDC00\u3044\uD840\uDC03\u3046"), CodePointAdapter.adapt(UNICODE_STRING));
        Assert.assertEquals(CodePointAdapter.adapt("ABC"), CodePointAdapter.adapt("ABC"));
        Assert.assertNotEquals(CodePointAdapter.adapt("123"), CodePointAdapter.adapt("ABC"));
        Verify.assertEqualsAndHashCode(CodePointAdapter.adapt("ABC"), CodePointList.from("ABC"));
        Verify.assertEqualsAndHashCode(CodePointAdapter.adapt(UNICODE_STRING), CodePointList.from(UNICODE_STRING));
        Assert.assertNotEquals(CodePointList.from("123"), CodePointAdapter.adapt("ABC"));
        Assert.assertNotEquals(CodePointAdapter.adapt("ABC"), CodePointList.from("123"));
        Assert.assertNotEquals(CodePointList.from("ABCD"), CodePointAdapter.adapt("ABC"));
        Assert.assertNotEquals(CodePointAdapter.adapt("ABC"), CodePointList.from("ABCD"));
        Assert.assertNotEquals(CodePointList.from("ABC"), CodePointAdapter.adapt("ABCD"));
        Assert.assertNotEquals(CodePointAdapter.adapt("ABCD"), CodePointList.from("ABC"));
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
    }

    @Test
    public void collectCodePointUnicode() {
        Assert.assertEquals(UNICODE_STRING.codePoints().boxed().collect(Collectors.toList()), CodePointAdapter.adapt(UNICODE_STRING).collect(i -> i));
        Assert.assertEquals(UNICODE_STRING.codePoints().boxed().collect(Collectors.toList()), CodePointAdapter.adapt(UNICODE_STRING).collect(i -> i));
    }

    @Test
    public void selectCodePointUnicode() {
        String string = CodePointAdapter.adapt(UNICODE_STRING).select(Character::isBmpCodePoint).toString();
        Assert.assertEquals("\u3042\u3044\u3046", string);
    }

    @Test
    public void allSatisfyUnicode() {
        Assert.assertTrue(CodePointAdapter.adapt("\u3042\u3044\u3046").allSatisfy(Character::isBmpCodePoint));
        Assert.assertFalse(CodePointAdapter.adapt("\uD840\uDC00\uD840\uDC03\uD83D\uDE09").allSatisfy(Character::isBmpCodePoint));
    }

    @Test
    public void anySatisfyUnicode() {
        Assert.assertTrue(CodePointAdapter.adapt("\u3042\u3044\u3046").anySatisfy(Character::isBmpCodePoint));
        Assert.assertFalse(CodePointAdapter.adapt("\uD840\uDC00\uD840\uDC03\uD83D\uDE09").anySatisfy(Character::isBmpCodePoint));
    }

    @Test
    public void noneSatisfyUnicode() {
        Assert.assertFalse(CodePointAdapter.adapt("\u3042\u3044\u3046").noneSatisfy(Character::isBmpCodePoint));
        Assert.assertTrue(CodePointAdapter.adapt("\uD840\uDC00\uD840\uDC03\uD83D\uDE09").noneSatisfy(Character::isBmpCodePoint));
    }

    @Test
    public void forEachUnicode() {
        StringBuilder builder = new StringBuilder();
        CodePointAdapter.adapt(UNICODE_STRING).forEach(builder::appendCodePoint);
        Assert.assertEquals(UNICODE_STRING, builder.toString());
    }

    @Test
    public void asReversedForEachUnicode() {
        StringBuilder builder = new StringBuilder();
        CodePointAdapter.adapt(UNICODE_STRING).asReversed().forEach(builder::appendCodePoint);
        Assert.assertEquals("\uD83D\uDE09\u3046\uD840\uDC03\u3044\uD840\uDC00\u3042", builder.toString());
        StringBuilder builder2 = new StringBuilder();
        CodePointAdapter.adapt("\uD840\uDC00\u3042\uD840\uDC03\u3044\uD83D\uDE09\u3046").asReversed().forEach(builder2::appendCodePoint);
        Assert.assertEquals("\u3046\uD83D\uDE09\u3044\uD840\uDC03\u3042\uD840\uDC00", builder2.toString());
        CodePointAdapter.adapt("").asReversed().forEach((int codePoint) -> Assert.fail());
    }

    @Test
    public void asReversedForEachInvalidUnicode() {
        StringBuilder builder = new StringBuilder();
        CodePointAdapter.adapt("\u3042\uDC00\uD840\u3044\uDC03\uD840\u3046\uDE09\uD83D").asReversed().forEach(builder::appendCodePoint);
        Assert.assertEquals("\uD83D\uDE09\u3046\uD840\uDC03\u3044\uD840\uDC00\u3042", builder.toString());
        StringBuilder builder2 = new StringBuilder();
        CodePointAdapter.adapt("\u3042\uD840\u3044\uD840\u3046\uD840").asReversed().forEach(builder2::appendCodePoint);
        Assert.assertEquals("\uD840\u3046\uD840\u3044\uD840\u3042", builder2.toString());
        StringBuilder builder3 = new StringBuilder();
        CodePointAdapter.adapt("\u3042\uDC00\u3044\uDC03\u3046\uDC06").asReversed().forEach(builder3::appendCodePoint);
        Assert.assertEquals("\uDC06\u3046\uDC03\u3044\uDC00\u3042", builder3.toString());
        CodePointAdapter.adapt("").asReversed().forEach((int codePoint) -> Assert.fail());
    }

    @Test
    public void toReversedForEachUnicode() {
        StringBuilder builder = new StringBuilder();
        CodePointAdapter.adapt(UNICODE_STRING).toReversed().forEach(builder::appendCodePoint);
        Assert.assertEquals("\uD83D\uDE09\u3046\uD840\uDC03\u3044\uD840\uDC00\u3042", builder.toString());
        StringBuilder builder2 = new StringBuilder();
        CodePointAdapter.adapt("\uD840\uDC00\u3042\uD840\uDC03\u3044\uD83D\uDE09\u3046").toReversed().forEach(builder2::appendCodePoint);
        Assert.assertEquals("\u3046\uD83D\uDE09\u3044\uD840\uDC03\u3042\uD840\uDC00", builder2.toString());
        CodePointAdapter.adapt("").toReversed().forEach((int codePoint) -> Assert.fail());
    }

    @Test
    public void toReversedForEachInvalidUnicode() {
        StringBuilder builder = new StringBuilder();
        CodePointAdapter.adapt("\u3042\uDC00\uD840\u3044\uDC03\uD840\u3046\uDE09\uD83D").toReversed().forEach(builder::appendCodePoint);
        Assert.assertEquals("\uD83D\uDE09\u3046\uD840\uDC03\u3044\uD840\uDC00\u3042", builder.toString());
        StringBuilder builder2 = new StringBuilder();
        CodePointAdapter.adapt("\u3042\uD840\u3044\uD840\u3046\uD840").toReversed().forEach(builder2::appendCodePoint);
        Assert.assertEquals("\uD840\u3046\uD840\u3044\uD840\u3042", builder2.toString());
        StringBuilder builder3 = new StringBuilder();
        CodePointAdapter.adapt("\u3042\uDC00\u3044\uDC03\u3046\uDC06").toReversed().forEach(builder3::appendCodePoint);
        Assert.assertEquals("\uDC06\u3046\uDC03\u3044\uDC00\u3042", builder3.toString());
        CodePointAdapter.adapt("").toReversed().forEach((int codePoint) -> Assert.fail());
    }

    @Test
    public void distinctUnicode() {
        Assert.assertEquals("\uD840\uDC00\uD840\uDC03\uD83D\uDE09", CodePointAdapter.adapt("\uD840\uDC00\uD840\uDC03\uD83D\uDE09\uD840\uDC00\uD840\uDC03\uD83D\uDE09").distinct().toString());
    }

    @Test
    public void newWithUnicode() {
        CodePointAdapter codePointAdapter = CodePointAdapter.adapt("");
        CodePointAdapter collection = codePointAdapter.newWith(12354);
        CodePointAdapter collection0 = codePointAdapter.newWith(12354).newWith(131072);
        CodePointAdapter collection1 = codePointAdapter.newWith(12354).newWith(131072).newWith(12356);
        CodePointAdapter collection2 = codePointAdapter.newWith(12354).newWith(131072).newWith(12356).newWith(131075);
        CodePointAdapter collection3 = codePointAdapter.newWith(12354).newWith(131072).newWith(12356).newWith(131075).newWith(12358);
        this.assertSizeAndContains(codePointAdapter);
        this.assertSizeAndContains(collection, 12354);
        this.assertSizeAndContains(collection0, 12354, 131072);
        this.assertSizeAndContains(collection1, 12354, 131072, 12356);
        this.assertSizeAndContains(collection2, 12354, 131072, 12356, 131075);
        this.assertSizeAndContains(collection3, 12354, 131072, 12356, 131075, 12358);
    }

    @Test
    public void newWithoutUnicode() {
        CodePointAdapter collection0 = CodePointAdapter.adapt("\u3042\uD840\uDC00\u3044\uD840\uDC03\u3046");
        CodePointAdapter collection1 = collection0.newWithout(12358);
        CodePointAdapter collection2 = collection1.newWithout(131075);
        CodePointAdapter collection3 = collection2.newWithout(12356);
        CodePointAdapter collection4 = collection3.newWithout(131072);
        CodePointAdapter collection5 = collection4.newWithout(12354);
        CodePointAdapter collection6 = collection5.newWithout(131078);
        this.assertSizeAndContains(collection6);
        this.assertSizeAndContains(collection5);
        this.assertSizeAndContains(collection4, 12354);
        this.assertSizeAndContains(collection3, 12354, 131072);
        this.assertSizeAndContains(collection2, 12354, 131072, 12356);
        this.assertSizeAndContains(collection1, 12354, 131072, 12356, 131075);
    }

    @Override
    public void toReversed() {
        super.toReversed();
        Assert.assertEquals("cba", CodePointAdapter.adapt("abc").toReversed().toString());
    }

    @Test
    public void primitiveStream() {
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4, 5), this.newWith(1, 2, 3, 4, 5).primitiveStream().boxed().collect(Collectors.toList()));
    }

    @Test
    public void primitiveParallelStream() {
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4, 5), this.newWith(1, 2, 3, 4, 5).primitiveParallelStream().boxed().collect(Collectors.toList()));
    }

    @Test
    public void toImmutable() {
        CodePointAdapter adapter = Strings.asCodePoints("123");
        ImmutableIntList immutable = adapter.toImmutable();
        Assert.assertSame(adapter, immutable);
    }

    @Test
    public void asReversed() {
        CodePointAdapter adapter = Strings.asCodePoints("123");
        LazyIntIterable iterable = adapter.asReversed();
        String string = iterable.collectChar(each -> (char) each).makeString("");
        Assert.assertEquals("321", string);
    }

    @Test
    public void dotProduct() {
        CodePointAdapter adapter = Strings.asCodePoints("123");
        Assert.assertThrows(UnsupportedOperationException.class, () -> {
            adapter.dotProduct(adapter);
        });
    }

    @Test
    public void binarySearch() {
        CodePointAdapter adapter = Strings.asCodePoints("123");
        Assert.assertThrows(UnsupportedOperationException.class, () -> {
            adapter.binarySearch((int) '2');
        });
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

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CodePointAdapterTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectIterableWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectIterableWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToLists() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToLists);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToSets() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToSets);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summaryStatistics() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summaryStatistics);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArrayWithTargetArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArrayWithTargetArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionNaturalOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionNaturalOrder);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionWithComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOnEmptyThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOnEmptyThrows);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduce() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduce);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get_throws_index_greater_than_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get_throws_index_negative);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lastIndexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lastIndexOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toReversed);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stringBuilder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stringBuilder);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subSequence() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subSequence);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringStringBuffer() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringStringBuffer);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringAppendable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringAppendable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCodePointUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCodePointUnicode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectCodePointUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectCodePointUnicode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyUnicode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyUnicode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyUnicode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachUnicode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asReversedForEachUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asReversedForEachUnicode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asReversedForEachInvalidUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asReversedForEachInvalidUnicode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversedForEachUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toReversedForEachUnicode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversedForEachInvalidUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toReversedForEachInvalidUnicode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctUnicode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithUnicode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutUnicode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_primitiveStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.primitiveStream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_primitiveParallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.primitiveParallelStream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asReversed);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dotProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dotProduct);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_binarySearch() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.binarySearch);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> payload) throws java.lang.Throwable {
            this.instance = new CodePointAdapterTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> intIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> intIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> zipInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> stringBuilder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> subSequence;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> appendStringStringBuffer;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> appendStringAppendable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> collectCodePointUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> selectCodePointUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> allSatisfyUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> anySatisfyUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> noneSatisfyUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> forEachUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> asReversedForEachUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> asReversedForEachInvalidUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> toReversedForEachUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> toReversedForEachInvalidUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> distinctUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> newWithUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> newWithoutUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> primitiveStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> primitiveParallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> asReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> dotProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CodePointAdapterTest> binarySearch;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = CodePointAdapterTest::newCollectionWith;
            this.payloads.newCollection = CodePointAdapterTest::newCollection;
            this.payloads.isEmpty = CodePointAdapterTest::isEmpty;
            this.payloads.notEmpty = CodePointAdapterTest::notEmpty;
            this.payloads.tap = CodePointAdapterTest::tap;
            this.payloads.contains = CodePointAdapterTest::contains;
            this.payloads.containsAllArray = CodePointAdapterTest::containsAllArray;
            this.payloads.containsAllIterable = CodePointAdapterTest::containsAllIterable;
            this.payloads.containsAnyArray = CodePointAdapterTest::containsAnyArray;
            this.payloads.containsAnyIterable = CodePointAdapterTest::containsAnyIterable;
            this.payloads.containsNoneArray = CodePointAdapterTest::containsNoneArray;
            this.payloads.containsNoneIterable = CodePointAdapterTest::containsNoneIterable;
            this.payloads.intIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CodePointAdapterTest::intIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.intIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(CodePointAdapterTest::intIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = CodePointAdapterTest::forEach;
            this.payloads.size = CodePointAdapterTest::size;
            this.payloads.count = CodePointAdapterTest::count;
            this.payloads.noneSatisfy = CodePointAdapterTest::noneSatisfy;
            this.payloads.collect = CodePointAdapterTest::collect;
            this.payloads.collectWithTarget = CodePointAdapterTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = CodePointAdapterTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = CodePointAdapterTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = CodePointAdapterTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = CodePointAdapterTest::collectPrimitivesToSets;
            this.payloads.select = CodePointAdapterTest::select;
            this.payloads.selectWithTarget = CodePointAdapterTest::selectWithTarget;
            this.payloads.reject = CodePointAdapterTest::reject;
            this.payloads.rejectWithTarget = CodePointAdapterTest::rejectWithTarget;
            this.payloads.detectIfNone = CodePointAdapterTest::detectIfNone;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(CodePointAdapterTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(CodePointAdapterTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = CodePointAdapterTest::minIfEmpty;
            this.payloads.maxIfEmpty = CodePointAdapterTest::maxIfEmpty;
            this.payloads.sum = CodePointAdapterTest::sum;
            this.payloads.summaryStatistics = CodePointAdapterTest::summaryStatistics;
            this.payloads.average = CodePointAdapterTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CodePointAdapterTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = CodePointAdapterTest::averageIfEmpty;
            this.payloads.median = CodePointAdapterTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CodePointAdapterTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = CodePointAdapterTest::medianIfEmpty;
            this.payloads.toArrayWithTargetArray = CodePointAdapterTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = CodePointAdapterTest::toSortedArray;
            this.payloads.testHashCode = CodePointAdapterTest::testHashCode;
            this.payloads.toSortedList = CodePointAdapterTest::toSortedList;
            this.payloads.toSortedListByComparator = CodePointAdapterTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = CodePointAdapterTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = CodePointAdapterTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = CodePointAdapterTest::toSet;
            this.payloads.toBag = CodePointAdapterTest::toBag;
            this.payloads.asLazy = CodePointAdapterTest::asLazy;
            this.payloads.injectIntoBoolean = CodePointAdapterTest::injectIntoBoolean;
            this.payloads.injectIntoByte = CodePointAdapterTest::injectIntoByte;
            this.payloads.injectIntoChar = CodePointAdapterTest::injectIntoChar;
            this.payloads.injectIntoShort = CodePointAdapterTest::injectIntoShort;
            this.payloads.injectIntoInt = CodePointAdapterTest::injectIntoInt;
            this.payloads.injectIntoFloat = CodePointAdapterTest::injectIntoFloat;
            this.payloads.injectIntoLong = CodePointAdapterTest::injectIntoLong;
            this.payloads.injectIntoDouble = CodePointAdapterTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(CodePointAdapterTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = CodePointAdapterTest::reduce;
            this.payloads.reduceIfEmpty = CodePointAdapterTest::reduceIfEmpty;
            this.payloads.chunk = CodePointAdapterTest::chunk;
            this.payloads.testNewWith = CodePointAdapterTest::testNewWith;
            this.payloads.newWithAll = CodePointAdapterTest::newWithAll;
            this.payloads.newWithout = CodePointAdapterTest::newWithout;
            this.payloads.newWithoutAll = CodePointAdapterTest::newWithoutAll;
            this.payloads.get = CodePointAdapterTest::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(CodePointAdapterTest::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(CodePointAdapterTest::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = CodePointAdapterTest::getFirst;
            this.payloads.getLast = CodePointAdapterTest::getLast;
            this.payloads.indexOf = CodePointAdapterTest::indexOf;
            this.payloads.lastIndexOf = CodePointAdapterTest::lastIndexOf;
            this.payloads.intIterator = CodePointAdapterTest::intIterator;
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(CodePointAdapterTest::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.toArray = CodePointAdapterTest::toArray;
            this.payloads.injectInto = CodePointAdapterTest::injectInto;
            this.payloads.injectIntoWithIndex = CodePointAdapterTest::injectIntoWithIndex;
            this.payloads.selectWithIndex = CodePointAdapterTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = CodePointAdapterTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = CodePointAdapterTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = CodePointAdapterTest::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = CodePointAdapterTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = CodePointAdapterTest::collectWithIndexWithTarget;
            this.payloads.distinct = CodePointAdapterTest::distinct;
            this.payloads.toReversed = CodePointAdapterTest::toReversed;
            this.payloads.forEachWithIndex = CodePointAdapterTest::forEachWithIndex;
            this.payloads.toList = CodePointAdapterTest::toList;
            this.payloads.zipInt = CodePointAdapterTest::zipInt;
            this.payloads.zip = CodePointAdapterTest::zip;
            this.payloads.stream = CodePointAdapterTest::stream;
            this.payloads.parallelStream = CodePointAdapterTest::parallelStream;
            this.payloads.stringBuilder = CodePointAdapterTest::stringBuilder;
            this.payloads.subSequence = CodePointAdapterTest::subSequence;
            this.payloads.testEquals = CodePointAdapterTest::testEquals;
            this.payloads.max = CodePointAdapterTest::max;
            this.payloads.min = CodePointAdapterTest::min;
            this.payloads.allSatisfy = CodePointAdapterTest::allSatisfy;
            this.payloads.anySatisfy = CodePointAdapterTest::anySatisfy;
            this.payloads.testToString = CodePointAdapterTest::testToString;
            this.payloads.makeString = CodePointAdapterTest::makeString;
            this.payloads.appendString = CodePointAdapterTest::appendString;
            this.payloads.appendStringStringBuffer = CodePointAdapterTest::appendStringStringBuffer;
            this.payloads.appendStringAppendable = CodePointAdapterTest::appendStringAppendable;
            this.payloads.collectCodePointUnicode = CodePointAdapterTest::collectCodePointUnicode;
            this.payloads.selectCodePointUnicode = CodePointAdapterTest::selectCodePointUnicode;
            this.payloads.allSatisfyUnicode = CodePointAdapterTest::allSatisfyUnicode;
            this.payloads.anySatisfyUnicode = CodePointAdapterTest::anySatisfyUnicode;
            this.payloads.noneSatisfyUnicode = CodePointAdapterTest::noneSatisfyUnicode;
            this.payloads.forEachUnicode = CodePointAdapterTest::forEachUnicode;
            this.payloads.asReversedForEachUnicode = CodePointAdapterTest::asReversedForEachUnicode;
            this.payloads.asReversedForEachInvalidUnicode = CodePointAdapterTest::asReversedForEachInvalidUnicode;
            this.payloads.toReversedForEachUnicode = CodePointAdapterTest::toReversedForEachUnicode;
            this.payloads.toReversedForEachInvalidUnicode = CodePointAdapterTest::toReversedForEachInvalidUnicode;
            this.payloads.distinctUnicode = CodePointAdapterTest::distinctUnicode;
            this.payloads.newWithUnicode = CodePointAdapterTest::newWithUnicode;
            this.payloads.newWithoutUnicode = CodePointAdapterTest::newWithoutUnicode;
            this.payloads.primitiveStream = CodePointAdapterTest::primitiveStream;
            this.payloads.primitiveParallelStream = CodePointAdapterTest::primitiveParallelStream;
            this.payloads.toImmutable = CodePointAdapterTest::toImmutable;
            this.payloads.asReversed = CodePointAdapterTest::asReversed;
            this.payloads.dotProduct = CodePointAdapterTest::dotProduct;
            this.payloads.binarySearch = CodePointAdapterTest::binarySearch;
        }
    }
*/
}
