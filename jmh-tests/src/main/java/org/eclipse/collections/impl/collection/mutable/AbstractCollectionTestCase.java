/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.collection.mutable;

import java.util.Collections;
import org.eclipse.collections.api.collection.ImmutableCollection;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.multimap.bag.MutableBagMultimap;
import org.eclipse.collections.api.tuple.Twin;
import org.eclipse.collections.impl.AbstractRichIterableTestCase;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.collector.Collectors2;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Multimaps;
import org.eclipse.collections.impl.lazy.LazyIterableAdapter;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iList;
import static org.eclipse.collections.impl.factory.Iterables.mSet;

/**
 * Abstract JUnit test for {@link MutableCollection}s.
 */
public abstract class AbstractCollectionTestCase extends AbstractRichIterableTestCase {

    @Test
    public void newEmpty() {
        MutableCollection<Object> collection = this.newWith().newEmpty();
        Verify.assertEmpty(collection);
        Verify.assertSize(0, collection);
        Assert.assertFalse(collection.notEmpty());
    }

    @Test
    public void toImmutable() {
        Verify.assertInstanceOf(MutableCollection.class, this.newWith());
        Verify.assertInstanceOf(ImmutableCollection.class, this.newWith().toImmutable());
    }

    @Override
    protected abstract <T> MutableCollection<T> newWith(T... littleElements);

    @Test
    public void testNewWith() {
        MutableCollection<Integer> collection = this.newWith(1);
        Verify.assertNotEmpty(collection);
        Verify.assertSize(1, collection);
        Verify.assertContains(1, collection);
    }

    @Test
    public void testNewWithWith() {
        MutableCollection<Integer> collection = this.newWith(1, 2);
        Verify.assertNotEmpty(collection);
        Verify.assertSize(2, collection);
        Verify.assertContainsAll(collection, 1, 2);
    }

    @Test
    public void testNewWithWithWith() {
        MutableCollection<Integer> collection = this.newWith(1, 2, 3);
        Verify.assertNotEmpty(collection);
        Verify.assertSize(3, collection);
        Verify.assertContainsAll(collection, 1, 2, 3);
    }

    @Test
    public void testNewWithVarArgs() {
        MutableCollection<Integer> collection = this.newWith(1, 2, 3, 4);
        Verify.assertNotEmpty(collection);
        Verify.assertSize(4, collection);
        Verify.assertContainsAll(collection, 1, 2, 3, 4);
    }

    @Test
    public void addAll() {
        MutableCollection<Integer> collection = this.newWith();
        Assert.assertTrue(collection.addAll(FastList.newListWith(1, 2, 3)));
        Assert.assertFalse(collection.addAll(Collections.emptyList()));
        Verify.assertContainsAll(collection, 1, 2, 3);
        boolean result = collection.addAll(FastList.newListWith(1, 2, 3));
        if (collection.size() == 3) {
            Assert.assertFalse("addAll did not modify the collection", result);
        } else {
            Assert.assertTrue("addAll modified the collection", result);
        }
        Verify.assertContainsAll(collection, 1, 2, 3);
    }

    @Test
    public void addAllIterable() {
        MutableCollection<Integer> collection1 = this.newWith();
        Assert.assertTrue(collection1.addAllIterable(FastList.newListWith(1, 2, 3)));
        Verify.assertContainsAll(collection1, 1, 2, 3);
        boolean result1 = collection1.addAllIterable(FastList.newListWith(1, 2, 3));
        if (collection1.size() == 3) {
            Assert.assertFalse("addAllIterable did not modify the collection", result1);
        } else {
            Assert.assertTrue("addAllIterable modified the collection", result1);
        }
        Verify.assertContainsAll(collection1, 1, 2, 3);
        MutableCollection<Integer> collection2 = this.newWith();
        Assert.assertTrue(collection2.addAllIterable(UnifiedSet.newSetWith(1, 2, 3)));
        Verify.assertContainsAll(collection2, 1, 2, 3);
        boolean result2 = collection2.addAllIterable(UnifiedSet.newSetWith(1, 2, 3));
        if (collection1.size() == 3) {
            Assert.assertFalse("addAllIterable did not modify the collection", result2);
        } else {
            Assert.assertTrue("addAllIterable modified the collection", result2);
        }
        Verify.assertContainsAll(collection2, 1, 2, 3);
    }

