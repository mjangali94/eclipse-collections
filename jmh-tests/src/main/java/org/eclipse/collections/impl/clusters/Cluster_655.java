package org.eclipse.collections.impl.clusters;

public class Cluster_655 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.mutable.ArrayListAdapterTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bag.sorted.immutable.ImmutableEmptySortedBagTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.list.immutable.ImmutableArrayListTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.list.immutable.ImmutableSextupletonListTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark _Benchmark_benchmark_14;
       private org.eclipse.collections.impl.list.immutable.ImmutableDoubletonListTest._Benchmark _Benchmark_benchmark_16;
       private org.eclipse.collections.impl.list.immutable.ImmutableSeptupletonListTest._Benchmark _Benchmark_benchmark_18;
       private org.eclipse.collections.impl.list.immutable.ImmutableTripletonListTest._Benchmark _Benchmark_benchmark_19;
       private org.eclipse.collections.impl.list.immutable.ImmutableDecapletonListTest._Benchmark _Benchmark_benchmark_20;
       private org.eclipse.collections.impl.list.immutable.ImmutableOctupletonListTest._Benchmark _Benchmark_benchmark_21;
       private org.eclipse.collections.impl.list.immutable.ImmutableNonupletonListTest._Benchmark _Benchmark_benchmark_22;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.mutable.ArrayListAdapterTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.bag.sorted.immutable.ImmutableEmptySortedBagTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.list.immutable.ImmutableArrayListTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.list.immutable.ImmutableSextupletonListTest._Benchmark();
            _Benchmark_benchmark_14 = new org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark();
            _Benchmark_benchmark_16 = new org.eclipse.collections.impl.list.immutable.ImmutableDoubletonListTest._Benchmark();
            _Benchmark_benchmark_18 = new org.eclipse.collections.impl.list.immutable.ImmutableSeptupletonListTest._Benchmark();
            _Benchmark_benchmark_19 = new org.eclipse.collections.impl.list.immutable.ImmutableTripletonListTest._Benchmark();
            _Benchmark_benchmark_20 = new org.eclipse.collections.impl.list.immutable.ImmutableDecapletonListTest._Benchmark();
            _Benchmark_benchmark_21 = new org.eclipse.collections.impl.list.immutable.ImmutableOctupletonListTest._Benchmark();
            _Benchmark_benchmark_22 = new org.eclipse.collections.impl.list.immutable.ImmutableNonupletonListTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_14.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_16.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_18.makePayloads();
            this._Benchmark_benchmark_19.makePayloads();
            this._Benchmark_benchmark_20.makePayloads();
            this._Benchmark_benchmark_21.makePayloads();
            this._Benchmark_benchmark_22.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_655() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.detectIndex);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.detectLastIndex);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.distinctView);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.toSortedSetBy);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.toSortedSetBy);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.asReversed);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.detect);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.count);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.summarizeDouble);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.summarizeFloat);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.summarizeLong);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.summarizeInt);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.anySatisfy);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.noneSatisfy);
            this._Benchmark_benchmark_14.runBenchmark(this._Benchmark_benchmark_14.payloads.injectIntoDouble);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.allSatisfy);
            this._Benchmark_benchmark_16.runBenchmark(this._Benchmark_benchmark_16.payloads.toSortedSetBy);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.sortThis_with_null);
            this._Benchmark_benchmark_18.runBenchmark(this._Benchmark_benchmark_18.payloads.asReversed);
            this._Benchmark_benchmark_19.runBenchmark(this._Benchmark_benchmark_19.payloads.toSortedSetBy);
            this._Benchmark_benchmark_20.runBenchmark(this._Benchmark_benchmark_20.payloads.selectInstanceOf);
            this._Benchmark_benchmark_21.runBenchmark(this._Benchmark_benchmark_21.payloads.asReversed);
            this._Benchmark_benchmark_22.runBenchmark(this._Benchmark_benchmark_22.payloads.asReversed);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.detectIfNone);
        }

   }

}