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
 * This file was automatically generated from template file immutablePrimitiveKeySetTest.stg.
 */
public class ImmutableCharMapKeySetTest extends AbstractImmutableCharHashSetTestCase {

    @Override
    protected ImmutableCharSet classUnderTest() {
        return (ImmutableCharSet) CharByteHashMap.newWithKeysValues((char) 1, (byte) -1, (char) 2, (byte) 2, (char) 3, (byte) 4).keySet().freeze();
    }

    @Override
    protected ImmutableCharSet newWith(char... elements) {
        CharByteHashMap charByteHashMap = new CharByteHashMap();
        for (char element : elements) {
            charByteHashMap.put(element, (byte) 0);
        }
        return (ImmutableCharSet) charByteHashMap.keySet().freeze();
    }

    @Override
    public void contains() {
        super.contains();
        char collision1 = AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst();
        char collision2 = AbstractImmutableCharHashSetTestCase.generateCollisions().get(1);
        CharByteHashMap charByteHashMap = CharByteHashMap.newWithKeysValues(collision1, (byte) 0, collision2, (byte) 0);
        charByteHashMap.removeKey(collision2);
        CharSet charSet = charByteHashMap.keySet().freeze();
        Assert.assertTrue(charSet.contains(collision1));
        Assert.assertFalse(charSet.contains(collision2));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableCharHashSetTestCase._Benchmark {

        private ImmutableCharMapKeySetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableCharMapKeySetTest();
        }

        @java.lang.Override
        public ImmutableCharMapKeySetTest implementation() {
            return this.implementation;
        }
    }
}
