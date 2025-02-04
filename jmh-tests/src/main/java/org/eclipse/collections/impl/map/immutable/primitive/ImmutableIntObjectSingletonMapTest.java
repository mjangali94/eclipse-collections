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
import org.eclipse.collections.api.map.primitive.ImmutableIntObjectMap;
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
import org.eclipse.collections.impl.map.mutable.primitive.IntObjectHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.StringIterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableIntObjectSingletonMap}.
 * This file was automatically generated from template file immutablePrimitiveObjectSingletonMapTest.stg.
 */
public class ImmutableIntObjectSingletonMapTest extends AbstractImmutableIntObjectMapTestCase {

    @Override
    protected ImmutableIntObjectMap<String> classUnderTest() {
        return IntObjectHashMap.newWithKeysValues(0, "zero").toImmutable();
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
        Assert.assertTrue(this.classUnderTest().containsKey(0));
        Assert.assertFalse(this.classUnderTest().containsKey(31));
        Assert.assertFalse(this.classUnderTest().containsKey(32));
        Assert.assertFalse(this.classUnderTest().containsKey(1));
        Assert.assertFalse(this.classUnderTest().containsKey(5));
        Assert.assertFalse(this.classUnderTest().containsKey(35));
    }

    @Override
    @Test
    public void getIfAbsent() {
        Function0<String> ifAbsent = () -> "ifAbsent";
        Assert.assertEquals("zero", this.classUnderTest().getIfAbsent(0, ifAbsent));
        Assert.assertEquals("ifAbsent", this.classUnderTest().getIfAbsent(31, ifAbsent));
        Assert.assertEquals("ifAbsent", this.classUnderTest().getIfAbsent(32, ifAbsent));
        Assert.assertEquals("ifAbsent", this.classUnderTest().getIfAbsent(1, ifAbsent));
        Assert.assertEquals("ifAbsent", this.classUnderTest().getIfAbsent(33, ifAbsent));
    }

    @Override
    @Test
    public void get() {
        Assert.assertEquals("zero", this.classUnderTest().get(0));
        Assert.assertNull(this.classUnderTest().get(31));
        Assert.assertNull(this.classUnderTest().get(32));
        Assert.assertNull(this.classUnderTest().get(1));
        Assert.assertNull(this.classUnderTest().get(33));
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
        ImmutableIntObjectMap<String> map = this.classUnderTest();
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
        this.classUnderTest().forEachKey((int each) -> sum[0] += each);
        Assert.assertEquals(0L, sum[0]);
    }

    @Override
    @Test
    public void forEachKeyValue() {
        String[] concat = { "" };
        this.classUnderTest().forEachKeyValue((int each, String parameter) -> {
            concat[0] += each;
            concat[0] += parameter;
        });
        Assert.assertEquals("0zero", concat[0]);
    }

