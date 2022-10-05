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
import org.eclipse.collections.api.set.primitive.ImmutableFloatSet;
import org.eclipse.collections.api.set.primitive.MutableFloatSet;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableFloatHashSetTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;

/**
 * JUnit test for {@link ImmutableFloatSet} created from the freeze() method.
 * This file was automatically generated from template file frozenPrimitiveSetTest.stg.
 */
public class FrozenFloatHashSetTest extends AbstractImmutableFloatHashSetTestCase {

    @Override
    protected ImmutableFloatSet classUnderTest() {
        return (ImmutableFloatSet) FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f).freeze();
    }

    @Override
    protected ImmutableFloatSet newWith(float... elements) {
        return (ImmutableFloatSet) FloatHashSet.newSetWith(elements).freeze();
    }

    @Override
    protected MutableFloatSet newMutableCollectionWith(float... elements) {
        return FloatHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Float> newObjectCollectionWith(Float... elements) {
        return UnifiedSet.newSetWith(elements);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableFloatHashSetTestCase._Benchmark {

        private FrozenFloatHashSetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new FrozenFloatHashSetTest();
        }

        @java.lang.Override
        public FrozenFloatHashSetTest implementation() {
            return this.implementation;
        }
    }
}
