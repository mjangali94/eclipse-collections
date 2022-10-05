/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.collector;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.BooleanList;
import org.eclipse.collections.api.list.primitive.ByteList;
import org.eclipse.collections.api.list.primitive.CharList;
import org.eclipse.collections.api.list.primitive.DoubleList;
import org.eclipse.collections.api.list.primitive.FloatList;
import org.eclipse.collections.api.list.primitive.IntList;
import org.eclipse.collections.api.list.primitive.LongList;
import org.eclipse.collections.api.list.primitive.ShortList;
import org.eclipse.collections.api.partition.bag.PartitionMutableBag;
import org.eclipse.collections.api.partition.list.PartitionMutableList;
import org.eclipse.collections.api.partition.set.PartitionMutableSet;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.primitive.BooleanLists;
import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.CompositeFastList;
import org.eclipse.collections.impl.partition.bag.PartitionHashBag;
import org.eclipse.collections.impl.partition.list.PartitionFastList;
import org.eclipse.collections.impl.partition.set.PartitionUnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.eclipse.collections.impl.utility.Iterate;
import org.junit.Assert;
import org.junit.Test;

/*
Do not merge this test with Collectors2Test. Doing so will fail the build. This is due to a bug in ASM.
Refer to links below for additional details:
1) JaCoCo issue: https://github.com/jacoco/jacoco/issues/462
2) ASM bug: http://forge.ow2.org/tracker/?func=detail&aid=317748&group_id=23&atid=100023
3) JaCoCo integration pull request: https://github.com/eclipse/eclipse-collections/pull/166
 */
public class Collectors2AdditionalTest {

    public static final Interval SMALL_INTERVAL = Interval.oneTo(5);

    public static final Interval LARGE_INTERVAL = Interval.oneTo(30000);

    public static final Integer HALF_SIZE = Integer.valueOf(LARGE_INTERVAL.size() / 2);

    private final List<Integer> smallData = new ArrayList<>(SMALL_INTERVAL);

    private final List<Integer> bigData = new ArrayList<>(LARGE_INTERVAL);

    @Test
    public void chunk() {
        MutableList<MutableList<Integer>> chunked0 = this.bigData.stream().collect(Collectors2.chunk(100));
        Assert.assertEquals(LARGE_INTERVAL.toList().chunk(100), chunked0);
        MutableList<MutableList<Integer>> chunked1 = this.bigData.stream().collect(Collectors2.chunk(333));
        Assert.assertEquals(LARGE_INTERVAL.toList().chunk(333), chunked1);
        MutableList<MutableList<Integer>> chunked2 = this.bigData.stream().collect(Collectors2.chunk(654));
        Assert.assertEquals(LARGE_INTERVAL.toList().chunk(654), chunked2);
        MutableList<MutableList<Integer>> chunked3 = this.smallData.stream().collect(Collectors2.chunk(SMALL_INTERVAL.size()));
        Assert.assertEquals(SMALL_INTERVAL.toList().chunk(SMALL_INTERVAL.size()), chunked3);
        MutableList<MutableList<Integer>> chunked4 = this.smallData.stream().collect(Collectors2.chunk(SMALL_INTERVAL.size() - 1));
        Assert.assertEquals(SMALL_INTERVAL.toList().chunk(SMALL_INTERVAL.size() - 1), chunked4);
        Assert.assertThrows(IllegalArgumentException.class, () -> Collectors2.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> Collectors2.chunk(-10));
    }

    @Test
    public void chunkParallel() {
        MutableList<MutableList<Integer>> chunked = this.bigData.parallelStream().collect(Collectors2.chunk(100));
        Assert.assertTrue(chunked.size() > 1);
        Verify.assertAllSatisfy(chunked, each -> each.size() > 1 && each.size() <= 100);
    }

    @Test
    public void zip() {
        MutableList<Integer> integers1 = Interval.oneTo(10).toList();
        MutableList<Integer> integers2 = Interval.oneTo(10).toList().toReversed();
        Assert.assertEquals(integers1.zip(integers2), integers1.stream().collect(Collectors2.zip(integers2)));
        MutableList<Integer> integers3 = Interval.oneTo(9).toList().toReversed();
        Assert.assertEquals(integers1.zip(integers3), integers1.stream().collect(Collectors2.zip(integers3)));
        Assert.assertEquals(integers3.zip(integers1), integers3.stream().collect(Collectors2.zip(integers1)));
    }

    @Test
    public void zipParallel() {
        MutableList<Integer> integers1 = Interval.oneTo(10).toList();
        MutableList<Integer> integers2 = Interval.oneTo(10).toList().toReversed();
        Assert.assertThrows(UnsupportedOperationException.class, () -> integers1.parallelStream().collect(Collectors2.zip(integers2)));
    }

    @Test
    public void zipWithIndex() {
        MutableList<Integer> integers1 = Interval.oneTo(10).toList();
        Assert.assertEquals(integers1.zipWithIndex().collect(each -> PrimitiveTuples.pair(each.getOne(), each.getTwo().intValue())), integers1.stream().collect(Collectors2.zipWithIndex()));
    }

    @Test
    public void zipWithIndexParallel() {
        MutableList<Integer> integers1 = Interval.oneTo(10).toList();
        Assert.assertThrows(UnsupportedOperationException.class, () -> integers1.parallelStream().collect(Collectors2.zipWithIndex()));
    }

    @Test
    public void sumByInt() {
        Assert.assertEquals(SMALL_INTERVAL.sumByInt(each -> Integer.valueOf(each.intValue() % 2), Integer::intValue), SMALL_INTERVAL.stream().collect(Collectors2.sumByInt(each -> Integer.valueOf(each.intValue() % 2), Integer::intValue)));
        Assert.assertEquals(LARGE_INTERVAL.sumByInt(each -> Integer.valueOf(each.intValue() % 2), Integer::intValue), LARGE_INTERVAL.stream().collect(Collectors2.sumByInt(each -> Integer.valueOf(each.intValue() % 2), Integer::intValue)));
    }

