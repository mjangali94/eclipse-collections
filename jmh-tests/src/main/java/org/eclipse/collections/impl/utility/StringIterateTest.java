/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.utility;

import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.procedure.primitive.CharProcedure;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.CharList;
import org.eclipse.collections.api.list.primitive.ImmutableCharList;
import org.eclipse.collections.api.list.primitive.IntList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.primitive.ImmutableCharSet;
import org.eclipse.collections.api.set.primitive.ImmutableIntSet;
import org.eclipse.collections.api.tuple.Twin;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.block.factory.primitive.CharToCharFunctions;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.block.function.primitive.CodePointFunction;
import org.eclipse.collections.impl.block.predicate.CodePointPredicate;
import org.eclipse.collections.impl.block.procedure.primitive.CodePointProcedure;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.CharSets;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.string.immutable.CharAdapter;
import org.eclipse.collections.impl.string.immutable.CodePointAdapter;
import org.eclipse.collections.impl.string.immutable.CodePointList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link StringIterate}.
 */
public class StringIterateTest {

    public static final String THE_QUICK_BROWN_FOX_JUMPS_OVER_THE_LAZY_DOG = "The quick brown fox jumps over the lazy dog.";

    public static final String ALPHABET_LOWERCASE = "abcdefghijklmnopqrstuvwxyz";

    public static final Twin<String> HALF_ABET = StringIterate.splitAtIndex(ALPHABET_LOWERCASE, 13);

    public static final String TQBFJOTLD_MINUS_HALF_ABET_1 = "t qu rown ox ups ovr t zy o.";

    public static final String TQBFJOTLD_MINUS_HALF_ABET_2 = "he ick b f jm e he la dg.";

    @Test
    public void asCharAdapter() {
        CharAdapter answer = StringIterate.asCharAdapter("HelloHellow").collectChar(Character::toUpperCase).select(c -> c != 'W').distinct().toReversed().reject(CharAdapter.adapt("LE")::contains).newWith('!');
        Assert.assertEquals("OH!", answer.toString());
        Assert.assertEquals("OH!", answer.toStringBuilder().toString());
        Assert.assertEquals("OH!", answer.makeString(""));
        CharList charList = StringIterate.asCharAdapter("HelloHellow").asLazy().collectChar(Character::toUpperCase).select(c -> c != 'W').toList().distinct().toReversed().reject(CharAdapter.adapt("LE")::contains).with('!');
        Assert.assertEquals("OH!", CharAdapter.from(charList).toString());
        Assert.assertEquals("OH!", CharAdapter.from(CharAdapter.from(charList)).toString());
        String helloUppercase2 = StringIterate.asCharAdapter("Hello").asLazy().collectChar(Character::toUpperCase).makeString("");
        Assert.assertEquals("HELLO", helloUppercase2);
        CharArrayList arraylist = new CharArrayList();
        StringIterate.asCharAdapter("Hello".toUpperCase()).chars().sorted().forEach(e -> arraylist.add((char) e));
        Assert.assertEquals(StringIterate.asCharAdapter("EHLLO"), arraylist);
        ImmutableCharList arrayList2 = StringIterate.asCharAdapter("Hello".toUpperCase()).toSortedList().toImmutable();
        Assert.assertEquals(StringIterate.asCharAdapter("EHLLO"), arrayList2);
        Assert.assertEquals(StringIterate.asCharAdapter("HELLO"), CharAdapter.adapt("hello").collectChar(Character::toUpperCase));
    }

    @Test
    public void asCharAdapterExtra() {
        Assert.assertEquals(9, StringIterate.asCharAdapter(THE_QUICK_BROWN_FOX_JUMPS_OVER_THE_LAZY_DOG).count(c -> !Character.isLetter(c)));
        Assert.assertTrue(StringIterate.asCharAdapter(THE_QUICK_BROWN_FOX_JUMPS_OVER_THE_LAZY_DOG).anySatisfy(Character::isWhitespace));
        Assert.assertEquals(8, StringIterate.asCharAdapter(THE_QUICK_BROWN_FOX_JUMPS_OVER_THE_LAZY_DOG).count(Character::isWhitespace));
        Verify.assertSize(26, StringIterate.asCharAdapter(THE_QUICK_BROWN_FOX_JUMPS_OVER_THE_LAZY_DOG).asLazy().select(Character::isLetter).collectChar(Character::toLowerCase).toSet());
        ImmutableCharSet alphaCharAdapter = StringIterate.asCharAdapter(ALPHABET_LOWERCASE).toSet().toImmutable();
        Assert.assertTrue(StringIterate.asCharAdapter(THE_QUICK_BROWN_FOX_JUMPS_OVER_THE_LAZY_DOG).containsAll(alphaCharAdapter));
        Assert.assertEquals(CharSets.immutable.empty(), alphaCharAdapter.newWithoutAll(StringIterate.asCharAdapter(THE_QUICK_BROWN_FOX_JUMPS_OVER_THE_LAZY_DOG.toLowerCase())));
        Assert.assertEquals(TQBFJOTLD_MINUS_HALF_ABET_1, StringIterate.asCharAdapter(THE_QUICK_BROWN_FOX_JUMPS_OVER_THE_LAZY_DOG.toLowerCase()).newWithoutAll(StringIterate.asCharAdapter(HALF_ABET.getOne())).toString());
        Assert.assertEquals(TQBFJOTLD_MINUS_HALF_ABET_2, StringIterate.asCharAdapter(THE_QUICK_BROWN_FOX_JUMPS_OVER_THE_LAZY_DOG.toLowerCase()).newWithoutAll(StringIterate.asCharAdapter(HALF_ABET.getTwo())).toString());
    }

    @Test
    public void buildTheAlphabetFromEmpty() {
        String alphabet = StringIterate.asCharAdapter("").newWith('a').newWithAll(StringIterate.asCharAdapter(HALF_ABET.getOne())).newWithAll(StringIterate.asCharAdapter(HALF_ABET.getTwo())).newWithout('a').toString();
        Assert.assertEquals(ALPHABET_LOWERCASE, alphabet);
    }

