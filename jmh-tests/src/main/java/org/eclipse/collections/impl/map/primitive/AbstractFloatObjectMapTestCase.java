/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.primitive;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleObjectToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatObjectToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.IntObjectToIntFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction;
import org.eclipse.collections.api.block.function.primitive.LongObjectToLongFunction;
import org.eclipse.collections.api.block.predicate.Predicate;
import org.eclipse.collections.api.block.predicate.Predicate2;
import org.eclipse.collections.api.block.predicate.primitive.FloatObjectPredicate;
import org.eclipse.collections.api.block.procedure.Procedure2;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MapIterable;
import org.eclipse.collections.api.map.primitive.ImmutableFloatObjectMap;
import org.eclipse.collections.api.map.primitive.MutableFloatObjectMap;
import org.eclipse.collections.api.map.primitive.FloatObjectMap;
import org.eclipse.collections.api.map.primitive.ObjectDoubleMap;
import org.eclipse.collections.api.map.primitive.ObjectLongMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.Pair;
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
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.block.factory.StringFunctions;
import org.eclipse.collections.impl.block.factory.StringPredicates;
import org.eclipse.collections.impl.block.factory.StringPredicates2;
import org.eclipse.collections.impl.factory.primitive.FloatObjectMaps;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.FloatObjectHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.FloatObjectHashMapTest;
import org.eclipse.collections.impl.multimap.list.FastListMultimap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;
import org.eclipse.collections.impl.string.immutable.CharAdapter;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractPrimitiveObjectMapTestCase.stg.
 */
public abstract class AbstractFloatObjectMapTestCase {

    protected abstract FloatObjectMap<String> classUnderTest();

    protected abstract <T> FloatObjectMap<T> newWithKeysValues(float key1, T value1);

    protected abstract <T> FloatObjectMap<T> newWithKeysValues(float key1, T value1, float key2, T value2);

    protected abstract <T> FloatObjectMap<T> newWithKeysValues(float key1, T value1, float key2, T value2, float key3, T value3);

    protected abstract <T> FloatObjectMap<T> getEmptyMap();

    @Test
    public void keySet() {
        Verify.assertEmpty(this.getEmptyMap().keySet());
        Assert.assertEquals(FloatHashSet.newSetWith(0.0f), this.newWithKeysValues(0.0f, "zero").keySet());
        Assert.assertEquals(FloatHashSet.newSetWith(0.0f, 1.0f, 9.0f), this.newWithKeysValues(0.0f, "zero", 1.0f, "one", 9.0f, "nine").keySet());
    }

    @Test
    public void values() {
        Verify.assertEmpty(this.getEmptyMap().values());
        FloatObjectMap<String> map = this.newWithKeysValues(0.0f, "zero");
        Verify.assertSize(1, map.values());
        Verify.assertContains("zero", map.values());
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one", 9.0f, "nine");
        Verify.assertSize(3, map1.values());
        Verify.assertContainsAll(map1.values(), "zero", "one", "nine");
    }

