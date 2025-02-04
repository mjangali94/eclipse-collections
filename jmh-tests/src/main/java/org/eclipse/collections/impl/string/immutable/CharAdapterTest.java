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

import org.eclipse.collections.api.LazyCharIterable;
import org.eclipse.collections.api.bag.primitive.MutableCharBag;
import org.eclipse.collections.api.list.primitive.ImmutableCharList;
import org.eclipse.collections.impl.factory.Strings;
import org.eclipse.collections.impl.factory.primitive.CharBags;
import org.eclipse.collections.impl.list.immutable.primitive.AbstractImmutableCharListTestCase;
import org.junit.Assert;
import org.junit.Test;

public class CharAdapterTest extends AbstractImmutableCharListTestCase {

    private static final String UNICODE_STRING = "\u3042\uD840\uDC00\u3044\uD840\uDC03\u3046\uD83D\uDE09";

    @Override
    protected ImmutableCharList classUnderTest() {
        return CharAdapter.from((char) 1, (char) 2, (char) 3);
    }

    @Override
    protected ImmutableCharList newWith(char... elements) {
        return CharAdapter.from(elements);
    }

    @SuppressWarnings("StringBufferReplaceableByString")
    @Test
    public void stringBuilder() {
        CharAdapter adapt = CharAdapter.adapt(UNICODE_STRING);
        Assert.assertEquals(UNICODE_STRING, new StringBuilder(adapt).toString());
    }

    @Test
    public void subSequence() {
        CharAdapter adapt = CharAdapter.adapt(UNICODE_STRING);
        CharSequence sequence = adapt.subSequence(1, 3);
        Assert.assertEquals(UNICODE_STRING.subSequence(1, 3), sequence);
    }

    @Override
    public void toBag() {
        super.toBag();
        MutableCharBag expected = CharBags.mutable.empty();
        expected.addOccurrences('a', 3);
        expected.addOccurrences('b', 3);
        expected.addOccurrences('c', 3);
        Assert.assertEquals(expected, CharAdapter.adapt("aaabbbccc").toBag());
    }

