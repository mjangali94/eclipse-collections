package org.eclipse.collections.impl.clusters;

public class Cluster_637 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bag.immutable.ImmutableArrayBagTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagAsWriteUntouchableTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.bag.mutable.HashBagTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.bag.immutable.ImmutableEmptyBagTest._Benchmark _Benchmark_benchmark_5;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bag.immutable.ImmutableArrayBagTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagAsWriteUntouchableTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.bag.mutable.HashBagTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.bag.immutable.ImmutableEmptyBagTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_637() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.toMapTarget);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.isEmpty);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.getOnly_not_only_one_throws);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.toArray);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.toSortedListWith);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.fusedCollectMakeString);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.makeString);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.appendStringWithSeparatorAndStartAndEnd);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.makeStringWithSeparatorAndStartAndEnd);
        }

   }

}