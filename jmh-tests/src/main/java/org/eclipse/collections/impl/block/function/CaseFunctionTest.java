/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.function;

import java.util.Objects;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class CaseFunctionTest {

    @Test
    public void noopCase() {
        Function<Integer, Integer> function = new CaseFunction<>();
        Assert.assertNull(function.valueOf(42));
    }

    @Test
    public void basicCase() {
        CaseFunction<Integer, Integer> function = new CaseFunction<>();
        function.addCase(ignored -> true, Functions.getIntegerPassThru());
        Integer fortyTwo = 42;
        Assert.assertEquals(fortyTwo, function.valueOf(fortyTwo));
    }

    @Test
    public void defaultValue() {
        CaseFunction<Foo, String> function = Functions.caseDefault(Functions.getFixedValue("Yow!"), Predicates.attributeGreaterThan(Foo.TO_VALUE, 5.0D), Functions.getFixedValue("Patience, grasshopper"));
        Assert.assertEquals("Yow!", function.valueOf(new Foo("", 1.0D)));
        CaseFunction<Foo, String> function1 = function.setDefault(Functions.getFixedValue("Patience, young grasshopper"));
        Assert.assertSame(function, function1);
        Assert.assertEquals("Patience, grasshopper", function.valueOf(new Foo("", 6.0D)));
        Assert.assertEquals("Patience, young grasshopper", function.valueOf(new Foo("", 1.0D)));
        Verify.assertContains("CaseFunction", function.toString());
    }

    public static final class Foo implements Comparable<Foo> {

        public static final Function<Foo, Double> TO_VALUE = foo -> foo.value;

        private final String description;

        private final double value;

        private Foo(String description, double value) {
            this.description = description;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }
            Foo foo = (Foo) o;
            if (Double.compare(foo.value, this.value) != 0) {
                return false;
            }
            return Objects.equals(this.description, foo.description);
        }

        @Override
        public int hashCode() {
            int result = this.description == null ? 0 : this.description.hashCode();
            long l = Double.doubleToLongBits(this.value);
            result = 31 * result + (int) (l ^ l >>> 32);
            return result;
        }

        @Override
        public int compareTo(Foo o) {
            throw new RuntimeException("compareTo not implemented");
        }
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CaseFunctionTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noopCase() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noopCase);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_basicCase() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.basicCase);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_defaultValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.defaultValue);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CaseFunctionTest> payload) throws java.lang.Throwable {
            this.instance = new CaseFunctionTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CaseFunctionTest> noopCase;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CaseFunctionTest> basicCase;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CaseFunctionTest> defaultValue;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.noopCase = CaseFunctionTest::noopCase;
            this.payloads.basicCase = CaseFunctionTest::basicCase;
            this.payloads.defaultValue = CaseFunctionTest::defaultValue;
        }
    }
}
