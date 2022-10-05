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
 * This file was automatically generated from template file immutablePrimitiveKeySetTest.stg.
 */
public class ImmutableLongMapKeySetTest extends AbstractImmutableLongHashSetTestCase {

    @Override
    protected ImmutableLongSet classUnderTest() {
        return (ImmutableLongSet) LongByteHashMap.newWithKeysValues(1L, (byte) -1, 2L, (byte) 2, 3L, (byte) 4).keySet().freeze();
    }

    @Override
    protected ImmutableLongSet newWith(long... elements) {
        LongByteHashMap longByteHashMap = new LongByteHashMap();
        for (long element : elements) {
            longByteHashMap.put(element, (byte) 0);
        }
        return (ImmutableLongSet) longByteHashMap.keySet().freeze();
    }

    @Override
    public void contains() {
        super.contains();
        long collision1 = AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst();
        long collision2 = AbstractImmutableLongHashSetTestCase.generateCollisions().get(1);
        LongByteHashMap longByteHashMap = LongByteHashMap.newWithKeysValues(collision1, (byte) 0, collision2, (byte) 0);
        longByteHashMap.removeKey(collision2);
        LongSet longSet = longByteHashMap.keySet().freeze();
        Assert.assertTrue(longSet.contains(collision1));
        Assert.assertFalse(longSet.contains(collision2));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableLongHashSetTestCase._Benchmark {

        private ImmutableLongMapKeySetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableLongMapKeySetTest();
        }

        @java.lang.Override
        public ImmutableLongMapKeySetTest implementation() {
            return this.implementation;
        }
    }
}