    @Test
    public void sumByIntParallel() {
        Assert.assertEquals(LARGE_INTERVAL.sumByInt(each -> Integer.valueOf(each.intValue() % 2), Integer::intValue), LARGE_INTERVAL.parallelStream().collect(Collectors2.sumByInt(each -> Integer.valueOf(each.intValue() % 2), Integer::intValue)));
    }

    @Test
    public void sumByLong() {
        MutableList<Long> smallLongs = SMALL_INTERVAL.collect(Long::valueOf).toList();
        MutableList<Long> largeLongs = LARGE_INTERVAL.collect(Long::valueOf).toList();
        Assert.assertEquals(smallLongs.sumByLong(each -> Integer.valueOf(each.intValue() % 2), Long::longValue), smallLongs.stream().collect(Collectors2.sumByLong(each -> Integer.valueOf(each.intValue() % 2), Long::longValue)));
        Assert.assertEquals(largeLongs.sumByLong(each -> Integer.valueOf(each.intValue() % 2), Long::longValue), largeLongs.stream().collect(Collectors2.sumByLong(each -> Integer.valueOf(each.intValue() % 2), Long::longValue)));
    }

    @Test
    public void sumByLongParallel() {
        MutableList<Long> largeLongs = LARGE_INTERVAL.collect(Long::valueOf).toList();
        Assert.assertEquals(largeLongs.sumByLong(each -> Integer.valueOf(each.intValue() % 2), Long::longValue), largeLongs.parallelStream().collect(Collectors2.sumByLong(each -> Integer.valueOf(each.intValue() % 2), Long::longValue)));
    }

    @Test
    public void sumByFloat() {
        MutableList<Float> smallLongs = SMALL_INTERVAL.collect(Float::valueOf).toList();
        MutableList<Float> largeLongs = LARGE_INTERVAL.collect(Float::valueOf).toList();
        Assert.assertEquals(smallLongs.sumByFloat(each -> Integer.valueOf(each.intValue() % 2), Float::floatValue), smallLongs.stream().collect(Collectors2.sumByFloat(each -> Integer.valueOf(each.intValue() % 2), Float::floatValue)));
        Assert.assertEquals(largeLongs.sumByFloat(each -> Integer.valueOf(each.intValue() % 2), Float::floatValue), largeLongs.stream().collect(Collectors2.sumByFloat(each -> Integer.valueOf(each.intValue() % 2), Float::floatValue)));
    }

    @Test
    public void sumByFloatParallel() {
        MutableList<Float> largeLongs = LARGE_INTERVAL.collect(Float::valueOf).toList();
        Assert.assertEquals(largeLongs.sumByFloat(each -> Integer.valueOf(each.intValue() % 2), Float::floatValue), largeLongs.parallelStream().collect(Collectors2.sumByFloat(each -> Integer.valueOf(each.intValue() % 2), Float::floatValue)));
    }

    @Test
    public void sumByDouble() {
        MutableList<Double> smallLongs = SMALL_INTERVAL.collect(Double::valueOf).toList();
        MutableList<Double> largeLongs = LARGE_INTERVAL.collect(Double::valueOf).toList();
        Assert.assertEquals(smallLongs.sumByDouble(each -> Integer.valueOf(each.intValue() % 2), Double::doubleValue), smallLongs.stream().collect(Collectors2.sumByDouble(each -> Integer.valueOf(each.intValue() % 2), Double::doubleValue)));
        Assert.assertEquals(largeLongs.sumByDouble(each -> Integer.valueOf(each.intValue() % 2), Double::doubleValue), largeLongs.stream().collect(Collectors2.sumByDouble(each -> Integer.valueOf(each.intValue() % 2), Double::doubleValue)));
    }

    @Test
    public void sumByDoubleParallel() {
        MutableList<Double> largeLongs = LARGE_INTERVAL.collect(Double::valueOf).toList();
        Assert.assertEquals(largeLongs.sumByDouble(each -> Integer.valueOf(each.intValue() % 2), Double::doubleValue), largeLongs.parallelStream().collect(Collectors2.sumByDouble(each -> Integer.valueOf(each.intValue() % 2), Double::doubleValue)));
    }

    @Test
    public void sumByBigInteger() {
        Assert.assertEquals(Iterate.sumByBigInteger(SMALL_INTERVAL, each -> Integer.valueOf(each.intValue() % 2), each -> BigInteger.valueOf(each.longValue())), SMALL_INTERVAL.stream().collect(Collectors2.sumByBigInteger(each -> Integer.valueOf(each.intValue() % 2), each -> BigInteger.valueOf(each.longValue()))));
        Assert.assertEquals(Iterate.sumByBigInteger(LARGE_INTERVAL, each -> Integer.valueOf(each.intValue() % 2), each -> BigInteger.valueOf(each.longValue())), LARGE_INTERVAL.stream().collect(Collectors2.sumByBigInteger(each -> Integer.valueOf(each.intValue() % 2), each -> BigInteger.valueOf(each.longValue()))));
    }

    @Test
    public void sumByBigIntegerParallel() {
        Assert.assertEquals(Iterate.sumByBigInteger(LARGE_INTERVAL, each -> Integer.valueOf(each.intValue() % 2), each -> BigInteger.valueOf(each.longValue())), LARGE_INTERVAL.parallelStream().collect(Collectors2.sumByBigInteger(each -> Integer.valueOf(each.intValue() % 2), each -> BigInteger.valueOf(each.longValue()))));
    }

