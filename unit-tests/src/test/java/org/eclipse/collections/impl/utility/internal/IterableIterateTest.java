/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.utility.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.eclipse.collections.api.block.function.Function3;
import org.eclipse.collections.api.block.procedure.primitive.ObjectIntProcedure;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.tuple.Twin;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.factory.ObjectIntProcedures;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.block.function.MaxSizeFunction;
import org.eclipse.collections.impl.block.function.MinSizeFunction;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.math.IntegerSum;
import org.eclipse.collections.impl.math.Sum;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.Iterate;
import org.eclipse.collections.impl.utility.ListIterate;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iList;
import static org.eclipse.collections.impl.factory.Iterables.mList;

/**
 * JUnit test for {@link IterableIterate}.
 */
public class IterableIterateTest {

    @Test
    public void injectInto() {
        Iterable<Integer> iterable = new IterableAdapter<>(iList(1, 2, 3));
        Assert.assertEquals(1 + 1 + 2 + 3, Iterate.injectInto(1, iterable, AddFunction.INTEGER).intValue());
    }

    @Test
    public void injectIntoOver30() {
        MutableList<Integer> list = Lists.mutable.of();
        for (int i = 0; i < 31; i++) {
            list.add(1);
        }
        Iterable<Integer> iterable = new IterableAdapter<>(list);
        Assert.assertEquals(32, Iterate.injectInto(1, iterable, AddFunction.INTEGER).intValue());
    }

    @Test
    public void injectIntoDouble() {
        Iterable<Double> iterable = new IterableAdapter<>(iList(1.0, 2.0, 3.0));
        Assert.assertEquals(1.0 + 1.0 + 2.0 + 3.0, Iterate.injectInto(1.0, iterable, AddFunction.DOUBLE).doubleValue(), 0.0);
    }

    @Test
    public void injectIntoString() {
        Iterable<String> iterable = new IterableAdapter<>(iList("1", "2", "3"));
        Assert.assertEquals("0123", Iterate.injectInto("0", iterable, AddFunction.STRING));
    }

    @Test
    public void injectIntoMaxString() {
        Iterable<String> iterable = new IterableAdapter<>(iList("1", "12", "123"));
        Assert.assertEquals(3, Iterate.injectInto(Integer.MIN_VALUE, iterable, MaxSizeFunction.STRING).intValue());
    }

    @Test
    public void injectIntoMinString() {
        Iterable<String> iterable = new IterableAdapter<>(iList("1", "12", "123"));
        Assert.assertEquals(1, Iterate.injectInto(Integer.MAX_VALUE, iterable, MinSizeFunction.STRING).intValue());
    }

    @Test
    public void collect() {
        Iterable<Boolean> iterable = new IterableAdapter<>(iList(Boolean.TRUE, Boolean.FALSE, null));
        Collection<String> result = Iterate.collect(iterable, String::valueOf);
        Assert.assertEquals(iList("true", "false", "null"), result);
    }

    @Test
    public void collectWithTarget() {
        Iterable<Boolean> iterable = new IterableAdapter<>(iList(Boolean.TRUE, Boolean.FALSE, null));
        Collection<String> result = Iterate.collect(iterable, String::valueOf, FastList.newList());
        Assert.assertEquals(iList("true", "false", "null"), result);
    }

    @Test
    public void collectOver30() {
        Iterable<Integer> iterable = new IterableAdapter<>(Interval.oneTo(31));
        Collection<Class<?>> result = Iterate.collect(iterable, Object::getClass);
        Assert.assertEquals(Collections.nCopies(31, Integer.class), result);
    }

    private List<Integer> getIntegerList() {
        return Interval.toReverseList(1, 5);
    }

    @Test
    public void forEachWithIndex() {
        Iterable<Integer> iterable = new IterableAdapter<>(Iterate.sortThis(this.getIntegerList()));
        Iterate.forEachWithIndex(iterable, (object, index) -> Assert.assertEquals(index, object - 1));
    }

    @Test
    public void forEachWithIndexOver30() {
        Iterable<Integer> iterable = new IterableAdapter<>(Iterate.sortThis(Interval.oneTo(31).toList()));
        Iterate.forEachWithIndex(iterable, (object, index) -> Assert.assertEquals(index, object - 1));
    }

