/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.mutable;

import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.predicate.Predicate2;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.Twin;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.block.function.MaxSizeFunction;
import org.eclipse.collections.impl.block.function.MinSizeFunction;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.fixed.ArrayAdapter;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.eclipse.collections.impl.utility.ListIterate;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iList;

/**
 * JUnit test for {@link MultiReaderFastList}.
 */
public class MultiReaderFastListTest extends AbstractListTestCase {

    @Override
    protected <T> MultiReaderFastList<T> newWith(T... littleElements) {
        return MultiReaderFastList.newListWith(littleElements);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void largeCollectionStreamToBagMultimap() {
        super.largeCollectionStreamToBagMultimap();
    }

    @Override
    @Test
    public void newEmpty() {
        Verify.assertInstanceOf(MultiReaderFastList.class, MultiReaderFastList.newList().newEmpty());
        Verify.assertEmpty(MultiReaderFastList.<Integer>newListWith(null, null).newEmpty());
    }

    @Test
    public void fastListNewWith() {
        Assert.assertEquals(FastList.newListWith("Alice", "Bob", "Cooper", "Dio"), MultiReaderFastList.newListWith("Alice", "Bob", "Cooper", "Dio"));
    }

    @Override
    @Test
    public void forEach() {
        MutableList<Integer> result = FastList.newList();
        MutableList<Integer> collection = MultiReaderFastList.newListWith(1, 2, 3, 4);
        collection.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(FastList.newListWith(1, 2, 3, 4), result);
    }

    @Override
    @Test
    public void injectInto() {
        MutableList<Integer> list = MultiReaderFastList.newListWith(1, 2, 3);
        Assert.assertEquals(Integer.valueOf(7), list.injectInto(1, AddFunction.INTEGER));
    }

    @Test
    public void injectIntoDouble2() {
        MutableList<Double> list = MultiReaderFastList.newListWith(1.0, 2.0, 3.0);
        Assert.assertEquals(7.0d, list.injectInto(1.0, AddFunction.DOUBLE_TO_DOUBLE), 0.001);
    }

    @Test
    public void injectIntoString() {
        MutableList<String> list = MultiReaderFastList.newListWith("1", "2", "3");
        Assert.assertEquals("0123", list.injectInto("0", AddFunction.STRING));
    }

    @Test
    public void injectIntoMaxString() {
        MutableList<String> list = MultiReaderFastList.newListWith("1", "12", "123");
        Function2<Integer, String, Integer> function = MaxSizeFunction.STRING;
        Assert.assertEquals(Integer.valueOf(3), list.injectInto(Integer.MIN_VALUE, function));
    }

    @Test
    public void injectIntoMinString() {
        MutableList<String> list = MultiReaderFastList.newListWith("1", "12", "123");
        Function2<Integer, String, Integer> function = MinSizeFunction.STRING;
        Assert.assertEquals(Integer.valueOf(1), list.injectInto(Integer.MAX_VALUE, function));
    }

    @Override
    @Test
    public void collect() {
        MutableList<Boolean> list = MultiReaderFastList.newListWith(Boolean.TRUE, Boolean.FALSE, null);
        MutableList<String> newCollection = list.collect(String::valueOf);
        Assert.assertEquals(FastList.newListWith("true", "false", "null"), newCollection);
    }

    private MutableList<Integer> getIntegerList() {
        return MultiReaderFastList.newList(Interval.toReverseList(1, 5));
    }

    @Override
    @Test
    public void forEachWithIndex() {
        super.forEachWithIndex();
        MutableList<Integer> list = MultiReaderFastList.newList(Interval.oneTo(5));
        list.forEachWithIndex((object, index) -> Assert.assertEquals(index, object - 1));
    }

    @Test
    public void forEachInBothUsingListIterate() {
        MutableList<Pair<String, String>> list = MultiReaderFastList.newList();
        MutableList<String> list1 = MultiReaderFastList.newListWith("1", "2");
        MutableList<String> list2 = MultiReaderFastList.newListWith("a", "b");
        ListIterate.forEachInBoth(list1, list2, (argument1, argument2) -> list.add(Tuples.pair(argument1, argument2)));
        Assert.assertEquals(FastList.newListWith(Tuples.pair("1", "a"), Tuples.pair("2", "b")), list);
    }

    @Override
    @Test
    public void forEachInBoth() {
        MutableList<Pair<String, String>> list = MultiReaderFastList.newList();
        MutableList<String> list1 = Lists.multiReader.with("1", "2");
        MutableList<String> list2 = Lists.multiReader.with("a", "b");
        list1.forEachInBoth(list2, (argument1, argument2) -> list.add(Tuples.pair(argument1, argument2)));
        Assert.assertEquals(Lists.mutable.with(Tuples.pair("1", "a"), Tuples.pair("2", "b")), list);
    }

    @Override
    @Test
    public void detect() {
        MutableList<Integer> list = this.getIntegerList();
        Assert.assertEquals(Integer.valueOf(1), list.detect(Integer.valueOf(1)::equals));
        MutableList<Integer> list2 = MultiReaderFastList.newListWith(1, 2, 2);
        Assert.assertSame(list2.get(1), list2.detect(Integer.valueOf(2)::equals));
    }

    @Override
    @Test
    public void detectWith() {
        MutableList<Integer> list = this.getIntegerList();
        Assert.assertEquals(Integer.valueOf(1), list.detectWith(Object::equals, 1));
        MutableList<Integer> list2 = MultiReaderFastList.newListWith(1, 2, 2);
        Assert.assertSame(list2.get(1), list2.detectWith(Object::equals, 2));
    }

    @Test
    public void detectWithIfNone() {
        MutableList<Integer> list = this.getIntegerList();
        Assert.assertNull(list.detectWithIfNone(Object::equals, 6, new PassThruFunction0<>(null)));
        Assert.assertEquals(Integer.valueOf(1), list.detectWithIfNone(Object::equals, Integer.valueOf(1), new PassThruFunction0<>(Integer.valueOf(10000))));
    }

    @Override
    @Test
    public void select() {
        MutableList<Integer> list = this.getIntegerList();
        MutableList<Integer> results = list.select(Integer.class::isInstance);
        Verify.assertSize(5, results);
    }

    @Override
    @Test
    public void selectWith() {
        MutableList<Integer> list = this.getIntegerList();
        MutableList<Integer> results = list.selectWith(Predicates2.instanceOf(), Integer.class);
        Verify.assertSize(5, results);
    }

    @Override
    @Test
    public void rejectWith() {
        MutableList<Integer> list = this.getIntegerList();
        MutableList<Integer> results = list.rejectWith(Predicates2.instanceOf(), Integer.class);
        Verify.assertEmpty(results);
    }

    @Override
    @Test
    public void selectAndRejectWith() {
        MutableList<Integer> list = this.getIntegerList();
        Twin<MutableList<Integer>> result = list.selectAndRejectWith(Predicates2.in(), Lists.fixedSize.of(1));
        Verify.assertSize(1, result.getOne());
        Verify.assertSize(4, result.getTwo());
    }

    @Override
    @Test
    public void anySatisfyWith() {
        MutableList<Integer> list = this.getIntegerList();
        Assert.assertTrue(list.anySatisfyWith(Predicates2.instanceOf(), Integer.class));
        Assert.assertFalse(list.anySatisfyWith(Predicates2.instanceOf(), Double.class));
    }

    @Override
    @Test
    public void anySatisfy() {
        MutableList<Integer> list = this.getIntegerList();
        Assert.assertTrue(Predicates.<Integer>anySatisfy(Integer.class::isInstance).accept(list));
        Assert.assertFalse(Predicates.<Integer>anySatisfy(Double.class::isInstance).accept(list));
    }

    @Override
    @Test
    public void allSatisfyWith() {
        MutableList<Integer> list = this.getIntegerList();
        Assert.assertTrue(list.allSatisfyWith(Predicates2.instanceOf(), Integer.class));
        Predicate2<Integer, Integer> greaterThanPredicate = Predicates2.greaterThan();
        Assert.assertFalse(list.allSatisfyWith(greaterThanPredicate, 2));
    }

    @Override
    @Test
    public void allSatisfy() {
        MutableList<Integer> list = this.getIntegerList();
        Assert.assertTrue(Predicates.<Integer>allSatisfy(Integer.class::isInstance).accept(list));
        Assert.assertFalse(Predicates.allSatisfy(Predicates.greaterThan(2)).accept(list));
    }

    @Override
    @Test
    public void noneSatisfy() {
        MutableList<Integer> list = this.getIntegerList();
        Assert.assertTrue(Predicates.<Integer>noneSatisfy(String.class::isInstance).accept(list));
        Assert.assertFalse(Predicates.noneSatisfy(Predicates.greaterThan(0)).accept(list));
    }

    @Override
    @Test
    public void noneSatisfyWith() {
        MutableList<Integer> list = this.getIntegerList();
        Assert.assertTrue(list.noneSatisfyWith(Predicates2.instanceOf(), String.class));
        Predicate2<Integer, Integer> greaterThanPredicate = Predicates2.greaterThan();
        Assert.assertFalse(list.noneSatisfyWith(greaterThanPredicate, 0));
    }

    @Override
    @Test
    public void count() {
        MutableList<Integer> list = this.getIntegerList();
        Assert.assertEquals(5, list.count(Integer.class::isInstance));
        Assert.assertEquals(0, list.count(Double.class::isInstance));
    }

    @Override
    @Test
    public void countWith() {
        MutableList<Integer> list = this.getIntegerList();
        Assert.assertEquals(5, list.countWith(Predicates2.instanceOf(), Integer.class));
        Assert.assertEquals(0, list.countWith(Predicates2.instanceOf(), Double.class));
    }

    @Override
    @Test
    public void detectIfNone() {
        Function0<Integer> defaultResultFunction = new PassThruFunction0<>(6);
        Assert.assertEquals(Integer.valueOf(3), MultiReaderFastList.newListWith(1, 2, 3, 4, 5).detectIfNone(Integer.valueOf(3)::equals, defaultResultFunction));
        Assert.assertEquals(Integer.valueOf(6), MultiReaderFastList.newListWith(1, 2, 3, 4, 5).detectIfNone(Integer.valueOf(6)::equals, defaultResultFunction));
    }

    @Override
    @Test
    public void forEachWith() {
        MutableList<Integer> result = FastList.newList();
        MutableList<Integer> collection = MultiReaderFastList.newListWith(1, 2, 3, 4);
        collection.forEachWith((argument1, argument2) -> result.add(argument1 + argument2), 0);
        Assert.assertEquals(FastList.newListWith(1, 2, 3, 4), result);
    }

    @Override
    @Test
    public void getFirst() {
        Assert.assertNull(MultiReaderFastList.newList().getFirst());
        Assert.assertEquals(Integer.valueOf(1), MultiReaderFastList.newListWith(1, 2, 3).getFirst());
    }

    @Override
    @Test
    public void getLast() {
        Assert.assertNull(MultiReaderFastList.newList().getLast());
        Assert.assertNotEquals(Integer.valueOf(1), MultiReaderFastList.newListWith(1, 2, 3).getLast());
        Assert.assertEquals(Integer.valueOf(3), MultiReaderFastList.newListWith(1, 2, 3).getLast());
    }

    @Override
    @Test
    public void isEmpty() {
        Verify.assertEmpty(MultiReaderFastList.newList());
        Verify.assertNotEmpty(MultiReaderFastList.newListWith(1, 2));
        Assert.assertTrue(MultiReaderFastList.newListWith(1, 2).notEmpty());
    }

    @Override
    @Test
    public void collectIf() {
        Assert.assertEquals(FastList.newListWith("1", "2", "3"), MultiReaderFastList.newListWith(1, 2, 3).collectIf(Integer.class::isInstance, String::valueOf));
        Assert.assertEquals(FastList.newListWith("1", "2", "3"), MultiReaderFastList.newListWith(1, 2, 3).collectIf(Integer.class::isInstance, String::valueOf, FastList.newList()));
    }

    @Override
    @Test
    public void collectWith() {
        Function2<Integer, Integer, Integer> addZeroFunction = (each, parameter) -> each + parameter;
        Verify.assertContainsAll(MultiReaderFastList.newListWith(1, 2, 3).collectWith(addZeroFunction, 0), 1, 2, 3);
        Verify.assertContainsAll(MultiReaderFastList.newListWith(1, 2, 3).collectWith(addZeroFunction, 0, FastList.newList()), 1, 2, 3);
    }

    @Override
    @Test
    public void injectIntoWith() {
        MutableList<Integer> objects = MultiReaderFastList.newListWith(1, 2, 3);
        Integer result = objects.injectIntoWith(1, (injectedValued, item, parameter) -> injectedValued + item + parameter, 0);
        Assert.assertEquals(Integer.valueOf(7), result);
    }

    @Test
    public void removeUsingPredicate() {
        MutableList<Integer> objects = MultiReaderFastList.newListWith(1, 2, 3, null);
        Assert.assertTrue(objects.removeIf(Predicates.isNull()));
        Verify.assertSize(3, objects);
        Verify.assertContainsAll(objects, 1, 2, 3);
    }

    @Override
    @Test
    public void removeIf() {
        MutableList<Integer> objects = MultiReaderFastList.newListWith(1, 2, 3, null);
        Assert.assertTrue(objects.removeIf(Predicates.cast(Objects::isNull)));
        Verify.assertSize(3, objects);
        Verify.assertContainsAll(objects, 1, 2, 3);
    }

    @Override
    @Test
    public void removeIfWith() {
        MutableList<Integer> objects = MultiReaderFastList.newListWith(1, 2, 3, null);
        Assert.assertTrue(objects.removeIfWith((each, ignored) -> each == null, null));
        Verify.assertSize(3, objects);
        Verify.assertContainsAll(objects, 1, 2, 3);
    }

    @Override
    @Test
    public void removeAllIterable() {
        super.removeAllIterable();
        MutableList<Integer> objects = MultiReaderFastList.newListWith(1, 2, 3);
        objects.removeAllIterable(Lists.fixedSize.of(1, 2));
        Verify.assertSize(1, objects);
        Verify.assertContains(3, objects);
        MutableList<Integer> objects2 = MultiReaderFastList.newListWith(1, 2, 3);
        objects2.removeAllIterable(Lists.fixedSize.of(1));
        Verify.assertSize(2, objects2);
        Verify.assertContainsAll(objects2, 2, 3);
        MutableList<Integer> objects3 = MultiReaderFastList.newListWith(1, 2, 3);
        objects3.removeAllIterable(Lists.fixedSize.of(3));
        Verify.assertSize(2, objects3);
        Verify.assertContainsAll(objects3, 1, 2);
        MutableList<Integer> objects4 = MultiReaderFastList.newListWith(1, 2, 3);
        objects4.removeAllIterable(Lists.fixedSize.of());
        Verify.assertSize(3, objects4);
        Verify.assertContainsAll(objects4, 1, 2, 3);
        MutableList<Integer> objects5 = MultiReaderFastList.newListWith(1, 2, 3);
        objects5.removeAllIterable(Lists.fixedSize.of(1, 2, 3));
        Verify.assertEmpty(objects5);
        MutableList<Integer> objects6 = MultiReaderFastList.newListWith(1, 2, 3);
        objects6.removeAllIterable(Lists.fixedSize.of(2));
        Verify.assertSize(2, objects6);
        Verify.assertContainsAll(objects6, 1, 3);
    }

    @SuppressWarnings("StringOperationCanBeSimplified")
    @Test
    public void removeAllWithWeakReference() {
        // Deliberate String copy for unit test purpose
        String fred = new String("Fred");
        // Deliberate String copy for unit test purpose
        String wilma = new String("Wilma");
        MutableList<String> objects = MultiReaderFastList.newListWith(fred, wilma);
        objects.removeAll(Lists.fixedSize.of("Fred"));
        objects.remove(0);
        Verify.assertEmpty(objects);
        WeakReference<String> ref = new WeakReference<>(wilma);
        // noinspection ReuseOfLocalVariable
        // Deliberate null of a local variable for unit test purpose
        fred = null;
        // noinspection ReuseOfLocalVariable
        // Deliberate null of a local variable for unit test purpose
        wilma = null;
        System.gc();
        Thread.yield();
        System.gc();
        Thread.yield();
        Assert.assertNull(ref.get());
    }

    @Override
    @Test
    public void retainAll() {
        super.retainAll();
        MutableList<Integer> objects = this.newWith(1, 2, 3);
        objects.retainAll(Lists.fixedSize.of(1, 2));
        Verify.assertSize(2, objects);
        Verify.assertContainsAll(objects, 1, 2);
        MutableList<Integer> objects2 = this.newWith(1, 2, 3);
        objects2.retainAll(Lists.fixedSize.of(1));
        Verify.assertSize(1, objects2);
        Verify.assertContainsAll(objects2, 1);
        MutableList<Integer> objects3 = this.newWith(1, 2, 3);
        objects3.retainAll(Lists.fixedSize.of(3));
        Verify.assertSize(1, objects3);
        Verify.assertContainsAll(objects3, 3);
        MutableList<Integer> objects4 = this.newWith(1, 2, 3);
        objects4.retainAll(Lists.fixedSize.of(2));
        Verify.assertSize(1, objects4);
        Verify.assertContainsAll(objects4, 2);
        MutableList<Integer> objects5 = this.newWith(1, 2, 3);
        objects5.retainAll(Lists.fixedSize.of());
        Verify.assertEmpty(objects5);
        MutableList<Integer> objects6 = this.newWith(1, 2, 3);
        objects6.retainAll(Lists.fixedSize.of(1, 2, 3));
        Verify.assertSize(3, objects6);
        Verify.assertContainsAll(objects6, 1, 2, 3);
    }

    @Override
    @Test
    public void retainAllIterable() {
        super.retainAllIterable();
        MutableList<Integer> objects = this.newWith(1, 2, 3);
        objects.retainAllIterable(Lists.fixedSize.of(1, 2));
        Verify.assertSize(2, objects);
        Verify.assertContainsAll(objects, 1, 2);
        MutableList<Integer> objects2 = this.newWith(1, 2, 3);
        objects2.retainAllIterable(Lists.fixedSize.of(1));
        Verify.assertSize(1, objects2);
        Verify.assertContainsAll(objects2, 1);
        MutableList<Integer> objects3 = this.newWith(1, 2, 3);
        objects3.retainAllIterable(Lists.fixedSize.of(3));
        Verify.assertSize(1, objects3);
        Verify.assertContainsAll(objects3, 3);
        MutableList<Integer> objects4 = this.newWith(1, 2, 3);
        objects4.retainAllIterable(Lists.fixedSize.of(2));
        Verify.assertSize(1, objects4);
        Verify.assertContainsAll(objects4, 2);
        MutableList<Integer> objects5 = this.newWith(1, 2, 3);
        objects5.retainAllIterable(Lists.fixedSize.of());
        Verify.assertEmpty(objects5);
        MutableList<Integer> objects6 = this.newWith(1, 2, 3);
        objects6.retainAllIterable(Lists.fixedSize.of(1, 2, 3));
        Verify.assertSize(3, objects6);
        Verify.assertContainsAll(objects6, 1, 2, 3);
    }

    @Override
    @Test
    public void reject() {
        Verify.assertContainsAll(this.newWith(1, 2, 3, 4).reject(Predicates.lessThan(3)), 3, 4);
        Verify.assertContainsAll(this.newWith(1, 2, 3, 4).reject(Predicates.lessThan(3), UnifiedSet.newSet()), 3, 4);
    }

    @Override
    @Test
    public void serialization() {
        MutableList<Integer> collection = this.newWith(1, 2, 3, 4, 5);
        MutableList<Integer> deserializedCollection = SerializeTestHelper.serializeDeserialize(collection);
        Verify.assertSize(5, deserializedCollection);
        Verify.assertStartsWith(deserializedCollection, 1, 2, 3, 4, 5);
        Assert.assertEquals(collection, deserializedCollection);
    }

    @Test
    public void serializationOfEmpty() {
        MutableList<Integer> collection = MultiReaderFastList.newList();
        Verify.assertPostSerializedEqualsAndHashCode(collection);
    }

    @Test
    public void serializationOfSublist() {
        MutableList<Integer> collection = this.newWith(1, 2, 3, 4, 5);
        MutableList<Integer> deserializedCollection = SerializeTestHelper.serializeDeserialize(collection.subList(0, 2));
        Verify.assertSize(2, deserializedCollection);
        Verify.assertStartsWith(deserializedCollection, 1, 2);
        Assert.assertEquals(collection.subList(0, 2), deserializedCollection);
    }

    @Override
    @Test
    public void addAll() {
        super.addAll();
        MutableList<Integer> integers = MultiReaderFastList.newList();
        Assert.assertTrue(integers.addAll(Lists.fixedSize.of(1, 2, 3, 4)));
        Verify.assertContainsAll(integers, 1, 2, 3, 4);
        Assert.assertTrue(integers.addAll(FastList.<Integer>newList(4).with(1, 2, 3, 4)));
        Verify.assertStartsWith(integers, 1, 2, 3, 4, 1, 2, 3, 4);
        Assert.assertTrue(integers.addAll(Sets.fixedSize.of(5)));
        Verify.assertStartsWith(integers, 1, 2, 3, 4, 1, 2, 3, 4, 5);
    }

    @Override
    @Test
    public void addAllIterable() {
        super.addAllIterable();
        MutableList<Integer> integers = MultiReaderFastList.newList();
        Assert.assertTrue(integers.addAllIterable(Lists.fixedSize.of(1, 2, 3, 4)));
        Verify.assertContainsAll(integers, 1, 2, 3, 4);
        Assert.assertTrue(integers.addAllIterable(FastList.<Integer>newList(4).with(1, 2, 3, 4)));
        Verify.assertStartsWith(integers, 1, 2, 3, 4, 1, 2, 3, 4);
        Assert.assertTrue(integers.addAllIterable(Sets.fixedSize.of(5)));
        Verify.assertStartsWith(integers, 1, 2, 3, 4, 1, 2, 3, 4, 5);
    }

    @Test
    public void addAllEmpty() {
        MutableList<Integer> integers = MultiReaderFastList.newList();
        integers.addAll(Lists.fixedSize.of());
        Verify.assertEmpty(integers);
        integers.addAll(Sets.fixedSize.of());
        Verify.assertEmpty(integers);
        integers.addAll(FastList.newList());
        Verify.assertEmpty(integers);
        integers.addAll(ArrayAdapter.newArray());
        Verify.assertEmpty(integers);
    }

    @Override
    @Test
    public void replaceAll() {
        MutableList<Integer> integers = this.getIntegerList();
        integers.replaceAll(i -> i * 2);
        Assert.assertEquals(Lists.mutable.with(10, 8, 6, 4, 2), integers);
    }

    @Override
    @Test
    public void sort() {
        MutableList<Integer> integers = this.getIntegerList();
        integers.sort(Comparator.reverseOrder());
        Assert.assertEquals(Lists.mutable.with(5, 4, 3, 2, 1), integers);
    }

    @Override
    @Test
    public void addAllAtIndex() {
        MutableList<Integer> integers = this.newWith(5);
        integers.addAll(0, Lists.fixedSize.of(1, 2, 3, 4));
        Verify.assertStartsWith(integers, 1, 2, 3, 4, 5);
        integers.addAll(0, this.newWith(-3, -2, -1, 0));
        Verify.assertStartsWith(integers, -3, -2, -1, 0, 1, 2, 3, 4, 5);
    }

    @Test
    public void addAllAtIndexEmpty() {
        MutableList<Integer> integers = this.newWith(5);
        integers.addAll(0, Lists.fixedSize.of());
        Verify.assertSize(1, integers);
        Verify.assertStartsWith(integers, 5);
        integers.addAll(0, FastList.newList(4));
        Verify.assertSize(1, integers);
        Verify.assertStartsWith(integers, 5);
        integers.addAll(0, Sets.fixedSize.of());
        Verify.assertSize(1, integers);
        Verify.assertStartsWith(integers, 5);
        FastList<String> zeroSizedList = FastList.newList(0);
        zeroSizedList.addAll(0, this.newWith("1", "2"));
    }

    @Override
    @Test
    public void addAtIndex() {
        MutableList<Integer> integers = this.newWith(1, 2, 3, 5);
        integers.add(3, 4);
        Verify.assertStartsWith(integers, 1, 2, 3, 4, 5);
        integers.add(5, 6);
        Verify.assertStartsWith(integers, 1, 2, 3, 4, 5, 6);
        integers.add(0, 0);
        Verify.assertStartsWith(integers, 0, 1, 2, 3, 4, 5, 6);
        FastList<String> zeroSizedList = FastList.newList(0);
        zeroSizedList.add(0, "1");
        Verify.assertStartsWith(zeroSizedList, "1");
        zeroSizedList.add(1, "3");
        Verify.assertStartsWith(zeroSizedList, "1", "3");
        zeroSizedList.add(1, "2");
        Verify.assertStartsWith(zeroSizedList, "1", "2", "3");
        MutableList<Integer> midList = FastList.<Integer>newList(2).with(1, 3);
        midList.add(1, 2);
        Verify.assertStartsWith(midList, 1, 2, 3);
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> midList.add(-1, -1));
    }