    @Test
    public void sumByBigDecimal() {
        Assert.assertEquals(Iterate.sumByBigDecimal(SMALL_INTERVAL, each -> Integer.valueOf(each.intValue() % 2), BigDecimal::new), SMALL_INTERVAL.stream().collect(Collectors2.sumByBigDecimal(each -> Integer.valueOf(each.intValue() % 2), BigDecimal::new)));
        Assert.assertEquals(Iterate.sumByBigDecimal(LARGE_INTERVAL, each -> Integer.valueOf(each.intValue() % 2), BigDecimal::new), LARGE_INTERVAL.stream().collect(Collectors2.sumByBigDecimal(each -> Integer.valueOf(each.intValue() % 2), BigDecimal::new)));
    }

    @Test
    public void sumByBigDecimalParallel() {
        Assert.assertEquals(Iterate.sumByBigDecimal(LARGE_INTERVAL, each -> Integer.valueOf(each.intValue() % 2), BigDecimal::new), LARGE_INTERVAL.parallelStream().collect(Collectors2.sumByBigDecimal(each -> Integer.valueOf(each.intValue() % 2), BigDecimal::new)));
    }

    @Test
    public void select() {
        Assert.assertEquals(LARGE_INTERVAL.toList().select(IntegerPredicates.isEven()), this.bigData.stream().collect(Collectors2.select(IntegerPredicates.isEven(), Lists.mutable::empty)));
        Assert.assertEquals(LARGE_INTERVAL.toSet().select(IntegerPredicates.isEven()), this.bigData.stream().collect(Collectors2.select(IntegerPredicates.isEven(), Sets.mutable::empty)));
        Assert.assertEquals(LARGE_INTERVAL.toBag().select(IntegerPredicates.isEven()), this.bigData.stream().collect(Collectors2.select(IntegerPredicates.isEven(), Bags.mutable::empty)));
    }

    @Test
    public void selectParallel() {
        Assert.assertEquals(LARGE_INTERVAL.toList().select(IntegerPredicates.isEven()), this.bigData.parallelStream().collect(Collectors2.select(IntegerPredicates.isEven(), Lists.mutable::empty)));
        Assert.assertEquals(LARGE_INTERVAL.toSet().select(IntegerPredicates.isEven()), this.bigData.parallelStream().collect(Collectors2.select(IntegerPredicates.isEven(), Sets.mutable::empty)));
        Assert.assertEquals(LARGE_INTERVAL.toBag().select(IntegerPredicates.isEven()), this.bigData.parallelStream().collect(Collectors2.select(IntegerPredicates.isEven(), Bags.mutable::empty)));
    }

    @Test
    public void selectWith() {
        Assert.assertEquals(LARGE_INTERVAL.toList().selectWith(Predicates2.greaterThan(), HALF_SIZE), this.bigData.stream().collect(Collectors2.selectWith(Predicates2.greaterThan(), HALF_SIZE, Lists.mutable::empty)));
        Assert.assertEquals(LARGE_INTERVAL.toSet().selectWith(Predicates2.greaterThan(), HALF_SIZE), this.bigData.stream().collect(Collectors2.selectWith(Predicates2.greaterThan(), HALF_SIZE, Sets.mutable::empty)));
        Assert.assertEquals(LARGE_INTERVAL.toBag().selectWith(Predicates2.greaterThan(), HALF_SIZE), this.bigData.stream().collect(Collectors2.selectWith(Predicates2.greaterThan(), HALF_SIZE, Bags.mutable::empty)));
    }

    @Test
    public void selectWithParallel() {
        Assert.assertEquals(LARGE_INTERVAL.toList().selectWith(Predicates2.greaterThan(), HALF_SIZE), this.bigData.parallelStream().collect(Collectors2.selectWith(Predicates2.greaterThan(), HALF_SIZE, Lists.mutable::empty)));
        Assert.assertEquals(LARGE_INTERVAL.toSet().selectWith(Predicates2.greaterThan(), HALF_SIZE), this.bigData.parallelStream().collect(Collectors2.selectWith(Predicates2.greaterThan(), HALF_SIZE, Sets.mutable::empty)));
        Assert.assertEquals(LARGE_INTERVAL.toBag().selectWith(Predicates2.greaterThan(), HALF_SIZE), this.bigData.parallelStream().collect(Collectors2.selectWith(Predicates2.greaterThan(), HALF_SIZE, Bags.mutable::empty)));
    }

    @Test
    public void reject() {
        Assert.assertEquals(LARGE_INTERVAL.toList().reject(IntegerPredicates.isEven()), this.bigData.stream().collect(Collectors2.reject(IntegerPredicates.isEven(), Lists.mutable::empty)));
        Assert.assertEquals(LARGE_INTERVAL.toSet().reject(IntegerPredicates.isEven()), this.bigData.stream().collect(Collectors2.reject(IntegerPredicates.isEven(), Sets.mutable::empty)));
        Assert.assertEquals(LARGE_INTERVAL.toBag().reject(IntegerPredicates.isEven()), this.bigData.stream().collect(Collectors2.reject(IntegerPredicates.isEven(), Bags.mutable::empty)));
    }

    @Test
    public void rejectParallel() {
        Assert.assertEquals(LARGE_INTERVAL.toList().reject(IntegerPredicates.isEven()), this.bigData.parallelStream().collect(Collectors2.reject(IntegerPredicates.isEven(), Lists.mutable::empty)));
        Assert.assertEquals(LARGE_INTERVAL.toSet().reject(IntegerPredicates.isEven()), this.bigData.parallelStream().collect(Collectors2.reject(IntegerPredicates.isEven(), Sets.mutable::empty)));
        Assert.assertEquals(LARGE_INTERVAL.toBag().reject(IntegerPredicates.isEven()), this.bigData.parallelStream().collect(Collectors2.reject(IntegerPredicates.isEven(), Bags.mutable::empty)));
    }

