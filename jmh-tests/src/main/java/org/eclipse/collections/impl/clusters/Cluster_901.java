package org.eclipse.collections.impl.clusters;

public class Cluster_901 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bag.sorted.mutable.SynchronizedSortedBagTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bag.sorted.mutable.TreeBagTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.list.mutable.ArrayListAdapterTest._Benchmark _Benchmark_benchmark_5;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bag.sorted.mutable.SynchronizedSortedBagTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.bag.sorted.mutable.TreeBagTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.list.mutable.ArrayListAdapterTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_901() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.collectCharWithTarget);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.collectShortWithTarget);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.collectFloatWithTarget);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.collectByteWithBagTarget);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.collectCharWithBagTarget);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.newEmpty);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.collectDoubleWithBagTarget);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.collectFloatWithBagTarget);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.collectShortWithBagTarget);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.collectByte);
        }

   }

}