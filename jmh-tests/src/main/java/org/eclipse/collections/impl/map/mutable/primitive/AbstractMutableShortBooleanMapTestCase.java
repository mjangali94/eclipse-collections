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
import org.eclipse.collections.api.block.function.primitive.ShortToBooleanFunction;
import org.eclipse.collections.api.iterator.MutableBooleanIterator;
import org.eclipse.collections.api.map.primitive.MutableShortBooleanMap;
import org.eclipse.collections.api.tuple.primitive.ShortBooleanPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractShortBooleanMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitiveBooleanMapTestCase.stg.
 */
public abstract class AbstractMutableShortBooleanMapTestCase extends AbstractShortBooleanMapTestCase {

    protected final MutableShortBooleanMap map = this.classUnderTest();

    protected static ShortArrayList generateCollisions() {
        ShortArrayList collisions = new ShortArrayList();
        ShortBooleanHashMap hashMap = new ShortBooleanHashMap();
        for (short each = (short) 2; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask((short) 2)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Override
    protected abstract MutableShortBooleanMap classUnderTest();

    @Override
    protected abstract MutableShortBooleanMap newWithKeysValues(short key1, boolean value1);

    @Override
    protected abstract MutableShortBooleanMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2);

    @Override
    protected abstract MutableShortBooleanMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2, short key3, boolean value3);

