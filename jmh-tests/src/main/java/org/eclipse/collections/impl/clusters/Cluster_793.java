package org.eclipse.collections.impl.clusters;

public class Cluster_793 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsReadUntouchableTest._Benchmark _Benchmark_benchmark_2;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsReadUntouchableTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_793() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.dropWhile);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.takeWhile);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.sortThis);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.sortThisByLong);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.removeAtIndex);
        }

   }

}