    @Test
    public void removeAll() {
        MutableCollection<Integer> objects = this.newWith(1, 2, 3);
        Assert.assertTrue(objects.removeAll(FastList.newListWith(1, 2, 4)));
        Assert.assertEquals(Bags.mutable.of(3), objects.toBag());
        MutableCollection<Integer> objects2 = this.newWith(1, 2, 3);
        Assert.assertFalse(objects2.removeAll(FastList.newListWith(4, 5)));
        Assert.assertEquals(Bags.mutable.of(1, 2, 3), objects2.toBag());
    }

    @Test
    public void removeAllIterable() {
        MutableCollection<Integer> objects = this.newWith(1, 2, 3);
        Assert.assertTrue(objects.removeAllIterable(FastList.newListWith(1, 2, 4)));
        Assert.assertEquals(Bags.mutable.of(3), objects.toBag());
        MutableCollection<Integer> objects2 = this.newWith(1, 2, 3);
        Assert.assertFalse(objects2.removeAllIterable(FastList.newListWith(4, 5)));
        Assert.assertEquals(Bags.mutable.of(1, 2, 3), objects2.toBag());
    }

    @Test
    public void retainAll() {
        MutableCollection<Integer> objects = this.newWith(1, 2, 3);
        Assert.assertTrue(objects.retainAll(mSet(1, 2)));
        Verify.assertSize(2, objects);
        Verify.assertContainsAll(objects, 1, 2);
        MutableCollection<Integer> integers1 = this.newWith(0);
        Assert.assertFalse(integers1.retainAll(FastList.newListWith(1, 0)));
        Assert.assertEquals(Bags.mutable.of(0), integers1.toBag());
        MutableCollection<Integer> integers2 = this.newWith(1, 2, 3);
        Integer copy = new Integer(1);
        Assert.assertTrue(integers2.retainAll(FastList.newListWith(copy)));
        Assert.assertEquals(Bags.mutable.of(1), integers2.toBag());
        Assert.assertNotSame(copy, integers2.getFirst());
    }

    @Test
    public void retainAllIterable() {
        MutableCollection<Integer> objects = this.newWith(1, 2, 3);
        Assert.assertTrue(objects.retainAllIterable(iList(1, 2)));
        Verify.assertSize(2, objects);
        Verify.assertContainsAll(objects, 1, 2);
        MutableCollection<Integer> integers = this.newWith(0);
        Assert.assertFalse(integers.retainAllIterable(FastList.newListWith(1, 0)));
        Assert.assertEquals(Bags.mutable.of(0), integers.toBag());
    }

    @Test
    public void clear() {
        MutableCollection<Integer> objects = this.newWith(1, 2, 3);
        objects.clear();
        Verify.assertSize(0, objects);
        Verify.assertEmpty(objects);
        objects.clear();
        Verify.assertEmpty(objects);
    }

    @Test
    public void injectIntoWith() {
        MutableCollection<Integer> objects = this.newWith(1, 2, 3);
        Integer result = objects.injectIntoWith(1, (injectedValued, item, parameter) -> injectedValued + item + parameter, 0);
        Assert.assertEquals(Integer.valueOf(7), result);
    }

    @Test
    public void removeObject() {
        MutableCollection<Integer> objects = this.newWith(1, 2, 3);
        objects.remove(3);
        Verify.assertSize(2, objects);
    }

