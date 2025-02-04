/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.function;

import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.impl.block.factory.StringFunctions;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public final class StringFunctionsTest {

    @Test
    public void toUpperCase() {
        Function<String, String> function = StringFunctions.toUpperCase();
        Assert.assertEquals("UPPER", function.valueOf("upper"));
        Assert.assertEquals("UPPER", function.valueOf("Upper"));
        Assert.assertEquals("UPPER", function.valueOf("UPPER"));
        Assert.assertSame("UPPER", function.valueOf("UPPER"));
    }

    @Test
    public void toLowerCase() {
        Function<String, String> function = StringFunctions.toLowerCase();
        Assert.assertEquals("lower", function.valueOf("LOWER"));
        Assert.assertEquals("lower", function.valueOf("Lower"));
        Assert.assertEquals("lower", function.valueOf("lower"));
        Assert.assertSame("lower", function.valueOf("lower"));
    }

    @Test
    public void toInteger() {
        Assert.assertEquals(-42L, StringFunctions.toInteger().valueOf("-42").longValue());
        Verify.assertInstanceOf(Integer.class, StringFunctions.toInteger().valueOf("10"));
    }

    @Test
    public void length() {
        Function<String, Integer> function = StringFunctions.length();
        Assert.assertEquals(Integer.valueOf(6), function.valueOf("string"));
        Assert.assertEquals(Integer.valueOf(0), function.valueOf(""));
        Assert.assertEquals("string.length()", function.toString());
    }

    @Test
    public void trim() {
        Function<String, String> function = StringFunctions.trim();
        Assert.assertEquals("trim", function.valueOf("trim "));
        Assert.assertEquals("trim", function.valueOf(" trim"));
        Assert.assertEquals("trim", function.valueOf("  trim  "));
        Assert.assertEquals("trim", function.valueOf("trim"));
        Assert.assertSame("trim", function.valueOf("trim"));
        Assert.assertEquals("string.trim()", function.toString());
    }

    @Test
    public void firstLetter() {
        Function<String, Character> function = StringFunctions.firstLetter();
        Assert.assertNull(function.valueOf(null));
        Assert.assertNull(function.valueOf(""));
        Assert.assertEquals('A', function.valueOf("Autocthonic").charValue());
    }

    @Test
    public void subString() {
        Function<String, String> function1 = StringFunctions.subString(2, 5);
        String testString = "habits";
        Assert.assertEquals("bit", function1.valueOf(testString));
        Verify.assertContains("string.subString", function1.toString());
        Function<String, String> function2 = StringFunctions.subString(0, testString.length());
        Assert.assertEquals(testString, function2.valueOf(testString));
        Function<String, String> function3 = StringFunctions.subString(0, testString.length() + 1);
        Assert.assertThrows(StringIndexOutOfBoundsException.class, () -> function3.valueOf(testString));
        Function<String, String> function4 = StringFunctions.subString(-1, 1);
        Assert.assertThrows(StringIndexOutOfBoundsException.class, () -> function4.valueOf(testString));
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void subString_throws_on_short_string() {
        StringFunctions.subString(2, 4).valueOf("hi");
    }

    @Test(expected = NullPointerException.class)
    public void subString_throws_on_null() {
        StringFunctions.subString(2, 4).valueOf(null);
    }

    @Test
    public void toPrimitiveBoolean() {
        Assert.assertTrue(StringFunctions.toPrimitiveBoolean().booleanValueOf("true"));
        Assert.assertFalse(StringFunctions.toPrimitiveBoolean().booleanValueOf("nah"));
    }

    @Test
    public void toPrimitiveByte() {
        Assert.assertEquals((byte) 16, StringFunctions.toPrimitiveByte().byteValueOf("16"));
    }

    @Test
    public void toFirstChar() {
        Assert.assertEquals('X', StringFunctions.toFirstChar().charValueOf("X-ray"));
    }

    @Test
    public void toPrimitiveChar() {
        Assert.assertEquals('A', StringFunctions.toPrimitiveChar().charValueOf("65"));
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void toPrimitiveCharWithEmptyString() {
        StringFunctions.toFirstChar().charValueOf("");
    }

    @Test
    public void toPrimitiveDouble() {
        Assert.assertEquals(3.14159265359d, StringFunctions.toPrimitiveDouble().doubleValueOf("3.14159265359"), 0.0);
    }

    @Test
    public void toPrimitiveFloat() {
        Assert.assertEquals(3.1415d, StringFunctions.toPrimitiveFloat().floatValueOf("3.1415"), 0.00001);
    }

    @Test
    public void toPrimitiveInt() {
        Assert.assertEquals(256, StringFunctions.toPrimitiveInt().intValueOf("256"));
    }

    @Test
    public void toPrimitiveLong() {
        Assert.assertEquals(0x7fffffffffffffffL, StringFunctions.toPrimitiveLong().longValueOf("9223372036854775807"));
    }

    @Test
    public void toPrimitiveShort() {
        Assert.assertEquals(-32768, StringFunctions.toPrimitiveShort().shortValueOf("-32768"));
    }

    @Test
    public void append() {
        Verify.assertContainsAll(FastList.newListWith("1", "2", "3", "4", "5").collect(StringFunctions.append("!")), "1!", "2!", "3!", "4!", "5!");
    }

    @Test
    public void prepend() {
        Verify.assertContainsAll(FastList.newListWith("1", "2", "3", "4", "5").collect(StringFunctions.prepend("@")), "@1", "@2", "@3", "@4", "@5");
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(StringFunctions.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private StringFunctionsTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toUpperCase() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toUpperCase);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toLowerCase() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toLowerCase);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toInteger);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_length() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.length);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_trim() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.trim);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_firstLetter() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.firstLetter);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subString_throws_on_short_string() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subString_throws_on_short_string);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subString_throws_on_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subString_throws_on_null);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toPrimitiveBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toPrimitiveBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toPrimitiveByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toPrimitiveByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toFirstChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toFirstChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toPrimitiveChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toPrimitiveChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toPrimitiveCharWithEmptyString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toPrimitiveCharWithEmptyString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toPrimitiveDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toPrimitiveDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toPrimitiveFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toPrimitiveFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toPrimitiveInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toPrimitiveInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toPrimitiveLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toPrimitiveLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toPrimitiveShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toPrimitiveShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_append() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.append);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_prepend() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.prepend);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<StringFunctionsTest> payload) throws java.lang.Throwable {
            this.instance = new StringFunctionsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringFunctionsTest> toUpperCase;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringFunctionsTest> toLowerCase;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringFunctionsTest> toInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringFunctionsTest> length;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringFunctionsTest> trim;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringFunctionsTest> firstLetter;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringFunctionsTest> subString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringFunctionsTest> subString_throws_on_short_string;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringFunctionsTest> subString_throws_on_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringFunctionsTest> toPrimitiveBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringFunctionsTest> toPrimitiveByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringFunctionsTest> toFirstChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringFunctionsTest> toPrimitiveChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringFunctionsTest> toPrimitiveCharWithEmptyString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringFunctionsTest> toPrimitiveDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringFunctionsTest> toPrimitiveFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringFunctionsTest> toPrimitiveInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringFunctionsTest> toPrimitiveLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringFunctionsTest> toPrimitiveShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringFunctionsTest> append;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringFunctionsTest> prepend;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringFunctionsTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toUpperCase = StringFunctionsTest::toUpperCase;
            this.payloads.toLowerCase = StringFunctionsTest::toLowerCase;
            this.payloads.toInteger = StringFunctionsTest::toInteger;
            this.payloads.length = StringFunctionsTest::length;
            this.payloads.trim = StringFunctionsTest::trim;
            this.payloads.firstLetter = StringFunctionsTest::firstLetter;
            this.payloads.subString = StringFunctionsTest::subString;
            this.payloads.subString_throws_on_short_string = new se.chalmers.ju2jmh.api.ExceptionTest<>(StringFunctionsTest::subString_throws_on_short_string, java.lang.StringIndexOutOfBoundsException.class);
            this.payloads.subString_throws_on_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(StringFunctionsTest::subString_throws_on_null, java.lang.NullPointerException.class);
            this.payloads.toPrimitiveBoolean = StringFunctionsTest::toPrimitiveBoolean;
            this.payloads.toPrimitiveByte = StringFunctionsTest::toPrimitiveByte;
            this.payloads.toFirstChar = StringFunctionsTest::toFirstChar;
            this.payloads.toPrimitiveChar = StringFunctionsTest::toPrimitiveChar;
            this.payloads.toPrimitiveCharWithEmptyString = new se.chalmers.ju2jmh.api.ExceptionTest<>(StringFunctionsTest::toPrimitiveCharWithEmptyString, java.lang.StringIndexOutOfBoundsException.class);
            this.payloads.toPrimitiveDouble = StringFunctionsTest::toPrimitiveDouble;
            this.payloads.toPrimitiveFloat = StringFunctionsTest::toPrimitiveFloat;
            this.payloads.toPrimitiveInt = StringFunctionsTest::toPrimitiveInt;
            this.payloads.toPrimitiveLong = StringFunctionsTest::toPrimitiveLong;
            this.payloads.toPrimitiveShort = StringFunctionsTest::toPrimitiveShort;
            this.payloads.append = StringFunctionsTest::append;
            this.payloads.prepend = StringFunctionsTest::prepend;
            this.payloads.classIsNonInstantiable = StringFunctionsTest::classIsNonInstantiable;
        }
    }
}
