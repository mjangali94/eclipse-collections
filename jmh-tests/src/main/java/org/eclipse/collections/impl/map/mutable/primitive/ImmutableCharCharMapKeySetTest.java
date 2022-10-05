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

import org.eclipse.collections.api.set.primitive.CharSet;
import org.eclipse.collections.api.set.primitive.ImmutableCharSet;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableCharHashSetTestCase;
import org.junit.Assert;

/**
 * JUnit test for {@link ImmutableCharSet} created from the freeze() method.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapKeySetTest.stg.
 */
public class ImmutableCharCharMapKeySetTest extends AbstractImmutableCharHashSetTestCase {

    @Override
    protected ImmutableCharSet classUnderTest() {
        return (ImmutableCharSet) CharCharHashMap.newWithKeysValues((char) 1, (char) -1, (char) 2, (char) 2, (char) 3, (char) 4).keySet().freeze();
    }

    @Override
    protected ImmutableCharSet newWith(char... elements) {
        CharCharHashMap charCharHashMap = new CharCharHashMap();
        for (char element : elements) {
            charCharHashMap.put(element, element);
        }
        return (ImmutableCharSet) charCharHashMap.keySet().freeze();
    }

    @Override
    public void contains() {
        super.contains();
        char collision1 = AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst();
        char collision2 = AbstractImmutableCharHashSetTestCase.generateCollisions().get(1);
        CharCharHashMap charCharHashMap = CharCharHashMap.newWithKeysValues(collision1, collision1, collision2, collision2);
        charCharHashMap.removeKey(collision2);
        CharSet charSet = charCharHashMap.keySet().freeze();
        Assert.assertTrue(charSet.contains(collision1));
        Assert.assertFalse(charSet.contains(collision2));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableCharHashSetTestCase._Benchmark {

        private ImmutableCharCharMapKeySetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableCharCharMapKeySetTest();
        }

        @java.lang.Override
        public ImmutableCharCharMapKeySetTest implementation() {
            return this.implementation;
        }
    }
}
