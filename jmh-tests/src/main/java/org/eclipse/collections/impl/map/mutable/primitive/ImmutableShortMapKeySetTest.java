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

import org.eclipse.collections.api.set.primitive.ShortSet;
import org.eclipse.collections.api.set.primitive.ImmutableShortSet;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableShortHashSetTestCase;
import org.junit.Assert;

/**
 * JUnit test for {@link ImmutableShortSet} created from the freeze() method.
 * This file was automatically generated from template file immutablePrimitiveKeySetTest.stg.
 */
public class ImmutableShortMapKeySetTest extends AbstractImmutableShortHashSetTestCase {

    @Override
    protected ImmutableShortSet classUnderTest() {
        return (ImmutableShortSet) ShortByteHashMap.newWithKeysValues((short) 1, (byte) -1, (short) 2, (byte) 2, (short) 3, (byte) 4).keySet().freeze();
    }

    @Override
    protected ImmutableShortSet newWith(short... elements) {
        ShortByteHashMap shortByteHashMap = new ShortByteHashMap();
        for (short element : elements) {
            shortByteHashMap.put(element, (byte) 0);
        }
        return (ImmutableShortSet) shortByteHashMap.keySet().freeze();
    }

    @Override
    public void contains() {
        super.contains();
        short collision1 = AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst();
        short collision2 = AbstractImmutableShortHashSetTestCase.generateCollisions().get(1);
        ShortByteHashMap shortByteHashMap = ShortByteHashMap.newWithKeysValues(collision1, (byte) 0, collision2, (byte) 0);
        shortByteHashMap.removeKey(collision2);
        ShortSet shortSet = shortByteHashMap.keySet().freeze();
        Assert.assertTrue(shortSet.contains(collision1));
        Assert.assertFalse(shortSet.contains(collision2));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableShortHashSetTestCase._Benchmark {

        private ImmutableShortMapKeySetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableShortMapKeySetTest();
        }

        @java.lang.Override
        public ImmutableShortMapKeySetTest implementation() {
            return this.implementation;
        }
    }
}
