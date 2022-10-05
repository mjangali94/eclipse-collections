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
import org.eclipse.collections.api.set.primitive.ImmutableDoubleSet;
import org.eclipse.collections.api.set.primitive.MutableDoubleSet;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableDoubleHashSetTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;

/**
 * JUnit test for {@link ImmutableDoubleSet} created from the freeze() method.
 * This file was automatically generated from template file frozenPrimitiveSetTest.stg.
 */
public class FrozenDoubleHashSetTest extends AbstractImmutableDoubleHashSetTestCase {

    @Override
    protected ImmutableDoubleSet classUnderTest() {
        return (ImmutableDoubleSet) DoubleHashSet.newSetWith(1.0, 2.0, 3.0).freeze();
    }

    @Override
    protected ImmutableDoubleSet newWith(double... elements) {
        return (ImmutableDoubleSet) DoubleHashSet.newSetWith(elements).freeze();
    }

    @Override
    protected MutableDoubleSet newMutableCollectionWith(double... elements) {
        return DoubleHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Double> newObjectCollectionWith(Double... elements) {
        return UnifiedSet.newSetWith(elements);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableDoubleHashSetTestCase._Benchmark {

        private FrozenDoubleHashSetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new FrozenDoubleHashSetTest();
        }

        @java.lang.Override
        public FrozenDoubleHashSetTest implementation() {
            return this.implementation;
        }
    }
}