    @Test
    public void rejectWith() {
        Assert.assertEquals(LARGE_INTERVAL.toList().rejectWith(Predicates2.greaterThan(), HALF_SIZE), this.bigData.stream().collect(Collectors2.rejectWith(Predicates2.greaterThan(), HALF_SIZE, Lists.mutable::empty)));
        Assert.assertEquals(LARGE_INTERVAL.toSet().rejectWith(Predicates2.greaterThan(), HALF_SIZE), this.bigData.stream().collect(Collectors2.rejectWith(Predicates2.greaterThan(), HALF_SIZE, Sets.mutable::empty)));
        Assert.assertEquals(LARGE_INTERVAL.toBag().rejectWith(Predicates2.greaterThan(), HALF_SIZE), this.bigData.stream().collect(Collectors2.rejectWith(Predicates2.greaterThan(), HALF_SIZE, Bags.mutable::empty)));
    }

    @Test
    public void rejectWithParallel() {
        Assert.assertEquals(LARGE_INTERVAL.toList().rejectWith(Predicates2.greaterThan(), HALF_SIZE), this.bigData.parallelStream().collect(Collectors2.rejectWith(Predicates2.greaterThan(), HALF_SIZE, Lists.mutable::empty)));
        Assert.assertEquals(LARGE_INTERVAL.toSet().rejectWith(Predicates2.greaterThan(), HALF_SIZE), this.bigData.parallelStream().collect(Collectors2.rejectWith(Predicates2.greaterThan(), HALF_SIZE, Sets.mutable::empty)));
        Assert.assertEquals(LARGE_INTERVAL.toBag().rejectWith(Predicates2.greaterThan(), HALF_SIZE), this.bigData.parallelStream().collect(Collectors2.rejectWith(Predicates2.greaterThan(), HALF_SIZE, Bags.mutable::empty)));
    }

    @Test
    public void partition() {
        PartitionMutableList<Integer> expectedList = LARGE_INTERVAL.toList().partition(IntegerPredicates.isEven());
        PartitionMutableList<Integer> actualList = this.bigData.stream().collect(Collectors2.partition(IntegerPredicates.isEven(), PartitionFastList::new));
        Assert.assertEquals(expectedList.getSelected(), actualList.getSelected());
        Assert.assertEquals(expectedList.getRejected(), actualList.getRejected());
        PartitionMutableSet<Integer> expectedSet = LARGE_INTERVAL.toSet().partition(IntegerPredicates.isEven());
        PartitionMutableSet<Integer> actualSet = this.bigData.stream().collect(Collectors2.partition(IntegerPredicates.isEven(), PartitionUnifiedSet::new));
        Assert.assertEquals(expectedSet.getSelected(), actualSet.getSelected());
        Assert.assertEquals(expectedSet.getRejected(), actualSet.getRejected());
        PartitionMutableBag<Integer> expectedBag = LARGE_INTERVAL.toBag().partition(IntegerPredicates.isEven());
        PartitionMutableBag<Integer> actualBag = this.bigData.stream().collect(Collectors2.partition(IntegerPredicates.isEven(), PartitionHashBag::new));
        Assert.assertEquals(expectedBag.getSelected(), actualBag.getSelected());
        Assert.assertEquals(expectedBag.getRejected(), actualBag.getRejected());
    }

    @Test
    public void partitionParallel() {
        PartitionMutableList<Integer> expectedList = LARGE_INTERVAL.toList().partition(IntegerPredicates.isEven());
        PartitionMutableList<Integer> actualList = this.bigData.parallelStream().collect(Collectors2.partition(IntegerPredicates.isEven(), PartitionFastList::new));
        Assert.assertEquals(expectedList.getSelected(), actualList.getSelected());
        Assert.assertEquals(expectedList.getRejected(), actualList.getRejected());
        PartitionMutableSet<Integer> expectedSet = LARGE_INTERVAL.toSet().partition(IntegerPredicates.isEven());
        PartitionMutableSet<Integer> actualSet = this.bigData.parallelStream().collect(Collectors2.partition(IntegerPredicates.isEven(), PartitionUnifiedSet::new));
        Assert.assertEquals(expectedSet.getSelected(), actualSet.getSelected());
        Assert.assertEquals(expectedSet.getRejected(), actualSet.getRejected());
        PartitionMutableBag<Integer> expectedBag = LARGE_INTERVAL.toBag().partition(IntegerPredicates.isEven());
        PartitionMutableBag<Integer> actualBag = this.bigData.parallelStream().collect(Collectors2.partition(IntegerPredicates.isEven(), PartitionHashBag::new));
        Assert.assertEquals(expectedBag.getSelected(), actualBag.getSelected());
        Assert.assertEquals(expectedBag.getRejected(), actualBag.getRejected());
    }

    @Test
    public void partitionWith() {
        PartitionMutableList<Integer> expectedList = LARGE_INTERVAL.toList().partitionWith(Predicates2.greaterThan(), HALF_SIZE);
        PartitionMutableList<Integer> actualList = this.bigData.stream().collect(Collectors2.partitionWith(Predicates2.greaterThan(), HALF_SIZE, PartitionFastList::new));
        Assert.assertEquals(expectedList.getSelected(), actualList.getSelected());
        Assert.assertEquals(expectedList.getRejected(), actualList.getRejected());
        PartitionMutableSet<Integer> expectedSet = LARGE_INTERVAL.toSet().partitionWith(Predicates2.greaterThan(), HALF_SIZE);
        PartitionMutableSet<Integer> actualSet = this.bigData.stream().collect(Collectors2.partitionWith(Predicates2.greaterThan(), HALF_SIZE, PartitionUnifiedSet::new));
        Assert.assertEquals(expectedSet.getSelected(), actualSet.getSelected());
        Assert.assertEquals(expectedSet.getRejected(), actualSet.getRejected());
        PartitionMutableBag<Integer> expectedBag = LARGE_INTERVAL.toBag().partitionWith(Predicates2.greaterThan(), HALF_SIZE);
        PartitionMutableBag<Integer> actualBag = this.bigData.stream().collect(Collectors2.partitionWith(Predicates2.greaterThan(), HALF_SIZE, PartitionHashBag::new));
        Assert.assertEquals(expectedBag.getSelected(), actualBag.getSelected());
        Assert.assertEquals(expectedBag.getRejected(), actualBag.getRejected());
    }

