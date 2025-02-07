package org.eclipse.collections.impl.clusters;

public class Cluster_1029 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapCustomLockTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.multimap.bag.strategy.HashBagMultimapWithHashingStrategyTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.multimap.bag.sorted.mutable.TreeBagMultimapTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.multimap.list.FastListMultimapTest._Benchmark _Benchmark_benchmark_4;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapCustomLockTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.multimap.bag.strategy.HashBagMultimapWithHashingStrategyTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.multimap.bag.sorted.mutable.TreeBagMultimapTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.multimap.list.FastListMultimapTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_1029() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.keyValuesView);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.keyValuesView);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.testNewMultimap);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.testNewMultimap);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.testNewMultimap);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.removeKey);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.addAndGrowMultimap);
        }

   }

}