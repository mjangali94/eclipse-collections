/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.mutable;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.block.HashingStrategy;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.Pool;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.math.IntegerSum;
import org.eclipse.collections.impl.math.Sum;
import org.eclipse.collections.impl.math.SumProcedure;
import org.eclipse.collections.impl.set.strategy.mutable.UnifiedSetWithHashingStrategy;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.domain.Key;
import org.eclipse.collections.impl.test.domain.Person;
import org.eclipse.collections.impl.utility.ArrayIterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test suite for {@link UnifiedSetWithHashingStrategy}.
 */
public class UnifiedSetWithHashingStrategyTest extends AbstractUnifiedSetTestCase {

    // Not using the static factory method in order to have concrete types for test cases
    private static final HashingStrategy<Integer> INTEGER_HASHING_STRATEGY = HashingStrategies.nullSafeHashingStrategy(new HashingStrategy<Integer>() {

        public int computeHashCode(Integer object) {
            return object.hashCode();
        }

        public boolean equals(Integer object1, Integer object2) {
            return object1.equals(object2);
        }
    });

    private static final HashingStrategy<String> STRING_HASHING_STRATEGY = HashingStrategies.nullSafeHashingStrategy(new HashingStrategy<String>() {

        public int computeHashCode(String object) {
            return object.hashCode();
        }

        public boolean equals(String object1, String object2) {
            return object1.equals(object2);
        }
    });

    private static final HashingStrategy<Person> FIRST_NAME_HASHING_STRATEGY = HashingStrategies.fromFunction(Person.TO_FIRST);

    private static final HashingStrategy<Person> LAST_NAME_HASHING_STRATEGY = HashingStrategies.fromFunction(Person.TO_LAST);

    private static final Person JOHNSMITH = new Person("John", "Smith");

    private static final Person JANESMITH = new Person("Jane", "Smith");

    private static final Person JOHNDOE = new Person("John", "Doe");

    private static final Person JANEDOE = new Person("Jane", "Doe");

    private static final ImmutableList<Person> PEOPLE = Lists.immutable.of(JOHNSMITH, JANESMITH, JOHNDOE, JANEDOE);

    private static final ImmutableSet<Person> LAST_NAME_HASHED_SET = Sets.immutable.of(JOHNSMITH, JOHNDOE);

