/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.immutable.primitive;

import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.primitive.ImmutableByteSet;
import org.eclipse.collections.api.set.primitive.MutableByteSet;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableByteHashSetTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;

/**
 * JUnit test for {@link ImmutableByteSet} created from the freeze() method.
 * This file was automatically generated from template file frozenPrimitiveSetTest.stg.
 */
public class FrozenByteHashSetTest extends AbstractImmutableByteHashSetTestCase {

    @Override
    protected ImmutableByteSet classUnderTest() {
        return (ImmutableByteSet) ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3).freeze();
    }

    @Override
    protected ImmutableByteSet newWith(byte... elements) {
        return (ImmutableByteSet) ByteHashSet.newSetWith(elements).freeze();
    }

    @Override
    protected MutableByteSet newMutableCollectionWith(byte... elements) {
        return ByteHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Byte> newObjectCollectionWith(Byte... elements) {
        return UnifiedSet.newSetWith(elements);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableByteHashSetTestCase._Benchmark {

        private FrozenByteHashSetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new FrozenByteHashSetTest();
        }

        @java.lang.Override
        public FrozenByteHashSetTest implementation() {
            return this.implementation;
        }
    }
}