    @Test
    public void selectAndRejectWith() {
        MutableCollection<Integer> objects = this.newWith(1, 2);
        Twin<MutableList<Integer>> result = objects.selectAndRejectWith(Object::equals, 1);
        Verify.assertSize(1, result.getOne());
        Verify.assertSize(1, result.getTwo());
    }

    @Test
    public void removeIf() {
        MutableCollection<Integer> objects1 = this.newWith(1, 2, 3);
        objects1.add(null);
        Assert.assertTrue(objects1.removeIf(Predicates.isNull()));
        Verify.assertSize(3, objects1);
        Verify.assertContainsAll(objects1, 1, 2, 3);
        MutableCollection<Integer> objects2 = this.newWith(3, 4, 5);
        Assert.assertTrue(objects2.removeIf(Predicates.equal(3)));
        Assert.assertFalse(objects2.removeIf(Predicates.equal(6)));
        MutableCollection<Integer> objects3 = this.newWith(1, 2, 3, 4, 5);
        Assert.assertTrue(objects3.removeIf(Predicates.greaterThan(0)));
        Assert.assertFalse(objects3.removeIf(Predicates.equal(5)));
    }

    @Test
    public void removeIfWith() {
        MutableCollection<Integer> objects1 = this.newWith(1, 2, 3, 4);
        Assert.assertTrue(objects1.removeIfWith(Predicates2.lessThan(), 3));
        Verify.assertSize(2, objects1);
        Verify.assertContainsAll(objects1, 3, 4);
        Assert.assertFalse(objects1.removeIfWith(Predicates2.greaterThan(), 6));
        MutableCollection<Integer> objects2 = this.newWith(1, 2, 3, 4, 5);
        Assert.assertTrue(objects2.removeIfWith(Predicates2.greaterThan(), 0));
        Assert.assertFalse(objects2.removeIfWith(Predicates2.greaterThan(), 3));
    }

    @Test
    public void with() {
        MutableCollection<Integer> coll = this.newWith(1, 2, 3);
        MutableCollection<Integer> collWith = coll.with(4);
        Assert.assertSame(coll, collWith);
        Assert.assertEquals(this.newWith(1, 2, 3, 4), collWith);
    }

    @Test
    public void withAll() {
        MutableCollection<Integer> coll = this.newWith(1, 2, 3);
        MutableCollection<Integer> collWith = coll.withAll(FastList.newListWith(4, 5));
        Assert.assertSame(coll, collWith);
        Assert.assertEquals(this.newWith(1, 2, 3, 4, 5), collWith);
    }

    @Test
    public void without() {
        MutableCollection<Integer> coll = this.newWith(1, 2, 3);
        MutableCollection<Integer> collWithout = coll.without(2);
        Assert.assertSame(coll, collWithout);
        Assert.assertEquals(this.newWith(1, 3), collWithout);
    }

    @Test
    public void withoutAll() {
        MutableCollection<Integer> coll = this.newWith(1, 2, 3, 4, 5);
        MutableCollection<Integer> collWithout = coll.withoutAll(FastList.newListWith(2, 4));
        Assert.assertSame(coll, collWithout);
        Assert.assertEquals(this.newWith(1, 3, 5), collWithout);
    }

    @Test
    public void largeCollectionStreamToBagMultimap() {
        MutableCollection<Integer> collection = this.newWith(Interval.oneTo(100000).toArray());
        MutableBagMultimap<Integer, Integer> expected = collection.groupBy(each -> each % 100, Multimaps.mutable.bag.empty());
        Assert.assertEquals(expected, collection.stream().collect(Collectors2.toBagMultimap(each -> each % 100)));
        Assert.assertEquals(expected, collection.parallelStream().collect(Collectors2.toBagMultimap(each -> each % 100)));
    }

    @Test
    public void asLazy() {
        Verify.assertInstanceOf(LazyIterableAdapter.class, this.newWith().asLazy());
    }

    @Test
    public abstract void asSynchronized();

