package org.eclipse.collections.impl.clusters;

public class Cluster_1087 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bag.sorted.mutable.UnmodifiableSortedBagTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bag.sorted.mutable.SynchronizedSortedBagTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.bag.strategy.mutable.HashBagWithHashingStrategyTest._Benchmark _Benchmark_benchmark_3;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bag.sorted.mutable.UnmodifiableSortedBagTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.bag.sorted.mutable.SynchronizedSortedBagTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.bag.strategy.mutable.HashBagWithHashingStrategyTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_1087() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.min_null_throws);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.min_null_throws);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.newEmpty);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.testNewCollection);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.empty);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.testNewWithWithWith);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.testNewWithVarArgs);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.newEmpty);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.clear);
        }

   }

}