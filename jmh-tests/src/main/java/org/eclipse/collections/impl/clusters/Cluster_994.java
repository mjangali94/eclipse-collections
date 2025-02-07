package org.eclipse.collections.impl.clusters;

public class Cluster_994 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.multimap.list.ImmutableListMultimapTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.multimap.list.FastListMultimapTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.multimap.bag.sorted.mutable.TreeBagMultimapTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.bimap.mutable.HashBiMapTest._Benchmark _Benchmark_benchmark_3;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.multimap.list.ImmutableListMultimapTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.multimap.list.FastListMultimapTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.multimap.bag.sorted.mutable.TreeBagMultimapTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_994() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.allowDuplicates);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.keyValuePairsView);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.multiValuesView);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.toSortedBagBy);
        }

   }

}