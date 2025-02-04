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
import org.eclipse.collections.api.block.function.primitive.CharToBooleanFunction;
import org.eclipse.collections.api.iterator.MutableBooleanIterator;
import org.eclipse.collections.api.map.primitive.MutableCharBooleanMap;
import org.eclipse.collections.api.tuple.primitive.CharBooleanPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractCharBooleanMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitiveBooleanMapTestCase.stg.
 */
public abstract class AbstractMutableCharBooleanMapTestCase extends AbstractCharBooleanMapTestCase {

    protected final MutableCharBooleanMap map = this.classUnderTest();

    protected static CharArrayList generateCollisions() {
        CharArrayList collisions = new CharArrayList();
        CharBooleanHashMap hashMap = new CharBooleanHashMap();
        for (char each = (char) 2; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask((char) 2)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Override
    protected abstract MutableCharBooleanMap classUnderTest();

    @Override
    protected abstract MutableCharBooleanMap newWithKeysValues(char key1, boolean value1);

    @Override
    protected abstract MutableCharBooleanMap newWithKeysValues(char key1, boolean value1, char key2, boolean value2);

    @Override
    protected abstract MutableCharBooleanMap newWithKeysValues(char key1, boolean value1, char key2, boolean value2, char key3, boolean value3);

    @Override
    protected abstract MutableCharBooleanMap newWithKeysValues(char key1, boolean value1, char key2, boolean value2, char key3, boolean value3, char key4, boolean value4);

    @Override
    protected abstract MutableCharBooleanMap getEmptyMap();

    @Test
    public void clear() {
        this.map.clear();
        Assert.assertEquals(new CharBooleanHashMap(), this.map);
        this.map.put((char) 1, false);
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 1, false), this.map);
        this.map.clear();
        Assert.assertEquals(new CharBooleanHashMap(), this.map);
        this.map.put((char) 33, false);
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 33, false), this.map);
        this.map.clear();
        Assert.assertEquals(new CharBooleanHashMap(), this.map);
    }

    @Test
    public void removeKey() {
        this.map.removeKey((char) 5);
        this.map.removeKey((char) 50);
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 0, true, (char) 31, false, (char) 32, true), this.map);
        this.map.removeKey((char) 0);
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 31, false, (char) 32, true), this.map);
        this.map.removeKey((char) 31);
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 32, true), this.map);
        this.map.removeKey((char) 32);
        Assert.assertEquals(new CharBooleanHashMap(), this.map);
        this.map.removeKey((char) 0);
        this.map.removeKey((char) 31);
        this.map.removeKey((char) 32);
        Assert.assertEquals(new CharBooleanHashMap(), this.map);
        Verify.assertEmpty(this.map);
        this.map.put(AbstractMutableCharBooleanMapTestCase.generateCollisions().get(0), true);
        this.map.put(AbstractMutableCharBooleanMapTestCase.generateCollisions().get(1), false);
        Assert.assertTrue(this.map.get(AbstractMutableCharBooleanMapTestCase.generateCollisions().get(0)));
        this.map.removeKey(AbstractMutableCharBooleanMapTestCase.generateCollisions().get(0));
        Assert.assertFalse(this.map.get(AbstractMutableCharBooleanMapTestCase.generateCollisions().get(0)));
        Assert.assertFalse(this.map.get(AbstractMutableCharBooleanMapTestCase.generateCollisions().get(1)));
        this.map.removeKey(AbstractMutableCharBooleanMapTestCase.generateCollisions().get(1));
        Assert.assertFalse(this.map.get(AbstractMutableCharBooleanMapTestCase.generateCollisions().get(1)));
        MutableCharBooleanMap map1 = this.newWithKeysValues((char) 1, true);
        map1.removeKey((char) 1);
        Assert.assertEquals(new CharBooleanHashMap(), map1);
    }

    @Test
    public void removeKeyIfAbsent() {
        Assert.assertTrue(this.map.removeKeyIfAbsent((char) 5, true));
        Assert.assertFalse(this.map.removeKeyIfAbsent((char) 50, false));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 0, true, (char) 31, false, (char) 32, true), this.map);
        Assert.assertTrue(this.map.removeKeyIfAbsent((char) 0, false));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 31, false, (char) 32, true), this.map);
        Assert.assertFalse(this.map.removeKeyIfAbsent((char) 31, true));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 32, true), this.map);
        Assert.assertTrue(this.map.removeKeyIfAbsent((char) 32, false));
        Assert.assertEquals(new CharBooleanHashMap(), this.map);
        Assert.assertTrue(this.map.removeKeyIfAbsent((char) 0, true));
        Assert.assertFalse(this.map.removeKeyIfAbsent((char) 31, false));
        Assert.assertFalse(this.map.removeKeyIfAbsent((char) 32, false));
        Assert.assertEquals(new CharBooleanHashMap(), this.map);
        Verify.assertEmpty(this.map);
        this.map.put(AbstractMutableCharBooleanMapTestCase.generateCollisions().get(0), true);
        this.map.put(AbstractMutableCharBooleanMapTestCase.generateCollisions().get(1), false);
        Assert.assertTrue(this.map.get(AbstractMutableCharBooleanMapTestCase.generateCollisions().get(0)));
        Assert.assertTrue(this.map.removeKeyIfAbsent(AbstractMutableCharBooleanMapTestCase.generateCollisions().get(0), false));
        Assert.assertFalse(this.map.get(AbstractMutableCharBooleanMapTestCase.generateCollisions().get(0)));
        Assert.assertFalse(this.map.get(AbstractMutableCharBooleanMapTestCase.generateCollisions().get(1)));
        Assert.assertFalse(this.map.removeKeyIfAbsent(AbstractMutableCharBooleanMapTestCase.generateCollisions().get(1), true));
        Assert.assertFalse(this.map.get(AbstractMutableCharBooleanMapTestCase.generateCollisions().get(1)));
        Assert.assertTrue(this.classUnderTest().withKeyValue((char) 1, true).removeKeyIfAbsent((char) 0, false));
        MutableCharBooleanMap map1 = this.classUnderTest().withKeyValue((char) 1, true);
        Assert.assertTrue(map1.removeKeyIfAbsent((char) 1, false));
        Assert.assertTrue(map1.removeKeyIfAbsent((char) 0, false));
        Assert.assertFalse(map1.removeKeyIfAbsent((char) 1, false));
        MutableCharBooleanMap map2 = this.newWithKeysValues((char) 1, true);
        Assert.assertTrue(map2.removeKeyIfAbsent((char) 1, false));
    }

    @Test
    public void put() {
        this.map.put((char) 0, false);
        this.map.put((char) 31, true);
        this.map.put((char) 32, false);
        MutableCharBooleanMap expected = this.newWithKeysValues((char) 0, false, (char) 31, true, (char) 32, false);
        Assert.assertEquals(expected, this.map);
        this.map.put((char) 1, true);
        expected.put((char) 1, true);
        Assert.assertEquals(expected, this.map);
        this.map.put((char) 33, false);
        expected.put((char) 33, false);
        Assert.assertEquals(expected, this.map);
        this.map.put((char) 30, true);
        expected.put((char) 30, true);
        Assert.assertEquals(expected, this.map);
    }

    @Test
    public void updateValues() {
        MutableCharBooleanMap map1 = this.newWithKeysValues((char) 0, true, (char) 1, false, (char) 2, false);
        map1.updateValues((k, v) -> v);
        MutableCharBooleanMap expected1 = this.newWithKeysValues((char) 0, true, (char) 1, false, (char) 2, false);
        Assert.assertEquals(expected1, map1);
        MutableCharBooleanMap map2 = this.newWithKeysValues((char) 0, true, (char) 1, false, (char) 2, false);
        map2.updateValues((k, v) -> !v);
        MutableCharBooleanMap expected2 = this.newWithKeysValues((char) 0, false, (char) 1, true, (char) 2, true);
        Assert.assertEquals(expected2, map2);
        MutableCharBooleanMap map3 = this.newWithKeysValues((char) 0, true, (char) 1, false, (char) 2, false);
        map3.updateValues((k, v) -> k == (char) 2 ? true : v);
        MutableCharBooleanMap expected3 = this.newWithKeysValues((char) 0, true, (char) 1, false, (char) 2, true);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        char collision1 = AbstractMutableCharBooleanMapTestCase.generateCollisions().getFirst();
        char collision2 = AbstractMutableCharBooleanMapTestCase.generateCollisions().get(1);
        char collision3 = AbstractMutableCharBooleanMapTestCase.generateCollisions().get(2);
        char collision4 = AbstractMutableCharBooleanMapTestCase.generateCollisions().get(3);
        MutableCharBooleanMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, true);
        hashMap.put(collision2, false);
        hashMap.put(collision3, true);
        Assert.assertFalse(hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, false);
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues(collision1, true, collision3, true, collision4, false), hashMap);
        MutableCharBooleanMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, false);
        hashMap1.put(collision2, true);
        hashMap1.put(collision3, false);
        Assert.assertFalse(hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, true);
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues(collision2, true, collision3, false, collision4, true), hashMap1);
        MutableCharBooleanMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, true);
        hashMap2.put(collision2, false);
        hashMap2.put(collision3, true);
        Assert.assertTrue(hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, false);
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues(collision1, true, collision2, false, collision4, false), hashMap2);
    }

    @Override
    @Test
    public void get() {
        super.get();
        this.map.put((char) 0, false);
        Assert.assertFalse(this.map.get((char) 0));
        this.map.put((char) 1, true);
        Assert.assertTrue(this.map.get((char) 1));
        this.map.put((char) 5, true);
        Assert.assertTrue(this.map.get((char) 5));
        this.map.put((char) 35, false);
        Assert.assertFalse(this.map.get((char) 35));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        this.map.removeKey((char) 0);
        Assert.assertFalse(this.map.getIfAbsent((char) 0, false));
        Assert.assertTrue(this.map.getIfAbsent((char) 0, true));
        Assert.assertFalse(this.map.getIfAbsent((char) 1, false));
        Assert.assertTrue(this.map.getIfAbsent((char) 1, true));
        Assert.assertFalse(this.map.getIfAbsent((char) 33, false));
        Assert.assertTrue(this.map.getIfAbsent((char) 33, true));
        this.map.put((char) 0, false);
        Assert.assertFalse(this.map.getIfAbsent((char) 0, true));
        this.map.put((char) 1, true);
        Assert.assertTrue(this.map.getIfAbsent((char) 1, false));
        this.map.put((char) 5, false);
        Assert.assertFalse(this.map.getIfAbsent((char) 5, true));
        this.map.put((char) 35, true);
        Assert.assertTrue(this.map.getIfAbsent((char) 35, false));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        this.map.removeKey((char) 0);
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((char) 0));
        this.map.put((char) 0, false);
        Assert.assertFalse(this.map.getOrThrow((char) 0));
        this.map.put((char) 1, true);
        Assert.assertTrue(this.map.getOrThrow((char) 1));
        this.map.put((char) 5, false);
        Assert.assertFalse(this.map.getOrThrow((char) 5));
        this.map.put((char) 35, true);
        Assert.assertTrue(this.map.getOrThrow((char) 35));
    }

    @Test
    public void getIfAbsentPut() {
        MutableCharBooleanMap map1 = this.getEmptyMap();
        Assert.assertTrue(map1.getIfAbsentPut((char) 0, true));
        Assert.assertTrue(map1.getIfAbsentPut((char) 0, false));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 0, true), map1);
        Assert.assertFalse(map1.getIfAbsentPut((char) 1, false));
        Assert.assertFalse(map1.getIfAbsentPut((char) 1, true));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 0, true, (char) 1, false), map1);
        MutableCharBooleanMap map2 = this.getEmptyMap();
        Assert.assertTrue(map2.getIfAbsentPut((char) 1, true));
        Assert.assertTrue(map2.getIfAbsentPut((char) 1, false));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 1, true), map2);
        Assert.assertFalse(map2.getIfAbsentPut((char) 0, false));
        Assert.assertFalse(map2.getIfAbsentPut((char) 0, true));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 0, false, (char) 1, true), map2);
        MutableCharBooleanMap map3 = this.getEmptyMap();
        Assert.assertTrue(map3.getIfAbsentPut((char) 32, true));
        Assert.assertTrue(map3.getIfAbsentPut((char) 32, false));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 32, true), map3);
        MutableCharBooleanMap map4 = this.getEmptyMap();
        Assert.assertFalse(map4.getIfAbsentPut((char) 33, false));
        Assert.assertFalse(map4.getIfAbsentPut((char) 33, true));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 33, false), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        BooleanFunction0 factory = () -> true;
        BooleanFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableCharBooleanMap map1 = this.getEmptyMap();
        Assert.assertTrue(map1.getIfAbsentPut((char) 0, factory));
        Assert.assertTrue(map1.getIfAbsentPut((char) 0, factoryThrows));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 0, true), map1);
        Assert.assertTrue(map1.getIfAbsentPut((char) 1, factory));
        Assert.assertTrue(map1.getIfAbsentPut((char) 1, factoryThrows));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 0, true, (char) 1, true), map1);
        MutableCharBooleanMap map2 = this.getEmptyMap();
        Assert.assertTrue(map2.getIfAbsentPut((char) 1, factory));
        Assert.assertTrue(map2.getIfAbsentPut((char) 1, factoryThrows));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 1, true), map2);
        Assert.assertTrue(map2.getIfAbsentPut((char) 0, factory));
        Assert.assertTrue(map2.getIfAbsentPut((char) 0, factoryThrows));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 0, true, (char) 1, true), map2);
        MutableCharBooleanMap map3 = this.getEmptyMap();
        Assert.assertTrue(map3.getIfAbsentPut((char) 32, factory));
        Assert.assertTrue(map3.getIfAbsentPut((char) 32, factoryThrows));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 32, true), map3);
        MutableCharBooleanMap map4 = this.getEmptyMap();
        Assert.assertTrue(map4.getIfAbsentPut((char) 33, factory));
        Assert.assertTrue(map4.getIfAbsentPut((char) 33, factoryThrows));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 33, true), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        BooleanFunction<String> functionLengthEven = (String string) -> (string.length() & 1) == (char) 0;
        BooleanFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableCharBooleanMap map1 = this.getEmptyMap();
        Assert.assertTrue(map1.getIfAbsentPutWith((char) 0, functionLengthEven, "12345678"));
        Assert.assertTrue(map1.getIfAbsentPutWith((char) 0, functionThrows, "unused"));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 0, true), map1);
        Assert.assertFalse(map1.getIfAbsentPutWith((char) 1, functionLengthEven, "123456789"));
        Assert.assertFalse(map1.getIfAbsentPutWith((char) 1, functionThrows, "unused"));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 0, true, (char) 1, false), map1);
        MutableCharBooleanMap map2 = this.getEmptyMap();
        Assert.assertTrue(map2.getIfAbsentPutWith((char) 1, functionLengthEven, "12345678"));
        Assert.assertTrue(map2.getIfAbsentPutWith((char) 1, functionThrows, "unused"));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 1, true), map2);
        Assert.assertFalse(map2.getIfAbsentPutWith((char) 0, functionLengthEven, "123456789"));
        Assert.assertFalse(map2.getIfAbsentPutWith((char) 0, functionThrows, "unused"));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 0, false, (char) 1, true), map2);
        MutableCharBooleanMap map3 = this.getEmptyMap();
        Assert.assertTrue(map3.getIfAbsentPutWith((char) 32, functionLengthEven, "12345678"));
        Assert.assertTrue(map3.getIfAbsentPutWith((char) 32, functionThrows, "unused"));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 32, true), map3);
        MutableCharBooleanMap map4 = this.getEmptyMap();
        Assert.assertTrue(map4.getIfAbsentPutWith((char) 33, functionLengthEven, "12345678"));
        Assert.assertTrue(map4.getIfAbsentPutWith((char) 33, functionThrows, "unused"));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 33, true), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        CharToBooleanFunction keyIsEven = (char parameter) -> (parameter & 1) == (char) 0;
        CharToBooleanFunction functionThrows = (char charParameter) -> {
            throw new AssertionError();
        };
        MutableCharBooleanMap map1 = this.getEmptyMap();
        Assert.assertTrue(map1.getIfAbsentPutWithKey((char) 0, keyIsEven));
        Assert.assertTrue(map1.getIfAbsentPutWithKey((char) 0, functionThrows));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 0, true), map1);
        Assert.assertFalse(map1.getIfAbsentPutWithKey((char) 1, keyIsEven));
        Assert.assertFalse(map1.getIfAbsentPutWithKey((char) 1, functionThrows));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 0, true, (char) 1, false), map1);
        MutableCharBooleanMap map2 = this.getEmptyMap();
        Assert.assertFalse(map2.getIfAbsentPutWithKey((char) 1, keyIsEven));
        Assert.assertFalse(map2.getIfAbsentPutWithKey((char) 1, functionThrows));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 1, false), map2);
        Assert.assertTrue(map2.getIfAbsentPutWithKey((char) 0, keyIsEven));
        Assert.assertTrue(map2.getIfAbsentPutWithKey((char) 0, functionThrows));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 0, true, (char) 1, false), map2);
        MutableCharBooleanMap map3 = this.getEmptyMap();
        Assert.assertTrue(map3.getIfAbsentPutWithKey((char) 32, keyIsEven));
        Assert.assertTrue(map3.getIfAbsentPutWithKey((char) 32, functionThrows));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 32, true), map3);
        MutableCharBooleanMap map4 = this.getEmptyMap();
        Assert.assertFalse(map4.getIfAbsentPutWithKey((char) 33, keyIsEven));
        Assert.assertFalse(map4.getIfAbsentPutWithKey((char) 33, functionThrows));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 33, false), map4);
    }

    @Test
    public void updateValue() {
        BooleanToBooleanFunction flip = (boolean value) -> !value;
        MutableCharBooleanMap map1 = this.getEmptyMap();
        Assert.assertTrue(map1.updateValue((char) 0, false, flip));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 0, true), map1);
        Assert.assertFalse(map1.updateValue((char) 0, false, flip));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 0, false), map1);
        Assert.assertFalse(map1.updateValue((char) 1, true, flip));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 0, false, (char) 1, false), map1);
        Assert.assertTrue(map1.updateValue((char) 1, true, flip));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 0, false, (char) 1, true), map1);
        MutableCharBooleanMap map2 = this.getEmptyMap();
        Assert.assertTrue(map2.updateValue((char) 1, false, flip));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 1, true), map2);
        Assert.assertFalse(map2.updateValue((char) 1, false, flip));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 1, false), map2);
        Assert.assertFalse(map2.updateValue((char) 0, true, flip));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 0, false, (char) 1, false), map2);
        Assert.assertTrue(map2.updateValue((char) 0, true, flip));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 0, true, (char) 1, false), map2);
        MutableCharBooleanMap map3 = this.getEmptyMap();
        Assert.assertTrue(map3.updateValue((char) 33, false, flip));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 33, true), map3);
        Assert.assertFalse(map3.updateValue((char) 33, false, flip));
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 33, false), map3);
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        this.map.removeKey((char) 0);
        Assert.assertFalse(this.map.containsKey((char) 0));
        Assert.assertFalse(this.map.get((char) 0));
        this.map.removeKey((char) 0);
        Assert.assertFalse(this.map.containsKey((char) 0));
        Assert.assertFalse(this.map.get((char) 0));
        this.map.removeKey((char) 1);
        Assert.assertFalse(this.map.containsKey((char) 1));
        Assert.assertFalse(this.map.get((char) 1));
        this.map.removeKey((char) 31);
        Assert.assertFalse(this.map.containsKey((char) 31));
        Assert.assertFalse(this.map.get((char) 31));
        this.map.removeKey((char) 32);
        Assert.assertFalse(this.map.containsKey((char) 32));
        Assert.assertFalse(this.map.get((char) 32));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        this.map.clear();
        this.map.put((char) 35, true);
        Assert.assertTrue(this.map.containsValue(true));
        this.map.removeKey((char) 35);
        Assert.assertFalse(this.map.containsValue(false));
        Assert.assertFalse(this.map.containsValue(true));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        this.map.clear();
        this.map.put((char) 35, true);
        Assert.assertTrue(this.map.contains(true));
        this.map.removeKey((char) 35);
        Assert.assertFalse(this.map.contains(false));
        Assert.assertFalse(this.map.contains(true));
    }

    @Override
    @Test
    public void containsAll() {
        super.containsAll();
        this.map.clear();
        this.map.put((char) 5, true);
        Assert.assertTrue(this.map.containsAll(true));
        Assert.assertFalse(this.map.containsAll(true, false));
        Assert.assertFalse(this.map.containsAll(false, false));
        this.map.put((char) 0, false);
        Assert.assertTrue(this.map.containsAll(false));
        Assert.assertTrue(this.map.containsAll(true, false));
        this.map.removeKey((char) 5);
        Assert.assertFalse(this.map.containsAll(true));
        Assert.assertFalse(this.map.containsAll(true, false));
        Assert.assertTrue(this.map.containsAll(false, false));
        this.map.removeKey((char) 0);
        Assert.assertFalse(this.map.containsAll(false, true));
    }

    @Override
    @Test
    public void containsAllIterable() {
        super.containsAllIterable();
        this.map.clear();
        this.map.put((char) 5, true);
        Assert.assertTrue(this.map.containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertFalse(this.map.containsAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertFalse(this.map.containsAll(BooleanArrayList.newListWith(false, false)));
        this.map.put((char) 0, false);
        Assert.assertTrue(this.map.containsAll(BooleanArrayList.newListWith(false)));
        Assert.assertTrue(this.map.containsAll(BooleanArrayList.newListWith(true, false)));
        this.map.removeKey((char) 5);
        Assert.assertFalse(this.map.containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertFalse(this.map.containsAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertTrue(this.map.containsAll(BooleanArrayList.newListWith(false, false)));
        this.map.removeKey((char) 0);
        Assert.assertFalse(this.map.containsAll(BooleanArrayList.newListWith(false, true)));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableCharBooleanMap hashMap1 = this.newWithKeysValues((char) 1, true, (char) 0, false);
        Verify.assertSize(2, hashMap1);
        hashMap1.removeKey((char) 1);
        Verify.assertSize(1, hashMap1);
        hashMap1.removeKey((char) 0);
        Verify.assertSize(0, hashMap1);
        MutableCharBooleanMap hashMap = this.newWithKeysValues((char) 6, false, (char) 5, true);
        hashMap.removeKey((char) 5);
        Verify.assertSize(1, hashMap);
    }

    @Test
    public void withoutKey() {
        MutableCharBooleanMap map = this.newWithKeysValues((char) 0, false, (char) 1, true, (char) 31, false, (char) 32, true);
        MutableCharBooleanMap mapWithout = map.withoutKey((char) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 0, false, (char) 1, true, (char) 31, false), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableCharBooleanMap map = this.newWithKeysValues((char) 0, true, (char) 1, false, (char) 31, true, (char) 32, false);
        MutableCharBooleanMap mapWithout = map.withoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 1, false, (char) 31, true), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableCharBooleanMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((char) 1, false), hashMap);
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 1, false), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableCharBooleanMap emptyMap = this.getEmptyMap();
        MutableCharBooleanMap partialMap = this.newWithKeysValues((char) 1, true, (char) 3, false);
        MutableCharBooleanMap completeMap = this.newWithKeysValues((char) 1, true, (char) 2, true, (char) 3, false, (char) 4, false);
        Iterable<CharBooleanPair> emptyIterable = Iterables.iList();
        Iterable<CharBooleanPair> partialIterable = Iterables.iList(PrimitiveTuples.pair((char) 1, true), PrimitiveTuples.pair((char) 3, false));
        Iterable<CharBooleanPair> completeIterable = Iterables.iList(PrimitiveTuples.pair((char) 1, true), PrimitiveTuples.pair((char) 2, true), PrimitiveTuples.pair((char) 3, false), PrimitiveTuples.pair((char) 4, false));
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
        Verify.assertInstanceOf(SynchronizedCharBooleanMap.class, this.map.asSynchronized());
        Assert.assertEquals(new SynchronizedCharBooleanMap(this.map), this.map.asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableCharBooleanMap.class, this.map.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableCharBooleanMap(this.map), this.map.asUnmodifiable());
    }

    @Test
    public void booleanIterator_with_remove() {
        MutableCharBooleanMap map = this.classUnderTest();
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

        private AbstractMutableCharBooleanMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableCharBooleanMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> booleanIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBooleanMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.isEmpty = AbstractMutableCharBooleanMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableCharBooleanMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableCharBooleanMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableCharBooleanMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableCharBooleanMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableCharBooleanMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableCharBooleanMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableCharBooleanMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableCharBooleanMapTestCase::forEachKeyValue;
            this.payloads.makeString = AbstractMutableCharBooleanMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableCharBooleanMapTestCase::appendString;
            this.payloads.select = AbstractMutableCharBooleanMapTestCase::select;
            this.payloads.reject = AbstractMutableCharBooleanMapTestCase::reject;
            this.payloads.select_value = AbstractMutableCharBooleanMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableCharBooleanMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableCharBooleanMapTestCase::collect;
            this.payloads.count = AbstractMutableCharBooleanMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableCharBooleanMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableCharBooleanMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableCharBooleanMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableCharBooleanMapTestCase::noneSatisfy;
            this.payloads.toList = AbstractMutableCharBooleanMapTestCase::toList;
            this.payloads.toSet = AbstractMutableCharBooleanMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableCharBooleanMapTestCase::toBag;
            this.payloads.booleanIterator = AbstractMutableCharBooleanMapTestCase::booleanIterator;
            this.payloads.asLazy = AbstractMutableCharBooleanMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableCharBooleanMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableCharBooleanMapTestCase::keyValuesView;
            this.payloads.toArray = AbstractMutableCharBooleanMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableCharBooleanMapTestCase::toImmutable;
            this.payloads.clear = AbstractMutableCharBooleanMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableCharBooleanMapTestCase::removeKey;
            this.payloads.removeKeyIfAbsent = AbstractMutableCharBooleanMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableCharBooleanMapTestCase::put;
            this.payloads.updateValues = AbstractMutableCharBooleanMapTestCase::updateValues;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableCharBooleanMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.get = AbstractMutableCharBooleanMapTestCase::get;
            this.payloads.getIfAbsent = AbstractMutableCharBooleanMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractMutableCharBooleanMapTestCase::getOrThrow;
            this.payloads.getIfAbsentPut = AbstractMutableCharBooleanMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableCharBooleanMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableCharBooleanMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableCharBooleanMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableCharBooleanMapTestCase::updateValue;
            this.payloads.containsKey = AbstractMutableCharBooleanMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableCharBooleanMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableCharBooleanMapTestCase::contains;
            this.payloads.containsAll = AbstractMutableCharBooleanMapTestCase::containsAll;
            this.payloads.containsAllIterable = AbstractMutableCharBooleanMapTestCase::containsAllIterable;
            this.payloads.size = AbstractMutableCharBooleanMapTestCase::size;
            this.payloads.withoutKey = AbstractMutableCharBooleanMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableCharBooleanMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableCharBooleanMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableCharBooleanMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableCharBooleanMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableCharBooleanMapTestCase::asUnmodifiable;
            this.payloads.booleanIterator_with_remove = AbstractMutableCharBooleanMapTestCase::booleanIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableCharBooleanMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableCharBooleanMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
        }
    }
*/
}
