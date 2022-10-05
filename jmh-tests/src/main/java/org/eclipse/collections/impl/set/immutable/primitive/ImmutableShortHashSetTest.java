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
import org.eclipse.collections.api.set.primitive.ImmutableShortSet;
import org.eclipse.collections.api.set.primitive.MutableShortSet;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableShortHashSetTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;

/**
 * JUnit test for {@link ImmutableShortHashSet}.
 * This file was automatically generated from template file immutablePrimitiveHashSetTest.stg.
 */
public class ImmutableShortHashSetTest extends AbstractImmutableShortHashSetTestCase {

    @Override
    protected ImmutableShortSet classUnderTest() {
        return ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3).toImmutable();
    }

    @Override
    protected ImmutableShortSet newWith(short... elements) {
        return ShortHashSet.newSetWith(elements).toImmutable();
    }

    @Override
    protected MutableShortSet newMutableCollectionWith(short... elements) {
        return ShortHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Short> newObjectCollectionWith(Short... elements) {
        return UnifiedSet.newSetWith(elements);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableShortHashSetTestCase._Benchmark {

        private ImmutableShortHashSetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableShortHashSetTest();
        }

        @java.lang.Override
        public ImmutableShortHashSetTest implementation() {
            return this.implementation;
        }
    }
}