    @Test
    public void asCodePointAdapter() {
        CodePointAdapter answer = StringIterate.asCodePointAdapter("HelloHellow").collectInt(Character::toUpperCase).select(i -> i != 'W').distinct().toReversed().reject(CodePointAdapter.adapt("LE")::contains).newWith('!');
        Assert.assertEquals("OH!", answer.toString());
        Assert.assertEquals("OH!", answer.toStringBuilder().toString());
        Assert.assertEquals("OH!", answer.makeString(""));
        IntList intList = StringIterate.asCodePointAdapter("HelloHellow").asLazy().collectInt(Character::toUpperCase).select(i -> i != 'W').toList().distinct().toReversed().reject(CodePointAdapter.adapt("LE")::contains).with('!');
        Assert.assertEquals("OH!", CodePointAdapter.from(intList).toString());
        Assert.assertEquals("OH!", CodePointAdapter.from(CodePointAdapter.from(intList)).toString());
    }

    @Test
    public void asCodePointAdapterExtra() {
        Assert.assertEquals(9, StringIterate.asCodePointAdapter(THE_QUICK_BROWN_FOX_JUMPS_OVER_THE_LAZY_DOG).count(i -> !Character.isLetter(i)));
        Assert.assertTrue(StringIterate.asCodePointAdapter(THE_QUICK_BROWN_FOX_JUMPS_OVER_THE_LAZY_DOG).anySatisfy(Character::isWhitespace));
        Assert.assertEquals(8, StringIterate.asCodePointAdapter(THE_QUICK_BROWN_FOX_JUMPS_OVER_THE_LAZY_DOG).count(Character::isWhitespace));
        Verify.assertSize(26, StringIterate.asCodePointAdapter(THE_QUICK_BROWN_FOX_JUMPS_OVER_THE_LAZY_DOG).asLazy().select(Character::isLetter).collectInt(Character::toLowerCase).toSet());
        ImmutableIntSet alphaints = StringIterate.asCodePointAdapter(ALPHABET_LOWERCASE).toSet().toImmutable();
        Assert.assertTrue(StringIterate.asCodePointAdapter(THE_QUICK_BROWN_FOX_JUMPS_OVER_THE_LAZY_DOG).containsAll(alphaints));
        Assert.assertEquals(IntSets.immutable.empty(), alphaints.newWithoutAll(StringIterate.asCodePointAdapter(THE_QUICK_BROWN_FOX_JUMPS_OVER_THE_LAZY_DOG.toLowerCase())));
        Assert.assertEquals(TQBFJOTLD_MINUS_HALF_ABET_1, StringIterate.asCodePointAdapter(THE_QUICK_BROWN_FOX_JUMPS_OVER_THE_LAZY_DOG.toLowerCase()).newWithoutAll(StringIterate.asCodePointAdapter(HALF_ABET.getOne())).toString());
        Assert.assertEquals(TQBFJOTLD_MINUS_HALF_ABET_2, StringIterate.asCodePointAdapter(THE_QUICK_BROWN_FOX_JUMPS_OVER_THE_LAZY_DOG.toLowerCase()).newWithoutAll(StringIterate.asCodePointAdapter(HALF_ABET.getTwo())).toString());
    }

    @Test
    public void toCodePointList() {
        CodePointList answer = StringIterate.toCodePointList("Hello").collectInt(Character::toUpperCase).select(i -> i != 'W').distinct().toReversed().reject(CodePointList.from("LE")::contains).newWith('!');
        Assert.assertEquals("OH!", answer.toString());
        Assert.assertEquals("OH!", answer.toStringBuilder().toString());
        Assert.assertEquals("OH!", answer.makeString(""));
        IntList intList = StringIterate.toCodePointList("HelloHellow").asLazy().collectInt(Character::toUpperCase).select(i -> i != 'W').toList().distinct().toReversed().reject(CodePointList.from("LE")::contains).with('!');
        Assert.assertEquals("OH!", CodePointList.from(intList).toString());
        Assert.assertEquals("OH!", CodePointList.from(CodePointList.from(intList)).toString());
    }

    @Test
    public void toCodePointListExtra() {
        Assert.assertEquals(9, StringIterate.toCodePointList(THE_QUICK_BROWN_FOX_JUMPS_OVER_THE_LAZY_DOG).count(i -> !Character.isLetter(i)));
        Assert.assertTrue(StringIterate.toCodePointList(THE_QUICK_BROWN_FOX_JUMPS_OVER_THE_LAZY_DOG).anySatisfy(Character::isWhitespace));
        Assert.assertEquals(8, StringIterate.toCodePointList(THE_QUICK_BROWN_FOX_JUMPS_OVER_THE_LAZY_DOG).count(Character::isWhitespace));
        Verify.assertSize(26, StringIterate.toCodePointList(THE_QUICK_BROWN_FOX_JUMPS_OVER_THE_LAZY_DOG).asLazy().select(Character::isLetter).collectInt(Character::toLowerCase).toSet());
        ImmutableIntSet alphaints = StringIterate.toCodePointList(ALPHABET_LOWERCASE).toSet().toImmutable();
        Assert.assertTrue(StringIterate.toCodePointList(THE_QUICK_BROWN_FOX_JUMPS_OVER_THE_LAZY_DOG).containsAll(alphaints));
        Assert.assertEquals(IntSets.immutable.empty(), alphaints.newWithoutAll(StringIterate.toCodePointList(THE_QUICK_BROWN_FOX_JUMPS_OVER_THE_LAZY_DOG.toLowerCase())));
        Assert.assertTrue(StringIterate.toCodePointList(THE_QUICK_BROWN_FOX_JUMPS_OVER_THE_LAZY_DOG).containsAll(StringIterate.toCodePointList(HALF_ABET.getOne())));
        Assert.assertEquals(TQBFJOTLD_MINUS_HALF_ABET_1, StringIterate.toCodePointList(THE_QUICK_BROWN_FOX_JUMPS_OVER_THE_LAZY_DOG.toLowerCase()).newWithoutAll(StringIterate.toCodePointList(HALF_ABET.getOne())).toString());
        Assert.assertEquals(TQBFJOTLD_MINUS_HALF_ABET_2, StringIterate.toCodePointList(THE_QUICK_BROWN_FOX_JUMPS_OVER_THE_LAZY_DOG.toLowerCase()).newWithoutAll(StringIterate.toCodePointList(HALF_ABET.getTwo())).toString());
    }

