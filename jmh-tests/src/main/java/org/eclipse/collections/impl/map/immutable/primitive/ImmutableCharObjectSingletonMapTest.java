/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.immutable.primitive;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bag.primitive.MutableBooleanBag;
import org.eclipse.collections.api.bag.primitive.MutableByteBag;
import org.eclipse.collections.api.bag.primitive.MutableCharBag;
import org.eclipse.collections.api.bag.primitive.MutableDoubleBag;
import org.eclipse.collections.api.bag.primitive.MutableFloatBag;
import org.eclipse.collections.api.bag.primitive.MutableIntBag;
import org.eclipse.collections.api.bag.primitive.MutableLongBag;
import org.eclipse.collections.api.bag.primitive.MutableShortBag;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.map.primitive.ImmutableCharObjectMap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.BooleanHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.ByteHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.bag.sorted.mutable.TreeBag;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.block.factory.StringFunctions;
import org.eclipse.collections.impl.block.factory.StringPredicates;
import org.eclipse.collections.impl.block.factory.StringPredicates2;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.primitive.CharObjectHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.StringIterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableCharObjectSingletonMap}.
 * This file was automatically generated from template file immutablePrimitiveObjectSingletonMapTest.stg.
 */
public class ImmutableCharObjectSingletonMapTest extends AbstractImmutableCharObjectMapTestCase {

    @Override
    protected ImmutableCharObjectMap<String> classUnderTest() {
        return CharObjectHashMap.newWithKeysValues((char) 0, "zero").toImmutable();
    }

    @Override
    @Test
    public void containsValue() {
        Assert.assertFalse(this.classUnderTest().containsValue(null));
        Assert.assertTrue(this.classUnderTest().containsValue("zero"));
        Assert.assertFalse(this.classUnderTest().containsValue("thirtyOne"));
        Assert.assertFalse(this.classUnderTest().containsValue("thirtyTwo"));
    }

    @Override
    @Test
    public void contains() {
        Assert.assertFalse(this.classUnderTest().contains(null));
        Assert.assertTrue(this.classUnderTest().contains("zero"));
        Assert.assertFalse(this.classUnderTest().contains("thirtyOne"));
        Assert.assertFalse(this.classUnderTest().contains("thirtyTwo"));
    }

    @Override
    @Test
    public void containsAllIterable() {
        Assert.assertTrue(this.classUnderTest().containsAllIterable(FastList.newListWith("zero")));
        Assert.assertTrue(this.classUnderTest().containsAllIterable(FastList.newListWith()));
        Assert.assertFalse(this.classUnderTest().containsAllIterable(FastList.newListWith("zero", "thirtyOne")));
        Assert.assertFalse(this.classUnderTest().containsAllIterable(FastList.newListWith("zero", "thirtyOne", "thirtyTwo")));
        Assert.assertFalse(this.classUnderTest().containsAllIterable(FastList.newListWith("zero", "one", "thirtyTwo")));
        Assert.assertFalse(this.classUnderTest().containsAllIterable(FastList.newListWith("two", "one", "nine")));
    }

    @Override
    @Test
    public void containsAll() {
        Assert.assertTrue(this.classUnderTest().containsAll(FastList.newListWith()));
        Assert.assertTrue(this.classUnderTest().containsAll(FastList.newListWith("zero")));
        Assert.assertFalse(this.classUnderTest().containsAll(FastList.newListWith("zero", "thirtyOne")));
        Assert.assertFalse(this.classUnderTest().containsAll(FastList.newListWith("zero", "thirtyOne", "thirtyTwo")));
        Assert.assertFalse(this.classUnderTest().containsAll(FastList.newListWith("zero", "one", "thirtyTwo")));
        Assert.assertFalse(this.classUnderTest().containsAll(FastList.newListWith("two", "one", "nine")));
    }

    @Override
    @Test
    public void containsAllArguments() {
        Assert.assertTrue(this.classUnderTest().containsAllArguments());
        Assert.assertTrue(this.classUnderTest().containsAllArguments("zero"));
        Assert.assertFalse(this.classUnderTest().containsAllArguments("zero", "thirtyOne"));
        Assert.assertFalse(this.classUnderTest().containsAllArguments("zero", "thirtyOne", "thirtyTwo"));
        Assert.assertFalse(this.classUnderTest().containsAllArguments("zero", "one", "thirtyTwo"));
        Assert.assertFalse(this.classUnderTest().containsAllArguments("two", "one", "nine"));
    }

    @Override
    @Test
    public void containsKey() {
        Assert.assertTrue(this.classUnderTest().containsKey((char) 0));
        Assert.assertFalse(this.classUnderTest().containsKey((char) 31));
        Assert.assertFalse(this.classUnderTest().containsKey((char) 32));
        Assert.assertFalse(this.classUnderTest().containsKey((char) 1));
        Assert.assertFalse(this.classUnderTest().containsKey((char) 5));
        Assert.assertFalse(this.classUnderTest().containsKey((char) 35));
    }

