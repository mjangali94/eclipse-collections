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

import org.junit.Assert;
import org.junit.Test;

public class SynchronizedObjectBooleanMapTest extends AbstractMutableObjectBooleanMapTestCase {

    private final SynchronizedObjectBooleanMap<String> map = this.classUnderTest();

    @Override
    protected SynchronizedObjectBooleanMap<String> classUnderTest() {
        return new SynchronizedObjectBooleanMap<>(ObjectBooleanHashMap.newWithKeysValues("0", true, "1", true, "2", false));
    }

    @Override
    protected <T> SynchronizedObjectBooleanMap<T> newWithKeysValues(T key1, boolean value1) {
        return new SynchronizedObjectBooleanMap<>(ObjectBooleanHashMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <T> SynchronizedObjectBooleanMap<T> newWithKeysValues(T key1, boolean value1, T key2, boolean value2) {
        return new SynchronizedObjectBooleanMap<>(ObjectBooleanHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> SynchronizedObjectBooleanMap<T> newWithKeysValues(T key1, boolean value1, T key2, boolean value2, T key3, boolean value3) {
        return new SynchronizedObjectBooleanMap<>(ObjectBooleanHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> SynchronizedObjectBooleanMap<T> newWithKeysValues(T key1, boolean value1, T key2, boolean value2, T key3, boolean value3, T key4, boolean value4) {
        return new SynchronizedObjectBooleanMap<>(ObjectBooleanHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected <T> SynchronizedObjectBooleanMap<T> getEmptyMap() {
        return new SynchronizedObjectBooleanMap<>(new ObjectBooleanHashMap<>());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedObjectBooleanMapTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrThrow() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrThrow);
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
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
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
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArrayWithTargetArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArrayWithTargetArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
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
        public void benchmark_getAndPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAndPut);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putDuplicateWithRemovedSlot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Function() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Function);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAllKeys);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_consecutive_invocation_of_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_consecutive_invocation_of_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_invocation_of_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_invocation_of_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedObjectBooleanMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> iterator_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectBooleanMapTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.get = SynchronizedObjectBooleanMapTest::get;
            this.payloads.getIfAbsent = SynchronizedObjectBooleanMapTest::getIfAbsent;
            this.payloads.getOrThrow = SynchronizedObjectBooleanMapTest::getOrThrow;
            this.payloads.containsKey = SynchronizedObjectBooleanMapTest::containsKey;
            this.payloads.containsValue = SynchronizedObjectBooleanMapTest::containsValue;
            this.payloads.size = SynchronizedObjectBooleanMapTest::size;
            this.payloads.isEmpty = SynchronizedObjectBooleanMapTest::isEmpty;
            this.payloads.notEmpty = SynchronizedObjectBooleanMapTest::notEmpty;
            this.payloads.testEquals = SynchronizedObjectBooleanMapTest::testEquals;
            this.payloads.testHashCode = SynchronizedObjectBooleanMapTest::testHashCode;
            this.payloads.testToString = SynchronizedObjectBooleanMapTest::testToString;
            this.payloads.forEachValue = SynchronizedObjectBooleanMapTest::forEachValue;
            this.payloads.forEach = SynchronizedObjectBooleanMapTest::forEach;
            this.payloads.forEachKey = SynchronizedObjectBooleanMapTest::forEachKey;
            this.payloads.forEachKeyValue = SynchronizedObjectBooleanMapTest::forEachKeyValue;
            this.payloads.makeString = SynchronizedObjectBooleanMapTest::makeString;
            this.payloads.appendString = SynchronizedObjectBooleanMapTest::appendString;
            this.payloads.select = SynchronizedObjectBooleanMapTest::select;
            this.payloads.reject = SynchronizedObjectBooleanMapTest::reject;
            this.payloads.count = SynchronizedObjectBooleanMapTest::count;
            this.payloads.anySatisfy = SynchronizedObjectBooleanMapTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedObjectBooleanMapTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedObjectBooleanMapTest::noneSatisfy;
            this.payloads.detectIfNone = SynchronizedObjectBooleanMapTest::detectIfNone;
            this.payloads.collect = SynchronizedObjectBooleanMapTest::collect;
            this.payloads.toArray = SynchronizedObjectBooleanMapTest::toArray;
            this.payloads.toArrayWithTargetArray = SynchronizedObjectBooleanMapTest::toArrayWithTargetArray;
            this.payloads.contains = SynchronizedObjectBooleanMapTest::contains;
            this.payloads.containsAll = SynchronizedObjectBooleanMapTest::containsAll;
            this.payloads.containsAllIterable = SynchronizedObjectBooleanMapTest::containsAllIterable;
            this.payloads.toList = SynchronizedObjectBooleanMapTest::toList;
            this.payloads.toSet = SynchronizedObjectBooleanMapTest::toSet;
            this.payloads.toBag = SynchronizedObjectBooleanMapTest::toBag;
            this.payloads.asLazy = SynchronizedObjectBooleanMapTest::asLazy;
            this.payloads.iterator = SynchronizedObjectBooleanMapTest::iterator;
            this.payloads.toImmutable = SynchronizedObjectBooleanMapTest::toImmutable;
            this.payloads.getAndPut = SynchronizedObjectBooleanMapTest::getAndPut;
            this.payloads.clear = SynchronizedObjectBooleanMapTest::clear;
            this.payloads.removeKey = SynchronizedObjectBooleanMapTest::removeKey;
            this.payloads.put = SynchronizedObjectBooleanMapTest::put;
            this.payloads.putDuplicateWithRemovedSlot = SynchronizedObjectBooleanMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut_Function = SynchronizedObjectBooleanMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = SynchronizedObjectBooleanMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = SynchronizedObjectBooleanMapTest::getIfAbsentPutWithKey;
            this.payloads.withKeysValues = SynchronizedObjectBooleanMapTest::withKeysValues;
            this.payloads.withoutKey = SynchronizedObjectBooleanMapTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedObjectBooleanMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = SynchronizedObjectBooleanMapTest::withAllKeyValues;
            this.payloads.asUnmodifiable = SynchronizedObjectBooleanMapTest::asUnmodifiable;
            this.payloads.iterator_remove = SynchronizedObjectBooleanMapTest::iterator_remove;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = SynchronizedObjectBooleanMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = SynchronizedObjectBooleanMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.asSynchronized = SynchronizedObjectBooleanMapTest::asSynchronized;
        }
    }
}
