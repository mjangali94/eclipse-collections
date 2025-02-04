/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.mutable.primitive;

import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bag.primitive.ImmutableBooleanBag;
import org.eclipse.collections.api.bag.primitive.MutableBooleanBag;
import org.eclipse.collections.api.block.function.primitive.BooleanToObjectFunction;
import org.eclipse.collections.api.collection.primitive.MutableBooleanCollection;
import org.eclipse.collections.api.list.primitive.MutableBooleanList;
import org.eclipse.collections.api.set.primitive.MutableBooleanSet;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableBooleanCollectionTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.BooleanBags;
import org.eclipse.collections.impl.factory.primitive.BooleanSets;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableBooleanBag}.
 */
public abstract class AbstractMutableBooleanBagTestCase extends AbstractMutableBooleanCollectionTestCase {

    @Override
    protected abstract MutableBooleanBag classUnderTest();

    @Override
    protected abstract MutableBooleanBag newWith(boolean... elements);

    @Override
    protected MutableBooleanBag newMutableCollectionWith(boolean... elements) {
        return BooleanHashBag.newBagWith(elements);
    }

    @Override
    protected MutableBag<Object> newObjectCollectionWith(Object... elements) {
        return HashBag.newBagWith(elements);
    }

    @Test
    public void sizeDistinct() {
        Assert.assertEquals(0L, this.newWith().sizeDistinct());
        Assert.assertEquals(1L, this.newWith(true).sizeDistinct());
        Assert.assertEquals(1L, this.newWith(true, true, true).sizeDistinct());
        Assert.assertEquals(2L, this.newWith(true, false, true, false, true).sizeDistinct());
    }

