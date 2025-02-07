package org.eclipse.collections.impl.clusters;

public class Cluster_543 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.immutable.ImmutableDecapletonListTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.bag.strategy.mutable.HashBagWithHashingStrategyTest._Benchmark _Benchmark_benchmark_9;
       private org.eclipse.collections.impl.list.immutable.ImmutableArrayListTest._Benchmark _Benchmark_benchmark_12;
       private org.eclipse.collections.impl.list.immutable.ImmutableEmptyListTest._Benchmark _Benchmark_benchmark_15;
       private org.eclipse.collections.impl.bag.immutable.ImmutableEmptyBagTest._Benchmark _Benchmark_benchmark_18;
       private org.eclipse.collections.impl.list.immutable.ImmutableSingletonListTest._Benchmark _Benchmark_benchmark_19;
       private org.eclipse.collections.impl.list.immutable.ImmutableQuintupletonListTest._Benchmark _Benchmark_benchmark_20;
       private org.eclipse.collections.impl.list.immutable.ImmutableDoubletonListTest._Benchmark _Benchmark_benchmark_21;
       private org.eclipse.collections.impl.list.immutable.ImmutableTripletonListTest._Benchmark _Benchmark_benchmark_22;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.immutable.ImmutableDecapletonListTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark();
            _Benchmark_benchmark_9 = new org.eclipse.collections.impl.bag.strategy.mutable.HashBagWithHashingStrategyTest._Benchmark();
            _Benchmark_benchmark_12 = new org.eclipse.collections.impl.list.immutable.ImmutableArrayListTest._Benchmark();
            _Benchmark_benchmark_15 = new org.eclipse.collections.impl.list.immutable.ImmutableEmptyListTest._Benchmark();
            _Benchmark_benchmark_18 = new org.eclipse.collections.impl.bag.immutable.ImmutableEmptyBagTest._Benchmark();
            _Benchmark_benchmark_19 = new org.eclipse.collections.impl.list.immutable.ImmutableSingletonListTest._Benchmark();
            _Benchmark_benchmark_20 = new org.eclipse.collections.impl.list.immutable.ImmutableQuintupletonListTest._Benchmark();
            _Benchmark_benchmark_21 = new org.eclipse.collections.impl.list.immutable.ImmutableDoubletonListTest._Benchmark();
            _Benchmark_benchmark_22 = new org.eclipse.collections.impl.list.immutable.ImmutableTripletonListTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_12.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_15.makePayloads();
            this._Benchmark_benchmark_12.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_18.makePayloads();
            this._Benchmark_benchmark_19.makePayloads();
            this._Benchmark_benchmark_20.makePayloads();
            this._Benchmark_benchmark_21.makePayloads();
            this._Benchmark_benchmark_22.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_543() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.toSortedListBy);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.toSortedListBy);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.testToString);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.sortThisByInt);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.makeStringWithSeparator);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.makeStringWithSeparatorAndStartAndEnd);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.makeString);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.appendStringWithSeparatorAndStartAndEnd);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.reverseForEach);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.fusedCollectMakeString);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.appendString);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.appendStringWithSeparator);
            this._Benchmark_benchmark_12.runBenchmark(this._Benchmark_benchmark_12.payloads.toStack);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.forEachFromToInReverse);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.binarySearchWithComparator);
            this._Benchmark_benchmark_15.runBenchmark(this._Benchmark_benchmark_15.payloads.toSortedSetBy);
            this._Benchmark_benchmark_12.runBenchmark(this._Benchmark_benchmark_12.payloads.toSortedList);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.toSortedList_natural_ordering);
            this._Benchmark_benchmark_18.runBenchmark(this._Benchmark_benchmark_18.payloads.toSortedMap_with_comparator);
            this._Benchmark_benchmark_19.runBenchmark(this._Benchmark_benchmark_19.payloads.toStack);
            this._Benchmark_benchmark_20.runBenchmark(this._Benchmark_benchmark_20.payloads.asReversed);
            this._Benchmark_benchmark_21.runBenchmark(this._Benchmark_benchmark_21.payloads.toStack);
            this._Benchmark_benchmark_22.runBenchmark(this._Benchmark_benchmark_22.payloads.toStack);
        }

   }

}