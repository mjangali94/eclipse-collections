/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.mutable;

import org.eclipse.collections.impl.collection.mutable.AbstractCollectionTestCase;
import org.junit.Test;

public abstract class MultiReaderMutableCollectionTestCase extends AbstractCollectionTestCase {

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void iterator_throws() {
        this.newWith(1, 2, 3).iterator();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void spliterator_throws() {
        this.newWith(1, 2, 3).spliterator();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void stream_throws() {
        this.newWith(1, 2, 3).stream();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void parallelStream_throws() {
        this.newWith(1, 2, 3).parallelStream();
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MultiReaderMutableCollectionTestCase instance;

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
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
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
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_spliterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.spliterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream_throws);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> payload) throws java.lang.Throwable {
            this.instance = new MultiReaderMutableCollectionTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> spliterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> stream_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderMutableCollectionTestCase> parallelStream_throws;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = MultiReaderMutableCollectionTestCase::testNewCollection;
            this.payloads.equalsAndHashCode = MultiReaderMutableCollectionTestCase::equalsAndHashCode;
            this.payloads.contains = MultiReaderMutableCollectionTestCase::contains;
            this.payloads.containsBy = MultiReaderMutableCollectionTestCase::containsBy;
            this.payloads.containsAllIterable = MultiReaderMutableCollectionTestCase::containsAllIterable;
            this.payloads.containsAnyIterable = MultiReaderMutableCollectionTestCase::containsAnyIterable;
            this.payloads.containsNoneIterable = MultiReaderMutableCollectionTestCase::containsNoneIterable;
            this.payloads.containsAllArray = MultiReaderMutableCollectionTestCase::containsAllArray;
            this.payloads.containsAnyCollection = MultiReaderMutableCollectionTestCase::containsAnyCollection;
            this.payloads.containsNoneCollection = MultiReaderMutableCollectionTestCase::containsNoneCollection;
            this.payloads.containsAllCollection = MultiReaderMutableCollectionTestCase::containsAllCollection;
            this.payloads.tap = MultiReaderMutableCollectionTestCase::tap;
            this.payloads.forEach = MultiReaderMutableCollectionTestCase::forEach;
            this.payloads.forEachWith = MultiReaderMutableCollectionTestCase::forEachWith;
            this.payloads.forEachWithIndex = MultiReaderMutableCollectionTestCase::forEachWithIndex;
            this.payloads.select = MultiReaderMutableCollectionTestCase::select;
            this.payloads.selectWith = MultiReaderMutableCollectionTestCase::selectWith;
            this.payloads.selectWith_target = MultiReaderMutableCollectionTestCase::selectWith_target;
            this.payloads.reject = MultiReaderMutableCollectionTestCase::reject;
            this.payloads.rejectWith = MultiReaderMutableCollectionTestCase::rejectWith;
            this.payloads.rejectWith_target = MultiReaderMutableCollectionTestCase::rejectWith_target;
            this.payloads.selectInstancesOf = MultiReaderMutableCollectionTestCase::selectInstancesOf;
            this.payloads.collect = MultiReaderMutableCollectionTestCase::collect;
            this.payloads.collectTarget = MultiReaderMutableCollectionTestCase::collectTarget;
            this.payloads.collectBoolean = MultiReaderMutableCollectionTestCase::collectBoolean;
            this.payloads.collectBooleanWithTarget = MultiReaderMutableCollectionTestCase::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = MultiReaderMutableCollectionTestCase::collectBooleanWithBagTarget;
            this.payloads.collectByte = MultiReaderMutableCollectionTestCase::collectByte;
            this.payloads.collectByteWithTarget = MultiReaderMutableCollectionTestCase::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = MultiReaderMutableCollectionTestCase::collectByteWithBagTarget;
            this.payloads.collectChar = MultiReaderMutableCollectionTestCase::collectChar;
            this.payloads.collectCharWithTarget = MultiReaderMutableCollectionTestCase::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = MultiReaderMutableCollectionTestCase::collectCharWithBagTarget;
            this.payloads.collectDouble = MultiReaderMutableCollectionTestCase::collectDouble;
            this.payloads.collectDoubleWithTarget = MultiReaderMutableCollectionTestCase::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = MultiReaderMutableCollectionTestCase::collectDoubleWithBagTarget;
            this.payloads.collectFloat = MultiReaderMutableCollectionTestCase::collectFloat;
            this.payloads.collectFloatWithTarget = MultiReaderMutableCollectionTestCase::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = MultiReaderMutableCollectionTestCase::collectFloatWithBagTarget;
            this.payloads.collectInt = MultiReaderMutableCollectionTestCase::collectInt;
            this.payloads.collectIntWithTarget = MultiReaderMutableCollectionTestCase::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = MultiReaderMutableCollectionTestCase::collectIntWithBagTarget;
            this.payloads.collectLong = MultiReaderMutableCollectionTestCase::collectLong;
            this.payloads.collectLongWithTarget = MultiReaderMutableCollectionTestCase::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = MultiReaderMutableCollectionTestCase::collectLongWithBagTarget;
            this.payloads.collectShort = MultiReaderMutableCollectionTestCase::collectShort;
            this.payloads.collectShortWithTarget = MultiReaderMutableCollectionTestCase::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = MultiReaderMutableCollectionTestCase::collectShortWithBagTarget;
            this.payloads.flatCollect = MultiReaderMutableCollectionTestCase::flatCollect;
            this.payloads.flatCollectWith = MultiReaderMutableCollectionTestCase::flatCollectWith;
            this.payloads.flatCollectBoolean = MultiReaderMutableCollectionTestCase::flatCollectBoolean;
            this.payloads.flatCollectByte = MultiReaderMutableCollectionTestCase::flatCollectByte;
            this.payloads.flatCollectShort = MultiReaderMutableCollectionTestCase::flatCollectShort;
            this.payloads.flatCollectInt = MultiReaderMutableCollectionTestCase::flatCollectInt;
            this.payloads.flatCollectChar = MultiReaderMutableCollectionTestCase::flatCollectChar;
            this.payloads.flatCollectLong = MultiReaderMutableCollectionTestCase::flatCollectLong;
            this.payloads.flatCollectDouble = MultiReaderMutableCollectionTestCase::flatCollectDouble;
            this.payloads.flatCollectFloat = MultiReaderMutableCollectionTestCase::flatCollectFloat;
            this.payloads.detect = MultiReaderMutableCollectionTestCase::detect;
            this.payloads.detectOptional = MultiReaderMutableCollectionTestCase::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderMutableCollectionTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderMutableCollectionTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderMutableCollectionTestCase::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderMutableCollectionTestCase::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = MultiReaderMutableCollectionTestCase::min;
            this.payloads.minOptional = MultiReaderMutableCollectionTestCase::minOptional;
            this.payloads.max = MultiReaderMutableCollectionTestCase::max;
            this.payloads.maxOptional = MultiReaderMutableCollectionTestCase::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderMutableCollectionTestCase::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderMutableCollectionTestCase::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = MultiReaderMutableCollectionTestCase::min_without_comparator;
            this.payloads.max_without_comparator = MultiReaderMutableCollectionTestCase::max_without_comparator;
            this.payloads.min_null_safe = MultiReaderMutableCollectionTestCase::min_null_safe;
            this.payloads.max_null_safe = MultiReaderMutableCollectionTestCase::max_null_safe;
            this.payloads.minBy = MultiReaderMutableCollectionTestCase::minBy;
            this.payloads.minByOptional = MultiReaderMutableCollectionTestCase::minByOptional;
            this.payloads.maxBy = MultiReaderMutableCollectionTestCase::maxBy;
            this.payloads.maxByOptional = MultiReaderMutableCollectionTestCase::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderMutableCollectionTestCase::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderMutableCollectionTestCase::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = MultiReaderMutableCollectionTestCase::detectWith;
            this.payloads.detectWithOptional = MultiReaderMutableCollectionTestCase::detectWithOptional;
            this.payloads.detectIfNone = MultiReaderMutableCollectionTestCase::detectIfNone;
            this.payloads.detectWithIfNoneBlock = MultiReaderMutableCollectionTestCase::detectWithIfNoneBlock;
            this.payloads.allSatisfy = MultiReaderMutableCollectionTestCase::allSatisfy;
            this.payloads.allSatisfyWith = MultiReaderMutableCollectionTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = MultiReaderMutableCollectionTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = MultiReaderMutableCollectionTestCase::noneSatisfyWith;
            this.payloads.anySatisfy = MultiReaderMutableCollectionTestCase::anySatisfy;
            this.payloads.anySatisfyWith = MultiReaderMutableCollectionTestCase::anySatisfyWith;
            this.payloads.count = MultiReaderMutableCollectionTestCase::count;
            this.payloads.countWith = MultiReaderMutableCollectionTestCase::countWith;
            this.payloads.collectIf = MultiReaderMutableCollectionTestCase::collectIf;
            this.payloads.collectWith = MultiReaderMutableCollectionTestCase::collectWith;
            this.payloads.collectWith_target = MultiReaderMutableCollectionTestCase::collectWith_target;
            this.payloads.getAny = MultiReaderMutableCollectionTestCase::getAny;
            this.payloads.getFirst = MultiReaderMutableCollectionTestCase::getFirst;
            this.payloads.getLast = MultiReaderMutableCollectionTestCase::getLast;
            this.payloads.getOnly = MultiReaderMutableCollectionTestCase::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderMutableCollectionTestCase::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderMutableCollectionTestCase::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = MultiReaderMutableCollectionTestCase::isEmpty;
            this.payloads.iterator = MultiReaderMutableCollectionTestCase::iterator;
            this.payloads.injectInto = MultiReaderMutableCollectionTestCase::injectInto;
            this.payloads.injectIntoInt = MultiReaderMutableCollectionTestCase::injectIntoInt;
            this.payloads.injectIntoLong = MultiReaderMutableCollectionTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = MultiReaderMutableCollectionTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = MultiReaderMutableCollectionTestCase::injectIntoFloat;
            this.payloads.sumFloat = MultiReaderMutableCollectionTestCase::sumFloat;
            this.payloads.summarizeFloat = MultiReaderMutableCollectionTestCase::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = MultiReaderMutableCollectionTestCase::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = MultiReaderMutableCollectionTestCase::sumFloatConsistentRounding2;
            this.payloads.sumDouble = MultiReaderMutableCollectionTestCase::sumDouble;
            this.payloads.summarizeDouble = MultiReaderMutableCollectionTestCase::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = MultiReaderMutableCollectionTestCase::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = MultiReaderMutableCollectionTestCase::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = MultiReaderMutableCollectionTestCase::sumInteger;
            this.payloads.summarizeInt = MultiReaderMutableCollectionTestCase::summarizeInt;
            this.payloads.sumLong = MultiReaderMutableCollectionTestCase::sumLong;
            this.payloads.summarizeLong = MultiReaderMutableCollectionTestCase::summarizeLong;
            this.payloads.sumByInt = MultiReaderMutableCollectionTestCase::sumByInt;
            this.payloads.sumByFloat = MultiReaderMutableCollectionTestCase::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = MultiReaderMutableCollectionTestCase::sumByFloatConsistentRounding;
            this.payloads.sumByLong = MultiReaderMutableCollectionTestCase::sumByLong;
            this.payloads.sumByDouble = MultiReaderMutableCollectionTestCase::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = MultiReaderMutableCollectionTestCase::sumByDoubleConsistentRounding;
            this.payloads.toArray = MultiReaderMutableCollectionTestCase::toArray;
            this.payloads.partition = MultiReaderMutableCollectionTestCase::partition;
            this.payloads.partitionWith = MultiReaderMutableCollectionTestCase::partitionWith;
            this.payloads.toList = MultiReaderMutableCollectionTestCase::toList;
            this.payloads.toImmutableList = MultiReaderMutableCollectionTestCase::toImmutableList;
            this.payloads.toCollection = MultiReaderMutableCollectionTestCase::toCollection;
            this.payloads.toBag = MultiReaderMutableCollectionTestCase::toBag;
            this.payloads.toImmutableBag = MultiReaderMutableCollectionTestCase::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = MultiReaderMutableCollectionTestCase::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = MultiReaderMutableCollectionTestCase::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = MultiReaderMutableCollectionTestCase::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = MultiReaderMutableCollectionTestCase::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderMutableCollectionTestCase::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = MultiReaderMutableCollectionTestCase::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = MultiReaderMutableCollectionTestCase::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = MultiReaderMutableCollectionTestCase::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = MultiReaderMutableCollectionTestCase::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderMutableCollectionTestCase::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = MultiReaderMutableCollectionTestCase::toSortedBagBy;
            this.payloads.toImmutableSortedBagBy = MultiReaderMutableCollectionTestCase::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = MultiReaderMutableCollectionTestCase::toSortedListBy;
            this.payloads.toImmutableSortedListBy = MultiReaderMutableCollectionTestCase::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = MultiReaderMutableCollectionTestCase::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = MultiReaderMutableCollectionTestCase::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = MultiReaderMutableCollectionTestCase::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = MultiReaderMutableCollectionTestCase::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = MultiReaderMutableCollectionTestCase::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = MultiReaderMutableCollectionTestCase::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderMutableCollectionTestCase::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = MultiReaderMutableCollectionTestCase::toSet;
            this.payloads.toImmutableSet = MultiReaderMutableCollectionTestCase::toImmutableSet;
            this.payloads.toMap = MultiReaderMutableCollectionTestCase::toMap;
            this.payloads.toImmutableMap = MultiReaderMutableCollectionTestCase::toImmutableMap;
            this.payloads.toMapTarget = MultiReaderMutableCollectionTestCase::toMapTarget;
            this.payloads.toSortedMap = MultiReaderMutableCollectionTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = MultiReaderMutableCollectionTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = MultiReaderMutableCollectionTestCase::toSortedMapBy;
            this.payloads.toBiMap = MultiReaderMutableCollectionTestCase::toBiMap;
            this.payloads.toImmutableBiMap = MultiReaderMutableCollectionTestCase::toImmutableBiMap;
            this.payloads.testToString = MultiReaderMutableCollectionTestCase::testToString;
            this.payloads.makeString = MultiReaderMutableCollectionTestCase::makeString;
            this.payloads.makeStringWithSeparator = MultiReaderMutableCollectionTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = MultiReaderMutableCollectionTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = MultiReaderMutableCollectionTestCase::fusedCollectMakeString;
            this.payloads.appendString = MultiReaderMutableCollectionTestCase::appendString;
            this.payloads.appendStringWithSeparator = MultiReaderMutableCollectionTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = MultiReaderMutableCollectionTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = MultiReaderMutableCollectionTestCase::appendStringThrows;
            this.payloads.countBy = MultiReaderMutableCollectionTestCase::countBy;
            this.payloads.countByWith = MultiReaderMutableCollectionTestCase::countByWith;
            this.payloads.countByEach = MultiReaderMutableCollectionTestCase::countByEach;
            this.payloads.groupBy = MultiReaderMutableCollectionTestCase::groupBy;
            this.payloads.groupByEach = MultiReaderMutableCollectionTestCase::groupByEach;
            this.payloads.groupByUniqueKey = MultiReaderMutableCollectionTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderMutableCollectionTestCase::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = MultiReaderMutableCollectionTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderMutableCollectionTestCase::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = MultiReaderMutableCollectionTestCase::zip;
            this.payloads.zipWithIndex = MultiReaderMutableCollectionTestCase::zipWithIndex;
            this.payloads.chunk = MultiReaderMutableCollectionTestCase::chunk;
            this.payloads.chunk_empty = MultiReaderMutableCollectionTestCase::chunk_empty;
            this.payloads.chunk_single = MultiReaderMutableCollectionTestCase::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderMutableCollectionTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = MultiReaderMutableCollectionTestCase::chunk_large_size;
            this.payloads.empty = MultiReaderMutableCollectionTestCase::empty;
            this.payloads.notEmpty = MultiReaderMutableCollectionTestCase::notEmpty;
            this.payloads.aggregateByMutating = MultiReaderMutableCollectionTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = MultiReaderMutableCollectionTestCase::aggregateByNonMutating;
            this.payloads.reduceOptional = MultiReaderMutableCollectionTestCase::reduceOptional;
            this.payloads.newEmpty = MultiReaderMutableCollectionTestCase::newEmpty;
            this.payloads.toImmutable = MultiReaderMutableCollectionTestCase::toImmutable;
            this.payloads.testNewWith = MultiReaderMutableCollectionTestCase::testNewWith;
            this.payloads.testNewWithWith = MultiReaderMutableCollectionTestCase::testNewWithWith;
            this.payloads.testNewWithWithWith = MultiReaderMutableCollectionTestCase::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = MultiReaderMutableCollectionTestCase::testNewWithVarArgs;
            this.payloads.addAll = MultiReaderMutableCollectionTestCase::addAll;
            this.payloads.addAllIterable = MultiReaderMutableCollectionTestCase::addAllIterable;
            this.payloads.removeAll = MultiReaderMutableCollectionTestCase::removeAll;
            this.payloads.removeAllIterable = MultiReaderMutableCollectionTestCase::removeAllIterable;
            this.payloads.retainAll = MultiReaderMutableCollectionTestCase::retainAll;
            this.payloads.retainAllIterable = MultiReaderMutableCollectionTestCase::retainAllIterable;
            this.payloads.clear = MultiReaderMutableCollectionTestCase::clear;
            this.payloads.injectIntoWith = MultiReaderMutableCollectionTestCase::injectIntoWith;
            this.payloads.removeObject = MultiReaderMutableCollectionTestCase::removeObject;
            this.payloads.selectAndRejectWith = MultiReaderMutableCollectionTestCase::selectAndRejectWith;
            this.payloads.removeIf = MultiReaderMutableCollectionTestCase::removeIf;
            this.payloads.removeIfWith = MultiReaderMutableCollectionTestCase::removeIfWith;
            this.payloads.with = MultiReaderMutableCollectionTestCase::with;
            this.payloads.withAll = MultiReaderMutableCollectionTestCase::withAll;
            this.payloads.without = MultiReaderMutableCollectionTestCase::without;
            this.payloads.withoutAll = MultiReaderMutableCollectionTestCase::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = MultiReaderMutableCollectionTestCase::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = MultiReaderMutableCollectionTestCase::asLazy;
            this.payloads.asSynchronized = MultiReaderMutableCollectionTestCase::asSynchronized;
            this.payloads.asUnmodifiable = MultiReaderMutableCollectionTestCase::asUnmodifiable;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderMutableCollectionTestCase::iterator_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.spliterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderMutableCollectionTestCase::spliterator_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.stream_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderMutableCollectionTestCase::stream_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.parallelStream_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderMutableCollectionTestCase::parallelStream_throws, java.lang.UnsupportedOperationException.class);
        }
    }
*/
}