    @Override
    @Test
    public void getIfAbsent() {
        Function0<String> ifAbsent = () -> "ifAbsent";
        Assert.assertEquals("zero", this.classUnderTest().getIfAbsent((char) 0, ifAbsent));
        Assert.assertEquals("ifAbsent", this.classUnderTest().getIfAbsent((char) 31, ifAbsent));
        Assert.assertEquals("ifAbsent", this.classUnderTest().getIfAbsent((char) 32, ifAbsent));
        Assert.assertEquals("ifAbsent", this.classUnderTest().getIfAbsent((char) 1, ifAbsent));
        Assert.assertEquals("ifAbsent", this.classUnderTest().getIfAbsent((char) 33, ifAbsent));
    }

    @Override
    @Test
    public void get() {
        Assert.assertEquals("zero", this.classUnderTest().get((char) 0));
        Assert.assertNull(this.classUnderTest().get((char) 31));
        Assert.assertNull(this.classUnderTest().get((char) 32));
        Assert.assertNull(this.classUnderTest().get((char) 1));
        Assert.assertNull(this.classUnderTest().get((char) 33));
    }

    @Override
    @Test
    public void iterator() {
        Iterator<String> iterator = this.classUnderTest().iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals("zero", iterator.next());
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void getFirst() {
        Assert.assertEquals("zero", this.classUnderTest().getFirst());
    }

    @Override
    @Test
    public void getLast() {
        Assert.assertEquals("zero", this.classUnderTest().getLast());
    }

    @Override
    @Test
    public void getOnly() {
        Assert.assertEquals("zero", this.classUnderTest().getOnly());
    }

    @Override
    @Test
    public void tap() {
        StringBuilder concat = new StringBuilder();
        ImmutableCharObjectMap<String> map = this.classUnderTest();
        Assert.assertSame(map, map.tap(concat::append));
        Assert.assertEquals("zero", concat.toString());
    }

    @Override
    @Test
    public void forEach() {
        String[] concat = { "" };
        this.classUnderTest().forEach(Procedures.cast(each -> concat[0] += each));
        Assert.assertEquals("zero", concat[0]);
    }

    @Override
    @Test
    public void forEachWithIndex() {
        String[] concat = { "" };
        this.classUnderTest().forEachWithIndex((String each, int parameter) -> {
            concat[0] += each;
            concat[0] += parameter;
        });
        Assert.assertEquals("zero0", concat[0]);
    }

    @Override
    @Test
    public void forEachWith() {
        String[] concat = { "" };
        this.classUnderTest().forEachWith((String argument1, String argument2) -> {
            concat[0] += argument1;
            concat[0] += argument2;
        }, "-");
        Assert.assertEquals("zero-", concat[0]);
    }

    @Override
    @Test
    public void forEachValue() {
        String[] concat = { "" };
        this.classUnderTest().forEachValue((String each) -> concat[0] += each);
        Assert.assertEquals("zero", concat[0]);
    }

    @Override
    @Test
    public void forEachKey() {
        long[] sum = new long[4];
        this.classUnderTest().forEachKey((char each) -> sum[0] += each);
        Assert.assertEquals(0L, sum[0]);
    }

    @Override
    @Test
    public void forEachKeyValue() {
        String[] concat = { "" };
        this.classUnderTest().forEachKeyValue((char each, String parameter) -> {
            concat[0] += each;
            concat[0] += parameter;
        });
        Assert.assertEquals("\u0000zero", concat[0]);
    }

    @Override
    @Test
    public void select() {
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, "zero"), this.classUnderTest().select((char value, String object) -> value == 0));
        Verify.assertIterableEmpty(this.classUnderTest().select((char value, String object) -> value != 0));
        Assert.assertEquals(HashBag.newBagWith("zero"), this.classUnderTest().select(Predicates.equal("zero")));
        Verify.assertIterableEmpty(this.classUnderTest().select(Predicates.equal("one")));
        MutableBag<String> target = HashBag.newBag();
        Assert.assertSame(target, this.classUnderTest().select(Predicates.equal("zero"), target));
        Assert.assertEquals(HashBag.newBagWith("zero"), target);
    }

    @Override
    public void selectWith() {
        Assert.assertEquals(HashBag.newBagWith("zero"), this.classUnderTest().selectWith(Object::equals, "zero"));
        MutableBag<String> target = HashBag.newBag();
        Assert.assertSame(target, this.classUnderTest().selectWith(Object::equals, "zero", target));
        Assert.assertEquals(HashBag.newBagWith("zero"), target);
    }

    @Override
    @Test
    public void selectInstancesOf() {
        Assert.assertEquals(HashBag.newBagWith("zero"), this.classUnderTest().selectInstancesOf(String.class));
        Verify.assertIterableEmpty(this.classUnderTest().selectInstancesOf(Integer.class));
    }

    @Override
    @Test
    public void reject() {
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, "zero"), this.classUnderTest().reject((value, object) -> value != 0));
        Verify.assertIterableEmpty(this.classUnderTest().reject((value, object) -> value == 0));
        Assert.assertEquals(HashBag.newBagWith("zero"), this.classUnderTest().reject(Predicates.equal("one")));
        Verify.assertIterableEmpty(this.classUnderTest().reject(Predicates.equal("zero")));
        MutableBag<String> target = HashBag.newBag();
        Assert.assertSame(target, this.classUnderTest().reject(Predicates.equal("one"), target));
        Assert.assertEquals(HashBag.newBagWith("zero"), target);
    }

    @Override
    @Test
    public void rejectWith() {
        Assert.assertEquals(HashBag.newBagWith("zero"), this.classUnderTest().rejectWith(Object::equals, "one"));
        Verify.assertIterableEmpty(this.classUnderTest().rejectWith(Object::equals, "zero"));
        MutableBag<String> target = HashBag.newBag();
        Assert.assertSame(target, this.classUnderTest().rejectWith(Object::equals, "one", target));
        Assert.assertEquals(HashBag.newBagWith("zero"), target);
    }

    @Override
    @Test
    public void detect() {
        Assert.assertEquals("zero", this.classUnderTest().detect(Predicates.equal("zero")));
        Assert.assertNull(this.classUnderTest().detect(Predicates.equal("one")));
    }

    @Override
    @Test
    public void detectWith() {
        Assert.assertEquals("zero", this.classUnderTest().detectWith(Object::equals, "zero"));
        Assert.assertNull(this.classUnderTest().detectWith(Object::equals, "one"));
    }

    @Override
    @Test
    public void detectOptional() {
        Assert.assertEquals(Optional.of("zero"), this.classUnderTest().detectOptional(Predicates.equal("zero")));
        Assert.assertEquals(Optional.empty(), this.classUnderTest().detectOptional(Predicates.equal("one")));
    }

    @Override
    @Test
    public void detectWithOptional() {
        Assert.assertEquals(Optional.of("zero"), this.classUnderTest().detectWithOptional(Object::equals, "zero"));
        Assert.assertEquals(Optional.empty(), this.classUnderTest().detectWithOptional(Object::equals, "one"));
    }

    @Override
    @Test
    public void detectIfNone() {
        Assert.assertEquals("zero", this.classUnderTest().detectIfNone(Predicates.equal("zero"), Functions0.value("default")));
        Assert.assertEquals("default", this.classUnderTest().detectIfNone(Predicates.equal("one"), Functions0.value("default")));
    }

    @Override
    @Test
    public void detectWithIfNone() {
        Assert.assertEquals("zero", this.classUnderTest().detectWithIfNone(Object::equals, "zero", Functions0.value("default")));
        Assert.assertEquals("default", this.classUnderTest().detectWithIfNone(Object::equals, "one", Functions0.value("default")));
    }

    @Override
    @Test
    public void count() {
        Assert.assertEquals(1, this.classUnderTest().count(Predicates.equal("zero")));
        Assert.assertEquals(0, this.classUnderTest().count(Predicates.equal("one")));
    }

    @Override
    @Test
    public void countWith() {
        Assert.assertEquals(1, this.classUnderTest().countWith(Object::equals, "zero"));
        Assert.assertEquals(0, this.classUnderTest().countWith(Object::equals, "one"));
    }

    @Override
    @Test
    public void anySatisfy() {
        Verify.assertAnySatisfy(this.classUnderTest(), StringPredicates.endsWith("o"));
        Assert.assertFalse(this.classUnderTest().anySatisfy(Predicates.equal("ten")));
    }

    @Override
    @Test
    public void anySatisfyWith() {
        Assert.assertTrue(this.classUnderTest().anySatisfyWith(StringPredicates2.endsWith(), "o"));
        Assert.assertFalse(this.classUnderTest().anySatisfyWith(Object::equals, "ten"));
    }

    @Override
    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.classUnderTest().allSatisfy(StringPredicates.endsWith("o")));
        Assert.assertFalse(this.classUnderTest().allSatisfy(Predicates.equal("nine")));
    }

    @Override
    @Test
    public void allSatisfyWith() {
        Assert.assertTrue(this.classUnderTest().allSatisfyWith(StringPredicates2.contains(), "o"));
        Assert.assertFalse(this.classUnderTest().allSatisfyWith(Object::equals, "nine"));
    }

    @Override
    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.classUnderTest().noneSatisfy(StringPredicates.endsWith("o")));
        Assert.assertTrue(this.classUnderTest().noneSatisfy(Predicates.equal("ten")));
    }

    @Override
    @Test
    public void noneSatisfyWith() {
        Assert.assertTrue(this.classUnderTest().noneSatisfyWith(StringPredicates2.notContains(), "e"));
        Assert.assertFalse(this.classUnderTest().noneSatisfyWith(StringPredicates2.endsWith(), "o"));
    }

    @Override
    @Test
    public void partition() {
        PartitionIterable<String> result = this.classUnderTest().partition(StringPredicates.endsWith("ne"));
        Verify.assertIterableEmpty(result.getSelected());
        Assert.assertEquals(HashBag.newBagWith("zero"), result.getRejected());
    }

    @Override
    @Test
    public void partitionWith() {
        PartitionIterable<String> result = this.classUnderTest().partitionWith(StringPredicates2.endsWith(), "ro");
        Assert.assertEquals(HashBag.newBagWith("zero"), result.getSelected());
        Verify.assertIterableEmpty(result.getRejected());
    }

    @Test
    public void min_withComparator() {
        Assert.assertEquals("zero", this.classUnderTest().min(Comparators.naturalOrder()));
    }

    @Test
    public void max_withComparator() {
        Assert.assertEquals("zero", this.classUnderTest().max(Comparators.naturalOrder()));
    }

    @Override
    @Test
    public void minBy() {
        Assert.assertEquals("zero", this.classUnderTest().minBy(String::valueOf));
    }

    @Override
    @Test
    public void maxBy() {
        Assert.assertEquals("zero", this.classUnderTest().maxBy(String::valueOf));
    }

    @Override
    @Test
    public void min() {
        Assert.assertEquals("zero", this.classUnderTest().min());
    }

    @Override
    @Test
    public void max() {
        Assert.assertEquals("zero", this.classUnderTest().max());
    }

    @Override
    @Test
    public void sumOfInt() {
        Assert.assertEquals(4L, this.classUnderTest().sumOfInt(String::length));
    }

    @Override
    @Test
    public void sumOfFloat() {
        Assert.assertEquals(4.0d, this.classUnderTest().sumOfFloat(value -> (float) value.length()), 0.0d);
    }

    @Override
    @Test
    public void sumOfLong() {
        Assert.assertEquals(4L, this.classUnderTest().sumOfLong(value -> (long) value.length()));
    }

    @Override
    @Test
    public void sumOfDouble() {
        Assert.assertEquals(4.0d, this.classUnderTest().sumOfDouble(value -> (double) value.length()), 0.0d);
    }

    @Override
    @Test
    public void collectIf() {
        Assert.assertEquals(HashBag.newBagWith("ZERO"), this.classUnderTest().collectIf(StringPredicates.endsWith("ro"), StringFunctions.toUpperCase()));
        Verify.assertIterableEmpty(this.classUnderTest().collectIf(StringPredicates.endsWith("ne"), StringFunctions.toUpperCase()));
        MutableBag<String> target = HashBag.newBag();
        Assert.assertSame(target, this.classUnderTest().collectIf(StringPredicates.endsWith("ro"), StringFunctions.toUpperCase(), target));
        Assert.assertEquals(HashBag.newBagWith("ZERO"), target);
    }

    @Override
    @Test
    public void flatCollect() {
        Verify.assertBagsEqual(HashBag.newBagWith('z', 'e', 'r', 'o'), this.classUnderTest().flatCollect(StringIterate::toSet));
        MutableBag<Character> target = HashBag.newBag();
        Assert.assertSame(target, this.classUnderTest().flatCollect(StringIterate::toSet, target));
        Verify.assertBagsEqual(HashBag.newBagWith('z', 'e', 'r', 'o'), target);
    }

    @Override
    @Test
    public void collect() {
        Assert.assertEquals(HashBag.newBagWith("ZERO"), this.classUnderTest().collect(StringFunctions.toUpperCase()));
        MutableBag<String> target = HashBag.newBag();
        Assert.assertSame(target, this.classUnderTest().collect(StringFunctions.toUpperCase(), target));
        Assert.assertEquals(HashBag.newBagWith("ZERO"), target);
    }

    @Override
    @Test
    public void collectWith() {
        Function2<String, String, String> function = (String each, String param) -> each.toUpperCase() + param;
        Assert.assertEquals(HashBag.newBagWith("ZERO!"), this.classUnderTest().collectWith(function, "!"));
        MutableBag<String> target = HashBag.newBag();
        Assert.assertSame(target, this.classUnderTest().collectWith(function, "!", target));
        Assert.assertEquals(HashBag.newBagWith("ZERO!"), target);
    }

    @Override
    @Test
    public void collectBoolean() {
        Assert.assertEquals(BooleanHashBag.newBagWith(true), this.newWithKeysValues((char) 0, "true").collectBoolean(StringFunctions.toPrimitiveBoolean()));
    }

    @Override
    @Test
    public void collectBoolean_withTarget() {
        MutableBooleanBag target = new BooleanHashBag();
        Assert.assertSame(target, this.newWithKeysValues((char) 0, "true").collectBoolean(StringFunctions.toPrimitiveBoolean(), target));
        Assert.assertEquals(BooleanHashBag.newBagWith(true), target);
    }

    @Override
    @Test
    public void collectByte() {
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 0), this.newWithKeysValues((char) 0, "0").collectByte(Byte::parseByte));
    }

    @Override
    @Test
    public void collectByte_withTarget() {
        MutableByteBag target = new ByteHashBag();
        Assert.assertSame(target, this.newWithKeysValues((char) 0, "0").collectByte(Byte::parseByte, target));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 0), target);
    }

    @Override
    @Test
    public void collectChar() {
        Assert.assertEquals(CharHashBag.newBagWith((char) 0), this.newWithKeysValues((char) 0, "0").collectChar(StringFunctions.toPrimitiveChar()));
    }

    @Override
    @Test
    public void collectChar_withTarget() {
        MutableCharBag target = new CharHashBag();
        Assert.assertSame(target, this.newWithKeysValues((char) 0, "0").collectChar(StringFunctions.toPrimitiveChar(), target));
        Assert.assertEquals(CharHashBag.newBagWith((char) 0), target);
    }

    @Override
    @Test
    public void collectDouble() {
        Assert.assertEquals(DoubleHashBag.newBagWith((double) 0), this.newWithKeysValues((char) 0, "0").collectDouble(Double::parseDouble));
    }

    @Override
    @Test
    public void collectDouble_withTarget() {
        MutableDoubleBag target = new DoubleHashBag();
        Assert.assertSame(target, this.newWithKeysValues((char) 0, "0").collectDouble(Double::parseDouble, target));
        Assert.assertEquals(DoubleHashBag.newBagWith((double) 0), target);
    }

    @Override
    @Test
    public void collectFloat() {
        Assert.assertEquals(FloatHashBag.newBagWith((float) 0), this.newWithKeysValues((char) 0, "0").collectFloat(Float::parseFloat));
    }

    @Override
    @Test
    public void collectFloat_withTarget() {
        MutableFloatBag target = new FloatHashBag();
        Assert.assertSame(target, this.newWithKeysValues((char) 0, "0").collectFloat(Float::parseFloat, target));
        Assert.assertEquals(FloatHashBag.newBagWith((float) 0), target);
    }

    @Override
    @Test
    public void collectInt() {
        Assert.assertEquals(IntHashBag.newBagWith((int) 0), this.newWithKeysValues((char) 0, "0").collectInt(Integer::parseInt));
    }

    @Override
    @Test
    public void collectInt_withTarget() {
        MutableIntBag target = new IntHashBag();
        Assert.assertSame(target, this.newWithKeysValues((char) 0, "0").collectInt(Integer::parseInt, target));
        Assert.assertEquals(IntHashBag.newBagWith((int) 0), target);
    }

    @Override
    @Test
    public void collectLong() {
        Assert.assertEquals(LongHashBag.newBagWith(0L), this.newWithKeysValues((char) 0, "0").collectLong(Long::parseLong));
    }

    @Override
    @Test
    public void collectLong_withTarget() {
        MutableLongBag target = new LongHashBag();
        Assert.assertSame(target, this.newWithKeysValues((char) 0, "0").collectLong(Long::parseLong, target));
        Assert.assertEquals(LongHashBag.newBagWith(0L), target);
    }

    @Override
    @Test
    public void collectShort() {
        Assert.assertEquals(ShortHashBag.newBagWith((short) 0), this.newWithKeysValues((char) 0, "0").collectShort(Short::parseShort));
    }

    @Override
    @Test
    public void collectShort_withTarget() {
        MutableShortBag target = new ShortHashBag();
        Assert.assertSame(target, this.newWithKeysValues((char) 0, "0").collectShort(Short::parseShort, target));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 0), target);
    }

    @Override
    @Test
    public void toSortedBag() {
        ImmutableCharObjectMap<String> map1 = this.classUnderTest();
        ImmutableCharObjectMap<String> map2 = this.classUnderTest();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith("zero"), map1.toSortedBag());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparator.<String>reverseOrder(), "zero"), map2.toSortedBag(Comparator.<String>reverseOrder()));
    }

    @Override
    @Test
    public void toSortedBagBy() {
        ImmutableCharObjectMap<String> map1 = this.classUnderTest();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.byFunction(String::valueOf), "zero"), map1.toSortedBagBy(String::valueOf));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableCharObjectSingletonMapTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intInjectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longInjectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatInjectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleInjectInto);
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
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoKeyValue);
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
        public void benchmark_getOnly_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_not_only_one_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_not_only_one_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAny() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAny);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNone);
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
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_throws_negative_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_throws_negative_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_throws_zero_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_throws_zero_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateInPlaceBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateInPlaceBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_1);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_2);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_3() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_3);
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
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArguments);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
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
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_withComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_withComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_withComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_withComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
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
        public void benchmark_sumOfInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableCharObjectSingletonMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> selectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> intInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> longInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> floatInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> doubleInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> toImmutableSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> toImmutableSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> toImmutableSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> min_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> max_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> rejectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> containsAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> containsNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> chunk_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> chunk_throws_zero_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> groupByUniqueKey_target_throws_1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> groupByUniqueKey_target_throws_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> groupByUniqueKey_target_throws_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> min_withComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> max_withComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> collectBoolean_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> collectByte_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> collectChar_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> collectDouble_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> collectFloat_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> collectInt_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> collectLong_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> collectShort_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharObjectSingletonMapTest> toSortedBagBy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = ImmutableCharObjectSingletonMapTest::values;
            this.payloads.selectWith = ImmutableCharObjectSingletonMapTest::selectWith;
            this.payloads.selectWith_withTarget = ImmutableCharObjectSingletonMapTest::selectWith_withTarget;
            this.payloads.collectWithTarget = ImmutableCharObjectSingletonMapTest::collectWithTarget;
            this.payloads.injectInto = ImmutableCharObjectSingletonMapTest::injectInto;
            this.payloads.intInjectInto = ImmutableCharObjectSingletonMapTest::intInjectInto;
            this.payloads.longInjectInto = ImmutableCharObjectSingletonMapTest::longInjectInto;
            this.payloads.floatInjectInto = ImmutableCharObjectSingletonMapTest::floatInjectInto;
            this.payloads.doubleInjectInto = ImmutableCharObjectSingletonMapTest::doubleInjectInto;
            this.payloads.toList = ImmutableCharObjectSingletonMapTest::toList;
            this.payloads.toSortedList = ImmutableCharObjectSingletonMapTest::toSortedList;
            this.payloads.toSet = ImmutableCharObjectSingletonMapTest::toSet;
            this.payloads.toSortedSet = ImmutableCharObjectSingletonMapTest::toSortedSet;
            this.payloads.toBag = ImmutableCharObjectSingletonMapTest::toBag;
            this.payloads.toMap = ImmutableCharObjectSingletonMapTest::toMap;
            this.payloads.toMapTarget = ImmutableCharObjectSingletonMapTest::toMapTarget;
            this.payloads.toSortedMap = ImmutableCharObjectSingletonMapTest::toSortedMap;
            this.payloads.toImmutableList = ImmutableCharObjectSingletonMapTest::toImmutableList;
            this.payloads.toImmutableSortedList = ImmutableCharObjectSingletonMapTest::toImmutableSortedList;
            this.payloads.toImmutableSet = ImmutableCharObjectSingletonMapTest::toImmutableSet;
            this.payloads.toImmutableSortedSet = ImmutableCharObjectSingletonMapTest::toImmutableSortedSet;
            this.payloads.toImmutableBag = ImmutableCharObjectSingletonMapTest::toImmutableBag;
            this.payloads.toImmutableSortedBag = ImmutableCharObjectSingletonMapTest::toImmutableSortedBag;
            this.payloads.toImmutableSortedBagBy = ImmutableCharObjectSingletonMapTest::toImmutableSortedBagBy;
            this.payloads.toArray = ImmutableCharObjectSingletonMapTest::toArray;
            this.payloads.min_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharObjectSingletonMapTest::min_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.max_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharObjectSingletonMapTest::max_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.sumByInt = ImmutableCharObjectSingletonMapTest::sumByInt;
            this.payloads.sumByFloat = ImmutableCharObjectSingletonMapTest::sumByFloat;
            this.payloads.sumByLong = ImmutableCharObjectSingletonMapTest::sumByLong;
            this.payloads.sumByDouble = ImmutableCharObjectSingletonMapTest::sumByDouble;
            this.payloads.keysView = ImmutableCharObjectSingletonMapTest::keysView;
            this.payloads.rejectWith_withTarget = ImmutableCharObjectSingletonMapTest::rejectWith_withTarget;
            this.payloads.injectIntoKeyValue = ImmutableCharObjectSingletonMapTest::injectIntoKeyValue;
            this.payloads.size = ImmutableCharObjectSingletonMapTest::size;
            this.payloads.isEmpty = ImmutableCharObjectSingletonMapTest::isEmpty;
            this.payloads.notEmpty = ImmutableCharObjectSingletonMapTest::notEmpty;
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharObjectSingletonMapTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharObjectSingletonMapTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.containsAnyIterable = ImmutableCharObjectSingletonMapTest::containsAnyIterable;
            this.payloads.containsAny = ImmutableCharObjectSingletonMapTest::containsAny;
            this.payloads.containsNoneIterable = ImmutableCharObjectSingletonMapTest::containsNoneIterable;
            this.payloads.containsNone = ImmutableCharObjectSingletonMapTest::containsNone;
            this.payloads.testEquals = ImmutableCharObjectSingletonMapTest::testEquals;
            this.payloads.testHashCode = ImmutableCharObjectSingletonMapTest::testHashCode;
            this.payloads.testToString = ImmutableCharObjectSingletonMapTest::testToString;
            this.payloads.zip = ImmutableCharObjectSingletonMapTest::zip;
            this.payloads.zipWithIndex = ImmutableCharObjectSingletonMapTest::zipWithIndex;
            this.payloads.chunk = ImmutableCharObjectSingletonMapTest::chunk;
            this.payloads.chunk_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharObjectSingletonMapTest::chunk_throws_negative_size, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_throws_zero_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharObjectSingletonMapTest::chunk_throws_zero_size, java.lang.IllegalArgumentException.class);
            this.payloads.aggregateInPlaceBy = ImmutableCharObjectSingletonMapTest::aggregateInPlaceBy;
            this.payloads.aggregateBy = ImmutableCharObjectSingletonMapTest::aggregateBy;
            this.payloads.groupBy = ImmutableCharObjectSingletonMapTest::groupBy;
            this.payloads.groupByEach = ImmutableCharObjectSingletonMapTest::groupByEach;
            this.payloads.groupByUniqueKey = ImmutableCharObjectSingletonMapTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharObjectSingletonMapTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ImmutableCharObjectSingletonMapTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_1 = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharObjectSingletonMapTest::groupByUniqueKey_target_throws_1, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_2 = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharObjectSingletonMapTest::groupByUniqueKey_target_throws_2, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_3 = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharObjectSingletonMapTest::groupByUniqueKey_target_throws_3, java.lang.IllegalStateException.class);
            this.payloads.makeString = ImmutableCharObjectSingletonMapTest::makeString;
            this.payloads.appendString = ImmutableCharObjectSingletonMapTest::appendString;
            this.payloads.stream = ImmutableCharObjectSingletonMapTest::stream;
            this.payloads.parallelStream = ImmutableCharObjectSingletonMapTest::parallelStream;
            this.payloads.toImmutable = ImmutableCharObjectSingletonMapTest::toImmutable;
            this.payloads.keySet = ImmutableCharObjectSingletonMapTest::keySet;
            this.payloads.flipUniqueValues = ImmutableCharObjectSingletonMapTest::flipUniqueValues;
            this.payloads.containsValue = ImmutableCharObjectSingletonMapTest::containsValue;
            this.payloads.contains = ImmutableCharObjectSingletonMapTest::contains;
            this.payloads.containsAllIterable = ImmutableCharObjectSingletonMapTest::containsAllIterable;
            this.payloads.containsAll = ImmutableCharObjectSingletonMapTest::containsAll;
            this.payloads.containsAllArguments = ImmutableCharObjectSingletonMapTest::containsAllArguments;
            this.payloads.containsKey = ImmutableCharObjectSingletonMapTest::containsKey;
            this.payloads.getIfAbsent = ImmutableCharObjectSingletonMapTest::getIfAbsent;
            this.payloads.get = ImmutableCharObjectSingletonMapTest::get;
            this.payloads.iterator = ImmutableCharObjectSingletonMapTest::iterator;
            this.payloads.getFirst = ImmutableCharObjectSingletonMapTest::getFirst;
            this.payloads.getLast = ImmutableCharObjectSingletonMapTest::getLast;
            this.payloads.getOnly = ImmutableCharObjectSingletonMapTest::getOnly;
            this.payloads.tap = ImmutableCharObjectSingletonMapTest::tap;
            this.payloads.forEach = ImmutableCharObjectSingletonMapTest::forEach;
            this.payloads.forEachWithIndex = ImmutableCharObjectSingletonMapTest::forEachWithIndex;
            this.payloads.forEachWith = ImmutableCharObjectSingletonMapTest::forEachWith;
            this.payloads.forEachValue = ImmutableCharObjectSingletonMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableCharObjectSingletonMapTest::forEachKey;
            this.payloads.forEachKeyValue = ImmutableCharObjectSingletonMapTest::forEachKeyValue;
            this.payloads.select = ImmutableCharObjectSingletonMapTest::select;
            this.payloads.selectInstancesOf = ImmutableCharObjectSingletonMapTest::selectInstancesOf;
            this.payloads.reject = ImmutableCharObjectSingletonMapTest::reject;
            this.payloads.rejectWith = ImmutableCharObjectSingletonMapTest::rejectWith;
            this.payloads.detect = ImmutableCharObjectSingletonMapTest::detect;
            this.payloads.detectWith = ImmutableCharObjectSingletonMapTest::detectWith;
            this.payloads.detectOptional = ImmutableCharObjectSingletonMapTest::detectOptional;
            this.payloads.detectWithOptional = ImmutableCharObjectSingletonMapTest::detectWithOptional;
            this.payloads.detectIfNone = ImmutableCharObjectSingletonMapTest::detectIfNone;
            this.payloads.detectWithIfNone = ImmutableCharObjectSingletonMapTest::detectWithIfNone;
            this.payloads.count = ImmutableCharObjectSingletonMapTest::count;
            this.payloads.countWith = ImmutableCharObjectSingletonMapTest::countWith;
            this.payloads.anySatisfy = ImmutableCharObjectSingletonMapTest::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableCharObjectSingletonMapTest::anySatisfyWith;
            this.payloads.allSatisfy = ImmutableCharObjectSingletonMapTest::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableCharObjectSingletonMapTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableCharObjectSingletonMapTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableCharObjectSingletonMapTest::noneSatisfyWith;
            this.payloads.partition = ImmutableCharObjectSingletonMapTest::partition;
            this.payloads.partitionWith = ImmutableCharObjectSingletonMapTest::partitionWith;
            this.payloads.min_withComparator = ImmutableCharObjectSingletonMapTest::min_withComparator;
            this.payloads.max_withComparator = ImmutableCharObjectSingletonMapTest::max_withComparator;
            this.payloads.minBy = ImmutableCharObjectSingletonMapTest::minBy;
            this.payloads.maxBy = ImmutableCharObjectSingletonMapTest::maxBy;
            this.payloads.min = ImmutableCharObjectSingletonMapTest::min;
            this.payloads.max = ImmutableCharObjectSingletonMapTest::max;
            this.payloads.sumOfInt = ImmutableCharObjectSingletonMapTest::sumOfInt;
            this.payloads.sumOfFloat = ImmutableCharObjectSingletonMapTest::sumOfFloat;
            this.payloads.sumOfLong = ImmutableCharObjectSingletonMapTest::sumOfLong;
            this.payloads.sumOfDouble = ImmutableCharObjectSingletonMapTest::sumOfDouble;
            this.payloads.collectIf = ImmutableCharObjectSingletonMapTest::collectIf;
            this.payloads.flatCollect = ImmutableCharObjectSingletonMapTest::flatCollect;
            this.payloads.collect = ImmutableCharObjectSingletonMapTest::collect;
            this.payloads.collectWith = ImmutableCharObjectSingletonMapTest::collectWith;
            this.payloads.collectBoolean = ImmutableCharObjectSingletonMapTest::collectBoolean;
            this.payloads.collectBoolean_withTarget = ImmutableCharObjectSingletonMapTest::collectBoolean_withTarget;
            this.payloads.collectByte = ImmutableCharObjectSingletonMapTest::collectByte;
            this.payloads.collectByte_withTarget = ImmutableCharObjectSingletonMapTest::collectByte_withTarget;
            this.payloads.collectChar = ImmutableCharObjectSingletonMapTest::collectChar;
            this.payloads.collectChar_withTarget = ImmutableCharObjectSingletonMapTest::collectChar_withTarget;
            this.payloads.collectDouble = ImmutableCharObjectSingletonMapTest::collectDouble;
            this.payloads.collectDouble_withTarget = ImmutableCharObjectSingletonMapTest::collectDouble_withTarget;
            this.payloads.collectFloat = ImmutableCharObjectSingletonMapTest::collectFloat;
            this.payloads.collectFloat_withTarget = ImmutableCharObjectSingletonMapTest::collectFloat_withTarget;
            this.payloads.collectInt = ImmutableCharObjectSingletonMapTest::collectInt;
            this.payloads.collectInt_withTarget = ImmutableCharObjectSingletonMapTest::collectInt_withTarget;
            this.payloads.collectLong = ImmutableCharObjectSingletonMapTest::collectLong;
            this.payloads.collectLong_withTarget = ImmutableCharObjectSingletonMapTest::collectLong_withTarget;
            this.payloads.collectShort = ImmutableCharObjectSingletonMapTest::collectShort;
            this.payloads.collectShort_withTarget = ImmutableCharObjectSingletonMapTest::collectShort_withTarget;
            this.payloads.toSortedBag = ImmutableCharObjectSingletonMapTest::toSortedBag;
            this.payloads.toSortedBagBy = ImmutableCharObjectSingletonMapTest::toSortedBagBy;
        }
    }
}
