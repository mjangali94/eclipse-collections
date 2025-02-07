package org.eclipse.collections.impl.clusters;

public class Cluster_834 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.multimap.bag.sorted.mutable.SynchronizedSortedBagMultimapTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.multimap.list.FastListMultimapTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.multimap.bag.sorted.mutable.TreeBagMultimapTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.UnmodifiableMapEntrySetTest._Benchmark _Benchmark_benchmark_5;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.multimap.bag.sorted.mutable.SynchronizedSortedBagMultimapTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.multimap.list.FastListMultimapTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.multimap.bag.sorted.mutable.TreeBagMultimapTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.UnmodifiableMapEntrySetTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_834() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.removeObject);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.rejectKeysValues);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.selectKeysValues);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.groupBy);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.put_createCollection);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.forEach);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.testNewMultimapWith);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.toImmutable);
        }

   }

}