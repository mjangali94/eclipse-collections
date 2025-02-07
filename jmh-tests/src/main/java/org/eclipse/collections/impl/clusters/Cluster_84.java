package org.eclipse.collections.impl.clusters;

public class Cluster_84 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bag.sorted.mutable.SynchronizedSortedBagTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bag.sorted.mutable.UnmodifiableSortedBagTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.bag.sorted.mutable.TreeBagTest._Benchmark _Benchmark_benchmark_3;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bag.sorted.mutable.SynchronizedSortedBagTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.bag.sorted.mutable.UnmodifiableSortedBagTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.bag.sorted.mutable.TreeBagTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_84() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.chunk_zero_throws);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.contains);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.count);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.summarizeInt);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.summarizeLong);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.summarizeFloat);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.summarizeDouble);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.count);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.appendString_with_collection_containing_self);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.toString_with_collection_containing_self);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.makeString_with_collection_containing_self);
        }

   }

}