    @Test
    public void englishToUpperLowerCase() {
        Assert.assertEquals("ABC", StringIterate.englishToUpperCase("abc"));
        Assert.assertEquals("abc", StringIterate.englishToLowerCase("ABC"));
    }

    @Test
    public void collect() {
        Assert.assertEquals("ABC", StringIterate.collect("abc", CharToCharFunctions.toUpperCase()));
        Assert.assertEquals("abc", StringIterate.collect("abc", CharToCharFunctions.toLowerCase()));
    }

    @Test
    public void collectCodePoint() {
        Assert.assertEquals("ABC", StringIterate.collect("abc", CodePointFunction.TO_UPPERCASE));
        Assert.assertEquals("abc", StringIterate.collect("abc", CodePointFunction.TO_LOWERCASE));
    }

    @Test
    public void collectCodePointUnicode() {
        Assert.assertEquals("\u3042\uD840\uDC00\u3044\uD840\uDC03\u3046\uD83D\uDE09", StringIterate.collect("\u3042\uD840\uDC00\u3044\uD840\uDC03\u3046\uD83D\uDE09", CodePointFunction.PASS_THRU));
        Assert.assertEquals("\u3042\uD840\uDC00\u3044\uD840\uDC03\u3046\uD83D\uDE09", StringIterate.collect("\u3042\uD840\uDC00\u3044\uD840\uDC03\u3046\uD83D\uDE09", CodePointFunction.PASS_THRU));
    }

    @Test
    public void englishToUpperCase() {
        Assert.assertEquals("ABC", StringIterate.englishToUpperCase("abc"));
        Assert.assertEquals("A,B,C", StringIterate.englishToUpperCase("a,b,c"));
        Assert.assertSame("A,B,C", StringIterate.englishToUpperCase("A,B,C"));
    }

    @Test
    public void englishToLowerCase() {
        Assert.assertEquals("abc", StringIterate.englishToLowerCase("ABC"));
        Assert.assertEquals("a,b,c", StringIterate.englishToLowerCase("A,B,C"));
        Assert.assertSame("a,b,c", StringIterate.englishToLowerCase("a,b,c"));
    }

