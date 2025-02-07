package org.eclipse.collections.impl.clusters;

public class Cluster_840 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.immutable.ImmutableArrayListTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.immutable.ImmutableTripletonListTest._Benchmark _Benchmark_benchmark_1;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.immutable.ImmutableArrayListTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.list.immutable.ImmutableTripletonListTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_840() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.sort);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.chunk_zero_throws);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.set);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.replaceAll);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.getOnly);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.getFirst);
        }

   }

}