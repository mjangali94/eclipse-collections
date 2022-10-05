/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.immutable.primitive;

import org.eclipse.collections.api.bag.primitive.ImmutableFloatBag;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.factory.primitive.FloatBags;
import org.eclipse.collections.impl.math.MutableFloat;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.impl.factory.primitive.FloatSets;
import org.eclipse.collections.api.set.primitive.ImmutableFloatSet;

/**
 * JUnit test for {@link ImmutableFloatSingletonBag}.
 * This file was automatically generated from template file immutablePrimitiveSingletonBagTest.stg.
 */
public class ImmutableFloatSingletonBagTest extends AbstractImmutableFloatBagTestCase {

    @Override
    protected final ImmutableFloatBag classUnderTest() {
        return FloatBags.immutable.of(1.0f);
    }

    @Override
    @Test
    public void forEachWithOccurrences() {
        StringBuilder stringBuilder = new StringBuilder();
        this.classUnderTest().forEachWithOccurrences((float argument1, int argument2) -> stringBuilder.append(argument1).append(argument2));
        String string = stringBuilder.toString();
        Assert.assertEquals("1.01", string);
    }

    @Override
    @Test
    public void selectByOccurrences() {
        ImmutableFloatSingletonBag bag = new ImmutableFloatSingletonBag(1.0f);
        ImmutableFloatBag filtered1 = bag.selectByOccurrences(i -> i > 0);
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f), filtered1);
        ImmutableFloatBag filtered2 = bag.selectByOccurrences(i -> i > 1);
        Assert.assertEquals(FloatBags.immutable.empty(), filtered2);
    }

    @Override
    @Test
    public void selectDuplicates() {
        ImmutableFloatSingletonBag bag = new ImmutableFloatSingletonBag(1.0f);
        Assert.assertEquals(FloatHashBag.newBagWith(), bag.selectDuplicates());
    }

    @Override
    @Test
    public void selectUnique() {
        super.selectUnique();
        ImmutableFloatBag bag = this.classUnderTest();
        ImmutableFloatSet expected = FloatSets.immutable.with(1.0f);
        ImmutableFloatSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        ImmutableFloatSingletonBag iterable = new ImmutableFloatSingletonBag(1.0f);
        MutableFloat result = iterable.injectInto(new MutableFloat(1.0f), MutableFloat::add);
        Assert.assertEquals(new MutableFloat(2.0f), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.bag.immutable.primitive.AbstractImmutableFloatBagTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWithOccurrences, this.description("forEachWithOccurrences"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectByOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectByOccurrences, this.description("selectByOccurrences"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectDuplicates() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectDuplicates, this.description("selectDuplicates"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectUnique, this.description("selectUnique"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectInto, this.description("injectInto"));
        }

        private ImmutableFloatSingletonBagTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableFloatSingletonBagTest();
        }

        @java.lang.Override
        public ImmutableFloatSingletonBagTest implementation() {
            return this.implementation;
        }
    }
}