    @Override
    @Test
    public void addAllIterable() {
        super.addAllIterable();
        MutableBooleanBag bag = this.newWith();
        Assert.assertTrue(bag.addAll(BooleanArrayList.newListWith(true, false, true, false, true)));
        Assert.assertFalse(bag.addAll(new BooleanArrayList()));
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, true, false, true), bag);
        Assert.assertTrue(bag.addAll(BooleanHashBag.newBagWith(true, false, true, false, true)));
        Assert.assertEquals(BooleanHashBag.newBagWith(false, false, false, false, true, true, true, true, true, true), bag);
    }

    @Test
    public void addOccurrences() {
        MutableBooleanBag bag = this.newWith();
        bag.addOccurrences(false, 3);
        Assert.assertEquals(BooleanHashBag.newBagWith(false, false, false), bag);
        bag.addOccurrences(false, 2);
        Assert.assertEquals(BooleanHashBag.newBagWith(false, false, false, false, false), bag);
        bag.addOccurrences(false, 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(false, false, false, false, false), bag);
        bag.addOccurrences(true, 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(false, false, false, false, false), bag);
        bag.addOccurrences(true, 1);
        Assert.assertEquals(BooleanHashBag.newBagWith(false, false, false, false, false, true), bag);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addOccurrences_throws() {
        this.newWith().addOccurrences(true, -1);
    }

    @Test
    public void removeOccurrences() {
        MutableBooleanBag bag1 = this.newWith();
        Assert.assertFalse(bag1.removeOccurrences(true, 5));
        bag1.addOccurrences(true, 5);
        Assert.assertTrue(bag1.removeOccurrences(true, 2));
        Assert.assertEquals(BooleanHashBag.newBagWith(true, true, true), bag1);
        Assert.assertFalse(bag1.removeOccurrences(true, 0));
        Assert.assertEquals(BooleanHashBag.newBagWith(true, true, true), bag1);
        Assert.assertTrue(bag1.removeOccurrences(true, 5));
        Assert.assertEquals(new BooleanHashBag(), bag1);
        Assert.assertFalse(bag1.removeOccurrences(true, 5));
        Assert.assertEquals(new BooleanHashBag(), bag1);
        MutableBooleanBag bag2 = this.newWith();
        Assert.assertFalse(bag2.removeOccurrences(false, 5));
        bag2.addOccurrences(false, 5);
        Assert.assertTrue(bag2.removeOccurrences(false, 2));
        Assert.assertEquals(BooleanHashBag.newBagWith(false, false, false), bag2);
        Assert.assertFalse(bag2.removeOccurrences(false, 0));
        Assert.assertEquals(BooleanHashBag.newBagWith(false, false, false), bag2);
        Assert.assertTrue(bag2.removeOccurrences(false, 5));
        Assert.assertEquals(new BooleanHashBag(), bag2);
        Assert.assertFalse(bag2.removeOccurrences(false, 5));
        Assert.assertEquals(new BooleanHashBag(), bag2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeOccurrences_throws() {
        this.newWith().removeOccurrences(true, -1);
    }

    @Test
    public void forEachWithOccurrences() {
        StringBuilder stringBuilder = new StringBuilder();
        this.classUnderTest().forEachWithOccurrences((argument1, argument2) -> stringBuilder.append(argument1).append(argument2));
        String string = stringBuilder.toString();
        Assert.assertTrue("true2false1".equals(string) || "false1true2".equals(string));
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(3, this.classUnderTest());
    }

    @Override
    @Test
    public void anySatisfy() {
        super.anySatisfy();
        long[] count = { 0 };
        MutableBooleanBag bag = this.newWith(false, true, false);
        Assert.assertTrue(bag.anySatisfy(value -> {
            count[0]++;
            return value;
        }));
        Assert.assertEquals(2L, count[0]);
    }

    @Override
    @Test
    public void allSatisfy() {
        super.allSatisfy();
        int[] count = { 0 };
        MutableBooleanBag bag = this.newWith(false, true, false);
        Assert.assertFalse(bag.allSatisfy(value -> {
            count[0]++;
            return !value;
        }));
        Assert.assertEquals(2L, count[0]);
    }

    @Override
    @Test
    public void noneSatisfy() {
        super.noneSatisfy();
        MutableBooleanBag bag = this.newWith(false, true, false);
        Assert.assertFalse(bag.noneSatisfy(value -> value));
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        MutableBooleanBag bag = this.newWith(true, false, false, true, true, true);
        BooleanToObjectFunction<String> stringValueOf = parameter -> parameter ? "true" : "false";
        Assert.assertEquals(HashBag.newBagWith("true", "false", "false", "true", "true", "true"), bag.collect(stringValueOf));
        MutableBooleanBag bag1 = this.newWith(false, false);
        Assert.assertEquals(HashBag.newBagWith("false", "false"), bag1.collect(stringValueOf));
        MutableBooleanBag bag2 = this.newWith(true, true);
        Assert.assertEquals(HashBag.newBagWith("true", "true"), bag2.collect(stringValueOf));
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        MutableBooleanCollection collection1 = this.newWith(true, false, true, false);
        MutableBooleanCollection collection2 = this.newWith(true, false, false, true);
        MutableBooleanCollection collection3 = this.newWith(true, false);
        MutableBooleanCollection collection4 = this.newWith(true, true, false);
        Assert.assertEquals(collection1, collection2);
        Assert.assertNotEquals(collection3, collection4);
    }

    @Override
    @Test
    public void testHashCode() {
        super.testHashCode();
        MutableBooleanCollection collection1 = this.newWith(true, false, true, false);
        MutableBooleanCollection collection2 = this.newWith(true, false, false, true);
        MutableBooleanCollection collection3 = this.newWith(true, false);
        MutableBooleanCollection collection4 = this.newWith(true, true, false);
        Verify.assertEqualsAndHashCode(collection1, collection2);
        Assert.assertNotEquals(collection3.hashCode(), collection4.hashCode());
    }

    @Override
    @Test
    public void testToString() {
        super.testToString();
        Assert.assertEquals("[true, true, true]", BooleanHashBag.newBagWith(true, true, true).toString());
    }

    @Override
    @Test
    public void makeString() {
        super.makeString();
        Assert.assertEquals("true, true, true", BooleanHashBag.newBagWith(true, true, true).makeString());
    }

    @Override
    @Test
    public void appendString() {
        super.appendString();
        StringBuilder appendable1 = new StringBuilder();
        this.newWith(true, true, true).appendString(appendable1);
        Assert.assertEquals("true, true, true", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();
        MutableBooleanBag bag1 = this.newWith(false, false, true);
        bag1.appendString(appendable2);
        Assert.assertTrue(appendable2.toString(), "false, false, true".equals(appendable2.toString()) || "true, false, false".equals(appendable2.toString()) || "false, true, false".equals(appendable2.toString()));
    }

    @Override
    @Test
    public void toList() {
        super.toList();
        MutableBooleanList list = this.newWith(false, false, true).toList();
        Assert.assertTrue(list.equals(BooleanArrayList.newListWith(false, false, true)) || list.equals(BooleanArrayList.newListWith(true, false, false)) || list.equals(BooleanArrayList.newListWith(false, true, false)));
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Assert.assertNotSame(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableBooleanBag.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void topOccurrences() {
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWith().topOccurrences(-1));
        Assert.assertTrue(this.newWith().topOccurrences(1).isEmpty());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(true, 2)), this.newWith(true, true, false).topOccurrences(1));
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(false, 2)), this.newWith(false, true, false).topOccurrences(1));
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(true, 2), PrimitiveTuples.pair(false, 1)), this.newWith(true, true, false).topOccurrences(2));
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(true, 1), PrimitiveTuples.pair(false, 1)).toBag(), this.newWith(true, false).topOccurrences(1).toBag());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(false, 2), PrimitiveTuples.pair(true, 1)).toBag(), this.newWith(true, false, false).topOccurrences(2).toBag());
    }

    @Test
    public void bottomOccurrences() {
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWith().bottomOccurrences(-1));
        Assert.assertTrue(this.newWith().bottomOccurrences(1).isEmpty());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(false, 1)), this.newWith(true, true, false).bottomOccurrences(1));
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(true, 1)), this.newWith(false, true, false).bottomOccurrences(1));
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(true, 1), PrimitiveTuples.pair(false, 2)), this.newWith(false, true, false).bottomOccurrences(2));
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(true, 1), PrimitiveTuples.pair(false, 1)), this.newWith(true, false).bottomOccurrences(1));
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(false, 1), PrimitiveTuples.pair(true, 2)), this.newWith(true, true, false).bottomOccurrences(2));
    }

    @Test
    public void selectUnique() {
        MutableBooleanBag bag = BooleanBags.mutable.with(false, false, true);
        MutableBooleanSet expected = BooleanSets.mutable.with(true);
        MutableBooleanSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
        MutableBooleanBag bag2 = BooleanBags.mutable.with(false, false, true, true);
        MutableBooleanSet expected2 = BooleanSets.mutable.empty();
        MutableBooleanSet actual2 = bag2.selectUnique();
        Assert.assertEquals(expected2, actual2);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableBooleanBagTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
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
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_emptyList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
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
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOnEmptyThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOnEmptyThrows);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduce() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduce);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
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
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll_iterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll_iterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
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

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sizeDistinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sizeDistinct);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addOccurrences_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeOccurrences_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeOccurrences_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_topOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.topOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_bottomOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.bottomOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectUnique);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableBooleanBagTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> iterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> iterator_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> booleanIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> addOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> addOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> removeOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> removeOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanBagTestCase> selectUnique;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractMutableBooleanBagTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractMutableBooleanBagTestCase::newCollection;
            this.payloads.isEmpty = AbstractMutableBooleanBagTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableBooleanBagTestCase::notEmpty;
            this.payloads.contains = AbstractMutableBooleanBagTestCase::contains;
            this.payloads.containsAnyArray = AbstractMutableBooleanBagTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractMutableBooleanBagTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractMutableBooleanBagTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractMutableBooleanBagTestCase::containsNoneIterable;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableBooleanBagTestCase::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableBooleanBagTestCase::iterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableBooleanBagTestCase::iterator_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.booleanIterator = AbstractMutableBooleanBagTestCase::booleanIterator;
            this.payloads.forEach = AbstractMutableBooleanBagTestCase::forEach;
            this.payloads.count = AbstractMutableBooleanBagTestCase::count;
            this.payloads.select = AbstractMutableBooleanBagTestCase::select;
            this.payloads.reject = AbstractMutableBooleanBagTestCase::reject;
            this.payloads.detectIfNone = AbstractMutableBooleanBagTestCase::detectIfNone;
            this.payloads.injectInto = AbstractMutableBooleanBagTestCase::injectInto;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableBooleanBagTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractMutableBooleanBagTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractMutableBooleanBagTestCase::reduceIfEmpty;
            this.payloads.toArray = AbstractMutableBooleanBagTestCase::toArray;
            this.payloads.toSet = AbstractMutableBooleanBagTestCase::toSet;
            this.payloads.toBag = AbstractMutableBooleanBagTestCase::toBag;
            this.payloads.asLazy = AbstractMutableBooleanBagTestCase::asLazy;
            this.payloads.clear = AbstractMutableBooleanBagTestCase::clear;
            this.payloads.containsAllArray = AbstractMutableBooleanBagTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractMutableBooleanBagTestCase::containsAllIterable;
            this.payloads.add = AbstractMutableBooleanBagTestCase::add;
            this.payloads.addAllArray = AbstractMutableBooleanBagTestCase::addAllArray;
            this.payloads.remove = AbstractMutableBooleanBagTestCase::remove;
            this.payloads.removeAll = AbstractMutableBooleanBagTestCase::removeAll;
            this.payloads.removeAll_iterable = AbstractMutableBooleanBagTestCase::removeAll_iterable;
            this.payloads.retainAll_iterable = AbstractMutableBooleanBagTestCase::retainAll_iterable;
            this.payloads.retainAll = AbstractMutableBooleanBagTestCase::retainAll;
            this.payloads.with = AbstractMutableBooleanBagTestCase::with;
            this.payloads.withAll = AbstractMutableBooleanBagTestCase::withAll;
            this.payloads.without = AbstractMutableBooleanBagTestCase::without;
            this.payloads.withoutAll = AbstractMutableBooleanBagTestCase::withoutAll;
            this.payloads.asSynchronized = AbstractMutableBooleanBagTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableBooleanBagTestCase::asUnmodifiable;
            this.payloads.booleanIterator_with_remove = AbstractMutableBooleanBagTestCase::booleanIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableBooleanBagTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableBooleanBagTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.chunk = AbstractMutableBooleanBagTestCase::chunk;
            this.payloads.sizeDistinct = AbstractMutableBooleanBagTestCase::sizeDistinct;
            this.payloads.addAllIterable = AbstractMutableBooleanBagTestCase::addAllIterable;
            this.payloads.addOccurrences = AbstractMutableBooleanBagTestCase::addOccurrences;
            this.payloads.addOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableBooleanBagTestCase::addOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.removeOccurrences = AbstractMutableBooleanBagTestCase::removeOccurrences;
            this.payloads.removeOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableBooleanBagTestCase::removeOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.forEachWithOccurrences = AbstractMutableBooleanBagTestCase::forEachWithOccurrences;
            this.payloads.size = AbstractMutableBooleanBagTestCase::size;
            this.payloads.anySatisfy = AbstractMutableBooleanBagTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableBooleanBagTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableBooleanBagTestCase::noneSatisfy;
            this.payloads.collect = AbstractMutableBooleanBagTestCase::collect;
            this.payloads.testEquals = AbstractMutableBooleanBagTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableBooleanBagTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableBooleanBagTestCase::testToString;
            this.payloads.makeString = AbstractMutableBooleanBagTestCase::makeString;
            this.payloads.appendString = AbstractMutableBooleanBagTestCase::appendString;
            this.payloads.toList = AbstractMutableBooleanBagTestCase::toList;
            this.payloads.toImmutable = AbstractMutableBooleanBagTestCase::toImmutable;
            this.payloads.topOccurrences = AbstractMutableBooleanBagTestCase::topOccurrences;
            this.payloads.bottomOccurrences = AbstractMutableBooleanBagTestCase::bottomOccurrences;
            this.payloads.selectUnique = AbstractMutableBooleanBagTestCase::selectUnique;
        }
    }
*/
}
