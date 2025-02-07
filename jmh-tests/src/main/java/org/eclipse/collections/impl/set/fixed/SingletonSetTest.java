/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.fixed;

import java.util.Collections;
import java.util.Iterator;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.partition.set.PartitionMutableSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.Twin;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.mutable.SynchronizedMutableSet;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iSet;
import static org.eclipse.collections.impl.factory.Iterables.mSet;

/**
 * JUnit test for {@link SingletonSet}.
 */
public class SingletonSetTest extends AbstractMemoryEfficientMutableSetTestCase {

    private SingletonSet<String> set;

    private MutableSet<Integer> intSet;

    @Before
    public void setUp() {
        this.set = new SingletonSet<>("1");
        this.intSet = Sets.fixedSize.of(1);
    }

    @Override
    protected MutableSet<String> classUnderTest() {
        return new SingletonSet<>("1");
    }

    @Override
    protected MutableSet<String> classUnderTestWithNull() {
        return new SingletonSet<>(null);
    }

    @Test
    public void nonUniqueWith() {
        Twin<String> twin1 = Tuples.twin("1", "1");
        Twin<String> twin2 = Tuples.twin("1", "1");
        SingletonSet<Twin<String>> set = new SingletonSet<>(twin1);
        set.with(twin2);
        Assert.assertSame(set.getFirst(), twin1);
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Verify.assertInstanceOf(SynchronizedMutableSet.class, Sets.fixedSize.of("1").asSynchronized());
    }

    @Test
    public void contains() {
        this.assertUnchanged();
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        MutableSet<String> one = Sets.fixedSize.of("1");
        MutableSet<String> oneA = UnifiedSet.newSet();
        oneA.add("1");
        Verify.assertEqualsAndHashCode(one, oneA);
        Verify.assertPostSerializedEqualsAndHashCode(one);
    }

    @Test
    public void remove() {
        try {
            this.set.remove("1");
            Assert.fail("Should not allow remove from SingletonSet");
        } catch (UnsupportedOperationException ignored) {
            this.assertUnchanged();
        }
    }

    @Test
    public void addDuplicate() {
        try {
            this.set.add("1");
            Assert.fail("Should not allow adding a duplicate to SingletonSet");
        } catch (UnsupportedOperationException ignored) {
            this.assertUnchanged();
        }
    }

    @Test
    public void add() {
        try {
            this.set.add("2");
            Assert.fail("Should not allow add to SingletonSet");
        } catch (UnsupportedOperationException ignored) {
            this.assertUnchanged();
        }
    }

    @Test
    public void addingAllToOtherSet() {
        MutableSet<String> newSet = UnifiedSet.newSet(Sets.fixedSize.of("1"));
        newSet.add("2");
        Verify.assertContainsAll(newSet, "1", "2");
    }

    private void assertUnchanged() {
        Verify.assertSize(1, this.set);
        Verify.assertContains("1", this.set);
        Verify.assertNotContains("2", this.set);
    }

    @Test
    public void tap() {
        MutableList<Integer> tapResult = Lists.mutable.of();
        Assert.assertSame(this.intSet, this.intSet.tap(tapResult::add));
        Assert.assertEquals(this.intSet.toList(), tapResult);
    }

    @Test
    public void forEach() {
        MutableList<Integer> result = Lists.mutable.of();
        this.intSet.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(1, result);
        Verify.assertContainsAll(result, 1);
    }

    @Test
    public void forEachWith() {
        MutableList<Integer> result = Lists.mutable.of();
        this.intSet.forEachWith((argument1, argument2) -> result.add(argument1 + argument2), 0);
        Verify.assertSize(1, result);
        Verify.assertContainsAll(result, 1);
    }

    @Test
    public void forEachWithIndex() {
        MutableList<Integer> result = Lists.mutable.of();
        this.intSet.forEachWithIndex((object, index) -> result.add(object + index));
        Verify.assertContainsAll(result, 1);
    }