    @Test
    public void partitionWithParallel() {
        PartitionMutableList<Integer> expectedList = LARGE_INTERVAL.toList().partitionWith(Predicates2.greaterThan(), HALF_SIZE);
        PartitionMutableList<Integer> actualList = this.bigData.parallelStream().collect(Collectors2.partitionWith(Predicates2.greaterThan(), HALF_SIZE, PartitionFastList::new));
        Assert.assertEquals(expectedList.getSelected(), actualList.getSelected());
        Assert.assertEquals(expectedList.getRejected(), actualList.getRejected());
        PartitionMutableSet<Integer> expectedSet = LARGE_INTERVAL.toSet().partitionWith(Predicates2.greaterThan(), HALF_SIZE);
        PartitionMutableSet<Integer> actualSet = this.bigData.parallelStream().collect(Collectors2.partitionWith(Predicates2.greaterThan(), HALF_SIZE, PartitionUnifiedSet::new));
        Assert.assertEquals(expectedSet.getSelected(), actualSet.getSelected());
        Assert.assertEquals(expectedSet.getRejected(), actualSet.getRejected());
        PartitionMutableBag<Integer> expectedBag = LARGE_INTERVAL.toBag().partitionWith(Predicates2.greaterThan(), HALF_SIZE);
        PartitionMutableBag<Integer> actualBag = this.bigData.parallelStream().collect(Collectors2.partitionWith(Predicates2.greaterThan(), HALF_SIZE, PartitionHashBag::new));
        Assert.assertEquals(expectedBag.getSelected(), actualBag.getSelected());
        Assert.assertEquals(expectedBag.getRejected(), actualBag.getRejected());
    }

    @Test
    public void collect() {
        Assert.assertEquals(LARGE_INTERVAL.toList().collect(Functions.getToString()), this.bigData.stream().collect(Collectors2.collect(Functions.getToString(), Lists.mutable::empty)));
        Assert.assertEquals(LARGE_INTERVAL.toSet().collect(Functions.getToString()), this.bigData.stream().collect(Collectors2.collect(Functions.getToString(), Sets.mutable::empty)));
        Assert.assertEquals(LARGE_INTERVAL.toBag().collect(Functions.getToString()), this.bigData.stream().collect(Collectors2.collect(Functions.getToString(), Bags.mutable::empty)));
    }

    @Test
    public void collectParallel() {
        Assert.assertEquals(LARGE_INTERVAL.toList().collect(Functions.getToString()), this.bigData.parallelStream().collect(Collectors2.collect(Functions.getToString(), Lists.mutable::empty)));
        Assert.assertEquals(LARGE_INTERVAL.toSet().collect(Functions.getToString()), this.bigData.parallelStream().collect(Collectors2.collect(Functions.getToString(), Sets.mutable::empty)));
        Assert.assertEquals(LARGE_INTERVAL.toBag().collect(Functions.getToString()), this.bigData.parallelStream().collect(Collectors2.collect(Functions.getToString(), Bags.mutable::empty)));
    }

    @Test
    public void flatCollect() {
        MutableList<Interval> list = Lists.mutable.with(SMALL_INTERVAL, SMALL_INTERVAL, SMALL_INTERVAL);
        Assert.assertEquals(list.flatCollect(Functions.identity()), list.stream().collect(Collectors2.flatCollect(Functions.identity(), Lists.mutable::empty)));
        Assert.assertEquals(list.flatCollect(Functions.identity()), list.stream().collect(Collectors2.flatCollect(Functions.identity(), CompositeFastList::new)));
        Assert.assertEquals(list.toSet().flatCollect(Functions.identity()), list.stream().collect(Collectors2.flatCollect(Functions.identity(), Sets.mutable::empty)));
        Assert.assertEquals(list.toBag().flatCollect(Functions.identity()), list.stream().collect(Collectors2.flatCollect(Functions.identity(), Bags.mutable::empty)));
        List<MutableList<String>> lists = Lists.mutable.with(Lists.mutable.with("a", "b"), Lists.mutable.with("c", "d"), Lists.mutable.with("e"));
        MutableList<String> flattened = lists.stream().collect(Collectors2.flatCollect(l -> l, Lists.mutable::empty));
        Assert.assertEquals(Lists.mutable.with("a", "b", "c", "d", "e"), flattened);
    }

    @Test
    public void flatCollectParallel() {
        MutableList<Interval> list = Lists.mutable.withNValues(20000, () -> SMALL_INTERVAL);
        Assert.assertEquals(list.flatCollect(Functions.identity()), list.parallelStream().collect(Collectors2.flatCollect(Functions.identity(), Lists.mutable::empty)));
        Assert.assertEquals(list.flatCollect(Functions.identity()), list.parallelStream().collect(Collectors2.flatCollect(Functions.identity(), CompositeFastList::new)));
        Assert.assertEquals(list.toSet().flatCollect(Functions.identity()), list.parallelStream().collect(Collectors2.flatCollect(Functions.identity(), Sets.mutable::empty)));
        Assert.assertEquals(list.toBag().flatCollect(Functions.identity()), list.parallelStream().collect(Collectors2.flatCollect(Functions.identity(), Bags.mutable::empty)));
    }

    @Test
    public void collectWith() {
        Assert.assertEquals(LARGE_INTERVAL.toList().collectWith(Integer::sum, Integer.valueOf(10)), this.bigData.stream().collect(Collectors2.collectWith(Integer::sum, Integer.valueOf(10), Lists.mutable::empty)));
        Assert.assertEquals(LARGE_INTERVAL.toSet().collectWith(Integer::sum, Integer.valueOf(10)), this.bigData.stream().collect(Collectors2.collectWith(Integer::sum, Integer.valueOf(10), Sets.mutable::empty)));
        Assert.assertEquals(LARGE_INTERVAL.toBag().collectWith(Integer::sum, Integer.valueOf(10)), this.bigData.stream().collect(Collectors2.collectWith(Integer::sum, Integer.valueOf(10), Bags.mutable::empty)));
    }

