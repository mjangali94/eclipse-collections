package org.eclipse.collections.impl.clusters;

public class Cluster_99 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.mutable.ListAdapterTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark _Benchmark_benchmark_3;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.mutable.ListAdapterTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_99() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.collectIf);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.subListFromOutOfBoundsException);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.toArray);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.sortThisBy);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.sortThis_with_comparator_small);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.sortThis_with_comparator);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.indexOf);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.toArray);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.drop_throws);
        }

   }

}