    @Override
    protected abstract MutableShortBooleanMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2, short key3, boolean value3, short key4, boolean value4);

    @Override
    protected abstract MutableShortBooleanMap getEmptyMap();

    @Test
    public void clear() {
        this.map.clear();
        Assert.assertEquals(new ShortBooleanHashMap(), this.map);
        this.map.put((short) 1, false);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 1, false), this.map);
        this.map.clear();
        Assert.assertEquals(new ShortBooleanHashMap(), this.map);
        this.map.put((short) 33, false);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 33, false), this.map);
        this.map.clear();
        Assert.assertEquals(new ShortBooleanHashMap(), this.map);
    }

    @Test
    public void removeKey() {
        this.map.removeKey((short) 5);
        this.map.removeKey((short) 50);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 31, false, (short) 32, true), this.map);
        this.map.removeKey((short) 0);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 31, false, (short) 32, true), this.map);
        this.map.removeKey((short) 31);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 32, true), this.map);
        this.map.removeKey((short) 32);
        Assert.assertEquals(new ShortBooleanHashMap(), this.map);
        this.map.removeKey((short) 0);
        this.map.removeKey((short) 31);
        this.map.removeKey((short) 32);
        Assert.assertEquals(new ShortBooleanHashMap(), this.map);
        Verify.assertEmpty(this.map);
        this.map.put(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(0), true);
        this.map.put(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(1), false);
        Assert.assertTrue(this.map.get(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(0)));
        this.map.removeKey(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(0));
        Assert.assertFalse(this.map.get(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(0)));
        Assert.assertFalse(this.map.get(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(1)));
        this.map.removeKey(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(1));
        Assert.assertFalse(this.map.get(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(1)));
        MutableShortBooleanMap map1 = this.newWithKeysValues((short) 1, true);
        map1.removeKey((short) 1);
        Assert.assertEquals(new ShortBooleanHashMap(), map1);
    }

    @Test
    public void removeKeyIfAbsent() {
        Assert.assertTrue(this.map.removeKeyIfAbsent((short) 5, true));
        Assert.assertFalse(this.map.removeKeyIfAbsent((short) 50, false));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 31, false, (short) 32, true), this.map);
        Assert.assertTrue(this.map.removeKeyIfAbsent((short) 0, false));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 31, false, (short) 32, true), this.map);
        Assert.assertFalse(this.map.removeKeyIfAbsent((short) 31, true));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 32, true), this.map);
        Assert.assertTrue(this.map.removeKeyIfAbsent((short) 32, false));
        Assert.assertEquals(new ShortBooleanHashMap(), this.map);
        Assert.assertTrue(this.map.removeKeyIfAbsent((short) 0, true));
        Assert.assertFalse(this.map.removeKeyIfAbsent((short) 31, false));
        Assert.assertFalse(this.map.removeKeyIfAbsent((short) 32, false));
        Assert.assertEquals(new ShortBooleanHashMap(), this.map);
        Verify.assertEmpty(this.map);
        this.map.put(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(0), true);
        this.map.put(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(1), false);
        Assert.assertTrue(this.map.get(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(0)));
        Assert.assertTrue(this.map.removeKeyIfAbsent(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(0), false));
        Assert.assertFalse(this.map.get(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(0)));
        Assert.assertFalse(this.map.get(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(1)));
        Assert.assertFalse(this.map.removeKeyIfAbsent(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(1), true));
        Assert.assertFalse(this.map.get(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(1)));
        Assert.assertTrue(this.classUnderTest().withKeyValue((short) 1, true).removeKeyIfAbsent((short) 0, false));
        MutableShortBooleanMap map1 = this.classUnderTest().withKeyValue((short) 1, true);
        Assert.assertTrue(map1.removeKeyIfAbsent((short) 1, false));
        Assert.assertTrue(map1.removeKeyIfAbsent((short) 0, false));
        Assert.assertFalse(map1.removeKeyIfAbsent((short) 1, false));
        MutableShortBooleanMap map2 = this.newWithKeysValues((short) 1, true);
        Assert.assertTrue(map2.removeKeyIfAbsent((short) 1, false));
    }

    @Test
    public void put() {
        this.map.put((short) 0, false);
        this.map.put((short) 31, true);
        this.map.put((short) 32, false);
        MutableShortBooleanMap expected = this.newWithKeysValues((short) 0, false, (short) 31, true, (short) 32, false);
        Assert.assertEquals(expected, this.map);
        this.map.put((short) 1, true);
        expected.put((short) 1, true);
        Assert.assertEquals(expected, this.map);
        this.map.put((short) 33, false);
        expected.put((short) 33, false);
        Assert.assertEquals(expected, this.map);
        this.map.put((short) 30, true);
        expected.put((short) 30, true);
        Assert.assertEquals(expected, this.map);
    }

    @Test
    public void updateValues() {
        MutableShortBooleanMap map1 = this.newWithKeysValues((short) 0, true, (short) 1, false, (short) 2, false);
        map1.updateValues((k, v) -> v);
        MutableShortBooleanMap expected1 = this.newWithKeysValues((short) 0, true, (short) 1, false, (short) 2, false);
        Assert.assertEquals(expected1, map1);
        MutableShortBooleanMap map2 = this.newWithKeysValues((short) 0, true, (short) 1, false, (short) 2, false);
        map2.updateValues((k, v) -> !v);
        MutableShortBooleanMap expected2 = this.newWithKeysValues((short) 0, false, (short) 1, true, (short) 2, true);
        Assert.assertEquals(expected2, map2);
        MutableShortBooleanMap map3 = this.newWithKeysValues((short) 0, true, (short) 1, false, (short) 2, false);
        map3.updateValues((k, v) -> k == (short) 2 ? true : v);
        MutableShortBooleanMap expected3 = this.newWithKeysValues((short) 0, true, (short) 1, false, (short) 2, true);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        short collision1 = AbstractMutableShortBooleanMapTestCase.generateCollisions().getFirst();
        short collision2 = AbstractMutableShortBooleanMapTestCase.generateCollisions().get(1);
        short collision3 = AbstractMutableShortBooleanMapTestCase.generateCollisions().get(2);
        short collision4 = AbstractMutableShortBooleanMapTestCase.generateCollisions().get(3);
        MutableShortBooleanMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, true);
        hashMap.put(collision2, false);
        hashMap.put(collision3, true);
        Assert.assertFalse(hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, false);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues(collision1, true, collision3, true, collision4, false), hashMap);
        MutableShortBooleanMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, false);
        hashMap1.put(collision2, true);
        hashMap1.put(collision3, false);
        Assert.assertFalse(hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, true);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues(collision2, true, collision3, false, collision4, true), hashMap1);
        MutableShortBooleanMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, true);
        hashMap2.put(collision2, false);
        hashMap2.put(collision3, true);
        Assert.assertTrue(hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, false);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues(collision1, true, collision2, false, collision4, false), hashMap2);
    }

    @Override
    @Test
    public void get() {
        super.get();
        this.map.put((short) 0, false);
        Assert.assertFalse(this.map.get((short) 0));
        this.map.put((short) 1, true);
        Assert.assertTrue(this.map.get((short) 1));
        this.map.put((short) 5, true);
        Assert.assertTrue(this.map.get((short) 5));
        this.map.put((short) 35, false);
        Assert.assertFalse(this.map.get((short) 35));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        this.map.removeKey((short) 0);
        Assert.assertFalse(this.map.getIfAbsent((short) 0, false));
        Assert.assertTrue(this.map.getIfAbsent((short) 0, true));
        Assert.assertFalse(this.map.getIfAbsent((short) 1, false));
        Assert.assertTrue(this.map.getIfAbsent((short) 1, true));
        Assert.assertFalse(this.map.getIfAbsent((short) 33, false));
        Assert.assertTrue(this.map.getIfAbsent((short) 33, true));
        this.map.put((short) 0, false);
        Assert.assertFalse(this.map.getIfAbsent((short) 0, true));
        this.map.put((short) 1, true);
        Assert.assertTrue(this.map.getIfAbsent((short) 1, false));
        this.map.put((short) 5, false);
        Assert.assertFalse(this.map.getIfAbsent((short) 5, true));
        this.map.put((short) 35, true);
        Assert.assertTrue(this.map.getIfAbsent((short) 35, false));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        this.map.removeKey((short) 0);
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((short) 0));
        this.map.put((short) 0, false);
        Assert.assertFalse(this.map.getOrThrow((short) 0));
        this.map.put((short) 1, true);
        Assert.assertTrue(this.map.getOrThrow((short) 1));
        this.map.put((short) 5, false);
        Assert.assertFalse(this.map.getOrThrow((short) 5));
        this.map.put((short) 35, true);
        Assert.assertTrue(this.map.getOrThrow((short) 35));
    }

    @Test
    public void getIfAbsentPut() {
        MutableShortBooleanMap map1 = this.getEmptyMap();
        Assert.assertTrue(map1.getIfAbsentPut((short) 0, true));
        Assert.assertTrue(map1.getIfAbsentPut((short) 0, false));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, true), map1);
        Assert.assertFalse(map1.getIfAbsentPut((short) 1, false));
        Assert.assertFalse(map1.getIfAbsentPut((short) 1, true));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 1, false), map1);
        MutableShortBooleanMap map2 = this.getEmptyMap();
        Assert.assertTrue(map2.getIfAbsentPut((short) 1, true));
        Assert.assertTrue(map2.getIfAbsentPut((short) 1, false));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 1, true), map2);
        Assert.assertFalse(map2.getIfAbsentPut((short) 0, false));
        Assert.assertFalse(map2.getIfAbsentPut((short) 0, true));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, false, (short) 1, true), map2);
        MutableShortBooleanMap map3 = this.getEmptyMap();
        Assert.assertTrue(map3.getIfAbsentPut((short) 32, true));
        Assert.assertTrue(map3.getIfAbsentPut((short) 32, false));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 32, true), map3);
        MutableShortBooleanMap map4 = this.getEmptyMap();
        Assert.assertFalse(map4.getIfAbsentPut((short) 33, false));
        Assert.assertFalse(map4.getIfAbsentPut((short) 33, true));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 33, false), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        BooleanFunction0 factory = () -> true;
        BooleanFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableShortBooleanMap map1 = this.getEmptyMap();
        Assert.assertTrue(map1.getIfAbsentPut((short) 0, factory));
        Assert.assertTrue(map1.getIfAbsentPut((short) 0, factoryThrows));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, true), map1);
        Assert.assertTrue(map1.getIfAbsentPut((short) 1, factory));
        Assert.assertTrue(map1.getIfAbsentPut((short) 1, factoryThrows));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 1, true), map1);
        MutableShortBooleanMap map2 = this.getEmptyMap();
        Assert.assertTrue(map2.getIfAbsentPut((short) 1, factory));
        Assert.assertTrue(map2.getIfAbsentPut((short) 1, factoryThrows));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 1, true), map2);
        Assert.assertTrue(map2.getIfAbsentPut((short) 0, factory));
        Assert.assertTrue(map2.getIfAbsentPut((short) 0, factoryThrows));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 1, true), map2);
        MutableShortBooleanMap map3 = this.getEmptyMap();
        Assert.assertTrue(map3.getIfAbsentPut((short) 32, factory));
        Assert.assertTrue(map3.getIfAbsentPut((short) 32, factoryThrows));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 32, true), map3);
        MutableShortBooleanMap map4 = this.getEmptyMap();
        Assert.assertTrue(map4.getIfAbsentPut((short) 33, factory));
        Assert.assertTrue(map4.getIfAbsentPut((short) 33, factoryThrows));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 33, true), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        BooleanFunction<String> functionLengthEven = (String string) -> (string.length() & 1) == (short) 0;
        BooleanFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableShortBooleanMap map1 = this.getEmptyMap();
        Assert.assertTrue(map1.getIfAbsentPutWith((short) 0, functionLengthEven, "12345678"));
        Assert.assertTrue(map1.getIfAbsentPutWith((short) 0, functionThrows, "unused"));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, true), map1);
        Assert.assertFalse(map1.getIfAbsentPutWith((short) 1, functionLengthEven, "123456789"));
        Assert.assertFalse(map1.getIfAbsentPutWith((short) 1, functionThrows, "unused"));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 1, false), map1);
        MutableShortBooleanMap map2 = this.getEmptyMap();
        Assert.assertTrue(map2.getIfAbsentPutWith((short) 1, functionLengthEven, "12345678"));
        Assert.assertTrue(map2.getIfAbsentPutWith((short) 1, functionThrows, "unused"));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 1, true), map2);
        Assert.assertFalse(map2.getIfAbsentPutWith((short) 0, functionLengthEven, "123456789"));
        Assert.assertFalse(map2.getIfAbsentPutWith((short) 0, functionThrows, "unused"));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, false, (short) 1, true), map2);
        MutableShortBooleanMap map3 = this.getEmptyMap();
        Assert.assertTrue(map3.getIfAbsentPutWith((short) 32, functionLengthEven, "12345678"));
        Assert.assertTrue(map3.getIfAbsentPutWith((short) 32, functionThrows, "unused"));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 32, true), map3);
        MutableShortBooleanMap map4 = this.getEmptyMap();
        Assert.assertTrue(map4.getIfAbsentPutWith((short) 33, functionLengthEven, "12345678"));
        Assert.assertTrue(map4.getIfAbsentPutWith((short) 33, functionThrows, "unused"));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 33, true), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        ShortToBooleanFunction keyIsEven = (short parameter) -> (parameter & 1) == (short) 0;
        ShortToBooleanFunction functionThrows = (short shortParameter) -> {
            throw new AssertionError();
        };
        MutableShortBooleanMap map1 = this.getEmptyMap();
        Assert.assertTrue(map1.getIfAbsentPutWithKey((short) 0, keyIsEven));
        Assert.assertTrue(map1.getIfAbsentPutWithKey((short) 0, functionThrows));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, true), map1);
        Assert.assertFalse(map1.getIfAbsentPutWithKey((short) 1, keyIsEven));
        Assert.assertFalse(map1.getIfAbsentPutWithKey((short) 1, functionThrows));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 1, false), map1);
        MutableShortBooleanMap map2 = this.getEmptyMap();
        Assert.assertFalse(map2.getIfAbsentPutWithKey((short) 1, keyIsEven));
        Assert.assertFalse(map2.getIfAbsentPutWithKey((short) 1, functionThrows));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 1, false), map2);
        Assert.assertTrue(map2.getIfAbsentPutWithKey((short) 0, keyIsEven));
        Assert.assertTrue(map2.getIfAbsentPutWithKey((short) 0, functionThrows));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 1, false), map2);
        MutableShortBooleanMap map3 = this.getEmptyMap();
        Assert.assertTrue(map3.getIfAbsentPutWithKey((short) 32, keyIsEven));
        Assert.assertTrue(map3.getIfAbsentPutWithKey((short) 32, functionThrows));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 32, true), map3);
        MutableShortBooleanMap map4 = this.getEmptyMap();
        Assert.assertFalse(map4.getIfAbsentPutWithKey((short) 33, keyIsEven));
        Assert.assertFalse(map4.getIfAbsentPutWithKey((short) 33, functionThrows));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 33, false), map4);
    }

    @Test
    public void updateValue() {
        BooleanToBooleanFunction flip = (boolean value) -> !value;
        MutableShortBooleanMap map1 = this.getEmptyMap();
        Assert.assertTrue(map1.updateValue((short) 0, false, flip));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, true), map1);
        Assert.assertFalse(map1.updateValue((short) 0, false, flip));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, false), map1);
        Assert.assertFalse(map1.updateValue((short) 1, true, flip));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, false, (short) 1, false), map1);
        Assert.assertTrue(map1.updateValue((short) 1, true, flip));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, false, (short) 1, true), map1);
        MutableShortBooleanMap map2 = this.getEmptyMap();
        Assert.assertTrue(map2.updateValue((short) 1, false, flip));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 1, true), map2);
        Assert.assertFalse(map2.updateValue((short) 1, false, flip));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 1, false), map2);
        Assert.assertFalse(map2.updateValue((short) 0, true, flip));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, false, (short) 1, false), map2);
        Assert.assertTrue(map2.updateValue((short) 0, true, flip));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 1, false), map2);
        MutableShortBooleanMap map3 = this.getEmptyMap();
        Assert.assertTrue(map3.updateValue((short) 33, false, flip));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 33, true), map3);
        Assert.assertFalse(map3.updateValue((short) 33, false, flip));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 33, false), map3);
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        this.map.removeKey((short) 0);
        Assert.assertFalse(this.map.containsKey((short) 0));
        Assert.assertFalse(this.map.get((short) 0));
        this.map.removeKey((short) 0);
        Assert.assertFalse(this.map.containsKey((short) 0));
        Assert.assertFalse(this.map.get((short) 0));
        this.map.removeKey((short) 1);
        Assert.assertFalse(this.map.containsKey((short) 1));
        Assert.assertFalse(this.map.get((short) 1));
        this.map.removeKey((short) 31);
        Assert.assertFalse(this.map.containsKey((short) 31));
        Assert.assertFalse(this.map.get((short) 31));
        this.map.removeKey((short) 32);
        Assert.assertFalse(this.map.containsKey((short) 32));
        Assert.assertFalse(this.map.get((short) 32));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        this.map.clear();
        this.map.put((short) 35, true);
        Assert.assertTrue(this.map.containsValue(true));
        this.map.removeKey((short) 35);
        Assert.assertFalse(this.map.containsValue(false));
        Assert.assertFalse(this.map.containsValue(true));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        this.map.clear();
        this.map.put((short) 35, true);
        Assert.assertTrue(this.map.contains(true));
        this.map.removeKey((short) 35);
        Assert.assertFalse(this.map.contains(false));
        Assert.assertFalse(this.map.contains(true));
    }

    @Override
    @Test
    public void containsAll() {
        super.containsAll();
        this.map.clear();
        this.map.put((short) 5, true);
        Assert.assertTrue(this.map.containsAll(true));
        Assert.assertFalse(this.map.containsAll(true, false));
        Assert.assertFalse(this.map.containsAll(false, false));
        this.map.put((short) 0, false);
        Assert.assertTrue(this.map.containsAll(false));
        Assert.assertTrue(this.map.containsAll(true, false));
        this.map.removeKey((short) 5);
        Assert.assertFalse(this.map.containsAll(true));
        Assert.assertFalse(this.map.containsAll(true, false));
        Assert.assertTrue(this.map.containsAll(false, false));
        this.map.removeKey((short) 0);
        Assert.assertFalse(this.map.containsAll(false, true));
    }

    @Override
    @Test
    public void containsAllIterable() {
        super.containsAllIterable();
        this.map.clear();
        this.map.put((short) 5, true);
        Assert.assertTrue(this.map.containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertFalse(this.map.containsAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertFalse(this.map.containsAll(BooleanArrayList.newListWith(false, false)));
        this.map.put((short) 0, false);
        Assert.assertTrue(this.map.containsAll(BooleanArrayList.newListWith(false)));
        Assert.assertTrue(this.map.containsAll(BooleanArrayList.newListWith(true, false)));
        this.map.removeKey((short) 5);
        Assert.assertFalse(this.map.containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertFalse(this.map.containsAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertTrue(this.map.containsAll(BooleanArrayList.newListWith(false, false)));
        this.map.removeKey((short) 0);
        Assert.assertFalse(this.map.containsAll(BooleanArrayList.newListWith(false, true)));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableShortBooleanMap hashMap1 = this.newWithKeysValues((short) 1, true, (short) 0, false);
        Verify.assertSize(2, hashMap1);
        hashMap1.removeKey((short) 1);
        Verify.assertSize(1, hashMap1);
        hashMap1.removeKey((short) 0);
        Verify.assertSize(0, hashMap1);
        MutableShortBooleanMap hashMap = this.newWithKeysValues((short) 6, false, (short) 5, true);
        hashMap.removeKey((short) 5);
        Verify.assertSize(1, hashMap);
    }

    @Test
    public void withoutKey() {
        MutableShortBooleanMap map = this.newWithKeysValues((short) 0, false, (short) 1, true, (short) 31, false, (short) 32, true);
        MutableShortBooleanMap mapWithout = map.withoutKey((short) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, false, (short) 1, true, (short) 31, false), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableShortBooleanMap map = this.newWithKeysValues((short) 0, true, (short) 1, false, (short) 31, true, (short) 32, false);
        MutableShortBooleanMap mapWithout = map.withoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 1, false, (short) 31, true), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableShortBooleanMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((short) 1, false), hashMap);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 1, false), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableShortBooleanMap emptyMap = this.getEmptyMap();
        MutableShortBooleanMap partialMap = this.newWithKeysValues((short) 1, true, (short) 3, false);
        MutableShortBooleanMap completeMap = this.newWithKeysValues((short) 1, true, (short) 2, true, (short) 3, false, (short) 4, false);
        Iterable<ShortBooleanPair> emptyIterable = Iterables.iList();
        Iterable<ShortBooleanPair> partialIterable = Iterables.iList(PrimitiveTuples.pair((short) 1, true), PrimitiveTuples.pair((short) 3, false));
        Iterable<ShortBooleanPair> completeIterable = Iterables.iList(PrimitiveTuples.pair((short) 1, true), PrimitiveTuples.pair((short) 2, true), PrimitiveTuples.pair((short) 3, false), PrimitiveTuples.pair((short) 4, false));
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
        Verify.assertInstanceOf(SynchronizedShortBooleanMap.class, this.map.asSynchronized());
        Assert.assertEquals(new SynchronizedShortBooleanMap(this.map), this.map.asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableShortBooleanMap.class, this.map.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableShortBooleanMap(this.map), this.map.asUnmodifiable());
    }

    @Test
    public void booleanIterator_with_remove() {
        MutableShortBooleanMap map = this.classUnderTest();
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

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableShortBooleanMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableShortBooleanMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> booleanIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBooleanMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.isEmpty = AbstractMutableShortBooleanMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableShortBooleanMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableShortBooleanMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableShortBooleanMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableShortBooleanMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableShortBooleanMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableShortBooleanMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableShortBooleanMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableShortBooleanMapTestCase::forEachKeyValue;
            this.payloads.makeString = AbstractMutableShortBooleanMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableShortBooleanMapTestCase::appendString;
            this.payloads.select = AbstractMutableShortBooleanMapTestCase::select;
            this.payloads.reject = AbstractMutableShortBooleanMapTestCase::reject;
            this.payloads.select_value = AbstractMutableShortBooleanMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableShortBooleanMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableShortBooleanMapTestCase::collect;
            this.payloads.count = AbstractMutableShortBooleanMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableShortBooleanMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableShortBooleanMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableShortBooleanMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableShortBooleanMapTestCase::noneSatisfy;
            this.payloads.toList = AbstractMutableShortBooleanMapTestCase::toList;
            this.payloads.toSet = AbstractMutableShortBooleanMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableShortBooleanMapTestCase::toBag;
            this.payloads.booleanIterator = AbstractMutableShortBooleanMapTestCase::booleanIterator;
            this.payloads.asLazy = AbstractMutableShortBooleanMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableShortBooleanMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableShortBooleanMapTestCase::keyValuesView;
            this.payloads.toArray = AbstractMutableShortBooleanMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableShortBooleanMapTestCase::toImmutable;
            this.payloads.clear = AbstractMutableShortBooleanMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableShortBooleanMapTestCase::removeKey;
            this.payloads.removeKeyIfAbsent = AbstractMutableShortBooleanMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableShortBooleanMapTestCase::put;
            this.payloads.updateValues = AbstractMutableShortBooleanMapTestCase::updateValues;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableShortBooleanMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.get = AbstractMutableShortBooleanMapTestCase::get;
            this.payloads.getIfAbsent = AbstractMutableShortBooleanMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractMutableShortBooleanMapTestCase::getOrThrow;
            this.payloads.getIfAbsentPut = AbstractMutableShortBooleanMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableShortBooleanMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableShortBooleanMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableShortBooleanMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableShortBooleanMapTestCase::updateValue;
            this.payloads.containsKey = AbstractMutableShortBooleanMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableShortBooleanMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableShortBooleanMapTestCase::contains;
            this.payloads.containsAll = AbstractMutableShortBooleanMapTestCase::containsAll;
            this.payloads.containsAllIterable = AbstractMutableShortBooleanMapTestCase::containsAllIterable;
            this.payloads.size = AbstractMutableShortBooleanMapTestCase::size;
            this.payloads.withoutKey = AbstractMutableShortBooleanMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableShortBooleanMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableShortBooleanMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableShortBooleanMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableShortBooleanMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableShortBooleanMapTestCase::asUnmodifiable;
            this.payloads.booleanIterator_with_remove = AbstractMutableShortBooleanMapTestCase::booleanIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableShortBooleanMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableShortBooleanMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
        }
    }
}