    @Test
    public void englishIsUpperLowerCase() {
        String allValues = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890~`!@#$%^&*()_-+=[]{};<>,.?/|";
        String jdkUpper = allValues.toUpperCase();
        String upper = StringIterate.englishToUpperCase(allValues);
        Assert.assertEquals(jdkUpper.length(), upper.length());
        Assert.assertEquals(jdkUpper, upper);
        String jdkLower = allValues.toLowerCase();
        String lower = StringIterate.englishToLowerCase(allValues);
        Assert.assertEquals(jdkLower.length(), lower.length());
        Assert.assertEquals(jdkLower, lower);
    }

    @Test
    public void select() {
        String string = StringIterate.select("1a2a3", CharPredicates.isDigit());
        Assert.assertEquals("123", string);
    }

    @Test
    public void selectCodePoint() {
        String string = StringIterate.select("1a2a3", CodePointPredicate.IS_DIGIT);
        Assert.assertEquals("123", string);
    }

    @Test
    public void selectCodePointUnicode() {
        String string = StringIterate.select("\u3042\uD840\uDC00\u3044\uD840\uDC03\u3046\uD83D\uDE09", CodePointPredicate.IS_BMP);
        Assert.assertEquals("\u3042\u3044\u3046", string);
    }

    @Test
    public void detect() {
        char character = StringIterate.detect("1a2a3", CharPredicates.isLetter());
        Assert.assertEquals('a', character);
    }

    @Test
    public void detectIfNone() {
        char character = StringIterate.detectIfNone("123", CharPredicates.isLetter(), "b".charAt(0));
        Assert.assertEquals('b', character);
    }

    @Test
    public void detectIfNoneWithString() {
        char character = StringIterate.detectIfNone("123", CharPredicates.isLetter(), "b");
        Assert.assertEquals('b', character);
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(StringIterate.allSatisfy("MARY", CharPredicates.isUpperCase()));
        Assert.assertFalse(StringIterate.allSatisfy("Mary", CharPredicates.isUpperCase()));
    }

    @Test
    public void allSatisfyCodePoint() {
        Assert.assertTrue(StringIterate.allSatisfy("MARY", CodePointPredicate.IS_UPPERCASE));
        Assert.assertFalse(StringIterate.allSatisfy("Mary", CodePointPredicate.IS_UPPERCASE));
    }

    @Test
    public void allSatisfyCodePointUnicode() {
        Assert.assertTrue(StringIterate.allSatisfy("\u3042\u3044\u3046", CodePointPredicate.IS_BMP));
        Assert.assertFalse(StringIterate.allSatisfy("\uD840\uDC00\uD840\uDC03\uD83D\uDE09", CodePointPredicate.IS_BMP));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(StringIterate.anySatisfy("MARY", CharPredicates.isUpperCase()));
        Assert.assertFalse(StringIterate.anySatisfy("mary", CharPredicates.isUpperCase()));
    }

    @Test
    public void anySatisfyCodePoint() {
        Assert.assertTrue(StringIterate.anySatisfy("MARY", CodePointPredicate.IS_UPPERCASE));
        Assert.assertFalse(StringIterate.anySatisfy("mary", CodePointPredicate.IS_UPPERCASE));
    }

    @Test
    public void anySatisfyCodePointUnicode() {
        Assert.assertTrue(StringIterate.anySatisfy("\u3042\u3044\u3046", CodePointPredicate.IS_BMP));
        Assert.assertFalse(StringIterate.anySatisfy("\uD840\uDC00\uD840\uDC03\uD83D\uDE09", CodePointPredicate.IS_BMP));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(StringIterate.noneSatisfy("MaRy", CharPredicates.isUpperCase()));
        Assert.assertTrue(StringIterate.noneSatisfy("mary", CharPredicates.isUpperCase()));
    }

    @Test
    public void noneSatisfyCodePoint() {
        Assert.assertFalse(StringIterate.noneSatisfy("MaRy", CodePointPredicate.IS_UPPERCASE));
        Assert.assertTrue(StringIterate.noneSatisfy("mary", CodePointPredicate.IS_UPPERCASE));
    }

    @Test
    public void noneSatisfyCodePointUnicode() {
        Assert.assertFalse(StringIterate.noneSatisfy("\u3042\u3044\u3046", CodePointPredicate.IS_BMP));
        Assert.assertTrue(StringIterate.noneSatisfy("\uD840\uDC00\uD840\uDC03\uD83D\uDE09", CodePointPredicate.IS_BMP));
    }

    @Test
    public void isNumber() {
        Assert.assertTrue(StringIterate.isNumber("123"));
        Assert.assertFalse(StringIterate.isNumber("abc"));
        Assert.assertFalse(StringIterate.isNumber(""));
    }

    @Test
    public void isAlphaNumeric() {
        Assert.assertTrue(StringIterate.isAlphaNumeric("123"));
        Assert.assertTrue(StringIterate.isAlphaNumeric("abc"));
        Assert.assertTrue(StringIterate.isAlphaNumeric("123abc"));
        Assert.assertFalse(StringIterate.isAlphaNumeric("!@#"));
        Assert.assertFalse(StringIterate.isAlphaNumeric(""));
    }

    @Test
    public void csvTokensToList() {
        String tokens = "Ted,Mary  ";
        MutableList<String> results = StringIterate.csvTokensToList(tokens);
        Verify.assertSize(2, results);
        Verify.assertStartsWith(results, "Ted", "Mary  ");
    }

    @Test
    public void csvTokensToSortedList() {
        String tokens = " Ted, Mary ";
        MutableList<String> results = StringIterate.csvTokensToSortedList(tokens);
        Verify.assertSize(2, results);
        Verify.assertStartsWith(results, " Mary ", " Ted");
    }

    @Test
    public void csvTrimmedTokensToSortedList() {
        String tokens = " Ted,Mary ";
        MutableList<String> results = StringIterate.csvTrimmedTokensToSortedList(tokens);
        Verify.assertSize(2, results);
        Verify.assertStartsWith(results, "Mary", "Ted");
    }

    @Test
    public void csvTokensToSet() {
        String tokens = "Ted,Mary";
        MutableSet<String> results = StringIterate.csvTokensToSet(tokens);
        Verify.assertSize(2, results);
        Verify.assertContainsAll(results, "Mary", "Ted");
    }

    @Test
    public void csvTokensToReverseSortedList() {
        String tokens = "Ted,Mary";
        MutableList<String> results = StringIterate.csvTokensToReverseSortedList(tokens);
        Verify.assertSize(2, results);
    }

    @Test
    public void tokensToMap() {
        String tokens = "1:Ted|2:Mary";
        MutableMap<String, String> results = StringIterate.tokensToMap(tokens);
        Verify.assertSize(2, results);
        Verify.assertContainsKeyValue("1", "Ted", results);
        Verify.assertContainsKeyValue("2", "Mary", results);
    }

    @Test
    public void tokensToMapWithFunctions() {
        String tokens = "1:Ted|2:Mary";
        Function<String, String> stringPassThruFunction = Functions.getPassThru();
        MutableMap<Integer, String> results = StringIterate.tokensToMap(tokens, "|", ":", Integer::valueOf, stringPassThruFunction);
        Verify.assertSize(2, results);
        Verify.assertContainsKeyValue(1, "Ted", results);
        Verify.assertContainsKeyValue(2, "Mary", results);
    }

    @Test
    public void reject() {
        String string = StringIterate.reject("1a2b3c", CharPredicates.isDigit());
        Assert.assertEquals("abc", string);
    }

    @Test
    public void rejectCodePoint() {
        String string = StringIterate.reject("1a2b3c", CodePointPredicate.IS_DIGIT);
        Assert.assertEquals("abc", string);
    }

    @Test
    public void count() {
        int count = StringIterate.count("1a2a3", CharPredicates.isDigit());
        Assert.assertEquals(3, count);
    }

    @Test
    public void countCodePoint() {
        int count = StringIterate.count("1a2a3", CodePointPredicate.IS_DIGIT);
        Assert.assertEquals(3, count);
    }

    @Test
    public void occurrencesOf() {
        int count = StringIterate.occurrencesOf("1a2a3", 'a');
        Assert.assertEquals(2, count);
    }

    @Test(expected = IllegalArgumentException.class)
    public void occurrencesOf_multiple_character_string_throws() {
        StringIterate.occurrencesOf("1a2a3", "abc");
    }

    @Test
    public void occurrencesOfCodePoint() {
        int count = StringIterate.occurrencesOf("1a2a3", "a".codePointAt(0));
        Assert.assertEquals(2, count);
    }

    @Test
    public void occurrencesOfString() {
        int count = StringIterate.occurrencesOf("1a2a3", "a");
        Assert.assertEquals(2, count);
    }

    @Test
    public void count2() {
        int count = StringIterate.count("1a2a3", CharPredicates.isUndefined());
        Assert.assertEquals(0, count);
    }

    @Test
    public void count2CodePoint() {
        int count = StringIterate.count("1a2a3", CodePointPredicate.IS_UNDEFINED);
        Assert.assertEquals(0, count);
    }

    @Test
    public void forEach() {
        StringBuilder builder = new StringBuilder();
        StringIterate.forEach("1a2b3c", (CharProcedure) builder::append);
        Assert.assertEquals("1a2b3c", builder.toString());
    }

    @Test
    public void forEachCodePoint() {
        StringBuilder builder = new StringBuilder();
        StringIterate.forEach("1a2b3c", (CodePointProcedure) builder::appendCodePoint);
        Assert.assertEquals("1a2b3c", builder.toString());
    }

    @Test
    public void forEachCodePointUnicode() {
        StringBuilder builder = new StringBuilder();
        StringIterate.forEach("\u3042\uD840\uDC00\u3044\uD840\uDC03\u3046\uD83D\uDE09", (CodePointProcedure) builder::appendCodePoint);
        Assert.assertEquals("\u3042\uD840\uDC00\u3044\uD840\uDC03\u3046\uD83D\uDE09", builder.toString());
    }

    @Test
    public void reverseForEach() {
        StringBuilder builder = new StringBuilder();
        StringIterate.reverseForEach("1a2b3c", (CharProcedure) builder::append);
        Assert.assertEquals("c3b2a1", builder.toString());
        StringIterate.reverseForEach("", (char character) -> Assert.fail());
    }

    @Test
    public void reverseForEachCodePoint() {
        StringBuilder builder = new StringBuilder();
        StringIterate.reverseForEach("1a2b3c", (CodePointProcedure) builder::appendCodePoint);
        Assert.assertEquals("c3b2a1", builder.toString());
        StringIterate.reverseForEach("", (int codePoint) -> Assert.fail());
    }

    @Test
    public void reverseForEachCodePointUnicode() {
        StringBuilder builder = new StringBuilder();
        StringIterate.reverseForEach("\u3042\uD840\uDC00\u3044\uD840\uDC03\u3046\uD83D\uDE09", (CodePointProcedure) builder::appendCodePoint);
        Assert.assertEquals("\uD83D\uDE09\u3046\uD840\uDC03\u3044\uD840\uDC00\u3042", builder.toString());
        StringIterate.reverseForEach("", (int codePoint) -> Assert.fail());
    }

    @Test
    public void reverseForEachCodePointInvalidUnicode() {
        StringBuilder builder = new StringBuilder();
        StringIterate.reverseForEach("\u3042\uDC00\uD840\u3044\uDC03\uD840\u3046\uDE09\uD83D", (CodePointProcedure) builder::appendCodePoint);
        Assert.assertEquals("\uD83D\uDE09\u3046\uD840\uDC03\u3044\uD840\uDC00\u3042", builder.toString());
        StringBuilder builder2 = new StringBuilder();
        StringIterate.reverseForEach("\u3042\uD840\u3044\uD840\u3046\uD840", (CodePointProcedure) builder2::appendCodePoint);
        Assert.assertEquals("\uD840\u3046\uD840\u3044\uD840\u3042", builder2.toString());
        StringBuilder builder3 = new StringBuilder();
        StringIterate.reverseForEach("\u3042\uDC00\u3044\uDC03\u3046\uDC06", (CodePointProcedure) builder3::appendCodePoint);
        Assert.assertEquals("\uDC06\u3046\uDC03\u3044\uDC00\u3042", builder3.toString());
        StringIterate.reverseForEach("", (int codePoint) -> Assert.fail());
    }

    @Test
    public void forEachToken() {
        String tokens = "1,2";
        MutableList<Integer> list = Lists.mutable.of();
        StringIterate.forEachToken(tokens, ",", Procedures.throwing(string -> list.add(Integer.valueOf(string))));
        Verify.assertSize(2, list);
        Verify.assertContains(1, list);
        Verify.assertContains(2, list);
    }

    @Test
    public void forEachTrimmedToken() {
        String tokens = " 1,2 ";
        MutableList<Integer> list = Lists.mutable.of();
        StringIterate.forEachTrimmedToken(tokens, ",", Procedures.throwing(string -> list.add(Integer.valueOf(string))));
        Verify.assertSize(2, list);
        Verify.assertContains(1, list);
        Verify.assertContains(2, list);
    }

    @Test
    public void csvTrimmedTokenToList() {
        String tokens = " 1,2 ";
        Assert.assertEquals(FastList.newListWith("1", "2"), StringIterate.csvTrimmedTokensToList(tokens));
    }

    @Test
    public void injectIntoTokens() {
        Assert.assertEquals("123", StringIterate.injectIntoTokens("1,2,3", ",", null, AddFunction.STRING));
    }

    @Test
    public void getLastToken() {
        Assert.assertEquals("charlie", StringIterate.getLastToken("alpha~|~beta~|~charlie", "~|~"));
        Assert.assertEquals("123", StringIterate.getLastToken("123", "~|~"));
        Assert.assertEquals("", StringIterate.getLastToken("", "~|~"));
        Assert.assertNull(StringIterate.getLastToken(null, "~|~"));
        Assert.assertEquals("", StringIterate.getLastToken("123~|~", "~|~"));
        Assert.assertEquals("123", StringIterate.getLastToken("~|~123", "~|~"));
    }

    @Test
    public void getFirstToken() {
        Assert.assertEquals("alpha", StringIterate.getFirstToken("alpha~|~beta~|~charlie", "~|~"));
        Assert.assertEquals("123", StringIterate.getFirstToken("123", "~|~"));
        Assert.assertEquals("", StringIterate.getFirstToken("", "~|~"));
        Assert.assertNull(StringIterate.getFirstToken(null, "~|~"));
        Assert.assertEquals("123", StringIterate.getFirstToken("123~|~", "~|~"));
        Assert.assertEquals("", StringIterate.getFirstToken("~|~123,", "~|~"));
    }

    @Test
    public void isEmptyOrWhitespace() {
        Assert.assertTrue(StringIterate.isEmptyOrWhitespace("   "));
        Assert.assertFalse(StringIterate.isEmptyOrWhitespace(" 1  "));
    }

    @Test
    public void notEmptyOrWhitespace() {
        Assert.assertFalse(StringIterate.notEmptyOrWhitespace("   "));
        Assert.assertTrue(StringIterate.notEmptyOrWhitespace(" 1  "));
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(StringIterate.isEmpty(""));
        Assert.assertFalse(StringIterate.isEmpty("   "));
        Assert.assertFalse(StringIterate.isEmpty("1"));
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(StringIterate.notEmpty(""));
        Assert.assertTrue(StringIterate.notEmpty("   "));
        Assert.assertTrue(StringIterate.notEmpty("1"));
    }

    @Test
    public void repeat() {
        Assert.assertEquals("", StringIterate.repeat("", 42));
        Assert.assertEquals("    ", StringIterate.repeat(' ', 4));
        Assert.assertEquals("        ", StringIterate.repeat(" ", 8));
        Assert.assertEquals("CubedCubedCubed", StringIterate.repeat("Cubed", 3));
    }

    @Test
    public void padOrTrim() {
        Assert.assertEquals("abcdefghijkl", StringIterate.padOrTrim("abcdefghijkl", 12));
        Assert.assertEquals("this n", StringIterate.padOrTrim("this needs to be trimmed", 6));
        Assert.assertEquals("pad this      ", StringIterate.padOrTrim("pad this", 14));
    }

    @Test
    public void string() {
        Assert.assertEquals("Token2", StringIterate.getLastToken("Token1DelimiterToken2", "Delimiter"));
    }

    @Test
    public void toList() {
        Assert.assertEquals(FastList.newListWith('a', 'a', 'b', 'c', 'd', 'e'), StringIterate.toList("aabcde"));
    }

    @Test
    public void toLowercaseList() {
        MutableList<Character> set = StringIterate.toLowercaseList("America");
        Assert.assertEquals(FastList.newListWith('a', 'm', 'e', 'r', 'i', 'c', 'a'), set);
    }

    @Test
    public void toUppercaseList() {
        MutableList<Character> set = StringIterate.toUppercaseList("America");
        Assert.assertEquals(FastList.newListWith('A', 'M', 'E', 'R', 'I', 'C', 'A'), set);
    }

    @Test
    public void toSet() {
        Verify.assertSetsEqual(UnifiedSet.newSetWith('a', 'b', 'c', 'd', 'e'), StringIterate.toSet("aabcde"));
    }

    @Test
    public void chunk() {
        Assert.assertEquals(Lists.immutable.with("ab", "cd", "ef"), StringIterate.chunk("abcdef", 2));
        Assert.assertEquals(Lists.immutable.with("abc", "def"), StringIterate.chunk("abcdef", 3));
        Assert.assertEquals(Lists.immutable.with("abc", "def", "g"), StringIterate.chunk("abcdefg", 3));
        Assert.assertEquals(Lists.immutable.with("abcdef"), StringIterate.chunk("abcdef", 6));
        Assert.assertEquals(Lists.immutable.with("abcdef"), StringIterate.chunk("abcdef", 7));
        Assert.assertEquals(Lists.immutable.with(), StringIterate.chunk("", 2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunkWithZeroSize() {
        StringIterate.chunk("abcdef", 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunkWithNegativeSize() {
        StringIterate.chunk("abcdef", -42);
    }

    @Test
    public void toLowercaseSet() {
        MutableSet<Character> set = StringIterate.toLowercaseSet("America");
        Assert.assertEquals(UnifiedSet.newSetWith('a', 'm', 'e', 'r', 'i', 'c'), set);
        Assert.assertEquals(StringIterate.asLowercaseSet("America"), set);
    }

    @Test
    public void toUppercaseSet() {
        MutableSet<Character> set = StringIterate.toUppercaseSet("America");
        Assert.assertEquals(UnifiedSet.newSetWith('A', 'M', 'E', 'R', 'I', 'C'), set);
        Assert.assertEquals(StringIterate.asUppercaseSet("America"), set);
    }

    @Test
    public void splitAtIndex() {
        String oompaLoompa = "oompaloompa";
        Assert.assertEquals(Tuples.twin("oompa", "loompa"), StringIterate.splitAtIndex(oompaLoompa, 5));
        Assert.assertEquals(Tuples.twin("", oompaLoompa), StringIterate.splitAtIndex(oompaLoompa, 0));
        Assert.assertEquals(Tuples.twin(oompaLoompa, ""), StringIterate.splitAtIndex(oompaLoompa, oompaLoompa.length()));
        Assert.assertEquals(Tuples.twin("", ""), StringIterate.splitAtIndex("", 0));
        Assert.assertThrows(StringIndexOutOfBoundsException.class, () -> StringIterate.splitAtIndex(oompaLoompa, 17));
        Assert.assertThrows(StringIndexOutOfBoundsException.class, () -> StringIterate.splitAtIndex(oompaLoompa, -8));
    }

    @Test
    public void toLowercaseBag() {
        MutableBag<Character> lowercaseBag = StringIterate.toLowercaseBag("America");
        Assert.assertEquals(2, lowercaseBag.occurrencesOf(Character.valueOf('a')));
        Assert.assertEquals(1, lowercaseBag.occurrencesOf(Character.valueOf('m')));
        Assert.assertEquals(1, lowercaseBag.occurrencesOf(Character.valueOf('e')));
        Assert.assertEquals(1, lowercaseBag.occurrencesOf(Character.valueOf('r')));
        Assert.assertEquals(1, lowercaseBag.occurrencesOf(Character.valueOf('i')));
        Assert.assertEquals(1, lowercaseBag.occurrencesOf(Character.valueOf('c')));
    }

    @Test
    public void toUppercaseBag() {
        MutableBag<Character> uppercaseBag = StringIterate.toUppercaseBag("America");
        Assert.assertEquals(2, uppercaseBag.occurrencesOf(Character.valueOf('A')));
        Assert.assertEquals(1, uppercaseBag.occurrencesOf(Character.valueOf('M')));
        Assert.assertEquals(1, uppercaseBag.occurrencesOf(Character.valueOf('E')));
        Assert.assertEquals(1, uppercaseBag.occurrencesOf(Character.valueOf('R')));
        Assert.assertEquals(1, uppercaseBag.occurrencesOf(Character.valueOf('I')));
        Assert.assertEquals(1, uppercaseBag.occurrencesOf(Character.valueOf('C')));
    }

    @Test
    public void toBag() {
        MutableBag<Character> bag = StringIterate.toBag("America");
        Assert.assertEquals(1, bag.occurrencesOf(Character.valueOf('A')));
        Assert.assertEquals(1, bag.occurrencesOf(Character.valueOf('m')));
        Assert.assertEquals(1, bag.occurrencesOf(Character.valueOf('e')));
        Assert.assertEquals(1, bag.occurrencesOf(Character.valueOf('r')));
        Assert.assertEquals(1, bag.occurrencesOf(Character.valueOf('i')));
        Assert.assertEquals(1, bag.occurrencesOf(Character.valueOf('c')));
        Assert.assertEquals(1, bag.occurrencesOf(Character.valueOf('a')));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(StringIterate.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private StringIterateTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asCharAdapter() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asCharAdapter);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asCharAdapterExtra() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asCharAdapterExtra);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_buildTheAlphabetFromEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.buildTheAlphabetFromEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asCodePointAdapter() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asCodePointAdapter);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asCodePointAdapterExtra() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asCodePointAdapterExtra);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toCodePointList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toCodePointList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toCodePointListExtra() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toCodePointListExtra);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_englishToUpperLowerCase() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.englishToUpperLowerCase);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCodePoint() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCodePoint);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCodePointUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCodePointUnicode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_englishToUpperCase() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.englishToUpperCase);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_englishToLowerCase() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.englishToLowerCase);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_englishIsUpperLowerCase() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.englishIsUpperLowerCase);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectCodePoint() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectCodePoint);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectCodePointUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectCodePointUnicode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNoneWithString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNoneWithString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyCodePoint() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyCodePoint);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyCodePointUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyCodePointUnicode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyCodePoint() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyCodePoint);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyCodePointUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyCodePointUnicode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyCodePoint() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyCodePoint);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyCodePointUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyCodePointUnicode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isNumber() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isNumber);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isAlphaNumeric() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isAlphaNumeric);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_csvTokensToList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.csvTokensToList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_csvTokensToSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.csvTokensToSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_csvTrimmedTokensToSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.csvTrimmedTokensToSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_csvTokensToSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.csvTokensToSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_csvTokensToReverseSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.csvTokensToReverseSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tokensToMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tokensToMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tokensToMapWithFunctions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tokensToMapWithFunctions);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectCodePoint() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectCodePoint);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countCodePoint() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countCodePoint);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occurrencesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occurrencesOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occurrencesOf_multiple_character_string_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occurrencesOf_multiple_character_string_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occurrencesOfCodePoint() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occurrencesOfCodePoint);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occurrencesOfString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occurrencesOfString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count2);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count2CodePoint() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count2CodePoint);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachCodePoint() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachCodePoint);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachCodePointUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachCodePointUnicode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseForEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseForEachCodePoint() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseForEachCodePoint);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseForEachCodePointUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseForEachCodePointUnicode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseForEachCodePointInvalidUnicode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseForEachCodePointInvalidUnicode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachToken() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachToken);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachTrimmedToken() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachTrimmedToken);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_csvTrimmedTokenToList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.csvTrimmedTokenToList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoTokens() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoTokens);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLastToken() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLastToken);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirstToken() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirstToken);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmptyOrWhitespace() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmptyOrWhitespace);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmptyOrWhitespace() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmptyOrWhitespace);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_repeat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.repeat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_padOrTrim() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.padOrTrim);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_string() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.string);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toLowercaseList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toLowercaseList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toUppercaseList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toUppercaseList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunkWithZeroSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunkWithZeroSize);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunkWithNegativeSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunkWithNegativeSize);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toLowercaseSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toLowercaseSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toUppercaseSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toUppercaseSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_splitAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.splitAtIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toLowercaseBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toLowercaseBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toUppercaseBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toUppercaseBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> payload) throws java.lang.Throwable {
            this.instance = new StringIterateTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> asCharAdapter;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> asCharAdapterExtra;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> buildTheAlphabetFromEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> asCodePointAdapter;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> asCodePointAdapterExtra;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> toCodePointList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> toCodePointListExtra;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> englishToUpperLowerCase;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> collectCodePoint;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> collectCodePointUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> englishToUpperCase;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> englishToLowerCase;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> englishIsUpperLowerCase;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> selectCodePoint;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> selectCodePointUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> detectIfNoneWithString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> allSatisfyCodePoint;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> allSatisfyCodePointUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> anySatisfyCodePoint;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> anySatisfyCodePointUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> noneSatisfyCodePoint;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> noneSatisfyCodePointUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> isNumber;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> isAlphaNumeric;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> csvTokensToList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> csvTokensToSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> csvTrimmedTokensToSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> csvTokensToSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> csvTokensToReverseSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> tokensToMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> tokensToMapWithFunctions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> rejectCodePoint;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> countCodePoint;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> occurrencesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> occurrencesOf_multiple_character_string_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> occurrencesOfCodePoint;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> occurrencesOfString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> count2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> count2CodePoint;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> forEachCodePoint;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> forEachCodePointUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> reverseForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> reverseForEachCodePoint;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> reverseForEachCodePointUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> reverseForEachCodePointInvalidUnicode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> forEachToken;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> forEachTrimmedToken;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> csvTrimmedTokenToList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> injectIntoTokens;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> getLastToken;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> getFirstToken;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> isEmptyOrWhitespace;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> notEmptyOrWhitespace;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> repeat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> padOrTrim;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> string;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> toLowercaseList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> toUppercaseList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> chunkWithZeroSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> chunkWithNegativeSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> toLowercaseSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> toUppercaseSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> splitAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> toLowercaseBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> toUppercaseBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<StringIterateTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.asCharAdapter = StringIterateTest::asCharAdapter;
            this.payloads.asCharAdapterExtra = StringIterateTest::asCharAdapterExtra;
            this.payloads.buildTheAlphabetFromEmpty = StringIterateTest::buildTheAlphabetFromEmpty;
            this.payloads.asCodePointAdapter = StringIterateTest::asCodePointAdapter;
            this.payloads.asCodePointAdapterExtra = StringIterateTest::asCodePointAdapterExtra;
            this.payloads.toCodePointList = StringIterateTest::toCodePointList;
            this.payloads.toCodePointListExtra = StringIterateTest::toCodePointListExtra;
            this.payloads.englishToUpperLowerCase = StringIterateTest::englishToUpperLowerCase;
            this.payloads.collect = StringIterateTest::collect;
            this.payloads.collectCodePoint = StringIterateTest::collectCodePoint;
            this.payloads.collectCodePointUnicode = StringIterateTest::collectCodePointUnicode;
            this.payloads.englishToUpperCase = StringIterateTest::englishToUpperCase;
            this.payloads.englishToLowerCase = StringIterateTest::englishToLowerCase;
            this.payloads.englishIsUpperLowerCase = StringIterateTest::englishIsUpperLowerCase;
            this.payloads.select = StringIterateTest::select;
            this.payloads.selectCodePoint = StringIterateTest::selectCodePoint;
            this.payloads.selectCodePointUnicode = StringIterateTest::selectCodePointUnicode;
            this.payloads.detect = StringIterateTest::detect;
            this.payloads.detectIfNone = StringIterateTest::detectIfNone;
            this.payloads.detectIfNoneWithString = StringIterateTest::detectIfNoneWithString;
            this.payloads.allSatisfy = StringIterateTest::allSatisfy;
            this.payloads.allSatisfyCodePoint = StringIterateTest::allSatisfyCodePoint;
            this.payloads.allSatisfyCodePointUnicode = StringIterateTest::allSatisfyCodePointUnicode;
            this.payloads.anySatisfy = StringIterateTest::anySatisfy;
            this.payloads.anySatisfyCodePoint = StringIterateTest::anySatisfyCodePoint;
            this.payloads.anySatisfyCodePointUnicode = StringIterateTest::anySatisfyCodePointUnicode;
            this.payloads.noneSatisfy = StringIterateTest::noneSatisfy;
            this.payloads.noneSatisfyCodePoint = StringIterateTest::noneSatisfyCodePoint;
            this.payloads.noneSatisfyCodePointUnicode = StringIterateTest::noneSatisfyCodePointUnicode;
            this.payloads.isNumber = StringIterateTest::isNumber;
            this.payloads.isAlphaNumeric = StringIterateTest::isAlphaNumeric;
            this.payloads.csvTokensToList = StringIterateTest::csvTokensToList;
            this.payloads.csvTokensToSortedList = StringIterateTest::csvTokensToSortedList;
            this.payloads.csvTrimmedTokensToSortedList = StringIterateTest::csvTrimmedTokensToSortedList;
            this.payloads.csvTokensToSet = StringIterateTest::csvTokensToSet;
            this.payloads.csvTokensToReverseSortedList = StringIterateTest::csvTokensToReverseSortedList;
            this.payloads.tokensToMap = StringIterateTest::tokensToMap;
            this.payloads.tokensToMapWithFunctions = StringIterateTest::tokensToMapWithFunctions;
            this.payloads.reject = StringIterateTest::reject;
            this.payloads.rejectCodePoint = StringIterateTest::rejectCodePoint;
            this.payloads.count = StringIterateTest::count;
            this.payloads.countCodePoint = StringIterateTest::countCodePoint;
            this.payloads.occurrencesOf = StringIterateTest::occurrencesOf;
            this.payloads.occurrencesOf_multiple_character_string_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(StringIterateTest::occurrencesOf_multiple_character_string_throws, java.lang.IllegalArgumentException.class);
            this.payloads.occurrencesOfCodePoint = StringIterateTest::occurrencesOfCodePoint;
            this.payloads.occurrencesOfString = StringIterateTest::occurrencesOfString;
            this.payloads.count2 = StringIterateTest::count2;
            this.payloads.count2CodePoint = StringIterateTest::count2CodePoint;
            this.payloads.forEach = StringIterateTest::forEach;
            this.payloads.forEachCodePoint = StringIterateTest::forEachCodePoint;
            this.payloads.forEachCodePointUnicode = StringIterateTest::forEachCodePointUnicode;
            this.payloads.reverseForEach = StringIterateTest::reverseForEach;
            this.payloads.reverseForEachCodePoint = StringIterateTest::reverseForEachCodePoint;
            this.payloads.reverseForEachCodePointUnicode = StringIterateTest::reverseForEachCodePointUnicode;
            this.payloads.reverseForEachCodePointInvalidUnicode = StringIterateTest::reverseForEachCodePointInvalidUnicode;
            this.payloads.forEachToken = StringIterateTest::forEachToken;
            this.payloads.forEachTrimmedToken = StringIterateTest::forEachTrimmedToken;
            this.payloads.csvTrimmedTokenToList = StringIterateTest::csvTrimmedTokenToList;
            this.payloads.injectIntoTokens = StringIterateTest::injectIntoTokens;
            this.payloads.getLastToken = StringIterateTest::getLastToken;
            this.payloads.getFirstToken = StringIterateTest::getFirstToken;
            this.payloads.isEmptyOrWhitespace = StringIterateTest::isEmptyOrWhitespace;
            this.payloads.notEmptyOrWhitespace = StringIterateTest::notEmptyOrWhitespace;
            this.payloads.isEmpty = StringIterateTest::isEmpty;
            this.payloads.notEmpty = StringIterateTest::notEmpty;
            this.payloads.repeat = StringIterateTest::repeat;
            this.payloads.padOrTrim = StringIterateTest::padOrTrim;
            this.payloads.string = StringIterateTest::string;
            this.payloads.toList = StringIterateTest::toList;
            this.payloads.toLowercaseList = StringIterateTest::toLowercaseList;
            this.payloads.toUppercaseList = StringIterateTest::toUppercaseList;
            this.payloads.toSet = StringIterateTest::toSet;
            this.payloads.chunk = StringIterateTest::chunk;
            this.payloads.chunkWithZeroSize = new se.chalmers.ju2jmh.api.ExceptionTest<>(StringIterateTest::chunkWithZeroSize, java.lang.IllegalArgumentException.class);
            this.payloads.chunkWithNegativeSize = new se.chalmers.ju2jmh.api.ExceptionTest<>(StringIterateTest::chunkWithNegativeSize, java.lang.IllegalArgumentException.class);
            this.payloads.toLowercaseSet = StringIterateTest::toLowercaseSet;
            this.payloads.toUppercaseSet = StringIterateTest::toUppercaseSet;
            this.payloads.splitAtIndex = StringIterateTest::splitAtIndex;
            this.payloads.toLowercaseBag = StringIterateTest::toLowercaseBag;
            this.payloads.toUppercaseBag = StringIterateTest::toUppercaseBag;
            this.payloads.toBag = StringIterateTest::toBag;
            this.payloads.classIsNonInstantiable = StringIterateTest::classIsNonInstantiable;
        }
    }
}
