/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.factory;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.predicate.Predicate;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.Twin;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.eclipse.collections.impl.utility.ListIterate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PredicatesTest {

    private Employee alice;

    private Employee bob;

    private Employee charlie;

    private Employee diane;

    private MutableList<Employee> employees;

    @Before
    public void setUp() {
        this.alice = new Employee(new Address(State.ARIZONA));
        this.alice.addDependent(new Dependent(DependentType.SPOUSE));
        this.alice.addDependent(new Dependent(DependentType.CHILD));
        this.alice.addDependent(new Dependent(DependentType.CHILD));
        this.alice.addDependent(new Dependent(DependentType.PARENT));
        this.bob = new Employee(new Address(State.ALASKA));
        this.bob.addDependent(new Dependent(DependentType.SPOUSE));
        this.bob.addDependent(new Dependent(DependentType.CHILD));
        this.charlie = new Employee(new Address(State.ARIZONA));
        this.charlie.addDependent(new Dependent(DependentType.SPOUSE));
        this.charlie.addDependent(new Dependent(DependentType.CHILD));
        this.charlie.addDependent(new Dependent(DependentType.CHILD));
        this.diane = new Employee(new Address(State.ALASKA));
        this.diane.addDependent(new Dependent(DependentType.SPOUSE));
        this.diane.addDependent(new Dependent(DependentType.PARENT));
        this.diane.addDependent(new Dependent(DependentType.PARENT));
        this.diane.addDependent(new Dependent(DependentType.GRANDPARENT));
        this.employees = FastList.newListWith(this.alice, this.bob, this.charlie, this.diane);
    }

    @Test
    public void throwing() {
        Verify.assertThrowsWithCause(RuntimeException.class, IOException.class, () -> {
            Predicates.throwing(e -> {
                throw new IOException();
            }).accept(null);
        });
    }

    @Test
    public void throwingNoException() {
        Assert.assertTrue(Predicates.throwing(object -> true).accept(true));
    }

    @Test
    public void throwingWithUserSpecifiedException() {
        Verify.assertThrowsWithCause(RuntimeException.class, IOException.class, () -> {
            Predicates.throwing(a -> {
                throw new IOException();
            }, (each, ce) -> new RuntimeException(ce)).accept(null);
        });
        Verify.assertThrowsWithCause(MyRuntimeException.class, IOException.class, () -> {
            Predicates.throwing(a -> {
                throw new IOException();
            }, this::throwMyException).accept(null);
        });
        Verify.assertThrows(NullPointerException.class, () -> {
            Predicates.throwing(a -> {
                throw new NullPointerException();
            }, this::throwMyException).accept(null);
        });
    }

    private MyRuntimeException throwMyException(Object each, Throwable exception) {
        return new MyRuntimeException(String.valueOf(each), exception);
    }

    @Test
    public void bind() {
        MutableList<Integer> list = Lists.mutable.of(1, 2, 3);
        Predicate<Integer> predicate = Predicates.bind((element, parameter) -> (element + parameter) % 2 == 0, 1);
        Verify.assertListsEqual(Lists.mutable.of(1, 3), list.select(predicate));
        PredicatesTest.assertToString(predicate);
    }

    @Test
    public void alwaysTrue() {
        PredicatesTest.assertAccepts(Predicates.alwaysTrue(), (Object) null);
        PredicatesTest.assertToString(Predicates.alwaysTrue());
    }

    @Test
    public void alwaysFalse() {
        PredicatesTest.assertRejects(Predicates.alwaysFalse(), (Object) null);
        PredicatesTest.assertToString(Predicates.alwaysFalse());
    }

    @Test
    public void instanceNot() {
        PredicatesTest.assertRejects(Predicates.alwaysTrue().not(), (Object) null);
        PredicatesTest.assertToString(Predicates.alwaysTrue().not());
    }

    @Test
    public void synchronizedEach() {
        Predicate<Object> predicate = Predicates.synchronizedEach(Predicates.alwaysTrue());
        PredicatesTest.assertAccepts(predicate, new Object());
    }

    @Test
    public void adapt() {
        PredicatesTest.assertAccepts(Predicates.adapt(Predicates.alwaysTrue()), new Object());
        PredicatesTest.assertToString(Predicates.adapt(Predicates.alwaysTrue()));
    }

    @Test
    public void staticOr() {
        PredicatesTest.assertAccepts(Predicates.or(Predicates.alwaysTrue(), Predicates.alwaysFalse()), new Object());
        PredicatesTest.assertRejects(Predicates.or(Predicates.alwaysFalse(), Predicates.alwaysFalse()), new Object());
        PredicatesTest.assertAccepts(Predicates.or(Predicates.alwaysTrue(), Predicates.alwaysTrue()), new Object());
        PredicatesTest.assertToString(Predicates.or(Predicates.alwaysTrue(), Predicates.alwaysTrue()));
    }

    @Test
    public void instanceOr() {
        PredicatesTest.assertAccepts(Predicates.alwaysTrue().or(Predicates.alwaysFalse()), new Object());
        PredicatesTest.assertRejects(Predicates.alwaysFalse().or(Predicates.alwaysFalse()), new Object());
        PredicatesTest.assertAccepts(Predicates.alwaysTrue().or(Predicates.alwaysTrue()), new Object());
        PredicatesTest.assertToString(Predicates.alwaysTrue().or(Predicates.alwaysTrue()));
    }

    @Test
    public void collectionOr() {
        MutableList<Predicate<Object>> predicates = Lists.fixedSize.of(Predicates.alwaysTrue(), Predicates.alwaysFalse(), null);
        PredicatesTest.assertAccepts(Predicates.or(predicates), new Object());
        MutableList<Predicate<Object>> falsePredicates = Lists.fixedSize.of(Predicates.alwaysFalse(), Predicates.alwaysFalse());
        PredicatesTest.assertRejects(Predicates.or(falsePredicates), new Object());
        MutableList<Predicate<Object>> truePredicates = Lists.fixedSize.of(Predicates.alwaysTrue(), Predicates.alwaysTrue());
        PredicatesTest.assertAccepts(Predicates.or(truePredicates), new Object());
        PredicatesTest.assertToString(Predicates.or(truePredicates));
    }

    @Test
    public void varArgOr() {
        PredicatesTest.assertAccepts(Predicates.or(Predicates.alwaysTrue(), Predicates.alwaysFalse(), null), new Object());
        PredicatesTest.assertRejects(Predicates.or(Predicates.alwaysFalse(), Predicates.alwaysFalse(), Predicates.alwaysFalse()), new Object());
        PredicatesTest.assertAccepts(Predicates.or(Predicates.alwaysTrue(), Predicates.alwaysTrue(), Predicates.alwaysTrue()), new Object());
        PredicatesTest.assertToString(Predicates.or(Predicates.alwaysTrue(), Predicates.alwaysTrue(), Predicates.alwaysTrue()));
    }

    @Test
    public void staticAnd() {
        PredicatesTest.assertAccepts(Predicates.and(Predicates.alwaysTrue(), Predicates.alwaysTrue()), new Object());
        PredicatesTest.assertRejects(Predicates.and(Predicates.alwaysTrue(), Predicates.alwaysFalse()), new Object());
        PredicatesTest.assertRejects(Predicates.and(Predicates.alwaysFalse(), Predicates.alwaysFalse()), new Object());
        PredicatesTest.assertToString(Predicates.and(Predicates.alwaysTrue(), Predicates.alwaysTrue()));
    }

    @Test
    public void instanceAnd() {
        PredicatesTest.assertAccepts(Predicates.alwaysTrue().and(Predicates.alwaysTrue()), new Object());
        PredicatesTest.assertRejects(Predicates.alwaysTrue().and(Predicates.alwaysFalse()), new Object());
        PredicatesTest.assertRejects(Predicates.alwaysFalse().and(Predicates.alwaysFalse()), new Object());
        PredicatesTest.assertToString(Predicates.alwaysTrue().and(Predicates.alwaysTrue()));
    }

    @Test
    public void collectionAnd() {
        MutableList<Predicate<Object>> predicates = Lists.fixedSize.of(Predicates.alwaysTrue(), Predicates.alwaysTrue());
        PredicatesTest.assertAccepts(Predicates.and(predicates), new Object());
        MutableList<Predicate<Object>> tfPredicates = Lists.fixedSize.of(Predicates.alwaysTrue(), Predicates.alwaysFalse());
        PredicatesTest.assertRejects(Predicates.and(tfPredicates), new Object());
        MutableList<Predicate<Object>> falsePredicates = Lists.fixedSize.of(Predicates.alwaysFalse(), Predicates.alwaysFalse());
        PredicatesTest.assertRejects(Predicates.and(falsePredicates), new Object());
        PredicatesTest.assertToString(Predicates.and(predicates));
    }

    @Test
    public void varArgAnd() {
        PredicatesTest.assertAccepts(Predicates.and(Predicates.alwaysTrue(), Predicates.alwaysTrue()), new Object());
        PredicatesTest.assertRejects(Predicates.and(Predicates.alwaysTrue(), Predicates.alwaysTrue(), Predicates.alwaysFalse()), new Object());
        PredicatesTest.assertRejects(Predicates.and(Predicates.alwaysFalse(), Predicates.alwaysFalse(), Predicates.alwaysFalse()), new Object());
        PredicatesTest.assertToString(Predicates.and(Predicates.alwaysTrue(), Predicates.alwaysTrue(), null));
    }

    @Test
    public void equal() {
        PredicatesTest.assertAccepts(Integer.valueOf(1)::equals, 1);
        PredicatesTest.assertRejects(Integer.valueOf(1)::equals, 2);
        PredicatesTest.assertAccepts("test"::equals, "test");
        PredicatesTest.assertRejects("test"::equals, "production");
    }

    @Test
    public void notEqual() {
        PredicatesTest.assertRejects(Predicates.notEqual(1), 1);
        PredicatesTest.assertAccepts(Predicates.notEqual(1), 2);
        PredicatesTest.assertRejects(Predicates.notEqual("test"), "test");
        PredicatesTest.assertAccepts(Predicates.notEqual("test"), "production");
        PredicatesTest.assertAccepts(Predicates.notEqual(null), "test");
        PredicatesTest.assertToString(Predicates.notEqual(1));
    }

    @Test
    public void not() {
        Predicate<Object> notTrue = Predicates.not(Predicates.alwaysTrue());
        PredicatesTest.assertRejects(notTrue, new Object());
        PredicatesTest.assertToString(notTrue);
        Predicate<Object> notFalse = Predicates.not(Predicates.alwaysFalse());
        PredicatesTest.assertAccepts(notFalse, new Object());
        PredicatesTest.assertToString(notFalse);
    }

    @Test
    public void testNull() {
        PredicatesTest.assertAccepts(Predicates.isNull(), (Object) null);
        PredicatesTest.assertRejects(Predicates.isNull(), new Object());
        PredicatesTest.assertToString(Predicates.isNull());
    }

    @Test
    public void notNull() {
        PredicatesTest.assertAccepts(Predicates.notNull(), new Object());
        PredicatesTest.assertRejects(Predicates.notNull(), (Object) null);
        PredicatesTest.assertToString(Predicates.notNull());
    }

    @Test
    public void neither() {
        PredicatesTest.assertRejects(Predicates.neither(Predicates.alwaysTrue(), Predicates.alwaysTrue()), new Object());
        PredicatesTest.assertRejects(Predicates.neither(Predicates.alwaysTrue(), Predicates.alwaysFalse()), new Object());
        PredicatesTest.assertAccepts(Predicates.neither(Predicates.alwaysFalse(), Predicates.alwaysFalse()), new Object());
        PredicatesTest.assertToString(Predicates.neither(Predicates.alwaysFalse(), Predicates.alwaysFalse()));
    }

    @Test
    public void collectionNoneOf() {
        MutableList<Predicate<Object>> trueNorTrue = Lists.fixedSize.of(Predicates.alwaysTrue(), Predicates.alwaysTrue(), Predicates.alwaysTrue());
        PredicatesTest.assertRejects(Predicates.noneOf(trueNorTrue), new Object());
        MutableList<Predicate<Object>> trueNorFalse = Lists.fixedSize.of(Predicates.alwaysTrue(), Predicates.alwaysTrue(), Predicates.alwaysFalse());
        PredicatesTest.assertRejects(Predicates.noneOf(trueNorFalse), new Object());
        MutableList<Predicate<Object>> falseNorFalse = Lists.fixedSize.of(Predicates.alwaysFalse(), Predicates.alwaysFalse(), Predicates.alwaysFalse());
        PredicatesTest.assertAccepts(Predicates.noneOf(falseNorFalse), new Object());
        PredicatesTest.assertToString(Predicates.noneOf(falseNorFalse));
    }

    @Test
    public void noneOf() {
        PredicatesTest.assertRejects(Predicates.noneOf(Predicates.alwaysTrue(), Predicates.alwaysTrue(), Predicates.alwaysTrue()), new Object());
        PredicatesTest.assertRejects(Predicates.noneOf(Predicates.alwaysTrue(), Predicates.alwaysTrue(), Predicates.alwaysFalse()), new Object());
        PredicatesTest.assertAccepts(Predicates.noneOf(Predicates.alwaysFalse(), Predicates.alwaysFalse(), Predicates.alwaysFalse()), new Object());
        PredicatesTest.assertToString(Predicates.noneOf(Predicates.alwaysFalse(), Predicates.alwaysFalse(), Predicates.alwaysFalse()));
    }

    @Test
    public void sameAs() {
        Object object = new Object();
        Predicate<Object> sameAs = Predicates.sameAs(object);
        PredicatesTest.assertAccepts(sameAs, object);
        PredicatesTest.assertRejects(sameAs, new Object());
        PredicatesTest.assertToString(sameAs);
    }

    @Test
    public void notSameAs() {
        Object object = new Object();
        Predicate<Object> notSameAs = Predicates.notSameAs(object);
        PredicatesTest.assertRejects(notSameAs, object);
        PredicatesTest.assertAccepts(notSameAs, new Object());
        PredicatesTest.assertToString(notSameAs);
    }

    @Test
    public void instanceOf() {
        Assert.assertTrue(Predicates.instanceOf(Integer.class).accept(1));
        Assert.assertFalse(Predicates.instanceOf(Integer.class).accept(1.0));
        PredicatesTest.assertToString(Predicates.instanceOf(Integer.class));
    }

    @Test
    public void assignableFrom() {
        PredicatesTest.assertAccepts(Predicates.assignableFrom(Number.class), 1);
        PredicatesTest.assertAccepts(Predicates.assignableFrom(Integer.class), 1);
        PredicatesTest.assertRejects(Predicates.assignableFrom(List.class), 1);
        PredicatesTest.assertToString(Predicates.assignableFrom(Number.class));
    }

    @Test
    public void notInstanceOf() {
        Assert.assertFalse(Predicates.notInstanceOf(Integer.class).accept(1));
        Assert.assertTrue(Predicates.notInstanceOf(Integer.class).accept(1.0));
        PredicatesTest.assertToString(Predicates.notInstanceOf(Integer.class));
    }

    @Test
    public void ifTrue() {
        PredicatesTest.assertIf(Predicates.ifTrue(List::isEmpty), true);
    }

    @Test
    public void ifFalse() {
        PredicatesTest.assertIf(Predicates.ifFalse(List::isEmpty), false);
    }

    private static void assertIf(Predicate<List<Object>> predicate, boolean bool) {
        Assert.assertEquals(bool, predicate.accept(Lists.fixedSize.of()));
        Assert.assertEquals(!bool, predicate.accept(FastList.newListWith((Object) null)));
        PredicatesTest.assertToString(predicate);
    }

    @Test
    public void ifTrueWithClassAndFunctionName() {
        Twin<Boolean> target = Tuples.twin(true, false);
        PredicatesTest.assertAccepts(Predicates.ifTrue(Functions.firstOfPair()), target);
        PredicatesTest.assertRejects(Predicates.ifTrue(Functions.secondOfPair()), target);
    }

    @Test
    public void ifFalseWithClassAndFunctionName() {
        Twin<Boolean> target = Tuples.twin(true, false);
        PredicatesTest.assertRejects(Predicates.ifFalse(Functions.firstOfPair()), target);
        PredicatesTest.assertAccepts(Predicates.ifFalse(Functions.secondOfPair()), target);
    }

    @Test
    public void attributeEqual() {
        Predicate<String> predicate = Predicates.attributeEqual(String::valueOf, "1");
        PredicatesTest.assertAccepts(predicate, "1");
        PredicatesTest.assertRejects(predicate, "0");
        PredicatesTest.assertToString(predicate);
    }

    @Test
    public void attributeNotEqual() {
        Predicate<String> predicate = Predicates.attributeNotEqual(String::valueOf, "1");
        PredicatesTest.assertAccepts(predicate, "0");
        PredicatesTest.assertRejects(predicate, "1");
        PredicatesTest.assertToString(predicate);
    }

    @Test
    public void attributeLessThan() {
        Predicate<String> predicate = Predicates.attributeLessThan(String::valueOf, "1");
        PredicatesTest.assertRejects(predicate, "1");
        PredicatesTest.assertAccepts(predicate, "0");
        PredicatesTest.assertToString(predicate);
    }

    @Test
    public void attributeGreaterThan() {
        Predicate<String> predicate = Predicates.attributeGreaterThan(String::valueOf, "0");
        PredicatesTest.assertAccepts(predicate, "1");
        PredicatesTest.assertRejects(predicate, "0");
        PredicatesTest.assertToString(predicate);
    }

    @Test
    public void attributeGreaterThanOrEqualTo() {
        Predicate<String> predicate = Predicates.attributeGreaterThanOrEqualTo(String::valueOf, "1");
        PredicatesTest.assertAccepts(predicate, "1", "2");
        PredicatesTest.assertRejects(predicate, "0");
        PredicatesTest.assertToString(predicate);
    }

    @Test
    public void attributeLessThanOrEqualTo() {
        Predicate<String> predicate = Predicates.attributeLessThanOrEqualTo(String::valueOf, "1");
        PredicatesTest.assertAccepts(predicate, "1", "0");
        PredicatesTest.assertRejects(predicate, "2");
        PredicatesTest.assertToString(predicate);
    }

    @Test
    public void attributeAnySatisfy() {
        Function<Address, String> stateAbbreviation = address -> address.getState().getAbbreviation();
        Predicates<Address> inArizona = Predicates.attributeEqual(stateAbbreviation, "AZ");
        MutableCollection<Employee> azResidents = this.employees.select(Predicates.attributeAnySatisfy(employee -> employee.addresses, inArizona));
        Assert.assertEquals(FastList.newListWith(this.alice, this.charlie), azResidents);
        Predicates<Address> inAlaska = Predicates.attributeEqual(stateAbbreviation, "AK");
        MutableCollection<Employee> akResidents = this.employees.select(Predicates.attributeAnySatisfy(employee -> employee.addresses, inAlaska));
        Assert.assertEquals(FastList.newListWith(this.bob, this.diane), akResidents);
        PredicatesTest.assertToString(inArizona);
    }

    @Test
    public void attributeAllSatisfy() {
        MutableCollection<Employee> noExtendedDependents = this.employees.select(Predicates.attributeAllSatisfy(Employee.TO_DEPENEDENTS, Dependent.IS_IMMEDIATE));
        Assert.assertEquals(FastList.newListWith(this.bob, this.charlie), noExtendedDependents);
    }

    @Test
    public void attributeNoneSatisfy() {
        Function<Address, String> stateAbbreviation = address -> address.getState().getAbbreviation();
        Predicates<Address> inAlabama = Predicates.attributeEqual(stateAbbreviation, "AL");
        MutableCollection<Employee> notAlResidents = this.employees.select(Predicates.attributeNoneSatisfy(employee -> employee.addresses, inAlabama));
        Assert.assertEquals(FastList.newListWith(this.alice, this.bob, this.charlie, this.diane), notAlResidents);
    }

    @Test
    public void allSatisfy() {
        Predicate<Iterable<Object>> allIntegers = Predicates.allSatisfy(Predicates.instanceOf(Integer.class));
        PredicatesTest.assertAccepts(allIntegers, FastList.newListWith(1, 2, 3));
        PredicatesTest.assertRejects(allIntegers, FastList.newListWith(Boolean.TRUE, Boolean.FALSE));
    }

    @Test
    public void anySatisfy() {
        Predicates<Iterable<Object>> anyIntegers = Predicates.anySatisfy(Predicates.instanceOf(Integer.class));
        PredicatesTest.assertAccepts(anyIntegers, FastList.newListWith(1, 2, 3));
        PredicatesTest.assertRejects(anyIntegers, FastList.newListWith(Boolean.TRUE, Boolean.FALSE));
    }

    @Test
    public void noneSatisfy() {
        Predicates<Iterable<Object>> anyIntegers = Predicates.noneSatisfy(Predicates.instanceOf(Integer.class));
        PredicatesTest.assertRejects(anyIntegers, FastList.newListWith(1, 2, 3));
        PredicatesTest.assertAccepts(anyIntegers, FastList.newListWith(Boolean.TRUE, Boolean.FALSE));
    }

    @Test
    public void attributeIsNull() {
        PredicatesTest.assertAccepts(Predicates.attributeIsNull(Functions.getPassThru()), (Object) null);
        PredicatesTest.assertRejects(Predicates.attributeIsNull(Functions.getPassThru()), new Object());
    }

    @Test
    public void attributeIsNullWithFunctionName() {
        Twin<Integer> target = Tuples.twin(null, 1);
        PredicatesTest.assertAccepts(Predicates.attributeIsNull(Functions.firstOfPair()), target);
        PredicatesTest.assertRejects(Predicates.attributeIsNull(Functions.secondOfPair()), target);
    }

    @Test
    public void attributeNotNullWithFunction() {
        PredicatesTest.assertRejects(Predicates.attributeNotNull(Functions.getPassThru()), (Object) null);
        PredicatesTest.assertAccepts(Predicates.attributeNotNull(Functions.getPassThru()), new Object());
    }

    @Test
    public void in_SetIterable() {
        Predicate<Object> predicate = Predicates.in(Sets.immutable.with(1, 2, 3));
        PredicatesTest.assertAccepts(predicate, 1, 2, 3);
        PredicatesTest.assertRejects(predicate, 0, 4, null);
    }

    @Test
    public void notIn_SetIterable() {
        Predicate<Object> predicate = Predicates.notIn(Sets.immutable.with(1, 2, 3));
        PredicatesTest.assertAccepts(predicate, 0, 4, null);
        PredicatesTest.assertRejects(predicate, 1, 2, 3);
    }

    @Test
    public void in_Set() {
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3));
        Predicate<Object> predicate = Predicates.in(set);
        PredicatesTest.assertAccepts(predicate, 1, 2, 3);
        PredicatesTest.assertRejects(predicate, 0, 4, null);
        PredicatesTest.assertToString(predicate);
        Assert.assertTrue(predicate.toString().contains(set.toString()));
    }

    @Test
    public void notIn_Set() {
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3));
        Predicate<Object> predicate = Predicates.notIn(set);
        PredicatesTest.assertAccepts(predicate, 0, 4, null);
        PredicatesTest.assertRejects(predicate, 1, 2, 3);
        PredicatesTest.assertToString(predicate);
        Assert.assertTrue(predicate.toString().contains(set.toString()));
    }

    @Test
    public void in_Collection() {
        Predicate<Object> predicate = Predicates.in(Lists.mutable.with(1, 2, 3));
        PredicatesTest.assertAccepts(predicate, 1, 2, 3);
        PredicatesTest.assertRejects(predicate, 0, 4, null);
    }

    @Test
    public void notIn_Collection() {
        Predicate<Object> predicate = Predicates.notIn(Lists.mutable.with(1, 2, 3));
        PredicatesTest.assertAccepts(predicate, 0, 4, null);
        PredicatesTest.assertRejects(predicate, 1, 2, 3);
    }

    @Test
    public void in() {
        MutableList<String> list1 = Lists.fixedSize.of("1", "3");
        Predicate<Object> inList = Predicates.in(list1);
        PredicatesTest.assertAccepts(inList, "1");
        PredicatesTest.assertRejects(inList, "2");
        PredicatesTest.assertAccepts(Predicates.in(list1.toArray()), "1");
        PredicatesTest.assertRejects(Predicates.in(list1.toArray()), "2");
        Object[] array = Lists.mutable.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10").toArray();
        Predicates<Object> predicate = Predicates.in(array);
        PredicatesTest.assertAccepts(predicate, "1");
        PredicatesTest.assertRejects(predicate, "0");
        Assert.assertEquals(FastList.newListWith("1"), ListIterate.select(Lists.fixedSize.of("1", "2"), inList));
        PredicatesTest.assertToString(inList);
        Assert.assertTrue(inList.toString().contains(list1.toString()));
        PredicatesTest.assertToString(predicate);
    }

    @Test
    public void inInterval() {
        PredicatesTest.assertAccepts(Predicates.in(Interval.oneTo(3)), 2);
        PredicatesTest.assertToString(Predicates.in(Interval.oneTo(3)));
    }

    @Test
    public void attributeIn() {
        MutableList<String> upperList = Lists.fixedSize.of("A", "B");
        Predicate<String> in = Predicates.attributeIn(StringFunctions.toUpperCase(), upperList);
        PredicatesTest.assertAccepts(in, "a");
        PredicatesTest.assertRejects(in, "c");
        Assert.assertEquals(FastList.newListWith("a"), ListIterate.select(Lists.fixedSize.of("a", "c"), in));
        PredicatesTest.assertToString(in);
    }

    @Test
    public void notIn() {
        MutableList<String> odds = Lists.fixedSize.of("1", "3");
        Predicate<Object> predicate1 = Predicates.notIn(odds);
        PredicatesTest.assertAccepts(predicate1, "2");
        PredicatesTest.assertRejects(predicate1, "1");
        PredicatesTest.assertAccepts(Predicates.notIn(odds.toArray()), "2");
        PredicatesTest.assertRejects(Predicates.notIn(odds.toArray()), "1");
        MutableList<String> list = Lists.mutable.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        PredicatesTest.assertAccepts(Predicates.notIn(list), "0");
        PredicatesTest.assertRejects(Predicates.notIn(list), "1");
        Predicates<Object> predicate2 = Predicates.notIn(list.toArray());
        PredicatesTest.assertAccepts(predicate2, "0");
        PredicatesTest.assertRejects(predicate2, "1");
        Assert.assertEquals(FastList.newListWith("2"), ListIterate.select(Lists.fixedSize.of("1", "2"), predicate1));
        PredicatesTest.assertToString(predicate1);
        PredicatesTest.assertToString(predicate2);
        Assert.assertTrue(predicate1.toString().contains(odds.toString()));
    }

    @Test
    public void notInInterval() {
        PredicatesTest.assertAccepts(Predicates.notIn(Interval.oneTo(3)), 4);
        PredicatesTest.assertToString(Predicates.notIn(Interval.oneTo(3)));
    }

    @Test
    public void attributeNotIn() {
        MutableList<String> lowerList = Lists.fixedSize.of("a", "b");
        Predicate<String> out = Predicates.attributeNotIn(StringFunctions.toLowerCase(), lowerList);
        PredicatesTest.assertAccepts(out, "C");
        PredicatesTest.assertRejects(out, "A");
        Assert.assertEquals(FastList.newListWith("A"), ListIterate.reject(Lists.fixedSize.of("A", "C"), out));
        PredicatesTest.assertToString(out);
    }

    @Test
    public void lessThan() {
        Predicate<Integer> lessThan = Predicates.lessThan(0);
        PredicatesTest.assertAccepts(lessThan, -1);
        PredicatesTest.assertRejects(lessThan, 0, 1);
        PredicatesTest.assertToString(lessThan);
    }

    @Test
    public void attributeBetweenExclusive() {
        Predicate<Pair<Integer, ?>> predicate = Predicates.attributeBetweenExclusive(Functions.firstOfPair(), 9, 11);
        PredicatesTest.assertAccepts(predicate, Tuples.twin(10, 0));
        PredicatesTest.assertRejects(predicate, Tuples.twin(8, 0), Tuples.twin(9, 0), Tuples.twin(11, 0), Tuples.twin(12, 0));
    }

    @Test
    public void attributeBetweenInclusiveFrom() {
        Predicate<Pair<Integer, ?>> predicate = Predicates.attributeBetweenInclusiveFrom(Functions.firstOfPair(), 9, 11);
        PredicatesTest.assertAccepts(predicate, Tuples.twin(9, 0), Tuples.twin(10, 0));
        PredicatesTest.assertRejects(predicate, Tuples.twin(8, 0), Tuples.twin(11, 0), Tuples.twin(12, 0));
    }

    @Test
    public void attributeBetweenInclusiveTo() {
        Predicate<Pair<Integer, ?>> predicate = Predicates.attributeBetweenInclusiveTo(Functions.firstOfPair(), 9, 11);
        PredicatesTest.assertAccepts(predicate, Tuples.twin(10, 0), Tuples.twin(11, 0));
        PredicatesTest.assertRejects(predicate, Tuples.twin(8, 0), Tuples.twin(9, 0), Tuples.twin(12, 0));
    }

    @Test
    public void attributeBetweenInclusive() {
        Predicate<Pair<Integer, ?>> predicate = Predicates.attributeBetweenInclusive(Functions.firstOfPair(), 9, 11);
        PredicatesTest.assertAccepts(predicate, Tuples.twin(9, 0), Tuples.twin(10, 0), Tuples.twin(11, 0));
        PredicatesTest.assertRejects(predicate, Tuples.twin(8, 0), Tuples.twin(12, 0));
    }

    @Test
    public void lessThanOrEqualTo() {
        PredicatesTest.assertAccepts(Predicates.lessThanOrEqualTo(0), 0, -1);
        PredicatesTest.assertRejects(Predicates.lessThanOrEqualTo(0), 1);
        PredicatesTest.assertToString(Predicates.lessThanOrEqualTo(0));
    }

    @Test
    public void greaterThan() {
        PredicatesTest.assertAccepts(Predicates.greaterThan(0), 1);
        PredicatesTest.assertRejects(Predicates.greaterThan(0), 0, -1);
        PredicatesTest.assertToString(Predicates.greaterThan(0));
    }

    @Test
    public void greaterThanOrEqualTo() {
        PredicatesTest.assertAccepts(Predicates.greaterThanOrEqualTo(0), 0, 1);
        PredicatesTest.assertRejects(Predicates.greaterThanOrEqualTo(0), -1);
        PredicatesTest.assertToString(Predicates.greaterThanOrEqualTo(0));
    }

    private static void assertToString(Predicate<?> predicate) {
        String toString = predicate.toString();
        Assert.assertTrue(toString.startsWith("Predicates"));
    }

    private static <T> void assertAccepts(Predicate<? super T> predicate, T... elements) {
        for (T element : elements) {
            Assert.assertTrue(predicate.accept(element));
        }
    }

    private static <T> void assertRejects(Predicate<? super T> predicate, T... elements) {
        for (T element : elements) {
            Assert.assertFalse(predicate.accept(element));
        }
    }

    @Test
    public void betweenInclusiveNumber() {
        PredicatesTest.assertBetweenInclusive(Predicates.betweenInclusive(1, 3));
        PredicatesTest.assertBetweenInclusive(Predicates.attributeBetweenInclusive(Functions.getIntegerPassThru(), 1, 3));
    }

    private static void assertBetweenInclusive(Predicate<Integer> oneToThree) {
        PredicatesTest.assertRejects(oneToThree, 0, 4);
        PredicatesTest.assertAccepts(oneToThree, 1, 2, 3);
    }

    @Test
    public void betweenInclusiveString() {
        PredicatesTest.assertStringBetweenInclusive(Predicates.betweenInclusive("1", "3"));
        PredicatesTest.assertStringBetweenInclusive(Predicates.attributeBetweenInclusive(String::valueOf, "1", "3"));
    }

    private static void assertStringBetweenInclusive(Predicate<String> oneToThree) {
        PredicatesTest.assertRejects(oneToThree, "0", "4");
        PredicatesTest.assertAccepts(oneToThree, "1", "2", "3");
    }

    @Test
    public void betweenInclusiveFromNumber() {
        PredicatesTest.assertBetweenInclusiveFrom(Predicates.betweenInclusiveFrom(1, 3));
        PredicatesTest.assertBetweenInclusiveFrom(Predicates.attributeBetweenInclusiveFrom(Functions.getIntegerPassThru(), 1, 3));
    }

    private static void assertBetweenInclusiveFrom(Predicate<Integer> oneToThree) {
        PredicatesTest.assertRejects(oneToThree, 0, 3, 4);
        PredicatesTest.assertAccepts(oneToThree, 1, 2);
    }

    @Test
    public void betweenInclusiveFromString() {
        PredicatesTest.assertStringBetweenInclusiveFrom(Predicates.betweenInclusiveFrom("1", "3"));
        PredicatesTest.assertStringBetweenInclusiveFrom(Predicates.attributeBetweenInclusiveFrom(String::valueOf, "1", "3"));
    }

    private static void assertStringBetweenInclusiveFrom(Predicate<String> oneToThree) {
        PredicatesTest.assertRejects(oneToThree, "0", "3", "4");
        PredicatesTest.assertAccepts(oneToThree, "1", "2");
    }

    @Test
    public void betweenInclusiveToNumber() {
        PredicatesTest.assertBetweenInclusiveTo(Predicates.betweenInclusiveTo(1, 3));
        PredicatesTest.assertBetweenInclusiveTo(Predicates.attributeBetweenInclusiveTo(Functions.getIntegerPassThru(), 1, 3));
    }

    private static void assertBetweenInclusiveTo(Predicate<Integer> oneToThree) {
        PredicatesTest.assertRejects(oneToThree, 0, 1, 4);
        PredicatesTest.assertAccepts(oneToThree, 2, 3);
    }

    @Test
    public void betweenInclusiveToString() {
        PredicatesTest.assertStringBetweenInclusiveTo(Predicates.betweenInclusiveTo("1", "3"));
        PredicatesTest.assertStringBetweenInclusiveTo(Predicates.attributeBetweenInclusiveTo(String::valueOf, "1", "3"));
    }

    private static void assertStringBetweenInclusiveTo(Predicate<String> oneToThree) {
        PredicatesTest.assertRejects(oneToThree, "0", "1", "4");
        PredicatesTest.assertAccepts(oneToThree, "2", "3");
    }

    @Test
    public void betweenExclusiveNumber() {
        PredicatesTest.assertBetweenExclusive(Predicates.betweenExclusive(1, 3));
        PredicatesTest.assertBetweenExclusive(Predicates.attributeBetweenExclusive(Functions.getIntegerPassThru(), 1, 3));
    }

    private static void assertBetweenExclusive(Predicate<Integer> oneToThree) {
        PredicatesTest.assertRejects(oneToThree, 0, 1, 3, 4);
        PredicatesTest.assertAccepts(oneToThree, 2);
    }

    @Test
    public void betweenExclusiveString() {
        PredicatesTest.assertStringBetweenExclusive(Predicates.betweenExclusive("1", "3"));
        PredicatesTest.assertStringBetweenExclusive(Predicates.attributeBetweenExclusive(String::valueOf, "1", "3"));
    }

    private static void assertStringBetweenExclusive(Predicate<String> oneToThree) {
        PredicatesTest.assertRejects(oneToThree, "0", "1", "3", "4");
        PredicatesTest.assertAccepts(oneToThree, "2");
    }

    @Test
    public void attributeNotNull() {
        Twin<String> testCandidate = Tuples.twin("Hello", null);
        PredicatesTest.assertAccepts(Predicates.attributeNotNull(Functions.firstOfPair()), testCandidate);
        PredicatesTest.assertRejects(Predicates.attributeNotNull(Functions.secondOfPair()), testCandidate);
        PredicatesTest.assertToString(Predicates.attributeNotNull(Functions.<String>firstOfPair()));
    }

    @Test
    public void subClass() {
        Predicates<Class<?>> subClass = Predicates.subClass(Number.class);
        Assert.assertTrue(subClass.accept(Integer.class));
        Assert.assertFalse(subClass.accept(Object.class));
        Assert.assertTrue(subClass.accept(Number.class));
    }

    @Test
    public void superClass() {
        Predicates<Class<?>> superClass = Predicates.superClass(Number.class);
        Assert.assertFalse(superClass.accept(Integer.class));
        Assert.assertTrue(superClass.accept(Object.class));
        Assert.assertTrue(superClass.accept(Number.class));
    }

    public static final class Employee {

        public static final Function<Employee, MutableList<Address>> TO_ADDRESSES = employee -> employee.addresses;

        public static final Function<Employee, MutableList<Dependent>> TO_DEPENEDENTS = employee -> employee.dependents;

        private final MutableList<Address> addresses;

        private final MutableList<Dependent> dependents = Lists.mutable.of();

        private Employee(Address addr) {
            this.addresses = FastList.newListWith(addr);
        }

        private void addDependent(Dependent dependent) {
            this.dependents.add(dependent);
        }
    }

    public static final class Address {

        private final State state;

        private Address(State state) {
            this.state = state;
        }

        public State getState() {
            return this.state;
        }
    }

    public enum State {

        ARIZONA("AZ"), ALASKA("AK"), ALABAMA("AL");

        private final String abbreviation;

        State(String abbreviation) {
            this.abbreviation = abbreviation;
        }

        public String getAbbreviation() {
            return this.abbreviation;
        }
    }

    public static final class Dependent {

        public static final Predicate<Dependent> IS_IMMEDIATE = Dependent::isImmediate;

        private final DependentType type;

        private Dependent(DependentType type) {
            this.type = type;
        }

        public boolean isImmediate() {
            return this.type.isImmediate();
        }
    }

    public enum DependentType {

        SPOUSE {

            @Override
            public boolean isImmediate() {
                return true;
            }
        }
        , CHILD {

            @Override
            public boolean isImmediate() {
                return true;
            }
        }
        , PARENT {

            @Override
            public boolean isImmediate() {
                return false;
            }
        }
        , GRANDPARENT {

            @Override
            public boolean isImmediate() {
                return false;
            }
        }
        ;

        public abstract boolean isImmediate();
    }

    private static class MyRuntimeException extends RuntimeException {

        MyRuntimeException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private PredicatesTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_throwing() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.throwing);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_throwingNoException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.throwingNoException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_throwingWithUserSpecifiedException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.throwingWithUserSpecifiedException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_bind() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.bind);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_alwaysTrue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.alwaysTrue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_alwaysFalse() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.alwaysFalse);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_instanceNot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.instanceNot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_synchronizedEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.synchronizedEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_adapt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.adapt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_staticOr() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.staticOr);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_instanceOr() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.instanceOr);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectionOr() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectionOr);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_varArgOr() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.varArgOr);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_staticAnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.staticAnd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_instanceAnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.instanceAnd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectionAnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectionAnd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_varArgAnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.varArgAnd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equal() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equal);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEqual() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEqual);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_not() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.not);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNull);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notNull);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_neither() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.neither);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectionNoneOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectionNoneOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sameAs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sameAs);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notSameAs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notSameAs);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_instanceOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.instanceOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_assignableFrom() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.assignableFrom);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notInstanceOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notInstanceOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ifTrue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ifTrue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ifFalse() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ifFalse);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ifTrueWithClassAndFunctionName() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ifTrueWithClassAndFunctionName);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ifFalseWithClassAndFunctionName() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ifFalseWithClassAndFunctionName);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_attributeEqual() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.attributeEqual);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_attributeNotEqual() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.attributeNotEqual);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_attributeLessThan() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.attributeLessThan);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_attributeGreaterThan() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.attributeGreaterThan);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_attributeGreaterThanOrEqualTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.attributeGreaterThanOrEqualTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_attributeLessThanOrEqualTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.attributeLessThanOrEqualTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_attributeAnySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.attributeAnySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_attributeAllSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.attributeAllSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_attributeNoneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.attributeNoneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_attributeIsNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.attributeIsNull);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_attributeIsNullWithFunctionName() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.attributeIsNullWithFunctionName);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_attributeNotNullWithFunction() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.attributeNotNullWithFunction);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_in_SetIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.in_SetIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notIn_SetIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notIn_SetIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_in_Set() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.in_Set);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notIn_Set() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notIn_Set);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_in_Collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.in_Collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notIn_Collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notIn_Collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_in() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.in);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_inInterval() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.inInterval);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_attributeIn() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.attributeIn);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notIn() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notIn);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notInInterval() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notInInterval);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_attributeNotIn() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.attributeNotIn);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lessThan() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lessThan);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_attributeBetweenExclusive() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.attributeBetweenExclusive);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_attributeBetweenInclusiveFrom() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.attributeBetweenInclusiveFrom);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_attributeBetweenInclusiveTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.attributeBetweenInclusiveTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_attributeBetweenInclusive() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.attributeBetweenInclusive);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lessThanOrEqualTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lessThanOrEqualTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_greaterThan() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.greaterThan);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_greaterThanOrEqualTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.greaterThanOrEqualTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_betweenInclusiveNumber() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.betweenInclusiveNumber);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_betweenInclusiveString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.betweenInclusiveString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_betweenInclusiveFromNumber() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.betweenInclusiveFromNumber);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_betweenInclusiveFromString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.betweenInclusiveFromString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_betweenInclusiveToNumber() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.betweenInclusiveToNumber);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_betweenInclusiveToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.betweenInclusiveToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_betweenExclusiveNumber() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.betweenExclusiveNumber);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_betweenExclusiveString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.betweenExclusiveString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_attributeNotNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.attributeNotNull);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subClass() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subClass);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_superClass() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.superClass);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> payload) throws java.lang.Throwable {
            this.instance = new PredicatesTest();
            this.instance.setUp();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> throwing;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> throwingNoException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> throwingWithUserSpecifiedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> bind;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> alwaysTrue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> alwaysFalse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> instanceNot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> synchronizedEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> adapt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> staticOr;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> instanceOr;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> collectionOr;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> varArgOr;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> staticAnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> instanceAnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> collectionAnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> varArgAnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> equal;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> notEqual;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> not;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> testNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> notNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> neither;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> collectionNoneOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> noneOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> sameAs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> notSameAs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> instanceOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> assignableFrom;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> notInstanceOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> ifTrue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> ifFalse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> ifTrueWithClassAndFunctionName;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> ifFalseWithClassAndFunctionName;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> attributeEqual;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> attributeNotEqual;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> attributeLessThan;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> attributeGreaterThan;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> attributeGreaterThanOrEqualTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> attributeLessThanOrEqualTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> attributeAnySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> attributeAllSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> attributeNoneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> attributeIsNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> attributeIsNullWithFunctionName;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> attributeNotNullWithFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> in_SetIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> notIn_SetIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> in_Set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> notIn_Set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> in_Collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> notIn_Collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> in;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> inInterval;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> attributeIn;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> notIn;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> notInInterval;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> attributeNotIn;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> lessThan;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> attributeBetweenExclusive;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> attributeBetweenInclusiveFrom;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> attributeBetweenInclusiveTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> attributeBetweenInclusive;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> lessThanOrEqualTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> greaterThan;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> greaterThanOrEqualTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> betweenInclusiveNumber;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> betweenInclusiveString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> betweenInclusiveFromNumber;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> betweenInclusiveFromString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> betweenInclusiveToNumber;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> betweenInclusiveToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> betweenExclusiveNumber;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> betweenExclusiveString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> attributeNotNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> subClass;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PredicatesTest> superClass;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.throwing = PredicatesTest::throwing;
            this.payloads.throwingNoException = PredicatesTest::throwingNoException;
            this.payloads.throwingWithUserSpecifiedException = PredicatesTest::throwingWithUserSpecifiedException;
            this.payloads.bind = PredicatesTest::bind;
            this.payloads.alwaysTrue = PredicatesTest::alwaysTrue;
            this.payloads.alwaysFalse = PredicatesTest::alwaysFalse;
            this.payloads.instanceNot = PredicatesTest::instanceNot;
            this.payloads.synchronizedEach = PredicatesTest::synchronizedEach;
            this.payloads.adapt = PredicatesTest::adapt;
            this.payloads.staticOr = PredicatesTest::staticOr;
            this.payloads.instanceOr = PredicatesTest::instanceOr;
            this.payloads.collectionOr = PredicatesTest::collectionOr;
            this.payloads.varArgOr = PredicatesTest::varArgOr;
            this.payloads.staticAnd = PredicatesTest::staticAnd;
            this.payloads.instanceAnd = PredicatesTest::instanceAnd;
            this.payloads.collectionAnd = PredicatesTest::collectionAnd;
            this.payloads.varArgAnd = PredicatesTest::varArgAnd;
            this.payloads.equal = PredicatesTest::equal;
            this.payloads.notEqual = PredicatesTest::notEqual;
            this.payloads.not = PredicatesTest::not;
            this.payloads.testNull = PredicatesTest::testNull;
            this.payloads.notNull = PredicatesTest::notNull;
            this.payloads.neither = PredicatesTest::neither;
            this.payloads.collectionNoneOf = PredicatesTest::collectionNoneOf;
            this.payloads.noneOf = PredicatesTest::noneOf;
            this.payloads.sameAs = PredicatesTest::sameAs;
            this.payloads.notSameAs = PredicatesTest::notSameAs;
            this.payloads.instanceOf = PredicatesTest::instanceOf;
            this.payloads.assignableFrom = PredicatesTest::assignableFrom;
            this.payloads.notInstanceOf = PredicatesTest::notInstanceOf;
            this.payloads.ifTrue = PredicatesTest::ifTrue;
            this.payloads.ifFalse = PredicatesTest::ifFalse;
            this.payloads.ifTrueWithClassAndFunctionName = PredicatesTest::ifTrueWithClassAndFunctionName;
            this.payloads.ifFalseWithClassAndFunctionName = PredicatesTest::ifFalseWithClassAndFunctionName;
            this.payloads.attributeEqual = PredicatesTest::attributeEqual;
            this.payloads.attributeNotEqual = PredicatesTest::attributeNotEqual;
            this.payloads.attributeLessThan = PredicatesTest::attributeLessThan;
            this.payloads.attributeGreaterThan = PredicatesTest::attributeGreaterThan;
            this.payloads.attributeGreaterThanOrEqualTo = PredicatesTest::attributeGreaterThanOrEqualTo;
            this.payloads.attributeLessThanOrEqualTo = PredicatesTest::attributeLessThanOrEqualTo;
            this.payloads.attributeAnySatisfy = PredicatesTest::attributeAnySatisfy;
            this.payloads.attributeAllSatisfy = PredicatesTest::attributeAllSatisfy;
            this.payloads.attributeNoneSatisfy = PredicatesTest::attributeNoneSatisfy;
            this.payloads.allSatisfy = PredicatesTest::allSatisfy;
            this.payloads.anySatisfy = PredicatesTest::anySatisfy;
            this.payloads.noneSatisfy = PredicatesTest::noneSatisfy;
            this.payloads.attributeIsNull = PredicatesTest::attributeIsNull;
            this.payloads.attributeIsNullWithFunctionName = PredicatesTest::attributeIsNullWithFunctionName;
            this.payloads.attributeNotNullWithFunction = PredicatesTest::attributeNotNullWithFunction;
            this.payloads.in_SetIterable = PredicatesTest::in_SetIterable;
            this.payloads.notIn_SetIterable = PredicatesTest::notIn_SetIterable;
            this.payloads.in_Set = PredicatesTest::in_Set;
            this.payloads.notIn_Set = PredicatesTest::notIn_Set;
            this.payloads.in_Collection = PredicatesTest::in_Collection;
            this.payloads.notIn_Collection = PredicatesTest::notIn_Collection;
            this.payloads.in = PredicatesTest::in;
            this.payloads.inInterval = PredicatesTest::inInterval;
            this.payloads.attributeIn = PredicatesTest::attributeIn;
            this.payloads.notIn = PredicatesTest::notIn;
            this.payloads.notInInterval = PredicatesTest::notInInterval;
            this.payloads.attributeNotIn = PredicatesTest::attributeNotIn;
            this.payloads.lessThan = PredicatesTest::lessThan;
            this.payloads.attributeBetweenExclusive = PredicatesTest::attributeBetweenExclusive;
            this.payloads.attributeBetweenInclusiveFrom = PredicatesTest::attributeBetweenInclusiveFrom;
            this.payloads.attributeBetweenInclusiveTo = PredicatesTest::attributeBetweenInclusiveTo;
            this.payloads.attributeBetweenInclusive = PredicatesTest::attributeBetweenInclusive;
            this.payloads.lessThanOrEqualTo = PredicatesTest::lessThanOrEqualTo;
            this.payloads.greaterThan = PredicatesTest::greaterThan;
            this.payloads.greaterThanOrEqualTo = PredicatesTest::greaterThanOrEqualTo;
            this.payloads.betweenInclusiveNumber = PredicatesTest::betweenInclusiveNumber;
            this.payloads.betweenInclusiveString = PredicatesTest::betweenInclusiveString;
            this.payloads.betweenInclusiveFromNumber = PredicatesTest::betweenInclusiveFromNumber;
            this.payloads.betweenInclusiveFromString = PredicatesTest::betweenInclusiveFromString;
            this.payloads.betweenInclusiveToNumber = PredicatesTest::betweenInclusiveToNumber;
            this.payloads.betweenInclusiveToString = PredicatesTest::betweenInclusiveToString;
            this.payloads.betweenExclusiveNumber = PredicatesTest::betweenExclusiveNumber;
            this.payloads.betweenExclusiveString = PredicatesTest::betweenExclusiveString;
            this.payloads.attributeNotNull = PredicatesTest::attributeNotNull;
            this.payloads.subClass = PredicatesTest::subClass;
            this.payloads.superClass = PredicatesTest::superClass;
        }
    }
}