    @Test
    public void detect() {
        Iterable<Integer> iterable = new IterableAdapter<>(this.getIntegerList());
        Assert.assertEquals(1, Iterate.detect(iterable, Integer.valueOf(1)::equals).intValue());
        // noinspection CachedNumberConstructorCall,UnnecessaryBoxing
        Integer firstInt = new Integer(2);
        // noinspection CachedNumberConstructorCall,UnnecessaryBoxing
        Integer secondInt = new Integer(2);
        Assert.assertNotSame(firstInt, secondInt);
        ImmutableList<Integer> list2 = iList(1, firstInt, secondInt);
        Assert.assertSame(list2.get(1), Iterate.detect(list2, Integer.valueOf(2)::equals));
    }

    @Test
    public void detectOver30() {
        List<Integer> list = Interval.oneTo(31);
        Iterable<Integer> iterable = new IterableAdapter<>(list);
        Assert.assertEquals(1, Iterate.detect(iterable, Integer.valueOf(1)::equals).intValue());
    }

    @Test
    public void detectWith() {
        Iterable<Integer> iterable = new IterableAdapter<>(this.getIntegerList());
        Assert.assertEquals(1, Iterate.detectWith(iterable, Object::equals, 1).intValue());
        // noinspection CachedNumberConstructorCall,UnnecessaryBoxing
        Integer firstInt = new Integer(2);
        // noinspection CachedNumberConstructorCall,UnnecessaryBoxing
        Integer secondInt = new Integer(2);
        Assert.assertNotSame(firstInt, secondInt);
        ImmutableList<Integer> list2 = iList(1, firstInt, secondInt);
        Assert.assertSame(list2.get(1), Iterate.detectWith(list2, Object::equals, 2));
    }

    @Test
    public void detectWithOver30() {
        Iterable<Integer> iterable = new IterableAdapter<>(Interval.oneTo(31));
        Assert.assertEquals(1, Iterate.detectWith(iterable, Object::equals, 1).intValue());
    }

    @Test
    public void detectOptional() {
        Iterable<Integer> iterable = new IterableAdapter<>(this.getIntegerList());
        Assert.assertEquals(Optional.of(1), Iterate.detectOptional(iterable, Integer.valueOf(1)::equals));
        // noinspection CachedNumberConstructorCall,UnnecessaryBoxing
        Integer firstInt = new Integer(2);
        // noinspection CachedNumberConstructorCall,UnnecessaryBoxing
        Integer secondInt = new Integer(2);
        Assert.assertNotSame(firstInt, secondInt);
        ImmutableList<Integer> list2 = iList(1, firstInt, secondInt);
        Optional<Integer> result = Iterate.detectOptional(list2, Integer.valueOf(2)::equals);
        Assert.assertTrue(result.isPresent());
        Assert.assertSame(list2.get(1), result.get());
        Assert.assertEquals(Optional.empty(), Iterate.detectOptional(list2, Integer.valueOf(3)::equals));
    }

    @Test
    public void detectOptionalOver30() {
        List<Integer> list = Interval.oneTo(31);
        Iterable<Integer> iterable = new IterableAdapter<>(list);
        Assert.assertEquals(Optional.of(1), Iterate.detectOptional(iterable, Integer.valueOf(1)::equals));
        Assert.assertEquals(Optional.empty(), Iterate.detectOptional(iterable, Integer.valueOf(32)::equals));
    }

    @Test
    public void detectOptionalNull() {
        MutableList<Integer> objects = mList(1, null, 3);
        Iterable<Integer> iterable = new IterableAdapter<>(objects);
        Assert.assertThrows(NullPointerException.class, () -> Iterate.detectOptional(iterable, Objects::isNull));
    }

    @Test
    public void detectWithOptional() {
        Iterable<Integer> iterable = new IterableAdapter<>(this.getIntegerList());
        Assert.assertEquals(1, Iterate.detectWith(iterable, Object::equals, 1).intValue());
        // noinspection CachedNumberConstructorCall,UnnecessaryBoxing
        Integer firstInt = new Integer(2);
        // noinspection CachedNumberConstructorCall,UnnecessaryBoxing
        Integer secondInt = new Integer(2);
        Assert.assertNotSame(firstInt, secondInt);
        ImmutableList<Integer> list2 = iList(1, firstInt, secondInt);
        Optional<Integer> result = Iterate.detectWithOptional(list2, Object::equals, 2);
        Assert.assertTrue(result.isPresent());
        Assert.assertSame(list2.get(1), result.get());
        Assert.assertEquals(Optional.empty(), Iterate.detectOptional(list2, Integer.valueOf(3)::equals));
    }

