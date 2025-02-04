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
    public static class _Benchmark {

        private _Payloads payloads;

        private PrimitiveTuplesTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_objectBytePair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.objectBytePair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteObjectPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteObjectPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIntPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIntPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteFloatPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteFloatPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteDoublePair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteDoublePair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteLongPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteLongPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteShortPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteShortPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteCharPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteCharPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteBooleanPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteBooleanPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charObjectPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charObjectPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIntPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIntPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charFloatPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charFloatPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charDoublePair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charDoublePair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanFloatPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanFloatPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanDoublePair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanDoublePair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanLongPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanLongPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanShortPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanShortPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanBytePair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanBytePair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanCharPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanCharPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charLongPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charLongPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charShortPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charShortPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charBytePair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charBytePair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charBooleanPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charBooleanPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortObjectPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortObjectPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIntPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIntPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortBytePair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortBytePair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortCharPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortCharPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortLongPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortLongPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortBooleanPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortBooleanPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortFloatPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortFloatPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortDoublePair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortDoublePair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatObjectPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatObjectPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatDoublePair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatDoublePair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatLongPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatLongPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatShortPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatShortPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatBytePair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatBytePair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatCharPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatCharPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatBooleanPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatBooleanPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIntPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIntPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIntPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIntPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleShortPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleShortPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleCharPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleCharPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleBooleanPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleBooleanPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleBytePair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleBytePair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleLongPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleLongPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleFloatPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleFloatPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleObjectPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleObjectPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intFloatPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intFloatPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intDoublePair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intDoublePair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intShortPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intShortPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intBytePair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intBytePair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intCharPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intCharPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longObjectPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longObjectPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIntPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIntPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longFloatPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longFloatPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longDoublePair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longDoublePair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longShortPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longShortPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longBytePair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longBytePair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longCharPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longCharPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longBooleanPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longBooleanPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_objectCharPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.objectCharPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_objectShortPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.objectShortPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_objectFloatPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.objectFloatPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_objectLongPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.objectLongPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_objectDoublePair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.objectDoublePair);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> payload) throws java.lang.Throwable {
            this.instance = new PrimitiveTuplesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> objectBytePair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> byteObjectPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> byteIntPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> byteFloatPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> byteDoublePair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> byteLongPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> byteShortPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> byteCharPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> byteBooleanPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> charObjectPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> charIntPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> charFloatPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> charDoublePair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> booleanFloatPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> booleanDoublePair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> booleanLongPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> booleanShortPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> booleanBytePair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> booleanCharPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> charLongPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> charShortPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> charBytePair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> charBooleanPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> shortObjectPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> shortIntPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> shortBytePair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> shortCharPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> shortLongPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> shortBooleanPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> shortFloatPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> shortDoublePair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> floatObjectPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> floatDoublePair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> floatLongPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> floatShortPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> floatBytePair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> floatCharPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> floatBooleanPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> floatIntPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> doubleIntPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> doubleShortPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> doubleCharPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> doubleBooleanPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> doubleBytePair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> doubleLongPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> doubleFloatPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> doubleObjectPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> intFloatPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> intDoublePair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> intShortPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> intBytePair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> intCharPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> longObjectPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> longIntPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> longFloatPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> longDoublePair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> longShortPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> longBytePair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> longCharPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> longBooleanPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> objectCharPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> objectShortPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> objectFloatPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> objectLongPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveTuplesTest> objectDoublePair;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.objectBytePair = PrimitiveTuplesTest::objectBytePair;
            this.payloads.byteObjectPair = PrimitiveTuplesTest::byteObjectPair;
            this.payloads.byteIntPair = PrimitiveTuplesTest::byteIntPair;
            this.payloads.byteFloatPair = PrimitiveTuplesTest::byteFloatPair;
            this.payloads.byteDoublePair = PrimitiveTuplesTest::byteDoublePair;
            this.payloads.byteLongPair = PrimitiveTuplesTest::byteLongPair;
            this.payloads.byteShortPair = PrimitiveTuplesTest::byteShortPair;
            this.payloads.byteCharPair = PrimitiveTuplesTest::byteCharPair;
            this.payloads.byteBooleanPair = PrimitiveTuplesTest::byteBooleanPair;
            this.payloads.charObjectPair = PrimitiveTuplesTest::charObjectPair;
            this.payloads.charIntPair = PrimitiveTuplesTest::charIntPair;
            this.payloads.charFloatPair = PrimitiveTuplesTest::charFloatPair;
            this.payloads.charDoublePair = PrimitiveTuplesTest::charDoublePair;
            this.payloads.booleanFloatPair = PrimitiveTuplesTest::booleanFloatPair;
            this.payloads.booleanDoublePair = PrimitiveTuplesTest::booleanDoublePair;
            this.payloads.booleanLongPair = PrimitiveTuplesTest::booleanLongPair;
            this.payloads.booleanShortPair = PrimitiveTuplesTest::booleanShortPair;
            this.payloads.booleanBytePair = PrimitiveTuplesTest::booleanBytePair;
            this.payloads.booleanCharPair = PrimitiveTuplesTest::booleanCharPair;
            this.payloads.charLongPair = PrimitiveTuplesTest::charLongPair;
            this.payloads.charShortPair = PrimitiveTuplesTest::charShortPair;
            this.payloads.charBytePair = PrimitiveTuplesTest::charBytePair;
            this.payloads.charBooleanPair = PrimitiveTuplesTest::charBooleanPair;
            this.payloads.shortObjectPair = PrimitiveTuplesTest::shortObjectPair;
            this.payloads.shortIntPair = PrimitiveTuplesTest::shortIntPair;
            this.payloads.shortBytePair = PrimitiveTuplesTest::shortBytePair;
            this.payloads.shortCharPair = PrimitiveTuplesTest::shortCharPair;
            this.payloads.shortLongPair = PrimitiveTuplesTest::shortLongPair;
            this.payloads.shortBooleanPair = PrimitiveTuplesTest::shortBooleanPair;
            this.payloads.shortFloatPair = PrimitiveTuplesTest::shortFloatPair;
            this.payloads.shortDoublePair = PrimitiveTuplesTest::shortDoublePair;
            this.payloads.floatObjectPair = PrimitiveTuplesTest::floatObjectPair;
            this.payloads.floatDoublePair = PrimitiveTuplesTest::floatDoublePair;
            this.payloads.floatLongPair = PrimitiveTuplesTest::floatLongPair;
            this.payloads.floatShortPair = PrimitiveTuplesTest::floatShortPair;
            this.payloads.floatBytePair = PrimitiveTuplesTest::floatBytePair;
            this.payloads.floatCharPair = PrimitiveTuplesTest::floatCharPair;
            this.payloads.floatBooleanPair = PrimitiveTuplesTest::floatBooleanPair;
            this.payloads.floatIntPair = PrimitiveTuplesTest::floatIntPair;
            this.payloads.doubleIntPair = PrimitiveTuplesTest::doubleIntPair;
            this.payloads.doubleShortPair = PrimitiveTuplesTest::doubleShortPair;
            this.payloads.doubleCharPair = PrimitiveTuplesTest::doubleCharPair;
            this.payloads.doubleBooleanPair = PrimitiveTuplesTest::doubleBooleanPair;
            this.payloads.doubleBytePair = PrimitiveTuplesTest::doubleBytePair;
            this.payloads.doubleLongPair = PrimitiveTuplesTest::doubleLongPair;
            this.payloads.doubleFloatPair = PrimitiveTuplesTest::doubleFloatPair;
            this.payloads.doubleObjectPair = PrimitiveTuplesTest::doubleObjectPair;
            this.payloads.intFloatPair = PrimitiveTuplesTest::intFloatPair;
            this.payloads.intDoublePair = PrimitiveTuplesTest::intDoublePair;
            this.payloads.intShortPair = PrimitiveTuplesTest::intShortPair;
            this.payloads.intBytePair = PrimitiveTuplesTest::intBytePair;
            this.payloads.intCharPair = PrimitiveTuplesTest::intCharPair;
            this.payloads.longObjectPair = PrimitiveTuplesTest::longObjectPair;
            this.payloads.longIntPair = PrimitiveTuplesTest::longIntPair;
            this.payloads.longFloatPair = PrimitiveTuplesTest::longFloatPair;
            this.payloads.longDoublePair = PrimitiveTuplesTest::longDoublePair;
            this.payloads.longShortPair = PrimitiveTuplesTest::longShortPair;
            this.payloads.longBytePair = PrimitiveTuplesTest::longBytePair;
            this.payloads.longCharPair = PrimitiveTuplesTest::longCharPair;
            this.payloads.longBooleanPair = PrimitiveTuplesTest::longBooleanPair;
            this.payloads.objectCharPair = PrimitiveTuplesTest::objectCharPair;
            this.payloads.objectShortPair = PrimitiveTuplesTest::objectShortPair;
            this.payloads.objectFloatPair = PrimitiveTuplesTest::objectFloatPair;
            this.payloads.objectLongPair = PrimitiveTuplesTest::objectLongPair;
            this.payloads.objectDoublePair = PrimitiveTuplesTest::objectDoublePair;
        }
    }
}
