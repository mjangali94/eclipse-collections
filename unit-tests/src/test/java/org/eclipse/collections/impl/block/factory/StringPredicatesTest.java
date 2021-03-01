/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.factory;

import org.eclipse.collections.api.block.predicate.Predicate;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class StringPredicatesTest {

    @Test
    public void startsWith() {
        Assert.assertFalse(StringPredicates.startsWith("Hello").accept(null));
        Assert.assertTrue(StringPredicates.startsWith("Hello").accept("HelloWorld"));
        Assert.assertFalse(StringPredicates.startsWith("World").accept("HelloWorld"));
        Assert.assertEquals("StringPredicates.startsWith(\"Hello\")", StringPredicates.startsWith("Hello").toString());
    }

    @Test
    public void endsWith() {
        Assert.assertFalse(StringPredicates.endsWith("Hello").accept(null));
        Assert.assertFalse(StringPredicates.endsWith("Hello").accept("HelloWorld"));
        Assert.assertTrue(StringPredicates.endsWith("World").accept("HelloWorld"));
        Assert.assertEquals("StringPredicates.endsWith(\"Hello\")", StringPredicates.endsWith("Hello").toString());
    }

    @Test
    public void equalsIgnoreCase() {
        Assert.assertFalse(StringPredicates.equalsIgnoreCase("HELLO").accept(null));
        Assert.assertTrue(StringPredicates.equalsIgnoreCase("HELLO").accept("hello"));
        Assert.assertTrue(StringPredicates.equalsIgnoreCase("world").accept("WORLD"));
        Assert.assertFalse(StringPredicates.equalsIgnoreCase("Hello").accept("World"));
        Assert.assertEquals("StringPredicates.equalsIgnoreCase(\"Hello\")", StringPredicates.equalsIgnoreCase("Hello").toString());
    }

    @Test
    public void containsString() {
        Assert.assertTrue(StringPredicates.contains("Hello").accept("WorldHelloWorld"));
        Assert.assertTrue(StringPredicates.contains("Hello").and(StringPredicates.contains("World")).accept("WorldHelloWorld"));
        Assert.assertFalse(StringPredicates.contains("Goodbye").accept("WorldHelloWorld"));
        Assert.assertEquals("StringPredicates.contains(\"Hello\")", StringPredicates.contains("Hello").toString());
    }

    @Test
    public void containsCharacter() {
        Assert.assertTrue(StringPredicates.contains("H".charAt(0)).accept("WorldHelloWorld"));
        Assert.assertFalse(StringPredicates.contains("B".charAt(0)).accept("WorldHelloWorld"));
        Assert.assertEquals("StringPredicates.contains(\"H\")", StringPredicates.contains("H".charAt(0)).toString());
    }

    @Test
    public void emptyAndNotEmpty() {
        Assert.assertFalse(StringPredicates.empty().accept("WorldHelloWorld"));
        Assert.assertEquals("StringPredicates.empty()", StringPredicates.empty().toString());
        Assert.assertTrue(StringPredicates.notEmpty().accept("WorldHelloWorld"));
        Assert.assertEquals("StringPredicates.notEmpty()", StringPredicates.notEmpty().toString());
        Assert.assertTrue(StringPredicates.empty().accept(""));
        Assert.assertFalse(StringPredicates.notEmpty().accept(""));
    }

    @Test
    public void lessThan() {
        Assert.assertTrue(StringPredicates.lessThan("b").accept("a"));
        Assert.assertFalse(StringPredicates.lessThan("b").accept("b"));
        Assert.assertFalse(StringPredicates.lessThan("b").accept("c"));
        Assert.assertEquals("StringPredicates.lessThan(\"b\")", StringPredicates.lessThan("b").toString());
    }

    @Test
    public void lessThanOrEqualTo() {
        Assert.assertTrue(StringPredicates.lessThanOrEqualTo("b").accept("a"));
        Assert.assertTrue(StringPredicates.lessThanOrEqualTo("b").accept("b"));
        Assert.assertFalse(StringPredicates.lessThanOrEqualTo("b").accept("c"));
        Assert.assertEquals("StringPredicates.lessThanOrEqualTo(\"b\")", StringPredicates.lessThanOrEqualTo("b").toString());
    }

    @Test
    public void greaterThan() {
        Assert.assertFalse(StringPredicates.greaterThan("b").accept("a"));
        Assert.assertFalse(StringPredicates.greaterThan("b").accept("b"));
        Assert.assertTrue(StringPredicates.greaterThan("b").accept("c"));
        Assert.assertEquals("StringPredicates.greaterThan(\"b\")", StringPredicates.greaterThan("b").toString());
    }

    @Test
    public void greaterThanOrEqualTo() {
        Assert.assertFalse(StringPredicates.greaterThanOrEqualTo("b").accept("a"));
        Assert.assertTrue(StringPredicates.greaterThanOrEqualTo("b").accept("b"));
        Assert.assertTrue(StringPredicates.greaterThanOrEqualTo("b").accept("c"));
        Assert.assertEquals("StringPredicates.greaterThanOrEqualTo(\"b\")", StringPredicates.greaterThanOrEqualTo("b").toString());
    }

    @Test
    public void matches() {
        Assert.assertTrue(StringPredicates.matches("a*b*").accept("aaaaabbbbb"));
        Assert.assertFalse(StringPredicates.matches("a*b").accept("ba"));
        Assert.assertEquals("StringPredicates.matches(\"a*b\")", StringPredicates.matches("a*b").toString());
    }

    @Test
    public void size() {
        Assert.assertTrue(StringPredicates.size(1).accept("a"));
        Assert.assertFalse(StringPredicates.size(0).accept("a"));
        Assert.assertTrue(StringPredicates.size(2).accept("ab"));
        Assert.assertEquals("StringPredicates.size(2)", StringPredicates.size(2).toString());
    }

    @Test
    public void hasLetters() {
        Assert.assertTrue(StringPredicates.hasLetters().accept("a2a"));
        Assert.assertFalse(StringPredicates.hasLetters().accept("222"));
        Assert.assertEquals("StringPredicates.hasLetters()", StringPredicates.hasLetters().toString());
    }

    @Test
    public void hasDigits() {
        Assert.assertFalse(StringPredicates.hasDigits().accept("aaa"));
        Assert.assertTrue(StringPredicates.hasDigits().accept("a22"));
        Assert.assertEquals("StringPredicates.hasDigits()", StringPredicates.hasDigits().toString());
    }

    @Test
    public void hasLettersAndDigits() {
        Predicate<String> predicate = StringPredicates.hasLettersAndDigits();
        Assert.assertTrue(predicate.accept("a2a"));
        Assert.assertFalse(predicate.accept("aaa"));
        Assert.assertFalse(predicate.accept("222"));
        Assert.assertEquals("StringPredicates.hasLettersAndDigits()", predicate.toString());
    }

    @Test
    public void hasLettersOrDigits() {
        Predicate<String> predicate = StringPredicates.hasLettersOrDigits();
        Assert.assertTrue(predicate.accept("a2a"));
        Assert.assertTrue(predicate.accept("aaa"));
        Assert.assertTrue(predicate.accept("222"));
        Assert.assertEquals("StringPredicates.hasLettersOrDigits()", predicate.toString());
    }

    @Test
    public void isAlpha() {
        Predicate<String> predicate = StringPredicates.isAlpha();
        Assert.assertTrue(predicate.accept("aaa"));
        Assert.assertFalse(predicate.accept("a2a"));
        Assert.assertEquals("StringPredicates.isAlpha()", predicate.toString());
    }

    @Test
    public void isAlphaNumeric() {
        Predicate<String> predicate = StringPredicates.isAlphanumeric();
        Assert.assertTrue(predicate.accept("aaa"));
        Assert.assertTrue(predicate.accept("a2a"));
        Assert.assertEquals("StringPredicates.isAlphanumeric()", predicate.toString());
    }

    @Test
    public void isBlank() {
        Predicate<String> predicate = StringPredicates.isBlank();
        Assert.assertTrue(predicate.accept(""));
        Assert.assertTrue(predicate.accept(" "));
        Assert.assertFalse(predicate.accept("a2a"));
        Assert.assertEquals("StringPredicates.isBlank()", predicate.toString());
    }

    @Test
    public void notBlank() {
        Predicate<String> predicate = StringPredicates.notBlank();
        Assert.assertFalse(predicate.accept(""));
        Assert.assertFalse(predicate.accept(" "));
        Assert.assertTrue(predicate.accept("a2a"));
        Assert.assertEquals("StringPredicates.notBlank()", predicate.toString());
    }

    @Test
    public void isNumeric() {
        Predicate<String> predicate = StringPredicates.isNumeric();
        Assert.assertTrue(predicate.accept("222"));
        Assert.assertFalse(predicate.accept("a2a2a2"));
        Assert.assertFalse(predicate.accept("aaa"));
        Assert.assertEquals("StringPredicates.isNumeric()", predicate.toString());
    }

    @Test
    public void hasLowerCase() {
        Predicate<String> predicate = StringPredicates.hasLowerCase();
        Assert.assertTrue(predicate.accept("aaa"));
        Assert.assertFalse(predicate.accept("AAA"));
        Assert.assertEquals("StringPredicates.hasLowerCase()", predicate.toString());
    }

    @Test
    public void hasUpperCase() {
        Predicate<String> predicate = StringPredicates.hasUpperCase();
        Assert.assertFalse(predicate.accept("aaa"));
        Assert.assertTrue(predicate.accept("AAA"));
        Assert.assertEquals("StringPredicates.hasUpperCase()", predicate.toString());
    }

    @Test
    public void hasUndefined() {
        Predicate<String> predicate = StringPredicates.hasUndefined();
        Assert.assertFalse(predicate.accept("aaa"));
        Assert.assertEquals("StringPredicates.hasUndefined()", predicate.toString());
    }

    @Test
    public void hasSpaces() {
        Predicate<String> predicate = StringPredicates.hasSpaces();
        Assert.assertTrue(predicate.accept("a a a"));
        Assert.assertTrue(predicate.accept(" "));
        Assert.assertFalse(predicate.accept("aaa"));
        Assert.assertEquals("StringPredicates.hasSpaces()", predicate.toString());
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(StringPredicates.class);
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_startsWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::startsWith, this.description("startsWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_endsWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::endsWith, this.description("endsWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsIgnoreCase() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::equalsIgnoreCase, this.description("equalsIgnoreCase"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsString, this.description("containsString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsCharacter() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsCharacter, this.description("containsCharacter"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_emptyAndNotEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::emptyAndNotEmpty, this.description("emptyAndNotEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lessThan() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::lessThan, this.description("lessThan"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lessThanOrEqualTo() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::lessThanOrEqualTo, this.description("lessThanOrEqualTo"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_greaterThan() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::greaterThan, this.description("greaterThan"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_greaterThanOrEqualTo() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::greaterThanOrEqualTo, this.description("greaterThanOrEqualTo"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_matches() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::matches, this.description("matches"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::size, this.description("size"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_hasLetters() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::hasLetters, this.description("hasLetters"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_hasDigits() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::hasDigits, this.description("hasDigits"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_hasLettersAndDigits() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::hasLettersAndDigits, this.description("hasLettersAndDigits"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_hasLettersOrDigits() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::hasLettersOrDigits, this.description("hasLettersOrDigits"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isAlpha() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isAlpha, this.description("isAlpha"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isAlphaNumeric() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isAlphaNumeric, this.description("isAlphaNumeric"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isBlank() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isBlank, this.description("isBlank"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notBlank() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::notBlank, this.description("notBlank"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isNumeric() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isNumeric, this.description("isNumeric"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_hasLowerCase() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::hasLowerCase, this.description("hasLowerCase"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_hasUpperCase() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::hasUpperCase, this.description("hasUpperCase"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_hasUndefined() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::hasUndefined, this.description("hasUndefined"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_hasSpaces() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::hasSpaces, this.description("hasSpaces"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::classIsNonInstantiable, this.description("classIsNonInstantiable"));
        }

        private StringPredicatesTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new StringPredicatesTest();
        }

        @java.lang.Override
        public StringPredicatesTest implementation() {
            return this.implementation;
        }
    }
}