    @Test
    public void select() {
        Verify.assertContainsAll(this.intSet.select(Predicates.lessThan(3)), 1);
        Verify.assertEmpty(this.intSet.select(Predicates.greaterThan(3)));
    }

    @Test
    public void selectWith() {
        Verify.assertContainsAll(this.intSet.selectWith(Predicates2.lessThan(), 3), 1);
        Verify.assertEmpty(this.intSet.selectWith(Predicates2.greaterThan(), 3));
    }

    @Test
    public void reject() {
        Verify.assertEmpty(this.intSet.reject(Predicates.lessThan(3)));
        Verify.assertContainsAll(this.intSet.reject(Predicates.greaterThan(3), UnifiedSet.newSet()), 1);
    }

    @Test
    public void rejectWith() {
        Verify.assertEmpty(this.intSet.rejectWith(Predicates2.lessThan(), 3));
        Verify.assertContainsAll(this.intSet.rejectWith(Predicates2.greaterThan(), 3, UnifiedSet.newSet()), 1);
    }

    @Test
    public void partition() {
        PartitionMutableSet<Integer> partition = this.intSet.partition(Predicates.lessThan(3));
        Assert.assertEquals(mSet(1), partition.getSelected());
        Assert.assertEquals(mSet(), partition.getRejected());
    }

    @Test
    public void partitionWith() {
        PartitionMutableSet<Integer> partition = this.intSet.partitionWith(Predicates2.lessThan(), 3);
        Assert.assertEquals(mSet(1), partition.getSelected());
        Assert.assertEquals(mSet(), partition.getRejected());
    }

    @Test
    public void selectInstancesOf() {
        MutableSet<Number> numbers = Sets.fixedSize.of(1);
        Assert.assertEquals(iSet(1), numbers.selectInstancesOf(Integer.class));
        Verify.assertEmpty(numbers.selectInstancesOf(Double.class));
    }

    @Test
    public void collect() {
        Verify.assertContainsAll(this.intSet.collect(String::valueOf), "1");
        Verify.assertContainsAll(this.intSet.collect(String::valueOf, UnifiedSet.newSet()), "1");
    }

    @Test
    public void flatCollect() {
        Function<Integer, MutableSet<String>> function = object -> UnifiedSet.newSetWith(String.valueOf(object));
        Verify.assertSetsEqual(UnifiedSet.newSetWith("1"), this.intSet.flatCollect(function));
        Verify.assertListsEqual(FastList.newListWith("1"), this.intSet.flatCollect(function, FastList.newList()));
    }

    @Test
    public void detect() {
        Assert.assertEquals(Integer.valueOf(1), this.intSet.detect(Integer.valueOf(1)::equals));
        Assert.assertNull(this.intSet.detect(Integer.valueOf(6)::equals));
    }

    @Test
    public void detectWith() {
        Assert.assertEquals(Integer.valueOf(1), this.intSet.detectWith(Object::equals, 1));
        Assert.assertNull(this.intSet.detectWith(Object::equals, 6));
    }

    @Test
    public void detectIfNone() {
        Function0<Integer> function = new PassThruFunction0<>(6);
        Assert.assertEquals(Integer.valueOf(1), this.intSet.detectIfNone(Integer.valueOf(1)::equals, function));
        Assert.assertEquals(Integer.valueOf(6), this.intSet.detectIfNone(Integer.valueOf(6)::equals, function));
    }

