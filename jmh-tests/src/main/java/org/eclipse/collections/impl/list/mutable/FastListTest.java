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

import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.predicate.Predicate2;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.Twin;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.block.function.MaxSizeFunction;
import org.eclipse.collections.impl.block.function.MinSizeFunction;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.block.procedure.CountProcedure;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.fixed.ArrayAdapter;
import org.eclipse.collections.impl.math.IntegerSum;
import org.eclipse.collections.impl.math.Sum;
import org.eclipse.collections.impl.math.SumProcedure;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.ClassComparer;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.eclipse.collections.impl.utility.LazyIterate;
import org.eclipse.collections.impl.utility.ListIterate;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iList;
import static org.eclipse.collections.impl.factory.Iterables.mList;
import static org.eclipse.collections.impl.factory.Iterables.mSet;

/**
 * JUnit test for {@link FastList}.
 */
public class FastListTest extends AbstractListTestCase {

    @Override
    protected <T> FastList<T> newWith(T... littleElements) {
        return FastList.newListWith(littleElements);
    }

    @Override
    @Test
    public void newEmpty() {
        Verify.assertInstanceOf(FastList.class, FastList.newList().newEmpty());
    }

    @Test
    public void withNValues() {
        Assert.assertEquals(FastList.newListWith(1, 1, 1, 1, 1), FastList.newWithNValues(5, () -> 1));
        Assert.assertEquals(FastList.newListWith(null, null, null, null, null), FastList.newWithNValues(5, () -> null));
        Assert.assertEquals(FastList.newListWith(Lists.mutable.with(), Lists.mutable.with(), Lists.mutable.with(), Lists.mutable.with(), Lists.mutable.with()), FastList.newWithNValues(5, FastList::new));
    }