    @Override
    @Test
    public void subList() {
        super.subList();
        MutableList<String> list = this.newWith("A", "B", "C", "D");
        MutableList<String> sublist = list.subList(1, 3);
        Verify.assertPostSerializedEqualsAndHashCode(sublist);
        Verify.assertSize(2, sublist);
        Verify.assertContainsAll(sublist, "B", "C");
        sublist.add("X");
        Verify.assertSize(3, sublist);
        Verify.assertContainsAll(sublist, "B", "C", "X");
        Verify.assertSize(5, list);
        Verify.assertContainsAll(list, "A", "B", "C", "X", "D");
        sublist.remove("X");
        Verify.assertContainsAll(sublist, "B", "C");
        Verify.assertContainsAll(list, "A", "B", "C", "D");
        Assert.assertEquals("C", sublist.set(1, "R"));
        Verify.assertContainsAll(sublist, "B", "R");
        Verify.assertContainsAll(list, "A", "B", "R", "D");
        sublist.addAll(Arrays.asList("W", "G"));
        Verify.assertContainsAll(sublist, "B", "R", "W", "G");
        Verify.assertContainsAll(list, "A", "B", "R", "W", "G", "D");
        sublist.clear();
        Verify.assertEmpty(sublist);
        Verify.assertContainsAll(list, "A", "D");
    }

