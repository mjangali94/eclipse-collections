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
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapKeySetTest.stg.
 */
public class ImmutableDoubleDoubleMapKeySetTest extends AbstractImmutableDoubleHashSetTestCase {

    @Override
    protected ImmutableDoubleSet classUnderTest() {
        return (ImmutableDoubleSet) DoubleDoubleHashMap.newWithKeysValues(1.0, -1.0, 2.0, 2.0, 3.0, 4.0).keySet().freeze();
    }

    @Override
    protected ImmutableDoubleSet newWith(double... elements) {
        DoubleDoubleHashMap doubleDoubleHashMap = new DoubleDoubleHashMap();
        for (double element : elements) {
            doubleDoubleHashMap.put(element, element);
        }
        return (ImmutableDoubleSet) doubleDoubleHashMap.keySet().freeze();
    }

    @Override
    public void contains() {
        super.contains();
        double collision1 = AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst();
        double collision2 = AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1);
        DoubleDoubleHashMap doubleDoubleHashMap = DoubleDoubleHashMap.newWithKeysValues(collision1, collision1, collision2, collision2);
        doubleDoubleHashMap.removeKey(collision2);
        DoubleSet doubleSet = doubleDoubleHashMap.keySet().freeze();
        Assert.assertTrue(doubleSet.contains(collision1));
        Assert.assertFalse(doubleSet.contains(collision2));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableDoubleHashSetTestCase._Benchmark {

        private ImmutableDoubleDoubleMapKeySetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableDoubleDoubleMapKeySetTest();
        }

        @java.lang.Override
        public ImmutableDoubleDoubleMapKeySetTest implementation() {
            return this.implementation;
        }
    }
}
