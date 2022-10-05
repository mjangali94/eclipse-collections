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

import org.eclipse.collections.api.set.primitive.LongSet;
import org.eclipse.collections.api.set.primitive.ImmutableLongSet;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableLongHashSetTestCase;
import org.junit.Assert;

/**
 * JUnit test for {@link ImmutableLongSet} created from the freeze() method.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapKeySetTest.stg.
 */
public class ImmutableLongLongMapKeySetTest extends AbstractImmutableLongHashSetTestCase {

    @Override
    protected ImmutableLongSet classUnderTest() {
        return (ImmutableLongSet) LongLongHashMap.newWithKeysValues(1L, -1L, 2L, 2L, 3L, 4L).keySet().freeze();
    }

    @Override
    protected ImmutableLongSet newWith(long... elements) {
        LongLongHashMap longLongHashMap = new LongLongHashMap();
        for (long element : elements) {
            longLongHashMap.put(element, element);
        }
        return (ImmutableLongSet) longLongHashMap.keySet().freeze();
    }

    @Override
    public void contains() {
        super.contains();
        long collision1 = AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst();
        long collision2 = AbstractImmutableLongHashSetTestCase.generateCollisions().get(1);
        LongLongHashMap longLongHashMap = LongLongHashMap.newWithKeysValues(collision1, collision1, collision2, collision2);
        longLongHashMap.removeKey(collision2);
        LongSet longSet = longLongHashMap.keySet().freeze();
        Assert.assertTrue(longSet.contains(collision1));
        Assert.assertFalse(longSet.contains(collision2));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableLongHashSetTestCase._Benchmark {

        private ImmutableLongLongMapKeySetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableLongLongMapKeySetTest();
        }

        @java.lang.Override
        public ImmutableLongLongMapKeySetTest implementation() {
            return this.implementation;
        }
    }
}