    @Test
    public void detectWithIfNone() {
        Function0<Integer> function = new PassThruFunction0<>(6);
        Assert.assertEquals(Integer.valueOf(1), this.intSet.detectWithIfNone(Object::equals, Integer.valueOf(1), function));
        Assert.assertEquals(Integer.valueOf(6), this.intSet.detectWithIfNone(Object::equals, Integer.valueOf(6), function));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.intSet.allSatisfy(Integer.class::isInstance));
        Assert.assertFalse(this.intSet.allSatisfy(Integer.valueOf(2)::equals));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertTrue(this.intSet.allSatisfyWith(Predicates2.instanceOf(), Integer.class));
        Assert.assertFalse(this.intSet.allSatisfyWith(Object::equals, 2));
    }

    @Test
    public void anySatisfy() {
        Assert.assertFalse(this.intSet.anySatisfy(String.class::isInstance));
        Assert.assertTrue(this.intSet.anySatisfy(Integer.class::isInstance));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertFalse(this.intSet.anySatisfyWith(Predicates2.instanceOf(), String.class));
        Assert.assertTrue(this.intSet.anySatisfyWith(Predicates2.instanceOf(), Integer.class));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.intSet.noneSatisfy(Integer.class::isInstance));
        Assert.assertTrue(this.intSet.noneSatisfy(Integer.valueOf(10)::equals));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertFalse(this.intSet.noneSatisfyWith(Predicates2.instanceOf(), Integer.class));
        Assert.assertTrue(this.intSet.noneSatisfyWith(Object::equals, 10));
    }

    @Test
    public void count() {
        Assert.assertEquals(1, this.intSet.count(Integer.class::isInstance));
        Assert.assertEquals(0, this.intSet.count(String.class::isInstance));
    }

    @Test
    public void countWith() {
        Assert.assertEquals(1, this.intSet.countWith(Predicates2.instanceOf(), Integer.class));
        Assert.assertEquals(0, this.intSet.countWith(Predicates2.instanceOf(), String.class));
    }

    @Test
    public void collectIf() {
        Verify.assertContainsAll(this.intSet.collectIf(Integer.class::isInstance, String::valueOf), "1");
        Verify.assertContainsAll(this.intSet.collectIf(Integer.class::isInstance, String::valueOf, FastList.newList()), "1");
    }

    @Test
    public void collectWith() {
        Assert.assertEquals(UnifiedSet.newSetWith(2), this.intSet.collectWith(AddFunction.INTEGER, 1));
        Assert.assertEquals(FastList.newListWith(2), this.intSet.collectWith(AddFunction.INTEGER, 1, FastList.newList()));
    }

    @Test
    public void getFirst() {
        Assert.assertEquals(Integer.valueOf(1), this.intSet.getFirst());
    }

    @Test
    public void getLast() {
        Assert.assertEquals(Integer.valueOf(1), this.intSet.getLast());
    }

    @Test
    public void getOnly() {
        Assert.assertEquals(Integer.valueOf(1), this.intSet.getOnly());
    }

    @Test
    public void isEmpty() {
        Verify.assertNotEmpty(this.intSet);
        Assert.assertTrue(this.intSet.notEmpty());
    }

    @Test
    public void removeAll() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.intSet.removeAll(Lists.fixedSize.of(1, 2)));
    }

    @Test
    public void retainAll() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.intSet.retainAll(Lists.fixedSize.of(2)));
    }

    @Test
    public void clear() {
        Assert.assertThrows(UnsupportedOperationException.class, this.intSet::clear);
    }

    @Override
    @Test
    public void iterator() {
        super.iterator();
        Iterator<Integer> iterator = this.intSet.iterator();
        for (int i = this.intSet.size(); i-- > 0; ) {
            Integer integer = iterator.next();
            Assert.assertEquals(1, integer.intValue() + i);
        }
    }

    @Test
    public void injectInto() {
        Integer result = this.intSet.injectInto(1, AddFunction.INTEGER);
        Assert.assertEquals(Integer.valueOf(2), result);
    }

    @Test
    public void injectIntoWith() {
        Integer result = this.intSet.injectIntoWith(1, (injectedValued, item, parameter) -> injectedValued + item + parameter, 0);
        Assert.assertEquals(Integer.valueOf(2), result);
    }

    @Test
    public void toArray() {
        Object[] array = this.intSet.toArray();
        Verify.assertSize(1, array);
        Integer[] array2 = this.intSet.toArray(new Integer[1]);
        Verify.assertSize(1, array2);
    }

    @Test
    public void selectAndRejectWith() {
        Twin<MutableList<Integer>> result = this.intSet.selectAndRejectWith(Object::equals, 1);
        Verify.assertSize(1, result.getOne());
        Verify.assertEmpty(result.getTwo());
    }

    @Test
    public void removeWithPredicate() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.intSet.removeIf(Predicates.isNull()));
    }

    @Test
    public void toList() {
        MutableList<Integer> list = this.intSet.toList();
        list.add(2);
        list.add(3);
        list.add(4);
        Verify.assertContainsAll(list, 1, 2, 3, 4);
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(FastList.newListWith(1), this.intSet.toSortedList(Collections.reverseOrder()));
    }

    @Test
    public void toSortedListBy() {
        Assert.assertEquals(FastList.newListWith(1), this.intSet.toSortedListBy(Functions.getIntegerPassThru()));
    }

    @Test
    public void toSet() {
        MutableSet<Integer> set = this.intSet.toSet();
        Verify.assertContainsAll(set, 1);
    }

    @Test
    public void toMap() {
        MutableMap<Integer, Integer> map = this.intSet.toMap(Functions.getIntegerPassThru(), Functions.getIntegerPassThru());
        Verify.assertContainsAll(map.keySet(), 1);
        Verify.assertContainsAll(map.values(), 1);
    }

    @Override
    @Test
    public void testClone() {
        try {
            Verify.assertShallowClone(this.set);
        } catch (Exception e) {
            // Suppress if a Java 9 specific exception related to reflection is thrown.
            if (!e.getClass().getCanonicalName().equals("java.lang.reflect.InaccessibleObjectException")) {
                throw e;
            }
        }
        MutableSet<String> cloneSet = this.set.clone();
        Assert.assertNotSame(cloneSet, this.set);
        Verify.assertEqualsAndHashCode(UnifiedSet.newSetWith("1"), cloneSet);
    }

    @Test
    public void newEmpty() {
        MutableSet<String> newEmpty = this.set.newEmpty();
        Verify.assertInstanceOf(UnifiedSet.class, newEmpty);
        Verify.assertEmpty(newEmpty);
    }

    @Test
    @Override
    public void min_null_throws() {
        // Collections with one element should not throw to emulate the JDK Collections behavior
        super.min_null_throws();
    }

    @Test
    @Override
    public void max_null_throws() {
        // Collections with one element should not throw to emulate the JDK Collections behavior
        super.max_null_throws();
    }

    @Test
    @Override
    public void min_null_throws_without_comparator() {
        // Collections with one element should not throw to emulate the JDK Collections behavior
        super.min_null_throws_without_comparator();
    }

    @Test
    @Override
    public void max_null_throws_without_comparator() {
        // Collections with one element should not throw to emulate the JDK Collections behavior
        super.max_null_throws_without_comparator();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public SingletonSetTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add_duplicate_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add_duplicate_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllIterable_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllIterable_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllIterable_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllIterable_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIfWith_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIfWith_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorRemove_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorRemove_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterationWithIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterationWithIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorWillGetUpsetIfYouPushItTooFar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorWillGetUpsetIfYouPushItTooFar);
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
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
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
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
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
        public void benchmark_union() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.union);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unionInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.unionInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_difference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.difference);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_differenceInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.differenceInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifference);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifferenceInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifferenceInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isSubsetOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isProperSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isProperSubsetOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_powerSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.powerSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProduct);
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
        public void benchmark_nonUniqueWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.nonUniqueWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addDuplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addDuplicate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addingAllToOtherSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addingAllToOtherSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
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
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
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
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
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
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
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
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
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
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
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
        public void benchmark_injectIntoWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWith);
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
        public void benchmark_removeWithPredicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeWithPredicate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
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
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
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
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws_without_comparator);
        }

        public void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> payload) throws java.lang.Throwable {
            this.instance = new SingletonSetTest();
            this.instance.setUp();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> addAll_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> addAllIterable_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> add_duplicate_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> add_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> removeAll_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> removeAllIterable_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> retainAll_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> retainAllIterable_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> clear_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> removeIf_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> removeIfWith_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> iteratorRemove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> iterationWithIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> iteratorWillGetUpsetIfYouPushItTooFar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> unionInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> intersectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> differenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> symmetricDifferenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> powerSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> nonUniqueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> addDuplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> addingAllToOtherSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> removeWithPredicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonSetTest> max_null_throws_without_comparator;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonSetTest::remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonSetTest::addAll_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllIterable_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonSetTest::addAllIterable_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.add_duplicate_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonSetTest::add_duplicate_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.add_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonSetTest::add_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonSetTest::removeAll_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllIterable_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonSetTest::removeAllIterable_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonSetTest::retainAll_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAllIterable_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonSetTest::retainAllIterable_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.clear_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonSetTest::clear_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonSetTest::removeIf_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIfWith_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonSetTest::removeIfWith_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.iteratorRemove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonSetTest::iteratorRemove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.iterationWithIterator = SingletonSetTest::iterationWithIterator;
            this.payloads.iteratorWillGetUpsetIfYouPushItTooFar = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonSetTest::iteratorWillGetUpsetIfYouPushItTooFar, java.util.NoSuchElementException.class);
            this.payloads.groupBy = SingletonSetTest::groupBy;
            this.payloads.groupByEach = SingletonSetTest::groupByEach;
            this.payloads.zip = SingletonSetTest::zip;
            this.payloads.zipWithIndex = SingletonSetTest::zipWithIndex;
            this.payloads.asUnmodifiable = SingletonSetTest::asUnmodifiable;
            this.payloads.toImmutable = SingletonSetTest::toImmutable;
            this.payloads.min = SingletonSetTest::min;
            this.payloads.max = SingletonSetTest::max;
            this.payloads.min_without_comparator = SingletonSetTest::min_without_comparator;
            this.payloads.max_without_comparator = SingletonSetTest::max_without_comparator;
            this.payloads.minBy = SingletonSetTest::minBy;
            this.payloads.maxBy = SingletonSetTest::maxBy;
            this.payloads.chunk = SingletonSetTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonSetTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = SingletonSetTest::chunk_large_size;
            this.payloads.union = SingletonSetTest::union;
            this.payloads.unionInto = SingletonSetTest::unionInto;
            this.payloads.intersect = SingletonSetTest::intersect;
            this.payloads.intersectInto = SingletonSetTest::intersectInto;
            this.payloads.difference = SingletonSetTest::difference;
            this.payloads.differenceInto = SingletonSetTest::differenceInto;
            this.payloads.symmetricDifference = SingletonSetTest::symmetricDifference;
            this.payloads.symmetricDifferenceInto = SingletonSetTest::symmetricDifferenceInto;
            this.payloads.isSubsetOf = SingletonSetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = SingletonSetTest::isProperSubsetOf;
            this.payloads.powerSet = SingletonSetTest::powerSet;
            this.payloads.cartesianProduct = SingletonSetTest::cartesianProduct;
            this.payloads.with = SingletonSetTest::with;
            this.payloads.withAll = SingletonSetTest::withAll;
            this.payloads.without = SingletonSetTest::without;
            this.payloads.withoutAll = SingletonSetTest::withoutAll;
            this.payloads.nonUniqueWith = SingletonSetTest::nonUniqueWith;
            this.payloads.asSynchronized = SingletonSetTest::asSynchronized;
            this.payloads.contains = SingletonSetTest::contains;
            this.payloads.equalsAndHashCode = SingletonSetTest::equalsAndHashCode;
            this.payloads.remove = SingletonSetTest::remove;
            this.payloads.addDuplicate = SingletonSetTest::addDuplicate;
            this.payloads.add = SingletonSetTest::add;
            this.payloads.addingAllToOtherSet = SingletonSetTest::addingAllToOtherSet;
            this.payloads.tap = SingletonSetTest::tap;
            this.payloads.forEach = SingletonSetTest::forEach;
            this.payloads.forEachWith = SingletonSetTest::forEachWith;
            this.payloads.forEachWithIndex = SingletonSetTest::forEachWithIndex;
            this.payloads.select = SingletonSetTest::select;
            this.payloads.selectWith = SingletonSetTest::selectWith;
            this.payloads.reject = SingletonSetTest::reject;
            this.payloads.rejectWith = SingletonSetTest::rejectWith;
            this.payloads.partition = SingletonSetTest::partition;
            this.payloads.partitionWith = SingletonSetTest::partitionWith;
            this.payloads.selectInstancesOf = SingletonSetTest::selectInstancesOf;
            this.payloads.collect = SingletonSetTest::collect;
            this.payloads.flatCollect = SingletonSetTest::flatCollect;
            this.payloads.detect = SingletonSetTest::detect;
            this.payloads.detectWith = SingletonSetTest::detectWith;
            this.payloads.detectIfNone = SingletonSetTest::detectIfNone;
            this.payloads.detectWithIfNone = SingletonSetTest::detectWithIfNone;
            this.payloads.allSatisfy = SingletonSetTest::allSatisfy;
            this.payloads.allSatisfyWith = SingletonSetTest::allSatisfyWith;
            this.payloads.anySatisfy = SingletonSetTest::anySatisfy;
            this.payloads.anySatisfyWith = SingletonSetTest::anySatisfyWith;
            this.payloads.noneSatisfy = SingletonSetTest::noneSatisfy;
            this.payloads.noneSatisfyWith = SingletonSetTest::noneSatisfyWith;
            this.payloads.count = SingletonSetTest::count;
            this.payloads.countWith = SingletonSetTest::countWith;
            this.payloads.collectIf = SingletonSetTest::collectIf;
            this.payloads.collectWith = SingletonSetTest::collectWith;
            this.payloads.getFirst = SingletonSetTest::getFirst;
            this.payloads.getLast = SingletonSetTest::getLast;
            this.payloads.getOnly = SingletonSetTest::getOnly;
            this.payloads.isEmpty = SingletonSetTest::isEmpty;
            this.payloads.removeAll = SingletonSetTest::removeAll;
            this.payloads.retainAll = SingletonSetTest::retainAll;
            this.payloads.clear = SingletonSetTest::clear;
            this.payloads.iterator = SingletonSetTest::iterator;
            this.payloads.injectInto = SingletonSetTest::injectInto;
            this.payloads.injectIntoWith = SingletonSetTest::injectIntoWith;
            this.payloads.toArray = SingletonSetTest::toArray;
            this.payloads.selectAndRejectWith = SingletonSetTest::selectAndRejectWith;
            this.payloads.removeWithPredicate = SingletonSetTest::removeWithPredicate;
            this.payloads.toList = SingletonSetTest::toList;
            this.payloads.toSortedList = SingletonSetTest::toSortedList;
            this.payloads.toSortedListBy = SingletonSetTest::toSortedListBy;
            this.payloads.toSet = SingletonSetTest::toSet;
            this.payloads.toMap = SingletonSetTest::toMap;
            this.payloads.testClone = SingletonSetTest::testClone;
            this.payloads.newEmpty = SingletonSetTest::newEmpty;
            this.payloads.min_null_throws = SingletonSetTest::min_null_throws;
            this.payloads.max_null_throws = SingletonSetTest::max_null_throws;
            this.payloads.min_null_throws_without_comparator = SingletonSetTest::min_null_throws_without_comparator;
            this.payloads.max_null_throws_without_comparator = SingletonSetTest::max_null_throws_without_comparator;
        }
    }
}