    @Test
    public void collectWithParallel() {
        Assert.assertEquals(LARGE_INTERVAL.toList().collectWith(Integer::sum, Integer.valueOf(10)), this.bigData.parallelStream().collect(Collectors2.collectWith(Integer::sum, Integer.valueOf(10), Lists.mutable::empty)));
        Assert.assertEquals(LARGE_INTERVAL.toSet().collectWith(Integer::sum, Integer.valueOf(10)), this.bigData.parallelStream().collect(Collectors2.collectWith(Integer::sum, Integer.valueOf(10), Sets.mutable::empty)));
        Assert.assertEquals(LARGE_INTERVAL.toBag().collectWith(Integer::sum, Integer.valueOf(10)), this.bigData.parallelStream().collect(Collectors2.collectWith(Integer::sum, Integer.valueOf(10), Bags.mutable::empty)));
    }

    @Test
    public void collectBoolean() {
        BooleanList expected = SMALL_INTERVAL.collectBoolean(each -> each % 2 == 0, BooleanLists.mutable.empty());
        BooleanList actual = this.smallData.stream().collect(Collectors2.collectBoolean(each -> each % 2 == 0, BooleanLists.mutable::empty));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void collectBooleanParallel() {
        BooleanList expected = LARGE_INTERVAL.collectBoolean(each -> each % 2 == 0, BooleanLists.mutable.empty());
        BooleanList actual = this.bigData.parallelStream().collect(Collectors2.collectBoolean(each -> each % 2 == 0, BooleanLists.mutable::empty));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void collectByte() {
        ByteList expected = SMALL_INTERVAL.collectByte(each -> (byte) (each % Byte.MAX_VALUE), ByteLists.mutable.empty());
        ByteList actual = this.smallData.stream().collect(Collectors2.collectByte(each -> (byte) (each % Byte.MAX_VALUE), ByteLists.mutable::empty));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void collectByteParallel() {
        ByteList expected = LARGE_INTERVAL.collectByte(each -> (byte) (each % Byte.MAX_VALUE), ByteLists.mutable.empty());
        ByteList actual = this.bigData.parallelStream().collect(Collectors2.collectByte(each -> (byte) (each % Byte.MAX_VALUE), ByteLists.mutable::empty));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void collectChar() {
        CharList expected = SMALL_INTERVAL.collectChar(each -> (char) (each % Character.MAX_VALUE), CharLists.mutable.empty());
        CharList actual = this.smallData.stream().collect(Collectors2.collectChar(each -> (char) (each % Character.MAX_VALUE), CharLists.mutable::empty));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void collectCharParallel() {
        CharList expected = LARGE_INTERVAL.collectChar(each -> (char) (each % Character.MAX_VALUE), CharLists.mutable.empty());
        CharList actual = this.bigData.parallelStream().collect(Collectors2.collectChar(each -> (char) (each % Character.MAX_VALUE), CharLists.mutable::empty));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void collectShort() {
        ShortList expected = SMALL_INTERVAL.collectShort(each -> (short) (each % Short.MAX_VALUE), ShortLists.mutable.empty());
        ShortList actual = this.smallData.stream().collect(Collectors2.collectShort(each -> (short) (each % Short.MAX_VALUE), ShortLists.mutable::empty));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void collectShortParallel() {
        ShortList expected = LARGE_INTERVAL.collectShort(each -> (short) (each % Short.MAX_VALUE), ShortLists.mutable.empty());
        ShortList actual = this.bigData.parallelStream().collect(Collectors2.collectShort(each -> (short) (each % Short.MAX_VALUE), ShortLists.mutable::empty));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void collectInt() {
        IntList expected = SMALL_INTERVAL.collectInt(Integer::intValue, IntLists.mutable.empty());
        IntList actual = this.smallData.stream().collect(Collectors2.collectInt(each -> each, IntLists.mutable::empty));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void collectIntParallel() {
        IntList expected = LARGE_INTERVAL.collectInt(Integer::intValue, IntLists.mutable.empty());
        IntList actual = this.bigData.parallelStream().collect(Collectors2.collectInt(each -> each, IntLists.mutable::empty));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void collectFloat() {
        FloatList expected = SMALL_INTERVAL.collectFloat(Integer::floatValue, FloatLists.mutable.empty());
        FloatList actual = this.smallData.stream().collect(Collectors2.collectFloat(each -> (float) each, FloatLists.mutable::empty));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void collectFloatParallel() {
        FloatList expected = LARGE_INTERVAL.collectFloat(Integer::floatValue, FloatLists.mutable.empty());
        FloatList actual = this.bigData.parallelStream().collect(Collectors2.collectFloat(each -> (float) each, FloatLists.mutable::empty));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void collectLong() {
        LongList expected = SMALL_INTERVAL.collectLong(Integer::longValue, LongLists.mutable.empty());
        LongList actual = this.smallData.stream().collect(Collectors2.collectLong(each -> (long) each, LongLists.mutable::empty));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void collectLongParallel() {
        LongList expected = LARGE_INTERVAL.collectLong(Integer::longValue, LongLists.mutable.empty());
        LongList actual = this.bigData.parallelStream().collect(Collectors2.collectLong(each -> (long) each, LongLists.mutable::empty));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void collectDouble() {
        DoubleList expected = SMALL_INTERVAL.collectDouble(Integer::doubleValue, DoubleLists.mutable.empty());
        DoubleList actual = this.smallData.stream().collect(Collectors2.collectDouble(each -> (double) each, DoubleLists.mutable::empty));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void collectDoubleParallel() {
        DoubleList expected = LARGE_INTERVAL.collectDouble(Integer::doubleValue, DoubleLists.mutable.empty());
        DoubleList actual = this.bigData.parallelStream().collect(Collectors2.collectDouble(each -> (double) each, DoubleLists.mutable::empty));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void summarizingBigDecimal() {
        ValueHolder valueHolder = new ValueHolder(5, 100, 10.0);
        BigDecimalSummaryStatistics summaryStatistics = Lists.mutable.withNValues(25_000, () -> valueHolder).stream().collect(Collectors2.summarizingBigDecimal(vh -> BigDecimal.valueOf(vh.getLongValue())));
        Assert.assertEquals(BigDecimal.valueOf(2_500_000L), summaryStatistics.getSum());
        Assert.assertEquals(BigDecimal.valueOf(100L), summaryStatistics.getMin());
        Assert.assertEquals(BigDecimal.valueOf(100L), summaryStatistics.getMax());
    }

    @Test
    public void summarizingBigDecimalParallel() {
        ValueHolder valueHolder = new ValueHolder(5, 100, 10.0);
        BigDecimalSummaryStatistics summaryStatistics = Lists.mutable.withNValues(25_000, () -> valueHolder).parallelStream().collect(Collectors2.summarizingBigDecimal(vh -> BigDecimal.valueOf(vh.getLongValue())));
        Assert.assertEquals(BigDecimal.valueOf(2_500_000L), summaryStatistics.getSum());
        Assert.assertEquals(BigDecimal.valueOf(100L), summaryStatistics.getMin());
        Assert.assertEquals(BigDecimal.valueOf(100L), summaryStatistics.getMax());
    }

    @Test
    public void summingBigDecimal() {
        ValueHolder valueHolder = new ValueHolder(5, 100, 10.0);
        BigDecimal sum = Lists.mutable.withNValues(25_000, () -> valueHolder).stream().collect(Collectors2.summingBigDecimal(vh -> BigDecimal.valueOf(vh.getLongValue())));
        Assert.assertEquals(BigDecimal.valueOf(2_500_000L), sum);
    }

    @Test
    public void summingBigDecimalParallel() {
        ValueHolder valueHolder = new ValueHolder(5, 100, 10.0);
        BigDecimal sum = Lists.mutable.withNValues(25_000, () -> valueHolder).parallelStream().collect(Collectors2.summingBigDecimal(vh -> BigDecimal.valueOf(vh.getLongValue())));
        Assert.assertEquals(BigDecimal.valueOf(2_500_000L), sum);
    }

    @Test
    public void summarizingBigInteger() {
        ValueHolder valueHolder = new ValueHolder(5, 100, 10.0);
        BigIntegerSummaryStatistics summaryStatistics = Lists.mutable.withNValues(25_000, () -> valueHolder).stream().collect(Collectors2.summarizingBigInteger(vh -> BigInteger.valueOf(vh.getLongValue())));
        Assert.assertEquals(BigInteger.valueOf(2_500_000L), summaryStatistics.getSum());
        Assert.assertEquals(BigInteger.valueOf(100L), summaryStatistics.getMin());
        Assert.assertEquals(BigInteger.valueOf(100L), summaryStatistics.getMax());
    }

    @Test
    public void summarizingBigIntegerParallel() {
        ValueHolder valueHolder = new ValueHolder(5, 100, 10.0);
        BigIntegerSummaryStatistics summaryStatistics = Lists.mutable.withNValues(25_000, () -> valueHolder).parallelStream().collect(Collectors2.summarizingBigInteger(vh -> BigInteger.valueOf(vh.getLongValue())));
        Assert.assertEquals(BigInteger.valueOf(2_500_000L), summaryStatistics.getSum());
        Assert.assertEquals(BigInteger.valueOf(100L), summaryStatistics.getMin());
        Assert.assertEquals(BigInteger.valueOf(100L), summaryStatistics.getMax());
    }

    @Test
    public void summingBigInteger() {
        ValueHolder valueHolder = new ValueHolder(5, 100, 10.0);
        BigInteger sum = Lists.mutable.withNValues(25_000, () -> valueHolder).stream().collect(Collectors2.summingBigInteger(vh -> BigInteger.valueOf(vh.getLongValue())));
        Assert.assertEquals(BigInteger.valueOf(2_500_000L), sum);
    }

    @Test
    public void summingBigIntegerParallel() {
        ValueHolder valueHolder = new ValueHolder(5, 100, 10.0);
        BigInteger sum = Lists.mutable.withNValues(25_000, () -> valueHolder).parallelStream().collect(Collectors2.summingBigInteger(vh -> BigInteger.valueOf(vh.getLongValue())));
        Assert.assertEquals(BigInteger.valueOf(2_500_000L), sum);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private Collectors2AdditionalTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunkParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunkParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndexParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndexParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByIntParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByIntParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLongParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLongParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloatParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloatParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDoubleParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDoubleParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByBigInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByBigInteger);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByBigIntegerParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByBigIntegerParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByBigDecimal() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByBigDecimal);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByBigDecimalParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByBigDecimalParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWithParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWithParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizingBigDecimal() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizingBigDecimal);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizingBigDecimalParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizingBigDecimalParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summingBigDecimal() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summingBigDecimal);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summingBigDecimalParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summingBigDecimalParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizingBigInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizingBigInteger);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizingBigIntegerParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizingBigIntegerParallel);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summingBigInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summingBigInteger);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summingBigIntegerParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summingBigIntegerParallel);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> payload) throws java.lang.Throwable {
            this.instance = new Collectors2AdditionalTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> chunkParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> zipParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> zipWithIndexParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> sumByIntParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> sumByLongParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> sumByFloatParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> sumByDoubleParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> sumByBigInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> sumByBigIntegerParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> sumByBigDecimal;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> sumByBigDecimalParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> selectParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> selectWithParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> rejectParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> rejectWithParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> partitionParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> partitionWithParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> collectParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> flatCollectParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> collectWithParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> collectBooleanParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> collectByteParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> collectCharParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> collectShortParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> collectIntParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> collectFloatParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> collectLongParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> collectDoubleParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> summarizingBigDecimal;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> summarizingBigDecimalParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> summingBigDecimal;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> summingBigDecimalParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> summarizingBigInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> summarizingBigIntegerParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> summingBigInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Collectors2AdditionalTest> summingBigIntegerParallel;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.chunk = Collectors2AdditionalTest::chunk;
            this.payloads.chunkParallel = Collectors2AdditionalTest::chunkParallel;
            this.payloads.zip = Collectors2AdditionalTest::zip;
            this.payloads.zipParallel = Collectors2AdditionalTest::zipParallel;
            this.payloads.zipWithIndex = Collectors2AdditionalTest::zipWithIndex;
            this.payloads.zipWithIndexParallel = Collectors2AdditionalTest::zipWithIndexParallel;
            this.payloads.sumByInt = Collectors2AdditionalTest::sumByInt;
            this.payloads.sumByIntParallel = Collectors2AdditionalTest::sumByIntParallel;
            this.payloads.sumByLong = Collectors2AdditionalTest::sumByLong;
            this.payloads.sumByLongParallel = Collectors2AdditionalTest::sumByLongParallel;
            this.payloads.sumByFloat = Collectors2AdditionalTest::sumByFloat;
            this.payloads.sumByFloatParallel = Collectors2AdditionalTest::sumByFloatParallel;
            this.payloads.sumByDouble = Collectors2AdditionalTest::sumByDouble;
            this.payloads.sumByDoubleParallel = Collectors2AdditionalTest::sumByDoubleParallel;
            this.payloads.sumByBigInteger = Collectors2AdditionalTest::sumByBigInteger;
            this.payloads.sumByBigIntegerParallel = Collectors2AdditionalTest::sumByBigIntegerParallel;
            this.payloads.sumByBigDecimal = Collectors2AdditionalTest::sumByBigDecimal;
            this.payloads.sumByBigDecimalParallel = Collectors2AdditionalTest::sumByBigDecimalParallel;
            this.payloads.select = Collectors2AdditionalTest::select;
            this.payloads.selectParallel = Collectors2AdditionalTest::selectParallel;
            this.payloads.selectWith = Collectors2AdditionalTest::selectWith;
            this.payloads.selectWithParallel = Collectors2AdditionalTest::selectWithParallel;
            this.payloads.reject = Collectors2AdditionalTest::reject;
            this.payloads.rejectParallel = Collectors2AdditionalTest::rejectParallel;
            this.payloads.rejectWith = Collectors2AdditionalTest::rejectWith;
            this.payloads.rejectWithParallel = Collectors2AdditionalTest::rejectWithParallel;
            this.payloads.partition = Collectors2AdditionalTest::partition;
            this.payloads.partitionParallel = Collectors2AdditionalTest::partitionParallel;
            this.payloads.partitionWith = Collectors2AdditionalTest::partitionWith;
            this.payloads.partitionWithParallel = Collectors2AdditionalTest::partitionWithParallel;
            this.payloads.collect = Collectors2AdditionalTest::collect;
            this.payloads.collectParallel = Collectors2AdditionalTest::collectParallel;
            this.payloads.flatCollect = Collectors2AdditionalTest::flatCollect;
            this.payloads.flatCollectParallel = Collectors2AdditionalTest::flatCollectParallel;
            this.payloads.collectWith = Collectors2AdditionalTest::collectWith;
            this.payloads.collectWithParallel = Collectors2AdditionalTest::collectWithParallel;
            this.payloads.collectBoolean = Collectors2AdditionalTest::collectBoolean;
            this.payloads.collectBooleanParallel = Collectors2AdditionalTest::collectBooleanParallel;
            this.payloads.collectByte = Collectors2AdditionalTest::collectByte;
            this.payloads.collectByteParallel = Collectors2AdditionalTest::collectByteParallel;
            this.payloads.collectChar = Collectors2AdditionalTest::collectChar;
            this.payloads.collectCharParallel = Collectors2AdditionalTest::collectCharParallel;
            this.payloads.collectShort = Collectors2AdditionalTest::collectShort;
            this.payloads.collectShortParallel = Collectors2AdditionalTest::collectShortParallel;
            this.payloads.collectInt = Collectors2AdditionalTest::collectInt;
            this.payloads.collectIntParallel = Collectors2AdditionalTest::collectIntParallel;
            this.payloads.collectFloat = Collectors2AdditionalTest::collectFloat;
            this.payloads.collectFloatParallel = Collectors2AdditionalTest::collectFloatParallel;
            this.payloads.collectLong = Collectors2AdditionalTest::collectLong;
            this.payloads.collectLongParallel = Collectors2AdditionalTest::collectLongParallel;
            this.payloads.collectDouble = Collectors2AdditionalTest::collectDouble;
            this.payloads.collectDoubleParallel = Collectors2AdditionalTest::collectDoubleParallel;
            this.payloads.summarizingBigDecimal = Collectors2AdditionalTest::summarizingBigDecimal;
            this.payloads.summarizingBigDecimalParallel = Collectors2AdditionalTest::summarizingBigDecimalParallel;
            this.payloads.summingBigDecimal = Collectors2AdditionalTest::summingBigDecimal;
            this.payloads.summingBigDecimalParallel = Collectors2AdditionalTest::summingBigDecimalParallel;
            this.payloads.summarizingBigInteger = Collectors2AdditionalTest::summarizingBigInteger;
            this.payloads.summarizingBigIntegerParallel = Collectors2AdditionalTest::summarizingBigIntegerParallel;
            this.payloads.summingBigInteger = Collectors2AdditionalTest::summingBigInteger;
            this.payloads.summingBigIntegerParallel = Collectors2AdditionalTest::summingBigIntegerParallel;
        }
    }
}
