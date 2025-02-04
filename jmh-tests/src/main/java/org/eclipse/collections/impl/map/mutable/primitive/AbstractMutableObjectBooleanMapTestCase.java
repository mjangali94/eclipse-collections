/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable.primitive;

import org.eclipse.collections.api.block.function.primitive.BooleanFunction;
import org.eclipse.collections.api.block.function.primitive.BooleanFunction0;
import org.eclipse.collections.api.iterator.MutableBooleanIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableObjectBooleanMap;
import org.eclipse.collections.api.tuple.primitive.ObjectBooleanPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractMutableObjectBooleanMapTestCase extends AbstractObjectBooleanMapTestCase {

    protected final MutableObjectBooleanMap<String> map = this.classUnderTest();

    @Override
    protected abstract MutableObjectBooleanMap<String> classUnderTest();

    @Override
    protected abstract <T> MutableObjectBooleanMap<T> newWithKeysValues(T key1, boolean value1);

    @Override
    protected abstract <T> MutableObjectBooleanMap<T> newWithKeysValues(T key1, boolean value1, T key2, boolean value2);

    @Override
    protected abstract <T> MutableObjectBooleanMap<T> newWithKeysValues(T key1, boolean value1, T key2, boolean value2, T key3, boolean value3);

    @Override
    protected abstract <T> MutableObjectBooleanMap<T> newWithKeysValues(T key1, boolean value1, T key2, boolean value2, T key3, boolean value3, T key4, boolean value4);

    @Override
    protected abstract <T> MutableObjectBooleanMap<T> getEmptyMap();

    @Override
    public void get() {
        super.get();
        MutableObjectBooleanMap<String> map1 = this.classUnderTest();
        map1.put("0", false);
        Assert.assertFalse(map1.get("0"));
        map1.put("5", true);
        Assert.assertTrue(map1.get("5"));
        map1.put(null, true);
        Assert.assertTrue(map1.get(null));
    }

    @Override
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableObjectBooleanMap<String> map1 = this.classUnderTest();
        map1.removeKey("0");
        Assert.assertTrue(map1.getIfAbsent("0", true));
        Assert.assertFalse(map1.getIfAbsent("0", false));
        map1.put("0", false);
        Assert.assertFalse(map1.getIfAbsent("0", true));
        map1.put("5", true);
        Assert.assertTrue(map1.getIfAbsent("5", false));
        map1.put(null, false);
        Assert.assertFalse(map1.getIfAbsent(null, true));
    }

    @Override
    public void getOrThrow() {
        super.getOrThrow();
        MutableObjectBooleanMap<String> map1 = this.classUnderTest();
        map1.removeKey("0");
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow("0"));
        map1.put("0", false);
        Assert.assertFalse(map1.getOrThrow("0"));
        map1.put("5", true);
        Assert.assertTrue(map1.getOrThrow("5"));
        map1.put(null, false);
        Assert.assertFalse(map1.getOrThrow(null));
    }

    @Test
    public void getAndPut() {
        MutableObjectBooleanMap<Integer> map1 = this.getEmptyMap();
        Assert.assertTrue(map1.getAndPut(Integer.valueOf(1), false, true));
        Assert.assertFalse(map1.getAndPut(Integer.valueOf(2), false, false));
        Assert.assertFalse(map1.getAndPut(Integer.valueOf(1), true, true));
        map1.remove(Integer.valueOf(1));
        Assert.assertFalse(map1.getAndPut(Integer.valueOf(1), true, false));
    }

    @Override
    public void containsKey() {
        super.containsKey();
        MutableObjectBooleanMap<String> map1 = this.classUnderTest();
        map1.removeKey("0");
        Assert.assertFalse(map1.containsKey("0"));
        Assert.assertFalse(map1.get("0"));
        map1.removeKey("0");
        Assert.assertFalse(map1.containsKey("0"));
        Assert.assertFalse(map1.get("0"));
        map1.removeKey("1");
        Assert.assertFalse(map1.containsKey("1"));
        Assert.assertFalse(map1.get("1"));
        map1.removeKey("2");
        Assert.assertFalse(map1.containsKey("2"));
        Assert.assertFalse(map1.get("2"));
        map1.removeKey("3");
        Assert.assertFalse(map1.containsKey("3"));
        Assert.assertFalse(map1.get("3"));
        map1.put(null, true);
        Assert.assertTrue(map1.containsKey(null));
        map1.removeKey(null);
        Assert.assertFalse(map1.containsKey(null));
    }

    @Override
    public void containsValue() {
        super.containsValue();
        this.classUnderTest().clear();
        this.classUnderTest().put("5", true);
        Assert.assertTrue(this.classUnderTest().containsValue(true));
        this.classUnderTest().put(null, false);
        Assert.assertTrue(this.classUnderTest().containsValue(false));
    }

    @Override
    public void size() {
        super.size();
        MutableObjectBooleanMap<Integer> hashMap1 = this.newWithKeysValues(1, true, 0, false);
        Verify.assertSize(2, hashMap1);
        hashMap1.removeKey(1);
        Verify.assertSize(1, hashMap1);
        hashMap1.removeKey(0);
        Verify.assertSize(0, hashMap1);
    }

    @Override
    public void contains() {
        super.contains();
        MutableObjectBooleanMap<String> map1 = this.classUnderTest();
        map1.clear();
        map1.put("5", true);
        Assert.assertTrue(map1.contains(true));
        map1.put(null, false);
        Assert.assertTrue(map1.contains(false));
        map1.removeKey("5");
        Assert.assertFalse(map1.contains(true));
        Assert.assertTrue(map1.contains(false));
        map1.removeKey(null);
        Assert.assertFalse(map1.contains(false));
    }

    @Override
    public void containsAll() {
        super.containsAll();
        MutableObjectBooleanMap<String> map1 = this.classUnderTest();
        map1.clear();
        map1.put("5", true);
        Assert.assertTrue(map1.containsAll(true));
        Assert.assertFalse(map1.containsAll(true, false));
        Assert.assertFalse(map1.containsAll(false, false));
        map1.put(null, false);
        Assert.assertTrue(map1.containsAll(false));
        Assert.assertTrue(map1.containsAll(true, false));
        map1.removeKey("5");
        Assert.assertFalse(map1.containsAll(true));
        Assert.assertFalse(map1.containsAll(true, false));
        Assert.assertTrue(map1.containsAll(false, false));
        map1.removeKey(null);
        Assert.assertFalse(map1.containsAll(false, true));
    }

    @Override
    public void containsAllIterable() {
        super.containsAllIterable();
        MutableObjectBooleanMap<String> map1 = this.classUnderTest();
        map1.clear();
        map1.put("5", true);
        Assert.assertTrue(map1.containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertFalse(map1.containsAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertFalse(map1.containsAll(BooleanArrayList.newListWith(false, false)));
        map1.put(null, false);
        Assert.assertTrue(map1.containsAll(BooleanArrayList.newListWith(false)));
        Assert.assertTrue(map1.containsAll(BooleanArrayList.newListWith(true, false)));
        map1.removeKey("5");
        Assert.assertFalse(map1.containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertFalse(map1.containsAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertTrue(map1.containsAll(BooleanArrayList.newListWith(false, false)));
        map1.removeKey(null);
        Assert.assertFalse(map1.containsAll(BooleanArrayList.newListWith(false, true)));
    }

    protected static MutableList<String> generateCollisions() {
        MutableList<String> collisions = FastList.newList();
        ObjectBooleanHashMap<String> hashMap = new ObjectBooleanHashMap<>();
        for (int each = 3; collisions.size() <= 10; each++) {
            if (hashMap.spread(String.valueOf(each)) == hashMap.spread(String.valueOf(3))) {
                collisions.add(String.valueOf(each));
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableObjectBooleanMap<String> hashMap = this.getEmptyMap();
        hashMap.put("0", true);
        hashMap.clear();
        Assert.assertEquals(ObjectBooleanHashMap.newMap(), hashMap);
        hashMap.put("1", false);
        hashMap.clear();
        Assert.assertEquals(ObjectBooleanHashMap.newMap(), hashMap);
        hashMap.put(null, true);
        hashMap.clear();
        Assert.assertEquals(ObjectBooleanHashMap.newMap(), hashMap);
    }

    @Test
    public void removeKey() {
        MutableObjectBooleanMap<String> map0 = this.newWithKeysValues("0", true, "1", false);
        map0.removeKey("1");
        Assert.assertEquals(this.newWithKeysValues("0", true), map0);
        map0.removeKey("0");
        Assert.assertEquals(ObjectBooleanHashMap.newMap(), map0);
        MutableObjectBooleanMap<String> map1 = this.newWithKeysValues("0", false, "1", true);
        map1.removeKey("0");
        Assert.assertEquals(this.newWithKeysValues("1", true), map1);
        map1.removeKey("1");
        Assert.assertEquals(ObjectBooleanHashMap.newMap(), map1);
        this.map.removeKey("5");
        Assert.assertEquals(this.newWithKeysValues("0", true, "1", true, "2", false), this.map);
        this.map.removeKey("0");
        Assert.assertEquals(this.newWithKeysValues("1", true, "2", false), this.map);
        this.map.removeKey("1");
        Assert.assertEquals(this.newWithKeysValues("2", false), this.map);
        this.map.removeKey("2");
        Assert.assertEquals(ObjectBooleanHashMap.newMap(), this.map);
        this.map.removeKey("0");
        this.map.removeKey("1");
        this.map.removeKey("2");
        Assert.assertEquals(ObjectBooleanHashMap.newMap(), this.map);
        Verify.assertEmpty(this.map);
        this.map.put(null, true);
        Assert.assertTrue(this.map.get(null));
        this.map.removeKey(null);
        Assert.assertFalse(this.map.get(null));
    }

    @Test
    public void put() {
        this.map.put("0", false);
        this.map.put("1", false);
        this.map.put("2", true);
        ObjectBooleanHashMap<String> expected = ObjectBooleanHashMap.newWithKeysValues("0", false, "1", false, "2", true);
        Assert.assertEquals(expected, this.map);
        this.map.put("5", true);
        expected.put("5", true);
        Assert.assertEquals(expected, this.map);
        this.map.put(null, false);
        expected.put(null, false);
        Assert.assertEquals(expected, this.map);
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        String collision1 = generateCollisions().getFirst();
        String collision2 = generateCollisions().get(1);
        String collision3 = generateCollisions().get(2);
        String collision4 = generateCollisions().get(3);
        MutableObjectBooleanMap<String> hashMap = this.getEmptyMap();
        hashMap.put(collision1, true);
        hashMap.put(collision2, false);
        hashMap.put(collision3, true);
        Assert.assertFalse(hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, false);
        Assert.assertEquals(this.newWithKeysValues(collision1, true, collision3, true, collision4, false), hashMap);
        MutableObjectBooleanMap<String> hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, false);
        hashMap1.put(collision2, false);
        hashMap1.put(collision3, true);
        Assert.assertFalse(hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, true);
        Assert.assertEquals(this.newWithKeysValues(collision2, false, collision3, true, collision4, true), hashMap1);
        MutableObjectBooleanMap<String> hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, true);
        hashMap2.put(collision2, true);
        hashMap2.put(collision3, false);
        Assert.assertFalse(hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, false);
        Assert.assertEquals(this.newWithKeysValues(collision1, true, collision2, true, collision4, false), hashMap2);
        MutableObjectBooleanMap<String> hashMap3 = this.getEmptyMap();
        hashMap3.put(collision1, true);
        hashMap3.put(collision2, true);
        hashMap3.put(collision3, false);
        Assert.assertTrue(hashMap3.get(collision2));
        Assert.assertFalse(hashMap3.get(collision3));
        hashMap3.removeKey(collision2);
        hashMap3.removeKey(collision3);
        hashMap3.put(collision4, false);
        Assert.assertEquals(this.newWithKeysValues(collision1, true, collision4, false), hashMap3);
        MutableObjectBooleanMap<String> hashMap4 = this.getEmptyMap();
        hashMap4.put(null, false);
        Assert.assertEquals(this.newWithKeysValues(null, false), hashMap4);
        hashMap4.put(null, true);
        Assert.assertEquals(this.newWithKeysValues(null, true), hashMap4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        MutableObjectBooleanMap<Integer> map1 = this.getEmptyMap();
        Assert.assertTrue(map1.getIfAbsentPut(0, () -> true));
        BooleanFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        Assert.assertTrue(map1.getIfAbsentPut(0, factoryThrows));
        Assert.assertEquals(this.newWithKeysValues(0, true), map1);
        Assert.assertTrue(map1.getIfAbsentPut(1, () -> true));
        Assert.assertTrue(map1.getIfAbsentPut(1, factoryThrows));
        Assert.assertEquals(this.newWithKeysValues(0, true, 1, true), map1);
        MutableObjectBooleanMap<Integer> map2 = this.getEmptyMap();
        Assert.assertFalse(map2.getIfAbsentPut(1, () -> false));
        Assert.assertFalse(map2.getIfAbsentPut(1, factoryThrows));
        Assert.assertEquals(this.newWithKeysValues(1, false), map2);
        Assert.assertFalse(map2.getIfAbsentPut(0, () -> false));
        Assert.assertFalse(map2.getIfAbsentPut(0, factoryThrows));
        Assert.assertEquals(this.newWithKeysValues(0, false, 1, false), map2);
        MutableObjectBooleanMap<Integer> map3 = this.getEmptyMap();
        Assert.assertTrue(map3.getIfAbsentPut(null, () -> true));
        Assert.assertTrue(map3.getIfAbsentPut(null, factoryThrows));
        Assert.assertEquals(this.newWithKeysValues(null, true), map3);
    }

    @Test
    public void getIfAbsentPutWith() {
        BooleanFunction<String> functionLengthEven = string -> (string.length() & 1) == 0;
        MutableObjectBooleanMap<Integer> map1 = this.getEmptyMap();
        Assert.assertFalse(map1.getIfAbsentPutWith(0, functionLengthEven, "123456789"));
        BooleanFunction<String> functionThrows = string -> {
            throw new AssertionError();
        };
        Assert.assertFalse(map1.getIfAbsentPutWith(0, functionThrows, "unused"));
        Assert.assertEquals(this.newWithKeysValues(0, false), map1);
        Assert.assertFalse(map1.getIfAbsentPutWith(1, functionLengthEven, "123456789"));
        Assert.assertFalse(map1.getIfAbsentPutWith(1, functionThrows, "unused"));
        Assert.assertEquals(this.newWithKeysValues(0, false, 1, false), map1);
        MutableObjectBooleanMap<Integer> map2 = this.getEmptyMap();
        Assert.assertTrue(map2.getIfAbsentPutWith(1, functionLengthEven, "1234567890"));
        Assert.assertTrue(map2.getIfAbsentPutWith(1, functionThrows, "unused0"));
        Assert.assertEquals(this.newWithKeysValues(1, true), map2);
        Assert.assertTrue(map2.getIfAbsentPutWith(0, functionLengthEven, "1234567890"));
        Assert.assertTrue(map2.getIfAbsentPutWith(0, functionThrows, "unused0"));
        Assert.assertEquals(this.newWithKeysValues(0, true, 1, true), map2);
        MutableObjectBooleanMap<Integer> map3 = this.getEmptyMap();
        Assert.assertFalse(map3.getIfAbsentPutWith(null, functionLengthEven, "123456789"));
        Assert.assertFalse(map3.getIfAbsentPutWith(null, functionThrows, "unused"));
        Assert.assertEquals(this.newWithKeysValues(null, false), map3);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        BooleanFunction<Integer> function = anObject -> anObject == null || (anObject & 1) == 0;
        MutableObjectBooleanMap<Integer> map1 = this.getEmptyMap();
        Assert.assertTrue(map1.getIfAbsentPutWithKey(0, function));
        BooleanFunction<Integer> functionThrows = anObject -> {
            throw new AssertionError();
        };
        Assert.assertTrue(map1.getIfAbsentPutWithKey(0, functionThrows));
        Assert.assertEquals(this.newWithKeysValues(0, true), map1);
        Assert.assertFalse(map1.getIfAbsentPutWithKey(1, function));
        Assert.assertFalse(map1.getIfAbsentPutWithKey(1, functionThrows));
        Assert.assertEquals(this.newWithKeysValues(0, true, 1, false), map1);
        MutableObjectBooleanMap<Integer> map2 = this.getEmptyMap();
        Assert.assertFalse(map2.getIfAbsentPutWithKey(1, function));
        Assert.assertFalse(map2.getIfAbsentPutWithKey(1, functionThrows));
        Assert.assertEquals(this.newWithKeysValues(1, false), map2);
        Assert.assertTrue(map2.getIfAbsentPutWithKey(0, function));
        Assert.assertTrue(map2.getIfAbsentPutWithKey(0, functionThrows));
        Assert.assertEquals(this.newWithKeysValues(0, true, 1, false), map2);
        MutableObjectBooleanMap<Integer> map3 = this.getEmptyMap();
        Assert.assertTrue(map3.getIfAbsentPutWithKey(null, function));
        Assert.assertTrue(map3.getIfAbsentPutWithKey(null, functionThrows));
        Assert.assertEquals(this.newWithKeysValues(null, true), map3);
    }

    @Test
    public void withKeysValues() {
        MutableObjectBooleanMap<Integer> emptyMap = this.getEmptyMap();
        MutableObjectBooleanMap<Integer> hashMap = emptyMap.withKeyValue(1, true);
        Assert.assertEquals(this.newWithKeysValues(1, true), hashMap);
        Assert.assertSame(emptyMap, hashMap);
    }

    @Test
    public void withoutKey() {
        MutableObjectBooleanMap<Integer> hashMap = this.newWithKeysValues(1, true, 2, true, 3, false, 4, false);
        MutableObjectBooleanMap<Integer> actual = hashMap.withoutKey(5);
        Assert.assertSame(hashMap, actual);
        Assert.assertEquals(this.newWithKeysValues(1, true, 2, true, 3, false, 4, false), actual);
        Assert.assertEquals(this.newWithKeysValues(1, true, 2, true, 3, false), hashMap.withoutKey(4));
        Assert.assertEquals(this.newWithKeysValues(1, true, 2, true), hashMap.withoutKey(3));
        Assert.assertEquals(this.newWithKeysValues(1, true), hashMap.withoutKey(2));
        Assert.assertEquals(ObjectBooleanHashMap.newMap(), hashMap.withoutKey(1));
        Assert.assertEquals(ObjectBooleanHashMap.newMap(), hashMap.withoutKey(1));
    }

    @Test
    public void withoutAllKeys() {
        MutableObjectBooleanMap<Integer> hashMap = this.newWithKeysValues(1, true, 2, true, 3, false, 4, false);
        MutableObjectBooleanMap<Integer> actual = hashMap.withoutAllKeys(FastList.newListWith(5, 6, 7));
        Assert.assertSame(hashMap, actual);
        Assert.assertEquals(this.newWithKeysValues(1, true, 2, true, 3, false, 4, false), actual);
        Assert.assertEquals(this.newWithKeysValues(1, true, 2, true), hashMap.withoutAllKeys(FastList.newListWith(5, 4, 3)));
        Assert.assertEquals(this.newWithKeysValues(1, true), hashMap.withoutAllKeys(FastList.newListWith(2)));
        Assert.assertEquals(ObjectBooleanHashMap.newMap(), hashMap.withoutAllKeys(FastList.newListWith(1)));
        Assert.assertEquals(ObjectBooleanHashMap.newMap(), hashMap.withoutAllKeys(FastList.newListWith(5, 6)));
    }

    @Test
    public void withAllKeyValues() {
        MutableObjectBooleanMap<Integer> emptyMap = this.getEmptyMap();
        MutableObjectBooleanMap<Integer> partialMap = this.newWithKeysValues(1, true, 3, false);
        MutableObjectBooleanMap<Integer> completeMap = this.newWithKeysValues(1, true, 2, true, 3, false, 4, false);
        Iterable<ObjectBooleanPair<Integer>> emptyIterable = Iterables.iList();
        Iterable<ObjectBooleanPair<Integer>> partialIterable = Iterables.iList(PrimitiveTuples.pair(Integer.valueOf(1), true), PrimitiveTuples.pair(Integer.valueOf(3), false));
        Iterable<ObjectBooleanPair<Integer>> completeIterable = Iterables.iList(PrimitiveTuples.pair(Integer.valueOf(1), true), PrimitiveTuples.pair(Integer.valueOf(2), true), PrimitiveTuples.pair(Integer.valueOf(3), false), PrimitiveTuples.pair(Integer.valueOf(4), false));
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
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableObjectBooleanMap.class, this.map.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableObjectBooleanMap<>(this.map), this.map.asUnmodifiable());
    }

    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedObjectBooleanMap.class, this.map.asSynchronized());
        Assert.assertEquals(new SynchronizedObjectBooleanMap<>(this.map), this.map.asSynchronized());
    }

    @Test
    public void iterator_remove() {
        MutableObjectBooleanMap<String> map = this.classUnderTest();
        Verify.assertNotEmpty(map);
        MutableBooleanIterator booleanIterator = map.booleanIterator();
        while (booleanIterator.hasNext()) {
            booleanIterator.next();
            booleanIterator.remove();
        }
        Verify.assertEmpty(map);
    }

    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove() {
        MutableObjectBooleanMap<String> map = this.classUnderTest();
        Verify.assertNotEmpty(map);
        MutableBooleanIterator booleanIterator = map.booleanIterator();
        Assert.assertTrue(booleanIterator.hasNext());
        booleanIterator.next();
        booleanIterator.remove();
        Assert.assertThrows(IllegalStateException.class, booleanIterator::remove);
    }

    @Test
    public void iterator_throws_on_invocation_of_remove_before_next() {
        MutableObjectBooleanMap<String> map = this.classUnderTest();
        MutableBooleanIterator booleanIterator = map.booleanIterator();
        Assert.assertTrue(booleanIterator.hasNext());
        Assert.assertThrows(IllegalStateException.class, booleanIterator::remove);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableObjectBooleanMapTestCase instance;

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
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableObjectBooleanMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> iterator_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectBooleanMapTestCase> iterator_throws_on_invocation_of_remove_before_next;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.get = AbstractMutableObjectBooleanMapTestCase::get;
            this.payloads.getIfAbsent = AbstractMutableObjectBooleanMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractMutableObjectBooleanMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractMutableObjectBooleanMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableObjectBooleanMapTestCase::containsValue;
            this.payloads.size = AbstractMutableObjectBooleanMapTestCase::size;
            this.payloads.isEmpty = AbstractMutableObjectBooleanMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableObjectBooleanMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableObjectBooleanMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableObjectBooleanMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableObjectBooleanMapTestCase::testToString;
            this.payloads.forEachValue = AbstractMutableObjectBooleanMapTestCase::forEachValue;
            this.payloads.forEach = AbstractMutableObjectBooleanMapTestCase::forEach;
            this.payloads.forEachKey = AbstractMutableObjectBooleanMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableObjectBooleanMapTestCase::forEachKeyValue;
            this.payloads.makeString = AbstractMutableObjectBooleanMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableObjectBooleanMapTestCase::appendString;
            this.payloads.select = AbstractMutableObjectBooleanMapTestCase::select;
            this.payloads.reject = AbstractMutableObjectBooleanMapTestCase::reject;
            this.payloads.count = AbstractMutableObjectBooleanMapTestCase::count;
            this.payloads.anySatisfy = AbstractMutableObjectBooleanMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableObjectBooleanMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableObjectBooleanMapTestCase::noneSatisfy;
            this.payloads.detectIfNone = AbstractMutableObjectBooleanMapTestCase::detectIfNone;
            this.payloads.collect = AbstractMutableObjectBooleanMapTestCase::collect;
            this.payloads.toArray = AbstractMutableObjectBooleanMapTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractMutableObjectBooleanMapTestCase::toArrayWithTargetArray;
            this.payloads.contains = AbstractMutableObjectBooleanMapTestCase::contains;
            this.payloads.containsAll = AbstractMutableObjectBooleanMapTestCase::containsAll;
            this.payloads.containsAllIterable = AbstractMutableObjectBooleanMapTestCase::containsAllIterable;
            this.payloads.toList = AbstractMutableObjectBooleanMapTestCase::toList;
            this.payloads.toSet = AbstractMutableObjectBooleanMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableObjectBooleanMapTestCase::toBag;
            this.payloads.asLazy = AbstractMutableObjectBooleanMapTestCase::asLazy;
            this.payloads.iterator = AbstractMutableObjectBooleanMapTestCase::iterator;
            this.payloads.toImmutable = AbstractMutableObjectBooleanMapTestCase::toImmutable;
            this.payloads.getAndPut = AbstractMutableObjectBooleanMapTestCase::getAndPut;
            this.payloads.clear = AbstractMutableObjectBooleanMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableObjectBooleanMapTestCase::removeKey;
            this.payloads.put = AbstractMutableObjectBooleanMapTestCase::put;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableObjectBooleanMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut_Function = AbstractMutableObjectBooleanMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableObjectBooleanMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableObjectBooleanMapTestCase::getIfAbsentPutWithKey;
            this.payloads.withKeysValues = AbstractMutableObjectBooleanMapTestCase::withKeysValues;
            this.payloads.withoutKey = AbstractMutableObjectBooleanMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableObjectBooleanMapTestCase::withoutAllKeys;
            this.payloads.withAllKeyValues = AbstractMutableObjectBooleanMapTestCase::withAllKeyValues;
            this.payloads.asUnmodifiable = AbstractMutableObjectBooleanMapTestCase::asUnmodifiable;
            this.payloads.asSynchronized = AbstractMutableObjectBooleanMapTestCase::asSynchronized;
            this.payloads.iterator_remove = AbstractMutableObjectBooleanMapTestCase::iterator_remove;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableObjectBooleanMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableObjectBooleanMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
        }
    }
*/
}