    @Test
    public void detectWithOptionalOver30() {
        MutableList<Integer> objects = mList(1, null, 3);
        Iterable<Integer> iterable = new IterableAdapter<>(objects);
        Assert.assertThrows(NullPointerException.class, () -> Iterate.detectWithOptional(iterable, (i, object) -> i == object, null));
    }

    @Test
    public void detectWithOptionalNull() {
        Iterable<Integer> iterable = new IterableAdapter<>(Interval.oneTo(31));
        Assert.assertEquals(Optional.of(1), Iterate.detectWithOptional(iterable, Object::equals, 1));
        Assert.assertEquals(Optional.empty(), Iterate.detectWithOptional(iterable, Object::equals, 32));
    }

    @Test
    public void detectIfNone() {
        Iterable<Integer> iterable = new IterableAdapter<>(this.getIntegerList());
        Assert.assertNull(Iterate.detectIfNone(iterable, Integer.valueOf(6)::equals, null));
    }

    @Test
    public void detectIfNoneOver30() {
        Iterable<Integer> iterable = new IterableAdapter<>(Interval.oneTo(31));
        Assert.assertNull(Iterate.detectIfNone(iterable, Integer.valueOf(32)::equals, null));
    }

    @Test
    public void detectWithIfNone() {
        Iterable<Integer> iterable = new IterableAdapter<>(this.getIntegerList());
        Assert.assertNull(Iterate.detectWithIfNone(iterable, Object::equals, 6, null));
    }

    @Test
    public void detectWithIfNoneOver30() {
        Iterable<Integer> iterable = new IterableAdapter<>(Interval.oneTo(31));
        Assert.assertNull(Iterate.detectWithIfNone(iterable, Object::equals, 32, null));
    }

    @Test
    public void select() {
        Iterable<Integer> iterable = new IterableAdapter<>(this.getIntegerList());
        Verify.assertSize(5, Iterate.select(iterable, Integer.class::isInstance));
        Verify.assertSize(5, Iterate.select(iterable, Integer.class::isInstance, FastList.newList()));
    }

    @Test
    public void reject() {
        Iterable<Integer> iterable = new IterableAdapter<>(this.getIntegerList());
        Verify.assertSize(5, Iterate.reject(iterable, String.class::isInstance));
        Verify.assertSize(5, Iterate.reject(iterable, String.class::isInstance, FastList.newList()));
    }

    @Test
    public void distinct() {
        Collection<Integer> list = FastList.newListWith(2, 1, 3, 2, 1, 3);
        FastList<Integer> result = FastList.newList();
        FastList<Integer> actualList = IterableIterate.distinct(list, result);
        FastList<Integer> expectedList = FastList.newListWith(2, 1, 3);
        Verify.assertListsEqual(expectedList, result);
        Verify.assertListsEqual(expectedList, actualList);
        Verify.assertSize(6, list);
        Iterable<Integer> iterable1 = FastList.newListWith(1, 2, 5, 7, 7, 4);
        MutableList<Integer> result2 = IterableIterate.distinct(iterable1);
        Assert.assertEquals(result2, FastList.newListWith(1, 2, 5, 7, 4));
        Iterable<Integer> iterable2 = new IterableAdapter<>(Interval.oneTo(2));
        MutableList<Integer> result3 = IterableIterate.distinct(iterable2);
        Assert.assertEquals(result3, FastList.newListWith(1, 2));
        Iterable<Integer> iterable3 = new IterableAdapter<>(FastList.newListWith(2, 2, 4, 5));
        MutableList<Integer> result4 = IterableIterate.distinct(iterable3);
        Assert.assertEquals(result4, FastList.newListWith(2, 4, 5));
    }

    @Test
    public void distinctWithHashingStrategy() {
        MutableList<String> list = FastList.newList();
        list.addAll(FastList.newListWith("A", "a", "b", "c", "B", "D", "e", "e", "E", "D"));
        list = IterableIterate.distinct(list, HashingStrategies.fromFunction(String::toLowerCase));
        Assert.assertEquals(FastList.newListWith("A", "b", "c", "D", "e"), list);
    }

    @Test
    public void selectWith() {
        Iterable<Integer> iterable = new IterableAdapter<>(this.getIntegerList());
        Verify.assertSize(5, Iterate.selectWith(iterable, Predicates2.instanceOf(), Integer.class));
        Verify.assertSize(5, Iterate.selectWith(iterable, Predicates2.instanceOf(), Integer.class, FastList.newList()));
    }