    @Test
    public void subListSort() {
        MutableList<Integer> list = Interval.from(0).to(20).addAllTo(MultiReaderFastList.newList()).subList(2, 18).sortThis();
        Assert.assertEquals(FastList.newList(list), Interval.from(2).to(17));
    }

    @Test
    public void subListOfSubList() {
        MutableList<String> list = this.newWith("A", "B", "C", "D");
        MutableList<String> sublist = list.subList(0, 3);
        MutableList<String> sublist2 = sublist.subList(0, 2);
        Verify.assertSize(2, sublist2);
        Verify.assertContainsAll(sublist, "A", "B");
        sublist2.add("X");
        Verify.assertSize(3, sublist2);
        Verify.assertStartsWith(sublist2, "A", "B", "X");
        Verify.assertContainsAll(sublist, "A", "B", "C", "X");
        Assert.assertEquals("X", sublist2.remove(2));
        Verify.assertSize(2, sublist2);
        Verify.assertContainsNone(sublist, "X");
        Verify.assertContainsNone(sublist2, "X");
    }

    @Test
    public void setAtIndex() {
        MutableList<Integer> integers = this.newWith(1, 2, 3, 5);
        Assert.assertEquals(Integer.valueOf(5), integers.set(3, 4));
        Verify.assertStartsWith(integers, 1, 2, 3, 4);
    }

