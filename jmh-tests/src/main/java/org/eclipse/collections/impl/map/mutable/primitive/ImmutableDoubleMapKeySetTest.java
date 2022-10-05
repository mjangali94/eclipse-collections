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

import org.eclipse.collections.api.set.primitive.DoubleSet;
import org.eclipse.collections.api.set.primitive.ImmutableDoubleSet;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableDoubleHashSetTestCase;
import org.junit.Assert;

/**
 * JUnit test for {@link ImmutableDoubleSet} created from the freeze() method.
 * This file was automatically generated from template file immutablePrimitiveKeySetTest.stg.
 */
public class ImmutableDoubleMapKeySetTest extends AbstractImmutableDoubleHashSetTestCase {

    @Override
    protected ImmutableDoubleSet classUnderTest() {
        return (ImmutableDoubleSet) DoubleByteHashMap.newWithKeysValues(1.0, (byte) -1, 2.0, (byte) 2, 3.0, (byte) 4).keySet().freeze();
    }

    @Override
    protected ImmutableDoubleSet newWith(double... elements) {
        DoubleByteHashMap doubleByteHashMap = new DoubleByteHashMap();
        for (double element : elements) {
            doubleByteHashMap.put(element, (byte) 0);
        }
        return (ImmutableDoubleSet) doubleByteHashMap.keySet().freeze();
    }

    @Override
    public void contains() {
        super.contains();
        double collision1 = AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst();
        double collision2 = AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1);
        DoubleByteHashMap doubleByteHashMap = DoubleByteHashMap.newWithKeysValues(collision1, (byte) 0, collision2, (byte) 0);
        doubleByteHashMap.removeKey(collision2);
        DoubleSet doubleSet = doubleByteHashMap.keySet().freeze();
        Assert.assertTrue(doubleSet.contains(collision1));
        Assert.assertFalse(doubleSet.contains(collision2));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableDoubleHashSetTestCase._Benchmark {

        private ImmutableDoubleMapKeySetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableDoubleMapKeySetTest();
        }

        @java.lang.Override
        public ImmutableDoubleMapKeySetTest implementation() {
            return this.implementation;
        }
    }
}
