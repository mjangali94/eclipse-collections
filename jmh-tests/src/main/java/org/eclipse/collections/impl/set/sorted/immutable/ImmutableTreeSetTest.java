/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.sorted.immutable;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;
import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;
import org.eclipse.collections.api.set.sorted.SortedSetIterable;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.PrimitiveFunctions;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.SortedSets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableTreeSetTest extends AbstractImmutableSortedSetTestCase {

    @Override
    protected ImmutableSortedSet<Integer> classUnderTest() {
        return ImmutableTreeSet.newSetWith(1, 2, 3, 4);
    }

    @Override
    protected ImmutableSortedSet<Integer> classUnderTest(Comparator<? super Integer> comparator) {
        return ImmutableTreeSet.newSetWith(comparator, 1, 2, 3, 4);
    }

    @Test
    public void constructWithNull() {
        Assert.assertThrows(ClassCastException.class, () -> new TreeSet<>(Arrays.asList(new Object())));
        Assert.assertThrows(NullPointerException.class, () -> new TreeSet<>(Arrays.asList(null, null)));
        Assert.assertThrows(NullPointerException.class, () -> new TreeSet<>(Arrays.asList((Object) null)));
        Assert.assertThrows(ClassCastException.class, () -> SortedSets.immutable.of(new Object()));
        Assert.assertThrows(NullPointerException.class, () -> SortedSets.immutable.of((Object) null, null));
        Assert.assertThrows(NullPointerException.class, () -> SortedSets.immutable.of((Object) null));
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        Assert.assertNotEquals(new TreeSet<>(Arrays.asList("1", "2", "3")), new TreeSet<>(Arrays.asList(1, 2, 3)));
        Assert.assertNotEquals(new TreeSet<>(Arrays.asList("1", "2", "3")), Sets.immutable.of("1", "2", null));
        Assert.assertNotEquals(SortedSets.immutable.of("1", "2", "3"), SortedSets.immutable.of(1, 2, 3));
    }

    @Test
    public void serialization() {
        ImmutableSortedSet<Integer> set = this.classUnderTest();
        Verify.assertPostSerializedEqualsAndHashCode(set);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void subSet() {
        this.classUnderTest().castToSortedSet().subSet(1, 4);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void headSet() {
        this.classUnderTest().castToSortedSet().headSet(4);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void tailSet() {
        this.classUnderTest().castToSortedSet().tailSet(1);
    }

    @Override
    @Test
    public void powerSet() {
        ImmutableSortedSet<SortedSetIterable<Integer>> intPowerSet = SortedSets.immutable.of(1, 2, 3).powerSet();
        ImmutableSortedSet<SortedSetIterable<Integer>> revPowerSet = SortedSets.immutable.of(Comparators.reverseNaturalOrder(), 1, 2, 3).powerSet();
        FastList<TreeSortedSet<Integer>> expectedSortedSet = FastList.newListWith(TreeSortedSet.newSet(), TreeSortedSet.newSetWith(1), TreeSortedSet.newSetWith(2), TreeSortedSet.newSetWith(3), TreeSortedSet.newSetWith(1, 2), TreeSortedSet.newSetWith(1, 3), TreeSortedSet.newSetWith(2, 3), TreeSortedSet.newSetWith(1, 2, 3));
        FastList<TreeSortedSet<Integer>> expectedRevSortedSet = FastList.newListWith(TreeSortedSet.newSet(), TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), 3), TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), 2), TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), 1), TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), 2, 3), TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), 1, 3), TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), 1, 2), TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), 1, 2, 3));
        Verify.assertListsEqual(expectedSortedSet, intPowerSet.toList());
        Verify.assertListsEqual(expectedRevSortedSet, revPowerSet.toList());
    }

    @Test
    public void compareTo() {
        ImmutableSortedSet<Integer> set = SortedSets.immutable.of(1, 2, 3);
        Assert.assertEquals(0, set.compareTo(set));
        Assert.assertEquals(-1, set.compareTo(SortedSets.immutable.of(1, 2, 3, 4)));
        Assert.assertEquals(1, set.compareTo(SortedSets.immutable.of(1, 2)));
        Assert.assertEquals(-1, set.compareTo(SortedSets.immutable.of(1, 2, 4)));
        Assert.assertEquals(1, set.compareTo(SortedSets.immutable.of(1, 2, 2)));
    }

    @Override
    @Test
    public void collectBoolean() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Assert.assertEquals(BooleanArrayList.newListWith(true, true, true, true), integers.collectBoolean(PrimitiveFunctions.integerIsPositive()));
    }

    @Override
    @Test
    public void collectByte() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Assert.assertEquals(ByteArrayList.newListWith((byte) 4, (byte) 3, (byte) 2, (byte) 1), integers.collectByte(PrimitiveFunctions.unboxIntegerToByte()));
    }

    @Override
    @Test
    public void collectChar() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Assert.assertEquals(CharArrayList.newListWith('D', 'C', 'B', 'A'), integers.collectChar(integer -> (char) (integer.intValue() + 64)));
    }

    @Override
    @Test
    public void collectDouble() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Assert.assertEquals(DoubleArrayList.newListWith(4.0d, 3.0d, 2.0d, 1.0d), integers.collectDouble(PrimitiveFunctions.unboxIntegerToDouble()));
    }

    @Override
    @Test
    public void collectFloat() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Assert.assertEquals(FloatArrayList.newListWith(4.0f, 3.0f, 2.0f, 1.0f), integers.collectFloat(PrimitiveFunctions.unboxIntegerToFloat()));
    }

    @Override
    @Test
    public void collectInt() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Assert.assertEquals(IntArrayList.newListWith(4, 3, 2, 1), integers.collectInt(PrimitiveFunctions.unboxIntegerToInt()));
    }

    @Override
    @Test
    public void collectLong() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Assert.assertEquals(LongArrayList.newListWith(4, 3, 2, 1), integers.collectLong(PrimitiveFunctions.unboxIntegerToLong()));
    }

    @Override
    @Test
    public void collectShort() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Assert.assertEquals(ShortArrayList.newListWith((short) 4, (short) 3, (short) 2, (short) 1), integers.collectShort(PrimitiveFunctions.unboxIntegerToShort()));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public ImmutableTreeSetTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noSupportForNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noSupportForNull);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAll);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
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
        public void benchmark_selectToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectToTarget);
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
        public void benchmark_rejectToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectToTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
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
        public void benchmark_partitionWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_takeWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.takeWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dropWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dropWhile);
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
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectToTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
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
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_corresponds() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.corresponds);
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
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIfToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIfToTarget);
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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
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
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMapBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forLoop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forLoop);
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
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEachWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEachWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_union() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.union);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unionInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.unionInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_difference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.difference);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_differenceInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.differenceInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifference);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifferenceInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifferenceInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isSubsetOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isProperSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isProperSubsetOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProduct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachFromTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexWithFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexWithFromTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStack);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_constructWithNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.constructWithNull);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_headSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.headSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tailSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tailSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_powerSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.powerSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_compareTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.compareTo);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableTreeSetTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> noSupportForNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> newWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> selectToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> rejectToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> collectToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> collectIfToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> toSortedSetWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> forLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> groupByWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> groupByEachWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> unionInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> intersectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> differenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> symmetricDifferenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> forEachWithIndexWithFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> constructWithNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> subSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> headSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> tailSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> powerSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> compareTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetTest> collectShort;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.noSupportForNull = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeSetTest::noSupportForNull, java.lang.NullPointerException.class);
            this.payloads.newWith = ImmutableTreeSetTest::newWith;
            this.payloads.newWithout = ImmutableTreeSetTest::newWithout;
            this.payloads.newWithAll = ImmutableTreeSetTest::newWithAll;
            this.payloads.newWithoutAll = ImmutableTreeSetTest::newWithoutAll;
            this.payloads.contains = ImmutableTreeSetTest::contains;
            this.payloads.containsAllArray = ImmutableTreeSetTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableTreeSetTest::containsAllIterable;
            this.payloads.tap = ImmutableTreeSetTest::tap;
            this.payloads.forEach = ImmutableTreeSetTest::forEach;
            this.payloads.forEachWith = ImmutableTreeSetTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableTreeSetTest::forEachWithIndex;
            this.payloads.select = ImmutableTreeSetTest::select;
            this.payloads.selectWith = ImmutableTreeSetTest::selectWith;
            this.payloads.selectToTarget = ImmutableTreeSetTest::selectToTarget;
            this.payloads.reject = ImmutableTreeSetTest::reject;
            this.payloads.rejectWith = ImmutableTreeSetTest::rejectWith;
            this.payloads.rejectToTarget = ImmutableTreeSetTest::rejectToTarget;
            this.payloads.selectInstancesOf = ImmutableTreeSetTest::selectInstancesOf;
            this.payloads.partition = ImmutableTreeSetTest::partition;
            this.payloads.partitionWith = ImmutableTreeSetTest::partitionWith;
            this.payloads.partitionWhile = ImmutableTreeSetTest::partitionWhile;
            this.payloads.takeWhile = ImmutableTreeSetTest::takeWhile;
            this.payloads.dropWhile = ImmutableTreeSetTest::dropWhile;
            this.payloads.collect = ImmutableTreeSetTest::collect;
            this.payloads.collectWith = ImmutableTreeSetTest::collectWith;
            this.payloads.collectWithIndex = ImmutableTreeSetTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ImmutableTreeSetTest::collectWithIndexWithTarget;
            this.payloads.selectWithIndexWithTarget = ImmutableTreeSetTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndexWithTarget = ImmutableTreeSetTest::rejectWithIndexWithTarget;
            this.payloads.collectToTarget = ImmutableTreeSetTest::collectToTarget;
            this.payloads.flatCollect = ImmutableTreeSetTest::flatCollect;
            this.payloads.flatCollectWithTarget = ImmutableTreeSetTest::flatCollectWithTarget;
            this.payloads.zip = ImmutableTreeSetTest::zip;
            this.payloads.zipWithIndex = ImmutableTreeSetTest::zipWithIndex;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeSetTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = ImmutableTreeSetTest::chunk_large_size;
            this.payloads.detect = ImmutableTreeSetTest::detect;
            this.payloads.detectWith = ImmutableTreeSetTest::detectWith;
            this.payloads.detectWithIfNone = ImmutableTreeSetTest::detectWithIfNone;
            this.payloads.detectIfNone = ImmutableTreeSetTest::detectIfNone;
            this.payloads.detectIndex = ImmutableTreeSetTest::detectIndex;
            this.payloads.corresponds = ImmutableTreeSetTest::corresponds;
            this.payloads.allSatisfy = ImmutableTreeSetTest::allSatisfy;
            this.payloads.anySatisfy = ImmutableTreeSetTest::anySatisfy;
            this.payloads.count = ImmutableTreeSetTest::count;
            this.payloads.collectIf = ImmutableTreeSetTest::collectIf;
            this.payloads.collectIfToTarget = ImmutableTreeSetTest::collectIfToTarget;
            this.payloads.getFirst = ImmutableTreeSetTest::getFirst;
            this.payloads.getLast = ImmutableTreeSetTest::getLast;
            this.payloads.isEmpty = ImmutableTreeSetTest::isEmpty;
            this.payloads.iterator = ImmutableTreeSetTest::iterator;
            this.payloads.injectInto = ImmutableTreeSetTest::injectInto;
            this.payloads.toArray = ImmutableTreeSetTest::toArray;
            this.payloads.testToString = ImmutableTreeSetTest::testToString;
            this.payloads.makeString = ImmutableTreeSetTest::makeString;
            this.payloads.appendString = ImmutableTreeSetTest::appendString;
            this.payloads.toList = ImmutableTreeSetTest::toList;
            this.payloads.toSortedList = ImmutableTreeSetTest::toSortedList;
            this.payloads.toSortedListBy = ImmutableTreeSetTest::toSortedListBy;
            this.payloads.toSortedSet = ImmutableTreeSetTest::toSortedSet;
            this.payloads.toSortedSetWithComparator = ImmutableTreeSetTest::toSortedSetWithComparator;
            this.payloads.toSortedSetBy = ImmutableTreeSetTest::toSortedSetBy;
            this.payloads.toSortedMap = ImmutableTreeSetTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = ImmutableTreeSetTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = ImmutableTreeSetTest::toSortedMapBy;
            this.payloads.forLoop = ImmutableTreeSetTest::forLoop;
            this.payloads.iteratorRemove = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeSetTest::iteratorRemove, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeSetTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeSetTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeSetTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeSetTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeSetTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeSetTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.min = ImmutableTreeSetTest::min;
            this.payloads.max = ImmutableTreeSetTest::max;
            this.payloads.min_without_comparator = ImmutableTreeSetTest::min_without_comparator;
            this.payloads.max_without_comparator = ImmutableTreeSetTest::max_without_comparator;
            this.payloads.minBy = ImmutableTreeSetTest::minBy;
            this.payloads.maxBy = ImmutableTreeSetTest::maxBy;
            this.payloads.groupBy = ImmutableTreeSetTest::groupBy;
            this.payloads.groupByEach = ImmutableTreeSetTest::groupByEach;
            this.payloads.groupByWithTarget = ImmutableTreeSetTest::groupByWithTarget;
            this.payloads.groupByEachWithTarget = ImmutableTreeSetTest::groupByEachWithTarget;
            this.payloads.groupByUniqueKey = ImmutableTreeSetTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeSetTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ImmutableTreeSetTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeSetTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.union = ImmutableTreeSetTest::union;
            this.payloads.unionInto = ImmutableTreeSetTest::unionInto;
            this.payloads.intersect = ImmutableTreeSetTest::intersect;
            this.payloads.intersectInto = ImmutableTreeSetTest::intersectInto;
            this.payloads.difference = ImmutableTreeSetTest::difference;
            this.payloads.differenceInto = ImmutableTreeSetTest::differenceInto;
            this.payloads.symmetricDifference = ImmutableTreeSetTest::symmetricDifference;
            this.payloads.symmetricDifferenceInto = ImmutableTreeSetTest::symmetricDifferenceInto;
            this.payloads.isSubsetOf = ImmutableTreeSetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = ImmutableTreeSetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = ImmutableTreeSetTest::cartesianProduct;
            this.payloads.distinct = ImmutableTreeSetTest::distinct;
            this.payloads.indexOf = ImmutableTreeSetTest::indexOf;
            this.payloads.forEachFromTo = ImmutableTreeSetTest::forEachFromTo;
            this.payloads.forEachWithIndexWithFromTo = ImmutableTreeSetTest::forEachWithIndexWithFromTo;
            this.payloads.toStack = ImmutableTreeSetTest::toStack;
            this.payloads.toImmutable = ImmutableTreeSetTest::toImmutable;
            this.payloads.take = ImmutableTreeSetTest::take;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeSetTest::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = ImmutableTreeSetTest::drop;
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeSetTest::drop_throws, java.lang.IllegalArgumentException.class);
            this.payloads.constructWithNull = ImmutableTreeSetTest::constructWithNull;
            this.payloads.equalsAndHashCode = ImmutableTreeSetTest::equalsAndHashCode;
            this.payloads.serialization = ImmutableTreeSetTest::serialization;
            this.payloads.subSet = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeSetTest::subSet, java.lang.UnsupportedOperationException.class);
            this.payloads.headSet = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeSetTest::headSet, java.lang.UnsupportedOperationException.class);
            this.payloads.tailSet = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeSetTest::tailSet, java.lang.UnsupportedOperationException.class);
            this.payloads.powerSet = ImmutableTreeSetTest::powerSet;
            this.payloads.compareTo = ImmutableTreeSetTest::compareTo;
            this.payloads.collectBoolean = ImmutableTreeSetTest::collectBoolean;
            this.payloads.collectByte = ImmutableTreeSetTest::collectByte;
            this.payloads.collectChar = ImmutableTreeSetTest::collectChar;
            this.payloads.collectDouble = ImmutableTreeSetTest::collectDouble;
            this.payloads.collectFloat = ImmutableTreeSetTest::collectFloat;
            this.payloads.collectInt = ImmutableTreeSetTest::collectInt;
            this.payloads.collectLong = ImmutableTreeSetTest::collectLong;
            this.payloads.collectShort = ImmutableTreeSetTest::collectShort;
        }
    }
}