    @Test
    public void rejectWith() {
        Iterable<Integer> iterable = new IterableAdapter<>(this.getIntegerList());
        Verify.assertEmpty(Iterate.rejectWith(iterable, Predicates2.instanceOf(), Integer.class));
        Verify.assertEmpty(Iterate.rejectWith(iterable, Predicates2.instanceOf(), Integer.class, FastList.newList()));
    }

    @Test
    public void selectInstancesOf() {
        Iterable<Number> iterable = new IterableAdapter<>(FastList.newListWith(1, 2.0, 3, 4.0, 5));
        Collection<Integer> result = Iterate.selectInstancesOf(iterable, Integer.class);
        Assert.assertEquals(iList(1, 3, 5), result);
    }

    @Test
    public void injectIntoWith() {
        Sum result = new IntegerSum(0);
        Iterable<Integer> iterable = new IterableAdapter<>(Interval.oneTo(5));
        Function3<Sum, Integer, Integer, Sum> function = (sum, element, withValue) -> sum.add(element.intValue() * withValue.intValue());
        Sum sumOfDoubledValues = Iterate.injectIntoWith(result, iterable, function, 2);
        Assert.assertEquals(30, sumOfDoubledValues.getValue().intValue());
    }

    @Test
    public void selectAndRejectWith() {
        Iterable<Integer> iterable = new IterableAdapter<>(this.getIntegerList());
        Twin<MutableList<Integer>> result = Iterate.selectAndRejectWith(iterable, Predicates2.in(), iList(1));
        Assert.assertEquals(iList(1), result.getOne());
        Assert.assertEquals(iList(5, 4, 3, 2), result.getTwo());
    }

    @Test
    public void partition() {
        Iterable<Integer> iterable = new IterableAdapter<>(this.getIntegerList());
        PartitionIterable<Integer> partition = Iterate.partition(iterable, IntegerPredicates.isEven());
        Assert.assertEquals(iList(4, 2), partition.getSelected());
        Assert.assertEquals(iList(5, 3, 1), partition.getRejected());
    }

    @Test
    public void anySatisfyWith() {
        Iterable<Integer> iterable = new IterableAdapter<>(this.getIntegerList());
        Assert.assertTrue(Iterate.anySatisfyWith(iterable, Predicates2.instanceOf(), Integer.class));
        Assert.assertFalse(Iterate.anySatisfyWith(iterable, Predicates2.instanceOf(), Double.class));
    }

    @Test
    public void anySatisfy() {
        Iterable<Integer> iterable = new IterableAdapter<>(this.getIntegerList());
        Assert.assertTrue(Iterate.anySatisfy(iterable, Integer.class::isInstance));
        Assert.assertFalse(Iterate.anySatisfy(iterable, Double.class::isInstance));
    }

    @Test
    public void allSatisfyWith() {
        Iterable<Integer> iterable = new IterableAdapter<>(this.getIntegerList());
        Assert.assertTrue(Iterate.allSatisfyWith(iterable, Predicates2.instanceOf(), Integer.class));
        Assert.assertFalse(Iterate.allSatisfyWith(iterable, Predicates2.greaterThan(), 2));
    }

    @Test
    public void allSatisfy() {
        Iterable<Integer> iterable = new IterableAdapter<>(this.getIntegerList());
        Assert.assertTrue(Iterate.allSatisfy(iterable, Integer.class::isInstance));
        Assert.assertFalse(Iterate.allSatisfy(iterable, Predicates.greaterThan(2)));
    }

    @Test
    public void noneSatisfy() {
        Iterable<Integer> iterable = new IterableAdapter<>(this.getIntegerList());
        Assert.assertTrue(Iterate.noneSatisfy(iterable, String.class::isInstance));
        Assert.assertFalse(Iterate.noneSatisfy(iterable, Predicates.greaterThan(0)));
    }

    @Test
    public void noneSatisfyWith() {
        Iterable<Integer> iterable = new IterableAdapter<>(this.getIntegerList());
        Assert.assertTrue(Iterate.noneSatisfyWith(iterable, Predicates2.instanceOf(), String.class));
        Assert.assertFalse(Iterate.noneSatisfyWith(iterable, Predicates2.greaterThan(), 0));
    }

    @Test
    public void countWith() {
        Iterable<Integer> iterable = new IterableAdapter<>(this.getIntegerList());
        Assert.assertEquals(5, Iterate.countWith(iterable, Predicates2.instanceOf(), Integer.class));
        Assert.assertEquals(0, Iterate.countWith(iterable, Predicates2.instanceOf(), Double.class));
    }

