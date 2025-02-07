/*
 * Copyright (c) 2021 Bhavana Hindupur.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.strategy.mutable;

import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.HashingStrategy;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.MutableBagTestCase;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.domain.Person;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test suite for {@link HashBagWithHashingStrategy}.
 */
public class HashBagWithHashingStrategyTest extends MutableBagTestCase {

    private static final HashingStrategy<Person> FIRST_NAME_HASHING_STRATEGY = HashingStrategies.fromFunction(Person.TO_FIRST);

    private static final HashingStrategy<Person> LAST_NAME_HASHING_STRATEGY = HashingStrategies.fromFunction(Person.TO_LAST);

    private static final Person JOHNSMITH = new Person("John", "Smith");

    private static final Person JANESMITH = new Person("Jane", "Smith");

    private static final Person JOHNDOE = new Person("John", "Doe");

    private static final Person JANEDOE = new Person("Jane", "Doe");

    @Override
    protected <T> MutableBag<T> newWith(T... littleElements) {
        return HashBagWithHashingStrategy.newBagWith(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy()), littleElements);
    }

    @Override
    protected <T> MutableBag<T> newWithOccurrences(ObjectIntPair<T>... elementsWithOccurrences) {
        MutableBag<T> bag = this.newWith();
        for (int i = 0; i < elementsWithOccurrences.length; i++) {
            ObjectIntPair<T> itemToAdd = elementsWithOccurrences[i];
            bag.addOccurrences(itemToAdd.getOne(), itemToAdd.getTwo());
        }
        return bag;
    }

    @Test
    public void newBag_throws() {
        Assert.assertThrows(IllegalArgumentException.class, () -> HashBagWithHashingStrategy.newBag(null));
        Assert.assertThrows(IllegalArgumentException.class, () -> HashBagWithHashingStrategy.newBag(null, 1));
        Assert.assertThrows(IllegalArgumentException.class, () -> HashBagWithHashingStrategy.newBag(null, Bags.mutable.empty()));
        Assert.assertThrows(IllegalArgumentException.class, () -> HashBagWithHashingStrategy.newBag(null, Lists.mutable.empty()));
        Assert.assertThrows(IllegalArgumentException.class, () -> HashBagWithHashingStrategy.newBag(HashingStrategies.defaultStrategy(), -1));
    }

    @Override
    @Test
    public void removeAllIterable() {
        super.removeAllIterable();
        MutableBag<Integer> objects = this.newWith(1, 2, 3);
        Assert.assertTrue(objects.removeAllIterable(Bags.mutable.of(1, 2, 4)));
        Assert.assertEquals(Bags.mutable.of(3), objects.toBag());
    }

    @Override
    @Test
    public void addAll() {
        super.addAll();
        MutableBag<Integer> bag1 = this.newWith();
        Assert.assertTrue(bag1.addAll(this.newWith(1, 1, 2, 3)));
        Verify.assertContainsAll(bag1, 1, 2, 3);
        Assert.assertTrue(bag1.addAll(this.newWith(1, 2, 3)));
        Verify.assertSize(7, bag1);
        Assert.assertFalse(bag1.addAll(this.newWith()));
        Verify.assertContainsAll(bag1, 1, 2, 3);
        MutableBag<Integer> bag2 = this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
        bag2.addAll(this.newWith(5, 5, 5, 5, 5));
        Verify.assertBagsEqual(this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5), bag2);
        MutableBag<Integer> bag3 = this.newWith(1, 2, 2, 3, 3, 3);
        bag3.addAll(this.newWith(1));
        Verify.assertBagsEqual(this.newWith(1, 1, 2, 2, 3, 3, 3), bag3);
    }

    @Test
    public void hashingStrategy() {
        HashBagWithHashingStrategy<Integer> map = HashBagWithHashingStrategy.newBagWith(HashingStrategies.defaultStrategy(), 1, 1, 2, 2);
        Assert.assertSame(HashingStrategies.defaultStrategy(), map.hashingStrategy());
    }

    @Test
    public void contains_with_hashing_strategy() {
        HashBagWithHashingStrategy<Person> bag = HashBagWithHashingStrategy.newBagWith(LAST_NAME_HASHING_STRATEGY, JOHNDOE, JANEDOE, JANEDOE, JOHNSMITH, JOHNSMITH, JOHNSMITH, JANESMITH, JANESMITH, JANESMITH, JANESMITH);
        Verify.assertContains(JOHNDOE, bag);
        Assert.assertEquals(3, bag.occurrencesOf(JOHNDOE));
        Verify.assertContains(JOHNSMITH, bag);
        Assert.assertEquals(7, bag.occurrencesOf(JOHNSMITH));
        Verify.assertContains(JANEDOE, bag);
        Verify.assertContains(JANESMITH, bag);
    }

    @Test
    public void equals_with_hashing_strategy() {
        HashBagWithHashingStrategy<Person> bag1 = HashBagWithHashingStrategy.newBagWith(LAST_NAME_HASHING_STRATEGY, JOHNDOE, JANEDOE, JOHNSMITH, JANESMITH);
        HashBagWithHashingStrategy<Person> bag2 = HashBagWithHashingStrategy.newBagWith(FIRST_NAME_HASHING_STRATEGY, JOHNDOE, JANEDOE, JOHNSMITH, JANESMITH);
        Assert.assertEquals(bag1, bag2);
        Assert.assertEquals(bag2, bag1);
        Assert.assertNotEquals(bag1.hashCode(), bag2.hashCode());
        HashBagWithHashingStrategy<Person> bag3 = HashBagWithHashingStrategy.newBagWith(LAST_NAME_HASHING_STRATEGY, JOHNDOE, JANEDOE, JANEDOE, JOHNSMITH, JOHNSMITH, JOHNSMITH, JANESMITH, JANESMITH, JANESMITH, JANESMITH);
        HashBagWithHashingStrategy<Person> bag4 = HashBagWithHashingStrategy.newBag(bag3.hashingStrategy(), bag3);
        MutableBag<Person> hashBag = HashBag.newBag(bag3);
        Verify.assertEqualsAndHashCode(bag3, bag4);
        Assert.assertTrue(bag3.equals(hashBag) && hashBag.equals(bag3) && bag3.hashCode() != hashBag.hashCode());
        HashBag<Person> people = HashBag.newBagWith(JOHNDOE, JANEDOE, JANEDOE, JOHNSMITH, JOHNSMITH, JOHNSMITH, JANESMITH, JANESMITH, JANESMITH, JANESMITH);
        HashBagWithHashingStrategy<Person> bag5 = HashBagWithHashingStrategy.newBag(LAST_NAME_HASHING_STRATEGY, people);
        Assert.assertNotEquals(bag5, people);
    }

    @Test
    public void addOccurrences_occurrencesOf_with_hashing_strategy() {
        HashBagWithHashingStrategy<String> bag = HashBagWithHashingStrategy.newBagWith(HashingStrategies.defaultStrategy(), "1", "2", "2");
        bag.addOccurrences(null, 5);
        // Testing getting values from no chains
        Assert.assertEquals(1, bag.occurrencesOf("1"));
        Assert.assertEquals(2, bag.occurrencesOf("2"));
        Assert.assertEquals(5, bag.occurrencesOf(null));
        HashBagWithHashingStrategy<Person> bag2 = HashBagWithHashingStrategy.newBag(LAST_NAME_HASHING_STRATEGY);
        bag2.addOccurrences(JOHNSMITH, 1);
        Assert.assertEquals(1, bag2.occurrencesOf(JOHNSMITH));
        bag2.addOccurrences(JANESMITH, 2);
        Assert.assertEquals(3, bag2.occurrencesOf(JOHNSMITH));
    }

    @Test
    public void remove_with_hashing_strategy() {
        HashBagWithHashingStrategy<Person> bag = HashBagWithHashingStrategy.newBagWith(LAST_NAME_HASHING_STRATEGY, JOHNDOE, JANEDOE, JANEDOE, JOHNSMITH, JOHNSMITH, JOHNSMITH, JANESMITH, JANESMITH, JANESMITH, JANESMITH);
        bag.removeOccurrences(JANEDOE, 3);
        Assert.assertEquals(HashBagWithHashingStrategy.newBagWith(LAST_NAME_HASHING_STRATEGY, JOHNSMITH, JOHNSMITH, JOHNSMITH, JOHNSMITH, JOHNSMITH, JOHNSMITH, JOHNSMITH), bag);
        bag.removeOccurrences(JOHNSMITH, 7);
        Verify.assertEmpty(bag);
        HashBagWithHashingStrategy<Integer> bag2 = HashBagWithHashingStrategy.newBagWith(HashingStrategies.defaultStrategy(), 1, null, null, 3, 3, 3);
        bag2.removeOccurrences(null, 2);
        Assert.assertEquals(HashBagWithHashingStrategy.newBagWith(HashingStrategies.defaultStrategy(), 1, 3, 3, 3), bag2);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public HashBagWithHashingStrategyTest instance;

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
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_target);
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
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
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
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
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
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
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
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
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
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStringOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStringOfItemToCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapOfItemToCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorRemove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorRemove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorRemove2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorRemove2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occurrencesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occurrencesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addOccurrences_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeOccurrences_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeOccurrences_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_setOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.setOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_setOccurrences_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.setOccurrences_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
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
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
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
        public void benchmark_selectByOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectByOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectDuplicates() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectDuplicates);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_topOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.topOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_bottomOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.bottomOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectUnique);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newBag_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newBag_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_hashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.hashingStrategy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_with_hashing_strategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_with_hashing_strategy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equals_with_hashing_strategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equals_with_hashing_strategy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences_occurrencesOf_with_hashing_strategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addOccurrences_occurrencesOf_with_hashing_strategy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove_with_hashing_strategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove_with_hashing_strategy);
        }

        public void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> payload) throws java.lang.Throwable {
            this.instance = new HashBagWithHashingStrategyTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toMapOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> iteratorRemove2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> collectWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> occurrencesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> addOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> addOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> removeOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> removeOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> setOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> setOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toSortedListWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> anySatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> noneSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> allSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> detectWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> distinctView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> newBag_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> hashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> contains_with_hashing_strategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> equals_with_hashing_strategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> addOccurrences_occurrencesOf_with_hashing_strategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagWithHashingStrategyTest> remove_with_hashing_strategy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = HashBagWithHashingStrategyTest::testNewCollection;
            this.payloads.contains = HashBagWithHashingStrategyTest::contains;
            this.payloads.containsBy = HashBagWithHashingStrategyTest::containsBy;
            this.payloads.containsAllIterable = HashBagWithHashingStrategyTest::containsAllIterable;
            this.payloads.containsAnyIterable = HashBagWithHashingStrategyTest::containsAnyIterable;
            this.payloads.containsNoneIterable = HashBagWithHashingStrategyTest::containsNoneIterable;
            this.payloads.containsAllArray = HashBagWithHashingStrategyTest::containsAllArray;
            this.payloads.containsAnyCollection = HashBagWithHashingStrategyTest::containsAnyCollection;
            this.payloads.containsNoneCollection = HashBagWithHashingStrategyTest::containsNoneCollection;
            this.payloads.containsAllCollection = HashBagWithHashingStrategyTest::containsAllCollection;
            this.payloads.tap = HashBagWithHashingStrategyTest::tap;
            this.payloads.forEachWith = HashBagWithHashingStrategyTest::forEachWith;
            this.payloads.forEachWithIndex = HashBagWithHashingStrategyTest::forEachWithIndex;
            this.payloads.select = HashBagWithHashingStrategyTest::select;
            this.payloads.selectWith = HashBagWithHashingStrategyTest::selectWith;
            this.payloads.selectWith_target = HashBagWithHashingStrategyTest::selectWith_target;
            this.payloads.reject = HashBagWithHashingStrategyTest::reject;
            this.payloads.rejectWith = HashBagWithHashingStrategyTest::rejectWith;
            this.payloads.rejectWith_target = HashBagWithHashingStrategyTest::rejectWith_target;
            this.payloads.selectInstancesOf = HashBagWithHashingStrategyTest::selectInstancesOf;
            this.payloads.collect = HashBagWithHashingStrategyTest::collect;
            this.payloads.collectTarget = HashBagWithHashingStrategyTest::collectTarget;
            this.payloads.collectBoolean = HashBagWithHashingStrategyTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = HashBagWithHashingStrategyTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = HashBagWithHashingStrategyTest::collectBooleanWithBagTarget;
            this.payloads.collectByte = HashBagWithHashingStrategyTest::collectByte;
            this.payloads.collectByteWithTarget = HashBagWithHashingStrategyTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = HashBagWithHashingStrategyTest::collectByteWithBagTarget;
            this.payloads.collectChar = HashBagWithHashingStrategyTest::collectChar;
            this.payloads.collectCharWithTarget = HashBagWithHashingStrategyTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = HashBagWithHashingStrategyTest::collectCharWithBagTarget;
            this.payloads.collectDouble = HashBagWithHashingStrategyTest::collectDouble;
            this.payloads.collectDoubleWithTarget = HashBagWithHashingStrategyTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = HashBagWithHashingStrategyTest::collectDoubleWithBagTarget;
            this.payloads.collectFloat = HashBagWithHashingStrategyTest::collectFloat;
            this.payloads.collectFloatWithTarget = HashBagWithHashingStrategyTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = HashBagWithHashingStrategyTest::collectFloatWithBagTarget;
            this.payloads.collectInt = HashBagWithHashingStrategyTest::collectInt;
            this.payloads.collectIntWithTarget = HashBagWithHashingStrategyTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = HashBagWithHashingStrategyTest::collectIntWithBagTarget;
            this.payloads.collectLong = HashBagWithHashingStrategyTest::collectLong;
            this.payloads.collectLongWithTarget = HashBagWithHashingStrategyTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = HashBagWithHashingStrategyTest::collectLongWithBagTarget;
            this.payloads.collectShort = HashBagWithHashingStrategyTest::collectShort;
            this.payloads.collectShortWithTarget = HashBagWithHashingStrategyTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = HashBagWithHashingStrategyTest::collectShortWithBagTarget;
            this.payloads.flatCollect = HashBagWithHashingStrategyTest::flatCollect;
            this.payloads.flatCollectWith = HashBagWithHashingStrategyTest::flatCollectWith;
            this.payloads.flatCollectBoolean = HashBagWithHashingStrategyTest::flatCollectBoolean;
            this.payloads.flatCollectByte = HashBagWithHashingStrategyTest::flatCollectByte;
            this.payloads.flatCollectShort = HashBagWithHashingStrategyTest::flatCollectShort;
            this.payloads.flatCollectInt = HashBagWithHashingStrategyTest::flatCollectInt;
            this.payloads.flatCollectChar = HashBagWithHashingStrategyTest::flatCollectChar;
            this.payloads.flatCollectLong = HashBagWithHashingStrategyTest::flatCollectLong;
            this.payloads.flatCollectDouble = HashBagWithHashingStrategyTest::flatCollectDouble;
            this.payloads.flatCollectFloat = HashBagWithHashingStrategyTest::flatCollectFloat;
            this.payloads.detect = HashBagWithHashingStrategyTest::detect;
            this.payloads.detectOptional = HashBagWithHashingStrategyTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagWithHashingStrategyTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagWithHashingStrategyTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagWithHashingStrategyTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagWithHashingStrategyTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = HashBagWithHashingStrategyTest::min;
            this.payloads.minOptional = HashBagWithHashingStrategyTest::minOptional;
            this.payloads.max = HashBagWithHashingStrategyTest::max;
            this.payloads.maxOptional = HashBagWithHashingStrategyTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagWithHashingStrategyTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagWithHashingStrategyTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = HashBagWithHashingStrategyTest::min_without_comparator;
            this.payloads.max_without_comparator = HashBagWithHashingStrategyTest::max_without_comparator;
            this.payloads.min_null_safe = HashBagWithHashingStrategyTest::min_null_safe;
            this.payloads.max_null_safe = HashBagWithHashingStrategyTest::max_null_safe;
            this.payloads.minBy = HashBagWithHashingStrategyTest::minBy;
            this.payloads.minByOptional = HashBagWithHashingStrategyTest::minByOptional;
            this.payloads.maxBy = HashBagWithHashingStrategyTest::maxBy;
            this.payloads.maxByOptional = HashBagWithHashingStrategyTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagWithHashingStrategyTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagWithHashingStrategyTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = HashBagWithHashingStrategyTest::detectWith;
            this.payloads.detectWithOptional = HashBagWithHashingStrategyTest::detectWithOptional;
            this.payloads.detectIfNone = HashBagWithHashingStrategyTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = HashBagWithHashingStrategyTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = HashBagWithHashingStrategyTest::allSatisfy;
            this.payloads.allSatisfyWith = HashBagWithHashingStrategyTest::allSatisfyWith;
            this.payloads.noneSatisfy = HashBagWithHashingStrategyTest::noneSatisfy;
            this.payloads.noneSatisfyWith = HashBagWithHashingStrategyTest::noneSatisfyWith;
            this.payloads.anySatisfy = HashBagWithHashingStrategyTest::anySatisfy;
            this.payloads.anySatisfyWith = HashBagWithHashingStrategyTest::anySatisfyWith;
            this.payloads.count = HashBagWithHashingStrategyTest::count;
            this.payloads.countWith = HashBagWithHashingStrategyTest::countWith;
            this.payloads.collectIf = HashBagWithHashingStrategyTest::collectIf;
            this.payloads.collectWith = HashBagWithHashingStrategyTest::collectWith;
            this.payloads.collectWith_target = HashBagWithHashingStrategyTest::collectWith_target;
            this.payloads.getAny = HashBagWithHashingStrategyTest::getAny;
            this.payloads.getFirst = HashBagWithHashingStrategyTest::getFirst;
            this.payloads.getOnly = HashBagWithHashingStrategyTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagWithHashingStrategyTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagWithHashingStrategyTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = HashBagWithHashingStrategyTest::isEmpty;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagWithHashingStrategyTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = HashBagWithHashingStrategyTest::injectInto;
            this.payloads.injectIntoInt = HashBagWithHashingStrategyTest::injectIntoInt;
            this.payloads.injectIntoLong = HashBagWithHashingStrategyTest::injectIntoLong;
            this.payloads.injectIntoDouble = HashBagWithHashingStrategyTest::injectIntoDouble;
            this.payloads.injectIntoFloat = HashBagWithHashingStrategyTest::injectIntoFloat;
            this.payloads.sumFloat = HashBagWithHashingStrategyTest::sumFloat;
            this.payloads.summarizeFloat = HashBagWithHashingStrategyTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = HashBagWithHashingStrategyTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = HashBagWithHashingStrategyTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = HashBagWithHashingStrategyTest::sumDouble;
            this.payloads.summarizeDouble = HashBagWithHashingStrategyTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = HashBagWithHashingStrategyTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = HashBagWithHashingStrategyTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = HashBagWithHashingStrategyTest::sumInteger;
            this.payloads.summarizeInt = HashBagWithHashingStrategyTest::summarizeInt;
            this.payloads.sumLong = HashBagWithHashingStrategyTest::sumLong;
            this.payloads.summarizeLong = HashBagWithHashingStrategyTest::summarizeLong;
            this.payloads.sumByInt = HashBagWithHashingStrategyTest::sumByInt;
            this.payloads.sumByFloat = HashBagWithHashingStrategyTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = HashBagWithHashingStrategyTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = HashBagWithHashingStrategyTest::sumByLong;
            this.payloads.sumByDouble = HashBagWithHashingStrategyTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = HashBagWithHashingStrategyTest::sumByDoubleConsistentRounding;
            this.payloads.toArray = HashBagWithHashingStrategyTest::toArray;
            this.payloads.toImmutableList = HashBagWithHashingStrategyTest::toImmutableList;
            this.payloads.toCollection = HashBagWithHashingStrategyTest::toCollection;
            this.payloads.toBag = HashBagWithHashingStrategyTest::toBag;
            this.payloads.toImmutableBag = HashBagWithHashingStrategyTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = HashBagWithHashingStrategyTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = HashBagWithHashingStrategyTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = HashBagWithHashingStrategyTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = HashBagWithHashingStrategyTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagWithHashingStrategyTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = HashBagWithHashingStrategyTest::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = HashBagWithHashingStrategyTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = HashBagWithHashingStrategyTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = HashBagWithHashingStrategyTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagWithHashingStrategyTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = HashBagWithHashingStrategyTest::toSortedBagBy;
            this.payloads.toImmutableSortedBagBy = HashBagWithHashingStrategyTest::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = HashBagWithHashingStrategyTest::toSortedListBy;
            this.payloads.toImmutableSortedListBy = HashBagWithHashingStrategyTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = HashBagWithHashingStrategyTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = HashBagWithHashingStrategyTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = HashBagWithHashingStrategyTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = HashBagWithHashingStrategyTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = HashBagWithHashingStrategyTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = HashBagWithHashingStrategyTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagWithHashingStrategyTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSet = HashBagWithHashingStrategyTest::toImmutableSet;
            this.payloads.toMap = HashBagWithHashingStrategyTest::toMap;
            this.payloads.toImmutableMap = HashBagWithHashingStrategyTest::toImmutableMap;
            this.payloads.toMapTarget = HashBagWithHashingStrategyTest::toMapTarget;
            this.payloads.toSortedMap = HashBagWithHashingStrategyTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = HashBagWithHashingStrategyTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = HashBagWithHashingStrategyTest::toSortedMapBy;
            this.payloads.toBiMap = HashBagWithHashingStrategyTest::toBiMap;
            this.payloads.toImmutableBiMap = HashBagWithHashingStrategyTest::toImmutableBiMap;
            this.payloads.testToString = HashBagWithHashingStrategyTest::testToString;
            this.payloads.makeString = HashBagWithHashingStrategyTest::makeString;
            this.payloads.makeStringWithSeparator = HashBagWithHashingStrategyTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = HashBagWithHashingStrategyTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = HashBagWithHashingStrategyTest::fusedCollectMakeString;
            this.payloads.appendString = HashBagWithHashingStrategyTest::appendString;
            this.payloads.appendStringWithSeparator = HashBagWithHashingStrategyTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = HashBagWithHashingStrategyTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = HashBagWithHashingStrategyTest::appendStringThrows;
            this.payloads.countBy = HashBagWithHashingStrategyTest::countBy;
            this.payloads.countByWith = HashBagWithHashingStrategyTest::countByWith;
            this.payloads.countByEach = HashBagWithHashingStrategyTest::countByEach;
            this.payloads.groupBy = HashBagWithHashingStrategyTest::groupBy;
            this.payloads.groupByEach = HashBagWithHashingStrategyTest::groupByEach;
            this.payloads.groupByUniqueKey = HashBagWithHashingStrategyTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagWithHashingStrategyTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = HashBagWithHashingStrategyTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagWithHashingStrategyTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zipWithIndex = HashBagWithHashingStrategyTest::zipWithIndex;
            this.payloads.chunk = HashBagWithHashingStrategyTest::chunk;
            this.payloads.chunk_empty = HashBagWithHashingStrategyTest::chunk_empty;
            this.payloads.chunk_single = HashBagWithHashingStrategyTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagWithHashingStrategyTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = HashBagWithHashingStrategyTest::chunk_large_size;
            this.payloads.empty = HashBagWithHashingStrategyTest::empty;
            this.payloads.notEmpty = HashBagWithHashingStrategyTest::notEmpty;
            this.payloads.aggregateByMutating = HashBagWithHashingStrategyTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = HashBagWithHashingStrategyTest::aggregateByNonMutating;
            this.payloads.reduceOptional = HashBagWithHashingStrategyTest::reduceOptional;
            this.payloads.newEmpty = HashBagWithHashingStrategyTest::newEmpty;
            this.payloads.testNewWith = HashBagWithHashingStrategyTest::testNewWith;
            this.payloads.testNewWithWith = HashBagWithHashingStrategyTest::testNewWithWith;
            this.payloads.testNewWithWithWith = HashBagWithHashingStrategyTest::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = HashBagWithHashingStrategyTest::testNewWithVarArgs;
            this.payloads.addAllIterable = HashBagWithHashingStrategyTest::addAllIterable;
            this.payloads.removeAll = HashBagWithHashingStrategyTest::removeAll;
            this.payloads.retainAll = HashBagWithHashingStrategyTest::retainAll;
            this.payloads.retainAllIterable = HashBagWithHashingStrategyTest::retainAllIterable;
            this.payloads.clear = HashBagWithHashingStrategyTest::clear;
            this.payloads.injectIntoWith = HashBagWithHashingStrategyTest::injectIntoWith;
            this.payloads.selectAndRejectWith = HashBagWithHashingStrategyTest::selectAndRejectWith;
            this.payloads.removeIfWith = HashBagWithHashingStrategyTest::removeIfWith;
            this.payloads.with = HashBagWithHashingStrategyTest::with;
            this.payloads.withAll = HashBagWithHashingStrategyTest::withAll;
            this.payloads.without = HashBagWithHashingStrategyTest::without;
            this.payloads.withoutAll = HashBagWithHashingStrategyTest::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = HashBagWithHashingStrategyTest::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = HashBagWithHashingStrategyTest::asLazy;
            this.payloads.equalsAndHashCode = HashBagWithHashingStrategyTest::equalsAndHashCode;
            this.payloads.toStringOfItemToCount = HashBagWithHashingStrategyTest::toStringOfItemToCount;
            this.payloads.toMapOfItemToCount = HashBagWithHashingStrategyTest::toMapOfItemToCount;
            this.payloads.add = HashBagWithHashingStrategyTest::add;
            this.payloads.iterator = HashBagWithHashingStrategyTest::iterator;
            this.payloads.iteratorRemove = HashBagWithHashingStrategyTest::iteratorRemove;
            this.payloads.iteratorRemove2 = HashBagWithHashingStrategyTest::iteratorRemove2;
            this.payloads.removeIf = HashBagWithHashingStrategyTest::removeIf;
            this.payloads.forEach = HashBagWithHashingStrategyTest::forEach;
            this.payloads.forEachWithOccurrences = HashBagWithHashingStrategyTest::forEachWithOccurrences;
            this.payloads.collectWithOccurrences = HashBagWithHashingStrategyTest::collectWithOccurrences;
            this.payloads.toImmutable = HashBagWithHashingStrategyTest::toImmutable;
            this.payloads.getLast = HashBagWithHashingStrategyTest::getLast;
            this.payloads.occurrencesOf = HashBagWithHashingStrategyTest::occurrencesOf;
            this.payloads.addOccurrences = HashBagWithHashingStrategyTest::addOccurrences;
            this.payloads.addOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagWithHashingStrategyTest::addOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.removeOccurrences = HashBagWithHashingStrategyTest::removeOccurrences;
            this.payloads.removeOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagWithHashingStrategyTest::removeOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.setOccurrences = HashBagWithHashingStrategyTest::setOccurrences;
            this.payloads.setOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagWithHashingStrategyTest::setOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.toSortedListWith = HashBagWithHashingStrategyTest::toSortedListWith;
            this.payloads.toSet = HashBagWithHashingStrategyTest::toSet;
            this.payloads.toList = HashBagWithHashingStrategyTest::toList;
            this.payloads.removeObject = HashBagWithHashingStrategyTest::removeObject;
            this.payloads.asSynchronized = HashBagWithHashingStrategyTest::asSynchronized;
            this.payloads.asUnmodifiable = HashBagWithHashingStrategyTest::asUnmodifiable;
            this.payloads.serialization = HashBagWithHashingStrategyTest::serialization;
            this.payloads.partition = HashBagWithHashingStrategyTest::partition;
            this.payloads.partitionWith = HashBagWithHashingStrategyTest::partitionWith;
            this.payloads.selectByOccurrences = HashBagWithHashingStrategyTest::selectByOccurrences;
            this.payloads.selectDuplicates = HashBagWithHashingStrategyTest::selectDuplicates;
            this.payloads.topOccurrences = HashBagWithHashingStrategyTest::topOccurrences;
            this.payloads.anySatisfyWithOccurrences = HashBagWithHashingStrategyTest::anySatisfyWithOccurrences;
            this.payloads.noneSatisfyWithOccurrences = HashBagWithHashingStrategyTest::noneSatisfyWithOccurrences;
            this.payloads.allSatisfyWithOccurrences = HashBagWithHashingStrategyTest::allSatisfyWithOccurrences;
            this.payloads.detectWithOccurrences = HashBagWithHashingStrategyTest::detectWithOccurrences;
            this.payloads.bottomOccurrences = HashBagWithHashingStrategyTest::bottomOccurrences;
            this.payloads.selectUnique = HashBagWithHashingStrategyTest::selectUnique;
            this.payloads.zip = HashBagWithHashingStrategyTest::zip;
            this.payloads.distinctView = HashBagWithHashingStrategyTest::distinctView;
            this.payloads.newBag_throws = HashBagWithHashingStrategyTest::newBag_throws;
            this.payloads.removeAllIterable = HashBagWithHashingStrategyTest::removeAllIterable;
            this.payloads.addAll = HashBagWithHashingStrategyTest::addAll;
            this.payloads.hashingStrategy = HashBagWithHashingStrategyTest::hashingStrategy;
            this.payloads.contains_with_hashing_strategy = HashBagWithHashingStrategyTest::contains_with_hashing_strategy;
            this.payloads.equals_with_hashing_strategy = HashBagWithHashingStrategyTest::equals_with_hashing_strategy;
            this.payloads.addOccurrences_occurrencesOf_with_hashing_strategy = HashBagWithHashingStrategyTest::addOccurrences_occurrencesOf_with_hashing_strategy;
            this.payloads.remove_with_hashing_strategy = HashBagWithHashingStrategyTest::remove_with_hashing_strategy;
        }
    }
}
