/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.fixed;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.tuple.Twin;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.mutable.AbstractListTestCase;
import org.eclipse.collections.impl.list.mutable.ArrayListAdapter;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.UnmodifiableMutableList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JUnit test for {@link ArrayAdapter}.
 */
public class ArrayAdapterTest extends AbstractListTestCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayAdapterTest.class);

    @Override
    protected <T> MutableList<T> newWith(T... littleElements) {
        return ArrayAdapter.newArrayWith(littleElements);
    }

    @Test
    public void testNewList() {
        MutableList<Integer> collection = this.newArray();
        Verify.assertEmpty(collection);
        Verify.assertSize(0, collection);
        MutableList<Integer> collection1 = ArrayAdapter.newArrayWith(1, 2, 3, 4, 5, 6);
        Verify.assertSize(6, collection1);
        Verify.assertInstanceOf(ArrayAdapter.class, collection1);
    }

    private MutableList<Integer> newArray() {
        return ArrayAdapter.newArray();
    }

    @Test
    public void adapt() {
        MutableList<Integer> collection = ArrayAdapter.newArrayWith();
        Verify.assertEmpty(collection);
    }

    @Test
    public void newListWith() {
        MutableList<Integer> collection = ArrayAdapter.newArrayWith(1);
        Verify.assertNotEmpty(collection);
        Verify.assertSize(1, collection);
        Verify.assertContains(1, collection);
    }

    @Test
    public void newListWithWith() {
        MutableList<Integer> collection = ArrayAdapter.newArrayWith(1, 2);
        Verify.assertNotEmpty(collection);
        Verify.assertSize(2, collection);
        Verify.assertContainsAll(collection, 1, 2);
    }

    @Test
    public void newListWithWithWith() {
        MutableList<Integer> collection = ArrayAdapter.newArrayWith(1, 2, 3);
        Verify.assertNotEmpty(collection);
        Verify.assertSize(3, collection);
        Verify.assertContainsAll(collection, 1, 2, 3);
    }

    @Test
    public void newListWithVarArgs() {
        MutableList<Integer> collection = this.newWith(1, 2, 3, 4);
        Verify.assertNotEmpty(collection);
        Verify.assertSize(4, collection);
        Verify.assertContainsAll(collection, 1, 2, 3, 4);
    }

    @Override
    @Test
    public void forEach() {
        super.forEach();
        List<Integer> result = new ArrayList<>();
        MutableList<Integer> collection = this.newWith(1, 2, 3, 4);
        collection.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(4, result);
        Verify.assertContainsAll(result, 1, 2, 3, 4);
    }

    @Override
    @Test
    public void forEachFromTo() {
        super.forEachFromTo();
        MutableList<Integer> result = Lists.mutable.of();
        MutableList<Integer> collection = this.newWith(1, 2, 3, 4);
        collection.forEach(2, 3, result::add);
        Verify.assertSize(2, result);
        Verify.assertContainsAll(result, 3, 4);
    }

    @Override
    @Test
    public void forEachWithIndex() {
        super.forEachWithIndex();
        List<Integer> result = new ArrayList<>();
        MutableList<Integer> collection = this.newWith(1, 2, 3, 4);
        collection.forEachWithIndex((object, index) -> result.add(object + index));
        Verify.assertContainsAll(result, 1, 3, 5, 7);
    }

    @Test
    public void add() {
        MutableList<String> collection = ArrayAdapter.newArray();
        Assert.assertThrows(UnsupportedOperationException.class, () -> collection.add(null));
    }

    @Override
    @Test
    public void allSatisfy() {
        super.allSatisfy();
        Assert.assertTrue(this.newWith(1, 2, 3).allSatisfy(Integer.class::isInstance));
        Assert.assertFalse(this.newWith(1, 2, 3).allSatisfy(Integer.valueOf(1)::equals));
    }

    @Override
    @Test
    public void anySatisfy() {
        super.anySatisfy();
        Assert.assertFalse(this.newWith(1, 2, 3).anySatisfy(String.class::isInstance));
        Assert.assertTrue(this.newWith(1, 2, 3).anySatisfy(Integer.class::isInstance));
    }

    @Override
    @Test
    public void noneSatisfy() {
        super.noneSatisfy();
        Assert.assertTrue(this.newWith(1, 2, 3).noneSatisfy(String.class::isInstance));
        Assert.assertFalse(this.newWith(1, 2, 3).noneSatisfy(Integer.valueOf(1)::equals));
    }

    @Override
    @Test
    public void count() {
        super.count();
        Assert.assertEquals(3, this.newWith(1, 2, 3).count(Integer.class::isInstance));
    }

    @Override
    @Test
    public void collectIf() {
        super.collectIf();
        Verify.assertContainsAll(this.newWith(1, 2, 3).collectIf(Integer.class::isInstance, String::valueOf), "1", "2", "3");
        Verify.assertContainsAll(this.newWith(1, 2, 3).collectIf(Integer.class::isInstance, String::valueOf, new ArrayList<>()), "1", "2", "3");
    }

    @Override
    @Test
    public void getFirst() {
        super.getFirst();
        Assert.assertEquals(Integer.valueOf(1), this.newWith(1, 2, 3).getFirst());
        Assert.assertNotEquals(Integer.valueOf(3), this.newWith(1, 2, 3).getFirst());
    }

    @Override
    @Test
    public void getLast() {
        super.getLast();
        Assert.assertNotEquals(Integer.valueOf(1), this.newWith(1, 2, 3).getLast());
        Assert.assertEquals(Integer.valueOf(3), this.newWith(1, 2, 3).getLast());
    }

    @Override
    @Test
    public void isEmpty() {
        super.isEmpty();
        Verify.assertEmpty(this.newArray());
        Verify.assertNotEmpty(this.newWith(1, 2));
        Assert.assertTrue(this.newWith(1, 2).notEmpty());
    }

    @Override
    @Test
    public void iterator() {
        super.iterator();
        MutableList<Integer> objects = this.newWith(1, 2, 3);
        Iterator<Integer> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Integer integer = iterator.next();
            Assert.assertEquals(3, integer.intValue() + i);
        }
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        MutableList<Integer> objects = this.newWith(1, 2, 3);
        Integer result = objects.injectInto(1, AddFunction.INTEGER);
        Assert.assertEquals(Integer.valueOf(7), result);
    }

    @Override
    @Test
    public void toArray() {
        super.toArray();
        MutableList<Integer> objects = this.newWith(1, 2, 3);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        Integer[] array2 = objects.toArray(new Integer[3]);
        Verify.assertSize(3, array2);
        Integer[] array3 = objects.toArray(new Integer[1]);
        Verify.assertSize(3, array3);
        Integer[] expected = { 1, 2, 3 };
        Assert.assertArrayEquals(expected, array);
        Assert.assertArrayEquals(expected, array2);
        Assert.assertArrayEquals(expected, array3);
    }

    @Override
    @Test
    public void selectAndRejectWith() {
        super.selectAndRejectWith();
        MutableList<Integer> objects = this.newWith(1, 2);
        Twin<MutableList<Integer>> result = objects.selectAndRejectWith(Object::equals, 1);
        Verify.assertSize(1, result.getOne());
        Verify.assertSize(1, result.getTwo());
    }

    @Override
    @Test
    public void removeIf() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> ArrayAdapter.newArrayWith(1, 2, 3, null).removeIf(Predicates.isNull()));
    }

    @Override
    @Test
    public void removeIndex() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> ArrayAdapter.newArrayWith(1, 2, 3, null).remove(0));
    }

    @Override
    @Test
    public void removeIfWith() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> ArrayAdapter.newArrayWith(1, 2, 3, null).removeIfWith((each, ignored) -> each == null, null));
    }

    @Override
    @Test
    public void indexOf() {
        super.indexOf();
        MutableList<Integer> objects = ArrayAdapter.newArrayWith(1, 2, 3);
        Assert.assertEquals(1, objects.indexOf(2));
    }

    @Override
    @Test
    public void lastIndexOf() {
        super.lastIndexOf();
        MutableList<Integer> objects = ArrayAdapter.newArrayWith(1, 2, 3);
        Assert.assertEquals(1, objects.lastIndexOf(2));
    }

    @Override
    @Test
    public void set() {
        super.set();
        MutableList<Integer> objects = ArrayAdapter.newArrayWith(1, 2, 3);
        Assert.assertEquals(Integer.valueOf(2), objects.set(1, 4));
        Assert.assertEquals(FastList.newListWith(1, 4, 3), objects);
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        ArrayAdapter<Integer> array1 = ArrayAdapter.newArrayWith(1, 2, 3, 4);
        ArrayAdapter<Integer> array2 = ArrayAdapter.newArrayWith(1, 2, 3, 4);
        ArrayAdapter<Integer> array3 = ArrayAdapter.newArrayWith(2, 3, 4);
        ArrayAdapter<Integer> array4 = ArrayAdapter.newArrayWith(1, 2, 3, 5);
        Assert.assertNotEquals(array1, null);
        Verify.assertEqualsAndHashCode(array1, array1);
        Verify.assertEqualsAndHashCode(array1, array2);
        Assert.assertNotEquals(array2, array3);
        Verify.assertEqualsAndHashCode(array1, new ArrayList<>(array1));
        Verify.assertEqualsAndHashCode(array1, new LinkedList<>(array1));
        Verify.assertEqualsAndHashCode(array1, ArrayListAdapter.<Integer>newList().with(1, 2, 3, 4));
        Verify.assertEqualsAndHashCode(array1, FastList.<Integer>newList().with(1, 2, 3, 4));
        Assert.assertNotEquals(array1, new LinkedList<>(array4));
    }

    @Override
    @Test
    public void forEachWith() {
        super.forEachWith();
        List<Integer> result = new ArrayList<>();
        MutableList<Integer> collection = ArrayAdapter.newArrayWith(1, 2, 3, 4);
        collection.forEachWith((argument1, argument2) -> result.add(argument1 + argument2), 0);
        Verify.assertSize(4, result);
        Verify.assertContainsAll(result, 1, 2, 3, 4);
    }

    @Override
    @Test
    public void selectWith() {
        super.selectWith();
        Verify.assertContainsAll(ArrayAdapter.newArrayWith(1, 2, 3, 4, 5).selectWith(Predicates2.lessThan(), 3), 1, 2);
        Verify.denyContainsAny(ArrayAdapter.newArrayWith(-1, 2, 3, 4, 5).selectWith(Predicates2.lessThan(), 3), 3, 4, 5);
        Verify.assertContainsAll(ArrayAdapter.newArrayWith(1, 2, 3, 4, 5).selectWith(Predicates2.lessThan(), 3, UnifiedSet.newSet()), 1, 2);
    }

    @Override
    @Test
    public void rejectWith() {
        super.rejectWith();
        Verify.assertContainsAll(ArrayAdapter.newArrayWith(1, 2, 3, 4).rejectWith(Predicates2.lessThan(), 3), 3, 4);
        Verify.assertContainsAll(ArrayAdapter.newArrayWith(1, 2, 3, 4).rejectWith(Predicates2.lessThan(), 3, UnifiedSet.newSet()), 3, 4);
    }

    @Override
    @Test
    public void detectWith() {
        Assert.assertEquals(Integer.valueOf(3), ArrayAdapter.newArrayWith(1, 2, 3, 4, 5).detectWith(Object::equals, 3));
        Assert.assertNull(ArrayAdapter.newArrayWith(1, 2, 3, 4, 5).detectWith(Object::equals, 6));
    }

    @Test
    public void detectWithIfNone() {
        MutableList<Integer> list = ArrayAdapter.newArrayWith(1, 2, 3, 4, 5);
        Assert.assertNull(list.detectWithIfNone(Object::equals, 6, new PassThruFunction0<>(null)));
        Assert.assertEquals(Integer.valueOf(10000), list.detectWithIfNone(Object::equals, 6, new PassThruFunction0<>(Integer.valueOf(10000))));
    }

    @Override
    @Test
    public void allSatisfyWith() {
        super.allSatisfyWith();
        Assert.assertTrue(ArrayAdapter.newArrayWith(1, 2, 3).allSatisfyWith(Predicates2.instanceOf(), Integer.class));
        Assert.assertFalse(ArrayAdapter.newArrayWith(1, 2, 3).allSatisfyWith(Object::equals, 1));
    }

    @Override
    @Test
    public void anySatisfyWith() {
        super.anySatisfyWith();
        Assert.assertFalse(ArrayAdapter.newArrayWith(1, 2, 3).anySatisfyWith(Predicates2.instanceOf(), String.class));
        Assert.assertTrue(ArrayAdapter.newArrayWith(1, 2, 3).anySatisfyWith(Predicates2.instanceOf(), Integer.class));
    }

    @Override
    @Test
    public void noneSatisfyWith() {
        super.noneSatisfyWith();
        Assert.assertTrue(ArrayAdapter.newArrayWith(1, 2, 3).noneSatisfyWith(Predicates2.instanceOf(), String.class));
        Assert.assertFalse(ArrayAdapter.newArrayWith(1, 2, 3).noneSatisfyWith(Object::equals, 1));
    }

    @Override
    @Test
    public void countWith() {
        super.countWith();
        Assert.assertEquals(3, ArrayAdapter.newArrayWith(1, 2, 3).countWith(Predicates2.instanceOf(), Integer.class));
    }

    @Override
    @Test
    public void collectWith() {
        super.collectWith();
        Function2<Integer, Integer, Integer> addBlock = (each, parameter) -> each + parameter;
        Assert.assertEquals(FastList.newListWith(2, 3, 4), ArrayAdapter.newArrayWith(1, 2, 3).collectWith(addBlock, 1));
        Assert.assertEquals(FastList.newListWith(2, 3, 4), ArrayAdapter.newArrayWith(1, 2, 3).collectWith(addBlock, 1, FastList.newList()));
    }

    @Override
    @Test
    public void injectIntoWith() {
        super.injectIntoWith();
        MutableList<Integer> objects = ArrayAdapter.newArrayWith(1, 2, 3);
        Integer result = objects.injectIntoWith(1, (injectedValued, item, parameter) -> injectedValued + item + parameter, 0);
        Assert.assertEquals(Integer.valueOf(7), result);
    }

    @Override
    @Test
    public void serialization() {
        super.serialization();
        MutableList<Integer> collection = ArrayAdapter.newArrayWith(1, 2, 3, 4, 5);
        MutableList<Integer> deserializedCollection = SerializeTestHelper.serializeDeserialize(collection);
        Verify.assertSize(5, deserializedCollection);
        Verify.assertStartsWith(deserializedCollection, 1, 2, 3, 4, 5);
        Verify.assertListsEqual(collection, deserializedCollection);
    }

    @Test
    public void testBAOSSize() {
        MutableList<Integer> mutableArrayList = ArrayAdapter.newArray();
        List<Integer> arrayList = new ArrayList<>();
        ByteArrayOutputStream stream2 = SerializeTestHelper.getByteArrayOutputStream(arrayList);
        LOGGER.info("ArrayList size: {}", stream2.size());
        LOGGER.info("{}", stream2);
        ByteArrayOutputStream stream1 = SerializeTestHelper.getByteArrayOutputStream(mutableArrayList);
        LOGGER.info("ArrayAdapter size: {}", stream1.size());
        LOGGER.info("{}", stream1);
    }

    @Override
    @Test
    public void testToString() {
        // ArrayAdapter doesn't support add and cannot contain itself
        Assert.assertEquals(FastList.newList(this.newWith(1, 2, 3, 4)).toString(), this.newWith(1, 2, 3, 4).toString());
    }

    @Override
    @Test
    public void makeString() {
        // ArrayAdapter doesn't support add and cannot contain itself
        Assert.assertEquals(FastList.newList(this.newWith(1, 2, 3, 4)).makeString(), this.newWith(1, 2, 3, 4).makeString());
    }

    @Override
    @Test
    public void appendString() {
        // ArrayAdapter doesn't support add and cannot contain itself
        StringBuilder stringBuilder = new StringBuilder();
        this.newWith(1, 2, 3, 4).appendString(stringBuilder);
        Assert.assertEquals(FastList.newList(this.newWith(1, 2, 3, 4)).makeString(), stringBuilder.toString());
    }

    @Override
    @Test
    public void asUnmodifiable() {
        super.asUnmodifiable();
        Verify.assertInstanceOf(UnmodifiableMutableList.class, this.newWith().asUnmodifiable());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void clear() {
        this.newArray().clear();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAtIndex() {
        this.newArray().add(0, null);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllAtIndex() {
        this.newArray().addAll(0, FastList.newList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAll() {
        this.newArray().addAll(FastList.newList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable() {
        this.newArray().addAllIterable(FastList.newList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeObject() {
        this.newArray().remove(null);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll() {
        this.newArray().removeAll(FastList.newList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAllIterable() {
        this.newArray().removeAllIterable(FastList.newList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll() {
        this.newArray().retainAll(FastList.newList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAllIterable() {
        this.newArray().retainAllIterable(FastList.newList());
    }

    @Override
    @Test
    public void forEachOnRange() {
        MutableList<Integer> list = this.newWith(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        this.validateForEachOnRange(list, 0, 0, FastList.newListWith(0));
        this.validateForEachOnRange(list, 3, 5, FastList.newListWith(3, 4, 5));
        this.validateForEachOnRange(list, 4, 6, FastList.newListWith(4, 5, 6));
        this.validateForEachOnRange(list, 9, 9, FastList.newListWith(9));
        this.validateForEachOnRange(list, 0, 9, FastList.newListWith(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> this.validateForEachOnRange(list, 10, 10, FastList.newList()));
    }

    @Override
    @Test
    public void forEachWithIndexOnRange() {
        MutableList<Integer> list = this.newWith(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        this.validateForEachWithIndexOnRange(list, 0, 0, FastList.newListWith(0));
        this.validateForEachWithIndexOnRange(list, 3, 5, FastList.newListWith(3, 4, 5));
        this.validateForEachWithIndexOnRange(list, 4, 6, FastList.newListWith(4, 5, 6));
        this.validateForEachWithIndexOnRange(list, 9, 9, FastList.newListWith(9));
        this.validateForEachWithIndexOnRange(list, 0, 9, FastList.newListWith(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> this.validateForEachWithIndexOnRange(list, 10, 10, FastList.newList()));
    }

    @Override
    @Test
    public void subList() {
        MutableList<String> list = this.newWith("A", "B", "C", "D");
        MutableList<String> sublist = list.subList(1, 3);
        Verify.assertSize(2, sublist);
        Verify.assertContainsAll(sublist, "B", "C");
    }

    @Override
    @Test
    public void with() {
        MutableCollection<Integer> coll = this.newWith(1, 2, 3);
        MutableCollection<Integer> collWith = coll.with(4);
        Assert.assertNotSame(coll, collWith);
        Assert.assertEquals(FastList.newListWith(1, 2, 3, 4), collWith);
    }

    @Override
    @Test
    public void withAll() {
        MutableCollection<Integer> coll = this.newWith(1, 2, 3);
        MutableCollection<Integer> collWith = coll.withAll(FastList.newListWith(4, 5));
        Assert.assertNotSame(coll, collWith);
        Assert.assertEquals(FastList.newListWith(1, 2, 3, 4, 5), collWith);
        Assert.assertSame(collWith, collWith.withAll(FastList.newList()));
    }

    @Override
    @Test
    public void without() {
        MutableCollection<Integer> coll = this.newWith(1, 2, 3, 2);
        MutableCollection<Integer> collWithout = coll.without(2);
        Assert.assertNotSame(coll, collWithout);
        Assert.assertEquals(FastList.newListWith(1, 3, 2), collWithout);
        Assert.assertSame(collWithout, collWithout.without(9));
    }

    @Override
    @Test
    public void withoutAll() {
        MutableCollection<Integer> coll = this.newWith(1, 2, 4, 2, 3, 4, 5);
        MutableCollection<Integer> collWithout = coll.withoutAll(FastList.newListWith(2, 4));
        Assert.assertNotSame(coll, collWithout);
        Assert.assertEquals(FastList.newListWith(1, 3, 5), collWithout);
        Assert.assertSame(collWithout, collWithout.withoutAll(FastList.newListWith(8, 9)));
        Assert.assertSame(collWithout, collWithout.withoutAll(FastList.newList()));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public ArrayAdapterTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_target);
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
        public void benchmark_collectTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_safe);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_safe);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minByOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxByOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy_null_throws);
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
        public void benchmark_detectWithIfNoneBlock() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNoneBlock);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAny() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAny);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_not_only_one_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_not_only_one_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding1);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding1);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumInteger);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeLong);
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
        public void benchmark_sumByFloatConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloatConsistentRounding);
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
        public void benchmark_sumByDoubleConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDoubleConsistentRounding);
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
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortSet_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSet_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy_with_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableMap);
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
        public void benchmark_toSortedMap_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMapBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBiMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBiMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_fusedCollectMakeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.fusedCollectMakeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringThrows);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach);
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
        public void benchmark_groupByUniqueKey_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws_for_duplicate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_for_duplicate);
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
        public void benchmark_chunk_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_single() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_single);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithVarArgs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithVarArgs);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_largeCollectionStreamToBagMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.largeCollectionStreamToBagMultimap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_randomAccess_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.randomAccess_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirstOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirstOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLastOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLastOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectLastIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectLastIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWithSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWithSize);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_corresponds() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.corresponds);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachFromToInReverse() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachFromToInReverse);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseForEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseForEach_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseForEach_emptyList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseForEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseForEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseForEachWithIndex_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseForEachWithIndex_emptyList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseThis() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseThis);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toReversed);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctWithHashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctWithHashingStrategy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMethods() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMethods);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis_with_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis_small() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis_small);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis_large() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis_large);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis_with_comparator_small() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis_with_comparator_small);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis_with_comparator_large() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis_with_comparator_large);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparatorAndStartAndEnd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparatorAndStartAndEnd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexWithFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexWithFromTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexWithFromToInReverse() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexWithFromToInReverse);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisWithNullWithNoComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisWithNullWithNoComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListWithNullWithNoComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListWithNullWithNoComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subListFromOutOfBoundsException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subListFromOutOfBoundsException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subListToGreaterThanSizeException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subListToGreaterThanSizeException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subListFromGreaterThanToException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subListFromGreaterThanToException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getWithIndexOutOfBoundsException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getWithIndexOutOfBoundsException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getWithArrayIndexOutOfBoundsException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getWithArrayIndexOutOfBoundsException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.listIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIteratorIndexTooSmall() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.listIteratorIndexTooSmall);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIteratorIndexTooBig() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.listIteratorIndexTooBig);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStack);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_takeWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.takeWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dropWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dropWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asReversed);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_binarySearch() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.binarySearch);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_binarySearchWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.binarySearchWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachInBoth() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachInBoth);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachInBothThrowsOnDifferentListSizes() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachInBothThrowsOnDifferentListSizes);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachInBothThrowsOnNullList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachInBothThrowsOnNullList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_replaceAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.replaceAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_adapt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.adapt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWithWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWithVarArgs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWithVarArgs);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachFromTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectAndRejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectAndRejectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIfWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIfWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lastIndexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lastIndexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_set() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.set);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testBAOSSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testBAOSSize);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
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
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachOnRange() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachOnRange);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexOnRange() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexOnRange);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> payload) throws java.lang.Throwable {
            this.instance = new ArrayAdapterTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> randomAccess_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> getFirstOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> getLastOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> detectLastIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> newListWithSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> forEachFromToInReverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> reverseForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> reverseForEach_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> reverseForEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> reverseForEachWithIndex_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> distinctWithHashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> distinctBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> withMethods;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sortThis_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sortThis_small;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sortThis_large;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sortThis_with_comparator_small;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sortThis_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sortThis_with_comparator_large;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sortThisBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sortThisByBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sortThisByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sortThisByChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sortThisByByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sortThisByShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sortThisByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sortThisByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sortThisByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> forEachWithIndexWithFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> forEachWithIndexWithFromToInReverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sortThisWithNullWithNoComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toSortedListWithNullWithNoComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> subListFromOutOfBoundsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> subListToGreaterThanSizeException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> subListFromGreaterThanToException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> getWithIndexOutOfBoundsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> getWithArrayIndexOutOfBoundsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> listIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> listIteratorIndexTooSmall;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> listIteratorIndexTooBig;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> asReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> binarySearch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> binarySearchWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> forEachInBoth;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> forEachInBothThrowsOnDifferentListSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> forEachInBothThrowsOnNullList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> replaceAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> sort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> testNewList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> adapt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> newListWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> newListWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> newListWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> newListWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> removeIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> testBAOSSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> forEachOnRange;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> forEachWithIndexOnRange;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterTest> withoutAll;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = ArrayAdapterTest::testNewCollection;
            this.payloads.contains = ArrayAdapterTest::contains;
            this.payloads.containsBy = ArrayAdapterTest::containsBy;
            this.payloads.containsAllIterable = ArrayAdapterTest::containsAllIterable;
            this.payloads.containsAnyIterable = ArrayAdapterTest::containsAnyIterable;
            this.payloads.containsNoneIterable = ArrayAdapterTest::containsNoneIterable;
            this.payloads.containsAllArray = ArrayAdapterTest::containsAllArray;
            this.payloads.containsAnyCollection = ArrayAdapterTest::containsAnyCollection;
            this.payloads.containsNoneCollection = ArrayAdapterTest::containsNoneCollection;
            this.payloads.containsAllCollection = ArrayAdapterTest::containsAllCollection;
            this.payloads.tap = ArrayAdapterTest::tap;
            this.payloads.select = ArrayAdapterTest::select;
            this.payloads.selectWith_target = ArrayAdapterTest::selectWith_target;
            this.payloads.reject = ArrayAdapterTest::reject;
            this.payloads.rejectWith_target = ArrayAdapterTest::rejectWith_target;
            this.payloads.selectInstancesOf = ArrayAdapterTest::selectInstancesOf;
            this.payloads.collect = ArrayAdapterTest::collect;
            this.payloads.collectTarget = ArrayAdapterTest::collectTarget;
            this.payloads.collectBoolean = ArrayAdapterTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = ArrayAdapterTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = ArrayAdapterTest::collectBooleanWithBagTarget;
            this.payloads.collectByte = ArrayAdapterTest::collectByte;
            this.payloads.collectByteWithTarget = ArrayAdapterTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = ArrayAdapterTest::collectByteWithBagTarget;
            this.payloads.collectChar = ArrayAdapterTest::collectChar;
            this.payloads.collectCharWithTarget = ArrayAdapterTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = ArrayAdapterTest::collectCharWithBagTarget;
            this.payloads.collectDouble = ArrayAdapterTest::collectDouble;
            this.payloads.collectDoubleWithTarget = ArrayAdapterTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = ArrayAdapterTest::collectDoubleWithBagTarget;
            this.payloads.collectFloat = ArrayAdapterTest::collectFloat;
            this.payloads.collectFloatWithTarget = ArrayAdapterTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = ArrayAdapterTest::collectFloatWithBagTarget;
            this.payloads.collectInt = ArrayAdapterTest::collectInt;
            this.payloads.collectIntWithTarget = ArrayAdapterTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = ArrayAdapterTest::collectIntWithBagTarget;
            this.payloads.collectLong = ArrayAdapterTest::collectLong;
            this.payloads.collectLongWithTarget = ArrayAdapterTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = ArrayAdapterTest::collectLongWithBagTarget;
            this.payloads.collectShort = ArrayAdapterTest::collectShort;
            this.payloads.collectShortWithTarget = ArrayAdapterTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = ArrayAdapterTest::collectShortWithBagTarget;
            this.payloads.flatCollect = ArrayAdapterTest::flatCollect;
            this.payloads.flatCollectWith = ArrayAdapterTest::flatCollectWith;
            this.payloads.flatCollectBoolean = ArrayAdapterTest::flatCollectBoolean;
            this.payloads.flatCollectByte = ArrayAdapterTest::flatCollectByte;
            this.payloads.flatCollectShort = ArrayAdapterTest::flatCollectShort;
            this.payloads.flatCollectInt = ArrayAdapterTest::flatCollectInt;
            this.payloads.flatCollectChar = ArrayAdapterTest::flatCollectChar;
            this.payloads.flatCollectLong = ArrayAdapterTest::flatCollectLong;
            this.payloads.flatCollectDouble = ArrayAdapterTest::flatCollectDouble;
            this.payloads.flatCollectFloat = ArrayAdapterTest::flatCollectFloat;
            this.payloads.detect = ArrayAdapterTest::detect;
            this.payloads.detectOptional = ArrayAdapterTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = ArrayAdapterTest::min;
            this.payloads.minOptional = ArrayAdapterTest::minOptional;
            this.payloads.max = ArrayAdapterTest::max;
            this.payloads.maxOptional = ArrayAdapterTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = ArrayAdapterTest::min_without_comparator;
            this.payloads.max_without_comparator = ArrayAdapterTest::max_without_comparator;
            this.payloads.min_null_safe = ArrayAdapterTest::min_null_safe;
            this.payloads.max_null_safe = ArrayAdapterTest::max_null_safe;
            this.payloads.minBy = ArrayAdapterTest::minBy;
            this.payloads.minByOptional = ArrayAdapterTest::minByOptional;
            this.payloads.maxBy = ArrayAdapterTest::maxBy;
            this.payloads.maxByOptional = ArrayAdapterTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWithOptional = ArrayAdapterTest::detectWithOptional;
            this.payloads.detectIfNone = ArrayAdapterTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = ArrayAdapterTest::detectWithIfNoneBlock;
            this.payloads.collectWith_target = ArrayAdapterTest::collectWith_target;
            this.payloads.getAny = ArrayAdapterTest::getAny;
            this.payloads.getOnly = ArrayAdapterTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectIntoInt = ArrayAdapterTest::injectIntoInt;
            this.payloads.injectIntoLong = ArrayAdapterTest::injectIntoLong;
            this.payloads.injectIntoDouble = ArrayAdapterTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ArrayAdapterTest::injectIntoFloat;
            this.payloads.sumFloat = ArrayAdapterTest::sumFloat;
            this.payloads.summarizeFloat = ArrayAdapterTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = ArrayAdapterTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = ArrayAdapterTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = ArrayAdapterTest::sumDouble;
            this.payloads.summarizeDouble = ArrayAdapterTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = ArrayAdapterTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = ArrayAdapterTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = ArrayAdapterTest::sumInteger;
            this.payloads.summarizeInt = ArrayAdapterTest::summarizeInt;
            this.payloads.sumLong = ArrayAdapterTest::sumLong;
            this.payloads.summarizeLong = ArrayAdapterTest::summarizeLong;
            this.payloads.sumByInt = ArrayAdapterTest::sumByInt;
            this.payloads.sumByFloat = ArrayAdapterTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = ArrayAdapterTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = ArrayAdapterTest::sumByLong;
            this.payloads.sumByDouble = ArrayAdapterTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = ArrayAdapterTest::sumByDoubleConsistentRounding;
            this.payloads.partition = ArrayAdapterTest::partition;
            this.payloads.partitionWith = ArrayAdapterTest::partitionWith;
            this.payloads.toList = ArrayAdapterTest::toList;
            this.payloads.toImmutableList = ArrayAdapterTest::toImmutableList;
            this.payloads.toCollection = ArrayAdapterTest::toCollection;
            this.payloads.toBag = ArrayAdapterTest::toBag;
            this.payloads.toImmutableBag = ArrayAdapterTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = ArrayAdapterTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = ArrayAdapterTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = ArrayAdapterTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = ArrayAdapterTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = ArrayAdapterTest::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = ArrayAdapterTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = ArrayAdapterTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = ArrayAdapterTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = ArrayAdapterTest::toSortedBagBy;
            this.payloads.toImmutableSortedBagBy = ArrayAdapterTest::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = ArrayAdapterTest::toSortedListBy;
            this.payloads.toImmutableSortedListBy = ArrayAdapterTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = ArrayAdapterTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = ArrayAdapterTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = ArrayAdapterTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = ArrayAdapterTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = ArrayAdapterTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = ArrayAdapterTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = ArrayAdapterTest::toSet;
            this.payloads.toImmutableSet = ArrayAdapterTest::toImmutableSet;
            this.payloads.toMap = ArrayAdapterTest::toMap;
            this.payloads.toImmutableMap = ArrayAdapterTest::toImmutableMap;
            this.payloads.toMapTarget = ArrayAdapterTest::toMapTarget;
            this.payloads.toSortedMap = ArrayAdapterTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = ArrayAdapterTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = ArrayAdapterTest::toSortedMapBy;
            this.payloads.toBiMap = ArrayAdapterTest::toBiMap;
            this.payloads.toImmutableBiMap = ArrayAdapterTest::toImmutableBiMap;
            this.payloads.fusedCollectMakeString = ArrayAdapterTest::fusedCollectMakeString;
            this.payloads.appendStringThrows = ArrayAdapterTest::appendStringThrows;
            this.payloads.countBy = ArrayAdapterTest::countBy;
            this.payloads.countByWith = ArrayAdapterTest::countByWith;
            this.payloads.countByEach = ArrayAdapterTest::countByEach;
            this.payloads.groupBy = ArrayAdapterTest::groupBy;
            this.payloads.groupByEach = ArrayAdapterTest::groupByEach;
            this.payloads.groupByUniqueKey = ArrayAdapterTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ArrayAdapterTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = ArrayAdapterTest::zip;
            this.payloads.zipWithIndex = ArrayAdapterTest::zipWithIndex;
            this.payloads.chunk_empty = ArrayAdapterTest::chunk_empty;
            this.payloads.chunk_single = ArrayAdapterTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = ArrayAdapterTest::chunk_large_size;
            this.payloads.empty = ArrayAdapterTest::empty;
            this.payloads.notEmpty = ArrayAdapterTest::notEmpty;
            this.payloads.aggregateByMutating = ArrayAdapterTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ArrayAdapterTest::aggregateByNonMutating;
            this.payloads.reduceOptional = ArrayAdapterTest::reduceOptional;
            this.payloads.testNewWith = ArrayAdapterTest::testNewWith;
            this.payloads.testNewWithWith = ArrayAdapterTest::testNewWithWith;
            this.payloads.testNewWithWithWith = ArrayAdapterTest::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = ArrayAdapterTest::testNewWithVarArgs;
            this.payloads.largeCollectionStreamToBagMultimap = ArrayAdapterTest::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = ArrayAdapterTest::asLazy;
            this.payloads.randomAccess_throws = ArrayAdapterTest::randomAccess_throws;
            this.payloads.getFirstOptional = ArrayAdapterTest::getFirstOptional;
            this.payloads.getLastOptional = ArrayAdapterTest::getLastOptional;
            this.payloads.detectIndex = ArrayAdapterTest::detectIndex;
            this.payloads.detectLastIndex = ArrayAdapterTest::detectLastIndex;
            this.payloads.collectWithIndex = ArrayAdapterTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ArrayAdapterTest::collectWithIndexWithTarget;
            this.payloads.selectWithIndex = ArrayAdapterTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = ArrayAdapterTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = ArrayAdapterTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = ArrayAdapterTest::rejectWithIndexWithTarget;
            this.payloads.asSynchronized = ArrayAdapterTest::asSynchronized;
            this.payloads.toImmutable = ArrayAdapterTest::toImmutable;
            this.payloads.testClone = ArrayAdapterTest::testClone;
            this.payloads.newListWithSize = ArrayAdapterTest::newListWithSize;
            this.payloads.corresponds = ArrayAdapterTest::corresponds;
            this.payloads.forEachFromToInReverse = ArrayAdapterTest::forEachFromToInReverse;
            this.payloads.reverseForEach = ArrayAdapterTest::reverseForEach;
            this.payloads.reverseForEach_emptyList = ArrayAdapterTest::reverseForEach_emptyList;
            this.payloads.reverseForEachWithIndex = ArrayAdapterTest::reverseForEachWithIndex;
            this.payloads.reverseForEachWithIndex_emptyList = ArrayAdapterTest::reverseForEachWithIndex_emptyList;
            this.payloads.reverseThis = ArrayAdapterTest::reverseThis;
            this.payloads.toReversed = ArrayAdapterTest::toReversed;
            this.payloads.distinct = ArrayAdapterTest::distinct;
            this.payloads.distinctWithHashingStrategy = ArrayAdapterTest::distinctWithHashingStrategy;
            this.payloads.distinctBy = ArrayAdapterTest::distinctBy;
            this.payloads.withMethods = ArrayAdapterTest::withMethods;
            this.payloads.sortThis_with_null = ArrayAdapterTest::sortThis_with_null;
            this.payloads.sortThis_small = ArrayAdapterTest::sortThis_small;
            this.payloads.sortThis = ArrayAdapterTest::sortThis;
            this.payloads.sortThis_large = ArrayAdapterTest::sortThis_large;
            this.payloads.sortThis_with_comparator_small = ArrayAdapterTest::sortThis_with_comparator_small;
            this.payloads.sortThis_with_comparator = ArrayAdapterTest::sortThis_with_comparator;
            this.payloads.sortThis_with_comparator_large = ArrayAdapterTest::sortThis_with_comparator_large;
            this.payloads.sortThisBy = ArrayAdapterTest::sortThisBy;
            this.payloads.sortThisByBoolean = ArrayAdapterTest::sortThisByBoolean;
            this.payloads.sortThisByInt = ArrayAdapterTest::sortThisByInt;
            this.payloads.sortThisByChar = ArrayAdapterTest::sortThisByChar;
            this.payloads.sortThisByByte = ArrayAdapterTest::sortThisByByte;
            this.payloads.sortThisByShort = ArrayAdapterTest::sortThisByShort;
            this.payloads.sortThisByFloat = ArrayAdapterTest::sortThisByFloat;
            this.payloads.sortThisByLong = ArrayAdapterTest::sortThisByLong;
            this.payloads.sortThisByDouble = ArrayAdapterTest::sortThisByDouble;
            this.payloads.newEmpty = ArrayAdapterTest::newEmpty;
            this.payloads.makeStringWithSeparator = ArrayAdapterTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = ArrayAdapterTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringWithSeparator = ArrayAdapterTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = ArrayAdapterTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.forEachWithIndexWithFromTo = ArrayAdapterTest::forEachWithIndexWithFromTo;
            this.payloads.forEachWithIndexWithFromToInReverse = ArrayAdapterTest::forEachWithIndexWithFromToInReverse;
            this.payloads.sortThisWithNullWithNoComparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::sortThisWithNullWithNoComparator, java.lang.NullPointerException.class);
            this.payloads.sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements, java.lang.NullPointerException.class);
            this.payloads.toSortedListWithNullWithNoComparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::toSortedListWithNullWithNoComparator, java.lang.NullPointerException.class);
            this.payloads.toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements, java.lang.NullPointerException.class);
            this.payloads.subListFromOutOfBoundsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::subListFromOutOfBoundsException, java.lang.IndexOutOfBoundsException.class);
            this.payloads.subListToGreaterThanSizeException = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::subListToGreaterThanSizeException, java.lang.IndexOutOfBoundsException.class);
            this.payloads.subListFromGreaterThanToException = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::subListFromGreaterThanToException, java.lang.IllegalArgumentException.class);
            this.payloads.getWithIndexOutOfBoundsException = ArrayAdapterTest::getWithIndexOutOfBoundsException;
            this.payloads.getWithArrayIndexOutOfBoundsException = ArrayAdapterTest::getWithArrayIndexOutOfBoundsException;
            this.payloads.listIterator = ArrayAdapterTest::listIterator;
            this.payloads.listIteratorIndexTooSmall = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::listIteratorIndexTooSmall, java.lang.IndexOutOfBoundsException.class);
            this.payloads.listIteratorIndexTooBig = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::listIteratorIndexTooBig, java.lang.IndexOutOfBoundsException.class);
            this.payloads.chunk = ArrayAdapterTest::chunk;
            this.payloads.toStack = ArrayAdapterTest::toStack;
            this.payloads.take = ArrayAdapterTest::take;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = ArrayAdapterTest::takeWhile;
            this.payloads.drop = ArrayAdapterTest::drop;
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::drop_throws, java.lang.IllegalArgumentException.class);
            this.payloads.dropWhile = ArrayAdapterTest::dropWhile;
            this.payloads.partitionWhile = ArrayAdapterTest::partitionWhile;
            this.payloads.asReversed = ArrayAdapterTest::asReversed;
            this.payloads.binarySearch = ArrayAdapterTest::binarySearch;
            this.payloads.binarySearchWithComparator = ArrayAdapterTest::binarySearchWithComparator;
            this.payloads.forEachInBoth = ArrayAdapterTest::forEachInBoth;
            this.payloads.forEachInBothThrowsOnDifferentListSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::forEachInBothThrowsOnDifferentListSizes, java.lang.IllegalArgumentException.class);
            this.payloads.forEachInBothThrowsOnNullList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::forEachInBothThrowsOnNullList, java.lang.NullPointerException.class);
            this.payloads.replaceAll = ArrayAdapterTest::replaceAll;
            this.payloads.sort = ArrayAdapterTest::sort;
            this.payloads.testNewList = ArrayAdapterTest::testNewList;
            this.payloads.adapt = ArrayAdapterTest::adapt;
            this.payloads.newListWith = ArrayAdapterTest::newListWith;
            this.payloads.newListWithWith = ArrayAdapterTest::newListWithWith;
            this.payloads.newListWithWithWith = ArrayAdapterTest::newListWithWithWith;
            this.payloads.newListWithVarArgs = ArrayAdapterTest::newListWithVarArgs;
            this.payloads.forEach = ArrayAdapterTest::forEach;
            this.payloads.forEachFromTo = ArrayAdapterTest::forEachFromTo;
            this.payloads.forEachWithIndex = ArrayAdapterTest::forEachWithIndex;
            this.payloads.add = ArrayAdapterTest::add;
            this.payloads.allSatisfy = ArrayAdapterTest::allSatisfy;
            this.payloads.anySatisfy = ArrayAdapterTest::anySatisfy;
            this.payloads.noneSatisfy = ArrayAdapterTest::noneSatisfy;
            this.payloads.count = ArrayAdapterTest::count;
            this.payloads.collectIf = ArrayAdapterTest::collectIf;
            this.payloads.getFirst = ArrayAdapterTest::getFirst;
            this.payloads.getLast = ArrayAdapterTest::getLast;
            this.payloads.isEmpty = ArrayAdapterTest::isEmpty;
            this.payloads.iterator = ArrayAdapterTest::iterator;
            this.payloads.injectInto = ArrayAdapterTest::injectInto;
            this.payloads.toArray = ArrayAdapterTest::toArray;
            this.payloads.selectAndRejectWith = ArrayAdapterTest::selectAndRejectWith;
            this.payloads.removeIf = ArrayAdapterTest::removeIf;
            this.payloads.removeIndex = ArrayAdapterTest::removeIndex;
            this.payloads.removeIfWith = ArrayAdapterTest::removeIfWith;
            this.payloads.indexOf = ArrayAdapterTest::indexOf;
            this.payloads.lastIndexOf = ArrayAdapterTest::lastIndexOf;
            this.payloads.set = ArrayAdapterTest::set;
            this.payloads.equalsAndHashCode = ArrayAdapterTest::equalsAndHashCode;
            this.payloads.forEachWith = ArrayAdapterTest::forEachWith;
            this.payloads.selectWith = ArrayAdapterTest::selectWith;
            this.payloads.rejectWith = ArrayAdapterTest::rejectWith;
            this.payloads.detectWith = ArrayAdapterTest::detectWith;
            this.payloads.detectWithIfNone = ArrayAdapterTest::detectWithIfNone;
            this.payloads.allSatisfyWith = ArrayAdapterTest::allSatisfyWith;
            this.payloads.anySatisfyWith = ArrayAdapterTest::anySatisfyWith;
            this.payloads.noneSatisfyWith = ArrayAdapterTest::noneSatisfyWith;
            this.payloads.countWith = ArrayAdapterTest::countWith;
            this.payloads.collectWith = ArrayAdapterTest::collectWith;
            this.payloads.injectIntoWith = ArrayAdapterTest::injectIntoWith;
            this.payloads.serialization = ArrayAdapterTest::serialization;
            this.payloads.testBAOSSize = ArrayAdapterTest::testBAOSSize;
            this.payloads.testToString = ArrayAdapterTest::testToString;
            this.payloads.makeString = ArrayAdapterTest::makeString;
            this.payloads.appendString = ArrayAdapterTest::appendString;
            this.payloads.asUnmodifiable = ArrayAdapterTest::asUnmodifiable;
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.addAtIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::addAtIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllAtIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::addAllAtIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.removeObject = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::removeObject, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::removeAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterTest::retainAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.forEachOnRange = ArrayAdapterTest::forEachOnRange;
            this.payloads.forEachWithIndexOnRange = ArrayAdapterTest::forEachWithIndexOnRange;
            this.payloads.subList = ArrayAdapterTest::subList;
            this.payloads.with = ArrayAdapterTest::with;
            this.payloads.withAll = ArrayAdapterTest::withAll;
            this.payloads.without = ArrayAdapterTest::without;
            this.payloads.withoutAll = ArrayAdapterTest::withoutAll;
        }
    }
}
