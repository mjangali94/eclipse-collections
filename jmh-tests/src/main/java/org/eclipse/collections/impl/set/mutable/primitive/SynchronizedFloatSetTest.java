/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.mutable.primitive;

import org.eclipse.collections.api.set.primitive.MutableFloatSet;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedFloatSet}.
 * This file was automatically generated from template file synchronizedPrimitiveSetTest.stg.
 */
public class SynchronizedFloatSetTest extends AbstractFloatSetTestCase {

    @Override
    protected SynchronizedFloatSet classUnderTest() {
        return new SynchronizedFloatSet(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f));
    }

    @Override
    protected SynchronizedFloatSet newWith(float... elements) {
        return new SynchronizedFloatSet(FloatHashSet.newSetWith(elements));
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        SynchronizedFloatSet set = this.classUnderTest();
        MutableFloatSet setWithLockObject = new SynchronizedFloatSet(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f), new Object());
        Assert.assertEquals(set, setWithLockObject);
        Assert.assertSame(setWithLockObject, setWithLockObject.asSynchronized());
        Assert.assertSame(set, set.asSynchronized());
        Assert.assertEquals(set, set.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.set.mutable.primitive.AbstractFloatSetTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedFloatSetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedFloatSetTest();
        }

        @java.lang.Override
        public SynchronizedFloatSetTest implementation() {
            return this.implementation;
        }
    }
}
