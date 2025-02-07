package org.eclipse.collections.impl.clusters;

public class Cluster_45 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.immutable.ImmutableArrayListTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.multimap.list.FastListMultimapTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.multimap.bag.sorted.mutable.TreeBagMultimapTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.list.immutable.ImmutableSubListTest._Benchmark _Benchmark_benchmark_4;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.immutable.ImmutableArrayListTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.multimap.list.FastListMultimapTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.multimap.bag.sorted.mutable.TreeBagMultimapTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.list.immutable.ImmutableSubListTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_45() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.subList);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.takeWhile);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.newEmpty);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.newEmpty);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.listIterator_throwsGreaterThanSize);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.retainAll);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.removeAll);
        }

   }

}