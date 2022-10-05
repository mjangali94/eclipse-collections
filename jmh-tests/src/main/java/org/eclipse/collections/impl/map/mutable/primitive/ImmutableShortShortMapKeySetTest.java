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
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapKeySetTest.stg.
 */
public class ImmutableShortShortMapKeySetTest extends AbstractImmutableShortHashSetTestCase {

    @Override
    protected ImmutableShortSet classUnderTest() {
        return (ImmutableShortSet) ShortShortHashMap.newWithKeysValues((short) 1, (short) -1, (short) 2, (short) 2, (short) 3, (short) 4).keySet().freeze();
    }

    @Override
    protected ImmutableShortSet newWith(short... elements) {
        ShortShortHashMap shortShortHashMap = new ShortShortHashMap();
        for (short element : elements) {
            shortShortHashMap.put(element, element);
        }
        return (ImmutableShortSet) shortShortHashMap.keySet().freeze();
    }

    @Override
    public void contains() {
        super.contains();
        short collision1 = AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst();
        short collision2 = AbstractImmutableShortHashSetTestCase.generateCollisions().get(1);
        ShortShortHashMap shortShortHashMap = ShortShortHashMap.newWithKeysValues(collision1, collision1, collision2, collision2);
        shortShortHashMap.removeKey(collision2);
        ShortSet shortSet = shortShortHashMap.keySet().freeze();
        Assert.assertTrue(shortSet.contains(collision1));
        Assert.assertFalse(shortSet.contains(collision2));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableShortHashSetTestCase._Benchmark {

        private ImmutableShortShortMapKeySetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableShortShortMapKeySetTest();
        }

        @java.lang.Override
        public ImmutableShortShortMapKeySetTest implementation() {
            return this.implementation;
        }
    }
}