    @Override
    @Test
    public void indexOf() {
        MutableList<Integer> integers = this.newWith(1, 2, 3, 4);
        Assert.assertEquals(2, integers.indexOf(3));
        Assert.assertEquals(-1, integers.indexOf(0));
        Assert.assertEquals(-1, integers.indexOf(null));
        MutableList<Integer> integers2 = this.newWith(null, 2, 3, 4);
        Assert.assertEquals(0, integers2.indexOf(null));
    }

    @Override
    @Test
    public void lastIndexOf() {
        MutableList<Integer> integers = this.newWith(1, 2, 3, 4);
        Assert.assertEquals(2, integers.lastIndexOf(3));
        Assert.assertEquals(-1, integers.lastIndexOf(0));
        Assert.assertEquals(-1, integers.lastIndexOf(null));
        MutableList<Integer> integers2 = this.newWith(null, 2, 3, 4);
        Assert.assertEquals(0, integers2.lastIndexOf(null));
    }

    @Test
    public void outOfBoundsCondition() {
        MutableList<Integer> integers = this.newWith(1, 2, 3, 4);
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> integers.get(4));
    }

    @Override
    @Test
    public void clear() {
        MutableList<Integer> integers = this.newWith(1, 2, 3, 4);
        Verify.assertNotEmpty(integers);
        integers.clear();
        Verify.assertEmpty(integers);
    }

    @Override
    @Test
    public void testClone() {
        MutableList<Integer> integers = this.newWith(1, 2, 3, 4);
        MutableList<Integer> clone = integers.clone();
        Assert.assertEquals(integers, clone);
        Verify.assertInstanceOf(MultiReaderFastList.class, clone);
    }

    @Override
    @Test
    public void toArray() {
        Object[] typelessArray = this.newWith(1, 2, 3, 4).toArray();
        Assert.assertArrayEquals(typelessArray, new Object[] { 1, 2, 3, 4 });
        Integer[] typedArray = this.newWith(1, 2, 3, 4).toArray(new Integer[0]);
        Assert.assertArrayEquals(typedArray, new Integer[] { 1, 2, 3, 4 });
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        MutableList<Integer> integers = this.newWith(1, 2, 3);
        MutableList<Integer> integers2 = this.newWith(1, 2, 3);
        MutableList<Integer> integers3 = this.newWith(1, null, 3, 4, 5);
        MutableList<Integer> integers4 = this.newWith(1, null, 3, 4, 5);
        MutableList<Integer> integers5 = this.newWith(1, null, 3);
        MutableList<Integer> randomAccessList = Lists.fixedSize.of(1, 2, 3);
        MutableList<Integer> randomAccessList2 = Lists.fixedSize.of(2, 3, 4);
        Verify.assertEqualsAndHashCode(integers, integers);
        Verify.assertPostSerializedEqualsAndHashCode(integers);
        Verify.assertEqualsAndHashCode(integers, integers2);
        Verify.assertEqualsAndHashCode(integers, randomAccessList);
        Assert.assertNotEquals(integers, integers3);
        Assert.assertNotEquals(integers, integers5);
        Assert.assertNotEquals(integers, randomAccessList2);
        Assert.assertNotEquals(integers, Sets.fixedSize.of());
        Verify.assertEqualsAndHashCode(integers3, integers4);
        Verify.assertEqualsAndHashCode(integers3, ArrayAdapter.newArrayWith(1, null, 3, 4, 5));
        Assert.assertEquals(integers, integers2);
        Assert.assertNotEquals(integers, integers3);
    }

    @Override
    @Test
    public void removeObject() {
        super.removeObject();
        MutableList<Integer> integers = this.newWith(1, 2, 3, 4);
        Integer doesExist = 1;
        integers.remove(doesExist);
        Verify.assertStartsWith(integers, 2, 3, 4);
        Integer doesNotExist = 5;
        Assert.assertFalse(integers.remove(doesNotExist));
    }

    @Override
    @Test
    public void toList() {
        MutableList<Integer> integers = this.newWith(1, 2, 3, 4);
        MutableList<Integer> list = integers.toList();
        Verify.assertStartsWith(list, 1, 2, 3, 4);
    }

    @Override
    @Test
    public void toSet() {
        MutableList<Integer> integers = this.newWith(1, 2, 3, 4);
        MutableSet<Integer> set = integers.toSet();
        Verify.assertContainsAll(set, 1, 2, 3, 4);
    }

    @Override
    @Test
    public void toMap() {
        MutableList<Integer> integers = this.newWith(1, 2, 3, 4);
        MutableMap<String, String> map = integers.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1", "1", "2", "2", "3", "3", "4", "4"), map);
    }

    @Test
    public void sortThisOnListWithLessThan10Elements() {
        MutableList<Integer> integers = this.newWith(2, 3, 4, 1, 7, 9, 6, 8, 5);
        Verify.assertStartsWith(integers.sortThis(), 1, 2, 3, 4, 5, 6, 7, 8, 9);
        MutableList<Integer> integers2 = this.newWith(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Verify.assertStartsWith(integers2.sortThis(Collections.reverseOrder()), 9, 8, 7, 6, 5, 4, 3, 2, 1);
        MutableList<Integer> integers3 = this.newWith(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Verify.assertStartsWith(integers3.sortThis(), 1, 2, 3, 4, 5, 6, 7, 8, 9);
        Verify.assertInstanceOf(MultiReaderFastList.class, integers3.sortThis());
    }

    @Test
    public void sortThisOnListWithMoreThan9Elements() {
        MutableList<Integer> integers = this.newWith(2, 3, 4, 1, 5, 7, 6, 8, 10, 9);
        Verify.assertStartsWith(integers.sortThis(), 1, 2, 3, 4);
        MutableList<Integer> integers2 = this.newWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Verify.assertStartsWith(integers2.sortThis(Collections.reverseOrder()), 10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
        MutableList<Integer> integers3 = this.newWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Verify.assertStartsWith(integers3.sortThis(), 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    @Test
    public void newListWithCollection() {
        Verify.assertEmpty(MultiReaderFastList.newList(Lists.fixedSize.of()));
        Verify.assertEmpty(MultiReaderFastList.newList(Sets.fixedSize.of()));
        Verify.assertEmpty(MultiReaderFastList.newList(FastList.newList()));
        Verify.assertEmpty(MultiReaderFastList.newList(FastList.newList(4)));
        MutableList<Integer> setToList = MultiReaderFastList.newList(UnifiedSet.newSetWith(1, 2, 3, 4, 5));
        Verify.assertNotEmpty(setToList);
        Verify.assertSize(5, setToList);
        Verify.assertContainsAll(setToList, 1, 2, 3, 4, 5);
        MutableList<Integer> arrayListToList = MultiReaderFastList.newList(Lists.fixedSize.of(1, 2, 3, 4, 5));
        Verify.assertNotEmpty(arrayListToList);
        Verify.assertSize(5, arrayListToList);
        Verify.assertStartsWith(arrayListToList, 1, 2, 3, 4, 5);
        MutableList<Integer> fastListToList = MultiReaderFastList.newList(FastList.<Integer>newList().with(1, 2, 3, 4, 5));
        Verify.assertNotEmpty(fastListToList);
        Verify.assertSize(5, fastListToList);
        Verify.assertStartsWith(fastListToList, 1, 2, 3, 4, 5);
    }

    @Test
    public void containsAll() {
        MutableList<Integer> list = this.newWith(1, 2, 3, 4, 5, null);
        Assert.assertTrue(list.containsAll(Lists.fixedSize.of(1, 3, 5, null)));
        Assert.assertFalse(list.containsAll(Lists.fixedSize.of(2, null, 6)));
        Assert.assertTrue(list.containsAll(FastList.<Integer>newList().with(1, 3, 5, null)));
        Assert.assertFalse(list.containsAll(FastList.<Integer>newList().with(2, null, 6)));
    }

    @Override
    @Test
    public void iterator() {
        MultiReaderFastList<Integer> integers = this.newWith(1, 2, 3, 4);
        Assert.assertThrows(UnsupportedOperationException.class, integers::iterator);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void listIterator() {
        MultiReaderFastList<Integer> integers = this.newWith(1, 2, 3, 4);
        integers.listIterator();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void listIteratorWithIndex() {
        MultiReaderFastList<Integer> integers = this.newWith(1, 2, 3, 4);
        integers.listIterator(2);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void listIteratorIndexTooSmall() {
        this.newWith(1).listIterator(-1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void listIteratorIndexTooBig() {
        this.newWith(1).listIterator(2);
    }

    @Test
    public void withWritelockAndDelegate() {
        MultiReaderFastList<Integer> list = MultiReaderFastList.newList(2);
        AtomicReference<MutableList<?>> delegateList = new AtomicReference<>();
        AtomicReference<MutableList<?>> subLists = new AtomicReference<>();
        AtomicReference<Iterator<?>> iterator = new AtomicReference<>();
        AtomicReference<Iterator<?>> listIterator = new AtomicReference<>();
        AtomicReference<Iterator<?>> listIteratorWithPosition = new AtomicReference<>();
        list.withWriteLockAndDelegate(delegate -> {
            delegate.add(1);
            delegate.add(2);
            delegate.add(3);
            delegate.add(4);
            delegateList.set(delegate);
            subLists.set(delegate.subList(1, 3));
            iterator.set(delegate.iterator());
            listIterator.set(delegate.listIterator());
            listIteratorWithPosition.set(delegate.listIterator(3));
        });
        Assert.assertEquals(FastList.newListWith(1, 2, 3, 4), list);
        this.assertIteratorThrows(delegateList.get());
        this.assertIteratorThrows(subLists.get());
        this.assertIteratorThrows(iterator.get());
        this.assertIteratorThrows(listIterator.get());
        this.assertIteratorThrows(listIteratorWithPosition.get());
    }

    private void assertIteratorThrows(Iterator<?> iterator) {
        Assert.assertThrows(NullPointerException.class, iterator::hasNext);
    }

    private void assertIteratorThrows(MutableList<?> list) {
        Assert.assertThrows(NullPointerException.class, list::iterator);
    }

    @Test
    public void withReadLockAndDelegate() {
        MultiReaderFastList<Integer> list = this.newWith(1);
        Object[] result = new Object[1];
        list.withReadLockAndDelegate(delegate -> {
            result[0] = delegate.getFirst();
            this.verifyDelegateIsUnmodifiable(delegate);
        });
        Assert.assertNotNull(result[0]);
    }

    private void verifyDelegateIsUnmodifiable(MutableList<Integer> delegate) {
        Assert.assertThrows(UnsupportedOperationException.class, () -> delegate.add(2));
        Assert.assertThrows(UnsupportedOperationException.class, () -> delegate.remove(0));
    }

    @Override
    @Test
    public void testToString() {
        Assert.assertEquals("[1, 2, 3]", this.newWith(1, 2, 3).toString());
    }

    @Override
    @Test
    public void makeString() {
        Assert.assertEquals("1, 2, 3", this.newWith(1, 2, 3).makeString());
    }

    @Override
    @Test
    public void appendString() {
        Appendable builder = new StringBuilder();
        this.newWith(1, 2, 3).appendString(builder);
        Assert.assertEquals("1, 2, 3", builder.toString());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void iterator_throws() {
        this.newWith(1, 2, 3).iterator();
    }

    @Override
    @Test
    public void asReversed() {
        MultiReaderFastList<Integer> multiReaderFastList = this.newWith(1, 2, 3, 4);
        multiReaderFastList.withReadLockAndDelegate(delegate -> Verify.assertIterablesEqual(iList(4, 3, 2, 1), delegate.asReversed()));
    }

    @Override
    @Test
    public void binarySearch() {
        MutableList<Integer> sortedList = this.newWith(1, 2, 3, 4, 5, 7);
        Assert.assertEquals(1, sortedList.binarySearch(2));
        Assert.assertEquals(-6, sortedList.binarySearch(6));
    }

    @Override
    @Test
    public void binarySearchWithComparator() {
        MutableList<Integer> sortedList = this.newWith(7, 5, 4, 3, 2, 1);
        Assert.assertEquals(4, sortedList.binarySearch(2, Comparators.reverseNaturalOrder()));
        Assert.assertEquals(-2, sortedList.binarySearch(6, Comparators.reverseNaturalOrder()));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public MultiReaderFastListTest instance;

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
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_target);
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
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSet);
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
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
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
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
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
        public void benchmark_forEachFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachFromTo);
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
        public void benchmark_removeIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_set() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.set);
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
        public void benchmark_forEachOnRange() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachOnRange);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexOnRange() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexOnRange);
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
        public void benchmark_forEachInBothThrowsOnDifferentListSizes() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachInBothThrowsOnDifferentListSizes);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachInBothThrowsOnNullList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachInBothThrowsOnNullList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_largeCollectionStreamToBagMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.largeCollectionStreamToBagMultimap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_fastListNewWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.fastListNewWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoMaxString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoMaxString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoMinString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoMinString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachInBothUsingListIterate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachInBothUsingListIterate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachInBoth() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachInBoth);
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
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
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
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectAndRejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectAndRejectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
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
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
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
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
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
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
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
        public void benchmark_removeUsingPredicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeUsingPredicate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIfWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIfWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllWithWeakReference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllWithWeakReference);
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
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serializationOfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serializationOfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serializationOfSublist() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serializationOfSublist);
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
        public void benchmark_addAllEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllEmpty);
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
        public void benchmark_addAllAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllAtIndexEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllAtIndexEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subListSort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subListSort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subListOfSubList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subListOfSubList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_setAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.setAtIndex);
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
        public void benchmark_outOfBoundsCondition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.outOfBoundsCondition);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
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
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisOnListWithLessThan10Elements() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisOnListWithLessThan10Elements);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisOnListWithMoreThan9Elements() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisOnListWithMoreThan9Elements);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWithCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWithCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.listIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIteratorWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.listIteratorWithIndex);
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
        public void benchmark_withWritelockAndDelegate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withWritelockAndDelegate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withReadLockAndDelegate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withReadLockAndDelegate);
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
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
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

        public void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> payload) throws java.lang.Throwable {
            this.instance = new MultiReaderFastListTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> randomAccess_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> getFirstOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> getLastOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> detectLastIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> newListWithSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> forEachFromToInReverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> reverseForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> reverseForEach_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> reverseForEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> reverseForEachWithIndex_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> distinctWithHashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> distinctBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> removeIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> withMethods;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sortThis_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sortThis_small;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sortThis_large;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sortThis_with_comparator_small;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sortThis_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sortThis_with_comparator_large;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sortThisBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sortThisByBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sortThisByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sortThisByChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sortThisByByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sortThisByShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sortThisByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sortThisByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sortThisByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> forEachWithIndexWithFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> forEachWithIndexWithFromToInReverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sortThisWithNullWithNoComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toSortedListWithNullWithNoComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> forEachOnRange;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> forEachWithIndexOnRange;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> subListFromOutOfBoundsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> subListToGreaterThanSizeException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> subListFromGreaterThanToException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> getWithIndexOutOfBoundsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> getWithArrayIndexOutOfBoundsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> forEachInBothThrowsOnDifferentListSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> forEachInBothThrowsOnNullList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> fastListNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> injectIntoDouble2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> injectIntoString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> injectIntoMaxString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> injectIntoMinString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> forEachInBothUsingListIterate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> forEachInBoth;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> removeUsingPredicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> removeAllWithWeakReference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> serializationOfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> serializationOfSublist;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> addAllEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> replaceAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> addAllAtIndexEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> subListSort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> subListOfSubList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> setAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> outOfBoundsCondition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sortThisOnListWithLessThan10Elements;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> sortThisOnListWithMoreThan9Elements;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> newListWithCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> listIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> listIteratorWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> listIteratorIndexTooSmall;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> listIteratorIndexTooBig;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> withWritelockAndDelegate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> withReadLockAndDelegate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> asReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> binarySearch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListTest> binarySearchWithComparator;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = MultiReaderFastListTest::testNewCollection;
            this.payloads.contains = MultiReaderFastListTest::contains;
            this.payloads.containsBy = MultiReaderFastListTest::containsBy;
            this.payloads.containsAllIterable = MultiReaderFastListTest::containsAllIterable;
            this.payloads.containsAnyIterable = MultiReaderFastListTest::containsAnyIterable;
            this.payloads.containsNoneIterable = MultiReaderFastListTest::containsNoneIterable;
            this.payloads.containsAllArray = MultiReaderFastListTest::containsAllArray;
            this.payloads.containsAnyCollection = MultiReaderFastListTest::containsAnyCollection;
            this.payloads.containsNoneCollection = MultiReaderFastListTest::containsNoneCollection;
            this.payloads.containsAllCollection = MultiReaderFastListTest::containsAllCollection;
            this.payloads.tap = MultiReaderFastListTest::tap;
            this.payloads.selectWith_target = MultiReaderFastListTest::selectWith_target;
            this.payloads.rejectWith_target = MultiReaderFastListTest::rejectWith_target;
            this.payloads.selectInstancesOf = MultiReaderFastListTest::selectInstancesOf;
            this.payloads.collectTarget = MultiReaderFastListTest::collectTarget;
            this.payloads.collectBoolean = MultiReaderFastListTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = MultiReaderFastListTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = MultiReaderFastListTest::collectBooleanWithBagTarget;
            this.payloads.collectByte = MultiReaderFastListTest::collectByte;
            this.payloads.collectByteWithTarget = MultiReaderFastListTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = MultiReaderFastListTest::collectByteWithBagTarget;
            this.payloads.collectChar = MultiReaderFastListTest::collectChar;
            this.payloads.collectCharWithTarget = MultiReaderFastListTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = MultiReaderFastListTest::collectCharWithBagTarget;
            this.payloads.collectDouble = MultiReaderFastListTest::collectDouble;
            this.payloads.collectDoubleWithTarget = MultiReaderFastListTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = MultiReaderFastListTest::collectDoubleWithBagTarget;
            this.payloads.collectFloat = MultiReaderFastListTest::collectFloat;
            this.payloads.collectFloatWithTarget = MultiReaderFastListTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = MultiReaderFastListTest::collectFloatWithBagTarget;
            this.payloads.collectInt = MultiReaderFastListTest::collectInt;
            this.payloads.collectIntWithTarget = MultiReaderFastListTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = MultiReaderFastListTest::collectIntWithBagTarget;
            this.payloads.collectLong = MultiReaderFastListTest::collectLong;
            this.payloads.collectLongWithTarget = MultiReaderFastListTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = MultiReaderFastListTest::collectLongWithBagTarget;
            this.payloads.collectShort = MultiReaderFastListTest::collectShort;
            this.payloads.collectShortWithTarget = MultiReaderFastListTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = MultiReaderFastListTest::collectShortWithBagTarget;
            this.payloads.flatCollect = MultiReaderFastListTest::flatCollect;
            this.payloads.flatCollectWith = MultiReaderFastListTest::flatCollectWith;
            this.payloads.flatCollectBoolean = MultiReaderFastListTest::flatCollectBoolean;
            this.payloads.flatCollectByte = MultiReaderFastListTest::flatCollectByte;
            this.payloads.flatCollectShort = MultiReaderFastListTest::flatCollectShort;
            this.payloads.flatCollectInt = MultiReaderFastListTest::flatCollectInt;
            this.payloads.flatCollectChar = MultiReaderFastListTest::flatCollectChar;
            this.payloads.flatCollectLong = MultiReaderFastListTest::flatCollectLong;
            this.payloads.flatCollectDouble = MultiReaderFastListTest::flatCollectDouble;
            this.payloads.flatCollectFloat = MultiReaderFastListTest::flatCollectFloat;
            this.payloads.detectOptional = MultiReaderFastListTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = MultiReaderFastListTest::min;
            this.payloads.minOptional = MultiReaderFastListTest::minOptional;
            this.payloads.max = MultiReaderFastListTest::max;
            this.payloads.maxOptional = MultiReaderFastListTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = MultiReaderFastListTest::min_without_comparator;
            this.payloads.max_without_comparator = MultiReaderFastListTest::max_without_comparator;
            this.payloads.min_null_safe = MultiReaderFastListTest::min_null_safe;
            this.payloads.max_null_safe = MultiReaderFastListTest::max_null_safe;
            this.payloads.minBy = MultiReaderFastListTest::minBy;
            this.payloads.minByOptional = MultiReaderFastListTest::minByOptional;
            this.payloads.maxBy = MultiReaderFastListTest::maxBy;
            this.payloads.maxByOptional = MultiReaderFastListTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWithOptional = MultiReaderFastListTest::detectWithOptional;
            this.payloads.detectWithIfNoneBlock = MultiReaderFastListTest::detectWithIfNoneBlock;
            this.payloads.collectWith_target = MultiReaderFastListTest::collectWith_target;
            this.payloads.getAny = MultiReaderFastListTest::getAny;
            this.payloads.getOnly = MultiReaderFastListTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.injectIntoInt = MultiReaderFastListTest::injectIntoInt;
            this.payloads.injectIntoLong = MultiReaderFastListTest::injectIntoLong;
            this.payloads.injectIntoDouble = MultiReaderFastListTest::injectIntoDouble;
            this.payloads.injectIntoFloat = MultiReaderFastListTest::injectIntoFloat;
            this.payloads.sumFloat = MultiReaderFastListTest::sumFloat;
            this.payloads.summarizeFloat = MultiReaderFastListTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = MultiReaderFastListTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = MultiReaderFastListTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = MultiReaderFastListTest::sumDouble;
            this.payloads.summarizeDouble = MultiReaderFastListTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = MultiReaderFastListTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = MultiReaderFastListTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = MultiReaderFastListTest::sumInteger;
            this.payloads.summarizeInt = MultiReaderFastListTest::summarizeInt;
            this.payloads.sumLong = MultiReaderFastListTest::sumLong;
            this.payloads.summarizeLong = MultiReaderFastListTest::summarizeLong;
            this.payloads.sumByInt = MultiReaderFastListTest::sumByInt;
            this.payloads.sumByFloat = MultiReaderFastListTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = MultiReaderFastListTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = MultiReaderFastListTest::sumByLong;
            this.payloads.sumByDouble = MultiReaderFastListTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = MultiReaderFastListTest::sumByDoubleConsistentRounding;
            this.payloads.partition = MultiReaderFastListTest::partition;
            this.payloads.partitionWith = MultiReaderFastListTest::partitionWith;
            this.payloads.toImmutableList = MultiReaderFastListTest::toImmutableList;
            this.payloads.toCollection = MultiReaderFastListTest::toCollection;
            this.payloads.toBag = MultiReaderFastListTest::toBag;
            this.payloads.toImmutableBag = MultiReaderFastListTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = MultiReaderFastListTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = MultiReaderFastListTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = MultiReaderFastListTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = MultiReaderFastListTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = MultiReaderFastListTest::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = MultiReaderFastListTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = MultiReaderFastListTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = MultiReaderFastListTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = MultiReaderFastListTest::toSortedBagBy;
            this.payloads.toImmutableSortedBagBy = MultiReaderFastListTest::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = MultiReaderFastListTest::toSortedListBy;
            this.payloads.toImmutableSortedListBy = MultiReaderFastListTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = MultiReaderFastListTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = MultiReaderFastListTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = MultiReaderFastListTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = MultiReaderFastListTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = MultiReaderFastListTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = MultiReaderFastListTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSet = MultiReaderFastListTest::toImmutableSet;
            this.payloads.toImmutableMap = MultiReaderFastListTest::toImmutableMap;
            this.payloads.toMapTarget = MultiReaderFastListTest::toMapTarget;
            this.payloads.toSortedMap = MultiReaderFastListTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = MultiReaderFastListTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = MultiReaderFastListTest::toSortedMapBy;
            this.payloads.toBiMap = MultiReaderFastListTest::toBiMap;
            this.payloads.toImmutableBiMap = MultiReaderFastListTest::toImmutableBiMap;
            this.payloads.fusedCollectMakeString = MultiReaderFastListTest::fusedCollectMakeString;
            this.payloads.appendStringThrows = MultiReaderFastListTest::appendStringThrows;
            this.payloads.countBy = MultiReaderFastListTest::countBy;
            this.payloads.countByWith = MultiReaderFastListTest::countByWith;
            this.payloads.countByEach = MultiReaderFastListTest::countByEach;
            this.payloads.groupBy = MultiReaderFastListTest::groupBy;
            this.payloads.groupByEach = MultiReaderFastListTest::groupByEach;
            this.payloads.groupByUniqueKey = MultiReaderFastListTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = MultiReaderFastListTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = MultiReaderFastListTest::zip;
            this.payloads.zipWithIndex = MultiReaderFastListTest::zipWithIndex;
            this.payloads.chunk_empty = MultiReaderFastListTest::chunk_empty;
            this.payloads.chunk_single = MultiReaderFastListTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = MultiReaderFastListTest::chunk_large_size;
            this.payloads.empty = MultiReaderFastListTest::empty;
            this.payloads.notEmpty = MultiReaderFastListTest::notEmpty;
            this.payloads.aggregateByMutating = MultiReaderFastListTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = MultiReaderFastListTest::aggregateByNonMutating;
            this.payloads.reduceOptional = MultiReaderFastListTest::reduceOptional;
            this.payloads.testNewWith = MultiReaderFastListTest::testNewWith;
            this.payloads.testNewWithWith = MultiReaderFastListTest::testNewWithWith;
            this.payloads.testNewWithWithWith = MultiReaderFastListTest::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = MultiReaderFastListTest::testNewWithVarArgs;
            this.payloads.removeAll = MultiReaderFastListTest::removeAll;
            this.payloads.with = MultiReaderFastListTest::with;
            this.payloads.withAll = MultiReaderFastListTest::withAll;
            this.payloads.without = MultiReaderFastListTest::without;
            this.payloads.withoutAll = MultiReaderFastListTest::withoutAll;
            this.payloads.asLazy = MultiReaderFastListTest::asLazy;
            this.payloads.randomAccess_throws = MultiReaderFastListTest::randomAccess_throws;
            this.payloads.getFirstOptional = MultiReaderFastListTest::getFirstOptional;
            this.payloads.getLastOptional = MultiReaderFastListTest::getLastOptional;
            this.payloads.detectIndex = MultiReaderFastListTest::detectIndex;
            this.payloads.detectLastIndex = MultiReaderFastListTest::detectLastIndex;
            this.payloads.collectWithIndex = MultiReaderFastListTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = MultiReaderFastListTest::collectWithIndexWithTarget;
            this.payloads.selectWithIndex = MultiReaderFastListTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = MultiReaderFastListTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = MultiReaderFastListTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = MultiReaderFastListTest::rejectWithIndexWithTarget;
            this.payloads.asSynchronized = MultiReaderFastListTest::asSynchronized;
            this.payloads.toImmutable = MultiReaderFastListTest::toImmutable;
            this.payloads.asUnmodifiable = MultiReaderFastListTest::asUnmodifiable;
            this.payloads.newListWithSize = MultiReaderFastListTest::newListWithSize;
            this.payloads.corresponds = MultiReaderFastListTest::corresponds;
            this.payloads.forEachFromTo = MultiReaderFastListTest::forEachFromTo;
            this.payloads.forEachFromToInReverse = MultiReaderFastListTest::forEachFromToInReverse;
            this.payloads.reverseForEach = MultiReaderFastListTest::reverseForEach;
            this.payloads.reverseForEach_emptyList = MultiReaderFastListTest::reverseForEach_emptyList;
            this.payloads.reverseForEachWithIndex = MultiReaderFastListTest::reverseForEachWithIndex;
            this.payloads.reverseForEachWithIndex_emptyList = MultiReaderFastListTest::reverseForEachWithIndex_emptyList;
            this.payloads.reverseThis = MultiReaderFastListTest::reverseThis;
            this.payloads.toReversed = MultiReaderFastListTest::toReversed;
            this.payloads.distinct = MultiReaderFastListTest::distinct;
            this.payloads.distinctWithHashingStrategy = MultiReaderFastListTest::distinctWithHashingStrategy;
            this.payloads.distinctBy = MultiReaderFastListTest::distinctBy;
            this.payloads.removeIndex = MultiReaderFastListTest::removeIndex;
            this.payloads.set = MultiReaderFastListTest::set;
            this.payloads.withMethods = MultiReaderFastListTest::withMethods;
            this.payloads.sortThis_with_null = MultiReaderFastListTest::sortThis_with_null;
            this.payloads.sortThis_small = MultiReaderFastListTest::sortThis_small;
            this.payloads.sortThis = MultiReaderFastListTest::sortThis;
            this.payloads.sortThis_large = MultiReaderFastListTest::sortThis_large;
            this.payloads.sortThis_with_comparator_small = MultiReaderFastListTest::sortThis_with_comparator_small;
            this.payloads.sortThis_with_comparator = MultiReaderFastListTest::sortThis_with_comparator;
            this.payloads.sortThis_with_comparator_large = MultiReaderFastListTest::sortThis_with_comparator_large;
            this.payloads.sortThisBy = MultiReaderFastListTest::sortThisBy;
            this.payloads.sortThisByBoolean = MultiReaderFastListTest::sortThisByBoolean;
            this.payloads.sortThisByInt = MultiReaderFastListTest::sortThisByInt;
            this.payloads.sortThisByChar = MultiReaderFastListTest::sortThisByChar;
            this.payloads.sortThisByByte = MultiReaderFastListTest::sortThisByByte;
            this.payloads.sortThisByShort = MultiReaderFastListTest::sortThisByShort;
            this.payloads.sortThisByFloat = MultiReaderFastListTest::sortThisByFloat;
            this.payloads.sortThisByLong = MultiReaderFastListTest::sortThisByLong;
            this.payloads.sortThisByDouble = MultiReaderFastListTest::sortThisByDouble;
            this.payloads.makeStringWithSeparator = MultiReaderFastListTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = MultiReaderFastListTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringWithSeparator = MultiReaderFastListTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = MultiReaderFastListTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.forEachWithIndexWithFromTo = MultiReaderFastListTest::forEachWithIndexWithFromTo;
            this.payloads.forEachWithIndexWithFromToInReverse = MultiReaderFastListTest::forEachWithIndexWithFromToInReverse;
            this.payloads.sortThisWithNullWithNoComparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::sortThisWithNullWithNoComparator, java.lang.NullPointerException.class);
            this.payloads.sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements, java.lang.NullPointerException.class);
            this.payloads.toSortedListWithNullWithNoComparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::toSortedListWithNullWithNoComparator, java.lang.NullPointerException.class);
            this.payloads.toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements, java.lang.NullPointerException.class);
            this.payloads.forEachOnRange = MultiReaderFastListTest::forEachOnRange;
            this.payloads.forEachWithIndexOnRange = MultiReaderFastListTest::forEachWithIndexOnRange;
            this.payloads.subListFromOutOfBoundsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::subListFromOutOfBoundsException, java.lang.IndexOutOfBoundsException.class);
            this.payloads.subListToGreaterThanSizeException = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::subListToGreaterThanSizeException, java.lang.IndexOutOfBoundsException.class);
            this.payloads.subListFromGreaterThanToException = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::subListFromGreaterThanToException, java.lang.IllegalArgumentException.class);
            this.payloads.getWithIndexOutOfBoundsException = MultiReaderFastListTest::getWithIndexOutOfBoundsException;
            this.payloads.getWithArrayIndexOutOfBoundsException = MultiReaderFastListTest::getWithArrayIndexOutOfBoundsException;
            this.payloads.chunk = MultiReaderFastListTest::chunk;
            this.payloads.toStack = MultiReaderFastListTest::toStack;
            this.payloads.take = MultiReaderFastListTest::take;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = MultiReaderFastListTest::takeWhile;
            this.payloads.drop = MultiReaderFastListTest::drop;
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::drop_throws, java.lang.IllegalArgumentException.class);
            this.payloads.dropWhile = MultiReaderFastListTest::dropWhile;
            this.payloads.partitionWhile = MultiReaderFastListTest::partitionWhile;
            this.payloads.forEachInBothThrowsOnDifferentListSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::forEachInBothThrowsOnDifferentListSizes, java.lang.IllegalArgumentException.class);
            this.payloads.forEachInBothThrowsOnNullList = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::forEachInBothThrowsOnNullList, java.lang.NullPointerException.class);
            this.payloads.largeCollectionStreamToBagMultimap = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::largeCollectionStreamToBagMultimap, java.lang.UnsupportedOperationException.class);
            this.payloads.newEmpty = MultiReaderFastListTest::newEmpty;
            this.payloads.fastListNewWith = MultiReaderFastListTest::fastListNewWith;
            this.payloads.forEach = MultiReaderFastListTest::forEach;
            this.payloads.injectInto = MultiReaderFastListTest::injectInto;
            this.payloads.injectIntoDouble2 = MultiReaderFastListTest::injectIntoDouble2;
            this.payloads.injectIntoString = MultiReaderFastListTest::injectIntoString;
            this.payloads.injectIntoMaxString = MultiReaderFastListTest::injectIntoMaxString;
            this.payloads.injectIntoMinString = MultiReaderFastListTest::injectIntoMinString;
            this.payloads.collect = MultiReaderFastListTest::collect;
            this.payloads.forEachWithIndex = MultiReaderFastListTest::forEachWithIndex;
            this.payloads.forEachInBothUsingListIterate = MultiReaderFastListTest::forEachInBothUsingListIterate;
            this.payloads.forEachInBoth = MultiReaderFastListTest::forEachInBoth;
            this.payloads.detect = MultiReaderFastListTest::detect;
            this.payloads.detectWith = MultiReaderFastListTest::detectWith;
            this.payloads.detectWithIfNone = MultiReaderFastListTest::detectWithIfNone;
            this.payloads.select = MultiReaderFastListTest::select;
            this.payloads.selectWith = MultiReaderFastListTest::selectWith;
            this.payloads.rejectWith = MultiReaderFastListTest::rejectWith;
            this.payloads.selectAndRejectWith = MultiReaderFastListTest::selectAndRejectWith;
            this.payloads.anySatisfyWith = MultiReaderFastListTest::anySatisfyWith;
            this.payloads.anySatisfy = MultiReaderFastListTest::anySatisfy;
            this.payloads.allSatisfyWith = MultiReaderFastListTest::allSatisfyWith;
            this.payloads.allSatisfy = MultiReaderFastListTest::allSatisfy;
            this.payloads.noneSatisfy = MultiReaderFastListTest::noneSatisfy;
            this.payloads.noneSatisfyWith = MultiReaderFastListTest::noneSatisfyWith;
            this.payloads.count = MultiReaderFastListTest::count;
            this.payloads.countWith = MultiReaderFastListTest::countWith;
            this.payloads.detectIfNone = MultiReaderFastListTest::detectIfNone;
            this.payloads.forEachWith = MultiReaderFastListTest::forEachWith;
            this.payloads.getFirst = MultiReaderFastListTest::getFirst;
            this.payloads.getLast = MultiReaderFastListTest::getLast;
            this.payloads.isEmpty = MultiReaderFastListTest::isEmpty;
            this.payloads.collectIf = MultiReaderFastListTest::collectIf;
            this.payloads.collectWith = MultiReaderFastListTest::collectWith;
            this.payloads.injectIntoWith = MultiReaderFastListTest::injectIntoWith;
            this.payloads.removeUsingPredicate = MultiReaderFastListTest::removeUsingPredicate;
            this.payloads.removeIf = MultiReaderFastListTest::removeIf;
            this.payloads.removeIfWith = MultiReaderFastListTest::removeIfWith;
            this.payloads.removeAllIterable = MultiReaderFastListTest::removeAllIterable;
            this.payloads.removeAllWithWeakReference = MultiReaderFastListTest::removeAllWithWeakReference;
            this.payloads.retainAll = MultiReaderFastListTest::retainAll;
            this.payloads.retainAllIterable = MultiReaderFastListTest::retainAllIterable;
            this.payloads.reject = MultiReaderFastListTest::reject;
            this.payloads.serialization = MultiReaderFastListTest::serialization;
            this.payloads.serializationOfEmpty = MultiReaderFastListTest::serializationOfEmpty;
            this.payloads.serializationOfSublist = MultiReaderFastListTest::serializationOfSublist;
            this.payloads.addAll = MultiReaderFastListTest::addAll;
            this.payloads.addAllIterable = MultiReaderFastListTest::addAllIterable;
            this.payloads.addAllEmpty = MultiReaderFastListTest::addAllEmpty;
            this.payloads.replaceAll = MultiReaderFastListTest::replaceAll;
            this.payloads.sort = MultiReaderFastListTest::sort;
            this.payloads.addAllAtIndex = MultiReaderFastListTest::addAllAtIndex;
            this.payloads.addAllAtIndexEmpty = MultiReaderFastListTest::addAllAtIndexEmpty;
            this.payloads.addAtIndex = MultiReaderFastListTest::addAtIndex;
            this.payloads.subList = MultiReaderFastListTest::subList;
            this.payloads.subListSort = MultiReaderFastListTest::subListSort;
            this.payloads.subListOfSubList = MultiReaderFastListTest::subListOfSubList;
            this.payloads.setAtIndex = MultiReaderFastListTest::setAtIndex;
            this.payloads.indexOf = MultiReaderFastListTest::indexOf;
            this.payloads.lastIndexOf = MultiReaderFastListTest::lastIndexOf;
            this.payloads.outOfBoundsCondition = MultiReaderFastListTest::outOfBoundsCondition;
            this.payloads.clear = MultiReaderFastListTest::clear;
            this.payloads.testClone = MultiReaderFastListTest::testClone;
            this.payloads.toArray = MultiReaderFastListTest::toArray;
            this.payloads.equalsAndHashCode = MultiReaderFastListTest::equalsAndHashCode;
            this.payloads.removeObject = MultiReaderFastListTest::removeObject;
            this.payloads.toList = MultiReaderFastListTest::toList;
            this.payloads.toSet = MultiReaderFastListTest::toSet;
            this.payloads.toMap = MultiReaderFastListTest::toMap;
            this.payloads.sortThisOnListWithLessThan10Elements = MultiReaderFastListTest::sortThisOnListWithLessThan10Elements;
            this.payloads.sortThisOnListWithMoreThan9Elements = MultiReaderFastListTest::sortThisOnListWithMoreThan9Elements;
            this.payloads.newListWithCollection = MultiReaderFastListTest::newListWithCollection;
            this.payloads.containsAll = MultiReaderFastListTest::containsAll;
            this.payloads.iterator = MultiReaderFastListTest::iterator;
            this.payloads.listIterator = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::listIterator, java.lang.UnsupportedOperationException.class);
            this.payloads.listIteratorWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::listIteratorWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.listIteratorIndexTooSmall = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::listIteratorIndexTooSmall, java.lang.UnsupportedOperationException.class);
            this.payloads.listIteratorIndexTooBig = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::listIteratorIndexTooBig, java.lang.UnsupportedOperationException.class);
            this.payloads.withWritelockAndDelegate = MultiReaderFastListTest::withWritelockAndDelegate;
            this.payloads.withReadLockAndDelegate = MultiReaderFastListTest::withReadLockAndDelegate;
            this.payloads.testToString = MultiReaderFastListTest::testToString;
            this.payloads.makeString = MultiReaderFastListTest::makeString;
            this.payloads.appendString = MultiReaderFastListTest::appendString;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListTest::iterator_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.asReversed = MultiReaderFastListTest::asReversed;
            this.payloads.binarySearch = MultiReaderFastListTest::binarySearch;
            this.payloads.binarySearchWithComparator = MultiReaderFastListTest::binarySearchWithComparator;
        }
    }
}