    @Override
    @Test
    public void makeString() {
        ImmutableCharList list = this.classUnderTest();
        StringBuilder expectedString = new StringBuilder();
        StringBuilder expectedString1 = new StringBuilder();
        int size = list.size();
        for (char each = 0; each < size; each++) {
            expectedString.append((char) (each + (char) 1));
            expectedString1.append((char) (each + (char) 1));
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
        for (char each = 0; each < size; each++) {
            expectedString.append((char) (each + (char) 1));
            expectedString1.append((char) (each + (char) 1));
            expectedString.append(each == size - 1 ? "" : ", ");
            expectedString1.append(each == size - 1 ? "" : "/");
        }
        ImmutableCharList list = this.classUnderTest();
        StringBuilder appendable2 = new StringBuilder();
        list.appendString(appendable2);
        Assert.assertEquals(expectedString.toString(), appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        list.appendString(appendable3, "/");
        Assert.assertEquals(expectedString1.toString(), appendable3.toString());
    }

    @Override
    @Test
    public void testToString() {
        StringBuilder expectedString = new StringBuilder();
        int size = this.classUnderTest().size();
        for (char each = 0; each < size; each++) {
            expectedString.append((char) (each + (char) 1));
        }
        Assert.assertEquals(expectedString.toString(), this.classUnderTest().toString());
    }

    @Test
    public void getCharacter() {
        CharAdapter adapter = Strings.asChars("123");
        Assert.assertEquals(Character.valueOf('1'), adapter.getCharacter(0));
        Assert.assertEquals(Character.valueOf('2'), adapter.getCharacter(1));
        Assert.assertEquals(Character.valueOf('3'), adapter.getCharacter(2));
    }

    @Test
    public void toImmutable() {
        CharAdapter adapter = Strings.asChars("123");
        ImmutableCharList immutable = adapter.toImmutable();
        Assert.assertSame(adapter, immutable);
    }

    @Test
    public void asReversed() {
        CharAdapter adapter = Strings.asChars("123");
        LazyCharIterable iterable = adapter.asReversed();
        String string = iterable.makeString("");
        Assert.assertEquals("321", string);
    }

    @Test
    public void dotProduct() {
        CharAdapter adapter = Strings.asChars("123");
        Assert.assertThrows(UnsupportedOperationException.class, () -> {
            adapter.dotProduct(adapter);
        });
    }

    @Test
    public void binarySearch() {
        CharAdapter adapter = Strings.asChars("123");
        Assert.assertThrows(UnsupportedOperationException.class, () -> {
            adapter.binarySearch('2');
        });
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CharAdapterTest instance;

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
        public void benchmark_charIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_non_empty_collection);
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
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
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
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
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
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
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
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getCharacter() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getCharacter);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> payload) throws java.lang.Throwable {
            this.instance = new CharAdapterTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> charIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> charIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> zipChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> stringBuilder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> subSequence;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> getCharacter;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> asReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> dotProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharAdapterTest> binarySearch;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = CharAdapterTest::newCollectionWith;
            this.payloads.newCollection = CharAdapterTest::newCollection;
            this.payloads.isEmpty = CharAdapterTest::isEmpty;
            this.payloads.notEmpty = CharAdapterTest::notEmpty;
            this.payloads.tap = CharAdapterTest::tap;
            this.payloads.contains = CharAdapterTest::contains;
            this.payloads.containsAllArray = CharAdapterTest::containsAllArray;
            this.payloads.containsAllIterable = CharAdapterTest::containsAllIterable;
            this.payloads.containsAnyArray = CharAdapterTest::containsAnyArray;
            this.payloads.containsAnyIterable = CharAdapterTest::containsAnyIterable;
            this.payloads.containsNoneArray = CharAdapterTest::containsNoneArray;
            this.payloads.containsNoneIterable = CharAdapterTest::containsNoneIterable;
            this.payloads.charIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharAdapterTest::charIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.charIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharAdapterTest::charIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = CharAdapterTest::forEach;
            this.payloads.size = CharAdapterTest::size;
            this.payloads.count = CharAdapterTest::count;
            this.payloads.anySatisfy = CharAdapterTest::anySatisfy;
            this.payloads.allSatisfy = CharAdapterTest::allSatisfy;
            this.payloads.noneSatisfy = CharAdapterTest::noneSatisfy;
            this.payloads.collect = CharAdapterTest::collect;
            this.payloads.collectWithTarget = CharAdapterTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = CharAdapterTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = CharAdapterTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = CharAdapterTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = CharAdapterTest::collectPrimitivesToSets;
            this.payloads.select = CharAdapterTest::select;
            this.payloads.selectWithTarget = CharAdapterTest::selectWithTarget;
            this.payloads.reject = CharAdapterTest::reject;
            this.payloads.rejectWithTarget = CharAdapterTest::rejectWithTarget;
            this.payloads.detectIfNone = CharAdapterTest::detectIfNone;
            this.payloads.max = CharAdapterTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharAdapterTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = CharAdapterTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharAdapterTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = CharAdapterTest::minIfEmpty;
            this.payloads.maxIfEmpty = CharAdapterTest::maxIfEmpty;
            this.payloads.sum = CharAdapterTest::sum;
            this.payloads.summaryStatistics = CharAdapterTest::summaryStatistics;
            this.payloads.average = CharAdapterTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharAdapterTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = CharAdapterTest::averageIfEmpty;
            this.payloads.median = CharAdapterTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharAdapterTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = CharAdapterTest::medianIfEmpty;
            this.payloads.toArrayWithTargetArray = CharAdapterTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = CharAdapterTest::toSortedArray;
            this.payloads.testHashCode = CharAdapterTest::testHashCode;
            this.payloads.toSortedList = CharAdapterTest::toSortedList;
            this.payloads.toSortedListByComparator = CharAdapterTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = CharAdapterTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = CharAdapterTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = CharAdapterTest::toSet;
            this.payloads.toBag = CharAdapterTest::toBag;
            this.payloads.asLazy = CharAdapterTest::asLazy;
            this.payloads.injectIntoBoolean = CharAdapterTest::injectIntoBoolean;
            this.payloads.injectIntoByte = CharAdapterTest::injectIntoByte;
            this.payloads.injectIntoChar = CharAdapterTest::injectIntoChar;
            this.payloads.injectIntoShort = CharAdapterTest::injectIntoShort;
            this.payloads.injectIntoInt = CharAdapterTest::injectIntoInt;
            this.payloads.injectIntoFloat = CharAdapterTest::injectIntoFloat;
            this.payloads.injectIntoLong = CharAdapterTest::injectIntoLong;
            this.payloads.injectIntoDouble = CharAdapterTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharAdapterTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = CharAdapterTest::reduce;
            this.payloads.reduceIfEmpty = CharAdapterTest::reduceIfEmpty;
            this.payloads.chunk = CharAdapterTest::chunk;
            this.payloads.testNewWith = CharAdapterTest::testNewWith;
            this.payloads.newWithAll = CharAdapterTest::newWithAll;
            this.payloads.newWithout = CharAdapterTest::newWithout;
            this.payloads.newWithoutAll = CharAdapterTest::newWithoutAll;
            this.payloads.get = CharAdapterTest::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharAdapterTest::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharAdapterTest::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = CharAdapterTest::getFirst;
            this.payloads.getLast = CharAdapterTest::getLast;
            this.payloads.indexOf = CharAdapterTest::indexOf;
            this.payloads.lastIndexOf = CharAdapterTest::lastIndexOf;
            this.payloads.charIterator = CharAdapterTest::charIterator;
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharAdapterTest::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.toArray = CharAdapterTest::toArray;
            this.payloads.injectInto = CharAdapterTest::injectInto;
            this.payloads.injectIntoWithIndex = CharAdapterTest::injectIntoWithIndex;
            this.payloads.selectWithIndex = CharAdapterTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = CharAdapterTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = CharAdapterTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = CharAdapterTest::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = CharAdapterTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = CharAdapterTest::collectWithIndexWithTarget;
            this.payloads.distinct = CharAdapterTest::distinct;
            this.payloads.toReversed = CharAdapterTest::toReversed;
            this.payloads.forEachWithIndex = CharAdapterTest::forEachWithIndex;
            this.payloads.testEquals = CharAdapterTest::testEquals;
            this.payloads.toList = CharAdapterTest::toList;
            this.payloads.zipChar = CharAdapterTest::zipChar;
            this.payloads.zip = CharAdapterTest::zip;
            this.payloads.stringBuilder = CharAdapterTest::stringBuilder;
            this.payloads.subSequence = CharAdapterTest::subSequence;
            this.payloads.makeString = CharAdapterTest::makeString;
            this.payloads.appendString = CharAdapterTest::appendString;
            this.payloads.testToString = CharAdapterTest::testToString;
            this.payloads.getCharacter = CharAdapterTest::getCharacter;
            this.payloads.toImmutable = CharAdapterTest::toImmutable;
            this.payloads.asReversed = CharAdapterTest::asReversed;
            this.payloads.dotProduct = CharAdapterTest::dotProduct;
            this.payloads.binarySearch = CharAdapterTest::binarySearch;
        }
    }
*/
}
