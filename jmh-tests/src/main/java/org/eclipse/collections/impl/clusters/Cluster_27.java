package org.eclipse.collections.impl.clusters;

public class Cluster_27 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.mutable.ListAdapterTest._Benchmark _Benchmark_benchmark_1;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.list.mutable.ListAdapterTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_27() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.chunk_zero_throws);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.getWithIndexOutOfBoundsException);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.iterator);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.getWithArrayIndexOutOfBoundsException);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.listIteratorIndexTooBig);
        }

   }

}