    @Override
    @Test
    public void select() {
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, "zero"), this.classUnderTest().select((int value, String object) -> value == 0));
        Verify.assertIterableEmpty(this.classUnderTest().select((int value, String object) -> value != 0));
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
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, "zero"), this.classUnderTest().reject((value, object) -> value != 0));
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
        Assert.assertEquals(BooleanHashBag.newBagWith(true), this.newWithKeysValues(0, "true").collectBoolean(StringFunctions.toPrimitiveBoolean()));
    }

    @Override
    @Test
    public void collectBoolean_withTarget() {
        MutableBooleanBag target = new BooleanHashBag();
        Assert.assertSame(target, this.newWithKeysValues(0, "true").collectBoolean(StringFunctions.toPrimitiveBoolean(), target));
        Assert.assertEquals(BooleanHashBag.newBagWith(true), target);
    }

    @Override
    @Test
    public void collectByte() {
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 0), this.newWithKeysValues(0, "0").collectByte(Byte::parseByte));
    }

    @Override
    @Test
    public void collectByte_withTarget() {
        MutableByteBag target = new ByteHashBag();
        Assert.assertSame(target, this.newWithKeysValues(0, "0").collectByte(Byte::parseByte, target));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 0), target);
    }

    @Override
    @Test
    public void collectChar() {
        Assert.assertEquals(CharHashBag.newBagWith((char) 0), this.newWithKeysValues(0, "0").collectChar(StringFunctions.toPrimitiveChar()));
    }

    @Override
    @Test
    public void collectChar_withTarget() {
        MutableCharBag target = new CharHashBag();
        Assert.assertSame(target, this.newWithKeysValues(0, "0").collectChar(StringFunctions.toPrimitiveChar(), target));
        Assert.assertEquals(CharHashBag.newBagWith((char) 0), target);
    }

    @Override
    @Test
    public void collectDouble() {
        Assert.assertEquals(DoubleHashBag.newBagWith((double) 0), this.newWithKeysValues(0, "0").collectDouble(Double::parseDouble));
    }

    @Override
    @Test
    public void collectDouble_withTarget() {
        MutableDoubleBag target = new DoubleHashBag();
        Assert.assertSame(target, this.newWithKeysValues(0, "0").collectDouble(Double::parseDouble, target));
        Assert.assertEquals(DoubleHashBag.newBagWith((double) 0), target);
    }

    @Override
    @Test
    public void collectFloat() {
        Assert.assertEquals(FloatHashBag.newBagWith((float) 0), this.newWithKeysValues(0, "0").collectFloat(Float::parseFloat));
    }

    @Override
    @Test
    public void collectFloat_withTarget() {
        MutableFloatBag target = new FloatHashBag();
        Assert.assertSame(target, this.newWithKeysValues(0, "0").collectFloat(Float::parseFloat, target));
        Assert.assertEquals(FloatHashBag.newBagWith((float) 0), target);
    }

    @Override
    @Test
    public void collectInt() {
        Assert.assertEquals(IntHashBag.newBagWith((int) 0), this.newWithKeysValues(0, "0").collectInt(Integer::parseInt));
    }

    @Override
    @Test
    public void collectInt_withTarget() {
        MutableIntBag target = new IntHashBag();
        Assert.assertSame(target, this.newWithKeysValues(0, "0").collectInt(Integer::parseInt, target));
        Assert.assertEquals(IntHashBag.newBagWith((int) 0), target);
    }

    @Override
    @Test
    public void collectLong() {
        Assert.assertEquals(LongHashBag.newBagWith(0L), this.newWithKeysValues(0, "0").collectLong(Long::parseLong));
    }

    @Override
    @Test
    public void collectLong_withTarget() {
        MutableLongBag target = new LongHashBag();
        Assert.assertSame(target, this.newWithKeysValues(0, "0").collectLong(Long::parseLong, target));
        Assert.assertEquals(LongHashBag.newBagWith(0L), target);
    }

    @Override
    @Test
    public void collectShort() {
        Assert.assertEquals(ShortHashBag.newBagWith((short) 0), this.newWithKeysValues(0, "0").collectShort(Short::parseShort));
    }

    @Override
    @Test
    public void collectShort_withTarget() {
        MutableShortBag target = new ShortHashBag();
        Assert.assertSame(target, this.newWithKeysValues(0, "0").collectShort(Short::parseShort, target));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 0), target);
    }

    @Override
    @Test
    public void toSortedBag() {
        ImmutableIntObjectMap<String> map1 = this.classUnderTest();
        ImmutableIntObjectMap<String> map2 = this.classUnderTest();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith("zero"), map1.toSortedBag());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparator.<String>reverseOrder(), "zero"), map2.toSortedBag(Comparator.<String>reverseOrder()));
    }

    @Override
    @Test
    public void toSortedBagBy() {
        ImmutableIntObjectMap<String> map1 = this.classUnderTest();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.byFunction(String::valueOf), "zero"), map1.toSortedBagBy(String::valueOf));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableIntObjectSingletonMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableIntObjectSingletonMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> selectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> intInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> longInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> floatInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> doubleInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> toImmutableSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> toImmutableSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> toImmutableSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> min_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> max_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> rejectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> containsAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> containsNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> chunk_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> chunk_throws_zero_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> groupByUniqueKey_target_throws_1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> groupByUniqueKey_target_throws_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> groupByUniqueKey_target_throws_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> min_withComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> max_withComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> collectBoolean_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> collectByte_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> collectChar_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> collectDouble_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> collectFloat_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> collectInt_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> collectLong_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> collectShort_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntObjectSingletonMapTest> toSortedBagBy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = ImmutableIntObjectSingletonMapTest::values;
            this.payloads.selectWith = ImmutableIntObjectSingletonMapTest::selectWith;
            this.payloads.selectWith_withTarget = ImmutableIntObjectSingletonMapTest::selectWith_withTarget;
            this.payloads.collectWithTarget = ImmutableIntObjectSingletonMapTest::collectWithTarget;
            this.payloads.injectInto = ImmutableIntObjectSingletonMapTest::injectInto;
            this.payloads.intInjectInto = ImmutableIntObjectSingletonMapTest::intInjectInto;
            this.payloads.longInjectInto = ImmutableIntObjectSingletonMapTest::longInjectInto;
            this.payloads.floatInjectInto = ImmutableIntObjectSingletonMapTest::floatInjectInto;
            this.payloads.doubleInjectInto = ImmutableIntObjectSingletonMapTest::doubleInjectInto;
            this.payloads.toList = ImmutableIntObjectSingletonMapTest::toList;
            this.payloads.toSortedList = ImmutableIntObjectSingletonMapTest::toSortedList;
            this.payloads.toSet = ImmutableIntObjectSingletonMapTest::toSet;
            this.payloads.toSortedSet = ImmutableIntObjectSingletonMapTest::toSortedSet;
            this.payloads.toBag = ImmutableIntObjectSingletonMapTest::toBag;
            this.payloads.toMap = ImmutableIntObjectSingletonMapTest::toMap;
            this.payloads.toMapTarget = ImmutableIntObjectSingletonMapTest::toMapTarget;
            this.payloads.toSortedMap = ImmutableIntObjectSingletonMapTest::toSortedMap;
            this.payloads.toImmutableList = ImmutableIntObjectSingletonMapTest::toImmutableList;
            this.payloads.toImmutableSortedList = ImmutableIntObjectSingletonMapTest::toImmutableSortedList;
            this.payloads.toImmutableSet = ImmutableIntObjectSingletonMapTest::toImmutableSet;
            this.payloads.toImmutableSortedSet = ImmutableIntObjectSingletonMapTest::toImmutableSortedSet;
            this.payloads.toImmutableBag = ImmutableIntObjectSingletonMapTest::toImmutableBag;
            this.payloads.toImmutableSortedBag = ImmutableIntObjectSingletonMapTest::toImmutableSortedBag;
            this.payloads.toImmutableSortedBagBy = ImmutableIntObjectSingletonMapTest::toImmutableSortedBagBy;
            this.payloads.toArray = ImmutableIntObjectSingletonMapTest::toArray;
            this.payloads.min_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntObjectSingletonMapTest::min_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.max_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntObjectSingletonMapTest::max_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.sumByInt = ImmutableIntObjectSingletonMapTest::sumByInt;
            this.payloads.sumByFloat = ImmutableIntObjectSingletonMapTest::sumByFloat;
            this.payloads.sumByLong = ImmutableIntObjectSingletonMapTest::sumByLong;
            this.payloads.sumByDouble = ImmutableIntObjectSingletonMapTest::sumByDouble;
            this.payloads.keysView = ImmutableIntObjectSingletonMapTest::keysView;
            this.payloads.rejectWith_withTarget = ImmutableIntObjectSingletonMapTest::rejectWith_withTarget;
            this.payloads.injectIntoKeyValue = ImmutableIntObjectSingletonMapTest::injectIntoKeyValue;
            this.payloads.size = ImmutableIntObjectSingletonMapTest::size;
            this.payloads.isEmpty = ImmutableIntObjectSingletonMapTest::isEmpty;
            this.payloads.notEmpty = ImmutableIntObjectSingletonMapTest::notEmpty;
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntObjectSingletonMapTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntObjectSingletonMapTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.containsAnyIterable = ImmutableIntObjectSingletonMapTest::containsAnyIterable;
            this.payloads.containsAny = ImmutableIntObjectSingletonMapTest::containsAny;
            this.payloads.containsNoneIterable = ImmutableIntObjectSingletonMapTest::containsNoneIterable;
            this.payloads.containsNone = ImmutableIntObjectSingletonMapTest::containsNone;
            this.payloads.testEquals = ImmutableIntObjectSingletonMapTest::testEquals;
            this.payloads.testHashCode = ImmutableIntObjectSingletonMapTest::testHashCode;
            this.payloads.testToString = ImmutableIntObjectSingletonMapTest::testToString;
            this.payloads.zip = ImmutableIntObjectSingletonMapTest::zip;
            this.payloads.zipWithIndex = ImmutableIntObjectSingletonMapTest::zipWithIndex;
            this.payloads.chunk = ImmutableIntObjectSingletonMapTest::chunk;
            this.payloads.chunk_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntObjectSingletonMapTest::chunk_throws_negative_size, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_throws_zero_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntObjectSingletonMapTest::chunk_throws_zero_size, java.lang.IllegalArgumentException.class);
            this.payloads.aggregateInPlaceBy = ImmutableIntObjectSingletonMapTest::aggregateInPlaceBy;
            this.payloads.aggregateBy = ImmutableIntObjectSingletonMapTest::aggregateBy;
            this.payloads.groupBy = ImmutableIntObjectSingletonMapTest::groupBy;
            this.payloads.groupByEach = ImmutableIntObjectSingletonMapTest::groupByEach;
            this.payloads.groupByUniqueKey = ImmutableIntObjectSingletonMapTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntObjectSingletonMapTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ImmutableIntObjectSingletonMapTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_1 = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntObjectSingletonMapTest::groupByUniqueKey_target_throws_1, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_2 = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntObjectSingletonMapTest::groupByUniqueKey_target_throws_2, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_3 = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntObjectSingletonMapTest::groupByUniqueKey_target_throws_3, java.lang.IllegalStateException.class);
            this.payloads.makeString = ImmutableIntObjectSingletonMapTest::makeString;
            this.payloads.appendString = ImmutableIntObjectSingletonMapTest::appendString;
            this.payloads.stream = ImmutableIntObjectSingletonMapTest::stream;
            this.payloads.parallelStream = ImmutableIntObjectSingletonMapTest::parallelStream;
            this.payloads.toImmutable = ImmutableIntObjectSingletonMapTest::toImmutable;
            this.payloads.keySet = ImmutableIntObjectSingletonMapTest::keySet;
            this.payloads.flipUniqueValues = ImmutableIntObjectSingletonMapTest::flipUniqueValues;
            this.payloads.containsValue = ImmutableIntObjectSingletonMapTest::containsValue;
            this.payloads.contains = ImmutableIntObjectSingletonMapTest::contains;
            this.payloads.containsAllIterable = ImmutableIntObjectSingletonMapTest::containsAllIterable;
            this.payloads.containsAll = ImmutableIntObjectSingletonMapTest::containsAll;
            this.payloads.containsAllArguments = ImmutableIntObjectSingletonMapTest::containsAllArguments;
            this.payloads.containsKey = ImmutableIntObjectSingletonMapTest::containsKey;
            this.payloads.getIfAbsent = ImmutableIntObjectSingletonMapTest::getIfAbsent;
            this.payloads.get = ImmutableIntObjectSingletonMapTest::get;
            this.payloads.iterator = ImmutableIntObjectSingletonMapTest::iterator;
            this.payloads.getFirst = ImmutableIntObjectSingletonMapTest::getFirst;
            this.payloads.getLast = ImmutableIntObjectSingletonMapTest::getLast;
            this.payloads.getOnly = ImmutableIntObjectSingletonMapTest::getOnly;
            this.payloads.tap = ImmutableIntObjectSingletonMapTest::tap;
            this.payloads.forEach = ImmutableIntObjectSingletonMapTest::forEach;
            this.payloads.forEachWithIndex = ImmutableIntObjectSingletonMapTest::forEachWithIndex;
            this.payloads.forEachWith = ImmutableIntObjectSingletonMapTest::forEachWith;
            this.payloads.forEachValue = ImmutableIntObjectSingletonMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableIntObjectSingletonMapTest::forEachKey;
            this.payloads.forEachKeyValue = ImmutableIntObjectSingletonMapTest::forEachKeyValue;
            this.payloads.select = ImmutableIntObjectSingletonMapTest::select;
            this.payloads.selectInstancesOf = ImmutableIntObjectSingletonMapTest::selectInstancesOf;
            this.payloads.reject = ImmutableIntObjectSingletonMapTest::reject;
            this.payloads.rejectWith = ImmutableIntObjectSingletonMapTest::rejectWith;
            this.payloads.detect = ImmutableIntObjectSingletonMapTest::detect;
            this.payloads.detectWith = ImmutableIntObjectSingletonMapTest::detectWith;
            this.payloads.detectOptional = ImmutableIntObjectSingletonMapTest::detectOptional;
            this.payloads.detectWithOptional = ImmutableIntObjectSingletonMapTest::detectWithOptional;
            this.payloads.detectIfNone = ImmutableIntObjectSingletonMapTest::detectIfNone;
            this.payloads.detectWithIfNone = ImmutableIntObjectSingletonMapTest::detectWithIfNone;
            this.payloads.count = ImmutableIntObjectSingletonMapTest::count;
            this.payloads.countWith = ImmutableIntObjectSingletonMapTest::countWith;
            this.payloads.anySatisfy = ImmutableIntObjectSingletonMapTest::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableIntObjectSingletonMapTest::anySatisfyWith;
            this.payloads.allSatisfy = ImmutableIntObjectSingletonMapTest::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableIntObjectSingletonMapTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableIntObjectSingletonMapTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableIntObjectSingletonMapTest::noneSatisfyWith;
            this.payloads.partition = ImmutableIntObjectSingletonMapTest::partition;
            this.payloads.partitionWith = ImmutableIntObjectSingletonMapTest::partitionWith;
            this.payloads.min_withComparator = ImmutableIntObjectSingletonMapTest::min_withComparator;
            this.payloads.max_withComparator = ImmutableIntObjectSingletonMapTest::max_withComparator;
            this.payloads.minBy = ImmutableIntObjectSingletonMapTest::minBy;
            this.payloads.maxBy = ImmutableIntObjectSingletonMapTest::maxBy;
            this.payloads.min = ImmutableIntObjectSingletonMapTest::min;
            this.payloads.max = ImmutableIntObjectSingletonMapTest::max;
            this.payloads.sumOfInt = ImmutableIntObjectSingletonMapTest::sumOfInt;
            this.payloads.sumOfFloat = ImmutableIntObjectSingletonMapTest::sumOfFloat;
            this.payloads.sumOfLong = ImmutableIntObjectSingletonMapTest::sumOfLong;
            this.payloads.sumOfDouble = ImmutableIntObjectSingletonMapTest::sumOfDouble;
            this.payloads.collectIf = ImmutableIntObjectSingletonMapTest::collectIf;
            this.payloads.flatCollect = ImmutableIntObjectSingletonMapTest::flatCollect;
            this.payloads.collect = ImmutableIntObjectSingletonMapTest::collect;
            this.payloads.collectWith = ImmutableIntObjectSingletonMapTest::collectWith;
            this.payloads.collectBoolean = ImmutableIntObjectSingletonMapTest::collectBoolean;
            this.payloads.collectBoolean_withTarget = ImmutableIntObjectSingletonMapTest::collectBoolean_withTarget;
            this.payloads.collectByte = ImmutableIntObjectSingletonMapTest::collectByte;
            this.payloads.collectByte_withTarget = ImmutableIntObjectSingletonMapTest::collectByte_withTarget;
            this.payloads.collectChar = ImmutableIntObjectSingletonMapTest::collectChar;
            this.payloads.collectChar_withTarget = ImmutableIntObjectSingletonMapTest::collectChar_withTarget;
            this.payloads.collectDouble = ImmutableIntObjectSingletonMapTest::collectDouble;
            this.payloads.collectDouble_withTarget = ImmutableIntObjectSingletonMapTest::collectDouble_withTarget;
            this.payloads.collectFloat = ImmutableIntObjectSingletonMapTest::collectFloat;
            this.payloads.collectFloat_withTarget = ImmutableIntObjectSingletonMapTest::collectFloat_withTarget;
            this.payloads.collectInt = ImmutableIntObjectSingletonMapTest::collectInt;
            this.payloads.collectInt_withTarget = ImmutableIntObjectSingletonMapTest::collectInt_withTarget;
            this.payloads.collectLong = ImmutableIntObjectSingletonMapTest::collectLong;
            this.payloads.collectLong_withTarget = ImmutableIntObjectSingletonMapTest::collectLong_withTarget;
            this.payloads.collectShort = ImmutableIntObjectSingletonMapTest::collectShort;
            this.payloads.collectShort_withTarget = ImmutableIntObjectSingletonMapTest::collectShort_withTarget;
            this.payloads.toSortedBag = ImmutableIntObjectSingletonMapTest::toSortedBag;
            this.payloads.toSortedBagBy = ImmutableIntObjectSingletonMapTest::toSortedBagBy;
        }
    }
}
