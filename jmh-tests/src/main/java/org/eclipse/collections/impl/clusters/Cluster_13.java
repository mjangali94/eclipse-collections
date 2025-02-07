package org.eclipse.collections.impl.clusters;

public class Cluster_13 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bag.sorted.mutable.UnmodifiableSortedBagTest._Benchmark _Benchmark_benchmark_0;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bag.sorted.mutable.UnmodifiableSortedBagTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_13() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.asUnmodifiable);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.setOccurrences_throws);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.getOnly_empty_throws);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.addOccurrences_throws);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.removeOccurrences_throws);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.testAsUnmodifiable);
        }

   }

}