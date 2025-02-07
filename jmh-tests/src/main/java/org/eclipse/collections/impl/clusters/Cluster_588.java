package org.eclipse.collections.impl.clusters;

public class Cluster_588 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.fixed.ArrayAdapterAsUnmodifiableTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark _Benchmark_benchmark_1;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.fixed.ArrayAdapterAsUnmodifiableTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_588() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.remove);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.max);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.min_without_comparator);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.without);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.addAll);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.sortThisByInt);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.addAllIterable);
        }

   }

}