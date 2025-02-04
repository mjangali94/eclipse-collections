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

import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ByteHashBag}.
 * This file was automatically generated from template file primitiveHashBagTest.stg.
 */
public class ByteHashBagTest extends AbstractMutableByteBagTestCase {

    @Override
    protected final ByteHashBag classUnderTest() {
        return ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3);
    }

    @Override
    protected ByteHashBag newWith(byte... elements) {
        return ByteHashBag.newBagWith(elements);
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(0, new ByteHashBag(3));
        Verify.assertSize(0, ByteHashBag.newBag(3));
        Verify.assertSize(3, ByteHashBag.newBagWith((byte) 0, (byte) 1, (byte) 2));
        Verify.assertSize(3, new ByteHashBag(ByteHashBag.newBagWith((byte) 0, (byte) 1, (byte) 2)));
        Verify.assertSize(3, ByteHashBag.newBag(ByteHashBag.newBagWith((byte) 0, (byte) 1, (byte) 2)));
        Verify.assertSize(3, ByteHashBag.newBag(ByteArrayList.newListWith((byte) 0, (byte) 1, (byte) 2)));
        Verify.assertSize(3, new ByteHashBag(ByteArrayList.newListWith((byte) 0, (byte) 1, (byte) 2)));
    }

    @Override
    @Test
    public void with() {
        super.with();
        ByteHashBag hashBag = new ByteHashBag().with((byte) 1);
        ByteHashBag hashBag0 = new ByteHashBag().with((byte) 1, (byte) 2);
        ByteHashBag hashBag1 = new ByteHashBag().with((byte) 1, (byte) 2, (byte) 3);
        ByteHashBag hashBag2 = new ByteHashBag().with((byte) 1).with((byte) 2).with((byte) 3).with((byte) 4);
        ByteHashBag hashBag3 = new ByteHashBag().with((byte) 1).with((byte) 2).with((byte) 3).with((byte) 4).with((byte) 5);
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1), hashBag);
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2), hashBag0);
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), hashBag1);
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3, (byte) 4), hashBag2);
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), hashBag3);
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        ByteHashBag hashBag = ByteHashBag.newBagWith((byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 3);
        Byte sum = hashBag.injectInto(Byte.valueOf((byte) 4), (Byte result, byte value) -> Byte.valueOf((byte) (result + value)));
        Assert.assertEquals(Byte.valueOf((byte) 17), sum);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ByteHashBagTest instance;

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
        public void benchmark_byteIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
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
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll_iterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll_iterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_for_consecutive_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sizeDistinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sizeDistinct);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectByOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectByOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectDuplicates() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectDuplicates);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectUnique);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_topOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.topOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_bottomOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.bottomOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addOccurrences_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeOccurrences_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeOccurrences_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
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
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStringOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStringOfItemToCount);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> payload) throws java.lang.Throwable {
            this.instance = new ByteHashBagTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> byteIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> byteIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> byteIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> byteIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> addOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> addOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> removeOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> removeOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> byteIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashBagTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ByteHashBagTest::newCollectionWith;
            this.payloads.newCollection = ByteHashBagTest::newCollection;
            this.payloads.isEmpty = ByteHashBagTest::isEmpty;
            this.payloads.notEmpty = ByteHashBagTest::notEmpty;
            this.payloads.tap = ByteHashBagTest::tap;
            this.payloads.containsAllArray = ByteHashBagTest::containsAllArray;
            this.payloads.containsAllIterable = ByteHashBagTest::containsAllIterable;
            this.payloads.containsAnyArray = ByteHashBagTest::containsAnyArray;
            this.payloads.containsAnyIterable = ByteHashBagTest::containsAnyIterable;
            this.payloads.containsNoneArray = ByteHashBagTest::containsNoneArray;
            this.payloads.containsNoneIterable = ByteHashBagTest::containsNoneIterable;
            this.payloads.byteIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteHashBagTest::byteIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.anySatisfy = ByteHashBagTest::anySatisfy;
            this.payloads.allSatisfy = ByteHashBagTest::allSatisfy;
            this.payloads.noneSatisfy = ByteHashBagTest::noneSatisfy;
            this.payloads.collect = ByteHashBagTest::collect;
            this.payloads.collectWithTarget = ByteHashBagTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ByteHashBagTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ByteHashBagTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ByteHashBagTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ByteHashBagTest::collectPrimitivesToSets;
            this.payloads.select = ByteHashBagTest::select;
            this.payloads.selectWithTarget = ByteHashBagTest::selectWithTarget;
            this.payloads.reject = ByteHashBagTest::reject;
            this.payloads.rejectWithTarget = ByteHashBagTest::rejectWithTarget;
            this.payloads.detectIfNone = ByteHashBagTest::detectIfNone;
            this.payloads.max = ByteHashBagTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteHashBagTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ByteHashBagTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteHashBagTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ByteHashBagTest::minIfEmpty;
            this.payloads.maxIfEmpty = ByteHashBagTest::maxIfEmpty;
            this.payloads.summaryStatistics = ByteHashBagTest::summaryStatistics;
            this.payloads.average = ByteHashBagTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteHashBagTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ByteHashBagTest::averageIfEmpty;
            this.payloads.median = ByteHashBagTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteHashBagTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ByteHashBagTest::medianIfEmpty;
            this.payloads.toArray = ByteHashBagTest::toArray;
            this.payloads.toArrayWithTargetArray = ByteHashBagTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = ByteHashBagTest::toSortedArray;
            this.payloads.testHashCode = ByteHashBagTest::testHashCode;
            this.payloads.toSortedListByComparator = ByteHashBagTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ByteHashBagTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ByteHashBagTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ByteHashBagTest::toSet;
            this.payloads.toBag = ByteHashBagTest::toBag;
            this.payloads.asLazy = ByteHashBagTest::asLazy;
            this.payloads.injectIntoBoolean = ByteHashBagTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ByteHashBagTest::injectIntoByte;
            this.payloads.injectIntoChar = ByteHashBagTest::injectIntoChar;
            this.payloads.injectIntoShort = ByteHashBagTest::injectIntoShort;
            this.payloads.injectIntoInt = ByteHashBagTest::injectIntoInt;
            this.payloads.injectIntoFloat = ByteHashBagTest::injectIntoFloat;
            this.payloads.injectIntoLong = ByteHashBagTest::injectIntoLong;
            this.payloads.injectIntoDouble = ByteHashBagTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteHashBagTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ByteHashBagTest::reduce;
            this.payloads.reduceIfEmpty = ByteHashBagTest::reduceIfEmpty;
            this.payloads.chunk = ByteHashBagTest::chunk;
            this.payloads.clear = ByteHashBagTest::clear;
            this.payloads.contains = ByteHashBagTest::contains;
            this.payloads.addAllArray = ByteHashBagTest::addAllArray;
            this.payloads.removeIf = ByteHashBagTest::removeIf;
            this.payloads.removeAll = ByteHashBagTest::removeAll;
            this.payloads.removeAll_iterable = ByteHashBagTest::removeAll_iterable;
            this.payloads.retainAll = ByteHashBagTest::retainAll;
            this.payloads.retainAll_iterable = ByteHashBagTest::retainAll_iterable;
            this.payloads.withAll = ByteHashBagTest::withAll;
            this.payloads.without = ByteHashBagTest::without;
            this.payloads.withoutAll = ByteHashBagTest::withoutAll;
            this.payloads.asSynchronized = ByteHashBagTest::asSynchronized;
            this.payloads.asUnmodifiable = ByteHashBagTest::asUnmodifiable;
            this.payloads.byteIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteHashBagTest::byteIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.byteIterator_throws_for_remove_before_next = ByteHashBagTest::byteIterator_throws_for_remove_before_next;
            this.payloads.byteIterator_throws_for_consecutive_remove = ByteHashBagTest::byteIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = ByteHashBagTest::newEmpty;
            this.payloads.sizeDistinct = ByteHashBagTest::sizeDistinct;
            this.payloads.selectByOccurrences = ByteHashBagTest::selectByOccurrences;
            this.payloads.selectDuplicates = ByteHashBagTest::selectDuplicates;
            this.payloads.selectUnique = ByteHashBagTest::selectUnique;
            this.payloads.topOccurrences = ByteHashBagTest::topOccurrences;
            this.payloads.bottomOccurrences = ByteHashBagTest::bottomOccurrences;
            this.payloads.addOccurrences = ByteHashBagTest::addOccurrences;
            this.payloads.addOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteHashBagTest::addOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.removeOccurrences = ByteHashBagTest::removeOccurrences;
            this.payloads.removeOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteHashBagTest::removeOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.forEachWithOccurrences = ByteHashBagTest::forEachWithOccurrences;
            this.payloads.add = ByteHashBagTest::add;
            this.payloads.addAllIterable = ByteHashBagTest::addAllIterable;
            this.payloads.remove = ByteHashBagTest::remove;
            this.payloads.byteIterator = ByteHashBagTest::byteIterator;
            this.payloads.byteIterator_with_remove = ByteHashBagTest::byteIterator_with_remove;
            this.payloads.forEach = ByteHashBagTest::forEach;
            this.payloads.count = ByteHashBagTest::count;
            this.payloads.sum = ByteHashBagTest::sum;
            this.payloads.testEquals = ByteHashBagTest::testEquals;
            this.payloads.testToString = ByteHashBagTest::testToString;
            this.payloads.makeString = ByteHashBagTest::makeString;
            this.payloads.appendString = ByteHashBagTest::appendString;
            this.payloads.toList = ByteHashBagTest::toList;
            this.payloads.toSortedList = ByteHashBagTest::toSortedList;
            this.payloads.toImmutable = ByteHashBagTest::toImmutable;
            this.payloads.toStringOfItemToCount = ByteHashBagTest::toStringOfItemToCount;
            this.payloads.size = ByteHashBagTest::size;
            this.payloads.with = ByteHashBagTest::with;
            this.payloads.injectInto = ByteHashBagTest::injectInto;
        }
    }
*/
}
