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
import org.eclipse.collections.api.set.primitive.ImmutableLongSet;
import org.eclipse.collections.api.set.primitive.MutableLongSet;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableLongHashSetTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;

/**
 * JUnit test for {@link ImmutableLongSet} created from the freeze() method.
 * This file was automatically generated from template file frozenPrimitiveSetTest.stg.
 */
public class FrozenLongHashSetTest extends AbstractImmutableLongHashSetTestCase {

    @Override
    protected ImmutableLongSet classUnderTest() {
        return (ImmutableLongSet) LongHashSet.newSetWith(1L, 2L, 3L).freeze();
    }

    @Override
    protected ImmutableLongSet newWith(long... elements) {
        return (ImmutableLongSet) LongHashSet.newSetWith(elements).freeze();
    }

    @Override
    protected MutableLongSet newMutableCollectionWith(long... elements) {
        return LongHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Long> newObjectCollectionWith(Long... elements) {
        return UnifiedSet.newSetWith(elements);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableLongHashSetTestCase._Benchmark {

        private FrozenLongHashSetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new FrozenLongHashSetTest();
        }

        @java.lang.Override
        public FrozenLongHashSetTest implementation() {
            return this.implementation;
        }
    }
}
