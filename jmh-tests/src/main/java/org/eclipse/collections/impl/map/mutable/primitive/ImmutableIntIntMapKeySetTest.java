/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable.primitive;

import org.eclipse.collections.api.set.primitive.IntSet;
import org.eclipse.collections.api.set.primitive.ImmutableIntSet;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableIntHashSetTestCase;
import org.junit.Assert;

/**
 * JUnit test for {@link ImmutableIntSet} created from the freeze() method.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapKeySetTest.stg.
 */
public class ImmutableIntIntMapKeySetTest extends AbstractImmutableIntHashSetTestCase {

    @Override
    protected ImmutableIntSet classUnderTest() {
        return (ImmutableIntSet) IntIntHashMap.newWithKeysValues(1, -1, 2, 2, 3, 4).keySet().freeze();
    }

    @Override
    protected ImmutableIntSet newWith(int... elements) {
        IntIntHashMap intIntHashMap = new IntIntHashMap();
        for (int element : elements) {
            intIntHashMap.put(element, element);
        }
        return (ImmutableIntSet) intIntHashMap.keySet().freeze();
    }

    @Override
    public void contains() {
        super.contains();
        int collision1 = AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst();
        int collision2 = AbstractImmutableIntHashSetTestCase.generateCollisions().get(1);
        IntIntHashMap intIntHashMap = IntIntHashMap.newWithKeysValues(collision1, collision1, collision2, collision2);
        intIntHashMap.removeKey(collision2);
        IntSet intSet = intIntHashMap.keySet().freeze();
        Assert.assertTrue(intSet.contains(collision1));
        Assert.assertFalse(intSet.contains(collision2));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableIntHashSetTestCase._Benchmark {

        private ImmutableIntIntMapKeySetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableIntIntMapKeySetTest();
        }

        @java.lang.Override
        public ImmutableIntIntMapKeySetTest implementation() {
            return this.implementation;
        }
    }
}