    @Test
    public void selectWithRandomAccess() {
        Iterable<Integer> iterable = new IterableAdapter<>(this.getIntegerList());
        Collection<Integer> results = Iterate.selectWith(iterable, Predicates2.instanceOf(), Integer.class);
        Assert.assertEquals(iList(5, 4, 3, 2, 1), results);
        Verify.assertSize(5, results);
    }

    @Test
    public void selectWithRandomAccessWithTarget() {
        Iterable<Integer> iterable = new IterableAdapter<>(this.getIntegerList());
        MutableList<Integer> results = Iterate.selectWith(iterable, Predicates2.instanceOf(), Integer.class, FastList.newList());
        Assert.assertEquals(iList(5, 4, 3, 2, 1), results);
        Verify.assertSize(5, results);
    }

    @Test
    public void collectIf() {
        Iterable<Integer> iterable = new IterableAdapter<>(Interval.oneTo(31));
        Collection<Class<?>> result = Iterate.collectIf(iterable, Integer.valueOf(31)::equals, Object::getClass);
        Assert.assertEquals(iList(Integer.class), result);
    }

    @Test
    public void collectIfWithTarget() {
        Iterable<Integer> iterable = new IterableAdapter<>(Interval.oneTo(31));
        Collection<Class<?>> result = Iterate.collectIf(iterable, Integer.valueOf(31)::equals, Object::getClass, FastList.newList());
        Assert.assertEquals(iList(Integer.class), result);
    }

    @Test
    public void collectWithOver30() {
        List<Integer> list = Interval.oneTo(31);
        Iterable<Integer> iterable = new IterableAdapter<>(list);
        Collection<String> result = Iterate.collectWith(iterable, (argument1, argument2) -> argument1.equals(argument2) ? "31" : null, 31);
        Verify.assertSize(31, result);
        Verify.assertContainsAll(result, null, "31");
        Verify.assertCount(30, result, Predicates.isNull());
    }

    @Test
    public void detectIndexOver30() {
        MutableList<Integer> list = Interval.toReverseList(1, 31);
        Iterable<Integer> iterable = new IterableAdapter<>(list);
        Assert.assertEquals(30, Iterate.detectIndex(iterable, Integer.valueOf(1)::equals));
        Assert.assertEquals(0, Iterate.detectIndex(iterable, Integer.valueOf(31)::equals));
    }

    @Test
    public void detectIndexWithOver30() {
        MutableList<Integer> list = Interval.toReverseList(1, 31);
        Iterable<Integer> iterable = new IterableAdapter<>(list);
        Assert.assertEquals(30, Iterate.detectIndexWith(iterable, Object::equals, 1));
        Assert.assertEquals(0, Iterate.detectIndexWith(iterable, Object::equals, 31));
    }

    @Test
    public void injectIntoWithOver30() {
        Sum result = new IntegerSum(0);
        Integer parameter = 2;
        List<Integer> integers = Interval.oneTo(31);
        Function3<Sum, Integer, Integer, Sum> function = (sum, element, withValue) -> sum.add((element.intValue() - element.intValue()) * withValue.intValue());
        Sum sumOfDoubledValues = Iterate.injectIntoWith(result, integers, function, parameter);
        Assert.assertEquals(0, sumOfDoubledValues.getValue().intValue());
    }

    @Test
    public void removeIf() {
        MutableList<Integer> objects = mList(1, 2, 3, null);
        Iterable<Integer> iterable = new IterableAdapter<>(objects);
        Iterate.removeIf(iterable, Predicates.isNull());
        Verify.assertIterableSize(3, objects);
        Verify.assertContainsAll(objects, 1, 2, 3);
        MutableList<Integer> objects4 = mList(null, 1, 2, 3);
        Iterable<Integer> iterable4 = new IterableAdapter<>(objects4);
        Iterate.removeIf(iterable4, Predicates.isNull());
        Verify.assertIterableSize(3, objects4);
        Verify.assertContainsAll(objects4, 1, 2, 3);
        MutableList<Integer> objects3 = mList(1, null, 2, 3);
        Iterable<Integer> iterable3 = new IterableAdapter<>(objects3);
        Iterate.removeIf(iterable3, Predicates.isNull());
        Verify.assertIterableSize(3, objects3);
        Verify.assertContainsAll(objects3, 1, 2, 3);
        MutableList<Integer> objects2 = mList(null, null, null, null);
        Iterable<Integer> iterable2 = new IterableAdapter<>(objects2);
        Iterate.removeIf(iterable2, Predicates.isNull());
        Verify.assertIterableEmpty(objects2);
        MutableList<Integer> objects1 = mList(1, 2, 3);
        Iterable<Integer> iterable1 = new IterableAdapter<>(objects1);
        Iterate.removeIf(iterable1, Predicates.isNull());
        Verify.assertIterableSize(3, objects1);
        Verify.assertContainsAll(objects1, 1, 2, 3);
    }