    @Test
    public abstract void asUnmodifiable();

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractCollectionTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_safe);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_safe);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minByOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxByOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNoneBlock() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNoneBlock);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAny() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAny);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_not_only_one_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_not_only_one_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding1);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding2);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding1);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding2);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumInteger);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloatConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloatConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDoubleConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDoubleConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_null);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_null);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedListBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortSet_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSet_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSetBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy_with_null);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMapBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBiMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBiMap);
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
        public void benchmark_makeStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparatorAndStartAndEnd);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_fusedCollectMakeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.fusedCollectMakeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparatorAndStartAndEnd);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringThrows);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws_for_duplicate);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_for_duplicate);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_single() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_single);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithWithWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithVarArgs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithVarArgs);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectAndRejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectAndRejectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIfWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIfWith);
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
        public void benchmark_largeCollectionStreamToBagMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.largeCollectionStreamToBagMultimap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractCollectionTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCollectionTestCase> asUnmodifiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = AbstractCollectionTestCase::testNewCollection;
            this.payloads.equalsAndHashCode = AbstractCollectionTestCase::equalsAndHashCode;
            this.payloads.contains = AbstractCollectionTestCase::contains;
            this.payloads.containsBy = AbstractCollectionTestCase::containsBy;
            this.payloads.containsAllIterable = AbstractCollectionTestCase::containsAllIterable;
            this.payloads.containsAnyIterable = AbstractCollectionTestCase::containsAnyIterable;
            this.payloads.containsNoneIterable = AbstractCollectionTestCase::containsNoneIterable;
            this.payloads.containsAllArray = AbstractCollectionTestCase::containsAllArray;
            this.payloads.containsAnyCollection = AbstractCollectionTestCase::containsAnyCollection;
            this.payloads.containsNoneCollection = AbstractCollectionTestCase::containsNoneCollection;
            this.payloads.containsAllCollection = AbstractCollectionTestCase::containsAllCollection;
            this.payloads.tap = AbstractCollectionTestCase::tap;
            this.payloads.forEach = AbstractCollectionTestCase::forEach;
            this.payloads.forEachWith = AbstractCollectionTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractCollectionTestCase::forEachWithIndex;
            this.payloads.select = AbstractCollectionTestCase::select;
            this.payloads.selectWith = AbstractCollectionTestCase::selectWith;
            this.payloads.selectWith_target = AbstractCollectionTestCase::selectWith_target;
            this.payloads.reject = AbstractCollectionTestCase::reject;
            this.payloads.rejectWith = AbstractCollectionTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractCollectionTestCase::rejectWith_target;
            this.payloads.selectInstancesOf = AbstractCollectionTestCase::selectInstancesOf;
            this.payloads.collect = AbstractCollectionTestCase::collect;
            this.payloads.collectTarget = AbstractCollectionTestCase::collectTarget;
            this.payloads.collectBoolean = AbstractCollectionTestCase::collectBoolean;
            this.payloads.collectBooleanWithTarget = AbstractCollectionTestCase::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = AbstractCollectionTestCase::collectBooleanWithBagTarget;
            this.payloads.collectByte = AbstractCollectionTestCase::collectByte;
            this.payloads.collectByteWithTarget = AbstractCollectionTestCase::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = AbstractCollectionTestCase::collectByteWithBagTarget;
            this.payloads.collectChar = AbstractCollectionTestCase::collectChar;
            this.payloads.collectCharWithTarget = AbstractCollectionTestCase::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = AbstractCollectionTestCase::collectCharWithBagTarget;
            this.payloads.collectDouble = AbstractCollectionTestCase::collectDouble;
            this.payloads.collectDoubleWithTarget = AbstractCollectionTestCase::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = AbstractCollectionTestCase::collectDoubleWithBagTarget;
            this.payloads.collectFloat = AbstractCollectionTestCase::collectFloat;
            this.payloads.collectFloatWithTarget = AbstractCollectionTestCase::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = AbstractCollectionTestCase::collectFloatWithBagTarget;
            this.payloads.collectInt = AbstractCollectionTestCase::collectInt;
            this.payloads.collectIntWithTarget = AbstractCollectionTestCase::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = AbstractCollectionTestCase::collectIntWithBagTarget;
            this.payloads.collectLong = AbstractCollectionTestCase::collectLong;
            this.payloads.collectLongWithTarget = AbstractCollectionTestCase::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = AbstractCollectionTestCase::collectLongWithBagTarget;
            this.payloads.collectShort = AbstractCollectionTestCase::collectShort;
            this.payloads.collectShortWithTarget = AbstractCollectionTestCase::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = AbstractCollectionTestCase::collectShortWithBagTarget;
            this.payloads.flatCollect = AbstractCollectionTestCase::flatCollect;
            this.payloads.flatCollectWith = AbstractCollectionTestCase::flatCollectWith;
            this.payloads.flatCollectBoolean = AbstractCollectionTestCase::flatCollectBoolean;
            this.payloads.flatCollectByte = AbstractCollectionTestCase::flatCollectByte;
            this.payloads.flatCollectShort = AbstractCollectionTestCase::flatCollectShort;
            this.payloads.flatCollectInt = AbstractCollectionTestCase::flatCollectInt;
            this.payloads.flatCollectChar = AbstractCollectionTestCase::flatCollectChar;
            this.payloads.flatCollectLong = AbstractCollectionTestCase::flatCollectLong;
            this.payloads.flatCollectDouble = AbstractCollectionTestCase::flatCollectDouble;
            this.payloads.flatCollectFloat = AbstractCollectionTestCase::flatCollectFloat;
            this.payloads.detect = AbstractCollectionTestCase::detect;
            this.payloads.detectOptional = AbstractCollectionTestCase::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCollectionTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCollectionTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCollectionTestCase::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCollectionTestCase::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = AbstractCollectionTestCase::min;
            this.payloads.minOptional = AbstractCollectionTestCase::minOptional;
            this.payloads.max = AbstractCollectionTestCase::max;
            this.payloads.maxOptional = AbstractCollectionTestCase::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCollectionTestCase::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCollectionTestCase::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = AbstractCollectionTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractCollectionTestCase::max_without_comparator;
            this.payloads.min_null_safe = AbstractCollectionTestCase::min_null_safe;
            this.payloads.max_null_safe = AbstractCollectionTestCase::max_null_safe;
            this.payloads.minBy = AbstractCollectionTestCase::minBy;
            this.payloads.minByOptional = AbstractCollectionTestCase::minByOptional;
            this.payloads.maxBy = AbstractCollectionTestCase::maxBy;
            this.payloads.maxByOptional = AbstractCollectionTestCase::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCollectionTestCase::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCollectionTestCase::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = AbstractCollectionTestCase::detectWith;
            this.payloads.detectWithOptional = AbstractCollectionTestCase::detectWithOptional;
            this.payloads.detectIfNone = AbstractCollectionTestCase::detectIfNone;
            this.payloads.detectWithIfNoneBlock = AbstractCollectionTestCase::detectWithIfNoneBlock;
            this.payloads.allSatisfy = AbstractCollectionTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractCollectionTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractCollectionTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractCollectionTestCase::noneSatisfyWith;
            this.payloads.anySatisfy = AbstractCollectionTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractCollectionTestCase::anySatisfyWith;
            this.payloads.count = AbstractCollectionTestCase::count;
            this.payloads.countWith = AbstractCollectionTestCase::countWith;
            this.payloads.collectIf = AbstractCollectionTestCase::collectIf;
            this.payloads.collectWith = AbstractCollectionTestCase::collectWith;
            this.payloads.collectWith_target = AbstractCollectionTestCase::collectWith_target;
            this.payloads.getAny = AbstractCollectionTestCase::getAny;
            this.payloads.getFirst = AbstractCollectionTestCase::getFirst;
            this.payloads.getLast = AbstractCollectionTestCase::getLast;
            this.payloads.getOnly = AbstractCollectionTestCase::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCollectionTestCase::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCollectionTestCase::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = AbstractCollectionTestCase::isEmpty;
            this.payloads.iterator = AbstractCollectionTestCase::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCollectionTestCase::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = AbstractCollectionTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractCollectionTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractCollectionTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractCollectionTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractCollectionTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractCollectionTestCase::sumFloat;
            this.payloads.summarizeFloat = AbstractCollectionTestCase::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = AbstractCollectionTestCase::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = AbstractCollectionTestCase::sumFloatConsistentRounding2;
            this.payloads.sumDouble = AbstractCollectionTestCase::sumDouble;
            this.payloads.summarizeDouble = AbstractCollectionTestCase::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = AbstractCollectionTestCase::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = AbstractCollectionTestCase::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = AbstractCollectionTestCase::sumInteger;
            this.payloads.summarizeInt = AbstractCollectionTestCase::summarizeInt;
            this.payloads.sumLong = AbstractCollectionTestCase::sumLong;
            this.payloads.summarizeLong = AbstractCollectionTestCase::summarizeLong;
            this.payloads.sumByInt = AbstractCollectionTestCase::sumByInt;
            this.payloads.sumByFloat = AbstractCollectionTestCase::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = AbstractCollectionTestCase::sumByFloatConsistentRounding;
            this.payloads.sumByLong = AbstractCollectionTestCase::sumByLong;
            this.payloads.sumByDouble = AbstractCollectionTestCase::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = AbstractCollectionTestCase::sumByDoubleConsistentRounding;
            this.payloads.toArray = AbstractCollectionTestCase::toArray;
            this.payloads.partition = AbstractCollectionTestCase::partition;
            this.payloads.partitionWith = AbstractCollectionTestCase::partitionWith;
            this.payloads.toList = AbstractCollectionTestCase::toList;
            this.payloads.toImmutableList = AbstractCollectionTestCase::toImmutableList;
            this.payloads.toCollection = AbstractCollectionTestCase::toCollection;
            this.payloads.toBag = AbstractCollectionTestCase::toBag;
            this.payloads.toImmutableBag = AbstractCollectionTestCase::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = AbstractCollectionTestCase::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = AbstractCollectionTestCase::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = AbstractCollectionTestCase::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = AbstractCollectionTestCase::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCollectionTestCase::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = AbstractCollectionTestCase::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = AbstractCollectionTestCase::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = AbstractCollectionTestCase::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = AbstractCollectionTestCase::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCollectionTestCase::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = AbstractCollectionTestCase::toSortedBagBy;
            this.payloads.toImmutableSortedBagBy = AbstractCollectionTestCase::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = AbstractCollectionTestCase::toSortedListBy;
            this.payloads.toImmutableSortedListBy = AbstractCollectionTestCase::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = AbstractCollectionTestCase::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = AbstractCollectionTestCase::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = AbstractCollectionTestCase::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = AbstractCollectionTestCase::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractCollectionTestCase::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = AbstractCollectionTestCase::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCollectionTestCase::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = AbstractCollectionTestCase::toSet;
            this.payloads.toImmutableSet = AbstractCollectionTestCase::toImmutableSet;
            this.payloads.toMap = AbstractCollectionTestCase::toMap;
            this.payloads.toImmutableMap = AbstractCollectionTestCase::toImmutableMap;
            this.payloads.toMapTarget = AbstractCollectionTestCase::toMapTarget;
            this.payloads.toSortedMap = AbstractCollectionTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractCollectionTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractCollectionTestCase::toSortedMapBy;
            this.payloads.toBiMap = AbstractCollectionTestCase::toBiMap;
            this.payloads.toImmutableBiMap = AbstractCollectionTestCase::toImmutableBiMap;
            this.payloads.testToString = AbstractCollectionTestCase::testToString;
            this.payloads.makeString = AbstractCollectionTestCase::makeString;
            this.payloads.makeStringWithSeparator = AbstractCollectionTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = AbstractCollectionTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = AbstractCollectionTestCase::fusedCollectMakeString;
            this.payloads.appendString = AbstractCollectionTestCase::appendString;
            this.payloads.appendStringWithSeparator = AbstractCollectionTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = AbstractCollectionTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = AbstractCollectionTestCase::appendStringThrows;
            this.payloads.countBy = AbstractCollectionTestCase::countBy;
            this.payloads.countByWith = AbstractCollectionTestCase::countByWith;
            this.payloads.countByEach = AbstractCollectionTestCase::countByEach;
            this.payloads.groupBy = AbstractCollectionTestCase::groupBy;
            this.payloads.groupByEach = AbstractCollectionTestCase::groupByEach;
            this.payloads.groupByUniqueKey = AbstractCollectionTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCollectionTestCase::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = AbstractCollectionTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCollectionTestCase::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = AbstractCollectionTestCase::zip;
            this.payloads.zipWithIndex = AbstractCollectionTestCase::zipWithIndex;
            this.payloads.chunk = AbstractCollectionTestCase::chunk;
            this.payloads.chunk_empty = AbstractCollectionTestCase::chunk_empty;
            this.payloads.chunk_single = AbstractCollectionTestCase::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCollectionTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractCollectionTestCase::chunk_large_size;
            this.payloads.empty = AbstractCollectionTestCase::empty;
            this.payloads.notEmpty = AbstractCollectionTestCase::notEmpty;
            this.payloads.aggregateByMutating = AbstractCollectionTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractCollectionTestCase::aggregateByNonMutating;
            this.payloads.reduceOptional = AbstractCollectionTestCase::reduceOptional;
            this.payloads.newEmpty = AbstractCollectionTestCase::newEmpty;
            this.payloads.toImmutable = AbstractCollectionTestCase::toImmutable;
            this.payloads.testNewWith = AbstractCollectionTestCase::testNewWith;
            this.payloads.testNewWithWith = AbstractCollectionTestCase::testNewWithWith;
            this.payloads.testNewWithWithWith = AbstractCollectionTestCase::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = AbstractCollectionTestCase::testNewWithVarArgs;
            this.payloads.addAll = AbstractCollectionTestCase::addAll;
            this.payloads.addAllIterable = AbstractCollectionTestCase::addAllIterable;
            this.payloads.removeAll = AbstractCollectionTestCase::removeAll;
            this.payloads.removeAllIterable = AbstractCollectionTestCase::removeAllIterable;
            this.payloads.retainAll = AbstractCollectionTestCase::retainAll;
            this.payloads.retainAllIterable = AbstractCollectionTestCase::retainAllIterable;
            this.payloads.clear = AbstractCollectionTestCase::clear;
            this.payloads.injectIntoWith = AbstractCollectionTestCase::injectIntoWith;
            this.payloads.removeObject = AbstractCollectionTestCase::removeObject;
            this.payloads.selectAndRejectWith = AbstractCollectionTestCase::selectAndRejectWith;
            this.payloads.removeIf = AbstractCollectionTestCase::removeIf;
            this.payloads.removeIfWith = AbstractCollectionTestCase::removeIfWith;
            this.payloads.with = AbstractCollectionTestCase::with;
            this.payloads.withAll = AbstractCollectionTestCase::withAll;
            this.payloads.without = AbstractCollectionTestCase::without;
            this.payloads.withoutAll = AbstractCollectionTestCase::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = AbstractCollectionTestCase::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = AbstractCollectionTestCase::asLazy;
            this.payloads.asSynchronized = AbstractCollectionTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractCollectionTestCase::asUnmodifiable;
        }
    }
*/
}
