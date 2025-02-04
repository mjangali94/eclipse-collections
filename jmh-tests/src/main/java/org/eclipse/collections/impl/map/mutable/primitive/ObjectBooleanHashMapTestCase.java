/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable.primitive;

import java.lang.reflect.Field;
import java.util.BitSet;
import java.util.Iterator;
import org.eclipse.collections.api.block.function.primitive.BooleanFunction;
import org.eclipse.collections.api.block.function.primitive.BooleanFunction0;
import org.eclipse.collections.api.block.function.primitive.BooleanToBooleanFunction;
import org.eclipse.collections.api.map.primitive.MutableObjectBooleanMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public abstract class ObjectBooleanHashMapTestCase extends AbstractMutableObjectBooleanMapTestCase {

    private final MutableObjectBooleanMap<String> map = this.classUnderTest();

    private final Class<?> targetClass = this.getTargetClass();

    protected abstract Class<?> getTargetClass();

    protected abstract <T> MutableObjectBooleanMap<T> newMapWithInitialCapacity(int size);

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keys = this.targetClass.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = this.targetClass.getDeclaredField("values");
        values.setAccessible(true);
        MutableObjectBooleanMap<String> hashMap = this.getEmptyMap();
        Assert.assertEquals(16L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keys = this.targetClass.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = this.targetClass.getDeclaredField("values");
        values.setAccessible(true);
        MutableObjectBooleanMap<String> hashMap = this.newMapWithInitialCapacity(3);
        Assert.assertEquals(8L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        MutableObjectBooleanMap<String> hashMap2 = this.newMapWithInitialCapacity(15);
        Assert.assertEquals(32L, ((Object[]) keys.get(hashMap2)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        this.newMapWithInitialCapacity(-1);
    }

    @Test
    public void newMap() throws Exception {
        Field keys = this.targetClass.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = this.targetClass.getDeclaredField("values");
        values.setAccessible(true);
        MutableObjectBooleanMap<String> hashMap = this.getEmptyMap();
        Assert.assertEquals(16L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        Assert.assertEquals(this.getEmptyMap(), hashMap);
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableObjectBooleanMap<String> map0 = this.newWithKeysValues("0", false, "1", true);
        Assert.assertTrue(map0.removeKeyIfAbsent("1", false));
        Assert.assertEquals(this.newWithKeysValues("0", false), map0);
        Assert.assertFalse(map0.removeKeyIfAbsent("0", true));
        Assert.assertEquals(this.getEmptyMap(), map0);
        Assert.assertFalse(map0.removeKeyIfAbsent("1", false));
        Assert.assertTrue(map0.removeKeyIfAbsent("0", true));
        MutableObjectBooleanMap<String> map1 = this.newWithKeysValues("0", true, "1", false);
        Assert.assertTrue(map1.removeKeyIfAbsent("0", false));
        Assert.assertEquals(this.newWithKeysValues("1", false), map1);
        Assert.assertFalse(map1.removeKeyIfAbsent("1", true));
        Assert.assertEquals(this.getEmptyMap(), map1);
        Assert.assertFalse(map1.removeKeyIfAbsent("0", false));
        Assert.assertTrue(map1.removeKeyIfAbsent("1", true));
        Assert.assertTrue(this.map.removeKeyIfAbsent("5", true));
        Assert.assertEquals(this.newWithKeysValues("0", true, "1", true, "2", false), this.map);
        Assert.assertTrue(this.map.removeKeyIfAbsent("0", false));
        Assert.assertEquals(this.newWithKeysValues("1", true, "2", false), this.map);
        Assert.assertTrue(this.map.removeKeyIfAbsent("1", false));
        Assert.assertEquals(this.newWithKeysValues("2", false), this.map);
        Assert.assertFalse(this.map.removeKeyIfAbsent("2", true));
        Assert.assertEquals(this.getEmptyMap(), this.map);
        Assert.assertFalse(this.map.removeKeyIfAbsent("0", false));
        Assert.assertFalse(this.map.removeKeyIfAbsent("1", false));
        Assert.assertTrue(this.map.removeKeyIfAbsent("2", true));
        Assert.assertEquals(this.getEmptyMap(), this.map);
        Verify.assertEmpty(this.map);
        this.map.put(null, true);
        Assert.assertTrue(this.map.get(null));
        Assert.assertTrue(this.map.removeKeyIfAbsent(null, false));
        Assert.assertFalse(this.map.get(null));
    }

    @Test
    public void putWithRehash() throws Exception {
        ObjectBooleanHashMap<Integer> hashMap = ObjectBooleanHashMap.newMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey(i));
            hashMap.put(i, (i & 1) == 0);
        }
        Field keys = ObjectBooleanHashMap.class.getDeclaredField("keys");
        Field values = ObjectBooleanHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey(i));
        }
        Assert.assertTrue(hashMap.containsValue(false));
        Assert.assertTrue(hashMap.containsValue(true));
        hashMap.put(10, true);
        Assert.assertEquals(32L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        for (int i = 11; i < 75; i++) {
            Assert.assertFalse(String.valueOf(i), hashMap.containsKey(i));
            hashMap.put(i, (i & 1) == 0);
        }
        Assert.assertEquals(256L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(256L, ((BitSet) values.get(hashMap)).size());
    }

    @Test
    public void getIfAbsentPut() {
        MutableObjectBooleanMap<Integer> map1 = this.getEmptyMap();
        Assert.assertTrue(map1.getIfAbsentPut(0, true));
        Assert.assertTrue(map1.getIfAbsentPut(0, false));
        Assert.assertEquals(this.newWithKeysValues(0, true), map1);
        Assert.assertTrue(map1.getIfAbsentPut(1, true));
        Assert.assertTrue(map1.getIfAbsentPut(1, false));
        Assert.assertEquals(this.newWithKeysValues(0, true, 1, true), map1);
        MutableObjectBooleanMap<Integer> map2 = this.getEmptyMap();
        Assert.assertFalse(map2.getIfAbsentPut(1, false));
        Assert.assertFalse(map2.getIfAbsentPut(1, true));
        Assert.assertEquals(this.newWithKeysValues(1, false), map2);
        Assert.assertFalse(map2.getIfAbsentPut(0, false));
        Assert.assertFalse(map2.getIfAbsentPut(0, true));
        Assert.assertEquals(this.newWithKeysValues(0, false, 1, false), map2);
        MutableObjectBooleanMap<Integer> map3 = this.getEmptyMap();
        Assert.assertTrue(map3.getIfAbsentPut(null, true));
        Assert.assertTrue(map3.getIfAbsentPut(null, false));
        Assert.assertEquals(this.newWithKeysValues(null, true), map3);
    }

    @Test
    public void updateValue() {
        BooleanToBooleanFunction flip = value -> !value;
        MutableObjectBooleanMap<Integer> map1 = this.getEmptyMap();
        Assert.assertTrue(map1.updateValue(0, false, flip));
        Assert.assertEquals(this.newWithKeysValues(0, true), map1);
        Assert.assertFalse(map1.updateValue(0, false, flip));
        Assert.assertEquals(this.newWithKeysValues(0, false), map1);
        Assert.assertFalse(map1.updateValue(1, true, flip));
        Assert.assertEquals(this.newWithKeysValues(0, false, 1, false), map1);
        Assert.assertTrue(map1.updateValue(1, true, flip));
        Assert.assertEquals(this.newWithKeysValues(0, false, 1, true), map1);
        MutableObjectBooleanMap<Integer> map2 = this.getEmptyMap();
        Assert.assertTrue(map2.updateValue(1, false, flip));
        Assert.assertEquals(this.newWithKeysValues(1, true), map2);
        Assert.assertFalse(map2.updateValue(1, false, flip));
        Assert.assertEquals(this.newWithKeysValues(1, false), map2);
        Assert.assertFalse(map2.updateValue(0, true, flip));
        Assert.assertEquals(this.newWithKeysValues(0, false, 1, false), map2);
        Assert.assertTrue(map2.updateValue(0, true, flip));
        Assert.assertEquals(this.newWithKeysValues(0, true, 1, false), map2);
        MutableObjectBooleanMap<Integer> map3 = this.getEmptyMap();
        Assert.assertFalse(map3.updateValue(null, true, flip));
        Assert.assertEquals(this.newWithKeysValues(null, false), map3);
        Assert.assertTrue(map3.updateValue(null, true, flip));
        Assert.assertEquals(this.newWithKeysValues(null, true), map3);
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        ObjectBooleanHashMap<Integer> hashMap0 = new ObjectBooleanHashMap<Integer>().withKeysValues(1, true, 2, false);
        ObjectBooleanHashMap<Integer> hashMap1 = new ObjectBooleanHashMap<Integer>().withKeysValues(1, false, 2, false, 3, true);
        ObjectBooleanHashMap<Integer> hashMap2 = new ObjectBooleanHashMap<Integer>().withKeysValues(1, true, 2, true, 3, false, 4, false);
        Assert.assertEquals(ObjectBooleanHashMap.newWithKeysValues(1, true, 2, false), hashMap0);
        Assert.assertEquals(ObjectBooleanHashMap.newWithKeysValues(1, false, 2, false, 3, true), hashMap1);
        Assert.assertEquals(ObjectBooleanHashMap.newWithKeysValues(1, true, 2, true, 3, false, 4, false), hashMap2);
    }

    @Test
    public void injectInto() {
        ObjectBooleanHashMap<Integer> hashMap0 = new ObjectBooleanHashMap<Integer>().withKeysValues(1, true, 2, true, 3, false, 4, false);
        Integer total = hashMap0.injectInto(Integer.valueOf(0), (result, value) -> {
            if (value) {
                return result + 2;
            }
            return result;
        });
        Assert.assertEquals(Integer.valueOf(4), total);
    }

    @Test
    public void put_every_slot() {
        ObjectBooleanHashMap<String> hashMap = ObjectBooleanHashMap.newMap();
        for (int each = 2; each < 100; each++) {
            Assert.assertFalse(hashMap.get(String.valueOf(each)));
            hashMap.put(String.valueOf(each), each % 2 == 0);
            Assert.assertEquals(each % 2 == 0, hashMap.get(String.valueOf(each)));
            hashMap.remove(String.valueOf(each));
            Assert.assertFalse(hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void remove_iterator_every_slot() {
        ObjectBooleanHashMap<String> hashMap = ObjectBooleanHashMap.newMap();
        for (int each = 2; each < 100; each++) {
            Assert.assertFalse(hashMap.get(String.valueOf(each)));
            hashMap.put(String.valueOf(each), false);
            Iterator<String> iterator = hashMap.keySet().iterator();
            Assert.assertTrue(iterator.hasNext());
            Assert.assertEquals(String.valueOf(each), iterator.next());
            iterator.remove();
            Assert.assertFalse(hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void getIfAbsentPut_every_slot() {
        ObjectBooleanHashMap<String> hashMap = ObjectBooleanHashMap.newMap();
        for (int each = 2; each < 100; each++) {
            Assert.assertFalse(hashMap.get(String.valueOf(each)));
            hashMap.getIfAbsentPut(String.valueOf(each), each % 2 == 0);
            Assert.assertEquals(each % 2 == 0, hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void getIfAbsentPutWith_every_slot() {
        BooleanFunction<String> functionLength = String::isEmpty;
        MutableObjectBooleanMap<String> hashMap = this.getEmptyMap();
        for (int each = 2; each < 100; each++) {
            Assert.assertFalse(hashMap.get(String.valueOf(each)));
            Assert.assertTrue(hashMap.getIfAbsentPutWith(String.valueOf(each), functionLength, ""));
            Assert.assertTrue(hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void getIfAbsentPutWithKey_every_slot() {
        BooleanFunction<Integer> function = (Integer each) -> each % 2 == 0;
        MutableObjectBooleanMap<Integer> hashMap = this.getEmptyMap();
        for (int each = 2; each < 100; each++) {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertEquals(each % 2 == 0, hashMap.getIfAbsentPutWithKey(each, function));
            Assert.assertEquals(each % 2 == 0, hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPut_Function_every_slot() {
        BooleanFunction0 factory = () -> true;
        MutableObjectBooleanMap<String> hashMap = this.getEmptyMap();
        for (int each = 2; each < 100; each++) {
            Assert.assertFalse(hashMap.get(String.valueOf(each)));
            Assert.assertTrue(hashMap.getIfAbsentPut(String.valueOf(each), factory));
            Assert.assertTrue(hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void updateValue_every_slot() {
        BooleanToBooleanFunction function = (boolean value) -> !value;
        ObjectBooleanHashMap<String> hashMap = new ObjectBooleanHashMap<>();
        for (int each = 2; each < 100; each++) {
            Assert.assertFalse(hashMap.get(String.valueOf(each)));
            Assert.assertEquals(each % 2 != 0, hashMap.updateValue(String.valueOf(each), each % 2 == 0, function));
            Assert.assertEquals(each % 2 != 0, hashMap.get(String.valueOf(each)));
        }
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectBooleanHashMapTestCase instance;

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
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
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
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
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
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
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
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAndPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAndPut);
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
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putDuplicateWithRemovedSlot);
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
        public void benchmark_withoutKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAllKeys);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_consecutive_invocation_of_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_consecutive_invocation_of_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_invocation_of_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_invocation_of_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_defaultInitialCapacity() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.defaultInitialCapacity);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithInitialCapacity() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithInitialCapacity);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithInitialCapacity_negative_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithInitialCapacity_negative_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKeyIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKeyIfAbsent);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putWithRehash() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putWithRehash);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove_iterator_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove_iterator_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Function_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Function_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue_every_slot);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new ObjectBooleanHashMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> iterator_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> remove_iterator_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> getIfAbsentPut_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> getIfAbsentPutWith_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> getIfAbsentPutWithKey_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> getIfAbsentPut_Function_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapTestCase> updateValue_every_slot;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.get = ObjectBooleanHashMapTestCase::get;
            this.payloads.getIfAbsent = ObjectBooleanHashMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = ObjectBooleanHashMapTestCase::getOrThrow;
            this.payloads.containsKey = ObjectBooleanHashMapTestCase::containsKey;
            this.payloads.containsValue = ObjectBooleanHashMapTestCase::containsValue;
            this.payloads.size = ObjectBooleanHashMapTestCase::size;
            this.payloads.isEmpty = ObjectBooleanHashMapTestCase::isEmpty;
            this.payloads.notEmpty = ObjectBooleanHashMapTestCase::notEmpty;
            this.payloads.testEquals = ObjectBooleanHashMapTestCase::testEquals;
            this.payloads.testHashCode = ObjectBooleanHashMapTestCase::testHashCode;
            this.payloads.testToString = ObjectBooleanHashMapTestCase::testToString;
            this.payloads.forEachValue = ObjectBooleanHashMapTestCase::forEachValue;
            this.payloads.forEach = ObjectBooleanHashMapTestCase::forEach;
            this.payloads.forEachKey = ObjectBooleanHashMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = ObjectBooleanHashMapTestCase::forEachKeyValue;
            this.payloads.makeString = ObjectBooleanHashMapTestCase::makeString;
            this.payloads.appendString = ObjectBooleanHashMapTestCase::appendString;
            this.payloads.select = ObjectBooleanHashMapTestCase::select;
            this.payloads.reject = ObjectBooleanHashMapTestCase::reject;
            this.payloads.count = ObjectBooleanHashMapTestCase::count;
            this.payloads.anySatisfy = ObjectBooleanHashMapTestCase::anySatisfy;
            this.payloads.allSatisfy = ObjectBooleanHashMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = ObjectBooleanHashMapTestCase::noneSatisfy;
            this.payloads.detectIfNone = ObjectBooleanHashMapTestCase::detectIfNone;
            this.payloads.collect = ObjectBooleanHashMapTestCase::collect;
            this.payloads.toArray = ObjectBooleanHashMapTestCase::toArray;
            this.payloads.toArrayWithTargetArray = ObjectBooleanHashMapTestCase::toArrayWithTargetArray;
            this.payloads.contains = ObjectBooleanHashMapTestCase::contains;
            this.payloads.containsAll = ObjectBooleanHashMapTestCase::containsAll;
            this.payloads.containsAllIterable = ObjectBooleanHashMapTestCase::containsAllIterable;
            this.payloads.toList = ObjectBooleanHashMapTestCase::toList;
            this.payloads.toSet = ObjectBooleanHashMapTestCase::toSet;
            this.payloads.toBag = ObjectBooleanHashMapTestCase::toBag;
            this.payloads.asLazy = ObjectBooleanHashMapTestCase::asLazy;
            this.payloads.iterator = ObjectBooleanHashMapTestCase::iterator;
            this.payloads.toImmutable = ObjectBooleanHashMapTestCase::toImmutable;
            this.payloads.getAndPut = ObjectBooleanHashMapTestCase::getAndPut;
            this.payloads.clear = ObjectBooleanHashMapTestCase::clear;
            this.payloads.removeKey = ObjectBooleanHashMapTestCase::removeKey;
            this.payloads.put = ObjectBooleanHashMapTestCase::put;
            this.payloads.putDuplicateWithRemovedSlot = ObjectBooleanHashMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut_Function = ObjectBooleanHashMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = ObjectBooleanHashMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = ObjectBooleanHashMapTestCase::getIfAbsentPutWithKey;
            this.payloads.withoutKey = ObjectBooleanHashMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = ObjectBooleanHashMapTestCase::withoutAllKeys;
            this.payloads.withAllKeyValues = ObjectBooleanHashMapTestCase::withAllKeyValues;
            this.payloads.asUnmodifiable = ObjectBooleanHashMapTestCase::asUnmodifiable;
            this.payloads.asSynchronized = ObjectBooleanHashMapTestCase::asSynchronized;
            this.payloads.iterator_remove = ObjectBooleanHashMapTestCase::iterator_remove;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = ObjectBooleanHashMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = ObjectBooleanHashMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.defaultInitialCapacity = ObjectBooleanHashMapTestCase::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = ObjectBooleanHashMapTestCase::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectBooleanHashMapTestCase::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = ObjectBooleanHashMapTestCase::newMap;
            this.payloads.removeKeyIfAbsent = ObjectBooleanHashMapTestCase::removeKeyIfAbsent;
            this.payloads.putWithRehash = ObjectBooleanHashMapTestCase::putWithRehash;
            this.payloads.getIfAbsentPut = ObjectBooleanHashMapTestCase::getIfAbsentPut;
            this.payloads.updateValue = ObjectBooleanHashMapTestCase::updateValue;
            this.payloads.withKeysValues = ObjectBooleanHashMapTestCase::withKeysValues;
            this.payloads.injectInto = ObjectBooleanHashMapTestCase::injectInto;
            this.payloads.put_every_slot = ObjectBooleanHashMapTestCase::put_every_slot;
            this.payloads.remove_iterator_every_slot = ObjectBooleanHashMapTestCase::remove_iterator_every_slot;
            this.payloads.getIfAbsentPut_every_slot = ObjectBooleanHashMapTestCase::getIfAbsentPut_every_slot;
            this.payloads.getIfAbsentPutWith_every_slot = ObjectBooleanHashMapTestCase::getIfAbsentPutWith_every_slot;
            this.payloads.getIfAbsentPutWithKey_every_slot = ObjectBooleanHashMapTestCase::getIfAbsentPutWithKey_every_slot;
            this.payloads.getIfAbsentPut_Function_every_slot = ObjectBooleanHashMapTestCase::getIfAbsentPut_Function_every_slot;
            this.payloads.updateValue_every_slot = ObjectBooleanHashMapTestCase::updateValue_every_slot;
        }
    }
}
