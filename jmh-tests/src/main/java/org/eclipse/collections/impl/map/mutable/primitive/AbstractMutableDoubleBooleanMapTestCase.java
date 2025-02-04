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
import org.eclipse.collections.api.block.function.primitive.DoubleToBooleanFunction;
import org.eclipse.collections.api.iterator.MutableBooleanIterator;
import org.eclipse.collections.api.map.primitive.MutableDoubleBooleanMap;
import org.eclipse.collections.api.tuple.primitive.DoubleBooleanPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractDoubleBooleanMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitiveBooleanMapTestCase.stg.
 */
public abstract class AbstractMutableDoubleBooleanMapTestCase extends AbstractDoubleBooleanMapTestCase {

    protected final MutableDoubleBooleanMap map = this.classUnderTest();

    protected static DoubleArrayList generateCollisions() {
        DoubleArrayList collisions = new DoubleArrayList();
        DoubleBooleanHashMap hashMap = new DoubleBooleanHashMap();
        for (double each = 2.0; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2.0)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Override
    protected abstract MutableDoubleBooleanMap classUnderTest();

    @Override
    protected abstract MutableDoubleBooleanMap newWithKeysValues(double key1, boolean value1);

    @Override
    protected abstract MutableDoubleBooleanMap newWithKeysValues(double key1, boolean value1, double key2, boolean value2);

    @Override
    protected abstract MutableDoubleBooleanMap newWithKeysValues(double key1, boolean value1, double key2, boolean value2, double key3, boolean value3);

    @Override
    protected abstract MutableDoubleBooleanMap newWithKeysValues(double key1, boolean value1, double key2, boolean value2, double key3, boolean value3, double key4, boolean value4);

    @Override
    protected abstract MutableDoubleBooleanMap getEmptyMap();

    @Test
    public void clear() {
        this.map.clear();
        Assert.assertEquals(new DoubleBooleanHashMap(), this.map);
        this.map.put(1.0, false);
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(1.0, false), this.map);
        this.map.clear();
        Assert.assertEquals(new DoubleBooleanHashMap(), this.map);
        this.map.put(33.0, false);
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(33.0, false), this.map);
        this.map.clear();
        Assert.assertEquals(new DoubleBooleanHashMap(), this.map);
    }

    @Test
    public void removeKey() {
        this.map.removeKey(5.0);
        this.map.removeKey(50.0);
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(0.0, true, 31.0, false, 32.0, true), this.map);
        this.map.removeKey(0.0);
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(31.0, false, 32.0, true), this.map);
        this.map.removeKey(31.0);
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(32.0, true), this.map);
        this.map.removeKey(32.0);
        Assert.assertEquals(new DoubleBooleanHashMap(), this.map);
        this.map.removeKey(0.0);
        this.map.removeKey(31.0);
        this.map.removeKey(32.0);
        Assert.assertEquals(new DoubleBooleanHashMap(), this.map);
        Verify.assertEmpty(this.map);
        this.map.put(AbstractMutableDoubleBooleanMapTestCase.generateCollisions().get(0), true);
        this.map.put(AbstractMutableDoubleBooleanMapTestCase.generateCollisions().get(1), false);
        Assert.assertTrue(this.map.get(AbstractMutableDoubleBooleanMapTestCase.generateCollisions().get(0)));
        this.map.removeKey(AbstractMutableDoubleBooleanMapTestCase.generateCollisions().get(0));
        Assert.assertFalse(this.map.get(AbstractMutableDoubleBooleanMapTestCase.generateCollisions().get(0)));
        Assert.assertFalse(this.map.get(AbstractMutableDoubleBooleanMapTestCase.generateCollisions().get(1)));
        this.map.removeKey(AbstractMutableDoubleBooleanMapTestCase.generateCollisions().get(1));
        Assert.assertFalse(this.map.get(AbstractMutableDoubleBooleanMapTestCase.generateCollisions().get(1)));
        MutableDoubleBooleanMap map1 = this.newWithKeysValues(1.0, true);
        map1.removeKey(1.0);
        Assert.assertEquals(new DoubleBooleanHashMap(), map1);
    }

    @Test
    public void removeKeyIfAbsent() {
        Assert.assertTrue(this.map.removeKeyIfAbsent(5.0, true));
        Assert.assertFalse(this.map.removeKeyIfAbsent(50.0, false));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(0.0, true, 31.0, false, 32.0, true), this.map);
        Assert.assertTrue(this.map.removeKeyIfAbsent(0.0, false));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(31.0, false, 32.0, true), this.map);
        Assert.assertFalse(this.map.removeKeyIfAbsent(31.0, true));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(32.0, true), this.map);
        Assert.assertTrue(this.map.removeKeyIfAbsent(32.0, false));
        Assert.assertEquals(new DoubleBooleanHashMap(), this.map);
        Assert.assertTrue(this.map.removeKeyIfAbsent(0.0, true));
        Assert.assertFalse(this.map.removeKeyIfAbsent(31.0, false));
        Assert.assertFalse(this.map.removeKeyIfAbsent(32.0, false));
        Assert.assertEquals(new DoubleBooleanHashMap(), this.map);
        Verify.assertEmpty(this.map);
        this.map.put(AbstractMutableDoubleBooleanMapTestCase.generateCollisions().get(0), true);
        this.map.put(AbstractMutableDoubleBooleanMapTestCase.generateCollisions().get(1), false);
        Assert.assertTrue(this.map.get(AbstractMutableDoubleBooleanMapTestCase.generateCollisions().get(0)));
        Assert.assertTrue(this.map.removeKeyIfAbsent(AbstractMutableDoubleBooleanMapTestCase.generateCollisions().get(0), false));
        Assert.assertFalse(this.map.get(AbstractMutableDoubleBooleanMapTestCase.generateCollisions().get(0)));
        Assert.assertFalse(this.map.get(AbstractMutableDoubleBooleanMapTestCase.generateCollisions().get(1)));
        Assert.assertFalse(this.map.removeKeyIfAbsent(AbstractMutableDoubleBooleanMapTestCase.generateCollisions().get(1), true));
        Assert.assertFalse(this.map.get(AbstractMutableDoubleBooleanMapTestCase.generateCollisions().get(1)));
        Assert.assertTrue(this.classUnderTest().withKeyValue(1.0, true).removeKeyIfAbsent(0.0, false));
        MutableDoubleBooleanMap map1 = this.classUnderTest().withKeyValue(1.0, true);
        Assert.assertTrue(map1.removeKeyIfAbsent(1.0, false));
        Assert.assertTrue(map1.removeKeyIfAbsent(0.0, false));
        Assert.assertFalse(map1.removeKeyIfAbsent(1.0, false));
        MutableDoubleBooleanMap map2 = this.newWithKeysValues(1.0, true);
        Assert.assertTrue(map2.removeKeyIfAbsent(1.0, false));
    }

    @Test
    public void put() {
        this.map.put(0.0, false);
        this.map.put(31.0, true);
        this.map.put(32.0, false);
        MutableDoubleBooleanMap expected = this.newWithKeysValues(0.0, false, 31.0, true, 32.0, false);
        Assert.assertEquals(expected, this.map);
        this.map.put(1.0, true);
        expected.put(1.0, true);
        Assert.assertEquals(expected, this.map);
        this.map.put(33.0, false);
        expected.put(33.0, false);
        Assert.assertEquals(expected, this.map);
        this.map.put(30.0, true);
        expected.put(30.0, true);
        Assert.assertEquals(expected, this.map);
    }

    @Test
    public void updateValues() {
        MutableDoubleBooleanMap map1 = this.newWithKeysValues(0.0, true, 1.0, false, 2.0, false);
        map1.updateValues((k, v) -> v);
        MutableDoubleBooleanMap expected1 = this.newWithKeysValues(0.0, true, 1.0, false, 2.0, false);
        Assert.assertEquals(expected1, map1);
        MutableDoubleBooleanMap map2 = this.newWithKeysValues(0.0, true, 1.0, false, 2.0, false);
        map2.updateValues((k, v) -> !v);
        MutableDoubleBooleanMap expected2 = this.newWithKeysValues(0.0, false, 1.0, true, 2.0, true);
        Assert.assertEquals(expected2, map2);
        MutableDoubleBooleanMap map3 = this.newWithKeysValues(0.0, true, 1.0, false, 2.0, false);
        map3.updateValues((k, v) -> k == 2.0 ? true : v);
        MutableDoubleBooleanMap expected3 = this.newWithKeysValues(0.0, true, 1.0, false, 2.0, true);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        double collision1 = AbstractMutableDoubleBooleanMapTestCase.generateCollisions().getFirst();
        double collision2 = AbstractMutableDoubleBooleanMapTestCase.generateCollisions().get(1);
        double collision3 = AbstractMutableDoubleBooleanMapTestCase.generateCollisions().get(2);
        double collision4 = AbstractMutableDoubleBooleanMapTestCase.generateCollisions().get(3);
        MutableDoubleBooleanMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, true);
        hashMap.put(collision2, false);
        hashMap.put(collision3, true);
        Assert.assertFalse(hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, false);
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(collision1, true, collision3, true, collision4, false), hashMap);
        MutableDoubleBooleanMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, false);
        hashMap1.put(collision2, true);
        hashMap1.put(collision3, false);
        Assert.assertFalse(hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, true);
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(collision2, true, collision3, false, collision4, true), hashMap1);
        MutableDoubleBooleanMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, true);
        hashMap2.put(collision2, false);
        hashMap2.put(collision3, true);
        Assert.assertTrue(hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, false);
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(collision1, true, collision2, false, collision4, false), hashMap2);
    }

    @Override
    @Test
    public void get() {
        super.get();
        this.map.put(0.0, false);
        Assert.assertFalse(this.map.get(0.0));
        this.map.put(1.0, true);
        Assert.assertTrue(this.map.get(1.0));
        this.map.put(5.0, true);
        Assert.assertTrue(this.map.get(5.0));
        this.map.put(35.0, false);
        Assert.assertFalse(this.map.get(35.0));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        this.map.removeKey(0.0);
        Assert.assertFalse(this.map.getIfAbsent(0.0, false));
        Assert.assertTrue(this.map.getIfAbsent(0.0, true));
        Assert.assertFalse(this.map.getIfAbsent(1.0, false));
        Assert.assertTrue(this.map.getIfAbsent(1.0, true));
        Assert.assertFalse(this.map.getIfAbsent(33.0, false));
        Assert.assertTrue(this.map.getIfAbsent(33.0, true));
        this.map.put(0.0, false);
        Assert.assertFalse(this.map.getIfAbsent(0.0, true));
        this.map.put(1.0, true);
        Assert.assertTrue(this.map.getIfAbsent(1.0, false));
        this.map.put(5.0, false);
        Assert.assertFalse(this.map.getIfAbsent(5.0, true));
        this.map.put(35.0, true);
        Assert.assertTrue(this.map.getIfAbsent(35.0, false));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        this.map.removeKey(0.0);
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(0.0));
        this.map.put(0.0, false);
        Assert.assertFalse(this.map.getOrThrow(0.0));
        this.map.put(1.0, true);
        Assert.assertTrue(this.map.getOrThrow(1.0));
        this.map.put(5.0, false);
        Assert.assertFalse(this.map.getOrThrow(5.0));
        this.map.put(35.0, true);
        Assert.assertTrue(this.map.getOrThrow(35.0));
    }

    @Test
    public void getIfAbsentPut() {
        MutableDoubleBooleanMap map1 = this.getEmptyMap();
        Assert.assertTrue(map1.getIfAbsentPut(0.0, true));
        Assert.assertTrue(map1.getIfAbsentPut(0.0, false));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(0.0, true), map1);
        Assert.assertFalse(map1.getIfAbsentPut(1.0, false));
        Assert.assertFalse(map1.getIfAbsentPut(1.0, true));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(0.0, true, 1.0, false), map1);
        MutableDoubleBooleanMap map2 = this.getEmptyMap();
        Assert.assertTrue(map2.getIfAbsentPut(1.0, true));
        Assert.assertTrue(map2.getIfAbsentPut(1.0, false));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(1.0, true), map2);
        Assert.assertFalse(map2.getIfAbsentPut(0.0, false));
        Assert.assertFalse(map2.getIfAbsentPut(0.0, true));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(0.0, false, 1.0, true), map2);
        MutableDoubleBooleanMap map3 = this.getEmptyMap();
        Assert.assertTrue(map3.getIfAbsentPut(32.0, true));
        Assert.assertTrue(map3.getIfAbsentPut(32.0, false));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(32.0, true), map3);
        MutableDoubleBooleanMap map4 = this.getEmptyMap();
        Assert.assertFalse(map4.getIfAbsentPut(33.0, false));
        Assert.assertFalse(map4.getIfAbsentPut(33.0, true));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(33.0, false), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        BooleanFunction0 factory = () -> true;
        BooleanFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableDoubleBooleanMap map1 = this.getEmptyMap();
        Assert.assertTrue(map1.getIfAbsentPut(0.0, factory));
        Assert.assertTrue(map1.getIfAbsentPut(0.0, factoryThrows));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(0.0, true), map1);
        Assert.assertTrue(map1.getIfAbsentPut(1.0, factory));
        Assert.assertTrue(map1.getIfAbsentPut(1.0, factoryThrows));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(0.0, true, 1.0, true), map1);
        MutableDoubleBooleanMap map2 = this.getEmptyMap();
        Assert.assertTrue(map2.getIfAbsentPut(1.0, factory));
        Assert.assertTrue(map2.getIfAbsentPut(1.0, factoryThrows));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(1.0, true), map2);
        Assert.assertTrue(map2.getIfAbsentPut(0.0, factory));
        Assert.assertTrue(map2.getIfAbsentPut(0.0, factoryThrows));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(0.0, true, 1.0, true), map2);
        MutableDoubleBooleanMap map3 = this.getEmptyMap();
        Assert.assertTrue(map3.getIfAbsentPut(32.0, factory));
        Assert.assertTrue(map3.getIfAbsentPut(32.0, factoryThrows));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(32.0, true), map3);
        MutableDoubleBooleanMap map4 = this.getEmptyMap();
        Assert.assertTrue(map4.getIfAbsentPut(33.0, factory));
        Assert.assertTrue(map4.getIfAbsentPut(33.0, factoryThrows));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(33.0, true), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        BooleanFunction<String> functionLengthEven = (String string) -> (string.length() & 1) == 0.0;
        BooleanFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableDoubleBooleanMap map1 = this.getEmptyMap();
        Assert.assertTrue(map1.getIfAbsentPutWith(0.0, functionLengthEven, "12345678"));
        Assert.assertTrue(map1.getIfAbsentPutWith(0.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(0.0, true), map1);
        Assert.assertFalse(map1.getIfAbsentPutWith(1.0, functionLengthEven, "123456789"));
        Assert.assertFalse(map1.getIfAbsentPutWith(1.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(0.0, true, 1.0, false), map1);
        MutableDoubleBooleanMap map2 = this.getEmptyMap();
        Assert.assertTrue(map2.getIfAbsentPutWith(1.0, functionLengthEven, "12345678"));
        Assert.assertTrue(map2.getIfAbsentPutWith(1.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(1.0, true), map2);
        Assert.assertFalse(map2.getIfAbsentPutWith(0.0, functionLengthEven, "123456789"));
        Assert.assertFalse(map2.getIfAbsentPutWith(0.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(0.0, false, 1.0, true), map2);
        MutableDoubleBooleanMap map3 = this.getEmptyMap();
        Assert.assertTrue(map3.getIfAbsentPutWith(32.0, functionLengthEven, "12345678"));
        Assert.assertTrue(map3.getIfAbsentPutWith(32.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(32.0, true), map3);
        MutableDoubleBooleanMap map4 = this.getEmptyMap();
        Assert.assertTrue(map4.getIfAbsentPutWith(33.0, functionLengthEven, "12345678"));
        Assert.assertTrue(map4.getIfAbsentPutWith(33.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(33.0, true), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        DoubleToBooleanFunction keyIsEven = (double parameter) -> ((int) parameter & 1) == 0.0;
        DoubleToBooleanFunction functionThrows = (double doubleParameter) -> {
            throw new AssertionError();
        };
        MutableDoubleBooleanMap map1 = this.getEmptyMap();
        Assert.assertTrue(map1.getIfAbsentPutWithKey(0.0, keyIsEven));
        Assert.assertTrue(map1.getIfAbsentPutWithKey(0.0, functionThrows));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(0.0, true), map1);
        Assert.assertFalse(map1.getIfAbsentPutWithKey(1.0, keyIsEven));
        Assert.assertFalse(map1.getIfAbsentPutWithKey(1.0, functionThrows));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(0.0, true, 1.0, false), map1);
        MutableDoubleBooleanMap map2 = this.getEmptyMap();
        Assert.assertFalse(map2.getIfAbsentPutWithKey(1.0, keyIsEven));
        Assert.assertFalse(map2.getIfAbsentPutWithKey(1.0, functionThrows));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(1.0, false), map2);
        Assert.assertTrue(map2.getIfAbsentPutWithKey(0.0, keyIsEven));
        Assert.assertTrue(map2.getIfAbsentPutWithKey(0.0, functionThrows));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(0.0, true, 1.0, false), map2);
        MutableDoubleBooleanMap map3 = this.getEmptyMap();
        Assert.assertTrue(map3.getIfAbsentPutWithKey(32.0, keyIsEven));
        Assert.assertTrue(map3.getIfAbsentPutWithKey(32.0, functionThrows));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(32.0, true), map3);
        MutableDoubleBooleanMap map4 = this.getEmptyMap();
        Assert.assertFalse(map4.getIfAbsentPutWithKey(33.0, keyIsEven));
        Assert.assertFalse(map4.getIfAbsentPutWithKey(33.0, functionThrows));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(33.0, false), map4);
    }

    @Test
    public void updateValue() {
        BooleanToBooleanFunction flip = (boolean value) -> !value;
        MutableDoubleBooleanMap map1 = this.getEmptyMap();
        Assert.assertTrue(map1.updateValue(0.0, false, flip));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(0.0, true), map1);
        Assert.assertFalse(map1.updateValue(0.0, false, flip));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(0.0, false), map1);
        Assert.assertFalse(map1.updateValue(1.0, true, flip));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(0.0, false, 1.0, false), map1);
        Assert.assertTrue(map1.updateValue(1.0, true, flip));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(0.0, false, 1.0, true), map1);
        MutableDoubleBooleanMap map2 = this.getEmptyMap();
        Assert.assertTrue(map2.updateValue(1.0, false, flip));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(1.0, true), map2);
        Assert.assertFalse(map2.updateValue(1.0, false, flip));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(1.0, false), map2);
        Assert.assertFalse(map2.updateValue(0.0, true, flip));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(0.0, false, 1.0, false), map2);
        Assert.assertTrue(map2.updateValue(0.0, true, flip));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(0.0, true, 1.0, false), map2);
        MutableDoubleBooleanMap map3 = this.getEmptyMap();
        Assert.assertTrue(map3.updateValue(33.0, false, flip));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(33.0, true), map3);
        Assert.assertFalse(map3.updateValue(33.0, false, flip));
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(33.0, false), map3);
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        this.map.removeKey(0.0);
        Assert.assertFalse(this.map.containsKey(0.0));
        Assert.assertFalse(this.map.get(0.0));
        this.map.removeKey(0.0);
        Assert.assertFalse(this.map.containsKey(0.0));
        Assert.assertFalse(this.map.get(0.0));
        this.map.removeKey(1.0);
        Assert.assertFalse(this.map.containsKey(1.0));
        Assert.assertFalse(this.map.get(1.0));
        this.map.removeKey(31.0);
        Assert.assertFalse(this.map.containsKey(31.0));
        Assert.assertFalse(this.map.get(31.0));
        this.map.removeKey(32.0);
        Assert.assertFalse(this.map.containsKey(32.0));
        Assert.assertFalse(this.map.get(32.0));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        this.map.clear();
        this.map.put(35.0, true);
        Assert.assertTrue(this.map.containsValue(true));
        this.map.removeKey(35.0);
        Assert.assertFalse(this.map.containsValue(false));
        Assert.assertFalse(this.map.containsValue(true));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        this.map.clear();
        this.map.put(35.0, true);
        Assert.assertTrue(this.map.contains(true));
        this.map.removeKey(35.0);
        Assert.assertFalse(this.map.contains(false));
        Assert.assertFalse(this.map.contains(true));
    }

    @Override
    @Test
    public void containsAll() {
        super.containsAll();
        this.map.clear();
        this.map.put(5.0, true);
        Assert.assertTrue(this.map.containsAll(true));
        Assert.assertFalse(this.map.containsAll(true, false));
        Assert.assertFalse(this.map.containsAll(false, false));
        this.map.put(0.0, false);
        Assert.assertTrue(this.map.containsAll(false));
        Assert.assertTrue(this.map.containsAll(true, false));
        this.map.removeKey(5.0);
        Assert.assertFalse(this.map.containsAll(true));
        Assert.assertFalse(this.map.containsAll(true, false));
        Assert.assertTrue(this.map.containsAll(false, false));
        this.map.removeKey(0.0);
        Assert.assertFalse(this.map.containsAll(false, true));
    }

    @Override
    @Test
    public void containsAllIterable() {
        super.containsAllIterable();
        this.map.clear();
        this.map.put(5.0, true);
        Assert.assertTrue(this.map.containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertFalse(this.map.containsAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertFalse(this.map.containsAll(BooleanArrayList.newListWith(false, false)));
        this.map.put(0.0, false);
        Assert.assertTrue(this.map.containsAll(BooleanArrayList.newListWith(false)));
        Assert.assertTrue(this.map.containsAll(BooleanArrayList.newListWith(true, false)));
        this.map.removeKey(5.0);
        Assert.assertFalse(this.map.containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertFalse(this.map.containsAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertTrue(this.map.containsAll(BooleanArrayList.newListWith(false, false)));
        this.map.removeKey(0.0);
        Assert.assertFalse(this.map.containsAll(BooleanArrayList.newListWith(false, true)));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableDoubleBooleanMap hashMap1 = this.newWithKeysValues(1.0, true, 0.0, false);
        Verify.assertSize(2, hashMap1);
        hashMap1.removeKey(1.0);
        Verify.assertSize(1, hashMap1);
        hashMap1.removeKey(0.0);
        Verify.assertSize(0, hashMap1);
        MutableDoubleBooleanMap hashMap = this.newWithKeysValues(6.0, false, 5.0, true);
        hashMap.removeKey(5.0);
        Verify.assertSize(1, hashMap);
    }

    @Test
    public void withoutKey() {
        MutableDoubleBooleanMap map = this.newWithKeysValues(0.0, false, 1.0, true, 31.0, false, 32.0, true);
        MutableDoubleBooleanMap mapWithout = map.withoutKey(32.0);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(0.0, false, 1.0, true, 31.0, false), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableDoubleBooleanMap map = this.newWithKeysValues(0.0, true, 1.0, false, 31.0, true, 32.0, false);
        MutableDoubleBooleanMap mapWithout = map.withoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(1.0, false, 31.0, true), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableDoubleBooleanMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1.0, false), hashMap);
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(1.0, false), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableDoubleBooleanMap emptyMap = this.getEmptyMap();
        MutableDoubleBooleanMap partialMap = this.newWithKeysValues(1.0, true, 3.0, false);
        MutableDoubleBooleanMap completeMap = this.newWithKeysValues(1.0, true, 2.0, true, 3.0, false, 4.0, false);
        Iterable<DoubleBooleanPair> emptyIterable = Iterables.iList();
        Iterable<DoubleBooleanPair> partialIterable = Iterables.iList(PrimitiveTuples.pair(1.0, true), PrimitiveTuples.pair(3.0, false));
        Iterable<DoubleBooleanPair> completeIterable = Iterables.iList(PrimitiveTuples.pair(1.0, true), PrimitiveTuples.pair(2.0, true), PrimitiveTuples.pair(3.0, false), PrimitiveTuples.pair(4.0, false));
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
        Verify.assertInstanceOf(SynchronizedDoubleBooleanMap.class, this.map.asSynchronized());
        Assert.assertEquals(new SynchronizedDoubleBooleanMap(this.map), this.map.asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableDoubleBooleanMap.class, this.map.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableDoubleBooleanMap(this.map), this.map.asUnmodifiable());
    }

    @Test
    public void booleanIterator_with_remove() {
        MutableDoubleBooleanMap map = this.classUnderTest();
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

        private AbstractMutableDoubleBooleanMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableDoubleBooleanMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> booleanIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleBooleanMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.isEmpty = AbstractMutableDoubleBooleanMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableDoubleBooleanMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableDoubleBooleanMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableDoubleBooleanMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableDoubleBooleanMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableDoubleBooleanMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableDoubleBooleanMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableDoubleBooleanMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableDoubleBooleanMapTestCase::forEachKeyValue;
            this.payloads.makeString = AbstractMutableDoubleBooleanMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableDoubleBooleanMapTestCase::appendString;
            this.payloads.select = AbstractMutableDoubleBooleanMapTestCase::select;
            this.payloads.reject = AbstractMutableDoubleBooleanMapTestCase::reject;
            this.payloads.select_value = AbstractMutableDoubleBooleanMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableDoubleBooleanMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableDoubleBooleanMapTestCase::collect;
            this.payloads.count = AbstractMutableDoubleBooleanMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableDoubleBooleanMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableDoubleBooleanMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableDoubleBooleanMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableDoubleBooleanMapTestCase::noneSatisfy;
            this.payloads.toList = AbstractMutableDoubleBooleanMapTestCase::toList;
            this.payloads.toSet = AbstractMutableDoubleBooleanMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableDoubleBooleanMapTestCase::toBag;
            this.payloads.booleanIterator = AbstractMutableDoubleBooleanMapTestCase::booleanIterator;
            this.payloads.asLazy = AbstractMutableDoubleBooleanMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableDoubleBooleanMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableDoubleBooleanMapTestCase::keyValuesView;
            this.payloads.toArray = AbstractMutableDoubleBooleanMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableDoubleBooleanMapTestCase::toImmutable;
            this.payloads.clear = AbstractMutableDoubleBooleanMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableDoubleBooleanMapTestCase::removeKey;
            this.payloads.removeKeyIfAbsent = AbstractMutableDoubleBooleanMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableDoubleBooleanMapTestCase::put;
            this.payloads.updateValues = AbstractMutableDoubleBooleanMapTestCase::updateValues;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableDoubleBooleanMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.get = AbstractMutableDoubleBooleanMapTestCase::get;
            this.payloads.getIfAbsent = AbstractMutableDoubleBooleanMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractMutableDoubleBooleanMapTestCase::getOrThrow;
            this.payloads.getIfAbsentPut = AbstractMutableDoubleBooleanMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableDoubleBooleanMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableDoubleBooleanMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableDoubleBooleanMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableDoubleBooleanMapTestCase::updateValue;
            this.payloads.containsKey = AbstractMutableDoubleBooleanMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableDoubleBooleanMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableDoubleBooleanMapTestCase::contains;
            this.payloads.containsAll = AbstractMutableDoubleBooleanMapTestCase::containsAll;
            this.payloads.containsAllIterable = AbstractMutableDoubleBooleanMapTestCase::containsAllIterable;
            this.payloads.size = AbstractMutableDoubleBooleanMapTestCase::size;
            this.payloads.withoutKey = AbstractMutableDoubleBooleanMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableDoubleBooleanMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableDoubleBooleanMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableDoubleBooleanMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableDoubleBooleanMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableDoubleBooleanMapTestCase::asUnmodifiable;
            this.payloads.booleanIterator_with_remove = AbstractMutableDoubleBooleanMapTestCase::booleanIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableDoubleBooleanMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableDoubleBooleanMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
        }
    }
}