    @Test
    public void removeIfWith() {
        MutableList<Integer> objects1 = mList(1, 2, 3, null);
        Iterable<Integer> iterable = new IterableAdapter<>(objects1);
        Iterate.removeIfWith(iterable, (each5, ignored5) -> each5 == null, null);
        Assert.assertEquals(iList(1, 2, 3), objects1);
        MutableList<Integer> objects2 = mList(null, 1, 2, 3);
        Iterable<Integer> iterable4 = new IterableAdapter<>(objects2);
        Iterate.removeIfWith(iterable4, (each4, ignored4) -> each4 == null, null);
        Assert.assertEquals(iList(1, 2, 3), objects2);
        MutableList<Integer> objects3 = mList(1, null, 2, 3);
        Iterable<Integer> iterable3 = new IterableAdapter<>(objects3);
        Iterate.removeIfWith(iterable3, (each3, ignored3) -> each3 == null, null);
        Assert.assertEquals(iList(1, 2, 3), objects3);
        MutableList<Integer> objects4 = mList(null, null, null, null);
        Iterable<Integer> iterable2 = new IterableAdapter<>(objects4);
        Iterate.removeIfWith(iterable2, (each2, ignored2) -> each2 == null, null);
        Verify.assertIterableEmpty(objects4);
        MutableList<Integer> objects5 = mList(null, 1, 2, 3, null);
        Iterate.removeIfWith(objects5, (each1, ignored1) -> each1 == null, null);
        Assert.assertEquals(iList(1, 2, 3), objects5);
        MutableList<Integer> objects6 = mList(1, 2, 3);
        Iterable<Integer> iterable1 = new IterableAdapter<>(objects6);
        Iterate.removeIfWith(iterable1, (each, ignored) -> each == null, null);
        Assert.assertEquals(iList(1, 2, 3), objects6);
    }

    @Test
    public void forEach() {
        MutableList<Integer> newCollection = Lists.mutable.of();
        IterableAdapter<Integer> iterable = new IterableAdapter<>(Interval.oneTo(10));
        Iterate.forEach(iterable, newCollection::add);
        Assert.assertEquals(Interval.oneTo(10), newCollection);
    }

    @Test
    public void forEachWith() {
        Sum result = new IntegerSum(0);
        Iterable<Integer> integers = new IterableAdapter<>(Interval.oneTo(5));
        Iterate.forEachWith(integers, (each, parm) -> result.add(each.intValue() * parm.intValue()), 2);
        Assert.assertEquals(30, result.getValue().intValue());
    }

    @Test
    public void collectWith() {
        Iterable<Boolean> iterable = new IterableAdapter<>(FastList.<Boolean>newList().with(Boolean.TRUE, Boolean.FALSE));
        Assert.assertEquals(FastList.newListWith("true", "false"), Iterate.collectWith(iterable, (argument1, argument2) -> Boolean.toString(argument1.booleanValue() && argument2.booleanValue()), Boolean.TRUE));
    }

    @Test
    public void collectWithToTarget() {
        Iterable<Boolean> iterable = new IterableAdapter<>(FastList.<Boolean>newList().with(Boolean.TRUE, Boolean.FALSE));
        Assert.assertEquals(FastList.newListWith("true", "false"), Iterate.collectWith(iterable, (argument1, argument2) -> Boolean.toString(argument1.booleanValue() && argument2.booleanValue()), Boolean.TRUE, new ArrayList<>()));
    }

    @Test
    public void take() {
        List<Integer> list = this.getIntegerList();
        Iterable<Integer> iterable = new IterableAdapter<>(list);
        Verify.assertEmpty(Iterate.take(iterable, 0));
        Assert.assertEquals(FastList.newListWith(5), Iterate.take(iterable, 1));
        Assert.assertEquals(FastList.newListWith(5, 4), Iterate.take(iterable, 2));
        Assert.assertEquals(list, Iterate.take(iterable, 5));
        Assert.assertEquals(list, Iterate.take(iterable, 6));
        Assert.assertEquals(list, Iterate.take(iterable, Integer.MAX_VALUE));
        Assert.assertNotSame(iterable, Iterate.take(iterable, Integer.MAX_VALUE));
    }

