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

import org.eclipse.collections.api.set.primitive.FloatSet;
import org.eclipse.collections.api.set.primitive.ImmutableFloatSet;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableFloatHashSetTestCase;
import org.junit.Assert;

/**
 * JUnit test for {@link ImmutableFloatSet} created from the freeze() method.
 * This file was automatically generated from template file immutablePrimitiveKeySetTest.stg.
 */
public class ImmutableFloatMapKeySetTest extends AbstractImmutableFloatHashSetTestCase {

    @Override
    protected ImmutableFloatSet classUnderTest() {
        return (ImmutableFloatSet) FloatByteHashMap.newWithKeysValues(1.0f, (byte) -1, 2.0f, (byte) 2, 3.0f, (byte) 4).keySet().freeze();
    }

    @Override
    protected ImmutableFloatSet newWith(float... elements) {
        FloatByteHashMap floatByteHashMap = new FloatByteHashMap();
        for (float element : elements) {
            floatByteHashMap.put(element, (byte) 0);
        }
        return (ImmutableFloatSet) floatByteHashMap.keySet().freeze();
    }

    @Override
    public void contains() {
        super.contains();
        float collision1 = AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst();
        float collision2 = AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1);
        FloatByteHashMap floatByteHashMap = FloatByteHashMap.newWithKeysValues(collision1, (byte) 0, collision2, (byte) 0);
        floatByteHashMap.removeKey(collision2);
        FloatSet floatSet = floatByteHashMap.keySet().freeze();
        Assert.assertTrue(floatSet.contains(collision1));
        Assert.assertFalse(floatSet.contains(collision2));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableFloatHashSetTestCase._Benchmark {

        private ImmutableFloatMapKeySetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableFloatMapKeySetTest();
        }

        @java.lang.Override
        public ImmutableFloatMapKeySetTest implementation() {
            return this.implementation;
        }
    }
}
