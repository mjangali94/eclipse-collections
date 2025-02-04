/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable.primitive;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.block.function.primitive.BooleanFunction;
import org.eclipse.collections.api.block.function.primitive.BooleanFunction0;
import org.eclipse.collections.api.block.function.primitive.BooleanToBooleanFunction;
import org.eclipse.collections.api.block.function.primitive.ByteToBooleanFunction;
import org.eclipse.collections.api.iterator.MutableBooleanIterator;
import org.eclipse.collections.api.map.primitive.MutableByteBooleanMap;
import org.eclipse.collections.api.tuple.primitive.ByteBooleanPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractByteBooleanMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitiveBooleanMapTestCase.stg.
 */
public abstract class AbstractMutableByteBooleanMapTestCase extends AbstractByteBooleanMapTestCase {

    protected final MutableByteBooleanMap map = this.classUnderTest();

    protected static ByteArrayList generateCollisions() {
        ByteArrayList collisions = new ByteArrayList();
        ByteBooleanHashMap hashMap = new ByteBooleanHashMap();
        for (byte each = (byte) 2; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask((byte) 2)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Override
    protected abstract MutableByteBooleanMap classUnderTest();

    @Override
    protected abstract MutableByteBooleanMap newWithKeysValues(byte key1, boolean value1);

    @Override
    protected abstract MutableByteBooleanMap newWithKeysValues(byte key1, boolean value1, byte key2, boolean value2);

    @Override
    protected abstract MutableByteBooleanMap newWithKeysValues(byte key1, boolean value1, byte key2, boolean value2, byte key3, boolean value3);

    @Override
    protected abstract MutableByteBooleanMap newWithKeysValues(byte key1, boolean value1, byte key2, boolean value2, byte key3, boolean value3, byte key4, boolean value4);

    @Override
    protected abstract MutableByteBooleanMap getEmptyMap();

    @Test
    public void clear() {
        this.map.clear();
        Assert.assertEquals(new ByteBooleanHashMap(), this.map);
        this.map.put((byte) 1, false);
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 1, false), this.map);
        this.map.clear();
        Assert.assertEquals(new ByteBooleanHashMap(), this.map);
        this.map.put((byte) 33, false);
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 33, false), this.map);
        this.map.clear();
        Assert.assertEquals(new ByteBooleanHashMap(), this.map);
    }

    @Test
    public void removeKey() {
        this.map.removeKey((byte) 5);
        this.map.removeKey((byte) 50);
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 0, true, (byte) 31, false, (byte) 32, true), this.map);
        this.map.removeKey((byte) 0);
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 31, false, (byte) 32, true), this.map);
        this.map.removeKey((byte) 31);
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 32, true), this.map);
        this.map.removeKey((byte) 32);
        Assert.assertEquals(new ByteBooleanHashMap(), this.map);
        this.map.removeKey((byte) 0);
        this.map.removeKey((byte) 31);
        this.map.removeKey((byte) 32);
        Assert.assertEquals(new ByteBooleanHashMap(), this.map);
        Verify.assertEmpty(this.map);
        this.map.put(AbstractMutableByteBooleanMapTestCase.generateCollisions().get(0), true);
        this.map.put(AbstractMutableByteBooleanMapTestCase.generateCollisions().get(1), false);
        Assert.assertTrue(this.map.get(AbstractMutableByteBooleanMapTestCase.generateCollisions().get(0)));
        this.map.removeKey(AbstractMutableByteBooleanMapTestCase.generateCollisions().get(0));
        Assert.assertFalse(this.map.get(AbstractMutableByteBooleanMapTestCase.generateCollisions().get(0)));
        Assert.assertFalse(this.map.get(AbstractMutableByteBooleanMapTestCase.generateCollisions().get(1)));
        this.map.removeKey(AbstractMutableByteBooleanMapTestCase.generateCollisions().get(1));
        Assert.assertFalse(this.map.get(AbstractMutableByteBooleanMapTestCase.generateCollisions().get(1)));
        MutableByteBooleanMap map1 = this.newWithKeysValues((byte) 1, true);
        map1.removeKey((byte) 1);
        Assert.assertEquals(new ByteBooleanHashMap(), map1);
    }

    @Test
    public void removeKeyIfAbsent() {
        Assert.assertTrue(this.map.removeKeyIfAbsent((byte) 5, true));
        Assert.assertFalse(this.map.removeKeyIfAbsent((byte) 50, false));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 0, true, (byte) 31, false, (byte) 32, true), this.map);
        Assert.assertTrue(this.map.removeKeyIfAbsent((byte) 0, false));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 31, false, (byte) 32, true), this.map);
        Assert.assertFalse(this.map.removeKeyIfAbsent((byte) 31, true));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 32, true), this.map);
        Assert.assertTrue(this.map.removeKeyIfAbsent((byte) 32, false));
        Assert.assertEquals(new ByteBooleanHashMap(), this.map);
        Assert.assertTrue(this.map.removeKeyIfAbsent((byte) 0, true));
        Assert.assertFalse(this.map.removeKeyIfAbsent((byte) 31, false));
        Assert.assertFalse(this.map.removeKeyIfAbsent((byte) 32, false));
        Assert.assertEquals(new ByteBooleanHashMap(), this.map);
        Verify.assertEmpty(this.map);
        this.map.put(AbstractMutableByteBooleanMapTestCase.generateCollisions().get(0), true);
        this.map.put(AbstractMutableByteBooleanMapTestCase.generateCollisions().get(1), false);
        Assert.assertTrue(this.map.get(AbstractMutableByteBooleanMapTestCase.generateCollisions().get(0)));
        Assert.assertTrue(this.map.removeKeyIfAbsent(AbstractMutableByteBooleanMapTestCase.generateCollisions().get(0), false));
        Assert.assertFalse(this.map.get(AbstractMutableByteBooleanMapTestCase.generateCollisions().get(0)));
        Assert.assertFalse(this.map.get(AbstractMutableByteBooleanMapTestCase.generateCollisions().get(1)));
        Assert.assertFalse(this.map.removeKeyIfAbsent(AbstractMutableByteBooleanMapTestCase.generateCollisions().get(1), true));
        Assert.assertFalse(this.map.get(AbstractMutableByteBooleanMapTestCase.generateCollisions().get(1)));
        Assert.assertTrue(this.classUnderTest().withKeyValue((byte) 1, true).removeKeyIfAbsent((byte) 0, false));
        MutableByteBooleanMap map1 = this.classUnderTest().withKeyValue((byte) 1, true);
        Assert.assertTrue(map1.removeKeyIfAbsent((byte) 1, false));
        Assert.assertTrue(map1.removeKeyIfAbsent((byte) 0, false));
        Assert.assertFalse(map1.removeKeyIfAbsent((byte) 1, false));
        MutableByteBooleanMap map2 = this.newWithKeysValues((byte) 1, true);
        Assert.assertTrue(map2.removeKeyIfAbsent((byte) 1, false));
    }

    @Test
    public void put() {
        this.map.put((byte) 0, false);
        this.map.put((byte) 31, true);
        this.map.put((byte) 32, false);
        MutableByteBooleanMap expected = this.newWithKeysValues((byte) 0, false, (byte) 31, true, (byte) 32, false);
        Assert.assertEquals(expected, this.map);
        this.map.put((byte) 1, true);
        expected.put((byte) 1, true);
        Assert.assertEquals(expected, this.map);
        this.map.put((byte) 33, false);
        expected.put((byte) 33, false);
        Assert.assertEquals(expected, this.map);
        this.map.put((byte) 30, true);
        expected.put((byte) 30, true);
        Assert.assertEquals(expected, this.map);
    }

    @Test
    public void updateValues() {
        MutableByteBooleanMap map1 = this.newWithKeysValues((byte) 0, true, (byte) 1, false, (byte) 2, false);
        map1.updateValues((k, v) -> v);
        MutableByteBooleanMap expected1 = this.newWithKeysValues((byte) 0, true, (byte) 1, false, (byte) 2, false);
        Assert.assertEquals(expected1, map1);
        MutableByteBooleanMap map2 = this.newWithKeysValues((byte) 0, true, (byte) 1, false, (byte) 2, false);
        map2.updateValues((k, v) -> !v);
        MutableByteBooleanMap expected2 = this.newWithKeysValues((byte) 0, false, (byte) 1, true, (byte) 2, true);
        Assert.assertEquals(expected2, map2);
        MutableByteBooleanMap map3 = this.newWithKeysValues((byte) 0, true, (byte) 1, false, (byte) 2, false);
        map3.updateValues((k, v) -> k == (byte) 2 ? true : v);
        MutableByteBooleanMap expected3 = this.newWithKeysValues((byte) 0, true, (byte) 1, false, (byte) 2, true);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        byte collision1 = AbstractMutableByteBooleanMapTestCase.generateCollisions().getFirst();
        byte collision2 = AbstractMutableByteBooleanMapTestCase.generateCollisions().get(1);
        byte collision3 = AbstractMutableByteBooleanMapTestCase.generateCollisions().get(2);
        byte collision4 = AbstractMutableByteBooleanMapTestCase.generateCollisions().get(3);
        MutableByteBooleanMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, true);
        hashMap.put(collision2, false);
        hashMap.put(collision3, true);
        Assert.assertFalse(hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, false);
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues(collision1, true, collision3, true, collision4, false), hashMap);
        MutableByteBooleanMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, false);
        hashMap1.put(collision2, true);
        hashMap1.put(collision3, false);
        Assert.assertFalse(hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, true);
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues(collision2, true, collision3, false, collision4, true), hashMap1);
        MutableByteBooleanMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, true);
        hashMap2.put(collision2, false);
        hashMap2.put(collision3, true);
        Assert.assertTrue(hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, false);
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues(collision1, true, collision2, false, collision4, false), hashMap2);
    }

    @Override
    @Test
    public void get() {
        super.get();
        this.map.put((byte) 0, false);
        Assert.assertFalse(this.map.get((byte) 0));
        this.map.put((byte) 1, true);
        Assert.assertTrue(this.map.get((byte) 1));
        this.map.put((byte) 5, true);
        Assert.assertTrue(this.map.get((byte) 5));
        this.map.put((byte) 35, false);
        Assert.assertFalse(this.map.get((byte) 35));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        this.map.removeKey((byte) 0);
        Assert.assertFalse(this.map.getIfAbsent((byte) 0, false));
        Assert.assertTrue(this.map.getIfAbsent((byte) 0, true));
        Assert.assertFalse(this.map.getIfAbsent((byte) 1, false));
        Assert.assertTrue(this.map.getIfAbsent((byte) 1, true));
        Assert.assertFalse(this.map.getIfAbsent((byte) 33, false));
        Assert.assertTrue(this.map.getIfAbsent((byte) 33, true));
        this.map.put((byte) 0, false);
        Assert.assertFalse(this.map.getIfAbsent((byte) 0, true));
        this.map.put((byte) 1, true);
        Assert.assertTrue(this.map.getIfAbsent((byte) 1, false));
        this.map.put((byte) 5, false);
        Assert.assertFalse(this.map.getIfAbsent((byte) 5, true));
        this.map.put((byte) 35, true);
        Assert.assertTrue(this.map.getIfAbsent((byte) 35, false));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        this.map.removeKey((byte) 0);
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((byte) 0));
        this.map.put((byte) 0, false);
        Assert.assertFalse(this.map.getOrThrow((byte) 0));
        this.map.put((byte) 1, true);
        Assert.assertTrue(this.map.getOrThrow((byte) 1));
        this.map.put((byte) 5, false);
        Assert.assertFalse(this.map.getOrThrow((byte) 5));
        this.map.put((byte) 35, true);
        Assert.assertTrue(this.map.getOrThrow((byte) 35));
    }

    @Test
    public void getIfAbsentPut() {
        MutableByteBooleanMap map1 = this.getEmptyMap();
        Assert.assertTrue(map1.getIfAbsentPut((byte) 0, true));
        Assert.assertTrue(map1.getIfAbsentPut((byte) 0, false));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 0, true), map1);
        Assert.assertFalse(map1.getIfAbsentPut((byte) 1, false));
        Assert.assertFalse(map1.getIfAbsentPut((byte) 1, true));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 0, true, (byte) 1, false), map1);
        MutableByteBooleanMap map2 = this.getEmptyMap();
        Assert.assertTrue(map2.getIfAbsentPut((byte) 1, true));
        Assert.assertTrue(map2.getIfAbsentPut((byte) 1, false));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 1, true), map2);
        Assert.assertFalse(map2.getIfAbsentPut((byte) 0, false));
        Assert.assertFalse(map2.getIfAbsentPut((byte) 0, true));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 0, false, (byte) 1, true), map2);
        MutableByteBooleanMap map3 = this.getEmptyMap();
        Assert.assertTrue(map3.getIfAbsentPut((byte) 32, true));
        Assert.assertTrue(map3.getIfAbsentPut((byte) 32, false));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 32, true), map3);
        MutableByteBooleanMap map4 = this.getEmptyMap();
        Assert.assertFalse(map4.getIfAbsentPut((byte) 33, false));
        Assert.assertFalse(map4.getIfAbsentPut((byte) 33, true));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 33, false), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        BooleanFunction0 factory = () -> true;
        BooleanFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableByteBooleanMap map1 = this.getEmptyMap();
        Assert.assertTrue(map1.getIfAbsentPut((byte) 0, factory));
        Assert.assertTrue(map1.getIfAbsentPut((byte) 0, factoryThrows));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 0, true), map1);
        Assert.assertTrue(map1.getIfAbsentPut((byte) 1, factory));
        Assert.assertTrue(map1.getIfAbsentPut((byte) 1, factoryThrows));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 0, true, (byte) 1, true), map1);
        MutableByteBooleanMap map2 = this.getEmptyMap();
        Assert.assertTrue(map2.getIfAbsentPut((byte) 1, factory));
        Assert.assertTrue(map2.getIfAbsentPut((byte) 1, factoryThrows));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 1, true), map2);
        Assert.assertTrue(map2.getIfAbsentPut((byte) 0, factory));
        Assert.assertTrue(map2.getIfAbsentPut((byte) 0, factoryThrows));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 0, true, (byte) 1, true), map2);
        MutableByteBooleanMap map3 = this.getEmptyMap();
        Assert.assertTrue(map3.getIfAbsentPut((byte) 32, factory));
        Assert.assertTrue(map3.getIfAbsentPut((byte) 32, factoryThrows));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 32, true), map3);
        MutableByteBooleanMap map4 = this.getEmptyMap();
        Assert.assertTrue(map4.getIfAbsentPut((byte) 33, factory));
        Assert.assertTrue(map4.getIfAbsentPut((byte) 33, factoryThrows));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 33, true), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        BooleanFunction<String> functionLengthEven = (String string) -> (string.length() & 1) == (byte) 0;
        BooleanFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableByteBooleanMap map1 = this.getEmptyMap();
        Assert.assertTrue(map1.getIfAbsentPutWith((byte) 0, functionLengthEven, "12345678"));
        Assert.assertTrue(map1.getIfAbsentPutWith((byte) 0, functionThrows, "unused"));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 0, true), map1);
        Assert.assertFalse(map1.getIfAbsentPutWith((byte) 1, functionLengthEven, "123456789"));
        Assert.assertFalse(map1.getIfAbsentPutWith((byte) 1, functionThrows, "unused"));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 0, true, (byte) 1, false), map1);
        MutableByteBooleanMap map2 = this.getEmptyMap();
        Assert.assertTrue(map2.getIfAbsentPutWith((byte) 1, functionLengthEven, "12345678"));
        Assert.assertTrue(map2.getIfAbsentPutWith((byte) 1, functionThrows, "unused"));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 1, true), map2);
        Assert.assertFalse(map2.getIfAbsentPutWith((byte) 0, functionLengthEven, "123456789"));
        Assert.assertFalse(map2.getIfAbsentPutWith((byte) 0, functionThrows, "unused"));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 0, false, (byte) 1, true), map2);
        MutableByteBooleanMap map3 = this.getEmptyMap();
        Assert.assertTrue(map3.getIfAbsentPutWith((byte) 32, functionLengthEven, "12345678"));
        Assert.assertTrue(map3.getIfAbsentPutWith((byte) 32, functionThrows, "unused"));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 32, true), map3);
        MutableByteBooleanMap map4 = this.getEmptyMap();
        Assert.assertTrue(map4.getIfAbsentPutWith((byte) 33, functionLengthEven, "12345678"));
        Assert.assertTrue(map4.getIfAbsentPutWith((byte) 33, functionThrows, "unused"));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 33, true), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        ByteToBooleanFunction keyIsEven = (byte parameter) -> (parameter & 1) == (byte) 0;
        ByteToBooleanFunction functionThrows = (byte byteParameter) -> {
            throw new AssertionError();
        };
        MutableByteBooleanMap map1 = this.getEmptyMap();
        Assert.assertTrue(map1.getIfAbsentPutWithKey((byte) 0, keyIsEven));
        Assert.assertTrue(map1.getIfAbsentPutWithKey((byte) 0, functionThrows));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 0, true), map1);
        Assert.assertFalse(map1.getIfAbsentPutWithKey((byte) 1, keyIsEven));
        Assert.assertFalse(map1.getIfAbsentPutWithKey((byte) 1, functionThrows));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 0, true, (byte) 1, false), map1);
        MutableByteBooleanMap map2 = this.getEmptyMap();
        Assert.assertFalse(map2.getIfAbsentPutWithKey((byte) 1, keyIsEven));
        Assert.assertFalse(map2.getIfAbsentPutWithKey((byte) 1, functionThrows));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 1, false), map2);
        Assert.assertTrue(map2.getIfAbsentPutWithKey((byte) 0, keyIsEven));
        Assert.assertTrue(map2.getIfAbsentPutWithKey((byte) 0, functionThrows));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 0, true, (byte) 1, false), map2);
        MutableByteBooleanMap map3 = this.getEmptyMap();
        Assert.assertTrue(map3.getIfAbsentPutWithKey((byte) 32, keyIsEven));
        Assert.assertTrue(map3.getIfAbsentPutWithKey((byte) 32, functionThrows));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 32, true), map3);
        MutableByteBooleanMap map4 = this.getEmptyMap();
        Assert.assertFalse(map4.getIfAbsentPutWithKey((byte) 33, keyIsEven));
        Assert.assertFalse(map4.getIfAbsentPutWithKey((byte) 33, functionThrows));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 33, false), map4);
    }

    @Test
    public void updateValue() {
        BooleanToBooleanFunction flip = (boolean value) -> !value;
        MutableByteBooleanMap map1 = this.getEmptyMap();
        Assert.assertTrue(map1.updateValue((byte) 0, false, flip));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 0, true), map1);
        Assert.assertFalse(map1.updateValue((byte) 0, false, flip));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 0, false), map1);
        Assert.assertFalse(map1.updateValue((byte) 1, true, flip));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 0, false, (byte) 1, false), map1);
        Assert.assertTrue(map1.updateValue((byte) 1, true, flip));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 0, false, (byte) 1, true), map1);
        MutableByteBooleanMap map2 = this.getEmptyMap();
        Assert.assertTrue(map2.updateValue((byte) 1, false, flip));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 1, true), map2);
        Assert.assertFalse(map2.updateValue((byte) 1, false, flip));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 1, false), map2);
        Assert.assertFalse(map2.updateValue((byte) 0, true, flip));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 0, false, (byte) 1, false), map2);
        Assert.assertTrue(map2.updateValue((byte) 0, true, flip));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 0, true, (byte) 1, false), map2);
        MutableByteBooleanMap map3 = this.getEmptyMap();
        Assert.assertTrue(map3.updateValue((byte) 33, false, flip));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 33, true), map3);
        Assert.assertFalse(map3.updateValue((byte) 33, false, flip));
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 33, false), map3);
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        this.map.removeKey((byte) 0);
        Assert.assertFalse(this.map.containsKey((byte) 0));
        Assert.assertFalse(this.map.get((byte) 0));
        this.map.removeKey((byte) 0);
        Assert.assertFalse(this.map.containsKey((byte) 0));
        Assert.assertFalse(this.map.get((byte) 0));
        this.map.removeKey((byte) 1);
        Assert.assertFalse(this.map.containsKey((byte) 1));
        Assert.assertFalse(this.map.get((byte) 1));
        this.map.removeKey((byte) 31);
        Assert.assertFalse(this.map.containsKey((byte) 31));
        Assert.assertFalse(this.map.get((byte) 31));
        this.map.removeKey((byte) 32);
        Assert.assertFalse(this.map.containsKey((byte) 32));
        Assert.assertFalse(this.map.get((byte) 32));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        this.map.clear();
        this.map.put((byte) 35, true);
        Assert.assertTrue(this.map.containsValue(true));
        this.map.removeKey((byte) 35);
        Assert.assertFalse(this.map.containsValue(false));
        Assert.assertFalse(this.map.containsValue(true));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        this.map.clear();
        this.map.put((byte) 35, true);
        Assert.assertTrue(this.map.contains(true));
        this.map.removeKey((byte) 35);
        Assert.assertFalse(this.map.contains(false));
        Assert.assertFalse(this.map.contains(true));
    }

    @Override
    @Test
    public void containsAll() {
        super.containsAll();
        this.map.clear();
        this.map.put((byte) 5, true);
        Assert.assertTrue(this.map.containsAll(true));
        Assert.assertFalse(this.map.containsAll(true, false));
        Assert.assertFalse(this.map.containsAll(false, false));
        this.map.put((byte) 0, false);
        Assert.assertTrue(this.map.containsAll(false));
        Assert.assertTrue(this.map.containsAll(true, false));
        this.map.removeKey((byte) 5);
        Assert.assertFalse(this.map.containsAll(true));
        Assert.assertFalse(this.map.containsAll(true, false));
        Assert.assertTrue(this.map.containsAll(false, false));
        this.map.removeKey((byte) 0);
        Assert.assertFalse(this.map.containsAll(false, true));
    }

    @Override
    @Test
    public void containsAllIterable() {
        super.containsAllIterable();
        this.map.clear();
        this.map.put((byte) 5, true);
        Assert.assertTrue(this.map.containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertFalse(this.map.containsAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertFalse(this.map.containsAll(BooleanArrayList.newListWith(false, false)));
        this.map.put((byte) 0, false);
        Assert.assertTrue(this.map.containsAll(BooleanArrayList.newListWith(false)));
        Assert.assertTrue(this.map.containsAll(BooleanArrayList.newListWith(true, false)));
        this.map.removeKey((byte) 5);
        Assert.assertFalse(this.map.containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertFalse(this.map.containsAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertTrue(this.map.containsAll(BooleanArrayList.newListWith(false, false)));
        this.map.removeKey((byte) 0);
        Assert.assertFalse(this.map.containsAll(BooleanArrayList.newListWith(false, true)));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableByteBooleanMap hashMap1 = this.newWithKeysValues((byte) 1, true, (byte) 0, false);
        Verify.assertSize(2, hashMap1);
        hashMap1.removeKey((byte) 1);
        Verify.assertSize(1, hashMap1);
        hashMap1.removeKey((byte) 0);
        Verify.assertSize(0, hashMap1);
        MutableByteBooleanMap hashMap = this.newWithKeysValues((byte) 6, false, (byte) 5, true);
        hashMap.removeKey((byte) 5);
        Verify.assertSize(1, hashMap);
    }

    @Test
    public void withoutKey() {
        MutableByteBooleanMap map = this.newWithKeysValues((byte) 0, false, (byte) 1, true, (byte) 31, false, (byte) 32, true);
        MutableByteBooleanMap mapWithout = map.withoutKey((byte) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 0, false, (byte) 1, true, (byte) 31, false), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableByteBooleanMap map = this.newWithKeysValues((byte) 0, true, (byte) 1, false, (byte) 31, true, (byte) 32, false);
        MutableByteBooleanMap mapWithout = map.withoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 1, false, (byte) 31, true), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableByteBooleanMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((byte) 1, false), hashMap);
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 1, false), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableByteBooleanMap emptyMap = this.getEmptyMap();
        MutableByteBooleanMap partialMap = this.newWithKeysValues((byte) 1, true, (byte) 3, false);
        MutableByteBooleanMap completeMap = this.newWithKeysValues((byte) 1, true, (byte) 2, true, (byte) 3, false, (byte) 4, false);
        Iterable<ByteBooleanPair> emptyIterable = Iterables.iList();
        Iterable<ByteBooleanPair> partialIterable = Iterables.iList(PrimitiveTuples.pair((byte) 1, true), PrimitiveTuples.pair((byte) 3, false));
        Iterable<ByteBooleanPair> completeIterable = Iterables.iList(PrimitiveTuples.pair((byte) 1, true), PrimitiveTuples.pair((byte) 2, true), PrimitiveTuples.pair((byte) 3, false), PrimitiveTuples.pair((byte) 4, false));
        Assert.assertEquals(emptyMap, emptyMap.withAllKeyValues(emptyIterable));
        Assert.assertEquals(partialMap, emptyMap.withAllKeyValues(partialIterable));
        Assert.assertEquals(completeMap, emptyMap.withAllKeyValues(completeIterable));
        Assert.assertEquals(partialMap, partialMap.withAllKeyValues(emptyIterable));
        Assert.assertEquals(partialMap, partialMap.withAllKeyValues(partialIterable));
        Assert.assertEquals(completeMap, partialMap.withAllKeyValues(completeIterable));
        Assert.assertEquals(completeMap, completeMap.withAllKeyValues(emptyIterable));
        Assert.assertEquals(completeMap, completeMap.withAllKeyValues(partialIterable));
        Assert.assertEquals(completeMap, completeMap.withAllKeyValues(completeIterable));
    }

    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedByteBooleanMap.class, this.map.asSynchronized());
        Assert.assertEquals(new SynchronizedByteBooleanMap(this.map), this.map.asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableByteBooleanMap.class, this.map.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableByteBooleanMap(this.map), this.map.asUnmodifiable());
    }

    @Test
    public void booleanIterator_with_remove() {
        MutableByteBooleanMap map = this.classUnderTest();
        MutableBooleanIterator iterator = map.booleanIterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        Assert.assertFalse(iterator.hasNext());
        Verify.assertEmpty(map);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void iterator_throws_on_invocation_of_remove_before_next() {
        MutableBooleanIterator iterator = this.classUnderTest().booleanIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove() {
        MutableBooleanIterator iterator = this.classUnderTest().booleanIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        iterator.remove();
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableByteBooleanMapTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
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
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
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
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone_value);
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
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
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
        public void benchmark_booleanIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyValuesView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKeyIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKeyIfAbsent);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putDuplicateWithRemovedSlot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrThrow() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrThrow);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Function() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Function);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
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
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAllKeys);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValues);
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
        public void benchmark_booleanIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_invocation_of_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_invocation_of_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_consecutive_invocation_of_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_consecutive_invocation_of_remove);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableByteBooleanMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> booleanIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBooleanMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.isEmpty = AbstractMutableByteBooleanMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableByteBooleanMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableByteBooleanMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableByteBooleanMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableByteBooleanMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableByteBooleanMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableByteBooleanMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableByteBooleanMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableByteBooleanMapTestCase::forEachKeyValue;
            this.payloads.makeString = AbstractMutableByteBooleanMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableByteBooleanMapTestCase::appendString;
            this.payloads.select = AbstractMutableByteBooleanMapTestCase::select;
            this.payloads.reject = AbstractMutableByteBooleanMapTestCase::reject;
            this.payloads.select_value = AbstractMutableByteBooleanMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableByteBooleanMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableByteBooleanMapTestCase::collect;
            this.payloads.count = AbstractMutableByteBooleanMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableByteBooleanMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableByteBooleanMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableByteBooleanMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableByteBooleanMapTestCase::noneSatisfy;
            this.payloads.toList = AbstractMutableByteBooleanMapTestCase::toList;
            this.payloads.toSet = AbstractMutableByteBooleanMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableByteBooleanMapTestCase::toBag;
            this.payloads.booleanIterator = AbstractMutableByteBooleanMapTestCase::booleanIterator;
            this.payloads.asLazy = AbstractMutableByteBooleanMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableByteBooleanMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableByteBooleanMapTestCase::keyValuesView;
            this.payloads.toArray = AbstractMutableByteBooleanMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableByteBooleanMapTestCase::toImmutable;
            this.payloads.clear = AbstractMutableByteBooleanMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableByteBooleanMapTestCase::removeKey;
            this.payloads.removeKeyIfAbsent = AbstractMutableByteBooleanMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableByteBooleanMapTestCase::put;
            this.payloads.updateValues = AbstractMutableByteBooleanMapTestCase::updateValues;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableByteBooleanMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.get = AbstractMutableByteBooleanMapTestCase::get;
            this.payloads.getIfAbsent = AbstractMutableByteBooleanMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractMutableByteBooleanMapTestCase::getOrThrow;
            this.payloads.getIfAbsentPut = AbstractMutableByteBooleanMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableByteBooleanMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableByteBooleanMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableByteBooleanMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableByteBooleanMapTestCase::updateValue;
            this.payloads.containsKey = AbstractMutableByteBooleanMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableByteBooleanMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableByteBooleanMapTestCase::contains;
            this.payloads.containsAll = AbstractMutableByteBooleanMapTestCase::containsAll;
            this.payloads.containsAllIterable = AbstractMutableByteBooleanMapTestCase::containsAllIterable;
            this.payloads.size = AbstractMutableByteBooleanMapTestCase::size;
            this.payloads.withoutKey = AbstractMutableByteBooleanMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableByteBooleanMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableByteBooleanMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableByteBooleanMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableByteBooleanMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableByteBooleanMapTestCase::asUnmodifiable;
            this.payloads.booleanIterator_with_remove = AbstractMutableByteBooleanMapTestCase::booleanIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableByteBooleanMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableByteBooleanMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
        }
    }
*/
}
