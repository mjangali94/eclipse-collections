package org.eclipse.collections.impl.clusters;

public class Cluster_126 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bag.strategy.mutable.HashBagWithHashingStrategyTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bimap.mutable.UnmodifiableBiMapTest._Benchmark _Benchmark_benchmark_1;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bag.strategy.mutable.HashBagWithHashingStrategyTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.bimap.mutable.UnmodifiableBiMapTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_126() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.aggregateByNonMutating);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.withMapIterableEmpty);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.withMapEmpty);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.tap);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.putAllMapIterable);
        }

   }

}