    @Test
    public void take_empty() {
        Verify.assertEmpty(Iterate.take(new IterableAdapter<>(FastList.<Integer>newList()), 2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void take_negative_throws() {
        Iterate.take(new IterableAdapter<>(FastList.<Integer>newList()), -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void take_target_negative_throws() {
        IterableIterate.take(new IterableAdapter<>(FastList.newList()), -1, FastList.newList());
    }

    @Test
    public void drop() {
        List<Integer> list = this.getIntegerList();
        Iterable<Integer> iterable = new IterableAdapter<>(list);
        Assert.assertEquals(FastList.newListWith(5, 4, 3, 2, 1), Iterate.drop(iterable, 0));
        Assert.assertEquals(FastList.newListWith(4, 3, 2, 1), Iterate.drop(iterable, 1));
        Assert.assertEquals(FastList.newListWith(3, 2, 1), Iterate.drop(iterable, 2));
        Assert.assertEquals(FastList.newListWith(1), Iterate.drop(iterable, 4));
        Verify.assertEmpty(Iterate.drop(iterable, 5));
        Verify.assertEmpty(Iterate.drop(iterable, 6));
        Verify.assertEmpty(Iterate.drop(iterable, Integer.MAX_VALUE));
    }

    @Test
    public void drop_empty() {
        Verify.assertEmpty(Iterate.drop(new IterableAdapter<>(FastList.<Integer>newList()), 2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void drop_negative_throws() {
        Iterate.drop(new IterableAdapter<>(FastList.<Integer>newList()), -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void drop_target_negative_throws() {
        IterableIterate.drop(new IterableAdapter<>(FastList.newList()), -1, FastList.newList());
    }

    private static final class IterableAdapter<E> implements Iterable<E> {

        private final Iterable<E> iterable;

        private IterableAdapter(Iterable<E> newIterable) {
            this.iterable = newIterable;
        }

        @Override
        public Iterator<E> iterator() {
            return this.iterable.iterator();
        }
    }

    @Test
    public void maxWithoutComparator() {
        Iterable<Integer> iterable = FastList.newListWith(1, 5, 2, 99, 7);
        Assert.assertEquals(99, IterableIterate.max(iterable).intValue());
    }

    @Test
    public void minWithoutComparator() {
        Iterable<Integer> iterable = FastList.newListWith(99, 5, 2, 1, 7);
        Assert.assertEquals(1, IterableIterate.min(iterable).intValue());
    }

    @Test
    public void max() {
        Iterable<Integer> iterable = FastList.newListWith(1, 5, 2, 99, 7);
        Assert.assertEquals(99, IterableIterate.max(iterable, Integer::compareTo).intValue());
    }

    @Test
    public void min() {
        Iterable<Integer> iterable = FastList.newListWith(99, 5, 2, 1, 7);
        Assert.assertEquals(1, IterableIterate.min(iterable, Integer::compareTo).intValue());
    }

    @Test
    public void forEachUsingFromTo() {
        MutableList<Integer> integers = Interval.oneTo(5).toList();
        this.assertForEachUsingFromTo(integers);
        this.assertForEachUsingFromTo(new LinkedList<>(integers));
    }

    private void assertForEachUsingFromTo(List<Integer> integers) {
        MutableList<Integer> results = Lists.mutable.of();
        IterableIterate.forEach(integers, 0, 4, results::add);
        Assert.assertEquals(integers, results);
        MutableList<Integer> reverseResults = Lists.mutable.of();
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> ListIterate.forEach(integers, 4, -1, reverseResults::add));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> ListIterate.forEach(integers, -1, 4, reverseResults::add));
    }

    @Test
    public void forEachWithIndexUsingFromTo() {
        MutableList<Integer> integers = Interval.oneTo(5).toList();
        this.assertForEachWithIndexUsingFromTo(integers);
        this.assertForEachWithIndexUsingFromTo(new LinkedList<>(integers));
    }

    private void assertForEachWithIndexUsingFromTo(List<Integer> integers) {
        MutableList<Integer> results = Lists.mutable.of();
        IterableIterate.forEachWithIndex(integers, 0, 4, ObjectIntProcedures.fromProcedure(results::add));
        Assert.assertEquals(integers, results);
        MutableList<Integer> reverseResults = Lists.mutable.of();
        ObjectIntProcedure<Integer> objectIntProcedure = ObjectIntProcedures.fromProcedure(reverseResults::add);
        Assert.assertThrows(IllegalArgumentException.class, () -> IterableIterate.forEachWithIndex(integers, 4, -1, objectIntProcedure));
        Assert.assertThrows(IllegalArgumentException.class, () -> IterableIterate.forEachWithIndex(integers, -1, 4, objectIntProcedure));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(IterableIterate.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectInto, this.description("injectInto"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoOver30() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoOver30, this.description("injectIntoOver30"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoDouble, this.description("injectIntoDouble"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoString, this.description("injectIntoString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoMaxString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoMaxString, this.description("injectIntoMaxString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoMinString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoMinString, this.description("injectIntoMinString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect, this.description("collect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectWithTarget, this.description("collectWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectOver30() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectOver30, this.description("collectOver30"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWithIndex, this.description("forEachWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexOver30() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWithIndexOver30, this.description("forEachWithIndexOver30"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detect, this.description("detect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOver30() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectOver30, this.description("detectOver30"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectWith, this.description("detectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOver30() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectWithOver30, this.description("detectWithOver30"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectOptional, this.description("detectOptional"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptionalOver30() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectOptionalOver30, this.description("detectOptionalOver30"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptionalNull() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectOptionalNull, this.description("detectOptionalNull"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectWithOptional, this.description("detectWithOptional"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptionalOver30() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectWithOptionalOver30, this.description("detectWithOptionalOver30"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptionalNull() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectWithOptionalNull, this.description("detectWithOptionalNull"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectIfNone, this.description("detectIfNone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNoneOver30() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectIfNoneOver30, this.description("detectIfNoneOver30"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectWithIfNone, this.description("detectWithIfNone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNoneOver30() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectWithIfNoneOver30, this.description("detectWithIfNoneOver30"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::select, this.description("select"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reject, this.description("reject"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::distinct, this.description("distinct"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctWithHashingStrategy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::distinctWithHashingStrategy, this.description("distinctWithHashingStrategy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectWith, this.description("selectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::rejectWith, this.description("rejectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectInstancesOf, this.description("selectInstancesOf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoWith, this.description("injectIntoWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectAndRejectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectAndRejectWith, this.description("selectAndRejectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::partition, this.description("partition"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfyWith, this.description("anySatisfyWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfy, this.description("anySatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfyWith, this.description("allSatisfyWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfy, this.description("allSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::noneSatisfy, this.description("noneSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::noneSatisfyWith, this.description("noneSatisfyWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::countWith, this.description("countWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithRandomAccess() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectWithRandomAccess, this.description("selectWithRandomAccess"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithRandomAccessWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectWithRandomAccessWithTarget, this.description("selectWithRandomAccessWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectIf, this.description("collectIf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIfWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectIfWithTarget, this.description("collectIfWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithOver30() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectWithOver30, this.description("collectWithOver30"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIndexOver30() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectIndexOver30, this.description("detectIndexOver30"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIndexWithOver30() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectIndexWithOver30, this.description("detectIndexWithOver30"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWithOver30() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoWithOver30, this.description("injectIntoWithOver30"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeIf, this.description("removeIf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIfWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeIfWith, this.description("removeIfWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach, this.description("forEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWith, this.description("forEachWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectWith, this.description("collectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithToTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectWithToTarget, this.description("collectWithToTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::take, this.description("take"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take_empty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::take_empty, this.description("take_empty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take_negative_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::take_negative_throws, this.description("take_negative_throws"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take_target_negative_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::take_target_negative_throws, this.description("take_target_negative_throws"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::drop, this.description("drop"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop_empty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::drop_empty, this.description("drop_empty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop_negative_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::drop_negative_throws, this.description("drop_negative_throws"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop_target_negative_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::drop_target_negative_throws, this.description("drop_target_negative_throws"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxWithoutComparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::maxWithoutComparator, this.description("maxWithoutComparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minWithoutComparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::minWithoutComparator, this.description("minWithoutComparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::max, this.description("max"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::min, this.description("min"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachUsingFromTo() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachUsingFromTo, this.description("forEachUsingFromTo"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexUsingFromTo() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWithIndexUsingFromTo, this.description("forEachWithIndexUsingFromTo"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::classIsNonInstantiable, this.description("classIsNonInstantiable"));
        }

        private IterableIterateTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new IterableIterateTest();
        }

        @java.lang.Override
        public IterableIterateTest implementation() {
            return this.implementation;
        }
    }
}
