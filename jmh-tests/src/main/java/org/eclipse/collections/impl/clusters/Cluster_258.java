package org.eclipse.collections.impl.clusters;

public class Cluster_258 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bag.mutable.HashBagTest._Benchmark _Benchmark_benchmark_0;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bag.mutable.HashBagTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_258() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.iterator_throws);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.addOccurrences_throws);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.removeOccurrences_throws);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.iteratorRemove2);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.max_null_throws_without_comparator);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.min_null_throws_without_comparator);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.maxBy_null_throws);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.minBy_null_throws);
        }

   }

}