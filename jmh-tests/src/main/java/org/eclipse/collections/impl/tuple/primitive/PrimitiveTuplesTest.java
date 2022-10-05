/*
 * Copyright (c) 2022 The Bank of New York Mellon.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.tuple.primitive;

import org.eclipse.collections.api.tuple.primitive.BooleanBytePair;
import org.eclipse.collections.api.tuple.primitive.BooleanCharPair;
import org.eclipse.collections.api.tuple.primitive.BooleanDoublePair;
import org.eclipse.collections.api.tuple.primitive.BooleanFloatPair;
import org.eclipse.collections.api.tuple.primitive.BooleanLongPair;
import org.eclipse.collections.api.tuple.primitive.BooleanShortPair;
import org.eclipse.collections.api.tuple.primitive.ByteBooleanPair;
import org.eclipse.collections.api.tuple.primitive.ByteCharPair;
import org.eclipse.collections.api.tuple.primitive.ByteDoublePair;
import org.eclipse.collections.api.tuple.primitive.ByteFloatPair;
import org.eclipse.collections.api.tuple.primitive.ByteIntPair;
import org.eclipse.collections.api.tuple.primitive.ByteLongPair;
import org.eclipse.collections.api.tuple.primitive.ByteObjectPair;
import org.eclipse.collections.api.tuple.primitive.ByteShortPair;
import org.eclipse.collections.api.tuple.primitive.CharBooleanPair;
import org.eclipse.collections.api.tuple.primitive.CharBytePair;
import org.eclipse.collections.api.tuple.primitive.CharDoublePair;
import org.eclipse.collections.api.tuple.primitive.CharFloatPair;
import org.eclipse.collections.api.tuple.primitive.CharIntPair;
import org.eclipse.collections.api.tuple.primitive.CharLongPair;
import org.eclipse.collections.api.tuple.primitive.CharObjectPair;
import org.eclipse.collections.api.tuple.primitive.CharShortPair;
import org.eclipse.collections.api.tuple.primitive.DoubleBooleanPair;
import org.eclipse.collections.api.tuple.primitive.DoubleBytePair;
import org.eclipse.collections.api.tuple.primitive.DoubleCharPair;
import org.eclipse.collections.api.tuple.primitive.DoubleFloatPair;
import org.eclipse.collections.api.tuple.primitive.DoubleIntPair;
import org.eclipse.collections.api.tuple.primitive.DoubleLongPair;
import org.eclipse.collections.api.tuple.primitive.DoubleObjectPair;
import org.eclipse.collections.api.tuple.primitive.DoubleShortPair;
import org.eclipse.collections.api.tuple.primitive.FloatBooleanPair;
import org.eclipse.collections.api.tuple.primitive.FloatBytePair;
import org.eclipse.collections.api.tuple.primitive.FloatCharPair;
import org.eclipse.collections.api.tuple.primitive.FloatDoublePair;
import org.eclipse.collections.api.tuple.primitive.FloatIntPair;
import org.eclipse.collections.api.tuple.primitive.FloatLongPair;
import org.eclipse.collections.api.tuple.primitive.FloatObjectPair;
import org.eclipse.collections.api.tuple.primitive.FloatShortPair;
import org.eclipse.collections.api.tuple.primitive.IntBytePair;
import org.eclipse.collections.api.tuple.primitive.IntDoublePair;
import org.eclipse.collections.api.tuple.primitive.IntFloatPair;
import org.eclipse.collections.api.tuple.primitive.IntShortPair;
import org.eclipse.collections.api.tuple.primitive.LongBooleanPair;
import org.eclipse.collections.api.tuple.primitive.LongBytePair;
import org.eclipse.collections.api.tuple.primitive.LongCharPair;
import org.eclipse.collections.api.tuple.primitive.LongDoublePair;
import org.eclipse.collections.api.tuple.primitive.LongFloatPair;
import org.eclipse.collections.api.tuple.primitive.LongIntPair;
import org.eclipse.collections.api.tuple.primitive.LongObjectPair;
import org.eclipse.collections.api.tuple.primitive.LongShortPair;
import org.eclipse.collections.api.tuple.primitive.ObjectBytePair;
import org.eclipse.collections.api.tuple.primitive.ObjectCharPair;
import org.eclipse.collections.api.tuple.primitive.ObjectDoublePair;
import org.eclipse.collections.api.tuple.primitive.ObjectFloatPair;
import org.eclipse.collections.api.tuple.primitive.ObjectLongPair;
import org.eclipse.collections.api.tuple.primitive.ObjectShortPair;
import org.eclipse.collections.api.tuple.primitive.ShortBooleanPair;
import org.eclipse.collections.api.tuple.primitive.ShortBytePair;
import org.eclipse.collections.api.tuple.primitive.ShortCharPair;
import org.eclipse.collections.api.tuple.primitive.ShortDoublePair;
import org.eclipse.collections.api.tuple.primitive.ShortFloatPair;
import org.eclipse.collections.api.tuple.primitive.ShortIntPair;
import org.eclipse.collections.api.tuple.primitive.ShortLongPair;
import org.eclipse.collections.api.tuple.primitive.ShortObjectPair;
import org.junit.Assert;
import org.junit.Test;

public class PrimitiveTuplesTest {

    private static final double DELTA = 0.0001;

    @Test
    public void objectBytePair() {
        String valueOne = "a";
        byte valueTwo = (byte) 1;
        ObjectBytePair<String> pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals(valueOne, pair.getOne());
        Assert.assertEquals((long) valueTwo, (long) pair.getTwo());
    }

    @Test
    public void byteObjectPair() {
        byte valueOne = (byte) 1;
        String valueTwo = "a";
        ByteObjectPair<String> pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((long) valueOne, (long) pair.getOne());
        Assert.assertEquals(valueTwo, pair.getTwo());
    }

    @Test
    public void byteIntPair() {
        byte valueOne = (byte) 1;
        int valueTwo = 555;
        ByteIntPair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((long) valueOne, (long) pair.getOne());
        Assert.assertEquals((long) valueTwo, (long) pair.getTwo());
    }

    @Test
    public void byteFloatPair() {
        byte valueOne = (byte) 1;
        float valueTwo = 555.0f;
        ByteFloatPair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((long) valueOne, (long) pair.getOne());
        Assert.assertEquals((double) valueTwo, (double) pair.getTwo(), DELTA);
    }

    @Test
    public void byteDoublePair() {
        byte valueOne = (byte) 1;
        double valueTwo = 555.0d;
        ByteDoublePair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((long) valueOne, (long) pair.getOne());
        Assert.assertEquals(valueTwo, pair.getTwo(), DELTA);
    }

    @Test
    public void byteLongPair() {
        byte valueOne = (byte) 1;
        long valueTwo = 454L;
        ByteLongPair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((long) valueOne, (long) pair.getOne());
        Assert.assertEquals(valueTwo, pair.getTwo());
    }

    @Test
    public void byteShortPair() {
        byte valueOne = (byte) 1;
        short valueTwo = (short) 454;
        ByteShortPair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((long) valueOne, (long) pair.getOne());
        Assert.assertEquals((long) valueTwo, (long) pair.getTwo());
    }

    @Test
    public void byteCharPair() {
        byte valueOne = (byte) 1;
        char valueTwo = 'c';
        ByteCharPair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((long) valueOne, (long) pair.getOne());
        Assert.assertEquals((long) valueTwo, (long) pair.getTwo());
    }

    @Test
    public void byteBooleanPair() {
        byte valueOne = (byte) 1;
        ByteBooleanPair pair = PrimitiveTuples.pair(valueOne, false);
        Assert.assertEquals((long) valueOne, (long) pair.getOne());
        Assert.assertFalse(pair.getTwo());
    }

    @Test
    public void charObjectPair() {
        char valueOne = 'c';
        String valueTwo = "a";
        CharObjectPair<String> pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((long) valueOne, (long) pair.getOne());
        Assert.assertEquals(valueTwo, pair.getTwo());
    }

    @Test
    public void charIntPair() {
        char valueOne = 'c';
        int valueTwo = 343;
        CharIntPair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((long) valueOne, (long) pair.getOne());
        Assert.assertEquals((long) valueTwo, (long) pair.getTwo());
    }

    @Test
    public void charFloatPair() {
        char valueOne = 'c';
        float valueTwo = 343.00f;
        CharFloatPair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((long) valueOne, (long) pair.getOne());
        Assert.assertEquals((double) valueTwo, (double) pair.getTwo(), DELTA);
    }

    @Test
    public void charDoublePair() {
        char valueOne = 'c';
        double valueTwo = 343.00d;
        CharDoublePair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((long) valueOne, (long) pair.getOne());
        Assert.assertEquals(valueTwo, pair.getTwo(), DELTA);
    }

    @Test
    public void booleanFloatPair() {
        float valueTwo = 454.01f;
        BooleanFloatPair pair = PrimitiveTuples.pair(true, valueTwo);
        Assert.assertTrue(pair.getOne());
        Assert.assertEquals((double) valueTwo, (double) pair.getTwo(), DELTA);
    }

    @Test
    public void booleanDoublePair() {
        double valueTwo = 454.01d;
        BooleanDoublePair pair = PrimitiveTuples.pair(true, valueTwo);
        Assert.assertTrue(pair.getOne());
        Assert.assertEquals(valueTwo, pair.getTwo(), DELTA);
    }

    @Test
    public void booleanLongPair() {
        long valueTwo = 444434L;
        BooleanLongPair pair = PrimitiveTuples.pair(true, valueTwo);
        Assert.assertTrue(pair.getOne());
        Assert.assertEquals(valueTwo, pair.getTwo());
    }

    @Test
    public void booleanShortPair() {
        short valueTwo = (short) 34;
        BooleanShortPair pair = PrimitiveTuples.pair(true, valueTwo);
        Assert.assertTrue(pair.getOne());
        Assert.assertEquals((long) valueTwo, (long) pair.getTwo());
    }

    @Test
    public void booleanBytePair() {
        byte valueTwo = (byte) 34;
        BooleanBytePair pair = PrimitiveTuples.pair(true, valueTwo);
        Assert.assertTrue(pair.getOne());
        Assert.assertEquals((long) valueTwo, (long) pair.getTwo());
    }

    @Test
    public void booleanCharPair() {
        char valueTwo = 'd';
        BooleanCharPair pair = PrimitiveTuples.pair(true, valueTwo);
        Assert.assertTrue(pair.getOne());
        Assert.assertEquals((long) valueTwo, (long) pair.getTwo());
    }

    @Test
    public void charLongPair() {
        char valueOne = 'c';
        long valueTwo = 454L;
        CharLongPair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((long) valueOne, (long) pair.getOne());
        Assert.assertEquals(valueTwo, pair.getTwo());
    }

    @Test
    public void charShortPair() {
        char valueOne = 'c';
        short valueTwo = (short) 454;
        CharShortPair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((long) valueOne, (long) pair.getOne());
        Assert.assertEquals((long) valueTwo, (long) pair.getTwo());
    }

    @Test
    public void charBytePair() {
        char valueOne = 'c';
        byte valueTwo = (byte) 454;
        CharBytePair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((long) valueOne, (long) pair.getOne());
        Assert.assertEquals((long) valueTwo, (long) pair.getTwo());
    }

    @Test
    public void charBooleanPair() {
        char valueOne = 'c';
        CharBooleanPair pair = PrimitiveTuples.pair(valueOne, true);
        Assert.assertEquals((long) valueOne, (long) pair.getOne());
        Assert.assertTrue(pair.getTwo());
    }

    @Test
    public void shortObjectPair() {
        short valueOne = (short) 10;
        String valueTwo = "a";
        ShortObjectPair<String> pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((long) valueOne, (long) pair.getOne());
        Assert.assertEquals(valueTwo, pair.getTwo());
    }

    @Test
    public void shortIntPair() {
        short valueOne = (short) 10;
        int valueTwo = 589;
        ShortIntPair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((long) valueOne, (long) pair.getOne());
        Assert.assertEquals((long) valueTwo, (long) pair.getTwo());
    }

    @Test
    public void shortBytePair() {
        short valueOne = (short) 10;
        byte valueTwo = (byte) 589;
        ShortBytePair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((long) valueOne, (long) pair.getOne());
        Assert.assertEquals((long) valueTwo, (long) pair.getTwo());
    }

    @Test
    public void shortCharPair() {
        short valueOne = (short) 10;
        char valueTwo = 'd';
        ShortCharPair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((long) valueOne, (long) pair.getOne());
        Assert.assertEquals((long) valueTwo, (long) pair.getTwo());
    }

    @Test
    public void shortLongPair() {
        short valueOne = (short) 10;
        long valueTwo = 589L;
        ShortLongPair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((long) valueOne, (long) pair.getOne());
        Assert.assertEquals(valueTwo, pair.getTwo());
    }

    @Test
    public void shortBooleanPair() {
        short valueOne = (short) 10;
        ShortBooleanPair pair = PrimitiveTuples.pair(valueOne, false);
        Assert.assertEquals((long) valueOne, (long) pair.getOne());
        Assert.assertFalse(pair.getTwo());
    }

    @Test
    public void shortFloatPair() {
        short valueOne = (short) 12;
        float valueTwo = 589.09f;
        ShortFloatPair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((long) valueOne, (long) pair.getOne());
        Assert.assertEquals((double) valueTwo, (double) pair.getTwo(), DELTA);
    }

    @Test
    public void shortDoublePair() {
        short valueOne = (short) 12;
        double valueTwo = 589.09d;
        ShortDoublePair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((long) valueOne, (long) pair.getOne());
        Assert.assertEquals(valueTwo, pair.getTwo(), DELTA);
    }

    @Test
    public void floatObjectPair() {
        float valueOne = 10.00f;
        String valueTwo = "a";
        FloatObjectPair<String> pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((double) valueOne, (double) pair.getOne(), DELTA);
        Assert.assertEquals(valueTwo, pair.getTwo());
    }

    @Test
    public void floatDoublePair() {
        float valueOne = 10.00f;
        double valueTwo = 567.00d;
        FloatDoublePair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((double) valueOne, (double) pair.getOne(), DELTA);
        Assert.assertEquals(valueTwo, pair.getTwo(), DELTA);
    }

    @Test
    public void floatLongPair() {
        float valueOne = 10.00f;
        long valueTwo = 55L;
        FloatLongPair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((double) valueOne, (double) pair.getOne(), DELTA);
        Assert.assertEquals(valueTwo, pair.getTwo());
    }

    @Test
    public void floatShortPair() {
        float valueOne = 10.00f;
        short valueTwo = (short) 55;
        FloatShortPair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((double) valueOne, (double) pair.getOne(), DELTA);
        Assert.assertEquals((long) valueTwo, (long) pair.getTwo());
    }

    @Test
    public void floatBytePair() {
        float valueOne = 10.00f;
        byte valueTwo = (byte) 55;
        FloatBytePair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((double) valueOne, (double) pair.getOne(), DELTA);
        Assert.assertEquals((long) valueTwo, (long) pair.getTwo());
    }

    @Test
    public void floatCharPair() {
        float valueOne = 10.00f;
        char valueTwo = 'd';
        FloatCharPair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((double) valueOne, (double) pair.getOne(), DELTA);
        Assert.assertEquals((long) valueTwo, (long) pair.getTwo());
    }

    @Test
    public void floatBooleanPair() {
        float valueOne = 10.00f;
        FloatBooleanPair pair = PrimitiveTuples.pair(valueOne, false);
        Assert.assertEquals(valueOne, pair.getOne(), DELTA);
        Assert.assertFalse(pair.getTwo());
    }

    @Test
    public void floatIntPair() {
        float valueOne = 10.00f;
        int valueTwo = 55;
        FloatIntPair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((double) valueOne, (double) pair.getOne(), DELTA);
        Assert.assertEquals((long) valueTwo, (long) pair.getTwo());
    }

    @Test
    public void doubleIntPair() {
        double valueOne = 10.00d;
        int valueTwo = 55;
        DoubleIntPair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals(valueOne, pair.getOne(), DELTA);
        Assert.assertEquals((long) valueTwo, (long) pair.getTwo());
    }

    @Test
    public void doubleShortPair() {
        double valueOne = 10.00d;
        short valueTwo = (short) 55;
        DoubleShortPair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals(valueOne, pair.getOne(), DELTA);
        Assert.assertEquals((long) valueTwo, (long) pair.getTwo());
    }

    @Test
    public void doubleCharPair() {
        double valueOne = 10.00d;
        char valueTwo = 'r';
        DoubleCharPair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals(valueOne, pair.getOne(), DELTA);
        Assert.assertEquals((long) valueTwo, (long) pair.getTwo());
    }

    @Test
    public void doubleBooleanPair() {
        double valueOne = 10.00d;
        DoubleBooleanPair pair = PrimitiveTuples.pair(valueOne, true);
        Assert.assertEquals(valueOne, pair.getOne(), DELTA);
        Assert.assertTrue(pair.getTwo());
    }

    @Test
    public void doubleBytePair() {
        double valueOne = 10.00d;
        byte valueTwo = (byte) 55;
        DoubleBytePair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals(valueOne, pair.getOne(), DELTA);
        Assert.assertEquals((long) valueTwo, (long) pair.getTwo());
    }

    @Test
    public void doubleLongPair() {
        double valueOne = 10.00d;
        long valueTwo = 55L;
        DoubleLongPair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals(valueOne, pair.getOne(), DELTA);
        Assert.assertEquals(valueTwo, pair.getTwo());
    }

    @Test
    public void doubleFloatPair() {
        double valueOne = 10.00d;
        float valueTwo = 55.0f;
        DoubleFloatPair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals(valueOne, pair.getOne(), DELTA);
        Assert.assertEquals((double) valueTwo, (double) pair.getTwo(), DELTA);
    }

    @Test
    public void doubleObjectPair() {
        double valueOne = 10.00d;
        String valueTwo = "a";
        DoubleObjectPair<String> pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals(valueOne, pair.getOne(), DELTA);
        Assert.assertEquals(valueTwo, pair.getTwo());
    }

    @Test
    public void intFloatPair() {
        int valueOne = 123;
        float valueTwo = 789.00f;
        IntFloatPair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((long) valueOne, (long) pair.getOne());
        Assert.assertEquals((double) valueTwo, (double) pair.getTwo(), DELTA);
    }

    @Test
    public void intDoublePair() {
        int valueOne = 123;
        double valueTwo = 789.00d;
        IntDoublePair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((long) valueOne, (long) pair.getOne());
        Assert.assertEquals(valueTwo, pair.getTwo(), DELTA);
    }

    @Test
    public void intShortPair() {
        int valueOne = 123;
        short valueTwo = (short) 696;
        IntShortPair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((long) valueOne, (long) pair.getOne());
        Assert.assertEquals((long) valueTwo, (long) pair.getTwo());
    }

    @Test
    public void intBytePair() {
        int valueOne = 123;
        byte valueTwo = (byte) 696;
        IntBytePair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((long) valueOne, (long) pair.getOne());
        Assert.assertEquals((long) valueTwo, (long) pair.getTwo());
    }

    @Test
    public void intCharPair() {
        int valueOne = 123;
        byte valueTwo = (byte) 696;
        IntBytePair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals((long) valueOne, (long) pair.getOne());
        Assert.assertEquals((long) valueTwo, (long) pair.getTwo());
    }

    @Test
    public void longObjectPair() {
        long valueOne = 123L;
        String valueTwo = "a";
        LongObjectPair<String> pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals(valueOne, pair.getOne());
        Assert.assertEquals(valueTwo, pair.getTwo());
    }

    @Test
    public void longIntPair() {
        long valueOne = 123L;
        int valueTwo = 33;
        LongIntPair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals(valueOne, pair.getOne());
        Assert.assertEquals((long) valueTwo, (long) pair.getTwo());
    }

    @Test
    public void longFloatPair() {
        long valueOne = 123L;
        float valueTwo = 33.01f;
        LongFloatPair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals(valueOne, pair.getOne());
        Assert.assertEquals((double) valueTwo, (double) pair.getTwo(), DELTA);
    }

    @Test
    public void longDoublePair() {
        long valueOne = 123L;
        double valueTwo = 33.01d;
        LongDoublePair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals(valueOne, pair.getOne());
        Assert.assertEquals(valueTwo, pair.getTwo(), DELTA);
    }

    @Test
    public void longShortPair() {
        long valueOne = 123L;
        short valueTwo = (short) 444;
        LongShortPair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals(valueOne, pair.getOne());
        Assert.assertEquals((long) valueTwo, (long) pair.getTwo());
    }

    @Test
    public void longBytePair() {
        long valueOne = 123L;
        byte valueTwo = (byte) 444;
        LongBytePair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals(valueOne, pair.getOne());
        Assert.assertEquals((long) valueTwo, (long) pair.getTwo());
    }

    @Test
    public void longCharPair() {
        long valueOne = 123L;
        char valueTwo = 'd';
        LongCharPair pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals(valueOne, pair.getOne());
        Assert.assertEquals((long) valueTwo, (long) pair.getTwo());
    }

    @Test
    public void longBooleanPair() {
        long valueOne = 123L;
        LongBooleanPair pair = PrimitiveTuples.pair(valueOne, false);
        Assert.assertEquals(valueOne, pair.getOne());
        Assert.assertFalse(pair.getTwo());
    }

    @Test
    public void objectCharPair() {
        String valueOne = "a";
        char valueTwo = 'c';
        ObjectCharPair<String> pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals(valueOne, pair.getOne());
        Assert.assertEquals((long) valueTwo, (long) pair.getTwo());
    }

    @Test
    public void objectShortPair() {
        String valueOne = "a";
        short valueTwo = (short) 1;
        ObjectShortPair<String> pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals(valueOne, pair.getOne());
        Assert.assertEquals((long) valueTwo, (long) pair.getTwo());
    }

    @Test
    public void objectFloatPair() {
        String valueOne = "a";
        float valueTwo = 1.00f;
        ObjectFloatPair<String> pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals(valueOne, pair.getOne());
        Assert.assertEquals((double) valueTwo, (double) pair.getTwo(), DELTA);
    }

    @Test
    public void objectLongPair() {
        String valueOne = "a";
        long valueTwo = 500L;
        ObjectLongPair<String> pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals(valueOne, pair.getOne());
        Assert.assertEquals(valueTwo, pair.getTwo());
    }

    @Test
    public void objectDoublePair() {
        String valueOne = "a";
        double valueTwo = 1.00d;
        ObjectDoublePair<String> pair = PrimitiveTuples.pair(valueOne, valueTwo);
        Assert.assertEquals(valueOne, pair.getOne());
        Assert.assertEquals(valueTwo, pair.getTwo(), DELTA);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_objectBytePair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::objectBytePair, this.description("objectBytePair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteObjectPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::byteObjectPair, this.description("byteObjectPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIntPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::byteIntPair, this.description("byteIntPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteFloatPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::byteFloatPair, this.description("byteFloatPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteDoublePair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::byteDoublePair, this.description("byteDoublePair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteLongPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::byteLongPair, this.description("byteLongPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteShortPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::byteShortPair, this.description("byteShortPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteCharPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::byteCharPair, this.description("byteCharPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteBooleanPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::byteBooleanPair, this.description("byteBooleanPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charObjectPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::charObjectPair, this.description("charObjectPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIntPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::charIntPair, this.description("charIntPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charFloatPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::charFloatPair, this.description("charFloatPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charDoublePair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::charDoublePair, this.description("charDoublePair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanFloatPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::booleanFloatPair, this.description("booleanFloatPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanDoublePair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::booleanDoublePair, this.description("booleanDoublePair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanLongPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::booleanLongPair, this.description("booleanLongPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanShortPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::booleanShortPair, this.description("booleanShortPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanBytePair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::booleanBytePair, this.description("booleanBytePair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanCharPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::booleanCharPair, this.description("booleanCharPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charLongPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::charLongPair, this.description("charLongPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charShortPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::charShortPair, this.description("charShortPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charBytePair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::charBytePair, this.description("charBytePair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charBooleanPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::charBooleanPair, this.description("charBooleanPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortObjectPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::shortObjectPair, this.description("shortObjectPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIntPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::shortIntPair, this.description("shortIntPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortBytePair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::shortBytePair, this.description("shortBytePair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortCharPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::shortCharPair, this.description("shortCharPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortLongPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::shortLongPair, this.description("shortLongPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortBooleanPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::shortBooleanPair, this.description("shortBooleanPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortFloatPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::shortFloatPair, this.description("shortFloatPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortDoublePair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::shortDoublePair, this.description("shortDoublePair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatObjectPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::floatObjectPair, this.description("floatObjectPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatDoublePair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::floatDoublePair, this.description("floatDoublePair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatLongPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::floatLongPair, this.description("floatLongPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatShortPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::floatShortPair, this.description("floatShortPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatBytePair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::floatBytePair, this.description("floatBytePair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatCharPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::floatCharPair, this.description("floatCharPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatBooleanPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::floatBooleanPair, this.description("floatBooleanPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIntPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::floatIntPair, this.description("floatIntPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIntPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::doubleIntPair, this.description("doubleIntPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleShortPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::doubleShortPair, this.description("doubleShortPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleCharPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::doubleCharPair, this.description("doubleCharPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleBooleanPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::doubleBooleanPair, this.description("doubleBooleanPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleBytePair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::doubleBytePair, this.description("doubleBytePair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleLongPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::doubleLongPair, this.description("doubleLongPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleFloatPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::doubleFloatPair, this.description("doubleFloatPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleObjectPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::doubleObjectPair, this.description("doubleObjectPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intFloatPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::intFloatPair, this.description("intFloatPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intDoublePair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::intDoublePair, this.description("intDoublePair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intShortPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::intShortPair, this.description("intShortPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intBytePair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::intBytePair, this.description("intBytePair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intCharPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::intCharPair, this.description("intCharPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longObjectPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::longObjectPair, this.description("longObjectPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIntPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::longIntPair, this.description("longIntPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longFloatPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::longFloatPair, this.description("longFloatPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longDoublePair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::longDoublePair, this.description("longDoublePair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longShortPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::longShortPair, this.description("longShortPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longBytePair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::longBytePair, this.description("longBytePair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longCharPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::longCharPair, this.description("longCharPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longBooleanPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::longBooleanPair, this.description("longBooleanPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_objectCharPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::objectCharPair, this.description("objectCharPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_objectShortPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::objectShortPair, this.description("objectShortPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_objectFloatPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::objectFloatPair, this.description("objectFloatPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_objectLongPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::objectLongPair, this.description("objectLongPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_objectDoublePair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::objectDoublePair, this.description("objectDoublePair"));
        }

        private PrimitiveTuplesTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new PrimitiveTuplesTest();
        }

        @java.lang.Override
        public PrimitiveTuplesTest implementation() {
            return this.implementation;
        }
    }
}