    @Test
    public void constructorWithCollection() {
        List<Integer> expected = new ArrayList<>(Interval.oneTo(20));
        FastList<Integer> actual = new FastList<>(expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFastListNewWithContainsAllItems() {
        Assert.assertEquals(Bags.mutable.of("Alice", "Bob", "Cooper", "Dio"), this.newWith("Alice", "Bob", "Cooper", "Dio").toBag());
    }

    @Test
    public void testAddWithZeroBasedConstructor() {
        MutableList<String> strings = FastList.newList(0);
        Assert.assertEquals(new ArrayList<String>(0), strings);
        strings.add("1");
        Assert.assertEquals(this.newWith("1"), strings);
    }

    @Test
    public void getBatchCount() {
        FastList<String> strings = FastList.newList(0);
        Assert.assertEquals(1, strings.getBatchCount(10));
        strings.with("a", "b", "c");
        Assert.assertEquals(3, strings.getBatchCount(1));
        Assert.assertEquals(1, strings.getBatchCount(2));
        Assert.assertEquals(1, strings.getBatchCount(200));
    }

    @Test
    public void remove() {
        MutableList<String> strings = Lists.mutable.of("a", "b", "c");
        Assert.assertTrue(strings.remove("a"));
        Verify.assertSize(2, strings);
        Assert.assertFalse(strings.remove("a"));
        Assert.assertFalse(strings.remove("z"));
        Verify.assertSize(2, strings);
        Assert.assertTrue(strings.remove("c"));
        Verify.assertSize(1, strings);
    }

    @Test
    public void wrapCopy() {
        Integer[] integers = { 1, 2, 3, 4 };
        FastList<Integer> actual = FastList.wrapCopy(integers);
        FastList<Integer> expected = this.newWith(1, 2, 3, 4);
        integers[0] = Integer.valueOf(4);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void fastListProperSuperSetOfArrayList() {
        Assert.assertTrue(ClassComparer.isProperSupersetOf(FastList.class, ArrayList.class));
    }

    @Override
    @Test
    public void forEach() {
        MutableList<Integer> result = FastList.newList();
        MutableList<Integer> collection = FastList.newListWith(1, 2, 3, 4);
        collection.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(this.newWith(1, 2, 3, 4), result);
    }

    @Override
    @Test
    public void injectInto() {
        FastList<Integer> list = this.newWith(1, 2, 3);
        Assert.assertEquals(Integer.valueOf(1 + 1 + 2 + 3), list.injectInto(1, AddFunction.INTEGER));
    }

    @Test
    public void testInjectIntoDouble() {
        FastList<Double> list = this.newWith(1.0, 2.0, 3.0);
        Assert.assertEquals(new Double(1.0 + 1.0 + 2.0 + 3.0), list.injectInto(new Double(1.0d), AddFunction.DOUBLE));
    }

    @Test
    public void testInjectIntoFloat() {
        FastList<Float> list = this.newWith(1.0f, 2.0f, 3.0f);
        Assert.assertEquals(new Float(7.0f), list.injectInto(new Float(1.0f), AddFunction.FLOAT));
    }

    @Test
    public void testInjectIntoString() {
        FastList<String> list = FastList.<String>newList().with("1", "2", "3");
        Assert.assertEquals("0123", list.injectInto("0", AddFunction.STRING));
    }

    @Test
    public void testInjectIntoMaxString() {
        FastList<String> list = FastList.<String>newList().with("1", "12", "123");
        Assert.assertEquals(Integer.valueOf(3), list.injectInto(Integer.MIN_VALUE, MaxSizeFunction.STRING));
    }

    @Test
    public void testInjectIntoMinString() {
        FastList<String> list = FastList.<String>newList().with("1", "12", "123");
        Assert.assertEquals(Integer.valueOf(1), list.injectInto(Integer.MAX_VALUE, MinSizeFunction.STRING));
    }

    @Override
    @Test
    public void collect() {
        FastList<Boolean> list = this.newWith(Boolean.TRUE, Boolean.FALSE, null);
        MutableList<String> newCollection = list.collect(String::valueOf);
        Assert.assertEquals(this.newWith("true", "false", "null"), newCollection);
    }

    @Override
    @Test
    public void forEachWithIndex() {
        super.forEachWithIndex();
        MutableList<Integer> list = FastList.newList(Interval.oneTo(5));
        list.forEachWithIndex((object, index) -> Assert.assertEquals(index, object - 1));
    }

    @Test
    public void testForEachInBoth() {
        MutableList<Twin<String>> list = FastList.newList();
        MutableList<String> list1 = this.newWith("1", "2");
        MutableList<String> list2 = this.newWith("a", "b");
        ListIterate.forEachInBoth(list1, list2, (argument1, argument2) -> list.add(Tuples.twin(argument1, argument2)));
        Assert.assertEquals(this.newWith(Tuples.twin("1", "a"), Tuples.twin("2", "b")), list);
    }

    @Override
    @Test
    public void detect() {
        MutableList<Integer> list = Interval.toReverseList(1, 5);
        Assert.assertEquals(Integer.valueOf(1), list.detect(Integer.valueOf(1)::equals));
        FastList<Integer> list2 = FastList.newListWith(1, 2, 2);
        Assert.assertSame(list2.get(1), list2.detect(Integer.valueOf(2)::equals));
    }

    @Override
    @Test
    public void detectWith() {
        MutableList<Integer> list = Interval.toReverseList(1, 5);
        Assert.assertEquals(Integer.valueOf(1), list.detectWith(Object::equals, 1));
        FastList<Integer> list2 = FastList.newListWith(1, 2, 2);
        Assert.assertSame(list2.get(1), list2.detectWith(Object::equals, 2));
    }

    @Test
    public void testDetectWithIfNone() {
        MutableList<Integer> list = Interval.toReverseList(1, 5);
        Assert.assertNull(list.detectWithIfNone(Object::equals, 6, new PassThruFunction0<>(null)));
    }

    @Override
    @Test
    public void select() {
        MutableList<Integer> list = Interval.toReverseList(1, 5);
        MutableList<Integer> results = list.select(Integer.class::isInstance);
        Verify.assertSize(5, results);
    }

    @Override
    @Test
    public void selectWith() {
        MutableList<Integer> list = Interval.toReverseList(1, 5);
        MutableList<Integer> results = list.selectWith(Predicates2.instanceOf(), Integer.class);
        Verify.assertSize(5, results);
    }

    @Override
    @Test
    public void rejectWith() {
        MutableList<Integer> list = Interval.toReverseList(1, 5);
        MutableList<Integer> results = list.rejectWith(Predicates2.instanceOf(), Integer.class);
        Verify.assertEmpty(results);
    }

    @Override
    @Test
    public void selectAndRejectWith() {
        MutableList<Integer> list = Interval.toReverseList(1, 5);
        Twin<MutableList<Integer>> result = list.selectAndRejectWith(Predicates2.in(), Lists.fixedSize.of(1));
        Verify.assertSize(1, result.getOne());
        Verify.assertSize(4, result.getTwo());
    }

    @Override
    @Test
    public void anySatisfyWith() {
        MutableList<Integer> list = Interval.toReverseList(1, 5);
        Assert.assertTrue(list.anySatisfyWith(Predicates2.instanceOf(), Integer.class));
        Assert.assertFalse(list.anySatisfyWith(Predicates2.instanceOf(), Double.class));
    }

    @Override
    @Test
    public void anySatisfy() {
        MutableList<Integer> list = Interval.toReverseList(1, 5);
        Assert.assertTrue(Predicates.<Integer>anySatisfy(Integer.class::isInstance).accept(list));
        Assert.assertFalse(Predicates.<Integer>anySatisfy(Double.class::isInstance).accept(list));
    }

    @Override
    @Test
    public void allSatisfyWith() {
        MutableList<Integer> list = Interval.toReverseList(1, 5);
        Assert.assertTrue(list.allSatisfyWith(Predicates2.instanceOf(), Integer.class));
        Predicate2<Integer, Integer> greaterThanPredicate = Predicates2.greaterThan();
        Assert.assertFalse(list.allSatisfyWith(greaterThanPredicate, 2));
    }

    @Override
    @Test
    public void allSatisfy() {
        MutableList<Integer> list = Interval.toReverseList(1, 5);
        Assert.assertTrue(Predicates.<Integer>allSatisfy(Integer.class::isInstance).accept(list));
        Assert.assertFalse(Predicates.allSatisfy(Predicates.greaterThan(2)).accept(list));
    }

    @Override
    @Test
    public void noneSatisfy() {
        MutableList<Integer> list = Interval.toReverseList(1, 5);
        Assert.assertTrue(Predicates.<Integer>noneSatisfy(String.class::isInstance).accept(list));
        Assert.assertFalse(Predicates.noneSatisfy(Predicates.greaterThan(0)).accept(list));
    }

    @Override
    @Test
    public void noneSatisfyWith() {
        MutableList<Integer> list = Interval.toReverseList(1, 5);
        Assert.assertTrue(list.noneSatisfyWith(Predicates2.instanceOf(), String.class));
        Predicate2<Integer, Integer> greaterThanPredicate = Predicates2.greaterThan();
        Assert.assertFalse(list.noneSatisfyWith(greaterThanPredicate, 0));
    }

    @Override
    @Test
    public void count() {
        MutableList<Integer> list = Interval.toReverseList(1, 5);
        Assert.assertEquals(5, list.count(Integer.class::isInstance));
        Assert.assertEquals(0, list.count(Double.class::isInstance));
    }

    @Override
    @Test
    public void countWith() {
        MutableList<Integer> list = Interval.toReverseList(1, 5);
        Assert.assertEquals(5, list.countWith(Predicates2.instanceOf(), Integer.class));
        Assert.assertEquals(0, list.countWith(Predicates2.instanceOf(), Double.class));
    }

    @Override
    @Test
    public void detectIfNone() {
        Function0<Integer> defaultResultFunction = new PassThruFunction0<>(6);
        Assert.assertEquals(Integer.valueOf(3), FastList.newListWith(1, 2, 3, 4, 5).detectIfNone(Integer.valueOf(3)::equals, defaultResultFunction));
        Assert.assertEquals(Integer.valueOf(6), FastList.newListWith(1, 2, 3, 4, 5).detectIfNone(Integer.valueOf(6)::equals, defaultResultFunction));
    }

    @Override
    @Test
    public void forEachWith() {
        MutableList<Integer> result = FastList.newList();
        MutableList<Integer> list = FastList.newListWith(1, 2, 3, 4);
        list.forEachWith((argument1, argument2) -> result.add(argument1 + argument2), 0);
        Verify.assertSize(4, result);
        Verify.assertContainsAll(result, 1, 2, 3, 4);
    }

    @Test
    public void testForEachIf() {
        FastList<Integer> collection = FastList.newListWith(1, 2, 3, 4);
        CountProcedure<Integer> countProcedure = new CountProcedure<>(ignored -> true);
        collection.forEachIf(Predicates.lessThan(4), countProcedure);
        Assert.assertEquals(3, countProcedure.getCount());
    }

    @Override
    @Test
    public void getFirst() {
        Assert.assertNull(FastList.<Integer>newList().getFirst());
        Assert.assertEquals(Integer.valueOf(1), FastList.newListWith(1, 2, 3).getFirst());
        Assert.assertNotEquals(Integer.valueOf(3), FastList.newListWith(1, 2, 3).getFirst());
    }

    @Override
    @Test
    public void getLast() {
        Assert.assertNull(FastList.<Integer>newList().getLast());
        Assert.assertNotEquals(Integer.valueOf(1), FastList.newListWith(1, 2, 3).getLast());
        Assert.assertEquals(Integer.valueOf(3), FastList.newListWith(1, 2, 3).getLast());
    }

    @Override
    @Test
    public void isEmpty() {
        Verify.assertEmpty(FastList.<Integer>newList());
        Verify.assertNotEmpty(FastList.newListWith(1, 2));
        Assert.assertTrue(FastList.newListWith(1, 2).notEmpty());
    }

    @Override
    @Test
    public void collectIf() {
        Verify.assertContainsAll(FastList.newListWith(1, 2, 3).collectIf(Integer.class::isInstance, String::valueOf), "1", "2", "3");
        Verify.assertContainsAll(FastList.newListWith(1, 2, 3).collectIf(Integer.class::isInstance, String::valueOf, new ArrayList<>()), "1", "2", "3");
    }

    @Override
    @Test
    public void collectWith() {
        Assert.assertEquals(FastList.newListWith(2, 3, 4), FastList.newListWith(1, 2, 3).collectWith(AddFunction.INTEGER, 1));
        Assert.assertEquals(FastList.newListWith(2, 3, 4), FastList.newListWith(1, 2, 3).collectWith(AddFunction.INTEGER, 1, FastList.newList()));
    }

    @Override
    @Test
    public void injectIntoWith() {
        MutableList<Integer> objects = FastList.newListWith(1, 2, 3);
        Integer result = objects.injectIntoWith(1, (injectedValued, item, parameter) -> injectedValued + item + parameter, 0);
        Assert.assertEquals(Integer.valueOf(7), result);
    }

    @Test
    public void testRemoveUsingPredicate() {
        MutableList<Integer> objects = FastList.newListWith(1, 2, 3, null);
        Assert.assertTrue(objects.removeIf(Predicates.isNull()));
        Verify.assertSize(3, objects);
        Verify.assertContainsAll(objects, 1, 2, 3);
    }

    @Override
    @Test
    public void removeAllIterable() {
        FastList<Integer> objects = FastList.newListWith(1, 2, 3);
        objects.removeAllIterable(iList(1, 2));
        Verify.assertSize(1, objects);
        Verify.assertContains(3, objects);
        FastList<Integer> objects2 = FastList.newListWith(1, 2, 3);
        objects2.removeAllIterable(iList(1));
        Verify.assertSize(2, objects2);
        Verify.assertContainsAll(objects2, 2, 3);
        FastList<Integer> objects3 = FastList.newListWith(1, 2, 3);
        objects3.removeAllIterable(iList(3));
        Verify.assertSize(2, objects3);
        Verify.assertContainsAll(objects3, 1, 2);
        FastList<Integer> objects4 = FastList.newListWith(1, 2, 3);
        objects4.removeAllIterable(iList());
        Verify.assertSize(3, objects4);
        Verify.assertContainsAll(objects4, 1, 2, 3);
        FastList<Integer> objects5 = FastList.newListWith(1, 2, 3);
        objects5.removeAllIterable(iList(1, 2, 3));
        Verify.assertEmpty(objects5);
        FastList<Integer> objects6 = FastList.newListWith(1, 2, 3);
        objects6.removeAllIterable(iList(2));
        Verify.assertSize(2, objects6);
        Verify.assertContainsAll(objects6, 1, 3);
    }

    @SuppressWarnings("StringOperationCanBeSimplified")
    @Test
    public void testRemoveAllWithWeakReference() {
        // Deliberate String copy for unit test purpose
        String fred = new String("Fred");
        // Deliberate String copy for unit test purpose
        String wilma = new String("Wilma");
        FastList<String> objects = FastList.<String>newList().with(fred, wilma);
        objects.removeAll(mList("Fred"));
        objects.remove(0);
        Verify.assertSize(0, objects);
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
        objects.retainAll(mList(1, 2));
        Verify.assertSize(2, objects);
        Verify.assertContainsAll(objects, 1, 2);
        MutableList<Integer> objects2 = this.newWith(1, 2, 3);
        objects2.retainAll(mList(1));
        Verify.assertSize(1, objects2);
        Verify.assertContainsAll(objects2, 1);
        MutableList<Integer> objects3 = this.newWith(1, 2, 3);
        objects3.retainAll(mList(3));
        Verify.assertSize(1, objects3);
        Verify.assertContainsAll(objects3, 3);
        MutableList<Integer> objects4 = this.newWith(1, 2, 3);
        objects4.retainAll(mList(2));
        Verify.assertSize(1, objects4);
        Verify.assertContainsAll(objects4, 2);
        MutableList<Integer> objects5 = this.newWith(1, 2, 3);
        objects5.retainAll(mList());
        Verify.assertEmpty(objects5);
        MutableList<Integer> objects6 = this.newWith(1, 2, 3);
        objects6.retainAll(mList(1, 2, 3));
        Verify.assertSize(3, objects6);
        Verify.assertContainsAll(objects6, 1, 2, 3);
    }

    @Override
    @Test
    public void retainAllIterable() {
        super.retainAllIterable();
        MutableList<Integer> objects = this.newWith(1, 2, 3);
        objects.retainAllIterable(iList(1, 2));
        Verify.assertSize(2, objects);
        Verify.assertContainsAll(objects, 1, 2);
        MutableList<Integer> objects2 = this.newWith(1, 2, 3);
        objects2.retainAllIterable(iList(1));
        Verify.assertSize(1, objects2);
        Verify.assertContainsAll(objects2, 1);
        MutableList<Integer> objects3 = this.newWith(1, 2, 3);
        objects3.retainAllIterable(iList(3));
        Verify.assertSize(1, objects3);
        Verify.assertContainsAll(objects3, 3);
        MutableList<Integer> objects4 = this.newWith(1, 2, 3);
        objects4.retainAllIterable(iList(2));
        Verify.assertSize(1, objects4);
        Verify.assertContainsAll(objects4, 2);
        MutableList<Integer> objects5 = this.newWith(1, 2, 3);
        objects5.retainAllIterable(iList());
        Verify.assertEmpty(objects5);
        MutableList<Integer> objects6 = this.newWith(1, 2, 3);
        objects6.retainAllIterable(iList(1, 2, 3));
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
    public void distinct() {
        super.distinct();
        Verify.assertListsEqual(this.newWith(5, 2, 3, 5, 4, 2).distinct(), this.newWith(5, 2, 3, 4));
        Verify.assertListsEqual(Interval.fromTo(1, 5).toList().distinct(), this.newWith(1, 2, 3, 4, 5));
    }

    @Override
    @Test
    public void serialization() {
        MutableList<Integer> collection = this.newWith(1, 2, 3, 4, 5);
        MutableList<Integer> deserializedCollection = SerializeTestHelper.serializeDeserialize(collection);
        Verify.assertSize(5, deserializedCollection);
        Verify.assertStartsWith(deserializedCollection, 1, 2, 3, 4, 5);
        Verify.assertListsEqual(collection, deserializedCollection);
    }

    @Test
    public void testSerializationOfEmpty() {
        MutableList<Integer> collection = FastList.newList();
        Verify.assertPostSerializedEqualsAndHashCode(collection);
    }

    @Test
    public void testSerializationOfSublist() {
        MutableList<Integer> collection = this.newWith(1, 2, 3, 4, 5);
        MutableList<Integer> deserializedCollection = SerializeTestHelper.serializeDeserialize(collection.subList(0, 2));
        Verify.assertSize(2, deserializedCollection);
        Verify.assertStartsWith(deserializedCollection, 1, 2);
        Verify.assertListsEqual(collection.subList(0, 2), deserializedCollection);
    }

    @Test
    public void testSubList() {
        MutableList<String> collection = FastList.newListWith("1", "2", "3", "4", "5");
        MutableList<String> subList = collection.subList(1, 3);
        Verify.assertContainsAll(subList, "2", "3");
        subList.add("6");
        Verify.assertItemAtIndex("6", 2, subList);
        Verify.assertSize(6, collection);
        Verify.assertSize(3, subList);
        Verify.assertItemAtIndex("6", 3, collection);
        subList.remove("6");
        Verify.assertSize(5, collection);
        Verify.assertSize(2, subList);
    }

    @Test
    public void testBAOSSize() {
        MutableList<MutableList<Object>> mutableArrayList = FastList.<MutableList<Object>>newList().with(FastList.newList(), FastList.newList(), FastList.newList(), FastList.newList()).with(FastList.newList(), FastList.newList(), FastList.newList(), FastList.newList());
        List<List<Object>> arrayList = new ArrayList<>();
        Interval.oneTo(8).forEach(Procedures.cast(object -> arrayList.add(new ArrayList<>())));
        ByteArrayOutputStream stream2 = SerializeTestHelper.getByteArrayOutputStream(arrayList);
        Assert.assertEquals(194L, stream2.size());
        ByteArrayOutputStream stream1 = SerializeTestHelper.getByteArrayOutputStream(mutableArrayList);
        Assert.assertEquals(182L, stream1.size());
    }

    @Override
    @Test
    public void addAll() {
        super.addAll();
        MutableList<Integer> integers1 = FastList.newList();
        Assert.assertTrue(integers1.addAll(mList(1, 2, 3, 4)));
        Verify.assertListsEqual(FastList.newListWith(1, 2, 3, 4), integers1);
        Assert.assertTrue(integers1.addAll(FastList.<Integer>newList(4).with(1, 2, 3, 4)));
        Verify.assertListsEqual(FastList.newListWith(1, 2, 3, 4, 1, 2, 3, 4), integers1);
        Assert.assertTrue(integers1.addAll(mSet(5)));
        Verify.assertListsEqual(FastList.newListWith(1, 2, 3, 4, 1, 2, 3, 4, 5), integers1);
        MutableList<Integer> integers2 = FastList.newListWith(0);
        Assert.assertTrue(integers2.addAll(mList(1, 2, 3, 4)));
        Verify.assertListsEqual(FastList.newListWith(0, 1, 2, 3, 4), integers2);
        Assert.assertTrue(integers2.addAll(FastList.<Integer>newList(4).with(1, 2, 3, 4)));
        Verify.assertListsEqual(FastList.newListWith(0, 1, 2, 3, 4, 1, 2, 3, 4), integers2);
        Assert.assertTrue(integers2.addAll(mSet(5)));
        Verify.assertListsEqual(FastList.newListWith(0, 1, 2, 3, 4, 1, 2, 3, 4, 5), integers2);
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> FastList.newList().addAll(1, null));
    }

    @Override
    @Test
    public void addAllIterable() {
        super.addAllIterable();
        FastList<Integer> integers = FastList.newList();
        Assert.assertTrue(integers.addAllIterable(iList(1, 2, 3, 4)));
        Verify.assertListsEqual(FastList.newListWith(1, 2, 3, 4), integers);
        Assert.assertTrue(integers.addAllIterable(FastList.<Integer>newList(4).with(1, 2, 3, 4)));
        Verify.assertListsEqual(FastList.newListWith(1, 2, 3, 4, 1, 2, 3, 4), integers);
        Assert.assertTrue(integers.addAllIterable(mSet(5)));
        Verify.assertListsEqual(FastList.newListWith(1, 2, 3, 4, 1, 2, 3, 4, 5), integers);
    }

    @Test
    public void testAddAllEmpty() {
        FastList<Integer> integers = FastList.newList();
        integers.addAll(Lists.mutable.of());
        Verify.assertEmpty(integers);
        integers.addAll(Sets.mutable.of());
        Verify.assertEmpty(integers);
        integers.addAll(FastList.newList());
        Verify.assertEmpty(integers);
        integers.addAll(ArrayAdapter.newArray());
        Verify.assertEmpty(integers);
    }

    @Test
    public void addAllWithMultipleTypes() {
        FastList<Integer> list = FastList.newList();
        list.addAll(mList(1, 2, 3, 4));
        list.addAll(mSet(5, 6));
        list.addAll(new ArrayList<>(mList(7, 8)));
        list.addAll(this.newWith(9, 10));
        Assert.assertFalse(list.addAll(Lists.mutable.of()));
        Assert.assertEquals(this.newWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), list);
    }

    @Override
    @Test
    public void addAllAtIndex() {
        super.addAllAtIndex();
        FastList<Integer> integers = this.newWith(5);
        integers.addAll(0, mList(1, 2, 3, 4));
        Verify.assertStartsWith(integers, 1, 2, 3, 4, 5);
        integers.addAll(0, FastList.<Integer>newList(4).with(-3, -2, -1, 0));
        Verify.assertStartsWith(integers, -3, -2, -1, 0, 1, 2, 3, 4, 5);
    }

    @Test
    public void testAddAllAtIndexEmpty() {
        FastList<Integer> integers = this.newWith(5);
        integers.addAll(0, Lists.mutable.of());
        Verify.assertSize(1, integers);
        Verify.assertStartsWith(integers, 5);
        integers.addAll(0, FastList.newList(4));
        Verify.assertSize(1, integers);
        Verify.assertStartsWith(integers, 5);
        integers.addAll(0, Sets.mutable.of());
        Verify.assertSize(1, integers);
        Verify.assertStartsWith(integers, 5);
        FastList<String> zeroSizedList = FastList.newList(0);
        zeroSizedList.addAll(0, this.newWith("1", "2"));
    }

    @Override
    @Test
    public void addAtIndex() {
        FastList<Integer> integers = this.newWith(1, 2, 3, 5);
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
        FastList<Integer> midList = FastList.<Integer>newList(2).with(1, 3);
        midList.add(1, 2);
        Verify.assertStartsWith(midList, 1, 2, 3);
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> midList.add(-1, -1));
    }

    @Test
    public void testSubListSort() {
        MutableList<Integer> list = new FastList<>(Interval.from(0).to(20));
        MutableList<Integer> sorted = list.subList(2, 18).sortThis();
        Verify.assertListsEqual(sorted, Interval.from(2).to(17));
    }

    @Test
    public void testSubListOfSubList() {
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
    public void testSubListListIterator() {
        MutableList<String> list = this.newWith("A", "B", "C", "D");
        MutableList<String> subList = list.subList(0, 3);
        ListIterator<String> iterator = subList.listIterator();
        MutableList<String> newList = FastList.newList();
        while (iterator.hasNext()) {
            newList.add(iterator.next());
        }
        Verify.assertSize(3, newList);
        while (iterator.hasPrevious()) {
            newList.remove(iterator.previous());
        }
        Verify.assertEmpty(newList);
        iterator.add("X");
        Verify.assertSize(4, subList);
    }

    @Test
    public void testSetAtIndex() {
        FastList<Integer> integers = this.newWith(1, 2, 3, 5);
        Assert.assertEquals(Integer.valueOf(5), integers.set(3, 4));
        Verify.assertStartsWith(integers, 1, 2, 3, 4);
    }

    @Override
    @Test
    public void indexOf() {
        FastList<Integer> integers = this.newWith(1, 2, 3, 4);
        Assert.assertEquals(2, integers.indexOf(3));
        Assert.assertEquals(-1, integers.indexOf(0));
        Assert.assertEquals(-1, integers.indexOf(null));
        FastList<Integer> integers2 = FastList.<Integer>newList(4).with(null, 2, 3, 4);
        Assert.assertEquals(0, integers2.indexOf(null));
    }

    @Override
    @Test
    public void lastIndexOf() {
        FastList<Integer> integers = FastList.<Integer>newList(4).with(1, 2, 3, 4);
        Assert.assertEquals(2, integers.lastIndexOf(3));
        Assert.assertEquals(-1, integers.lastIndexOf(0));
        Assert.assertEquals(-1, integers.lastIndexOf(null));
        FastList<Integer> integers2 = FastList.<Integer>newList(4).with(null, 2, 3, 4);
        Assert.assertEquals(0, integers2.lastIndexOf(null));
    }

    @Test
    public void testOutOfBoundsCondition() {
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
        Verify.assertListsEqual(integers, clone);
        Verify.assertInstanceOf(FastList.class, clone);
        Assert.assertEquals(FastList.newList(), FastList.newList().clone());
        Assert.assertEquals(FastList.newList(0), FastList.newList().clone());
    }

    @Override
    @Test
    public void toArray() {
        Object[] typelessArray = this.newWith(1, 2, 3, 4).toArray();
        Assert.assertArrayEquals(typelessArray, new Object[] { 1, 2, 3, 4 });
        Integer[] typedArray = this.newWith(1, 2, 3, 4).toArray(new Integer[0]);
        Assert.assertArrayEquals(typedArray, new Integer[] { 1, 2, 3, 4 });
        Integer[] typedArray2 = this.newWith(1, 2, 3, 4).toArray(new Integer[5]);
        Assert.assertArrayEquals(typedArray2, new Integer[] { 1, 2, 3, 4, null });
        Integer[] typedArray3 = this.newWith(1, 2, 3, 4).toTypedArray(Integer.class);
        Assert.assertArrayEquals(typedArray3, new Integer[] { 1, 2, 3, 4 });
    }

    @Override
    @Test
    public void testToString() {
        FastList<Integer> integers = this.newWith(1, 2, 3, 4);
        Assert.assertNotNull(integers.toString());
        Assert.assertEquals("[1, 2, 3, 4]", integers.toString());
    }

    @Test
    public void toStringRecursion() {
        MutableList<Object> list = FastList.newListWith(1, 2, 3);
        list.add(list);
        Assert.assertEquals("[1, 2, 3, (this FastList)]", list.toString());
    }

    @Test
    public void makeStringRecursion() {
        MutableList<Object> list = FastList.newListWith(1, 2, 3);
        list.add(list);
        Assert.assertEquals("1, 2, 3, (this FastList)", list.makeString());
    }

    @Test
    public void testTrimToSize() {
        FastList<Integer> integers = this.newWith(1, 2, 3, 4);
        integers.trimToSize();
        Assert.assertEquals("[1, 2, 3, 4]", integers.toString());
    }

    @Test
    public void testTrimToSizeWithLoadFactory() {
        FastList<Integer> integers = FastList.<Integer>newList(10).with(1, 2, 3, 4);
        Assert.assertFalse(integers.trimToSizeIfGreaterThanPercent(0.70));
        Assert.assertTrue(integers.trimToSizeIfGreaterThanPercent(0.10));
        Assert.assertEquals("[1, 2, 3, 4]", integers.toString());
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        FastList<Integer> integers = FastList.<Integer>newList(3).with(1, 2, 3);
        FastList<Integer> integers2 = this.newWith(1, 2, 3);
        FastList<Integer> integers3 = this.newWith(1, null, 3, 4, 5);
        FastList<Integer> integers4 = this.newWith(1, null, 3, 4, 5);
        FastList<Integer> integers5 = this.newWith(1, null, 3);
        List<Integer> linkedList = new LinkedList<>(integers);
        List<Integer> linkedList2 = new LinkedList<>(integers3);
        List<Integer> linkedList3 = new LinkedList<>(integers5);
        Verify.assertEqualsAndHashCode(integers, integers);
        Verify.assertPostSerializedEqualsAndHashCode(integers);
        Verify.assertEqualsAndHashCode(integers, integers2);
        Verify.assertEqualsAndHashCode(integers, iList(1, 2, 3));
        Verify.assertEqualsAndHashCode(integers, linkedList);
        Assert.assertNotEquals(integers, integers3);
        Assert.assertNotEquals(integers, integers5);
        Assert.assertNotEquals(integers, iList(2, 3, 4));
        Assert.assertNotEquals(integers, linkedList2);
        Assert.assertNotEquals(integers, linkedList3);
        Assert.assertNotEquals(integers, mSet());
        Verify.assertEqualsAndHashCode(integers3, integers4);
        Verify.assertEqualsAndHashCode(integers3, new ArrayList<>(integers3));
        Verify.assertEqualsAndHashCode(integers3, new LinkedList<>(integers3));
        Verify.assertEqualsAndHashCode(integers3, ArrayAdapter.newArrayWith(1, null, 3, 4, 5));
        Assert.assertNotEquals(integers3, ArrayAdapter.newArrayWith(1, null, 3, 4, 6));
        Verify.assertEqualsAndHashCode(integers3, ArrayListAdapter.<Integer>newList().with(1, null, 3, 4, 5));
        Assert.assertEquals(integers, integers2);
        Assert.assertNotEquals(integers, integers3);
    }

    @Override
    @Test
    public void iterator() {
        int sum = 0;
        FastList<Integer> integers = this.newWith(1, 2, 3, 4);
        for (Integer each : integers) {
            sum += each.intValue();
        }
        Assert.assertEquals(10, sum);
    }

    @Override
    @Test
    public void removeObject() {
        super.removeObject();
        FastList<Integer> integers = this.newWith(1, 2, 3, 4);
        integers.remove(Integer.valueOf(1));
        Verify.assertStartsWith(integers, 2, 3, 4);
        Assert.assertFalse(integers.remove(Integer.valueOf(5)));
    }

    @Test
    public void testIteratorRemove() {
        FastList<Integer> integers = this.newWith(1, 2, 3, 4);
        Iterator<Integer> iterator = integers.iterator();
        iterator.next();
        iterator.remove();
        Verify.assertStartsWith(integers, 2, 3, 4);
    }

    @Override
    @Test
    public void toList() {
        FastList<Integer> integers = this.newWith(1, 2, 3, 4);
        MutableList<Integer> list = integers.toList();
        Verify.assertStartsWith(list, 1, 2, 3, 4);
    }

    @Override
    @Test
    public void toSet() {
        FastList<Integer> integers = this.newWith(1, 2, 3, 4);
        MutableSet<Integer> set = integers.toSet();
        Verify.assertContainsAll(set, 1, 2, 3, 4);
    }

    @Test
    public void testSortOnListWithLessThan10Elements() {
        FastList<Integer> integers = this.newWith(2, 3, 4, 1, 7, 9, 6, 8, 5);
        Verify.assertStartsWith(integers.sortThis(), 1, 2, 3, 4, 5, 6, 7, 8, 9);
        FastList<Integer> integers2 = this.newWith(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Verify.assertStartsWith(integers2.sortThis(Collections.reverseOrder()), 9, 8, 7, 6, 5, 4, 3, 2, 1);
        FastList<Integer> integers3 = this.newWith(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Verify.assertStartsWith(integers3.sortThis(), 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    public void testSort() {
        for (int i = 1; i < 25; i++) {
            FastList<Integer> actual = FastList.newList(Interval.oneTo(i));
            for (int j = 0; j < 3; j++) {
                actual.shuffleThis();
                Assert.assertEquals(Interval.oneTo(i), actual.sortThis());
                Assert.assertEquals(Interval.oneTo(i).reverseThis(), actual.sortThis(Collections.reverseOrder()));
            }
        }
    }

    @Test
    public void testNewListWithCollection() {
        Verify.assertEmpty(FastList.newList(iList()));
        Verify.assertEmpty(FastList.newList(mSet()));
        Verify.assertEmpty(FastList.newList(FastList.newList()));
        Verify.assertEmpty(FastList.newList(FastList.newList(4)));
        FastList<Integer> setToList = FastList.newList(mSet(1, 2, 3, 4, 5));
        Verify.assertNotEmpty(setToList);
        Verify.assertSize(5, setToList);
        Verify.assertContainsAll(setToList, 1, 2, 3, 4, 5);
        FastList<Integer> arrayListToList = FastList.newList(iList(1, 2, 3, 4, 5));
        Verify.assertNotEmpty(arrayListToList);
        Verify.assertSize(5, arrayListToList);
        Verify.assertStartsWith(arrayListToList, 1, 2, 3, 4, 5);
        FastList<Integer> fastListToList = FastList.newList(this.newWith(1, 2, 3, 4, 5));
        Verify.assertNotEmpty(fastListToList);
        Verify.assertSize(5, fastListToList);
        Verify.assertStartsWith(fastListToList, 1, 2, 3, 4, 5);
    }

    @Test
    public void testNewListWithIterable() {
        FastList<Integer> integers = FastList.newList(Interval.oneTo(3));
        Assert.assertEquals(this.newWith(1, 2, 3), integers);
    }

    @Test
    public void testContainsAll() {
        FastList<Integer> list = this.newWith(1, 2, 3, 4, 5, null);
        Assert.assertTrue(list.containsAll(mList(1, 3, 5, null)));
        Assert.assertFalse(list.containsAll(mList(2, null, 6)));
        Assert.assertTrue(list.containsAll(this.newWith(1, 3, 5, null)));
        Assert.assertFalse(list.containsAll(this.newWith(2, null, 6)));
    }

    @Test
    public void testToArrayFromTo() {
        Assert.assertArrayEquals(new Integer[] { 1, 2, 3 }, this.newWith(1, 2, 3, 4).toArray(0, 2));
        Assert.assertArrayEquals(new Integer[] { 2, 3, 4 }, this.newWith(1, 2, 3, 4).toArray(1, 3));
    }

    @Test
    public void testLazyCollectForEach() {
        LazyIterable<String> select = FastList.newList(Interval.oneTo(5)).asLazy().collect(Object::toString);
        Procedure<String> builder = Procedures.append(new StringBuilder());
        select.forEach(builder);
        Assert.assertEquals("12345", builder.toString());
    }

    @Test
    public void testLazyFlattenForEach() {
        MutableList<Integer> list = new FastList<>(Interval.oneTo(5));
        LazyIterable<String> select = LazyIterate.flatCollect(list, object -> this.newWith(String.valueOf(object)));
        Appendable builder = new StringBuilder();
        Procedure<String> appendProcedure = Procedures.append(builder);
        select.forEach(appendProcedure);
        Assert.assertEquals("12345", builder.toString());
    }

    /**
     * @deprecated since 3.0. Use {@code asLazy().reject(Predicate)} instead.
     */
    @Deprecated
    @Test
    public void testLazyRejectForEach() {
        LazyIterable<Integer> select = FastList.newList(Interval.oneTo(5)).asLazy().reject(Predicates.lessThan(5));
        Sum sum = new IntegerSum(0);
        select.forEach(new SumProcedure<>(sum));
        Assert.assertEquals(5, sum.getValue().intValue());
    }

    /**
     * @deprecated since 3.0. Use {@code asLazy().select(Predicate)} instead.
     */
    @Deprecated
    @Test
    public void testLazySelectForEach() {
        LazyIterable<Integer> select = FastList.newList(Interval.oneTo(5)).asLazy().select(Predicates.lessThan(5));
        Sum sum = new IntegerSum(0);
        select.forEach(new SumProcedure<>(sum));
        Assert.assertEquals(10, sum.getValue().intValue());
    }

    @Test
    public void testWith() {
        Assert.assertEquals(FastList.newListWith("1"), FastList.<String>newList().with("1"));
        Assert.assertEquals(FastList.newListWith("1", "2"), FastList.<String>newList().with("1", "2"));
        Assert.assertEquals(FastList.newListWith("1", "2", "3"), FastList.<String>newList().with("1", "2", "3"));
        Assert.assertEquals(FastList.newListWith("1", "2", "3", "4"), FastList.<String>newList().with("1", "2", "3", "4"));
        Assert.assertEquals(FastList.newListWith("1", "2", "3", "4", "5", "6", "7", "8"), FastList.<String>newList().with("1", "2", "3", "4").with("5", "6", "7", "8"));
        MutableList<String> list = FastList.newListWith("A").withAll(Lists.immutable.of("1", "2")).withAll(Lists.immutable.of()).withAll(Sets.immutable.of("3", "4"));
        Assert.assertEquals(Bags.mutable.of("A", "1", "2", "3", "4"), list.toBag());
        // "3" and "4" are from a set, so may not be in order
        Verify.assertStartsWith(list, "A", "1", "2");
        Assert.assertEquals(FastList.newListWith(42, 10, 11, 12), FastList.newListWith(42).withAll(Interval.from(10).to(12).toList()));
    }

    @Test
    public void unoptimizedListToImmutable() {
        FastList<String> list = FastList.newListWith("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15");
        ImmutableList<String> immutableList = list.toImmutable();
        Verify.assertIterablesEqual(immutableList, list);
    }

    @Test(expected = NoSuchElementException.class)
    public void min_empty_throws_without_comparator() {
        this.newWith().min();
    }

    @Test(expected = NoSuchElementException.class)
    public void max_empty_throws_without_comparator() {
        this.newWith().max();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeInitialCapacity() {
        new FastList<>(-1);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FastListTest instance;

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
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIfWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIfWith);
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
        public void benchmark_distinctWithHashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctWithHashingStrategy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctBy);
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
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
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
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
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
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
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
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withNValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withNValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_constructorWithCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.constructorWithCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testFastListNewWithContainsAllItems() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testFastListNewWithContainsAllItems);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAddWithZeroBasedConstructor() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAddWithZeroBasedConstructor);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getBatchCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getBatchCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_wrapCopy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.wrapCopy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_fastListProperSuperSetOfArrayList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.fastListProperSuperSetOfArrayList);
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
        public void benchmark_testInjectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testInjectIntoDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testInjectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testInjectIntoFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testInjectIntoString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testInjectIntoString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testInjectIntoMaxString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testInjectIntoMaxString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testInjectIntoMinString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testInjectIntoMinString);
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
        public void benchmark_testForEachInBoth() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testForEachInBoth);
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
        public void benchmark_testDetectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testDetectWithIfNone);
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
        public void benchmark_testForEachIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testForEachIf);
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
        public void benchmark_testRemoveUsingPredicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testRemoveUsingPredicate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testRemoveAllWithWeakReference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testRemoveAllWithWeakReference);
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
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSerializationOfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSerializationOfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSerializationOfSublist() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSerializationOfSublist);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSubList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSubList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testBAOSSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testBAOSSize);
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
        public void benchmark_testAddAllEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAddAllEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllWithMultipleTypes() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllWithMultipleTypes);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAddAllAtIndexEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAddAllAtIndexEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSubListSort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSubListSort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSubListOfSubList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSubListOfSubList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSubListListIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSubListListIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSetAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSetAtIndex);
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
        public void benchmark_testOutOfBoundsCondition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testOutOfBoundsCondition);
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
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStringRecursion() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStringRecursion);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringRecursion() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringRecursion);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testTrimToSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testTrimToSize);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testTrimToSizeWithLoadFactory() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testTrimToSizeWithLoadFactory);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testIteratorRemove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testIteratorRemove);
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
        public void benchmark_testSortOnListWithLessThan10Elements() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSortOnListWithLessThan10Elements);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewListWithCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewListWithCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewListWithIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewListWithIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testContainsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testContainsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToArrayFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToArrayFromTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testLazyCollectForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testLazyCollectForEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testLazyFlattenForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testLazyFlattenForEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testLazyRejectForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testLazyRejectForEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testLazySelectForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testLazySelectForEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unoptimizedListToImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.unoptimizedListToImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNegativeInitialCapacity() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNegativeInitialCapacity);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> payload) throws java.lang.Throwable {
            this.instance = new FastListTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> randomAccess_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> getFirstOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> getLastOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> detectLastIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> newListWithSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> forEachFromToInReverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> reverseForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> reverseForEach_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> reverseForEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> reverseForEachWithIndex_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> distinctWithHashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> distinctBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> removeIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> withMethods;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sortThis_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sortThis_small;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sortThis_large;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sortThis_with_comparator_small;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sortThis_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sortThis_with_comparator_large;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sortThisBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sortThisByBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sortThisByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sortThisByChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sortThisByByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sortThisByShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sortThisByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sortThisByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sortThisByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> forEachWithIndexWithFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> forEachWithIndexWithFromToInReverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sortThisWithNullWithNoComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toSortedListWithNullWithNoComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> forEachOnRange;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> forEachWithIndexOnRange;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> subListFromOutOfBoundsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> subListToGreaterThanSizeException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> subListFromGreaterThanToException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> getWithIndexOutOfBoundsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> getWithArrayIndexOutOfBoundsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> listIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> listIteratorIndexTooSmall;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> listIteratorIndexTooBig;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> asReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> binarySearch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> binarySearchWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> forEachInBoth;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> forEachInBothThrowsOnDifferentListSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> forEachInBothThrowsOnNullList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> replaceAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> sort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> withNValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> constructorWithCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testFastListNewWithContainsAllItems;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testAddWithZeroBasedConstructor;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> getBatchCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> wrapCopy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> fastListProperSuperSetOfArrayList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testInjectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testInjectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testInjectIntoString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testInjectIntoMaxString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testInjectIntoMinString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testForEachInBoth;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testDetectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testForEachIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testRemoveUsingPredicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testRemoveAllWithWeakReference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testSerializationOfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testSerializationOfSublist;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testSubList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testBAOSSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testAddAllEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> addAllWithMultipleTypes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testAddAllAtIndexEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testSubListSort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testSubListOfSubList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testSubListListIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testSetAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testOutOfBoundsCondition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toStringRecursion;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> makeStringRecursion;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testTrimToSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testTrimToSizeWithLoadFactory;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testIteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testSortOnListWithLessThan10Elements;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testSort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testNewListWithCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testNewListWithIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testContainsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testToArrayFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testLazyCollectForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testLazyFlattenForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testLazyRejectForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testLazySelectForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> unoptimizedListToImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListTest> testNegativeInitialCapacity;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = FastListTest::testNewCollection;
            this.payloads.contains = FastListTest::contains;
            this.payloads.containsBy = FastListTest::containsBy;
            this.payloads.containsAllIterable = FastListTest::containsAllIterable;
            this.payloads.containsAnyIterable = FastListTest::containsAnyIterable;
            this.payloads.containsNoneIterable = FastListTest::containsNoneIterable;
            this.payloads.containsAllArray = FastListTest::containsAllArray;
            this.payloads.containsAnyCollection = FastListTest::containsAnyCollection;
            this.payloads.containsNoneCollection = FastListTest::containsNoneCollection;
            this.payloads.containsAllCollection = FastListTest::containsAllCollection;
            this.payloads.tap = FastListTest::tap;
            this.payloads.selectWith_target = FastListTest::selectWith_target;
            this.payloads.rejectWith_target = FastListTest::rejectWith_target;
            this.payloads.selectInstancesOf = FastListTest::selectInstancesOf;
            this.payloads.collectTarget = FastListTest::collectTarget;
            this.payloads.collectBoolean = FastListTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = FastListTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = FastListTest::collectBooleanWithBagTarget;
            this.payloads.collectByte = FastListTest::collectByte;
            this.payloads.collectByteWithTarget = FastListTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = FastListTest::collectByteWithBagTarget;
            this.payloads.collectChar = FastListTest::collectChar;
            this.payloads.collectCharWithTarget = FastListTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = FastListTest::collectCharWithBagTarget;
            this.payloads.collectDouble = FastListTest::collectDouble;
            this.payloads.collectDoubleWithTarget = FastListTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = FastListTest::collectDoubleWithBagTarget;
            this.payloads.collectFloat = FastListTest::collectFloat;
            this.payloads.collectFloatWithTarget = FastListTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = FastListTest::collectFloatWithBagTarget;
            this.payloads.collectInt = FastListTest::collectInt;
            this.payloads.collectIntWithTarget = FastListTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = FastListTest::collectIntWithBagTarget;
            this.payloads.collectLong = FastListTest::collectLong;
            this.payloads.collectLongWithTarget = FastListTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = FastListTest::collectLongWithBagTarget;
            this.payloads.collectShort = FastListTest::collectShort;
            this.payloads.collectShortWithTarget = FastListTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = FastListTest::collectShortWithBagTarget;
            this.payloads.flatCollect = FastListTest::flatCollect;
            this.payloads.flatCollectWith = FastListTest::flatCollectWith;
            this.payloads.flatCollectBoolean = FastListTest::flatCollectBoolean;
            this.payloads.flatCollectByte = FastListTest::flatCollectByte;
            this.payloads.flatCollectShort = FastListTest::flatCollectShort;
            this.payloads.flatCollectInt = FastListTest::flatCollectInt;
            this.payloads.flatCollectChar = FastListTest::flatCollectChar;
            this.payloads.flatCollectLong = FastListTest::flatCollectLong;
            this.payloads.flatCollectDouble = FastListTest::flatCollectDouble;
            this.payloads.flatCollectFloat = FastListTest::flatCollectFloat;
            this.payloads.detectOptional = FastListTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = FastListTest::min;
            this.payloads.minOptional = FastListTest::minOptional;
            this.payloads.max = FastListTest::max;
            this.payloads.maxOptional = FastListTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = FastListTest::min_without_comparator;
            this.payloads.max_without_comparator = FastListTest::max_without_comparator;
            this.payloads.min_null_safe = FastListTest::min_null_safe;
            this.payloads.max_null_safe = FastListTest::max_null_safe;
            this.payloads.minBy = FastListTest::minBy;
            this.payloads.minByOptional = FastListTest::minByOptional;
            this.payloads.maxBy = FastListTest::maxBy;
            this.payloads.maxByOptional = FastListTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWithOptional = FastListTest::detectWithOptional;
            this.payloads.detectWithIfNoneBlock = FastListTest::detectWithIfNoneBlock;
            this.payloads.collectWith_target = FastListTest::collectWith_target;
            this.payloads.getAny = FastListTest::getAny;
            this.payloads.getOnly = FastListTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectIntoInt = FastListTest::injectIntoInt;
            this.payloads.injectIntoLong = FastListTest::injectIntoLong;
            this.payloads.injectIntoDouble = FastListTest::injectIntoDouble;
            this.payloads.injectIntoFloat = FastListTest::injectIntoFloat;
            this.payloads.sumFloat = FastListTest::sumFloat;
            this.payloads.summarizeFloat = FastListTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = FastListTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = FastListTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = FastListTest::sumDouble;
            this.payloads.summarizeDouble = FastListTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = FastListTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = FastListTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = FastListTest::sumInteger;
            this.payloads.summarizeInt = FastListTest::summarizeInt;
            this.payloads.sumLong = FastListTest::sumLong;
            this.payloads.summarizeLong = FastListTest::summarizeLong;
            this.payloads.sumByInt = FastListTest::sumByInt;
            this.payloads.sumByFloat = FastListTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = FastListTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = FastListTest::sumByLong;
            this.payloads.sumByDouble = FastListTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = FastListTest::sumByDoubleConsistentRounding;
            this.payloads.partition = FastListTest::partition;
            this.payloads.partitionWith = FastListTest::partitionWith;
            this.payloads.toImmutableList = FastListTest::toImmutableList;
            this.payloads.toCollection = FastListTest::toCollection;
            this.payloads.toBag = FastListTest::toBag;
            this.payloads.toImmutableBag = FastListTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = FastListTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = FastListTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = FastListTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = FastListTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = FastListTest::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = FastListTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = FastListTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = FastListTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = FastListTest::toSortedBagBy;
            this.payloads.toImmutableSortedBagBy = FastListTest::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = FastListTest::toSortedListBy;
            this.payloads.toImmutableSortedListBy = FastListTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = FastListTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = FastListTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = FastListTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = FastListTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = FastListTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = FastListTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSet = FastListTest::toImmutableSet;
            this.payloads.toMap = FastListTest::toMap;
            this.payloads.toImmutableMap = FastListTest::toImmutableMap;
            this.payloads.toMapTarget = FastListTest::toMapTarget;
            this.payloads.toSortedMap = FastListTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = FastListTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = FastListTest::toSortedMapBy;
            this.payloads.toBiMap = FastListTest::toBiMap;
            this.payloads.toImmutableBiMap = FastListTest::toImmutableBiMap;
            this.payloads.fusedCollectMakeString = FastListTest::fusedCollectMakeString;
            this.payloads.appendStringThrows = FastListTest::appendStringThrows;
            this.payloads.countBy = FastListTest::countBy;
            this.payloads.countByWith = FastListTest::countByWith;
            this.payloads.countByEach = FastListTest::countByEach;
            this.payloads.groupBy = FastListTest::groupBy;
            this.payloads.groupByEach = FastListTest::groupByEach;
            this.payloads.groupByUniqueKey = FastListTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = FastListTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = FastListTest::zip;
            this.payloads.zipWithIndex = FastListTest::zipWithIndex;
            this.payloads.chunk_empty = FastListTest::chunk_empty;
            this.payloads.chunk_single = FastListTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = FastListTest::chunk_large_size;
            this.payloads.empty = FastListTest::empty;
            this.payloads.notEmpty = FastListTest::notEmpty;
            this.payloads.aggregateByMutating = FastListTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = FastListTest::aggregateByNonMutating;
            this.payloads.reduceOptional = FastListTest::reduceOptional;
            this.payloads.testNewWith = FastListTest::testNewWith;
            this.payloads.testNewWithWith = FastListTest::testNewWithWith;
            this.payloads.testNewWithWithWith = FastListTest::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = FastListTest::testNewWithVarArgs;
            this.payloads.removeAll = FastListTest::removeAll;
            this.payloads.removeIfWith = FastListTest::removeIfWith;
            this.payloads.with = FastListTest::with;
            this.payloads.withAll = FastListTest::withAll;
            this.payloads.without = FastListTest::without;
            this.payloads.withoutAll = FastListTest::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = FastListTest::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = FastListTest::asLazy;
            this.payloads.randomAccess_throws = FastListTest::randomAccess_throws;
            this.payloads.getFirstOptional = FastListTest::getFirstOptional;
            this.payloads.getLastOptional = FastListTest::getLastOptional;
            this.payloads.detectIndex = FastListTest::detectIndex;
            this.payloads.detectLastIndex = FastListTest::detectLastIndex;
            this.payloads.collectWithIndex = FastListTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = FastListTest::collectWithIndexWithTarget;
            this.payloads.selectWithIndex = FastListTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = FastListTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = FastListTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = FastListTest::rejectWithIndexWithTarget;
            this.payloads.asSynchronized = FastListTest::asSynchronized;
            this.payloads.toImmutable = FastListTest::toImmutable;
            this.payloads.asUnmodifiable = FastListTest::asUnmodifiable;
            this.payloads.newListWithSize = FastListTest::newListWithSize;
            this.payloads.corresponds = FastListTest::corresponds;
            this.payloads.forEachFromTo = FastListTest::forEachFromTo;
            this.payloads.forEachFromToInReverse = FastListTest::forEachFromToInReverse;
            this.payloads.reverseForEach = FastListTest::reverseForEach;
            this.payloads.reverseForEach_emptyList = FastListTest::reverseForEach_emptyList;
            this.payloads.reverseForEachWithIndex = FastListTest::reverseForEachWithIndex;
            this.payloads.reverseForEachWithIndex_emptyList = FastListTest::reverseForEachWithIndex_emptyList;
            this.payloads.reverseThis = FastListTest::reverseThis;
            this.payloads.toReversed = FastListTest::toReversed;
            this.payloads.distinctWithHashingStrategy = FastListTest::distinctWithHashingStrategy;
            this.payloads.distinctBy = FastListTest::distinctBy;
            this.payloads.removeIf = FastListTest::removeIf;
            this.payloads.removeIndex = FastListTest::removeIndex;
            this.payloads.set = FastListTest::set;
            this.payloads.withMethods = FastListTest::withMethods;
            this.payloads.sortThis_with_null = FastListTest::sortThis_with_null;
            this.payloads.sortThis_small = FastListTest::sortThis_small;
            this.payloads.sortThis = FastListTest::sortThis;
            this.payloads.sortThis_large = FastListTest::sortThis_large;
            this.payloads.sortThis_with_comparator_small = FastListTest::sortThis_with_comparator_small;
            this.payloads.sortThis_with_comparator = FastListTest::sortThis_with_comparator;
            this.payloads.sortThis_with_comparator_large = FastListTest::sortThis_with_comparator_large;
            this.payloads.sortThisBy = FastListTest::sortThisBy;
            this.payloads.sortThisByBoolean = FastListTest::sortThisByBoolean;
            this.payloads.sortThisByInt = FastListTest::sortThisByInt;
            this.payloads.sortThisByChar = FastListTest::sortThisByChar;
            this.payloads.sortThisByByte = FastListTest::sortThisByByte;
            this.payloads.sortThisByShort = FastListTest::sortThisByShort;
            this.payloads.sortThisByFloat = FastListTest::sortThisByFloat;
            this.payloads.sortThisByLong = FastListTest::sortThisByLong;
            this.payloads.sortThisByDouble = FastListTest::sortThisByDouble;
            this.payloads.makeString = FastListTest::makeString;
            this.payloads.makeStringWithSeparator = FastListTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = FastListTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = FastListTest::appendString;
            this.payloads.appendStringWithSeparator = FastListTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = FastListTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.forEachWithIndexWithFromTo = FastListTest::forEachWithIndexWithFromTo;
            this.payloads.forEachWithIndexWithFromToInReverse = FastListTest::forEachWithIndexWithFromToInReverse;
            this.payloads.sortThisWithNullWithNoComparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::sortThisWithNullWithNoComparator, java.lang.NullPointerException.class);
            this.payloads.sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements, java.lang.NullPointerException.class);
            this.payloads.toSortedListWithNullWithNoComparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::toSortedListWithNullWithNoComparator, java.lang.NullPointerException.class);
            this.payloads.toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements, java.lang.NullPointerException.class);
            this.payloads.forEachOnRange = FastListTest::forEachOnRange;
            this.payloads.forEachWithIndexOnRange = FastListTest::forEachWithIndexOnRange;
            this.payloads.subList = FastListTest::subList;
            this.payloads.subListFromOutOfBoundsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::subListFromOutOfBoundsException, java.lang.IndexOutOfBoundsException.class);
            this.payloads.subListToGreaterThanSizeException = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::subListToGreaterThanSizeException, java.lang.IndexOutOfBoundsException.class);
            this.payloads.subListFromGreaterThanToException = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::subListFromGreaterThanToException, java.lang.IllegalArgumentException.class);
            this.payloads.getWithIndexOutOfBoundsException = FastListTest::getWithIndexOutOfBoundsException;
            this.payloads.getWithArrayIndexOutOfBoundsException = FastListTest::getWithArrayIndexOutOfBoundsException;
            this.payloads.listIterator = FastListTest::listIterator;
            this.payloads.listIteratorIndexTooSmall = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::listIteratorIndexTooSmall, java.lang.IndexOutOfBoundsException.class);
            this.payloads.listIteratorIndexTooBig = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::listIteratorIndexTooBig, java.lang.IndexOutOfBoundsException.class);
            this.payloads.chunk = FastListTest::chunk;
            this.payloads.toStack = FastListTest::toStack;
            this.payloads.take = FastListTest::take;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = FastListTest::takeWhile;
            this.payloads.drop = FastListTest::drop;
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::drop_throws, java.lang.IllegalArgumentException.class);
            this.payloads.dropWhile = FastListTest::dropWhile;
            this.payloads.partitionWhile = FastListTest::partitionWhile;
            this.payloads.asReversed = FastListTest::asReversed;
            this.payloads.binarySearch = FastListTest::binarySearch;
            this.payloads.binarySearchWithComparator = FastListTest::binarySearchWithComparator;
            this.payloads.forEachInBoth = FastListTest::forEachInBoth;
            this.payloads.forEachInBothThrowsOnDifferentListSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::forEachInBothThrowsOnDifferentListSizes, java.lang.IllegalArgumentException.class);
            this.payloads.forEachInBothThrowsOnNullList = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::forEachInBothThrowsOnNullList, java.lang.NullPointerException.class);
            this.payloads.replaceAll = FastListTest::replaceAll;
            this.payloads.sort = FastListTest::sort;
            this.payloads.newEmpty = FastListTest::newEmpty;
            this.payloads.withNValues = FastListTest::withNValues;
            this.payloads.constructorWithCollection = FastListTest::constructorWithCollection;
            this.payloads.testFastListNewWithContainsAllItems = FastListTest::testFastListNewWithContainsAllItems;
            this.payloads.testAddWithZeroBasedConstructor = FastListTest::testAddWithZeroBasedConstructor;
            this.payloads.getBatchCount = FastListTest::getBatchCount;
            this.payloads.remove = FastListTest::remove;
            this.payloads.wrapCopy = FastListTest::wrapCopy;
            this.payloads.fastListProperSuperSetOfArrayList = FastListTest::fastListProperSuperSetOfArrayList;
            this.payloads.forEach = FastListTest::forEach;
            this.payloads.injectInto = FastListTest::injectInto;
            this.payloads.testInjectIntoDouble = FastListTest::testInjectIntoDouble;
            this.payloads.testInjectIntoFloat = FastListTest::testInjectIntoFloat;
            this.payloads.testInjectIntoString = FastListTest::testInjectIntoString;
            this.payloads.testInjectIntoMaxString = FastListTest::testInjectIntoMaxString;
            this.payloads.testInjectIntoMinString = FastListTest::testInjectIntoMinString;
            this.payloads.collect = FastListTest::collect;
            this.payloads.forEachWithIndex = FastListTest::forEachWithIndex;
            this.payloads.testForEachInBoth = FastListTest::testForEachInBoth;
            this.payloads.detect = FastListTest::detect;
            this.payloads.detectWith = FastListTest::detectWith;
            this.payloads.testDetectWithIfNone = FastListTest::testDetectWithIfNone;
            this.payloads.select = FastListTest::select;
            this.payloads.selectWith = FastListTest::selectWith;
            this.payloads.rejectWith = FastListTest::rejectWith;
            this.payloads.selectAndRejectWith = FastListTest::selectAndRejectWith;
            this.payloads.anySatisfyWith = FastListTest::anySatisfyWith;
            this.payloads.anySatisfy = FastListTest::anySatisfy;
            this.payloads.allSatisfyWith = FastListTest::allSatisfyWith;
            this.payloads.allSatisfy = FastListTest::allSatisfy;
            this.payloads.noneSatisfy = FastListTest::noneSatisfy;
            this.payloads.noneSatisfyWith = FastListTest::noneSatisfyWith;
            this.payloads.count = FastListTest::count;
            this.payloads.countWith = FastListTest::countWith;
            this.payloads.detectIfNone = FastListTest::detectIfNone;
            this.payloads.forEachWith = FastListTest::forEachWith;
            this.payloads.testForEachIf = FastListTest::testForEachIf;
            this.payloads.getFirst = FastListTest::getFirst;
            this.payloads.getLast = FastListTest::getLast;
            this.payloads.isEmpty = FastListTest::isEmpty;
            this.payloads.collectIf = FastListTest::collectIf;
            this.payloads.collectWith = FastListTest::collectWith;
            this.payloads.injectIntoWith = FastListTest::injectIntoWith;
            this.payloads.testRemoveUsingPredicate = FastListTest::testRemoveUsingPredicate;
            this.payloads.removeAllIterable = FastListTest::removeAllIterable;
            this.payloads.testRemoveAllWithWeakReference = FastListTest::testRemoveAllWithWeakReference;
            this.payloads.retainAll = FastListTest::retainAll;
            this.payloads.retainAllIterable = FastListTest::retainAllIterable;
            this.payloads.reject = FastListTest::reject;
            this.payloads.distinct = FastListTest::distinct;
            this.payloads.serialization = FastListTest::serialization;
            this.payloads.testSerializationOfEmpty = FastListTest::testSerializationOfEmpty;
            this.payloads.testSerializationOfSublist = FastListTest::testSerializationOfSublist;
            this.payloads.testSubList = FastListTest::testSubList;
            this.payloads.testBAOSSize = FastListTest::testBAOSSize;
            this.payloads.addAll = FastListTest::addAll;
            this.payloads.addAllIterable = FastListTest::addAllIterable;
            this.payloads.testAddAllEmpty = FastListTest::testAddAllEmpty;
            this.payloads.addAllWithMultipleTypes = FastListTest::addAllWithMultipleTypes;
            this.payloads.addAllAtIndex = FastListTest::addAllAtIndex;
            this.payloads.testAddAllAtIndexEmpty = FastListTest::testAddAllAtIndexEmpty;
            this.payloads.addAtIndex = FastListTest::addAtIndex;
            this.payloads.testSubListSort = FastListTest::testSubListSort;
            this.payloads.testSubListOfSubList = FastListTest::testSubListOfSubList;
            this.payloads.testSubListListIterator = FastListTest::testSubListListIterator;
            this.payloads.testSetAtIndex = FastListTest::testSetAtIndex;
            this.payloads.indexOf = FastListTest::indexOf;
            this.payloads.lastIndexOf = FastListTest::lastIndexOf;
            this.payloads.testOutOfBoundsCondition = FastListTest::testOutOfBoundsCondition;
            this.payloads.clear = FastListTest::clear;
            this.payloads.testClone = FastListTest::testClone;
            this.payloads.toArray = FastListTest::toArray;
            this.payloads.testToString = FastListTest::testToString;
            this.payloads.toStringRecursion = FastListTest::toStringRecursion;
            this.payloads.makeStringRecursion = FastListTest::makeStringRecursion;
            this.payloads.testTrimToSize = FastListTest::testTrimToSize;
            this.payloads.testTrimToSizeWithLoadFactory = FastListTest::testTrimToSizeWithLoadFactory;
            this.payloads.equalsAndHashCode = FastListTest::equalsAndHashCode;
            this.payloads.iterator = FastListTest::iterator;
            this.payloads.removeObject = FastListTest::removeObject;
            this.payloads.testIteratorRemove = FastListTest::testIteratorRemove;
            this.payloads.toList = FastListTest::toList;
            this.payloads.toSet = FastListTest::toSet;
            this.payloads.testSortOnListWithLessThan10Elements = FastListTest::testSortOnListWithLessThan10Elements;
            this.payloads.testSort = FastListTest::testSort;
            this.payloads.testNewListWithCollection = FastListTest::testNewListWithCollection;
            this.payloads.testNewListWithIterable = FastListTest::testNewListWithIterable;
            this.payloads.testContainsAll = FastListTest::testContainsAll;
            this.payloads.testToArrayFromTo = FastListTest::testToArrayFromTo;
            this.payloads.testLazyCollectForEach = FastListTest::testLazyCollectForEach;
            this.payloads.testLazyFlattenForEach = FastListTest::testLazyFlattenForEach;
            this.payloads.testLazyRejectForEach = FastListTest::testLazyRejectForEach;
            this.payloads.testLazySelectForEach = FastListTest::testLazySelectForEach;
            this.payloads.testWith = FastListTest::testWith;
            this.payloads.unoptimizedListToImmutable = FastListTest::unoptimizedListToImmutable;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.testNegativeInitialCapacity = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListTest::testNegativeInitialCapacity, java.lang.IllegalArgumentException.class);
        }
    }
}
