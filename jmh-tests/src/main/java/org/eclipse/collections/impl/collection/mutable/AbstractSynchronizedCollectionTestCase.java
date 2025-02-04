/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.collection.mutable;

import org.eclipse.collections.api.collection.MutableCollection;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractSynchronizedCollectionTestCase extends AbstractCollectionTestCase {

    @Override
    @Test
    public void testToString() {
        MutableCollection<Object> collection = this.newWith(1, 2);
        String string = collection.toString();
        Assert.assertTrue("[1, 2]".equals(string) || "[2, 1]".equals(string));
    }

    @Override
    @Test
    public void makeString() {
        MutableCollection<Object> collection = this.newWith(1, 2, 3);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Override
    @Test
    public void appendString() {
        MutableCollection<Object> collection = this.newWith(1, 2, 3);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Override
    @Test
    public void asSynchronized() {
        MutableCollection<Object> collection = this.newWith();
        Assert.assertSame(collection, collection.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractSynchronizedCollectionTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_safe);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_safe);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minByOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxByOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNoneBlock() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNoneBlock);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAny() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAny);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_not_only_one_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_not_only_one_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding1);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding2);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding1);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding2);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumInteger);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloatConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloatConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDoubleConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDoubleConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_null);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_null);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedListBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortSet_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSet_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSetBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy_with_null);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMapBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBiMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBiMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparatorAndStartAndEnd);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_fusedCollectMakeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.fusedCollectMakeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparatorAndStartAndEnd);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringThrows);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws_for_duplicate);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_for_duplicate);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_single() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_single);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithWithWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithVarArgs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithVarArgs);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectAndRejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectAndRejectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIfWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIfWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_largeCollectionStreamToBagMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.largeCollectionStreamToBagMultimap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractSynchronizedCollectionTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractSynchronizedCollectionTestCase> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = AbstractSynchronizedCollectionTestCase::testNewCollection;
            this.payloads.equalsAndHashCode = AbstractSynchronizedCollectionTestCase::equalsAndHashCode;
            this.payloads.contains = AbstractSynchronizedCollectionTestCase::contains;
            this.payloads.containsBy = AbstractSynchronizedCollectionTestCase::containsBy;
            this.payloads.containsAllIterable = AbstractSynchronizedCollectionTestCase::containsAllIterable;
            this.payloads.containsAnyIterable = AbstractSynchronizedCollectionTestCase::containsAnyIterable;
            this.payloads.containsNoneIterable = AbstractSynchronizedCollectionTestCase::containsNoneIterable;
            this.payloads.containsAllArray = AbstractSynchronizedCollectionTestCase::containsAllArray;
            this.payloads.containsAnyCollection = AbstractSynchronizedCollectionTestCase::containsAnyCollection;
            this.payloads.containsNoneCollection = AbstractSynchronizedCollectionTestCase::containsNoneCollection;
            this.payloads.containsAllCollection = AbstractSynchronizedCollectionTestCase::containsAllCollection;
            this.payloads.tap = AbstractSynchronizedCollectionTestCase::tap;
            this.payloads.forEach = AbstractSynchronizedCollectionTestCase::forEach;
            this.payloads.forEachWith = AbstractSynchronizedCollectionTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractSynchronizedCollectionTestCase::forEachWithIndex;
            this.payloads.select = AbstractSynchronizedCollectionTestCase::select;
            this.payloads.selectWith = AbstractSynchronizedCollectionTestCase::selectWith;
            this.payloads.selectWith_target = AbstractSynchronizedCollectionTestCase::selectWith_target;
            this.payloads.reject = AbstractSynchronizedCollectionTestCase::reject;
            this.payloads.rejectWith = AbstractSynchronizedCollectionTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractSynchronizedCollectionTestCase::rejectWith_target;
            this.payloads.selectInstancesOf = AbstractSynchronizedCollectionTestCase::selectInstancesOf;
            this.payloads.collect = AbstractSynchronizedCollectionTestCase::collect;
            this.payloads.collectTarget = AbstractSynchronizedCollectionTestCase::collectTarget;
            this.payloads.collectBoolean = AbstractSynchronizedCollectionTestCase::collectBoolean;
            this.payloads.collectBooleanWithTarget = AbstractSynchronizedCollectionTestCase::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = AbstractSynchronizedCollectionTestCase::collectBooleanWithBagTarget;
            this.payloads.collectByte = AbstractSynchronizedCollectionTestCase::collectByte;
            this.payloads.collectByteWithTarget = AbstractSynchronizedCollectionTestCase::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = AbstractSynchronizedCollectionTestCase::collectByteWithBagTarget;
            this.payloads.collectChar = AbstractSynchronizedCollectionTestCase::collectChar;
            this.payloads.collectCharWithTarget = AbstractSynchronizedCollectionTestCase::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = AbstractSynchronizedCollectionTestCase::collectCharWithBagTarget;
            this.payloads.collectDouble = AbstractSynchronizedCollectionTestCase::collectDouble;
            this.payloads.collectDoubleWithTarget = AbstractSynchronizedCollectionTestCase::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = AbstractSynchronizedCollectionTestCase::collectDoubleWithBagTarget;
            this.payloads.collectFloat = AbstractSynchronizedCollectionTestCase::collectFloat;
            this.payloads.collectFloatWithTarget = AbstractSynchronizedCollectionTestCase::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = AbstractSynchronizedCollectionTestCase::collectFloatWithBagTarget;
            this.payloads.collectInt = AbstractSynchronizedCollectionTestCase::collectInt;
            this.payloads.collectIntWithTarget = AbstractSynchronizedCollectionTestCase::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = AbstractSynchronizedCollectionTestCase::collectIntWithBagTarget;
            this.payloads.collectLong = AbstractSynchronizedCollectionTestCase::collectLong;
            this.payloads.collectLongWithTarget = AbstractSynchronizedCollectionTestCase::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = AbstractSynchronizedCollectionTestCase::collectLongWithBagTarget;
            this.payloads.collectShort = AbstractSynchronizedCollectionTestCase::collectShort;
            this.payloads.collectShortWithTarget = AbstractSynchronizedCollectionTestCase::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = AbstractSynchronizedCollectionTestCase::collectShortWithBagTarget;
            this.payloads.flatCollect = AbstractSynchronizedCollectionTestCase::flatCollect;
            this.payloads.flatCollectWith = AbstractSynchronizedCollectionTestCase::flatCollectWith;
            this.payloads.flatCollectBoolean = AbstractSynchronizedCollectionTestCase::flatCollectBoolean;
            this.payloads.flatCollectByte = AbstractSynchronizedCollectionTestCase::flatCollectByte;
            this.payloads.flatCollectShort = AbstractSynchronizedCollectionTestCase::flatCollectShort;
            this.payloads.flatCollectInt = AbstractSynchronizedCollectionTestCase::flatCollectInt;
            this.payloads.flatCollectChar = AbstractSynchronizedCollectionTestCase::flatCollectChar;
            this.payloads.flatCollectLong = AbstractSynchronizedCollectionTestCase::flatCollectLong;
            this.payloads.flatCollectDouble = AbstractSynchronizedCollectionTestCase::flatCollectDouble;
            this.payloads.flatCollectFloat = AbstractSynchronizedCollectionTestCase::flatCollectFloat;
            this.payloads.detect = AbstractSynchronizedCollectionTestCase::detect;
            this.payloads.detectOptional = AbstractSynchronizedCollectionTestCase::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractSynchronizedCollectionTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractSynchronizedCollectionTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractSynchronizedCollectionTestCase::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractSynchronizedCollectionTestCase::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = AbstractSynchronizedCollectionTestCase::min;
            this.payloads.minOptional = AbstractSynchronizedCollectionTestCase::minOptional;
            this.payloads.max = AbstractSynchronizedCollectionTestCase::max;
            this.payloads.maxOptional = AbstractSynchronizedCollectionTestCase::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractSynchronizedCollectionTestCase::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractSynchronizedCollectionTestCase::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = AbstractSynchronizedCollectionTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractSynchronizedCollectionTestCase::max_without_comparator;
            this.payloads.min_null_safe = AbstractSynchronizedCollectionTestCase::min_null_safe;
            this.payloads.max_null_safe = AbstractSynchronizedCollectionTestCase::max_null_safe;
            this.payloads.minBy = AbstractSynchronizedCollectionTestCase::minBy;
            this.payloads.minByOptional = AbstractSynchronizedCollectionTestCase::minByOptional;
            this.payloads.maxBy = AbstractSynchronizedCollectionTestCase::maxBy;
            this.payloads.maxByOptional = AbstractSynchronizedCollectionTestCase::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractSynchronizedCollectionTestCase::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractSynchronizedCollectionTestCase::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = AbstractSynchronizedCollectionTestCase::detectWith;
            this.payloads.detectWithOptional = AbstractSynchronizedCollectionTestCase::detectWithOptional;
            this.payloads.detectIfNone = AbstractSynchronizedCollectionTestCase::detectIfNone;
            this.payloads.detectWithIfNoneBlock = AbstractSynchronizedCollectionTestCase::detectWithIfNoneBlock;
            this.payloads.allSatisfy = AbstractSynchronizedCollectionTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractSynchronizedCollectionTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractSynchronizedCollectionTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractSynchronizedCollectionTestCase::noneSatisfyWith;
            this.payloads.anySatisfy = AbstractSynchronizedCollectionTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractSynchronizedCollectionTestCase::anySatisfyWith;
            this.payloads.count = AbstractSynchronizedCollectionTestCase::count;
            this.payloads.countWith = AbstractSynchronizedCollectionTestCase::countWith;
            this.payloads.collectIf = AbstractSynchronizedCollectionTestCase::collectIf;
            this.payloads.collectWith = AbstractSynchronizedCollectionTestCase::collectWith;
            this.payloads.collectWith_target = AbstractSynchronizedCollectionTestCase::collectWith_target;
            this.payloads.getAny = AbstractSynchronizedCollectionTestCase::getAny;
            this.payloads.getFirst = AbstractSynchronizedCollectionTestCase::getFirst;
            this.payloads.getLast = AbstractSynchronizedCollectionTestCase::getLast;
            this.payloads.getOnly = AbstractSynchronizedCollectionTestCase::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractSynchronizedCollectionTestCase::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractSynchronizedCollectionTestCase::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = AbstractSynchronizedCollectionTestCase::isEmpty;
            this.payloads.iterator = AbstractSynchronizedCollectionTestCase::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractSynchronizedCollectionTestCase::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = AbstractSynchronizedCollectionTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractSynchronizedCollectionTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractSynchronizedCollectionTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractSynchronizedCollectionTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractSynchronizedCollectionTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractSynchronizedCollectionTestCase::sumFloat;
            this.payloads.summarizeFloat = AbstractSynchronizedCollectionTestCase::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = AbstractSynchronizedCollectionTestCase::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = AbstractSynchronizedCollectionTestCase::sumFloatConsistentRounding2;
            this.payloads.sumDouble = AbstractSynchronizedCollectionTestCase::sumDouble;
            this.payloads.summarizeDouble = AbstractSynchronizedCollectionTestCase::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = AbstractSynchronizedCollectionTestCase::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = AbstractSynchronizedCollectionTestCase::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = AbstractSynchronizedCollectionTestCase::sumInteger;
            this.payloads.summarizeInt = AbstractSynchronizedCollectionTestCase::summarizeInt;
            this.payloads.sumLong = AbstractSynchronizedCollectionTestCase::sumLong;
            this.payloads.summarizeLong = AbstractSynchronizedCollectionTestCase::summarizeLong;
            this.payloads.sumByInt = AbstractSynchronizedCollectionTestCase::sumByInt;
            this.payloads.sumByFloat = AbstractSynchronizedCollectionTestCase::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = AbstractSynchronizedCollectionTestCase::sumByFloatConsistentRounding;
            this.payloads.sumByLong = AbstractSynchronizedCollectionTestCase::sumByLong;
            this.payloads.sumByDouble = AbstractSynchronizedCollectionTestCase::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = AbstractSynchronizedCollectionTestCase::sumByDoubleConsistentRounding;
            this.payloads.toArray = AbstractSynchronizedCollectionTestCase::toArray;
            this.payloads.partition = AbstractSynchronizedCollectionTestCase::partition;
            this.payloads.partitionWith = AbstractSynchronizedCollectionTestCase::partitionWith;
            this.payloads.toList = AbstractSynchronizedCollectionTestCase::toList;
            this.payloads.toImmutableList = AbstractSynchronizedCollectionTestCase::toImmutableList;
            this.payloads.toCollection = AbstractSynchronizedCollectionTestCase::toCollection;
            this.payloads.toBag = AbstractSynchronizedCollectionTestCase::toBag;
            this.payloads.toImmutableBag = AbstractSynchronizedCollectionTestCase::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = AbstractSynchronizedCollectionTestCase::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = AbstractSynchronizedCollectionTestCase::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = AbstractSynchronizedCollectionTestCase::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = AbstractSynchronizedCollectionTestCase::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractSynchronizedCollectionTestCase::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = AbstractSynchronizedCollectionTestCase::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = AbstractSynchronizedCollectionTestCase::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = AbstractSynchronizedCollectionTestCase::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = AbstractSynchronizedCollectionTestCase::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractSynchronizedCollectionTestCase::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = AbstractSynchronizedCollectionTestCase::toSortedBagBy;
            this.payloads.toImmutableSortedBagBy = AbstractSynchronizedCollectionTestCase::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = AbstractSynchronizedCollectionTestCase::toSortedListBy;
            this.payloads.toImmutableSortedListBy = AbstractSynchronizedCollectionTestCase::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = AbstractSynchronizedCollectionTestCase::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = AbstractSynchronizedCollectionTestCase::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = AbstractSynchronizedCollectionTestCase::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = AbstractSynchronizedCollectionTestCase::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractSynchronizedCollectionTestCase::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = AbstractSynchronizedCollectionTestCase::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractSynchronizedCollectionTestCase::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = AbstractSynchronizedCollectionTestCase::toSet;
            this.payloads.toImmutableSet = AbstractSynchronizedCollectionTestCase::toImmutableSet;
            this.payloads.toMap = AbstractSynchronizedCollectionTestCase::toMap;
            this.payloads.toImmutableMap = AbstractSynchronizedCollectionTestCase::toImmutableMap;
            this.payloads.toMapTarget = AbstractSynchronizedCollectionTestCase::toMapTarget;
            this.payloads.toSortedMap = AbstractSynchronizedCollectionTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractSynchronizedCollectionTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractSynchronizedCollectionTestCase::toSortedMapBy;
            this.payloads.toBiMap = AbstractSynchronizedCollectionTestCase::toBiMap;
            this.payloads.toImmutableBiMap = AbstractSynchronizedCollectionTestCase::toImmutableBiMap;
            this.payloads.makeStringWithSeparator = AbstractSynchronizedCollectionTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = AbstractSynchronizedCollectionTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = AbstractSynchronizedCollectionTestCase::fusedCollectMakeString;
            this.payloads.appendStringWithSeparator = AbstractSynchronizedCollectionTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = AbstractSynchronizedCollectionTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = AbstractSynchronizedCollectionTestCase::appendStringThrows;
            this.payloads.countBy = AbstractSynchronizedCollectionTestCase::countBy;
            this.payloads.countByWith = AbstractSynchronizedCollectionTestCase::countByWith;
            this.payloads.countByEach = AbstractSynchronizedCollectionTestCase::countByEach;
            this.payloads.groupBy = AbstractSynchronizedCollectionTestCase::groupBy;
            this.payloads.groupByEach = AbstractSynchronizedCollectionTestCase::groupByEach;
            this.payloads.groupByUniqueKey = AbstractSynchronizedCollectionTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractSynchronizedCollectionTestCase::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = AbstractSynchronizedCollectionTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractSynchronizedCollectionTestCase::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = AbstractSynchronizedCollectionTestCase::zip;
            this.payloads.zipWithIndex = AbstractSynchronizedCollectionTestCase::zipWithIndex;
            this.payloads.chunk = AbstractSynchronizedCollectionTestCase::chunk;
            this.payloads.chunk_empty = AbstractSynchronizedCollectionTestCase::chunk_empty;
            this.payloads.chunk_single = AbstractSynchronizedCollectionTestCase::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractSynchronizedCollectionTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractSynchronizedCollectionTestCase::chunk_large_size;
            this.payloads.empty = AbstractSynchronizedCollectionTestCase::empty;
            this.payloads.notEmpty = AbstractSynchronizedCollectionTestCase::notEmpty;
            this.payloads.aggregateByMutating = AbstractSynchronizedCollectionTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractSynchronizedCollectionTestCase::aggregateByNonMutating;
            this.payloads.reduceOptional = AbstractSynchronizedCollectionTestCase::reduceOptional;
            this.payloads.newEmpty = AbstractSynchronizedCollectionTestCase::newEmpty;
            this.payloads.toImmutable = AbstractSynchronizedCollectionTestCase::toImmutable;
            this.payloads.testNewWith = AbstractSynchronizedCollectionTestCase::testNewWith;
            this.payloads.testNewWithWith = AbstractSynchronizedCollectionTestCase::testNewWithWith;
            this.payloads.testNewWithWithWith = AbstractSynchronizedCollectionTestCase::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = AbstractSynchronizedCollectionTestCase::testNewWithVarArgs;
            this.payloads.addAll = AbstractSynchronizedCollectionTestCase::addAll;
            this.payloads.addAllIterable = AbstractSynchronizedCollectionTestCase::addAllIterable;
            this.payloads.removeAll = AbstractSynchronizedCollectionTestCase::removeAll;
            this.payloads.removeAllIterable = AbstractSynchronizedCollectionTestCase::removeAllIterable;
            this.payloads.retainAll = AbstractSynchronizedCollectionTestCase::retainAll;
            this.payloads.retainAllIterable = AbstractSynchronizedCollectionTestCase::retainAllIterable;
            this.payloads.clear = AbstractSynchronizedCollectionTestCase::clear;
            this.payloads.injectIntoWith = AbstractSynchronizedCollectionTestCase::injectIntoWith;
            this.payloads.removeObject = AbstractSynchronizedCollectionTestCase::removeObject;
            this.payloads.selectAndRejectWith = AbstractSynchronizedCollectionTestCase::selectAndRejectWith;
            this.payloads.removeIf = AbstractSynchronizedCollectionTestCase::removeIf;
            this.payloads.removeIfWith = AbstractSynchronizedCollectionTestCase::removeIfWith;
            this.payloads.with = AbstractSynchronizedCollectionTestCase::with;
            this.payloads.withAll = AbstractSynchronizedCollectionTestCase::withAll;
            this.payloads.without = AbstractSynchronizedCollectionTestCase::without;
            this.payloads.withoutAll = AbstractSynchronizedCollectionTestCase::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = AbstractSynchronizedCollectionTestCase::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = AbstractSynchronizedCollectionTestCase::asLazy;
            this.payloads.asUnmodifiable = AbstractSynchronizedCollectionTestCase::asUnmodifiable;
            this.payloads.testToString = AbstractSynchronizedCollectionTestCase::testToString;
            this.payloads.makeString = AbstractSynchronizedCollectionTestCase::makeString;
            this.payloads.appendString = AbstractSynchronizedCollectionTestCase::appendString;
            this.payloads.asSynchronized = AbstractSynchronizedCollectionTestCase::asSynchronized;
        }
    }
}
