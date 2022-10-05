/*
 * Copyright (c) 2021 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.mutable;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SetAdapter}.
 */
public class SetAdapterTest extends AbstractMutableSetTestCase {

    @Override
    protected <T> SetAdapter<T> newWith(T... littleElements) {
        return new SetAdapter<>(new HashSet<>(UnifiedSet.newSetWith(littleElements)));
    }

    @Override
    @Test
    public void testToString() {
        MutableCollection<Object> collection = this.newWith(1);
        collection.add(collection);
        String simpleName = collection.getClass().getSimpleName();
        String string = collection.toString();
        Assert.assertTrue(("[1, (this " + simpleName + ")]").equals(string) || ("[(this " + simpleName + "), 1]").equals(string));
    }

    @Override
    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedMutableSet.class, SetAdapter.adapt(new HashSet<>()).asSynchronized());
    }

    @Override
    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableMutableSet.class, this.newWith().asUnmodifiable());
    }

    @Test
    public void adapt() {
        MutableSet<Integer> adapter1 = SetAdapter.adapt(Sets.fixedSize.of(1, 2, 3, 4));
        MutableSet<Integer> adapter2 = new SetAdapter<Integer>(new HashSet<>()).with(1, 2, 3, 4);
        MutableSet<Integer> adapter3 = Sets.adapt(Sets.fixedSize.of(1, 2, 3, 4));
        Verify.assertEqualsAndHashCode(adapter1, adapter2);
        Verify.assertEqualsAndHashCode(adapter2, adapter3);
    }

    @Override
    @Test
    public void select() {
        super.select();
        Verify.assertContainsAll(this.newWith(1, 2, 3, 4, 5).select(Predicates.lessThan(3)), 1, 2);
        Verify.assertContainsAll(this.newWith(-1, 2, 3, 4, 5).select(Predicates.lessThan(3), FastList.newList()), -1, 2);
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        Verify.assertContainsAll(this.newWith(1, 2, 3, 4).reject(Predicates.lessThan(3)), 3, 4);
        Verify.assertContainsAll(this.newWith(1, 2, 3, 4).reject(Predicates.lessThan(3), FastList.newList()), 3, 4);
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        Verify.assertContainsAll(this.newWith(1, 2, 3, 4).collect(String::valueOf), "1", "2", "3", "4");
        Verify.assertContainsAll(this.newWith(1, 2, 3, 4).collect(String::valueOf, FastList.newList()), "1", "2", "3", "4");
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        MutableCollection<Integer> set1 = this.newWith(1, 2, 3);
        MutableCollection<Integer> set2 = this.newWith(1, 2, 3);
        MutableCollection<Integer> set3 = this.newWith(2, 3, 4);
        MutableSet<Integer> set4 = UnifiedSet.newSet();
        set4.add(2);
        set4.add(3);
        set4.add(4);
        Assert.assertNotEquals(set1, null);
        Verify.assertEqualsAndHashCode(set1, set1);
        Verify.assertEqualsAndHashCode(set1, set2);
        Assert.assertNotEquals(set2, set3);
        Verify.assertEqualsAndHashCode(set3, set4);
    }

    @Test
    public void newListWithSize() {
        Collection<Integer> collection = this.newWith(1, 2, 3);
        Verify.assertContainsAll(collection, 1, 2, 3);
    }

    @Test
    public void serialization() {
        MutableCollection<Integer> collection = this.newWith(1, 2, 3, 4, 5);
        MutableCollection<Integer> deserializedCollection = SerializeTestHelper.serializeDeserialize(collection);
        Verify.assertSize(5, deserializedCollection);
        Verify.assertContainsAll(deserializedCollection, 1, 2, 3, 4, 5);
        Assert.assertEquals(collection, deserializedCollection);
    }

    @Override
    @Test
    public void forEachWithIndex() {
        MutableList<Integer> result = Lists.mutable.of();
        MutableCollection<Integer> collection = this.newWith(1, 2, 3, 4);
        collection.forEachWithIndex((object, index) -> result.add(object));
        Verify.assertContainsAll(result, 1, 2, 3, 4);
    }

    @Override
    @Test
    public void getFirst() {
        Assert.assertNotNull(this.newWith(1, 2, 3).getFirst());
        Assert.assertNull(this.newWith().getFirst());
    }

    @Override
    @Test
    public void getLast() {
        Assert.assertNotNull(this.newWith(1, 2, 3).getLast());
        Assert.assertNull(this.newWith().getLast());
    }

    @Override
    @Test
    public void iterator() {
        MutableCollection<Integer> objects = this.newWith(1, 2, 3);
        MutableList<Integer> result = Lists.mutable.of();
        Iterator<Integer> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Integer integer = iterator.next();
            result.add(integer);
        }
        Verify.assertStartsWith(result.sortThis(Collections.reverseOrder()), 3, 2, 1);
    }

    @Test
    public void withMethods() {
        Verify.assertContainsAll(this.newWith().with(1), 1);
        Verify.assertContainsAll(this.newWith().with(1, 2), 1, 2);
        Verify.assertContainsAll(this.newWith().with(1, 2, 3), 1, 2, 3);
        Verify.assertContainsAll(this.newWith().with(1, 2, 3, 4), 1, 2, 3, 4);
    }

    @Test
    public void returnType() {
        // Type HashSet is important here because it's not a MutableSet
        Set<Integer> set = new HashSet<>();
        MutableSet<Integer> integerSetAdapter = SetAdapter.adapt(set);
        Verify.assertInstanceOf(MutableSet.class, integerSetAdapter.select(ignored -> true));
    }

    @Test
    public void adaptNull() {
        Assert.assertThrows(NullPointerException.class, () -> new SetAdapter<>(null));
        Assert.assertThrows(NullPointerException.class, () -> SetAdapter.adapt(null));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SetAdapterTest instance;

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
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
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
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
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
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
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
        public void benchmark_toImmutableSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_natural_ordering);
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
        public void benchmark_fusedCollectMakeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.fusedCollectMakeString);
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
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
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
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
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
        public void benchmark_removeAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectAndRejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectAndRejectWith);
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
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
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
        public void benchmark_unifiedSetKeySetToArrayDest() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.unifiedSetKeySetToArrayDest);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unifiedSetToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.unifiedSetToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
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
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
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
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_increment_past_end() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_increment_past_end);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_remove_without_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_remove_without_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_natural_ordering);
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
        public void benchmark_frequentCollisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.frequentCollisions);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_adapt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.adapt);
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
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWithSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWithSize);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
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
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMethods() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMethods);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_returnType() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.returnType);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_adaptNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.adaptNull);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> payload) throws java.lang.Throwable {
            this.instance = new SetAdapterTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> unionInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> intersectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> differenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> symmetricDifferenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> powerSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> unifiedSetKeySetToArrayDest;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> unifiedSetToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> iterator_increment_past_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> iterator_remove_without_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> frequentCollisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> adapt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> newListWithSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> withMethods;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> returnType;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterTest> adaptNull;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = SetAdapterTest::testNewCollection;
            this.payloads.contains = SetAdapterTest::contains;
            this.payloads.containsBy = SetAdapterTest::containsBy;
            this.payloads.containsAllIterable = SetAdapterTest::containsAllIterable;
            this.payloads.containsAnyIterable = SetAdapterTest::containsAnyIterable;
            this.payloads.containsNoneIterable = SetAdapterTest::containsNoneIterable;
            this.payloads.containsAllArray = SetAdapterTest::containsAllArray;
            this.payloads.containsAnyCollection = SetAdapterTest::containsAnyCollection;
            this.payloads.containsNoneCollection = SetAdapterTest::containsNoneCollection;
            this.payloads.containsAllCollection = SetAdapterTest::containsAllCollection;
            this.payloads.selectWith = SetAdapterTest::selectWith;
            this.payloads.selectWith_target = SetAdapterTest::selectWith_target;
            this.payloads.rejectWith = SetAdapterTest::rejectWith;
            this.payloads.rejectWith_target = SetAdapterTest::rejectWith_target;
            this.payloads.selectInstancesOf = SetAdapterTest::selectInstancesOf;
            this.payloads.collectTarget = SetAdapterTest::collectTarget;
            this.payloads.collectBoolean = SetAdapterTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = SetAdapterTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = SetAdapterTest::collectBooleanWithBagTarget;
            this.payloads.collectByte = SetAdapterTest::collectByte;
            this.payloads.collectByteWithTarget = SetAdapterTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = SetAdapterTest::collectByteWithBagTarget;
            this.payloads.collectChar = SetAdapterTest::collectChar;
            this.payloads.collectCharWithTarget = SetAdapterTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = SetAdapterTest::collectCharWithBagTarget;
            this.payloads.collectDouble = SetAdapterTest::collectDouble;
            this.payloads.collectDoubleWithTarget = SetAdapterTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = SetAdapterTest::collectDoubleWithBagTarget;
            this.payloads.collectFloat = SetAdapterTest::collectFloat;
            this.payloads.collectFloatWithTarget = SetAdapterTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = SetAdapterTest::collectFloatWithBagTarget;
            this.payloads.collectInt = SetAdapterTest::collectInt;
            this.payloads.collectIntWithTarget = SetAdapterTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = SetAdapterTest::collectIntWithBagTarget;
            this.payloads.collectLong = SetAdapterTest::collectLong;
            this.payloads.collectLongWithTarget = SetAdapterTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = SetAdapterTest::collectLongWithBagTarget;
            this.payloads.collectShort = SetAdapterTest::collectShort;
            this.payloads.collectShortWithTarget = SetAdapterTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = SetAdapterTest::collectShortWithBagTarget;
            this.payloads.flatCollect = SetAdapterTest::flatCollect;
            this.payloads.flatCollectWith = SetAdapterTest::flatCollectWith;
            this.payloads.flatCollectBoolean = SetAdapterTest::flatCollectBoolean;
            this.payloads.flatCollectByte = SetAdapterTest::flatCollectByte;
            this.payloads.flatCollectShort = SetAdapterTest::flatCollectShort;
            this.payloads.flatCollectInt = SetAdapterTest::flatCollectInt;
            this.payloads.flatCollectChar = SetAdapterTest::flatCollectChar;
            this.payloads.flatCollectLong = SetAdapterTest::flatCollectLong;
            this.payloads.flatCollectDouble = SetAdapterTest::flatCollectDouble;
            this.payloads.flatCollectFloat = SetAdapterTest::flatCollectFloat;
            this.payloads.detectOptional = SetAdapterTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = SetAdapterTest::min;
            this.payloads.minOptional = SetAdapterTest::minOptional;
            this.payloads.max = SetAdapterTest::max;
            this.payloads.maxOptional = SetAdapterTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = SetAdapterTest::min_without_comparator;
            this.payloads.max_without_comparator = SetAdapterTest::max_without_comparator;
            this.payloads.min_null_safe = SetAdapterTest::min_null_safe;
            this.payloads.max_null_safe = SetAdapterTest::max_null_safe;
            this.payloads.minBy = SetAdapterTest::minBy;
            this.payloads.minByOptional = SetAdapterTest::minByOptional;
            this.payloads.maxBy = SetAdapterTest::maxBy;
            this.payloads.maxByOptional = SetAdapterTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = SetAdapterTest::detectWith;
            this.payloads.detectWithOptional = SetAdapterTest::detectWithOptional;
            this.payloads.detectIfNone = SetAdapterTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = SetAdapterTest::detectWithIfNoneBlock;
            this.payloads.count = SetAdapterTest::count;
            this.payloads.countWith = SetAdapterTest::countWith;
            this.payloads.collectIf = SetAdapterTest::collectIf;
            this.payloads.collectWith = SetAdapterTest::collectWith;
            this.payloads.collectWith_target = SetAdapterTest::collectWith_target;
            this.payloads.getAny = SetAdapterTest::getAny;
            this.payloads.getOnly = SetAdapterTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = SetAdapterTest::injectInto;
            this.payloads.injectIntoInt = SetAdapterTest::injectIntoInt;
            this.payloads.injectIntoLong = SetAdapterTest::injectIntoLong;
            this.payloads.injectIntoDouble = SetAdapterTest::injectIntoDouble;
            this.payloads.injectIntoFloat = SetAdapterTest::injectIntoFloat;
            this.payloads.sumFloat = SetAdapterTest::sumFloat;
            this.payloads.summarizeFloat = SetAdapterTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = SetAdapterTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = SetAdapterTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = SetAdapterTest::sumDouble;
            this.payloads.summarizeDouble = SetAdapterTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = SetAdapterTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = SetAdapterTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = SetAdapterTest::sumInteger;
            this.payloads.summarizeInt = SetAdapterTest::summarizeInt;
            this.payloads.sumLong = SetAdapterTest::sumLong;
            this.payloads.summarizeLong = SetAdapterTest::summarizeLong;
            this.payloads.sumByInt = SetAdapterTest::sumByInt;
            this.payloads.sumByFloat = SetAdapterTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = SetAdapterTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = SetAdapterTest::sumByLong;
            this.payloads.sumByDouble = SetAdapterTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = SetAdapterTest::sumByDoubleConsistentRounding;
            this.payloads.partition = SetAdapterTest::partition;
            this.payloads.partitionWith = SetAdapterTest::partitionWith;
            this.payloads.toList = SetAdapterTest::toList;
            this.payloads.toImmutableList = SetAdapterTest::toImmutableList;
            this.payloads.toCollection = SetAdapterTest::toCollection;
            this.payloads.toBag = SetAdapterTest::toBag;
            this.payloads.toImmutableBag = SetAdapterTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = SetAdapterTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = SetAdapterTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = SetAdapterTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = SetAdapterTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBag_natural_ordering = SetAdapterTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBagBy = SetAdapterTest::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = SetAdapterTest::toSortedListBy;
            this.payloads.toImmutableSortedListBy = SetAdapterTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = SetAdapterTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = SetAdapterTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = SetAdapterTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = SetAdapterTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = SetAdapterTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = SetAdapterTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = SetAdapterTest::toSet;
            this.payloads.toImmutableSet = SetAdapterTest::toImmutableSet;
            this.payloads.toMap = SetAdapterTest::toMap;
            this.payloads.toImmutableMap = SetAdapterTest::toImmutableMap;
            this.payloads.toMapTarget = SetAdapterTest::toMapTarget;
            this.payloads.toSortedMap = SetAdapterTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = SetAdapterTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = SetAdapterTest::toSortedMapBy;
            this.payloads.toBiMap = SetAdapterTest::toBiMap;
            this.payloads.toImmutableBiMap = SetAdapterTest::toImmutableBiMap;
            this.payloads.makeString = SetAdapterTest::makeString;
            this.payloads.makeStringWithSeparator = SetAdapterTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = SetAdapterTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = SetAdapterTest::fusedCollectMakeString;
            this.payloads.appendString = SetAdapterTest::appendString;
            this.payloads.appendStringWithSeparator = SetAdapterTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = SetAdapterTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = SetAdapterTest::appendStringThrows;
            this.payloads.countBy = SetAdapterTest::countBy;
            this.payloads.countByWith = SetAdapterTest::countByWith;
            this.payloads.countByEach = SetAdapterTest::countByEach;
            this.payloads.groupBy = SetAdapterTest::groupBy;
            this.payloads.groupByEach = SetAdapterTest::groupByEach;
            this.payloads.groupByUniqueKey = SetAdapterTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = SetAdapterTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = SetAdapterTest::zip;
            this.payloads.zipWithIndex = SetAdapterTest::zipWithIndex;
            this.payloads.chunk = SetAdapterTest::chunk;
            this.payloads.chunk_empty = SetAdapterTest::chunk_empty;
            this.payloads.chunk_single = SetAdapterTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = SetAdapterTest::chunk_large_size;
            this.payloads.empty = SetAdapterTest::empty;
            this.payloads.notEmpty = SetAdapterTest::notEmpty;
            this.payloads.aggregateByMutating = SetAdapterTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = SetAdapterTest::aggregateByNonMutating;
            this.payloads.reduceOptional = SetAdapterTest::reduceOptional;
            this.payloads.newEmpty = SetAdapterTest::newEmpty;
            this.payloads.toImmutable = SetAdapterTest::toImmutable;
            this.payloads.testNewWith = SetAdapterTest::testNewWith;
            this.payloads.testNewWithWith = SetAdapterTest::testNewWithWith;
            this.payloads.testNewWithWithWith = SetAdapterTest::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = SetAdapterTest::testNewWithVarArgs;
            this.payloads.removeAll = SetAdapterTest::removeAll;
            this.payloads.removeAllIterable = SetAdapterTest::removeAllIterable;
            this.payloads.retainAllIterable = SetAdapterTest::retainAllIterable;
            this.payloads.clear = SetAdapterTest::clear;
            this.payloads.injectIntoWith = SetAdapterTest::injectIntoWith;
            this.payloads.removeObject = SetAdapterTest::removeObject;
            this.payloads.selectAndRejectWith = SetAdapterTest::selectAndRejectWith;
            this.payloads.removeIfWith = SetAdapterTest::removeIfWith;
            this.payloads.with = SetAdapterTest::with;
            this.payloads.withAll = SetAdapterTest::withAll;
            this.payloads.without = SetAdapterTest::without;
            this.payloads.withoutAll = SetAdapterTest::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = SetAdapterTest::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = SetAdapterTest::asLazy;
            this.payloads.addAll = SetAdapterTest::addAll;
            this.payloads.addAllIterable = SetAdapterTest::addAllIterable;
            this.payloads.union = SetAdapterTest::union;
            this.payloads.unionInto = SetAdapterTest::unionInto;
            this.payloads.intersect = SetAdapterTest::intersect;
            this.payloads.intersectInto = SetAdapterTest::intersectInto;
            this.payloads.difference = SetAdapterTest::difference;
            this.payloads.differenceInto = SetAdapterTest::differenceInto;
            this.payloads.symmetricDifference = SetAdapterTest::symmetricDifference;
            this.payloads.symmetricDifferenceInto = SetAdapterTest::symmetricDifferenceInto;
            this.payloads.isSubsetOf = SetAdapterTest::isSubsetOf;
            this.payloads.isProperSubsetOf = SetAdapterTest::isProperSubsetOf;
            this.payloads.powerSet = SetAdapterTest::powerSet;
            this.payloads.cartesianProduct = SetAdapterTest::cartesianProduct;
            this.payloads.unifiedSetKeySetToArrayDest = SetAdapterTest::unifiedSetKeySetToArrayDest;
            this.payloads.unifiedSetToString = SetAdapterTest::unifiedSetToString;
            this.payloads.testClone = SetAdapterTest::testClone;
            this.payloads.isEmpty = SetAdapterTest::isEmpty;
            this.payloads.add = SetAdapterTest::add;
            this.payloads.removeIf = SetAdapterTest::removeIf;
            this.payloads.retainAll = SetAdapterTest::retainAll;
            this.payloads.tap = SetAdapterTest::tap;
            this.payloads.forEach = SetAdapterTest::forEach;
            this.payloads.forEachWith = SetAdapterTest::forEachWith;
            this.payloads.anySatisfy = SetAdapterTest::anySatisfy;
            this.payloads.anySatisfyWith = SetAdapterTest::anySatisfyWith;
            this.payloads.allSatisfy = SetAdapterTest::allSatisfy;
            this.payloads.allSatisfyWith = SetAdapterTest::allSatisfyWith;
            this.payloads.noneSatisfy = SetAdapterTest::noneSatisfy;
            this.payloads.noneSatisfyWith = SetAdapterTest::noneSatisfyWith;
            this.payloads.detect = SetAdapterTest::detect;
            this.payloads.iterator_increment_past_end = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterTest::iterator_increment_past_end, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_without_next = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterTest::iterator_remove_without_next, java.lang.IllegalStateException.class);
            this.payloads.toArray = SetAdapterTest::toArray;
            this.payloads.toSortedBag_natural_ordering = SetAdapterTest::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = SetAdapterTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = SetAdapterTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = SetAdapterTest::toSortedBagBy;
            this.payloads.frequentCollisions = SetAdapterTest::frequentCollisions;
            this.payloads.testToString = SetAdapterTest::testToString;
            this.payloads.asSynchronized = SetAdapterTest::asSynchronized;
            this.payloads.asUnmodifiable = SetAdapterTest::asUnmodifiable;
            this.payloads.adapt = SetAdapterTest::adapt;
            this.payloads.select = SetAdapterTest::select;
            this.payloads.reject = SetAdapterTest::reject;
            this.payloads.collect = SetAdapterTest::collect;
            this.payloads.equalsAndHashCode = SetAdapterTest::equalsAndHashCode;
            this.payloads.newListWithSize = SetAdapterTest::newListWithSize;
            this.payloads.serialization = SetAdapterTest::serialization;
            this.payloads.forEachWithIndex = SetAdapterTest::forEachWithIndex;
            this.payloads.getFirst = SetAdapterTest::getFirst;
            this.payloads.getLast = SetAdapterTest::getLast;
            this.payloads.iterator = SetAdapterTest::iterator;
            this.payloads.withMethods = SetAdapterTest::withMethods;
            this.payloads.returnType = SetAdapterTest::returnType;
            this.payloads.adaptNull = SetAdapterTest::adaptNull;
        }
    }
}
