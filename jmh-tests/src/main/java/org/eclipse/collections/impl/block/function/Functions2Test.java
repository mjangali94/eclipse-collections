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

import java.io.IOException;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.tuple.Twin;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.Functions2;
import org.eclipse.collections.impl.block.function.checked.ThrowingFunction2;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Test;

public class Functions2Test {

    @Test
    public void throwing() {
        Verify.assertThrowsWithCause(RuntimeException.class, IOException.class, () -> Functions2.throwing((a, b) -> {
            throw new IOException();
        }).value(null, null));
    }

    @Test
    public void throwingWithSuccessfulCompletion() {
        ThrowingFunction2<String, String, String> throwingFunction2 = (argument1, argument2) -> argument1.concat(argument2);
        Assert.assertEquals("abcdef", Functions2.throwing(throwingFunction2).value("abc", "def"));
    }

    @Test
    public void min() {
        Function2<Integer, Integer, Integer> minFunction = Functions2.min(Comparators.naturalOrder());
        Assert.assertEquals(Integer.valueOf(1), minFunction.value(5, 1));
        Assert.assertEquals(Integer.valueOf(1), minFunction.value(1, 5));
        Assert.assertEquals(Integer.valueOf(2), minFunction.value(2, 2));
    }

    @Test
    public void max() {
        Function2<Integer, Integer, Integer> maxFunction = Functions2.max(Comparators.naturalOrder());
        Assert.assertEquals(Integer.valueOf(5), maxFunction.value(5, 1));
        Assert.assertEquals(Integer.valueOf(5), maxFunction.value(1, 5));
        Assert.assertEquals(Integer.valueOf(5), maxFunction.value(5, 5));
    }

    @Test
    public void minBy() {
        Function2<Twin<Integer>, Twin<Integer>, Twin<Integer>> minBy = Functions2.minBy(Functions.firstOfPair());
        Twin<Integer> twinOne = Tuples.twin(1, 5);
        Twin<Integer> twinTwo = Tuples.twin(0, 10);
        Assert.assertEquals(twinTwo, minBy.value(twinOne, twinTwo));
        Assert.assertEquals(twinTwo, minBy.value(twinTwo, twinOne));
        Assert.assertEquals(twinOne, minBy.value(twinOne, twinOne));
    }

    @Test
    public void maxBy() {
        Function2<Twin<Integer>, Twin<Integer>, Twin<Integer>> minBy = Functions2.maxBy(Functions.firstOfPair());
        Twin<Integer> twinOne = Tuples.twin(1, 5);
        Twin<Integer> twinTwo = Tuples.twin(0, 10);
        Assert.assertEquals(twinOne, minBy.value(twinOne, twinTwo));
        Assert.assertEquals(twinOne, minBy.value(twinTwo, twinOne));
        Assert.assertEquals(twinOne, minBy.value(twinOne, twinOne));
    }

    @Test
    public void throwingWithUserSpecifiedException() {
        Verify.assertThrowsWithCause(RuntimeException.class, IOException.class, () -> {
            Functions2.throwing((one, two) -> {
                throw new IOException();
            }, (one, two, ce) -> new RuntimeException(ce)).value(null, null);
        });
        Verify.assertThrowsWithCause(MyRuntimeException.class, IOException.class, () -> {
            Functions2.throwing((one, two) -> {
                throw new IOException();
            }, this::throwMyException).value(null, null);
        });
        Assert.assertThrows(NullPointerException.class, () -> {
            Functions2.throwing((one, two) -> {
                throw new NullPointerException();
            }, this::throwMyException).value(null, null);
        });
    }

    private MyRuntimeException throwMyException(Object one, Object two, Throwable exception) {
        return new MyRuntimeException(String.valueOf(one) + two, exception);
    }

    @Test
    public void asFunction2Function() {
        Function2<Integer, Object, String> block = Functions2.fromFunction(String::valueOf);
        Assert.assertEquals("1", block.value(1, null));
    }

    @Test
    public void plusInteger() {
        Function2<Integer, Integer, Integer> plusInteger = Functions2.integerAddition();
        Assert.assertEquals(Integer.valueOf(5), plusInteger.value(2, 3));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(Functions2.class);
    }

    private static class MyRuntimeException extends RuntimeException {

        MyRuntimeException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private Functions2Test instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_throwing() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.throwing);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_throwingWithSuccessfulCompletion() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.throwingWithSuccessfulCompletion);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_throwingWithUserSpecifiedException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.throwingWithUserSpecifiedException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asFunction2Function() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asFunction2Function);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_plusInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.plusInteger);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<Functions2Test> payload) throws java.lang.Throwable {
            this.instance = new Functions2Test();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Functions2Test> throwing;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Functions2Test> throwingWithSuccessfulCompletion;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Functions2Test> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Functions2Test> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Functions2Test> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Functions2Test> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Functions2Test> throwingWithUserSpecifiedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Functions2Test> asFunction2Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Functions2Test> plusInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Functions2Test> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.throwing = Functions2Test::throwing;
            this.payloads.throwingWithSuccessfulCompletion = Functions2Test::throwingWithSuccessfulCompletion;
            this.payloads.min = Functions2Test::min;
            this.payloads.max = Functions2Test::max;
            this.payloads.minBy = Functions2Test::minBy;
            this.payloads.maxBy = Functions2Test::maxBy;
            this.payloads.throwingWithUserSpecifiedException = Functions2Test::throwingWithUserSpecifiedException;
            this.payloads.asFunction2Function = Functions2Test::asFunction2Function;
            this.payloads.plusInteger = Functions2Test::plusInteger;
            this.payloads.classIsNonInstantiable = Functions2Test::classIsNonInstantiable;
        }
    }
}
