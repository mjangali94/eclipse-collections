/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.mutable.primitive;

import java.util.Arrays;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.LazyBooleanIterable;
import org.eclipse.collections.api.block.function.primitive.BooleanToObjectFunction;
import org.eclipse.collections.api.block.function.primitive.ObjectBooleanToObjectFunction;
import org.eclipse.collections.api.collection.primitive.MutableBooleanCollection;
import org.eclipse.collections.api.iterator.BooleanIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.primitive.MutableBooleanSet;
import org.eclipse.collections.api.tuple.primitive.BooleanBooleanPair;
import org.eclipse.collections.impl.bag.mutable.primitive.BooleanHashBag;
import org.eclipse.collections.impl.block.factory.primitive.BooleanPredicates;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableBooleanCollectionTestCase;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.math.MutableInteger;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractBooleanSetTestCase extends AbstractMutableBooleanCollectionTestCase {

    private MutableBooleanSet emptySet;

    private MutableBooleanSet setWithFalse;

    private MutableBooleanSet setWithTrue;

    private MutableBooleanSet setWithTrueFalse;

    @Override
    protected abstract MutableBooleanSet classUnderTest();

    @Override
    protected abstract MutableBooleanSet newWith(boolean... elements);

    @Override
    protected MutableBooleanSet newMutableCollectionWith(boolean... elements) {
        return BooleanHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Object> newObjectCollectionWith(Object... elements) {
        return UnifiedSet.newSetWith(elements);
    }

    @Before
    public void setup() {
        this.emptySet = this.newWith();
        this.setWithFalse = this.newWith(false);
        this.setWithTrue = this.newWith(true);
        this.setWithTrueFalse = this.newWith(true, false);
    }

    @Override
    @Test
    public void newCollectionWith() {
        MutableBooleanSet set = this.classUnderTest();
        Verify.assertSize(2, set);
        Assert.assertTrue(set.containsAll(true, false, true));
    }

    @Override
    @Test
    public void isEmpty() {
        super.isEmpty();
        Verify.assertEmpty(this.emptySet);
        Verify.assertNotEmpty(this.setWithFalse);
        Verify.assertNotEmpty(this.setWithTrue);
        Verify.assertNotEmpty(this.setWithTrueFalse);
    }

    @Override
    @Test
    public void notEmpty() {
        super.notEmpty();
        Assert.assertFalse(this.emptySet.notEmpty());
        Assert.assertTrue(this.setWithFalse.notEmpty());
        Assert.assertTrue(this.setWithTrue.notEmpty());
        Assert.assertTrue(this.setWithTrueFalse.notEmpty());
    }

    @Override
    @Test
    public void clear() {
        super.clear();
        this.emptySet.clear();
        this.setWithFalse.clear();
        this.setWithTrue.clear();
        this.setWithTrueFalse.clear();
        Verify.assertEmpty(this.emptySet);
        Verify.assertEmpty(this.setWithFalse);
        Verify.assertEmpty(this.setWithTrue);
        Verify.assertEmpty(this.setWithTrueFalse);
        Assert.assertFalse(this.setWithFalse.contains(false));
        Assert.assertFalse(this.setWithTrue.contains(true));
        Assert.assertFalse(this.setWithTrueFalse.contains(true));
        Assert.assertFalse(this.setWithTrueFalse.contains(false));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        Assert.assertFalse(this.emptySet.contains(true));
        Assert.assertFalse(this.emptySet.contains(false));
        Assert.assertTrue(this.setWithFalse.contains(false));
        Assert.assertFalse(this.setWithFalse.contains(true));
        Assert.assertTrue(this.setWithTrue.contains(true));
        Assert.assertFalse(this.setWithTrue.contains(false));
        Assert.assertTrue(this.setWithTrueFalse.contains(true));
        Assert.assertTrue(this.setWithTrueFalse.contains(false));
    }

    @Override
    @Test
    public void containsAllArray() {
        super.containsAllArray();
        Assert.assertFalse(this.emptySet.containsAll(true));
        Assert.assertFalse(this.emptySet.containsAll(true, false));
        Assert.assertTrue(this.setWithFalse.containsAll(false, false));
        Assert.assertFalse(this.setWithFalse.containsAll(true, true));
        Assert.assertFalse(this.setWithFalse.containsAll(true, false, true));
        Assert.assertTrue(this.setWithTrue.containsAll(true, true));
        Assert.assertFalse(this.setWithTrue.containsAll(false, false));
        Assert.assertFalse(this.setWithTrue.containsAll(true, false, false));
        Assert.assertTrue(this.setWithTrueFalse.containsAll(true, true));
        Assert.assertTrue(this.setWithTrueFalse.containsAll(false, false));
        Assert.assertTrue(this.setWithTrueFalse.containsAll(false, true, true));
    }

    @Override
    @Test
    public void containsAllIterable() {
        super.containsAllIterable();
        Assert.assertFalse(this.emptySet.containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertFalse(this.emptySet.containsAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertTrue(this.setWithFalse.containsAll(BooleanArrayList.newListWith(false, false)));
        Assert.assertFalse(this.setWithFalse.containsAll(BooleanArrayList.newListWith(true, true)));
        Assert.assertFalse(this.setWithFalse.containsAll(BooleanArrayList.newListWith(true, false, true)));
        Assert.assertTrue(this.setWithTrue.containsAll(BooleanArrayList.newListWith(true, true)));
        Assert.assertFalse(this.setWithTrue.containsAll(BooleanArrayList.newListWith(false, false)));
        Assert.assertFalse(this.setWithTrue.containsAll(BooleanArrayList.newListWith(true, false, false)));
        Assert.assertTrue(this.setWithTrueFalse.containsAll(BooleanArrayList.newListWith(true, true)));
        Assert.assertTrue(this.setWithTrueFalse.containsAll(BooleanArrayList.newListWith(false, false)));
        Assert.assertTrue(this.setWithTrueFalse.containsAll(BooleanArrayList.newListWith(false, true, true)));
    }

    @Override
    @Test
    public void add() {
        Assert.assertTrue(this.emptySet.add(true));
        Assert.assertEquals(BooleanHashSet.newSetWith(true), this.emptySet);
        MutableBooleanSet set = this.newWith();
        Assert.assertTrue(set.add(false));
        Assert.assertEquals(BooleanHashSet.newSetWith(false), set);
        Assert.assertFalse(this.setWithFalse.add(false));
        Assert.assertTrue(this.setWithFalse.add(true));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false), this.setWithFalse);
        Assert.assertFalse(this.setWithTrue.add(true));
        Assert.assertTrue(this.setWithTrue.add(false));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false), this.setWithTrue);
        Assert.assertFalse(this.setWithTrueFalse.add(true));
        Assert.assertFalse(this.setWithTrueFalse.add(false));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false), this.setWithTrueFalse);
    }

    @Override
    @Test
    public void addAllArray() {
        Assert.assertTrue(this.emptySet.addAll(true, false, true));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false), this.emptySet);
        Assert.assertFalse(this.setWithFalse.addAll(false, false));
        Assert.assertTrue(this.setWithFalse.addAll(true, false, true));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false), this.setWithFalse);
        Assert.assertFalse(this.setWithTrue.addAll(true, true));
        Assert.assertTrue(this.setWithTrue.addAll(true, false, true));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false), this.setWithTrue);
        Assert.assertFalse(this.setWithTrueFalse.addAll(true, false));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false), this.setWithTrueFalse);
    }

    @Override
    @Test
    public void addAllIterable() {
        Assert.assertTrue(this.emptySet.addAll(BooleanHashSet.newSetWith(true, false, true)));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false), this.emptySet);
        Assert.assertFalse(this.setWithFalse.addAll(BooleanHashSet.newSetWith(false, false)));
        Assert.assertTrue(this.setWithFalse.addAll(BooleanHashSet.newSetWith(true, false, true)));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false), this.setWithFalse);
        Assert.assertFalse(this.setWithTrue.addAll(BooleanHashSet.newSetWith(true, true)));
        Assert.assertTrue(this.setWithTrue.addAll(BooleanHashSet.newSetWith(true, false, true)));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false), this.setWithTrue);
        Assert.assertFalse(this.setWithTrueFalse.addAll(BooleanHashSet.newSetWith(true, false)));
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false), this.setWithTrueFalse);
    }

    @Override
    @Test
    public void remove() {
        Assert.assertTrue(this.setWithTrueFalse.remove(true));
        Assert.assertEquals(BooleanHashSet.newSetWith(false), this.setWithTrueFalse);
        MutableBooleanSet set = this.newWith(true, false);
        Assert.assertTrue(set.remove(false));
        Assert.assertEquals(BooleanHashSet.newSetWith(true), set);
        Assert.assertFalse(this.setWithTrue.remove(false));
        Assert.assertTrue(this.setWithTrue.remove(true));
        Assert.assertEquals(BooleanHashSet.newSetWith(), this.setWithTrue);
        Assert.assertFalse(this.setWithFalse.remove(true));
        Assert.assertTrue(this.setWithFalse.remove(false));
        Assert.assertEquals(BooleanHashSet.newSetWith(), this.setWithFalse);
        Assert.assertFalse(this.emptySet.remove(true));
        Assert.assertFalse(this.emptySet.remove(false));
        Assert.assertEquals(BooleanHashSet.newSetWith(), this.emptySet);
    }

    @Override
    @Test
    public void removeAll() {
        super.removeAll();
        Assert.assertFalse(this.emptySet.removeAll());
        Assert.assertFalse(this.setWithFalse.removeAll());
        Assert.assertFalse(this.setWithTrue.removeAll());
        Assert.assertFalse(this.setWithTrueFalse.removeAll());
        Assert.assertTrue(this.setWithTrueFalse.removeAll(true, true));
        Assert.assertEquals(BooleanHashSet.newSetWith(false), this.setWithTrueFalse);
        MutableBooleanSet set = this.newWith(true, false);
        Assert.assertTrue(set.removeAll(true, false));
        Assert.assertEquals(BooleanHashSet.newSetWith(), set);
        MutableBooleanSet sett = this.newWith(true, false);
        Assert.assertTrue(sett.removeAll(false, false));
        Assert.assertEquals(BooleanHashSet.newSetWith(true), sett);
        Assert.assertFalse(this.setWithTrue.removeAll(false, false));
        MutableBooleanSet sett2 = this.newWith(true);
        Assert.assertTrue(sett2.removeAll(true, true));
        Assert.assertEquals(BooleanHashSet.newSetWith(), sett2);
        Assert.assertTrue(this.setWithTrue.removeAll(true, false));
        Assert.assertEquals(BooleanHashSet.newSetWith(), this.setWithTrue);
        Assert.assertFalse(this.setWithFalse.removeAll(true, true));
        MutableBooleanSet sett3 = this.newWith(false);
        Assert.assertTrue(sett3.removeAll(false, false));
        Assert.assertEquals(BooleanHashSet.newSetWith(), sett3);
        Assert.assertTrue(this.setWithFalse.removeAll(true, false));
        Assert.assertEquals(BooleanHashSet.newSetWith(), this.setWithFalse);
        Assert.assertFalse(this.emptySet.removeAll(true, true));
        Assert.assertFalse(this.emptySet.removeAll(true, false));
        Assert.assertFalse(this.emptySet.removeAll(false, false));
        Assert.assertEquals(BooleanHashSet.newSetWith(), this.emptySet);
    }

    @Override
    @Test
    public void removeAll_iterable() {
        super.removeAll_iterable();
        Assert.assertFalse(this.emptySet.removeAll(new BooleanArrayList()));
        Assert.assertFalse(this.setWithFalse.removeAll(new BooleanArrayList()));
        Assert.assertFalse(this.setWithTrue.removeAll(new BooleanArrayList()));
        Assert.assertFalse(this.setWithTrueFalse.removeAll(new BooleanArrayList()));
        Assert.assertTrue(this.setWithTrueFalse.removeAll(BooleanArrayList.newListWith(true, true)));
        Assert.assertEquals(BooleanHashSet.newSetWith(false), this.setWithTrueFalse);
        MutableBooleanSet set = this.newWith(true, false);
        Assert.assertTrue(set.removeAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertEquals(BooleanHashSet.newSetWith(), set);
        MutableBooleanSet sett = this.newWith(true, false);
        Assert.assertTrue(sett.removeAll(BooleanArrayList.newListWith(false, false)));
        Assert.assertEquals(BooleanHashSet.newSetWith(true), sett);
        Assert.assertFalse(this.setWithTrue.removeAll(BooleanArrayList.newListWith(false, false)));
        MutableBooleanSet sett2 = this.newWith(true);
        Assert.assertTrue(sett2.removeAll(BooleanArrayList.newListWith(true, true)));
        Assert.assertEquals(BooleanHashSet.newSetWith(), sett2);
        Assert.assertTrue(this.setWithTrue.removeAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertEquals(BooleanHashSet.newSetWith(), this.setWithTrue);
        Assert.assertFalse(this.setWithFalse.removeAll(true, true));
        MutableBooleanSet sett3 = this.newWith(false);
        Assert.assertTrue(sett3.removeAll(BooleanArrayList.newListWith(false, false)));
        Assert.assertEquals(BooleanHashSet.newSetWith(), sett3);
        Assert.assertTrue(this.setWithFalse.removeAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertEquals(BooleanHashSet.newSetWith(), this.setWithFalse);
        Assert.assertFalse(this.emptySet.removeAll(BooleanArrayList.newListWith(true, true)));
        Assert.assertFalse(this.emptySet.removeAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertFalse(this.emptySet.removeAll(BooleanArrayList.newListWith(false, false)));
        Assert.assertEquals(BooleanHashSet.newSetWith(), this.emptySet);
    }

    @Override
    @Test
    public void retainAll() {
        super.retainAll();
        Assert.assertFalse(this.emptySet.retainAll());
        Assert.assertTrue(this.setWithTrueFalse.retainAll(true, true));
        Assert.assertEquals(BooleanHashSet.newSetWith(true), this.setWithTrueFalse);
        MutableBooleanSet set = this.newWith(true, false);
        Assert.assertTrue(set.retainAll());
        Assert.assertEquals(BooleanHashSet.newSetWith(), set);
        MutableBooleanSet sett = this.newWith(true, false);
        Assert.assertTrue(sett.retainAll(false, false));
        Assert.assertEquals(BooleanHashSet.newSetWith(false), sett);
        MutableBooleanSet sett2 = this.newWith(true);
        Assert.assertTrue(sett2.retainAll(false, false));
        Assert.assertEquals(BooleanHashSet.newSetWith(), sett2);
        Assert.assertTrue(this.setWithTrue.retainAll(false, false));
        Assert.assertFalse(this.setWithTrue.retainAll(true, false));
        Assert.assertEquals(BooleanHashSet.newSetWith(), this.setWithTrue);
        MutableBooleanSet sett3 = this.newWith(false);
        Assert.assertFalse(sett3.retainAll(false, false));
        Assert.assertEquals(BooleanHashSet.newSetWith(false), sett3);
        Assert.assertTrue(this.setWithFalse.retainAll(true, true));
        Assert.assertFalse(this.setWithFalse.retainAll(true, false));
        Assert.assertEquals(BooleanHashSet.newSetWith(), this.setWithFalse);
        Assert.assertFalse(this.emptySet.retainAll(true, true));
        Assert.assertFalse(this.emptySet.retainAll(true, false));
        Assert.assertFalse(this.emptySet.retainAll(false, false));
        Assert.assertEquals(BooleanHashSet.newSetWith(), this.emptySet);
    }

    @Override
    @Test
    public void retainAll_iterable() {
        super.retainAll_iterable();
        Assert.assertFalse(this.emptySet.retainAll(new BooleanArrayList()));
        Assert.assertTrue(this.setWithTrueFalse.retainAll(BooleanArrayList.newListWith(true, true)));
        Assert.assertEquals(BooleanHashSet.newSetWith(true), this.setWithTrueFalse);
        MutableBooleanSet set = this.newWith(true, false);
        Assert.assertTrue(set.retainAll(BooleanArrayList.newListWith()));
        Assert.assertEquals(BooleanHashSet.newSetWith(), set);
        MutableBooleanSet sett = this.newWith(true, false);
        Assert.assertTrue(sett.retainAll(BooleanArrayList.newListWith(false, false)));
        Assert.assertEquals(BooleanHashSet.newSetWith(false), sett);
        MutableBooleanSet sett2 = this.newWith(true);
        Assert.assertTrue(sett2.retainAll(BooleanArrayList.newListWith(false, false)));
        Assert.assertEquals(BooleanHashSet.newSetWith(), sett2);
        Assert.assertTrue(this.setWithTrue.retainAll(BooleanArrayList.newListWith(false, false)));
        Assert.assertFalse(this.setWithTrue.retainAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertEquals(BooleanHashSet.newSetWith(), this.setWithTrue);
        MutableBooleanSet sett3 = this.newWith(false);
        Assert.assertFalse(sett3.retainAll(BooleanArrayList.newListWith(false, false)));
        Assert.assertEquals(BooleanHashSet.newSetWith(false), sett3);
        Assert.assertTrue(this.setWithFalse.retainAll(BooleanArrayList.newListWith(true, true)));
        Assert.assertFalse(this.setWithFalse.retainAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertEquals(BooleanHashSet.newSetWith(), this.setWithFalse);
        Assert.assertFalse(this.emptySet.retainAll(BooleanArrayList.newListWith(true, true)));
        Assert.assertFalse(this.emptySet.retainAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertFalse(this.emptySet.retainAll(BooleanArrayList.newListWith(false, false)));
        Assert.assertEquals(BooleanHashSet.newSetWith(), this.emptySet);
    }

    @Override
    @Test
    public void with() {
        super.with();
        MutableBooleanCollection emptySet = this.newWith();
        MutableBooleanCollection set = emptySet.with(false);
        MutableBooleanSet set1 = this.newWith().with(true);
        MutableBooleanSet set2 = this.newWith().with(true).with(false);
        MutableBooleanSet set3 = this.newWith().with(false).with(true);
        Assert.assertSame(emptySet, set);
        Assert.assertEquals(this.setWithFalse, set);
        Assert.assertEquals(this.setWithTrue, set1);
        Assert.assertEquals(this.setWithTrueFalse, set2);
        Assert.assertEquals(this.setWithTrueFalse, set3);
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false), this.setWithTrueFalse.with(true));
    }

    @Override
    @Test
    public void withAll() {
        super.withAll();
        MutableBooleanCollection emptySet = this.newWith();
        MutableBooleanCollection set = emptySet.withAll(BooleanArrayList.newListWith(false));
        MutableBooleanSet set1 = this.newWith().withAll(BooleanArrayList.newListWith(true));
        MutableBooleanSet set2 = this.newWith().withAll(BooleanArrayList.newListWith(true, false));
        MutableBooleanSet set3 = this.newWith().withAll(BooleanArrayList.newListWith(true, false));
        Assert.assertSame(emptySet, set);
        Assert.assertEquals(this.setWithFalse, set);
        Assert.assertEquals(this.setWithTrue, set1);
        Assert.assertEquals(this.setWithTrueFalse, set2);
        Assert.assertEquals(this.setWithTrueFalse, set3);
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false), this.setWithTrueFalse.withAll(BooleanHashSet.newSetWith(true, false)));
    }

    @Override
    @Test
    public void without() {
        Assert.assertEquals(BooleanHashSet.newSetWith(true), this.setWithTrueFalse.without(false));
        Assert.assertSame(this.setWithTrueFalse, this.setWithTrueFalse.without(false));
        Assert.assertEquals(BooleanHashSet.newSetWith(false), this.newWith(true, false).without(true));
        Assert.assertEquals(BooleanHashSet.newSetWith(), this.setWithTrueFalse.without(true));
        Assert.assertEquals(BooleanHashSet.newSetWith(true), this.setWithTrue.without(false));
        Assert.assertEquals(BooleanHashSet.newSetWith(), this.setWithTrue.without(true));
        Assert.assertEquals(BooleanHashSet.newSetWith(false), this.setWithFalse.without(true));
        Assert.assertEquals(BooleanHashSet.newSetWith(), this.setWithFalse.without(false));
        Assert.assertEquals(new BooleanHashSet(), this.emptySet.without(true));
        Assert.assertEquals(new BooleanHashSet(), this.emptySet.without(false));
    }

    @Override
    @Test
    public void withoutAll() {
        super.withoutAll();
        Assert.assertEquals(BooleanHashSet.newSetWith(true), this.setWithTrueFalse.withoutAll(BooleanArrayList.newListWith(false, false)));
        Assert.assertSame(this.setWithTrueFalse, this.setWithTrueFalse.withoutAll(BooleanArrayList.newListWith(false, false)));
        Assert.assertEquals(BooleanHashSet.newSetWith(false), this.newWith(true, false).withoutAll(BooleanArrayList.newListWith(true, true)));
        Assert.assertEquals(BooleanHashSet.newSetWith(), this.newWith(true, false).withoutAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertEquals(BooleanHashSet.newSetWith(), this.setWithTrueFalse.withoutAll(BooleanArrayList.newListWith(true)));
        Assert.assertEquals(BooleanHashSet.newSetWith(true), this.setWithTrue.withoutAll(BooleanArrayList.newListWith(false)));
        Assert.assertEquals(BooleanHashSet.newSetWith(), this.setWithTrue.withoutAll(BooleanArrayList.newListWith(true)));
        Assert.assertEquals(BooleanHashSet.newSetWith(), this.newWith(true).withoutAll(BooleanArrayList.newListWith(false, true)));
        Assert.assertEquals(BooleanHashSet.newSetWith(false), this.setWithFalse.withoutAll(BooleanArrayList.newListWith(true)));
        Assert.assertEquals(BooleanHashSet.newSetWith(), this.setWithFalse.withoutAll(BooleanArrayList.newListWith(false)));
        Assert.assertEquals(BooleanHashSet.newSetWith(), this.newWith(false).withoutAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertEquals(new BooleanHashSet(), this.emptySet.withoutAll(BooleanArrayList.newListWith(true)));
        Assert.assertEquals(new BooleanHashSet(), this.emptySet.withoutAll(BooleanArrayList.newListWith(false)));
        Assert.assertEquals(new BooleanHashSet(), this.emptySet.withoutAll(BooleanArrayList.newListWith(false, true)));
    }

    @Override
    @Test
    public void toArray() {
        super.toArray();
        Assert.assertEquals(0L, this.emptySet.toArray().length);
        Assert.assertEquals(1L, this.setWithFalse.toArray().length);
        Assert.assertFalse(this.setWithFalse.toArray()[0]);
        Assert.assertEquals(1L, this.setWithTrue.toArray().length);
        Assert.assertTrue(this.setWithTrue.toArray()[0]);
        Assert.assertEquals(2L, this.setWithTrueFalse.toArray().length);
        Assert.assertTrue(Arrays.equals(new boolean[] { false, true }, this.setWithTrueFalse.toArray()) || Arrays.equals(new boolean[] { true, false }, this.setWithTrueFalse.toArray()));
    }

    @Override
    @Test
    public void toList() {
        super.toList();
        Assert.assertEquals(new BooleanArrayList(), this.emptySet.toList());
        Assert.assertEquals(BooleanArrayList.newListWith(false), this.setWithFalse.toList());
        Assert.assertEquals(BooleanArrayList.newListWith(true), this.setWithTrue.toList());
        Assert.assertTrue(BooleanArrayList.newListWith(false, true).equals(this.setWithTrueFalse.toList()) || BooleanArrayList.newListWith(true, false).equals(this.setWithTrueFalse.toList()));
    }

    @Override
    @Test
    public void toSet() {
        super.toSet();
        Assert.assertEquals(new BooleanHashSet(), this.emptySet.toSet());
        Assert.assertEquals(BooleanHashSet.newSetWith(false), this.setWithFalse.toSet());
        Assert.assertEquals(BooleanHashSet.newSetWith(true), this.setWithTrue.toSet());
        Assert.assertEquals(BooleanHashSet.newSetWith(false, true), this.setWithTrueFalse.toSet());
    }

    @Override
    @Test
    public void toBag() {
        Assert.assertEquals(new BooleanHashBag(), this.emptySet.toBag());
        Assert.assertEquals(BooleanHashBag.newBagWith(false), this.setWithFalse.toBag());
        Assert.assertEquals(BooleanHashBag.newBagWith(true), this.setWithTrue.toBag());
        Assert.assertEquals(BooleanHashBag.newBagWith(false, true), this.setWithTrueFalse.toBag());
    }

    @Override
    @Test
    public void testEquals() {
        Assert.assertNotEquals(this.setWithFalse, this.emptySet);
        Assert.assertNotEquals(this.setWithFalse, this.setWithTrue);
        Assert.assertNotEquals(this.setWithFalse, this.setWithTrueFalse);
        Assert.assertNotEquals(this.setWithTrue, this.emptySet);
        Assert.assertNotEquals(this.setWithTrue, this.setWithTrueFalse);
        Assert.assertNotEquals(this.setWithTrueFalse, this.emptySet);
        Verify.assertEqualsAndHashCode(this.newWith(false, true), this.setWithTrueFalse);
        Verify.assertEqualsAndHashCode(this.newWith(true, false), this.setWithTrueFalse);
        Verify.assertPostSerializedEqualsAndHashCode(this.emptySet);
        Verify.assertPostSerializedEqualsAndHashCode(this.setWithFalse);
        Verify.assertPostSerializedEqualsAndHashCode(this.setWithTrue);
        Verify.assertPostSerializedEqualsAndHashCode(this.setWithTrueFalse);
    }

    @Override
    @Test
    public void testHashCode() {
        super.testHashCode();
        Assert.assertEquals(UnifiedSet.newSet().hashCode(), this.emptySet.hashCode());
        Assert.assertEquals(UnifiedSet.newSetWith(false).hashCode(), this.setWithFalse.hashCode());
        Assert.assertEquals(UnifiedSet.newSetWith(true).hashCode(), this.setWithTrue.hashCode());
        Assert.assertEquals(UnifiedSet.newSetWith(true, false).hashCode(), this.setWithTrueFalse.hashCode());
        Assert.assertEquals(UnifiedSet.newSetWith(false, true).hashCode(), this.setWithTrueFalse.hashCode());
        Assert.assertNotEquals(UnifiedSet.newSetWith(false).hashCode(), this.setWithTrueFalse.hashCode());
    }

    @Override
    @Test
    public void booleanIterator() {
        BooleanIterator booleanIterator0 = this.emptySet.booleanIterator();
        Assert.assertFalse(booleanIterator0.hasNext());
        Assert.assertThrows(NoSuchElementException.class, booleanIterator0::next);
        BooleanIterator booleanIterator1 = this.setWithFalse.booleanIterator();
        Assert.assertTrue(booleanIterator1.hasNext());
        Assert.assertFalse(booleanIterator1.next());
        Assert.assertFalse(booleanIterator1.hasNext());
        Assert.assertThrows(NoSuchElementException.class, booleanIterator1::next);
        BooleanIterator booleanIterator2 = this.setWithTrue.booleanIterator();
        Assert.assertTrue(booleanIterator2.hasNext());
        Assert.assertTrue(booleanIterator2.next());
        Assert.assertFalse(booleanIterator2.hasNext());
        Assert.assertThrows(NoSuchElementException.class, booleanIterator2::next);
        BooleanIterator booleanIterator3 = this.setWithTrueFalse.booleanIterator();
        MutableBooleanSet actual = new BooleanHashSet();
        Assert.assertTrue(booleanIterator3.hasNext());
        actual.add(booleanIterator3.next());
        Assert.assertTrue(booleanIterator3.hasNext());
        actual.add(booleanIterator3.next());
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false), actual);
        Assert.assertFalse(booleanIterator3.hasNext());
        Assert.assertThrows(NoSuchElementException.class, booleanIterator3::next);
    }

    @Override
    @Test
    public void forEach() {
        String[] sum = new String[4];
        for (int i = 0; i < sum.length; i++) {
            sum[i] = "";
        }
        this.emptySet.forEach(each -> sum[0] += each);
        this.setWithFalse.forEach(each -> sum[1] += each);
        this.setWithTrue.forEach(each -> sum[2] += each);
        this.setWithTrueFalse.forEach(each -> sum[3] += each);
        Assert.assertEquals("", sum[0]);
        Assert.assertEquals("false", sum[1]);
        Assert.assertEquals("true", sum[2]);
        Assert.assertTrue("truefalse".equals(sum[3]) || "falsetrue".equals(sum[3]));
    }

    @Override
    @Test
    public void injectInto() {
        ObjectBooleanToObjectFunction<MutableInteger, MutableInteger> function = (object, value) -> object.add(value ? 1 : 0);
        Assert.assertEquals(new MutableInteger(1), BooleanHashSet.newSetWith(true, false, true).injectInto(new MutableInteger(0), function));
        Assert.assertEquals(new MutableInteger(1), BooleanHashSet.newSetWith(true).injectInto(new MutableInteger(0), function));
        Assert.assertEquals(new MutableInteger(0), BooleanHashSet.newSetWith(false).injectInto(new MutableInteger(0), function));
        Assert.assertEquals(new MutableInteger(0), new BooleanHashSet().injectInto(new MutableInteger(0), function));
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(2, this.classUnderTest());
    }

    @Override
    @Test
    public void count() {
        Assert.assertEquals(0L, this.emptySet.count(BooleanPredicates.isTrue()));
        Assert.assertEquals(0L, this.setWithFalse.count(BooleanPredicates.isTrue()));
        Assert.assertEquals(1L, this.setWithFalse.count(BooleanPredicates.isFalse()));
        Assert.assertEquals(0L, this.setWithTrue.count(BooleanPredicates.isFalse()));
        Assert.assertEquals(1L, this.setWithTrueFalse.count(BooleanPredicates.isTrue()));
        Assert.assertEquals(0L, this.setWithTrueFalse.count(BooleanPredicates.and(BooleanPredicates.isFalse(), BooleanPredicates.isTrue())));
        Assert.assertEquals(1L, this.setWithTrueFalse.count(BooleanPredicates.isFalse()));
        Assert.assertEquals(1L, this.setWithTrueFalse.count(BooleanPredicates.isTrue()));
        Assert.assertEquals(2L, this.setWithTrueFalse.count(BooleanPredicates.or(BooleanPredicates.isFalse(), BooleanPredicates.isTrue())));
    }

    @Override
    @Test
    public void anySatisfy() {
        super.anySatisfy();
        Assert.assertFalse(this.emptySet.anySatisfy(BooleanPredicates.or(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
        Assert.assertFalse(this.setWithFalse.anySatisfy(BooleanPredicates.isTrue()));
        Assert.assertTrue(this.setWithFalse.anySatisfy(BooleanPredicates.isFalse()));
        Assert.assertFalse(this.setWithTrue.anySatisfy(BooleanPredicates.isFalse()));
        Assert.assertTrue(this.setWithTrue.anySatisfy(BooleanPredicates.isTrue()));
        Assert.assertTrue(this.setWithTrueFalse.anySatisfy(BooleanPredicates.isTrue()));
        Assert.assertTrue(this.setWithTrueFalse.anySatisfy(BooleanPredicates.isFalse()));
        Assert.assertFalse(this.setWithTrueFalse.anySatisfy(BooleanPredicates.and(BooleanPredicates.isFalse(), BooleanPredicates.isTrue())));
    }

    @Override
    @Test
    public void allSatisfy() {
        super.allSatisfy();
        Assert.assertTrue(this.emptySet.allSatisfy(BooleanPredicates.or(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
        Assert.assertFalse(this.setWithFalse.allSatisfy(BooleanPredicates.isTrue()));
        Assert.assertTrue(this.setWithFalse.allSatisfy(BooleanPredicates.isFalse()));
        Assert.assertFalse(this.setWithTrue.allSatisfy(BooleanPredicates.isFalse()));
        Assert.assertTrue(this.setWithTrue.allSatisfy(BooleanPredicates.isTrue()));
        Assert.assertFalse(this.setWithTrueFalse.allSatisfy(BooleanPredicates.isTrue()));
        Assert.assertFalse(this.setWithTrueFalse.allSatisfy(BooleanPredicates.isFalse()));
        Assert.assertFalse(this.setWithTrueFalse.allSatisfy(BooleanPredicates.and(BooleanPredicates.isFalse(), BooleanPredicates.isTrue())));
        Assert.assertTrue(this.setWithTrueFalse.allSatisfy(BooleanPredicates.or(BooleanPredicates.isFalse(), BooleanPredicates.isTrue())));
    }

    @Override
    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.emptySet.noneSatisfy(BooleanPredicates.or(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
        Assert.assertFalse(this.setWithFalse.noneSatisfy(BooleanPredicates.isFalse()));
        Assert.assertTrue(this.setWithFalse.noneSatisfy(BooleanPredicates.isTrue()));
        Assert.assertFalse(this.setWithTrue.noneSatisfy(BooleanPredicates.isTrue()));
        Assert.assertTrue(this.setWithTrue.noneSatisfy(BooleanPredicates.isFalse()));
        Assert.assertFalse(this.setWithTrueFalse.noneSatisfy(BooleanPredicates.isTrue()));
        Assert.assertFalse(this.setWithTrueFalse.noneSatisfy(BooleanPredicates.isFalse()));
        Assert.assertTrue(this.setWithTrueFalse.noneSatisfy(BooleanPredicates.and(BooleanPredicates.isFalse(), BooleanPredicates.isTrue())));
        Assert.assertFalse(this.setWithTrueFalse.noneSatisfy(BooleanPredicates.or(BooleanPredicates.isFalse(), BooleanPredicates.isTrue())));
    }

    @Override
    @Test
    public void select() {
        Verify.assertEmpty(this.emptySet.select(BooleanPredicates.or(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
        Verify.assertEmpty(this.setWithFalse.select(BooleanPredicates.isTrue()));
        Verify.assertSize(1, this.setWithFalse.select(BooleanPredicates.isFalse()));
        Verify.assertEmpty(this.setWithTrue.select(BooleanPredicates.isFalse()));
        Verify.assertSize(1, this.setWithTrue.select(BooleanPredicates.isTrue()));
        Verify.assertSize(1, this.setWithTrueFalse.select(BooleanPredicates.isFalse()));
        Verify.assertSize(1, this.setWithTrueFalse.select(BooleanPredicates.isTrue()));
        Verify.assertEmpty(this.setWithTrueFalse.select(BooleanPredicates.and(BooleanPredicates.isFalse(), BooleanPredicates.isTrue())));
        Verify.assertSize(2, this.setWithTrueFalse.select(BooleanPredicates.or(BooleanPredicates.isFalse(), BooleanPredicates.isTrue())));
    }

    @Override
    @Test
    public void reject() {
        Verify.assertEmpty(this.emptySet.reject(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
        Verify.assertEmpty(this.setWithTrue.reject(BooleanPredicates.isTrue()));
        Verify.assertSize(1, this.setWithTrue.reject(BooleanPredicates.isFalse()));
        Verify.assertEmpty(this.setWithFalse.reject(BooleanPredicates.isFalse()));
        Verify.assertSize(1, this.setWithFalse.reject(BooleanPredicates.isTrue()));
        Verify.assertSize(1, this.setWithTrueFalse.reject(BooleanPredicates.isFalse()));
        Verify.assertSize(1, this.setWithTrueFalse.reject(BooleanPredicates.isTrue()));
        Verify.assertEmpty(this.setWithTrueFalse.reject(BooleanPredicates.or(BooleanPredicates.isFalse(), BooleanPredicates.isTrue())));
        Verify.assertSize(2, this.setWithTrueFalse.reject(BooleanPredicates.and(BooleanPredicates.isFalse(), BooleanPredicates.isTrue())));
    }

    @Override
    @Test
    public void detectIfNone() {
        super.detectIfNone();
        Assert.assertTrue(this.emptySet.detectIfNone(BooleanPredicates.or(BooleanPredicates.isTrue(), BooleanPredicates.isFalse()), true));
        Assert.assertFalse(this.emptySet.detectIfNone(BooleanPredicates.or(BooleanPredicates.isTrue(), BooleanPredicates.isFalse()), false));
        Assert.assertTrue(this.setWithFalse.detectIfNone(BooleanPredicates.isTrue(), true));
        Assert.assertFalse(this.setWithFalse.detectIfNone(BooleanPredicates.isTrue(), false));
        Assert.assertFalse(this.setWithFalse.detectIfNone(BooleanPredicates.isFalse(), true));
        Assert.assertFalse(this.setWithFalse.detectIfNone(BooleanPredicates.isFalse(), false));
        Assert.assertTrue(this.setWithTrue.detectIfNone(BooleanPredicates.isFalse(), true));
        Assert.assertFalse(this.setWithTrue.detectIfNone(BooleanPredicates.isFalse(), false));
        Assert.assertTrue(this.setWithTrue.detectIfNone(BooleanPredicates.isTrue(), true));
        Assert.assertTrue(this.setWithTrue.detectIfNone(BooleanPredicates.isTrue(), false));
        Assert.assertTrue(this.setWithTrueFalse.detectIfNone(BooleanPredicates.and(BooleanPredicates.isFalse(), BooleanPredicates.isTrue()), true));
        Assert.assertFalse(this.setWithTrueFalse.detectIfNone(BooleanPredicates.and(BooleanPredicates.isFalse(), BooleanPredicates.isTrue()), false));
        Assert.assertFalse(this.setWithTrueFalse.detectIfNone(BooleanPredicates.isFalse(), true));
        Assert.assertTrue(this.setWithTrueFalse.detectIfNone(BooleanPredicates.isTrue(), false));
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        BooleanToObjectFunction<Boolean> function = parameter -> !parameter;
        Assert.assertEquals(UnifiedSet.newSetWith(true, false), this.setWithTrueFalse.collect(function));
        Assert.assertEquals(UnifiedSet.newSetWith(false), this.setWithTrue.collect(function));
        Assert.assertEquals(UnifiedSet.newSetWith(true), this.setWithFalse.collect(function));
        Assert.assertEquals(UnifiedSet.newSetWith(), this.emptySet.collect(function));
    }

    @Override
    @Test
    public void testToString() {
        super.testToString();
        Assert.assertEquals("[]", this.emptySet.toString());
        Assert.assertEquals("[false]", this.setWithFalse.toString());
        Assert.assertEquals("[true]", this.setWithTrue.toString());
        Assert.assertTrue("[true, false]".equals(this.setWithTrueFalse.toString()) || "[false, true]".equals(this.setWithTrueFalse.toString()));
    }

    @Override
    @Test
    public void makeString() {
        super.makeString();
        Assert.assertEquals("", this.emptySet.makeString());
        Assert.assertEquals("false", this.setWithFalse.makeString());
        Assert.assertEquals("true", this.setWithTrue.makeString());
        Assert.assertTrue("true, false".equals(this.setWithTrueFalse.makeString()) || "false, true".equals(this.setWithTrueFalse.makeString()));
        Assert.assertEquals("", this.emptySet.makeString("/"));
        Assert.assertEquals("false", this.setWithFalse.makeString("/"));
        Assert.assertEquals("true", this.setWithTrue.makeString("/"));
        Assert.assertTrue(this.setWithTrueFalse.makeString("/"), "true/false".equals(this.setWithTrueFalse.makeString("/")) || "false/true".equals(this.setWithTrueFalse.makeString("/")));
        Assert.assertEquals("[]", this.emptySet.makeString("[", "/", "]"));
        Assert.assertEquals("[false]", this.setWithFalse.makeString("[", "/", "]"));
        Assert.assertEquals("[true]", this.setWithTrue.makeString("[", "/", "]"));
        Assert.assertTrue(this.setWithTrueFalse.makeString("[", "/", "]"), "[true/false]".equals(this.setWithTrueFalse.makeString("[", "/", "]")) || "[false/true]".equals(this.setWithTrueFalse.makeString("[", "/", "]")));
    }

    @Override
    @Test
    public void appendString() {
        super.appendString();
        StringBuilder appendable = new StringBuilder();
        this.emptySet.appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        StringBuilder appendable1 = new StringBuilder();
        this.setWithFalse.appendString(appendable1);
        Assert.assertEquals("false", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();
        this.setWithTrue.appendString(appendable2);
        Assert.assertEquals("true", appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        this.setWithTrueFalse.appendString(appendable3);
        Assert.assertTrue("true, false".equals(appendable3.toString()) || "false, true".equals(appendable3.toString()));
        StringBuilder appendable4 = new StringBuilder();
        this.setWithTrueFalse.appendString(appendable4, "[", ", ", "]");
        Assert.assertTrue("[true, false]".equals(appendable4.toString()) || "[false, true]".equals(appendable4.toString()));
    }

    @Override
    @Test
    public void asLazy() {
        super.asLazy();
        Verify.assertInstanceOf(LazyBooleanIterable.class, this.emptySet.asLazy());
        Assert.assertEquals(this.emptySet, this.emptySet.asLazy().toSet());
        Assert.assertEquals(this.setWithFalse, this.setWithFalse.asLazy().toSet());
        Assert.assertEquals(this.setWithTrue, this.setWithTrue.asLazy().toSet());
        Assert.assertEquals(this.setWithTrueFalse, this.setWithTrueFalse.asLazy().toSet());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Verify.assertInstanceOf(SynchronizedBooleanSet.class, this.emptySet.asSynchronized());
        Assert.assertEquals(new SynchronizedBooleanSet(this.emptySet), this.emptySet.asSynchronized());
        Assert.assertEquals(new SynchronizedBooleanSet(this.setWithFalse), this.setWithFalse.asSynchronized());
        Assert.assertEquals(new SynchronizedBooleanSet(this.setWithTrue), this.setWithTrue.asSynchronized());
        Assert.assertEquals(new SynchronizedBooleanSet(this.setWithTrueFalse), this.setWithTrueFalse.asSynchronized());
    }

    @Override
    @Test
    public void asUnmodifiable() {
        super.asUnmodifiable();
        Verify.assertInstanceOf(UnmodifiableBooleanSet.class, this.emptySet.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableBooleanSet(this.emptySet), this.emptySet.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableBooleanSet(this.setWithFalse), this.setWithFalse.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableBooleanSet(this.setWithTrue), this.setWithTrue.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableBooleanSet(this.setWithTrueFalse), this.setWithTrueFalse.asUnmodifiable());
    }

    @Test
    public void union() {
        MutableBooleanSet set11 = this.newWith(true);
        MutableBooleanSet set21 = this.newWith(false);
        MutableBooleanSet actual = set11.union(set21);
        Assert.assertEquals(this.setWithTrueFalse, actual);
        MutableBooleanSet set12 = this.newWith(false);
        MutableBooleanSet set22 = this.newWith(false);
        MutableBooleanSet actual2 = set12.union(set22);
        Assert.assertEquals(this.setWithFalse, actual2);
        MutableBooleanSet set13 = this.newWith(true);
        MutableBooleanSet set23 = this.newWith(true);
        MutableBooleanSet actual3 = set13.union(set23);
        Assert.assertEquals(this.setWithTrue, actual3);
        MutableBooleanSet set14 = this.setWithTrueFalse;
        MutableBooleanSet set24 = this.newWith();
        MutableBooleanSet actual4 = set14.union(set24);
        Assert.assertEquals(this.setWithTrueFalse, actual4);
        MutableBooleanSet set15 = this.newWith();
        MutableBooleanSet set25 = this.newWith();
        MutableBooleanSet actual5 = set15.union(set25);
        Assert.assertEquals(this.emptySet, actual5);
    }

    @Test
    public void intersect() {
        MutableBooleanSet set11 = this.newWith(true);
        MutableBooleanSet set21 = this.newWith(false);
        MutableBooleanSet actual = set11.intersect(set21);
        Assert.assertEquals(this.emptySet, actual);
        MutableBooleanSet set12 = this.newWith(false);
        MutableBooleanSet set22 = this.newWith(false);
        MutableBooleanSet actual2 = set12.intersect(set22);
        Assert.assertEquals(this.setWithFalse, actual2);
        MutableBooleanSet set13 = this.newWith(true);
        MutableBooleanSet set23 = this.newWith(true);
        MutableBooleanSet actual3 = set13.intersect(set23);
        Assert.assertEquals(this.setWithTrue, actual3);
        MutableBooleanSet set14 = this.setWithTrueFalse;
        MutableBooleanSet set24 = this.newWith();
        MutableBooleanSet actual4 = set14.intersect(set24);
        Assert.assertEquals(this.emptySet, actual4);
        MutableBooleanSet set15 = this.newWith();
        MutableBooleanSet set25 = this.newWith();
        MutableBooleanSet actual5 = set15.intersect(set25);
        Assert.assertEquals(this.emptySet, actual5);
    }

    @Test
    public void difference() {
        MutableBooleanSet set11 = this.newWith(true);
        MutableBooleanSet set21 = this.newWith(false);
        MutableBooleanSet actual = set11.difference(set21);
        Assert.assertEquals(this.setWithTrue, actual);
        MutableBooleanSet set12 = this.newWith(false);
        MutableBooleanSet set22 = this.newWith(false);
        MutableBooleanSet actual2 = set12.difference(set22);
        Assert.assertEquals(this.emptySet, actual2);
        MutableBooleanSet set13 = this.setWithTrueFalse;
        MutableBooleanSet set23 = this.setWithTrueFalse;
        MutableBooleanSet actual3 = set13.difference(set23);
        Assert.assertEquals(this.emptySet, actual3);
        MutableBooleanSet set14 = this.setWithTrueFalse;
        MutableBooleanSet set24 = this.newWith();
        MutableBooleanSet actual4 = set14.difference(set24);
        Assert.assertEquals(this.setWithTrueFalse, actual4);
        MutableBooleanSet set15 = this.newWith();
        MutableBooleanSet set25 = this.setWithTrueFalse;
        MutableBooleanSet actual5 = set15.difference(set25);
        Assert.assertEquals(this.emptySet, actual5);
        MutableBooleanSet set16 = this.newWith();
        MutableBooleanSet set26 = this.newWith();
        MutableBooleanSet actual6 = set16.difference(set26);
        Assert.assertEquals(this.emptySet, actual6);
    }

    @Test
    public void symmetricDifference() {
        MutableBooleanSet set11 = this.newWith(true);
        MutableBooleanSet set21 = this.newWith(false);
        MutableBooleanSet actual = set11.symmetricDifference(set21);
        Assert.assertEquals(this.setWithTrueFalse, actual);
        MutableBooleanSet set12 = this.newWith(false);
        MutableBooleanSet set22 = this.newWith(false);
        MutableBooleanSet actual2 = set12.symmetricDifference(set22);
        Assert.assertEquals(this.emptySet, actual2);
        MutableBooleanSet set13 = this.setWithTrueFalse;
        MutableBooleanSet set23 = this.setWithTrueFalse;
        MutableBooleanSet actual3 = set13.symmetricDifference(set23);
        Assert.assertEquals(this.emptySet, actual3);
        MutableBooleanSet set14 = this.setWithTrueFalse;
        MutableBooleanSet set24 = this.newWith();
        MutableBooleanSet actual4 = set14.symmetricDifference(set24);
        Assert.assertEquals(this.setWithTrueFalse, actual4);
        MutableBooleanSet set15 = this.newWith();
        MutableBooleanSet set25 = this.setWithTrueFalse;
        MutableBooleanSet actual5 = set15.symmetricDifference(set25);
        Assert.assertEquals(this.setWithTrueFalse, actual5);
        MutableBooleanSet set16 = this.newWith();
        MutableBooleanSet set26 = this.newWith();
        MutableBooleanSet actual6 = set16.symmetricDifference(set26);
        Assert.assertEquals(this.emptySet, actual6);
    }

    @Test
    public void isSubsetOf() {
        MutableBooleanSet set11 = this.newWith(true);
        MutableBooleanSet set21 = this.newWith(false);
        Assert.assertFalse(set11.isSubsetOf(set21));
        MutableBooleanSet set12 = this.newWith(false);
        MutableBooleanSet set22 = this.newWith(false);
        Assert.assertTrue(set12.isSubsetOf(set22));
        MutableBooleanSet set13 = this.setWithTrueFalse;
        MutableBooleanSet set23 = this.setWithTrueFalse;
        Assert.assertTrue(set13.isSubsetOf(set23));
        MutableBooleanSet set14 = this.setWithTrueFalse;
        MutableBooleanSet set24 = this.newWith();
        Assert.assertFalse(set14.isSubsetOf(set24));
        MutableBooleanSet set15 = this.newWith();
        MutableBooleanSet set25 = this.setWithTrueFalse;
        Assert.assertTrue(set15.isSubsetOf(set25));
        MutableBooleanSet set16 = this.newWith();
        MutableBooleanSet set26 = this.newWith();
        Assert.assertTrue(set16.isSubsetOf(set26));
    }

    @Test
    public void isProperSubsetOf() {
        MutableBooleanSet set11 = this.newWith(true);
        MutableBooleanSet set21 = this.newWith(false);
        Assert.assertFalse(set11.isProperSubsetOf(set21));
        MutableBooleanSet set12 = this.newWith(false);
        MutableBooleanSet set22 = this.newWith(false);
        Assert.assertFalse(set12.isProperSubsetOf(set22));
        MutableBooleanSet set13 = this.setWithTrue;
        MutableBooleanSet set23 = this.setWithTrueFalse;
        Assert.assertTrue(set13.isProperSubsetOf(set23));
        MutableBooleanSet set14 = this.setWithFalse;
        MutableBooleanSet set24 = this.setWithTrueFalse;
        Assert.assertTrue(set14.isProperSubsetOf(set24));
        MutableBooleanSet set15 = this.setWithTrueFalse;
        MutableBooleanSet set25 = this.newWith();
        Assert.assertFalse(set15.isProperSubsetOf(set25));
        MutableBooleanSet set16 = this.newWith();
        MutableBooleanSet set26 = this.setWithTrueFalse;
        Assert.assertTrue(set16.isProperSubsetOf(set26));
        MutableBooleanSet set17 = this.newWith();
        MutableBooleanSet set27 = this.newWith();
        Assert.assertFalse(set17.isProperSubsetOf(set27));
    }

    @Test
    public void cartesianProduct() {
        MutableBooleanSet set11 = this.setWithTrue;
        MutableBooleanSet set21 = this.setWithFalse;
        MutableSet<BooleanBooleanPair> expected1 = Sets.mutable.with(PrimitiveTuples.pair(true, false));
        Assert.assertEquals(expected1, set11.cartesianProduct(set21).toSet());
        MutableBooleanSet set12 = this.newWith(false);
        MutableBooleanSet set22 = this.newWith(false);
        MutableSet<BooleanBooleanPair> expected2 = Sets.mutable.with(PrimitiveTuples.pair(false, false));
        Assert.assertEquals(expected2, set12.cartesianProduct(set22).toSet());
        MutableBooleanSet set13 = this.setWithTrue;
        MutableBooleanSet set23 = this.setWithTrueFalse;
        MutableSet<BooleanBooleanPair> expected3 = Sets.mutable.with(PrimitiveTuples.pair(true, true), PrimitiveTuples.pair(true, false));
        Assert.assertEquals(expected3, set13.cartesianProduct(set23).toSet());
        MutableBooleanSet set14 = this.setWithFalse;
        MutableBooleanSet set24 = this.setWithTrueFalse;
        MutableSet<BooleanBooleanPair> expected4 = Sets.mutable.with(PrimitiveTuples.pair(false, true), PrimitiveTuples.pair(false, false));
        Assert.assertEquals(expected4, set14.cartesianProduct(set24).toSet());
        MutableBooleanSet set15 = this.setWithTrueFalse;
        MutableBooleanSet set25 = this.newWith();
        Assert.assertEquals(Sets.mutable.empty(), set15.cartesianProduct(set25).toSet());
        MutableBooleanSet set16 = this.newWith();
        MutableBooleanSet set26 = this.setWithTrueFalse;
        Assert.assertEquals(Sets.mutable.empty(), set16.cartesianProduct(set26).toSet());
        MutableBooleanSet set17 = this.newWith();
        MutableBooleanSet set27 = this.newWith();
        Assert.assertEquals(Sets.mutable.empty(), set17.cartesianProduct(set27).toSet());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractBooleanSetTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
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
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
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
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
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
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
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
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll_iterable);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
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
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
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
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
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
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_union() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.union);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_difference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.difference);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifference);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isSubsetOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isProperSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isProperSubsetOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProduct);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractBooleanSetTestCase();
            this.instance.setup();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> iterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> iterator_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> booleanIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanSetTestCase> cartesianProduct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollection = AbstractBooleanSetTestCase::newCollection;
            this.payloads.containsAnyArray = AbstractBooleanSetTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractBooleanSetTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractBooleanSetTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractBooleanSetTestCase::containsNoneIterable;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanSetTestCase::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanSetTestCase::iterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanSetTestCase::iterator_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanSetTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractBooleanSetTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractBooleanSetTestCase::reduceIfEmpty;
            this.payloads.booleanIterator_with_remove = AbstractBooleanSetTestCase::booleanIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractBooleanSetTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractBooleanSetTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.chunk = AbstractBooleanSetTestCase::chunk;
            this.payloads.newCollectionWith = AbstractBooleanSetTestCase::newCollectionWith;
            this.payloads.isEmpty = AbstractBooleanSetTestCase::isEmpty;
            this.payloads.notEmpty = AbstractBooleanSetTestCase::notEmpty;
            this.payloads.clear = AbstractBooleanSetTestCase::clear;
            this.payloads.contains = AbstractBooleanSetTestCase::contains;
            this.payloads.containsAllArray = AbstractBooleanSetTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractBooleanSetTestCase::containsAllIterable;
            this.payloads.add = AbstractBooleanSetTestCase::add;
            this.payloads.addAllArray = AbstractBooleanSetTestCase::addAllArray;
            this.payloads.addAllIterable = AbstractBooleanSetTestCase::addAllIterable;
            this.payloads.remove = AbstractBooleanSetTestCase::remove;
            this.payloads.removeAll = AbstractBooleanSetTestCase::removeAll;
            this.payloads.removeAll_iterable = AbstractBooleanSetTestCase::removeAll_iterable;
            this.payloads.retainAll = AbstractBooleanSetTestCase::retainAll;
            this.payloads.retainAll_iterable = AbstractBooleanSetTestCase::retainAll_iterable;
            this.payloads.with = AbstractBooleanSetTestCase::with;
            this.payloads.withAll = AbstractBooleanSetTestCase::withAll;
            this.payloads.without = AbstractBooleanSetTestCase::without;
            this.payloads.withoutAll = AbstractBooleanSetTestCase::withoutAll;
            this.payloads.toArray = AbstractBooleanSetTestCase::toArray;
            this.payloads.toList = AbstractBooleanSetTestCase::toList;
            this.payloads.toSet = AbstractBooleanSetTestCase::toSet;
            this.payloads.toBag = AbstractBooleanSetTestCase::toBag;
            this.payloads.testEquals = AbstractBooleanSetTestCase::testEquals;
            this.payloads.testHashCode = AbstractBooleanSetTestCase::testHashCode;
            this.payloads.booleanIterator = AbstractBooleanSetTestCase::booleanIterator;
            this.payloads.forEach = AbstractBooleanSetTestCase::forEach;
            this.payloads.injectInto = AbstractBooleanSetTestCase::injectInto;
            this.payloads.size = AbstractBooleanSetTestCase::size;
            this.payloads.count = AbstractBooleanSetTestCase::count;
            this.payloads.anySatisfy = AbstractBooleanSetTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractBooleanSetTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractBooleanSetTestCase::noneSatisfy;
            this.payloads.select = AbstractBooleanSetTestCase::select;
            this.payloads.reject = AbstractBooleanSetTestCase::reject;
            this.payloads.detectIfNone = AbstractBooleanSetTestCase::detectIfNone;
            this.payloads.collect = AbstractBooleanSetTestCase::collect;
            this.payloads.testToString = AbstractBooleanSetTestCase::testToString;
            this.payloads.makeString = AbstractBooleanSetTestCase::makeString;
            this.payloads.appendString = AbstractBooleanSetTestCase::appendString;
            this.payloads.asLazy = AbstractBooleanSetTestCase::asLazy;
            this.payloads.asSynchronized = AbstractBooleanSetTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractBooleanSetTestCase::asUnmodifiable;
            this.payloads.union = AbstractBooleanSetTestCase::union;
            this.payloads.intersect = AbstractBooleanSetTestCase::intersect;
            this.payloads.difference = AbstractBooleanSetTestCase::difference;
            this.payloads.symmetricDifference = AbstractBooleanSetTestCase::symmetricDifference;
            this.payloads.isSubsetOf = AbstractBooleanSetTestCase::isSubsetOf;
            this.payloads.isProperSubsetOf = AbstractBooleanSetTestCase::isProperSubsetOf;
            this.payloads.cartesianProduct = AbstractBooleanSetTestCase::cartesianProduct;
        }
    }
*/
}
