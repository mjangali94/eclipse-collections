/*
 * Copyright (c) 2017 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.collection.immutable;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Supplier;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.predicate.Predicate;
import org.eclipse.collections.api.block.procedure.Procedure2;
import org.eclipse.collections.api.collection.ImmutableCollection;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.collection.primitive.ImmutableBooleanCollection;
import org.eclipse.collections.api.collection.primitive.ImmutableByteCollection;
import org.eclipse.collections.api.collection.primitive.ImmutableCharCollection;
import org.eclipse.collections.api.collection.primitive.ImmutableDoubleCollection;
import org.eclipse.collections.api.collection.primitive.ImmutableFloatCollection;
import org.eclipse.collections.api.collection.primitive.ImmutableIntCollection;
import org.eclipse.collections.api.collection.primitive.ImmutableLongCollection;
import org.eclipse.collections.api.collection.primitive.ImmutableShortCollection;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MapIterable;
import org.eclipse.collections.api.map.primitive.ImmutableObjectDoubleMap;
import org.eclipse.collections.api.map.primitive.ImmutableObjectLongMap;
import org.eclipse.collections.api.partition.PartitionImmutableCollection;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.impl.Counter;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.factory.PrimitiveFunctions;
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
import org.eclipse.collections.impl.collector.Collectors2;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.SortedBags;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iList;

public abstract class AbstractImmutableCollectionTestCase {

    public static final Predicate<Integer> ERROR_THROWING_PREDICATE = each -> {
        throw new AssertionError();
    };

    public static final Predicates2<Integer, Class<Integer>> ERROR_THROWING_PREDICATE_2 = new Predicates2<Integer, Class<Integer>>() {

        public boolean accept(Integer argument1, Class<Integer> argument2) {
            throw new AssertionError();
        }
    };

    protected abstract ImmutableCollection<Integer> classUnderTest();

    protected abstract <T> MutableCollection<T> newMutable();

    /**
     * @since 9.0
     */
    @Test
    public void stream() {
        Assert.assertEquals(this.classUnderTest().stream().collect(Collectors2.toBag()), this.classUnderTest().reduceInPlace(Collectors2.toBag()));
        Supplier<MutableBag<Integer>> supplier = Bags.mutable::empty;
        Assert.assertEquals(this.classUnderTest().stream().collect(supplier, MutableBag::add, MutableBag::withAll), this.classUnderTest().reduceInPlace(supplier, MutableBag::add));
        Optional<Integer> expectedReduce = this.classUnderTest().reduce(Integer::sum);
        if (expectedReduce.isPresent()) {
            Assert.assertEquals(this.classUnderTest().stream().reduce(Integer::sum).get(), expectedReduce.get());
        }
        long count = this.classUnderTest().stream().filter(integer -> integer % 2 == 0).count();
        if (count > 0) {
            Assert.assertTrue(this.classUnderTest().stream().anyMatch(integer -> integer % 2 == 0));
        } else {
            Assert.assertTrue(this.classUnderTest().stream().noneMatch(integer -> integer % 2 == 0));
        }
    }

    /**
     * @since 9.0
     */
    @Test
    public void parallelStream() {
        Assert.assertEquals(this.classUnderTest().parallelStream().collect(Collectors2.toBag()), this.classUnderTest().reduceInPlace(Collectors2.toBag()));
        Supplier<MutableBag<Integer>> supplier = Bags.mutable::empty;
        Assert.assertEquals(this.classUnderTest().parallelStream().collect(supplier, MutableBag::add, MutableBag::withAll), this.classUnderTest().reduceInPlace(supplier, MutableBag::add));
        Optional<Integer> expectedReduce = this.classUnderTest().reduce(Integer::sum);
        if (expectedReduce.isPresent()) {
            Assert.assertEquals(this.classUnderTest().parallelStream().reduce(Integer::sum).get(), expectedReduce.get());
        }
        long count = this.classUnderTest().parallelStream().filter(integer -> integer % 2 == 0).count();
        if (count > 0) {
            Assert.assertTrue(this.classUnderTest().parallelStream().anyMatch(integer -> integer % 2 == 0));
        } else {
            Assert.assertTrue(this.classUnderTest().parallelStream().noneMatch(integer -> integer % 2 == 0));
        }
    }

    /**
     * @since 9.0
     */
    @Test(expected = UnsupportedOperationException.class)
    public void castToCollection() {
        this.classUnderTest().castToCollection().add(0);
    }

    /**
     * @since 9.0
     */
    @Test
    public void countBy() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Bag<Integer> results = integers.countBy(each -> each);
        Verify.assertSize(integers.size(), results);
        Bag<Integer> results2 = integers.countBy(each -> each, SortedBags.mutable.empty());
        Verify.assertSize(integers.size(), results2);
    }

    /**
     * @since 9.0
     */
    @Test
    public void countByWith() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Bag<Integer> results = integers.countByWith((each, parm) -> each, null);
        Verify.assertSize(integers.size(), results);
        Bag<Integer> results2 = integers.countByWith((each, parm) -> each, null, SortedBags.mutable.empty());
        Verify.assertSize(integers.size(), results2);
    }

    /**
     * @since 10.0.0
     */
    @Test
    public void countByEach() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Bag<Integer> results = integers.countByEach(each -> IntInterval.oneTo(5).collect(i -> each * i));
        Verify.assertSize(integers.size() * 5, results);
        Bag<Integer> results2 = integers.countByEach(each -> IntInterval.oneTo(5).collect(i -> each * i), SortedBags.mutable.empty());
        Verify.assertSize(integers.size() * 5, results2);
    }

    @Test
    public void selectWith() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Assert.assertEquals(this.<Integer>newMutable().withAll(integers).select(IntegerPredicates.isOdd()), integers.selectWith(Predicates2.in(), iList(1, 3, 5, 7, 9)));
    }

    @Test
    public void selectWith_target() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Assert.assertEquals(this.<Integer>newMutable().with(101).withAll(integers).select(IntegerPredicates.isOdd()), integers.selectWith(Predicates2.in(), iList(1, 3, 5, 7, 9), this.<Integer>newMutable().with(101)));
    }

    @Test
    public void rejectWith() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Assert.assertEquals(this.<Integer>newMutable().withAll(integers).reject(IntegerPredicates.isOdd()), integers.rejectWith(Predicates2.in(), iList(1, 3, 5, 7, 9)));
    }

    @Test
    public void rejectWith_target() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Assert.assertEquals(this.<Integer>newMutable().with(100).withAll(integers).reject(IntegerPredicates.isOdd()), integers.rejectWith(Predicates2.in(), iList(1, 3, 5, 7, 9), this.<Integer>newMutable().with(100)));
    }

    @Test
    public void partition() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        PartitionImmutableCollection<Integer> partition = integers.partition(IntegerPredicates.isOdd());
        Assert.assertEquals(integers.select(IntegerPredicates.isOdd()), partition.getSelected());
        Assert.assertEquals(integers.select(IntegerPredicates.isEven()), partition.getRejected());
    }

    @Test
    public void partitionWith() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        PartitionImmutableCollection<Integer> partition = integers.partitionWith(Predicates2.in(), integers.select(IntegerPredicates.isOdd()));
        Assert.assertEquals(integers.select(IntegerPredicates.isOdd()), partition.getSelected());
        Assert.assertEquals(integers.select(IntegerPredicates.isEven()), partition.getRejected());
    }

    @Test
    public void collectWith() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        ImmutableCollection<String> expected = integers.collect(Functions.chain(String::valueOf, string -> string + "!"));
        ImmutableCollection<String> actual = integers.collectWith((argument1, argument2) -> argument1 + argument2, "!");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void collect_target() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        MutableCollection<String> strings = this.newMutable();
        integers.forEach(Procedures.cast(each -> strings.add(each.toString())));
        MutableCollection<String> target = this.newMutable();
        MutableCollection<String> actual = integers.collect(String::valueOf, target);
        Assert.assertEquals(strings, actual);
        Assert.assertSame(target, actual);
    }

    @Test
    public void collectWith_target() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        MutableCollection<String> expected = this.<String>newMutable().with("?").withAll(integers.collect(Functions.chain(String::valueOf, string -> string + "!")));
        MutableCollection<String> targetCollection = this.<String>newMutable().with("?");
        MutableCollection<String> actual = integers.collectWith((argument1, argument2) -> argument1 + argument2, "!", targetCollection);
        Assert.assertEquals(expected, actual);
        Assert.assertSame(targetCollection, actual);
    }

    @Test
    public void injectInto() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Integer result = integers.injectInto(0, AddFunction.INTEGER);
        Assert.assertEquals(FastList.newList(integers).injectInto(0, AddFunction.INTEGER_TO_INT), result.intValue());
    }

    @Test
    public void injectIntoInt() {
        Assert.assertEquals(this.classUnderTest().injectInto(0, AddFunction.INTEGER).longValue(), this.classUnderTest().injectInto(0, AddFunction.INTEGER_TO_INT));
    }

    @Test
    public void injectIntoLong() {
        Assert.assertEquals(this.classUnderTest().injectInto(0, AddFunction.INTEGER).longValue(), this.classUnderTest().injectInto(0, AddFunction.INTEGER_TO_LONG));
    }

    @Test
    public void injectIntoDouble() {
        Assert.assertEquals(this.classUnderTest().injectInto(0, AddFunction.INTEGER).doubleValue(), this.classUnderTest().injectInto(0, AddFunction.INTEGER_TO_DOUBLE), 0.0);
    }

    @Test
    public void injectIntoFloat() {
        Assert.assertEquals(this.classUnderTest().injectInto(0, AddFunction.INTEGER).floatValue(), this.classUnderTest().injectInto(0, AddFunction.INTEGER_TO_FLOAT), 0.0);
    }

    @Test
    public void sumFloat() {
        Assert.assertEquals(this.classUnderTest().injectInto(0, AddFunction.INTEGER_TO_FLOAT), this.classUnderTest().sumOfFloat(Integer::floatValue), 0.0);
    }

    @Test
    public void sumDouble() {
        Assert.assertEquals(this.classUnderTest().injectInto(0, AddFunction.INTEGER_TO_DOUBLE), this.classUnderTest().sumOfDouble(Integer::doubleValue), 0.0);
    }

    @Test
    public void sumInteger() {
        Assert.assertEquals(this.classUnderTest().injectInto(0, AddFunction.INTEGER_TO_INT), this.classUnderTest().sumOfInt(integer -> integer));
    }

    @Test
    public void sumLong() {
        Assert.assertEquals(this.classUnderTest().injectInto(0, AddFunction.INTEGER_TO_LONG), this.classUnderTest().sumOfLong(Integer::longValue));
    }

    @Test
    public void sumByInt() {
        MutableCollection<Integer> integers = this.newMutable();
        integers.addAllIterable(FastList.newListWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        ImmutableCollection<Integer> values = integers.toImmutable();
        ImmutableObjectLongMap<Integer> result = values.sumByInt(i -> i % 2, e -> e);
        Assert.assertEquals(25, result.get(1));
        Assert.assertEquals(30, result.get(0));
    }

    @Test
    public void sumByFloat() {
        MutableCollection<Integer> integers = this.newMutable();
        integers.addAllIterable(FastList.newListWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        ImmutableCollection<Integer> values = integers.toImmutable();
        ImmutableObjectDoubleMap<Integer> result = values.sumByFloat(f -> f % 2, e -> e);
        Assert.assertEquals(25.0f, result.get(1), 0.0);
        Assert.assertEquals(30.0f, result.get(0), 0.0);
    }

    @Test
    public void sumByFloatConsistentRounding() {
        MutableList<Integer> group1 = Interval.oneTo(100_000).toList().shuffleThis();
        MutableList<Integer> group2 = Interval.fromTo(100_001, 200_000).toList().shuffleThis();
        MutableList<Integer> integers = Lists.mutable.withAll(group1);
        integers.addAll(group2);
        ImmutableCollection<Integer> values = integers.toImmutable();
        ImmutableObjectDoubleMap<Integer> result = values.sumByFloat(integer -> integer > 100_000 ? 2 : 1, integer -> {
            Integer i = integer > 100_000 ? integer - 100_000 : integer;
            return 1.0f / (i.floatValue() * i.floatValue() * i.floatValue() * i.floatValue());
        });
        // The test only ensures the consistency/stability of rounding. This is not meant to test the "correctness" of the float calculation result.
        // Indeed the lower bits of this calculation result are always incorrect due to the information loss of original float values.
        Assert.assertEquals(1.082323233761663, result.get(1), 1.0e-15);
        Assert.assertEquals(1.082323233761663, result.get(2), 1.0e-15);
    }

    @Test
    public void sumByLong() {
        MutableCollection<Integer> integers = this.newMutable();
        integers.addAllIterable(FastList.newListWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        ImmutableCollection<Integer> values = integers.toImmutable();
        ImmutableObjectLongMap<Integer> result = values.sumByLong(l -> l % 2, e -> e);
        Assert.assertEquals(25, result.get(1));
        Assert.assertEquals(30, result.get(0));
    }

    @Test
    public void sumByDouble() {
        MutableCollection<Integer> integers = this.newMutable();
        integers.addAllIterable(FastList.newListWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        ImmutableCollection<Integer> values = integers.toImmutable();
        ImmutableObjectDoubleMap<Integer> result = values.sumByDouble(d -> d % 2, e -> e);
        Assert.assertEquals(25.0d, result.get(1), 0.0);
        Assert.assertEquals(30.0d, result.get(0), 0.0);
    }

    @Test
    public void sumByDoubleConsistentRounding() {
        MutableList<Integer> group1 = Interval.oneTo(100_000).toList().shuffleThis();
        MutableList<Integer> group2 = Interval.fromTo(100_001, 200_000).toList().shuffleThis();
        MutableList<Integer> integers = Lists.mutable.withAll(group1);
        integers.addAll(group2);
        ImmutableCollection<Integer> values = integers.toImmutable();
        ImmutableObjectDoubleMap<Integer> result = values.sumByDouble(integer -> integer > 100_000 ? 2 : 1, integer -> {
            Integer i = integer > 100_000 ? integer - 100_000 : integer;
            return 1.0d / (i.doubleValue() * i.doubleValue() * i.doubleValue() * i.doubleValue());
        });
        Assert.assertEquals(1.082323233711138, result.get(1), 1.0e-15);
        Assert.assertEquals(1.082323233711138, result.get(2), 1.0e-15);
    }

    @Test
    public void makeString() {
        Assert.assertEquals(FastList.newList(this.classUnderTest()).toString(), '[' + this.classUnderTest().makeString() + ']');
        Assert.assertEquals(FastList.newList(this.classUnderTest()).toString(), '[' + this.classUnderTest().makeString(", ") + ']');
        Assert.assertEquals(FastList.newList(this.classUnderTest()).toString(), this.classUnderTest().makeString("[", ", ", "]"));
    }

    @Test
    public void appendString() {
        Appendable builder1 = new StringBuilder();
        this.classUnderTest().appendString(builder1);
        Assert.assertEquals(FastList.newList(this.classUnderTest()).toString(), '[' + builder1.toString() + ']');
        Appendable builder2 = new StringBuilder();
        this.classUnderTest().appendString(builder2, ", ");
        Assert.assertEquals(FastList.newList(this.classUnderTest()).toString(), '[' + builder2.toString() + ']');
        Appendable builder3 = new StringBuilder();
        this.classUnderTest().appendString(builder3, "[", ", ", "]");
        Assert.assertEquals(FastList.newList(this.classUnderTest()).toString(), builder3.toString());
    }

    @Test
    public void testToString() {
        Assert.assertEquals(FastList.newList(this.classUnderTest()).toString(), this.classUnderTest().toString());
    }

    @Test
    public void select() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Assert.assertEquals(integers, integers.select(Predicates.lessThan(integers.size() + 1)));
        Verify.assertIterableEmpty(integers.select(Predicates.greaterThan(integers.size())));
    }

    @Test
    public void selectInstancesOf() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        ImmutableCollection<Integer> result = integers.selectInstancesOf(Integer.class);
        Assert.assertEquals(integers, result);
    }

    @Test
    public void reject() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Verify.assertIterableEmpty(integers.reject(Predicates.lessThan(integers.size() + 1)));
        Assert.assertEquals(integers, integers.reject(Predicates.greaterThan(integers.size())));
    }

    @Test
    public void collect() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Assert.assertEquals(integers, integers.collect(Functions.getIntegerPassThru()));
    }

    @Test
    public void collectBoolean() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        ImmutableBooleanCollection immutableCollection = integers.collectBoolean(PrimitiveFunctions.integerIsPositive());
        Verify.assertSize(1, immutableCollection);
    }

    @Test
    public void collectByte() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        ImmutableByteCollection immutableCollection = integers.collectByte(PrimitiveFunctions.unboxIntegerToByte());
        Verify.assertSize(integers.size(), immutableCollection);
        Assert.assertEquals(integers, immutableCollection.collect(Integer::valueOf));
    }

    @Test
    public void collectChar() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        ImmutableCharCollection immutableCollection = integers.collectChar(PrimitiveFunctions.unboxIntegerToChar());
        Verify.assertSize(integers.size(), immutableCollection);
        Assert.assertEquals(integers, immutableCollection.collect(Integer::valueOf));
    }

    @Test
    public void collectDouble() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        ImmutableDoubleCollection immutableCollection = integers.collectDouble(PrimitiveFunctions.unboxIntegerToDouble());
        Verify.assertSize(integers.size(), immutableCollection);
        Assert.assertEquals(integers, immutableCollection.collect(doubleParameter -> Integer.valueOf((int) doubleParameter)));
    }

    @Test
    public void collectFloat() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        ImmutableFloatCollection immutableCollection = integers.collectFloat(PrimitiveFunctions.unboxIntegerToFloat());
        Verify.assertSize(integers.size(), immutableCollection);
        Assert.assertEquals(integers, immutableCollection.collect(floatParameter -> Integer.valueOf((int) floatParameter)));
    }

    @Test
    public void collectInt() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        ImmutableIntCollection immutableCollection = integers.collectInt(PrimitiveFunctions.unboxIntegerToInt());
        Verify.assertSize(integers.size(), immutableCollection);
        Assert.assertEquals(integers, immutableCollection.collect(Integer::valueOf));
    }

    @Test
    public void collectLong() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        ImmutableLongCollection immutableCollection = integers.collectLong(PrimitiveFunctions.unboxIntegerToLong());
        Verify.assertSize(integers.size(), immutableCollection);
        Assert.assertEquals(integers, immutableCollection.collect(longParameter -> Integer.valueOf((int) longParameter)));
    }

    @Test
    public void collectShort() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        ImmutableShortCollection immutableCollection = integers.collectShort(PrimitiveFunctions.unboxIntegerToShort());
        Verify.assertSize(integers.size(), immutableCollection);
        Assert.assertEquals(integers, immutableCollection.collect(Integer::valueOf));
    }

    @Test
    public void flatCollect() {
        RichIterable<String> actual = this.classUnderTest().flatCollect(integer -> Lists.fixedSize.of(String.valueOf(integer)));
        ImmutableCollection<String> expected = this.classUnderTest().collect(String::valueOf);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void flatCollectWith() {
        RichIterable<String> actual = this.classUnderTest().flatCollectWith((integer, factory) -> factory.of(String.valueOf(integer)), Lists.fixedSize);
        ImmutableCollection<String> expected = this.classUnderTest().collect(String::valueOf);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        this.classUnderTest().chunk(0);
    }

    @Test
    public void detect() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Assert.assertEquals(Integer.valueOf(1), integers.detect(Predicates.equal(1)));
        Assert.assertNull(integers.detect(Predicates.equal(integers.size() + 1)));
    }

    @Test
    public void detectWith() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Assert.assertEquals(Integer.valueOf(1), integers.detectWith(Object::equals, Integer.valueOf(1)));
        Assert.assertNull(integers.detectWith(Object::equals, Integer.valueOf(integers.size() + 1)));
        FastList<String> strings = FastList.newListWith("1", "2", "3");
        Assert.assertEquals("1", strings.detectWith(Object::equals, "1"));
    }

    @Test
    public void detectIfNone() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Function0<Integer> function = new PassThruFunction0<>(integers.size() + 1);
        Assert.assertEquals(Integer.valueOf(1), integers.detectIfNone(Predicates.equal(1), function));
        Assert.assertEquals(Integer.valueOf(integers.size() + 1), integers.detectIfNone(Predicates.equal(integers.size() + 1), function));
    }

    @Test
    public void detectWithIfNone() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Integer sum = Integer.valueOf(integers.size() + 1);
        Function0<Integer> function = new PassThruFunction0<>(sum);
        Assert.assertEquals(Integer.valueOf(1), integers.detectWithIfNone(Object::equals, Integer.valueOf(1), function));
        Assert.assertEquals(sum, integers.detectWithIfNone(Object::equals, sum, function));
    }

    @Test
    public void allSatisfy() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Assert.assertTrue(integers.allSatisfy(Integer.class::isInstance));
        Assert.assertFalse(integers.allSatisfy(Integer.valueOf(0)::equals));
    }

    @Test
    public void allSatisfyWith() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Assert.assertTrue(integers.allSatisfyWith(Predicates2.instanceOf(), Integer.class));
        Assert.assertFalse(integers.allSatisfyWith(Object::equals, 0));
    }

    @Test
    public void noneSatisfy() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Assert.assertTrue(integers.noneSatisfy(String.class::isInstance));
        Assert.assertFalse(integers.noneSatisfy(Integer.valueOf(1)::equals));
    }

    @Test
    public void noneSatisfyWith() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Assert.assertTrue(integers.noneSatisfyWith(Predicates2.instanceOf(), String.class));
        Assert.assertFalse(integers.noneSatisfyWith(Object::equals, 1));
    }

    @Test
    public void anySatisfy() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Assert.assertFalse(integers.anySatisfy(String.class::isInstance));
        Assert.assertTrue(integers.anySatisfy(Integer.class::isInstance));
    }

    @Test
    public void anySatisfyWith() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Assert.assertFalse(integers.anySatisfyWith(Predicates2.instanceOf(), String.class));
        Assert.assertTrue(integers.anySatisfyWith(Predicates2.instanceOf(), Integer.class));
    }

    @Test
    public void count() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Assert.assertEquals(integers.size(), integers.count(Integer.class::isInstance));
        Assert.assertEquals(0, integers.count(String.class::isInstance));
    }

    @Test
    public void countWith() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Assert.assertEquals(integers.size(), integers.countWith(Predicates2.instanceOf(), Integer.class));
        Assert.assertEquals(0, integers.countWith(Predicates2.instanceOf(), String.class));
    }

    @Test
    public void collectIf() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Assert.assertEquals(integers, integers.collectIf(Integer.class::isInstance, Functions.getIntegerPassThru()));
    }

    @Test
    public void getFirst() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Assert.assertEquals(Integer.valueOf(1), integers.getFirst());
    }

    @Test
    public void getLast() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Assert.assertEquals(Integer.valueOf(integers.size()), integers.getLast());
    }

    @Test
    public void isEmpty() {
        ImmutableCollection<Integer> immutableCollection = this.classUnderTest();
        Assert.assertFalse(immutableCollection.isEmpty());
        Assert.assertTrue(immutableCollection.notEmpty());
    }

    @Test
    public void iterator() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; iterator.hasNext(); i++) {
            Integer integer = iterator.next();
            Assert.assertEquals(i + 1, integer.intValue());
        }
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void toArray() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        MutableList<Integer> copy = FastList.newList(integers);
        Assert.assertArrayEquals(integers.toArray(), copy.toArray());
        Assert.assertArrayEquals(integers.toArray(new Integer[integers.size()]), copy.toArray(new Integer[integers.size()]));
    }

    @Test
    public void toSortedList() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        MutableList<Integer> copy = FastList.newList(integers);
        MutableList<Integer> list = integers.toSortedList(Collections.reverseOrder());
        Assert.assertEquals(copy.sortThis(Collections.reverseOrder()), list);
        MutableList<Integer> list2 = integers.toSortedList();
        Assert.assertEquals(copy.sortThis(), list2);
    }

    @Test
    public void toSortedSet() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        MutableSortedSet<Integer> set = integers.toSortedSet();
        Verify.assertListsEqual(integers.toSortedList(), set.toList());
    }

    @Test
    public void toSortedSetWithComparator() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        MutableSortedSet<Integer> set = integers.toSortedSet(Comparators.reverseNaturalOrder());
        Assert.assertEquals(integers.toSet(), set);
        Assert.assertEquals(integers.toSortedList(Comparators.reverseNaturalOrder()), set.toList());
    }

    @Test
    public void toSortedSetBy() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        MutableSortedSet<Integer> set = integers.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSet(integers), set);
    }

    @Test
    public void forLoop() {
        ImmutableCollection<Integer> immutableCollection = this.classUnderTest();
        for (Integer each : immutableCollection) {
            Assert.assertNotNull(each);
        }
    }

    private ImmutableCollection<Integer> classUnderTestWithNull() {
        return this.classUnderTest().reject(Integer.valueOf(1)::equals).newWith(null);
    }

    @Test(expected = NullPointerException.class)
    public void min_null_throws() {
        this.classUnderTestWithNull().min(Integer::compareTo);
    }

    @Test(expected = NullPointerException.class)
    public void max_null_throws() {
        this.classUnderTestWithNull().max(Integer::compareTo);
    }

    @Test
    public void min() {
        Assert.assertEquals(Integer.valueOf(1), this.classUnderTest().min(Integer::compareTo));
    }

    @Test
    public void max() {
        Assert.assertEquals(Integer.valueOf(1), this.classUnderTest().max(Comparators.reverse(Integer::compareTo)));
    }

    @Test(expected = NullPointerException.class)
    public void min_null_throws_without_comparator() {
        this.classUnderTestWithNull().min();
    }

    @Test(expected = NullPointerException.class)
    public void max_null_throws_without_comparator() {
        this.classUnderTestWithNull().max();
    }

    @Test
    public void min_without_comparator() {
        Assert.assertEquals(Integer.valueOf(1), this.classUnderTest().min());
    }

    @Test
    public void max_without_comparator() {
        Assert.assertEquals(Integer.valueOf(this.classUnderTest().size()), this.classUnderTest().max());
    }

    @Test
    public void minBy() {
        Assert.assertEquals(Integer.valueOf(1), this.classUnderTest().minBy(String::valueOf));
    }

    @Test
    public void maxBy() {
        Assert.assertEquals(Integer.valueOf(this.classUnderTest().size()), this.classUnderTest().maxBy(Functions.getIntegerPassThru()));
    }

    @Test
    public void iteratorRemove() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().iterator().remove());
    }

    @Test
    public void add() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> ((Collection<Integer>) this.classUnderTest()).add(1));
    }

    @Test
    public void remove() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> ((Collection<Integer>) this.classUnderTest()).remove(Integer.valueOf(1)));
    }

    @Test
    public void clear() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> ((Collection<Integer>) this.classUnderTest()).clear());
    }

    @Test
    public void removeAll() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> ((Collection<Integer>) this.classUnderTest()).removeAll(Lists.fixedSize.of()));
    }

    @Test
    public void retainAll() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> ((Collection<Integer>) this.classUnderTest()).retainAll(Lists.fixedSize.of()));
    }

    @Test
    public void addAll() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> ((Collection<Integer>) this.classUnderTest()).addAll(Lists.fixedSize.of()));
    }

    @Test
    public void aggregateByMutating() {
        Procedure2<Counter, Integer> sumAggregator = Counter::add;
        MapIterable<String, Counter> actual = this.classUnderTest().aggregateInPlaceBy(String::valueOf, Counter::new, sumAggregator);
        MapIterable<String, Counter> expected = this.classUnderTest().toBag().aggregateInPlaceBy(String::valueOf, Counter::new, sumAggregator);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void aggregateByNonMutating() {
        Function2<Integer, Integer, Integer> sumAggregator = (integer1, integer2) -> integer1 + integer2;
        MapIterable<String, Integer> actual = this.classUnderTest().aggregateBy(String::valueOf, () -> 0, sumAggregator);
        MapIterable<String, Integer> expected = this.classUnderTest().toBag().aggregateBy(String::valueOf, () -> 0, sumAggregator);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void tap() {
        MutableList<Integer> tapResult = Lists.mutable.of();
        ImmutableCollection<Integer> collection = this.classUnderTest();
        Assert.assertSame(collection, collection.tap(tapResult::add));
        Assert.assertEquals(collection.toList(), tapResult);
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static abstract class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::stream, this.description("stream"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::parallelStream, this.description("parallelStream"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_castToCollection() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::castToCollection, this.description("castToCollection"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::countBy, this.description("countBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::countByWith, this.description("countByWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::countByEach, this.description("countByEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectWith, this.description("selectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectWith_target, this.description("selectWith_target"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::rejectWith, this.description("rejectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_target() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::rejectWith_target, this.description("rejectWith_target"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::partition, this.description("partition"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::partitionWith, this.description("partitionWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectWith, this.description("collectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_target() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect_target, this.description("collect_target"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectWith_target, this.description("collectWith_target"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectInto, this.description("injectInto"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoInt, this.description("injectIntoInt"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoLong, this.description("injectIntoLong"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoDouble, this.description("injectIntoDouble"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoFloat, this.description("injectIntoFloat"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloat() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumFloat, this.description("sumFloat"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumDouble, this.description("sumDouble"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumInteger, this.description("sumInteger"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumLong, this.description("sumLong"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumByInt, this.description("sumByInt"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumByFloat, this.description("sumByFloat"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloatConsistentRounding() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumByFloatConsistentRounding, this.description("sumByFloatConsistentRounding"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumByLong, this.description("sumByLong"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumByDouble, this.description("sumByDouble"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDoubleConsistentRounding() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumByDoubleConsistentRounding, this.description("sumByDoubleConsistentRounding"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::makeString, this.description("makeString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::appendString, this.description("appendString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testToString, this.description("testToString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::select, this.description("select"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectInstancesOf, this.description("selectInstancesOf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reject, this.description("reject"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect, this.description("collect"));
        }


        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectByte, this.description("collectByte"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectChar, this.description("collectChar"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectDouble, this.description("collectDouble"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectFloat, this.description("collectFloat"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectInt, this.description("collectInt"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectLong, this.description("collectLong"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectShort, this.description("collectShort"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::flatCollect, this.description("flatCollect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::flatCollectWith, this.description("flatCollectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::chunk_zero_throws, this.description("chunk_zero_throws"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detect, this.description("detect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectWith, this.description("detectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectIfNone, this.description("detectIfNone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectWithIfNone, this.description("detectWithIfNone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfy, this.description("allSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfyWith, this.description("allSatisfyWith"));
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
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfy, this.description("anySatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfyWith, this.description("anySatisfyWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::count, this.description("count"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::countWith, this.description("countWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectIf, this.description("collectIf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getFirst, this.description("getFirst"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getLast, this.description("getLast"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isEmpty, this.description("isEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator, this.description("iterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toArray, this.description("toArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedList, this.description("toSortedList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedSet, this.description("toSortedSet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetWithComparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedSetWithComparator, this.description("toSortedSetWithComparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedSetBy, this.description("toSortedSetBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forLoop() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forLoop, this.description("forLoop"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::min_null_throws, this.description("min_null_throws"), java.lang.NullPointerException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::max_null_throws, this.description("max_null_throws"), java.lang.NullPointerException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::min, this.description("min"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::max, this.description("max"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::min_null_throws_without_comparator, this.description("min_null_throws_without_comparator"), java.lang.NullPointerException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::max_null_throws_without_comparator, this.description("max_null_throws_without_comparator"), java.lang.NullPointerException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::min_without_comparator, this.description("min_without_comparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::max_without_comparator, this.description("max_without_comparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::minBy, this.description("minBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::maxBy, this.description("maxBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorRemove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iteratorRemove, this.description("iteratorRemove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::add, this.description("add"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::remove, this.description("remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::clear, this.description("clear"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeAll, this.description("removeAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::retainAll, this.description("retainAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addAll, this.description("addAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::aggregateByMutating, this.description("aggregateByMutating"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::aggregateByNonMutating, this.description("aggregateByNonMutating"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::tap, this.description("tap"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractImmutableCollectionTestCase implementation();
    }
}
