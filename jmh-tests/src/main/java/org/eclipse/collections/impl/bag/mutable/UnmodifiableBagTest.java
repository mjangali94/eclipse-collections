/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.mutable;

import java.util.Set;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;
import org.eclipse.collections.impl.bag.mutable.primitive.BooleanHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.ByteHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.block.factory.PrimitiveFunctions;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.collection.mutable.UnmodifiableMutableCollectionTestCase;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iBag;

/**
 * Abstract JUnit test for {@link UnmodifiableBag}.
 */
public class UnmodifiableBagTest extends UnmodifiableMutableCollectionTestCase<String> {

    @Override
    protected MutableBag<String> getCollection() {
        return Bags.mutable.of("").asUnmodifiable();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addOccurrences() {
        this.getCollection().addOccurrences(null, 1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeOccurrences() {
        this.getCollection().removeOccurrences(null, 1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void setOccurrences() {
        this.getCollection().setOccurrences(null, 1);
    }

    @Test
    public void asUnmodifiable() {
        MutableBag<?> bag = this.getCollection();
        Verify.assertInstanceOf(UnmodifiableBag.class, bag.asUnmodifiable());
    }

    @Test
    public void asSynchronized() {
        MutableBag<?> bag = this.getCollection();
        Verify.assertInstanceOf(SynchronizedBag.class, bag.asSynchronized());
    }

    @Test
    public void toImmutable() {
        MutableBag<?> bag = this.getCollection();
        Verify.assertInstanceOf(ImmutableBag.class, bag.toImmutable());
    }

    @Test
    public void equalsAndHashCode() {
        Verify.assertEqualsAndHashCode(this.getCollection(), Bags.mutable.of(""));
        MutableBag<Number> numbers = UnmodifiableBag.of(HashBag.newBagWith(1, 1, 2, 2, 2, 3));
        Verify.assertPostSerializedEqualsAndHashCode(numbers);
        Verify.assertInstanceOf(UnmodifiableBag.class, SerializeTestHelper.serializeDeserialize(numbers));
    }

    @Test
    public void forEachWithOccurrences() {
        MutableList<Pair<Object, Integer>> list = Lists.mutable.of();
        this.getCollection().forEachWithOccurrences((each, index) -> list.add(Tuples.pair(each, index)));
        Assert.assertEquals(FastList.newListWith(Tuples.pair("", 1)), list);
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithOccurrences() {
        Bag<Integer> bag = Bags.mutable.with(3, 3, 3, 2, 2, 1).asUnmodifiable();
        Bag<ObjectIntPair<Integer>> actual = bag.collectWithOccurrences(PrimitiveTuples::pair, Bags.mutable.empty());
        Bag<ObjectIntPair<Integer>> expected = Bags.immutable.with(PrimitiveTuples.pair(Integer.valueOf(3), 3), PrimitiveTuples.pair(Integer.valueOf(2), 2), PrimitiveTuples.pair(Integer.valueOf(1), 1));
        Assert.assertEquals(expected, actual);
        Set<ObjectIntPair<Integer>> actual2 = bag.collectWithOccurrences(PrimitiveTuples::pair, Sets.mutable.empty());
        ImmutableSet<ObjectIntPair<Integer>> expected2 = Sets.immutable.with(PrimitiveTuples.pair(Integer.valueOf(3), 3), PrimitiveTuples.pair(Integer.valueOf(2), 2), PrimitiveTuples.pair(Integer.valueOf(1), 1));
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void toMapOfItemToCount() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues("", 1), this.getCollection().toMapOfItemToCount());
    }

    @Test
    public void selectInstancesOf() {
        MutableBag<Number> numbers = UnmodifiableBag.of(HashBag.newBagWith(1, 2.0, 3, 4.0, 5));
        Assert.assertEquals(iBag(1, 3, 5), numbers.selectInstancesOf(Integer.class));
        Assert.assertEquals(iBag(1, 2.0, 3, 4.0, 5), numbers.selectInstancesOf(Number.class));
    }

    @Test
    public void selectByOccurrences() {
        MutableBag<Integer> integers = UnmodifiableBag.of(HashBag.newBagWith(1, 1, 1, 1, 2, 2, 2, 3, 3, 4));
        Assert.assertEquals(iBag(1, 1, 1, 1, 3, 3), integers.selectByOccurrences(IntPredicates.isEven()));
    }

    @Test
    public void selectDuplicates() {
        Assert.assertEquals(UnmodifiableBag.of(HashBag.newBagWith(1, 1, 1, 1, 2, 2, 2, 3, 3)), UnmodifiableBag.of(HashBag.newBagWith(0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 5)).selectDuplicates());
    }

    @Override
    @Test
    public void collectBoolean() {
        MutableBag<Integer> integers = UnmodifiableBag.of(HashBag.newBagWith(0, 1, 2, 2));
        Assert.assertEquals(BooleanHashBag.newBagWith(false, true, true, true), integers.collectBoolean(PrimitiveFunctions.integerIsPositive()));
    }

    @Override
    @Test
    public void collectByte() {
        MutableBag<Integer> integers = UnmodifiableBag.of(HashBag.newBagWith(1, 2, 2, 3, 3, 3));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3), integers.collectByte(PrimitiveFunctions.unboxIntegerToByte()));
    }

    @Override
    @Test
    public void collectChar() {
        MutableBag<Integer> integers = UnmodifiableBag.of(HashBag.newBagWith(1, 2, 2, 3, 3, 3));
        Assert.assertEquals(CharHashBag.newBagWith('A', 'B', 'B', 'C', 'C', 'C'), integers.collectChar(integer -> (char) (integer.intValue() + 64)));
    }

    @Override
    @Test
    public void collectDouble() {
        MutableBag<Integer> integers = UnmodifiableBag.of(HashBag.newBagWith(1, 2, 2, 3, 3, 3));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0d, 2.0d, 2.0d, 3.0d, 3.0d, 3.0d), integers.collectDouble(PrimitiveFunctions.unboxIntegerToDouble()));
    }

    @Override
    @Test
    public void collectFloat() {
        MutableBag<Integer> integers = UnmodifiableBag.of(HashBag.newBagWith(1, 2, 2, 3, 3, 3));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f), integers.collectFloat(PrimitiveFunctions.unboxIntegerToFloat()));
    }

    @Override
    @Test
    public void collectInt() {
        MutableBag<Integer> integers = UnmodifiableBag.of(HashBag.newBagWith(1, 2, 2, 3, 3, 3));
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 2, 3, 3, 3), integers.collectInt(PrimitiveFunctions.unboxIntegerToInt()));
    }

    @Override
    @Test
    public void collectLong() {
        MutableBag<Integer> integers = UnmodifiableBag.of(HashBag.newBagWith(1, 2, 2, 3, 3, 3));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 2L, 3L, 3L, 3L), integers.collectLong(PrimitiveFunctions.unboxIntegerToLong()));
    }

    @Override
    @Test
    public void collectShort() {
        MutableBag<Integer> integers = UnmodifiableBag.of(HashBag.newBagWith(1, 2, 2, 3, 3, 3));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3), integers.collectShort(PrimitiveFunctions.unboxIntegerToShort()));
    }

    @Test
    public void topOccurrences() {
        MutableBag<String> mutable = HashBag.newBag();
        mutable.addOccurrences("one", 1);
        mutable.addOccurrences("two", 2);
        mutable.addOccurrences("three", 3);
        mutable.addOccurrences("four", 4);
        mutable.addOccurrences("five", 5);
        mutable.addOccurrences("six", 6);
        mutable.addOccurrences("seven", 7);
        mutable.addOccurrences("eight", 8);
        mutable.addOccurrences("nine", 9);
        mutable.addOccurrences("ten", 10);
        MutableBag<String> strings = mutable.asUnmodifiable();
        MutableList<ObjectIntPair<String>> top5 = strings.topOccurrences(5);
        Verify.assertSize(5, top5);
        Assert.assertEquals("ten", top5.getFirst().getOne());
        Assert.assertEquals(10, top5.getFirst().getTwo());
        Assert.assertEquals("six", top5.getLast().getOne());
        Assert.assertEquals(6, top5.getLast().getTwo());
    }

    @Test
    public void bottomOccurrences() {
        MutableBag<String> mutable = HashBag.newBag();
        mutable.addOccurrences("one", 1);
        mutable.addOccurrences("two", 2);
        mutable.addOccurrences("three", 3);
        mutable.addOccurrences("four", 4);
        mutable.addOccurrences("five", 5);
        mutable.addOccurrences("six", 6);
        mutable.addOccurrences("seven", 7);
        mutable.addOccurrences("eight", 8);
        mutable.addOccurrences("nine", 9);
        mutable.addOccurrences("ten", 10);
        MutableBag<String> strings = mutable.asUnmodifiable();
        MutableList<ObjectIntPair<String>> bottom5 = strings.bottomOccurrences(5);
        Verify.assertSize(5, bottom5);
        Assert.assertEquals("one", bottom5.getFirst().getOne());
        Assert.assertEquals(1, bottom5.getFirst().getTwo());
        Assert.assertEquals("five", bottom5.getLast().getOne());
        Assert.assertEquals(5, bottom5.getLast().getTwo());
    }

    @Test
    public void selectUnique() {
        MutableBag<String> bag = Bags.mutable.with("0", "1", "1", "1", "1", "2", "2", "2", "3", "3", "4", "5").asUnmodifiable();
        MutableSet<String> expected = Sets.mutable.with("0", "4", "5");
        MutableSet<String> actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void distinctView() {
        MutableBag<String> bag = Bags.mutable.of("1", "2", "2", "3", "3", "3", "3", "4", "5", "5", "6");
        RichIterable<String> expected = bag.toSet();
        RichIterable<String> actual = bag.asUnmodifiable().distinctView();
        Assert.assertEquals(expected, actual);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableBagTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIfWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIfWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorRemove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorRemove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testMakeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testMakeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAppendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAppendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_setOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.setOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapOfItemToCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectByOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectByOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectDuplicates() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectDuplicates);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_topOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.topOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_bottomOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.bottomOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectUnique);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctView);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableBagTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> testMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> testAppendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> addOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> removeOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> setOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> collectWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> toMapOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBagTest> distinctView;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.removeIfWith = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBagTest::removeIfWith, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBagTest::removeIf, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBagTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.iteratorRemove = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBagTest::iteratorRemove, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBagTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBagTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBagTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBagTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBagTest::removeAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBagTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBagTest::retainAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBagTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.testMakeString = UnmodifiableBagTest::testMakeString;
            this.payloads.testAppendString = UnmodifiableBagTest::testAppendString;
            this.payloads.select = UnmodifiableBagTest::select;
            this.payloads.selectWith = UnmodifiableBagTest::selectWith;
            this.payloads.reject = UnmodifiableBagTest::reject;
            this.payloads.rejectWith = UnmodifiableBagTest::rejectWith;
            this.payloads.partition = UnmodifiableBagTest::partition;
            this.payloads.partitionWith = UnmodifiableBagTest::partitionWith;
            this.payloads.collect = UnmodifiableBagTest::collect;
            this.payloads.collectWith = UnmodifiableBagTest::collectWith;
            this.payloads.collectIf = UnmodifiableBagTest::collectIf;
            this.payloads.newEmpty = UnmodifiableBagTest::newEmpty;
            this.payloads.groupBy = UnmodifiableBagTest::groupBy;
            this.payloads.zip = UnmodifiableBagTest::zip;
            this.payloads.zipWithIndex = UnmodifiableBagTest::zipWithIndex;
            this.payloads.flatCollect = UnmodifiableBagTest::flatCollect;
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBagTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBagTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBagTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBagTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.tap = UnmodifiableBagTest::tap;
            this.payloads.addOccurrences = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBagTest::addOccurrences, java.lang.UnsupportedOperationException.class);
            this.payloads.removeOccurrences = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBagTest::removeOccurrences, java.lang.UnsupportedOperationException.class);
            this.payloads.setOccurrences = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBagTest::setOccurrences, java.lang.UnsupportedOperationException.class);
            this.payloads.asUnmodifiable = UnmodifiableBagTest::asUnmodifiable;
            this.payloads.asSynchronized = UnmodifiableBagTest::asSynchronized;
            this.payloads.toImmutable = UnmodifiableBagTest::toImmutable;
            this.payloads.equalsAndHashCode = UnmodifiableBagTest::equalsAndHashCode;
            this.payloads.forEachWithOccurrences = UnmodifiableBagTest::forEachWithOccurrences;
            this.payloads.collectWithOccurrences = UnmodifiableBagTest::collectWithOccurrences;
            this.payloads.toMapOfItemToCount = UnmodifiableBagTest::toMapOfItemToCount;
            this.payloads.selectInstancesOf = UnmodifiableBagTest::selectInstancesOf;
            this.payloads.selectByOccurrences = UnmodifiableBagTest::selectByOccurrences;
            this.payloads.selectDuplicates = UnmodifiableBagTest::selectDuplicates;
            this.payloads.collectBoolean = UnmodifiableBagTest::collectBoolean;
            this.payloads.collectByte = UnmodifiableBagTest::collectByte;
            this.payloads.collectChar = UnmodifiableBagTest::collectChar;
            this.payloads.collectDouble = UnmodifiableBagTest::collectDouble;
            this.payloads.collectFloat = UnmodifiableBagTest::collectFloat;
            this.payloads.collectInt = UnmodifiableBagTest::collectInt;
            this.payloads.collectLong = UnmodifiableBagTest::collectLong;
            this.payloads.collectShort = UnmodifiableBagTest::collectShort;
            this.payloads.topOccurrences = UnmodifiableBagTest::topOccurrences;
            this.payloads.bottomOccurrences = UnmodifiableBagTest::bottomOccurrences;
            this.payloads.selectUnique = UnmodifiableBagTest::selectUnique;
            this.payloads.distinctView = UnmodifiableBagTest::distinctView;
        }
    }
*/
}
