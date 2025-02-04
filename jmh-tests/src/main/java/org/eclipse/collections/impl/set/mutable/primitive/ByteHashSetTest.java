/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.mutable.primitive;

import org.eclipse.collections.api.block.function.primitive.ByteToObjectFunction;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.primitive.MutableByteSet;
import org.eclipse.collections.impl.block.factory.primitive.BytePredicates;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ByteHashSet}.
 */
public class ByteHashSetTest extends AbstractByteSetTestCase {

    @Override
    protected final ByteHashSet classUnderTest() {
        return ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3);
    }

    @Override
    protected ByteHashSet newWith(byte... elements) {
        return ByteHashSet.newSetWith(elements);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new ByteHashSet(-1);
    }

    @Override
    @Test
    public void newCollection() {
        super.newCollection();
        ByteHashSet set = ByteHashSet.newSetWith((byte) 0, (byte) 1, (byte) 31, (byte) -1, (byte) -98, (byte) -64, (byte) -128);
        ByteHashSet hashSetFromList = ByteHashSet.newSet(ByteArrayList.newListWith((byte) 0, (byte) 0, (byte) 1, (byte) 31, (byte) -1, (byte) -98, (byte) -64, (byte) -128));
        ByteHashSet hashSetFromSet = ByteHashSet.newSet(set);
        Assert.assertEquals(set, hashSetFromList);
        Assert.assertEquals(set, hashSetFromSet);
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        ByteHashSet set = ByteHashSet.newSetWith((byte) 0, (byte) 1, (byte) 31, (byte) -1, (byte) -2, (byte) -64, (byte) -128, (byte) 64);
        Byte sum = set.injectInto(Byte.valueOf((byte) 0), (result, value) -> Byte.valueOf((byte) (result + value)));
        Assert.assertEquals(Byte.valueOf((byte) -99), sum);
    }

    @Override
    @Test
    public void appendString() {
        super.appendString();
        ByteHashSet set = ByteHashSet.newSetWith((byte) 0, (byte) 1, (byte) 31, (byte) -1, (byte) -2, (byte) -64, (byte) -128, (byte) 64);
        StringBuilder sb = new StringBuilder();
        sb.append("con");
        sb.append("tents");
        set.appendString(sb, "start", ",", "end");
        Assert.assertEquals("contentsstart-128,-64,-2,-1,0,1,31,64end", sb.toString());
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        ByteHashSet set = ByteHashSet.newSetWith((byte) 0, (byte) 1, (byte) 31, (byte) -1, (byte) -2, (byte) -64, (byte) -128, (byte) 64);
        MutableByteSet actualSet = set.reject(BytePredicates.greaterThan((byte) 0));
        ByteHashSet expectedSet = ByteHashSet.newSetWith((byte) 0, (byte) -1, (byte) -2, (byte) -64, (byte) -128);
        Assert.assertEquals(expectedSet, actualSet);
        MutableByteSet actualSet2 = set.reject(BytePredicates.lessThan((byte) 0));
        ByteHashSet expectedSet2 = ByteHashSet.newSetWith((byte) 0, (byte) 1, (byte) 31, (byte) 64);
        Assert.assertEquals(expectedSet2, actualSet2);
    }

    @Test
    public void hashcode() {
        ByteHashSet set = ByteHashSet.newSetWith((byte) 0, (byte) 1, (byte) 31, (byte) -1, (byte) -2, (byte) -64, (byte) -128, (byte) 64);
        Assert.assertEquals(-99, set.hashCode());
        ByteHashSet set1 = ByteHashSet.newSetWith((byte) 0, (byte) 1, (byte) 31);
        Assert.assertEquals(32, set1.hashCode());
        ByteHashSet set2 = ByteHashSet.newSetWith((byte) -76, (byte) -128, (byte) -127);
        Assert.assertEquals(-331, set2.hashCode());
        ByteHashSet set3 = ByteHashSet.newSetWith((byte) -33, (byte) 127, (byte) 65);
        Assert.assertEquals(159, set3.hashCode());
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        ByteToObjectFunction<Byte> function = parameter -> (byte) (parameter - 1);
        ByteHashSet set = ByteHashSet.newSetWith((byte) 0, (byte) 1, (byte) 31, (byte) -1, (byte) -2, (byte) -64, (byte) 111, (byte) 64);
        MutableSet<Byte> actualSet = set.collect(function);
        MutableSet<Byte> expectedSet = UnifiedSet.newSetWith((byte) -1, (byte) 0, (byte) 30, (byte) -2, (byte) -3, (byte) -65, (byte) 110, (byte) 63);
        Assert.assertEquals(expectedSet, actualSet);
    }

    @Override
    @Test
    public void anySatisfy() {
        super.anySatisfy();
        ByteHashSet set = ByteHashSet.newSetWith((byte) 0, (byte) 1, (byte) 31, (byte) -1, (byte) -2, (byte) -64, (byte) -65, (byte) -128, (byte) 111, (byte) 64);
        Assert.assertTrue(set.anySatisfy(BytePredicates.lessThan((byte) 0)));
        Assert.assertTrue(set.anySatisfy(BytePredicates.lessThan((byte) -2)));
        Assert.assertTrue(set.anySatisfy(BytePredicates.lessThan((byte) -64)));
        Assert.assertTrue(set.anySatisfy(BytePredicates.greaterThan((byte) 65)));
        Assert.assertFalse(set.anySatisfy(BytePredicates.greaterThan((byte) 121)));
        Assert.assertFalse(set.anySatisfy(BytePredicates.lessThan((byte) -128)));
    }

    @Override
    @Test
    public void allSatisfy() {
        super.allSatisfy();
        ByteHashSet set = ByteHashSet.newSetWith((byte) 0, (byte) 1, (byte) 31, (byte) -1, (byte) -2, (byte) -64, (byte) 111, (byte) 64, (byte) 65, (byte) 125, (byte) -65, (byte) -125);
        Assert.assertTrue(set.allSatisfy(BytePredicates.lessThan((byte) 127)));
        Assert.assertTrue(set.allSatisfy(BytePredicates.greaterThan((byte) -126)));
        Assert.assertFalse(set.allSatisfy(BytePredicates.lessThan((byte) 0)));
        Assert.assertFalse(set.allSatisfy(BytePredicates.greaterThan((byte) 63)));
        Assert.assertFalse(set.allSatisfy(BytePredicates.equal((byte) 68)));
        Assert.assertFalse(set.allSatisfy(BytePredicates.equal((byte) -124)));
        Assert.assertFalse(set.allSatisfy(BytePredicates.lessThan((byte) 68)));
        Assert.assertFalse(set.allSatisfy(BytePredicates.greaterThan((byte) -68)));
    }

    @Override
    @Test
    public void noneSatisfy() {
        super.noneSatisfy();
        ByteHashSet set = ByteHashSet.newSetWith((byte) 0, (byte) 1, (byte) 31, (byte) -1, (byte) -2, (byte) -64, (byte) 111, (byte) 64, (byte) 65, (byte) 125, (byte) -65, (byte) -125);
        Assert.assertFalse(set.noneSatisfy(BytePredicates.lessThan((byte) 127)));
        Assert.assertTrue(set.noneSatisfy(BytePredicates.greaterThan((byte) 127)));
        Assert.assertFalse(set.noneSatisfy(BytePredicates.lessThan((byte) 65)));
        Assert.assertFalse(set.noneSatisfy(BytePredicates.greaterThan((byte) -2)));
        Assert.assertFalse(set.noneSatisfy(BytePredicates.greaterThan((byte) -65)));
        Assert.assertFalse(set.noneSatisfy(BytePredicates.greaterThan((byte) 124)));
        Assert.assertFalse(set.noneSatisfy(BytePredicates.lessThan((byte) -1)));
        Assert.assertFalse(set.noneSatisfy(BytePredicates.lessThan((byte) -65)));
    }

    @Override
    @Test
    public void sum() {
        super.sum();
        ByteHashSet set = ByteHashSet.newSetWith((byte) 0, (byte) 1, (byte) 31, (byte) -1, (byte) -2, (byte) -64, (byte) -128, (byte) 64);
        Assert.assertEquals(-99, set.sum());
        ByteHashSet set1 = ByteHashSet.newSetWith((byte) 0, (byte) 1, (byte) 31);
        Assert.assertEquals(32, set1.sum());
        ByteHashSet set2 = ByteHashSet.newSetWith((byte) -76, (byte) -128, (byte) -127);
        Assert.assertEquals(-331, set2.sum());
        ByteHashSet set3 = ByteHashSet.newSetWith((byte) -33, (byte) 127, (byte) 65);
        Assert.assertEquals(159, set3.sum());
    }

    @Override
    @Test
    public void min() {
        super.min();
        ByteHashSet set = ByteHashSet.newSetWith((byte) 0, (byte) 1, (byte) 31, (byte) -1, (byte) -2, (byte) -64, (byte) -128, (byte) 64, (byte) 127);
        Assert.assertEquals(-128, set.min());
        ByteHashSet set1 = ByteHashSet.newSetWith((byte) 0, (byte) 1, (byte) 31);
        Assert.assertEquals(0, set1.min());
        ByteHashSet set2 = ByteHashSet.newSetWith((byte) -76, (byte) -128, (byte) -127);
        Assert.assertEquals(-128, set2.min());
        ByteHashSet set3 = ByteHashSet.newSetWith((byte) -33, (byte) 127, (byte) 65);
        Assert.assertEquals(-33, set3.min());
        ByteHashSet set4 = ByteHashSet.newSetWith((byte) -65, (byte) -127, (byte) -90);
        Assert.assertEquals(-127, set4.min());
        ByteHashSet set5 = ByteHashSet.newSetWith((byte) 75, (byte) 85, (byte) 127);
        Assert.assertEquals(75, set5.min());
    }

    @Override
    @Test
    public void max() {
        super.max();
        Assert.assertEquals(9L, this.newWith((byte) -1, (byte) -2, (byte) 9).max());
        Assert.assertEquals(127L, this.newWith((byte) -1, (byte) -2, (byte) 9, (byte) -65, (byte) -127, (byte) 65, (byte) 127).max());
        Assert.assertEquals(-1L, this.newWith((byte) -1, (byte) -2, (byte) -9, (byte) -65, (byte) -127).max());
        Assert.assertEquals(-65L, this.newWith((byte) -65, (byte) -87, (byte) -127).max());
    }

    @Test
    public void testEqualsContainingElements() {
        Verify.assertPostSerializedEqualsAndHashCode(this.newWith((byte) 14, (byte) 2, (byte) 30, (byte) 31, (byte) -90, (byte) 64, (byte) 0, (byte) 127, (byte) -14, (byte) -2, (byte) -30, (byte) -31, (byte) -65, (byte) -64, (byte) -128, (byte) 127));
    }

    @Test
    public void addAndCheckField() {
        MutableByteSet hashSet = new ByteHashSet();
        Assert.assertTrue(hashSet.add((byte) 14));
        Assert.assertFalse(hashSet.add((byte) 14));
        Assert.assertTrue(hashSet.add((byte) 2));
        Assert.assertFalse(hashSet.add((byte) 2));
        Assert.assertTrue(hashSet.add((byte) 35));
        Assert.assertFalse(hashSet.add((byte) 35));
        Assert.assertTrue(hashSet.add((byte) 31));
        Assert.assertFalse(hashSet.add((byte) 31));
        Assert.assertTrue(hashSet.add((byte) 32));
        Assert.assertFalse(hashSet.add((byte) 32));
        Assert.assertTrue(hashSet.add((byte) 0));
        Assert.assertFalse(hashSet.add((byte) 0));
        Assert.assertTrue(hashSet.add((byte) 1));
        Assert.assertFalse(hashSet.add((byte) 1));
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 14, (byte) 2, (byte) 31, (byte) 32, (byte) 35, (byte) 0, (byte) 1), hashSet);
    }

    @Test
    public void addWithRehash() {
        ByteHashSet hashSet = new ByteHashSet();
        Assert.assertTrue(hashSet.addAll((byte) 32, (byte) 33, (byte) 34, (byte) 35, (byte) 36, (byte) 37, (byte) 38, (byte) 39));
        Assert.assertEquals(8, hashSet.size());
        Assert.assertTrue(hashSet.addAll((byte) 0, (byte) 63, (byte) 64, (byte) 127, (byte) -1, (byte) -64, (byte) -65, (byte) -128));
        Assert.assertEquals(16, hashSet.size());
    }

    @Test
    public void addEverySlot() {
        this.addAndRemoveData(new ByteHashSet());
    }

    private void addAndRemoveData(ByteHashSet hashSet) {
        for (byte i = (byte) 100; i < (byte) 200; i++) {
            Assert.assertFalse(hashSet.contains(i));
            Assert.assertTrue(hashSet.add(i));
            Assert.assertTrue(hashSet.remove(i));
        }
    }

    @Test
    public void addDuplicateWithRemovedSlot() {
        ByteHashSet hashSet = new ByteHashSet();
        hashSet.add((byte) 0);
        hashSet.add((byte) 1);
        hashSet.add((byte) 63);
        hashSet.add((byte) 64);
        hashSet.add((byte) 65);
        hashSet.add((byte) 127);
        hashSet.add((byte) -1);
        hashSet.add((byte) -2);
        hashSet.add((byte) -63);
        hashSet.add((byte) -64);
        hashSet.add((byte) -127);
        hashSet.add((byte) -1);
        hashSet.add((byte) -2);
        hashSet.add((byte) -63);
        hashSet.add((byte) -64);
        hashSet.add((byte) -127);
        Assert.assertEquals(11, hashSet.size());
    }

    @Test
    public void addZeroToThirtyOne() {
        ByteHashSet hashSet = ByteHashSet.newSetWith();
        for (byte i = (byte) 0; i <= (byte) 31; i++) {
            Assert.assertTrue(hashSet.add(i));
            Assert.assertFalse(hashSet.add(i));
        }
        for (byte i = (byte) 0; i <= (byte) 31; i++) {
            Assert.assertTrue(hashSet.contains(i));
        }
        for (byte i = (byte) 0; i <= (byte) 31; i++) {
            Assert.assertTrue(hashSet.contains(i));
            Assert.assertTrue(hashSet.remove(i));
            Assert.assertFalse(hashSet.contains(i));
            Assert.assertFalse(hashSet.remove(i));
        }
        Assert.assertEquals(new ByteHashSet(), hashSet);
    }

    @Test
    public void addDuplicates() {
        ByteHashSet hashSet = ByteHashSet.newSetWith();
        Assert.assertEquals(0, hashSet.size());
        hashSet.add((byte) 0);
        hashSet.add((byte) 1);
        hashSet.add((byte) 2);
        hashSet.add((byte) 20);
        hashSet.add((byte) 55);
        hashSet.add((byte) 63);
        hashSet.add((byte) 0);
        hashSet.add((byte) 1);
        hashSet.add((byte) 63);
        Assert.assertEquals(6, hashSet.size());
    }

    @Test
    public void addRemoveAndContainsIntegrationTest() {
        ByteHashSet hashSet = ByteHashSet.newSetWith();
        Assert.assertFalse(hashSet.contains((byte) 0));
        Assert.assertFalse(hashSet.contains((byte) 1));
        Assert.assertFalse(hashSet.contains((byte) 2));
        Assert.assertFalse(hashSet.contains((byte) 20));
        Assert.assertFalse(hashSet.contains((byte) 55));
        Assert.assertFalse(hashSet.contains((byte) 63));
        Assert.assertFalse(hashSet.contains((byte) 63));
        hashSet.add((byte) 0);
        hashSet.add((byte) 1);
        hashSet.add((byte) 2);
        hashSet.add((byte) 20);
        hashSet.add((byte) 55);
        hashSet.add((byte) 63);
        Assert.assertTrue(hashSet.contains((byte) 0));
        Assert.assertTrue(hashSet.contains((byte) 1));
        Assert.assertTrue(hashSet.contains((byte) 2));
        Assert.assertTrue(hashSet.contains((byte) 20));
        Assert.assertTrue(hashSet.contains((byte) 55));
        Assert.assertTrue(hashSet.contains((byte) 63));
        Assert.assertTrue(hashSet.contains((byte) 63));
        Assert.assertFalse(hashSet.contains((byte) 23));
        Assert.assertFalse(hashSet.contains((byte) 44));
        Assert.assertFalse(hashSet.contains((byte) 54));
        hashSet.remove((byte) 0);
        Assert.assertFalse(hashSet.contains((byte) 0));
        hashSet.remove((byte) 20);
        Assert.assertFalse(hashSet.contains((byte) 20));
        Assert.assertFalse(hashSet.contains((byte) 64));
        Assert.assertFalse(hashSet.contains((byte) 66));
        Assert.assertFalse(hashSet.contains((byte) 78));
        Assert.assertFalse(hashSet.contains((byte) 100));
        Assert.assertFalse(hashSet.contains((byte) 127));
        hashSet.add((byte) 64);
        hashSet.add((byte) 66);
        hashSet.add((byte) 78);
        hashSet.add((byte) 100);
        hashSet.add((byte) 127);
        Assert.assertTrue(hashSet.contains((byte) 64));
        Assert.assertTrue(hashSet.contains((byte) 66));
        Assert.assertTrue(hashSet.contains((byte) 78));
        Assert.assertTrue(hashSet.contains((byte) 100));
        Assert.assertTrue(hashSet.contains((byte) 127));
        Assert.assertFalse(hashSet.contains((byte) 70));
        Assert.assertFalse(hashSet.contains((byte) 75));
        Assert.assertFalse(hashSet.contains((byte) 125));
        hashSet.remove((byte) 64);
        Assert.assertFalse(hashSet.contains((byte) 64));
        hashSet.remove((byte) 100);
        Assert.assertFalse(hashSet.contains((byte) 100));
        hashSet.add((byte) -1);
        hashSet.add((byte) -2);
        hashSet.add((byte) -33);
        hashSet.add((byte) -34);
        hashSet.add((byte) -50);
        hashSet.add((byte) -64);
        hashSet.add((byte) -65);
        hashSet.add((byte) -78);
        hashSet.add((byte) -112);
        hashSet.add((byte) -127);
        hashSet.add((byte) -128);
        Assert.assertTrue(hashSet.contains((byte) -1));
        Assert.assertTrue(hashSet.contains((byte) -2));
        Assert.assertTrue(hashSet.contains((byte) -33));
        Assert.assertTrue(hashSet.contains((byte) -34));
        Assert.assertTrue(hashSet.contains((byte) -50));
        Assert.assertTrue(hashSet.contains((byte) -64));
        Assert.assertTrue(hashSet.contains((byte) -65));
        Assert.assertTrue(hashSet.contains((byte) -78));
        Assert.assertTrue(hashSet.contains((byte) -112));
        Assert.assertTrue(hashSet.contains((byte) -127));
        Assert.assertTrue(hashSet.contains((byte) -128));
        Assert.assertFalse(hashSet.contains((byte) -31));
        Assert.assertFalse(hashSet.contains((byte) -55));
        Assert.assertFalse(hashSet.contains((byte) -66));
        Assert.assertFalse(hashSet.contains((byte) -75));
        Assert.assertFalse(hashSet.contains((byte) -80));
        Assert.assertFalse(hashSet.contains((byte) -100));
        hashSet.remove((byte) -1);
        hashSet.remove((byte) -2);
        hashSet.remove((byte) -65);
        hashSet.remove((byte) -127);
        hashSet.remove((byte) -33);
        Assert.assertFalse(hashSet.contains((byte) -1));
        Assert.assertFalse(hashSet.contains((byte) -2));
        Assert.assertFalse(hashSet.contains((byte) -65));
        Assert.assertFalse(hashSet.contains((byte) -127));
        Assert.assertFalse(hashSet.contains((byte) -33));
    }

    @Test
    public void testToArray() {
        ByteHashSet hashSet = ByteHashSet.newSetWith();
        hashSet.add((byte) 0);
        hashSet.add((byte) 1);
        hashSet.add((byte) 2);
        hashSet.add((byte) 20);
        hashSet.add((byte) 55);
        hashSet.add((byte) 63);
        hashSet.add((byte) 64);
        hashSet.add((byte) 65);
        hashSet.add((byte) 67);
        hashSet.add((byte) 70);
        hashSet.add((byte) 78);
        hashSet.add((byte) 80);
        hashSet.add((byte) 87);
        hashSet.add((byte) 98);
        hashSet.add((byte) 127);
        hashSet.add((byte) -1);
        hashSet.add((byte) -5);
        hashSet.add((byte) -14);
        hashSet.add((byte) -56);
        hashSet.add((byte) -63);
        hashSet.add((byte) -64);
        hashSet.add((byte) -65);
        hashSet.add((byte) -67);
        hashSet.add((byte) -100);
        hashSet.add((byte) -98);
        hashSet.add((byte) -87);
        hashSet.add((byte) -128);
        byte[] expected = { -128, -100, -98, -87, -67, -65, -64, -63, -56, -14, -5, -1, 0, 1, 2, 20, 55, 63, 64, 65, 67, 70, 78, 80, 87, 98, 127 };
        Assert.assertArrayEquals(expected, hashSet.toArray());
    }

    @Test
    public void toImmutable() {
        ByteHashSet hashSet = ByteHashSet.newSetWith();
        Assert.assertEquals(0, hashSet.toImmutable().size());
        ByteHashSet hashSet1 = ByteHashSet.newSetWith((byte) -1);
        Assert.assertEquals(1, hashSet1.toImmutable().size());
        ByteHashSet hashSet2 = ByteHashSet.newSetWith((byte) -1, (byte) -4);
        Assert.assertEquals(2, hashSet2.toImmutable().size());
    }

    @Test
    public void freeze() {
        ByteHashSet hashSet = ByteHashSet.newSetWith();
        Assert.assertEquals(0, hashSet.freeze().size());
        ByteHashSet hashSet1 = ByteHashSet.newSetWith((byte) -1);
        Assert.assertEquals(1, hashSet1.freeze().size());
        ByteHashSet hashSet2 = ByteHashSet.newSetWith((byte) -1, (byte) -4);
        Assert.assertEquals(2, hashSet2.freeze().size());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ByteHashSetTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
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
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
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
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
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
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll_iterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
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
        public void benchmark_byteIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_with_remove);
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
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
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
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll_iterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws);
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
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_union() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.union);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_difference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.difference);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifference);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isSubsetOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isProperSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isProperSubsetOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isCartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isCartesianProduct);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithInitialCapacity_negative_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithInitialCapacity_negative_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_hashcode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.hashcode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEqualsContainingElements() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEqualsContainingElements);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAndCheckField() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAndCheckField);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addWithRehash() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addWithRehash);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addEverySlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addEverySlot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addDuplicateWithRemovedSlot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addZeroToThirtyOne() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addZeroToThirtyOne);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addDuplicates() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addDuplicates);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addRemoveAndContainsIntegrationTest() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addRemoveAndContainsIntegrationTest);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_freeze() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.freeze);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> payload) throws java.lang.Throwable {
            this.instance = new ByteHashSetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> byteIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> byteIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> byteIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> byteIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> byteIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> isCartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> hashcode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> testEqualsContainingElements;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> addAndCheckField;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> addWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> addEverySlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> addDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> addZeroToThirtyOne;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> addDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> addRemoveAndContainsIntegrationTest;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> testToArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteHashSetTest> freeze;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ByteHashSetTest::newCollectionWith;
            this.payloads.tap = ByteHashSetTest::tap;
            this.payloads.containsAllArray = ByteHashSetTest::containsAllArray;
            this.payloads.containsAllIterable = ByteHashSetTest::containsAllIterable;
            this.payloads.containsAnyArray = ByteHashSetTest::containsAnyArray;
            this.payloads.containsAnyIterable = ByteHashSetTest::containsAnyIterable;
            this.payloads.containsNoneArray = ByteHashSetTest::containsNoneArray;
            this.payloads.containsNoneIterable = ByteHashSetTest::containsNoneIterable;
            this.payloads.collectWithTarget = ByteHashSetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ByteHashSetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ByteHashSetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ByteHashSetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ByteHashSetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = ByteHashSetTest::selectWithTarget;
            this.payloads.rejectWithTarget = ByteHashSetTest::rejectWithTarget;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteHashSetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteHashSetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ByteHashSetTest::minIfEmpty;
            this.payloads.maxIfEmpty = ByteHashSetTest::maxIfEmpty;
            this.payloads.summaryStatistics = ByteHashSetTest::summaryStatistics;
            this.payloads.average = ByteHashSetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteHashSetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ByteHashSetTest::averageIfEmpty;
            this.payloads.median = ByteHashSetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteHashSetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ByteHashSetTest::medianIfEmpty;
            this.payloads.toArray = ByteHashSetTest::toArray;
            this.payloads.toArrayWithTargetArray = ByteHashSetTest::toArrayWithTargetArray;
            this.payloads.testToString = ByteHashSetTest::testToString;
            this.payloads.makeString = ByteHashSetTest::makeString;
            this.payloads.toList = ByteHashSetTest::toList;
            this.payloads.toSortedList = ByteHashSetTest::toSortedList;
            this.payloads.toSortedListByComparator = ByteHashSetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ByteHashSetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ByteHashSetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ByteHashSetTest::toSet;
            this.payloads.injectIntoBoolean = ByteHashSetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ByteHashSetTest::injectIntoByte;
            this.payloads.injectIntoChar = ByteHashSetTest::injectIntoChar;
            this.payloads.injectIntoShort = ByteHashSetTest::injectIntoShort;
            this.payloads.injectIntoInt = ByteHashSetTest::injectIntoInt;
            this.payloads.injectIntoFloat = ByteHashSetTest::injectIntoFloat;
            this.payloads.injectIntoLong = ByteHashSetTest::injectIntoLong;
            this.payloads.injectIntoDouble = ByteHashSetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteHashSetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ByteHashSetTest::reduce;
            this.payloads.reduceIfEmpty = ByteHashSetTest::reduceIfEmpty;
            this.payloads.chunk = ByteHashSetTest::chunk;
            this.payloads.contains = ByteHashSetTest::contains;
            this.payloads.addAllArray = ByteHashSetTest::addAllArray;
            this.payloads.removeIf = ByteHashSetTest::removeIf;
            this.payloads.retainAll = ByteHashSetTest::retainAll;
            this.payloads.retainAll_iterable = ByteHashSetTest::retainAll_iterable;
            this.payloads.with = ByteHashSetTest::with;
            this.payloads.withAll = ByteHashSetTest::withAll;
            this.payloads.without = ByteHashSetTest::without;
            this.payloads.withoutAll = ByteHashSetTest::withoutAll;
            this.payloads.byteIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteHashSetTest::byteIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.byteIterator_with_remove = ByteHashSetTest::byteIterator_with_remove;
            this.payloads.byteIterator_throws_for_remove_before_next = ByteHashSetTest::byteIterator_throws_for_remove_before_next;
            this.payloads.byteIterator_throws_for_consecutive_remove = ByteHashSetTest::byteIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = ByteHashSetTest::newEmpty;
            this.payloads.size = ByteHashSetTest::size;
            this.payloads.isEmpty = ByteHashSetTest::isEmpty;
            this.payloads.notEmpty = ByteHashSetTest::notEmpty;
            this.payloads.clear = ByteHashSetTest::clear;
            this.payloads.add = ByteHashSetTest::add;
            this.payloads.addAllIterable = ByteHashSetTest::addAllIterable;
            this.payloads.remove = ByteHashSetTest::remove;
            this.payloads.removeAll = ByteHashSetTest::removeAll;
            this.payloads.removeAll_iterable = ByteHashSetTest::removeAll_iterable;
            this.payloads.byteIterator = ByteHashSetTest::byteIterator;
            this.payloads.byteIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteHashSetTest::byteIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ByteHashSetTest::forEach;
            this.payloads.count = ByteHashSetTest::count;
            this.payloads.select = ByteHashSetTest::select;
            this.payloads.detectIfNone = ByteHashSetTest::detectIfNone;
            this.payloads.toSortedArray = ByteHashSetTest::toSortedArray;
            this.payloads.testEquals = ByteHashSetTest::testEquals;
            this.payloads.testHashCode = ByteHashSetTest::testHashCode;
            this.payloads.toBag = ByteHashSetTest::toBag;
            this.payloads.asLazy = ByteHashSetTest::asLazy;
            this.payloads.asSynchronized = ByteHashSetTest::asSynchronized;
            this.payloads.asUnmodifiable = ByteHashSetTest::asUnmodifiable;
            this.payloads.classIsNonInstantiable = ByteHashSetTest::classIsNonInstantiable;
            this.payloads.union = ByteHashSetTest::union;
            this.payloads.intersect = ByteHashSetTest::intersect;
            this.payloads.difference = ByteHashSetTest::difference;
            this.payloads.symmetricDifference = ByteHashSetTest::symmetricDifference;
            this.payloads.isSubsetOf = ByteHashSetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = ByteHashSetTest::isProperSubsetOf;
            this.payloads.isCartesianProduct = ByteHashSetTest::isCartesianProduct;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteHashSetTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newCollection = ByteHashSetTest::newCollection;
            this.payloads.injectInto = ByteHashSetTest::injectInto;
            this.payloads.appendString = ByteHashSetTest::appendString;
            this.payloads.reject = ByteHashSetTest::reject;
            this.payloads.hashcode = ByteHashSetTest::hashcode;
            this.payloads.collect = ByteHashSetTest::collect;
            this.payloads.anySatisfy = ByteHashSetTest::anySatisfy;
            this.payloads.allSatisfy = ByteHashSetTest::allSatisfy;
            this.payloads.noneSatisfy = ByteHashSetTest::noneSatisfy;
            this.payloads.sum = ByteHashSetTest::sum;
            this.payloads.min = ByteHashSetTest::min;
            this.payloads.max = ByteHashSetTest::max;
            this.payloads.testEqualsContainingElements = ByteHashSetTest::testEqualsContainingElements;
            this.payloads.addAndCheckField = ByteHashSetTest::addAndCheckField;
            this.payloads.addWithRehash = ByteHashSetTest::addWithRehash;
            this.payloads.addEverySlot = ByteHashSetTest::addEverySlot;
            this.payloads.addDuplicateWithRemovedSlot = ByteHashSetTest::addDuplicateWithRemovedSlot;
            this.payloads.addZeroToThirtyOne = ByteHashSetTest::addZeroToThirtyOne;
            this.payloads.addDuplicates = ByteHashSetTest::addDuplicates;
            this.payloads.addRemoveAndContainsIntegrationTest = ByteHashSetTest::addRemoveAndContainsIntegrationTest;
            this.payloads.testToArray = ByteHashSetTest::testToArray;
            this.payloads.toImmutable = ByteHashSetTest::toImmutable;
            this.payloads.freeze = ByteHashSetTest::freeze;
        }
    }
}