    @Test
    public void select() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one", 9.0f, "nine");
        FloatObjectMap<String> map2 = this.newWithKeysValues(0.0f, "zero", 9.0f, "nine");
        FloatObjectMap<String> map3 = this.newWithKeysValues(1.0f, "one", 9.0f, "nine");
        FloatObjectMap<String> map4 = this.newWithKeysValues(5.0f, "five", 9.0f, "nine");
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "one", 9.0f, "nine"), map1.select((float value, String object) -> (value % 2) != 0));
        FloatObjectPredicate<String> keyGreaterThanOrEqualToSeven = (float value, String object) -> value <= 7;
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, "zero", 1.0f, "one"), map1.select(keyGreaterThanOrEqualToSeven));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, "zero"), map2.select(keyGreaterThanOrEqualToSeven));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "one"), map3.select(keyGreaterThanOrEqualToSeven));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(5.0f, "five"), map4.select(keyGreaterThanOrEqualToSeven));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "one", 9.0f, "nine"), map1.select((float value, String object) -> object.endsWith("ne")));
        RichIterable<String> actual1 = map1.select(StringPredicates.endsWith("ne"));
        Assert.assertTrue(HashBag.newBagWith("one", "nine").equals(actual1));
        Assert.assertEquals(HashBag.newBagWith("nine"), map1.select(Predicates.equal("nine")));
        Assert.assertEquals(HashBag.newBagWith("zero"), map1.select(StringPredicates.endsWith("o")));
        Assert.assertEquals(HashBag.newBagWith("nine"), map1.select(Predicates.equal("nine"), HashBag.<String>newBag()));
        Assert.assertEquals(HashBag.newBagWith("one", "nine"), map1.select(StringPredicates.endsWith("ne"), HashBag.<String>newBag()));
        Assert.assertEquals(HashBag.newBagWith("zero"), map1.select(StringPredicates.endsWith("o"), HashBag.<String>newBag()));
    }

    @Test
    public void selectWith() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one", 9.0f, "nine");
        Assert.assertEquals(HashBag.newBagWith("one", "nine"), map1.selectWith(StringPredicates2.endsWith(), "ne"));
        Assert.assertEquals(HashBag.newBagWith("nine"), map1.selectWith(Object::equals, "nine"));
        Assert.assertEquals(HashBag.newBagWith("zero"), map1.selectWith(StringPredicates2.endsWith(), "o"));
    }

    @Test
    public void selectWith_withTarget() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one", 9.0f, "nine");
        Assert.assertEquals(HashBag.newBagWith("one", "nine"), map1.selectWith(StringPredicates2.endsWith(), "ne", HashBag.<String>newBag()));
        Assert.assertEquals(HashBag.newBagWith("nine"), map1.selectWith(Object::equals, "nine", HashBag.<String>newBag()));
        Assert.assertEquals(HashBag.newBagWith("zero"), map1.selectWith(StringPredicates2.endsWith(), "o", HashBag.<String>newBag()));
    }

    @Test
    public void selectInstancesOf() {
        FloatObjectMap<Number> numbers = this.<Number>newWithKeysValues(0.0f, 0, 1.0f, 1.0, 5.0f, 5.0);
        Assert.assertEquals(HashBag.newBagWith(0), numbers.selectInstancesOf(Integer.class));
        Assert.assertEquals(HashBag.newBagWith(1.0, 5.0), numbers.selectInstancesOf(Double.class));
    }

    @Test
    public void collect() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one", 9.0f, "nine");
        Assert.assertEquals(HashBag.newBagWith("ZERO", "ONE", "NINE"), map1.collect(StringFunctions.toUpperCase()));
        Assert.assertEquals(HashBag.newBagWith("ZERO", "ONE", "NINE"), map1.collect(StringFunctions.toUpperCase(), HashBag.<String>newBag()));
    }

    @Test
    public void collectBoolean() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "true", 1.0f, "false", 2.0f, "nah");
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), map1.collectBoolean(StringFunctions.toPrimitiveBoolean()));
    }

    @Test
    public void collectBoolean_withTarget() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "true", 1.0f, "false", 2.0f, "nah");
        BooleanHashBag target = new BooleanHashBag();
        Assert.assertSame(target, map1.collectBoolean(StringFunctions.toPrimitiveBoolean(), target));
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), target);
    }

    @Test
    public void collectByte() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "0", 1.0f, "1", 2.0f, "9");
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 0, (byte) 1, (byte) 9), map1.collectByte(Byte::parseByte));
    }

    @Test
    public void collectByte_withTarget() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "0", 1.0f, "1", 2.0f, "9");
        ByteHashBag target = new ByteHashBag();
        Assert.assertSame(target, map1.collectByte(Byte::parseByte, target));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 0, (byte) 1, (byte) 9), target);
    }

    @Test
    public void collectChar() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "0", 1.0f, "1", 2.0f, "9");
        Assert.assertEquals(CharHashBag.newBagWith((char) 0, (char) 1, (char) 9), map1.collectChar(StringFunctions.toPrimitiveChar()));
    }

    @Test
    public void collectChar_withTarget() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "0", 1.0f, "1", 2.0f, "9");
        CharHashBag target = new CharHashBag();
        Assert.assertSame(target, map1.collectChar(StringFunctions.toPrimitiveChar(), target));
        Assert.assertEquals(CharHashBag.newBagWith((char) 0, (char) 1, (char) 9), target);
    }

    @Test
    public void collectDouble() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "0", 1.0f, "1", 2.0f, "9");
        Assert.assertEquals(DoubleHashBag.newBagWith(0.0d, 1.0d, 9.0d), map1.collectDouble(Double::parseDouble));
    }

    @Test
    public void collectDouble_withTarget() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "0", 1.0f, "1", 2.0f, "9");
        DoubleHashBag target = new DoubleHashBag();
        Assert.assertSame(target, map1.collectDouble(Double::parseDouble, target));
        Assert.assertEquals(DoubleHashBag.newBagWith(0.0d, 1.0d, 9.0d), target);
    }

    @Test
    public void collectFloat() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "0", 1.0f, "1", 2.0f, "9");
        Assert.assertEquals(FloatHashBag.newBagWith(0.0f, 1.0f, 9.0f), map1.collectFloat(Float::parseFloat));
    }

    @Test
    public void collectFloat_withTarget() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "0", 1.0f, "1", 2.0f, "9");
        FloatHashBag target = new FloatHashBag();
        Assert.assertSame(target, map1.collectFloat(Float::parseFloat, target));
        Assert.assertEquals(FloatHashBag.newBagWith(0.0f, 1.0f, 9.0f), target);
    }

    @Test
    public void collectInt() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "0", 1.0f, "1", 2.0f, "9");
        Assert.assertEquals(IntHashBag.newBagWith(0, 1, 9), map1.collectInt(Integer::parseInt));
    }

    @Test
    public void collectInt_withTarget() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "0", 1.0f, "1", 2.0f, "9");
        IntHashBag target = new IntHashBag();
        Assert.assertSame(target, map1.collectInt(Integer::parseInt, target));
        Assert.assertEquals(IntHashBag.newBagWith(0, 1, 9), target);
    }

    @Test
    public void collectLong() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "0", 1.0f, "1", 2.0f, "9");
        Assert.assertEquals(LongHashBag.newBagWith(0L, 1L, 9L), map1.collectLong(Long::parseLong));
    }

    @Test
    public void collectLong_withTarget() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "0", 1.0f, "1", 2.0f, "9");
        LongHashBag target = new LongHashBag();
        Assert.assertSame(target, map1.collectLong(Long::parseLong, target));
        Assert.assertEquals(LongHashBag.newBagWith(0L, 1L, 9L), target);
    }

    @Test
    public void collectShort() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "0", 1.0f, "1", 2.0f, "9");
        Assert.assertEquals(ShortHashBag.newBagWith((short) 0, (short) 1, (short) 9), map1.collectShort(Short::parseShort));
    }

    @Test
    public void collectShort_withTarget() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "0", 1.0f, "1", 2.0f, "9");
        ShortHashBag target = new ShortHashBag();
        Assert.assertSame(target, map1.collectShort(Short::parseShort, target));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 0, (short) 1, (short) 9), target);
    }

    @Test
    public void collectWith() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one", 9.0f, "nine");
        Assert.assertEquals(HashBag.newBagWith("ZERO!", "ONE!", "NINE!"), map1.collectWith((String argument1, String argument2) -> argument1.toUpperCase() + argument2, "!"));
    }

    @Test
    public void collectWithTarget() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one", 9.0f, "nine");
        Assert.assertEquals(HashBag.newBagWith("ZERO!", "ONE!", "NINE!"), map1.collectWith((String argument1, String argument2) -> argument1.toUpperCase() + argument2, "!", HashBag.<String>newBag()));
    }

    @Test
    public void collectIf() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one", 9.0f, "nine");
        Assert.assertEquals(HashBag.newBagWith("ONE", "NINE"), map1.collectIf(StringPredicates.endsWith("ne"), StringFunctions.toUpperCase()));
        Assert.assertEquals(HashBag.newBagWith("ZERO"), map1.collectIf(StringPredicates.endsWith("o"), StringFunctions.toUpperCase()));
        Assert.assertEquals(HashBag.newBagWith("ZERO"), map1.collectIf(StringPredicates.endsWith("o"), StringFunctions.toUpperCase(), HashBag.<String>newBag()));
    }

    @Test
    public void flatCollect() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 9.0f, "nine");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "one", 9.0f, "nine");
        FloatObjectMap<String> map3 = this.newWithKeysValues(5.0f, "five", 9.0f, "nine");
        Function<String, MutableList<Character>> toChars = (String object) -> {
            MutableList<Character> list = FastList.newList();
            char[] chars = object.toCharArray();
            for (char aChar : chars) {
                list.add(aChar);
            }
            return list;
        };
        Assert.assertEquals(UnifiedSet.newSetWith('z', 'e', 'r', 'o', 'n', 'i'), map1.flatCollect(toChars).toSet());
        Assert.assertEquals(UnifiedSet.newSetWith('o', 'n', 'e', 'i'), map2.flatCollect(toChars).toSet());
        Assert.assertEquals(UnifiedSet.newSetWith('f', 'i', 'v', 'e', 'n'), map3.flatCollect(toChars).toSet());
        Assert.assertEquals(UnifiedSet.newSetWith('f', 'i', 'v', 'e', 'n'), map3.flatCollect(toChars, UnifiedSet.<Character>newSet()));
    }

    @Test
    public void detect() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one", 9.0f, "nine");
        Assert.assertTrue("one".equals(map1.detect(StringPredicates.endsWith("ne"))) || "nine".equals(map1.detect(StringPredicates.endsWith("ne"))));
        Assert.assertEquals("zero", map1.detect(StringPredicates.endsWith("o")));
        Assert.assertEquals("nine", map1.detect(Predicates.equal("nine")));
        Assert.assertNull(map1.detect(Predicates.equal("ten")));
    }

    @Test
    public void detectWith() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one", 9.0f, "nine");
        Assert.assertTrue("one".equals(map1.detectWith(StringPredicates2.endsWith(), "ne")) || "nine".equals(map1.detectWith(StringPredicates2.endsWith(), "ne")));
        Assert.assertEquals("zero", map1.detectWith(StringPredicates2.endsWith(), "o"));
        Assert.assertEquals("nine", map1.detectWith(Object::equals, "nine"));
        Assert.assertNull(map1.detectWith(Object::equals, "ten"));
    }

    @Test
    public void detectOptional() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one", 9.0f, "nine");
        Assert.assertTrue(Optional.of("one").equals(map1.detectOptional(StringPredicates.endsWith("ne"))) || Optional.of("nine").equals(map1.detectOptional(StringPredicates.endsWith("ne"))));
        Assert.assertEquals(Optional.of("zero"), map1.detectOptional(StringPredicates.endsWith("o")));
        Assert.assertEquals(Optional.of("nine"), map1.detectOptional(Predicates.equal("nine")));
        Assert.assertEquals(Optional.empty(), map1.detectOptional(Predicates.equal("ten")));
    }

    @Test
    public void detectWithOptional() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one", 9.0f, "nine");
        Assert.assertTrue(Optional.of("one").equals(map1.detectWithOptional(StringPredicates2.endsWith(), "ne")) || Optional.of("nine").equals(map1.detectWithOptional(StringPredicates2.endsWith(), "ne")));
        Assert.assertEquals(Optional.of("zero"), map1.detectWithOptional(StringPredicates2.endsWith(), "o"));
        Assert.assertEquals(Optional.of("nine"), map1.detectWithOptional(Object::equals, "nine"));
        Assert.assertEquals(Optional.empty(), map1.detectWithOptional(Object::equals, "ten"));
    }

    @Test
    public void detectIfNone() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one", 9.0f, "nine");
        Function0<String> ifNone = () -> "ifNone";
        Assert.assertTrue("one".equals(map1.detectIfNone(StringPredicates.endsWith("ne"), ifNone)) || "nine".equals(map1.detectIfNone(StringPredicates.endsWith("ne"), ifNone)));
        Assert.assertEquals("zero", map1.detectIfNone(StringPredicates.endsWith("o"), ifNone));
        Assert.assertEquals("nine", map1.detectIfNone(Predicates.equal("nine"), ifNone));
        Assert.assertEquals("ifNone", map1.detectIfNone(Predicates.equal("ten"), ifNone));
    }

    @Test
    public void detectWithIfNone() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one", 9.0f, "nine");
        Function0<String> ifNone = () -> "ifNone";
        Assert.assertTrue("one".equals(map1.detectWithIfNone(StringPredicates2.endsWith(), "ne", ifNone)) || "nine".equals(map1.detectWithIfNone(StringPredicates2.endsWith(), "ne", ifNone)));
        Assert.assertEquals("zero", map1.detectWithIfNone(StringPredicates2.endsWith(), "o", ifNone));
        Assert.assertEquals("nine", map1.detectWithIfNone(Object::equals, "nine", ifNone));
        Assert.assertEquals("ifNone", map1.detectWithIfNone(Object::equals, "ten", ifNone));
    }

    @Test
    public void count() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one", 9.0f, "nine");
        Verify.assertCount(2, map1, StringPredicates.endsWith("ne"));
        Verify.assertCount(1, map1, StringPredicates.endsWith("o"));
        Verify.assertCount(1, map1, Predicates.equal("nine"));
        Verify.assertCount(0, map1, Predicates.equal("ten"));
    }

    @Test
    public void countWith() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one", 9.0f, "nine");
        Assert.assertEquals(2, map1.countWith(StringPredicates2.endsWith(), "ne"));
        Assert.assertEquals(1, map1.countWith(StringPredicates2.endsWith(), "o"));
        Assert.assertEquals(1, map1.countWith(Object::equals, "nine"));
        Assert.assertNotEquals(1, map1.countWith(Object::equals, "ten"));
    }

    @Test
    public void anySatisfy() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one", 9.0f, "nine");
        Verify.assertAnySatisfy(map1, StringPredicates.endsWith("ne"));
        Verify.assertAnySatisfy(map1, StringPredicates.endsWith("o"));
        Verify.assertAnySatisfy(map1, Predicates.equal("nine"));
        Assert.assertFalse(map1.anySatisfy(Predicates.equal("ten")));
    }

    @Test
    public void anySatisfyWith() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one", 9.0f, "nine");
        Assert.assertTrue(map1.anySatisfyWith(StringPredicates2.endsWith(), "ne"));
        Assert.assertTrue(map1.anySatisfyWith(StringPredicates2.endsWith(), "o"));
        Assert.assertTrue(map1.anySatisfyWith(Object::equals, "nine"));
        Assert.assertFalse(map1.anySatisfyWith(Object::equals, "ten"));
    }

    @Test
    public void allSatisfy() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one", 9.0f, "nine");
        Assert.assertTrue(map1.allSatisfy(StringPredicates.contains("e")));
        Assert.assertFalse(map1.allSatisfy(StringPredicates.endsWith("o")));
        Assert.assertFalse(map1.allSatisfy(StringPredicates.contains("o")));
        Assert.assertFalse(map1.allSatisfy(Predicates.equal("nine")));
        Assert.assertFalse(map1.allSatisfy(Predicates.equal("ten")));
    }

    @Test
    public void allSatisfyWith() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one", 9.0f, "nine");
        Assert.assertTrue(map1.allSatisfyWith(StringPredicates2.contains(), "e"));
        Assert.assertFalse(map1.allSatisfyWith(StringPredicates2.endsWith(), "o"));
        Assert.assertFalse(map1.allSatisfyWith(StringPredicates2.contains(), "o"));
        Assert.assertFalse(map1.allSatisfyWith(Object::equals, "nine"));
        Assert.assertFalse(map1.allSatisfyWith(Object::equals, "ten"));
    }

    @Test
    public void noneSatisfy() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one", 9.0f, "nine");
        Assert.assertTrue(map1.noneSatisfy(StringPredicates.notContains("e")));
        Assert.assertFalse(map1.noneSatisfy(StringPredicates.endsWith("o")));
        Assert.assertFalse(map1.noneSatisfy(StringPredicates.startsWith("o")));
        Assert.assertFalse(map1.noneSatisfy(StringPredicates.contains("o")));
        Assert.assertFalse(map1.noneSatisfy(Predicates.equal("nine")));
        Assert.assertTrue(map1.noneSatisfy(Predicates.equal("ten")));
    }

    @Test
    public void noneSatisfyWith() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one", 9.0f, "nine");
        Assert.assertTrue(map1.noneSatisfyWith(StringPredicates2.notContains(), "e"));
        Assert.assertFalse(map1.noneSatisfyWith(StringPredicates2.endsWith(), "o"));
        Assert.assertFalse(map1.noneSatisfyWith(StringPredicates2.startsWith(), "o"));
        Assert.assertFalse(map1.noneSatisfyWith(StringPredicates2.contains(), "o"));
        Assert.assertFalse(map1.noneSatisfyWith(Object::equals, "nine"));
        Assert.assertTrue(map1.noneSatisfyWith(Object::equals, "ten"));
    }

    @Test
    public void injectInto() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 9.0f, "nine");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "one", 9.0f, "nine");
        FloatObjectMap<String> map3 = this.newWithKeysValues(5.0f, "five", 9.0f, "nine");
        Function2<String, String, String> concat = (String argument1, String argument2) -> argument1 + '-' + argument2;
        Assert.assertTrue("Start-zero-nine".equals(map1.injectInto("Start", concat)) || "Start-nine-zero".equals(map1.injectInto("Start", concat)));
        Assert.assertTrue("Start-one-nine".equals(map2.injectInto("Start", concat)) || "Start-nine-one".equals(map2.injectInto("Start", concat)));
        Assert.assertTrue("Start-five-nine".equals(map3.injectInto("Start", concat)) || "Start-nine-five".equals(map3.injectInto("Start", concat)));
    }

    @Test
    public void intInjectInto() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "a", 9.0f, "abcd");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "ab", 9.0f, "abcd");
        FloatObjectMap<String> map3 = this.newWithKeysValues(5.0f, "abc", 9.0f, "abcd");
        IntObjectToIntFunction<String> function = (int intParameter, String objectParameter) -> intParameter + objectParameter.length();
        Assert.assertEquals(6, map1.injectInto(1, function));
        Assert.assertEquals(7, map2.injectInto(1, function));
        Assert.assertEquals(8, map3.injectInto(1, function));
    }

    @Test
    public void longInjectInto() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "a", 9.0f, "abcd");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "ab", 9.0f, "abcd");
        FloatObjectMap<String> map3 = this.newWithKeysValues(5.0f, "abc", 9.0f, "abcd");
        LongObjectToLongFunction<String> function = (long longParameter, String objectParameter) -> longParameter + objectParameter.length();
        Assert.assertEquals(6L, map1.injectInto(1L, function));
        Assert.assertEquals(7L, map2.injectInto(1L, function));
        Assert.assertEquals(8L, map3.injectInto(1L, function));
    }

    @Test
    public void floatInjectInto() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "a", 9.0f, "abcd");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "ab", 9.0f, "abcd");
        FloatObjectMap<String> map3 = this.newWithKeysValues(5.0f, "abc", 9.0f, "abcd");
        FloatObjectToFloatFunction<String> function = (float floatParameter, String objectParameter) -> floatParameter + objectParameter.length();
        Assert.assertEquals(6.0f, map1.injectInto(1.0f, function), 0.0);
        Assert.assertEquals(7.0f, map2.injectInto(1.0f, function), 0.0);
        Assert.assertEquals(8.0f, map3.injectInto(1.0f, function), 0.0);
    }

    @Test
    public void doubleInjectInto() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "a", 9.0f, "abcd");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "ab", 9.0f, "abcd");
        FloatObjectMap<String> map3 = this.newWithKeysValues(5.0f, "abc", 9.0f, "abcd");
        DoubleObjectToDoubleFunction<String> function = (double doubleParameter, String objectParameter) -> doubleParameter + objectParameter.length();
        Assert.assertEquals(6.0, map1.injectInto(1.0, function), 0.0);
        Assert.assertEquals(7.0, map2.injectInto(1.0, function), 0.0);
        Assert.assertEquals(8.0, map3.injectInto(1.0, function), 0.0);
    }

    @Test
    public void toList() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 9.0f, "nine");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "one", 9.0f, "nine");
        FloatObjectMap<String> map3 = this.newWithKeysValues(5.0f, "five", 9.0f, "nine");
        Assert.assertTrue(map1.toList().toString(), FastList.newListWith("zero", "nine").equals(map1.toList()) || FastList.newListWith("nine", "zero").equals(map1.toList()));
        Assert.assertTrue(map2.toList().toString(), FastList.newListWith("one", "nine").equals(map2.toList()) || FastList.newListWith("nine", "one").equals(map2.toList()));
        Assert.assertTrue(map3.toList().toString(), FastList.newListWith("five", "nine").equals(map3.toList()) || FastList.newListWith("nine", "five").equals(map3.toList()));
    }

    @Test
    public void toSortedList() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 9.0f, "nine");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "one", 9.0f, "nine");
        FloatObjectMap<String> map3 = this.newWithKeysValues(5.0f, "five", 9.0f, "nine");
        Assert.assertEquals(map1.toSortedList().toString(), FastList.newListWith("nine", "zero"), map1.toSortedList());
        Assert.assertEquals(map2.toSortedList().toString(), FastList.newListWith("nine", "one"), map2.toSortedList());
        Assert.assertEquals(map3.toSortedList().toString(), FastList.newListWith("five", "nine"), map3.toSortedList());
        Comparator<String> comparator = (String o1, String o2) -> o1.substring(1).compareTo(o2.substring(1));
        Assert.assertEquals(map1.toSortedList(comparator).toString(), FastList.newListWith("zero", "nine"), map1.toSortedList(comparator));
        Assert.assertEquals(map2.toSortedList(comparator).toString(), FastList.newListWith("nine", "one"), map2.toSortedList(comparator));
        Assert.assertEquals(map3.toSortedList(comparator).toString(), FastList.newListWith("nine", "five"), map3.toSortedList(comparator));
        Function<String, String> substring = (String object) -> object.substring(1);
        Assert.assertEquals(map1.toSortedListBy(substring).toString(), FastList.newListWith("zero", "nine"), map1.toSortedListBy(substring));
        Assert.assertEquals(map2.toSortedListBy(substring).toString(), FastList.newListWith("nine", "one"), map2.toSortedListBy(substring));
        Assert.assertEquals(map3.toSortedListBy(substring).toString(), FastList.newListWith("nine", "five"), map3.toSortedListBy(substring));
    }

    @Test
    public void toSet() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 5.0f, "zero", 9.0f, "nine");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "one", 5.0f, "one", 9.0f, "nine");
        FloatObjectMap<String> map3 = this.newWithKeysValues(5.0f, "five", 6.0f, "five", 9.0f, "nine");
        Assert.assertEquals(map1.toSet().toString(), UnifiedSet.newSetWith("zero", "nine"), map1.toSet());
        Assert.assertEquals(map2.toSet().toString(), UnifiedSet.newSetWith("one", "nine"), map2.toSet());
        Assert.assertEquals(map3.toSet().toString(), UnifiedSet.newSetWith("five", "nine"), map3.toSet());
    }

    @Test
    public void toSortedSet() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 5.0f, "zero", 9.0f, "nine");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "one", 5.0f, "one", 9.0f, "nine");
        FloatObjectMap<String> map3 = this.newWithKeysValues(5.0f, "five", 6.0f, "five", 9.0f, "nine");
        Assert.assertEquals(TreeSortedSet.newSetWith("nine", "zero"), map1.toSortedSet());
        Assert.assertEquals(map2.toSortedSet().toString(), TreeSortedSet.newSetWith("nine", "one"), map2.toSortedSet());
        Assert.assertEquals(TreeSortedSet.newSetWith("five", "nine"), map3.toSortedSet());
        Comparator<String> comparator = (String o1, String o2) -> o1.substring(1).compareTo(o2.substring(1));
        Assert.assertEquals(TreeSortedSet.newSetWith("zero", "nine"), map1.toSortedSet(comparator));
        Assert.assertEquals(map2.toSortedSet(comparator).toString(), TreeSortedSet.newSetWith("nine", "one"), map2.toSortedSet(comparator));
        Assert.assertEquals(TreeSortedSet.newSetWith("nine", "five"), map3.toSortedSet(comparator));
        Function<String, String> substring = (String object) -> object.substring(1);
        Assert.assertEquals(TreeSortedSet.newSetWith("zero", "nine"), map1.toSortedSetBy(substring));
        Assert.assertEquals(TreeSortedSet.newSetWith("nine", "one"), map2.toSortedSetBy(substring));
        Assert.assertEquals(map3.toSortedSetBy(substring).toString(), TreeSortedSet.newSetWith("nine", "five"), map3.toSortedSetBy(substring));
    }

    @Test
    public void toBag() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 5.0f, "zero", 9.0f, "nine");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "one", 5.0f, "one", 9.0f, "nine");
        FloatObjectMap<String> map3 = this.newWithKeysValues(5.0f, "five", 6.0f, "five", 9.0f, "nine");
        Assert.assertEquals(HashBag.newBagWith("zero", "zero", "nine"), map1.toBag());
        Assert.assertEquals(HashBag.newBagWith("one", "one", "nine"), map2.toBag());
        Assert.assertEquals(HashBag.newBagWith("five", "five", "nine"), map3.toBag());
    }

    @Test
    public void toMap() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "a", 9.0f, "abcd");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "ab", 9.0f, "abcd");
        FloatObjectMap<String> map3 = this.newWithKeysValues(5.0f, "abc", 9.0f, "abcd");
        Function<String, Integer> keyFunction = StringFunctions.length();
        Function<String, String> valueFunction = Functions.getPassThru();
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, "a", 4, "abcd"), map1.toMap(keyFunction, valueFunction));
        Assert.assertEquals(UnifiedMap.newWithKeysValues(2, "ab", 4, "abcd"), map2.toMap(keyFunction, valueFunction));
        Assert.assertEquals(UnifiedMap.newWithKeysValues(3, "abc", 4, "abcd"), map3.toMap(keyFunction, valueFunction));
    }

    @Test
    public void toMapTarget() {
        FloatObjectMap<String> map = this.newWithKeysValues(0.0f, "a", 9.0f, "abcd");
        Function<String, String> keyStringFunction = (Function<String, String>) each -> String.valueOf(each.length());
        Function<String, Long> keyLongFunction = (Function<String, Long>) each -> Long.valueOf(each.length());
        Function<String, String> valueFunction = Functions.getPassThru();
        Map<String, String> targetMap1 = new HashMap<>();
        targetMap1.put("1", "a");
        targetMap1.put("4", "abcd");
        Map<Long, String> targetMap2 = new HashMap<>();
        targetMap2.put(1L, "a");
        targetMap2.put(4L, "abcd");
        Assert.assertEquals(targetMap1, map.toMap(keyStringFunction, valueFunction, new HashMap<String, String>()));
        Assert.assertEquals(targetMap2, map.toMap(keyLongFunction, valueFunction, new HashMap<Long, String>()));
        Assert.assertTrue(map.toMap(keyLongFunction, valueFunction, new HashMap<Long, String>()) instanceof HashMap);
    }

    @Test
    public void toSortedMap() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "z", 9.0f, "abcd");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "ab", 9.0f, "abcd");
        FloatObjectMap<String> map3 = this.newWithKeysValues(5.0f, "zyx", 9.0f, "abcd");
        Function<String, Integer> keyFunction = StringFunctions.length();
        Function<String, String> valueFunction = Functions.getPassThru();
        Assert.assertEquals(UnifiedMap.newWithKeysValues(4, "abcd", 1, "z"), map1.toSortedMap(keyFunction, valueFunction));
        Assert.assertEquals(UnifiedMap.newWithKeysValues(2, "ab", 4, "abcd"), map2.toSortedMap(keyFunction, valueFunction));
        Assert.assertEquals(UnifiedMap.newWithKeysValues(4, "abcd", 3, "zyx"), map3.toSortedMap(keyFunction, valueFunction));
        Assert.assertEquals(UnifiedMap.newWithKeysValues(4, "abcd", 3, "zyx"), map3.toSortedMap(Comparators.naturalOrder(), keyFunction, valueFunction));
        Assert.assertEquals(UnifiedMap.newWithKeysValues(4, "abcd", 3, "zyx"), map3.toSortedMapBy(Functions.getPassThru(), keyFunction, valueFunction));
    }

    @Test
    public void toImmutableList() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 9.0f, "nine");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "one", 9.0f, "nine");
        FloatObjectMap<String> map3 = this.newWithKeysValues(5.0f, "five", 9.0f, "nine");
        Assert.assertTrue(map1.toList().toString(), FastList.newListWith("zero", "nine").equals(map1.toImmutableList()) || FastList.newListWith("nine", "zero").equals(map1.toList()));
        Assert.assertTrue(map2.toList().toString(), FastList.newListWith("one", "nine").equals(map2.toImmutableList()) || FastList.newListWith("nine", "one").equals(map2.toList()));
        Assert.assertTrue(map3.toList().toString(), FastList.newListWith("five", "nine").equals(map3.toImmutableList()) || FastList.newListWith("nine", "five").equals(map3.toList()));
    }

    @Test
    public void toImmutableSortedList() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 9.0f, "nine");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "one", 9.0f, "nine");
        FloatObjectMap<String> map3 = this.newWithKeysValues(5.0f, "five", 9.0f, "nine");
        Assert.assertEquals(map1.toSortedList().toString(), FastList.newListWith("nine", "zero"), map1.toImmutableSortedList());
        Assert.assertEquals(map2.toSortedList().toString(), FastList.newListWith("nine", "one"), map2.toImmutableSortedList());
        Assert.assertEquals(map3.toSortedList().toString(), FastList.newListWith("five", "nine"), map3.toImmutableSortedList());
        Comparator<String> comparator = (String o1, String o2) -> o1.substring(1).compareTo(o2.substring(1));
        Assert.assertEquals(map1.toSortedList(comparator).toString(), FastList.newListWith("zero", "nine"), map1.toImmutableSortedList(comparator));
        Assert.assertEquals(map2.toSortedList(comparator).toString(), FastList.newListWith("nine", "one"), map2.toImmutableSortedList(comparator));
        Assert.assertEquals(map3.toSortedList(comparator).toString(), FastList.newListWith("nine", "five"), map3.toImmutableSortedList(comparator));
        Function<String, String> substring = (String object) -> object.substring(1);
        Assert.assertEquals(map1.toSortedListBy(substring).toString(), FastList.newListWith("zero", "nine"), map1.toImmutableSortedListBy(substring));
        Assert.assertEquals(map2.toSortedListBy(substring).toString(), FastList.newListWith("nine", "one"), map2.toImmutableSortedListBy(substring));
        Assert.assertEquals(map3.toSortedListBy(substring).toString(), FastList.newListWith("nine", "five"), map3.toImmutableSortedListBy(substring));
    }

    @Test
    public void toImmutableSet() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 5.0f, "zero", 9.0f, "nine");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "one", 5.0f, "one", 9.0f, "nine");
        FloatObjectMap<String> map3 = this.newWithKeysValues(5.0f, "five", 6.0f, "five", 9.0f, "nine");
        Assert.assertEquals(map1.toSet().toString(), UnifiedSet.newSetWith("zero", "nine"), map1.toImmutableSet());
        Assert.assertEquals(map2.toSet().toString(), UnifiedSet.newSetWith("one", "nine"), map2.toImmutableSet());
        Assert.assertEquals(map3.toSet().toString(), UnifiedSet.newSetWith("five", "nine"), map3.toImmutableSet());
    }

    @Test
    public void toImmutableSortedSet() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 5.0f, "zero", 9.0f, "nine");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "one", 5.0f, "one", 9.0f, "nine");
        FloatObjectMap<String> map3 = this.newWithKeysValues(5.0f, "five", 6.0f, "five", 9.0f, "nine");
        Assert.assertEquals(TreeSortedSet.newSetWith("nine", "zero"), map1.toImmutableSortedSet());
        Assert.assertEquals(map2.toImmutableSortedSet().toString(), TreeSortedSet.newSetWith("nine", "one"), map2.toImmutableSortedSet());
        Assert.assertEquals(TreeSortedSet.newSetWith("five", "nine"), map3.toImmutableSortedSet());
        Comparator<String> comparator = (String o1, String o2) -> o1.substring(1).compareTo(o2.substring(1));
        Assert.assertEquals(TreeSortedSet.newSetWith("zero", "nine"), map1.toImmutableSortedSet(comparator));
        Assert.assertEquals(map2.toImmutableSortedSet(comparator).toString(), TreeSortedSet.newSetWith("nine", "one"), map2.toImmutableSortedSet(comparator));
        Assert.assertEquals(TreeSortedSet.newSetWith("nine", "five"), map3.toImmutableSortedSet(comparator));
        Function<String, String> substring = (String object) -> object.substring(1);
        Assert.assertEquals(TreeSortedSet.newSetWith("zero", "nine"), map1.toImmutableSortedSetBy(substring));
        Assert.assertEquals(TreeSortedSet.newSetWith("nine", "one"), map2.toImmutableSortedSetBy(substring));
        Assert.assertEquals(map3.toImmutableSortedSetBy(substring).toString(), TreeSortedSet.newSetWith("nine", "five"), map3.toImmutableSortedSetBy(substring));
    }

    @Test
    public void toImmutableBag() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 5.0f, "zero", 9.0f, "nine");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "one", 5.0f, "one", 9.0f, "nine");
        FloatObjectMap<String> map3 = this.newWithKeysValues(5.0f, "five", 6.0f, "five", 9.0f, "nine");
        Assert.assertEquals(HashBag.newBagWith("zero", "zero", "nine"), map1.toImmutableBag());
        Assert.assertEquals(HashBag.newBagWith("one", "one", "nine"), map2.toImmutableBag());
        Assert.assertEquals(HashBag.newBagWith("five", "five", "nine"), map3.toImmutableBag());
    }

    @Test
    public void toImmutableSortedBag() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 5.0f, "zero", 9.0f, "nine");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "one", 5.0f, "one", 9.0f, "nine");
        Verify.assertSortedBagsEqual(TreeBag.newBagWith("zero", "zero", "nine"), map1.toImmutableSortedBag());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparator.reverseOrder(), "one", "one", "nine"), map2.toImmutableSortedBag(Comparator.<String>reverseOrder()));
    }

    @Test
    public void toImmutableSortedBagBy() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 5.0f, "zero", 9.0f, "nine");
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.byFunction(String::valueOf), "zero", "zero", "nine"), map1.toImmutableSortedBagBy(String::valueOf));
    }

    @Test
    public void toArray() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "z", 9.0f, "abcd");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "ab", 9.0f, "abcd");
        FloatObjectMap<String> map3 = this.newWithKeysValues(5.0f, "zyx", 9.0f, "abcd");
        Assert.assertTrue(map1.asLazy().toString(), Arrays.equals(new String[] { "abcd", "z" }, map1.toArray()) || Arrays.equals(new String[] { "z", "abcd" }, map1.toArray()));
        Assert.assertTrue(map2.asLazy().toString(), Arrays.equals(new String[] { "abcd", "ab" }, map2.toArray()) || Arrays.equals(new String[] { "ab", "abcd" }, map2.toArray()));
        Assert.assertTrue(map3.asLazy().toString(), Arrays.equals(new String[] { "abcd", "zyx" }, map3.toArray()) || Arrays.equals(new String[] { "zyx", "abcd" }, map3.toArray()));
        Assert.assertTrue(map1.asLazy().toString(), Arrays.equals(new String[] { "abcd", "z" }, map1.toArray(new String[2])) || Arrays.equals(new String[] { "z", "abcd" }, map1.toArray()));
        Assert.assertTrue(map2.asLazy().toString(), Arrays.equals(new String[] { "abcd", "ab" }, map2.toArray(new String[4])) || Arrays.equals(new String[] { "ab", "abcd" }, map2.toArray()));
        Assert.assertTrue(map3.asLazy().toString(), Arrays.equals(new String[] { "abcd", "zyx" }, map3.toArray(new String[2])) || Arrays.equals(new String[] { "zyx", "abcd" }, map3.toArray()));
    }

    @Test
    public void min() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "z", 9.0f, "abcd");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "ab", 9.0f, "abcd");
        FloatObjectMap<String> map3 = this.newWithKeysValues(5.0f, "zyx", 9.0f, "abcd");
        Assert.assertEquals("abcd", map1.min());
        Assert.assertEquals("ab", map2.min());
        Assert.assertEquals("abcd", map3.min());
        Assert.assertEquals("abcd", map3.min(Comparators.naturalOrder()));
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_empty() {
        FloatObjectHashMap.newMap().min();
    }

    @Test
    public void maxBy() {
        FloatObjectMap<Class<?>> map1 = this.newWithKeysValues(0.0f, FloatObjectHashMapTest.class, 9.0f, FloatObjectHashMap.class);
        FloatObjectMap<Class<?>> map2 = this.newWithKeysValues(1.0f, FloatObjectHashMapTest.class, 9.0f, FloatObjectHashMap.class);
        FloatObjectMap<Class<?>> map3 = this.newWithKeysValues(5.0f, FloatObjectHashMap.class, 9.0f, FloatObjectHashMapTest.class);
        Function<Class<?>, Integer> classNameLength = (Class<?> aClass) -> aClass.getName().length();
        Assert.assertEquals(FloatObjectHashMapTest.class, map1.maxBy(classNameLength));
        Assert.assertEquals(FloatObjectHashMapTest.class, map2.maxBy(classNameLength));
        Assert.assertEquals(FloatObjectHashMapTest.class, map3.maxBy(classNameLength));
        Assert.assertThrows(NoSuchElementException.class, () -> FloatObjectHashMap.<Class<?>>newMap().maxBy(classNameLength));
    }

    @Test
    public void max() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "z", 9.0f, "abcd");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "ab", 9.0f, "abcd");
        FloatObjectMap<String> map3 = this.newWithKeysValues(5.0f, "zyx", 9.0f, "abcd");
        Assert.assertEquals("z", map1.max());
        Assert.assertEquals("abcd", map2.max());
        Assert.assertEquals("zyx", map3.max());
        Assert.assertEquals("zyx", map3.max(Comparators.naturalOrder()));
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_empty() {
        FloatObjectHashMap.newMap().max();
    }

    @Test
    public void minBy() {
        FloatObjectMap<Class<?>> map1 = this.newWithKeysValues(0.0f, FloatObjectHashMapTest.class, 9.0f, FloatObjectHashMap.class);
        FloatObjectMap<Class<?>> map2 = this.newWithKeysValues(1.0f, FloatObjectHashMapTest.class, 9.0f, FloatObjectHashMap.class);
        FloatObjectMap<Class<?>> map3 = this.newWithKeysValues(5.0f, FloatObjectHashMap.class, 9.0f, FloatObjectHashMapTest.class);
        Function<Class<?>, Integer> classNameLength = (Class<?> object) -> object.getName().length();
        Assert.assertEquals(FloatObjectHashMap.class, map1.minBy(classNameLength));
        Assert.assertEquals(FloatObjectHashMap.class, map2.minBy(classNameLength));
        Assert.assertEquals(FloatObjectHashMap.class, map3.minBy(classNameLength));
        Assert.assertThrows(NoSuchElementException.class, () -> FloatObjectHashMap.<Class<?>>newMap().minBy(classNameLength));
    }

    @Test
    public void sumOfInt() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "z", 9.0f, "abcd");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "ab", 9.0f, "abcd");
        FloatObjectMap<String> map3 = this.newWithKeysValues(5.0f, "zyx", 9.0f, "abcd");
        IntFunction<String> function = StringFunctions.length();
        Assert.assertEquals(5L, map1.sumOfInt(function));
        Assert.assertEquals(6L, map2.sumOfInt(function));
        Assert.assertEquals(7L, map3.sumOfInt(function));
    }

    @Test
    public void sumOfLong() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "z", 9.0f, "abcd");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "ab", 9.0f, "abcd");
        FloatObjectMap<String> map3 = this.newWithKeysValues(5.0f, "zyx", 9.0f, "abcd");
        LongFunction<String> function = String::length;
        Assert.assertEquals(5L, map1.sumOfLong(function));
        Assert.assertEquals(6L, map2.sumOfLong(function));
        Assert.assertEquals(7L, map3.sumOfLong(function));
    }

    @Test
    public void sumOfDouble() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "z", 9.0f, "abcd");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "ab", 9.0f, "abcd");
        FloatObjectMap<String> map3 = this.newWithKeysValues(5.0f, "zyx", 9.0f, "abcd");
        DoubleFunction<String> function = String::length;
        Assert.assertEquals(5.0, map1.sumOfDouble(function), 0.0);
        Assert.assertEquals(6.0, map2.sumOfDouble(function), 0.0);
        Assert.assertEquals(7.0, map3.sumOfDouble(function), 0.0);
    }

    @Test
    public void sumOfFloat() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "z", 9.0f, "abcd");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "ab", 9.0f, "abcd");
        FloatObjectMap<String> map3 = this.newWithKeysValues(5.0f, "zyx", 9.0f, "abcd");
        FloatFunction<String> function = String::length;
        Assert.assertEquals(5.0, map1.sumOfFloat(function), 0.0);
        Assert.assertEquals(6.0, map2.sumOfFloat(function), 0.0);
        Assert.assertEquals(7.0, map3.sumOfFloat(function), 0.0);
    }

    @Test
    public void sumByInt() {
        RichIterable<String> values = this.newWithKeysValues(1.0f, "1", 2.0f, "2", 3.0f, "3");
        ObjectLongMap<Integer> result = values.sumByInt(s -> Integer.parseInt(s) % 2, Integer::parseInt);
        Assert.assertEquals(4, result.get(1));
        Assert.assertEquals(2, result.get(0));
    }

    @Test
    public void sumByFloat() {
        RichIterable<String> values = this.newWithKeysValues(1.0f, "1", 2.0f, "2", 3.0f, "3");
        ObjectDoubleMap<Integer> result = values.sumByFloat(s -> Integer.parseInt(s) % 2, Float::parseFloat);
        Assert.assertEquals(4.0f, result.get(1), 0.0);
        Assert.assertEquals(2.0f, result.get(0), 0.0);
    }

    @Test
    public void sumByLong() {
        RichIterable<String> values = this.newWithKeysValues(1.0f, "1", 2.0f, "2", 3.0f, "3");
        ObjectLongMap<Integer> result = values.sumByLong(s -> Integer.parseInt(s) % 2, Long::parseLong);
        Assert.assertEquals(4, result.get(1));
        Assert.assertEquals(2, result.get(0));
    }

    @Test
    public void sumByDouble() {
        RichIterable<String> values = this.newWithKeysValues(1.0f, "1", 2.0f, "2", 3.0f, "3");
        ObjectDoubleMap<Integer> result = values.sumByDouble(s -> Integer.parseInt(s) % 2, Double::parseDouble);
        Assert.assertEquals(4.0d, result.get(1), 0.0);
        Assert.assertEquals(2.0d, result.get(0), 0.0);
    }

    @Test
    public void keysView() {
        Assert.assertEquals(FloatArrayList.newListWith(), this.getEmptyMap().keysView().toList());
        Assert.assertEquals(FloatArrayList.newListWith(1.0f), this.newWithKeysValues(1.0f, "one").keysView().toList());
    }

    @Test
    public void reject() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one", 9.0f, "nine");
        FloatObjectMap<String> map2 = this.newWithKeysValues(0.0f, "zero", 9.0f, "nine");
        FloatObjectMap<String> map3 = this.newWithKeysValues(1.0f, "one", 9.0f, "nine");
        FloatObjectMap<String> map4 = this.newWithKeysValues(5.0f, "five", 9.0f, "nine");
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "one", 9.0f, "nine"), map1.reject((float value, String object) -> (value % 2) == 0));
        FloatObjectPredicate<String> keyLessThanSeven = (float value, String object) -> value > 7;
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, "zero", 1.0f, "one"), map1.reject(keyLessThanSeven));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, "zero"), map2.reject(keyLessThanSeven));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "one"), map3.reject(keyLessThanSeven));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(5.0f, "five"), map4.reject(keyLessThanSeven));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "one", 9.0f, "nine"), map1.reject((float value, String object) -> !object.endsWith("ne")));
        RichIterable<String> actual1 = map1.reject(StringPredicates.endsWith("ne").not());
        Assert.assertTrue(HashBag.newBagWith("one", "nine").equals(actual1));
        Assert.assertEquals(HashBag.newBagWith("nine"), map1.reject(Predicates.equal("nine").not()));
        Assert.assertEquals(HashBag.newBagWith("zero"), map1.reject(StringPredicates.endsWith("o").not()));
        Assert.assertEquals(HashBag.newBagWith("nine"), map1.reject(Predicates.equal("nine").not(), HashBag.<String>newBag()));
        Assert.assertEquals(HashBag.newBagWith("one", "nine"), map1.reject(StringPredicates.endsWith("ne").not(), HashBag.<String>newBag()));
        Assert.assertEquals(HashBag.newBagWith("zero"), map1.reject(StringPredicates.endsWith("o").not(), HashBag.<String>newBag()));
    }

    @Test
    public void rejectWith() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one", 9.0f, "nine");
        Assert.assertEquals(HashBag.newBagWith("one", "nine"), map1.rejectWith(StringPredicates2.notEndsWith(), "ne"));
        Assert.assertEquals(HashBag.newBagWith("nine"), map1.rejectWith(Predicates2.notEqual(), "nine"));
        Assert.assertEquals(HashBag.newBagWith("zero"), map1.rejectWith(StringPredicates2.notEndsWith(), "o"));
    }

    @Test
    public void rejectWith_withTarget() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one", 9.0f, "nine");
        Assert.assertEquals(HashBag.newBagWith("one", "nine"), map1.rejectWith(StringPredicates2.notEndsWith(), "ne", HashBag.<String>newBag()));
        Assert.assertEquals(HashBag.newBagWith("nine"), map1.rejectWith(Predicates2.notEqual(), "nine", HashBag.<String>newBag()));
        Assert.assertEquals(HashBag.newBagWith("zero"), map1.rejectWith(StringPredicates2.notEndsWith(), "o", HashBag.<String>newBag()));
    }

    @Test
    public void partition() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one", 9.0f, "nine");
        Predicate<String> endsWithNe = StringPredicates.endsWith("ne");
        PartitionIterable<String> partition = map1.partition(endsWithNe);
        Assert.assertTrue(HashBag.newBagWith("one", "nine").equals(partition.getSelected()));
        Assert.assertEquals(HashBag.newBagWith("zero"), partition.getRejected());
    }

    @Test
    public void partitionWith() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one", 9.0f, "nine");
        Predicate2<String, String> endsWith = StringPredicates2.endsWith();
        PartitionIterable<String> partition = map1.partitionWith(endsWith, "ne");
        Assert.assertTrue(HashBag.newBagWith("one", "nine").equals(partition.getSelected()));
        Assert.assertEquals(HashBag.newBagWith("zero"), partition.getRejected());
    }

    @Test
    public void get() {
        Assert.assertEquals("zero", this.classUnderTest().get(0.0f));
        Assert.assertEquals("thirtyOne", this.classUnderTest().get(31.0f));
        Assert.assertEquals("thirtyTwo", this.classUnderTest().get(32.0f));
        Assert.assertNull(this.classUnderTest().get(1.0f));
        Assert.assertNull(this.classUnderTest().get(33.0f));
        FloatObjectMap<Object> emptyMap = this.getEmptyMap();
        Assert.assertNull(emptyMap.get(0.0f));
        Assert.assertNull(emptyMap.get(1.0f));
        Assert.assertNull(emptyMap.get(33.0f));
    }

    @Test
    public void getIfAbsent() {
        Function0<String> ifAbsent = () -> "ifAbsent";
        Assert.assertEquals("zero", this.classUnderTest().getIfAbsent(0.0f, ifAbsent));
        Assert.assertEquals("thirtyOne", this.classUnderTest().getIfAbsent(31.0f, ifAbsent));
        Assert.assertEquals("thirtyTwo", this.classUnderTest().getIfAbsent(32.0f, ifAbsent));
        Assert.assertEquals("ifAbsent", this.classUnderTest().getIfAbsent(1.0f, ifAbsent));
        Assert.assertEquals("ifAbsent", this.classUnderTest().getIfAbsent(33.0f, ifAbsent));
        FloatObjectMap<Object> emptyMap = this.getEmptyMap();
        Assert.assertEquals("ifAbsent", emptyMap.getIfAbsent(0.0f, ifAbsent));
        Assert.assertEquals("ifAbsent", emptyMap.getIfAbsent(1.0f, ifAbsent));
        Assert.assertEquals("ifAbsent", emptyMap.getIfAbsent(33.0f, ifAbsent));
    }

    @Test
    public void containsKey() {
        Assert.assertTrue(this.classUnderTest().containsKey(0.0f));
        Assert.assertTrue(this.classUnderTest().containsKey(31.0f));
        Assert.assertTrue(this.classUnderTest().containsKey(32.0f));
        Assert.assertFalse(this.classUnderTest().containsKey(1.0f));
        Assert.assertFalse(this.classUnderTest().containsKey(5.0f));
        Assert.assertFalse(this.classUnderTest().containsKey(35.0f));
    }

    @Test
    public void containsValue() {
        Assert.assertFalse(this.classUnderTest().containsValue(null));
        Assert.assertTrue(this.classUnderTest().containsValue("zero"));
        Assert.assertTrue(this.classUnderTest().containsValue("thirtyOne"));
        Assert.assertTrue(this.classUnderTest().containsValue("thirtyTwo"));
    }

    @Test
    public void forEachValue() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(1.0f, "one", 5.0f, "five");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "one", 0.0f, "zero");
        FloatObjectMap<String> map3 = this.newWithKeysValues(2.0f, "two", 5.0f, "five");
        FloatObjectMap<String> map4 = this.newWithKeysValues(0.0f, "zero", 5.0f, "five");
        String[] concat = { "", "", "", "" };
        map1.forEachValue((String each) -> concat[0] += each);
        map2.forEachValue((String each) -> concat[1] += each);
        map3.forEachValue((String each) -> concat[2] += each);
        map4.forEachValue((String each) -> concat[3] += each);
        Assert.assertTrue(concat[0], "onefive".equals(concat[0]) || "fiveone".equals(concat[0]));
        Assert.assertTrue(concat[1], "onezero".equals(concat[1]) || "zeroone".equals(concat[1]));
        Assert.assertTrue(concat[2], "twofive".equals(concat[2]) || "fivetwo".equals(concat[2]));
        Assert.assertTrue(concat[3], "zerofive".equals(concat[3]) || "fivezero".equals(concat[3]));
    }

    @Test
    public void forEachKey() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(1.0f, "one", 5.0f, "five");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "one", 0.0f, "zero");
        FloatObjectMap<String> map3 = this.newWithKeysValues(2.0f, "two", 5.0f, "five");
        FloatObjectMap<String> map4 = this.newWithKeysValues(0.0f, "zero", 5.0f, "five");
        double[] sum = new double[4];
        map1.forEachKey((float each) -> sum[0] += each);
        map2.forEachKey((float each) -> sum[1] += each);
        map3.forEachKey((float each) -> sum[2] += each);
        map4.forEachKey((float each) -> sum[3] += each);
        Assert.assertEquals(6.0, sum[0], 0.0);
        Assert.assertEquals(1.0, sum[1], 0.0);
        Assert.assertEquals(7.0, sum[2], 0.0);
        Assert.assertEquals(5.0, sum[3], 0.0);
    }

    @Test
    public void forEachKeyValue() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(1.0f, "one", 5.0f, "five");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "one", 0.0f, "zero");
        FloatObjectMap<String> map3 = this.newWithKeysValues(2.0f, "two", 5.0f, "five");
        FloatObjectMap<String> map4 = this.newWithKeysValues(0.0f, "zero", 5.0f, "five");
        String[] concat = { "", "", "", "" };
        map1.forEachKeyValue((float each, String parameter) -> {
            concat[0] += each;
            concat[0] += parameter;
        });
        map2.forEachKeyValue((float each, String parameter) -> {
            concat[1] += each;
            concat[1] += parameter;
        });
        map3.forEachKeyValue((float each, String parameter) -> {
            concat[2] += each;
            concat[2] += parameter;
        });
        map4.forEachKeyValue((float each, String parameter) -> {
            concat[3] += each;
            concat[3] += parameter;
        });
        Assert.assertTrue(concat[0], "1.0one5.0five".equals(concat[0]) || "5.0five1.0one".equals(concat[0]));
        Assert.assertTrue(concat[1], "1.0one0.0zero".equals(concat[1]) || "0.0zero1.0one".equals(concat[1]));
        Assert.assertTrue(concat[2], "2.0two5.0five".equals(concat[2]) || "5.0five2.0two".equals(concat[2]));
        Assert.assertTrue(concat[3], "0.0zero5.0five".equals(concat[3]) || "5.0five0.0zero".equals(concat[3]));
    }

    @Test
    public void injectIntoKeyValue() {
        FloatObjectMap<String> map0 = this.newWithKeysValues(2.0f, "3", 4.0f, "5");
        String result0 = map0.injectIntoKeyValue(new String("1"), (result, eachKey, eachValue) -> result + String.valueOf(eachKey) + eachValue);
        Assert.assertTrue(result0, "12.034.05".equals(result0) || "14.052.03".equals(result0));
        FloatObjectMap copy = map0.injectIntoKeyValue(FloatObjectMaps.mutable.empty(), MutableFloatObjectMap::withKeyValue);
        Assert.assertEquals(map0, copy);
    }

    @Test
    public void size() {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(2, this.newWithKeysValues(1.0f, "one", 5.0f, "five").size());
        Assert.assertEquals(2, this.newWithKeysValues(0.0f, "zero", 5.0f, "five").size());
        Assert.assertEquals(3, this.newWithKeysValues(1.0f, "one", 0.0f, "zero", 5.0f, "five").size());
        Assert.assertEquals(2, this.newWithKeysValues(6.0f, "six", 5.0f, "five").size());
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(this.getEmptyMap().isEmpty());
        Assert.assertFalse(this.classUnderTest().isEmpty());
        Assert.assertFalse(this.newWithKeysValues(1.0f, "one").isEmpty());
        Assert.assertFalse(this.newWithKeysValues(0.0f, "zero").isEmpty());
        Assert.assertFalse(this.newWithKeysValues(50.0f, "fifty").isEmpty());
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.classUnderTest().notEmpty());
        Assert.assertTrue(this.newWithKeysValues(1.0f, "one").notEmpty());
        Assert.assertTrue(this.newWithKeysValues(0.0f, "zero").notEmpty());
        Assert.assertTrue(this.newWithKeysValues(50.0f, "fifty").notEmpty());
    }

    @Test
    public void getFirst() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(1.0f, "one", 5.0f, "five");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "one", 0.0f, "zero");
        FloatObjectMap<String> map3 = this.newWithKeysValues(2.0f, "two", 5.0f, "five");
        FloatObjectMap<String> map4 = this.newWithKeysValues(0.0f, "zero", 5.0f, "five");
        Assert.assertTrue(map1.getFirst(), "one".equals(map1.getFirst()) || "five".equals(map1.getFirst()));
        Assert.assertTrue(map2.getFirst(), "one".equals(map2.getFirst()) || "zero".equals(map2.getFirst()));
        Assert.assertTrue(map3.getFirst(), "two".equals(map3.getFirst()) || "five".equals(map3.getFirst()));
        Assert.assertTrue(map4.getFirst(), "zero".equals(map4.getFirst()) || "five".equals(map4.getFirst()));
        Assert.assertNull(FloatObjectHashMap.newMap().getFirst());
    }

    @Test
    public void getLast() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(1.0f, "one", 5.0f, "five");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "one", 0.0f, "zero");
        FloatObjectMap<String> map3 = this.newWithKeysValues(2.0f, "two", 5.0f, "five");
        FloatObjectMap<String> map4 = this.newWithKeysValues(0.0f, "zero", 5.0f, "five");
        Assert.assertTrue(map1.getLast(), "one".equals(map1.getLast()) || "five".equals(map1.getLast()));
        Assert.assertTrue(map2.getLast(), "one".equals(map2.getLast()) || "zero".equals(map2.getLast()));
        Assert.assertTrue(map3.getLast(), "two".equals(map3.getLast()) || "five".equals(map3.getLast()));
        Assert.assertTrue(map4.getLast(), "zero".equals(map4.getLast()) || "five".equals(map4.getLast()));
        Assert.assertEquals("zero", this.newWithKeysValues(0.0f, "zero").getLast());
        Assert.assertNull(FloatObjectHashMap.newMap().getLast());
    }

    @Test
    public void getOnly() {
        Assert.assertEquals("zero", this.newWithKeysValues(0.0f, "zero").getOnly());
        Assert.assertEquals("one", this.newWithKeysValues(1.0f, "one").getOnly());
        Assert.assertEquals("two", this.newWithKeysValues(2.0f, "two").getOnly());
    }

    @Test(expected = IllegalStateException.class)
    public void getOnly_empty_throws() {
        this.getEmptyMap().getOnly();
    }

    @Test(expected = IllegalStateException.class)
    public void getOnly_not_only_one_throws() {
        this.newWithKeysValues(1.0f, "one", 5.0f, "five").getOnly();
    }

    @Test
    public void contains() {
        Assert.assertFalse(this.classUnderTest().contains(null));
        Assert.assertTrue(this.classUnderTest().contains("zero"));
        Assert.assertTrue(this.classUnderTest().contains("thirtyOne"));
        Assert.assertTrue(this.classUnderTest().contains("thirtyTwo"));
    }

    @Test
    public void containsAllIterable() {
        Assert.assertTrue(this.classUnderTest().containsAllIterable(FastList.newListWith("zero", "thirtyOne")));
        Assert.assertTrue(this.classUnderTest().containsAllIterable(FastList.newListWith("zero", "thirtyOne", "thirtyTwo")));
        Assert.assertFalse(this.classUnderTest().containsAllIterable(FastList.newListWith("zero", "one", "thirtyTwo")));
        Assert.assertFalse(this.classUnderTest().containsAllIterable(FastList.newListWith("two", "one", "nine")));
    }

    @Test
    public void containsAll() {
        Assert.assertTrue(this.classUnderTest().containsAll(FastList.newListWith("zero", "thirtyOne")));
        Assert.assertTrue(this.classUnderTest().containsAll(FastList.newListWith("zero", "thirtyOne", "thirtyTwo")));
        Assert.assertFalse(this.classUnderTest().containsAll(FastList.newListWith("zero", "one", "thirtyTwo")));
        Assert.assertFalse(this.classUnderTest().containsAll(FastList.newListWith("two", "one", "nine")));
    }

    @Test
    public void containsAnyIterable() {
        Assert.assertTrue(this.classUnderTest().containsAnyIterable(FastList.newListWith("zero", "thirtyOne")));
        Assert.assertTrue(this.classUnderTest().containsAnyIterable(FastList.newListWith("zero", "thirtyOne", "thirtyTwo")));
        Assert.assertFalse(this.classUnderTest().containsAnyIterable(FastList.newListWith("none")));
    }

    @Test
    public void containsAny() {
        Assert.assertTrue(this.classUnderTest().containsAny(FastList.newListWith("zero", "thirtyOne")));
        Assert.assertTrue(this.classUnderTest().containsAny(FastList.newListWith("zero", "thirtyOne", "thirtyTwo")));
        Assert.assertFalse(this.classUnderTest().containsAny(FastList.newListWith("none")));
    }

    @Test
    public void containsNoneIterable() {
        Assert.assertFalse(this.classUnderTest().containsNoneIterable(FastList.newListWith("zero", "thirtyOne")));
        Assert.assertFalse(this.classUnderTest().containsNoneIterable(FastList.newListWith("zero", "thirtyOne", "thirtyTwo")));
        Assert.assertTrue(this.classUnderTest().containsNoneIterable(FastList.newListWith("none")));
    }

    @Test
    public void containsNone() {
        Assert.assertFalse(this.classUnderTest().containsNone(FastList.newListWith("zero", "thirtyOne")));
        Assert.assertFalse(this.classUnderTest().containsNone(FastList.newListWith("zero", "thirtyOne", "thirtyTwo")));
        Assert.assertTrue(this.classUnderTest().containsNone(FastList.newListWith("none")));
    }

    @Test
    public void containsAllArguments() {
        Assert.assertTrue(this.classUnderTest().containsAllArguments("zero", "thirtyOne"));
        Assert.assertTrue(this.classUnderTest().containsAllArguments("zero", "thirtyOne", "thirtyTwo"));
        Assert.assertFalse(this.classUnderTest().containsAllArguments("zero", "one", "thirtyTwo"));
        Assert.assertFalse(this.classUnderTest().containsAllArguments("two", "one", "nine"));
    }

    @Test
    public void testEquals() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one", 32.0f, "thirtyTwo");
        FloatObjectMap<String> map2 = this.newWithKeysValues(32.0f, "thirtyTwo", 0.0f, "zero", 1.0f, "one");
        FloatObjectMap<String> map3 = this.newWithKeysValues(0.0f, "zero", 1.0f, "two", 32.0f, "thirtyTwo");
        FloatObjectMap<String> map4 = this.newWithKeysValues(0.0f, "one", 1.0f, "one", 32.0f, "thirtyTwo");
        FloatObjectMap<String> map5 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one", 32.0f, "thirtyThree");
        FloatObjectMap<String> map6 = this.newWithKeysValues(1.0f, "one", 32.0f, "thirtyTwo");
        FloatObjectMap<String> map7 = this.newWithKeysValues(0.0f, "zero", 32.0f, "thirtyTwo");
        FloatObjectMap<String> map8 = this.newWithKeysValues(50.0f, "zero", 60.0f, "one", 70.0f, "thirtyThree");
        FloatObjectMap<String> map9 = this.newWithKeysValues(50.0f, "zero", 60.0f, "one");
        FloatObjectMap<String> map10 = this.newWithKeysValues(50.0f, "zero");
        Verify.assertEqualsAndHashCode(map1, map2);
        Verify.assertPostSerializedEqualsAndHashCode(map1);
        Verify.assertPostSerializedEqualsAndHashCode(map6);
        Verify.assertPostSerializedEqualsAndHashCode(map7);
        Verify.assertPostSerializedEqualsAndHashCode(map8);
        Verify.assertPostSerializedEqualsAndHashCode(map10);
        Verify.assertPostSerializedEqualsAndHashCode(FloatObjectHashMap.newMap());
        Verify.assertEqualsAndHashCode(map1, map2);
        Assert.assertNotEquals(map1, map3);
        Assert.assertNotEquals(map1, map4);
        Assert.assertNotEquals(map1, map5);
        Assert.assertNotEquals(map1, map6);
        Assert.assertNotEquals(map1, map7);
        Assert.assertNotEquals(map8, map5);
        Assert.assertNotEquals(map9, map8);
        Assert.assertNotEquals(this.newWithKeysValues(0.0f, null), this.newWithKeysValues(6.0f, ""));
        Assert.assertNotEquals(this.newWithKeysValues(5.0f, null), this.newWithKeysValues(6.0f, ""));
        Assert.assertEquals(map1, FloatObjectMaps.mutable.ofAll(map1));
        Assert.assertEquals(map1, FloatObjectMaps.immutable.ofAll(map1));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues(0.0f, "zero", 1.0f, "one", 32.0f, "thirtyTwo").hashCode(), this.newWithKeysValues(32.0f, "thirtyTwo", 0.0f, "zero", 1.0f, "one").hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(0.0f, null, 1.0f, null).hashCode(), this.newWithKeysValues(0.0f, null, 1.0f, null).hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(50.0f, "zero", 60.0f, "one", 70.0f, "thirtyThree").hashCode(), this.newWithKeysValues(50.0f, "zero", 60.0f, "one", 70.0f, "thirtyThree").hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(50.0f, null, 60.0f, null).hashCode(), this.newWithKeysValues(50.0f, null, 60.0f, null).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        Assert.assertEquals("{0.0=zero}", this.newWithKeysValues(0.0f, "zero").toString());
        Assert.assertEquals("{1.0=one}", this.newWithKeysValues(1.0f, "one").toString());
        Assert.assertEquals("{5.0=five}", this.newWithKeysValues(5.0f, "five").toString());
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one");
        Assert.assertTrue(map1.toString(), "{0.0=zero, 1.0=one}".equals(map1.toString()) || "{1.0=one, 0.0=zero}".equals(map1.toString()));
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "one", 32.0f, "thirtyTwo");
        Assert.assertTrue(map2.toString(), "{1.0=one, 32.0=thirtyTwo}".equals(map2.toString()) || "{32.0=thirtyTwo, 1.0=one}".equals(map2.toString()));
        FloatObjectMap<String> map3 = this.newWithKeysValues(0.0f, "zero", 32.0f, "thirtyTwo");
        Assert.assertTrue(map3.toString(), "{0.0=zero, 32.0=thirtyTwo}".equals(map3.toString()) || "{32.0=thirtyTwo, 0.0=zero}".equals(map3.toString()));
        FloatObjectMap<String> map4 = this.newWithKeysValues(32.0f, "thirtyTwo", 33.0f, "thirtyThree");
        Assert.assertTrue(map4.toString(), "{32.0=thirtyTwo, 33.0=thirtyThree}".equals(map4.toString()) || "{33.0=thirtyThree, 32.0=thirtyTwo}".equals(map4.toString()));
    }

    @Test
    public void zip() {
        RichIterable<Pair<String, Integer>> zip1 = this.newWithKeysValues(0.0f, "zero", 5.0f, "five").zip(FastList.newListWith(0, 5, 6));
        RichIterable<Pair<String, Integer>> zip2 = this.newWithKeysValues(1.0f, "one", 5.0f, "five").zip(FastList.newListWith(1));
        RichIterable<Pair<String, Integer>> zip3 = this.newWithKeysValues(1.0f, "one", 5.0f, "five").zip(FastList.newListWith(1), FastList.<Pair<String, Integer>>newList());
        Assert.assertTrue(HashBag.newBagWith(Tuples.pair("zero", 0), Tuples.pair("five", 5)).equals(zip1) || HashBag.newBagWith(Tuples.pair("five", 0), Tuples.pair("zero", 5)).equals(zip1));
        Assert.assertTrue(HashBag.newBagWith(Tuples.pair("one", 1)).equals(zip2) || HashBag.newBagWith(Tuples.pair("five", 1)).equals(zip2));
        Assert.assertTrue(FastList.newListWith(Tuples.pair("one", 1)).equals(zip3) || FastList.newListWith(Tuples.pair("five", 1)).equals(zip3));
    }

    @Test
    public void zipWithIndex() {
        RichIterable<Pair<String, Integer>> zip1 = this.newWithKeysValues(0.0f, "zero", 5.0f, "five").zipWithIndex();
        RichIterable<Pair<String, Integer>> zip2 = this.newWithKeysValues(1.0f, "one", 5.0f, "five").zipWithIndex();
        RichIterable<Pair<String, Integer>> zip3 = this.newWithKeysValues(1.0f, "one", 5.0f, "five").zipWithIndex(FastList.<Pair<String, Integer>>newList());
        Assert.assertTrue(UnifiedSet.newSetWith(Tuples.pair("zero", 0), Tuples.pair("five", 1)).equals(zip1) || UnifiedSet.newSetWith(Tuples.pair("five", 0), Tuples.pair("zero", 1)).equals(zip1));
        Assert.assertTrue(UnifiedSet.newSetWith(Tuples.pair("one", 0), Tuples.pair("five", 1)).equals(zip2) || UnifiedSet.newSetWith(Tuples.pair("five", 0), Tuples.pair("one", 1)).equals(zip2));
        Assert.assertTrue(FastList.newListWith(Tuples.pair("one", 0), Tuples.pair("five", 1)).equals(zip3) || FastList.newListWith(Tuples.pair("five", 0), Tuples.pair("one", 1)).equals(zip3));
    }

    @Test
    public void chunk() {
        RichIterable<RichIterable<String>> chunk1 = this.newWithKeysValues(0.0f, "zero", 5.0f, "five").chunk(1);
        RichIterable<RichIterable<String>> chunk2 = this.newWithKeysValues(1.0f, "one", 5.0f, "five").chunk(1);
        Assert.assertTrue(FastList.newListWith(FastList.newListWith("zero"), FastList.newListWith("five")).equals(chunk1) || FastList.newListWith(FastList.newListWith("five"), FastList.newListWith("zero")).equals(chunk1));
        Assert.assertTrue(FastList.newListWith(FastList.newListWith("one"), FastList.newListWith("five")).equals(chunk2) || FastList.newListWith(FastList.newListWith("five"), FastList.newListWith("one")).equals(chunk2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_throws_negative_size() {
        this.newWithKeysValues(0.0f, "zero", 5.0f, "five").chunk(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_throws_zero_size() {
        this.newWithKeysValues(0.0f, "zero", 5.0f, "five").chunk(0);
    }

    @Test
    public void aggregateInPlaceBy() {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, Integer> sumAggregator = AtomicInteger::addAndGet;
        FloatObjectMap<Integer> collection = this.newWithKeysValues(1.0f, 1, 2.0f, 2, 3.0f, 3);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(1, aggregation.get("1").intValue());
        Assert.assertEquals(2, aggregation.get("2").intValue());
        Assert.assertEquals(3, aggregation.get("3").intValue());
    }

    @Test
    public void aggregateBy() {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, Integer, Integer> sumAggregator = (Integer aggregate, Integer value) -> aggregate + value;
        FloatObjectMap<Integer> collection = this.newWithKeysValues(1.0f, 1, 2.0f, 2, 3.0f, 3);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(1, aggregation.get("1").intValue());
        Assert.assertEquals(2, aggregation.get("2").intValue());
        Assert.assertEquals(3, aggregation.get("3").intValue());
    }

    @Test
    public void groupBy() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one");
        FloatObjectMap<String> map2 = this.newWithKeysValues(2.0f, "two", 3.0f, "three");
        FloatObjectMap<String> map3 = this.newWithKeysValues(4.0f, "four");
        FastListMultimap<Character, String> expected1 = FastListMultimap.newMultimap(Tuples.pair('z', "zero"), Tuples.pair('o', "one"));
        FastListMultimap<Character, String> expected2 = FastListMultimap.newMultimap(Tuples.pair('t', "two"), Tuples.pair('t', "three"));
        FastListMultimap<Character, String> expected4 = FastListMultimap.newMultimap(Tuples.pair('f', "four"));
        Function<String, Character> firstChar = (String object) -> object.charAt(0);
        Multimap<Character, String> actual1 = map1.groupBy(firstChar);
        Multimap<Character, String> actual2 = map2.groupBy(firstChar);
        Multimap<Character, String> actual3 = map2.groupBy(firstChar, FastListMultimap.<Character, String>newMultimap());
        Multimap<Character, String> actual4 = map3.groupBy(firstChar);
        Multimap<Character, String> actual5 = map3.groupBy(firstChar, FastListMultimap.<Character, String>newMultimap());
        Verify.assertSize(expected1.size(), actual1);
        expected1.forEachKeyValue((Character argument1, String argument2) -> Assert.assertTrue(actual1.containsKeyAndValue(argument1, argument2)));
        Verify.assertSize(expected2.size(), actual2);
        expected2.forEachKeyValue((Character argument1, String argument2) -> Assert.assertTrue(actual2.containsKeyAndValue(argument1, argument2)));
        Verify.assertSize(expected2.size(), actual3);
        expected2.forEachKeyValue((Character argument1, String argument2) -> Assert.assertTrue(actual3.containsKeyAndValue(argument1, argument2)));
        Verify.assertSize(expected4.size(), actual4);
        expected4.forEachKeyValue((Character argument1, String argument2) -> Assert.assertTrue(actual4.containsKeyAndValue(argument1, argument2)));
        Verify.assertSize(expected4.size(), actual5);
        expected4.forEachKeyValue((Character argument1, String argument2) -> Assert.assertTrue(actual5.containsKeyAndValue(argument1, argument2)));
    }

    @Test
    public void groupByEach() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 9.0f, "nine");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "one");
        Function<String, UnifiedSet<Character>> toChars = (String object) -> {
            UnifiedSet<Character> list = UnifiedSet.newSet();
            char[] chars = object.toCharArray();
            for (char aChar : chars) {
                list.add(aChar);
            }
            return list;
        };
        FastListMultimap<Character, String> expected = FastListMultimap.newMultimap(Tuples.pair('z', "zero"), Tuples.pair('e', "zero"), Tuples.pair('r', "zero"), Tuples.pair('o', "zero"), Tuples.pair('n', "nine"), Tuples.pair('i', "nine"), Tuples.pair('e', "nine"));
        FastListMultimap<Character, String> expected2 = FastListMultimap.newMultimap(Tuples.pair('o', "one"), Tuples.pair('n', "one"), Tuples.pair('e', "one"));
        Multimap<Character, String> actual = map1.groupByEach(toChars);
        Multimap<Character, String> actual1 = map1.groupByEach(toChars, FastListMultimap.<Character, String>newMultimap());
        Multimap<Character, String> actual2 = map2.groupByEach(toChars);
        Multimap<Character, String> actual3 = map2.groupByEach(toChars, FastListMultimap.<Character, String>newMultimap());
        expected.forEachKeyValue((Character argument1, String argument2) -> Assert.assertTrue(actual.containsKeyAndValue(argument1, argument2)));
        expected.forEachKeyValue((Character argument1, String argument2) -> Assert.assertTrue(actual1.containsKeyAndValue(argument1, argument2)));
        expected2.forEachKeyValue((Character argument1, String argument2) -> Assert.assertTrue(actual2.containsKeyAndValue(argument1, argument2)));
        expected2.forEachKeyValue((Character argument1, String argument2) -> Assert.assertTrue(actual3.containsKeyAndValue(argument1, argument2)));
    }

    @Test
    public void groupByUniqueKey() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one", 2.0f, "two");
        FloatObjectMap<String> map2 = this.newWithKeysValues(2.0f, "two");
        Function<String, Character> firstChar = (String object) -> object.charAt(0);
        Assert.assertEquals(UnifiedMap.newWithKeysValues('z', "zero", 'o', "one", 't', "two"), map1.groupByUniqueKey(firstChar));
        Assert.assertEquals(UnifiedMap.newWithKeysValues('t', "two"), map2.groupByUniqueKey(firstChar));
    }

    @Test(expected = IllegalStateException.class)
    public void groupByUniqueKey_throws() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one");
        Function<String, Character> firstChar = (String object) -> 'a';
        map1.groupByUniqueKey(firstChar);
    }

    @Test
    public void groupByUniqueKey_target() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one");
        FloatObjectMap<String> map2 = this.newWithKeysValues(0.0f, "zero");
        Function<String, Character> firstChar = (String object) -> object.charAt(0);
        Assert.assertEquals(UnifiedMap.newWithKeysValues('z', "zero", 'o', "one", 't', "two"), map1.groupByUniqueKey(firstChar, UnifiedMap.newWithKeysValues('t', "two")));
        Assert.assertEquals(UnifiedMap.newWithKeysValues('z', "zero", 't', "two"), map2.groupByUniqueKey(firstChar, UnifiedMap.newWithKeysValues('t', "two")));
    }

    @Test(expected = IllegalStateException.class)
    public void groupByUniqueKey_target_throws_1() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one");
        Function<String, Character> firstChar = (String object) -> object.charAt(0);
        map1.groupByUniqueKey(firstChar, UnifiedMap.newWithKeysValues('z', "zero"));
    }

    @Test(expected = IllegalStateException.class)
    public void groupByUniqueKey_target_throws_2() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero");
        Function<String, Character> firstChar = (String object) -> object.charAt(0);
        map1.groupByUniqueKey(firstChar, UnifiedMap.newWithKeysValues('z', "zero"));
    }

    @Test(expected = IllegalStateException.class)
    public void groupByUniqueKey_target_throws_3() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(2.0f, "two");
        Function<String, Character> firstChar = (String object) -> object.charAt(0);
        map1.groupByUniqueKey(firstChar, UnifiedMap.newWithKeysValues('t', "two"));
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", this.getEmptyMap().makeString());
        Assert.assertEquals("zero", this.newWithKeysValues(0.0f, "zero").makeString());
        Assert.assertEquals("one", this.newWithKeysValues(1.0f, "one").makeString());
        Assert.assertEquals("five", this.newWithKeysValues(5.0f, "five").makeString());
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one");
        Assert.assertTrue(map1.makeString(), "zero, one".equals(map1.makeString()) || "one, zero".equals(map1.makeString()));
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "one", 32.0f, "thirtyTwo");
        Assert.assertTrue(map2.makeString("[", "/", "]"), "[one/thirtyTwo]".equals(map2.makeString("[", "/", "]")) || "[thirtyTwo/one]".equals(map2.makeString("[", "/", "]")));
        FloatObjectMap<String> map3 = this.newWithKeysValues(0.0f, "zero", 32.0f, "thirtyTwo");
        Assert.assertTrue(map3.makeString("~"), "zero~thirtyTwo".equals(map3.makeString("~")) || "thirtyTwo~zero".equals(map3.makeString("~")));
        FloatObjectMap<String> map4 = this.newWithKeysValues(32.0f, "thirtyTwo", 33.0f, "thirtyThree");
        Assert.assertTrue(map4.makeString("[", ", ", "]"), "[thirtyTwo, thirtyThree]".equals(map4.makeString("[", ", ", "]")) || "[thirtyThree, thirtyTwo]".equals(map4.makeString("[", ", ", "]")));
    }

    @Test
    public void appendString() {
        Appendable appendable = new StringBuilder();
        this.getEmptyMap().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        Appendable appendable0 = new StringBuilder();
        this.newWithKeysValues(0.0f, "zero").appendString(appendable0);
        Assert.assertEquals("zero", appendable0.toString());
        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues(1.0f, "one").appendString(appendable1);
        Assert.assertEquals("one", appendable1.toString());
        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues(5.0f, "five").appendString(appendable2);
        Assert.assertEquals("five", appendable2.toString());
        Appendable appendable3 = new StringBuilder();
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one");
        map1.appendString(appendable3);
        Assert.assertTrue(appendable3.toString(), "zero, one".equals(appendable3.toString()) || "one, zero".equals(appendable3.toString()));
        Appendable appendable4 = new StringBuilder();
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "one", 32.0f, "thirtyTwo");
        map2.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(appendable4.toString(), "[one/thirtyTwo]".equals(appendable4.toString()) || "[thirtyTwo/one]".equals(appendable4.toString()));
        Appendable appendable5 = new StringBuilder();
        FloatObjectMap<String> map3 = this.newWithKeysValues(1.0f, "one", 32.0f, "thirtyTwo");
        map3.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(appendable5.toString(), "[one/thirtyTwo]".equals(appendable5.toString()) || "[thirtyTwo/one]".equals(appendable5.toString()));
        Appendable appendable6 = new StringBuilder();
        map3.appendString(appendable6, "/");
        Assert.assertTrue(appendable6.toString(), "one/thirtyTwo".equals(appendable6.toString()) || "thirtyTwo/one".equals(appendable6.toString()));
    }

    @Test
    public void tap() {
        StringBuilder[] concat = new StringBuilder[4];
        concat[0] = new StringBuilder();
        concat[1] = new StringBuilder();
        concat[2] = new StringBuilder();
        concat[3] = new StringBuilder();
        FloatObjectMap<String> map1 = this.newWithKeysValues(1.0f, "one", 5.0f, "five");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "one", 0.0f, "zero");
        FloatObjectMap<String> map3 = this.newWithKeysValues(2.0f, "two", 5.0f, "five");
        FloatObjectMap<String> map4 = this.newWithKeysValues(0.0f, "zero", 5.0f, "five");
        Assert.assertSame(map1, map1.tap(concat[0]::append));
        Assert.assertSame(map2, map2.tap(concat[1]::append));
        Assert.assertSame(map3, map3.tap(concat[2]::append));
        Assert.assertSame(map4, map4.tap(concat[3]::append));
        Assert.assertTrue(concat[0].toString(), "onefive".equals(concat[0].toString()) || "fiveone".equals(concat[0].toString()));
        Assert.assertTrue(concat[1].toString(), "onezero".equals(concat[1].toString()) || "zeroone".equals(concat[1].toString()));
        Assert.assertTrue(concat[2].toString(), "twofive".equals(concat[2].toString()) || "fivetwo".equals(concat[2].toString()));
        Assert.assertTrue(concat[3].toString(), "zerofive".equals(concat[3].toString()) || "fivezero".equals(concat[3].toString()));
    }

    @Test
    public void forEach() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(1.0f, "one", 5.0f, "five");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "one", 0.0f, "zero");
        FloatObjectMap<String> map3 = this.newWithKeysValues(2.0f, "two", 5.0f, "five");
        FloatObjectMap<String> map4 = this.newWithKeysValues(0.0f, "zero", 5.0f, "five");
        String[] concat = { "", "", "", "" };
        map1.forEach(Procedures.cast(each -> concat[0] += each));
        map2.forEach(Procedures.cast(each -> concat[1] += each));
        map3.forEach(Procedures.cast(each -> concat[2] += each));
        map4.forEach(Procedures.cast(each -> concat[3] += each));
        Assert.assertTrue(concat[0], "onefive".equals(concat[0]) || "fiveone".equals(concat[0]));
        Assert.assertTrue(concat[1], "onezero".equals(concat[1]) || "zeroone".equals(concat[1]));
        Assert.assertTrue(concat[2], "twofive".equals(concat[2]) || "fivetwo".equals(concat[2]));
        Assert.assertTrue(concat[3], "zerofive".equals(concat[3]) || "fivezero".equals(concat[3]));
    }

    @Test
    public void forEachWithIndex() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(1.0f, "one", 5.0f, "five");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "one", 0.0f, "zero");
        FloatObjectMap<String> map3 = this.newWithKeysValues(2.0f, "two", 5.0f, "five");
        FloatObjectMap<String> map4 = this.newWithKeysValues(0.0f, "zero", 5.0f, "five");
        String[] concat = { "", "", "", "" };
        map1.forEachWithIndex((String each, int parameter) -> {
            concat[0] += each;
            concat[0] += parameter;
        });
        map2.forEachWithIndex((String each, int parameter) -> {
            concat[1] += each;
            concat[1] += parameter;
        });
        map3.forEachWithIndex((String each, int parameter) -> {
            concat[2] += each;
            concat[2] += parameter;
        });
        map4.forEachWithIndex((String each, int parameter) -> {
            concat[3] += each;
            concat[3] += parameter;
        });
        Assert.assertTrue(concat[0], "one0five1".equals(concat[0]) || "five0one1".equals(concat[0]));
        Assert.assertTrue(concat[1], "one0zero1".equals(concat[1]) || "zero0one1".equals(concat[1]));
        Assert.assertTrue(concat[2], "two0five1".equals(concat[2]) || "five0two1".equals(concat[2]));
        Assert.assertTrue(concat[3], "zero0five1".equals(concat[3]) || "five0zero1".equals(concat[3]));
    }

    @Test
    public void forEachWith() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(1.0f, "one", 5.0f, "five");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "one", 0.0f, "zero");
        FloatObjectMap<String> map3 = this.newWithKeysValues(2.0f, "two", 5.0f, "five");
        FloatObjectMap<String> map4 = this.newWithKeysValues(0.0f, "zero", 5.0f, "five");
        String[] concat = { "", "", "", "" };
        map1.forEachWith((String argument1, String argument2) -> {
            concat[0] += argument1;
            concat[0] += argument2;
        }, "-");
        map2.forEachWith((String argument1, String argument2) -> {
            concat[1] += argument1;
            concat[1] += argument2;
        }, "-");
        map3.forEachWith((String argument1, String argument2) -> {
            concat[2] += argument1;
            concat[2] += argument2;
        }, "-");
        map4.forEachWith((String argument1, String argument2) -> {
            concat[3] += argument1;
            concat[3] += argument2;
        }, "-");
        Assert.assertTrue(concat[0], "one-five-".equals(concat[0]) || "five-one-".equals(concat[0]));
        Assert.assertTrue(concat[1], "one-zero-".equals(concat[1]) || "zero-one-".equals(concat[1]));
        Assert.assertTrue(concat[2], "two-five-".equals(concat[2]) || "five-two-".equals(concat[2]));
        Assert.assertTrue(concat[3], "zero-five-".equals(concat[3]) || "five-zero-".equals(concat[3]));
    }

    @Test
    public void iterator() {
        MutableSet<String> expected = UnifiedSet.newSetWith("zero", "thirtyOne", "thirtyTwo");
        MutableSet<String> actual = UnifiedSet.newSet();
        Iterator<String> iterator = this.classUnderTest().iterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(expected, actual);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableFloatObjectMap.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void toSortedBag() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 5.0f, "zero", 9.0f, "nine");
        FloatObjectMap<String> map2 = this.newWithKeysValues(1.0f, "one", 5.0f, "one", 9.0f, "nine");
        Verify.assertSortedBagsEqual(TreeBag.newBagWith("zero", "zero", "nine"), map1.toSortedBag());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparator.reverseOrder(), "one", "one", "nine"), map2.toSortedBag(Comparator.<String>reverseOrder()));
    }

    @Test
    public void toSortedBagBy() {
        FloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 5.0f, "zero", 9.0f, "nine");
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.byFunction(String::valueOf), "zero", "zero", "nine"), map1.toSortedBagBy(String::valueOf));
    }

    @Test
    public void stream() {
        FloatObjectMap<String> map = this.newWithKeysValues(1.0f, "1", 2.0f, "2", 9.0f, "9");
        Assert.assertEquals("129", CharAdapter.adapt(map.stream().reduce("", (r, s) -> r + s)).toSortedList().makeString(""));
        Assert.assertEquals(map.reduce((r, s) -> r + s), map.stream().reduce((r, s) -> r + s));
    }

    @Test
    public void parallelStream() {
        FloatObjectMap<String> map = this.newWithKeysValues(1.0f, "1", 2.0f, "2", 9.0f, "9");
        Assert.assertEquals("129", CharAdapter.adapt(map.parallelStream().reduce("", (r, s) -> r + s)).toSortedList().makeString(""));
        Assert.assertEquals(map.reduce((r, s) -> r + s), map.stream().reduce((r, s) -> r + s));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractFloatObjectMapTestCase instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
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
        public void benchmark_selectWith_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
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
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intInjectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longInjectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatInjectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleInjectInto);
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
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
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
        public void benchmark_rejectWith_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_withTarget);
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
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_not_only_one_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_not_only_one_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAny() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAny);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArguments);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
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
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_throws_negative_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_throws_negative_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_throws_zero_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_throws_zero_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateInPlaceBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateInPlaceBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateBy);
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
        public void benchmark_groupByUniqueKey_target_throws_1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_1);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_3() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_3);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractFloatObjectMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> selectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> collectBoolean_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> collectByte_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> collectChar_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> collectDouble_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> collectFloat_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> collectInt_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> collectLong_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> collectShort_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> intInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> longInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> floatInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> doubleInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> toImmutableSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> toImmutableSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> toImmutableSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> min_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> max_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> rejectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> containsAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> containsNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> chunk_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> chunk_throws_zero_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> groupByUniqueKey_target_throws_1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> groupByUniqueKey_target_throws_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> groupByUniqueKey_target_throws_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatObjectMapTestCase> parallelStream;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractFloatObjectMapTestCase::keySet;
            this.payloads.values = AbstractFloatObjectMapTestCase::values;
            this.payloads.select = AbstractFloatObjectMapTestCase::select;
            this.payloads.selectWith = AbstractFloatObjectMapTestCase::selectWith;
            this.payloads.selectWith_withTarget = AbstractFloatObjectMapTestCase::selectWith_withTarget;
            this.payloads.selectInstancesOf = AbstractFloatObjectMapTestCase::selectInstancesOf;
            this.payloads.collect = AbstractFloatObjectMapTestCase::collect;
            this.payloads.collectBoolean = AbstractFloatObjectMapTestCase::collectBoolean;
            this.payloads.collectBoolean_withTarget = AbstractFloatObjectMapTestCase::collectBoolean_withTarget;
            this.payloads.collectByte = AbstractFloatObjectMapTestCase::collectByte;
            this.payloads.collectByte_withTarget = AbstractFloatObjectMapTestCase::collectByte_withTarget;
            this.payloads.collectChar = AbstractFloatObjectMapTestCase::collectChar;
            this.payloads.collectChar_withTarget = AbstractFloatObjectMapTestCase::collectChar_withTarget;
            this.payloads.collectDouble = AbstractFloatObjectMapTestCase::collectDouble;
            this.payloads.collectDouble_withTarget = AbstractFloatObjectMapTestCase::collectDouble_withTarget;
            this.payloads.collectFloat = AbstractFloatObjectMapTestCase::collectFloat;
            this.payloads.collectFloat_withTarget = AbstractFloatObjectMapTestCase::collectFloat_withTarget;
            this.payloads.collectInt = AbstractFloatObjectMapTestCase::collectInt;
            this.payloads.collectInt_withTarget = AbstractFloatObjectMapTestCase::collectInt_withTarget;
            this.payloads.collectLong = AbstractFloatObjectMapTestCase::collectLong;
            this.payloads.collectLong_withTarget = AbstractFloatObjectMapTestCase::collectLong_withTarget;
            this.payloads.collectShort = AbstractFloatObjectMapTestCase::collectShort;
            this.payloads.collectShort_withTarget = AbstractFloatObjectMapTestCase::collectShort_withTarget;
            this.payloads.collectWith = AbstractFloatObjectMapTestCase::collectWith;
            this.payloads.collectWithTarget = AbstractFloatObjectMapTestCase::collectWithTarget;
            this.payloads.collectIf = AbstractFloatObjectMapTestCase::collectIf;
            this.payloads.flatCollect = AbstractFloatObjectMapTestCase::flatCollect;
            this.payloads.detect = AbstractFloatObjectMapTestCase::detect;
            this.payloads.detectWith = AbstractFloatObjectMapTestCase::detectWith;
            this.payloads.detectOptional = AbstractFloatObjectMapTestCase::detectOptional;
            this.payloads.detectWithOptional = AbstractFloatObjectMapTestCase::detectWithOptional;
            this.payloads.detectIfNone = AbstractFloatObjectMapTestCase::detectIfNone;
            this.payloads.detectWithIfNone = AbstractFloatObjectMapTestCase::detectWithIfNone;
            this.payloads.count = AbstractFloatObjectMapTestCase::count;
            this.payloads.countWith = AbstractFloatObjectMapTestCase::countWith;
            this.payloads.anySatisfy = AbstractFloatObjectMapTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractFloatObjectMapTestCase::anySatisfyWith;
            this.payloads.allSatisfy = AbstractFloatObjectMapTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractFloatObjectMapTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractFloatObjectMapTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractFloatObjectMapTestCase::noneSatisfyWith;
            this.payloads.injectInto = AbstractFloatObjectMapTestCase::injectInto;
            this.payloads.intInjectInto = AbstractFloatObjectMapTestCase::intInjectInto;
            this.payloads.longInjectInto = AbstractFloatObjectMapTestCase::longInjectInto;
            this.payloads.floatInjectInto = AbstractFloatObjectMapTestCase::floatInjectInto;
            this.payloads.doubleInjectInto = AbstractFloatObjectMapTestCase::doubleInjectInto;
            this.payloads.toList = AbstractFloatObjectMapTestCase::toList;
            this.payloads.toSortedList = AbstractFloatObjectMapTestCase::toSortedList;
            this.payloads.toSet = AbstractFloatObjectMapTestCase::toSet;
            this.payloads.toSortedSet = AbstractFloatObjectMapTestCase::toSortedSet;
            this.payloads.toBag = AbstractFloatObjectMapTestCase::toBag;
            this.payloads.toMap = AbstractFloatObjectMapTestCase::toMap;
            this.payloads.toMapTarget = AbstractFloatObjectMapTestCase::toMapTarget;
            this.payloads.toSortedMap = AbstractFloatObjectMapTestCase::toSortedMap;
            this.payloads.toImmutableList = AbstractFloatObjectMapTestCase::toImmutableList;
            this.payloads.toImmutableSortedList = AbstractFloatObjectMapTestCase::toImmutableSortedList;
            this.payloads.toImmutableSet = AbstractFloatObjectMapTestCase::toImmutableSet;
            this.payloads.toImmutableSortedSet = AbstractFloatObjectMapTestCase::toImmutableSortedSet;
            this.payloads.toImmutableBag = AbstractFloatObjectMapTestCase::toImmutableBag;
            this.payloads.toImmutableSortedBag = AbstractFloatObjectMapTestCase::toImmutableSortedBag;
            this.payloads.toImmutableSortedBagBy = AbstractFloatObjectMapTestCase::toImmutableSortedBagBy;
            this.payloads.toArray = AbstractFloatObjectMapTestCase::toArray;
            this.payloads.min = AbstractFloatObjectMapTestCase::min;
            this.payloads.min_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatObjectMapTestCase::min_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.maxBy = AbstractFloatObjectMapTestCase::maxBy;
            this.payloads.max = AbstractFloatObjectMapTestCase::max;
            this.payloads.max_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatObjectMapTestCase::max_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.minBy = AbstractFloatObjectMapTestCase::minBy;
            this.payloads.sumOfInt = AbstractFloatObjectMapTestCase::sumOfInt;
            this.payloads.sumOfLong = AbstractFloatObjectMapTestCase::sumOfLong;
            this.payloads.sumOfDouble = AbstractFloatObjectMapTestCase::sumOfDouble;
            this.payloads.sumOfFloat = AbstractFloatObjectMapTestCase::sumOfFloat;
            this.payloads.sumByInt = AbstractFloatObjectMapTestCase::sumByInt;
            this.payloads.sumByFloat = AbstractFloatObjectMapTestCase::sumByFloat;
            this.payloads.sumByLong = AbstractFloatObjectMapTestCase::sumByLong;
            this.payloads.sumByDouble = AbstractFloatObjectMapTestCase::sumByDouble;
            this.payloads.keysView = AbstractFloatObjectMapTestCase::keysView;
            this.payloads.reject = AbstractFloatObjectMapTestCase::reject;
            this.payloads.rejectWith = AbstractFloatObjectMapTestCase::rejectWith;
            this.payloads.rejectWith_withTarget = AbstractFloatObjectMapTestCase::rejectWith_withTarget;
            this.payloads.partition = AbstractFloatObjectMapTestCase::partition;
            this.payloads.partitionWith = AbstractFloatObjectMapTestCase::partitionWith;
            this.payloads.get = AbstractFloatObjectMapTestCase::get;
            this.payloads.getIfAbsent = AbstractFloatObjectMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractFloatObjectMapTestCase::containsKey;
            this.payloads.containsValue = AbstractFloatObjectMapTestCase::containsValue;
            this.payloads.forEachValue = AbstractFloatObjectMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractFloatObjectMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractFloatObjectMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractFloatObjectMapTestCase::injectIntoKeyValue;
            this.payloads.size = AbstractFloatObjectMapTestCase::size;
            this.payloads.isEmpty = AbstractFloatObjectMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractFloatObjectMapTestCase::notEmpty;
            this.payloads.getFirst = AbstractFloatObjectMapTestCase::getFirst;
            this.payloads.getLast = AbstractFloatObjectMapTestCase::getLast;
            this.payloads.getOnly = AbstractFloatObjectMapTestCase::getOnly;
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatObjectMapTestCase::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatObjectMapTestCase::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.contains = AbstractFloatObjectMapTestCase::contains;
            this.payloads.containsAllIterable = AbstractFloatObjectMapTestCase::containsAllIterable;
            this.payloads.containsAll = AbstractFloatObjectMapTestCase::containsAll;
            this.payloads.containsAnyIterable = AbstractFloatObjectMapTestCase::containsAnyIterable;
            this.payloads.containsAny = AbstractFloatObjectMapTestCase::containsAny;
            this.payloads.containsNoneIterable = AbstractFloatObjectMapTestCase::containsNoneIterable;
            this.payloads.containsNone = AbstractFloatObjectMapTestCase::containsNone;
            this.payloads.containsAllArguments = AbstractFloatObjectMapTestCase::containsAllArguments;
            this.payloads.testEquals = AbstractFloatObjectMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractFloatObjectMapTestCase::testHashCode;
            this.payloads.testToString = AbstractFloatObjectMapTestCase::testToString;
            this.payloads.zip = AbstractFloatObjectMapTestCase::zip;
            this.payloads.zipWithIndex = AbstractFloatObjectMapTestCase::zipWithIndex;
            this.payloads.chunk = AbstractFloatObjectMapTestCase::chunk;
            this.payloads.chunk_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatObjectMapTestCase::chunk_throws_negative_size, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_throws_zero_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatObjectMapTestCase::chunk_throws_zero_size, java.lang.IllegalArgumentException.class);
            this.payloads.aggregateInPlaceBy = AbstractFloatObjectMapTestCase::aggregateInPlaceBy;
            this.payloads.aggregateBy = AbstractFloatObjectMapTestCase::aggregateBy;
            this.payloads.groupBy = AbstractFloatObjectMapTestCase::groupBy;
            this.payloads.groupByEach = AbstractFloatObjectMapTestCase::groupByEach;
            this.payloads.groupByUniqueKey = AbstractFloatObjectMapTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatObjectMapTestCase::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = AbstractFloatObjectMapTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_1 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatObjectMapTestCase::groupByUniqueKey_target_throws_1, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_2 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatObjectMapTestCase::groupByUniqueKey_target_throws_2, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_3 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatObjectMapTestCase::groupByUniqueKey_target_throws_3, java.lang.IllegalStateException.class);
            this.payloads.makeString = AbstractFloatObjectMapTestCase::makeString;
            this.payloads.appendString = AbstractFloatObjectMapTestCase::appendString;
            this.payloads.tap = AbstractFloatObjectMapTestCase::tap;
            this.payloads.forEach = AbstractFloatObjectMapTestCase::forEach;
            this.payloads.forEachWithIndex = AbstractFloatObjectMapTestCase::forEachWithIndex;
            this.payloads.forEachWith = AbstractFloatObjectMapTestCase::forEachWith;
            this.payloads.iterator = AbstractFloatObjectMapTestCase::iterator;
            this.payloads.toImmutable = AbstractFloatObjectMapTestCase::toImmutable;
            this.payloads.toSortedBag = AbstractFloatObjectMapTestCase::toSortedBag;
            this.payloads.toSortedBagBy = AbstractFloatObjectMapTestCase::toSortedBagBy;
            this.payloads.stream = AbstractFloatObjectMapTestCase::stream;
            this.payloads.parallelStream = AbstractFloatObjectMapTestCase::parallelStream;
        }
    }
}