    @Override
    protected <T> MutableSet<T> newWith(T... littleElements) {
        return UnifiedSetWithHashingStrategy.newSetWith(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy()), littleElements);
    }

    @Test
    public void newSet_throws() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new UnifiedSetWithHashingStrategy<>(INTEGER_HASHING_STRATEGY, -1, 0.5f));
        Assert.assertThrows(IllegalArgumentException.class, () -> new UnifiedSetWithHashingStrategy<>(INTEGER_HASHING_STRATEGY, 1, -0.5f));
        Assert.assertThrows(IllegalArgumentException.class, () -> new UnifiedSetWithHashingStrategy<>(INTEGER_HASHING_STRATEGY, 1, 1.5f));
    }

    @Override
    @Test
    public void tap() {
        super.tap();
        MutableList<Person> tapResult = Lists.mutable.of();
        UnifiedSetWithHashingStrategy<Person> people = UnifiedSetWithHashingStrategy.newSet(LAST_NAME_HASHING_STRATEGY).withAll(PEOPLE.castToList());
        Assert.assertSame(people, people.tap(tapResult::add));
        Assert.assertEquals(people.toList(), tapResult);
    }

    @Override
    @Test
    public void select() {
        super.select();
        UnifiedSetWithHashingStrategy<Person> people = UnifiedSetWithHashingStrategy.newSet(LAST_NAME_HASHING_STRATEGY).withAll(PEOPLE.castToList());
        Verify.assertSetsEqual(LAST_NAME_HASHED_SET.castToSet(), people);
        Verify.assertSetsEqual(UnifiedSet.newSetWith(JOHNSMITH), people.select(each -> "Smith".equals(each.getLastName())).with(JANESMITH));
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        UnifiedSetWithHashingStrategy<Person> people = UnifiedSetWithHashingStrategy.newSet(LAST_NAME_HASHING_STRATEGY).withAll(PEOPLE.castToList());
        Verify.assertSetsEqual(UnifiedSet.newSetWith(JOHNSMITH), people.reject(each -> "Doe".equals(each.getLastName())).with(JANESMITH));
    }

    /**
     * @deprecated since 3.0.
     */
    @Deprecated
    @Test
    public void lazyCollectForEach() {
        UnifiedSetWithHashingStrategy<Integer> integers = UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, 1, 2, 3, 4, 5);
        LazyIterable<String> select = integers.lazyCollect(String::valueOf);
        Procedure<String> builder = Procedures.append(new StringBuilder());
        select.forEach(builder);
        String result = builder.toString();
        Verify.assertContains("1", result);
        Verify.assertContains("2", result);
        Verify.assertContains("3", result);
        Verify.assertContains("4", result);
        Verify.assertContains("5", result);
    }

    /**
     * @deprecated since 3.0.
     */
    @Deprecated
    @Test
    public void lazyRejectForEach() {
        UnifiedSetWithHashingStrategy<Integer> integers = UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, 1, 2, 3, 4, 5);
        LazyIterable<Integer> select = integers.lazyReject(Predicates.lessThan(5));
        Sum sum = new IntegerSum(0);
        select.forEach(new SumProcedure<>(sum));
        Assert.assertEquals(5L, sum.getValue().intValue());
    }

    /**
     * @deprecated since 3.0.
     */
    @Deprecated
    @Test
    public void lazySelectForEach() {
        UnifiedSetWithHashingStrategy<Integer> integers = UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, 1, 2, 3, 4, 5);
        LazyIterable<Integer> select = integers.lazySelect(Predicates.lessThan(5));
        Sum sum = new IntegerSum(0);
        select.forEach(new SumProcedure<>(sum));
        Assert.assertEquals(10, sum.getValue().intValue());
    }

    @Override
    @Test
    public void with() {
        Verify.assertEqualsAndHashCode(UnifiedSetWithHashingStrategy.newSetWith(STRING_HASHING_STRATEGY, "1"), UnifiedSetWithHashingStrategy.newSet(STRING_HASHING_STRATEGY).with("1"));
        Verify.assertEqualsAndHashCode(UnifiedSetWithHashingStrategy.newSetWith(STRING_HASHING_STRATEGY, "1", "2"), UnifiedSetWithHashingStrategy.newSet(STRING_HASHING_STRATEGY).with("1", "2"));
        Verify.assertEqualsAndHashCode(UnifiedSetWithHashingStrategy.newSetWith(STRING_HASHING_STRATEGY, "1", "2", "3"), UnifiedSetWithHashingStrategy.newSet(STRING_HASHING_STRATEGY).with("1", "2", "3"));
        Verify.assertEqualsAndHashCode(UnifiedSetWithHashingStrategy.newSetWith(STRING_HASHING_STRATEGY, "1", "2", "3", "4"), UnifiedSetWithHashingStrategy.newSet(STRING_HASHING_STRATEGY).with("1", "2", "3", "4"));
        MutableSet<String> list = UnifiedSetWithHashingStrategy.newSet(STRING_HASHING_STRATEGY).with("A").withAll(Lists.fixedSize.of("1", "2")).withAll(Lists.fixedSize.of()).withAll(Sets.fixedSize.of("3", "4"));
        Verify.assertEqualsAndHashCode(UnifiedSetWithHashingStrategy.newSetWith(STRING_HASHING_STRATEGY, "A", "1", "2", "3", "4"), list);
    }

    @Test
    public void newSetWithIterable() {
        // testing collection
        MutableSet<Integer> integers = UnifiedSetWithHashingStrategy.newSet(INTEGER_HASHING_STRATEGY, Interval.oneTo(3));
        Assert.assertEquals(UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, 1, 2, 3), integers);
        // testing iterable
        UnifiedSetWithHashingStrategy<Integer> set1 = UnifiedSetWithHashingStrategy.newSet(INTEGER_HASHING_STRATEGY, FastList.newListWith(1, 2, 3).asLazy());
        Assert.assertEquals(UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, 1, 2, 3), set1);
        // testing null
        Assert.assertThrows(NullPointerException.class, () -> UnifiedSetWithHashingStrategy.newSet(INTEGER_HASHING_STRATEGY, null));
    }

    @Override
    @Test
    public void add() {
        super.add();
        // force rehashing at each step of adding a new colliding entry
        for (int i = 0; i < COLLISIONS.size(); i++) {
            UnifiedSetWithHashingStrategy<Integer> unifiedSet = UnifiedSetWithHashingStrategy.newSet(INTEGER_HASHING_STRATEGY, i, 0.75f).withAll(COLLISIONS.subList(0, i));
            if (i == 2) {
                unifiedSet.add(Integer.valueOf(1));
            }
            if (i == 4) {
                unifiedSet.add(Integer.valueOf(1));
                unifiedSet.add(Integer.valueOf(2));
            }
            Integer value = COLLISIONS.get(i);
            Assert.assertTrue(unifiedSet.add(value));
        }
        // Rehashing Case A: a bucket with only one entry and a low capacity forcing a rehash, where the trigging element goes in the bucket
        // set up a chained bucket
        UnifiedSetWithHashingStrategy<Integer> caseA = UnifiedSetWithHashingStrategy.newSet(INTEGER_HASHING_STRATEGY, 2).with(COLLISION_1, COLLISION_2);
        // clear the bucket to one element
        caseA.remove(COLLISION_2);
        // increase the occupied count to the threshold
        caseA.add(Integer.valueOf(1));
        caseA.add(Integer.valueOf(2));
        // add the colliding value back and force the rehash
        Assert.assertTrue(caseA.add(COLLISION_2));
        // Rehashing Case B: a bucket with only one entry and a low capacity forcing a rehash, where the triggering element is not in the chain
        // set up a chained bucket
        UnifiedSetWithHashingStrategy<Integer> caseB = UnifiedSetWithHashingStrategy.newSet(INTEGER_HASHING_STRATEGY, 2).with(COLLISION_1, COLLISION_2);
        // clear the bucket to one element
        caseB.remove(COLLISION_2);
        // increase the occupied count to the threshold
        caseB.add(Integer.valueOf(1));
        caseB.add(Integer.valueOf(2));
        // add a new value and force the rehash
        Assert.assertTrue(caseB.add(3));
    }

    @Test
    public void add_with_hashingStrategy() {
        HashingStrategy<Integer> hashingStrategy = HashingStrategies.nullSafeHashingStrategy(new HashingStrategy<Integer>() {

            public int computeHashCode(Integer object) {
                return object % 1000;
            }

            public boolean equals(Integer object1, Integer object2) {
                return object1.equals(object2);
            }
        });
        // Same as case A above except with a different hashing strategy
        UnifiedSetWithHashingStrategy<Integer> caseA = UnifiedSetWithHashingStrategy.newSet(hashingStrategy, 2);
        // Adding an element to a slot
        Assert.assertTrue(caseA.add(COLLISION_1));
        // Setting up a chained bucked by forcing a collision
        Assert.assertTrue(caseA.add(COLLISION_1 + 1000));
        // Increasing the occupied to the thresh hold
        Assert.assertTrue(caseA.add(COLLISION_1 + 2000));
        // Forcing a rehash where the element that forced the rehash goes in the chained bucket
        Assert.assertTrue(caseA.add(null));
        Verify.assertSetsEqual(UnifiedSet.newSetWith(COLLISION_1, COLLISION_1 + 1000, COLLISION_1 + 2000, null), caseA);
        // Same as case B above except with a different hashing strategy
        UnifiedSetWithHashingStrategy<Integer> caseB = UnifiedSetWithHashingStrategy.newSet(hashingStrategy, 2);
        // Adding an element to a slot
        Assert.assertTrue(caseB.add(null));
        // Setting up a chained bucked by forcing a collision
        Assert.assertTrue(caseB.add(1));
        // Increasing the occupied to the threshold
        Assert.assertTrue(caseB.add(2));
        // Forcing a rehash where the element that forced the rehash does not go in the chained bucket
        Assert.assertTrue(caseB.add(3));
        Verify.assertSetsEqual(UnifiedSet.newSetWith(null, 1, 2, 3), caseB);
        // Testing add throws NullPointerException if the hashingStrategy is not null safe
        Assert.assertThrows(NullPointerException.class, () -> UnifiedSetWithHashingStrategy.newSet(LAST_NAME_HASHING_STRATEGY).add(null));
    }

    @Test
    public void addOrReplace() {
        Person person1 = new Person("f1", "l1", 1);
        UnifiedSetWithHashingStrategy<Person> set1 = UnifiedSetWithHashingStrategy.newSetWith(HashingStrategies.fromFunction(Person::getAge), person1);
        Person person2 = new Person("f2", "l2", 1);
        Assert.assertEquals(person1, set1.getOnly());
        set1.add(person2);
        Assert.assertEquals(person1, set1.getOnly());
        Assert.assertEquals(person1, set1.addOrReplace(person2));
        Assert.assertEquals(person2, set1.getOnly());
        set1.remove(person1);
        Verify.assertEmpty(set1);
        Assert.assertEquals(person1, set1.addOrReplace(person1));
        Assert.assertEquals(person1, set1.getOnly());
        Assert.assertEquals(person1, set1.addOrReplace(person1));
        Person person31 = new Person("c1", "l31", COLLISION_1);
        Person person41 = new Person("c2", "l41", COLLISION_2);
        Person person51 = new Person("c3", "l51", COLLISION_3);
        Person person61 = new Person("c4", "l61", COLLISION_4);
        Person person71 = new Person("c5", "l71", COLLISION_5);
        Person person81 = new Person("c6", "l81", COLLISION_6);
        Person person91 = new Person("c7", "l91", COLLISION_7);
        Person person101 = new Person("c8", "l101", COLLISION_8);
        Person person111 = new Person("c9", "l111", COLLISION_9);
        Person person121 = new Person("c10", "l121", COLLISION_10);
        Person person32 = new Person("c1", "l32", COLLISION_1);
        Person person42 = new Person("c2", "l42", COLLISION_2);
        Person person52 = new Person("c3", "l52", COLLISION_3);
        Person person62 = new Person("c4", "l62", COLLISION_4);
        Person person72 = new Person("c5", "l72", COLLISION_5);
        Person person82 = new Person("c6", "l82", COLLISION_6);
        Person person92 = new Person("c7", "l92", COLLISION_7);
        Person person102 = new Person("c8", "l102", COLLISION_8);
        Person person112 = new Person("c9", "l112", COLLISION_9);
        Person person122 = new Person("c10", "l122", COLLISION_10);
        UnifiedSetWithHashingStrategy<Person> set2 = UnifiedSetWithHashingStrategy.newSetWith(HashingStrategies.fromFunction(Person::getAge));
        Assert.assertEquals(person31, set2.addOrReplace(person31));
        Assert.assertEquals(person41, set2.addOrReplace(person41));
        Assert.assertEquals(person51, set2.addOrReplace(person51));
        Assert.assertEquals(person61, set2.addOrReplace(person61));
        Assert.assertEquals(person61, set2.addOrReplace(person62));
        Assert.assertEquals(person62, set2.addOrReplace(person61));
        Assert.assertEquals(person71, set2.addOrReplace(person71));
        Assert.assertEquals(person81, set2.addOrReplace(person81));
        Assert.assertEquals(person91, set2.addOrReplace(person91));
        Assert.assertEquals(person101, set2.addOrReplace(person101));
        Assert.assertEquals(person111, set2.addOrReplace(person111));
        Assert.assertEquals(person121, set2.addOrReplace(person121));
        Assert.assertEquals(person31, set2.addOrReplace(person31));
        Assert.assertEquals(UnifiedSetWithHashingStrategy.newSetWith(HashingStrategies.fromFunction(Person::getAge), person31, person41, person51, person61, person71, person81, person91, person101, person111, person121), set2);
        Assert.assertEquals(person121, set2.addOrReplace(person122));
        Assert.assertEquals(person71, set2.addOrReplace(person72));
        Assert.assertEquals(UnifiedSetWithHashingStrategy.newSetWith(HashingStrategies.fromFunction(Person::getAge), person31, person41, person51, person61, person72, person81, person91, person101, person111, person122), set2);
        Assert.assertEquals(person31, set2.addOrReplace(person32));
        Assert.assertEquals(person41, set2.addOrReplace(person42));
        Assert.assertEquals(person51, set2.addOrReplace(person52));
        Assert.assertEquals(person61, set2.addOrReplace(person62));
        Assert.assertEquals(person72, set2.addOrReplace(person72));
        Assert.assertEquals(person81, set2.addOrReplace(person82));
        Assert.assertEquals(person91, set2.addOrReplace(person92));
        Assert.assertEquals(person101, set2.addOrReplace(person102));
        Assert.assertEquals(person111, set2.addOrReplace(person112));
        Assert.assertEquals(person122, set2.addOrReplace(person122));
        Assert.assertEquals(UnifiedSetWithHashingStrategy.newSetWith(HashingStrategies.fromFunction(Person::getAge), person32, person42, person52, person62, person72, person82, person92, person102, person112, person122), set2);
        Assert.assertEquals(person1, set2.addOrReplace(person1));
        Person person3 = new Person("f3", "l3", 3);
        Person person4 = new Person("f4", "l4", 4);
        Assert.assertEquals(person3, set2.addOrReplace(person3));
        Assert.assertEquals(person4, set2.addOrReplace(person4));
        Assert.assertEquals(UnifiedSetWithHashingStrategy.newSetWith(HashingStrategies.fromFunction(Person::getAge), person1, person3, person4, person32, person42, person52, person62, person72, person82, person92, person102, person112, person122), set2);
    }

    @Override
    @Test
    public void addAllIterable() {
        super.addAllIterable();
        // test adding a fully populated chained bucket
        MutableSet<Integer> expected = UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4, COLLISION_5, COLLISION_6, COLLISION_7);
        Assert.assertTrue(UnifiedSetWithHashingStrategy.newSet(INTEGER_HASHING_STRATEGY).addAllIterable(expected));
        // add an odd-sized collection to a set with a small max to ensure that its capacity is maintained after the operation.
        UnifiedSetWithHashingStrategy<Integer> tiny = UnifiedSetWithHashingStrategy.newSet(INTEGER_HASHING_STRATEGY, 0);
        Assert.assertTrue(tiny.addAllIterable(FastList.newListWith(COLLISION_1)));
        // Testing copying set with 3rd slot in chained bucket == null
        UnifiedSetWithHashingStrategy<Integer> integers = UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4);
        UnifiedSetWithHashingStrategy<Integer> set = UnifiedSetWithHashingStrategy.newSet(INTEGER_HASHING_STRATEGY);
        integers.remove(COLLISION_4);
        Assert.assertTrue(set.addAllIterable(integers));
        Assert.assertEquals(UnifiedSet.newSetWith(COLLISION_1, COLLISION_2, COLLISION_3), set);
        // Testing copying set with 2nd slot in chained bucket == null
        integers.remove(COLLISION_3);
        Assert.assertFalse(set.addAllIterable(integers));
        // Testing copying set with the 1st slot in chained bucket == null
        integers.remove(COLLISION_2);
        Assert.assertFalse(set.addAllIterable(integers));
        Assert.assertEquals(UnifiedSet.newSetWith(COLLISION_1, COLLISION_2, COLLISION_3), set);
    }

    @Test
    public void addALLIterable_with_hashingStrategy() {
        UnifiedSetWithHashingStrategy<Person> people = UnifiedSetWithHashingStrategy.newSet(HashingStrategies.nullSafeHashingStrategy(LAST_NAME_HASHING_STRATEGY), 2);
        // Testing adding an iterable
        Assert.assertTrue(people.addAllIterable(PEOPLE));
        Verify.assertSetsEqual(UnifiedSet.newSet(LAST_NAME_HASHED_SET), people);
        // Testing the set uses its own hashing strategy and not the target sets
        Assert.assertFalse(people.addAllIterable(UnifiedSetWithHashingStrategy.newSet(FIRST_NAME_HASHING_STRATEGY, PEOPLE)));
        Verify.assertSize(2, people);
        // Testing adding with null where the call to addALLIterable forces a rehash
        Person notInSet = new Person("Not", "InSet");
        Assert.assertTrue(people.addAllIterable(UnifiedSet.newSetWith(notInSet, null)));
        Verify.assertSetsEqual(UnifiedSet.newSet(LAST_NAME_HASHED_SET).with(notInSet, null), people);
        // Testing addAllIterable throws NullPointerException if the hashingStrategy is not null safe
        Assert.assertThrows(NullPointerException.class, () -> UnifiedSetWithHashingStrategy.newSet(LAST_NAME_HASHING_STRATEGY).addAllIterable(UnifiedSet.newSetWith((Person) null)));
    }

    @Test
    public void get() {
        UnifiedSetWithHashingStrategy<Integer> set = UnifiedSetWithHashingStrategy.newSet(INTEGER_HASHING_STRATEGY, SIZE).withAll(COLLISIONS);
        set.removeAll(COLLISIONS);
        for (Integer integer : COLLISIONS) {
            Assert.assertNull(set.get(integer));
            Assert.assertNull(set.get(null));
            set.add(integer);
            // noinspection UnnecessaryBoxing,CachedNumberConstructorCall,BoxingBoxedValue
            Assert.assertSame(integer, set.get(new Integer(integer)));
        }
        Assert.assertEquals(COLLISIONS.toSet(), set);
        // the pool interface supports getting null keys
        UnifiedSetWithHashingStrategy<Integer> chainedWithNull = UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, null, COLLISION_1);
        Verify.assertContains(null, chainedWithNull);
        Assert.assertNull(chainedWithNull.get(null));
        // getting a non-existent from a chain with one slot should short-circuit to return null
        UnifiedSetWithHashingStrategy<Integer> chainedWithOneSlot = UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, COLLISION_1, COLLISION_2);
        chainedWithOneSlot.remove(COLLISION_2);
        Assert.assertNull(chainedWithOneSlot.get(COLLISION_2));
    }

    @Test
    public void get_with_hashingStrategy() {
        UnifiedSetWithHashingStrategy<Person> people = UnifiedSetWithHashingStrategy.newSet(HashingStrategies.nullSafeHashingStrategy(LAST_NAME_HASHING_STRATEGY), 2).withAll(PEOPLE.castToList());
        // Putting null then testing geting a null
        Verify.assertSize(3, people.with((Person) null));
        Assert.assertNull(people.get(null));
        // Testing it is getting the same reference
        Assert.assertSame(JOHNSMITH, people.get(JANESMITH));
        Assert.assertSame(JOHNSMITH, people.get(JOHNSMITH));
        Assert.assertSame(JOHNDOE, people.get(JANEDOE));
        Assert.assertSame(JOHNDOE, people.get(JOHNDOE));
        Assert.assertSame(JOHNSMITH, people.get(new Person("Anything", "Smith")));
        Assert.assertNull(people.get(new Person("John", "NotHere")));
        // Testing get throws NullPointerException if the hashingStrategy is not null safe
        Assert.assertThrows(NullPointerException.class, () -> UnifiedSetWithHashingStrategy.newSet(LAST_NAME_HASHING_STRATEGY).get(null));
    }

    @Test
    public void put() {
        int size = MORE_COLLISIONS.size();
        for (int i = 1; i <= size; i++) {
            Pool<Integer> unifiedSet = UnifiedSetWithHashingStrategy.newSet(INTEGER_HASHING_STRATEGY, 1).withAll(MORE_COLLISIONS.subList(0, i - 1));
            Integer newValue = MORE_COLLISIONS.get(i - 1);
            Assert.assertSame(newValue, unifiedSet.put(newValue));
            // noinspection UnnecessaryBoxing,CachedNumberConstructorCall,BoxingBoxedValue
            Assert.assertSame(newValue, unifiedSet.put(new Integer(newValue)));
        }
        // assert that all redundant puts into each position of chain bucket return the original element added
        Pool<Integer> set = UnifiedSetWithHashingStrategy.newSet(INTEGER_HASHING_STRATEGY, 4).with(COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4);
        for (int i = 0; i < set.size(); i++) {
            Integer value = COLLISIONS.get(i);
            Assert.assertSame(value, set.put(value));
        }
        // force rehashing at each step of putting a new colliding entry
        for (int i = 0; i < COLLISIONS.size(); i++) {
            Pool<Integer> pool = UnifiedSetWithHashingStrategy.newSet(INTEGER_HASHING_STRATEGY, i).withAll(COLLISIONS.subList(0, i));
            if (i == 2) {
                pool.put(Integer.valueOf(1));
            }
            if (i == 4) {
                pool.put(Integer.valueOf(1));
                pool.put(Integer.valueOf(2));
            }
            Integer value = COLLISIONS.get(i);
            Assert.assertSame(value, pool.put(value));
        }
        // cover one case not covered in the above: a bucket with only one entry and a low capacity forcing a rehash
        // set up a chained bucket
        Pool<Integer> pool = UnifiedSetWithHashingStrategy.newSet(INTEGER_HASHING_STRATEGY, 2).with(COLLISION_1, COLLISION_2);
        // clear the bucket to one element
        pool.removeFromPool(COLLISION_2);
        // increase the occupied count to the threshold
        pool.put(Integer.valueOf(1));
        pool.put(Integer.valueOf(2));
        // put the colliding value back and force the rehash
        Assert.assertSame(COLLISION_2, pool.put(COLLISION_2));
        // put chained items into a pool without causing a rehash
        Pool<Integer> olympicPool = UnifiedSetWithHashingStrategy.newSet(INTEGER_HASHING_STRATEGY);
        Assert.assertSame(COLLISION_1, olympicPool.put(COLLISION_1));
        Assert.assertSame(COLLISION_2, olympicPool.put(COLLISION_2));
    }

    @Test
    public void put_with_hashingStrategy() {
        UnifiedSetWithHashingStrategy<Person> people = UnifiedSetWithHashingStrategy.newSet(HashingStrategies.nullSafeHashingStrategy(LAST_NAME_HASHING_STRATEGY), 2).withAll(PEOPLE.castToList());
        // Testing if element already exists, returns the instance in the set
        Assert.assertSame(JOHNSMITH, people.put(new Person("Anything", "Smith")));
        Verify.assertSize(2, people);
        // Testing if the element doesn't exist, returns the element itself
        Person notInSet = new Person("Not", "inSet");
        Assert.assertSame(notInSet, people.put(notInSet));
        Verify.assertSize(3, people);
        // Testing putting a null to force a rehash
        Assert.assertNull(people.put(null));
        Verify.assertSize(4, people);
        // Testing put throws NullPointerException if the hashingStrategy is not null safe
        Assert.assertThrows(NullPointerException.class, () -> UnifiedSetWithHashingStrategy.newSet(LAST_NAME_HASHING_STRATEGY).put(null));
    }

    @Test
    public void remove_with_hashingStrategy() {
        HashingStrategy<Integer> hashingStrategy = HashingStrategies.nullSafeHashingStrategy(new HashingStrategy<Integer>() {

            public int computeHashCode(Integer object) {
                return object % 1000;
            }

            public boolean equals(Integer object1, Integer object2) {
                return object1.equals(object2);
            }
        });
        UnifiedSetWithHashingStrategy<Integer> integers = UnifiedSetWithHashingStrategy.newSet(hashingStrategy, 2).with(COLLISION_1, COLLISION_1 + 1000, COLLISION_1 + 2000, null);
        // Testing remove null from the end of the chain
        Assert.assertTrue(integers.remove(null));
        // Adding null back and creating a deep chain.
        integers.with(null, COLLISION_1 + 3000, COLLISION_1 + 4000, COLLISION_1 + 5000);
        // Removing null from the first position of a bucket in the deep chain
        Assert.assertTrue(integers.remove(null));
        Assert.assertFalse(integers.remove(null));
        // Removing from the end of the deep chain
        Assert.assertTrue(integers.remove(COLLISION_1 + 4000));
        // Removing from the first spot of the chain
        Assert.assertTrue(integers.remove(COLLISION_1));
        Verify.assertSize(4, integers);
        // Testing removing a non-existent element from a non bucket slot
        integers.add(2);
        integers.add(4);
        Assert.assertFalse(integers.remove(1002));
        // Testing removeIf
        Assert.assertTrue(integers.removeIf(IntegerPredicates.isEven()));
        Verify.assertEmpty(integers);
    }

    @Test
    public void removeFromPool() {
        Pool<Integer> unifiedSet = UnifiedSetWithHashingStrategy.newSet(INTEGER_HASHING_STRATEGY, 8).withAll(COLLISIONS);
        COLLISIONS.reverseForEach(each -> {
            Assert.assertNull(unifiedSet.removeFromPool(null));
            Assert.assertSame(each, unifiedSet.removeFromPool(each));
            Assert.assertNull(unifiedSet.removeFromPool(each));
            Assert.assertNull(unifiedSet.removeFromPool(null));
            Assert.assertNull(unifiedSet.removeFromPool(COLLISION_10));
        });
        Assert.assertEquals(UnifiedSetWithHashingStrategy.newSet(INTEGER_HASHING_STRATEGY), unifiedSet);
        COLLISIONS.forEach(Procedures.cast(each -> {
            Pool<Integer> unifiedSet2 = UnifiedSetWithHashingStrategy.newSet(INTEGER_HASHING_STRATEGY, 8).withAll(COLLISIONS);
            Assert.assertNull(unifiedSet2.removeFromPool(null));
            Assert.assertSame(each, unifiedSet2.removeFromPool(each));
            Assert.assertNull(unifiedSet2.removeFromPool(each));
            Assert.assertNull(unifiedSet2.removeFromPool(null));
            Assert.assertNull(unifiedSet2.removeFromPool(COLLISION_10));
        }));
        // search a chain for a non-existent element
        Pool<Integer> chain = UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4);
        Assert.assertNull(chain.removeFromPool(COLLISION_5));
        // search a deep chain for a non-existent element
        Pool<Integer> deepChain = UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4, COLLISION_5, COLLISION_6, COLLISION_7);
        Assert.assertNull(deepChain.removeFromPool(COLLISION_8));
        // search for a non-existent element
        Pool<Integer> empty = UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, COLLISION_1);
        Assert.assertNull(empty.removeFromPool(COLLISION_2));
    }

    @Test
    public void removeFromPool_with_hashingStrategy() {
        HashingStrategy<Integer> hashingStrategy = HashingStrategies.nullSafeHashingStrategy(new HashingStrategy<Integer>() {

            public int computeHashCode(Integer object) {
                return object % 1000;
            }

            public boolean equals(Integer object1, Integer object2) {
                return object1.equals(object2);
            }
        });
        UnifiedSetWithHashingStrategy<Integer> integers = UnifiedSetWithHashingStrategy.newSet(hashingStrategy, 2).with(COLLISION_1, COLLISION_1 + 1000, COLLISION_1 + 2000, null);
        // Testing remove null from the end of the chain
        Assert.assertNull(integers.removeFromPool(null));
        Integer collision4000 = COLLISION_1 + 4000;
        // Adding null back and creating a deep chain.
        integers.with(null, COLLISION_1 + 3000, collision4000, COLLISION_1 + 5000);
        // Removing null from the first position of a bucket in the deep chain
        Assert.assertNull(integers.removeFromPool(null));
        Verify.assertSize(6, integers);
        Assert.assertNull(integers.removeFromPool(null));
        Verify.assertSize(6, integers);
        // Removing from the end of the deep chain
        Assert.assertSame(collision4000, integers.removeFromPool(COLLISION_1 + 4000));
        // Removing from the first spot of the chain
        Assert.assertSame(COLLISION_1, integers.removeFromPool(COLLISION_1));
        Verify.assertSize(4, integers);
        // Testing removing an element that is not in a chained bucket
        Assert.assertSame(JOHNSMITH, UnifiedSetWithHashingStrategy.newSetWith(LAST_NAME_HASHING_STRATEGY, JOHNSMITH).removeFromPool(JOHNSMITH));
    }

    @Test
    public void serialization() {
        int size = COLLISIONS.size();
        for (int i = 1; i < size; i++) {
            MutableSet<Integer> set = UnifiedSetWithHashingStrategy.newSet(INTEGER_HASHING_STRATEGY, SIZE).withAll(COLLISIONS.subList(0, i));
            Verify.assertPostSerializedEqualsAndHashCode(set);
            set.add(null);
            Verify.assertPostSerializedEqualsAndHashCode(set);
        }
        UnifiedSetWithHashingStrategy<Integer> nullBucketZero = UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, null, COLLISION_1, COLLISION_2);
        Verify.assertPostSerializedEqualsAndHashCode(nullBucketZero);
        UnifiedSetWithHashingStrategy<Integer> simpleSetWithNull = UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, null, 1, 2);
        Verify.assertPostSerializedEqualsAndHashCode(simpleSetWithNull);
        UnifiedSetWithHashingStrategy<Person> people = UnifiedSetWithHashingStrategy.newSet(LAST_NAME_HASHING_STRATEGY, PEOPLE);
        Verify.assertPostSerializedEqualsAndHashCode(people);
        // Testing the hashingStrategy is serialized correctly by making sure it is still hashing by last name
        Verify.assertSetsEqual(LAST_NAME_HASHED_SET.castToSet(), people.withAll(PEOPLE.castToList()));
    }

    @Test
    public void null_behavior() {
        UnifiedSetWithHashingStrategy<Integer> unifiedSet = UnifiedSetWithHashingStrategy.newSet(INTEGER_HASHING_STRATEGY, 8).withAll(MORE_COLLISIONS);
        MORE_COLLISIONS.clone().reverseForEach(each -> {
            Assert.assertTrue(unifiedSet.add(null));
            Assert.assertFalse(unifiedSet.add(null));
            Verify.assertContains(null, unifiedSet);
            Verify.assertPostSerializedEqualsAndHashCode(unifiedSet);
            Assert.assertTrue(unifiedSet.remove(null));
            Assert.assertFalse(unifiedSet.remove(null));
            Verify.assertNotContains(null, unifiedSet);
            Verify.assertPostSerializedEqualsAndHashCode(unifiedSet);
            Assert.assertNull(unifiedSet.put(null));
            Assert.assertNull(unifiedSet.put(null));
            Assert.assertNull(unifiedSet.removeFromPool(null));
            Assert.assertNull(unifiedSet.removeFromPool(null));
            Verify.assertContains(each, unifiedSet);
            Assert.assertTrue(unifiedSet.remove(each));
            Assert.assertFalse(unifiedSet.remove(each));
            Verify.assertNotContains(each, unifiedSet);
        });
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        UnifiedSetWithHashingStrategy<Integer> singleCollisionBucket = UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, COLLISION_1, COLLISION_2);
        singleCollisionBucket.remove(COLLISION_2);
        Assert.assertEquals(singleCollisionBucket, UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, COLLISION_1));
        Verify.assertEqualsAndHashCode(UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, null, COLLISION_1, COLLISION_2, COLLISION_3), UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, null, COLLISION_1, COLLISION_2, COLLISION_3));
        Verify.assertEqualsAndHashCode(UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, COLLISION_1, null, COLLISION_2, COLLISION_3), UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, COLLISION_1, null, COLLISION_2, COLLISION_3));
        Verify.assertEqualsAndHashCode(UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, COLLISION_1, COLLISION_2, null, COLLISION_3), UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, COLLISION_1, COLLISION_2, null, COLLISION_3));
        Verify.assertEqualsAndHashCode(UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, COLLISION_1, COLLISION_2, COLLISION_3, null), UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, COLLISION_1, COLLISION_2, COLLISION_3, null));
    }

    @Test
    public void equals_with_hashingStrategy() {
        HashingStrategy<Person> personHashingStrategy = HashingStrategies.fromFunction(Person.TO_LAST);
        HashingStrategy<Person> personHashingStrategyCopy = HashingStrategies.fromFunction(Person.TO_LAST);
        UnifiedSetWithHashingStrategy<Person> setA = UnifiedSetWithHashingStrategy.newSet(personHashingStrategy, PEOPLE);
        UnifiedSetWithHashingStrategy<Person> setB = UnifiedSetWithHashingStrategy.newSet(personHashingStrategyCopy, PEOPLE);
        // Test sets with different instances of the same hashing strategy are equal symmetrically
        Verify.assertEqualsAndHashCode(setA, setB);
        // Checking that a hashing set is symmetrically equal to an identical JDK set
        Set<Person> hashSet = new HashSet<>(setA);
        Assert.assertTrue(hashSet.equals(setA) && setA.equals(hashSet));
        // Checking that a hash set is symmetrically equal to an identical Eclipse Collections set
        UnifiedSet<Person> unifiedSet = UnifiedSet.newSet(setA);
        Assert.assertTrue(unifiedSet.equals(setA) && setA.equals(unifiedSet));
        // Testing the asymmetry of equals
        HashingStrategy<String> firstLetterHashingStrategy = new HashingStrategy<String>() {

            public int computeHashCode(String object) {
                return Character.valueOf(object.charAt(0));
            }

            public boolean equals(String object1, String object2) {
                return object1.charAt(0) == object2.charAt(0);
            }
        };
        UnifiedSetWithHashingStrategy<String> hashedString = UnifiedSetWithHashingStrategy.newSetWith(firstLetterHashingStrategy, "apple", "banana", "cheese");
        UnifiedSetWithHashingStrategy<String> anotherHashedString = UnifiedSetWithHashingStrategy.newSetWith(firstLetterHashingStrategy, "a", "b", "c");
        UnifiedSet<String> normalString = UnifiedSet.newSetWith("alpha", "bravo", "charlie");
        // Testing hashedString equals normalString
        Assert.assertTrue(hashedString.equals(normalString) && hashedString.equals(hashedString));
        // Testing normalString does not equal a hashedString, note cannot use Assert.notEquals because it assumes symmetric equals behavior
        Assert.assertFalse(normalString.equals(hashedString) && hashedString.equals(normalString));
        // Testing 2 sets with same hashing strategies must obey object equals definition
        Verify.assertEqualsAndHashCode(hashedString, anotherHashedString);
        // Testing set size matters
        Assert.assertNotEquals(hashedString, normalString.remove("alpha"));
    }

    @Test
    public void constructor_from_UnifiedSet() {
        Verify.assertEqualsAndHashCode(new HashSet<>(MORE_COLLISIONS), UnifiedSetWithHashingStrategy.newSet(INTEGER_HASHING_STRATEGY, MORE_COLLISIONS));
    }

    @Test
    public void copyConstructor() {
        // test copying a chained bucket
        UnifiedSetWithHashingStrategy<Integer> set = UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4, COLLISION_5, COLLISION_6, COLLISION_7);
        Verify.assertEqualsAndHashCode(set, UnifiedSetWithHashingStrategy.newSet(INTEGER_HASHING_STRATEGY, set));
    }

    @Test(expected = NullPointerException.class)
    public void newSet_null() {
        UnifiedSetWithHashingStrategy.newSet((UnifiedSetWithHashingStrategy<Object>) null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newSet_null_hashingStrategy() {
        UnifiedSetWithHashingStrategy.newSet((HashingStrategy<Object>) null);
    }

    @Test
    public void batchForEach() {
        // Testing batch size of 1 to 16 with no chains
        UnifiedSet<Integer> set = UnifiedSet.<Integer>newSet(10).with(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        for (int sectionCount = 1; sectionCount <= 16; ++sectionCount) {
            Sum sum = new IntegerSum(0);
            for (int sectionIndex = 0; sectionIndex < sectionCount; ++sectionIndex) {
                set.batchForEach(new SumProcedure<>(sum), sectionIndex, sectionCount);
            }
            Assert.assertEquals(55, sum.getValue());
        }
        // Testing 1 batch with chains
        Sum sum2 = new IntegerSum(0);
        UnifiedSetWithHashingStrategy<Integer> set2 = UnifiedSetWithHashingStrategy.newSet(INTEGER_HASHING_STRATEGY, 3).with(COLLISION_1, COLLISION_2, COLLISION_3, 1, 2);
        int numBatches = set2.getBatchCount(100);
        for (int i = 0; i < numBatches; ++i) {
            set2.batchForEach(new SumProcedure<>(sum2), i, numBatches);
        }
        Assert.assertEquals(1, numBatches);
        Assert.assertEquals(54, sum2.getValue());
        // Testing batch size of 3 with chains and uneven last batch
        Sum sum3 = new IntegerSum(0);
        UnifiedSetWithHashingStrategy<Integer> set3 = UnifiedSetWithHashingStrategy.newSet(INTEGER_HASHING_STRATEGY, 4, 1.0F).with(COLLISION_1, COLLISION_2, 1, 2, 3, 4, 5);
        int numBatches2 = set3.getBatchCount(3);
        for (int i = 0; i < numBatches2; ++i) {
            set3.batchForEach(new SumProcedure<>(sum3), i, numBatches2);
        }
        Assert.assertEquals(32, sum3.getValue());
        // Test batchForEach on empty set, it should simply do nothing and not throw any exceptions
        Sum sum4 = new IntegerSum(0);
        UnifiedSetWithHashingStrategy<Integer> set4 = UnifiedSetWithHashingStrategy.newSet(INTEGER_HASHING_STRATEGY);
        set4.batchForEach(new SumProcedure<>(sum4), 0, set4.getBatchCount(1));
        Assert.assertEquals(0, sum4.getValue());
    }

    @Override
    @Test
    public void toArray() {
        super.toArray();
        int size = COLLISIONS.size();
        for (int i = 1; i < size; i++) {
            MutableSet<Integer> set = UnifiedSetWithHashingStrategy.newSet(INTEGER_HASHING_STRATEGY, SIZE).withAll(COLLISIONS.subList(0, i));
            Object[] objects = set.toArray();
            Assert.assertEquals(set, UnifiedSet.newSetWith(objects));
        }
        MutableSet<Integer> deepChain = UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4, COLLISION_5, COLLISION_6);
        Assert.assertArrayEquals(new Integer[] { COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4, COLLISION_5, COLLISION_6 }, deepChain.toArray());
        MutableSet<Integer> minimumChain = UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, COLLISION_1, COLLISION_2);
        minimumChain.remove(COLLISION_2);
        Assert.assertArrayEquals(new Integer[] { COLLISION_1 }, minimumChain.toArray());
        MutableSet<Integer> set = UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4);
        Integer[] target = { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1) };
        Integer[] actual = set.toArray(target);
        ArrayIterate.sort(actual, actual.length, Comparators.safeNullsHigh(Integer::compareTo));
        Assert.assertArrayEquals(new Integer[] { COLLISION_1, 1, COLLISION_2, COLLISION_3, COLLISION_4, null }, actual);
    }

    @Test
    public void iterator_remove() {
        int size = MORE_COLLISIONS.size();
        for (int i = 0; i < size; i++) {
            MutableSet<Integer> actual = UnifiedSetWithHashingStrategy.newSet(INTEGER_HASHING_STRATEGY, SIZE).withAll(MORE_COLLISIONS);
            Iterator<Integer> iterator = actual.iterator();
            for (int j = 0; j <= i; j++) {
                Assert.assertTrue(iterator.hasNext());
                iterator.next();
            }
            iterator.remove();
            MutableSet<Integer> expected = UnifiedSetWithHashingStrategy.newSet(INTEGER_HASHING_STRATEGY, MORE_COLLISIONS);
            expected.remove(MORE_COLLISIONS.get(i));
            Assert.assertEquals(expected, actual);
        }
        // remove the last element from within a 2-level long chain that is fully populated
        MutableSet<Integer> set = UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4, COLLISION_5, COLLISION_6, COLLISION_7);
        Iterator<Integer> iterator1 = set.iterator();
        for (int i = 0; i < 7; i++) {
            iterator1.next();
        }
        iterator1.remove();
        Assert.assertEquals(UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4, COLLISION_5, COLLISION_6), set);
        // remove the second-to-last element from a 2-level long chain that that has one empty slot
        Iterator<Integer> iterator2 = set.iterator();
        for (int i = 0; i < 6; i++) {
            iterator2.next();
        }
        iterator2.remove();
        Assert.assertEquals(UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4, COLLISION_5), set);
        // Testing removing the last element in a fully populated chained bucket
        UnifiedSetWithHashingStrategy<Integer> set2 = UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, COLLISION_1, COLLISION_2, COLLISION_3, COLLISION_4);
        Iterator<Integer> iterator3 = set2.iterator();
        for (int i = 0; i < 3; ++i) {
            iterator3.next();
        }
        iterator3.next();
        iterator3.remove();
        Verify.assertSetsEqual(UnifiedSet.newSetWith(COLLISION_1, COLLISION_2, COLLISION_3), set2);
    }

    @Test
    public void setKeyPreservation() {
        Key key = new Key("key");
        Key duplicateKey1 = new Key("key");
        MutableSet<Key> set1 = UnifiedSetWithHashingStrategy.newSet(HashingStrategies.<Key>defaultStrategy()).with(key, duplicateKey1);
        Verify.assertSize(1, set1);
        Verify.assertContains(key, set1);
        Assert.assertSame(key, set1.getFirst());
        Key duplicateKey2 = new Key("key");
        MutableSet<Key> set2 = UnifiedSetWithHashingStrategy.newSet(HashingStrategies.<Key>defaultStrategy()).with(key, duplicateKey1, duplicateKey2);
        Verify.assertSize(1, set2);
        Verify.assertContains(key, set2);
        Assert.assertSame(key, set2.getFirst());
        Key duplicateKey3 = new Key("key");
        MutableSet<Key> set3 = UnifiedSetWithHashingStrategy.newSet(HashingStrategies.<Key>defaultStrategy()).with(key, new Key("not a dupe"), duplicateKey3);
        Verify.assertSize(2, set3);
        Verify.assertContainsAll(set3, key, new Key("not a dupe"));
        Assert.assertSame(key, set3.detect(key::equals));
    }

    @Test
    public void withSameIfNotModified() {
        UnifiedSetWithHashingStrategy<Integer> integers = UnifiedSetWithHashingStrategy.newSet(INTEGER_HASHING_STRATEGY);
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2), integers.with(1, 2));
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3, 4), integers.with(2, 3, 4));
        Assert.assertSame(integers, integers.with(5, 6, 7));
    }

    @Override
    @Test
    public void retainAll() {
        super.retainAll();
        MutableSet<Object> setWithNull = this.newWith((Object) null);
        Assert.assertFalse(setWithNull.retainAll(FastList.newListWith((Object) null)));
        Assert.assertEquals(UnifiedSet.newSetWith((Object) null), setWithNull);
    }

    @Override
    public void getFirst() {
        super.getFirst();
        int size = MORE_COLLISIONS.size();
        for (int i = 1; i <= size - 1; i++) {
            MutableSet<Integer> unifiedSet = UnifiedSetWithHashingStrategy.newSet(INTEGER_HASHING_STRATEGY, 1).withAll(MORE_COLLISIONS.subList(0, i));
            Assert.assertSame(MORE_COLLISIONS.get(0), unifiedSet.getFirst());
        }
    }

    @Override
    public void getLast() {
        super.getLast();
        int size = MORE_COLLISIONS.size();
        for (int i = 1; i <= size - 1; i++) {
            MutableSet<Integer> unifiedSet = UnifiedSetWithHashingStrategy.newSet(INTEGER_HASHING_STRATEGY, 1).withAll(MORE_COLLISIONS.subList(0, i));
            Assert.assertSame(MORE_COLLISIONS.get(i - 1), unifiedSet.getLast());
        }
        MutableSet<Integer> chainedWithOneSlot = UnifiedSetWithHashingStrategy.newSetWith(INTEGER_HASHING_STRATEGY, COLLISION_1, COLLISION_2);
        chainedWithOneSlot.remove(COLLISION_2);
        Assert.assertSame(COLLISION_1, chainedWithOneSlot.getLast());
    }

    @Test
    public void trimToSize() {
        UnifiedSetWithHashingStrategy<String> set = UnifiedSetWithHashingStrategy.newSet(HashingStrategies.defaultStrategy());
        MutableSet<String> expected = Sets.mutable.empty();
        Interval integers = Interval.fromTo(0, 250);
        integers.each(each -> {
            set.add(each.toString());
            expected.add(each.toString());
        });
        ArrayIterate.forEach(FREQUENT_COLLISIONS, each -> {
            set.add(each);
            expected.add(each);
        });
        Assert.assertEquals(expected, set);
        Assert.assertEquals(261, set.size());
        MutableList<Integer> toRemove = Lists.mutable.withAll(Interval.evensFromTo(0, 20));
        toRemove.addAll(Interval.oddsFromTo(35, 55));
        toRemove.each(each -> {
            set.remove(each.toString());
            expected.remove(each.toString());
        });
        // First assertion to verify that trim does not happen since, the table is already at the smallest required power of 2.
        Assert.assertFalse(set.trimToSize());
        Assert.assertEquals(239, set.size());
        Assert.assertEquals(expected, set);
        Interval.evensFromTo(0, 250).each(each -> {
            set.remove(each.toString());
            expected.remove(each.toString());
        });
        // Second assertion to verify that trim happens since, the table length is less than smallest required power of 2.
        Assert.assertTrue(set.trimToSize());
        Assert.assertFalse(set.trimToSize());
        Assert.assertEquals(expected, set);
        Assert.assertEquals(124, set.size());
        expected.each(each -> Assert.assertEquals(each, set.get(each)));
        integers.each(each -> {
            set.remove(each.toString());
            expected.remove(each.toString());
        });
        Assert.assertTrue(set.trimToSize());
        Assert.assertFalse(set.trimToSize());
        Assert.assertEquals(expected, set);
        expected.each(each -> Assert.assertEquals(each, set.get(each)));
        set.clear();
        Assert.assertTrue(set.trimToSize());
        Interval.oneTo(4).each(each -> set.add(each.toString()));
        // Assert that trim does not happen after puts
        Assert.assertFalse(set.trimToSize());
        set.remove("1");
        set.remove("2");
        Assert.assertTrue(set.trimToSize());
        set.add("1");
        // Assert that the resized table due to put is the required size and no need to trim that.
        Assert.assertFalse(set.trimToSize());
        Interval.zeroTo(4).each(each -> set.add(each.toString()));
        Interval.oneTo(3).each(each -> set.remove(each.toString()));
        Assert.assertTrue(set.trimToSize());
        Assert.assertEquals(2, set.size());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnifiedSetWithHashingStrategyTest instance;

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
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
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
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
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
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
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
        public void benchmark_addOnObjectWithCastInEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addOnObjectWithCastInEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromKeySet_null_collision() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromKeySet_null_collision);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rehash_null_collision() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rehash_null_collision);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newSet_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newSet_throws);
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
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lazyCollectForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lazyCollectForEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lazyRejectForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lazyRejectForEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lazySelectForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lazySelectForEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newSetWithIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newSetWithIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add_with_hashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add_with_hashingStrategy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOrReplace() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addOrReplace);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addALLIterable_with_hashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addALLIterable_with_hashingStrategy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_with_hashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get_with_hashingStrategy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_with_hashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_with_hashingStrategy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove_with_hashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove_with_hashingStrategy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromPool() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromPool);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromPool_with_hashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromPool_with_hashingStrategy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_null_behavior() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.null_behavior);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equals_with_hashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equals_with_hashingStrategy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_constructor_from_UnifiedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.constructor_from_UnifiedSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_copyConstructor() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.copyConstructor);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newSet_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newSet_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newSet_null_hashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newSet_null_hashingStrategy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_setKeyPreservation() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.setKeyPreservation);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withSameIfNotModified() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withSameIfNotModified);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_trimToSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.trimToSize);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> payload) throws java.lang.Throwable {
            this.instance = new UnifiedSetWithHashingStrategyTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> unionInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> intersectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> differenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> symmetricDifferenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> powerSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> unifiedSetKeySetToArrayDest;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> unifiedSetToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> iterator_increment_past_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> iterator_remove_without_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> frequentCollisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> addOnObjectWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> retainAllFromKeySet_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> rehash_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> newSet_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> lazyCollectForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> lazyRejectForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> lazySelectForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> newSetWithIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> add_with_hashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> addOrReplace;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> addALLIterable_with_hashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> get_with_hashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> put_with_hashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> remove_with_hashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> removeFromPool;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> removeFromPool_with_hashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> null_behavior;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> equals_with_hashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> constructor_from_UnifiedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> copyConstructor;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> newSet_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> newSet_null_hashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> batchForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> iterator_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> setKeyPreservation;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> withSameIfNotModified;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyTest> trimToSize;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = UnifiedSetWithHashingStrategyTest::testNewCollection;
            this.payloads.contains = UnifiedSetWithHashingStrategyTest::contains;
            this.payloads.containsBy = UnifiedSetWithHashingStrategyTest::containsBy;
            this.payloads.containsAllIterable = UnifiedSetWithHashingStrategyTest::containsAllIterable;
            this.payloads.containsAnyIterable = UnifiedSetWithHashingStrategyTest::containsAnyIterable;
            this.payloads.containsNoneIterable = UnifiedSetWithHashingStrategyTest::containsNoneIterable;
            this.payloads.containsAllArray = UnifiedSetWithHashingStrategyTest::containsAllArray;
            this.payloads.containsAnyCollection = UnifiedSetWithHashingStrategyTest::containsAnyCollection;
            this.payloads.containsNoneCollection = UnifiedSetWithHashingStrategyTest::containsNoneCollection;
            this.payloads.containsAllCollection = UnifiedSetWithHashingStrategyTest::containsAllCollection;
            this.payloads.selectWith = UnifiedSetWithHashingStrategyTest::selectWith;
            this.payloads.selectWith_target = UnifiedSetWithHashingStrategyTest::selectWith_target;
            this.payloads.rejectWith = UnifiedSetWithHashingStrategyTest::rejectWith;
            this.payloads.rejectWith_target = UnifiedSetWithHashingStrategyTest::rejectWith_target;
            this.payloads.selectInstancesOf = UnifiedSetWithHashingStrategyTest::selectInstancesOf;
            this.payloads.collect = UnifiedSetWithHashingStrategyTest::collect;
            this.payloads.collectTarget = UnifiedSetWithHashingStrategyTest::collectTarget;
            this.payloads.collectBoolean = UnifiedSetWithHashingStrategyTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = UnifiedSetWithHashingStrategyTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = UnifiedSetWithHashingStrategyTest::collectBooleanWithBagTarget;
            this.payloads.collectByte = UnifiedSetWithHashingStrategyTest::collectByte;
            this.payloads.collectByteWithTarget = UnifiedSetWithHashingStrategyTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = UnifiedSetWithHashingStrategyTest::collectByteWithBagTarget;
            this.payloads.collectChar = UnifiedSetWithHashingStrategyTest::collectChar;
            this.payloads.collectCharWithTarget = UnifiedSetWithHashingStrategyTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = UnifiedSetWithHashingStrategyTest::collectCharWithBagTarget;
            this.payloads.collectDouble = UnifiedSetWithHashingStrategyTest::collectDouble;
            this.payloads.collectDoubleWithTarget = UnifiedSetWithHashingStrategyTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = UnifiedSetWithHashingStrategyTest::collectDoubleWithBagTarget;
            this.payloads.collectFloat = UnifiedSetWithHashingStrategyTest::collectFloat;
            this.payloads.collectFloatWithTarget = UnifiedSetWithHashingStrategyTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = UnifiedSetWithHashingStrategyTest::collectFloatWithBagTarget;
            this.payloads.collectInt = UnifiedSetWithHashingStrategyTest::collectInt;
            this.payloads.collectIntWithTarget = UnifiedSetWithHashingStrategyTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = UnifiedSetWithHashingStrategyTest::collectIntWithBagTarget;
            this.payloads.collectLong = UnifiedSetWithHashingStrategyTest::collectLong;
            this.payloads.collectLongWithTarget = UnifiedSetWithHashingStrategyTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = UnifiedSetWithHashingStrategyTest::collectLongWithBagTarget;
            this.payloads.collectShort = UnifiedSetWithHashingStrategyTest::collectShort;
            this.payloads.collectShortWithTarget = UnifiedSetWithHashingStrategyTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = UnifiedSetWithHashingStrategyTest::collectShortWithBagTarget;
            this.payloads.flatCollect = UnifiedSetWithHashingStrategyTest::flatCollect;
            this.payloads.flatCollectWith = UnifiedSetWithHashingStrategyTest::flatCollectWith;
            this.payloads.flatCollectBoolean = UnifiedSetWithHashingStrategyTest::flatCollectBoolean;
            this.payloads.flatCollectByte = UnifiedSetWithHashingStrategyTest::flatCollectByte;
            this.payloads.flatCollectShort = UnifiedSetWithHashingStrategyTest::flatCollectShort;
            this.payloads.flatCollectInt = UnifiedSetWithHashingStrategyTest::flatCollectInt;
            this.payloads.flatCollectChar = UnifiedSetWithHashingStrategyTest::flatCollectChar;
            this.payloads.flatCollectLong = UnifiedSetWithHashingStrategyTest::flatCollectLong;
            this.payloads.flatCollectDouble = UnifiedSetWithHashingStrategyTest::flatCollectDouble;
            this.payloads.flatCollectFloat = UnifiedSetWithHashingStrategyTest::flatCollectFloat;
            this.payloads.detectOptional = UnifiedSetWithHashingStrategyTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = UnifiedSetWithHashingStrategyTest::min;
            this.payloads.minOptional = UnifiedSetWithHashingStrategyTest::minOptional;
            this.payloads.max = UnifiedSetWithHashingStrategyTest::max;
            this.payloads.maxOptional = UnifiedSetWithHashingStrategyTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = UnifiedSetWithHashingStrategyTest::min_without_comparator;
            this.payloads.max_without_comparator = UnifiedSetWithHashingStrategyTest::max_without_comparator;
            this.payloads.min_null_safe = UnifiedSetWithHashingStrategyTest::min_null_safe;
            this.payloads.max_null_safe = UnifiedSetWithHashingStrategyTest::max_null_safe;
            this.payloads.minBy = UnifiedSetWithHashingStrategyTest::minBy;
            this.payloads.minByOptional = UnifiedSetWithHashingStrategyTest::minByOptional;
            this.payloads.maxBy = UnifiedSetWithHashingStrategyTest::maxBy;
            this.payloads.maxByOptional = UnifiedSetWithHashingStrategyTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = UnifiedSetWithHashingStrategyTest::detectWith;
            this.payloads.detectWithOptional = UnifiedSetWithHashingStrategyTest::detectWithOptional;
            this.payloads.detectIfNone = UnifiedSetWithHashingStrategyTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = UnifiedSetWithHashingStrategyTest::detectWithIfNoneBlock;
            this.payloads.count = UnifiedSetWithHashingStrategyTest::count;
            this.payloads.countWith = UnifiedSetWithHashingStrategyTest::countWith;
            this.payloads.collectIf = UnifiedSetWithHashingStrategyTest::collectIf;
            this.payloads.collectWith = UnifiedSetWithHashingStrategyTest::collectWith;
            this.payloads.collectWith_target = UnifiedSetWithHashingStrategyTest::collectWith_target;
            this.payloads.getAny = UnifiedSetWithHashingStrategyTest::getAny;
            this.payloads.getOnly = UnifiedSetWithHashingStrategyTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.iterator = UnifiedSetWithHashingStrategyTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = UnifiedSetWithHashingStrategyTest::injectInto;
            this.payloads.injectIntoInt = UnifiedSetWithHashingStrategyTest::injectIntoInt;
            this.payloads.injectIntoLong = UnifiedSetWithHashingStrategyTest::injectIntoLong;
            this.payloads.injectIntoDouble = UnifiedSetWithHashingStrategyTest::injectIntoDouble;
            this.payloads.injectIntoFloat = UnifiedSetWithHashingStrategyTest::injectIntoFloat;
            this.payloads.sumFloat = UnifiedSetWithHashingStrategyTest::sumFloat;
            this.payloads.summarizeFloat = UnifiedSetWithHashingStrategyTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = UnifiedSetWithHashingStrategyTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = UnifiedSetWithHashingStrategyTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = UnifiedSetWithHashingStrategyTest::sumDouble;
            this.payloads.summarizeDouble = UnifiedSetWithHashingStrategyTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = UnifiedSetWithHashingStrategyTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = UnifiedSetWithHashingStrategyTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = UnifiedSetWithHashingStrategyTest::sumInteger;
            this.payloads.summarizeInt = UnifiedSetWithHashingStrategyTest::summarizeInt;
            this.payloads.sumLong = UnifiedSetWithHashingStrategyTest::sumLong;
            this.payloads.summarizeLong = UnifiedSetWithHashingStrategyTest::summarizeLong;
            this.payloads.sumByInt = UnifiedSetWithHashingStrategyTest::sumByInt;
            this.payloads.sumByFloat = UnifiedSetWithHashingStrategyTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = UnifiedSetWithHashingStrategyTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = UnifiedSetWithHashingStrategyTest::sumByLong;
            this.payloads.sumByDouble = UnifiedSetWithHashingStrategyTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = UnifiedSetWithHashingStrategyTest::sumByDoubleConsistentRounding;
            this.payloads.partition = UnifiedSetWithHashingStrategyTest::partition;
            this.payloads.partitionWith = UnifiedSetWithHashingStrategyTest::partitionWith;
            this.payloads.toList = UnifiedSetWithHashingStrategyTest::toList;
            this.payloads.toImmutableList = UnifiedSetWithHashingStrategyTest::toImmutableList;
            this.payloads.toCollection = UnifiedSetWithHashingStrategyTest::toCollection;
            this.payloads.toBag = UnifiedSetWithHashingStrategyTest::toBag;
            this.payloads.toImmutableBag = UnifiedSetWithHashingStrategyTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = UnifiedSetWithHashingStrategyTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = UnifiedSetWithHashingStrategyTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = UnifiedSetWithHashingStrategyTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = UnifiedSetWithHashingStrategyTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBag_natural_ordering = UnifiedSetWithHashingStrategyTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBagBy = UnifiedSetWithHashingStrategyTest::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = UnifiedSetWithHashingStrategyTest::toSortedListBy;
            this.payloads.toImmutableSortedListBy = UnifiedSetWithHashingStrategyTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = UnifiedSetWithHashingStrategyTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = UnifiedSetWithHashingStrategyTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = UnifiedSetWithHashingStrategyTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = UnifiedSetWithHashingStrategyTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = UnifiedSetWithHashingStrategyTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = UnifiedSetWithHashingStrategyTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = UnifiedSetWithHashingStrategyTest::toSet;
            this.payloads.toImmutableSet = UnifiedSetWithHashingStrategyTest::toImmutableSet;
            this.payloads.toMap = UnifiedSetWithHashingStrategyTest::toMap;
            this.payloads.toImmutableMap = UnifiedSetWithHashingStrategyTest::toImmutableMap;
            this.payloads.toMapTarget = UnifiedSetWithHashingStrategyTest::toMapTarget;
            this.payloads.toSortedMap = UnifiedSetWithHashingStrategyTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = UnifiedSetWithHashingStrategyTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = UnifiedSetWithHashingStrategyTest::toSortedMapBy;
            this.payloads.toBiMap = UnifiedSetWithHashingStrategyTest::toBiMap;
            this.payloads.toImmutableBiMap = UnifiedSetWithHashingStrategyTest::toImmutableBiMap;
            this.payloads.testToString = UnifiedSetWithHashingStrategyTest::testToString;
            this.payloads.makeString = UnifiedSetWithHashingStrategyTest::makeString;
            this.payloads.makeStringWithSeparator = UnifiedSetWithHashingStrategyTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = UnifiedSetWithHashingStrategyTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = UnifiedSetWithHashingStrategyTest::fusedCollectMakeString;
            this.payloads.appendString = UnifiedSetWithHashingStrategyTest::appendString;
            this.payloads.appendStringWithSeparator = UnifiedSetWithHashingStrategyTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = UnifiedSetWithHashingStrategyTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = UnifiedSetWithHashingStrategyTest::appendStringThrows;
            this.payloads.countBy = UnifiedSetWithHashingStrategyTest::countBy;
            this.payloads.countByWith = UnifiedSetWithHashingStrategyTest::countByWith;
            this.payloads.countByEach = UnifiedSetWithHashingStrategyTest::countByEach;
            this.payloads.groupBy = UnifiedSetWithHashingStrategyTest::groupBy;
            this.payloads.groupByEach = UnifiedSetWithHashingStrategyTest::groupByEach;
            this.payloads.groupByUniqueKey = UnifiedSetWithHashingStrategyTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = UnifiedSetWithHashingStrategyTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = UnifiedSetWithHashingStrategyTest::zip;
            this.payloads.zipWithIndex = UnifiedSetWithHashingStrategyTest::zipWithIndex;
            this.payloads.chunk = UnifiedSetWithHashingStrategyTest::chunk;
            this.payloads.chunk_empty = UnifiedSetWithHashingStrategyTest::chunk_empty;
            this.payloads.chunk_single = UnifiedSetWithHashingStrategyTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = UnifiedSetWithHashingStrategyTest::chunk_large_size;
            this.payloads.empty = UnifiedSetWithHashingStrategyTest::empty;
            this.payloads.notEmpty = UnifiedSetWithHashingStrategyTest::notEmpty;
            this.payloads.aggregateByMutating = UnifiedSetWithHashingStrategyTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = UnifiedSetWithHashingStrategyTest::aggregateByNonMutating;
            this.payloads.reduceOptional = UnifiedSetWithHashingStrategyTest::reduceOptional;
            this.payloads.newEmpty = UnifiedSetWithHashingStrategyTest::newEmpty;
            this.payloads.toImmutable = UnifiedSetWithHashingStrategyTest::toImmutable;
            this.payloads.testNewWith = UnifiedSetWithHashingStrategyTest::testNewWith;
            this.payloads.testNewWithWith = UnifiedSetWithHashingStrategyTest::testNewWithWith;
            this.payloads.testNewWithWithWith = UnifiedSetWithHashingStrategyTest::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = UnifiedSetWithHashingStrategyTest::testNewWithVarArgs;
            this.payloads.removeAll = UnifiedSetWithHashingStrategyTest::removeAll;
            this.payloads.removeAllIterable = UnifiedSetWithHashingStrategyTest::removeAllIterable;
            this.payloads.retainAllIterable = UnifiedSetWithHashingStrategyTest::retainAllIterable;
            this.payloads.clear = UnifiedSetWithHashingStrategyTest::clear;
            this.payloads.injectIntoWith = UnifiedSetWithHashingStrategyTest::injectIntoWith;
            this.payloads.removeObject = UnifiedSetWithHashingStrategyTest::removeObject;
            this.payloads.selectAndRejectWith = UnifiedSetWithHashingStrategyTest::selectAndRejectWith;
            this.payloads.removeIfWith = UnifiedSetWithHashingStrategyTest::removeIfWith;
            this.payloads.withAll = UnifiedSetWithHashingStrategyTest::withAll;
            this.payloads.without = UnifiedSetWithHashingStrategyTest::without;
            this.payloads.withoutAll = UnifiedSetWithHashingStrategyTest::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = UnifiedSetWithHashingStrategyTest::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = UnifiedSetWithHashingStrategyTest::asLazy;
            this.payloads.asSynchronized = UnifiedSetWithHashingStrategyTest::asSynchronized;
            this.payloads.addAll = UnifiedSetWithHashingStrategyTest::addAll;
            this.payloads.union = UnifiedSetWithHashingStrategyTest::union;
            this.payloads.unionInto = UnifiedSetWithHashingStrategyTest::unionInto;
            this.payloads.intersect = UnifiedSetWithHashingStrategyTest::intersect;
            this.payloads.intersectInto = UnifiedSetWithHashingStrategyTest::intersectInto;
            this.payloads.difference = UnifiedSetWithHashingStrategyTest::difference;
            this.payloads.differenceInto = UnifiedSetWithHashingStrategyTest::differenceInto;
            this.payloads.symmetricDifference = UnifiedSetWithHashingStrategyTest::symmetricDifference;
            this.payloads.symmetricDifferenceInto = UnifiedSetWithHashingStrategyTest::symmetricDifferenceInto;
            this.payloads.isSubsetOf = UnifiedSetWithHashingStrategyTest::isSubsetOf;
            this.payloads.isProperSubsetOf = UnifiedSetWithHashingStrategyTest::isProperSubsetOf;
            this.payloads.powerSet = UnifiedSetWithHashingStrategyTest::powerSet;
            this.payloads.cartesianProduct = UnifiedSetWithHashingStrategyTest::cartesianProduct;
            this.payloads.asUnmodifiable = UnifiedSetWithHashingStrategyTest::asUnmodifiable;
            this.payloads.getFirst = UnifiedSetWithHashingStrategyTest::getFirst;
            this.payloads.getLast = UnifiedSetWithHashingStrategyTest::getLast;
            this.payloads.unifiedSetKeySetToArrayDest = UnifiedSetWithHashingStrategyTest::unifiedSetKeySetToArrayDest;
            this.payloads.unifiedSetToString = UnifiedSetWithHashingStrategyTest::unifiedSetToString;
            this.payloads.testClone = UnifiedSetWithHashingStrategyTest::testClone;
            this.payloads.isEmpty = UnifiedSetWithHashingStrategyTest::isEmpty;
            this.payloads.removeIf = UnifiedSetWithHashingStrategyTest::removeIf;
            this.payloads.forEach = UnifiedSetWithHashingStrategyTest::forEach;
            this.payloads.forEachWith = UnifiedSetWithHashingStrategyTest::forEachWith;
            this.payloads.forEachWithIndex = UnifiedSetWithHashingStrategyTest::forEachWithIndex;
            this.payloads.anySatisfy = UnifiedSetWithHashingStrategyTest::anySatisfy;
            this.payloads.anySatisfyWith = UnifiedSetWithHashingStrategyTest::anySatisfyWith;
            this.payloads.allSatisfy = UnifiedSetWithHashingStrategyTest::allSatisfy;
            this.payloads.allSatisfyWith = UnifiedSetWithHashingStrategyTest::allSatisfyWith;
            this.payloads.noneSatisfy = UnifiedSetWithHashingStrategyTest::noneSatisfy;
            this.payloads.noneSatisfyWith = UnifiedSetWithHashingStrategyTest::noneSatisfyWith;
            this.payloads.detect = UnifiedSetWithHashingStrategyTest::detect;
            this.payloads.iterator_increment_past_end = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyTest::iterator_increment_past_end, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_without_next = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyTest::iterator_remove_without_next, java.lang.IllegalStateException.class);
            this.payloads.toSortedBag_natural_ordering = UnifiedSetWithHashingStrategyTest::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = UnifiedSetWithHashingStrategyTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = UnifiedSetWithHashingStrategyTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = UnifiedSetWithHashingStrategyTest::toSortedBagBy;
            this.payloads.frequentCollisions = UnifiedSetWithHashingStrategyTest::frequentCollisions;
            this.payloads.addOnObjectWithCastInEquals = UnifiedSetWithHashingStrategyTest::addOnObjectWithCastInEquals;
            this.payloads.retainAllFromKeySet_null_collision = UnifiedSetWithHashingStrategyTest::retainAllFromKeySet_null_collision;
            this.payloads.rehash_null_collision = UnifiedSetWithHashingStrategyTest::rehash_null_collision;
            this.payloads.newSet_throws = UnifiedSetWithHashingStrategyTest::newSet_throws;
            this.payloads.tap = UnifiedSetWithHashingStrategyTest::tap;
            this.payloads.select = UnifiedSetWithHashingStrategyTest::select;
            this.payloads.reject = UnifiedSetWithHashingStrategyTest::reject;
            this.payloads.lazyCollectForEach = UnifiedSetWithHashingStrategyTest::lazyCollectForEach;
            this.payloads.lazyRejectForEach = UnifiedSetWithHashingStrategyTest::lazyRejectForEach;
            this.payloads.lazySelectForEach = UnifiedSetWithHashingStrategyTest::lazySelectForEach;
            this.payloads.with = UnifiedSetWithHashingStrategyTest::with;
            this.payloads.newSetWithIterable = UnifiedSetWithHashingStrategyTest::newSetWithIterable;
            this.payloads.add = UnifiedSetWithHashingStrategyTest::add;
            this.payloads.add_with_hashingStrategy = UnifiedSetWithHashingStrategyTest::add_with_hashingStrategy;
            this.payloads.addOrReplace = UnifiedSetWithHashingStrategyTest::addOrReplace;
            this.payloads.addAllIterable = UnifiedSetWithHashingStrategyTest::addAllIterable;
            this.payloads.addALLIterable_with_hashingStrategy = UnifiedSetWithHashingStrategyTest::addALLIterable_with_hashingStrategy;
            this.payloads.get = UnifiedSetWithHashingStrategyTest::get;
            this.payloads.get_with_hashingStrategy = UnifiedSetWithHashingStrategyTest::get_with_hashingStrategy;
            this.payloads.put = UnifiedSetWithHashingStrategyTest::put;
            this.payloads.put_with_hashingStrategy = UnifiedSetWithHashingStrategyTest::put_with_hashingStrategy;
            this.payloads.remove_with_hashingStrategy = UnifiedSetWithHashingStrategyTest::remove_with_hashingStrategy;
            this.payloads.removeFromPool = UnifiedSetWithHashingStrategyTest::removeFromPool;
            this.payloads.removeFromPool_with_hashingStrategy = UnifiedSetWithHashingStrategyTest::removeFromPool_with_hashingStrategy;
            this.payloads.serialization = UnifiedSetWithHashingStrategyTest::serialization;
            this.payloads.null_behavior = UnifiedSetWithHashingStrategyTest::null_behavior;
            this.payloads.equalsAndHashCode = UnifiedSetWithHashingStrategyTest::equalsAndHashCode;
            this.payloads.equals_with_hashingStrategy = UnifiedSetWithHashingStrategyTest::equals_with_hashingStrategy;
            this.payloads.constructor_from_UnifiedSet = UnifiedSetWithHashingStrategyTest::constructor_from_UnifiedSet;
            this.payloads.copyConstructor = UnifiedSetWithHashingStrategyTest::copyConstructor;
            this.payloads.newSet_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyTest::newSet_null, java.lang.NullPointerException.class);
            this.payloads.newSet_null_hashingStrategy = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyTest::newSet_null_hashingStrategy, java.lang.IllegalArgumentException.class);
            this.payloads.batchForEach = UnifiedSetWithHashingStrategyTest::batchForEach;
            this.payloads.toArray = UnifiedSetWithHashingStrategyTest::toArray;
            this.payloads.iterator_remove = UnifiedSetWithHashingStrategyTest::iterator_remove;
            this.payloads.setKeyPreservation = UnifiedSetWithHashingStrategyTest::setKeyPreservation;
            this.payloads.withSameIfNotModified = UnifiedSetWithHashingStrategyTest::withSameIfNotModified;
            this.payloads.retainAll = UnifiedSetWithHashingStrategyTest::retainAll;
            this.payloads.trimToSize = UnifiedSetWithHashingStrategyTest::trimToSize;
        }
    }
}
